#!/bin/bash
asciidoctor -r asciidoctor-diagram -o build/chapter0.html chapter0.adoc

asciidoctor -r asciidoctor-diagram -o build/chapter1-1.html chapter1-1.adoc
asciidoctor -r asciidoctor-diagram -o build/chapter1-2.html chapter1-2.adoc
asciidoctor -r asciidoctor-diagram -o build/chapter1-3.html chapter1-3.adoc
asciidoctor -r asciidoctor-diagram -o build/chapter1-4.html chapter1-4.adoc

