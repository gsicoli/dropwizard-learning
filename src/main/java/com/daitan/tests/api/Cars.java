package com.daitan.tests.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cars {
  private Object[] cars;

  public Cars() {
    // Jackson deserialization
  }

  public Cars(Object[] cars) {
    this.cars = cars;
  }

  @JsonProperty
  public Object[] getCars() {
    return cars;
  }
}
