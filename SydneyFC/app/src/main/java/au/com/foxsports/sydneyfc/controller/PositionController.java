package au.com.foxsports.sydneyfc.controller;

import java.util.List;

import au.com.foxsports.sydneyfc.model.Player;

/**
 * Created by bclark on 24/02/17.
 */

public class PositionController {
    private List<Player> players;

    public PositionController() {

    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
