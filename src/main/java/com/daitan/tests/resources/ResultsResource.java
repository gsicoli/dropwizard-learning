package com.daitan.tests.resources;

import com.codahale.metrics.annotation.Timed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.daitan.tests.api.Results;

@Path("/v1/resultados")
@Produces(MediaType.APPLICATION_JSON)
public class ResultsResource {
  public ResultsResource() {
  }

  @GET
  @Timed
  @Path("/{time1}/{time2}")
  public Results matchScore(
    @PathParam("time1") String team1,
    @PathParam("time2") String team2) {
      Results result = new Results(team1, team2);
      return result;
  }
}
