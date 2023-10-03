package pt.example.hexarchapp.archunit;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses( packages = "pt.example.hexarchapp" )
class AdaptersInputEndpointsArchUnitTest {

	@ArchTest
	static final ArchRule endpoints_should_only_reside_on_package_adapters_input_endpoints =
			classes().that().areAnnotatedWith( RestController.class )
					.should().resideInAPackage( "..adapters.input.endpoints" );

	@ArchTest
	static final ArchRule controller_advice_should_only_reside_on_package_adapters_input_handlers =
			classes().that().areAnnotatedWith( ControllerAdvice.class ).or().areAnnotatedWith( RestControllerAdvice.class )
					.should().resideInAPackage( "..adapters.input.endpoints.handlers" );

}
