// File: app/src/main/java/com/example/myretro/ui/UserViewModel.kt
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

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    fun fetchUser(userId: Int) {
        _loading.value = true
        viewModelScope.launch {
            try {
                val fetchedUser = RetrofitClient.apiService.getUser(userId)
                _user.postValue(fetchedUser)
            } catch (e: Exception) {
                _error.postValue("Failed to fetch user")
            } finally {
                _loading.postValue(false)
            }
        }
    }
}
