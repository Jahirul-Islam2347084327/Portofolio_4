package uk.ac.aston.oop.rdd.sim;

public class Grid {

	private final int height;
	 private final int width;
	 private final GridCell[][] rows;
	 
	 public Grid(int height, int width) {
		 this.height = height;
		 this.width = width;
		 rows = new GridCell[height][];
		 
		 for (int i = 0; i<rows.length;i++) {
			 rows[i] = new GridCell[width];
			 for (int j=0; j<width;j++) {
				 rows[i][j] = new GridCell(this, i, j);
			 }
		 }
	 }
	
	 public int getWidth() {
		 return width;
	 }
	 
	 public int getHeight() {
		 return height;
	 }
	 
	 public GridCell get(int row, int column) {
		 return rows[row][column];
	 }
	 
}
