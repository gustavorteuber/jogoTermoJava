package usecases;

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class JogoDePalavrasUseCase {

    private static final int MAX_TENTATIVAS = 5;
    private final FornecerDicaUseCase fornecerDicaUseCase = new FornecerDicaUseCase();

    public void jogar() {
        String palavraSecreta = EscolherPalavraUseCase.escolherPalavra();
        int tamanhoPalavra = palavraSecreta.length();
        Scanner scanner = new Scanner(System.in);
        String palpite;
        int tentativas = 0;
        
        System.out.println("A palavra secreta escolhida é: " + palavraSecreta);
        System.out.println("Bem-vindo ao jogo! Tente adivinhar a palavra.");
        System.out.println("Você tem " + MAX_TENTATIVAS + " tentativas. A palavra tem " + tamanhoPalavra + " letras.");

        while (tentativas < MAX_TENTATIVAS) {
            System.out.println();
            System.out.print("Digite seu palpite: ");
            palpite = scanner.nextLine().toLowerCase();

            if (palpite.length() != tamanhoPalavra) {
                System.out.println("Você digitou uma palavra com tamanho diferente do necessário (" + tamanhoPalavra + " letras). Tente novamente.");
                continue;
            }

            tentativas++;

            if (palpite.equals(palavraSecreta)) {
                exibirMensagemVitoria(tentativas, palavraSecreta);
                scanner.close();
                return;
            } else {
                fornecerDica(palavraSecreta, palpite, tamanhoPalavra);
            }

            System.out.println("Tentativas restantes: " + (MAX_TENTATIVAS - tentativas));
        }

        System.out.println("Suas tentativas acabaram! A palavra era: " + palavraSecreta);
        scanner.close();
    }

    private void fornecerDica(String palavraSecreta, String palpite, int tamanhoPalavra) {
        fornecerDicaUseCase.fornecerDica(palavraSecreta, palpite, tamanhoPalavra);
    }

    private void exibirMensagemVitoria(int tentativas, String palavraSecreta) {
        int resposta = JOptionPane.showConfirmDialog(null,
                "<html>Parabéns!!<br>Você acertou a palavra!!<br><br>Tentativas: " + tentativas +
                        "<br>Palavra misteriosa: " + palavraSecreta + "<br><br>Deseja jogar novamente?</html>",
                "Vitória!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (resposta == JOptionPane.YES_OPTION) {
            for (int i = 0; i < 2; i++) {
                System.out.println();
            }
            System.out.println("---------------------------- Novo Jogo -------------------------------");
            jogar();
        }
    }
}
