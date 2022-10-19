package weapons;

public class Pistol extends Weapon {

    private int maxAmmo;

    public Pistol() {
        this(5, 5);
    }

    public Pistol(int ammo) {
        this(ammo, ammo);
    }

    public Pistol(int ammo, int maxAmmo) {
        super(ammo);
        if (maxAmmo < 0)
            throw new IllegalArgumentException("ammo amount cant be less then zero");

        this.maxAmmo = maxAmmo;
    }

    @Override
    public void reload(int ammo) {
        super.reload(ammo);
        if (maxAmmo < ammo)
            ammo = maxAmmo;
    }

    @Override
    public void shoot() {
        if (ammo > 0) {
            System.out.println("bah");
            ammo--;
            return;
        }
        System.out.println("click");
    }
}
