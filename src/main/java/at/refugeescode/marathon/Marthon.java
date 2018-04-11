package at.refugeescode.marathon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class Marthon {
    @Autowired
    private RunnersInfo runnersInfo;

    @GetMapping("/runners")
    List<Runners> getAllRunners(){
        return runnersInfo.getAllRunners();
    }
    @PostMapping("/runners")
    Runners addRunner(@RequestBody Runners runners){
        runnersInfo.addRunners(runners);
        return runners;
    }
    @GetMapping("/runners/{number}")
    public Runners getRunner(@PathVariable int number){
        return runnersInfo.getRunner(number);
    }
    @GetMapping("/winner")
    public Runners getWinner() {
        return runnersInfo.getWinner();
    }
}
