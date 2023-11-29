package usecases;

public class FornecerDicaUseCase {

    public void fornecerDica(String palavraSecreta, String palpite, int tamanhoPalavra) {
        StringBuilder palavraMisteriosa = new StringBuilder("-".repeat(tamanhoPalavra));
        StringBuilder letrasCorretasPosicaoCorreta = new StringBuilder();
        StringBuilder letrasCorretasPosicaoErrada = new StringBuilder();

        for (int i = 0; i < tamanhoPalavra; i++) {
            char letraPalpite = palpite.charAt(i);
            if (letraPalpite == palavraSecreta.charAt(i)) {
                palavraMisteriosa.setCharAt(i, letraPalpite);
                letrasCorretasPosicaoCorreta.append(letraPalpite).append(",");
            } else if (palavraSecreta.indexOf(letraPalpite) != -1 && letraPalpite != palpite.charAt(palavraSecreta.indexOf(letraPalpite))) {
                letrasCorretasPosicaoErrada.append(letraPalpite).append(",");
            }
        }

        if (letrasCorretasPosicaoCorreta.length() > 0) {
            letrasCorretasPosicaoCorreta.setCharAt(letrasCorretasPosicaoCorreta.length() - 1, '.');
        }

        if (letrasCorretasPosicaoErrada.length() > 0) {
            letrasCorretasPosicaoErrada.setCharAt(letrasCorretasPosicaoErrada.length() - 1, '.');
        }

        System.out.println("----------------------------------------------------------------");
        System.out.println("Letra correta na posição correta: " + (letrasCorretasPosicaoCorreta.length() > 0 ? letrasCorretasPosicaoCorreta.toString() : "Nenhuma."));
        System.out.println("Letra correta na posição errada: " + (letrasCorretasPosicaoErrada.length() > 0 ? letrasCorretasPosicaoErrada.toString() : "Nenhuma."));
        System.out.println("Palavra misteriosa está no momento desta maneira: \"" + palavraMisteriosa + "\"");
        System.out.println("----------------------------------------------------------------");
    }
}
