/*
 * Aloha Open Source SIP Application Server- https://trac.osmosoft.com/Aloha
 *
 * Copyright (c) 2008, British Telecommunications plc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License as published by the Free Software
 * Foundation; either version 3.0 of the License, or (at your option) any later
 * version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along
 * with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */

 	

 	
 	
 
package com.bt.aloha.batchtest;

import java.util.Vector;

import com.bt.aloha.dialog.collections.DialogCollection;
import com.bt.aloha.dialog.collections.DialogCollectionImpl;
import com.bt.aloha.dialog.state.DialogInfo;
import com.bt.aloha.util.ConcurrentUpdateException;

public class DialogCollectionImplWithStats extends DialogCollectionImpl {
	private Vector<String> invocationCounter;
	private Vector<String> exceptionCounter;

	public DialogCollectionImplWithStats(DialogCollection collection) {
		super(collection);
		invocationCounter = new Vector<String>();
		exceptionCounter = new Vector<String>();
	}

	@Override
	public void replace(DialogInfo dialogInfo) {
		try {
			invocationCounter.add(dialogInfo.getId());
			super.replace(dialogInfo);
		} catch(ConcurrentUpdateException e) {
			exceptionCounter.add(dialogInfo.getId());
			throw e;
		}
	}

	public int getExceptionCounterSize() {
		return exceptionCounter.size();
	}

	public int getInvocationCounterSize() {
		return invocationCounter.size();
	}

    public void reset(){
        this.invocationCounter.clear();
        this.exceptionCounter.clear();
    }
}
