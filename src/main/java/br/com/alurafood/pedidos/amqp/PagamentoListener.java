package br.com.alurafood.pedidos.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import br.com.alurafood.pedidos.dto.PagamentosDto;

@Component
public class PagamentoListener {
//deve salvar no banco mas no momente somente println
    @RabbitListener(queues = "pagamentos.detalhes-pedido")
    public void recebeMensagem(PagamentosDto pagamentosDto) {
        String mensagem = """
            Dados do pagamento: %s
            Número do pedido: %s
            Valor R$: %s
            Status: %s 
            """.formatted(pagamentosDto.getId(),
            pagamentosDto.getPedidoId(),
            pagamentosDto.getValor(),
            pagamentosDto.getStatus());

    System.out.println("Recebi a mensagem " + mensagem);
    }
}
