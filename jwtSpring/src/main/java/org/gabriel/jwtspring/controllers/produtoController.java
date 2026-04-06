package org.gabriel.jwtspring.controllers;

import org.gabriel.jwtspring.produto.Produto;
import org.gabriel.jwtspring.produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")

public class produtoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping()
    public ResponseEntity<Void> cadastrarProduto(@RequestBody Produto produto){
        produtoRepository.save(produto);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<List<Produto>> listarProdutos(){
        return ResponseEntity.ok(produtoRepository.findAll());
    }
}
