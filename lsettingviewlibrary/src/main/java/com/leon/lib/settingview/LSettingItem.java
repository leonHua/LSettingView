package com.leon.lib.settingview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * 作者：Leon
 * 时间：2016/12/21 10:32
 */
public class LSettingItem extends RelativeLayout {
    private String mLeftText;
    private Drawable mLeftIcon;
    private Drawable mRightIcon;
    private int mTextSize;
    private int mTextColor;
    //private Drawable mBgColor;//背景颜色
    //private Drawable mBgSelectedColor;//按下背景颜色
    private View mView;//整体布局
    private TextView mTvLeftText;
    private ImageView mIvLeftIcon;
    private ImageView mIvRightIcon;

    public LSettingItem(Context context) {
        this(context, null);
    }

    public LSettingItem(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LSettingItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
        getCustomStyle(context, attrs);
        ////设定背景选择器
        //StateListDrawable drawable = new StateListDrawable();
        //drawable.addState(new int[]{android.R.attr.state_pressed},
        //        selected);
        //drawable.addState(new int[]{-android.R.attr.state_pressed},
        //        unSelected);
        //tv.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
    }

    /**
     * 获取自定义属性
     *
     * @param context
     * @param attrs
     */
    public void getCustomStyle(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.LSettingView);
        int n = a.getIndexCount();
        Log.i("LSETTINGITEM---", "n:" + n);
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            if (attr == R.styleable.LSettingView_leftText) {
                mLeftText = a.getString(attr);
                Log.i("LSETTINGITEM---", "dd:" + mLeftText);
                mTvLeftText.setText(mLeftText);

            } else if (attr == R.styleable.LSettingView_leftIcon) {// 左侧图标
                mLeftIcon = a.getDrawable(attr);
                mIvLeftIcon.setImageDrawable(mLeftIcon);

            } else if (attr == R.styleable.LSettingView_textSize) {// 默认设置为16sp，TypeValue也可以把sp转化为px
                mTextSize = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
                mTvLeftText.setTextSize(mTextSize);

            } else if (attr == R.styleable.LSettingView_textColor) {//文字默认灰色
                mTextColor = a.getColor(attr, Color.LTGRAY);
                mTvLeftText.setTextColor(mTextColor);

            } else if (attr == R.styleable.LSettingView_bgColor) {//背景没有设定则为白色
                //mBgColor = a.getColor(attr, Color.WHITE);

            } else if (attr == R.styleable.LSettingView_bgSelectedColor) {//按下背景没有设定则默认为浅灰色
                // mBgSelectedColor = a.getColor(attr, Color.parseColor("#88666666"));

            }
        }
        a.recycle();
    }

    private void initView(Context context) {
        mView = View.inflate(context, R.layout.settingitem, this);
        mTvLeftText = (TextView) mView.findViewById(R.id.tv_lefttext);
        mIvLeftIcon = (ImageView) mView.findViewById(R.id.iv_lefticon);
        mIvRightIcon = (ImageView) mView.findViewById(R.id.iv_righticon);
    }
}
