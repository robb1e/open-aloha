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
package com.bt.aloha.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bt.aloha.util.MediaDescriptionException;

public class MediaDescriptionExceptionTest {

    /*
     * testing single argument constructor
     */
    @Test
    public void testStringConstructor() {
        assertEquals("shit happens", new MediaDescriptionException("shit happens").getMessage());
    }

    /*
     * testing constructor that takes a message and a Throwable
     */
    @Test
    public void testStringAndThrowableConstructor() {
        //setup
        Exception e = new Exception("nested");
        MediaDescriptionException mde = new MediaDescriptionException("shit happens", e);
        assertEquals("shit happens", mde.getMessage());
        assertEquals("nested", mde.getCause().getMessage());
    }
}
