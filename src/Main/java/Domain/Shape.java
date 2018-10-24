package Domain;

import java.io.Serializable;

public abstract class Shape implements Serializable {

    private int id;

    public String getType() {
        return this.getClass().getSimpleName();
    }

    /**
     *
     * @return
     */
    public abstract double calculateVolume();

    /**
     *
     * @return
     */
    public int getId() {
        return this.id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }
}