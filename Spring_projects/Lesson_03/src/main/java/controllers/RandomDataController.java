package controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Random;
import java.util.UUID;

@RestController
public class RandomDataController {
    @GetMapping("/uuid")
    public String getRandomUUID() {
        UUID uuid = UUID.randomUUID();
        return String.format("UUID: %1s", uuid);
    }

    @GetMapping("/exchange")
    public String getRandomExchangeRate() {
        double exchangeRate = new Random().nextDouble() * 40 + 20;
        return String.format("Exchange rate: %1s", exchangeRate);
    }

    @GetMapping("/exchange/{currency}")
    public String getExchangeRateForCurrency(@PathVariable String currency) {
        double exchangeRate = new Random().nextDouble() * 50 +10;
        return String.format("%1s exchange rate: %2s", currency, exchangeRate);
    }
}

