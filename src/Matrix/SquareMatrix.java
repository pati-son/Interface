package Matrix;

public class SquareMatrix extends UsualMatrix implements IMatrix{

	public SquareMatrix (int size){

		super(size, size);


		curRow = size;
		curColumn = size;
		matrix = new int [curRow][curColumn];

		for(int i = 0; i < curRow; i++){
			for(int j = 0; j < curColumn; j++){
				if(i == j){
					matrix[i][j] = 1;
				}
			}
		}
	}

	public SquareMatrix sum (SquareMatrix q){

		SquareMatrix matrix = new SquareMatrix(curRow);

		if(this.curColumn == q.curColumn + 1){
			for(int i = 0; i < curRow; i++){
				for(int j = 0; j < curColumn; j++){
					matrix.setElement(i, j, 0);
				}
			}	
	

			for(int i = 0; i < curRow; i++){
				for(int j = 0; j < curColumn; j++){
					int t = q.getElement(i, j) + this.getElement(i, j);
					matrix.setElement(i, j, t);
				}
			}
		}
		else{
			for(int i = 0; i < curRow; i++){
				for(int j = 0; j < curColumn; j++){
					matrix.setElement(i, j, 0);
				}
			}	


			for(int i = 0; i < curRow; i++){
				for(int j = 0; j < curColumn; j++){
					int t = q.getElement(i, j) + this.getElement(i, j);
					matrix.setElement(i, j, t);
				}
			}
		}
		//System.out.println(matrix);
		return matrix;
	}
}
