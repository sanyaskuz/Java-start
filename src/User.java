import java.io.Serializable;

public class User implements Serializable {
    private int id = 0;
    private String name;
    private String email;

    public User( String name, String email) {
        this.id ++;
        this.name = name;
        this.email = email;

    }

    public int getAge() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String toString(){
        return  "User:" + id + " : " + name  + " : " + email;
    }
}
