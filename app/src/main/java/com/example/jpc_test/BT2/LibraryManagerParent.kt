package com.example.jpc_test.BT2

open class LibraryManagerParent {
    open fun getAllBooks() : List<Book>{
        println("abc")
        return emptyList()
    }

    open fun getSelectedBooks() : List<Book> {
        println("cde")
        return emptyList()
    }
    open fun updateStudentName(name: String){
        println("name is $name")
    }
}