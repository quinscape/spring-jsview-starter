import bootstrap from "jsview-bootstrap"
import React from "react"

// noinspection ES6UnusedImports
import EXAMPLE_STYLE from "./style.css"

bootstrap(
    initial => (
        <React.Fragment>
            <h1>One</h1>
            <pre>
                {
                    JSON.stringify(initial, null, 4)
                }
            </pre>
            <a href="./two">To Two</a>
        </React.Fragment>
    ),
    () => console.info("ready!")
);
