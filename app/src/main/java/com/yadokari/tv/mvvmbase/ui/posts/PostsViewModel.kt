package com.yadokari.tv.mvvmbase.ui.posts

class PostsViewModel constructor(private val getPostsUseCase: GetPostsUseCase) : ViewModel() {

    val postsData = MutableLiveData<List<Post>>()
    val showProgressbar = MutableLiveData<Boolean>()
    val messageData = MutableLiveData<String>()

    fun getPosts() {
        showProgressbar.value = true
        getPostsUseCase.invoke(viewModelScope, null, object : UseCaseResponse<List<Post>> {
            override fun onSuccess(result: List<Post>) {
                Log.i(TAG, "result: $result")
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

    companion object {
        private val TAG = PostsViewModel::class.java.name
    }

}