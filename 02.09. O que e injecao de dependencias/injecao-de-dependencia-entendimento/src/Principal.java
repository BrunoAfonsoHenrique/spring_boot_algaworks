import com.algaworks.sistemanotificacao.model.Cliente;
import com.algaworks.sistemanotificacao.model.Produto;
import com.algaworks.sistemanotificacao.service.ComprarProdutoService;
import com.algaworks.sistemanotificacao.service.Notificador;
import com.algaworks.sistemanotificacao.service.NotificarClienteEmail;
import com.algaworks.sistemanotificacao.service.NotificarClienteSMS;

import java.math.BigDecimal;

public class Principal {
    public static void main(String[] args) {

        Cliente joao = new Cliente("Joao", "11988885555", "11122233355", "joao@gmail.com");
        Produto produto = new Produto("Iphone", "Smatphone tecnologico", BigDecimal.valueOf(9380));

        Notificador notificador = new NotificarClienteSMS();

        ComprarProdutoService comprarProduto =  new ComprarProdutoService(notificador);
        comprarProduto.comprarProduto(joao, produto);

    }
}