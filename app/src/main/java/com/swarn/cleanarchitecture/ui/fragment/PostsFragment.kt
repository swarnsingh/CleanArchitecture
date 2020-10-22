package com.swarn.cleanarchitecture.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.swarn.cleanarchitecture.R
import com.swarn.cleanarchitecture.adapter.PostsRecyclerAdapter
import com.swarn.cleanarchitecture.viewmodel.PostsViewModel
import com.swarn.cleanarchitecture.viewmodel.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * @author Swarn Singh.
 */
class PostsFragment : DaggerFragment() {

    private val TAG = PostsFragment::class.java.canonicalName

    private lateinit var postsViewModel: PostsViewModel

    private lateinit var recyclerView: RecyclerView

    @Inject
    lateinit var adapter: PostsRecyclerAdapter

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_posts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter

        postsViewModel =
            ViewModelProvider(this, providerFactory).get(PostsViewModel::class.java)

        subscribeObservers()
    }

    private fun subscribeObservers() {
        postsViewModel.observePosts().removeObservers(viewLifecycleOwner)

        postsViewModel.observePosts().observe(viewLifecycleOwner, Observer {
            if (it != null) {
                /*when (it.status) {
                    Resource.LOADING -> {
                        Log.d(TAG, "onChanged: Loading...")
                    }

                    Resource.Status.SUCCESS -> {
                        Log.d(TAG, "onChanged: Success...")
                        adapter.setPosts(it.data as ArrayList<Post>)
                    }

                    Resource.Status.ERROR -> {
                        Log.d(TAG, "onChanged: Error... ${it.message}")
                    }
                }*/
            }
        })
    }
}
