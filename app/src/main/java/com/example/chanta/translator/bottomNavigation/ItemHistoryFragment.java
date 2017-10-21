package com.example.chanta.translator.bottomNavigation;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.chanta.translator.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by chanta on 07.10.17.
 */

public class ItemHistoryFragment extends Fragment {
    private ListView listView;
    private ArrayAdapter<String> adapter;
    //    private List<String> values = new ArrayList<String>();
    private List<String> liste;

    public static ItemHistoryFragment newInstance() {
        ItemHistoryFragment fragment = new ItemHistoryFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_item_history, container, false);

        listView = (ListView) view.findViewById(R.id.list_translate);
        String[] values = getResources().getStringArray(R.array.list_translate);
        liste = new ArrayList<String>();
        Collections.addAll(liste, values);

        adapter = new ArrayAdapter<String>(getActivity().getBaseContext(),
                R.layout.list_for_translate, R.id.txt, liste);

        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                final int positionToRemove = pos;
                builder.setTitle(R.string.choice_delete)
                        .setMessage(R.string.choice_delete_text)
                        .setPositiveButton(R.string.choice_delete_ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                liste.remove(positionToRemove);
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton(R.string.choice_delete_cansel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                AlertDialog dialog = builder.create();
                dialog.show();
                return true;
            }
        });


//                new View.OnLongClickListener(){
//            @Override
//            public boolean onLongClick(View view) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//                builder.setTitle(R.string.choice_delete)
//                        .setMessage(R.string.choice_delete_text)
//                        .setPositiveButton(R.string.choice_delete_ok, new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int which) {
//                                listView.removeViewAt(which);
//                                adapter.notifyDataSetChanged();
//                            }
//                        })
//                        .setNegativeButton(R.string.choice_delete_cansel, new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int which) {
//                                dialog.cancel();
//                            }
//                        });
//
//                AlertDialog dialog = builder.create();
//                dialog.show();
//                return false;
//            }
//            });

//        imageButton = (ImageButton) view.findViewById(R.id.imageButton);
//        imageButton.setOnClickListener( new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//                builder.setTitle(R.string.choice_delete)
//                        .setMessage(R.string.choice_delete_text)
//                        .setPositiveButton(R.string.choice_delete_ok, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        listView.removeViewAt(which);
//                        adapter.notifyDataSetChanged();
//                    } })
//                        .setNegativeButton(R.string.choice_delete_cansel, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.cancel();
//                    } });
//
//                AlertDialog dialog = builder.create();
//                dialog.show();
//
//            }
//        });


        return view;
    }
}

