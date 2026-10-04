package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.SeslSeekBar;
import androidx.preference.Preference;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(24)
public class SeekBarPreference extends Preference {
    private static final String TAG = "SeekBarPreference";
    boolean mAdjustable;
    private int mMax;
    int mMin;
    private OnSeekBarPreferenceChangeListener mOnSeekBarPreferenceChangeListener;
    SeslSeekBar mSeekBar;
    private final SeslSeekBar.OnSeekBarChangeListener mSeekBarChangeListener;
    private int mSeekBarIncrement;
    private final View.OnKeyListener mSeekBarKeyListener;
    int mSeekBarValue;
    private boolean mShowSeekBarValue;
    boolean mTrackingTouch;
    boolean mUpdatesContinuously;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnSeekBarPreferenceChangeListener {
        void onProgressChanged(SeslSeekBar seslSeekBar, int i, boolean z);

        void onStartTrackingTouch(SeslSeekBar seslSeekBar);

        void onStopTrackingTouch(SeslSeekBar seslSeekBar);
    }

    public SeekBarPreference(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mSeekBarChangeListener = new SeslSeekBar.OnSeekBarChangeListener() { // from class: androidx.preference.SeekBarPreference.1
            @Override // androidx.appcompat.widget.SeslSeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeslSeekBar seslSeekBar, int i4, boolean z) {
                if (z) {
                    SeekBarPreference seekBarPreference = SeekBarPreference.this;
                    if (seekBarPreference.mUpdatesContinuously || !seekBarPreference.mTrackingTouch) {
                        seekBarPreference.syncValueInternal(seslSeekBar);
                    }
                }
                if (SeekBarPreference.this.mOnSeekBarPreferenceChangeListener != null) {
                    SeekBarPreference.this.mOnSeekBarPreferenceChangeListener.onProgressChanged(seslSeekBar, i4, z);
                }
            }

            @Override // androidx.appcompat.widget.SeslSeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeslSeekBar seslSeekBar) {
                SeekBarPreference seekBarPreference = SeekBarPreference.this;
                seekBarPreference.mTrackingTouch = true;
                if (seekBarPreference.mOnSeekBarPreferenceChangeListener != null) {
                    SeekBarPreference.this.mOnSeekBarPreferenceChangeListener.onStartTrackingTouch(seslSeekBar);
                }
            }

