package com.example.blubanksampleapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.facebook.shimmer.ShimmerFrameLayout


class MainActivity : AppCompatActivity() {

    private lateinit var mShimmerViewContainer: ShimmerFrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mShimmerViewContainer = findViewById(R.id.shimmer_view_container)

    }

    override fun onResume() {
        super.onResume()
        mShimmerViewContainer.startShimmerAnimation()
    }
}