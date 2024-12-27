package at.htl.leonding.boundary;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.*;
@QuarkusTest
class PersonResourceTest {

    @Test
    public void testGetAllPersons() {
        Response response = given()
                .when().get("/person/all")
                .then()
                .statusCode(200)
                .extract().response();

        // Überprüfen, ob die Antwort eine Liste enthält
        assertThat(response.jsonPath().getList("$")).isNotEmpty();
    }

    @Test
    public void testGetPersonById() {
        Long personId = 1L; // Beispiel-ID, anpassen je nach Testdaten

        Response response = given()
                .queryParam("id", personId)
                .when().get("/person/{id}", personId)
                .then()
                .statusCode(200)
                .extract().response();

        // Überprüfen, ob die zurückgegebene Person die erwartete ID hat
        assertThat(response.jsonPath().getLong("id")).isEqualTo(personId);
    }

}