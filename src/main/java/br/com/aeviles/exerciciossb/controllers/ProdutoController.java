package br.com.aeviles.exerciciossb.controllers;

import br.com.aeviles.exerciciossb.model.entities.Produto;
import br.com.aeviles.exerciciossb.model.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos") //a url quando eu chamar esse método
public class ProdutoController {

//@RequestParam : eu espero receber o nome a partir de um parametro da requisição
//@ResponseBody: foi anotado assim pois eu quero deixar claro que Produto faz parte do corpo da resposta

    @Autowired
    private ProdutoRepository produtoRepository; //é como se o spring criasse um objeto chamado ProdutoRepository


    //duas formas de fazer o post, com o Objeto direto e com os parametros
    @PostMapping(path = "produto2")
    public @ResponseBody  Produto novoProduto(@RequestParam String  nome, @RequestParam Double preco,@RequestParam Double desconto){
        Produto produto = new Produto(nome, preco,desconto);
        produtoRepository.save(produto); //está salvando no BD

        return produto;
    }
    @PostMapping
    public @ResponseBody  Produto novoProduto2(@Valid Produto produto){
        produtoRepository.save(produto); //está salvando no BD

        return produto;
    }

//Iterable é uma interface que determina que uma coleção pode ter seus elementos alcançados por uma estrutura foreach. A interface só possui um método.
    @GetMapping
    public Iterable<Produto>obterProdutos(){
        //não é indicado fazer findAll() devido pesquisas com alto nivel de dados
        return produtoRepository.findAll();
    }

    @GetMapping(path = "/nome/{parteNome}")
    public Iterable<Produto>obterProdutosPorNome(@PathVariable String parteNome){
        //não é indicado fazer findAll() devido pesquisas com alto nivel de dados
        return produtoRepository.findByNomeContainingIgnoreCase(parteNome);
    }

    @GetMapping(path = "/nomealterado/{parteNome}")
    public Iterable<Produto>obterProdutosPorNomeTeste(@PathVariable String parteNome){
        //não é indicado fazer findAll() devido pesquisas com alto nivel de dados
        return produtoRepository.searchByNameLike(parteNome);
    }


    @GetMapping(path = "/{id}")
    public Optional<Produto>obterProdutosPorId(@PathVariable Integer id){

        return produtoRepository.findById(id);
    }

    //consulta paginada
    //temos uma lista de produtos que sera chamada pelo o getMapping
    //http://localhost:8080/api/produtos/pagina/0/5
    @GetMapping(path = "/pagina/{numeroPagina}/{qtdPagina}")
    public Iterable<Produto> obterProdutosPorPagina(@PathVariable int numeroPagina, @PathVariable int qtdPagina){

        if(qtdPagina>=5) qtdPagina=5;
        PageRequest pageable= PageRequest.of(numeroPagina,qtdPagina);
        return produtoRepository.findAll(pageable);


    }
    @PutMapping
    public Produto alterarProduto(@Valid Produto produto){
            produtoRepository.save(produto);
            return produto;
    }

    //ao invés de usar o @PutMapping e o @PostMapping para altera/salvar podemos criar um unico metodo para essas duas funções
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT}, path = {"/salvaAtualiza"})
    public @ResponseBody  Produto salvarEAtualizar(@Valid Produto produto){
        produtoRepository.save(produto); //está salvando no BD

        return produto;
    }


    @DeleteMapping(path = "/{id}")
    public void excluirProduto(@PathVariable Integer id){
        produtoRepository.deleteById(id);
    }



}
