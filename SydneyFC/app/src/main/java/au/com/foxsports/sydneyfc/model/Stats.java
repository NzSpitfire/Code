package au.com.foxsports.sydneyfc.model;

/**
 * Created by bclark on 23/02/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Stats {

    @SerializedName("games")
    @Expose
    private Integer games;
    @SerializedName("wins")
    @Expose
    private Integer wins;
    @SerializedName("draws")
    @Expose
    private Integer draws;
    @SerializedName("losses")
    @Expose
    private Integer losses;
    @SerializedName("tackles")
    @Expose
    private Integer tackles;
    @SerializedName("citations")
    @Expose
    private Integer citations;
    @SerializedName("clearances")
    @Expose
    private Integer clearances;
    @SerializedName("crosses")
    @Expose
    private Integer crosses;
    @SerializedName("goals")
    @Expose
    private Integer goals;
    @SerializedName("offsides")
    @Expose
    private Integer offsides;
    @SerializedName("passes")
    @Expose
    private Integer passes;
    @SerializedName("possessions")
    @Expose
    private Integer possessions;
    @SerializedName("runs")
    @Expose
    private Integer runs;
    @SerializedName("shots")
    @Expose
    private Integer shots;
    @SerializedName("minutes_played")
    @Expose
    private Integer minutesPlayed;
    @SerializedName("win_percentage")
    @Expose
    private Double winPercentage;
    @SerializedName("ball_in_box")
    @Expose
    private Integer ballInBox;
    @SerializedName("clean_sheets")
    @Expose
    private Integer cleanSheets;
    @SerializedName("clearance_attempts")
    @Expose
    private Integer clearanceAttempts;
    @SerializedName("corners_taken")
    @Expose
    private Integer cornersTaken;
    @SerializedName("corners_won")
    @Expose
    private Integer cornersWon;
    @SerializedName("crosses_regained")
    @Expose
    private Integer crossesRegained;
    @SerializedName("forced_turnovers")
    @Expose
    private Integer forcedTurnovers;
    @SerializedName("fouls_conceded")
    @Expose
    private Integer foulsConceded;
    @SerializedName("fouls_won")
    @Expose
    private Integer foulsWon;
    @SerializedName("goal_assists")
    @Expose
    private Integer goalAssists;
    @SerializedName("interchanges_off")
    @Expose
    private Integer interchangesOff;
    @SerializedName("interchanges_on")
    @Expose
    private Integer interchangesOn;
    @SerializedName("keeper_claims")
    @Expose
    private Integer keeperClaims;
    @SerializedName("keeper_claim_attempts")
    @Expose
    private Integer keeperClaimAttempts;
    @SerializedName("keeper_conceded")
    @Expose
    private Integer keeperConceded;
    @SerializedName("keeper_saves")
    @Expose
    private Integer keeperSaves;
    @SerializedName("keeper_sweeps")
    @Expose
    private Integer keeperSweeps;
    @SerializedName("keeper_sweep_attempts")
    @Expose
    private Integer keeperSweepAttempts;
    @SerializedName("medal_points")
    @Expose
    private Integer medalPoints;
    @SerializedName("own_goals")
    @Expose
    private Integer ownGoals;
    @SerializedName("pass_break_ups")
    @Expose
    private Integer passBreakUps;
    @SerializedName("passes_regained")
    @Expose
    private Integer passesRegained;
    @SerializedName("pass_intercepts")
    @Expose
    private Integer passIntercepts;
    @SerializedName("penalties_conceded")
    @Expose
    private Integer penaltiesConceded;
    @SerializedName("penalties_faced")
    @Expose
    private Integer penaltiesFaced;
    @SerializedName("penalties_won")
    @Expose
    private Integer penaltiesWon;
    @SerializedName("penalty_goals")
    @Expose
    private Integer penaltyGoals;
    @SerializedName("penalty_misses")
    @Expose
    private Integer penaltyMisses;
    @SerializedName("penalty_saves")
    @Expose
    private Integer penaltySaves;
    @SerializedName("red_cards")
    @Expose
    private Integer redCards;
    @SerializedName("send_offs")
    @Expose
    private Integer sendOffs;
    @SerializedName("shot_assists")
    @Expose
    private Integer shotAssists;
    @SerializedName("secondary_assists")
    @Expose
    private Integer secondaryAssists;
    @SerializedName("shot_blocks")
    @Expose
    private Integer shotBlocks;
    @SerializedName("shot_saves")
    @Expose
    private Integer shotSaves;
    @SerializedName("shots_blocked")
    @Expose
    private Integer shotsBlocked;
    @SerializedName("shots_off_target")
    @Expose
    private Integer shotsOffTarget;
    @SerializedName("shots_on_target")
    @Expose
    private Integer shotsOnTarget;
    @SerializedName("tackle_attempts")
    @Expose
    private Integer tackleAttempts;
    @SerializedName("tackle_busts")
    @Expose
    private Integer tackleBusts;
    @SerializedName("tackle_misses")
    @Expose
    private Integer tackleMisses;
    @SerializedName("through_balls")
    @Expose
    private Integer throughBalls;
    @SerializedName("through_balls_complete")
    @Expose
    private Integer throughBallsComplete;
    @SerializedName("yellow_cards")
    @Expose
    private Integer yellowCards;

    private List<Stat> statList;

    public Stats(){
        statList = new ArrayList<>();
    }

    public List<Stat> getStatList(){

        if(statList.isEmpty()) {
            statList = new ArrayList<>();
            statList.add(new Stat("Games", getGames().toString()));
            statList.add(new Stat("Wins", getWins().toString()));
            statList.add(new Stat("Draws", getDraws().toString()));
            statList.add(new Stat("Losses", getDraws().toString()));
            statList.add(new Stat("Tackles", getTackles().toString()));
            statList.add(new Stat("Citations", getCitations().toString()));
            statList.add(new Stat("Clearances", getClearances().toString()));
            statList.add(new Stat("Crosses", getCrosses().toString()));
            statList.add(new Stat("Goals", getGoals().toString()));
            statList.add(new Stat("Offsides", getOffsides().toString()));
            statList.add(new Stat("Passes", getPasses().toString()));
            statList.add(new Stat("Possessions", getPossessions().toString()));
            statList.add(new Stat("Runs", getRuns().toString()));
            statList.add(new Stat("Shots", getShots().toString()));
            statList.add(new Stat("Minutes Played", getMinutesPlayed().toString()));
            statList.add(new Stat("Win Percentaged", getWinPercentage().toString()));
            statList.add(new Stat("Ball In Box", getBallInBox().toString()));
            statList.add(new Stat("Clean Sheets", getCleanSheets().toString()));
            statList.add(new Stat("Clearance Attempts", getClearanceAttempts().toString()));
            statList.add(new Stat("Corners Taken", getCornersTaken().toString()));
            statList.add(new Stat("Corners Won", getCornersWon().toString()));
            statList.add(new Stat("Crosses Regained", getCrossesRegained().toString()));
            statList.add(new Stat("Forced Turnovers", getForcedTurnovers().toString()));
            statList.add(new Stat("Fouls Conceded", getFoulsConceded().toString()));
            statList.add(new Stat("Fouls Won", getFoulsWon().toString()));
            statList.add(new Stat("Goal Assists", getGoalAssists().toString()));
            statList.add(new Stat("Interchanges Off", getInterchangesOff().toString()));
            statList.add(new Stat("Interchanges On", getInterchangesOn().toString()));
            statList.add(new Stat("Keeper Claims", getKeeperClaims().toString()));
            statList.add(new Stat("Keeper Claim Attempts", getKeeperClaimAttempts().toString()));
            statList.add(new Stat("Keeper Conceded", getKeeperConceded().toString()));
            statList.add(new Stat("Keeper Saves", getKeeperSaves().toString()));
            statList.add(new Stat("Keeper Sweeps", getKeeperSweeps().toString()));
            statList.add(new Stat("Keeper Sweep Attempts", getKeeperSweepAttempts().toString()));
            statList.add(new Stat("Medal Points", getMedalPoints().toString()));
            statList.add(new Stat("Own Goals", getOwnGoals().toString()));
            statList.add(new Stat("Pass Break Ups", getPassBreakUps().toString()));
            statList.add(new Stat("Passes Regained", getPassesRegained().toString()));
            statList.add(new Stat("Pass Intercepts", getPassIntercepts().toString()));
            statList.add(new Stat("Penalties Conceded", getPenaltiesConceded().toString()));
            statList.add(new Stat("Penalties Faced", getPenaltiesFaced().toString()));
            statList.add(new Stat("Penalties Won", getPenaltiesWon().toString()));
            statList.add(new Stat("Penalty Goals", getPenaltyGoals().toString()));
            statList.add(new Stat("Penalty Misses", getPenaltyMisses().toString()));
            statList.add(new Stat("Penalty Saves", getPenaltySaves().toString()));
            statList.add(new Stat("Red Cards", getRedCards().toString()));
            statList.add(new Stat("Send Offs", getSendOffs().toString()));
            statList.add(new Stat("Shot Assists", getShotAssists().toString()));
            statList.add(new Stat("Secondary Assists", getSecondaryAssists().toString()));
            statList.add(new Stat("Shot Blocks", getShotBlocks().toString()));
            statList.add(new Stat("Shot Saves", getShotSaves().toString()));
            statList.add(new Stat("Shots Blocked", getShotsBlocked().toString()));
            statList.add(new Stat("Shots Off Target", getShotsOffTarget().toString()));
            statList.add(new Stat("Shots On Target", getShotsOnTarget().toString()));
            statList.add(new Stat("Tackle Attempts", getTackleAttempts().toString()));
            statList.add(new Stat("Tackle Busts", getTackleBusts().toString()));
            statList.add(new Stat("Tackle Misses", getTackleMisses().toString()));
            statList.add(new Stat("Through Balls", getThroughBalls().toString()));
            statList.add(new Stat("Through Balls Complete", getThroughBallsComplete().toString()));
            statList.add(new Stat("Yellow Cards", getYellowCards().toString()));
        }
        return statList;
    }

    public Integer getGames() {
        return games;
    }

    public void setGames(Integer games) {
        this.games = games;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getDraws() {
        return draws;
    }

    public void setDraws(Integer draws) {
        this.draws = draws;
    }

    public Integer getLosses() {
        return losses;
    }

    public void setLosses(Integer losses) {
        this.losses = losses;
    }

    public Integer getTackles() {
        return tackles;
    }

    public void setTackles(Integer tackles) {
        this.tackles = tackles;
    }

    public Integer getCitations() {
        return citations;
    }

    public void setCitations(Integer citations) {
        this.citations = citations;
    }

    public Integer getClearances() {
        return clearances;
    }

    public void setClearances(Integer clearances) {
        this.clearances = clearances;
    }

    public Integer getCrosses() {
        return crosses;
    }

    public void setCrosses(Integer crosses) {
        this.crosses = crosses;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getOffsides() {
        return offsides;
    }

    public void setOffsides(Integer offsides) {
        this.offsides = offsides;
    }

    public Integer getPasses() {
        return passes;
    }

    public void setPasses(Integer passes) {
        this.passes = passes;
    }

    public Integer getPossessions() {
        return possessions;
    }

    public void setPossessions(Integer possessions) {
        this.possessions = possessions;
    }

    public Integer getRuns() {
        return runs;
    }

    public void setRuns(Integer runs) {
        this.runs = runs;
    }

    public Integer getShots() {
        return shots;
    }

    public void setShots(Integer shots) {
        this.shots = shots;
    }

    public Integer getMinutesPlayed() {
        return minutesPlayed;
    }

    public void setMinutesPlayed(Integer minutesPlayed) {
        this.minutesPlayed = minutesPlayed;
    }

    public String getWinPercentage() {
        return winPercentage + "%";
    }

    public void setWinPercentage(Double winPercentage) {
        this.winPercentage = winPercentage;
    }

    public Integer getBallInBox() {
        return ballInBox;
    }

    public void setBallInBox(Integer ballInBox) {
        this.ballInBox = ballInBox;
    }

    public Integer getCleanSheets() {
        return cleanSheets;
    }

    public void setCleanSheets(Integer cleanSheets) {
        this.cleanSheets = cleanSheets;
    }

    public Integer getClearanceAttempts() {
        return clearanceAttempts;
    }

    public void setClearanceAttempts(Integer clearanceAttempts) {
        this.clearanceAttempts = clearanceAttempts;
    }

    public Integer getCornersTaken() {
        return cornersTaken;
    }

    public void setCornersTaken(Integer cornersTaken) {
        this.cornersTaken = cornersTaken;
    }

    public Integer getCornersWon() {
        return cornersWon;
    }

    public void setCornersWon(Integer cornersWon) {
        this.cornersWon = cornersWon;
    }

    public Integer getCrossesRegained() {
        return crossesRegained;
    }

    public void setCrossesRegained(Integer crossesRegained) {
        this.crossesRegained = crossesRegained;
    }

    public Integer getForcedTurnovers() {
        return forcedTurnovers;
    }

    public void setForcedTurnovers(Integer forcedTurnovers) {
        this.forcedTurnovers = forcedTurnovers;
    }

    public Integer getFoulsConceded() {
        return foulsConceded;
    }

    public void setFoulsConceded(Integer foulsConceded) {
        this.foulsConceded = foulsConceded;
    }

    public Integer getFoulsWon() {
        return foulsWon;
    }

    public void setFoulsWon(Integer foulsWon) {
        this.foulsWon = foulsWon;
    }

    public Integer getGoalAssists() {
        return goalAssists;
    }

    public void setGoalAssists(Integer goalAssists) {
        this.goalAssists = goalAssists;
    }

    public Integer getInterchangesOff() {
        return interchangesOff;
    }

    public void setInterchangesOff(Integer interchangesOff) {
        this.interchangesOff = interchangesOff;
    }

    public Integer getInterchangesOn() {
        return interchangesOn;
    }

    public void setInterchangesOn(Integer interchangesOn) {
        this.interchangesOn = interchangesOn;
    }

    public Integer getKeeperClaims() {
        return keeperClaims;
    }

    public void setKeeperClaims(Integer keeperClaims) {
        this.keeperClaims = keeperClaims;
    }

    public Integer getKeeperClaimAttempts() {
        return keeperClaimAttempts;
    }

    public void setKeeperClaimAttempts(Integer keeperClaimAttempts) {
        this.keeperClaimAttempts = keeperClaimAttempts;
    }

    public Integer getKeeperConceded() {
        return keeperConceded;
    }

    public void setKeeperConceded(Integer keeperConceded) {
        this.keeperConceded = keeperConceded;
    }

    public Integer getKeeperSaves() {
        return keeperSaves;
    }

    public void setKeeperSaves(Integer keeperSaves) {
        this.keeperSaves = keeperSaves;
    }

    public Integer getKeeperSweeps() {
        return keeperSweeps;
    }

    public void setKeeperSweeps(Integer keeperSweeps) {
        this.keeperSweeps = keeperSweeps;
    }

    public Integer getKeeperSweepAttempts() {
        return keeperSweepAttempts;
    }

    public void setKeeperSweepAttempts(Integer keeperSweepAttempts) {
        this.keeperSweepAttempts = keeperSweepAttempts;
    }

    public Integer getMedalPoints() {
        return medalPoints;
    }

    public void setMedalPoints(Integer medalPoints) {
        this.medalPoints = medalPoints;
    }

    public Integer getOwnGoals() {
        return ownGoals;
    }

    public void setOwnGoals(Integer ownGoals) {
        this.ownGoals = ownGoals;
    }

    public Integer getPassBreakUps() {
        return passBreakUps;
    }

    public void setPassBreakUps(Integer passBreakUps) {
        this.passBreakUps = passBreakUps;
    }

    public Integer getPassesRegained() {
        return passesRegained;
    }

    public void setPassesRegained(Integer passesRegained) {
        this.passesRegained = passesRegained;
    }

    public Integer getPassIntercepts() {
        return passIntercepts;
    }

    public void setPassIntercepts(Integer passIntercepts) {
        this.passIntercepts = passIntercepts;
    }

    public Integer getPenaltiesConceded() {
        return penaltiesConceded;
    }

    public void setPenaltiesConceded(Integer penaltiesConceded) {
        this.penaltiesConceded = penaltiesConceded;
    }

    public Integer getPenaltiesFaced() {
        return penaltiesFaced;
    }

    public void setPenaltiesFaced(Integer penaltiesFaced) {
        this.penaltiesFaced = penaltiesFaced;
    }

    public Integer getPenaltiesWon() {
        return penaltiesWon;
    }

    public void setPenaltiesWon(Integer penaltiesWon) {
        this.penaltiesWon = penaltiesWon;
    }

    public Integer getPenaltyGoals() {
        return penaltyGoals;
    }

    public void setPenaltyGoals(Integer penaltyGoals) {
        this.penaltyGoals = penaltyGoals;
    }

    public Integer getPenaltyMisses() {
        return penaltyMisses;
    }

    public void setPenaltyMisses(Integer penaltyMisses) {
        this.penaltyMisses = penaltyMisses;
    }

    public Integer getPenaltySaves() {
        return penaltySaves;
    }

    public void setPenaltySaves(Integer penaltySaves) {
        this.penaltySaves = penaltySaves;
    }

    public Integer getRedCards() {
        return redCards;
    }

    public void setRedCards(Integer redCards) {
        this.redCards = redCards;
    }

    public Integer getSendOffs() {
        return sendOffs;
    }

    public void setSendOffs(Integer sendOffs) {
        this.sendOffs = sendOffs;
    }

    public Integer getShotAssists() {
        return shotAssists;
    }

    public void setShotAssists(Integer shotAssists) {
        this.shotAssists = shotAssists;
    }

    public Integer getSecondaryAssists() {
        return secondaryAssists;
    }

    public void setSecondaryAssists(Integer secondaryAssists) {
        this.secondaryAssists = secondaryAssists;
    }

    public Integer getShotBlocks() {
        return shotBlocks;
    }

    public void setShotBlocks(Integer shotBlocks) {
        this.shotBlocks = shotBlocks;
    }

    public Integer getShotSaves() {
        return shotSaves;
    }

    public void setShotSaves(Integer shotSaves) {
        this.shotSaves = shotSaves;
    }

    public Integer getShotsBlocked() {
        return shotsBlocked;
    }

    public void setShotsBlocked(Integer shotsBlocked) {
        this.shotsBlocked = shotsBlocked;
    }

    public Integer getShotsOffTarget() {
        return shotsOffTarget;
    }

    public void setShotsOffTarget(Integer shotsOffTarget) {
        this.shotsOffTarget = shotsOffTarget;
    }

    public Integer getShotsOnTarget() {
        return shotsOnTarget;
    }

    public void setShotsOnTarget(Integer shotsOnTarget) {
        this.shotsOnTarget = shotsOnTarget;
    }

    public Integer getTackleAttempts() {
        return tackleAttempts;
    }

    public void setTackleAttempts(Integer tackleAttempts) {
        this.tackleAttempts = tackleAttempts;
    }

    public Integer getTackleBusts() {
        return tackleBusts;
    }

    public void setTackleBusts(Integer tackleBusts) {
        this.tackleBusts = tackleBusts;
    }

    public Integer getTackleMisses() {
        return tackleMisses;
    }

    public void setTackleMisses(Integer tackleMisses) {
        this.tackleMisses = tackleMisses;
    }

    public Integer getThroughBalls() {
        return throughBalls;
    }

    public void setThroughBalls(Integer throughBalls) {
        this.throughBalls = throughBalls;
    }

    public Integer getThroughBallsComplete() {
        return throughBallsComplete;
    }

    public void setThroughBallsComplete(Integer throughBallsComplete) {
        this.throughBallsComplete = throughBallsComplete;
    }

    public Integer getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(Integer yellowCards) {
        this.yellowCards = yellowCards;
    }

}