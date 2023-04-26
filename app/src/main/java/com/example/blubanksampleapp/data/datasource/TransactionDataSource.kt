package com.example.blubanksampleapp.data.datasource

import android.content.Context
import android.view.SurfaceControl
import com.example.blubanksampleapp.models.JsonResult
import com.example.blubanksampleapp.models.TransactionEntity

interface TransactionDataSource {

    suspend fun getTransactionList(context: Context, fileName: String): JsonResult<List<TransactionEntity>>
}