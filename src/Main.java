
public class Main {
    public static void main(String[] args) {
        User test = new User("youssef", "ben", "youssef20ben@gmail.com", "Youssef93");
        System.out.println("Le compte :"+Request.addUser(test).getNom()+"à bein été ajouté en bdd");

    }
}