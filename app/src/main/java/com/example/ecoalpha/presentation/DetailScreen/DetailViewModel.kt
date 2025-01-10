package com.example.ecoalpha.presentation.DetailScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecoalpha.data.AppDB
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val appDB: AppDB
): ViewModel() {
    val cards = appDB.dao.getBankInfo()

}