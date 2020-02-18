package com.supernova.justgraph.structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Graph {
    private ArrayList<Node> nodes;

    public Graph() {
        nodes = new ArrayList<Node>();
    }

    public List<Node> getNodes() {
        return this.nodes;
    }

    public void addNode(Node newNode) {
        boolean hasNode = this.nodes.stream().anyMatch((node) -> {
            return newNode.getName().equals(node.getName());
        });

        if (!hasNode)
            this.nodes.add(newNode);
    }

    public Optional<Node> findNodeByName(String name) {
        return this.nodes.stream().filter(node -> node.getName().equals(name)).findFirst();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        this.nodes.stream().forEach(node -> {
           builder.append(node);
           builder.append("\n"); 
        });

        return builder.toString();
    }
}