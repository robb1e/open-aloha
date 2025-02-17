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

 	

 	
 	
 
package com.bt.aloha.media.convedia.msml.model;

import noNamespace.MsmlEventNameValueDatatype;
import noNamespace.MsmlDocument.Msml.Event;


public class MsmlDtmfGenerationResponse extends MsmlEventResponse {
	private String dtmfGenEnd;
	
	public MsmlDtmfGenerationResponse(String aCommandId, String aDtmfGenEnd) {
		super(aCommandId, MsmlApplicationEventType.DTMFGEN_COMMAND_COMPLETE);
		if(aDtmfGenEnd == null)
			throw new IllegalArgumentException("DTMF gen end status must not be null");
		this.dtmfGenEnd = aDtmfGenEnd;
	}

	public String getDtmfGenEnd() {
		return dtmfGenEnd;
	}

	@Override
	protected void addEventNameValuePairs(Event event) {
		event.addName(MsmlEventNameValueDatatype.DTMFGEN_END);
		event.addValue(dtmfGenEnd);
	}
}
