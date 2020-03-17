import java.util.ArrayList;
import java.util.List;

public class Node {
    int index;
    List<Node>neighbours=new ArrayList<>();

    @Override
    public String toString() {
        return String.valueOf(index);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public List<Node> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Node> neighbours) {
        this.neighbours = neighbours;
    }
}
