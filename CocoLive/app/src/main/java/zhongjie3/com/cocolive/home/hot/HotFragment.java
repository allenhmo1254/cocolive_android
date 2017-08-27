package zhongjie3.com.cocolive.home.hot;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import zhongjie3.com.cocolive.R;
import zhongjie3.com.cocolive.tools.ViewHolder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotFragment extends Fragment {

    @BindView(R.id.frag_hot_recyclerView)
    private RecyclerView recyclerView;
    @BindView(R.id.frag_hot_refresh)
    private SwipeRefreshLayout swipeRefreshLayout;
    private LinearLayoutManager mLayoutManager;
    private List<HotItemBean> beanList;

    public HotFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hot, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    private void initData()
    {
        beanList = new ArrayList<>();
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
    }

    private void initSwipeRefreshLayout()
    {

    }

    private class HotAdapter extends RecyclerView.Adapter<ViewHolder>
    {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            
            return null;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return beanList.size();
        }
    }

}
