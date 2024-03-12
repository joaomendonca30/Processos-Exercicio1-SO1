package view;

import controller.RedesController;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        RedesController redesController = new RedesController();

        while (true) {
            String[] options = {"IP", "Ping", "Finalizar"};
            int choice = JOptionPane.showOptionDialog(null, "Escolha uma das opções", "Redes Controller",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    redesController.ip();
                    break;
                case 1:
                    redesController.ping();
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        }
    }
}