package com.senac.clima.controllers;


import com.senac.clima.entities.Medidor;
import com.senac.clima.entities.RegistroMedicao;
import com.senac.clima.services.RegistroMedicaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registroMedicao")
public class RegistroMedicaoController {

    private RegistroMedicaoService registroMedicaoService;

    public RegistroMedicaoController(RegistroMedicaoService registroMedicaoService) {
        this.registroMedicaoService = registroMedicaoService;
    }
    @GetMapping("/listarRegistroMedicao")
    public ResponseEntity<List<RegistroMedicao>> ListarRegistroMedicao(){
        List<RegistroMedicao> registroMedicao = this.registroMedicaoService.ListarRegistroMedicao();
        return ResponseEntity.ok(registroMedicao);
    }
    @PostMapping(value="adicionarRegistroMedicao")
    public ResponseEntity<RegistroMedicao> AdicionarRegistroMedicao(@RequestBody RegistroMedicao registroMedicao) {
        RegistroMedicao temp = this.registroMedicaoService.adicionar(registroMedicao);
        return ResponseEntity.ok(temp);
    }
    @DeleteMapping("/apagarRegistroMedicao/{id}")
    public ResponseEntity<String> ApagarMedidor(@PathVariable Long id){
        String temp = this.registroMedicaoService.apagarMedicaoService(id);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }
    @PutMapping("/atualizarRegistroMedicao/{id}")
    public ResponseEntity<RegistroMedicao> AtualizarRegistroMedicao(@PathVariable Long id, @RequestBody RegistroMedicao registroMedicao) {
        //verficar id antes de atualizar
        //atualizar
        RegistroMedicao temp = this.registroMedicaoService.atualizar(id, registroMedicao);
        return ResponseEntity.ok(temp);
    }
}
