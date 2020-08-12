package com.eahm.motionlayoutexperiments.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eahm.motionlayoutexperiments.R

class ModifyingAPath : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modifying_a_path)

        /* app:motionDebug
        After you enable path debugging, when you run the app again, you'll see the paths of all views visualized with a dotted line:
            Circles  -> Represent the start or end position of one view.
            Lines    -> Represent the path of one view.
            Diamonds -> Represent a KeyPosition that modifies the path. */

        /* KeyPositionType
           - values: parentRelative, pathRelative and deltaRelative
           - Specifying a type will change the coordinate system by which percentX and percentY are calculated.
           - MotionLayout coordinate systems are a cartesian coordinate system

           parentRelative -> uses the same coordinate system as the screen. It defines (0, 0) to the
                             top left and (1, 1) to the bottom right.
           deltaRelative  -> is a math term for change, so deltaRelative is a way of saying "change relative"
                             the coordinates (0,0) is the starting position of the view, and (1,1) is the ending position
           pathRelative   -> the X axis follows the motion path from start to end. So (0,0) is the
                             starting position and (1,0) is the ending position.
         */

        /* KeyAttributes
          - MotionLayout supports animating many attributes on any view using a KeyAttribute.
          - Multiple attributes can be modified at the same time by a single KeyAttribute.
          - Here's a list of the standard attributes that you can try:
            android:visibility
            android:alpha
            android:elevation
            android:rotation
            android:rotationX
            android:rotationY
            android:scaleX
            android:scaleY
            android:translationX
            android:translationY
            android:translationZ */

        /* Custom Attributes
          - Can be used to set any value that has a setter. For example, you can set the backgroundColor on a View using a CustomAttribute
          - MotionLayout will use reflection to find the setter, then call it repeatedly to animate the view.

          app:attributeName -> is the name of the setter that will be called by this custom attribute.
          app:custom*Value  -> is a custom value of the type noted in the name.
                              *Custom values can have any of the following types:
                                    Color
                                    Integer
                                    Float
                                    String
                                    Dimension
                                    Boolean*/
    }
}