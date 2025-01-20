package ru.netology.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class GameTests {

    Player player1 = new Player(1, "name1", 120);
    Player player2 = new Player(2, "name2", 120);
    Player player3 = new Player(3, "name3", 95);

    @Test
    public void roundWhenFirstPlayerChampionTest() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);

        int actual = game.round("name1", "name3");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundWhenSecondPlayerChampionTest() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);

        int actual = game.round("name3", "name1");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundWhenStrengthEqualTest() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);

        int actual = game.round("name1", "name2");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundWhenFirstPlayerNotRegisteredTest() {
        Game game = new Game();
        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("name4", "name1");
        });
    }

    @Test
    public void roundWhenSecondPlayerNotRegisteredTest() {
        Game game = new Game();
        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("name1", "name4");
        });
    }


}