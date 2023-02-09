package Matrix;

import java.util.Iterator;
import java.util.LinkedList;

public class SparseMatrix extends UsualMatrix implements IMatrix{
	
	public LinkedList <Element> matrixList;
	public int curRow;
	public int curColumn;
	
	public SparseMatrix (int row, int column){
		
		super(row, column);
		
		curRow = row;
		curColumn = column;
		
		matrixList = new LinkedList <Element>();
	}
	
	public void setElement (int row, int column, int value){
		
		Element el = new Element(value, row, column); 
		
		Iterator <Element> it = matrixList.listIterator();
		while(it.hasNext()) {
			Element a = it.next();
			if(a.getR() == el.getR() && a.getC() == el.getC()) {
				it.remove();
			}
		}
		
		if(value != 0) {
			matrixList.add(el);
		}
	}
	
	public int getElement (int row, int column) {
		
		Iterator <Element> it = matrixList.listIterator();
		
		while(it.hasNext()) {
			Element a = it.next();
			if(a.getR() == row && a.getC() == column) {
				return a.getV();
			}
		}
		return 0;
	}
}

class Element {
	
	int value;
	int row;
	int column;
	
	public Element(int v, int r, int c) {
		value = v;
		row = r;
		column = c;
	}
	
	int getV() {
		return value;
	}
	
	int getR() {
		return row;
	}
	
	int getC() {
		return column;
	}
}
