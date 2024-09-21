package co.com.serenity.project.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

import static co.com.serenity.project.ui.HomeUI.BTN_ELEMENTS;
import static co.com.serenity.project.ui.HomeUI.BTN_LIST_ELEMENTS;
import static co.com.serenity.project.utils.Constans.REMEMBER_TEXT_BTN_SUB_ELEMENTS;

@AllArgsConstructor

public class ChooseSubElementsRandomTask implements Task {
    private String numberRandomBtn;

    @Override
    @Step("{0} Selecciona aleatoriamente la posicion #numberRandomBtn de la subfuncion de elementos")
    public <T extends Actor> void performAs(T actor) {
        String number = numberRandomBtn;
        actor.attemptsTo(Scroll.to(BTN_ELEMENTS), Click.on(BTN_LIST_ELEMENTS.of(number)));

        String textBtn = BTN_LIST_ELEMENTS.of(number).resolveFor(actor).getText();
        actor.remember(REMEMBER_TEXT_BTN_SUB_ELEMENTS, textBtn);
    }

    public static ChooseSubElementsRandomTask witchParams(String numberRandomBtn) {
        return Tasks.instrumented(ChooseSubElementsRandomTask.class, numberRandomBtn);
    }
}
