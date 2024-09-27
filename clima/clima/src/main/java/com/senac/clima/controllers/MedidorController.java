package com.senac.clima.controllers;

import com.senac.clima.entities.Medidor;
import com.senac.clima.entities.Municipio;
import com.senac.clima.services.MedidorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medidor")
public class MedidorController {
    private MedidorService medidorService;

    public MedidorController(MedidorService medidorService) {
        this.medidorService = medidorService;
    }

    @GetMapping("/listarMedidores")
    public ResponseEntity<List<Medidor>> ListarMedidores(){
         List<Medidor> medidores = this.medidorService.ListarMedidores();
         return ResponseEntity.ok(medidores);
    }
    @PostMapping(value="adicionarMedidor")
    public ResponseEntity<Medidor> AdicionarMedidor(@RequestBody Medidor medidor) {
        Medidor temp = this.medidorService.adicionar(medidor);
        return ResponseEntity.ok(temp);
    }
    @DeleteMapping("/apagarMedidor/{id}")
    public ResponseEntity<String> ApagarMedidor(@PathVariable Long id){
        String temp = this.medidorService.apagarMedidor(id);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }
    @PutMapping("/atualizarMedidor/{id}")
    public ResponseEntity<Medidor> AtualizarMedidor(@PathVariable Long id, @RequestBody Medidor medidor) {
        //verficar id antes de atualizar
        //atualizar
        Medidor temp = this.medidorService.atualizar(id, medidor);
        return ResponseEntity.ok(temp);
    }
}
