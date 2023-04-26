package com.example.blubanksampleapp.data.repository

import android.content.Context
import com.example.blubanksampleapp.data.datasource.TransactionDataSource
import com.example.blubanksampleapp.models.JsonResult
import com.example.blubanksampleapp.models.TransactionEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TransactionRepositoryImpl@Inject constructor(private val transactionDataSource: TransactionDataSource):
    TransactionRepository {

    override suspend fun getTransactionList(
        context: Context,
        fileName: String,
    ): JsonResult<List<TransactionEntity>>
    {
        return transactionDataSource.getTransactionList(context, fileName)
    }
}