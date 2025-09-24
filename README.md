
# sample-pdf

Experiments with PDF generation

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

- use images
- use tables
- use CSS styles
- ensure PDF/A-2 for use in the archiving and long-term preservation
  - based on a PDF 1.7 (ISO 32000-1)
  - check external dependencies

## OpenPDF

Rendering is pure Java

TODOs:

- specify page format A4
- disable zip deflate encoding
- how about OpenPDF v3.0.0?

## Playwright

Rendering is based on the default Chromium engine

TODOs:

- specify PDF version 1.7, it is currently 1.4
