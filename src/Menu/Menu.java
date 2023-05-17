package Menu;

import DAO.CandidatDAO;
import DAO.ProvinciesDAO;
import DAO.comunitats_autonomesDAO;
import Model.Candidats;
import Model.Comunitats_autonomes;
import Model.Provincies;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import static Utils.Conector_MySQL.getConnection;

public class Menu {
    public static void mostraMenu() throws SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.println("╔════════════════════════╗");
        System.out.println("║     MENÚ PRINCIPAL     ║");
        System.out.println("╠════════════════════════╣");
        System.out.println("║  1. Candidats          ║");
        System.out.println("║  2. Provincies         ║");
        System.out.println("║  3. CA                 ║");
        System.out.println("║  4. Sortir             ║");
        System.out.println("╚════════════════════════╝");
        System.out.print("Esculli una opció: ");

        int taula = scan.nextInt();
        switch (taula) {
            case 1 -> menuCandidats();
            case 2 -> menuProvincies();
            case 3 -> menuComunitatsAutonomes();
            case 4 -> System.exit(0);
        }
    }

    private static void menuProvincies () throws SQLException {
        Scanner scan = new Scanner(System.in);
        Connection con = getConnection();
        System.out.println("╔══════════════════════╗");
        System.out.println("║       PROVÍNCIES     ║");
        System.out.println("╠══════════════════════╣");
        System.out.println("║   1. Afegir      C   ║");
        System.out.println("║   2. Mostrar     R   ║");
        System.out.println("║   3. Modificar   U   ║");
        System.out.println("║   4. Esborrar    D   ║");
        System.out.println("║   5. Sortir          ║");
        System.out.println("╚══════════════════════╝");
        System.out.print("Escull una opció: ");


        int opcio = scan.nextInt();

        switch (opcio) {
            case 1:
                System.out.print("Introdueixi l'ID de la comunitat autonoma (1-19): ");
                int idComunitatAutonoma = scan.nextInt();
                System.out.print("Introdueixi el nom: ");
                String name = scan.next();
                System.out.print("Introdueixi codi INE: ");
                int codeIne = scan.nextInt();
                ProvinciesDAO provinciesDAO = new ProvinciesDAO(con);
                Provincies provincia = new Provincies(0, idComunitatAutonoma, name, codeIne);
                provinciesDAO.create(provincia);
                System.out.println("Provincia afegida");
                break;
            case 2:
                System.out.println("Per veure tots els resultats escrigui 1 \n Per cercar per ID escrigui 2");
                System.out.print("Esculli una opció: ");
                int option = scan.nextInt();
                switch (option) {
                    case 1 -> {
                        provinciesDAO = new ProvinciesDAO(con);
                        provinciesDAO.seleccionarTot();
                    }
                    case 2 -> {
                        System.out.print("Introdueixi l'ID de la provincia: ");
                        int id = scan.nextInt();
                        provinciesDAO = new ProvinciesDAO(con);
                        provincia = provinciesDAO.exists(id);
                        System.out.println(provincia.getProvincia_id() + " " + provincia.getidComunitatAutonoma() + " " + provincia.getNom() + " " + provincia.getCodiINE());
                    }
                    default -> {
                        System.out.println("Opció invàl·lida");
                        return;
                    }
                }
                break;
            case 3:
                provinciesDAO = new ProvinciesDAO(con);
                System.out.println("Quina provincia vol modificar?");
                int id = scan.nextInt();
                provincia = provinciesDAO.exists(id);
                System.out.println("Per modificar la comunitat autònoma escrigui 1 \nPer modificar el nom escrigui 2 \nPer modificar el codi INE escrigui 3?");
                System.out.print("Esculli una opció: ");
                int optiona = scan.nextInt();
                switch (optiona) {
                    case 1 -> {
                        System.out.print("Introdueixi la nova comunitat autònoma: ");
                        idComunitatAutonoma = scan.nextInt();
                        provincia.setidComunitatAutonoma(idComunitatAutonoma);
                    }
                    case 2 -> {
                        System.out.print("Introdueixi el nou nom: ");
                        name = scan.next();
                        provincia.setNom(name);
                    }
                    case 3 -> {
                        System.out.print("Introdueixi el nou codi INE: ");
                        codeIne = scan.nextInt();
                        provincia.setCodiINE(codeIne);
                    }
                    default -> {
                        System.out.println("Opció invàl·lida");
                        return;
                    }
                }
                provinciesDAO.update(provincia);
                System.out.println("Provincia modificada");
                return;
            case 4:
                System.out.print("Introdueixi l'ID de la provincia: ");
                id = scan.nextInt();
                provinciesDAO = new ProvinciesDAO(con);
                provinciesDAO.delete(id);
                System.out.println("Provincia esborrada.");
                break;
            case 5:
                System.exit(0);
        }
    }
    private static void menuComunitatsAutonomes() throws SQLException {
        Scanner scan = new Scanner(System.in);
        Connection con = getConnection();
        System.out.println("╔══════════════════════╗");
        System.out.println("║         C.A          ║");
        System.out.println("╠══════════════════════╣");
        System.out.println("║   1. Afegir      C   ║");
        System.out.println("║   2. Mostrar     R   ║");
        System.out.println("║   3. Modificar   U   ║");
        System.out.println("║   4. Esborrar    D   ║");
        System.out.println("║   5. Sortir          ║");
        System.out.println("╚══════════════════════╝");
        System.out.print("Escull una opció: ");
        int opcioMenu = scan.nextInt();

        switch (opcioMenu) {
            case 1:
                System.out.print("Introdueixi el nom: ");
                String name = scan.next();
                System.out.print("Introdueixi el codi INE: ");
                int codeIne = scan.nextInt();
                comunitats_autonomesDAO comunitats_autonomesDAO = new comunitats_autonomesDAO(con);
                Comunitats_autonomes comunitats_autonomes = new Comunitats_autonomes(0, name, codeIne);
                comunitats_autonomesDAO.create(comunitats_autonomes);
                System.out.println("Comunitat autònoma afegida");
                break;
            case 2:
                System.out.println("Per veure tots els resultats escrigui 1 \n Per cercar per ID escrigui 2");
                System.out.print("Esculli opció: ");
                int opcioMostrar = scan.nextInt();
                switch (opcioMostrar) {
                    case 1 -> {
                        comunitats_autonomesDAO = new comunitats_autonomesDAO(con);
                        comunitats_autonomesDAO.seleccionarTot();
                    }
                    case 2 -> {
                        System.out.print("Introdueixi l'ID de la comunitat autònoma: ");
                        int id = scan.nextInt();
                        comunitats_autonomesDAO = new comunitats_autonomesDAO(con);
                        comunitats_autonomes = comunitats_autonomesDAO.exists(id);
                        System.out.println(comunitats_autonomes.getComunitat_aut_id() + " " + comunitats_autonomes.getNom_comunitat_aut() + " " + comunitats_autonomes.getCodi_ine());
                    }
                    default -> {
                        System.out.println("Opció invàl·lida");
                        return;
                    }
                }
                break;
            case 3:
                comunitats_autonomesDAO = new comunitats_autonomesDAO(con);
                System.out.println("Quina comunitat autònoma vol modificar? Introdueix el número identificatiu de la CA:");
                int id = scan.nextInt();
                comunitats_autonomes = comunitats_autonomesDAO.exists(id);
                System.out.println("╔════════════════════════╗");
                System.out.println("║  QUÈ VOL MODIFICAR?    ║");
                System.out.println("╠════════════════════════╣");
                System.out.println("║  1. Comunitat Autònoma ║");
                System.out.println("║  2. Nom                ║");
                System.out.println("║  3. Codi INE           ║");
                System.out.println("╚════════════════════════╝");
                System.out.print("Esculli una opció: ");

                int opcioModificar = scan.nextInt();
                switch (opcioModificar) {
                    case 1 -> {
                        System.out.print("Introdueixi la nova comunitat autònoma: ");
                        int idComunitatAutonoma = scan.nextInt();
                        comunitats_autonomes.setComunitat_aut_id(idComunitatAutonoma);
                    }
                    case 2 -> {
                        System.out.print("Introdueixi el nou nom: ");
                        name = scan.next();
                        comunitats_autonomes.setNom_comunitat_aut(name);
                    }
                    case 3 -> {
                        System.out.print("Introdueixi el nou codi INE: ");
                        codeIne = scan.nextInt();
                        comunitats_autonomes.setCodi_ine(codeIne);
                    }
                    default -> {
                        System.out.println("Opció invàl·lida");
                        return;
                    }
                }
                comunitats_autonomesDAO.update(comunitats_autonomes);
                System.out.println("Comunitat autònoma modificada");
                return;
            case 4:
                System.out.print("Introdueixi l'ID de la comunitat autònoma: ");
                id = scan.nextInt();
                comunitats_autonomesDAO = new comunitats_autonomesDAO(con);
                comunitats_autonomesDAO.delete(id);
                System.out.println("Comunitat autònoma esborrada");
                break;
            case 5:
                System.exit(0);
        }
    }
    public static void menuCandidats() throws SQLException {
        Scanner scan = new Scanner(System.in);
        Connection con = getConnection();

        System.out.println("╔══════════════════════╗");
        System.out.println("║     MENÚ CANDIDATS   ║");
        System.out.println("╠══════════════════════╣");
        System.out.println("║   1. Afegir      C   ║");
        System.out.println("║   2. Mostrar     R   ║");
        System.out.println("║   3. Modificar   U   ║");
        System.out.println("║   4. Esborrar    D   ║");
        System.out.println("║   5. Sortir          ║");
        System.out.println("╚══════════════════════╝");
        System.out.print("Escull una opció: ");


    int opcio = scan.nextInt();

        switch (opcio) {
            case 1:
                System.out.print("Introdueixi l'ID de la candidatura: ");
                int idCandidatura = scan.nextInt();
                System.out.print("Introdueixi l'ID de la persona: ");
                int idPersona = scan.nextInt();
                System.out.print("Introdueixi l'ID de la provincia: ");
                int idProvincia = scan.nextInt();
                CandidatDAO candidatDAO = new CandidatDAO(con);
                Candidats candidats = new Candidats(0, idCandidatura, idPersona, idProvincia);
                candidatDAO.create(candidats);
                System.out.println("Candidat afegit");
                break;
            case 2:
                System.out.println("Per veure tots els resultats escrigui 1 \n Per cercar per ID escrigui 2");
                System.out.print("Esculli una opció: ");
                int option = scan.nextInt();
                switch (option) {
                    case 1 -> {
                        candidatDAO = new CandidatDAO(con);
                        candidatDAO.seleccionarTot();
                    }
                    case 2 -> {
                        System.out.print("Introdueixi l'ID del candidat ");
                        int id = scan.nextInt();
                        candidatDAO = new CandidatDAO(con);
                        candidats = candidatDAO.exists(id);
                        System.out.println(candidats.getCandidat_id() + " " + candidats.getCandidatura_id() + " " + candidats.getPersona_id() + " " + candidats.getProvincia_id());
                    }
                    default -> {
                        System.out.println("Opció invàl·lida");
                        return;
                    }
                }
                break;
            case 3:
                candidatDAO = new CandidatDAO(con);
                System.out.println("Quin candidat vols modificar? Introdueix-ne l'ID");
                int id = scan.nextInt();
                candidats = candidatDAO.exists(id);
                System.out.println("╔══════════════════════╗");
                System.out.println("║     MENÚ CANDIDATS   ║");
                System.out.println("╠══════════════════════╣");
                System.out.println("║ -Camp a modificar:   ║");
                System.out.println("║ 1. Candidatura       ║");
                System.out.println("║ 2. Persona           ║");
                System.out.println("║ 3. Provincia         ║");
                System.out.println("╚══════════════════════╝");
                System.out.print("Esculli una opció: ");
                int optiona = scan.nextInt();
                switch (optiona) {
                    case 1 -> {
                        System.out.print("Introdueixi una nova candidatura: ");
                        idCandidatura = scan.nextInt();
                        candidats.setCandidatura_id(idCandidatura);
                    }
                    case 2 -> {
                        System.out.print("Introdueixi una nova persona: ");
                        idPersona = scan.nextInt();
                        candidats.setPersona_id(idPersona);
                    }
                    case 3 -> {
                        System.out.print("Introdueixi una nova provincia: ");
                        idProvincia = scan.nextInt();
                        candidats.setProvincia_id(idProvincia);
                    }
                    default -> {
                        System.out.println("Opció invàl·lida");
                        return;
                    }
                }
                candidatDAO.update(candidats);
                System.out.println("Candidat modificat");
                return;
            case 4:
                System.out.print("Introdueixi l'ID del candidat: ");
                id = scan.nextInt();
                candidatDAO = new CandidatDAO(con);
                candidatDAO.delete(id);
                System.out.println("Candidat esborrat correctament");
                break;
            case 6:
                System.exit(0);
        }
    }
}
