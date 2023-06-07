import java.util.List;

public class Main {
    public static void main(String[] args) {
        //instancier un objet User
        User test = new User("Test4", "Test4", "test6@test.com", "1234");
        User test1 = new User("Test1", "Test1", "test1@test1.com", "1234");
        User monTest = new User("Test1", "Test1", "allo@test1.com", "1234");
        //Appel de la fonction getUserByMail
        User getUser = Request.getUserByMail(test);
        //test si un compte existe
        if (getUser !=null){
            System.out.println("Le compte : \n-"+getUser.getId()+" "+getUser.getEmail()+" existe déja en BDD");
        }
        //sinon pas de compte
        else{
            System.out.println("Le compte : "+Request.addUser(monTest).getNom()+" a été ajouté en BDD");
        }
        List<User> userList = Request.getAllUsers();

        System.out.println("Les comptes sont :");
        for (User user : userList) {
            System.out.println("- Nom : " + user.getNom());
            System.out.println("  Prénom : " + user.getPrenom());
            System.out.println("  Email : " + user.getEmail());
            System.out.println("  Mot de passe : " + user.getmdp());
            System.out.println("----------");
        }


    }
}