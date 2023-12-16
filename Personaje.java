/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex2p1_stelinlarios;

/**
 *
 * @author stelinlarios
 */
public class Personaje {

    public String nombre;
    public int hp;
    public int mp;
    public int attackPoints;
    public int defensePoints;

    public Personaje(String nombre, int hp, int mp, int attack, int defense) {
        this.nombre = nombre;
        this.hp = hp;
        this.attackPoints = attack;
        this.defensePoints = defense;
        this.mp = mp;
    }

    public void print() {
        System.out.println(this.nombre);
        System.out.println("HP=" + this.hp);
        System.out.println("Attack P.=" + this.attackPoints);
        System.out.println("Defense P.=" + this.defensePoints);
        System.out.println("");
    }
    

}
