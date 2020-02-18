package com.supernova.justgraph.structure;

import java.util.LinkedList;

public class Node {

    private String name;
    private LinkedList<Node> edges;

    public Node(String name) {
        this.setName(name);
        edges = new LinkedList<Node>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addEdge(Node node) {
        if (!this.edges.contains(node)) {
            this.edges.add(node);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        builder.append(this.name);
        builder.append("] : ");

        this.edges.stream().forEach(node -> {
            builder.append(node.getName());
            builder.append(" ");

        });

        return builder.toString();
    }
}