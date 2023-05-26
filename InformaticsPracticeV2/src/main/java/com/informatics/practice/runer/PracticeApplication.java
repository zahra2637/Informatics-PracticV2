package com.informatics.practice.runer;
import com.informatics.practice.runer.config.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisReactiveAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;


@SpringBootApplication(exclude = {
		ErrorMvcAutoConfiguration.class,
		RedisAutoConfiguration.class,
		RedisReactiveAutoConfiguration.class,
		RedisRepositoriesAutoConfiguration.class,
		ValidationAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class,
		JtaAutoConfiguration.class,
		UserDetailsServiceAutoConfiguration.class
})
@Import({
		AppConfiguration.class,
		JacksonConfiguration.class,
		WebSecurityConfiguration.class,
		WebConfiguration.class,
		SpringFoxConfig.class,
		MyJpaConfiguration.class


})
@EntityScan("com.informatics.practice.app.repository")
@EnableJpaRepositories(basePackages ="com.informatics.practice.app.repository")
@ComponentScan(basePackages = {"com.informatics.practice"}, excludeFilters = {@ComponentScan.Filter(value = {Configuration.class})})

public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
	}

}
