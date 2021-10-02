package autprodutos;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin ={"pretty" , "html:target/log.html"},
		features = "src/test/resources/features/", 
		glue = "com.autprodutos.steps",
		tags = "@Cadastrar1",
		monochrome = true
		)
public class Runner {

}
