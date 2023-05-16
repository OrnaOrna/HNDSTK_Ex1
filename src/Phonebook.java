import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

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
		this.pb = new ArrayList<Contact>();
	}



	// ******************************************************
	// Choice functions:

	public void addContact(Contact c) {
		// TODO 1
	}

	public void deleteContact(String name) {
		// TODO 2
	}

	public void printPhoneBook() {
		// TODO 3
	}

	public ArrayList<Contact> findContacts(String name) {
		ArrayList<Contact> ret = new ArrayList<Contact>();

		// TODO 4

		return ret;
	}

	public void sortByName() {
		// TODO 5
	}

	public void sortByNumber() {
		// TODO 6
	}

	public void deleteDuplicates() {
		// TODO 7
	}

	public void reverseOrder() {
		// TODO 8
	}

	public void saveToFile(String filename) throws IOException {
		FileWriter writer = new FileWriter(new File(filename));
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
