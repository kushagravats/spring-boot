package org.springframework.boot.actuate.autoconfigure.beans;

import org.springframework.boot.actuate.beans.BeansEndpoint;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnAvailableEndpoint;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * {@link AutoConfiguration} for the {@link BeansEndpoint}.
 * This configuration class ensures that the BeansEndpoint is only configured when
 * it is available and not already defined in the application context.
 *
 * @author Phillip Webb
 * @since 2.0.0
 */
@AutoConfiguration // This replaces @EnableAutoConfiguration if it was used
@ConditionalOnAvailableEndpoint(endpoint = BeansEndpoint.class)
public class BeansEndpointAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public BeansEndpoint beansEndpoint(ConfigurableApplicationContext applicationContext) {
        return new BeansEndpoint(applicationContext);
    }

}
