
all: build

build:
	mkdir -p docs/generated
	weasyprint --pdf-variant pdf/a-1b http://localhost:8080/web/sample.html docs/generated/sample.pdf

clean:
	rm -rf docs/generated
