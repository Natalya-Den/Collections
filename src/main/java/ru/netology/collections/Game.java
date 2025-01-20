package ru.netology.collections;

import java.util.*;

public class Game {

    HashMap<String, Integer> players = new HashMap<>();
    int player1Strength = 0;
    int player2Strength = 0;

    public void register(Player player) {
        players.put(player.getName(), player.getStrength());
    }

    public int round(String playerName1, String playerName2) {
        if (!players.containsKey(playerName1)) {
            throw new NotRegisteredException(playerName1);
        } else if (!players.containsKey(playerName2)) {
            throw new NotRegisteredException(playerName2);
        } else if (players.get(playerName1) > players.get(playerName2)) {
            return 1;
        } else if (players.get(playerName1) < players.get(playerName2)) {
            return 2;
        } else {
            return 0;
        }
    }
}
