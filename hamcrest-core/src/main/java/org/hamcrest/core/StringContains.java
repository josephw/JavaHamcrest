/*  Copyright (c) 2000-2006 hamcrest.org
 */
package org.hamcrest.core;

import org.hamcrest.Factory;
import org.hamcrest.Matcher;

/**
 * Tests if the argument is a string that contains a substring.
 */
public class StringContains extends SubstringMatcher {
    public StringContains(boolean ignoringCase, String substring) {
        super("containing", ignoringCase, substring);
    }

    @Override
    protected boolean evalSubstringOf(String s) {
        return converted(s).contains(converted(substring));
    }

    /**
     * Creates a matcher that matches if the examined {@link String} contains the specified
     * {@link String} anywhere.
     * <p/>
     * For example:
     * <pre>assertThat("myStringOfNote", containsString("ring"))</pre>
     * 
     * @param substring
     *     the substring that the returned matcher will expect to find within any examined string
     * 
     */
    @Factory
    public static Matcher<String> containsString(String substring) {
        return new StringContains(false, substring);
    }

    /**
     * Creates a matcher that matches if the examined {@link String} contains the specified
     * {@link String} anywhere, ignoring case.
     * <p/>
     * For example:
     * <pre>assertThat("myStringOfNote", containsString("ring"))</pre>
     *
     * @param substring
     *     the substring that the returned matcher will expect to find within any examined string
     *
     */
    @Factory
    public static Matcher<String> containsStringIgnoringCase(String substring) {
        return new StringContains(true, substring);
    }

}
