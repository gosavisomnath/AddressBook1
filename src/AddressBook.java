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
            System.out.println("1. Add \t2. Print \t3.Edit \t4.Delete \t5.SearchPersonByCity \t6.SearchPersonByState \t7.Back");
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
                    searchPersonByCity();
                    break;
                case 6:
                    searchPersonByState();
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
        duplicateName(firstName);
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
    public void duplicateName(String firstName) {
        for (int i = 0; i < list.size(); i++)
        {
            String contactName = list.get(i).firstName;

            if (firstName.equals(contactName))
            {
                System.out.println("This Person is Already Present");
            }
            else
            {
                System.out.println("You can Add this Person");
                break;
            }
        }
    }

    @Override
    public void searchPersonByCity() {
        System.out.println("Enter City name to search Person by city name");
        String userCity = s.next();
        Dictionary City = new Hashtable();
        list.stream().filter(map -> map.getCity().contains(userCity)).forEach(list -> City.put(list.getFirstName(),userCity));
        System.out.println("City Name: " + userCity);
        for (Enumeration i = City.keys(); i.hasMoreElements();)
        {
            System.out.println("Name : " + i.nextElement());
        }
    }

    @Override
    public void searchPersonByState() {
        System.out.println("Enter State name to search Person by State name");
        String userState = s.next();
        Dictionary State = new Hashtable();
        list.stream().filter(map -> map.getState().contains(userState)).forEach(list -> State.put(list.getFirstName(),userState));
        System.out.println("City Name: " + userState);
        for (Enumeration i = State.keys(); i.hasMoreElements();)
        {
            System.out.println("Name : " + i.nextElement());
        }

    }


}
