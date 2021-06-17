package neo4jLab4;

import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;

import java.util.*;

public class Main {

    private static DriverService driverService;
    private static PolicemanService policemanService;
    private static PenaltyFineService penaltyFineService;

    public static void main(String[] args) {
        Configuration configuration = new Configuration.Builder().uri("bolt://localhost:7687").credentials("neo4j", "neo4jpassword").build();
        SessionFactory sessionFactory = new SessionFactory(configuration, "neo4jLab4");

        Session session = sessionFactory.openSession();
        session.purgeDatabase();

        Scanner in = new Scanner(System.in);
        driverService = new DriverService(session);
        policemanService = new PolicemanService(session);
        penaltyFineService = new PenaltyFineService(session);


        menu:
        while (true) {
            displayMenu();
            System.out.print("Choose operation: ");
            switch (in.nextInt()) {
                case 1: {
                    System.out.println("Penalty: ");
                    penaltyFineService.readAll().forEach(System.out::println);
                    policemanService.readAll().forEach(System.out::println);
                    driverService.readAll().forEach(System.out::println);
                    break;
                }
                case 2: {

                    Driver driver1 = new Driver("Krzysztof", "Siczek","WR12356");
                    Driver driver2 = new Driver("Przemyslaw", "Pyk","KL12355");
                    Driver driver3 = new Driver("Jan", "Tusk","GFE31254");

                    Policeman policeman1 = new Policeman("Karol","Boczek", 1800.0);
                    Policeman policeman2 = new Policeman("Ala","Kotek", 5000.0);
                    Policeman policeman3 = new Policeman("Jas","Fasola", 9900.0);


                    PenaltyFine penaltyFine1 = new PenaltyFine("Mazowieckie", "Radom", 200.00, policeman1, driver3);
                    PenaltyFine penaltyFine2 = new PenaltyFine("Kieleckie", "Kielce", 500.00, policeman3, driver1);
                    PenaltyFine penaltyFine3 = new PenaltyFine("Mazowieckie", "Warszawa", 1000.00, policeman2, driver2);


                    penaltyFineService.createOrUpdate(penaltyFine1);
                    penaltyFineService.createOrUpdate(penaltyFine2);
                    penaltyFineService.createOrUpdate(penaltyFine3);

                    break;
                }
                case 3: {
                    System.out.println("Enter id: ");
                    var id = new Scanner(System.in).nextLine();
                    penaltyFineService.delete(Long.parseLong(id));
                    break;
                }
                case 4: {
                    System.out.println("Enter policeman ID:");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println("Enter policeman salary:");
                    Double salary = new Scanner(System.in).nextDouble();

                    Policeman policeman1 = policemanService.read(id);
                    policeman1.setSalary(salary);

                    policemanService.createOrUpdate(policeman1);
                    break;
                }
                case 5: {
                    System.out.println("Enter id: ");
                    var id = new Scanner(System.in).nextLine();
                    System.out.println((penaltyFineService.read(Long.parseLong(id))));
                    break;
                }
                case 6: {
                    System.out.println("Enter policeman salary:");
                    Double salary = new Scanner(System.in).nextDouble();
                           System.out.println(policemanService.getPolicemanSalary(salary));
                    break;
                }
                default: {
                    break menu;
                }
            }
        }
        sessionFactory.close();
    }

    private static void displayMenu() {
        System.out.println(
                "1. All Excursion\n" +
                "2. Save all\n" +
                "3. Remove penalty from DB\n" +
                "4. Update policeman salary\n" +
                "5. Get penalty by id\n" +
                        "6. Get avg salary\n" +
                "7. Finish\n");
    }
}