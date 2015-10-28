package com.example.poblenou.eltemps;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A placeholder fragment containing a simple view.
 */
public class ElTempsFragment extends Fragment {

    private ArrayAdapter tiempoCadaDiaAdapter;

    private ListView lvElTempsMain;

    private View vRoot;


    Boolean menu = true;

    public ElTempsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(menu);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        vRoot = inflater.inflate(R.layout.fragment_main, container, false);

        String[] data = {
                "Lun 23/6 - Soleado - 31/17",
                "Mar 24/6 - Lluvioso - 31/17",
                "Mie 25/6 - Soleado - 31/17",
                "Jue 26/6 - Nieve - 31/17",
                "Vie 27/6 - Nublado - 31/17",
                "Sab 28/6 - Tormenta - 31/17",
                "Sab 29/6 - Granizo - 31/17"
        };
        ArrayList<String> tiempoCadaDiaArray = new ArrayList<>(Arrays.asList(data));

        lvElTempsMain = (ListView)vRoot.findViewById(R.id.lvElTempsMain);

        tiempoCadaDiaAdapter = new ArrayAdapter<>(
                                getContext(),
                                R.layout.lv_eltempsfragment,
                                R.id.textView1,
                                tiempoCadaDiaArray
        );
        lvElTempsMain.setAdapter(tiempoCadaDiaAdapter);

        return vRoot;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {return true;}

        if (id == R.id.action_refresh) {
            refresh();
            return true;}


        return super.onOptionsItemSelected(item);
    }

    private void refresh() {
        OwmApiClient apiClient = new OwmApiClient();
        apiClient.updateForecasts(tiempoCadaDiaAdapter, getContext());
    }
}
