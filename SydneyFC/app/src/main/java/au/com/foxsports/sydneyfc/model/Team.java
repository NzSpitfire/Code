package au.com.foxsports.sydneyfc.model;

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Expose;

import java.util.HashMap;
import java.util.List;

/**
 * Created by bclark on 22/02/17.
 */

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



