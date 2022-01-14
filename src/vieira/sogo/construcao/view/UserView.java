package vieira.sogo.construcao.view;

import vieira.sogo.construcao.controller.User;
import vieira.sogo.construcao.enums.Floor;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserView {
    Scanner scan;
    private List<User> users;
    private List<Double> building;
    private List<Double> floorSize;
    private List<Floor> floor;

    public UserView() {
        this.scan = new Scanner(System.in);
        this.users = new ArrayList<>();
        this.building = new ArrayList<>();
        this.floorSize = new ArrayList<>();
        this.floor = new ArrayList<>();

        String name = this.askName();
        int quantityOfFacilities = this.askQuantityOfFacilities();
        Floor floorType;
        double facilityLength = 0.0;
        double facilityWidth = 0.0;
        double floorArea = 0.0;

        for (int facility = 0; facility < quantityOfFacilities; facility++) {
            facilityLength = this.askLength(facility);
            facilityWidth = this.askWidth(facility);
            floorType = askFloorType();

            floorArea = this.calculateFloorArea(floorType.ordinal());

            this.building.add(calculateArea(facilityLength, facilityWidth, floorArea));
            this.floorSize.add(floorArea);
            this.floor.add(floorType);
        }

        this.users.add(new User(name, facilityLength, facilityWidth, quantityOfFacilities));
        printDetails(users, building, floorSize, floor, quantityOfFacilities);
    }

    public String askName() {
        String name = "";

        System.out.println("#: Qual o nome do cliente?");
        System.out.print("#: ");

        do {
            try {
                name = scan.next();
                if (name.isBlank()) {
                    System.out.println("#: Nome inválido, tente novamente.");
                    System.out.print("#: ");
                    name = "";
                }
            } catch (InputMismatchException e) {
                System.out.println("#: Precisamos que digite um nome, tente novamente.");
                System.out.print("#: ");
            }
            scan.nextLine();
        } while (name == "");
        System.out.println(" ");
        return name;
    }

    public double askLength(int facility) {
        double facilityLength = 0.0;

        System.out.printf("#: Qual o comprimento do %d° cômodo, em metros? %n", facility+1);
        System.out.print("#: ");

        do {
            try {
                facilityLength = scan.nextDouble();
                if (facilityLength < 0.1) {
                    System.out.println("#: Valor inválido, insira um valor válido!");
                    System.out.print("#: ");
                    facilityLength = 0.0;
                }
            } catch(InputMismatchException e) {
                System.out.println("#: Precisamos que digite um número, tente novamente.");
                System.out.print("#: ");
                facilityLength = 0.0;
            }
        } while (facilityLength == 0.0);

        return facilityLength;
    }

    public double askWidth(int facility) {
        double facilityWidth = 0.0;

        System.out.printf("#: Qual a largura do %d° cômodo, em metros? %n", facility+1);
        System.out.print("#: ");

        do {
            try {
                facilityWidth = scan.nextDouble();
                if (facilityWidth < 0.1) {
                    System.out.println("#: Valor inválido, insira um valor válido!");
                    System.out.print("#: ");
                    facilityWidth = 0.0;
                }
            } catch(InputMismatchException e) {
                System.out.println("#: Precisamos que digite um número, tente novamente.");
                System.out.print("#: ");
                facilityWidth = 0.0;
            }
        } while (facilityWidth == 0.0);

        return facilityWidth;
    }

    public int askQuantityOfFacilities() {
        int quantityOfFacilities = 0;

        System.out.println("#: Quantos cômodos tem o imóvel?");
        System.out.print("#: ");

        do {
            try {
                quantityOfFacilities = scan.nextInt();
                if (quantityOfFacilities < 0) {
                    System.out.println("#: Valor inválido, insira um valor válido!");
                    System.out.print("#: ");
                    quantityOfFacilities = 0;
                }
            } catch(InputMismatchException e) {
                System.out.println("#: Precisamos que digite um número, tente novamente.");
                System.out.print("#: ");
                quantityOfFacilities = 0;
            }
        } while (quantityOfFacilities == 0);

        return quantityOfFacilities;
    }

    public Floor askFloorType() {
        int index = -1;

        System.out.println("#: Qual o tipo do piso desejado?");
        for (Floor floor : Floor.values()) {
            System.out.printf("%d - %s %n", floor.ordinal(), floor.name());
        }
        System.out.print("#: ");

        do {
            try {
                index = scan.nextInt();

                if (index < 0 || index >= Floor.values().length) {
                    System.out.println("Indice inválido, tente novamente.");
                    System.out.print("#: ");
                    continue;
                }
                for (Floor floor : Floor.values()) {
                    if (index == floor.ordinal() ) {
                        return Floor.valueOf(floor.name());
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("#: Precisamos que digite um número, tente novamente.");
                System.out.print("#: ");
            }
            scan.nextLine();
        } while (index < 0);

        return null;
    }

    public double calculateFloorArea(int index) {
        double floorLength;
        double floorWidth;
        double floorArea;

        switch (index) {
            case 0:
                floorLength = 0.1;
                floorWidth = 0.1;
                break;
            case 1:
                floorLength = 0.2;
                floorWidth = 0.2;
                break;
            case 2:
                floorLength = 0.2;
                floorWidth = 0.1;
                break;
            case 3:
                floorLength = 0.4;
                floorWidth = 0.4;
                break;
            case 4:
                floorLength = 0.6;
                floorWidth = 0.3;
                break;
            case 5:
                floorLength = 0.8;
                floorWidth = 0.2;
                break;
            case 6:
                floorLength = 0.3;
                floorWidth = 0.2;
                break;
            case 7:
                floorLength = 0.3;
                floorWidth = 0.3;
                break;
            case 8:
                floorLength = 0.4;
                floorWidth = 0.3;
                break;
            case 9:
                floorLength = 0.5;
                floorWidth = 0.3;
                break;
            case 10:
                floorLength = 0.6;
                floorWidth = 0.2;
                break;
            case 11:
                floorLength = 0.7;
                floorWidth = 0.3;
                break;
            case 12:
                floorLength = 0.4;
                floorWidth = 0.2;
                break;
            case 13:
                floorLength = 0.5;
                floorWidth = 0.2;
                break;
            case 14:
                floorLength = 0.5;
                floorWidth = 0.1;
                break;
            default:
                System.out.println("#: Opção inválida");
                System.out.println("#: ");
                floorLength = 0.0;
                floorWidth = 0.0;
        }

        floorArea = floorLength * floorWidth;

        return floorArea;
    }

    public double calculateArea(double facilityLength, double facilityWidth, double floorArea) {
        double totalArea;
        double floorQuantity;

        totalArea = facilityLength * facilityWidth;

        floorQuantity = totalArea / floorArea;

        return floorQuantity;
    }

    public void printDetails (List<User> users, List<Double> building, List<Double> floorSize, List<Floor> floor, int quantityOfFacilities) {
        int user = 0;

        do {
            System.out.println("\n---------------------------------------------");
            System.out.printf("|                   %s                    |%n", users.get(user).getName());
            System.out.println("---------------------------------------------");
            System.out.printf("Número de cômodos: %d %n", quantityOfFacilities);

            for (int facility = 0; facility < quantityOfFacilities; facility++) {
                System.out.printf("%d° cômodo: %n", facility+1);
                System.out.printf("Quantidade de pisos, com %.2fm², necessária: %.1f pisos %n", floorSize.get(facility), building.get(facility));
                System.out.printf("Tipo de piso selecionado: %s %n", floor.get(facility));
            }

            user++;
        } while (user < users.size());

    }

}
