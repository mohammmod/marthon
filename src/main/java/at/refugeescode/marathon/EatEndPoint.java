package at.refugeescode.marathon;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/eat")
public class EatEndPoint {

    private RestTemplate restTemplate;

    public EatEndPoint(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    String eat() {
        // which snacks are in the fridge?
        // if there are no snacks - my fridge is empty
        // if there are snacks - i choose one, and i eat it

        // which snacks are in the fridge?
        // I need to talk with the fridge - GET request
        // 1.- where to - url
        // 2.- what do we expect to receive - response

        String url = "http://localhost:8081/snacks";

        ResponseEntity<Snack[]> response = restTemplate.getForEntity(url, Snack[].class);
        List<Snack> snacks = Arrays.asList(response.getBody());

        // if there are no snacks - my fridge is empty
        if (snacks.isEmpty()) {
            return "My fridge is empty, I need to go to the supermarket!";
        }

        // if there are snacks - i choose one, and i eat it
        Collections.shuffle(snacks);
        Snack snack = snacks.get(0);
        String deleteUrl = url + "/" + snack.getName();
        restTemplate.delete(deleteUrl);

        return "I ate the snack " + snack.getName();
    }
}
