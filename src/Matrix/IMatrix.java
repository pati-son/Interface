package Matrix;

public interface IMatrix {
	int getElement (int row, int column);
	void setElement (int row, int column, int value);
	IMatrix product (IMatrix q);
	IMatrix sum (IMatrix q);
	boolean equals(IMatrix q);
	int getRow();
	int getColumn();
}
