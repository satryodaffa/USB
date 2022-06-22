package FinalProject;
// 2.4 Best Path to Kill Titan

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author PREDATOR
 */
public class BestPath {
    private int V; // vertices
    private LinkedList<Integer> adj[]; // Adjacency Lists

    BestPath(int v) {
        V = v;
        adj = new LinkedList[v+1];
        for (int i = 0; i < v+1; ++i)
            adj[i] = new LinkedList();
    }

    // add edge method
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // list is build to store the processing node
    static LinkedList<List<Integer>> list = new LinkedList<>();

    // BFS Traversal algrithm
    LinkedList<List<Integer>> BFS(int target) {
        //to store the result list which show the path to titan
        LinkedList<List<Integer>> res = new LinkedList<>();

        int minLength = 999;

        //traserval
        while (list.size() != 0) {
            // process current node
            List<Integer> now = list.poll();

//            System.out.print(now + " ");
            if (now.size() > minLength) {
                continue;
            }
            if (now.get(now.size() - 1) == target) {
                res.add(now);
                minLength = now.size();
                continue;
            }
            //connected node
            for (int n : adj[now.get(now.size() - 1)]) {
                List newList = new ArrayList<>(now);
                newList.add(n);
                list.add(newList);
            }

        }
        return res;
    }


    public static void bestPath() {
        //according to the question,build the non-directed  graph
        BestPath graph = new BestPath(15);

        graph.addEdge(0, 7);
        graph.addEdge(0, 5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 6);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 11);
        graph.addEdge(3, 10);
        graph.addEdge(4, 6);
        graph.addEdge(4, 10);
        graph.addEdge(5, 12);
        graph.addEdge(5, 6);
        graph.addEdge(6, 15);
        graph.addEdge(6, 8);
        graph.addEdge(7, 5);
        graph.addEdge(7, 9);
        graph.addEdge(9, 12);
        graph.addEdge(9, 15);
        graph.addEdge(10, 8);
        graph.addEdge(10, 14);
        graph.addEdge(11, 13);
        graph.addEdge(13, 14);
        graph.addEdge(14, 15);
        graph.addEdge(15, 15);

        //start up algrithm
        List<Integer> tmp = new LinkedList<>();
        tmp.add(0);
        list.add(tmp);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter location of Titan: ");
        int input = scanner.nextInt();
        LinkedList<List<Integer>> res = graph.BFS(input);
        System.out.println("");
        System.out.println("Best paths: ");
        for (List path : res) {
            System.out.println(path.toString().replace("[","").replace("]","").replace(",","-->").replace(" ", ""));
            
        }
        logout();
    }
     public static void logout(){
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.println("What would you like to do next? (Enter \"1\" to check the Best Path again or \"0\" to go back to the Main Menu)/n");
        System.out.print("Input command: ");
        int in = sc.nextInt();
        if(in == 0){
             for (int i = 0; i < 50; ++i) 
                System.out.println();
            LoginPage.runLoginPage();
        }
        else if(in == 1){
            System.out.println();
            bestPath();
        }
        else{
            System.out.println("Please enter a valid command!");
            logout();
        }
     }
}
