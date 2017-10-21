package com.example.chanta.translator.bottomNavigation;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.chanta.translator.R;

/**
 * Created by chanta on 07.10.17.
 */

public class ItemLanguageFragment extends Fragment {
    private EditText editText;
    private Button buttonLeft;
    private Button buttonRight;

    public static ItemLanguageFragment newInstance() {
        ItemLanguageFragment fragment = new ItemLanguageFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_item_language, container, false);

        editText = (EditText) view.findViewById(R.id.edit_text_language);
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View viewForKey, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN)
                        && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ScrollView scrollView = (ScrollView) view.findViewById(R.id.scrollViewLanguage);
                    scrollView.setVisibility(View.VISIBLE);
                    InputMethodManager manager = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
                    manager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
//                    Toast.makeText(getContext(), editText.getText(), Toast.LENGTH_LONG).show();
                    return true;
                }
                return false;
            }
        });

        buttonLeft = (Button) view.findViewById(R.id.left_button_language);
        buttonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(view, R.id.left_button_language);
            }
        });

        buttonLeft = (Button) view.findViewById(R.id.right_button_language);
        buttonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(view, R.id.right_button_language);
            }
        });


        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.floatingActionButton_favorite);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), R.string.add, Toast.LENGTH_LONG).show();
            }
        });
        return view;

    }

    public void showDialog(View view, final int id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.choose_language)
                .setItems(R.array.list_button_languages_entries, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        final String[] languages = getResources().getStringArray(R.array.list_button_languages_entries);
                        Button button = (Button) getView().findViewById(id);
                        button.setText(languages[i]);
//                      Toast.makeText(getContext(), editText.getText(), Toast.LENGTH_LONG).show();

                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }


//
//    public void translate(View view){
//        if (editText.getText().equals("Попугай")){
//                getView().findViewById(R.id.scrollViewLanguage).setVisibility(View.INVISIBLE);
//        }
//    }
}
