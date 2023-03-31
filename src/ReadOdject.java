import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadOdject {
    public ReadOdject(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("UserFile.bit"))) {

            User user = (User) ois.readObject();

            System.out.println(user);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
