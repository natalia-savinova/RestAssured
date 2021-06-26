import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class ApiTest {

//  код который: (.when())
//  отправит запрос get (.get())
//  запишет его в конслось (.log.all())
//  после чего (.then())
//  запишет ответ (.log.all())
//  проверит код ответа (.statusCode(200))
//   проверит содержимое body ответа (.body() )

    @Test
    public void restCountriesFirstGetTest() {
        RestAssured.
                when() .get("http://restcountries.eu/rest/v1/name/russia").
                then().assertThat().statusCode(200).
                and().body("[0].capital", Matchers.equalTo("Moscow"));
    }

    @Test
    public void postmanFirstGetTest(){
        RestAssured.
                when().get("https://postman-echo.com/get?foo1=bar1&foo2=bar2").
                then().assertThat().statusCode(200).
                and().body("args.foo2", Matchers.equalTo("bar2"));
    }

    @Test
    public void pocemonFirstGetTest() {
        RestAssured.
                when().get("https://pokeapi.co/api/v2/pokemon").
                then().
                statusCode(200).
                body("count", Matchers.equalTo(1118),
                "results.name", Matchers.hasItems("bulbasaur", "ivysaur"));
    }
}
