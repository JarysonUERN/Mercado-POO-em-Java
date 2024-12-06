package carrinho;

import produto.Produto;
import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<ItemCarrinho> itens; // Lista de itens no carrinho

    public Carrinho() {
        this.itens = new ArrayList<>();
    }

    // Adiciona um produto ao carrinho com uma quantidade específica
    public boolean adicionarProduto(Produto produto, int quantidade) {
        if (produto.getQuantidade() < quantidade) {
            System.out.println("Estoque insuficiente para o produto: " + produto.getNome());
            return false;
        }

        for (ItemCarrinho item : itens) {
            if (item.getProduto().getId() == produto.getId()) {
                item.setQuantidade(item.getQuantidade() + quantidade);
                return true;
            }
        }

        itens.add(new ItemCarrinho(produto, quantidade));
        return true;
    }

    // Remove um produto do carrinho
    public boolean removerProduto(int idProduto, int quantidade) {
        for (ItemCarrinho item : itens) {
            if (item.getProduto().getId() == idProduto) {
                if (item.getQuantidade() >= quantidade) {
                    item.setQuantidade(item.getQuantidade() - quantidade);
                    if (item.getQuantidade() == 0) {
                        itens.remove(item);
                    }
                    return true;
                } else {
                    System.out.println("Quantidade no carrinho insuficiente para remover.");
                    return false;
                }
            }
        }
        System.out.println("Produto não encontrado no carrinho.");
        return false;
    }

    // Calcula o valor total do carrinho
    public double calcularTotal() {
        double total = 0.0;
        for (ItemCarrinho item : itens) {
            total += item.getProduto().getPreco() * item.getQuantidade();
        }
        return total;
    }

    // Retorna uma lista com informações dos produtos do carrinho
    public List<ItemCarrinho> getItens() {
        return itens;
    }

    // Exibe os itens do carrinho
    public void exibirCarrinho() {
        System.out.println("\nItens no carrinho:");
        for (ItemCarrinho item : itens) {
            System.out.println("- Produto: " + item.getProduto().getNome() + ", Quantidade: " + item.getQuantidade() +
                               ", Preço Unitário: R$" + item.getProduto().getPreco());
        }
        System.out.println("Valor total: R$" + calcularTotal());
    }
}
