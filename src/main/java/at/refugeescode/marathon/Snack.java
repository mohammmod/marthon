package at.refugeescode.marathon;

public class Snack {
    private String name;

    public Snack() {
    }

    public Snack(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Snack{" +
                "name='" + name + '\'' +
                '}';
    }


}
