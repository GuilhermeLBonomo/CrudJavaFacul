package com.senac.clima.services;

import com.senac.clima.entities.Municipio;
import com.senac.clima.repositories.MunicipioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MunicipioService {

    private MunicipioRepository municipioRepository;

    public MunicipioService(MunicipioRepository municipioRepository) {
        this.municipioRepository = municipioRepository;
    }
    public List<Municipio> ListarMunicipios() {
        return this.municipioRepository.findAll();
    }

    public Municipio adicionar(Municipio municipio) {return this.municipioRepository.save(municipio);}

    public String apagarMunicipio(Long id) {
        try {
            this.municipioRepository.deleteById(id);
            return String.format("Município com o id %xl deletado!", id);
        }
        catch (Error e){
            return e.getMessage().toString();
        }
    }

    public Municipio atualizar(Long id, Municipio municipio) {
        if (this.municipioRepository.existsById(id)) {
            return this.municipioRepository.save(municipio);
        }
        else {
            return null;
        }

    }
}
