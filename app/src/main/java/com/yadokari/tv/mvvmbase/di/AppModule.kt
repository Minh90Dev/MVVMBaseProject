package com.yadokari.tv.mvvmbase.di

val AppModule = module {

    viewModel { PostsViewModel(get()) }

    single { createGetPostsUseCase(get()) }

    single { createPostRepository(get()) }
}