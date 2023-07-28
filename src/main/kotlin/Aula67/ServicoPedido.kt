package Aula67

import java.util.concurrent.TimeUnit

class ServicoPedido {
    private val precoMaca = 60
    private val precoLaranja = 25
    private var estoqueMaca = 3
    private var estoqueLaranja = 100

    // Etapa 1: Serviço de pedidos
    fun calcularTotal(pedidos: List<String>): Double? {
        var total = 0
        for (pedido in pedidos) {
            when (pedido) {
                "Maçã" -> {
                    if (estoqueMaca > 0) {
                        total += precoMaca
                        estoqueMaca--
                    } else {
                        println("Desculpe, maçãs fora de estoque.")
                        return null
                    }
                }
                "Laranja" -> {
                    if (estoqueLaranja > 0) {
                        total += precoLaranja
                        estoqueLaranja--
                    } else {
                        println("Desculpe, laranjas fora de estoque.")
                        return null
                    }
                }
                else -> {
                    println("Produto inválido: $pedido")
                    return null
                }
            }
        }
        //Etapa 2: Oferta Simples
        val macasGratis = pedidos.count { it == "Maçã" } / 2
        total -= macasGratis * precoMaca

        // Oferta: 3 pelo preço de 2 em laranjas
        val laranjasDesconto = pedidos.count { it == "Laranja" } / 3
        total -= laranjasDesconto * precoLaranja

        return total / 100.0
    }

    //Etapa 3: Notificacao ao cliente
    fun notificarCliente(pedido: List<String>) {
        println("\nPedido de ${pedido.joinToString(", ")} concluído.\nEnviando notificação ao cliente...")
        TimeUnit.SECONDS.sleep(2) // Simulação do tempo de envio da notificação
        println("\nNotificação enviada.")
    }
}

// Teste
fun main() {
    val pedidos = listOf("Maçã", "Maçã", "Laranja", "Maçã")
    val servico = ServicoPedido()
    val total = servico.calcularTotal(pedidos)
    if (total != null) {
        println("\nTotal: R$ ${"%.2f".format(total)}")
        servico.notificarCliente(pedidos)
    } else {
        println("Pedido falhou.")
    }
}
