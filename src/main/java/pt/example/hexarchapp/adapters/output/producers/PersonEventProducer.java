package pt.example.hexarchapp.adapters.output.producers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import pt.example.hexarchapp.adapters.output.producers.data.PersonMessage;
import pt.example.hexarchapp.adapters.output.producers.mappers.PersonMessageMapper;
import pt.example.hexarchapp.domain.model.Person;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Component
public class PersonEventProducer {

	private final RabbitTemplate rabbitTemplate;

	private final PersonMessageMapper personMessageMapper;

	public void sends( Person person ) {
		log.info( "Send Person".concat( person.toString() ) );

		Message<PersonMessage> message = MessageBuilder.createMessage( personMessageMapper.toMessage( person ),
				new MessageHeaders( Map.of( "origin", "Hex-App" ) ) );

		rabbitTemplate.convertAndSend( PersonMessage.QUEUE_NAME, message );
	}
}
