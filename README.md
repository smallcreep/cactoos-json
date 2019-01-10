# cactoos-json

## How to use
```java
Json json = new JsonOf(
    new InputOf(
        new JoinedText(
            "\n",
            "{",
             "\"foo\": \"bar\",",
             "\"array\": [",
             "\"string\",",
             "1,",
             "1.2,",
             "{",
             "\"bar\": 1",
             "}",
             "],",
             "\"user\": {",
             "\"boolean\": true,",
             "\"null\": null",
             "}",
             "}"
            )
        )
    );

String foo = new JsonString(
    new JsonElementOf(
        json,
        "foo"
    )
).value(); // bar

Iterrable<JsonValue> jsonrray = new JsonArrayOf(
    new JsonElementOf(
        json,
        "array"
    )
);

String next = new JsonString(
    jsonarray.next()
).value();
```