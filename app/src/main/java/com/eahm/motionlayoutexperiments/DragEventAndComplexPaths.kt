package com.eahm.motionlayoutexperiments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DragEventAndComplexPaths : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drag_event_and_complex_paths)

        /* Controlling animations that have complex paths using OnSwipe requires understanding
           how OnSwipe works. */

        /* Bug with an arc path:
        To understand the bug, consider what happens when the user is touching just below the top of
        the arc. Because the OnSwipe tag has an app:touchAnchorSide="bottom" MotionLayout will try
        to make the distance between the finger and the bottom of the view constant throughout the animation.

        But, since the bottom of the moon doesn't always go in the same direction, it goes up then
        comes back down, MotionLayout doesn't know what to do when the user has just passed the top
        of the arc. To consider this, since you're tracking the bottom of the moon, where should it
        be placed when the user is touching the middle point where the arch goes up and down at the same
        time, just before reaching the top of the arc?

        --------------------------------------------->
        Check the drag_event_complex_paths_scene.xml to find this bug and the solution.
        To avoid bugs like this, it is important to always choose a touchAnchorId and touchAnchorSide
        that always progresses in one direction throughout the duration of the entire animation.

        In this animation, both the right side and the left side of the moon will progress across the
        screen in one direction.
        However, both the bottom and the top will reverse direction. When OnSwipe attempts to track
        them, it will get confused when their direction changes.

        In the Motion Scene file:
            <OnSwipe
                   app:touchAnchorId="@id/moon"
                   app:touchAnchorSide="right"
            />

     !! The touchAnchorSide passed to OnSwipe must progress in a single direction through the
        entire animation.
        If the anchored side reverses its path, or pauses, MotionLayout will get confused and not
        progress in a smooth motion.

 --->   In some animations, no view has an appropriate touchAnchorSide.
        This may happen if every side follows a complex path through the motion, or views resize in
        ways that would cause surprising animations. In these situations, consider adding an invisible
        view that follows a simpler path to track.

 --->   You can also combine dragDirection with touchAnchorSide to make a side track a different
        direction than it normally would. It's still important that the touchAnchorSide only progress
        in one direction, but you can tell MotionLayout which direction to track. For example, you
        can keep the touchAnchorSide="bottom", but add dragDirection="dragRight". This will cause
        MotionLayout to track the position of the bottom of the view, but only consider its location
        when moving right (it ignores vertical motion). So, even though the bottom goes up and down,
        it will still animate correctly with OnSwipe:

        <OnSwipe
               app:touchAnchorId="@id/moon"
               app:touchAnchorSide="bottom"
               app:dragDirection="dragRight"
        />

        */
    }
}