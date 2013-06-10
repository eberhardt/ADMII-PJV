/**
 * 
 */
package inputOutput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import datastructure.CCSMatrix;
import datastructure.ColumnData;
import datastructure.LPStandardform;
import datastructure.RowInfo;
import datastructure.SparseVector;


/**
 * @author Phillip
 *
 */
public class ReadFile {

	private static HashMap<String,RowInfo> hs;
	private static int col;

	public static LPStandardform read(String filename){

		File f = new File("bin"+File.separator+"samples"+File.separator+""+filename+".SIF");
		CCSMatrix A = new CCSMatrix();
		ArrayList<Double> b = new ArrayList<Double>();
		SparseVector c = new SparseVector();

		try{
			FileReader     fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);

			String line = br.readLine();

			//HashMap fuer Zeilen erstellen
			while(line.charAt(0) != 'R'){
				String[] str = line.split(" ");
				ArrayList<String> astr = cleanRow(str);
				if(str.length != 1){
					if(astr.get(1).equals("classification")){
						String[] s = astr.get(2).split("-");
						hs = new HashMap<String,RowInfo>(Integer.parseInt(s[3])+2,1);
						//Spaltenanzahl abspeichern
						col = Integer.parseInt(s[2]);

					}
				}
				line = br.readLine();
				if(line.isEmpty()){
					line = br.readLine();					
				}
			}
			line = br.readLine();
			int i = 0;
			while(line.charAt(0) != 'C'){
				if(line.charAt(1) == 'N'){
					String[] str = line.split(" ");
					ArrayList<String> astr = cleanRow(str);
					hs.put(astr.get(1), new RowInfo(-1,"N"));
				}else{
					String[] str = line.split(" ");
					ArrayList<String> astr = cleanRow(str);
					hs.put(astr.get(1), new RowInfo(i,astr.get(0)));
					i++;
				}
				line = br.readLine();
			}
			line = br.readLine();
			String[] str = line.split(" ");
			ArrayList<String> temp = cleanRow(str);
			// spalten auslesen
			for(int k=0; k<col;k++){
				String column = temp.get(0);
				ArrayList<ColumnData> spalte = new ArrayList<ColumnData>();
				do{
					if(hs.get(temp.get(1)).getRow()==-1){
						c.add(Double.parseDouble(temp.get(2)),k);
					}else{
						spalte.add(new ColumnData(hs.get(temp.get(1)).getRow(),Double.parseDouble(temp.get(2))));
					}
					if(temp.size()==5){
						if(hs.get(temp.get(3)).getRow()==-1){
							c.add(Double.parseDouble(temp.get(4)),k);
						}else{
							spalte.add(new ColumnData(hs.get(temp.get(3)).getRow(),Double.parseDouble(temp.get(4))));
						}						
					}
					
					line = br.readLine();
					str = line.split(" ");
					temp = cleanRow(str);
				}while(column.equals(temp.get(0)));
				Collections.sort(spalte);
				//TODO spalten in matrix
				for(int h = 0;h<spalte.size();h++)System.out.println(spalte.get(h).getD());
				System.out.println("aaaaaaaaaaaaaaaaaaaa");
				
			}

			System.out.println(hs.get("COST").getRow());
			System.out.println(hs.get("COST").getEquation());
			System.out.println(line);


			br.close();
			fr.close();

		} catch (FileNotFoundException e) {
			System.err.println("File "+filename+" not found!");
			e.printStackTrace();
		} catch (IOException e){
			System.err.println("Error while reading: "+filename+"!");
			e.printStackTrace();
		}
		return null;
	}

	private static ArrayList<String> cleanRow(String[] str){
		ArrayList<String> a = new ArrayList<String>();
		for(int i=0;i<str.length; i++){
			if(!str[i].isEmpty()){
				a.add(str[i]);
			}
		}
		return a;
	}

}
