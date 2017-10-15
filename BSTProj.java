import java.io.*;
import java.util.*;

public class BSTProj {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String firstName = "";
		String lastName = "";
		String id = "";
		try {

			while (!firstName.equals("exit")) {

				System.out.println("Enter first name: (Enter 'exit' to close.) ");
				firstName = br.readLine();
				if (firstName.equalsIgnoreCase("exit")) {
					br.close();
					return;
				}

				while (!firstName.matches("[a-zA-Z]+")) {
					System.out.println("Name contains wrong characters. Try again: ");
					firstName = br.readLine();
				}
				System.out.println("Enter last name: ");
				lastName = br.readLine();
				while (!lastName.matches("[a-zA-Z]+")) {
					System.out.println("Name contains wrong characters. Try again: ");
					lastName = br.readLine();
				}
				System.out.println(
						"Enter 8 digit ID number in the format S####### for students, or F####### for faculty: ");
				id = br.readLine();
				while ((id.length() != 8) || (!id.matches("[SF]{1}[0-9]{7}"))) {
					System.out.println("ID in wrong format. Try again: ");
					id = br.readLine();
				}
				if (id.charAt(0) == 'S') {
					Student st = new Student(firstName, lastName, id);
					st.studentTree();
				} else {
					Faculty ft = new Faculty(firstName, lastName, id);
					ft.facultyTree();
				}

			}

		} catch (IOException ioe) {
			System.out.println("Couldn't read line");
		}

	}
}