// O que é um controller: é onde o usuario final vai executar as funcoes, é a ponte de acesso
// para que o mesmo execute funcoes em um sistema.

package controller;
// importando os usecases
import usecases.EscolherPalavraUseCase;
import usecases.FornecerDicaUseCase;
import usecases.JogoDePalavrasUseCase;

// O controller é responsavel por chamar os nossos casos de uso
// quais sao os casos de uso que temos?
// 1. Escolher uma palavra
// 2. Fornecer dica
// 3. Jogo de palavras

public class JogoController {
    // chamando os casos de uso aqui
    private final EscolherPalavraUseCase escolherPalavraUseCase;
    private final FornecerDicaUseCase fornecerDicaUseCase;
    private final JogoDePalavrasUseCase jogoDePalavrasUseCase;

    public JogoController() {
        // criando uma funcao para iniciar os usecases
        this.escolherPalavraUseCase = new EscolherPalavraUseCase();
        this.fornecerDicaUseCase = new FornecerDicaUseCase();
        this.jogoDePalavrasUseCase = new JogoDePalavrasUseCase();
    }

    public void iniciarJogo() {
        // criando uma funcao para iniciar o jogo
        jogoDePalavrasUseCase.jogar();
    }
}
