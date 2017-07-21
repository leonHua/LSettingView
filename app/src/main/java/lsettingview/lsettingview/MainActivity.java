package lsettingview.lsettingview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.leon.lib.settingview.LSettingItem;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private LSettingItem mSettingItemOne;
    private LSettingItem mSettingItemFour;
    private ImageView mIvHead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSettingItemOne = (LSettingItem) findViewById(R.id.item_one);
        mSettingItemFour = (LSettingItem) findViewById(R.id.item_four);
        mIvHead = (ImageView) findViewById(R.id.headimage);

        mSettingItemOne.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click(boolean isChecked) {
                Toast.makeText(getApplicationContext(), "我的消息", Toast.LENGTH_SHORT).show();
            }
        });
        mSettingItemFour.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click(boolean isChecked) {
                Toast.makeText(getApplicationContext(), "选中开关：" + isChecked, Toast.LENGTH_SHORT).show();
            }
        });
        mSettingItemOne.setRightText("我是右侧改变的文字");
        Picasso.with(this).load(R.drawable.girl).transform(new CircleTransform()).into(mIvHead);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item_one:
                Toast.makeText(getApplicationContext(), "我的消息", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
