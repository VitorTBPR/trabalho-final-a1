Projeto Jogo de Trivia
Informações Gerais sobre o Projeto
Descrição
Este é um jogo de trivia que permite aos jogadores responder perguntas e acumular pontos com base em suas respostas corretas. O sistema possui dois tipos de usuários: Players e Admins. Admins podem gerenciar perguntas e jogadores, enquanto os Players participam do jogo respondendo às perguntas.

Objetivos
Proporcionar um jogo de trivia interativo.
Permitir a gestão de usuários e perguntas por Admins.
Armazenar pontuações e exibir uma tabela de classificação.

Funcionalidades Principais
Cadastro e autenticação de Players e Admins.
Inserção de perguntas pelo Admin.
Jogo de trivia com perguntas de múltipla escolha.
Armazenamento e exibição de pontuações dos jogadores.
Exibição de uma tabela de classificação (scoreboard).

Informações sobre as Classes e suas Relações

Classes do Projeto
1. controller.Arquivo
Responsável pelo gerenciamento de arquivos, como salvar e carregar dados de jogadores, admins e perguntas.

2. controller.GerenciadorAdmins
Gerencia as operações relacionadas aos Admins, incluindo adicionar, remover, autenticar e listar Admins.

3. controller.GerenciadorPlayers
Gerencia as operações relacionadas aos Players, incluindo cadastro, edição, remoção, busca e exibição de players e suas pontuações.

4. controller.JogoTrivia
Controla a lógica do jogo de trivia, incluindo a inicialização do jogo, apresentação das perguntas e cálculo da pontuação.

5. controller.Sistema
Gerencia o fluxo principal do sistema, exibindo menus e controlando a navegação entre as diferentes funcionalidades.

6. model.Admin
Representa um Admin, estendendo a classe Player. Possui métodos adicionais específicos para as funcionalidades de um Admin.

7. model.Pergunta
Representa uma pergunta do jogo de trivia, incluindo o enunciado, opções de resposta e a resposta correta.

8. model.Player
Representa um jogador do jogo de trivia, com atributos como nome, senha e pontuação.

9. view.Console
Fornece métodos para leitura de entradas do console, como inteiros, floats e strings.

10. Principal
Onde fica a main

Relações entre as Classes
Associação: GerenciadorPlayers e GerenciadorAdmins utilizam a classe Arquivo para carregar e salvar dados de jogadores e admins.
JogoTrivia utiliza Pergunta para compor as perguntas do jogo.
Sistema utiliza GerenciadorPlayers e GerenciadorAdmins para gerenciar o fluxo do sistema.

Composição: jogoTrivia possui uma lista de Pergunta e um objeto Player representando o jogador atual.

Agregação: GerenciadorPlayers e GerenciadorAdmins mantêm listas de objetos Player e Admin, respectivamente.

Uso do ChatGPT: o uso do chatGPT foi utilizado para auxiliar no raciocínio de lógica para aplicar o que foi pensado, além do auxílio para aplicação de clean code no sistema.

Referências e Recursos: foram utilizados como referências os seguintes itens:
Vídeo do Youtube: "como fazer Jogo (QUIZ-Java) Código e configurações adicionais" - link: https://www.youtube.com/watch?v=OoZW71ppfnA
As aulas salvas no repositório java-ecoville
ChatGPT para saneamento de dúvidas pontuais e auxilio na lógica de programação.











