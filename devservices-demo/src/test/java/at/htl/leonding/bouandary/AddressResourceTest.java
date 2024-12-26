package at.htl.leonding.bouandary;


import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.*;



@QuarkusTest

class AddressResourceTest {

    @Test
    public void testGetAllAddresses() {
        Response response = given()
                .when().get("/address/all")
                .then()
                .statusCode(200)
                .extract().response();

        // Überprüfen, ob die Antwort eine Liste enthält
        assertThat(response.jsonPath().getList("$")).isNotEmpty();
    }

    @Test
    public void testGetAddressById() {
        Long addressId = 1L; // Beispiel-ID, anpassen je nach Testdaten

        Response response = given()
                .queryParam("id", addressId)
                .when().get("/address/{id}", addressId)
                .then()
                .statusCode(200)
                .extract().response();

        // Überprüfen, ob die zurückgegebene Adresse die erwartete ID hat
        assertThat(response.jsonPath().getLong("id")).isEqualTo(addressId);
    }
}