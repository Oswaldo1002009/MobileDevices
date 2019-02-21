package com.example.app4;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;
import android.content.*;


public class MainActivity extends Activity implements
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {

    private static final int SWIPE_THRESHOLD = 100;
    private static final int SWIPE_VELOCITY_THRESHOLD = 100;

    private GestureDetectorCompat mDetector;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDetector = new GestureDetectorCompat(this, this);
        mDetector.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (this.mDetector.onTouchEvent(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent event) {
//        Toast toast = Toast.makeText(getApplicationContext(), "OnDown" + event.toString(), Toast.LENGTH_SHORT);
//        toast.show();
        return true;
    }

    @Override
    public void onLongPress(MotionEvent event) {
//        Toast toast = Toast.makeText(getApplicationContext(), "OnLongPress", Toast.LENGTH_SHORT);
//        toast.show();
    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
//        Toast toast = Toast.makeText(getApplicationContext(), "onSingleTapUp", Toast.LENGTH_SHORT);
//        toast.show();
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent event) {
//        Toast toast = Toast.makeText(getApplicationContext(), "onDoubleTap", Toast.LENGTH_SHORT);
//        toast.show();
        return true;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        boolean result = false;
        try {
            float diffY = e2.getY() - e1.getY();
            float diffX = e2.getX() - e1.getX();
            if (Math.abs(diffX) > Math.abs(diffY)) {
                if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffX > 0) {
                        result = true;
                        onSwipeRight();

                    } else {
                        result = true;
                        onSwipeLeft();
                    }
                    result = true;
                }
            } else if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                if (diffY > 0) {
                } else {
                }
                result = true;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return result;

    }

    public void onSwipeRight() {
        Intent myIntent = new Intent(MainActivity.this, SwipeRight.class);
        MainActivity.this.startActivity(myIntent);
    }

    public void onSwipeLeft() {
        Intent myIntent = new Intent(MainActivity.this, SwipeLeft.class);
        MainActivity.this.startActivity(myIntent);
    }

    //Redundant Events

    @Override
    public boolean onDoubleTapEvent(MotionEvent event) {
        //Toast toast = Toast.makeText(getApplicationContext(), "onDoubleTapEvent" + event.toString(), Toast.LENGTH_SHORT); toast.show();
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent event) {
        //Toast toast = Toast.makeText(getApplicationContext(), "onSingleTapConfirmed" + event.toString(), Toast.LENGTH_SHORT); toast.show();
        return true;
    }

    @Override
    public void onShowPress(MotionEvent event) {
        //Toast toast = Toast.makeText(getApplicationContext(), "OnShowPress" + event.toString(), Toast.LENGTH_SHORT); toast.show();
    }

    @Override
    public boolean onScroll(MotionEvent event1, MotionEvent event2, float distanceX,
                            float distanceY) {
        //Toast toast = Toast.makeText(getApplicationContext(), "onScroll" + event1.toString() + "; " + event2.toString(), Toast.LENGTH_SHORT); toast.show();
        return true;
    }
}
