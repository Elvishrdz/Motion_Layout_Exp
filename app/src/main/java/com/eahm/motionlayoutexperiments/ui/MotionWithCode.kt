package com.eahm.motionlayoutexperiments.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.motion.widget.MotionLayout
import com.eahm.motionlayoutexperiments.R
import com.google.android.material.appbar.AppBarLayout

class MotionWithCode : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motion_with_code)

       /* This layout uses a CoordinatorLayout to share scrolling information between the
          NestedScrollView and the AppBarLayout. So, when the NestedScrollView scrolls up,
          it will tell the AppBarLayout about the change. That's how you implement a collapsing
          toolbar like this on Android—the scrolling of the text will be "coordinated" with
          the collapsing header.  */

       /* The motion scene that @id/motion_layout points to is similar to the motion scene in
          the last step. However, the OnSwipe declaration was removed to enable it to work with
          CoordinatorLayout.*/

        /*
        * To make the MotionLayout view scroll as soon as the NestedScrollView scrolls, add
             app:minHeight and app:layout_scrollFlags to the MotionLayout.
        * Run the app again and got to Step 8. You see that the MotionLayout collapses as you
             scroll up. However, the animation does not progress based on the scroll behavior yet.
        * Edit the coordinateMotion() function to tell MotionLayout about the changes in scroll
             position (See coordinateMotion() method here!)


        It's possible to build custom dynamic collapsing toolbar animations using MotionLayout.
        By using a sequence of KeyFrames you can achieve very bold effects.

        AppBarLayout does not resize the MotionLayout.
        The MotionLayout view will be moved partially offscreen when AppBarLayout collapses it.
        It will not be resized, but just moved up. If you have constraints to the top of the
        MotionLayout, they will be offscreen at the end of the animation. To work with AppBarLayout
        ensure end constraints are anchored to the bottom of the parent.

        * */

        coordinateMotion()

        /* Check all the info here:
            https://codelabs.developers.google.com/codelabs/motion-layout/#11
        */
    }


    /* This code will register a OnOffsetChangedListener that will be called every time the user scrolls with the current scroll offset. */
    private fun coordinateMotion() {
        val appBarLayout: AppBarLayout = findViewById(R.id.appbar_layout)
        val motionLayout: MotionLayout = findViewById(R.id.motion_layout)

        val listener = AppBarLayout.OnOffsetChangedListener { unused, verticalOffset ->
            /* MotionLayout supports seeking its transition by setting the progress property.
               To convert between a verticalOffset and a percentage progress, divide by the total
               scroll range.*/

            val seekPosition = -verticalOffset / appBarLayout.totalScrollRange.toFloat()
            motionLayout.progress = seekPosition
        }

        /* MotionLayout can seek to a specific point in the animation in code.
        Do this by setting motionLayout.progress. MotionLayout will immediately "jump" to the position that was specified.
        So, for example, if you set the progress to 0.43, MotionLayout will jump to 43% through the animation.*/
        appBarLayout.addOnOffsetChangedListener(listener)
    }

}