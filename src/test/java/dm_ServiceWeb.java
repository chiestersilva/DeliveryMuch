import static com.jayway.restassured.RestAssured.given;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;

import java.io.File;
import java.util.List;

import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//Ordenar os testes com Junit
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class dm_ServiceWeb {

    String extenso;
    static ExtentTest test;
    static ExtentReports report;

    @BeforeClass
    public static void bas(){
        baseURI = "http://challengeqa.staging.devmuch.io";
    }

    @BeforeClass
    public static void startTest() {
        report = new ExtentReports(System.getProperty("user.dir") + "\\DM_Test.html", true);
        report.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));

    }

    @Test
    public void CT01_Valor_DezMil() {

        test = report.startTest("CT01_Valor_DezMil");

        System.out.println("#### CT01 - Validar Dez Mil ####\n");

        Response response = when().get("/10000");

        if (response.getStatusCode() == 400 && response.body().prettyPrint().contains("\"extenso\": \"Invalid data\"") ){
                    test.log(LogStatus.PASS, "Retorno", response.jsonPath().getString("$"));
                    test.log(LogStatus.INFO, "Status Code", "400");
                    test.assignAuthor("Chiester Silva");
                    test.assignCategory("Api");
        } else {
            test.log(LogStatus.FAIL, "Falha ao Chamar a Api", response.getBody().prettyPrint());
            test.log(LogStatus.FAIL, "Status Code", String.valueOf(response.getStatusCode()));
        }
    }

    @Test
    public void CT02_Valor_MenosDezMil() {

        test = report.startTest("CT02_MenosValor_DezMil");

        System.out.println("#### CT02 - Validar Menos Dez Mil ####\n");

        Response response = when().get("/-10000");

        if (response.getStatusCode() == 400 && response.body().prettyPrint().contains("\"extenso\": \"Invalid data\"") ){
            test.log(LogStatus.PASS, "Retorno", response.jsonPath().getString("$"));
            test.log(LogStatus.INFO, "Status Code", "400");
            test.assignAuthor("Chiester Silva");
            test.assignCategory("Api");
        } else {
            test.log(LogStatus.FAIL, "Falha ao Chamar a Api", response.getBody().prettyPrint());
            test.log(LogStatus.FAIL, "Status Code", String.valueOf(response.getStatusCode()));
        }
    }

    @Test
    public void CT03_Valor_NoveMilNovecentoseNoventaeNove() {

        test = report.startTest("CT03_Valor_NoveMilNovecentoseNoventaeNove");

        System.out.println("#### CT03 - Validar Nove Mil Novecentos e Noventa e Nove ####\n");

        Response response = when().get("/9999");

        if (response.getStatusCode() == 200 && response.body().prettyPrint().contains("\"extenso\": \"nove mil novecentos e noventa e nove\"") ){
            test.log(LogStatus.PASS, "Retorno", response.jsonPath().getString("$"));
            test.log(LogStatus.PASS, "Status Code", String.valueOf(response.getStatusCode()));
            test.assignAuthor("Chiester Silva");
            test.assignCategory("Api");
        } else {
            test.log(LogStatus.FAIL, "Falha ao Chamar a Api", response.getBody().prettyPrint());
            test.log(LogStatus.FAIL, "Status Code", String.valueOf(response.getStatusCode()));
        }
    }

    @Test
    public void CT04_Valor_MenosNoveMilNovecentoseNoventaeNove() {

        test = report.startTest("CT04_Valor_MenosNoveMilNovecentoseNoventaeNove");

        System.out.println("#### CT04 - Validar Menos Nove Mil Novecentos e Noventa e Nove ####\n");

        Response response = when().get("/-9999");

        if (response.getStatusCode() == 200 && response.body().prettyPrint().contains("\"extenso\": \"menos nove mil novecentos e noventa e nove\"") ){
            test.log(LogStatus.PASS, "Retorno", response.jsonPath().getString("$"));
            test.log(LogStatus.PASS, "Status Code", String.valueOf(response.getStatusCode()));
            test.assignAuthor("Chiester Silva");
            test.assignCategory("Api");
        } else {
            test.log(LogStatus.FAIL, "Falha ao Chamar a Api", response.getBody().prettyPrint());
            test.log(LogStatus.FAIL, "Status Code", String.valueOf(response.getStatusCode()));
        }
    }

    @Test
    public void CT05_Valor_Dez() {

        test = report.startTest("CT05_Valor_Dez");

        System.out.println("#### CT05 - Validar Dez####\n");

        Response response = when().get("/10");

        if (response.getStatusCode() == 200 && response.body().prettyPrint().contains("\"extenso\": \"dez\"") ){
            test.log(LogStatus.PASS, "Retorno", response.jsonPath().getString("$"));
            test.log(LogStatus.PASS, "Status Code", String.valueOf(response.getStatusCode()));
            test.assignAuthor("Chiester Silva");
            test.assignCategory("Api");
        } else {
            test.log(LogStatus.FAIL, "Falha ao Chamar a Api", response.getBody().prettyPrint());
            test.log(LogStatus.FAIL, "Status Code", String.valueOf(response.getStatusCode()));
        }
    }

    @Test
    public void CT06_Valor_NoveMilNovecentoseNoventaeNoveEnglis() {

        test = report.startTest("CT06_Valor_NoveMilNovecentoseNoventaeNove");

        System.out.println("#### CT06 - Validar Nove Mil Novecentos e Noventa e Nove ####\n");

        Response response = when().get("/en/9999");

        if (response.getStatusCode() == 200 && response.body().prettyPrint().contains("\"extenso\": \"nine thousand, nine hundred and ninety-nine\"") ){
            test.log(LogStatus.PASS, "Retorno", response.jsonPath().getString("$"));
            test.log(LogStatus.PASS, "Status Code", String.valueOf(response.getStatusCode()));
            test.assignAuthor("Chiester Silva");
            test.assignCategory("Api");
        } else {
            test.log(LogStatus.FAIL, "Falha ao Chamar a Api", response.getBody().prettyPrint());
            test.log(LogStatus.FAIL, "Status Code", String.valueOf(response.getStatusCode()));
        }
    }

    @Test
    public void CT07_Valor_MenosNoveMilNovecentoseNoventaeNoveEnglis() {

        test = report.startTest("CT07_Valor_MenosNoveMilNovecentoseNoventaeNove");

        System.out.println("#### CT07 - Validar Menos Nove Mil Novecentos e Noventa e Nove ####\n");

        Response response = when().get("/en/-9999");

        if (response.getStatusCode() == 200 && response.body().prettyPrint().contains("\"extenso\": \"minus nine thousand, nine hundred and ninety-nine\"") ){
            test.log(LogStatus.PASS, "Retorno", response.jsonPath().getString("$"));
            test.log(LogStatus.PASS, "Status Code", String.valueOf(response.getStatusCode()));
            test.assignAuthor("Chiester Silva");
            test.assignCategory("Api");
        } else {
            test.log(LogStatus.FAIL, "Falha ao Chamar a Api", response.getBody().prettyPrint());
            test.log(LogStatus.FAIL, "Status Code", String.valueOf(response.getStatusCode()));
        }
    }

    @Test
    public void CT08_Valor_DezMilEnglis() {

        test = report.startTest("CT08_Valor_DezMil");

        System.out.println("#### CT08 - Validar Dez Mil ####\n");

        Response response = when().get("/en/10000");

        if (response.getStatusCode() == 400 && response.body().prettyPrint().contains("\"extenso\": \"ten thousand\"") ){
            test.log(LogStatus.PASS, "Retorno", response.jsonPath().getString("$"));
            test.log(LogStatus.PASS, "Status Code", String.valueOf(response.getStatusCode()));
            test.assignAuthor("Chiester Silva");
            test.assignCategory("Api");
        } else {
            test.log(LogStatus.FAIL, "Falha ao Chamar a Api", response.getBody().prettyPrint());
            test.log(LogStatus.FAIL, "Status Code", String.valueOf(response.getStatusCode()));
        }
    }

    @Test
    public void CT09_Valor_MenosDezMilEnglish() {

        test = report.startTest("CT09_MenosValor_DezMil");

        System.out.println("#### CT09 - Validar Menos Dez Mil ####\n");

        Response response = when().get("/en/-10000");

        if (response.getStatusCode() == 400 && response.body().prettyPrint().contains("\"extenso\": \"minus ten thousand\"") ){
            test.log(LogStatus.PASS, "Retorno", response.jsonPath().getString("$"));
            test.log(LogStatus.PASS, "Status Code", String.valueOf(response.getStatusCode()));
            test.assignAuthor("Chiester Silva");
            test.assignCategory("Api");
        } else {
            test.log(LogStatus.FAIL, "Falha ao Chamar a Api", response.getBody().prettyPrint());
            test.log(LogStatus.FAIL, "Status Code", String.valueOf(response.getStatusCode()));
        }
    }

    @Test
    public void CT10_Valor_QuinhentosEnglis() {

        test = report.startTest("CT10_Valor_Quinhentos");

        System.out.println("#### CT10 - Validar Quinhentos ####\n");

        Response response = when().get("/en/500");

        if (response.getStatusCode() == 200 && response.body().prettyPrint().contains("\"extenso\": \"five hundred\"") ){
            test.log(LogStatus.PASS, "Retorno", response.jsonPath().getString("$"));
            test.log(LogStatus.PASS, "Status Code", String.valueOf(response.getStatusCode()));
            test.assignAuthor("Chiester Silva");
            test.assignCategory("Api");
        } else {
            test.log(LogStatus.FAIL, "Falha ao Chamar a Api", response.getBody().prettyPrint());
            test.log(LogStatus.FAIL, "Status Code", String.valueOf(response.getStatusCode()));
        }
    }

    @AfterClass
    public static void endTest() {
        report.endTest(test);
        report.flush();
    }
}
