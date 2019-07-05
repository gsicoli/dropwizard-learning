package com.daitan.tests.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {
  private long id;
  private String brand;
  private String model;
  private String year;

  public Car() {
    // Jackson deserialization
  }

  public Car(long id, String brand, String model, String year) {
    this.id = id;
    this.brand = brand;
    this.model = model;
    this.year = year;
  }

  public void setId(long id) {
    this.id = id;
  }

  @JsonProperty
  public long getId() {
    return id;
  }

  @JsonProperty
  public String getYear() {
    return year;
  }

  @JsonProperty
  public String getModel() {
    return model;
  }

  @JsonProperty
  public String getBrand() {
    return brand;
  }
}
