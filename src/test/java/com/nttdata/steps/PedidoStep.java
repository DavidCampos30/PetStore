package com.nttdata.steps;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.CoreMatchers;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PedidoStep {
    private static final String BASE_URL = "https://petstore.swagger.io/v2/";
    private static RequestSpecification requestSpec;
    private Response response;

    static {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setContentType(ContentType.JSON)
                .build();
    }


    public void crearPedido(String jsonRequest) {
        response = SerenityRest.given()
                .spec(requestSpec)
                .body(jsonRequest)
                .log().all()
                .when()
                .post("store/order");


    }


    public void consultarPedido(int idPedido) {
        response = SerenityRest.given()
                .spec(requestSpec)
                .log().all()
                .when()
                .get("store/order/" + idPedido);


    }


    //Valida el codigo de respuesta

    public void validarCodigoRespuesta(int i) {
        assertThat(lastResponse().statusCode(), is(i));
    }


    //Valida que los detalles del pedido no sea nulo
    public void validarDetallesPedido() {
        if (response.getStatusCode() != 200) {
            String errorMessage = response.getBody().asString();
            System.out.println("Error detallado de la respuesta: " + errorMessage);  // Para depuración
            throw new IllegalStateException("El código de respuesta no es 200: " + response.getStatusCode() + ". Detalles del error: " + errorMessage);
        }
    }

    //Verificar que devuelve el pedido correcto
    public void validarPedidoCorrecto(int idPedido) {
        int idResponse = response.getBody().path("id");
        assertThat("El id del pedido no coincide", idResponse, CoreMatchers.equalTo(idPedido));
    }
}

