package com.company;
import java.io.*;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class Main {

    public static void main(String[] args) {
        //Create graph and add egde from txt file
        File file = new File(System.getProperty("user.dir") + "/INPUT//test.txt");
        Scanner sc = null;

        try{
            //Đọc dữ liệu từ file test.txt
            sc = new Scanner(file);
            int V = sc.nextInt();
            Graph graph = new Graph(V+1);

            while(sc.hasNextLine()) {
                graph.addEdge(sc.nextInt(),sc.nextInt());
            }


            //In Prufer Code ra file result.txt
            PrintWriter writer = new PrintWriter(new File(System.getProperty("user.dir")+"/OUTPUT//result.txt"));
            writer.write(graph.TreeToPrufer().toString());
            writer.flush();
            writer.close();
        }

        catch (Exception e){
                e.printStackTrace();
            }
        }
}


