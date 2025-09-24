package com.github.phoswald.sample.pdf.openpdf;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;

import org.openpdf.pdf.ITextRenderer;
import org.openpdf.text.pdf.PdfWriter;

class PdfGenerator {

    void generate(URI input, Path output) {
        try {
            Files.createDirectories(output.getParent());

            ITextRenderer renderer = ITextRenderer.fromUrl(input.toString());
            renderer.setPDFVersion(PdfWriter.VERSION_1_4);
            renderer.setPDFXConformance(PdfWriter.PDFA1A); // PDF/A-1a forces version 1.4
            renderer.layout();
            try(OutputStream stream = Files.newOutputStream(output)) {
                renderer.createPDF(stream);
            }

        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
