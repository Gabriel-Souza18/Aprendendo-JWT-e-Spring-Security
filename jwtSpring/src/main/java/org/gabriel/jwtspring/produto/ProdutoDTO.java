package org.gabriel.jwtspring.produto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// DTO para expor/receber dados de Produto na API sem expor diretamente a entidade JPA
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {

	private Long id;
	private String nome;
	private float preco;

	public static ProdutoDTO fromEntity(Produto produto) {
		return new ProdutoDTO(produto.getId(), produto.getNome(), produto.getPreco());
	}
}
