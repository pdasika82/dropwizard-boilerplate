package net.snet.base.resources;

import com.yammer.metrics.annotation.Timed;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path("/base")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BaseResource {
  private static final Logger LOGGER = LoggerFactory.getLogger(BaseResource.class);

  public BaseResource() {
  }

  @GET
  @Timed(name="get-requests")
  public Map<String, Object> status() {
    LOGGER.debug("status called");
    Map<String, Object> status = new HashMap<String, Object>();
    status.put("timestamp", new DateTime());
    return status;
  }


}
