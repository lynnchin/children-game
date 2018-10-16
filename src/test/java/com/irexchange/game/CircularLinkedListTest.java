package com.irexchange.game;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.hasSize;
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
        CircularLinkedList<Integer> linkedList = new CircularLinkedList<>();
        Integer firstItem = new Integer("1");
        linkedList.append(firstItem);
        Integer secondItem = new Integer("2");
        linkedList.append(secondItem);

        assertThat(linkedList.toList().size(), is(equalTo(2)));
    }

    @Test(expected = ChildrenGameException.class)
    public void testDeleteAtPosition_WhenListIsEmpty() {
        CircularLinkedList<Object> linkedList = new CircularLinkedList<>();
        linkedList.deleteAt(1);
    }

    @Test
    public void testDeleteAtFirstPosition_WhenListContainsOneElement() {
        CircularLinkedList<Object> linkedList = new CircularLinkedList<>();
        linkedList.append(new Integer("1"));
        linkedList.deleteAt(1);

        assertThat(linkedList.getSize(), is(equalTo(0)));
        assertThat(linkedList.toList(), is(equalTo(Arrays.asList())));
    }

    @Test
    public void testDeleteAtFirstPosition_WhenListContainsMoreThanOneElement() {
        Integer firstElement = new Integer("1");
        Integer secondElement = new Integer("2");
        Integer thirdElement = new Integer("3");

        CircularLinkedList<Integer> linkedList = new CircularLinkedList<>();
        linkedList.append(firstElement);
        linkedList.append(secondElement);
        linkedList.append(thirdElement);
        linkedList.deleteAt(1);

        List<Integer> actualList = linkedList.toList();
        assertThat(actualList, hasSize(2));

        assertThat(actualList.toString(),equalTo(Arrays.asList(2,3).toString()));
    }

    @Test
    public void testElementAtPositionIndex_WhenIndexIsGreaterThanListSize() {
        Integer firstElement = new Integer("1");
        Integer secondElement = new Integer("2");
        Integer thirdElement = new Integer("3");

        CircularLinkedList<Integer> linkedList = new CircularLinkedList<>();
        linkedList.append(firstElement);
        linkedList.append(secondElement);
        linkedList.append(thirdElement);

        Node<Integer> result = linkedList.elementAt(4);

        assertThat(result, is(nullValue()));
    }

    @Test
    public void testElementAtPositionIndex_WhenIndexIsWithinListSize() {
        Integer firstElement = new Integer("1");
        Integer secondElement = new Integer("2");
        Integer thirdElement = new Integer("3");

        CircularLinkedList<Integer> linkedList = new CircularLinkedList<>();
        linkedList.append(firstElement);
        linkedList.append(secondElement);
        linkedList.append(thirdElement);

        Node<Integer> result = linkedList.elementAt(2);

        assertThat(result.getData(), is(equalTo(secondElement)));
    }

    @Test
    public void testDeleteAtLastPosition_WhenListContainsMoreThanOneElement() {
        Integer firstElement = new Integer("1");
        Integer secondElement = new Integer("2");
        Integer thirdElement = new Integer("3");

        CircularLinkedList<Integer> linkedList = new CircularLinkedList<>();
        linkedList.append(firstElement);
        linkedList.append(secondElement);
        linkedList.append(thirdElement);
        linkedList.deleteAt(3);

        List<Integer> actualList = linkedList.toList();
        assertThat(actualList.toString(),equalTo(Arrays.asList(1,2).toString()));
    }
}