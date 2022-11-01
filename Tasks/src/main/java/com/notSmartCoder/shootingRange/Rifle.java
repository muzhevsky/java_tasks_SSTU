package com.notSmartCoder.shootingRange;

public class Rifle extends Pistol{
    final int fireRate;

    public Rifle(){
        super(10);
        fireRate = 10;
    }
    public Rifle(int maxAmmo){
        super(maxAmmo);
        fireRate = maxAmmo/2;
    }
    public Rifle(int maxAmmo, int fireRate){
        super(maxAmmo);
        if (fireRate < 0)
            throw new IllegalArgumentException("firerate cannot be less then zero");
        this.fireRate = fireRate;
    }

    @Override
    public void shoot(){
        for(int i = 0; i < fireRate; i++)
            super.shoot();
    }

    public void shoot(int seconds){
        for(; seconds > 0; seconds--)
            shoot();
    }
}
