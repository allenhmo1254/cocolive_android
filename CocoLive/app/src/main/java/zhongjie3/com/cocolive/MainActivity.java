package zhongjie3.com.cocolive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.fragmentContainer)
    FrameLayout fragmentContrainer;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;
    @BindView(R.id.radioHome)
    RadioButton radioHome;
    @BindView(R.id.radioMe)
    RadioButton radioMe;

    @OnClick(R.id.btnLive)
    public void onBtmLiveClick()
    {
        onStartLiveClick();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        //创建底部菜单标签页
        radioGroup.setOnCheckedChangeListener(this);
        radioGroup.check(R.id.radioHome);
    }

    private void onStartLiveClick()
    {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

    }
}
