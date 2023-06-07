public class User {
    /*Attributs : */

    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String mdp;

    /*Constructeurs : */

    public User(){
    }
    public User(String nom, String prenom, String email, String mdp){
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
    }

    /*Getters et Setters : */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getmdp() {
        return mdp;
    }

    public void setmdp(String mdp) {
        this.mdp = mdp;
    }
}