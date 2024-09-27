package com.senac.clima.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="municipio")
public class Municipio {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="municipio_id", nullable = false)
    private Long id;
    @Column(name="municipio_nome", nullable = false)
    private String nome;
    @Column(name="municipio_status", nullable = false)
    private Integer status;

    @Override
    public String toString() {
        return "Municipio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", status=" + status +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Municipio municipio)) return false;
        return Objects.equals(getId(), municipio.getId()) && Objects.equals(getNome(), municipio.getNome()) && Objects.equals(getStatus(), municipio.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getStatus());
    }

    public Municipio(Long id, String nome, Integer status) {
        this.setId(id);
        this.setNome(nome);
        this.setStatus(status);
    }
    public Municipio(){}
}
