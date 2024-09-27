package com.senac.clima.services;

import com.senac.clima.entities.Medidor;
import com.senac.clima.repositories.MedidorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedidorService {
    private MedidorRepository medidorRepository;

    public MedidorService(MedidorRepository medidorRepository) {
        this.medidorRepository = medidorRepository;
    }
    public List<Medidor> ListarMedidores() {
        return this.medidorRepository.findAll();
    }

    public Medidor adicionar(Medidor medidor) {return this.medidorRepository.save(medidor);}

    public String apagarMedidor(Long id) {
        try {
            this.medidorRepository.deleteById(id);
            return String.format("Município com o id %xl deletado!", id);
        }
        catch (Error e){
            return e.getMessage();
        }
    }

    public Medidor atualizar(Long id, Medidor medidor) {
        if (this.medidorRepository.existsById(id)) {
            return this.medidorRepository.save(medidor);
        }
        else {
            return null;
        }
    }
}
