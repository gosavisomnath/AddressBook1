import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AddressBook implements AddressBookImpl {
        Scanner s = new Scanner(System.in);
        ArrayList<Contact> list = new ArrayList<Contact>();
        public void operation(ArrayList<Contact> arrayRead)
        {
            list = arrayRead;
            boolean status = true;
            do {
                System.out.println("Choose Operation you want to do");
                System.out
                        .println("1. Add\t2. Print\t3.Edit\t4.Delete \t5.Back");
                switch (s.nextInt()) {
                    case 1:
                        add();
                        break;
                    case 2:
                        print();
                        break;
                    case 3:
                        edit();
                        break;
                    case 4:
                        delete();
                        break;
                    case 5:
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

    @Override
    public void edit() {
        System.out.println("Enter your First name:");
        String fname = s.next();

        Iterator<Contact> iterator = list.listIterator();

        while (iterator.hasNext()) {
            Contact contact = iterator.next();

            if (fname.equals(contact.getFirstName()))
            {
                //Address address = person.getAddress();
                System.out.println("Choose field you want to add:");
                System.out
                        .println("1.Last Name\t2.Phone Number\t3.City\t4.Zip\t5. State");
                switch (s.nextInt()) {
                    case 1:
                        System.out.println("Re-Correct your lastname");
                        contact.setLastName(s.next());
                        break;
                    case 2:
                        System.out.println("Re-Correct your Phone Number");
                        contact.setPhoneNumber(s.next());
                        break;
                    case 3:
                        System.out.println("Re-Correct your City");
                        contact.setCity(s.next());
                        break;
                    case 4:
                        System.out.println("Re-Correct your Email");
                        contact.setEmail(s.next());
                        break;
                    case 5:
                        System.out.println("Re-Correct your State");
                        contact.setState(s.next());
                        break;
                }

            }
        }
    }

    @Override
    public void delete() {
        System.out.println("Enter your First name:");
        String fname = s.next();

        Iterator<Contact> iterator = list.listIterator();
        while (iterator.hasNext())
        {
            Contact contact = iterator.next();

            if (fname.equals(contact.getFirstName()))
            {
                list.remove(contact);
            }
        }
    }


}
