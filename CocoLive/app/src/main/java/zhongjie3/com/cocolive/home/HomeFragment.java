package zhongjie3.com.cocolive.home;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import zhongjie3.com.cocolive.R;
import zhongjie3.com.cocolive.home.follow.FollowFragment;
import zhongjie3.com.cocolive.home.hot.HotFragment;
import zhongjie3.com.cocolive.home.newlive.NewLiveFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    @BindView(R.id.home_tabbar)
    TabLayout mTabLayout;

    @BindView(R.id.home_view_pager)
    ViewPager homeViewPager;

    private HomePagerFragmentAdapter fragmentPagerAdapter;
    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);

        initData();
        initView(savedInstanceState);

        return view;
    }

    private void initData()
    {
        titleList.add(getString(R.string.followFragmentTitle));
        titleList.add(getString(R.string.hotFragmentTitle));
        titleList.add(getString(R.string.newLiveFragmentTitle));
    }

    private void initView(Bundle savedInstanceState)
    {
        initFragment(savedInstanceState);
        initViewPager();
        initTabLayout();
    }

    private void initFragment(Bundle savedInstanceState)
    {
        FragmentManager fragmentManager = getChildFragmentManager();
        if (savedInstanceState != null)
        {
            List<Fragment> fragments = fragmentManager.getFragments();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            for (Fragment fragment : fragments)
            {
                if (fragment != null)
                {
                    fragmentTransaction.remove(fragment);
                }
            }
            fragmentTransaction.commit();
            fragmentManager.executePendingTransactions();
        }

        if (fragmentList.isEmpty())
        {
            fragmentList.add(new FollowFragment());
            fragmentList.add(new HotFragment());
            fragmentList.add(new NewLiveFragment());
        }
        if (fragmentPagerAdapter == null)
        {
            fragmentPagerAdapter = new HomePagerFragmentAdapter(fragmentManager);
        }
    }

    private void initViewPager()
    {
        homeViewPager.setAdapter(fragmentPagerAdapter);
    }

    private void initTabLayout()
    {
        mTabLayout.setupWithViewPager(homeViewPager);
    }

    private class HomePagerFragmentAdapter extends FragmentStatePagerAdapter {

        public HomePagerFragmentAdapter(FragmentManager fragmentManager)
        {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) //选择性实现
        {
            return titleList.get(position);
        }
    }
}
