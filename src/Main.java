import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Veuillez choisir une méthode (1/2/3) :");
        int choix = scanner.nextInt();

        switch (choix) {
            case 1:
                addUser();
                break;
            case 2:
                updateUser();
                break;
            case 3:
                getAllUsers();
                break;
            default:
                System.out.println("Demande invalide !!!.");
        }
    }

    private static void addUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez votre nom :");
        String nom = scanner.nextLine();

        System.out.println("Entrez votre prénom :");
        String prenom = scanner.nextLine();

        System.out.println("Entrez votre email :");
        String email = scanner.nextLine();

        System.out.println("Entrez votre mot de passe :");
        String mdp = scanner.nextLine();

        User user = new User(nom, prenom, email, mdp);

        User exist = Request.getUserByMail(user);

        if (exist == null) {
            User addedUser = Request.addUser(user);
            System.out.println("Le compte a été ajouté : " + addedUser.getPrenom());
        } else {
            System.out.println("Erreur : Le compte existe déjà pour l'email " + user.getEmail());
        }
    }

    private static void updateUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez l'ID de l'utilisateur à mettre à jour :");
        int userId = scanner.nextInt();

        User userToUpdate = new User();
        userToUpdate.setId(userId);

        System.out.println("Entrez le nom de l'attribut à mettre à jour (nom, prenom, email, mdp) :");
        String attributeName = scanner.next();

        System.out.println("Entrez la nouvelle valeur :");
        String newValue = scanner.next();

        User updatedUser = Request.updateUserAttribute(userToUpdate, attributeName, newValue);

        if (updatedUser != null) {
            System.out.println("Attribut mis à jour avec succès : " + attributeName);
        } else {
            System.out.println("Impossible de mettre à jour l'attribut.");
        }
    }

    private static void getAllUsers() {
        List<User> userList = Request.getAllUsers();

        System.out.println("Les comptes sont :");
        for (User user : userList) {
            System.out.println("- Nom : " + user.getNom());
            System.out.println("  Prénom : " + user.getPrenom());
            System.out.println("  Email : " + user.getEmail());
            System.out.println("  Mot de passe : " + user.getmdp());
            System.out.println("________");
        }
    }
}
