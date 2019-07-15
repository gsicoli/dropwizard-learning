package com.daitan.tests.db;

import com.daitan.tests.api.MatchScore;

import java.util.ArrayList;

public class InMemory {
  private static final ArrayList<GameData> scoreBoard = new ArrayList<>();

  public void addResult(MatchScore newScore) {
    int gameIndex = -1;
    for (GameData game: scoreBoard) {
      if(game.isCorrespondingMatch(newScore.team1.name, newScore.team2.name)) {
        gameIndex = scoreBoard.indexOf(game);
      }
    }

    GameData currentMatchScore = new GameData(newScore);
    if (gameIndex == -1) {
      scoreBoard.add(currentMatchScore);
    } else {
      scoreBoard.set(gameIndex, currentMatchScore);
    }
  }

  public MatchScore getMatchResult(String t1, String t2) {
    for (GameData game: scoreBoard) {
      if(game.isCorrespondingMatch(t1, t2)) {
        return game.getScore();
      }
    }
    return null;
  }

  public void clear() {
    scoreBoard.clear();
  }
}
