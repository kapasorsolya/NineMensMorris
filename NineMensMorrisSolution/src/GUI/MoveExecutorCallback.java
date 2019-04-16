/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.Move;

/**
 *
 * @author Orsolya
 */
public interface MoveExecutorCallback {
	public void makeMove(Move move);
	public void terminate();
}
