package com.serhat.todayinhistory.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.serhat.todayinhistory.R
import com.serhat.todayinhistory.data.model.Article
import com.serhat.todayinhistory.databinding.CardArticleBinding

class ArticleAdapter(private val context: Context, private val articles: ArrayList<Article>): RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {
    class ArticleViewHolder(val binding: CardArticleBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding: CardArticleBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.card_article, parent, false)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = articles[position]
        holder.binding.article = article

        when (article.type) {
            context.getString(R.string.type_olay) -> holder.binding.cardArticle.setBackgroundColor(context.getColor(R.color.md_blue_300))
            context.getString(R.string.type_olum) -> holder.binding.cardArticle.setBackgroundColor(context.getColor(R.color.md_red_300))
            context.getString(R.string.type_dogum) -> holder.binding.cardArticle.setBackgroundColor(context.getColor(R.color.md_green_300))
        }
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(articles: ArrayList<Article>) {
        this.articles.clear()
        this.articles.addAll(articles)
        notifyDataSetChanged()
    }
}