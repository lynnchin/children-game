package com.irexchange.game;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class CircularLinkedListTest {

    @Test(expected = ChildrenGameException.class)
    public void testAppend_WhenNodeIsNull(){
        CircularLinkedList<Integer> linkedList = new CircularLinkedList<>();
        linkedList.append(null);
    }

    @Test
    public void testAppend_WhenListIsEmpty(){
        CircularLinkedList<Integer> linkedList = new CircularLinkedList<>();
        linkedList.append(new Integer("1"));

        assertThat(linkedList.getHead().getData(), is(equalTo(new Integer("1"))));
        assertThat(linkedList.getTail().getData(), is(equalTo(new Integer("1"))));
    }

    @Test
    public void testGetSize_ReturnsNonZeroValue_WhenAppendNewNode() {
        CircularLinkedList<Integer> linkedList = new CircularLinkedList<>();
        linkedList.append(new Integer("1"));

        assertThat(linkedList.getSize(), is(equalTo(1)));
    }

    @Test
    public void testAppend_WhenListIsNonEmpty() {
        CircularLinkedList<Integer> linkedList = new CircularLinkedList<>();
        Integer firstItem = new Integer("1");
        linkedList.append(firstItem);
        Integer secondItem = new Integer("2");
        linkedList.append(secondItem);


        assertThat(linkedList.getSize(), is(equalTo(2)));

        assertThat(linkedList.getHead().getData(), is(equalTo(firstItem)));
        assertThat(linkedList.getTail().getData(), is(equalTo(secondItem)));
    }

    @Test
    public void testToList_WhenListIsEmpty() {
        CircularLinkedList<Object> linkedList = new CircularLinkedList<>();
        assertThat(linkedList.toList().size(), is(equalTo(0)));
    }

    @Test
    public void testToList_WhenListIsNonEmpty() {
        CircularLinkedList<Object> linkedList = new CircularLinkedList<>();
        Integer firstItem = new Integer("1");
        linkedList.append(firstItem);
        Integer secondItem = new Integer("2");
        linkedList.append(secondItem);

        assertThat(linkedList.toList().toString(), is(equalTo("[1, 2]")));
    }

    @Test(expected = ChildrenGameException.class)
    public void testDeleteAtPosition_WhenListIsEmpty() {
        CircularLinkedList<Object> linkedList = new CircularLinkedList<>();
        linkedList.deleteAt(1);
    }
}