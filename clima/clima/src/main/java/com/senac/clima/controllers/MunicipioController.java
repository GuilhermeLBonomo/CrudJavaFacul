package com.senac.clima.controllers;

import com.senac.clima.entities.Municipio;
import com.senac.clima.services.MunicipioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/municipio")
public class MunicipioController {

    private MunicipioService municipioService;

    public MunicipioController(MunicipioService municipioService) {
        this.municipioService = municipioService;
    }
    @GetMapping("/listarMunicipios")
    public ResponseEntity<List<Municipio>> ListarMunicipios(){
        List<Municipio> municipios = municipioService.ListarMunicipios();
        return ResponseEntity.ok(municipios);
    }
    @PostMapping("/adicionarMunicipio")
    public ResponseEntity<Municipio> AdicionarMunicipio(@RequestBody Municipio municipio) {
        Municipio temp = municipioService.adicionar(municipio);
        return ResponseEntity.ok(temp);
    }
    @DeleteMapping("/apagarMunicipio/{id}")
    public ResponseEntity<String> ApagarMunicipio(@PathVariable Long id){
        String temp = this.municipioService.apagarMunicipio(id);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }
    @PutMapping("/atualizarMunicipio/{id}")
    public ResponseEntity<Municipio> AtualizarMunicipio(@PathVariable Long id, @RequestBody Municipio municipio) {
        //verficar id antes de atualizar
        //atualizar
        Municipio temp = this.municipioService.atualizar(id, municipio);
        return ResponseEntity.ok(temp);
    }
}
