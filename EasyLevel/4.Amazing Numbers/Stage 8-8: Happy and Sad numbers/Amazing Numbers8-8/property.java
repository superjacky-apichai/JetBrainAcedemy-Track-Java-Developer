package numbers;

public enum property {

    EVEN("-EVEN", 0), ODD("-ODD", 1), BUZZ("-BUZZ", 2), DUCK("-DUCK", 3), PALINDROMIC("-PALINDROMIC", 4), GAPFUL("-GAPFUL", 5)
    , SPY("-SPY", 6), SQUARE("-SQUARE", 7), SUNNY("-SUNNY", 8), JUMPING("-JUMPING", 9),HAPPY("-HAPPY",10),SAD("-SAD",11);


    property(String section, int number) {
        this.section = section;
        this.number = number;
    }

    String section;
    int number;


}
