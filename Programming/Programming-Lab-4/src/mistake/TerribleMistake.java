package mistake;
public class TerribleMistake {
    protected String desciption;

    public TerribleMistake(String desciption) {
        this.desciption = desciption;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    @Override
    public String toString() {
        return "TerribleMistake [id=" + hashCode() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof TerribleMistake))
            return false;
        TerribleMistake other = (TerribleMistake) obj;
        return desciption == other.desciption;
    }

    @Override
    public int hashCode() {
        return desciption.hashCode();
    }

}
