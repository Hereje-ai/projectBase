package co.com.serenity.project.stepdefinition;

import co.com.serenity.project.questions.ValidateElementsTextBtn;
import co.com.serenity.project.tasks.ChooseSubElementsRandomTask;
import co.com.serenity.project.tasks.FunctionsElementsTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.actors.OnStage;

import static co.com.serenity.project.utils.Constans.ACTOR;
import static co.com.serenity.project.utils.Constans.REMEMBER_TEXT_BTN_SUB_ELEMENTS;
import static co.com.serenity.project.utils.DataFaker.fakerNumberOneAndNine;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

@Slf4j
public class OpenWebStep {


    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @And("desea validar la funcion de la carta de elementos")
    public void deseaValidarLaFuncionDeLaCartaDeElementos() {
        OnStage.theActorCalled(ACTOR).attemptsTo(FunctionsElementsTask.choose());
    }

    @When("selecciona aleatoriamente alguna de las subfunciones")
    public void seleccionaAleatoriamenteAlgunaDeLasSubfunciones() {
        OnStage.theActorCalled(ACTOR).attemptsTo(ChooseSubElementsRandomTask.witchParams(fakerNumberOneAndNine()));
    }

    @Then("visualizara en la cabecera el nombre de la opcion elegida")
    public void visualizaraEnLaCabeceraElNombreDeLaOpcionElegida() {
        String validateText = OnStage.theActor(ACTOR).recall(REMEMBER_TEXT_BTN_SUB_ELEMENTS);
        if (validateText != null) {
            log.info(validateText);
        }
        theActorInTheSpotlight().should(seeThat(ValidateElementsTextBtn.withParams(validateText)));
    }
}

