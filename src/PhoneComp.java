import java.util.Comparator;

public class PhoneComp implements Comparator<Contact> {
    public int compare(Contact c1, Contact c2){
        return c2.getPhoneNum().compareTo(c1.getPhoneNum());
    }
}
