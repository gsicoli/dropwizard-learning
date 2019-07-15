package com.daitan.tests.db;

import com.daitan.tests.api.MatchScore;

public class GameData {
  private MatchScore score;

  public GameData(MatchScore score) {
    this.score = score;
  }

  public boolean isCorrespondingMatch(String t1, String t2) {
    if ((score.team1.name.equals(t1) && score.team2.name.equals(t2))
        || (score.team1.name.equals(t2) && score.team2.name.equals(t1))) {
      return true;
    }
    return false;
  }

  public MatchScore getScore() {
    return score;
  }
}
