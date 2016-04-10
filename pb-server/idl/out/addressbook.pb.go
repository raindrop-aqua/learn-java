// Code generated by protoc-gen-go.
// source: addressbook.proto
// DO NOT EDIT!

/*
Package addressbook is a generated protocol buffer package.

It is generated from these files:
	addressbook.proto

It has these top-level messages:
	AddressBookRequest
	AddressBookResponse
	Person
	AddressBook
*/
package addressbook

import proto "github.com/golang/protobuf/proto"
import fmt "fmt"
import math "math"

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

func (x Person_PhoneType) Enum() *Person_PhoneType {
	p := new(Person_PhoneType)
	*p = x
	return p
}
func (x Person_PhoneType) String() string {
	return proto.EnumName(Person_PhoneType_name, int32(x))
}
func (x *Person_PhoneType) UnmarshalJSON(data []byte) error {
	value, err := proto.UnmarshalJSONEnum(Person_PhoneType_value, data, "Person_PhoneType")
	if err != nil {
		return err
	}
	*x = Person_PhoneType(value)
	return nil
}
func (Person_PhoneType) EnumDescriptor() ([]byte, []int) { return fileDescriptor0, []int{2, 0} }

type AddressBookRequest struct {
	Id               *int32 `protobuf:"varint,1,req,name=id" json:"id,omitempty"`
	XXX_unrecognized []byte `json:"-"`
}

func (m *AddressBookRequest) Reset()                    { *m = AddressBookRequest{} }
func (m *AddressBookRequest) String() string            { return proto.CompactTextString(m) }
func (*AddressBookRequest) ProtoMessage()               {}
func (*AddressBookRequest) Descriptor() ([]byte, []int) { return fileDescriptor0, []int{0} }

func (m *AddressBookRequest) GetId() int32 {
	if m != nil && m.Id != nil {
		return *m.Id
	}
	return 0
}

type AddressBookResponse struct {
	Person           *Person `protobuf:"bytes,1,req,name=person" json:"person,omitempty"`
	XXX_unrecognized []byte  `json:"-"`
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
	Name             *string               `protobuf:"bytes,1,req,name=name" json:"name,omitempty"`
	Id               *int32                `protobuf:"varint,2,req,name=id" json:"id,omitempty"`
	Email            *string               `protobuf:"bytes,3,opt,name=email" json:"email,omitempty"`
	Phone            []*Person_PhoneNumber `protobuf:"bytes,4,rep,name=phone" json:"phone,omitempty"`
	XXX_unrecognized []byte                `json:"-"`
}

func (m *Person) Reset()                    { *m = Person{} }
func (m *Person) String() string            { return proto.CompactTextString(m) }
func (*Person) ProtoMessage()               {}
func (*Person) Descriptor() ([]byte, []int) { return fileDescriptor0, []int{2} }

func (m *Person) GetName() string {
	if m != nil && m.Name != nil {
		return *m.Name
	}
	return ""
}

func (m *Person) GetId() int32 {
	if m != nil && m.Id != nil {
		return *m.Id
	}
	return 0
}

func (m *Person) GetEmail() string {
	if m != nil && m.Email != nil {
		return *m.Email
	}
	return ""
}

func (m *Person) GetPhone() []*Person_PhoneNumber {
	if m != nil {
		return m.Phone
	}
	return nil
}

type Person_PhoneNumber struct {
	Number           *string           `protobuf:"bytes,1,req,name=number" json:"number,omitempty"`
	Type             *Person_PhoneType `protobuf:"varint,2,opt,name=type,enum=Person_PhoneType,def=1" json:"type,omitempty"`
	XXX_unrecognized []byte            `json:"-"`
}

func (m *Person_PhoneNumber) Reset()                    { *m = Person_PhoneNumber{} }
func (m *Person_PhoneNumber) String() string            { return proto.CompactTextString(m) }
func (*Person_PhoneNumber) ProtoMessage()               {}
func (*Person_PhoneNumber) Descriptor() ([]byte, []int) { return fileDescriptor0, []int{2, 0} }

const Default_Person_PhoneNumber_Type Person_PhoneType = Person_HOME

func (m *Person_PhoneNumber) GetNumber() string {
	if m != nil && m.Number != nil {
		return *m.Number
	}
	return ""
}

func (m *Person_PhoneNumber) GetType() Person_PhoneType {
	if m != nil && m.Type != nil {
		return *m.Type
	}
	return Default_Person_PhoneNumber_Type
}

