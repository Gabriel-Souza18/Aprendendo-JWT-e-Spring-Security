package org.gabriel.jwtspring.usuario;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

// A entidade Usuario utiliza Long como tipo do ID, então o repositório
// deve declarar o mesmo tipo para manter a consistência com o mapeamento JPA.
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByNickname(String nickname);
}

