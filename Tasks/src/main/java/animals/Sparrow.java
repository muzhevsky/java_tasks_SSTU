package animals;

public class Sparrow extends Bird {

    public Sparrow(boolean isFlyable, ColorRGB color){
        super(isFlyable, color);
    }
    @Override
    public void sing() {
        System.out.println("chirick");
    }
}
