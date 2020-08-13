package com.eahm.motionlayoutexperiments.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eahm.motionlayoutexperiments.R

class MultipleTransitions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiple_transitions)

        /**
         * See xml -> motion_multiple_transitions.xml
         *
         * In this section we use an attribute in the <Transition> tag
         * the "app:deriveConstraintsFrom"
         *      This specify a constraintSet configuration reference, and
         *      the current ConstraintSet (using this tag) will use the final
         *      state of the view from the given constraintSet reference.
         *
         *
         * Other attributes of <Transition>
         * autoTransition: automatically transition from one state to another.
         *                 supports keywords {none, jumpToStart, jumpToEnd,
         *                 animateToStart, animateToEnd}
         *
         * motionInterpolator: The ability to set an overall interpolation
         *                     (easeInOut, linear, etc.)
         */

    }
}