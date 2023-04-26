package com.example.blubanksampleapp.data.datasource

import android.content.Context
import com.example.blubanksampleapp.models.JsonResult
import com.google.gson.Gson
import com.example.blubanksampleapp.models.TransactionEntity
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject

class TransactionDataSourceImpl@Inject constructor(): TransactionDataSource {

    override suspend fun getTransactionList(context: Context, fileName: String): JsonResult<List<TransactionEntity>> = withContext(
        Dispatchers.IO){
        val jsonFileStringDeferred = async { getJsonDataFromAsset(context, fileName) }
        val jsonFileString = jsonFileStringDeferred.await()

        val gson = Gson()
        val listCityType = object : TypeToken<List<TransactionEntity>>() {}.type

        val products: List<TransactionEntity> = gson.fromJson(jsonFileString, listCityType)
        products.forEachIndexed { idx, trs -> println("> Item ${idx}:\n${trs}") }

        return@withContext JsonResult(products)
    }

    //read json file from assets folder
    private fun getJsonDataFromAsset(context: Context, fileName: String): String? {

        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

}