/**
 * 
 */
package datastructure;

import java.util.ArrayList;

/**
 * @author fiala
 *
 */
public class SparseVector {

	private ArrayList<Double> vals;
	private ArrayList<Integer> rows;
	
	public SparseVector(){
		this.vals = new ArrayList<Double>();
		this.rows = new ArrayList<Integer>();
	}

	public void add(double d,int i){
		vals.add(d);
		rows.add(i);
	}
	/**
	 * @return the vals
	 */
	public ArrayList<Double> getVals() {
		return vals;
	}

	/**
	 * @return the rows
	 */
	public ArrayList<Integer> getRows() {
		return rows;
	}
}
