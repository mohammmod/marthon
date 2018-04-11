package at.refugeescode.marathon;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class Initilaizer {
    @Bean
    ApplicationRunner applicationRunner (RunnersInfo runnersInfo){
        return args -> {
            Runners mohammad = new Runners("mohammad", Duration.ofSeconds(20));
            Runners sawas = new Runners("sawas", Duration.ofSeconds(10));

            runnersInfo.addRunners(mohammad);
            runnersInfo.addRunners(sawas);
            System.out.println(mohammad.getName() + " " + mohammad.getTime());
        };
    }
}
