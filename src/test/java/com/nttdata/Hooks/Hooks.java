package com.nttdata.Hooks;

import com.nttdata.steps.PedidoStep;
import io.cucumber.java.Before;
import net.thucydides.core.annotations.Steps;



public class Hooks {
    @Steps
    PedidoStep pedidoStep;

    @Before(order = 1)
    public void CrearPedido() {
        System.out.println("Creando pedido antes de cualquier consulta...");

        String jsonRequest = "{"
                + "\"id\": 88,"
                + "\"petId\": 200,"
                + "\"quantity\": 2,"
                + "\"shipDate\": \"2025-02-02T21:11:30.803Z\","
                + "\"status\": \"placed\","
                + "\"complete\": true"
                + "}";

        pedidoStep.crearPedido(jsonRequest);
        pedidoStep.validarCodigoRespuesta(200);
    }


    @Before(order = 2)
    public void ConsultarPedido() {
        System.out.println("Verificando consulta de pedido...");
    }

}
