

public class AppRun {


    public static void main(String[] args) {
        AddressBookImpl obj=new AddressBook();
        obj.operation(obj.list());
        obj.print();
        obj.edit();
        obj.delete();




    }
}