type AddressBook struct {
	Person           []*Person `protobuf:"bytes,1,rep,name=person" json:"person,omitempty"`
	XXX_unrecognized []byte    `json:"-"`
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
	proto.RegisterType((*AddressBookRequest)(nil), "AddressBookRequest")
	proto.RegisterType((*AddressBookResponse)(nil), "AddressBookResponse")
	proto.RegisterType((*Person)(nil), "Person")
	proto.RegisterType((*Person_PhoneNumber)(nil), "Person.PhoneNumber")
	proto.RegisterType((*AddressBook)(nil), "AddressBook")
	proto.RegisterEnum("Person_PhoneType", Person_PhoneType_name, Person_PhoneType_value)
}

var fileDescriptor0 = []byte{
	// 300 bytes of a gzipped FileDescriptorProto
	0x1f, 0x8b, 0x08, 0x00, 0x00, 0x09, 0x6e, 0x88, 0x02, 0xff, 0x6c, 0x91, 0x4f, 0x4b, 0xc3, 0x40,
	0x10, 0xc5, 0x9b, 0x34, 0x89, 0x76, 0xaa, 0x35, 0xdd, 0x0a, 0x96, 0x9e, 0xc2, 0x8a, 0x52, 0x10,
	0xf6, 0x50, 0x3c, 0x79, 0x33, 0x58, 0xf0, 0x5f, 0x4d, 0xa8, 0x82, 0xe7, 0xfc, 0x19, 0x30, 0x68,
	0xb2, 0xeb, 0x6e, 0x2a, 0xf4, 0x1b, 0xfa, 0xb1, 0xdc, 0xa4, 0x41, 0x12, 0xf4, 0x36, 0xfb, 0xe6,
	0xf1, 0x63, 0xdf, 0x1b, 0x18, 0x47, 0x69, 0x2a, 0x51, 0xa9, 0x98, 0xf3, 0x77, 0x26, 0x24, 0x2f,
	0x39, 0xf5, 0x80, 0x5c, 0xef, 0x44, 0x5f, 0x8b, 0x6b, 0xfc, 0xdc, 0xa0, 0x2a, 0x09, 0x80, 0x99,
	0xa5, 0x53, 0xc3, 0x33, 0xe7, 0x36, 0x65, 0x30, 0xe9, 0x38, 0x94, 0xe0, 0x85, 0x42, 0x72, 0x02,
	0x8e, 0x40, 0xa9, 0x78, 0x51, 0xdb, 0x86, 0x8b, 0x3d, 0x16, 0xd6, 0x4f, 0xfa, 0x6d, 0x80, 0xb3,
	0x1b, 0xc9, 0x01, 0x58, 0x45, 0x94, 0x63, 0xed, 0x18, 0x34, 0x50, 0xb3, 0x82, 0x92, 0x43, 0xb0,
	0x31, 0x8f, 0xb2, 0x8f, 0x69, 0xdf, 0x33, 0xf4, 0x8a, 0x82, 0x2d, 0xde, 0x78, 0x81, 0x53, 0xcb,
	0xeb, 0x6b, 0xd6, 0xa4, 0x61, 0xb1, 0xb0, 0x12, 0x9f, 0x36, 0x79, 0x8c, 0x72, 0x76, 0x03, 0xc3,
	0xd6, 0x93, 0x8c, 0xc0, 0x29, 0xea, 0xa9, 0xa1, 0x9f, 0x81, 0x55, 0x6e, 0x05, 0x6a, 0xbe, 0x31,
	0x1f, 0x2d, 0xc6, 0x1d, 0xc2, 0x8b, 0x5e, 0x5c, 0x59, 0xb7, 0xc1, 0x6a, 0x49, 0x2f, 0x60, 0xf0,
	0x2b, 0xe9, 0x1f, 0x39, 0xab, 0xc0, 0xbf, 0x7b, 0x5c, 0xba, 0x3d, 0xb2, 0x0f, 0xb5, 0xc1, 0x35,
	0xaa, 0xe9, 0x35, 0x58, 0x3f, 0xb8, 0x26, 0x3d, 0x87, 0x61, 0x2b, 0x7a, 0x27, 0x72, 0xbf, 0x15,
	0x79, 0x71, 0xdf, 0x29, 0xf1, 0x19, 0xe5, 0x57, 0x96, 0x20, 0xb9, 0x04, 0x5b, 0xb7, 0x29, 0xb7,
	0x64, 0xc2, 0xfe, 0x56, 0x3c, 0x3b, 0x66, 0xff, 0xb4, 0x4a, 0x7b, 0xfe, 0x29, 0x1c, 0x25, 0x3c,
	0xd7, 0xd7, 0x89, 0x92, 0x52, 0x53, 0x98, 0x88, 0x7d, 0xb7, 0xe5, 0x0c, 0xab, 0xab, 0xfd, 0x04,
	0x00, 0x00, 0xff, 0xff, 0x2a, 0xb0, 0x2b, 0xbc, 0xc9, 0x01, 0x00, 0x00,
}