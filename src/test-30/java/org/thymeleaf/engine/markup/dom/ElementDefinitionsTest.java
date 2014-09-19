/*
 * =============================================================================
 * 
 *   Copyright (c) 2011-2014, The THYMELEAF team (http://www.thymeleaf.org)
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
package org.thymeleaf.engine.markup.dom;

import org.junit.Assert;
import org.junit.Test;


public final class ElementDefinitionsTest {



    @Test
    public void test() {

        final int standardSize = ElementDefinitions.ALL_STANDARD_ELEMENTS.size();
        Assert.assertEquals(standardSize, ElementDefinitions.ALL_STANDARD_ELEMENT_NAMES.size());

        for (final String name : ElementDefinitions.ALL_STANDARD_ELEMENT_NAMES) {
            final ElementDefinition def1 = ElementDefinitions.forName(false, name);
            final ElementDefinition def2 = ElementDefinitions.forName(false, name);
            final ElementDefinition def3 = ElementDefinitions.forName(false, name.toUpperCase());
            Assert.assertSame(def1, def2);
            Assert.assertSame(def2, def3);
        }

        final ElementDefinition new1 = ElementDefinitions.forName(false, "NEW");
        Assert.assertNotNull(new1);
        Assert.assertEquals("new", new1.getName());
        final ElementDefinition new2 = ElementDefinitions.forName(false, "new");
        Assert.assertSame(new1, new2);
        final ElementDefinition new3 = ElementDefinitions.forName(false, "NeW");
        Assert.assertSame(new1, new3);
        final ElementDefinition new4 = ElementDefinitions.forName(true, "NeW");
        Assert.assertNotSame(new1, new4);
        final ElementDefinition new5 = ElementDefinitions.forName(true, "new");
        Assert.assertSame(new1, new5);
        final ElementDefinition new6 = ElementDefinitions.forName(false, "new");
        Assert.assertSame(new1, new6);

        Assert.assertEquals(standardSize, ElementDefinitions.ALL_STANDARD_ELEMENTS.size());
        Assert.assertEquals(standardSize, ElementDefinitions.ALL_STANDARD_ELEMENT_NAMES.size());
        Assert.assertFalse(ElementDefinitions.ALL_STANDARD_ELEMENT_NAMES.contains("new"));
        Assert.assertFalse(ElementDefinitions.ALL_STANDARD_ELEMENTS.contains(new1));

    }



    
}
