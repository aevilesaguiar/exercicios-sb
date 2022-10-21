package br.com.aeviles.exerciciossb.model.repositories;


//Esse repositorio de dados pode ser um arquivo de texto, uma planilha em excel, um BD...
//A ideia do repositorio é voc~e abstrai, você criar métodos de alto nível que vai abstrai todo o acesso aos dados
//assim como um data access object(DAO) ele tem essa visão de abastrai os dados a diferença é que o DAO tem a pegada da implementação
//enquanto que o repository tem a pegada de definir a interface de como você vai a bstrair o acesso a dados.


import br.com.aeviles.exerciciossb.model.entities.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//substitui o CrudRepository por PagingAndSortingRepository devido a consultas paginadas
@Repository
public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Integer> {

    //pela convenção eu coloco o nome do atributo nesse caso vou buscar "nome"
    //que Containing
    //IgnoreCase é para ignorar letras maiuscula e minusculas
    public Iterable<Produto> findByNomeContainingIgnoreCase(String parteNome);

    //as tres são a mesma coisa
    //findByNomeContaining
    //findByNomeIsContaining
    //findByNomeContains

    //inicio e fim
    //findByNomeStartWith
    //findByNomeEndsWith

    //não contém
    //findByNomeNotContaining

    @Query("SELECT p FROM Produto p WHERE p.nome LIKE %:nome%")
    public Iterable<Produto> searchByNameLike(@Param("nome") String parteNome);



}
