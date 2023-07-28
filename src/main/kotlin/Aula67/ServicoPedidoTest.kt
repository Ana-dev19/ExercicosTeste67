package Aula67
import java.util.concurrent.TimeUnit
import org.testng.Assert.assertEquals
import org.testng.Assert.assertNull
import org.testng.annotations.Test
class ServicoPedidoTest {

        // Teste para a função calcularTotal com pedido válido
        @Test
        fun testCalcularTotal() {
            val pedidos = listOf("Maçã", "Maçã", "Laranja", "Maçã")
            val servico = ServicoPedido()
            val totalEsperado = 2.05
            val totalCalculado = servico.calcularTotal(pedidos)
        }

    private fun assertEquals(totalEsperado: Double, totalCalculado: Double?, d: Double) {
        TODO("Not yet implemented")
    }

    // Teste para a função calcularTotal com pedido inválido
        @Test
        fun testCalcularTotalPedidoInvalido() {
            val pedidos = listOf("Banana", "Pera", "Uva")
            val servico = ServicoPedido()
            val totalCalculado = servico.calcularTotal(pedidos)
            assertNull(totalCalculado)
        }

        // Teste para a função calcularTotal com estoque de maçãs esgotado
        @Test
        fun testCalcularTotalEstoqueEsgotado() {
            val pedidos = listOf("Maçã", "Maçã", "Laranja", "Maçã", "Maçã", "Maçã") // Pedido com 6 maçãs (estoque limitado para 3)
            val servico = ServicoPedido()
            val totalCalculado = servico.calcularTotal(pedidos)
            assertNull(totalCalculado)
        }

        // Teste para a função notificarCliente
        @Test
        fun testNotificarCliente() {
            val pedidos = listOf("Maçã", "Maçã", "Laranja", "Maçã")
            val servico = ServicoPedido()

            // Verifica se a função não lança exceção
            servico.notificarCliente(pedidos)
        }
    }
