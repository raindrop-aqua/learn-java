// Code generated by protoc-gen-go.
// source: addressbook.proto
// DO NOT EDIT!

/*
Package com_practice is a generated protocol buffer package.

It is generated from these files:
	addressbook.proto

It has these top-level messages:
	AddressBookRequest
	AddressBookResponse
	Person
	AddressBook
*/
package com_practice

import proto "github.com/golang/protobuf/proto"
import fmt "fmt"
import math "math"

import (
	context "golang.org/x/net/context"
	grpc "google.golang.org/grpc"
)

// Reference imports to suppress errors if they are not otherwise used.
var _ = proto.Marshal
var _ = fmt.Errorf
var _ = math.Inf

// This is a compile-time assertion to ensure that this generated file
// is compatible with the proto package it is being compiled against.
const _ = proto.ProtoPackageIsVersion1

type Person_PhoneType int32

const (
	Person_MOBILE Person_PhoneType = 0
	Person_HOME   Person_PhoneType = 1
	Person_WORK   Person_PhoneType = 2
)

var Person_PhoneType_name = map[int32]string{
	0: "MOBILE",
	1: "HOME",
	2: "WORK",
}
var Person_PhoneType_value = map[string]int32{
	"MOBILE": 0,
	"HOME":   1,
	"WORK":   2,
}

func (x Person_PhoneType) String() string {
	return proto.EnumName(Person_PhoneType_name, int32(x))
}
func (Person_PhoneType) EnumDescriptor() ([]byte, []int) { return fileDescriptor0, []int{2, 0} }

type AddressBookRequest struct {
	Id int32 `protobuf:"varint,1,opt,name=id" json:"id,omitempty"`
}

func (m *AddressBookRequest) Reset()                    { *m = AddressBookRequest{} }
func (m *AddressBookRequest) String() string            { return proto.CompactTextString(m) }
func (*AddressBookRequest) ProtoMessage()               {}
func (*AddressBookRequest) Descriptor() ([]byte, []int) { return fileDescriptor0, []int{0} }

type AddressBookResponse struct {
	Person *Person `protobuf:"bytes,1,opt,name=person" json:"person,omitempty"`
}

func (m *AddressBookResponse) Reset()                    { *m = AddressBookResponse{} }
func (m *AddressBookResponse) String() string            { return proto.CompactTextString(m) }
func (*AddressBookResponse) ProtoMessage()               {}
func (*AddressBookResponse) Descriptor() ([]byte, []int) { return fileDescriptor0, []int{1} }

func (m *AddressBookResponse) GetPerson() *Person {
	if m != nil {
		return m.Person
	}
	return nil
}

type Person struct {
	Name  string                `protobuf:"bytes,1,opt,name=name" json:"name,omitempty"`
	Id    int32                 `protobuf:"varint,2,opt,name=id" json:"id,omitempty"`
	Email string                `protobuf:"bytes,3,opt,name=email" json:"email,omitempty"`
	Phone []*Person_PhoneNumber `protobuf:"bytes,4,rep,name=phone" json:"phone,omitempty"`
}

func (m *Person) Reset()                    { *m = Person{} }
func (m *Person) String() string            { return proto.CompactTextString(m) }
func (*Person) ProtoMessage()               {}
func (*Person) Descriptor() ([]byte, []int) { return fileDescriptor0, []int{2} }

func (m *Person) GetPhone() []*Person_PhoneNumber {
	if m != nil {
		return m.Phone
	}
	return nil
}

type Person_PhoneNumber struct {
	Number string           `protobuf:"bytes,1,opt,name=number" json:"number,omitempty"`
	Type   Person_PhoneType `protobuf:"varint,2,opt,name=type,enum=com.practice.Person_PhoneType" json:"type,omitempty"`
}

func (m *Person_PhoneNumber) Reset()                    { *m = Person_PhoneNumber{} }
func (m *Person_PhoneNumber) String() string            { return proto.CompactTextString(m) }
func (*Person_PhoneNumber) ProtoMessage()               {}
func (*Person_PhoneNumber) Descriptor() ([]byte, []int) { return fileDescriptor0, []int{2, 0} }

