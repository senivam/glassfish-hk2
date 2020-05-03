/*
 * Copyright (c) 2013, 2018 Oracle and/or its affiliates. All rights reserved.
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

package org.glassfish.hk2.tests.locator.proxysamescope;

import jakarta.inject.Inject;

import org.glassfish.hk2.api.ProxyCtl;
import org.junit.Assert;

/**
 * Even though ProxiableServiceD is in the same scope, it should
 * still be proxied because of the explicit choice of
 * ProxiableServiceD.  ProxiableServiceDPrime has been
 * explicitly set ProxyForSameScope to false
 * 
 * @author jwells
 *
 */
@ProxiableSingletonNoLazy
public class ProxiableServiceE {
    @Inject
    private ProxiableServiceD serviceD;
    private ProxiableServiceDPrime dPrime;
    
    @SuppressWarnings("unused")
    @Inject
    private void setDPrime(ProxiableServiceDPrime dPrime) {
        this.dPrime = dPrime;
        
    }
    
    public void check() {
        Assert.assertTrue(serviceD instanceof ProxyCtl);
        Assert.assertFalse(dPrime instanceof ProxyCtl);
    }

}
