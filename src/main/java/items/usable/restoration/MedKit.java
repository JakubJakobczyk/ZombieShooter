package items.usable.restoration;

import items.Item;

/**
 * Created by T540p on 2015-05-27.
 */
public class MedKit extends Item {
    private int healthRestored = 400;
    private int charges = 1;


    public int getCharges() {
        return charges;
    }

    public int heal() {
        if (charges > 0) {
            charges = charges - 1;
            return healthRestored;
        } else {
            System.out.printf("SKONCZYLY SIE UZYCIA");
            return 0;
        }
    }
}
