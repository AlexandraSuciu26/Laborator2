import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Greedy {
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
                node.index=r;
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

    public Path greedy(){
        Path best=new Path();
        float min=Float.MAX_VALUE;
        Node minNode;
        Pair<Float,Path>list;
        Path path=new Path();
        path.nodeList.add(nodes.get(0));
        Integer index=0;//parcurg nodurile
        Node current;
        while(path.nodeList.size()!=nodes.size())
        {   current=path.nodeList.get(index);//current va lua pe rand valoare fiecarui nod
            min=Float.MAX_VALUE;
             minNode=current.neighbours.get(0);//minNode retine primul vecin
            for ( Node n:current.neighbours) {//cu n parcurgem vecinii fiecarui nod
                if(min>listaLinks.get(new Pair<>(current,n))&& (! path.nodeList.contains(n))){//cautam cea mai buna muchide,cu costul cel mai mic si verificam sa nu mai fi trecut prin acel nod
                    min=listaLinks.get(new Pair<>(current,n));//actualizam valoarea minima
                    minNode=n;//selectam acel nod care e mai bun decat restul
                }
            }
            path.nodeList.add(minNode);
            path.cost=path.cost+min;
            index++;
        }
        if(listaLinks.containsKey(new Pair<>(path.nodeList.get(nodes.size()-1),path.nodeList.get(0)))){//daca am legatura intre ultimul nod si primul
            path.cost=path.cost+listaLinks.get(new Pair<>(path.nodeList.get(nodes.size()-1),path.nodeList.get(0)));//adun costul acela la costul total
            path.nodeList.add(path.nodeList.get(0));//il adaug din nou in lista pe primul pt tiparire
        }
        return path;
    }


}
