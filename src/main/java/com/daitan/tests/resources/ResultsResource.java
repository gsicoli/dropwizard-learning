package com.daitan.tests.resources;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
  public Response addMatchScore(MatchScore matchScore) {
    if (myLocalDb.addResult(matchScore)) {
      return Response.ok().build();
    } else {
      return Response.status(Response.Status.CONFLICT).build();
    }
  }

  @PUT
  @Timed
  public Response updateMatchScore(MatchScore matchScore) {
    if (myLocalDb.updateResult(matchScore)) {
      return Response.ok().build();
    } else {
      return Response.status(Response.Status.NOT_FOUND).build();
    }
  }

  @DELETE
  @Timed
  public Response clearMatchScore(MatchScore matchScore) {
    myLocalDb.clear();
    return Response.ok().build();
  }

  @GET
  @Timed
  @Path("/{time1}/{time2}")
  public Response matchScore(
    @PathParam("time1") String team1,
    @PathParam("time2") String team2) {
    MatchScore score = myLocalDb.getMatchResult(team1, team2);
    if (score == null) {
      return Response.status(Response.Status.NOT_FOUND).build();
    }
    return Response.ok(score).build();
  }
}
