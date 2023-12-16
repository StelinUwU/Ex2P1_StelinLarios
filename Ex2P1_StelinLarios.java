/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex2p1_stelinlarios;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author stelinlarios silla 7 - filas 3 (ultima)
 */
public class Ex2P1_StelinLarios {

    /**
     * @param args the command line arguments
     */
    public static Scanner sc = new Scanner(System.in);
    public static boolean isPlaying = false;
    public static ArrayList<Personaje> party = new ArrayList<>();
    public static ArrayList<Personaje> reserve = new ArrayList<>();
    public static ArrayList<Item> backpack = new ArrayList<>();
    public static int roomCount = 0;

    public static void main(String[] args) {

        int selectedOption = 0;

        boolean leave1stMenu = false;

        while (!leave1stMenu) {
            System.out.println("Seleccione una opción:");
            System.out.println("1.Kingdom Hearts Re-Re:Coded!");
            System.out.println("2.Salir");
            selectedOption = sc.nextInt();

            if (selectedOption == 1 || selectedOption == 2) {
                leave1stMenu = true;
            }
        }

        switch (selectedOption) {
            case 1:
                play(sc);
                break;
            case 2:

                break;

            default:
                throw new AssertionError();
        }

    }

    public static void play(Scanner sc) {

        boolean isPlaying = true;

        createItemsAndCharacters();

        while (isPlaying && roomCount < 30) {
            getRandomEvent();
            roomCount++;

            if (roomCount >= 30) {
                System.out.println("Adios :)");
                break;
            }
        }
    }

    public static void showMenu() {
        System.out.println("---Menu---");
        System.out.println("1.Attack");
        System.out.println("2.Magic");
        System.out.println("3.Items");
        System.out.println("4.Party");
    }

    public static void createItemsAndCharacters() {
        Personaje sora = new Personaje("Sora", 300, 300, 75, 15);
        party.add(sora);
        sora.print();

        Personaje donald = new Personaje("Donald", 150, 450, 45, 10);
        party.add(donald);
        donald.print();

        Personaje goofy = new Personaje("Goofy", 450, 100, 150, 50);
        party.add(goofy);
        goofy.print();

        Personaje mickey = new Personaje("Mickey", 100, 500, 150, 35);
        reserve.add(mickey);

        Personaje roxas = new Personaje("Roxas", 300, 300, 15, 75);
        reserve.add(roxas);

        Personaje kairi = new Personaje("Kairi", 200, 200, 50, 15);
        reserve.add(kairi);

        Item pocion = new Item("Pocion", 50, 0);
        backpack.add(pocion);
        Item ether = new Item("Ether", 0, 50);
        backpack.add(ether);
        Item elixir = new Item("Elixir", 100, 100);
        backpack.add(elixir);

        checkIfKeppPlaying();

    }

    public static void getRandomEvent() {

        Random rand = new Random();

        int event = rand.nextInt(1, 6);

        switch (event) {
            case 1:
                int enemies = rand.nextInt(1, 3);
                System.out.println("Te has encontrado a " + enemies + " Heartless");
                fight(enemies);
                break;
            case 2:
                backpack.add(new Item("Pocion", 50, 0));
                System.out.println("Te has encontrado un cofre que contiene una Poción");
                checkIfKeppPlaying();

                break;
            case 3:
                backpack.add(new Item("Ether", 0, 50));
                System.out.println("Te has encontrado un cofre que contiene un Ether");
                checkIfKeppPlaying();

                break;
            case 4:
                backpack.add(new Item("Elixir", 100, 100));
                System.out.println("Te has encontrado un cofre que contiene un Elixir");
                checkIfKeppPlaying();
                break;
            case 5:
                System.out.println("VideoGame desbalanceado");
                int cuantosItemsPerdistePorEsteUnbalancedVideogame = rand.nextInt(1, backpack.size());
                System.out.println("Te has encontrado amigos que ocupan de tu ayuda y decides darles " + cuantosItemsPerdistePorEsteUnbalancedVideogame + " items");
                removeItemsFromBackpack(cuantosItemsPerdistePorEsteUnbalancedVideogame);

                checkIfKeppPlaying();
                break;
            default:
                throw new AssertionError();
        }
    }

