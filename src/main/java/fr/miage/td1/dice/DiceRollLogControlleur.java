package fr.miage.td1.dice;


import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@Transactional
public class DiceRollLogControlleur {

    private final DiceRepository diceRepository;

    @Autowired
    public DiceRollLogControlleur(DiceRepository diceRepository) {
        this.diceRepository = diceRepository;
    }

    @GetMapping("/diceLogs")
    public List<DiceRollLog> diceLogs() {
        return this.diceRepository.findAll();
    }
}
