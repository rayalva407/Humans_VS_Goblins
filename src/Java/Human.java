public class Human {

    private int strength;
    private int health;
    private int hPos;
    private int vPos;

    // Getters and Setters
    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHPos() {
        return hPos;
    }

    public void setHPos(int hPos) {
        this.hPos = hPos;
    }

    public int getVPos() {
        return vPos;
    }

    public void setVPos(int vPos) {
        this.vPos = vPos;
    }

    @Override
    public String toString() {
        return "H";
    }
}
