/*
 * Copyright (c) 2021.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Dimitrios Sria: GameOfLife v.0.1
 */
package org.dimitrios.gameoflife;

/**
 *
 * @author srvmng
 */
public class Game {

  private Board board;
  private int births;
  
    /**
     *Constructor
     */
    public Game() {
        this.births = 10;
    }

    /**
     *Genererar liv och tar bort döda
     */
    public void iterate() {
    
    byte[] prev = new byte[board.getBoardSize()];
    randomBirth();
    
    System.arraycopy(board.getPrintedBoard(), 0, prev, 0, board.getBoardSize());

    byte[] next = new byte[board.getBoardSize()];

    for (int i = 0; i < board.getWidth(); i++) {

      for (int j = 0; j < board.getHeight(); j++) {

        int type = isAlive(i, j, prev);

        if (type > 0) {

          next[j * board.getWidth() + i] = 1;

        } else {

          next[j * board.getWidth() + i] = 0;

        }

      }
      
    }
    
    System.arraycopy(next, 0, board.getPrintedBoard(), 0, board.getBoardSize());//Print the byte
    //System.out.println(Arrays.toString(next));
    for (int i =0; i<board.getWidth(); i++){
        for (int j = 0; j < board.getHeight(); j++){
            System.out.print(next[j* board.getWidth() + 1] + " ");
        }
        System.out.print("\n");
    }
  }

    /**
     *Kollar if grannarna är levande eller ej enligt spelet.
     * @param x
     * @param y
     * @param d
     * @return
     */
    protected int isAlive(int x, int y, byte[] d) {

    int count = 0;

    int pos1 = y * board.getWidth() + x;

    for (int i = x - 1; i <= x + 1; i++) {

      for (int j = y - 1; j <= y + 1; j++) {

        int pos = j * board.getWidth()+ i;

        if (pos >= 0 && pos < board.getBoardSize() - 1 && pos != pos1) {

          if (d[pos] == 1) {

            count++;

          }

        }

      }

    }

    if (d[pos1] == 0) {

      if (count == 3) {

        return 1;//Levande

      }

      return 0;//Död

    } else {

      if (count < 2 || count > 3) {

        return 0;

      }

      return 1;

    }

  }

    /**
     *Placerar levande celler slumpmässigt
     */
    public void randomBirth() {

    for (int i = 0; i < getBirths(); i++) {

      int x = (int)(Math.random() * board.getWidth());

      int y = (int)(Math.random() * board.getHeight());

       board.setPos(x, y, (byte) 1);

    }
  }
  //Getters n setters
  public Board getBoard() {
    return board;
  }

  public void setBoard(Board board) {
    this.board = board;
  }

    public int getBirths() {
        return births;
    }

    public void setBirths(int births) {
        this.births = births;
    }

}