package com.melardev.tutorialstheming;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityDialogFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_fragment);
    }

    public void showDialog(View view) {
        PromptDialogFragment dialog = new PromptDialogFragment();
        dialog.setCancelable(true);
        dialog.show(getSupportFragmentManager(), "tag");
    }

    public static class PromptDialogFragment extends DialogFragment implements View.OnClickListener {

        private Button btnCancel;
        private Button btnOk;
        private EditText etxtPrompt;

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            etxtPrompt = (EditText) view.findViewById(R.id.etxtPrompDialog);
            btnOk = (Button) view.findViewById(R.id.btnOk);
            btnCancel = (Button) view.findViewById(R.id.btnCancel);

            btnOk.setOnClickListener(this);
            btnCancel.setOnClickListener(this);

        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.prompt_dialog, container, false);
        }

        @Override
        public void onClick(View view) {
            if (view == btnOk) {
                Toast.makeText(getActivity(), etxtPrompt.getText().toString().trim(), Toast.LENGTH_SHORT).show();
            } else if (view == btnCancel) {
                Toast.makeText(getActivity(), "Cancel clicked", Toast.LENGTH_SHORT).show();
            }
            dismiss();
        }

    }
}
