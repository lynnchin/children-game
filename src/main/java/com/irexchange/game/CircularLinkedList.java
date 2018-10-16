package com.irexchange.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CircularLinkedList<T> {
    private int size;
    private Node<T> lastDeleted;
    private Node<T> head = null;
    private Node<T> tail = null;

    public CircularLinkedList() {
        head = null;
        tail = null;
        lastDeleted = null;
        size = 0;
    }

    public void append(T data) {
        if(data == null) {
            throw new ChildrenGameException("Data is null value");
        }
        Node<T> newNode = new Node(data);
        if(getSize() == 0) {
            head = newNode;
            newNode.setNext(head);
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public void deleteAt(int indexPosition) {
        if(size == 0) {
           throw new ChildrenGameException("No element can be deleted in empty list");
        }
        if(indexPosition == 1 && size == 1) {
           head = null;
           tail = null;
           size = 0;
           return;
        }
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }

    public List<Object> toList() {
        List<Object> nodeList = new ArrayList<>();

        if(size == 0) {
           return Collections.emptyList();
        } else {
            Node<T> node = head;
            nodeList.add(node);
            node = node.getNext();

            while(node != null && node != head) {
                nodeList.add(node);
                node = node.getNext();
            }

            return nodeList;
        }
    }


}
