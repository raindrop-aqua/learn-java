#!/usr/bin/env bash
protoc --java_out=../src/main/java addressbook.proto
#protoc --plugin=protoc-gen-grpc-java=/usr/local/bin/protoc-gen-grpc-java --grpc-java_out=../src/main/java addressbook.proto
protoc --go_out=plugins=grpc:./out addressbook.proto
