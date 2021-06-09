package numbers;

public enum property {

    BUZZ("BUZZ",0), DUCK("DUCK",1), PALINDROMIC("PALINDROMIC",2)

    , GAPFUL("GAPFUL",3), SPY("SPY",4), SQUARE("SQUARE",5)

    , SUNNY("SUNNY",6), JUMPING("JUMPING",7), EVEN("EVEN",8), ODD("ODD",9);


    property(String section, int number) {
        this.section = section;
        this.number = number;
    }

    String section;
    int number;


}
