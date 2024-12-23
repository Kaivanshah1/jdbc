package com.example.jdbc.repository

import com.example.jdbc.model.User
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository

@Repository
class UserRepository(private val jdbcTemplate: JdbcTemplate) {

    private val rowMapper = RowMapper<User> { rs, _ ->
        User(
            id = rs.getInt("id"),
            name = rs.getString("name"),
            email = rs.getString("email")
        )
    }

    fun getAllUsers(): List<User> =
        jdbcTemplate.query("SELECT * FROM users", rowMapper)

    fun getUserById(id: Int): User? =
        jdbcTemplate.queryForObject("SELECT * FROM users WHERE id = ?", rowMapper, id)

    fun createUser(user: User): Int =
        jdbcTemplate.update("INSERT INTO users (name, email) VALUES (?, ?)", user.name, user.email)

    fun updateUser(id: Int, user: User): Int =
        jdbcTemplate.update("UPDATE users SET name = ?, email = ? WHERE id = ?", user.name, user.email, id)

    fun deleteUser(id: Int): Int =
        jdbcTemplate.update("DELETE FROM users WHERE id = ?", id)
}