package demidova.alcodb.model.domain

import demidova.alcodb.model.UserModel

class UsersRepository {

    private val users = listOf(
        UserModel("User1"),
        UserModel("User2"),
        UserModel("User3"),
        UserModel("User4"),
        UserModel("User5"),
    )

    fun getUsers(): List<UserModel> {
        return users
    }
}