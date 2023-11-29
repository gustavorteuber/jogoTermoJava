// entry-point da aplicação

import controller.JogoController;

public class JogoApp {

    public static void main(String[] args) {
        JogoController jogoController = new JogoController();
        jogoController.iniciarJogo();
    }
}
