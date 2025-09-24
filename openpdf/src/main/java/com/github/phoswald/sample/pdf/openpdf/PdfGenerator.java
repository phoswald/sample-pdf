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
            renderer.setPDFVersion(PdfWriter.VERSION_1_4);
            // String font1 = input.toString().replace("sample.html", "fonts/source-sans-3-regular.ttf");
            // String font2 = input.toString().replace("sample.html", "fonts/source-sans-3-bold.ttf");
            // renderer.getFontResolver().addFont(font1, "Source Sans Pro", "UTF-8", true, null);
            // renderer.getFontResolver().addFont(font2, "Source Sans Pro", "UTF-8", true, null);
            // renderer.getFontResolver().addFont(font1, "SourceSans3-Regular", "UTF-8", true, null);
            // renderer.getFontResolver().addFont(font2, "SourceSans3-Bold", "UTF-8", true, null);
            // renderer.getFontResolver().getFonts().keySet().forEach(System.out::println);
            // renderer.setPDFXConformance(PdfWriter.PDFA1B); // TODO: fails with "All the fonts must be embedded."
            renderer.layout();
            try(OutputStream stream = Files.newOutputStream(output)) {
                renderer.createPDF(stream);
            }

        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
