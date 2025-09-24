package com.github.phoswald.sample.pdf.playright;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Page.PdfOptions;

class PdfGenerator {

    void generate(URI input, Path output) {
        try {
            Files.createDirectories(output.getParent());

            try (Playwright playwright = Playwright.create()) {
                Browser browser = playwright.chromium().launch();
                Page page = browser.newPage();
                page.navigate(input.toString());
                page.waitForURL(input.toString());
                PdfOptions options = new PdfOptions()
                        .setPreferCSSPageSize(true)
                        .setPrintBackground(true);
                byte[] buffer = page.pdf(options);

                Files.write(output, buffer);
            }

        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
