import java.io.Serializable;
import java.util.Objects;

public class PairA implements Serializable {
    private String key;
    private String value;

    public PairA(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    /*public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PairA pairA = (PairA) o;
        return Objects.equals(key, pairA.key) &&
                Objects.equals(value, pairA.value);
    }*/
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof PairA)) {
            return false;
        } else {
            PairA pair = (PairA)o;
            if (this.key != null) {
                if (!this.key.equals(pair.key)) {
                    return false;
                }
            } else if (pair.key != null) {
                return false;
            }

            if (this.value != null) {
                if (!this.value.equals(pair.value)) {
                    return false;
                }
            } else if (pair.value != null) {
                return false;
            }

            return true;
        }}

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
