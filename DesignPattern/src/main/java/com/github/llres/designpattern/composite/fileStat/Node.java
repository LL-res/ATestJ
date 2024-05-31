package com.github.llres.designpattern.composite.fileStat;

import lombok.Data;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Node {
    //private Node node;
    protected File file;
    protected List<Node> nodes = new ArrayList<>();

    public Node(File file) {
        this.file = file;
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    nodes.add(new DirectoryNode(f));
                } else {
                    nodes.add(new FileNode(f));
                }
            }
        }
    }

    public Node(String path) {
        this(new File(path));
    }

    public final List<NodeState> getStat() {
        ArrayList<NodeState> nodeStates = new ArrayList<>();
        for (Node n : nodes) {
            nodeStates.add(new NodeState(n.file.getName(), n.size()));
        }
        nodeStates.sort(Comparator.comparingLong(n -> n.size));
        return nodeStates;
    }

    protected long size() {
        return nodes.stream().map(Node::size).reduce(file.length(), Long::sum);
    }


    @Data
    public static class NodeState {
        private String name;
        private long size;

        public NodeState(String name, long size) {
            this.name = name;
            //MB
            this.size = size / 1024 / 1024;
        }

        @Override
        public String toString() {
            return "NodeState{" +
                    "name='" + name + '\'' +
                    ", size=" + size + " MB" +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        File file1 = new File("C:\\Users\\LL\\Desktop\\W\\gf\\test.txt");
        boolean newFile = file1.createNewFile();
        try (OutputStream outputStream = new FileOutputStream(file1)) {
            outputStream.write(new byte[1024 * 1024]);
        }

    }
}
