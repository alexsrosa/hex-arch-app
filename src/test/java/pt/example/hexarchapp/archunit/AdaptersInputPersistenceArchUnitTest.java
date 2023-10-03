package pt.example.hexarchapp.archunit;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.stereotype.Repository;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses( packages = "pt.example.hexarchapp" )
class AdaptersInputPersistenceArchUnitTest {

	@ArchTest
	static final ArchRule entities_should_only_reside_on_package_adapters_output_persistence_data =
			classes().that().areAnnotatedWith( Entity.class ).or().areAnnotatedWith( Table.class )
					.should().resideInAPackage( "..adapters.output.persistence.data.." );

	@ArchTest
	static final ArchRule entities_should_only_ends_with_name_data =
			classes().that().areAnnotatedWith( Entity.class ).or().areAnnotatedWith( Table.class )
					.should().haveSimpleNameEndingWith( "Data" );

	@ArchTest
	static final ArchRule repositories_should_only_reside_on_package_adapters_output_persistence =
			classes().that().areAnnotatedWith( Repository.class )
					.should().resideInAPackage( "..adapters.output.persistence.." );

	@ArchTest
	static final ArchRule repositories_should_only_ends_with_name_jpa_repository =
			classes().that().areAnnotatedWith( Repository.class )
					.should().haveSimpleNameEndingWith( "JPARepository" );

}
