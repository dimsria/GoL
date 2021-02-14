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

import java.util.Scanner;

/**
 *
 * @author srvmng
 */
public class Play {
    
    public static void main(String[] args) throws InterruptedException{
        
        Scanner in = new Scanner(System.in);
        
        System.out.print("Ange Bred: ");
        int x = in.nextInt();
        System.out.print("Ange Höjd: ");
        int y = in.nextInt();       
        Board b = new Board(y, x);
        Game g = new Game();
        g.setBoard(b);
        System.out.print("Ange tid i sekunder: ");
       int t = in.nextInt();
        for (int i = 1; i< t; i++){
            try{
            Thread.sleep(1000);
            //g.randomBirth();
            g.iterate();
            }
            catch(InterruptedException e){System.out.println(e);}  
        }
  
    }
}
