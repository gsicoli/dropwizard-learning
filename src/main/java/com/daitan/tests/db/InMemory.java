package com.daitan.tests.db;

import com.daitan.tests.api.MatchScore;

import java.util.ArrayList;
import java.util.Arrays;

public class InMemory {
  private static final ArrayList<GameData> scoreBoard = new ArrayList<>();
  public static final String[] teams = {
      "Argentina",
      "Bolivia",
      "Brasil",
      "Chile",
      "Colombia",
      "Equador",
      "Japao",
      "Paraguai",
      "Peru",
      "Qatar",
      "Uruguai",
      "Venezuela"
  };

  private boolean areTeamsValid(MatchScore score) {
    ArrayList<String> teamList = new ArrayList<>(Arrays.asList(teams));
    String team1 = score.team1.name;
    String team2 = score.team2.name;

    if (team1.equals(team2)) {
      return false;
    }
    if (!teamList.contains(team1)) {
      return false;
    }
    if (!teamList.contains(team2)) {
      return false;
    }

    return true;
  }

  public boolean addResult(MatchScore newScore) {
    if (!areTeamsValid(newScore)) {
      return false;
    }

    for (GameData game: scoreBoard) {
      if(game.isCorrespondingMatch(newScore.team1.name, newScore.team2.name)) {
        return false;
      }
    }

    GameData currentMatchScore = new GameData(newScore);
    scoreBoard.add(currentMatchScore);

    return true;
  }

  public boolean updateResult(MatchScore newScore) {
    int gameIndex = -1;
    for (GameData game: scoreBoard) {
      if(game.isCorrespondingMatch(newScore.team1.name, newScore.team2.name)) {
        gameIndex = scoreBoard.indexOf(game);
      }
    }

    if (gameIndex == -1) {
      return false;
    }

    GameData currentMatchScore = new GameData(newScore);
    scoreBoard.set(gameIndex, currentMatchScore);

    return true;
  }

  public MatchScore getMatchResult(String t1, String t2) {
    for (GameData game: scoreBoard) {
      if(game.isCorrespondingMatch(t1, t2)) {
        return game.getScore();
      }
    }
    return null;
  }

  public MatchScore deleteMatchResult(String t1, String t2) {
    for (GameData game: scoreBoard) {
      if(game.isCorrespondingMatch(t1, t2)) {
        scoreBoard.remove(game);
        return game.getScore();
      }
    }
    return null;
  }

  public void clear() {
    scoreBoard.clear();
  }
}
