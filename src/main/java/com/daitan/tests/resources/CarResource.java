package com.daitan.tests.resources;

import com.daitan.tests.api.Id;
import com.daitan.tests.api.Car;
import com.daitan.tests.api.Cars;
import com.codahale.metrics.annotation.Timed;

import io.dropwizard.jersey.params.IntParam;

import java.util.concurrent.atomic.AtomicLong;
import java.util.ArrayList;
import java.util.HashMap;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.core.MediaType;

@Path("/v1/cars")
@Produces(MediaType.APPLICATION_JSON)
public class CarResource {
  private static HashMap<Long, Car> carsDb = new HashMap<Long, Car>();
  private final AtomicLong counter;

  public CarResource() {
    this.counter = new AtomicLong();
  }

  @POST
  @Timed
  public Id addCar(Car car) {
    final long id = counter.incrementAndGet();
    System.out.println("Adding " + car.getBrand() + " - " + car.getModel());
    car.setId(id);
    carsDb.put(id, car);
    return new Id(id);
  }

  @GET
  @Timed
  public Cars getCars(
    @QueryParam("offset") @DefaultValue("-1") IntParam _offset,
    @QueryParam("limit") @DefaultValue("-1") IntParam _limit) {

    int offset = _offset.get();
    int limit = _limit.get();

    if (offset == -1 || limit == -1) {
      offset = offset == -1 ? 0 : offset;
      limit = limit == -1 ? 10 : limit;
    }

    Object[] carsArray = carsDb.values().toArray();
    ArrayList<Car> carsPag = new ArrayList<Car>();
    for (int i = offset; i < (offset + limit) && i < carsArray.length; i++) {
      carsPag.add((Car) carsArray[i]);
    }

    return new Cars(carsPag.toArray());
  }

  @DELETE
  @Timed
  @Path("/{id}")
  public void removeCar(@PathParam("id") long id) {
    carsDb.remove(id);
  }
}
