package at.refugeescode.marathon;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@Service
public class RunnersInfo {
    private List<Runners> allRunners = new ArrayList<>();

    public List<Runners> getAllRunners() {
        return allRunners;
    }

    public void addRunners(Runners runners){
        allRunners.add(runners);
    }
    public Runners getRunner(int number ){
        return allRunners.get(number);
    }
    public Runners getWinner(){
        return allRunners.stream()
                .min(Comparator.comparing(Runners::getTime)).get();
    }
}
