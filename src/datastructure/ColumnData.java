/**
 * 
 */
package datastructure;

/**
 * @author fiala
 *
 */
public class ColumnData implements Comparable<ColumnData> {

	private int i;
	private double d;
	
	public ColumnData(int i, double d){
		this.i = i;
		this.d = d;
	}

	/**
	 * @return the i
	 */
	public int getI() {
		return i;
	}

	/**
	 * @return the d
	 */
	public double getD() {
		return d;
	}

	@Override
	public int compareTo(ColumnData a) {
		if(a.getI() < this.i){
			return 1;
		}
		return -1;
	}
}
