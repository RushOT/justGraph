package com.supernova.justgraph;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Graph init...\n\n");
        try {
            Init i = new Init();
            i.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
