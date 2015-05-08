package me.leolin.speedmyandroid.speedview;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import me.leolin.speedmyandroid.speedview.chain.*;
import me.leolin.speedmyandroid.speedview.wrapper.ActivityWrapper;
import me.leolin.speedmyandroid.speedview.wrapper.ViewWrapper;

/**
 * @author leolin
 */
public abstract class SpeedView {
    public static SpeedView with(View view) {
        return new ViewWrapper(view);
    }

    public static SpeedView with(Activity activity) {
        return new ActivityWrapper(activity);
    }

    protected abstract View findViewById(int id);

    public View just(int id) {
        return findViewById(id);
    }

    public ViewChain view(int id) {
        return new ViewChain(findViewById(id), this);
    }

    public ButtonChain btn(int id) {
        return new ButtonChain((Button) findViewById(id), this);
    }

    public TextViewChain tv(int id) {
        return new TextViewChain((TextView) findViewById(id), this);
    }

    public ViewGroupChain container(int id) {
        return new ViewGroupChain((ViewGroup) findViewById(id), this);
    }

    public ListViewChain list(int id) {
        return new ListViewChain((ListView) findViewById(id), this);
    }
}