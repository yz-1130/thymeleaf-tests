/*
 * =============================================================================
 * 
 *   Copyright (c) 2011-2016, The THYMELEAF team (http://www.thymeleaf.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package org.thymeleaf.util;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Christopher Kluwe
 * 
 * @since 2.0.17
 *
 */
public class DateUtilsTest {
    /**
     * constructor.
     */
    public DateUtilsTest() {
        super();
    }

    @Test
    @SuppressWarnings("boxing")
    public void testCreateToday() {
        final Calendar cal = Calendar.getInstance();
        final Calendar today = DateUtils.createToday();

        Assert.assertEquals(today.get(Calendar.YEAR), cal.get(Calendar.YEAR));
        Assert.assertEquals(today.get(Calendar.MONTH), cal.get(Calendar.MONTH));
        Assert.assertEquals(today.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.DAY_OF_MONTH));
        Assert.assertEquals(today.get(Calendar.HOUR), 0);
        Assert.assertEquals(today.get(Calendar.MINUTE), 0);
        Assert.assertEquals(today.get(Calendar.SECOND), 0);
        Assert.assertEquals(today.get(Calendar.MILLISECOND), 0);
    }
}
