@PedidoCompleto
  Feature: Pedido

    @CrearPedido
    Scenario Outline: Registro de pedido de mascota exitoso
      Given tiene acceso al sistema de pedidos
      When crea un pedido de mascota con los siguientes datos
      """
      {
        "id": <id>,
        "petId": <petId>,
        "quantity": <quantity>,
        "shipDate": "<shipDate>",
        "status": "<status>",
        "complete": <complete>
      }
      """
      Then el pedido es creado exitosamente
      And valido que el código de respuesta sea 200
      And el sistema muestra los detalles del pedido creado
      Examples:
        | id  | petId | quantity | shipDate                    | status | complete |
        | 88   | 200   | 2        | "2025-02-02T21:11:30.803Z" | placed | true     |



      @ConsultarPedido
      Scenario Outline: Consulta de pedido de mascota
        Given tiene acceso al sistema de pedidos
        When el usuario consulta el pedido de la mascota <id>
        Then pedido se consulto exitosamente
        And valido que el código de respuesta sea 200
        And el sistema muestra los detalles del pedido de la mascota
        And el sistema devuelve la información correcta para el ID <id>

        Examples:
          | id  |
          | 88  |



