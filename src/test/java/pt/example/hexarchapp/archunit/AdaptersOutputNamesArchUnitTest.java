package pt.example.hexarchapp.archunit;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.stereotype.Repository;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses( packages = "pt.example.hexarchapp" )
class AdaptersOutputNamesArchUnitTest {

	@ArchTest
	static final ArchRule output_adapter_should_only_ends_with_name_and_reside_in_output_adapter =
			classes().that().haveSimpleNameEndingWith( "OutputAdapter" )
					.should().resideInAPackage( "..adapters.output" );

	@ArchTest
	static final ArchRule event_producer_should_only_ends_with_name_and_reside_in_producers =
			classes().that().haveSimpleNameEndingWith( "EventProducer" )
					.should().resideInAPackage( "..adapters.output.producers" );

}
