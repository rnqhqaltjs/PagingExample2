package com.example.pagingexample2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.pagingexample2.new_data.NewItems
import com.example.pagingexample2.new_network.GithubApi
import com.example.pagingexample2.new_network.RetrofitInstanceNew
import kotlinx.coroutines.flow.Flow

class MainViewModel : ViewModel(){

    private val api = RetrofitInstanceNew.getInstance().create(GithubApi::class.java)

    val items : Flow<PagingData<NewItems>> = Pager(
        config = PagingConfig(pageSize = 30),
        pagingSourceFactory = {
            MyPagingSource(api)
        }
    )
        .flow
        .cachedIn(viewModelScope)

}