package hw5.steps;

import io.cucumber.java.en.Given;

public class GivenStep extends AbstractBaseStep {

    @Given("I open JDI GitHub site")
    public void iOpenIndexPage() {
        indexPage.openIndexPage();
    }

}
