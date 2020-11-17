package com.example.areaandvolume;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogMessage extends DialogFragment implements View.OnClickListener {

    public static DialogMessage Dialog(){
        DialogMessage dialog = new DialogMessage();
        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_layout, container);

        return view;
    }

    @Override
    public void onClick(View v) {

    }
}
