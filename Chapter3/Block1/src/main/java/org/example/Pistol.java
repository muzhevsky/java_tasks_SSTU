package org.example;

public class Pistol {
    protected int maxAmmo;
    protected int ammo;

    public Pistol(){
        this(5,5);
    }
    public Pistol(int ammo){
        this(ammo,ammo);
    }
    public Pistol(int ammo, int maxAmmo){
        if (ammo < 0 && maxAmmo < 0)
            throw new IllegalArgumentException("ammo amount cant be less then zero");

        this.maxAmmo = maxAmmo;
        this.ammo = ammo;
    }

    public void shoot(){
        if(ammo > 0){
            System.out.println("bah");
            ammo--;
            return;
        }
        System.out.println("click");
    }

    public int reload(int ammo){
        if(ammo < 0)
            throw new IllegalArgumentException("ammo amount cant be less then 0)");

        this.ammo += ammo;
        ammo = 0;

        if(this.ammo > this.maxAmmo){
            ammo = this.ammo - this.maxAmmo;
            this.ammo = this.maxAmmo;
        }

        return ammo;
    }

    public void unload(){
        ammo = 0;
    }

    public int ammoLeft(){
        return ammo;
    }

    public boolean isLoaded(){
        return ammo > 0;
    }
}
