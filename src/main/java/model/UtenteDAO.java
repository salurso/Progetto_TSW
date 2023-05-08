package model;

import java.sql.*;

public class UtenteDAO {
    public Utente doRetrieveByUsernamePassword(String username, String password) {

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Utente utente = null;

        try (Connection connection = ConPool.getConnection()) {
            statement = connection.prepareStatement("SELECT  FROM utente WHERE username=? AND password=SHA1(?)");
            statement.setString(1, username);
            statement.setString(2, password);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                utente = new Utente();
                utente.setId(resultSet.getInt("id"));
                utente.setUsername(resultSet.getString("username"));
                utente.setPassword(password);
                utente.setName(resultSet.getString("name"));
                utente.setEmail(resultSet.getString("email"));
                utente.setAdmin(resultSet.getBoolean("admin"));
            }
        }  catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return utente;
    }

//    public void doSave(Utente utente) {
//
//            try (Connection con = ConPool.getConnection()) {
//                PreparedStatement ps = con.prepareStatement("INSERT INTO utente (username, password, email, name, admin) VALUES(?,?,?,?,?)");
//                ps.setString(1, utente.getUsername());
//                ps.setString(2, utente.getPassword());
//                ps.setString(3, utente.getEmail());
//                ps.setString(4, utente.getName());
//                ps.setString(5, String.valueOf(0));
//                if (ps.executeUpdate() != 1) {
//                    throw new RuntimeException("INSERT error.");
//                }
//
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//    }

    public static void doRegistration(Utente utente) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO utente (username, password, email, name, admin) VALUES (?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, utente.getUsername());
            ps.setString(2, utente.getPassword());
            ps.setString(3, utente.getEmail());
            ps.setString(4, utente.getName());
            ps.setInt(5, 0);

            if (ps.executeUpdate() != 1)
                throw new RuntimeException("Errore nel definire l'utente");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean checkEmail(String email){
        try (Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT email FROM utente WHERE email= ?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
