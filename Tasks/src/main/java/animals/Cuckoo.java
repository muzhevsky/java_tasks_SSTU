package animals;

import java.util.Random;

public class Cuckoo extends Bird{

    @Override
    public void sing() {
        Random random = new Random();
        for(int i = 0; i < random.nextInt()%10 + 1; i++){
            System.out.println("ku-ku");
        }
    }
}
