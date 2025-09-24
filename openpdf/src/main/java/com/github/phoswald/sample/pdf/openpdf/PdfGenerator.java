package com.github.phoswald.sample.pdf.openpdf;

import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;

import org.openpdf.pdf.ITextRenderer;

import com.lowagie.text.pdf.PdfWriter;

class PdfGenerator {

    void generate(URI input, Path output) {
        try {
            Files.createDirectories(output.getParent());

            ITextRenderer renderer = ITextRenderer.fromUrl(input.toString());
            renderer.setPDFVersion(PdfWriter.VERSION_1_7);
            renderer.layout();
            try(OutputStream stream = Files.newOutputStream(output)) {
                renderer.createPDF(stream);
            }

        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
