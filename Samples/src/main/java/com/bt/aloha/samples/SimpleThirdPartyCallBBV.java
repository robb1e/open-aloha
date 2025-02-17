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

 	

 	
 	
 
package com.bt.aloha.samples;

import java.net.URI;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bt.aloha.call.CallBean;
import com.bt.aloha.callleg.OutboundCallLegBean;

/**
 * Simplest ThirdPartyCall scenario
 */
public class SimpleThirdPartyCallBBV {

    public void makeCall(String caller, String callee) throws Exception {
        // load Spring
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/bt/aloha/samples/ThirdPartyCall.ApplicationContext.xml");

        // get required beans
        OutboundCallLegBean outboundCallLegBean = (OutboundCallLegBean)applicationContext.getBean("outboundCallLegBean");
        CallBean callBean = (CallBean)applicationContext.getBean("callBean");

        // create two call legs
        String callLegId1 = outboundCallLegBean.createCallLeg(URI.create("sip:05601500000@bmnhb-03.bt.com"), URI.create(caller));
        String callLegId2 = outboundCallLegBean.createCallLeg(URI.create("sip:05601500000@bmnhb-03.bt.com"), URI.create(callee));

        // join the call legs
        System.out.println(String.format("connecting %s and %s in call...", caller, callee));
        System.out.println(callBean.joinCallLegs(callLegId1, callLegId2));

        // allow time for phones to ring and be answered
        Thread.sleep(180000);

        // destroy the Spring context to release stack and ports
        applicationContext.destroy();
    }

    public static void main(String[] args) throws Exception {
        new SimpleThirdPartyCallBBV().makeCall(
        		"sip:02087261156@bmnhb-03.bt.com;username=05601500000;password=05601500000TEST",
        		"sip:02087261158@bmnhb-03.bt.com;username=05601500000;password=05601500000TEST"
//        		"sip:07918029610@bmnhb-03.bt.com;username=05601500000;password=05601500000TEST",
//        		"sip:01908614079@bmnhb-03.bt.com;username=05601500000;password=05601500000TEST"
        	);
  //      		"sip:joe.darling@sandbox.sip.bt.com");
//        new SimpleThirdPartyCall().makeCall("sip:adrian@10.237.33.48:5060", "sip:joe@10.237.33.193:5060");
    }
}
