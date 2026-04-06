package org.gabriel.jwtspring.usuario;

public enum RoleUsuario {
    ADMIN("admin"),
    USER("user");
    private String nome;
    RoleUsuario(String nome) {}

    public String getRole() {
        return this.nome;
    }
}
