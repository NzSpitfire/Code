package au.com.foxsports.sydneyfc.model;

/**
 * Created by bclark on 22/02/17.
 */

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Expose;



public class Player {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("team")
    @Expose
    private Team team;
    @SerializedName("season")
    @Expose
    private Season season;
    @SerializedName("surname")
    @Expose
    private String surname;
    @SerializedName("stats")
    @Expose
    private Stats stats;
    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("short_name")
    @Expose
    private String shortName;
    @SerializedName("other_names")
    @Expose
    private String otherNames;
    @SerializedName("default_position")
    @Expose
    private String defaultPosition;

    public Player(Integer id, String surname, String fullName, String shortName, String otherNames, String defaultPosition) {
        this.id = id;
        this.surname = surname;
        this.fullName = fullName;
        this.shortName = shortName;
        this.otherNames = otherNames;
        this.defaultPosition = defaultPosition;
    }

    public Player(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(String otherNames) {
        this.otherNames = otherNames;
    }

    public String getDefaultPosition() {
        return defaultPosition;
    }

    public void setDefaultPosition(String defaultPosition) {
        this.defaultPosition = defaultPosition;
    }
}