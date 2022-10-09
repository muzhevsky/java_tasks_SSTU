package org.example;

public class Pistol {
    private int maxAmmo;
    private int currentAmmo;

    public Pistol(){
        maxAmmo = 5;
        currentAmmo = maxAmmo;
    }
    public Pistol(int ammo){
        if (ammo > -1){
            maxAmmo = ammo;
            currentAmmo = maxAmmo;
        }
        else
            throw new IllegalArgumentException("ammo amount cant be less then zero");
    }

    public void shoot(){
        if(currentAmmo > 0){
            System.out.println("bah");
            currentAmmo--;
        }
        else
            System.out.println("click");
    }
}
