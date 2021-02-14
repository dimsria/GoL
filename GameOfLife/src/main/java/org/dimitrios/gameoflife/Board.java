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
public class Board{
    
    private final int width; //bred
    private final int height; //höjd
    private final int boardSize; //storlek
    private final byte [] printedBoard;
    
    public Board(int width, int height){
        this.width = width;
        this.height = height;
        boardSize = width*height;
        printedBoard = new byte [boardSize];
    }
    
    public void setPos(int x, int y, byte val) {
        printedBoard[y * width + x] = val;
    }
    

    public int getBoardSize() {
        return boardSize;
    }

    public byte[] getPrintedBoard() {
        return printedBoard;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
  

}
