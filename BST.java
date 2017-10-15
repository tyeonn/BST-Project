import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BST {

	private BSTNode root;
	
	public void insert(String st){
		root=insert(root,st);
	}
	private BSTNode insert(BSTNode rt, String x){
		
		BSTNode st = new BSTNode(x);
		if(rt==null){
			rt = st;
			return st;
		}
		BSTNode current = rt;
		BSTNode parent = null;
		while(true){
			parent = current;
			if(x.compareTo(current.data)<0){				
				current = current.left;
				if(current==null){
					parent.left = st;
					return st;
				}
			}else{
				current = current.right;
				if(current==null){
					parent.right = st;
					return st;
				}
			}
		}
		
	}
	
	public void delete(String st){
		root = delete(root,st);
	}
	private BSTNode delete(BSTNode rt, String x){
		if(rt.data!=null){
			if(x.compareTo(rt.data)<0){
				rt.left= delete(rt.left, x);
			}else if(x.compareTo(rt.data)>0){
				rt.right=delete(rt.right,x);
			}else{
				if(rt.left==null) {
					return rt.right;
				}else if(rt.right ==null){
					return rt.left;
					
				}else{
					rt.data = findMin(rt.right).data;
					rt.right=delete(rt.right, rt.data);
				}
				
			}
			
		}
		return rt;
	}
	
	private BSTNode findMin(BSTNode rt){
		if(rt==null){
			return null;
		}else if(rt.left!=null){
			return findMin(rt.left);
		}else{
			return rt;
		}
	}
	public void display(){
		display(root);
	}
	private void display(BSTNode rt){
		
		if(rt!=null){
			display(rt.left);
			System.out.print(" " + rt.data);
			display(rt.right);
		}
	}
	public String toString(BSTNode rt){
		String x="";
		if(rt!=null){
			if(rt.left!=null){
			return rt.left.toString();
			}
			if(rt.right!=null){
				return rt.right.toString();
				
			}
			
			
		}
		return x;
	}
	
	public boolean equal(String id){
		BSTNode current = root;
		while(current!=null){
			int space = current.data.indexOf(" ");
			String currID = current.data.substring(space+1); 
		
			if(currID==id){
				return true;
			}else if(currID.compareTo(id)<0){
				current = current.left;
			}else{
				current = current.right;
			}
		}
		return false;

	}
	
	public void compare(String last){
		BSTNode current=root;
		while(current!=null){
			int space = current.data.indexOf(" ");
			if(current.data.substring(0,space)==last){
				System.out.println("Same last name");
				
			}else if(current.data.substring(0,space).compareTo(last)<0){
				current=current.left;
			
			}else{
				current=current.right;
			}
		}
		System.out.println("No match");
	}

	
}
