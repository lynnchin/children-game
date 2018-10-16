package com.irexchange.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CircularLinkedList<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;

    public CircularLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void reset() {
        head = null;
        tail = null;
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

    public Node<T> elementAt(int indexPosition){
        if(indexPosition > size){
            return null;
        }

        Node temp = head;
        int i = 1;
        while(i++ != indexPosition){
            temp = temp.getNext();
        }

        return temp;
    }

    public void deleteAt(int indexPosition) {
        if(size == 0) {
           throw new ChildrenGameException("No element can be deleted in empty list");
        }

        if(size == 1) {
           head = null;
           tail = null;
           size = 0;
           return;
        }

        // Removes first element
        if(indexPosition == 1 && size > 1) {
            head = head.getNext();
            tail.setNext(head);
            size--;
            return;
        }

        // Removes last element
        if(indexPosition == size) {
           // Find the previous node in circular linked list
           Node<T> foundNode = elementAt(indexPosition-1);
           // Set the next pointer to head
           foundNode.setNext(head);
           size--;
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

    public List<T> toList() {
        List<T> nodeList = new ArrayList<>();

        if(size == 0) {
           return Collections.emptyList();
        } else {
            Node<T> node = head;
            nodeList.add((T) node);
            node = node.getNext();

            while(node != null && node != head) {
                nodeList.add((T) node);
                node = node.getNext();
            }

            return nodeList;
        }
    }
}
