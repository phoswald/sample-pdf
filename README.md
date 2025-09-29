
# sample-pdf

Experiments with PDF generation

Links:

- https://print-css.rocks/
- https://wiki.selfhtml.org/wiki/Print-CSS
- https://developer.mozilla.org/en-US/docs/Web/CSS/@page
- https://developer.mozilla.org/en-US/docs/Web/CSS/@media

~~~
$ nginx-start $(pwd) 8080
$ mvn -f openpdf    clean verify && \
  mvn -f playwright clean verify && \
  (cd weasyprint && make clean && make all)
$ file */docs/generated/*.pdf
~~~

See: http://localhost:8080/

## OpenPDF

Links:

- https://github.com/LibrePDF/OpenPDF
- https://github.com/LibrePDF/OpenPDF/tree/master/openpdf-html

See:

- [Sample](openpdf/docs/generated/sample.pdf)
- [Layouts](openpdf/docs/generated/layouts.pdf)
- [Markdown](openpdf/docs/generated/markdown.pdf)

Rendering is pure Java. The desired PDF version and conformance level can be configured.

The **PDF/A-1a** conformance level is suitable for use in archiving and long-term preservation.
This generates PDF version 1.4 and verifies, among other things, whether fonts are embedded.
Font embedding requires the custom CSS style `-fs-pdf-font-embed: embed`.

Note that Flying Saucer **doesn't support Flex**, and will likely never support it.
The CSS supported is limited to CSS 2.1 and most of CSS paged media.

Note that `rem` does not work, but `em` can be used instead.
Also, `.ico` are not displayed, but `.png` and `.jpeg` can be used instead.

## Playwright

Links:

- https://playwright.dev/java/docs/intro
- https://playwright.dev/java/docs/api/class-page#page-pdf

~~~
$ sudo apt-get install libavif16
~~~

See:

- [Sample](playwright/docs/generated/sample.pdf)
- [Layouts](playwright/docs/generated/layouts.pdf)
- [Markdown](playwright/docs/generated/markdown.pdf)

Rendering is based on the default Chromium engine.
This generates PDF version 1.4 with embedded fonts.

Cache: `~/.cache/ms-playwright`

## Weasyprint

Links:

- https://weasyprint.org/

~~~
$ sudo apt install weasyprint
$ weasyprint --version
$ weasyprint --help
$ weasyprint --info
~~~

See:

- [Sample](weasyprint/docs/generated/sample.pdf)
- [Layouts](weasyprint/docs/generated/layouts.pdf)
- [Markdown](weasyprint/docs/generated/markdown.pdf)

Rendering is implemented in Python and NOT based on a browser.
The desired PDF version and conformance level can be configured.
This generates PDF version 1.4 with embedded fonts.
