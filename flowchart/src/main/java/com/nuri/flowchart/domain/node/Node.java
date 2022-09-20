package com.nuri.flowchart.domain.node;

import java.util.Optional;
import java.util.function.Supplier;

public class Node<R> {

    private String description;

    private FlowLine<R> flowLine;

    private Supplier<R> task;

    public Node(String description, Supplier<R> task) {
        this.description = description;
        this.flowLine = new FlowLine<>();
        this.task = task;
    }

    public static Node of(String description, Supplier task) {
        return new Node(description, task);
    }

    public Node next(Node node) {
        flowLine.to(node);
        return this;
    }

    public Node next(R r, Node node) {
        flowLine.to(r, node);
        return this;
    }

    public void execute() {
        Optional<R> taskResult = Optional.ofNullable(task)
            .map(Supplier::get);
        System.out.println("%s result: %s".formatted(description, taskResult.get()));
        taskResult.map(flowLine::getNextNode)
            .ifPresent(Node::execute);
    }
}
