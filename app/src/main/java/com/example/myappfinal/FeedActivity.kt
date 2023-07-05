package com.example.myappfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myappfinal.databinding.ActivityFeedBinding

class FeedActivity : AppCompatActivity() {

    private lateinit var iconHome : ImageView
    private lateinit var iconSearch : ImageView
    private lateinit var iconSettings : ImageView
    private lateinit var iconProfile : ImageView





    private lateinit var binding : ActivityFeedBinding

    private lateinit var homeRVAdapter : FeedRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        listeners()
        binding.apply {
            homeRVAdapter = FeedRecyclerViewAdapter(getData())
            feedRV.adapter = homeRVAdapter
            feedRV.layoutManager = LinearLayoutManager(this@FeedActivity)
        }

    }

    private fun listeners() {



        iconHome.setOnClickListener {
            startActivity(Intent(this, FeedActivity::class.java))
        }


        iconSearch.setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }

        iconSettings.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }


        iconProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }


    }





    private fun getData(): MutableList<Post> {
        var dataList = ArrayList<Post>()
        dataList.add(Post("author 1", "subject 1", "content 1 content 1 content 1 content 1 content 1"))
        dataList.add(Post("author 2", "subject 2", "content 1 content 1 content 1 content 1 content 1"))
        dataList.add(Post("author 3", "subject 3", "content 1 content 1 content 1 content 1 content 1"))
        dataList.add(Post("author 4", "subject 4", "content 1 content 1 content 1 content 1 content 1"))
        dataList.add(Post("author 5", "subject 5", "content 1 content 1 content 1 content 1 content 1"))
        dataList.add(Post("author 6", "subject 6", "content 1 content 1 content 1 content 1 content 1"))
        dataList.add(Post("author 7", "subject 7", "content 1 content 1 content 1 content 1 content 1"))
        dataList.add(Post("author 8", "subject 8", "content 1 content 1 content 1 content 1 content 1"))
        dataList.add(Post("author 9", "subject 9", "content 1 content 1 content 1 content 1 content 1"))
        dataList.add(Post("author 10", "subject 10", "content 1 content 1 content 1 content 1 content 1"))
        dataList.add(Post("author 11", "subject 11", "content 1 content 1 content 1 content 1 content 1"))
        dataList.add(Post("author 12", "subject 12", "content 1 content 1 content 1 content 1 content 1"))
        dataList.add(Post("author 13", "subject 13", "content 1 content 1 content 1 content 1 content 1"))
        dataList.add(Post("author 14", "subject 14", "content 1 content 1 content 1 content 1 content 1"))
        dataList.add(Post("author 15", "subject 15", "content 1 content 1 content 1 content 1 content 1"))
        return dataList
    }



    private fun init() {
        iconHome = findViewById(R.id.iconHome)
        iconSearch = findViewById(R.id.iconSearch)
        iconSettings = findViewById(R.id.iconSettings)
        iconProfile = findViewById(R.id.iconProfile)
    }


}



