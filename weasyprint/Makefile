
all: build

HTML := $(wildcard ../web/*.html)
PDF  := $(patsubst ../web/%.html,docs/generated/%.pdf, $(HTML))

build: build_prepare $(PDF)

build_prepare:
	mkdir -p docs/generated

# input can be URL or file name
# weasyprint --pdf-variant pdf/a-1b http://localhost:8080/web/sample.html docs/generated/sample.pdf
# weasyprint --pdf-variant pdf/a-1b                    ../web/sample.html docs/generated/sample.pdf

docs/generated/%.pdf: ../web/%.html
	weasyprint --pdf-variant pdf/a-1b $< $@

clean:
	rm -rf docs/generated
