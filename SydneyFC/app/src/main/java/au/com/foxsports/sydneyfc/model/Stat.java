package au.com.foxsports.sydneyfc.model;

/**
 * Created by bclark on 23/02/17.
 */

public class Stat {
    private String type;
    private String value;

    public Stat(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
