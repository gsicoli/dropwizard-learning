package com.allianza.tests;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class GustavoApplication extends Application<GustavoConfiguration> {

    public static void main(final String[] args) throws Exception {
        new GustavoApplication().run(args);
    }

    @Override
    public String getName() {
        return "Gustavo";
    }

    @Override
    public void initialize(final Bootstrap<GustavoConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final GustavoConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
