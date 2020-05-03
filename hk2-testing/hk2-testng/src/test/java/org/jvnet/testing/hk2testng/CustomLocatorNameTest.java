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

package org.jvnet.testing.hk2testng;

import org.jvnet.testing.hk2testng.service.PrimaryService;
import jakarta.inject.Inject;
import static org.assertj.core.api.Assertions.assertThat;
import org.glassfish.hk2.api.ServiceLocator;
import org.testng.annotations.Test;

/**
 *
 * @author saden
 */
@HK2(CustomLocatorNameTest.CUSTOM_LOCATOR_NAME)
public class CustomLocatorNameTest {

    public static final String CUSTOM_LOCATOR_NAME = "custom";

    @Inject
    ServiceLocator sericeLocator;

    @Inject
    PrimaryService primaryService;

    @Test
    public void assertPrimaryServiceInjecton() {
        assertThat(primaryService).isNotNull();
    }

    @Test
    public void assertSecondaryService() {
        assertThat(primaryService.getSecondaryService()).isNotNull();
    }

    @Test
    public void assertServiceLocatorIsCustom() {
        assertThat(sericeLocator.getName())
                .isEqualTo(CUSTOM_LOCATOR_NAME);
    }
}
