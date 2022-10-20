package br.com.aeviles.exerciciossb.controllers;

import br.com.aeviles.exerciciossb.model.entities.Produto;
import br.com.aeviles.exerciciossb.model.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/produtos") //a url quando eu chamar esse método
public class ProdutoController {

//@RequestParam : eu espero receber o nome a partir de um parametro da requisição
//@ResponseBody: foi anotado assim pois eu quero deixar claro que Produto faz parte do corpo da resposta

    @Autowired
    private ProdutoRepository produtoRepository; //é como se o spring criasse um objeto chamado ProdutoRepository

    @PostMapping
    public @ResponseBody  Produto novoProduto(@RequestParam String  nome, @RequestParam Double preco,@RequestParam Double desconto){
        Produto produto = new Produto(nome, preco,desconto);
        produtoRepository.save(produto); //está salvando no BD

        return produto;
    }
}
