package com.example.myapp1434.ui

import androidx.lifecycle.*
import com.example.myapp1434.model.User
import com.example.myapp1434.network.RetrofitClient
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    private val _user = MutableLiveData<User>()
    val user: LiveData<User> get() = _user

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    fun fetchUser(userId: Int) {
        viewModelScope.launch {
            try {
                val fetchedUser = RetrofitClient.apiService.getUser(userId)
                _user.postValue(fetchedUser)
            } catch (e: Exception) {
                _error.postValue("Failed to fetch user")
            }
        }
    }
}