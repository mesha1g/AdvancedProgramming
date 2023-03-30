package JavaOrgExample.Four.Generic;

public class NumberBox<E extends Number>{
    private E number;

    public void setNumber(E number) {
        this.number = number;
    }

    public E getNumber() {
        return number;
    }
}

