import java.sql.*;

public class Request {
    //Attribut paramètre BDD
    static final String DB_URL = "jdbc:mysql://localhost/Java?serverTimezone=UTC";
    static final String USERNAME = "root";
    static final String PASSWORD = "";
    //Connexion à la BDD
    private static Connection connexion;
    //Connexion à la BDD
    static {
        try {
            connexion = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // Methode ajouter un user
    public static User addUser(User user){
        User userAdd = null;
        try{
            // 1 Connection à la BDD...
            Statement stmt = connexion.createStatement();
            // 2 requête SQL
            String sql = "INSERT INTO users (nom, prenom, email, mdp) " + "VALUES (?, ?, ?, ?)";
            //3 préparer la requête
            PreparedStatement preparedStatement = connexion.prepareStatement(sql);
            // 4 Binder les paramètres
            preparedStatement.setString(1, user.getNom());
            preparedStatement.setString(2, user.getPrenom());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getMdp());
            //5 Exécution de la requête le typage int pour savoir combien d'enregistrement
            int addRows = preparedStatement.executeUpdate();
            //6 Test si la requête est bien passée
            if(addRows >0){
                userAdd = new User(user.getNom(), user.getPrenom(), user.getEmail(), user.getMdp());
            }
            //7 Fermer la connexion à la BDD
            stmt.close();
            connexion.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userAdd;
    }


}
