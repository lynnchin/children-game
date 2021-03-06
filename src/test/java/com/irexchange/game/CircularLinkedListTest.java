package com.irexchange.game;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class CircularLinkedListTest {

    private CircularLinkedList<Integer> linkedList;

    @Before
    public void setUp() {
        linkedList = new CircularLinkedList<>();
    }

    @After
    public void tearDown(){
        linkedList.reset();
    }

    @Test(expected = ChildrenGameException.class)
    public void testAppend_WhenNodeIsNull(){
        linkedList.append(null);
    }

    @Test
    public void testAppend_WhenListIsEmpty(){
        appendOneElementToList();

        assertThat(linkedList.getHead().getData(), is(equalTo(new Integer("1"))));
        assertThat(linkedList.getTail().getData(), is(equalTo(new Integer("1"))));
    }

    @Test
    public void testAppend_AndListIsCircular() {
        appendMoreThanTwoElementsToList();

        Node<Integer> head = linkedList.getHead();
        Node<Integer> tail = linkedList.getTail();

        assertThat(tail.getNext(), is(equalTo(head)));
    }

    @Test
    public void testGetSize_ReturnsNonZeroValue_WhenAppendNewNode() {
        appendOneElementToList();

        assertThat(linkedList.getSize(), is(equalTo(1)));
    }

    @Test
    public void testAppend_WhenListIsNonEmpty() {
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
        assertThat(linkedList.toList().size(), is(equalTo(0)));
    }

    @Test
    public void testToList_WhenListIsNonEmpty() {
        Integer firstItem = new Integer("1");
        linkedList.append(firstItem);
        Integer secondItem = new Integer("2");
        linkedList.append(secondItem);

        assertThat(linkedList.toList().size(), is(equalTo(2)));
    }

    @Test(expected = ChildrenGameException.class)
    public void testDeleteAtPosition_WhenListIsEmpty() {
        linkedList.deleteAt(1);
    }

    @Test
    public void testDeleteAtFirstPosition_WhenListContainsOneElement() {
        appendOneElementToList();
        linkedList.deleteAt(1);

        assertThat(linkedList.getSize(), is(equalTo(0)));
        assertThat(linkedList.toList(), is(equalTo(Arrays.asList())));
    }

    @Test
    public void testDeleteAtFirstPosition_WhenListContainsMoreThanOneElement() {
        appendMoreThanTwoElementsToList();
        linkedList.deleteAt(1);

        List<Integer> actualList = linkedList.toList();
        assertThat(actualList, hasSize(2));

        assertThat(actualList.toString(),equalTo(Arrays.asList(2,3).toString()));
    }

    @Test
    public void testElementAtPositionIndex_WhenIndexIsGreaterThanListSize() {
        appendMoreThanTwoElementsToList();

        Node<Integer> result = linkedList.elementAt(4);

        assertThat(result, is(nullValue()));
    }

    @Test
    public void testElementAtPositionIndex_WhenIndexIsWithinListSize() {
        appendMoreThanTwoElementsToList();
        Integer secondElement = new Integer("2");

        Node<Integer> result = linkedList.elementAt(2);

        assertThat(result.getData(), is(equalTo(secondElement)));
    }

    @Test
    public void testDeleteAtLastPosition_WhenListContainsMoreThanOneElement() {
        appendMoreThanTwoElementsToList();

        linkedList.deleteAt(3);

        List<Integer> actualList = linkedList.toList();
        assertThat(actualList.toString(),equalTo(Arrays.asList(1,2).toString()));
    }

    @Test
    public void testDeleteAt_WhenListContainsTwoElements() {
        Integer firstElement = new Integer("1");
        Integer secondElement = new Integer("2");

        linkedList.append(firstElement);
        linkedList.append(secondElement);

        linkedList.deleteAt(3);

        List<Integer> actualList = linkedList.toList();
        assertThat(actualList.toString(),equalTo(Arrays.asList(2).toString()));
    }

    @Test
    public void testDeleteAtMiddlePosition_WhenListContainsMoreThanOneElement() {
        Integer firstElement = new Integer("1");
        Integer secondElement = new Integer("2");
        Integer thirdElement = new Integer("3");
        Integer fourthElement = new Integer("4");
        Integer fifthElement = new Integer("5");

        linkedList.append(firstElement);
        linkedList.append(secondElement);
        linkedList.append(thirdElement);
        linkedList.append(fourthElement);
        linkedList.append(fifthElement);

        linkedList.deleteAt(3);

        List<Integer> actualList = linkedList.toList();

        System.out.println(actualList.toString());
        assertThat(actualList.toString(),equalTo(Arrays.asList(4,5,1,2).toString()));
    }

    private void appendOneElementToList() {
        linkedList.append(new Integer("1"));
    }

    private void appendMoreThanTwoElementsToList() {
        Integer firstElement = new Integer("1");
        Integer secondElement = new Integer("2");
        Integer thirdElement = new Integer("3");

        linkedList.append(firstElement);
        linkedList.append(secondElement);
        linkedList.append(thirdElement);
    }
}