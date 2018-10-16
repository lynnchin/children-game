package com.irexchange.game;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class NodeTest {

    @Test
    public void testGetData_With_SingleNodeInstance(){
        Node<Integer> node = new Node(new Integer("1"));
        assertThat(node.getData(), is(equalTo(new Integer("1"))));
    }
}