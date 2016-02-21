package br.gilsonjuniorpro.mytabs.com.mytabs.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.gilsonjuniorpro.mytabs.com.mytabs.R;

/**
 * Created by gilsonjuniorpro on 21/02/16.
 */
public class FourFragment extends Fragment {

    public FourFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_four, container, false);
    }
}