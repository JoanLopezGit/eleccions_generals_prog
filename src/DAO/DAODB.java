package DAO;

import java.sql.SQLException;
import java.util.List;

/**
 * Interfície per a operacions CRUD de base de dades
 * @param <T> el tipus d'objecte amb el qual treballa aquest DAO
 */
public interface DAODB<T> {

    /**
     * Crea un nou registre a la base de dades a partir d'un objecte
     * @param t l'objecte a crear a la base de dades
     * @return true si la creació ha estat exitosa
     * @throws SQLException
     */
    boolean create(T t) throws SQLException;

    /**
     * Actualitza un registre existent a la base de dades a partir d'un objecte
     * @param t l'objecte a actualitzar a la base de dades
     * @return true si l'actualització ha estat exitosa
     * @throws SQLException
     */
    boolean update(T t) throws SQLException;

    /**
     * Elimina un registre de la base de dades per la seva ID
     * @param id l'ID del registre a eliminar
     * @return true si l'eliminació ha estat exitosa
     * @throws SQLException
     */
    boolean delete(int id) throws SQLException;

    /**
     * Comprova si un registre existeix a la base de dades per la seva ID
     * @param id l'ID del registre a comprovar
     * @return l'objecte si existeix, null en cas contrari
     * @throws
     */
    T exists(int id) throws SQLException;

    /**
     * Obté tots els registres de la base de dades
     * @return una llista de tots els registres a la base de dades
     * @throws
     */
    List<T> seleccionarTot() throws SQLException;
}
