
public class Main {
    public static void main(String[] args) {
        User test = new User("Mathieu", "Mith", "mathieu@.com", "Mathieu");
        User test1 = new User("Mathieu", "Mith", "mathieuX@.com", "Mathieu");
        //System.out.println("Le compte :"+Request.addUser(test).getNom()+" à bein été ajouté en bdd");
        //System.out.println("Le compte :"+Request.showUserByEmail(test).getNom()+" Existe");
        User testUser = Request.showUserByEmail(test1);
                if (testUser == null){
                    System.out.println("Le compte :"+Request.showUserByEmail(test).getNom()+" ne existe pas");
                }else{
                    System.out.println("Le compte :"+Request.showUserByEmail(test).getNom()+" Existe");
                }

    }
}