package animals;

import tools.CharManager;
import tools.Swapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Parrot extends Bird{
    private String songLyrics;

    public Parrot(String songLyrics){
        Character[] characterArray = CharManager.stringToCharacter(songLyrics);

        Random random = new Random();
        List<Integer> randomIndexes = new ArrayList<Integer>();

        for(int i = 0; i < characterArray.length; i++){
            if (random.nextInt()%10==0)
                randomIndexes.add(Math.abs(Integer.valueOf(i)));
        }

        while(randomIndexes.size() > 0){
            int idx1 = randomIndexes.get(0);
            int idx2 = Math.abs(random.nextInt())%characterArray.length;
            randomIndexes.remove(0);

            if(characterArray[idx1] == ' ' || characterArray[idx2] == ' ' || characterArray[idx1] == '\n' || characterArray[idx2] == '\n')
                continue;

            Swapper.Swap(characterArray,idx1,idx2);
        }

        CharManager.printSongLyrics(characterArray);

        this.songLyrics = new String(CharManager.characterToChar(characterArray));
    }

    @Override
    public void sing() {
        System.out.println(songLyrics);
    }


}