package com.irexchange.game;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ChildrenGameTest {

    private ChildrenGame game;

    @Before
    public void setUp(){
        game = new ChildrenGame();
    }

    @Test
    public void testStart_AndSetupListWithChildrenWithIndexAsSequenceId(){
        game.start(10);

        List<Integer> result = game.getChildrenList();

        assertThat(result.size(), is(equalTo(10)));
    }
}