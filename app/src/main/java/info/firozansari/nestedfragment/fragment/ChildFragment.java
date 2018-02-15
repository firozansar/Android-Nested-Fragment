package info.firozansari.nestedfragment.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import info.firozansari.nestedfragment.helper.MyAdapter;
import info.firozansari.nestedfragment.R;


/**
 * The child fragment is no different than any other fragment other than it is now being maintained by
 * a child FragmentManager.
 */
public class ChildFragment extends Fragment {

    public static final String POSITION_KEY = "FragmentPositionKey";
    private int position;

    public static ChildFragment newInstance(Bundle args) {
        ChildFragment fragment = new ChildFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        position = getArguments().getInt(POSITION_KEY);

        View root = inflater.inflate(R.layout.fragment_child, container, false);
        RecyclerView rv = (RecyclerView) root.findViewById(R.id.rv_recycler_view);
        rv.setHasFixedSize(true);
        MyAdapter adapter = new MyAdapter(new String[]{"test one", "test two", "test three", "test four", "test five" , "test six" , "test seven"});
        rv.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);
        return root;
    }

}
