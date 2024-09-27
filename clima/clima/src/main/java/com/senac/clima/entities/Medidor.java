package com.senac.clima.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="medidor")
public class Medidor {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="medidor_id", nullable = false)
    private Long id;
    @Column(name="medidor_status", nullable = false)
    private Integer status;
    @ManyToOne
    @JoinColumn(name="municipio_municipio_id", nullable = false)
    private Municipio municipio;

    @Override
    public String toString() {
        return "Medidor{" +
                "id=" + id +
                ", status=" + status +
                ", municipioId=" + municipio +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Medidor medidor)) return false;
        return Objects.equals(getId(), medidor.getId()) && Objects.equals(getStatus(), medidor.getStatus()) && Objects.equals(getMunicipio(), medidor.getMunicipio());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStatus(), getMunicipio());
    }

    public Medidor(Long id, Integer status, Municipio municipio) {
        this.setId(id);
        this.setStatus(status);
        this.setMunicipio(municipio);
    }

    public Medidor(){}
}
