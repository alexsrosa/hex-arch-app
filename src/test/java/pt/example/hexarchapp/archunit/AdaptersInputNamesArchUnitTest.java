package pt.example.hexarchapp.archunit;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses( packages = "pt.example.hexarchapp" )
class AdaptersInputNamesArchUnitTest {

	@ArchTest
	static final ArchRule endpoints_should_only_ends_with_name_endpoint_and_reside_endpoints =
			classes().that().areAnnotatedWith( RestController.class )
					.should().haveSimpleNameEndingWith( "Endpoint" )
					.andShould().resideInAPackage( "..adapters.input.endpoints" );

	@ArchTest
	static final ArchRule controller_advice_should_only_ends_with_name_exception_handler =
			classes().that().areAnnotatedWith( ControllerAdvice.class ).or().areAnnotatedWith( RestControllerAdvice.class )
					.should().haveSimpleNameEndingWith( "ExceptionHandler" )
					.andShould().resideInAPackage( "..adapters.input.endpoints.handlers" );

}
