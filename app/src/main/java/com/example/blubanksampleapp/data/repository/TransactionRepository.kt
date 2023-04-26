package com.example.blubanksampleapp.data.repository

import android.content.Context
import com.example.blubanksampleapp.models.JsonResult
import com.example.blubanksampleapp.models.TransactionEntity
import kotlinx.coroutines.flow.Flow

interface TransactionRepository {

    suspend fun getTransactionList(context: Context, fileName: String): JsonResult<List<TransactionEntity>>

}