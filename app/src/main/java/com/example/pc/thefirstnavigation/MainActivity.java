package com.example.pc.thefirstnavigation;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.pc.thefirstnavigation.base.activity.BaseActivity;
import com.example.pc.thefirstnavigation.beans.News_Channel;
import com.example.pc.thefirstnavigation.contact.ListNewTab;
import com.example.pc.thefirstnavigation.presenter.MainPresenterIml;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<ListNewTab.ListNewTabView, MainPresenterIml<ListNewTab.ListNewTabView>> implements ListNewTab.ListNewTabView {


    @BindView(R.id.mainActivitylayout)
    LinearLayout mainActivitylayout;
    @BindView(R.id.activity_toolbar)
    Toolbar activityToolbar;
    @BindView(R.id.activity_title)
    TextView activityTitle;
    @BindView(R.id.activity_Login)
    EditText activityLogin;
    @BindView(R.id.activity_Password)
    EditText activityPassword;
    @BindView(R.id.activity_verification)
    TextView activityVerification;
    @BindView(R.id.bt_Login)
    Button btLogin;
    @BindView(R.id.activity_radioButton)
    CheckBox activityRadioButton;
    @BindView(R.id.wechat)
    ImageView wechat;
    @BindView(R.id.qq)
    ImageView qq;
    @BindView(R.id.sina)
    ImageView sina;
    @BindView(R.id.agreement)
    TextView agreement;
    private boolean showPop;

    @Override
    protected MainPresenterIml<ListNewTab.ListNewTabView> createPresenter() {
        return new MainPresenterIml<>();
    }

    @Override
    protected View getViewLayoutID() {
        return mainActivitylayout;
    }

    @Override
    protected int createLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        setToolBar(activityToolbar, "",2);
        initView();
    }

    @Override
    public void showListNewTab(News_Channel news_channel) {
        Log.e("litao22news_channel", news_channel.getNewsChannelList().get(0).getChannelName());
    }

    @Override
    public void showError(String error) {
        Log.e("litao22error", error);
    }


    public void initView() {

    }




    @OnClick({R.id.agreement,R.id.bt_Login, R.id.activity_Login, R.id.activity_Password, R.id.activity_verification, R.id.activity_radioButton})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_Login:
              /*  if(activityRadioButton.isChecked()==false){
                    btLogin.setBackgroundColor(R.drawable.circular_button);
                }else{
                    btLogin.setBackgroundColor(R.drawable.circular_buttontwo);
                    presenter.getListNewTab("");
                }*/
                presenter.getListNewTab("");
                break;
            case R.id.activity_Login:

                break;
            case R.id.activity_Password:
            if(activityLogin.getText() != null){



            }
                break;
            case R.id.activity_verification:

                break;
            case R.id.activity_radioButton:

                break;
            case R.id.agreement:
               /* if(showPop){
                    showWindow();
                    mainActivitylayout.setVisibility(View.GONE);
                    showPop = false;

                }else{
                    mainActivitylayout.setVisibility(View.VISIBLE);
                    showPop = true;
                }*/
                break;
        }


    }

    @Override
    public void showAnimation() {
        super.showAnimation();

    }

    @Override
    public void hideAnimation() {
        super.hideAnimation();

    }

    private void showWindow() {
        //三要素 布局,宽 ,高
        View inflate = LayoutInflater.from(this).inflate(R.layout.agreement, null, false);

        final PopupWindow window = new PopupWindow(inflate);
        //把宽高设置成MATCH_PARENT后,点击外部消失效果没有了,可以pop 布局最外层的view设置点击
        inflate.findViewById(R.id.agteement_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                window.dismiss();
            }
        });
        window.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        window.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        //在前面某些版本api下,必须给背景,否则setOutsideTouchable无效
        window.setBackgroundDrawable(new ColorDrawable());
        //设置为true,点击外部,PopupWindow可以消失
        window.setOutsideTouchable(true);
        //在某个view下方显示,xoff水平方向的偏移量,正值向右,yoff垂直方向的偏移量,正值向下
        //window.showAsDropDown(mBtn2,100,-100);
        //在屏幕的某个位置显示,x水平方向的偏移量,正值向右,y垂直方向的偏移量,正值向下,和给定的view位置没有关系
        window.showAtLocation(mainActivitylayout, Gravity.CENTER,0,0);
    }


}

