package pt.example.hexarchapp.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@ComponentScan( basePackages = { "pt.example.hexarchapp" } )
@Configuration
public class TestConfiguration {

}
