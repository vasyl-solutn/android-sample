package com.example.myapp1434.ui

import androidx.lifecycle.*
import com.example.myapp1434.db.AppDatabase
import com.example.myapp1434.model.User
import kotlinx.coroutines.launch

class UserViewModel(private val database: AppDatabase) : ViewModel() {

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _users

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            _users.value = database.userDao().getAllUsers()
        }
    }

    fun insertUsers(users: List<User>) {
        viewModelScope.launch {
            database.userDao().insertUsers(users)
            fetchUsers() // Refresh the list after insertion
        }
    }

    fun deleteAllUsers() {
        viewModelScope.launch {
            database.userDao().deleteAllUsers()
            fetchUsers() // Refresh the list after deletion
        }
    }
}

class UserViewModelFactory(private val database: AppDatabase) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(database) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
