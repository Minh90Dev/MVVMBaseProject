package com.yadokari.tv.mvvmbase.ui.posts

class PostsActivity : AppCompatActivity() {

    private lateinit var activityPostsBinding: ActivityPostsBinding
    private var mAdapter: PostsAdapter? = PostsAdapter()
    private val postViewModel: PostsViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityPostsBinding = DataBindingUtil.setContentView(this, R.layout.activity_posts)

        activityPostsBinding.postsRecyclerView.adapter = mAdapter

        if (isNetworkAvailable()) {
            postViewModel.getPosts()
        } else {
            Toast.makeText(
                this,
                getString(R.string.no_internet_connection),
                LENGTH_SHORT
            ).show()
        }

        with(postViewModel) {

            postsData.observe(this@PostsActivity, Observer {
                activityPostsBinding.postsProgressBar.visibility = GONE
                mAdapter?.mPostList = it
            })

            messageData.observe(this@PostsActivity, Observer {
                Toast.makeText(this@PostsActivity, it, LENGTH_LONG).show()
            })

            showProgressbar.observe(this@PostsActivity, Observer { isVisible ->
                posts_progress_bar.visibility = if (isVisible) VISIBLE else GONE
            })
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