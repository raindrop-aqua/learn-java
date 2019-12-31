rm -rf gen-java
rm -rf gen-netstd
rm -rf gen-csharp

thrift -r --gen java --gen netstd --gen csharp book.thrift
