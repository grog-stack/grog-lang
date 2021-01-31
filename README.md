# Grog Language

A programming language, just for fun. All these specifications might change in future versions.

## The basics

### Variables

You define variables with ```var```. You must specify a name and a value. The assignment operator is ```<-```.

    var message <- "Hello, world!" // This is a variable of type Text
    var counter <- 0 // This is a variable of type Number

You can change the value of a variable at any time.

The type of the variable is inferred from the assigned value, but you can specify the type after
the name of the variable:

    var message: Text <- "Hello, world!"
    var counter: Number <- 0
    var size: Number <- "some text" // This will result in a compilation error.

### Literal types

These are types of which you can create new values with a literal expression.

#### Number

There's one one numeric type. All numbers are expressed in base 10.

#### Text

Text is expressed between double quotes. Multi-line texts are supported. End-of-line characters are preserved.

    var a = "Hello, world!"
    var b = "Hello,
             world
             !" //

#### Boolean

Boolean literals are ```true``` and ```false```.

    var engage <- true

    ### Arithmetic expressions

The usual rules apply. These are the arithmetic operators, in order of precedence:

* ```^```: exponentiation
* ```*```, ```/```: multiplication and divition
* ```+```, ```/```: addition and subtraction

This expression

    1^2*3+4/5

Is equal to this on

    ((1^2)*3)+(4/5)

### Boolean expressions

* ```!```: not
* ```&```, ```|```: and, or

This expression:

    !a|!b

Is equivalent to this:

    (!a) | (!b)

### Arrays

Arrays are fixed length sequenques of values. You specify the values between square brackets.

    var odd_numbers <- [1,3,5]
    var even_numbers <- [2,4,6]

You can reference an element by its offset from the begin of the array.

    var first_odd <- odd_numbers[0] // This assignes the value 1
    var first_even <- even_numbers[2] // This assignes the value 6

### Sets

A set is a collection of distinct elements. You specify the values between curly brackets.

    var odd_numbers = {1,3,5}
    var even_numbers = {2,4,6}

### Maps

A map is an indexed collection of elements. Each element is referenced by a key. 

    var users = {
        "guybrush" <- "Guybrush Threepwood",
        "elaine" <- "Elaine Marley"
    }

### Functions

Function declarations are simple:

    func f(x: Number, y: Number) <- x+y

Parameter types are optional, and are inferred if possible. The previous function is equivalent
to this:

    func f(x, y) <- x+y

Functions are first-order elements in Grog. You can pass them pass parameters:

    func f(f1, x) <-f1(y)
    func g(x) <- x+x
    func h(x) <- x*x
    f(g, 3) // this yields 6
    f(h, 3) // this yields 9

### Lambdas

Lambdas are expressions that can be used as values

    func f(f1, x) <- f1(x)
    var addToSelf <- (x) <- x+x
    f(addToSelf, 3) // this yields 6
    f((x) <- x*x, 3) // this yields 9

### Comments

Single line comments begin with ```//```. 

Multi-line comments begin with ```/*``` and end with ```*/```.

## Writing a program

A program contains as many declarations as you need (functions, and variables) and then all
the statements you want to evalute. The results of each statement will be printed to console.

Here's an example:

    func f(x) <- x+1
    func g(x) <- f(x+1)
    var x <- f(1)
    x // Prints 2
    g(x+1) // Prints 5