            @Override // androidx.appcompat.widget.SeslSeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeslSeekBar seslSeekBar) {
                SeekBarPreference.this.mTrackingTouch = false;
                int progress = seslSeekBar.getProgress();
                SeekBarPreference seekBarPreference = SeekBarPreference.this;
                if (progress + seekBarPreference.mMin != seekBarPreference.mSeekBarValue) {
                    seekBarPreference.syncValueInternal(seslSeekBar);
                }
                if (SeekBarPreference.this.mOnSeekBarPreferenceChangeListener != null) {
                    SeekBarPreference.this.mOnSeekBarPreferenceChangeListener.onStopTrackingTouch(seslSeekBar);
                }
            }
        };
        this.mSeekBarKeyListener = new View.OnKeyListener() { // from class: androidx.preference.SeekBarPreference.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i4, KeyEvent keyEvent) {
                if (keyEvent.getAction() != 0) {
                    return false;
                }
                SeekBarPreference seekBarPreference = SeekBarPreference.this;
                if ((!seekBarPreference.mAdjustable && (i4 == 21 || i4 == 22)) || i4 == 23 || i4 == 66) {
                    return false;
                }
                SeslSeekBar seslSeekBar = seekBarPreference.mSeekBar;
                if (seslSeekBar != null) {
                    return seslSeekBar.onKeyDown(i4, keyEvent);
                }
                Log.e(SeekBarPreference.TAG, "SeekBar view is null and hence cannot be adjusted.");
                return false;
            }
        };
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3711R.styleable.SeekBarPreference, i, i2);
        this.mMin = typedArrayObtainStyledAttributes.getInt(C3711R.styleable.SeekBarPreference_min, 0);
        setMax(typedArrayObtainStyledAttributes.getInt(C3711R.styleable.SeekBarPreference_android_max, 100));
        setSeekBarIncrement(typedArrayObtainStyledAttributes.getInt(C3711R.styleable.SeekBarPreference_seekBarIncrement, 0));
        this.mAdjustable = typedArrayObtainStyledAttributes.getBoolean(C3711R.styleable.SeekBarPreference_adjustable, true);
        this.mShowSeekBarValue = typedArrayObtainStyledAttributes.getBoolean(C3711R.styleable.SeekBarPreference_showSeekBarValue, false);
        this.mUpdatesContinuously = typedArrayObtainStyledAttributes.getBoolean(C3711R.styleable.SeekBarPreference_updatesContinuously, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void setValueInternal(int i, boolean z) {
        int i2 = this.mMin;
        if (i < i2) {
            i = i2;
        }
        int i4 = this.mMax;
        if (i > i4) {
            i = i4;
        }
        if (i != this.mSeekBarValue) {
            this.mSeekBarValue = i;
            persistInt(i);
            if (z) {
                notifyChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void syncValueInternal(SeslSeekBar seslSeekBar) {
        int progress = seslSeekBar.getProgress() + this.mMin;
        if (progress != this.mSeekBarValue) {
            if (callChangeListener(Integer.valueOf(progress))) {
                setValueInternal(progress, false);
            } else {
                seslSeekBar.setProgress(this.mSeekBarValue - this.mMin);
            }
        }
    }

    public int getMax() {
        return this.mMax;
    }

    public int getMin() {
        return this.mMin;
    }

    public final int getSeekBarIncrement() {
        return this.mSeekBarIncrement;
    }

    public boolean getShowSeekBarValue() {
        return this.mShowSeekBarValue;
    }

    public boolean getUpdatesContinuously() {
        return this.mUpdatesContinuously;
    }

    public int getValue() {
        return this.mSeekBarValue;
    }

    public boolean isAdjustable() {
        return this.mAdjustable;
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(@NonNull PreferenceViewHolder preferenceViewHolder) {
        super.onBindViewHolder(preferenceViewHolder);
        preferenceViewHolder.itemView.setOnKeyListener(this.mSeekBarKeyListener);
        SeslSeekBar seslSeekBar = (SeslSeekBar) preferenceViewHolder.findViewById(C3711R.id.seekbar);
        this.mSeekBar = seslSeekBar;
        if (seslSeekBar == null) {
            Log.e(TAG, "SeekBar view is null in onBindViewHolder.");
            return;
        }
        seslSeekBar.setOnSeekBarChangeListener(this.mSeekBarChangeListener);
        this.mSeekBar.setMax(this.mMax - this.mMin);
        int i = this.mSeekBarIncrement;
        if (i != 0) {
            this.mSeekBar.setKeyProgressIncrement(i);
        } else {
            this.mSeekBarIncrement = this.mSeekBar.getKeyProgressIncrement();
        }
        this.mSeekBar.setProgress(this.mSeekBarValue - this.mMin);
        this.mSeekBar.setEnabled(isEnabled());
    }

    @Override // androidx.preference.Preference
    @Nullable
    public Object onGetDefaultValue(@NonNull TypedArray typedArray, int i) {
        return Integer.valueOf(typedArray.getInt(i, 0));
    }

    @Override // androidx.preference.Preference
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        SeslSeekBar seslSeekBar;
        if (keyEvent.getAction() == 0 && (seslSeekBar = (SeslSeekBar) view.findViewById(C3711R.id.seekbar)) != null) {
            return seslSeekBar.onKeyDown(i, keyEvent);
        }
        return false;
    }

    @Override // androidx.preference.Preference
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mSeekBarValue = savedState.mSeekBarValue;
        this.mMin = savedState.mMin;
        this.mMax = savedState.mMax;
        notifyChanged();
    }

    @Override // androidx.preference.Preference
    @Nullable
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return parcelableOnSaveInstanceState;
        }
        SavedState savedState = new SavedState(parcelableOnSaveInstanceState);
        savedState.mSeekBarValue = this.mSeekBarValue;
        savedState.mMin = this.mMin;
        savedState.mMax = this.mMax;
        return savedState;
    }

    @Override // androidx.preference.Preference
    public void onSetInitialValue(Object obj) {
        if (obj == null) {
            obj = 0;
        }
        setValue(getPersistedInt(((Integer) obj).intValue()));
    }

    public void setAdjustable(boolean z) {
        this.mAdjustable = z;
    }

    public final void setMax(int i) {
        int i2 = this.mMin;
        if (i < i2) {
            i = i2;
        }
        if (i != this.mMax) {
            this.mMax = i;
            notifyChanged();
        }
    }

    public void setMin(int i) {
        int i2 = this.mMax;
        if (i > i2) {
            i = i2;
        }
        if (i != this.mMin) {
            this.mMin = i;
            notifyChanged();
        }
    }

    public void setOnSeekBarPreferenceChangeListener(OnSeekBarPreferenceChangeListener onSeekBarPreferenceChangeListener) {
        this.mOnSeekBarPreferenceChangeListener = onSeekBarPreferenceChangeListener;
    }

    public final void setSeekBarIncrement(int i) {
        if (i != this.mSeekBarIncrement) {
            this.mSeekBarIncrement = Math.min(this.mMax - this.mMin, Math.abs(i));
            notifyChanged();
        }
    }

    public void setShowSeekBarValue(boolean z) {
        this.mShowSeekBarValue = z;
        notifyChanged();
    }

    public void setUpdatesContinuously(boolean z) {
        this.mUpdatesContinuously = z;
    }

    public void setValue(int i) {
        setValueInternal(i, true);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.preference.SeekBarPreference.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int mMax;
        int mMin;
        int mSeekBarValue;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.mSeekBarValue = parcel.readInt();
            this.mMin = parcel.readInt();
            this.mMax = parcel.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mSeekBarValue);
            parcel.writeInt(this.mMin);
            parcel.writeInt(this.mMax);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public SeekBarPreference(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public SeekBarPreference(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, C3711R.attr.seekBarPreferenceStyle);
    }

    public SeekBarPreference(@NonNull Context context) {
        this(context, null);
    }
}
