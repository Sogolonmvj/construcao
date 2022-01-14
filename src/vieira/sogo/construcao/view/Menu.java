package vieira.sogo.construcao.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    Scanner scan;
    private UserView userView;

    public Menu() {
        this.scan = new Scanner(System.in);
    }

    public void app() {
        this.userView = new UserView();
    }

    public void start() {
        System.out.println("#: Deseja iniciar a aplicação?");
        System.out.println("#: 1 - Sim  2 - Não");
        System.out.print("#: ");
        this.enteredValue();
    }

    public void enteredValue() {
        int input = 0;

        do {
            try {
                input = scan.nextInt();
                if (input != 1 && input != 2) {
                    System.out.println("#: Opção inválida, tente novamente.");
                    System.out.print("#: ");
                    input = 0;
                }
            } catch (InputMismatchException e) {
                System.out.println("#: Precisamos que digite apenas números, tente novamente.");
                System.out.print("#: ");
            }
        } while (input == 0);

        System.out.println(" ");

        if (input == 1) {
            this.app();
        } else if (input == 2) {
            System.out.println("#: Saindo da aplicação...");
            System.out.println("...");
            System.out.println("#: Aplicação fechada com sucesso!");
        }
    }

}
