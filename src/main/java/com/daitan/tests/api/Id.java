package com.daitan.tests.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Id {
  private long id;

  public Id() {
    // Jackson deserialization
  }

  public Id(long id) {
    this.id = id;
  }

  @JsonProperty
  public long getId() {
    return id;
  }
}
