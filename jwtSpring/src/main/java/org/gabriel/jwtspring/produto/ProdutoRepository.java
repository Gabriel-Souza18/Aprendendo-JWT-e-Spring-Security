package org.gabriel.jwtspring.produto;

import org.springframework.data.jpa.repository.JpaRepository;

// A entidade Produto utiliza Long como tipo do ID, então o repositório
// deve declarar o mesmo tipo para evitar problemas em tempo de execução.
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}

