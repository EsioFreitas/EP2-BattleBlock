
package Controller;

import java.awt.Point;
import java.util.ArrayList;

import Model.ArcMap;
import View.ChoosePowersPanel;
import View.GameCanvas;

public class Player {
    
    private String name;
    private int pointers; 
    
    private ArcMap archive;
    private GameCanvas canvas;
    private ChoosePowersPanel choose;
    
    private int[][] explosionMatrix;
    
    private int fleet;
    
    public static final int DESTROY1X1 = 0;
    public static final int DESTROY2X2 = 1;
    public static final int DESTROYROW = 2;
    public static final int DESTROYCOL = 3;
    public static final int SEE2X2 = 4;
    
    private int id = 0;
    
    private int amauntShots;
    private int amauntpowerDestroy2x2 = 1;
    private int amauntpowerDestroyRow = 1;
    private int amauntpowerDestroyCol = 1;
    private int amauntpowerSee = 1;
    
     
    
    public Player(ArcMap archive, GameCanvas canvas){
      this.archive = archive;
      this.fleet = archive.getArcFleet();
      this.canvas = canvas; 
      this.explosionMatrix = canvas.getExplosionMatrix();     
    }
    
    public int amountShots() {
    	int shots = fleet*2;
        this.amauntShots = shots;
        
        return amauntShots;
    }
    
    //
    
    public void shot(int x, int y){
        switch(id){
            case 0: 
                if(amauntShots <= 0){
                    System.out.println("ddddd");
                }else
                    shotBlock(x, y);
                    break;
            case 1:
                if(amauntpowerDestroy2x2 <= 0){
                    System.out.println("doooooont");
                }else 
                    powerDestroy2x2(x, y);
                    break;
            case 2:
                if(amauntpowerDestroyRow <=0){
                    
                }else
                    powerDestroyRow(x, y);
                    break;
            case 3: 
                if(amauntpowerDestroyCol <=0){
                    
                }else
                    powerDestroyCol(x, y);
                    break;
            case 4:
                if(amauntpowerSee <= 0){
                    
                }else
                    powerSee(x, y);
                    break;
            default:
                break;
        }
    }
    
    public int playerPoints(){
        
        return 0;
    }
    
  
    public void shotBlock(int x, int y) {
        amauntShots -= 1;
        if(archive.getPosition(explosionMatrix, x, y) == 0){
            explosionMatrix[x][y] = 6;
        } else{
            explosionMatrix[x][y] = archive.getPosition(explosionMatrix, x, y);
            playerPoints();
        }

    }
    public int Attention(int x, int y) {
            return explosionMatrix[x][y] = 7;
    }
    public void waterShot(int x, int y) {
		explosionMatrix[x][y] = 6;

    }
    
    public void powerSee(int x, int y) {
        amauntpowerSee -= 1;
        if(archive.getPosition(explosionMatrix, x, y) == 0){
            explosionMatrix[x][y] = 0;
        } else
            explosionMatrix[x][y] = 7;
        
        if(archive.getPosition(explosionMatrix, x+1, y) == 0){
            explosionMatrix[x+1][y] = 0;
        } else
            explosionMatrix[x+1][y] = 7;
        
        if(archive.getPosition(explosionMatrix, x+1, y+1) == 0){
            explosionMatrix[x+1][y+1] = 0;
        } else
            explosionMatrix[x+1][y+1] = 7;
        
        if(archive.getPosition(explosionMatrix, x, y+1) == 0){
            explosionMatrix[x][y+1] = 0;
        } else
            explosionMatrix[x][y+1] = 7;
    }
    
    public void powerDestroy2x2(int x, int y) {
        amauntpowerDestroy2x2 -= 1;
        if(archive.getPosition(explosionMatrix, x, y) == 0){
            explosionMatrix[x][y] = 6;
        } else
            explosionMatrix[x][y] = archive.getPosition(explosionMatrix, x, y);
        
        if(archive.getPosition(explosionMatrix, x+1, y) == 0){
            explosionMatrix[x+1][y] = 6;
        } else
            explosionMatrix[x+1][y] = archive.getPosition(explosionMatrix, x+1, y);
        
        if(archive.getPosition(explosionMatrix, x+1, y+1) == 0){
            explosionMatrix[x+1][y+1] = 6;
        } else
            explosionMatrix[x+1][y+1] = archive.getPosition(explosionMatrix, x+1, y+1);
        
        if(archive.getPosition(explosionMatrix, x, y+1) == 0){
            explosionMatrix[x][y+1] = 6;
        } else
            explosionMatrix[x][y+1] = archive.getPosition(explosionMatrix, x, y+1);
    }
    
    public void powerDestroyRow(int x, int y) {
        amauntpowerDestroyRow -= 1;
        for(int i =0; i<canvas.getRows(); i++){
            if(archive.getPosition(explosionMatrix, i, y) > 0){
                explosionMatrix[i][y] = archive.getPosition(explosionMatrix, i, y);
            } else
                explosionMatrix[i][y] = 6;
        }

        
    }
    
    public void powerDestroyCol(int x, int y) {
        amauntpowerDestroyCol -= 1;
        for(int j=0; j<canvas.getCols();j++){
            if(archive.getPosition(explosionMatrix, x, j) > 0){
                explosionMatrix[x][j] = archive.getPosition(explosionMatrix, x, j);
            } else
                explosionMatrix[x][j] = 6;
            

        }
                

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPointers() {
        return pointers;
    }

    public void setPointers(int pointers) {
        this.pointers = pointers;
    }

    public ArcMap getArchive() {
        return archive;
    }

    public void setArchive(ArcMap archive) {
        this.archive = archive;
    }

    public GameCanvas getCanvas() {
        return canvas;
    }

    public void setCanvas(GameCanvas canvas) {
        this.canvas = canvas;
    }

    public ChoosePowersPanel getChoose() {
        return choose;
    }

    public void setChoose(ChoosePowersPanel choose) {
        this.choose = choose;
    }

    public int[][] getExplosionMatrix() {
        return explosionMatrix;
    }

    public void setExplosionMatrix(int[][] explosionMatrix) {
        this.explosionMatrix = explosionMatrix;
    }

    public int getFleet() {
        return fleet;
    }

    public void setFleet(int fleet) {
        this.fleet = fleet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmauntShots() {
        return amauntShots;
    }

    public void setAmauntShots(int amauntShots) {
        this.amauntShots = amauntShots;
    }

    public int getAmauntpowerDestroy2x2() {
        return amauntpowerDestroy2x2;
    }

    public void setAmauntpowerDestroy2x2(int amauntpowerDestroy2x2) {
        this.amauntpowerDestroy2x2 = amauntpowerDestroy2x2;
    }

    public int getAmauntpowerDestroyRow() {
        return amauntpowerDestroyRow;
    }

    public void setAmauntpowerDestroyRow(int amauntpowerDestroyRow) {
        this.amauntpowerDestroyRow = amauntpowerDestroyRow;
    }

    public int getAmauntpowerDestroyCol() {
        return amauntpowerDestroyCol;
    }

    public void setAmauntpowerDestroyCol(int amauntpowerDestroyCol) {
        this.amauntpowerDestroyCol = amauntpowerDestroyCol;
    }

    public int getAmauntpowerSee() {
        return amauntpowerSee;
    }

    public void setAmauntpowerSee(int amauntpowerSee) {
        this.amauntpowerSee = amauntpowerSee;
    }


    
    
}
