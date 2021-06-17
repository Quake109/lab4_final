package neo4jLab4;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity(label = "neo4jLab4.Driver")
@Data
public class Driver {

    @Id
    @GeneratedValue
    private Long id;

    @Property("name")
    private String name;
    @Property("surname")
    private String surname;
    @Property("licence")
    private String licence;


    public Driver(String name, String surname, String licence) {
        this.name = name;
        this.surname = surname;
        this.licence = licence;

    }

    public Driver() {
    }
}