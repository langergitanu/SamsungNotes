package androidx.preference;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.C0419R;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.SeslArrayAdapter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
public class DropDownPreference extends ListPreference {
    private final ArrayAdapter mAdapter;
    private final Context mContext;
    private final AdapterView.OnItemSelectedListener mItemSelectedListener;
    private AppCompatSpinner mSpinner;

    public DropDownPreference(@NonNull Context context) {
        this(context, null);
    }

    private int findSpinnerIndexOfValue(String str) {
        CharSequence[] entryValues = getEntryValues();
        if (str == null || entryValues == null) {
            return -1;
        }
        for (int length = entryValues.length - 1; length >= 0; length--) {
            if (TextUtils.equals(entryValues[length].toString(), str)) {
                return length;
            }
        }
        return -1;
    }

    private void updateEntries() {
        this.mAdapter.clear();
        if (getEntries() != null) {
            for (CharSequence charSequence : getEntries()) {
                this.mAdapter.add(charSequence.toString());
            }
        }
    }

    @NonNull
    public ArrayAdapter createAdapter() {
        return new SeslArrayAdapter(this.mContext, C0419R.layout.support_simple_spinner_dropdown_item);
    }

    @Override // androidx.preference.Preference
    public void notifyChanged() {
        super.notifyChanged();
        ArrayAdapter arrayAdapter = this.mAdapter;
        if (arrayAdapter != null) {
            arrayAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(@NonNull PreferenceViewHolder preferenceViewHolder) {
        AppCompatSpinner appCompatSpinner = (AppCompatSpinner) preferenceViewHolder.itemView.findViewById(C3711R.id.spinner);
        this.mSpinner = appCompatSpinner;
        appCompatSpinner.setSoundEffectsEnabled(false);
        if (!this.mAdapter.equals(this.mSpinner.getAdapter())) {
            this.mSpinner.setAdapter((SpinnerAdapter) this.mAdapter);
        }
        this.mSpinner.setOnItemSelectedListener(this.mItemSelectedListener);
        this.mSpinner.setSelection(findSpinnerIndexOfValue(getValue()));
        super.onBindViewHolder(preferenceViewHolder);
    }

    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    public void onClick() {
        this.mSpinner.performClick();
    }

    public AppCompatSpinner seslGetSpinner() {
        return this.mSpinner;
    }

    @Override // androidx.preference.ListPreference
    public void setEntries(@NonNull CharSequence[] charSequenceArr) {
        super.setEntries(charSequenceArr);
        updateEntries();
    }

    @Override // androidx.preference.ListPreference
    public void setValueIndex(int i) {
        setValue(getEntryValues()[i].toString());
    }

    public DropDownPreference(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, C3711R.attr.dropdownPreferenceStyle);
    }

    public DropDownPreference(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public DropDownPreference(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mItemSelectedListener = new AdapterView.OnItemSelectedListener() { // from class: androidx.preference.DropDownPreference.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long j) {
                if (i4 >= 0) {
                    String string = DropDownPreference.this.getEntryValues()[i4].toString();
                    if (string.equals(DropDownPreference.this.getValue()) || !DropDownPreference.this.callChangeListener(string)) {
                        return;
                    }
                    DropDownPreference.this.setValue(string);
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        this.mContext = context;
        this.mAdapter = createAdapter();
        updateEntries();
    }
}