type AddressBook struct {
	Person []*Person `protobuf:"bytes,1,rep,name=person" json:"person,omitempty"`
}

func (m *AddressBook) Reset()                    { *m = AddressBook{} }
func (m *AddressBook) String() string            { return proto.CompactTextString(m) }
func (*AddressBook) ProtoMessage()               {}
func (*AddressBook) Descriptor() ([]byte, []int) { return fileDescriptor0, []int{3} }

func (m *AddressBook) GetPerson() []*Person {
	if m != nil {
		return m.Person
	}
	return nil
}

func init() {
	proto.RegisterType((*AddressBookRequest)(nil), "com.practice.AddressBookRequest")
	proto.RegisterType((*AddressBookResponse)(nil), "com.practice.AddressBookResponse")
	proto.RegisterType((*Person)(nil), "com.practice.Person")
	proto.RegisterType((*Person_PhoneNumber)(nil), "com.practice.Person.PhoneNumber")
	proto.RegisterType((*AddressBook)(nil), "com.practice.AddressBook")
	proto.RegisterEnum("com.practice.Person_PhoneType", Person_PhoneType_name, Person_PhoneType_value)
}

// Reference imports to suppress errors if they are not otherwise used.
var _ context.Context
var _ grpc.ClientConn

// This is a compile-time assertion to ensure that this generated file
// is compatible with the grpc package it is being compiled against.
const _ = grpc.SupportPackageIsVersion1

// Client API for AddressBookService service

type AddressBookServiceClient interface {
	Query(ctx context.Context, in *AddressBookRequest, opts ...grpc.CallOption) (*AddressBookResponse, error)
}

type addressBookServiceClient struct {
	cc *grpc.ClientConn
}

func NewAddressBookServiceClient(cc *grpc.ClientConn) AddressBookServiceClient {
	return &addressBookServiceClient{cc}
}

