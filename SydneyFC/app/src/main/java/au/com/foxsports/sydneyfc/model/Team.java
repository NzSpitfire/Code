package au.com.foxsports.sydneyfc.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bclark on 22/02/17.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Team {
    private List<Player> playersList;
    private HashMap<String,List<Player>> playerByPosition;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("short_name")
    @Expose
    private String shortName;


    public Team(List<Player> playersList) {
        this.playersList = playersList;
        playerByPosition = new HashMap<>();
        Collections.sort(playersList, new Comparator<Player>()
        {
            @Override
            public int compare(Player player1, Player player2)
            {
                return player1.getSurname().compareToIgnoreCase(player2.getSurname());
            }
        });
        for (Player player:playersList) {
            List<Player> list = playerByPosition.get(player.getDefaultPosition());
            if(list == null){
                list = new ArrayList<>();
            }
            if (!player.getDefaultPosition().equals("")){
                list.add(player);
                playerByPosition.put(player.getDefaultPosition(),list);
            }

        }
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public List<Player> getPlayersList() {
        return playersList;
    }

    public void setPlayersList(List<Player> playersList) {
        this.playersList = playersList;
    }

    public HashMap<String, List<Player>> getPlayerByPosition() {
        return playerByPosition;
    }

    public void setPlayerByPosition(HashMap<String, List<Player>> playerByPosition) {
        this.playerByPosition = playerByPosition;
    }
}



