package com.example.poblenou.eltemps;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private ArrayList<String> tiempoCadaDiaArray;
    private ArrayAdapter tiempoCadaDiaAdapter;

    private ListView tiempoCadaDia;

    private View vRoot;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        vRoot = inflater.inflate(R.layout.fragment_main, container, false);

        String data [] = {
                "Lun 23/6 - Soleado - 31/17",
                "Mar 24/6 - Lluvioso - 31/17",
                "Mie 25/6 - Soleado - 31/17",
                "Jue 26/6 - Nieve - 31/17",
                "Vie 27/6 - Nublado - 31/17",
                "Sab 28/6 - Tormenta - 31/17",
                "Sab 29/6 - Granizo - 31/17"
        };


        tiempoCadaDia = (ListView) vRoot.findViewById(R.id.lvTiempoCadaDia);

        tiempoCadaDiaArray = new ArrayList<>();
        tiempoCadaDiaAdapter = new ArrayAdapter<>(
                getContext(),
                R.layout.lv_mainfragment,
                R.id.textView1,
                tiempoCadaDiaArray
        );

        return vRoot;
    }
}
