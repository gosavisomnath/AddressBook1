import java.util.Comparator;

public class Sort {
        static Comparator<Contact> compareFirstName = new Comparator<Contact>()
        {
            public int compare(Contact obj, Contact obj2)
            {
                return obj.getFirstName().compareTo(obj2.getFirstName());
            }
        };
    static Comparator<Contact> getCity = new Comparator<Contact>()
    {
        public int compare(Contact obj, Contact obj2)
        {
            return obj.getCity().compareTo(obj2.getCity());
        }
    };

}
