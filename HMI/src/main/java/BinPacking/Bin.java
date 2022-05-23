package BinPacking;

public class Bin {
    int maxVolume;
    int currentVolume;
    int blueCount;
    int redCount;
    int greenCount;

    public void addObject(char color, int weight){
        switch(color){
            case 'r':
                redCount++;
                break;
            case 'g':
                greenCount++;
                break;
            case 'b':
                blueCount++;
                break;
        }
        currentVolume += weight;
    }

    public int getCurrentVolume(){
        return currentVolume;
    }

    public Bin(){
        maxVolume = 1000;
        currentVolume = 0;
        blueCount = 0;
        redCount = 0;
        greenCount = 0;
    }

    public Bin(int max){
        maxVolume = max;
        currentVolume = 0;
        blueCount = 0;
        redCount = 0;
        greenCount = 0;
    }

    public Bin(int max, int current){
        maxVolume = max;
        currentVolume = current;
        blueCount = 0;
        redCount = 0;
        greenCount = 0;
    }
}
