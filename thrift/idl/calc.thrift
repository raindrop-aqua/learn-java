namespace java com.practice.calc.thrift

typedef i32 int

service Calc {
    int add(1: int op1, 2: int op2),
}


