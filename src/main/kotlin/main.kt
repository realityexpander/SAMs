// https://oguzhanaslann.medium.com/what-is-kotlin-sam-c6cfee64b00d


// SAM's - Single Abstract Method - is a function / interface that has one abstract method.

fun main() {

    // 1. Non-SAM way
    val fooImp1 = object : Foo {
        override fun baz(a: Int, b: Int) {
            println("baz $a $b")
        }
    }
    fooImp1.baz(1, 2)
    println("-----------------")



    // 2. SAM way
    val fooImp2 = FooSAM { a, b ->
        println("baz $a $b")
    }
    fooImp2.baz(1, 2)
    println("-----------------")



    // 3. SAM way (cleaner)
    bar { a, b, ->
        println("baz $a, $b")
    }

    bar { x, y ->
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
fun bar(fooSAM: FooSAM) {
    print("bar: ")

    fooSAM.baz(1, 2)
}