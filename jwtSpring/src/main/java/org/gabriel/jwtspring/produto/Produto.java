package org.gabriel.jwtspring.produto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.gabriel.jwtspring.usuario.Usuario;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Table(name = "tb_posts")
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String nome;
    private float preco;

}
