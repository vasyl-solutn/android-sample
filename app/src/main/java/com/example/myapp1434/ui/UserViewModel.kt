// File: app/src/main/java/com/example/myapp1434/ui/UserViewModel.kt
package com.example.myapp1434.ui

import android.app.Application
import androidx.lifecycle.*
import com.example.myapp1434.model.User
import com.example.myapp1434.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = UserRepository(application)

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _users

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    fun fetchUsers() {
        _loading.value = true
        viewModelScope.launch {
            try {
                val fetchedUsers = repository.fetchUsersFromApi().take(10)
                repository.deleteAllUsers()
                repository.insertUsers(fetchedUsers)
                _users.postValue(fetchedUsers)
            } catch (e: Exception) {
                _error.postValue("Failed to fetch users. Please try again.")
                _users.postValue(repository.getAllUsers())
            } finally {
                _loading.postValue(false)
            }
        }
    }

    fun retryFetchUsers() {
        fetchUsers()
    }
}
