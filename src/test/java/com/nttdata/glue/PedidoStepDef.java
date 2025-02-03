package com.nttdata.glue;
import com.nttdata.steps.PedidoStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class PedidoStepDef {
    @Steps
    PedidoStep pedidoStep;
    @Given("tiene acceso al sistema de pedidos")
    public void accesoSistemaPedidos() {
        }

    @When("crea un pedido de mascota con los siguientes datos")
    public void crearPedido(String jsonRequest) {
        pedidoStep.crearPedido(jsonRequest);
    }

    @Then("el pedido es creado exitosamente")
    public void validarPedidoCreado() {
        pedidoStep.validarDetallesPedido();
    }

    @And("valido que el código de respuesta sea {int}")
    public void validarCodigoRespuesta(int i) {
        pedidoStep.validarCodigoRespuesta(i);
    }

    @And("el sistema muestra los detalles del pedido creado")
    public void validarDetallesPedido() {
        pedidoStep.validarDetallesPedido();
    }

    @When("el usuario consulta el pedido de la mascota {int}")
    public void consultarPedido(int idPedido) {
        pedidoStep.consultarPedido(idPedido);
    }

    @Then("pedido se consulto exitosamente")
    public void validarConsultaExitosa() {
        pedidoStep.validarDetallesPedido();
    }
    @And("el sistema muestra los detalles del pedido de la mascota")
    public void el_sistema_muestra_los_detalles_del_pedido_de_la_mascota() {
    pedidoStep.validarDetallesPedido();  
    }
    @And("el sistema devuelve la información correcta para el ID {int}")
    public void validarPedidoCorrecto(int idPedido) {
        pedidoStep.validarPedidoCorrecto(idPedido);
    }
}


