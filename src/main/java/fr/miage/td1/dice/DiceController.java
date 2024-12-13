package fr.miage.td1.dice;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@Slf4j
@Transactional
public class DiceController {

    private final DiceService diceService;
    Dice dice;

    public DiceController(DiceService diceService) {
        this.diceService = diceService;
        this.dice = new Dice();
    }

    @GetMapping("/rollDice")
    public ArrayList<Integer> rollDice() {
        return diceService.rollDice(1);
    }

    @GetMapping("/rollDices/{x}")
    public ArrayList<Integer> rollDice(@PathVariable int x) {
        return diceService.rollDice(x);
    }
}
