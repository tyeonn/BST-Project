import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Student {

	private String first="";
	private String last="";
	private String id="";
	static String fileName = "Student.txt"; //Text file to be written to
	static BufferedWriter bw = null;

	static {

		try {

			//This will write to the file
			bw = new BufferedWriter(new FileWriter(fileName));

		} catch (IOException ioe) {

			ioe.printStackTrace();

		}

	}

	public Student(String f, String l, String id){
		first=f;
		last=l;
		this.id=id;
	}
	
	public void studentTree(){
		BST studentTree = new BST();
		studentTree.insert(last+" "+first+" "+id);
	}
	
	public void write(BST s) {

		try {
			
			bw = new BufferedWriter(new FileWriter(fileName, true));
			bw.write(s.toString());
			bw.newLine();
			bw.close();

		} catch (IOException ioe) {

			ioe.printStackTrace();

		}

	}


	
	
	
}
