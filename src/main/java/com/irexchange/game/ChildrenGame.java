package com.irexchange.game;

import java.util.ArrayList;
import java.util.List;

public class ChildrenGame {

    private CircularLinkedList<Integer> childrenList;
    private List<String> gameResult;

    public ChildrenGame() {
        childrenList = new CircularLinkedList<>();
        gameResult = new ArrayList<>();
    }

    protected void start(int n) {
        int sequenceId = 1;

        while(sequenceId <= n) {
            childrenList.append(new Integer(sequenceId));
            sequenceId++;
        }
        gameResult.add("Start: " + getChildrenList().toString());
    }

    protected void print() {
        gameResult.forEach(result -> System.out.println(result));
    }

    public void play (int n, int k) {
        start(n);
        while(childrenList.getSize() > 2) {
            childrenList.deleteAt(k);
            gameResult.add("Progress: " + getChildrenList().toString());
        }

        childrenList.deleteAt(k);
        gameResult.add("Winner: " + getChildrenList().get(0));
    }

    protected List<Integer> getChildrenList() {
        return childrenList.toList();
    }
}
