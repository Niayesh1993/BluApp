package com.example.blubanksampleapp.di

import com.example.blubanksampleapp.data.datasource.TransactionDataSource
import com.example.blubanksampleapp.data.datasource.TransactionDataSourceImpl
import com.example.blubanksampleapp.data.repository.TransactionRepository
import com.example.blubanksampleapp.data.repository.TransactionRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataModule {

    @Singleton
    @Provides
    fun provideDataSource(): TransactionDataSource =
        TransactionDataSourceImpl()

    @Singleton
    @Provides
    fun provideRepository(transactionDataSource: TransactionDataSource): TransactionRepository =
        TransactionRepositoryImpl(transactionDataSource)

}