import java.util.Comparator;

public class PhoneComp implements Comparator<Contact> {
    public int compare(Contact c1, Contact c2){
        /* Returns negative number if c2.getPhoneNum() is smaller lexicographically than c1.getPhoneNum()
        (which also means numerically) and vice versa
         */
        return c2.getPhoneNum().compareTo(c1.getPhoneNum());
    }
}
