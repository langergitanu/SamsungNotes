package androidx.picker.app;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.util.SeslMisc;
import androidx.picker.C3623R;
import androidx.picker.util.SeslAnimationListener;
import androidx.picker.widget.SeslTimePicker;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(24)
public class SeslTimePickerDialog extends AlertDialog implements DialogInterface.OnClickListener, SeslTimePicker.OnTimeChangedListener {
    private static final String HOUR = "hour";
    private static final String IS_24_HOUR = "is24hour";
    private static final String MINUTE = "minute";
    private final View.OnFocusChangeListener mBtnFocusChangeListener;
    private InputMethodManager mImm;
    private final int mInitialHourOfDay;
    private final int mInitialMinute;
    private final boolean mIs24HourView;
    private boolean mIsStartAnimation;
    private final SeslTimePicker mTimePicker;
    private final OnTimeSetListener mTimeSetListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnTimeSetListener {
        void onTimeSet(SeslTimePicker seslTimePicker, int i, int i2);
    }

    public SeslTimePickerDialog(Context context, OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        this(context, 0, onTimeSetListener, i, i2, z);
    }

    public static int resolveDialogTheme(Context context, int i) {
        return i == 0 ? SeslMisc.isLightTheme(context) ? C3623R.style.Theme_AppCompat_Light_PickerDialog_TimePicker : C3623R.style.Theme_AppCompat_PickerDialog_TimePicker : i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -2) {
            InputMethodManager inputMethodManager = this.mImm;
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
            }
            cancel();
            return;
        }
        if (i == -1 && !this.mIsStartAnimation) {
            if (this.mTimeSetListener != null) {
                this.mTimePicker.clearFocus();
                OnTimeSetListener onTimeSetListener = this.mTimeSetListener;
                SeslTimePicker seslTimePicker = this.mTimePicker;
                onTimeSetListener.onTimeSet(seslTimePicker, seslTimePicker.getHour(), this.mTimePicker.getMinute());
            }
            InputMethodManager inputMethodManager2 = this.mImm;
            if (inputMethodManager2 != null) {
                inputMethodManager2.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
            }
            dismiss();
        }
    }

    @Override // androidx.appcompat.app.AlertDialog, androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getButton(-1).setOnFocusChangeListener(this.mBtnFocusChangeListener);
        getButton(-2).setOnFocusChangeListener(this.mBtnFocusChangeListener);
        this.mIsStartAnimation = true;
        this.mTimePicker.startAnimation(283, new SeslAnimationListener() { // from class: androidx.picker.app.SeslTimePickerDialog.2
            @Override // androidx.picker.util.SeslAnimationListener
            public void onAnimationEnd() {
                SeslTimePickerDialog.this.mIsStartAnimation = false;
            }
        });
    }

    @Override // android.app.Dialog
    public void onRestoreInstanceState(@NonNull Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        int i = bundle.getInt(HOUR);
        int i2 = bundle.getInt(MINUTE);
        this.mTimePicker.setIs24HourView(Boolean.valueOf(bundle.getBoolean(IS_24_HOUR)));
        this.mTimePicker.setHour(i);
        this.mTimePicker.setMinute(i2);
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    @NonNull
    public Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        bundleOnSaveInstanceState.putInt(HOUR, this.mTimePicker.getHour());
        bundleOnSaveInstanceState.putInt(MINUTE, this.mTimePicker.getMinute());
        bundleOnSaveInstanceState.putBoolean(IS_24_HOUR, this.mTimePicker.is24HourView());
        return bundleOnSaveInstanceState;
    }

    public void updateTime(int i, int i2) {
        this.mTimePicker.setHour(i);
        this.mTimePicker.setMinute(i2);
    }

    public SeslTimePickerDialog(@NonNull Context context, int i, @Nullable OnTimeSetListener onTimeSetListener, int i2, int i4, boolean z) {
        super(context, resolveDialogTheme(context, i));
        this.mBtnFocusChangeListener = new View.OnFocusChangeListener() { // from class: androidx.picker.app.SeslTimePickerDialog.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z2) {
                if (SeslTimePickerDialog.this.mTimePicker.isEditTextMode() && z2) {
                    SeslTimePickerDialog.this.mTimePicker.setEditTextMode(false);
                }
            }
        };
        this.mTimeSetListener = onTimeSetListener;
        this.mInitialHourOfDay = i2;
        this.mInitialMinute = i4;
        this.mIs24HourView = z;
        Context context2 = getContext();
        View viewInflate = LayoutInflater.from(context2).inflate(C3623R.layout.sesl_time_picker_spinner_dialog, (ViewGroup) null);
        setView(viewInflate);
        setButton(-1, context2.getString(C3623R.string.sesl_picker_done), this);
        setButton(-2, context2.getString(C3623R.string.sesl_picker_cancel), this);
        seslSetBackgroundBlurEnabled(true);
        SeslTimePicker seslTimePicker = (SeslTimePicker) viewInflate.findViewById(C3623R.id.timePicker);
        this.mTimePicker = seslTimePicker;
        seslTimePicker.setIs24HourView(Boolean.valueOf(z));
        seslTimePicker.setHour(i2);
        seslTimePicker.setMinute(i4);
        seslTimePicker.setOnTimeChangedListener(this);
        setTitle(C3623R.string.sesl_time_picker_set_title);
        this.mImm = (InputMethodManager) getContext().getSystemService("input_method");
    }

    @Override // androidx.picker.widget.SeslTimePicker.OnTimeChangedListener
    public void onTimeChanged(@NonNull SeslTimePicker seslTimePicker, int i, int i2) {
    }
}
