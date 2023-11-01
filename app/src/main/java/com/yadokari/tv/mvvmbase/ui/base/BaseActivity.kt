package com.yadokari.tv.mvvmbase.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<VM: BaseViewModel, VB: ViewDataBinding>(private val layoutId: Int) : AppCompatActivity() {

    protected lateinit var binding: VB
    abstract val viewModel: VM

    abstract fun initView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this@BaseActivity

        initView()
    }
}