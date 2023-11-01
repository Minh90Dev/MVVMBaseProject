package com.yadokari.tv.mvvmbase.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<VM: BaseViewModel, VB: ViewDataBinding>(private val layoutId: Int): Fragment() {

    companion object {
        private val TAG = BaseFragment::class.java.name
    }

    protected lateinit var binding: VB
    abstract val viewModel: VM

    abstract fun initView(inflater: LayoutInflater, container: ViewGroup?, binding: VB, savedInstanceState: Bundle?)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        binding.lifecycleOwner = this
        initView(inflater, container, binding, savedInstanceState)

        return binding.root
    }
}