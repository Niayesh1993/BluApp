package com.example.blubanksampleapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.blubanksampleapp.R
import com.example.blubanksampleapp.databinding.RowTransactionItemBinding
import com.example.blubanksampleapp.models.TransactionEntity

class TransactionAdapter: RecyclerView.Adapter<TransactionAdapter.ViewHolder>() {

    private lateinit var binding: RowTransactionItemBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = RowTransactionItemBinding.inflate(inflater, parent, false)
        return ViewHolder()
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    inner class ViewHolder: RecyclerView.ViewHolder(binding.root){

        fun bind(item: TransactionEntity){
            binding.apply {
                txtTitle.text = item.title
                txtDesc.text = item.date
                txtPrice.text = item.price.toString()
                when(item.type){
                    "1" -> imgTransaction.setImageResource(R.drawable.ic_tr_atm)
                    "2" -> imgTransaction.setImageResource(R.drawable.ic_tr_fee)
                    "3" -> imgTransaction.setImageResource(R.drawable.ic_tr_atm)
                    "4" -> imgTransaction.setImageResource(R.drawable.ic_tr_atm)
                    "5" -> imgTransaction.setImageResource(R.drawable.ic_tr_deposit_gift)
                    "6" -> imgTransaction.setImageResource(R.drawable.ic_tr_remittance_transfer)
                }

            }
        }
    }

    private val differCallback = object :
        DiffUtil.ItemCallback<TransactionEntity>(){
        override fun areItemsTheSame(oldItem: TransactionEntity, newItem: TransactionEntity): Boolean {
            return oldItem._id == newItem._id
        }

        override fun areContentsTheSame(oldItem: TransactionEntity, newItem: TransactionEntity): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this, differCallback)

}