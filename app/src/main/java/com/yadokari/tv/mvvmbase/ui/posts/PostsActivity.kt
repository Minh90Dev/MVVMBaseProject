package com.yadokari.tv.mvvmbase.ui.posts

import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.LENGTH_SHORT
import androidx.activity.viewModels
import com.yadokari.tv.mvvmbase.R
import com.yadokari.tv.mvvmbase.databinding.ActivityPostsBinding
import com.yadokari.tv.mvvmbase.ui.base.BaseActivity
import com.yadokari.tv.mvvmbase.utils.isNetworkAvailable

class PostsActivity : BaseActivity<PostsViewModel, ActivityPostsBinding>(R.layout.activity_posts) {

    override val viewModel: PostsViewModel by viewModels()
    private var mAdapter : PostsAdapter? = PostsAdapter()

    override fun initView() {
        binding.postsRecyclerView.adapter = mAdapter

        if (isNetworkAvailable()) {
            viewModel.getPosts()
        } else {
            Toast.makeText(
                this,
                getString(R.string.no_internet_connection),
                LENGTH_SHORT
            ).show()
        }

        with(viewModel) {
            postsData.observe(this@PostsActivity) {
                binding.postsProgressBar.visibility = GONE
                mAdapter?.mPostList = it
            }

            messageData.observe(this@PostsActivity) {
                Toast.makeText(this@PostsActivity, it, LENGTH_LONG).show()
            }

            showProgressbar.observe(this@PostsActivity) { isVisible ->
                binding.postsProgressBar.visibility = if (isVisible) VISIBLE else GONE
            }
        }
    }

    override fun onDestroy() {
        mAdapter = null
        super.onDestroy()
    }

    companion object {
        private val TAG = PostsActivity::class.java.name
    }
}