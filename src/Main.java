import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void printMenu() {
		System.out.println("1. Add a Contact\t\t2. Delete a Contact (by name)\t\t\t\t3. Print all Contacts");
		System.out.println("4. Find Contact (by name)\t5. Sort phone book lexicographically (small to big)\t6. Sort numerically (big to small)");
		System.out.println("7. Delete duplicates\t\t8. Reverse order of phone book\t\t\t\t9. Save phonebook data in text file");
		System.out.println("10. Load Contacts data from text file\t\t\t11. Exit");
	}

	public static void handleUser() {
		Scanner reader = new Scanner(System.in);
		// First time introduction:

		int choice = 0;
		boolean menu_on = true;

		Phonebook phonebook = new Phonebook();

		System.out.println("Hello dear user!\nWe will organize a Phone Book for you to use!\nHere's a list of options for you to choose from:");
		while (menu_on) {
			System.out.println("***************");
			printMenu();
			System.out.println("***************");
			System.out.print("Enter your choice: ");
			choice = reader.nextInt();
			reader.nextLine();

			switch (choice) {
				case 1 -> { // add contact
					System.out.println("Enter name: ");
					String name = reader.nextLine();
					System.out.println("Enter phone number: ");
					String num = reader.nextLine();
					Contact c = new Contact(name, num);
					phonebook.addContact(c);

					System.out.println("Contact added");
				}
				case 2 -> { // delete contact
					System.out.println("Insert name to delete: ");
					String del_name = reader.nextLine();
					phonebook.deleteContact(del_name);
					System.out.println("Contact deleted");
				}
				case 3 -> // print to screen
						phonebook.printPhoneBook();

				case 4 -> { // find contact
					System.out.println("Insert name to search: ");
					String find_name = reader.nextLine();
					ArrayList<Contact> found = phonebook.findContacts(find_name);

					// we're supposed to just print them
					Phonebook foundContacts = new Phonebook();
					foundContacts.setPb(found);
					foundContacts.printPhoneBook();
				}

				case 5 -> { // sort lexi
					phonebook.sortByName();
					System.out.println("Phone book sorted lexicographically");
				}
				case 6 -> { // sort num
					phonebook.sortByNumber();
					System.out.println("Phone book sorted numerically");
				}
				case 7 -> { // Delete Duplicates
					phonebook.deleteDuplicates();
					System.out.println("Duplicates deleted successfully");
				}
				case 8 -> { // Reverse
					phonebook.reverseOrder();
					System.out.println("Order reversed successfully");
				}
				case 9 -> { // Save to file
					System.out.println("Enter file name: ");
					String outfile = reader.nextLine();
					try {
						phonebook.saveToFile(outfile);
						System.out.println("Successfully written data to the file " + outfile);
					} catch (IOException e) {
						System.out.println("Error writing to the output file. Check that " +
								"the file exists and that it is available for writing.");
					}
				}
				case 10 -> { // Load from file
					System.out.println("Enter file name: ");
					String infile = reader.nextLine();
					try {
						phonebook.loadFromFile(infile);
						System.out.println("Successfully read contacts from the file " + infile);
					} catch (FileNotFoundException e) {
						System.out.println("Error reading from the input file. Check that " +
								"the file exists and that it is available for reading.");

					}
				}
				case 11 -> { // exit
					menu_on = false;
					System.out.println("Bye! See you soon ...");
				}
				default -> System.out.println("Your Choice is not valid. Try again.");
			}
		}
		reader.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		handleUser();
	}

}
