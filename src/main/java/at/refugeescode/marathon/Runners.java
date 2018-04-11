package at.refugeescode.marathon;

import java.time.Duration;

public class Runners {
    private String name;
    private Duration time;

    public Runners(String name , Duration time ){
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Duration getTime() {
        return time;
    }

    public void setTime(Duration time) {
        this.time = time;
    }
}
