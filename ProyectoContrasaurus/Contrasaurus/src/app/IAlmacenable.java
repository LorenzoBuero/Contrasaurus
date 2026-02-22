package app;

import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author pirulo
 */
public interface IAlmacenable {
    public abstract PreparedStatement prepararAlmacenado(PreparedStatement pStatement, int[] incluidos) throws SQLException;
}
