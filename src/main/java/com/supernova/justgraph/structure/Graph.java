package com.supernova.justgraph.structure;

import java.util.ArrayList;
import java.util.List;

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

        if (!hasNode) this.nodes.add(newNode);
    }

    public void addEdge(String nodeName) {
    }
}