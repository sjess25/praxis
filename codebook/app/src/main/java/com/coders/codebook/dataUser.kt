package com.coders.codebook

object dataUser {

    private var nickName: String = ""
    private var password: String = ""
    private var fullName: String? = null
    private var id: Int = -1
    private var teacher: Boolean = false

    fun create(nickname: String, password: String) {
        this.nickName = nickname
        this.password = password
    }

    fun getNickName (): String {
        return nickName
    }

    fun getPassword (): String {
        return password
    }

    fun getTeacher (): Boolean {
        return teacher
    }

    fun getID (): Int {
        return id
    }

    fun setTeacher (teacher: Boolean) {
        this.teacher = teacher
    }

    fun setID (id: Int) {
        this.id = id
    }

    fun setName(name: String){
        this.fullName = name
    }

    override fun toString(): String {
        return "ID:$id,NickName:$nickName,teacher:$teacher"
    }

    fun getDrawable(tech: Int): Int {

        when (tech) {
            2 -> return R.drawable.c
            6 -> return R.drawable.java
            1 -> return R.drawable.ruby
            5 -> return R.drawable.prolog
            7 -> return R.drawable.praxis_logo
        }
        return -1
    }

    fun getIDTechnology(name: String): Int {

        when (name) {
            "C" -> return 2
            "Java" -> return 6
            "Ruby" -> return 1
            "Prolog" -> return 5
            "Praxis" -> return 7
        }
        return -1
    }
}