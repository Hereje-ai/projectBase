package co.com.serenity.project.stepdefinition.hook;

import co.com.serenity.project.hook.OpenWeb;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import org.hamcrest.Matchers;
import org.junit.Before;

import static co.com.serenity.project.utils.Constans.*;
import static co.com.serenity.project.utils.Time.waiting;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Hook {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{string} abre el sitio web de pruebas")
    public void abreElSitioWebDePruebas(String actor) {
        OnStage.theActorCalled(actor).attemptsTo(
                OpenWeb.browserURL(WEB_URL)
        );
        waiting(TIME_SHORT);
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        TheWebPage.title(),
                        Matchers.containsString(TITLE)
                )
        );
    }

}
