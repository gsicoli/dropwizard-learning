package com.daitan.tests.resources;

import com.codahale.metrics.annotation.Timed;
import io.dropwizard.jersey.params.IntParam;
import java.lang.Math;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1/times")
@Produces(MediaType.APPLICATION_JSON)
public class TeamsResource {
  private final String[] times = {
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

  public TeamsResource() {}

  @GET
  @Timed
  public Response getTimes(
    @QueryParam("offset") @DefaultValue("-1") IntParam _offset,
    @QueryParam("limit") @DefaultValue("-1") IntParam _limit) {

    int offset = _offset.get();
    int limit = _limit.get();

    if (offset == -1 || limit == -1) {
      offset = offset == -1 ? 0 : offset;
      limit = limit == -1 ? 10 : limit;
    }

    int arraySize = Math.min(limit, (times.length-offset));
    String[] timesPag = new String[arraySize];
    for (int i = 0; i < limit && (i + offset) < times.length; i++) {
      timesPag[i] = times[i + offset];
    }

    return Response.ok(timesPag).build();
  }
}