    public static void fight(int cantidadHeartless) {
        int hpHeartless = 75 * cantidadHeartless;
        int ataqueHeartless = 25;

        while (hpHeartless > 0 && !party.isEmpty()) {
            System.out.println("Elige un personaje de la party:");
            for (int i = 0; i < party.size(); i++) {
                Personaje heroe = party.get(i);
                System.out.println((i + 1) + ". " + heroe.nombre + " - HP: " + heroe.hp + ", MP: " + heroe.mp + ", Ataque: " + heroe.attackPoints + ", Defensa: " + heroe.defensePoints);
            }

            int eleccion = sc.nextInt() - 1;
            Personaje personajeElegido = party.get(eleccion);
            showMenu();
            int accion = sc.nextInt();

            switch (accion) {
                case 1:
                    hpHeartless -= personajeElegido.attackPoints;
                    System.out.println(personajeElegido.nombre + " atacó, causando " + personajeElegido.attackPoints + " de daño");
                    break;
                case 2:
                    showMPMenu();
                    int hechizo = sc.nextInt();

                    switch (hechizo) {
                        case 1:
                            if (personajeElegido.mp >= 50) {
                                personajeElegido.mp -= 50;
                                hpHeartless -= 50;
                                System.out.println(personajeElegido.nombre + " uso Blizzard");
                            } else {
                                System.out.println("MP insuficiente para Blizzard");
                            }
                            break;
                        case 2:
                            if (personajeElegido.mp >= 25) {
                                personajeElegido.mp -= 25;
                                hpHeartless -= 25;
                                System.out.println(personajeElegido.nombre + " uso Firaga");
                            } else {
                                System.out.println("MP insuficiente para Firaga");
                            }
                            break;
                        case 3:
                            if (personajeElegido.mp >= 75) {
                                personajeElegido.mp -= 75;
                                hpHeartless -= 100;
                                System.out.println(personajeElegido.nombre + " uso Gravity");
                            } else {
                                System.out.println("MP insuficiente para Gravity");
                            }
                            break;
                    }
                    break;
                case 3:
                    showItems();
                    int itemChoice = sc.nextInt() - 1;

                    if (itemChoice >= 0 && itemChoice < backpack.size()) {
                        Item selectedItem = backpack.get(itemChoice);
                        useItem(selectedItem, personajeElegido);
                    } else {
                        System.out.println("Selección inválida.");
                    }
                    break;
                case 4:
                    showReserve();
                    System.out.println("Selecciona un personaje de la reserva para intercambiar:");
                    int reserveChoice = sc.nextInt() - 1;

                    if (reserveChoice >= 0 && reserveChoice < reserve.size()) {
                        int indexEnParty = 777;
                        for (int i = 0; i < party.size(); i++) {
                            if (party.get(i) == personajeElegido) {
                                indexEnParty = i;
                                break;
                            }
                        }

                        if (indexEnParty != 777) {
                            Personaje reserveCharacter = reserve.get(reserveChoice);
                            party.set(indexEnParty, reserveCharacter);
                            reserve.set(reserveChoice, personajeElegido);

                            personajeElegido = reserveCharacter;
                            System.out.println("Listo precioso");
                        } else {
                            System.out.println("Happens");
                        }
                    } else {
                        System.out.println("Selección inválida.");
                    }
                    break;
            }

            personajeElegido.hp -= ataqueHeartless;
            System.out.println(personajeElegido.nombre + " recibió un golpe, quedando con " + personajeElegido.hp + " HP.");

            if (personajeElegido.hp <= 0) {
                party.remove(personajeElegido);
                System.out.println(personajeElegido.nombre + " ha sido derrotado.");
                if (party.isEmpty()) {
                    System.out.println("Tu party ha sido derrotada.");
                    return;
                }
            }

            System.out.println("HP restante de los Heartless: " + hpHeartless);
            System.out.println("Miembros restantes de la party: " + party.size());
        }

        if (hpHeartless <= 0) {
            System.out.println("¡Has wipeado a todos los Heartless!");
        } else {
            System.out.println("Tu party ha sido wipeada");
            isPlaying = false;
        }
        checkIfKeppPlaying();

    }

    public static void removeItemsFromBackpack(int cuantosItemsPerdistePorEsteUnbalancedVideogame) {

        System.out.println("Cantidad inicial de items " + backpack.size());
        for (int i = 0; i < cuantosItemsPerdistePorEsteUnbalancedVideogame; i++) {
            backpack.remove(0);

        }
        System.out.println("Cantidad actual de items " + backpack.size());

    }

    public static void showMPMenu() {
        System.out.println("Elige un hechizo:");
        System.out.println("1. Blizzard - 50MP - 50DMG");
        System.out.println("2. Firaga - 25MP - 25DMG");
        System.out.println("3. Gravity - 75MP - 100DMG");
    }

    public static void showItems() {
        System.out.println("Elige un ítem:");
        for (int i = 0; i < backpack.size(); i++) {
            Item item = backpack.get(i);
            System.out.println((i + 1) + ". " + item.nombre + " - Restaura HP: " + item.hpPoints + ", Restaura MP: " + item.mpPoints);
        }
    }

    public static void useItem(Item item, Personaje personaje) {
        personaje.hp += item.hpPoints;
        personaje.mp += item.mpPoints;
        System.out.println(personaje.nombre + " ha usado " + item.nombre + ".");
        backpack.remove(item);
    }

    public static void checkIfKeppPlaying() {

        System.out.println("Deseas continuar?");
        sc.next();

    }

    public static void showReserve() {
        if (reserve.isEmpty()) {
            System.out.println("Nos quedamos sin reservas");
        } else {
            System.out.println("Personajes en la reserva:");
            for (int i = 0; i < reserve.size(); i++) {
                int option = i + 1;
                System.out.print(option + ". ");
                reserve.get(i).print();
            }
        }
    }

}
