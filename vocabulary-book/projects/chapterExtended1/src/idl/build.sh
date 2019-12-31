rm -rf gen-java
rm -rf gen-netstd

thrift -r --gen java --gen netstd book.thrift
