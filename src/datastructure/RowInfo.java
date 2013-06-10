/**
 * 
 */
package datastructure;

/**
 * @author Phillip
 *
 */
public class RowInfo {

	private int row;
	private String equation;
	
	public RowInfo(int i, String e){
		this.row = i;
		this.equation = e;		
	}
	
	public RowInfo(){
	}

	/**
	 * @return the name
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @return the row
	 */
	public String getEquation() {
		return equation;
	}
	
	
}
