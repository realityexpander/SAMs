// https://oguzhanaslann.medium.com/what-is-kotlin-sam-c6cfee64b00d


// SAM's - Single Abstract Method - is a function / interface that has one abstract method.

fun main() {

    // 1. Non-SAM way
    val fooImpl1 = object : Foo {
        override fun baz(a: Int, b: Int) {
            println("baz $a $b")
        }
    }
    fooImpl1.baz(1, 2)
    println("-----------------")



    // 2. SAM way
    val fooImpl2 = FooSAM { a, b ->
        println("baz $a $b")
    }
    fooImpl2.baz(1, 2)
    println("-----------------")



    // 3. SAM way (passing in the interface)
    fooImpl3(1,2) { a, b, ->
        println("baz $a, $b")
    }

    fooImpl3(1,2) { x, y ->
        println("SomeOther BazImpl $x, $y")
    }




}

// 1. Non-SAM way
interface Foo {
    fun baz(a:Int, b:Int) {
        println("baz default, $a, $b")
    }
}

// 2. SAM way
fun interface FooSAM {
    fun baz(a: Int, b: Int)  // SAM, just signature, no implementation, AUTOMATICALLY ABSTRACT
//    {  // no default implementation allowed!
//        print("baz default")
//    }

    //fun baz2() // fun interfaces (SAM) can only have one abstract method!
}

// 3. SAM way (cleaner)
fun fooImpl3(a:Int, b: Int, fooSAM: FooSAM) {
    print("bar: ")

    fooSAM.baz(a, b)
}