package module8.lesson3

class CppDeveloper : Developer {
    constructor(name: String, age: Int) : super(name, age)
    constructor(name: String, age: Int, experience: Int) : super(name, age, experience)

    override fun writeCode(){
        println("cpp developer writing cpp code")
    }
}