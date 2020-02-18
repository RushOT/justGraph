package com.supernova.justgraph;

import java.io.IOException;
import java.util.Iterator;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.supernova.justgraph.services.JsonFileReader;
import com.supernova.justgraph.structure.Graph;
import com.supernova.justgraph.structure.Node;

public class Init {
    private Graph graph;

    public Init() {
        this.graph = new Graph();
    }

    public void run() throws JsonParseException, JsonMappingException, IOException {
        JsonNode jsonNode = JsonFileReader.getJson();
        this.addNodes(jsonNode);
        System.out.println(graph);
    }

    public void addNodes(JsonNode jsonNode) {

        Iterator<String> iterator = jsonNode.fieldNames();

        while (iterator.hasNext()) {
            String nodeName = (String) iterator.next();
            Node node = new Node(nodeName);
            this.graph.addNode(node);

            addEdges(jsonNode, node);
        }
    }

    private void addEdges(JsonNode jsonNode, Node from) {
        Iterator<JsonNode> iterator = jsonNode.get(from.getName()).elements();

        while(iterator.hasNext()) {
            String nodeName = iterator.next().asText();
            Optional<Node> hasNode = graph.findNodeByName(nodeName);

            if (hasNode.isPresent()) {
                from.addEdge(hasNode.get());
            } else {
                Node newNode = new Node(nodeName);
                from.addEdge(newNode);
            }
        }
    }
}