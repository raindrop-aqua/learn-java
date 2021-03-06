#!/bin/bash
asciidoctor -r asciidoctor-diagram -o build/chapter0.html chapter0.adoc

asciidoctor -r asciidoctor-diagram -o build/chapter1-1.html chapter1-1.adoc
asciidoctor -r asciidoctor-diagram -o build/chapter1-2.html chapter1-2.adoc
asciidoctor -r asciidoctor-diagram -o build/chapter1-3.html chapter1-3.adoc
asciidoctor -r asciidoctor-diagram -o build/chapter1-4.html chapter1-4.adoc

asciidoctor -r asciidoctor-diagram -o build/chapter2-1.html chapter2-1.adoc
asciidoctor -r asciidoctor-diagram -o build/chapter2-2.html chapter2-2.adoc
asciidoctor -r asciidoctor-diagram -o build/chapter2-3.html chapter2-3.adoc
asciidoctor -r asciidoctor-diagram -o build/chapter2-4.html chapter2-4.adoc

asciidoctor -r asciidoctor-diagram -o build/chapter3-1.html chapter3-1.adoc
asciidoctor -r asciidoctor-diagram -o build/chapter3-2.html chapter3-2.adoc
asciidoctor -r asciidoctor-diagram -o build/chapter3-3.html chapter3-3.adoc
asciidoctor -r asciidoctor-diagram -o build/chapter3-4.html chapter3-4.adoc
asciidoctor -r asciidoctor-diagram -o build/chapter3-5.html chapter3-5.adoc
asciidoctor -r asciidoctor-diagram -o build/chapter3-6.html chapter3-6.adoc
asciidoctor -r asciidoctor-diagram -o build/chapter3-7.html chapter3-7.adoc
asciidoctor -r asciidoctor-diagram -o build/chapter3-8.html chapter3-8.adoc

asciidoctor -r asciidoctor-diagram -o build/chapter4-1.html chapter4-1.adoc
asciidoctor -r asciidoctor-diagram -o build/chapter4-2.html chapter4-2.adoc
asciidoctor -r asciidoctor-diagram -o build/chapter4-3.html chapter4-3.adoc
asciidoctor -r asciidoctor-diagram -o build/chapter4-4.html chapter4-4.adoc
asciidoctor -r asciidoctor-diagram -o build/chapter4-5.html chapter4-5.adoc
asciidoctor -r asciidoctor-diagram -o build/chapter4-6.html chapter4-6.adoc

asciidoctor -r asciidoctor-diagram -o build/chapter5-1.html chapter5-1.adoc
asciidoctor -r asciidoctor-diagram -o build/chapter5-2.html chapter5-2.adoc
asciidoctor -r asciidoctor-diagram -o build/chapter5-3.html chapter5-3.adoc
asciidoctor -r asciidoctor-diagram -o build/chapter5-4.html chapter5-4.adoc
asciidoctor -r asciidoctor-diagram -o build/chapter5-5.html chapter5-5.adoc
asciidoctor -r asciidoctor-diagram -o build/chapter5-6.html chapter5-6.adoc

asciidoctor -r asciidoctor-diagram -o build/chapter6-1.html chapter6-1.adoc
asciidoctor -r asciidoctor-diagram -o build/chapter6-2.html chapter6-2.adoc
asciidoctor -r asciidoctor-diagram -o build/chapter6-3.html chapter6-3.adoc
asciidoctor -r asciidoctor-diagram -o build/chapter6-4.html chapter6-4.adoc
asciidoctor -r asciidoctor-diagram -o build/chapter6-5.html chapter6-5.adoc
asciidoctor -r asciidoctor-diagram -o build/chapter6-6.html chapter6-6.adoc

asciidoctor -r asciidoctor-diagram -o build/chapter7-1.html chapter7-1.adoc
asciidoctor -r asciidoctor-diagram -o build/chapter7-2.html chapter7-2.adoc
asciidoctor -r asciidoctor-diagram -o build/chapter7-3.html chapter7-3.adoc
asciidoctor -r asciidoctor-diagram -o build/chapter7-4.html chapter7-4.adoc

asciidoctor -r asciidoctor-diagram -o build/chapter8-1.html chapter8-1.adoc
asciidoctor -r asciidoctor-diagram -o build/chapter8-2.html chapter8-2.adoc
asciidoctor -r asciidoctor-diagram -o build/chapter8-3.html chapter8-3.adoc
asciidoctor -r asciidoctor-diagram -o build/chapter8-4.html chapter8-4.adoc
asciidoctor -r asciidoctor-diagram -o build/chapter8-5.html chapter8-5.adoc
asciidoctor -r asciidoctor-diagram -o build/chapter8-6.html chapter8-6.adoc

asciidoctor -r asciidoctor-diagram -o build/chapterExtended1-1.html chapterExtended1-1.adoc
asciidoctor -r asciidoctor-diagram -o build/chapterExtended1-2.html chapterExtended1-2.adoc
asciidoctor -r asciidoctor-diagram -o build/chapterExtended1-3.html chapterExtended1-3.adoc
asciidoctor -r asciidoctor-diagram -o build/chapterExtended1-4.html chapterExtended1-4.adoc
asciidoctor -r asciidoctor-diagram -o build/chapterExtended1-5.html chapterExtended1-5.adoc

cp -R image/ build/image/
