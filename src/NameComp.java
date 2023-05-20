import java.util.Comparator;

public class NameComp implements Comparator<Contact> {
    public int compare(Contact c1, Contact c2){
        // Returns negative number if c1.getName() is smaller lexicographically than c2.getName() and vice versa
        return c1.getName().compareTo(c2.getName());
    }
}
