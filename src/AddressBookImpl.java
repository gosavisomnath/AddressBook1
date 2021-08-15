import java.util.ArrayList;

public interface AddressBookImpl {
    public void operation(ArrayList<Contact> arrayRead);
    public void add();
    public void print();
    public ArrayList<Contact> list();
    public void edit();
    public void delete();
    public void duplicateName(String firstName);
    public void searchPersonByCity();
    public void searchPersonByState();
    public void countByCity();
    public void sortPersonByFirstname();


}
