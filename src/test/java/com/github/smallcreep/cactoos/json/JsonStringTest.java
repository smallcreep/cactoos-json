/*
 * MIT License
 *
 * Copyright (c) 2018 Ilia Rogozhin (@smallcreep) <ilia.rogozhin@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.smallcreep.cactoos.json;

import org.cactoos.io.InputOf;
import org.cactoos.text.TextOf;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.llorllale.cactoos.matchers.ScalarHasValue;

/**
 * Test Case {@link JsonString}.
 * @since 0.1.0
 */
public class JsonStringTest {

    /**
     * JsonString can return string value of json without double quotes.
     */
    @Test
    public void returnJsonStringValueAsJavaString() {
        MatcherAssert.assertThat(
            new JsonString(
                new JsonValueOf(
                    new JsonOf(
                        new InputOf(
                            new TextOf(
                                "\"test\""
                            )
                        )
                    )
                )
            ),
            new ScalarHasValue<String>(
                Matchers.equalTo("test")
            )
        );
    }
}