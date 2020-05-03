/*
 * Copyright (c) 2012, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package org.glassfish.examples.http;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

/**
 * @author jwells
 *
 */
@Singleton
public class HttpServer {
    @Inject
    private HttpRequest httpRequest;
    
    @Inject
    private RequestContext requestContext;
    
    /**
     * This method starts an httpRequest, with all the values from that request
     * 
     * @param lastRank The last rank as read in from the network
     * @param id The last request id as read in from the network
     * @param action The last action as read in from the network
     */
    public void startRequest(String lastRank, String id, String action) {
        requestContext.startRequest();
        
        httpRequest.addElement(lastRank);
        httpRequest.addElement(id);
        httpRequest.addElement(action);
    }
    
    /**
     * Finishes the request
     */
    public void finishRequest() {
        requestContext.stopRequest();
    }

}
