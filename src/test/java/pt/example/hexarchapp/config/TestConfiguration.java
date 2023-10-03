package pt.example.hexarchapp.config;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@ComponentScan( basePackages = { "pt.example.hexarchapp" } )
@Configuration
public class TestConfiguration {

	@MockBean private RabbitTemplate rabbitTemplate;

}
