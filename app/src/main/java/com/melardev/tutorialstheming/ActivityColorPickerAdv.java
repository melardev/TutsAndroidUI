package com.melardev.tutorialstheming;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.larswerkman.holocolorpicker.ColorPicker;
import com.larswerkman.holocolorpicker.OpacityBar;
import com.larswerkman.holocolorpicker.SVBar;
import com.larswerkman.holocolorpicker.SaturationBar;
import com.larswerkman.holocolorpicker.ValueBar;

public class ActivityColorPickerAdv extends AppCompatActivity {

    TextView txtColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker_adv);

        Button btnPick = (Button) findViewById(R.id.btnColorPick);
        txtColor = (TextView) findViewById(R.id.txtColorPicked);

        btnPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragColorPicker dialog = new DialogFragColorPicker();
                //dialog.setCancelable(false);
                dialog.show(getSupportFragmentManager(), null);
            }
        });
    }

    private void onColorChoosed(int color) {
        txtColor.setBackgroundColor(color);
    }

    public static class DialogFragColorPicker extends DialogFragment implements View.OnClickListener {

        public int opacity;
        private int saturation;
        private int value;
        private int color;
        private Button btnOk;
        private Button btnCancel;

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.frag_color_picker, container, false);
            ColorPicker picker = (ColorPicker) view.findViewById(R.id.picker);

            SVBar svBar = (SVBar) view.findViewById(R.id.svbar);
            OpacityBar opacityBar = (OpacityBar) view.findViewById(R.id.opacitybar);
            SaturationBar saturationBar = (SaturationBar) view.findViewById(R.id.saturationbar);
            ValueBar valueBar = (ValueBar) view.findViewById(R.id.valuebar);

            btnOk = (Button) view.findViewById(R.id.btnOk);
            btnCancel = (Button) view.findViewById(R.id.btnCancel);

            btnOk.setOnClickListener(this);
            btnCancel.setOnClickListener(this);

            picker.addSVBar(svBar);
            picker.addOpacityBar(opacityBar);
            picker.addSaturationBar(saturationBar);
            picker.addValueBar(valueBar);

            picker.setOldCenterColor(picker.getColor());

            picker.setOnColorChangedListener(new ColorPicker.OnColorChangedListener() {
                @Override
                public void onColorChanged(int color) {
                    DialogFragColorPicker.this.color = color;
                }
            });

            picker.setShowOldCenterColor(false);

            opacityBar.setOnOpacityChangedListener(new OpacityBar.OnOpacityChangedListener() {
                @Override
                public void onOpacityChanged(int opacity) {
                    DialogFragColorPicker.this.opacity = opacity;
                }
            });

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
                valueBar.setOnValueChangedListener(new ValueBar.OnValueChangedListener() {
                    @Override
                    public void onValueChanged(int value) {
                        DialogFragColorPicker.this.value = value;
                    }
                });
            } else
                valueBar.setVisibility(View.GONE);

            saturationBar.setOnSaturationChangedListener(new SaturationBar.OnSaturationChangedListener() {
                @Override
                public void onSaturationChanged(int saturation) {
                    DialogFragColorPicker.this.saturation = saturation;
                }
            });
            return view;
        }

        @Override
        public void onClick(View view) {
            if (view == btnOk) {
                ((ActivityColorPickerAdv) getActivity()).onColorChoosed(color);
                dismiss();
            } else if (view == btnCancel) {
                dismiss();
            }
        }
    }
}
