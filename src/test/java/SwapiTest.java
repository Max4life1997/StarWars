import io.restassured.http.ContentType;
import org.json.JSONException;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.*;
import java.io.IOException;
import static io.restassured.RestAssured.*;
import static org.hamcrest.core.IsEqual.equalTo;


@DisplayName("Swapi Test")
public class SwapiTest {
    @DisplayName("Test 1")
    @Test
    public void listOfEssence() throws JSONException, IOException {
        SwapiTestBox swapiTestBox = new SwapiTestBox();
        System.out.println(swapiTestBox.apiTestBox("https://swapi.dev/api/?format=json","$"));
    }

    @DisplayName("Тест 2: Список фильмов")
    @Test
    public void listOfFilms() throws JSONException, IOException {
        SwapiTestBox swapiTestBox = new SwapiTestBox();
        System.out.println("Весь список фильмов: " + swapiTestBox.apiTestBox("https://swapi.dev/api/films/?format=json","results.title"));
        System.out.println("Выбранный фильм: " + swapiTestBox.apiTestBox("https://swapi.dev/api/films/?format=json","results[0]."));
        //Assertions.ass;
    }

    @DisplayName("Тест 3: Список Планет")
    @Test
    public void listOfPlanets() throws JSONException, IOException {
        SwapiTestBox swapiTestBox = new SwapiTestBox();
        System.out.println("Весь список планет: " + swapiTestBox.apiTestBox("https://swapi.dev/api/planets?format=json","results.name"));
        System.out.println("Планета из фильма Новая Надежда: " + swapiTestBox.apiTestBox("https://swapi.dev/api/planets?format=json","results.find{it.name.contains('Tatooine')}"));
    }

    @DisplayName("Тест 4: Список рас")
    @Test
    public void listOfRace() throws JSONException, IOException {
        SwapiTestBox swapiTestBox = new SwapiTestBox();
        System.out.println("Весь список рас: " + swapiTestBox.apiTestBox("https://swapi.dev/api/species/?format=json","results.name"));
        System.out.println("Раса с выбранной планеты: " + swapiTestBox.apiTestBox("https://swapi.dev/api/species/?format=json","results[0].name"));
    }

    @DisplayName("Тест 5: Список пилотов корабля")
    @Test
    public void listOfPeople() throws JSONException, IOException {
        SwapiTestBox swapiTestBox = new SwapiTestBox();
        System.out.println("Весь список рас: " + swapiTestBox.apiTestBox("https://swapi.dev/api/people/?format=json","results.name"));
        System.out.println("Список пилотов корабля: " + swapiTestBox.apiTestBox("https://swapi.dev/api/people/?format=json","results[0].name") +" и " + swapiTestBox.apiTestBox("https://swapi.dev/api/people/?format=json","results[2].name"));
    }

}
