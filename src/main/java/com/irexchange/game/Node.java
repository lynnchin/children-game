package com.irexchange.game;

public class Node<T> {
    T data;
    private Node next;

    public Node(T data) {
        this.data = data;
        next = null;
    }

    public T getData(){
        return data;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getNext() {
        return next;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
