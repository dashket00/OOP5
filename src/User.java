
public class User implements Cloneable {
    private int id;
    private String name;
    private Address address;

    public User(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
    @Override
    public User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }

    public User deepClone() throws CloneNotSupportedException {
        User clonedUser = (User) super.clone();
        clonedUser.address = this.address.clone();
        return clonedUser;
    }

    public static void main(String[] args) {
        User originalUser = new User(1, "shrek", new Address("kek", "pushkina"));

        String cloneType = "deep";

        User clonedUser = null;

        try {
            if (cloneType.equals("shallow")) {
                clonedUser = originalUser.clone();
            } else if (cloneType.equals("deep")) {
                clonedUser = originalUser.deepClone();
            } else {
                System.out.println("Недопустимый тип операции клонирования");
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        originalUser.address.setCity("Kolhoznik");
            System.out.println("Original User: " + originalUser);
            System.out.println(originalUser.address.getCity() + " " + originalUser.address.getStreet());
        if (clonedUser != null) {
            System.out.println("Cloned User: " + clonedUser);
            System.out.println(clonedUser.address.getCity() + " " + clonedUser.address.getStreet());

        }

    }
}
