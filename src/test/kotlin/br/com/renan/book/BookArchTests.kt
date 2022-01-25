package br.com.renan.book

import com.tngtech.archunit.core.domain.JavaClasses
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.ArchRule
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition
import com.tngtech.archunit.library.Architectures

@AnalyzeClasses(
    packages = ["br.com.renan.book"],
)
class BookArchTests {

    @ArchTest
    fun checkLayeredApplication(importedClasses: JavaClasses) {
        val layeredArch = Architectures
            .layeredArchitecture()
            .layer("Domain")
            .definedBy("br.com.renan.book.domain")
            .layer("Repository")
            .definedBy("br.com.renan.book.repository")
            .layer("Service")
            .definedBy("br.com.renan.book.service")
            .layer("Resource")
            .definedBy("br.com.renan.book.resource")
            .layer("Config")
            .definedBy("br.com.renan.book.config")


        val rule: ArchRule = layeredArch
            .whereLayer("Repository").mayOnlyBeAccessedByLayers("Service", "Config")

        rule.check(importedClasses)
    }

    @ArchTest
    fun repositoryOnlyHaveDependentInResourceOrRepository(importedClasses: JavaClasses) {
        val rule: ArchRule = ArchRuleDefinition.classes()
            .that().resideInAPackage("..repository..")
            .should().onlyHaveDependentClassesThat().resideInAnyPackage("..repository..", "..service..")
    }
}