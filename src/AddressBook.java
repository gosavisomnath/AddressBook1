import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AddressBook implements AddressBookImpl{
        Scanner s = new Scanner(System.in);
        ArrayList<Contact> list = new ArrayList<Contact>();
        public void operation(ArrayList<Contact> arrayRead)
        {
            list = arrayRead;
            boolean status = true;
            do {
                System.out.println("Choose Operation you want to do");
                System.out
                        .println("1. Add\t2. Print\t3.BAck");
                switch (s.nextInt()) {
                    case 1:
                        add();
                        break;
                    case 2:
                        print();
                    case 3:
                        status = false;
                        break;
                }
            } while (status);
        }

    @Override
    public void add() {
        Contact contact = new Contact();
        System.out.println("Enter the First name:");
        String fname = s.next();
        contact.setFirstName(fname);

        System.out.println("Enter the Last name:");
        String lname = s.next();
        contact.setLastName(lname);

        System.out.println("Enter the Phone Number:");
        String phone = s.next();
        contact.setPhoneNumber(phone);

        System.out.println("Enter the City:");
        String city = s.next();
        contact.setCity(city);

        System.out.println("Enter the Email:");
        String email = s.next();
        contact.setEmail(email);

        System.out.println("Enter the State:");
        String state = s.next();
        contact.setState(state);
        list.add(contact);

    }

    @Override
    public void print() {
            Iterator<Contact> it = list.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        }

    @Override
    public ArrayList<Contact> list() {
        return list;
    }


}
