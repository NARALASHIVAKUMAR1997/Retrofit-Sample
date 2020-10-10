package com.example.sampletest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.sample_layout.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var apiInterface: ApiInterface
    lateinit var recyclerViewAdap: RecyclerViewAdap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiInterface = RestClient.getInstance().create(ApiInterface::class.java)
        val call: Call<Example> = apiInterface.loadData()
        call.enqueue(object : Callback<Example> {
            override fun onResponse(call: Call<Example>, response: Response<Example>) {
                val example = response.body()
                username.text = example.username
                display_name.text = example.displayname
                posted_ago.text = example.postedAt
                text.text = example.text
                likes.text = example.likes.toString()
                postes.text = example.postLevel.toString()
                shares.text = example.shares.toString()

                recyclerViewAdap = RecyclerViewAdap(this@MainActivity, example.replies)
                replies.let {
                    it.layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,false)
                    it.adapter = recyclerViewAdap
                    it.isNestedScrollingEnabled = true
                }
            }

            override fun onFailure(call: Call<Example>, t: Throwable) {
                Log.v("errorTag", t.message.toString())
            }

        })
    }
}