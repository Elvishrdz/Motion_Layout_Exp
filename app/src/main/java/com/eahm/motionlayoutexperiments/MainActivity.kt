package com.eahm.motionlayoutexperiments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.eahm.motionlayoutexperiments.adapters.MainAdapter
import com.eahm.motionlayoutexperiments.models.MainElements
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mainMenu = listOf(
        MainElements(
            "Basics",
            "Here you can swipe a box horizontally and it reacts to physics",
            Basics::class.java
        ),
        MainElements(
            "Touching a Star",
            "Here you can swipe a box horizontally and it reacts to physics",
            TouchingAStar::class.java
        ),
        MainElements(
            "DragEvent Animation",
            "The user must swipe outside of the specified view to run the animation and not in the animated view",
            DragEventAnimation::class.java
        ),
        MainElements(
            "Modifiying a Path",
            "Working with KeyPositionType, KeyAttributes and CustomAttributes.",
            ModifyingAPath::class.java
        ),
        MainElements(
            "Basics",
            "Controlling animations that have complex paths using OnSwipe requires understanding how OnSwipe works",
            DragEventAndComplexPaths::class.java
        ),
        MainElements(
            "Motion with Code",
            "This layout uses a CoordinatorLayout to share scrolling information between the NestedScrollView and the AppBarLayout",
            MotionWithCode::class.java
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       rvMain.apply {
           layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
           adapter = MainAdapter(mainMenu)
       }

    }

}