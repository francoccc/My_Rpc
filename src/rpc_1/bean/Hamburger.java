package rpc_1.bean;

import java.io.Serializable;

/**
 * Hamburger bean
 *
 * @Author Franco
 */
public class Hamburger implements Serializable {

    private static final long serialVersionUID = -7791678740074980564L;

    private String vegetable;
    private String meat;
    private String sauce;

    public String getVegetable() { return vegetable; }

    public void setVegetable(String vegetable) {
        this.vegetable = vegetable;
    }

    public String getMeat() {
        return meat;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public String toString() {
        return vegetable + " " + meat + " " + sauce + " hamburger";
    }
}
