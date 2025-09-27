package com.github.phoswald.sample.pdf.openpdf;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

class PdfGeneratorTest {

    private final PdfGenerator testee = new PdfGenerator();

    @Test
    void generate() throws URISyntaxException {
        var input = new URI("http://localhost:8080/web/sample.html");
        var output = Path.of("docs/generated/sample.pdf");

        testee.generate(input, output);

        assertTrue(Files.isRegularFile(output));
    }
}
