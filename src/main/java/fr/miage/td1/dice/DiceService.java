package fr.miage.td1.dice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;


@Service
public class DiceService {

    private final DiceRepository diceRepository;

    @Autowired
    public DiceService(DiceRepository diceRepository) {
        this.diceRepository = diceRepository;
    }

    public ArrayList<Integer> rollDice(int number) {
        ArrayList<Integer> rolls = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            rolls.add((int) (Math.random() * 6) + 1);
        }
        // Enregistre les résultat via le DiceRepository
        DiceRollLog log = new DiceRollLog();
        log.setResults(rolls);
        log.setDiceCount(number);
        log.setTimestamp(LocalDateTime.now());
        diceRepository.save(log);

        return rolls;
    }
}