func (c *addressBookServiceClient) Query(ctx context.Context, in *AddressBookRequest, opts ...grpc.CallOption) (*AddressBookResponse, error) {
	out := new(AddressBookResponse)
	err := grpc.Invoke(ctx, "/com.practice.AddressBookService/query", in, out, c.cc, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

// Server API for AddressBookService service

type AddressBookServiceServer interface {
	Query(context.Context, *AddressBookRequest) (*AddressBookResponse, error)
}

func RegisterAddressBookServiceServer(s *grpc.Server, srv AddressBookServiceServer) {
	s.RegisterService(&_AddressBookService_serviceDesc, srv)
}

func _AddressBookService_Query_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error) (interface{}, error) {
	in := new(AddressBookRequest)
	if err := dec(in); err != nil {
		return nil, err
	}
	out, err := srv.(AddressBookServiceServer).Query(ctx, in)
	if err != nil {
		return nil, err
	}
	return out, nil
}

var _AddressBookService_serviceDesc = grpc.ServiceDesc{
	ServiceName: "com.practice.AddressBookService",
	HandlerType: (*AddressBookServiceServer)(nil),
	Methods: []grpc.MethodDesc{
		{
			MethodName: "query",
			Handler:    _AddressBookService_Query_Handler,
		},
	},
	Streams: []grpc.StreamDesc{},
}

var fileDescriptor0 = []byte{
	// 330 bytes of a gzipped FileDescriptorProto
	0x1f, 0x8b, 0x08, 0x00, 0x00, 0x09, 0x6e, 0x88, 0x02, 0xff, 0x84, 0x92, 0x4f, 0x4b, 0xc3, 0x40,
	0x10, 0xc5, 0x9b, 0x34, 0x09, 0x76, 0x2a, 0x35, 0x8e, 0x45, 0x4a, 0x0f, 0x52, 0x83, 0xa0, 0xa0,
	0xe4, 0x10, 0xc1, 0x8b, 0x27, 0x23, 0x85, 0x8a, 0xb6, 0x0d, 0xab, 0x20, 0x1e, 0x93, 0x66, 0xc0,
	0xa2, 0xc9, 0xc6, 0x24, 0x15, 0x7a, 0xf5, 0x93, 0xbb, 0xd9, 0x44, 0x49, 0xfc, 0x7b, 0x7b, 0x3b,
	0xf9, 0x65, 0xdf, 0xf2, 0xde, 0xc0, 0xb6, 0x1f, 0x86, 0x29, 0x65, 0x59, 0xc0, 0xf9, 0x93, 0x9d,
	0xa4, 0x3c, 0xe7, 0xb8, 0xb9, 0xe0, 0x91, 0x90, 0xfe, 0x22, 0x5f, 0x2e, 0xc8, 0x3a, 0x00, 0xbc,
	0x28, 0x11, 0x57, 0x20, 0x8c, 0x5e, 0x56, 0x94, 0xe5, 0xd8, 0x03, 0x75, 0x19, 0x0e, 0x94, 0x91,
	0x72, 0xa4, 0x33, 0xa1, 0xac, 0x4b, 0xd8, 0x69, 0x50, 0x59, 0xc2, 0xe3, 0x8c, 0xf0, 0x04, 0x8c,
	0x84, 0xd2, 0x8c, 0xc7, 0x12, 0xed, 0x3a, 0x7d, 0xbb, 0x7e, 0xb7, 0xed, 0xc9, 0x6f, 0xac, 0x62,
	0xac, 0x37, 0x15, 0x8c, 0x72, 0x84, 0x08, 0x5a, 0xec, 0x47, 0x24, 0x7f, 0xeb, 0x30, 0xa9, 0x2b,
	0x4f, 0xf5, 0xc3, 0x13, 0xfb, 0xa0, 0x53, 0xe4, 0x2f, 0x9f, 0x07, 0x6d, 0x09, 0x95, 0x07, 0x3c,
	0x03, 0x3d, 0x79, 0xe4, 0x31, 0x0d, 0xb4, 0x51, 0x5b, 0x38, 0x8e, 0x7e, 0x72, 0xb4, 0xbd, 0x82,
	0x98, 0xad, 0xa2, 0x80, 0x52, 0x56, 0xe2, 0xc3, 0x07, 0xe8, 0xd6, 0xa6, 0xb8, 0x0b, 0x46, 0x2c,
	0x55, 0xf5, 0x84, 0xea, 0x84, 0x0e, 0x68, 0xf9, 0x3a, 0x21, 0xf9, 0x8c, 0x9e, 0xb3, 0xf7, 0xfb,
	0xed, 0x77, 0x82, 0x62, 0x92, 0xb5, 0x8e, 0xa1, 0xf3, 0x39, 0x42, 0x00, 0x63, 0x3a, 0x77, 0xaf,
	0x6e, 0xc6, 0x66, 0x0b, 0x37, 0x40, 0x9b, 0xcc, 0xa7, 0x63, 0x53, 0x29, 0xd4, 0xfd, 0x9c, 0x5d,
	0x9b, 0xaa, 0x75, 0x0e, 0xdd, 0x5a, 0x92, 0x8d, 0x04, 0xdb, 0xff, 0x25, 0xe8, 0x84, 0x8d, 0xb2,
	0x6e, 0x29, 0x7d, 0x15, 0x10, 0xce, 0x40, 0x17, 0xad, 0xa5, 0x6b, 0xfc, 0x12, 0xc6, 0xf7, 0x5e,
	0x87, 0xfb, 0x7f, 0x10, 0x65, 0xa7, 0x56, 0xcb, 0x3d, 0x84, 0xad, 0x06, 0x95, 0x04, 0xae, 0x59,
	0x23, 0xbd, 0x62, 0x8b, 0x26, 0x8a, 0xa7, 0x04, 0x86, 0x5c, 0xa8, 0xd3, 0xf7, 0x00, 0x00, 0x00,
	0xff, 0xff, 0x2b, 0x24, 0x25, 0xcc, 0x65, 0x02, 0x00, 0x00,
}
