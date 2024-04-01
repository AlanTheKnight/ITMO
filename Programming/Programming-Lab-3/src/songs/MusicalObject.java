package songs;

public abstract class MusicalObject {
    protected String name;

    public MusicalObject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract String getRepresentation();

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof MusicalObject))
            return false;
        MusicalObject other = (MusicalObject) obj;
        return name == other.name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "MusicalObject [name=" + name + "]";
    }
}
