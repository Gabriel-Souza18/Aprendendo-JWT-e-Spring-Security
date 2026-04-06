package org.gabriel.jwtspring.produto;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.gabriel.jwtspring.usuario.Usuario;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Table(name = "tb_posts")
public class Produto {
    @Id
    private String id;
    private String nome;
    private float preco;

}
