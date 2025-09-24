
# sample-pdf

Experiments with PDF generation

Links:

- https://print-css.rocks/
- https://wiki.selfhtml.org/wiki/Print-CSS
- https://developer.mozilla.org/en-US/docs/Web/CSS/@page
- https://developer.mozilla.org/en-US/docs/Web/CSS/@media

~~~
$ nginx-start $(pwd) 8080
$ mvn clean verify
$ file */target/generated/sample.pdf
~~~

See:

- http://localhost:8080/web/sample.html
- http://localhost:8080/openpdf/target/generated/sample.pdf
- http://localhost:8080/playwright/target/generated/sample.pdf

## OpenPDF

Links:

- https://github.com/LibrePDF/OpenPDF
- https://github.com/LibrePDF/OpenPDF/tree/master/openpdf-html

Rendering is pure Java. The desired PDF version and conformance level can be configured.

The **PDF/A-1a** conformance level is suitable for use in archiving and long-term preservation.
This generates PDF version 1.4 and verifies, among other things, whether fonts are embedded.
Font embedding requires the custom CSS style `-fs-pdf-font-embed: embed`.

Note that Flying Saucer **doesn't support Flex**, and will likely never support it.
The CSS supported is limited to CSS 2.1 and most of CSS paged media.

## Playwright

Links:

- https://playwright.dev/java/docs/intro
- https://playwright.dev/java/docs/api/class-page#page-pdf

Rendering is based on the default Chromium engine.
This generates PDF version 1.4 with embedded fonts.

~~~
$ sudo apt-get install libavif16
~~~

Cache: `~/.cache/ms-playwright`
