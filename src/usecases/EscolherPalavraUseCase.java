package usecases;

import java.util.Random;

public class EscolherPalavraUseCase {

    private static final String[] PALAVRAS = {
            "abrir", "buscar", "celar", "dados", "eixo", "focal", "grito", "hoje",
            "irado", "jogar", "luzes", "meio", "nobre", "olhar", "perto", "quase",
            "raiva", "saldo", "tempo", "uivar", "vagao", "xaxim", "livro", "zelar"
    };

    public static String escolherPalavra() {
        Random random = new Random();

        try {
            return PALAVRAS[random.nextInt(PALAVRAS.length)];
        } catch (Exception e) {
            System.err.println("Erro ao escolher palavra: " + e.getMessage());
            return ""; 
        }
    }
}
