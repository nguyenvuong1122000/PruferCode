package com.company;

import java.util.LinkedList;

public class Graph {
    int V;
    LinkedList<Integer> adjListArray[];

    // constructor
    Graph(int V) {
        this.V = V;

        adjListArray = new LinkedList[V];
        //store Edge by LinkedList

        for (int i = 0; i < V; i++) {
            adjListArray[i] = new LinkedList<>();
        }
    }


     void addEdge(int vertice1, int vertice2) {
        adjListArray[vertice1].add(vertice2);
        adjListArray[vertice2].add(vertice1);
    }


     void deleteVertice(int vertice){

        adjListArray[vertice] = null;
        for(int i = 0; i < V; i++) {
            if (adjListArray[i] != null) {
                adjListArray[i].remove(Integer.valueOf(vertice));
            }
        }
    }

     public LinkedList TreeToPrufer(){
        LinkedList result = new LinkedList<Integer>();
        while(result.size() != V - 2){
            for(int i = 1; i < V; i++){
                if(adjListArray[i] == null){
                    continue;
                }
                if(adjListArray[i].size() == 1){
                    result.add(adjListArray[i].getFirst());
                    deleteVertice(i);
                    break;
                }
            }
        }
        return result;
    }
}

