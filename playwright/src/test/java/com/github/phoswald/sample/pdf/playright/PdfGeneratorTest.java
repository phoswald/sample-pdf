package com.github.phoswald.sample.pdf.playright;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PdfGeneratorTest {

    private final PdfGenerator testee = new PdfGenerator();

    @ParameterizedTest
    @MethodSource("inputFiles")
    void generate(String inputFile) throws URISyntaxException {
        var input = new URI("http://localhost:8080/web/" + inputFile);
        var output = Path.of("docs/generated/" + inputFile.replace(".html", ".pdf"));

        testee.generate(input, output);

        assertTrue(Files.isRegularFile(output));
    }

    static Stream<Arguments> inputFiles() throws IOException {
        return Files.find(Path.of("../web/"), 1, (p, a) -> true) //
                .map(path -> path.getFileName().toString()) //
                .filter(file -> file.endsWith(".html")) //
                .peek(file -> System.out.println(file.toString())) //
                .map(Arguments::of);
    }
}
