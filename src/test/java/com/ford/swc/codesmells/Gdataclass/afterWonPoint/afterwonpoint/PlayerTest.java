package com.ford.swc.codesmells.Gdataclass.afterWonPoint.afterwonpoint;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    @Test
    void whenOnePointIsWonPointsIncreaseByOne() {
        Player player = new Player("a player");
        player.wonPoint();
        assertThat(player.arePointsAtLeast(1)).isTrue();
        assertThat(player.arePointsAtMost(3)).isTrue();
    }

    @Test
    void whenTwoPointAreWonPointsIncreaseByTwo() {
        Player player = new Player("a player");
        player.wonPoint();
        player.wonPoint();
        assertThat(player.arePointsAtLeast(2)).isTrue();
        assertThat(player.arePointsAtMost(2)).isTrue();
    }
}