
Nome: Gabriel dos Santos Nascimento 

Matrícula: 201376133

Curso: Sistemas de Informação

________________________________________________________________________________________________________________________________________
Cenário

O projeto descrito tem como contexto um sistema de gerenciamento de comandas para bar, ou seja, o sistema conta com um cardápio
dinâmico de bebidas e comidas(porções e pratos) e, além disso, permite a adição de mais itens ao mesmo. Para gerir este recurso
foi utlizado JComboBox.
O programa permite o gerenciamento de 20 mesas (foi estipulado um número total de 20 mesas, mas pode ser aumentado). Para o 
funcionamento, o operador seleciona a mesa que deseja cadastrar a comanda, seleciona em seguida o item de bebida e item de comida
da respectiva mesa (sem a obrigatóriedade de ter que pedir os dois juntos) e, logo em seguida, adiciona o pedido a lista. Para 
gerir a lista de pedidos do estabelecimento foi utilizado JTableModel.
O programa permite fechar a messa, alterando assim o status de "Aberto" para "Fechado" e, com isso, nã permitindo mais fazer 
alterações na comanda e gravando a hora de fechamento. Além disso, é possível fazer a exclusão de um pedido, caso o mesmo seja 
cancelado pelo usuário.
O programa permite ao operador gerar um relatório ao usuário de todo o consumo do local, funcionalidade promovida através de um
JOptionPane que exibe uma caixa de texto na tela com os respectivos dados da comanda.

________________________________________________________________________________________________________________________________________
Modelo de dados utlizados

Disponível através do link: https://drive.google.com/drive/folders/0B3LEDVDRlngebV9GYlptU1dZS1U?usp=sharing

________________________________________________________________________________________________________________________________________
Campos necessários para construção da tela

A classe JanelaTrabalho.java extende a classe JFrame, sendo esta uma classe necessária para todo funcionamento do projeto. Para
manipulação dos botões foi utilizado objetos da classe JButton. Para manipulação da lista de pedidos foi utilizado um objeto 
da classe JTable. Para ulização das listas de itens do cardápio foi utlizado JComboBox. E para gerir a organização dos botões,
listas e títulos foi utlizado um JPanel.

________________________________________________________________________________________________________________________________________
Pontos importantes do funcionamento da interface

A interface tem seu tamanho fixo, e a tabela não está e/ou não se altera com a quantidade de itens que vai crescendo na horizontal, porém durante a listagem de casa pedido, todos os itens aparecem.
________________________________________________________________________________________________________________________________________
Pontos mais mais difíceis de implementar

Manipulação de arrayList junto com o o JTableModel, visto que ao selecionar uma linha na tabela, o numero da mesa é tratado como index dento do arraylist listapedidos que por sua vez armazera vários objetos "pedidos" com outros dois arraylists dentro de cada objeto "pedido" referentes a lista de bebida e comida.
________________________________________________________________________________________________________________________________________
Melhorias futuras

Melhoria na parte de interface, comunicação com o usuário, layout de telas...
Inclusão de imagens referentes aos itens do cardápio, troca de botões por imagens sugestivas como, por exemplo, uma imagem de um "+" ao
botão "adicionar".


