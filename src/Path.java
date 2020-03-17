import java.util.ArrayList;

public class Path {
    ArrayList<Node>nodeList=new ArrayList<>();
    float cost=0;

    public Path(ArrayList<Node> nodeList, Float cost) {
        this.nodeList = nodeList;
        this.cost = cost;
    }

    public Path() {
    }

    public ArrayList<Node> getNodeList() {
        return nodeList;
    }

    public void setNodeList(ArrayList<Node> nodeList) {
        this.nodeList = nodeList;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Path{" +
                "nodeList=" + nodeList +
                ", cost=" + cost +
                '}';
    }
}
