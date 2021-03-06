package com.zerdi.schoolchattingapp.presentation.forum.forumdetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.zerdi.schoolchattingapp.data.firebase.firestore.model.ForumDetailModel
import com.zerdi.schoolchattingapp.databinding.ItemAnswerBinding

class ForumAnswersAdapter : RecyclerView.Adapter<ForumAnswersAdapter.AnswersVH>() {
    class AnswersVH(val binding: ItemAnswerBinding) : RecyclerView.ViewHolder(binding.root) {
    }
    private val differCallBack = object : DiffUtil.ItemCallback<ForumDetailModel>() {
        override fun areItemsTheSame(
            oldItem: ForumDetailModel,
            newItem: ForumDetailModel
        ): Boolean {
            return true
        }

        override fun areContentsTheSame(
            oldItem: ForumDetailModel,
            newItem: ForumDetailModel
        ): Boolean {
            return true
        }
    }
    val differ = AsyncListDiffer(this, differCallBack)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AnswersVH {
        val binding = ItemAnswerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnswersVH(binding)
    }

    override fun onBindViewHolder(holder: AnswersVH, position: Int) {
        val list = differ.currentList[position]
        holder.binding.apply {
            tvForum.text = list.message
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}