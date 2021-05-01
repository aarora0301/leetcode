package main.twilion;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    //  static String[][] dependencies = new String[][]{
    //          // group 1: P0 depends on P1 and so on
    //          {"P0", "P1"},
    //          {"P3", "P2"},
    //          {"P1", "P3"},
    //          {"P4", "P1"},

    //         5 packages (po, p1,,,,p4)
    //         // {"P2", "P3"},       // adding this makes it a cyclic dependency and not installable; negative case for part 1


    private Map<String,List<String>> graph;
    private Set<String> isVisited;
    private Set<String> onStack;
    boolean isCyclic;
    Set<String> allPack;
    Queue<String> queue;
    public List<String> findOrder(String[][] packages){
        List<String> result= new ArrayList<String>();
        hasCycle(packages);
        if(isCyclic){
            return result;
        }

        queue= new LinkedList<>();
        for(String tempPack: allPack){
            if(!isVisited.contains(tempPack)){
                dfs_postOrder(graph, tempPack);
            }
        }

        for(String pack: queue){
            result.add(pack);
        }

        Collections.reverse(result);
        return result;

    }

    private void dfs_postOrder(Map<String,List<String>> graph, String pack){
        isVisited.add(pack);
        List<String> neighbours= graph.get(pack);
        if (neighbours != null){
            for(String neighbour: neighbours){
                if(!isVisited.contains(neighbour))  {
                    dfs_postOrder(graph, neighbour);
                }
            }
        }
        queue.add(pack);
    }

    private void hasCycle(String[][] packages){
        graph= new HashMap<>();
        allPack= new HashSet<String>();
        isVisited= new HashSet<String>();
        onStack= new HashSet<String>();;

        List<String> list;
        for(String [] pack: packages){
            // graph[pack[1]].add(pack[0]);
            if(graph.containsKey(pack[1])){
                list= graph.get(pack[1]);
            }else{
                list= new ArrayList<>();
            }
            allPack.add(pack[1]);
            list.add(pack[0]);
            graph.put(pack[1], list);
        }

        for(String tempPack: allPack){
            if(!isVisited.contains(tempPack) && !isCyclic){
                dfs_cyclicity(graph, tempPack);
            }
        }

        isVisited.clear();
    }


    private void dfs_cyclicity(Map<String,List<String>> graph, String pack){
        isVisited.add(pack);
        onStack.add(pack);
        List<String> neighbours= graph.get(pack);
        if (neighbours != null){
            for(String neighbour: neighbours){
                if(isCyclic){
                    return;
                }else if(!isVisited.contains(neighbour)){
                    dfs_cyclicity(graph, neighbour);
                }else if(onStack.contains(neighbour)){
                    isCyclic= true;
                }
            }
        }

        onStack.remove(pack);
    }

    public static void main(String[] args) {
        // Find the desired order of installation of all the packages
        // P0, P1, P2, P3, P4
        Solution solution= new Solution();

        String[][] dependencies = new String[][]{
                // group 1: P0 depends on P1 and so on
                {"P0", "P1"},
                {"P3", "P2"},
                {"P1", "P3"},
                {"P4", "P1"},
                {"P2", ""}
        };
        System.out.println(solution.findOrder(dependencies).toString());
    }
}

