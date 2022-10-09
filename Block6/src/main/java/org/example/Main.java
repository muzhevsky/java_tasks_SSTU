package org.example;

public class Main {
    public static void main(String[] args) {
        Pistol pistol = new Pistol();
        System.out.println(pistol.isLoaded());
        System.out.println(pistol.ammoLeft());

        pistol.unload();

        System.out.println(pistol.isLoaded());
        System.out.println(pistol.ammoLeft());
    }
}