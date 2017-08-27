package zhongjie3.com.cocolive.home.hot;


import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import zhongjie3.com.cocolive.R;
import zhongjie3.com.cocolive.tools.ViewHolder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, Runnable {

    @BindView(R.id.frag_hot_recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.frag_hot_refresh)
    SwipeRefreshLayout swipeRefreshLayout;
    private LinearLayoutManager mLayoutManager;
    private List<HotItemBean> beanList;
    private Handler handler = new Handler(Looper.getMainLooper());
    private HotAdapter hotAdapter;

    public HotFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hot, container, false);

        ButterKnife.bind(this, view);

        initData();
        initView();

        return view;
    }

    private void initData()
    {
        beanList = new ArrayList<>();
        for (int i = 0; i < 10; i ++)
        {
            HotItemBean bean = new HotItemBean();
            bean.setAvatorUrl("");
            bean.setIconUrl("");
            bean.setLocation("北京");
            bean.setNick("美女");
            bean.setNum(""+i*100);
            beanList.add(bean);
        }
    }

    private void initView()
    {
        initRecyclerView();
        initSwipeRefreshLayout();
    }

    private void initRecyclerView()
    {
        mLayoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        hotAdapter = new HotAdapter();
        recyclerView.addItemDecoration(new HotItemDecoration());
        recyclerView.setAdapter(hotAdapter);
    }

    private void initSwipeRefreshLayout()
    {
        swipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(true);
        handler.postDelayed(this, 2000);
    }

    @Override
    public void run() {
        swipeRefreshLayout.setRefreshing(false);
    }

    private class HotAdapter extends RecyclerView.Adapter<ViewHolder> implements View.OnClickListener {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_recycler_hot, parent, false);
            ViewHolder viewHolder = new ViewHolder(view);
            view.setOnClickListener(this);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            HotItemBean bean = beanList.get(position);
            ((TextView)holder.get(R.id.item_hot_nick)).setText(bean.getNick());
            ((TextView)holder.get(R.id.item_hot_location_text)).setText(bean.getLocation());
            ((TextView)holder.get(R.id.item_hot_viewer_num_text)).setText(bean.getNum());
            ((ImageView)holder.get(R.id.item_hot_avator)).setImageResource(R.drawable.li_btn_room_follow_bg);
            ((ImageView)holder.get(R.id.item_hot_icon)).setImageResource(R.drawable.login_page_bg);
        }

        @Override
        public int getItemCount() {
            return beanList.size();
        }

        @Override
        public void onClick(View v) {
            int position = recyclerView.getChildAdapterPosition(v);
            Log.d("MainActivity", "position = "+position);
        }
    }

    private class HotItemDecoration extends RecyclerView.ItemDecoration
    {
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.left = 0;
            outRect.right = 0;
            outRect.bottom = 10;
            outRect.top = 0;
        }
    }

}


