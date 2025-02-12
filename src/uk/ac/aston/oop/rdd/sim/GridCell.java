package uk.ac.aston.oop.rdd.sim;

import java.util.ArrayList;
import java.util.Random;

public class GridCell {

	private final ArrayList<Actor> contents;
	private final int row;
	private final int column;
	private final Grid grid;
	
	public GridCell(Grid grid,int row, int column) {
		this.row = row;
		this.column = column;
		contents = new ArrayList<Actor>();
		this.grid = grid;
	}
	
	public ArrayList<Actor> getContents(){
		return contents;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}
	
	public Grid getGrid() {
		return grid;
	}
	
	public ArrayList<GridCell> getAdjacent() {
		ArrayList<GridCell> results  = new ArrayList<GridCell>();
		
		for (int i = this.getRow()-1; i <= this.getRow()+1; i++) {
		    for (int j = this.getColumn()-1; j <= this.getColumn()+1; j++) {
				  if (i == this.getRow() && j == this.getColumn()) {
		                continue;// Do nothing
		            }
				  if(i < 0 || j < 0 || i > grid.getHeight() -1 || j > grid.getWidth() - 1) {
					   continue; // do nothing
					}
				else {
					results.add(grid.get(i,j));
				}
			}
		}
	return results; 
	}
	
	public ArrayList<GridCell> getFreeAdjacent(){
		ArrayList<GridCell> adjacentGrids = getAdjacent();
		ArrayList<GridCell> freeCell = new ArrayList<GridCell>();
		
		for (int i = 0; i<adjacentGrids.size();i++) {
			if(adjacentGrids.get(i).getContents().isEmpty()) {
				freeCell.add(adjacentGrids.get(i));
			}
		}
	return freeCell;	
	}
	
	public GridCell getRandomFreeAdjacent(Random rnd) {
		ArrayList<GridCell> freeAdjacent = getFreeAdjacent();
		if(freeAdjacent.isEmpty()) {
			return null;
		}
		else {
			return freeAdjacent.get(rnd.nextInt(freeAdjacent.size()));
		}
	}
}
