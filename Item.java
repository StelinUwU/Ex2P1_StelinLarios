package ex2p1_stelinlarios;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author stelinlarios
 */
public class Item {

    public String nombre;
    public int hpPoints;
    public int mpPoints;

    public Item(String nombre, int hpPoints, int mpPoints) {
        this.nombre = nombre;
        this.hpPoints = hpPoints;
        this.mpPoints = mpPoints;

    }

    public String getNombre() {
        return nombre;
    }

    public int getHpPoints() {
        return hpPoints;
    }

    public int getMpPoints() {
        return mpPoints;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setHpPoints(int hpPoints) {
        this.hpPoints = hpPoints;
    }

    public void setMpPoints(int mpPoints) {
        this.mpPoints = mpPoints;
    }
}
