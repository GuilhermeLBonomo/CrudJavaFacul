package com.senac.clima.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="registro_medicao")
public class RegistroMedicao {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="registro_medicao_id", nullable = false)
    private Long id;
    @Column(name="registro_medicao_data", nullable = false)
    private LocalDateTime data;
    @Column(name="registro_medicao_status", nullable = false)
    private Integer status;
    @ManyToOne
    @JoinColumn(name="medidor_medidor_id", nullable = false)
    private Medidor medidor;
    @ManyToOne
    @JoinColumn(name="municipio_municipio_id", nullable = false)
    private Municipio municipio;

    @Override
    public String toString() {
        return "RegistroMedicao{" +
                "id=" + id +
                ", data=" + data +
                ", status=" + status +
                ", medidorId=" + medidor +
                ", municipioId=" + municipio +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Medidor getMedidor() {
        return medidor;
    }

    public void setMedidor(Medidor medidor) {
        this.medidor = medidor;
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
        if (!(o instanceof RegistroMedicao that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getData(), that.getData()) && Objects.equals(getStatus(), that.getStatus()) && Objects.equals(getMedidor(), that.getMedidor()) && Objects.equals(getMunicipio(), that.getMunicipio());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getData(), getStatus(), getMedidor(), getMunicipio());
    }

    public RegistroMedicao(Long id, LocalDateTime data, Integer status, Medidor medidor, Municipio municipio) {
        this.setId(id);
        this.setData(data);
        this.setStatus(status);
        this.setMedidor(medidor);
        this.setMunicipio(municipio);
    }

    public RegistroMedicao(){}
}
