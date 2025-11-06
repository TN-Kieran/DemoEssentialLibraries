package com.example.jpc_test.BT2

class LibraryManager : LibraryManagerParent() , ILibraryManager {
    private val books = mutableListOf<Book>()
    private var studentName: String = ""

    init {
        // Thêm dữ liệu mẫu
        books.addAll(
            listOf(
                Book(1, "Sách 01", true),
                Book(2, "Sách 02", false)
            )
        )
    }

    override fun addBook(book: Book) {
        books.add(book)
    }

    override fun removeBook(book: Book) {
        books.remove(book)
    }

    override fun getAllBooks(): List<Book> {
        return books
    }

    override fun getSelectedBooks(): List<Book> {
        return books.filter { it.isSelected }
    }

    override fun updateStudentName(name: String) {
        studentName = name
    }

    fun getStudentName(): String = studentName
}