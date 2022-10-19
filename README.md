# Apontamentos

json(javaSccript Object Notation): json é um formato textual(TEXTO).
JSON é um formato de arquivo padrão aberto e formato de intercâmbio de dados que usa texto legível por humanos 
para armazenar e transmitir objetos de dados que consistem em pares e matrizes de valor-atributo. É um formato 
de dados comum com diversos usos no intercâmbio eletrônico de dados.

Ex json:
{
    "nome":"Maria",
    "sobrenome":"Pera",
    "dataNascimento":"13/11/2022",
    "endereco":{
    "logradouro":"Rua ABC",
    "numero":123
},
"dependentes":[
        {
            "id":212,
            "nome":"Ana"
        },
        {
            "id":214,
            "nome":"João"
        },
        {
            "id":158,
            "nome":"Pedro"
        }
]
}


https://jsonformatter.curiousconcept.com/


## Pilha de protocolos


![](../../Users/aesilva/AppData/Local/Temp/images.jpg)
![](../../Users/aesilva/AppData/Local/Temp/download.png)
![](../../Users/aesilva/AppData/Local/Temp/download.jpg)

## Protocolo HTTP

Protocolo HTTP que está na camada de aplicação.
O protocolo HTTP é baseado em requisição e resposta(request e response),
ou seja você faz um request ele envia um response.
Você faz uma requisição, e essa requisição deve estar associada a um método ex: GET, POST, DELETE...
O  protocolo HTTP possui 8 métodos.

O método mais usado no protocolo http é o método GET. Ex.: se sua página tem referencia para um 
arquivo CSS ele vai buscar esse arquivo CSS usando GET, se sua página tem referencia para um arquivo
JS, imagem ou vídeo  isso é feito via de regra com GET.
O método GET serve para obter/ler informações do servidor.
O método GET não é para causar nenhum  alteração/efeito colateral no servidor, ou seja mudar
o estado da aplicação, quando você insere /exclui alguma informação do BD.
O método GET serve para ler informações e não para alterar (de acordo com a semantica) informações no servidor.


Quando você faz uma requisição do tipo POST/PUT/PATCH/DELET

O POST é o segundo método mais utilizado depois do GET.
POST serve para submeter ou enviar informações para o servidor. Ou seja quando eu
quero cadastrar/inserir novos dados no servidor.

PATCH / PUT quando eu quero alterar um dado no servidor. A diferença é que o PATCH é
usado para fazer uma alteração parcial, e o PUT é para fazer uma alteração total.
Ex: quando eu quero mexer em todos os atributos de um usuário eu uso o  PUT, 
mas se for apenas um único atributo eu uso o PATCH.
Via de regra é mais comum usar o PUT na API REST.

DELETE serve para fazer uma exclusão.

Método OPTIONS ele é usado para fazer uma requisição quando você quer saber qual método HTTP
que aquela url suporta.
OPTIONS-> /OLA -> get
                -> POST

O Método TRACE serve para fazer uma requisição de teste

- O método HEAD é muito parecida com o GET, só que quando fazemos uma requisição com o GET ele retorna um
corpo na resposta (response body) . Já no HEAD você recebe a resposta sem o conteudo.
Você pode usar uma requisição tipo HEAD quando você quer verificar que uma determinada url está funcionando.


Esses métodos estarão funcionando apena entre o BROWSER e a aplicação Spring Boot, ou seja seu servidor.
Esses métodos vão estar funcionando como uma forma de comunicar entre esses dois computadores
na internet. Mas o que a sua aplicação faz com a requisição após esse processo exemplo
acessar o BD, excluir as informações não tem relação direta com o tipo de método HTTP 
que você usa, vococê pode obter um método DELETE e no final obter informações do Servidor
ou seja não tem a obrigação de usar o método DELETE para excluir, o método POST para incluit
o PUT para alterar , o GET para obter dados, o que devemos fazer é manter a consistencia entre
a semantica(significado) de cada método HTTP mais aderente voc~e estará ao padrão REST.

             _________    ---------------->    ___________ 
            |BROWNSER|                        |SPRING BOOT|  ----
            ----------   <----------------    ------------       |
                                                                 |
                                                                 V
                                                                [BD]

Os métodos HTTP servem para comunicação entre dois nós dentro da rede, mas não necessariamente o que você faz depois 
dentro da sua aplicação tem que refletir que tipo de método você usou. Mas manter a coerencia e semanticas dos verbos
é muito importante.

## GRAPHQL

Tecnologia GRAPHQL que é uma alterantiva a uma API do tipo REST.
GRAPHQL usa para inserir o método POST, para alterar um registro ele usa o método POST
para excluir ele usa o método POST e para ler ele usa o método GET. 