#!/bin/bash

asciidoctor-pdf -r asciidoctor-pdf-cjk -r asciidoctor-diagram -b pdf -o build/chapter0.pdf chapter0.adoc

asciidoctor-pdf -r asciidoctor-pdf-cjk -r asciidoctor-diagram -b pdf -o build/chapter1-1.pdf chapter1-1.adoc
asciidoctor-pdf -r asciidoctor-pdf-cjk -r asciidoctor-diagram -b pdf -o build/chapter1-2.pdf chapter1-2.adoc
asciidoctor-pdf -r asciidoctor-pdf-cjk -r asciidoctor-diagram -b pdf -o build/chapter1-3.pdf chapter1-3.adoc
asciidoctor-pdf -r asciidoctor-pdf-cjk -r asciidoctor-diagram -b pdf -o build/chapter1-4.pdf chapter1-4.adoc
