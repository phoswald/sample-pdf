
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

TODOs:

- ensure PDF/A for use in the archiving and long-term preservation
  - based on a PDF 1.4 or 1.7 (ISO 32000-1)
  - check external dependencies

## OpenPDF

Links:

- https://github.com/LibrePDF/OpenPDF
- https://github.com/LibrePDF/OpenPDF/tree/master/openpdf-html

Rendering is pure Java. 

TODOs:

- disable zip deflate encoding
- enforcing conformance with PDFA1B does not work
- how about OpenPDF v3.0.0?

Limitations: 

> Note that Flying Saucer doesn't support Flex, and will likely never support it.
> The CSS supported is limited to CSS 2.1 and most of CSS paged media.

## Playwright

Links:

- https://playwright.dev/java/docs/intro
- https://playwright.dev/java/docs/api/class-page#page-pdf

Rendering is based on the default Chromium engine. 
It generates PDF 1.4. Fonts always seem to be embedded.
