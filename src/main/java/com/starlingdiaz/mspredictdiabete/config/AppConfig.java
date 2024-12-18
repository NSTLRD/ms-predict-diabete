/**
 * @author Starling Diaz on 12/18/2024.
 * @Github https://github.com/NSTLRD
 * @Website https://mentorly.blog/
 * @Academy https://www.mentor-ly.com/
 * @version ms-predict-diabete 1.0
 * @since 12/18/2024.
 */

package com.starlingdiaz.mspredictdiabete.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}