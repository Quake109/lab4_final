package neo4jLab4;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity(label = "Policeman")
@Data
public class Policeman{

    @Id
    @GeneratedValue
    private Long id;
    @Property(name = "name")
    private String name;
    @Property(name = "surname")
    private String surname;
    @Property(name = "salary")
    private Double salary;

    public Policeman() {
    }

    public Policeman(String name, String surname, Double salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }
}