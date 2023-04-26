package com.example.blubanksampleapp.ui

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blubanksampleapp.data.repository.TransactionRepository
import com.example.blubanksampleapp.models.TransactionEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel@Inject constructor(private val transactionRepository: TransactionRepository):ViewModel() {

    private val _transactions = MutableLiveData<List<TransactionEntity>>()
    val transactions: LiveData<List<TransactionEntity>> get() = _transactions


     fun getTransactionsList(context: Context)
    {
        viewModelScope.launch {
            delay(5000)
            val result = transactionRepository.getTransactionList(context, fileName)
            _transactions.value = result.value

        }
    }

    companion object {
        const val fileName = "transactions.json"
    }
}