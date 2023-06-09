import java.io.*;
import java.util.*;

public class Phonebook {

	private ArrayList<Contact> pb;


	public ArrayList<Contact> getPb() {
		return pb;
	}

	public void setPb(ArrayList<Contact> pb) {
		this.pb = pb;
	}

	// Default Constructor
	public Phonebook() {
		this.pb = new ArrayList<>();
	}



	// ******************************************************
	// Choice functions:

	public void addContact(Contact c) {
		pb.add(c);
	}

	public void deleteContact(String name) {
		for (Contact contact:pb) {
			if(name.equals(contact.getName())) {
				System.out.println("Contact " + contact + " removed successfully");
				pb.remove(contact);
				return;
			}
		}
		System.out.println("Contact not found");

	}

	public void printPhoneBook() {
		System.out.println("***************");
		for (Contact contact:pb) {
			System.out.println("* " + contact);
		}
		System.out.println("***************");
	}

	public ArrayList<Contact> findContacts(String name) {
		// The function returns linked list with all the contacts with that name
		ArrayList<Contact> ret = new ArrayList<>();
		// Searching contacts with that name and adding them to the linked list
		for (Contact contact:pb) {
			if (name.equals(contact.getName())) {
				ret.add(contact);
			}
		}
		return ret;
	}

	public void sortByName() {
		pb.sort(new NameComp());
	}

	public void sortByNumber() {
		pb.sort(new PhoneComp());
	}

	public void deleteDuplicates() {
		Set<Contact> set = new TreeSet<>(pb);
		pb.clear();
		pb.addAll(set);
	}

	public void reverseOrder() {
		Collections.reverse(pb);
	}

	public void saveToFile(String filename) throws IOException {
		FileWriter writer = new FileWriter(filename);
		for (Contact contact : pb) {
			writer.write(contact + "\n");
		}
		writer.close();
	}

	public void loadFromFile(String filename) throws FileNotFoundException {
		Scanner reader = new Scanner(new File(filename));
		while (reader.hasNextLine()) {
			addContact(Contact.parse(reader.nextLine()));
		}
		reader.close();
	}
}
