package com.daitan.tests;

import com.daitan.tests.health.TemplateHealthCheck;
import com.daitan.tests.resources.HelloWorldResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class TestFrameworkApplication extends Application<TestFrameworkConfiguration> {
  public static void main(final String[] args) throws Exception {
    new TestFrameworkApplication().run(args);
  }

  @Override
  public String getName() {
    return "Gustavo";
  }

  @Override
  public void initialize(final Bootstrap<TestFrameworkConfiguration> bootstrap) {
    // TODO: application initialization
  }

  @Override
  public void run(final TestFrameworkConfiguration configuration,
                  final Environment environment) {
    final HelloWorldResource resource = new HelloWorldResource(
      configuration.getTemplate(),
      configuration.getDefaultName()
    );
    final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
    environment.healthChecks().register("template", healthCheck);
    environment.jersey().register(resource);
  }
}
