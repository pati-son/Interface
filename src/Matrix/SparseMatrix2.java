package Matrix;

import java.util.ArrayList;
import java.util.LinkedList;

public class SparseMatrix2 implements IMatrix {

    private int rows;
    private int columns;
    private ArrayList<LinkedList<Integer>> data;
    //private ArrayList<Integer> array;

    public SparseMatrix2(int rows, int columns) {
       
            this.rows = rows;
            this.columns = columns;
           // array = new ArrayList<>(columns);
           // for(int j = 0; j < columns; j++) array.add(null);
            data = new ArrayList<LinkedList<Integer>>();
            for(int i = 0; i < this.rows; i++) {
                //data.add(i, array);
                data.add(new LinkedList<Integer>());
                for(int j = 0; j < columns; j++) {
                    data.get(i).add(j, null);
                }
            }

        
    }

    public void setElement(int row, int column, int value) {
       // row = 2; column = 4
            for(int i = 0; i < this.columns; i++) { // иду по массиву
                for(int j = 0; j < this.rows; j++) { // иду по списку
                    if(i == row && j == column) {
                        data.get(i).set(j, value);
                    }
                }
            }
        
    }

    public int getElement(int row, int column) {
        
            for(int i = 0; i < this.columns; i++) { // иду по списку
                for(int j = 0; j < this.rows; j++) { // иду по массиву
                    if(i == row && j == column) {
                        if (data.get(i).get(j) == null) return 0;
                        else return data.get(i).get(j);
                    }
                }
            }
        
        return 0;
    }


    public int getRow() {
        return rows;
    }
    public int getColumn() {
        return columns;
    }

    public SparseMatrix2 sum(final IMatrix second) { // «јћ≈Ќ»“№ Ќј final IMatrix
       
            SparseMatrix2 tmp = new SparseMatrix2(this.getRow(), this.getColumn());

            for(int i = 0; i < this.getRow(); i++) {
                for(int j = 0; j < this.getColumn(); j++) {
                    int a = this.getElement(i, j) + second.getElement(i, j);
                    tmp.setElement(i, j, a);
                    //System.out.println(a);
                    //tmp.setElement(i, j, a);
                }
            }
            return tmp;
        }
    

    public SparseMatrix2 product(final IMatrix second) {
        
            SparseMatrix2 newMatrix = new SparseMatrix2(rows, columns);
            int res = 0;
            for (int i = 0; i < rows; i++) {
                for (int u = 0; u < columns; u++) {
                    for (int j = 0; j < rows; j++) {
                        res = newMatrix.getElement(i,u) + getElement(i,j) * second.getElement(j,u);
                        if (res != 0) {
                            newMatrix.setElement( i, u, res);
                        }
                    }
                }
            }
            return newMatrix;
     }
    

    public String toString() {
        StringBuilder res = new StringBuilder();
            for(int i = 0; i < this.columns; i++) {
                for(int j = 0; j < this.rows; j++) {
                    if(data.get(i).get(j) == null) {
                        res.append("0").append(" ");
                    }
                    else res.append(data.get(i).get(j)).append(" ");
            }
                res.append("\n");
        }
        return res.toString();
    }

    public boolean equals(IMatrix second) {
        if(this.rows != second.getRow() || this.columns != second.getRow()) {
            return false;
        }
        for(int i = 0; i < this.rows; i++) {
            for(int j = 0; j < this.columns; j++) {
                if(this.getElement(i, j) != second.getElement(i,j)) {
                    return false;
                }
            }
        }
        return true;
    }
}

class Elements {
	
	int value;
	int column;
	
	public Elements(int v, int c) {
		value = v;
		
		column = c;
	}
	
	int getV() {
		return value;
	}
	
	
	int getC() {
		return column;
	}
}
