package com.serhat.todayinhistory.ui.view

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.serhat.todayinhistory.R
import com.serhat.todayinhistory.databinding.ActivityMainBinding
import com.serhat.todayinhistory.ui.adapter.ArticleAdapter
import com.serhat.todayinhistory.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val context: Context = this@MainActivity
    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel

    private var articleAdapter: ArticleAdapter = ArticleAdapter(context, arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.articleAdapter = this.articleAdapter
        binding.date = SimpleDateFormat(getString(R.string.date_format), Locale(Locale.getDefault().language)).format(Date())

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        initObservers()

        viewModel.loadData()
    }

    private fun initObservers() {
        viewModel.articles.observe(this) {
            it.let {
                articleAdapter.updateData(it)
            }
        }

        viewModel.messageId.observe(this) {
            it.let {
                Toast.makeText(context, getString(it), Toast.LENGTH_SHORT).show()
            }
        }
    }
}