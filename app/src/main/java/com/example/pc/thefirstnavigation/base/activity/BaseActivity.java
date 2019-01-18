package com.example.pc.thefirstnavigation.base.activity;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.pc.thefirstnavigation.R;
import com.example.pc.thefirstnavigation.app.MyApp;
import com.example.pc.thefirstnavigation.base.presenter.BasePresenterIml;
import com.example.pc.thefirstnavigation.base.view.BaseView;

public abstract class BaseActivity<V, P extends BasePresenterIml<V>> extends SimpleActivity implements BaseView {


    public P presenter;
    private View mView1s;
    private PopupWindow mWindows;

    @Override
    public void viewCreated(View view) {
        super.viewCreated(view);

        presenter = createPresenter();
        if (presenter != null) {
            presenter.boundView((V) this);
        }
        showWindow();
    }

    protected abstract P createPresenter();
    protected abstract View getViewLayoutID();


   /* @Override
    protected int createLayoutId() {
        return 0;
    }*/

    /*@Override
    protected void initData() {

    }*/

    /*protected void setAnimation(View v){

    }*/
    private void showWindow() {
        //三要素 布局,宽 ,高
        View inflate = LayoutInflater.from(this).inflate(R.layout.animation, null, false);
        mWindows = new PopupWindow(inflate);
        //把宽高设置成MATCH_PARENT后,点击外部消失效果没有了,可以pop 布局最外层的view设置点击
        /*inflate.findViewById(R.id.img).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWindows.dismiss();
            }
        });*/
        mWindows.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        mWindows.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        //在前面某些版本api下,必须给背景,否则setOutsideTouchable无效
        //  mWindows.setBackgroundDrawable(new ColorDrawable());
        //设置为true,点击外部,PopupWindow可以消失
        //   mWindows.setOutsideTouchable(true);
        // window.setAnimationStyle(R.style.PopAnimation);
        //在某个view下方显示,xoff水平方向的偏移量,正值向右,yoff垂直方向的偏移量,正值向下
        //window.showAsDropDown(mBtn2,100,-100);
        //在屏幕的某个位置显示,x水平方向的偏移量,正值向右,y垂直方向的偏移量,正值向下,和给定的view位置没有关系
        //  mWindows.showAtLocation(v, Gravity.CENTER,0,0);
      /*  mWindows.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
               // v.setBackgroundColor(0xFFFFFFF);
            }
        });*/
    }

    @Override
    public void showAnimation() {
        getViewLayoutID().setBackgroundColor(0xC4BDB6B6);
        getViewLayoutID().post(new Runnable() {
            @Override
            public void run() {
                mWindows.showAtLocation(getViewLayoutID(), Gravity.CENTER, 0, 0);
            }
        });

    }

    @Override
    public void hideAnimation() {

        getViewLayoutID().setBackgroundColor(0xFFFFFFFF);
        mWindows.dismiss();

    }

   /* @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }*/

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.unbindView();
            presenter = null;
        }
    }
}
