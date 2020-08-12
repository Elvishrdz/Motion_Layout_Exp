package com.eahm.motionlayoutexperiments.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eahm.motionlayoutexperiments.R

class DragEventAnimation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drag_event_animation)

        /* Motion Editor currently does NOT support creating "chains" via the UI (only xml)
           An alternate solution would be:
            Left start connect to start+top of parent, margin 32dp
            Right star connected to end + top of parent, margin 32dp
            Red star connected center in parent, top of parent, margin 32dp */

        /* OnSwipe listens for swipes on the MotionLayout and not the view specified in
            touchAnchorId. This means the user may swipe outside of the specified view to run
            the animation. */

    }
}