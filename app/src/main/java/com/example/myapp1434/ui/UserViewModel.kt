// File: app/src/main/java/com/example/myapp1434/ui/UserViewModel.kt
package com.example.myapp1434.ui

import androidx.lifecycle.*
import com.example.myapp1434.model.User
import com.example.myapp1434.network.RetrofitClient
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
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
                val fetchedUsers = RetrofitClient.apiService.getUsers()
                _users.postValue(fetchedUsers)
            } catch (e: Exception) {
                _error.postValue("Failed to fetch users")
            } finally {
                _loading.postValue(false)
            }
        }
    }
}
