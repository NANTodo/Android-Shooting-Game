package org.Game;

import android.graphics.Rect;

public class CollisionManager {
    public static boolean CheckBoxToBox(Rect _rt1, Rect _rt2){
        //여기 손좀 봐야함
        if(_rt1.right > _rt2.left && _rt1.left < _rt2.right && _rt1.top < _rt2.bottom && _rt1.bottom > _rt2.top)
            return true;
        return false;

//        _rt1. right > _rt2. left && _rt1. left < _rt2. right
//                && _rt1. top <_rt2. bottom && _rt1. bottom > _rt2. top
    }

}
