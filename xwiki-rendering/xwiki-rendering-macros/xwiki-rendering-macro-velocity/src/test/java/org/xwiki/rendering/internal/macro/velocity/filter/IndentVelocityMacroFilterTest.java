/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.rendering.internal.macro.velocity.filter;

import junit.framework.TestCase;

import org.apache.velocity.VelocityContext;

/**
 * Validate the behavior of {@link HTMLVelocityMacroFilter}.
 * 
 * @version $Id$
 */
public class IndentVelocityMacroFilterTest extends TestCase
{
    private IndentVelocityMacroFilter filter;

    private VelocityContext context;

    /**
     * {@inheritDoc}
     * 
     * @see junit.framework.TestCase#setUp()
     */
    @Override
    protected void setUp() throws Exception
    {
        super.setUp();

        this.filter = new IndentVelocityMacroFilter();

        this.context = new VelocityContext();
    }

    public void assertFilter(String expected, String input)
    {
        assertEquals(expected, this.filter.before(input, this.context));
    }

    public void testFilter()
    {
        assertFilter("", " ");
        assertFilter("\n", "  \n  ");
        assertFilter("", " \t");
    }
}
