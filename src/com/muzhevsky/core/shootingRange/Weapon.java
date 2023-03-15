package com.muzhevsky.core.shootingRange;

public abstract class Weapon {
    protected int ammo;

    public Weapon(int ammo) {
        if (ammo < 0)
            throw new IllegalArgumentException("ammo amount cant be less then zero");

        this.ammo = ammo;
    }

    abstract public void shoot();

    public void reload(int ammo) {
        if (ammo < 0)
            throw new IllegalArgumentException("ammo amount cant be less then 0)");

        this.ammo += ammo;
    }

    public void unload() {
        ammo = 0;
    }

    public int ammoLeft() {
        return ammo;
    }

    public boolean isLoaded() {
        return ammo > 0;
    }
}
