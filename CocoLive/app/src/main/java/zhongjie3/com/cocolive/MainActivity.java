package zhongjie3.com.cocolive;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zhongjie3.com.cocolive.home.HomeFragment;
import zhongjie3.com.cocolive.me.MeFragment;

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
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
    }

    private void onStartLiveClick()
    {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentManager fm = getSupportFragmentManager();
        Fragment home = findFragmentByTag(R.id.radioHome);
        Fragment me = findFragmentByTag(R.id.radioMe);
        if (checkedId == R.id.radioHome) {
            fm.beginTransaction().show(home).hide(me).commit();
        } else if (checkedId == R.id.radioMe) {
            fm.beginTransaction().show(me).hide(home).commit();
        }
        fm.executePendingTransactions();
    }

    private void initView()
    {
        //创建底部菜单标签页
        radioGroup.setOnCheckedChangeListener(this);
        radioGroup.check(R.id.radioHome);
    }

    /**
     * 查找Home和User 两个Fragment,如果没有添加则添加
     */
    private Fragment findFragmentByTag(int tag) {
        FragmentManager fm = getSupportFragmentManager();
        Fragment f = fm.findFragmentByTag(String.valueOf(tag));
        if (f != null) {
            return f;
        }
        if (tag == R.id.radioHome) {
            f = new HomeFragment();
        } else if (tag == R.id.radioMe) {
            f = new MeFragment();
        }
        fm.beginTransaction().add(R.id.fragmentContainer, f, String.valueOf(tag)).commit();
        fm.executePendingTransactions();
        return f;
    }
}
