package pt.example.hexarchapp.archunit;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses( packages = "pt.example.hexarchapp" )
class DependenciesChecksArchUnitTests {

	@ArchTest
	static final ArchRule no_classes_reside_in_application_depend_classes_in_adapters =
			noClasses().that().resideInAPackage( "..application.." )
					.should().dependOnClassesThat().resideInAPackage( "..adapters.." );

	@ArchTest
	static final ArchRule no_classes_reside_in_application_depend_classes_in_config =
			noClasses().that().resideInAPackage( "..application.." )
					.should().dependOnClassesThat().resideInAPackage( "..config.." );

	@ArchTest
	static final ArchRule no_classes_reside_in_domain_depend_classes_in_application =
			noClasses().that().resideInAPackage( "..domain.." )
					.should().dependOnClassesThat().resideInAPackage( "..application.." );

	@ArchTest
	static final ArchRule no_classes_reside_in_domain_depend_classes_in_adapters =
			noClasses().that().resideInAPackage( "..domain.." )
					.should().dependOnClassesThat().resideInAPackage( "..adapters.." );

	@ArchTest
	static final ArchRule no_classes_reside_in_domain_depend_classes_in_config =
			noClasses().that().resideInAPackage( "..domain.." )
					.should().dependOnClassesThat().resideInAPackage( "..config.." );

}
