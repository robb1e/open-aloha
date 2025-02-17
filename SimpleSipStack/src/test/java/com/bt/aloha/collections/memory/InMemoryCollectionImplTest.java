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

 	

 	
 	
 
/**
 * (c) British Telecommunications plc, 2007, All Rights Reserved
 */
package com.bt.aloha.collections.memory;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.bt.aloha.collections.memory.InMemoryCollectionImpl;
import com.bt.aloha.dialog.state.DialogInfo;
import com.bt.aloha.dialog.state.DialogState;
import com.bt.aloha.util.CollectionImplTestBase;

public class InMemoryCollectionImplTest extends CollectionImplTestBase {
	static private boolean extraUpdatesCalled;

	@Before
	public void before() {
		dc = new InMemoryCollectionImpl<DialogInfo>();
		di1 = new DialogInfo("id1", "bean1", "1.2.3.4");
		extraUpdatesCalled = false;
	}


    /**
     * Make sure replace will call doExtraUpdates()
     * @throws Exception
     */
    @Test
    public void replaceCallsDoExtraUpdates() {
        // setup
        NewInMemoryInfoCollectionImpl subclass = new NewInMemoryInfoCollectionImpl();
        di1.setDialogState(DialogState.Confirmed);
        subclass.add(di1);
        di1.setDialogState(DialogState.Terminated);

        // act
        subclass.replace(di1);

        // assert
        assertTrue("Did not call doExtraUpdates.", extraUpdatesCalled);
    }



	static class NewInMemoryInfoCollectionImpl extends InMemoryCollectionImpl<DialogInfo> {
		@Override
		public void doExtraUpdates(DialogInfo info, DialogInfo newInfo) {
			super.doExtraUpdates(info, newInfo);
			extraUpdatesCalled = true;
		}
	}
}
