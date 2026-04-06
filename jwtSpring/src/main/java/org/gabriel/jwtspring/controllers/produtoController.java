package org.gabriel.jwtspring.controllers;

import org.gabriel.jwtspring.produto.Produto;
import org.gabriel.jwtspring.produto.ProdutoDTO;
import org.gabriel.jwtspring.produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produto")

public class produtoController {

      @Autowired
      private ProdutoRepository produtoRepository;

      @PostMapping()
      public ResponseEntity<ProdutoDTO> cadastrarProduto(@RequestBody ProdutoDTO dto){
        // Ignora qualquer ID vindo de fora e cria sempre um novo Produto
        Produto produto = new Produto(null, dto.getNome(), dto.getPreco());
        Produto salvo = produtoRepository.save(produto);
        return ResponseEntity.ok(ProdutoDTO.fromEntity(salvo));
      }

      @GetMapping()
      public ResponseEntity<List<ProdutoDTO>> listarProdutos(){
        List<ProdutoDTO> dtos = produtoRepository.findAll()
            .stream()
            .map(ProdutoDTO::fromEntity)
            .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
      }
}
