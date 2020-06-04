package shared.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public abstract class Identifier implements Serializable {

    final protected String value;

    public Identifier(String value) {
        ensureValidUUID(value);

        this.value = value;
    }

    private void ensureValidUUID(String value) throws IllegalArgumentException{
        UUID.fromString(value);
    }

    protected Identifier(){
        this.value = null;
    }

    public String getValue(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identifier that = (Identifier) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
