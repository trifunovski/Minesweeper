import java.util.Random;

public class Board {
	public int[][] fields;
	private int size;
	public int bombs;
	
	public Board(int bombs, int size){
		this.size = size;
		this.bombs = bombs;
		fields = new int[size][size];
		for(int i = 0; i < size ; i++)
			for(int j = 0; j < size ; j++)
				fields[i][j] = 0;
		randomBombs(bombs);
	}

	private void randomBombs(int bombs) {
		while(bombs>0){
			Random rand = new Random();
			int n = rand.nextInt(size);
			int m = rand.nextInt(size);
			while(fields[n][m]==-1){
				n = rand.nextInt(size);
				m = rand.nextInt(size);
			}
			fields[n][m] = -1;
			bombs--;
		}
		
	}

	public int getSize() {
		return size;
	}
	
	public int getLoc(int i, int j){
		return fields[i][j];
	}
	
	public void setLoc(int i, int j, int val){
		fields[i][j]=val;
	}
	
	public int hasBomb(int i, int j){
		if(i<0 || i>=size || j<0 || j>=size)
			return 0;
		if(fields[i][j] == -1)
			return 1;
		return 0;
	}
}
