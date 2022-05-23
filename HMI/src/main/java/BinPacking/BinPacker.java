package BinPacking;

import java.util.ArrayList;

public class BinPacker {
    int binAmount;
    ArrayList<Bin> bins;
    int maxVolume;
    int weightRed = 600;
    int weightGreen = 300;
    int weightBlue = 150;

    public BinPacker(int binAmount, int maxVolume){
        this.binAmount = binAmount;
        this.maxVolume = maxVolume;
        bins = new ArrayList<>();
        for(int i = 0; i < binAmount; i++){
            bins.add(new Bin(maxVolume));
        }
    }

    public int addBlock(char color){
        int blockWeight = getColorWeight(color);
        int count = 1;
        for (Bin bin:bins) {
            if(bin.currentVolume + blockWeight <= maxVolume){
                bin.addObject(color, blockWeight);
                return count;
            }
            count++;
        }
        System.out.println("Alle bins zitten vol, blokje is niet toegevoegd");
        return -1;
    }

    public void print(){
        System.out.println("Maximum volume: "+ maxVolume);
        System.out.println("----------------------");
        int count = 1;
        for (Bin bin:bins) {
            System.out.println("* Nr. "+ count +" Current volume: "+ bin.currentVolume +
                    "  Rood: "+ bin.redCount +"  Groen: "+ bin.greenCount +"  Blauw: "+ bin.blueCount);

            count++;
        }
    }

    public int getColorWeight(char color){
        switch(color){
            case 'r':
                return weightRed;
            case 'g':
                return weightGreen;
            case 'b':
                return weightBlue;
        }
        return -1;
    }

    public void setWeightRed(int weightRed) {
        this.weightRed = weightRed;
    }

    public void setWeightGreen(int weightGreen) {
        this.weightGreen = weightGreen;
    }

    public void setWeightBlue(int weightBlue) {
        this.weightBlue = weightBlue;
    }
}
