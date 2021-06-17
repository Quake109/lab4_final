package neo4jLab4;

import lombok.Data;
import org.neo4j.ogm.annotation.*;

@NodeEntity(label = "PenaltyFine")
@Data
public class PenaltyFine {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "voivodeship")
    private String voivodeship;

    @Property(name = "city")
    private String city;

    @Property(name = "penalty")
    private Double penalty;

    @Relationship(type = "created")
    private Policeman policeman;

    @Relationship(type = "punished")
    private Driver driver;

    public PenaltyFine() {
    }

    public PenaltyFine(String voivodeship, String city, Double penalty, Policeman policeman, Driver driver) {
        this.voivodeship = voivodeship;
        this.city = city;
        this.penalty = penalty;
        this.policeman = policeman;
        this.driver = driver;
    }
}