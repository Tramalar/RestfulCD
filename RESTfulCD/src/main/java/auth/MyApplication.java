package auth;
import javax.annotation.Priority;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
 
/**
 * Simple application startup.
 *
 * @author Deisss (MIT License)
*/
@Priority(1)
public class MyApplication extends ResourceConfig {
    public MyApplication() {
        register(RolesAllowedDynamicFeature.class);
    }
}