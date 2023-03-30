package JavaOrgExample.One;

/**
 * Box box1 = new Box();
 *
 */
public class Box<T> {

    private T polje;

    public void setPolje(T polje) {
        this.polje = polje;
    }

    public T getPolje() {
        return polje;
    }
}
