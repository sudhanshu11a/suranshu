/**
 * 
 */
package com.sudhanshu.work.suranshu.blogs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author sudhanshusharma
 *
 */
@Configuration
public class CorsConfiguration {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200", "http://kakia.info",
						"http://www.kakia.info", "http://d3tpknx1bgxd1j.cloudfront.net", "http://www.kakia.xyz");
			}
		};
	}
}