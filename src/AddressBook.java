import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddressBook implements AddressBookImpl {
    Scanner s = new Scanner(System.in);
    ArrayList<Contact> list = new ArrayList<Contact>();

    public void operation(ArrayList<Contact> arrayRead) {
        list = arrayRead;
        boolean status = true;
        do {
            System.out.println("Choose Operation you want to do");
            System.out.println("1. Add \t2. Print \t3.Edit \t4.Delete \t5.sortByName \t6.GetPersonByCity \t7.Back");
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
                    sortByName();
                    break;
                case 6:
                    sortByCity();
                    break;
                case 7:
                    status = false;
                    break;
            }
        } while (status);
    }

    @Override
    public void add() {
        Contact contact = new Contact();
        System.out.println("Enter the First name:");
        String firstName = s.next();
        contact.setFirstName(firstName);

        System.out.println("Enter the Last name:");
        String lastName = s.next();
        contact.setLastName(lastName);

        System.out.println("Enter the Address:");
        String address = s.next();
        contact.setAddress(address);

        System.out.println("Enter the City:");
        String city = s.next();
        contact.setCity(city);

        System.out.println("Enter the State:");
        String state = s.next();
        contact.setState(state);

        System.out.println("Enter the Email:");
        String email = s.next();
        contact.setEmail(email);

        System.out.println("Enter the Phone Number:");
        String phoneNumber = s.next();
        contact.setPhoneNumber(phoneNumber);
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

            if (fname.equals(contact.getFirstName())) {

                System.out.println("Choose field you want to add:");
                System.out.println("1.Last Name\t2.Phone Number\t3.City\t4.Zip\t5. State\t6.address");
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
                    case 6:
                        System.out.println("Re-Correct your Address");
                        contact.setAddress(s.next());
                        break;
                }

            }
        }
    }

    @Override
    public void delete() {
        System.out.println("Enter your First name:");
        String fname = s.next();

        for (Iterator<Contact> it = list.iterator(); it.hasNext(); ) {
            if (it.next().getFirstName().contains(fname))
            {
                it.remove();
                System.out.println("List Deleted:");
            }else
            {
                System.out.println("Enter Correct Name:");
            }
        }


    }

    @Override
    public void sortByName() {
        Collections.sort(list, Sort.compareFirstName);

    }

    @Override
    public void sortByCity() {
        Collections.sort(list, Sort.getCity);

    }

}
