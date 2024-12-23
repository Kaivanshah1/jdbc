package com.example.jdbc.service

import com.example.jdbc.model.User
import com.example.jdbc.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun getAllUsers(): List<User> = userRepository.getAllUsers()

    fun getUserById(id: Int): User? = userRepository.getUserById(id)

    fun createUser(user: User): Int = userRepository.createUser(user)

    fun updateUser(id: Int, user: User): Int = userRepository.updateUser(id, user)

    fun deleteUser(id: Int): Int = userRepository.deleteUser(id)
}