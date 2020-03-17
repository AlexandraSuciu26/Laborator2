import javafx.util.Pair;

import java.io.*;
import java.util.*;

public class Travel{
    List<Node> nodes=new ArrayList<>();
    Node destination;
    Map<Pair<Node,Node>,Float> listaLinks=new HashMap<Pair<Node, Node>, Float>();
        public void citire(){
            String s;
            Integer index=0;
            File file=new File("C:\\@Alexandra\\anul2\\semestrul2\\ai\\lab\\Laborator2\\src\\easy_01_tsp.txt");
            try (BufferedReader br = new BufferedReader(new FileReader(file)))
            {
                s=br.readLine();
                Integer number =Integer.valueOf(s);
                for(Integer r=1;r<=number;r++) {
                    Node node=new Node();
                    node.setIndex(r);
                    nodes.add(node);
                }
                while((s=br.readLine())!=null){
                    String[] c=s.split(",");
                    Integer j=0;
                    index++;
                    for (String o:c){
                        j++;
                        Node u=nodes.get(index-1);
                        if(index!=j){
                            u.neighbours.add(nodes.get(j-1));
                            listaLinks.putIfAbsent(new Pair<>(u,nodes.get(j-1)),Float.valueOf(o));
                        }


                    }

                }

            destination=nodes.get(0);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
       /* public Path bfs(){
            Queue<Path>q=new LinkedList<Path>() ;
            Path best=new Path();
            float min=Float.MAX_VALUE;
            Pair<Float,Path>list;
            Path path=new Path();
            path.nodeList.add(nodes.get(0));
            q.add(path);
            while(!q.isEmpty()){
                path=q.remove();
                Node last=path.nodeList.get(path.nodeList.size()-1);
                if(last.index==destination.index && path.nodeList.size()!=1){
                    if(path.cost<min){
                        min=path.cost;
                        best=path;
                    }

                }
                for ( Node n:last.neighbours){
                    if (!path.nodeList.contains(n)||(path.nodeList.size()==nodes.size()&& n==destination)){
                        ArrayList<Node>h=(ArrayList)path.nodeList.clone();
                        h.add(n);
                        Float i=listaLinks.get(new Pair<>(last,n));
                        Path nou=new Path(h,path.cost+i);
                        q.add(nou);

                    }
                }
            }
            return best;
        }
*/
    public Path dfs(){
        Stack<Path>q=new Stack<>() ;
        Path best=new Path();
        float min=Float.MAX_VALUE;
        Pair<Float,Path>list;
        Path path=new Path();
        path.nodeList.add(nodes.get(0));
        q.add(path);
        while(!q.isEmpty()){
            path=q.pop();
            Node last=path.nodeList.get(path.nodeList.size()-1);
            if(last.index==destination.index && path.nodeList.size()!=1){
                if(path.cost<min){
                    min=path.cost;
                    best=path;
                }

            }
            //System.out.println(best);
            for ( Node n:last.neighbours){
                if (!path.nodeList.contains(n)||(path.nodeList.size()==nodes.size()&& n==destination)){
                    ArrayList<Node>h=(ArrayList)path.nodeList.clone();
                    h.add(n);
                    Float i=listaLinks.get(new Pair<>(last,n));
                    Path nou=new Path(h,path.cost+i);
                    q.add(nou);

                }
            }
        }
        return best;
    }
}
