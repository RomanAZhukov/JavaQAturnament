package ru.netology.manager;

import ru.netology.domain.Player;
import ru.netology.exceptions.NotRegisteredException;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players = new ArrayList<>();

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void register(Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        int result = 0;
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException("Участник " + playerName1 + " не зарегистрирован");
        }
        if (findByName(playerName2) == null) {
            throw new NotRegisteredException("Участник " + playerName2 + " не зарегистрирован");
        }
        if (findByName(playerName1).getStrength() < findByName(playerName2).getStrength()) {
            result = 2;
        }
        if (findByName(playerName1).getStrength() > findByName(playerName2).getStrength()) {
            result = 1;
        }
        if (findByName(playerName1).getStrength() == findByName(playerName2).getStrength()) {
            result = 0;
        }
        return result;
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName() == name) {
                return player;
            }
        }
        return null;
    }
}
