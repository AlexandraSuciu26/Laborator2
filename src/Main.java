import javafx.util.Pair;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Greedy greedy=new Greedy();
        greedy.citire();
        Path path=greedy.greedy();
        path.nodeList.forEach(x->{
            System.out.println(x);
        });
        System.out.println(path.cost);

        Travel travel=new Travel();
        travel.citire();
        // System.out.println("incepe");
        Path trave=travel.dfs();
        trave.nodeList.forEach(x->{
            System.out.println(x);
        });
        System.out.println(trave.cost);


    }

}
