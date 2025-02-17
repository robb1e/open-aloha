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

 	

 	
 	
 
package com.bt.aloha.testing.mockphones;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bt.aloha.testing.mockphones.MockphonesHelper;

public class MockphonesHelperTest {

	@Test
	public void testGetRecipient() throws Exception {
		String uri = "sip:sleepy@123123.org:1234";
		String recipient = MockphonesHelper.getRecipient(uri);
		assertEquals("sleepy", recipient);
	}
	
	@Test
	public void testGetRecipientMoreAt() throws Exception {
		String uri = "sip:sleepy@1231@23.or@g:123@4";
		String recipient = MockphonesHelper.getRecipient(uri);
		assertEquals("sleepy", recipient);
	}	

	@Test
	public void testGetRecipientEmptyRecipient() throws Exception {
		String uri = "sip:@123123.org:1234";
		String recipient = MockphonesHelper.getRecipient(uri);
		assertEquals("", recipient);
	}
	
	@Test
	public void testGetRecipientEmptyUri() throws Exception {
		String uri = "";
		String recipient = MockphonesHelper.getRecipient(uri);
		assertEquals("", recipient);
	}
	
	@Test
	public void testGetDwarf() throws Exception {
		assertEquals("", MockphonesHelper.getDwarfName(""));
		assertEquals("sleepy", MockphonesHelper.getDwarfName("sleepy"));
		assertEquals("sleepy", MockphonesHelper.getDwarfName("sleepy.123456789"));
		assertEquals("sleepy", MockphonesHelper.getDwarfName("sleepy.1234.123456789"));
	}
	
	@Test
	public void testGetOneParam() throws Exception {
		String[] params = MockphonesHelper.getParams("sleepy.1234");
		assertEquals(1, params.length);
		assertEquals("1234", params[0]);
	}
	
	@Test
	public void testGetTwoParams() throws Exception {
		String[] params = MockphonesHelper.getParams("sleepy.abc.def");
		assertEquals(2, params.length);
		assertEquals("abc", params[0]);
		assertEquals("def", params[1]);
	}
	
	@Test
	public void testGetThreeParams() throws Exception {
		String[] params = MockphonesHelper.getParams("sleepy.abc.def.ghi");
		assertEquals(3, params.length);
		assertEquals("abc", params[0]);
		assertEquals("def", params[1]);
		assertEquals("ghi", params[2]);
	}
	
	@Test
	public void testGetParamsNoParams() throws Exception {
		String[] params = MockphonesHelper.getParams("sleepy");
		assertEquals(0, params.length);
	}
	
	@Test
	public void testGetParamsNoParams2() throws Exception {
		String recipient = "sleepy.";
		String[] params = MockphonesHelper.getParams(recipient);
		assertEquals(0, params.length);
	}
}
