/**
 * 
 */
package datastructure;

import java.util.ArrayList;

/**
 * @author Phillip
 *
 */
public class CCSMatrix {
	
	private ArrayList<Double> val;
	private ArrayList<Integer> row_ind;
	private ArrayList<Integer> col_ptr;
	
	public CCSMatrix(){
		this.val = new ArrayList<Double>();
		this.row_ind = new ArrayList<Integer>();
		this.col_ptr = new ArrayList<Integer>();
	}

}
