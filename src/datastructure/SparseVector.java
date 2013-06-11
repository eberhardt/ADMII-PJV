/**
 * 
 */
package datastructure;

/**
 * @author Philipp Fiala, Jan Eberhardt
 *
 */
public class SparseVector {

	private Double[] oVals; //original values
	private Integer[] oRows; //original rows
	private boolean finalized;
	private Double[] vals;
	private Integer[] rows;
	private int last;
	
	public SparseVector(int size){
		this.vals = new Double[size];
		this.rows = new Integer[size];
		this.last = 0;
		finalized = false;
	}

	public void add(double value,int pos){
		vals[last] = value;
		rows[last] = pos;
		last++;
	}
	/**
	 * @return the vals
	 */
	public Double[] getVals() {
		return vals;
	}

	public void finalize()
	{
		if(!finalized)
		{
			oVals = vals;
			oRows = rows;
			finalized = true;
		}
		else 
			System.out.println("WARNING: Already finalized.");
	}
	
	/**
	 * @return the rows
	 */
	public Integer[] getRows() {
		return rows;
	}
	
	public int size()
	{
		return last;
	}
	
	public int max()
	{
		return vals.length;
	}
	
	/**
	 * Eleminates zero-entries in vector
	 */
	public void refill()
	{
		if(!finalized)
		{
			System.out.println("ERROR: Vector has to be finalized.");
			System.exit(0);
		}
		else
		{
			Double[] tempVals = new Double[max()];
			Integer[] tempRows = new Integer[max()];
			int tempLast = 0;
			for(int i=0; i<last; i++)
			{
				if(vals[i] != 0)
				{
					tempVals[tempLast] = vals[i];
					tempRows[tempLast] = rows[i];
					tempLast++;
				}
			}
			
			vals = tempVals;
			rows = tempRows;
			last = tempLast;
		}
	}
}
