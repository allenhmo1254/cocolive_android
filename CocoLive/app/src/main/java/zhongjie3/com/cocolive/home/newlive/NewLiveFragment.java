package zhongjie3.com.cocolive.home.newlive;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import zhongjie3.com.cocolive.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewLiveFragment extends Fragment {


    public NewLiveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_live, container, false);
    }

}
