package com.senac.clima.services;

import com.senac.clima.entities.RegistroMedicao;
import com.senac.clima.repositories.RegistroMedicaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroMedicaoService {

    private RegistroMedicaoRepository registroMedicaoRepository;

    public RegistroMedicaoService(RegistroMedicaoRepository registroMedsicaoRepository) {
        this.registroMedicaoRepository = registroMedicaoRepository;
    }
    public List<RegistroMedicao> ListarRegistroMedicao() {return this.registroMedicaoRepository.findAll();}
    public RegistroMedicao adicionar(RegistroMedicao registroMedicao) {
        return this.registroMedicaoRepository.save(registroMedicao);
    }

    public String apagarMedicaoService(Long id) {
        try {
            this.registroMedicaoRepository.deleteById(id);
            return String.format("Município com o id %xl deletado!", id);
        }
        catch (Error e){
            return e.getMessage();
        }
    }

    public RegistroMedicao atualizar(Long id, RegistroMedicao registroMedicao) {
        if (this.registroMedicaoRepository.existsById(id)) {
            return this.registroMedicaoRepository.save(registroMedicao);
        }
        else {
            return null;
        }
    }
}
