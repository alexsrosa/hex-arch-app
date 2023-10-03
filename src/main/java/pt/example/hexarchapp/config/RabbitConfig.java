package pt.example.hexarchapp.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pt.example.hexarchapp.adapters.input.listeners.data.TransactionsMessage;
import pt.example.hexarchapp.adapters.output.producers.data.PersonMessage;

@Configuration
@EnableRabbit
public class RabbitConfig {

	@Value( "${spring.rabbitmq.host}" )
	public String host;

	@Value( "${spring.rabbitmq.port}" )
	public int port;

	@Value( "${spring.rabbitmq.username}" )
	public String username;

	@Value( "${spring.rabbitmq.password}" )
	public String password;

	@Bean
	public CachingConnectionFactory cachingConnectionFactory() {
		CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory( host, port );
		cachingConnectionFactory.setUsername( username );
		cachingConnectionFactory.setPassword( password );
		return cachingConnectionFactory;
	}

	@Bean
	public AmqpAdmin configChannels( CachingConnectionFactory cachingConnectionFactory ) {
		ConnectionFactory publisherConnectionFactory = cachingConnectionFactory.getPublisherConnectionFactory();
		assert publisherConnectionFactory != null;
		AmqpAdmin amqpAdmin = new RabbitAdmin( publisherConnectionFactory );
		amqpAdmin.declareQueue( new Queue( TransactionsMessage.QUEUE_NAME ) );
		amqpAdmin.declareQueue( new Queue( PersonMessage.QUEUE_NAME ) );
		return amqpAdmin;
	}
}
