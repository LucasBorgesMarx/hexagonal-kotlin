package com.devdeolho.hexagonal.architecture

import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes

@AnalyzeClasses(packages = ["com.devdeolho.hexagonal"])
class NamingConventionTest {
    @ArchTest
    val `consumer reside only consumer package` = classes()
        .that()
        .haveNameMatching(".*Consumer")
        .should()
        .resideInAnyPackage("..adapters.in.consumer")
        .`as`("Consumer classes should reside in consumer package in adapters.in package")

    @ArchTest
    val `message reside only message package` = classes()
        .that()
        .haveNameMatching(".*Message")
        .should()
        .resideInAnyPackage("..adapters.in.consumer.message")
        .`as`("Message classes should reside in message package in consumer package")

    val `controller reside only controller package` = classes()
        .that()
        .haveNameMatching(".*Controller")
        .should()
        .resideInAnyPackage("..adapters.in.controller")
        .`as`("Controller classes should reside in controller package in adapters.in package")

    val `request reside only request package` = classes()
        .that()
        .haveNameMatching(".*Request")
        .should()
        .resideInAnyPackage("..adapters.in.controller.request", "..adapters.out.client.request")
        .`as`("Request classes should reside inside request package in controller or client package")

    @ArchTest
    val `response reside only response packge` = classes()
        .that()
        .haveNameMatching(".*Response")
        .should()
        .resideInAnyPackage("..adapters.in.controller.response", "..adapters.out.client.response")
        .`as`("Response classes should reside inside response package in controller or client package")

    @ArchTest
    val `adapter reside only adapter package` = classes()
        .that()
        .haveNameMatching(".*Adapter")
        .should()
        .resideInAnyPackage("..adapters.out")
        .`as`("Adapter classes should reside inside out package in adapters package")

    @ArchTest
    val `client reside only client package` = classes()
        .that()
        .haveNameMatching(".*Client")
        .should()
        .resideInAnyPackage("..adapters.out.client")
        .`as`("Client classes should reside inside config package")

    @ArchTest
    val `repository reside only rerository package` = classes()
        .that()
        .haveNameMatching(".*Repository")
        .should()
        .resideInAnyPackage("..adapters.out.repository")
        .`as`("Repository classes should reside inside repository in adapters.out package")

    @ArchTest
    val `entity reside only entity package` = classes()
        .that()
        .haveNameMatching(".*Entity")
        .should()
        .resideInAnyPackage("..adapters.out.repository.entity")
        .`as`("Entity classes should reside inside entity package in entity package")

    @ArchTest
    val `usecase reside only usecase package` = classes()
        .that()
        .haveNameMatching(".*UseCase")
        .should()
        .resideInAnyPackage("..application.core.usecase")
        .`as`("UseCase classes should reside inside usecase package in core package")

    @ArchTest
    val `input reside only input package` = classes()
        .that()
        .haveNameMatching(".*InputPort")
        .should()
        .resideInAnyPackage("..application.ports.in")
        .`as`("InputPort should reside inside input port package in ports.in package")

    @ArchTest
    val `output reside only output package` = classes()
        .that()
        .haveNameMatching(".*OutputPort")
        .should()
        .resideInAnyPackage("..application.ports.out")
        .`as`("OutputPort should reside inside output ports.out package in application package")

    @ArchTest
    val `config reside only config package` = classes()
        .that()
        .haveNameMatching(".*Config")
        .should()
        .resideInAnyPackage("..hexagonal.config")
        .`as`("Config classes should reside inside config package in hexagonal package")

    @ArchTest
    val `should be suffixed consumer` = classes()
        .that()
        .resideInAPackage("..consumer")
        .should()
        .haveSimpleNameEndingWith("Consumer")

    @ArchTest
    val `should be suffixed message` = classes()
        .that()
        .resideInAPackage("..message")
        .should()
        .haveSimpleNameEndingWith("Message")

    @ArchTest
    val `should be suffixed controller` = classes()
        .that()
        .resideInAPackage("..controller")
        .should()
        .haveSimpleNameEndingWith("Controller")

    @ArchTest
    val `should be suffixed request` = classes()
        .that()
        .resideInAPackage("..request")
        .should()
        .haveSimpleNameEndingWith("Request")

    @ArchTest
    val `should be suffixed response` = classes()
        .that()
        .resideInAPackage("..response")
        .should()
        .haveNameMatching(".*Response.*")

    @ArchTest
    val `should be suffixed client` = classes()
        .that()
        .resideInAPackage("..client")
        .should()
        .haveSimpleNameEndingWith("Client")

    @ArchTest
    val `should be suffixed repository` = classes()
        .that()
        .resideInAPackage("..repository")
        .should()
        .haveSimpleNameEndingWith("Repository")

    @ArchTest
    val `should be suffixed entity` = classes()
        .that()
        .resideInAPackage("..entity")
        .should()
        .haveSimpleNameEndingWith("Entity")

    @ArchTest
    val `should be suffixed adapter` = classes()
        .that()
        .resideInAPackage("..adapters.out")
        .should()
        .haveSimpleNameEndingWith("Adapter")

    @ArchTest
    val `should be suffixed usecase` = classes()
        .that()
        .resideInAPackage("..usecase")
        .should()
        .haveSimpleNameEndingWith("UseCase")

    @ArchTest
    val `should be suffixed input port` = classes()
        .that()
        .resideInAPackage("..ports.in")
        .should()
        .haveSimpleNameEndingWith("InputPort")

    @ArchTest
    val `should be suffixed output port` = classes()
        .that()
        .resideInAPackage("..ports.out")
        .should()
        .haveSimpleNameEndingWith("OutputPort")

    @ArchTest
    val `should be suffixed config` = classes()
        .that()
        .resideInAPackage("..config")
        .should()
        .haveSimpleNameEndingWith("Config")
}