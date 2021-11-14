package budget;

import java.util.Map;

public interface Menu {

    void getPurchase();

    void setPurchase(String k, Double v);

    int getSize();

    Map getMap();

    void getLoad(String[] fileLoad);

    double getTotalSum();

    void sort();

}
