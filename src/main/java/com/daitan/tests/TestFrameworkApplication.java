package com.daitan.tests;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import com.daitan.tests.resources.ResultsResource;
import com.daitan.tests.resources.TeamsResource;

public class TestFrameworkApplication extends Application<TestFrameworkConfiguration> {
  public static void main(final String[] args) throws Exception {
    new TestFrameworkApplication().run(args);
  }

  @Override
  public String getName() {
    return "Some name";
  }

  @Override
  public void initialize(final Bootstrap<TestFrameworkConfiguration> bootstrap) {
  }

  @Override
  public void run(final TestFrameworkConfiguration configuration,
                  final Environment environment) {
    final TeamsResource teamsResource = new TeamsResource();
    environment.jersey().register(teamsResource);

    final ResultsResource resultsResource = new ResultsResource();
    environment.jersey().register(resultsResource);
  }
}
