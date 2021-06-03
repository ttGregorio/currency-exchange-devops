package br.com.nex2you.api.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import br.com.nex2you.api.HelloWorld;

public class HelloWorldSteps {

    private HelloWorld helloWorld = new HelloWorld();


    private String name = "";

    private String output = "";

    @Given("^A String name (.*)$")
    public void givenInput(String name) {
        this.name = name;
    }
    @When("^sayHello method of HelloWorld.java is called$")
    public void whenBusinessLogicCalled() {
        output = helloWorld.sayHello(name);
    }
    @Then("^It should return (.*)$")
    public void thenCheckOutput(String response) {
        Assert.assertEquals(output, response);
    }


    public static void main(String[] args) {
    }
}
