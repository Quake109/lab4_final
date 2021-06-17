package neo4jLab4;

import org.neo4j.ogm.session.Session;

public class PenaltyFineService extends MethodService<PenaltyFine> {
    public PenaltyFineService(Session session) {
        super(session);
    }

    @Override
    Class<PenaltyFine> getEntityType() {
        return PenaltyFine.class;
    }
}