package com.yogeshpaliyal.composecookbook

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yogeshpaliyal.composecookbook.data.UserModel

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val _usersList = MutableLiveData<List<UserModel>>()
    val usersList : LiveData<List<UserModel>> = _usersList

    init {
        loadUserData()
    }

    private fun loadUserData(){
        val tempUsers = arrayListOf<UserModel>()
        for (i in 0 until 100){
            tempUsers.add(UserModel("Name $i",""))
        }
        _usersList.value = tempUsers
    }

}