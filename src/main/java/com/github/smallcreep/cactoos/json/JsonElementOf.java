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

import com.github.smallcreep.cactoos.Json;
import com.github.smallcreep.cactoos.JsonElement;
import com.github.smallcreep.cactoos.JsonObject;
import com.github.smallcreep.cactoos.JsonValue;
import com.github.smallcreep.cactoos.io.TrimmedInputJsonStream;
import java.io.InputStream;
import org.cactoos.io.InputOf;
import org.cactoos.text.FormattedText;
import org.cactoos.text.ReplacedText;
import org.cactoos.text.TextOf;

/**
 * Baic implementation of Json Element.
 * @since 0.1.0
 */
public class JsonElementOf implements JsonElement {

    /**
     * Origin json.
     */
    private final Json json;

    /**
     * Element key.
     */
    private final String key;

    public JsonElementOf(final JsonObject object, final String key) throws Exception {
        this(
            new JsonOf(
                new InputOf(
                    new TrimmedInputJsonStream(
                        object.stream()
                    )
                )
            ),
            key
        );
    }

    /**
     * Ctor.
     * @param json Json
     * @param key Element key
     */
    public JsonElementOf(final Json json, final String key) {
        this.json = json;
        this.key = key;
    }

    @Override
    public InputStream stream() throws Exception {
        return this.json.stream();
    }

    @Override
    public JsonValue value() throws Exception {
        return new JsonValueOf(
            new JsonOf(
                new InputOf(
                    new ReplacedText(
                        new TextOf(
                            this.json
                        ),
                        new FormattedText(
                            "^\"%s\"\\s*:\\s*",
                            this.key
                        ).asString(),
                        ""
                    )
                )
            )
        );
    }
}

