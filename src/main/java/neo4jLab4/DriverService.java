package neo4jLab4;

import org.neo4j.ogm.session.Session;

public class DriverService extends MethodService<Driver> {


    public DriverService(Session session) {
        super(session);
    }

    @Override
    Class<Driver> getEntityType() {
        return Driver.class;
    }
}
