package co.com.serenity.project.questions;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import static co.com.serenity.project.ui.HomeUI.TXT_RANDOM_NAME_BTN;


@AllArgsConstructor //Acorta el código para generar constructores
@Slf4j //Nos ayuda para usar las funciones del log
public class ValidateElementsTextBtn implements Question <Boolean> {

    private String validateTextSubElementBtn;

    @Override
    @Subject("{0} se realiza validacion del elemento capturado en el header con el parametro #validateTextSubElementBtn")
    public Boolean answeredBy(Actor actor) {
        boolean result;             //Texto a validar
        String validTextBtnHeader = TXT_RANDOM_NAME_BTN.resolveFor(actor).getText();
        if (validTextBtnHeader != null && validateTextSubElementBtn.equals(validTextBtnHeader)) {
            log.info(validTextBtnHeader);
            result = true;
        }else {
            result = false;
        }
        return result;
    }
    public static ValidateElementsTextBtn withParams(String validateTextSubElementBtn) {
        return new ValidateElementsTextBtn(validateTextSubElementBtn);
    }
}
