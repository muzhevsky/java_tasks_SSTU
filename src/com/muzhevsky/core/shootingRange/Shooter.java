package com.muzhevsky.core.shootingRange;

public class Shooter {
    public Weapon weapon;
    private String name;

    public Shooter(String name) {
        if (name == null && name.length() <= 3)
            throw new IllegalArgumentException("invalid name");

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        if (name == null && name.length() <= 3)
            throw new IllegalArgumentException("invalid name");

        this.name = name;
    }

    public void shoot() {
        if (weapon == null) {
            System.out.println("I cant feel my weapon!! Bubba, they ain't there.");
            return;
        }

        weapon.shoot();
    }
}
