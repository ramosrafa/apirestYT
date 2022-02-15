package com.produtos.apirest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api("API rest produtos")
@CrossOrigin(origins = "*")
public class ProdutoController {

	@Autowired
	ProdutoRepository repository;

	@GetMapping("/produtos")
	@ApiOperation(value = "Retorna uma lista de produtos")
	public List<Produto> listaProdutos() {

		return repository.findAll();

	}

	@GetMapping("/produto/{id}")
	@ApiOperation(value = "Retorna um único produto")
	public Optional<Produto> listaProdutoUnico(@PathVariable(value = "id") Long id) {

		return repository.findById(id);

	}

	@PostMapping("/produto")
	@ApiOperation(value = "Salva um produto")
	public Produto salvarProduto(@RequestBody Produto produto) {

		return repository.save(produto);
	}

	@DeleteMapping("/produto/{id}")
	@ApiOperation(value = "Deleta um produto")
	public Optional<Produto> deletaProdutoPorId(@PathVariable(value = "id") Long id) {
		Optional<Produto> produto = repository.findById(id);
		if (produto.isPresent()) {
			repository.deleteById(id);
		}

		return produto;

	}

	@PutMapping("/produto")
	@ApiOperation(value = "Atualiza um produto")
	public Produto atualizarProduto(@RequestBody Produto produto) {

		return repository.save(produto);
	}

}
