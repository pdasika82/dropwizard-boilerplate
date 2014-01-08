package net.snet.base;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.jdbi.DBIFactory;
import net.snet.base.resources.BaseResource;
import org.skife.jdbi.v2.DBI;

public class BaseService extends Service<BaseConfiguration> {
  public static void main(String[] args) throws Exception {
    new BaseService().run(args);
  }

  @Override
  public void initialize(Bootstrap<BaseConfiguration> bootstrap) {
    bootstrap.setName("base-service");
  }

  @Override
  public void run(BaseConfiguration configuration, Environment environment) throws ClassNotFoundException {
		final DBIFactory dbiFactory = new DBIFactory();
		final DBI dbi = dbiFactory.build(environment, configuration.getDatabaseConfiguration(), "postgresql");
	  if (configuration.getJsonPrettyPrint()) {
		  environment.getObjectMapperFactory().enable(SerializationFeature.INDENT_OUTPUT);
	  }

		environment.addResource(new BaseResource());
  }

}
