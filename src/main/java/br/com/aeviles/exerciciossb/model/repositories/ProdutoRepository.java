package br.com.aeviles.exerciciossb.model.repositories;


//Esse repositorio de dados pode ser um arquivo de texto, uma planilha em excel, um BD...
//A ideia do repositorio é voc~e abstrai, você criar métodos de alto nível que vai abstrai todo o acesso aos dados
//assim como um data access object(DAO) ele tem essa visão de abastrai os dados a diferença é que o DAO tem a pegada da implementação
//enquanto que o repository tem a pegada de definir a interface de como você vai a bstrair o acesso a dados.


import br.com.aeviles.exerciciossb.model.entities.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

}
