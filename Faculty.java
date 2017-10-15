import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Faculty {

	private String first="";
	private String last="";
	private String id="";
	static String fileName = "Faculty.txt"; //Text file to be written to
	static BufferedWriter bw = null;

	static {

		try {

			//This will write to the file
			bw = new BufferedWriter(new FileWriter(fileName));

		} catch (IOException ioe) {

			ioe.printStackTrace();

		}

	}


	public Faculty(String f, String l, String id){
		first=f;
		last=l;
		this.id=id;
	}
	
	public void facultyTree(){
		BST facultyTree = new BST();
		facultyTree.insert(last+" "+first+" "+id);
	}
	
	public void write(BST f) {

		try {
			
			bw = new BufferedWriter(new FileWriter(fileName, true));
			bw.write(f.toString());
			bw.newLine();
			bw.close();

		} catch (IOException ioe) {

			ioe.printStackTrace();

		}

	}

	

}
