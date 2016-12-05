package com.fernandofgallego.stylight.view.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fernandofgallego.stylight.R;
import com.fernandofgallego.stylight.model.datasource.TimelineRepository;

public class MainFragment extends Fragment implements MainContract.View {

    private MainContract.Presenter mainPresenter;
    private RecyclerView list;

    public MainFragment() {
        mainPresenter = new MainPresenter(this, TimelineRepository.INSTANCE);
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fagment_main, container, false);

        list = (RecyclerView) view.findViewById(R.id.list_main);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        list.setLayoutManager(layoutManager);
        return view;

    }

    @Override
    public void onResume() {
        super.onResume();
        mainPresenter.start();
    }

    @Override
    public void showData(RecyclerView.Adapter adapter) {
        list.setAdapter(adapter);
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mainPresenter = presenter;
    }
}
