package com.behindthewalls.evgeniyChobotar;

public class GameBoard {   
    static private int[][]  gameboard   = new int[3][3];
    private int             player;
    final private int       X           =  1,
                            O           = -1,
                            empty       =  0;
    
    void setPosition(int i,int j,int p) {
        this.gameboard[i][j] = p;
    }
    
    int getPosition(int i,int j) {
        return this.gameboard[i][j];
    }    
    
    boolean checkCorrectTurn(int i,int j,int p) {
        return (getPosition(i,j) == empty);
    }
    
    boolean winnerCheck(int p) {
        return (getPosition(1,1)==p && getPosition(1,1)==getPosition(0,0) && getPosition(1,1)==getPosition(2,2)    || 
                getPosition(1,1)==p && getPosition(1,1)==getPosition(0,2) && getPosition(1,1)==getPosition(2,0)    ||
                getPosition(1,1)==p && getPosition(1,1)==getPosition(0,1) && getPosition(1,1)==getPosition(2,1)    ||   
                getPosition(1,1)==p && getPosition(1,1)==getPosition(1,0) && getPosition(1,1)==getPosition(1,2)    ||

                getPosition(1,0)==p && getPosition(1,0)==getPosition(0,0) && getPosition(1,0)==getPosition(2,0)    ||

                getPosition(0,1)==p && getPosition(0,1)==getPosition(0,0) && getPosition(0,1)==getPosition(0,2)    ||

                getPosition(1,2)==p && getPosition(1,2)==getPosition(0,2) && getPosition(1,2)==getPosition(2,2)    ||

                getPosition(2,1)==p && getPosition(2,1)==getPosition(2,0) && getPosition(2,1)==getPosition(2,2)    
                ) ;
    }
}
