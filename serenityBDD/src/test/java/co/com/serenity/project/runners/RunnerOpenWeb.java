package co.com.serenity.project.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/openweb.feature",
        glue = "co.com.serenity.project.stepdefinition",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@successful"

)

public class RunnerOpenWeb {

}
