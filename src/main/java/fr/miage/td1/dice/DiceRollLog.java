package fr.miage.td1.dice;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
public class DiceRollLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int diceCount;

    @ElementCollection
    @CollectionTable(name = "dice_results", joinColumns = @JoinColumn(name = "log_id"))
    @Column(name = "result")
    private List<Integer> results;
    private LocalDateTime timestamp;

    public DiceRollLog(int diceCount, List<Integer> results, LocalDateTime timestamp) {
        this.diceCount = diceCount;
        this.results = results;
        this.timestamp = timestamp;
    }

    public DiceRollLog() {}


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
