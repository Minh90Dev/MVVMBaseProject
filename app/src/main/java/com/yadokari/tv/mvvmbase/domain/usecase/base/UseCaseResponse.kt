package com.yadokari.tv.mvvmbase.domain.usecase.base

import com.yadokari.tv.mvvmbase.domain.model.ApiError

interface UseCaseResponse<Type> {

    fun onSuccess(result: Type)

    fun onError(apiError: ApiError?)
}
