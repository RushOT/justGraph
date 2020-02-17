package com.supernova.justgraph;

import java.io.IOException;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.supernova.justgraph.services.JsonFileReader;
import com.supernova.justgraph.structure.Graph;
import com.supernova.justgraph.structure.Node;

public class Init {
    private Graph graph;

    public Init () {
        this.graph = new Graph();
    }

    public void run() throws JsonParseException, JsonMappingException, IOException {
        JsonNode jsonNode = JsonFileReader.getJson();
        this.addNodes(jsonNode);
    }

    public void addNodes(JsonNode jsonNode) {

        Iterator<String> iterator = jsonNode.fieldNames();

        while (iterator.hasNext()) {
            String nodeName = (String) iterator.next();
            this.graph.addNode(new Node(nodeName));

            addEdges(jsonNode, nodeName);
        }
    }

    private void addEdges(JsonNode jsonNode, String nodeName) {
        Iterator<JsonNode> iterator = jsonNode.get(nodeName).elements();

        while(iterator.hasNext()) {
            String nodeName = iterator.next().asText();
        }
    }
}