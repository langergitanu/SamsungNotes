package androidx.picker.app;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.util.SeslMisc;
import androidx.picker.C3623R;
import androidx.picker.widget.SeslDatePicker;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(24)
public class SeslDatePickerDialog extends AlertDialog implements DialogInterface.OnClickListener, SeslDatePicker.OnDateChangedListener {
    private static final String DAY = "day";
    private static final String MONTH = "month";
    private static final String YEAR = "year";
    private final View.OnFocusChangeListener mBtnFocusChangeListener;
    private final SeslDatePicker mDatePicker;
    private final OnDateSetListener mDateSetListener;
    private InputMethodManager mImm;
    private final SeslDatePicker.ValidationCallback mValidationCallback;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnDateSetListener {
        void onDateSet(SeslDatePicker seslDatePicker, int i, int i2, int i4);
    }

    public SeslDatePickerDialog(@NonNull Context context, @Nullable OnDateSetListener onDateSetListener, int i, int i2, int i4) {
        this(context, 0, onDateSetListener, i, i2, i4);
    }

    @StyleRes
    public static int resolveDialogTheme(@NonNull Context context, @StyleRes int i) {
        return i == 0 ? SeslMisc.isLightTheme(context) ? C3623R.style.Theme_AppCompat_Light_PickerDialog_DatePicker : C3623R.style.Theme_AppCompat_PickerDialog_DatePicker : i;
    }

    @NonNull
    public SeslDatePicker getDatePicker() {
        return this.mDatePicker;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(@NonNull DialogInterface dialogInterface, int i) {
        InputMethodManager inputMethodManager = this.mImm;
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
        }
        if (i == -2) {
            cancel();
            return;
        }
        if (i == -1 && this.mDateSetListener != null) {
            this.mDatePicker.clearFocus();
            OnDateSetListener onDateSetListener = this.mDateSetListener;
            SeslDatePicker seslDatePicker = this.mDatePicker;
            onDateSetListener.onDateSet(seslDatePicker, seslDatePicker.getYear(), this.mDatePicker.getMonth(), this.mDatePicker.getDayOfMonth());
        }
    }

    @Override // androidx.appcompat.app.AlertDialog, androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getButton(-1).setOnFocusChangeListener(this.mBtnFocusChangeListener);
        getButton(-2).setOnFocusChangeListener(this.mBtnFocusChangeListener);
    }

    @Override // android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.mDatePicker.init(bundle.getInt(YEAR), bundle.getInt(MONTH), bundle.getInt(DAY), this);
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        bundleOnSaveInstanceState.putInt(YEAR, this.mDatePicker.getYear());
        bundleOnSaveInstanceState.putInt(MONTH, this.mDatePicker.getMonth());
        bundleOnSaveInstanceState.putInt(DAY, this.mDatePicker.getDayOfMonth());
        return bundleOnSaveInstanceState;
    }

    public void updateDate(int i, int i2, int i4) {
        this.mDatePicker.updateDate(i, i2, i4);
    }

    public SeslDatePickerDialog(@NonNull Context context, @StyleRes int i, @Nullable OnDateSetListener onDateSetListener, int i2, int i4, int i5) {
        super(context, resolveDialogTheme(context, i));
        this.mBtnFocusChangeListener = new View.OnFocusChangeListener() { // from class: androidx.picker.app.SeslDatePickerDialog.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (SeslDatePickerDialog.this.mDatePicker.isEditTextMode() && z) {
                    SeslDatePickerDialog.this.mDatePicker.setEditTextMode(false);
                }
            }
        };
        SeslDatePicker.ValidationCallback validationCallback = new SeslDatePicker.ValidationCallback() { // from class: androidx.picker.app.SeslDatePickerDialog.2
            @Override // androidx.picker.widget.SeslDatePicker.ValidationCallback
            public void onValidationChanged(boolean z) {
                Button button = SeslDatePickerDialog.this.getButton(-1);
                if (button != null) {
                    button.setEnabled(z);
                }
            }
        };
        this.mValidationCallback = validationCallback;
        Context context2 = getContext();
        View viewInflate = LayoutInflater.from(context2).inflate(C3623R.layout.sesl_date_picker_dialog, (ViewGroup) null);
        setView(viewInflate);
        setButton(-1, context2.getString(C3623R.string.sesl_picker_done), this);
        setButton(-2, context2.getString(C3623R.string.sesl_picker_cancel), this);
        seslSetBackgroundBlurEnabled(true);
        SeslDatePicker seslDatePicker = (SeslDatePicker) viewInflate.findViewById(C3623R.id.sesl_datePicker);
        this.mDatePicker = seslDatePicker;
        seslDatePicker.init(i2, i4, i5, this);
        seslDatePicker.setValidationCallback(validationCallback);
        seslDatePicker.setDialogWindow(getWindow());
        seslDatePicker.setDialogPaddingVertical(viewInflate.getPaddingBottom() + viewInflate.getPaddingTop());
        this.mDateSetListener = onDateSetListener;
        this.mImm = (InputMethodManager) context2.getSystemService("input_method");
    }

    @Override // androidx.picker.widget.SeslDatePicker.OnDateChangedListener
    public void onDateChanged(SeslDatePicker seslDatePicker, int i, int i2, int i4) {
    }
}
