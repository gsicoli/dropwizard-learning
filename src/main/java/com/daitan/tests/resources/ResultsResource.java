package com.daitan.tests.resources;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.daitan.tests.api.MatchScore;
import com.daitan.tests.db.InMemory;

@Path("/v1/resultados")
@Produces(MediaType.APPLICATION_JSON)
public class ResultsResource {
  private InMemory myLocalDb;

  public ResultsResource() {
    myLocalDb = new InMemory();
  }

  @POST
  @Timed
  public void addMatchScore(MatchScore matchScore) {
    myLocalDb.addResult(matchScore);
  }

  @DELETE
  @Timed
  public void clearMatchScore(MatchScore matchScore) {
    myLocalDb.clear();
  }

  @GET
  @Timed
  @Path("/{time1}/{time2}")
  public MatchScore matchScore(
    @PathParam("time1") String team1,
    @PathParam("time2") String team2) {
      return myLocalDb.getMatchResult(team1, team2);
  }
}
