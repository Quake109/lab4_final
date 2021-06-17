package neo4jLab4;

import org.neo4j.ogm.session.Session;

import java.util.HashMap;
import java.util.Map;

public class PolicemanService extends MethodService<Policeman> {

    public PolicemanService(Session session) {
        super(session);
    }


    @Override
    Class<Policeman> getEntityType() {
        return Policeman.class;
    }
        Iterable<Map<String, Object>> getPolicemanSalary(Double salary) {
        String query = "MATCH (e:Policeman) " +
                " WHERE e.salary > "+ salary +
                " RETURN e";
        System.out.println("Running: " + query);
        HashMap<String, Object> params = new HashMap<String, Object>();
        return session.query(query, params).queryResults();
        }


}