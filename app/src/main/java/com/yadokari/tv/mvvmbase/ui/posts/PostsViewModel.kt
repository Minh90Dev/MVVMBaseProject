package com.yadokari.tv.mvvmbase.ui.posts

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.yadokari.tv.mvvmbase.domain.model.ApiError
import com.yadokari.tv.mvvmbase.domain.model.Post
import com.yadokari.tv.mvvmbase.domain.usecase.GetPostsUseCase
import com.yadokari.tv.mvvmbase.domain.usecase.base.UseCaseResponse
import com.yadokari.tv.mvvmbase.ui.base.BaseViewModel
import com.yadokari.tv.mvvmbase.utils.LogUtils
import kotlinx.coroutines.cancel

class PostsViewModel constructor(private val getPostsUseCase: GetPostsUseCase) : BaseViewModel() {

    companion object {
        private val TAG = PostsViewModel::class.java.name
    }

    val postsData = MutableLiveData<List<Post>>()
    val showProgressbar = MutableLiveData<Boolean>()
    val messageData = MutableLiveData<String>()

    fun getPosts() {
        showProgressbar.value = true
        getPostsUseCase.invoke(viewModelScope, null, object : UseCaseResponse<List<Post>> {
            override fun onSuccess(result: List<Post>) {
                LogUtils.i(TAG, "result: $result")
                postsData.value = result
                showProgressbar.value = false
            }

            override fun onError(apiError: ApiError?) {
                messageData.value = apiError?.getErrorMessage()
                showProgressbar.value = false
            }
        },
        )
    }

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }
}