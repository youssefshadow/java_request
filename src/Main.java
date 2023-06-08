import java.util.List;

public class Main {
    public static void main(String[] args) {
        //instancier un objet User
        User test = new User("Akagami", "Shanks", "shanks6@test.com", "5678");
        User test1 = new User("Yoann", "Depp", "yoann@test1.com", "1234");
        User monTest = new User("Test1", "Test1", "allo@test1.com", "1234");
        //Appel de la fonction getUserByMail
        User getUser = Request.getUserByMail(test);
        //test si un compte existe
        if (getUser !=null){
            System.out.println("Le compte : \n-"+getUser.getId()+" "+getUser.getEmail()+" existe déja en BDD");
        }
        //sinon pas de compte
        else{
            System.out.println("Le compte : "+Request.addUser(test1).getNom()+" a été ajouté en BDD");
        }
        List<User> userList = Request.getAllUsers();

        System.out.println("Les comptes sont :");
        for (User user : userList) {
            System.out.println("- Nom : " + user.getNom());
            System.out.println("  Prénom : " + user.getPrenom());
            System.out.println("  Email : " + user.getEmail());
            System.out.println("  Mot de passe : " + user.getmdp());
            System.out.println("________");
        }
        // Test methode
        User userToUpdate = new User();
        userToUpdate.setId(2);


        User updatedUser = Request.updateUserAttribute(userToUpdate, "prenom", "Mith");

        if (updatedUser != null) {
            System.out.println("Le 'nom' a été mis à jour  avec l'ID : " + updatedUser.getId());
        } else {
            System.out.println("Impossible de mettre à jour l'attribut 'nom' " );
        }


    }
}