package com.yadokari.tv.mvvmbase.ui.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.yadokari.tv.mvvmbase.R
import com.yadokari.tv.mvvmbase.databinding.PostsFragmentBinding
import com.yadokari.tv.mvvmbase.ui.base.BaseFragment
import com.yadokari.tv.mvvmbase.utils.isNetworkAvailable

class PostsFragment : BaseFragment<PostsViewModel, PostsFragmentBinding>(R.layout.posts_fragment) {

    override val viewModel: PostsViewModel by viewModels()
    private var mAdapter : PostsAdapter? = PostsAdapter()

    override fun initView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        binding: PostsFragmentBinding,
        savedInstanceState: Bundle?
    ) {
        binding.postsRecyclerView.adapter = mAdapter

        if (requireContext().isNetworkAvailable()) {
            viewModel.getPosts()
        } else {
            Toast.makeText(
                requireContext(),
                requireContext().getString(R.string.no_internet_connection),
                Toast.LENGTH_SHORT
            ).show()
        }

        with(viewModel) {
            postsData.observe(this@PostsFragment) {
                binding.postsProgressBar.visibility = View.GONE
                mAdapter?.mPostList = it
            }

            messageData.observe(this@PostsFragment) {
                Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
            }

            showProgressbar.observe(this@PostsFragment) { isVisible ->
                binding.postsProgressBar.visibility = if (isVisible) View.VISIBLE else View.GONE
            }
        }
    }

    override fun onDestroyView() {
        mAdapter = null
        super.onDestroyView()
    }
}