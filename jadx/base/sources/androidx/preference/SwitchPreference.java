package androidx.preference;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import androidx.reflect.view.SeslHapticFeedbackConstantsReflector;
import androidx.reflect.view.SeslViewReflector;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
public class SwitchPreference extends TwoStatePreference {
    private static final boolean SUPPORT_TOUCH_FEEDBACK;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    static final int SWITCH_PREFERENCE_LAYOUT = 2;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    static final int SWITCH_PREFERENCE_LAYOUT_LARGE = 1;
    private final DummyClickListener mClickListener;
    private int mIsLargeLayout;
    private final Listener mListener;
    private CharSequence mSwitchOff;
    private CharSequence mSwitchOn;
    private int mWidth;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class DummyClickListener implements View.OnClickListener {
        private DummyClickListener() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SwitchPreference.this.callClickListener();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class Listener implements CompoundButton.OnCheckedChangeListener {
        public Listener() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (SwitchPreference.this.callChangeListener(Boolean.valueOf(z))) {
                SwitchPreference.this.setChecked(z);
            } else {
                compoundButton.setChecked(!z);
            }
        }
    }

    static {
        SUPPORT_TOUCH_FEEDBACK = Build.VERSION.SDK_INT >= 28;
    }

    public SwitchPreference(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mListener = new Listener();
        this.mWidth = 0;
        this.mClickListener = new DummyClickListener();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3711R.styleable.SwitchPreference, i, i2);
        this.mIsLargeLayout = 0;
        setSummaryOn(TypedArrayUtils.getString(typedArrayObtainStyledAttributes, C3711R.styleable.SwitchPreference_summaryOn, C3711R.styleable.SwitchPreference_android_summaryOn));
        setSummaryOff(TypedArrayUtils.getString(typedArrayObtainStyledAttributes, C3711R.styleable.SwitchPreference_summaryOff, C3711R.styleable.SwitchPreference_android_summaryOff));
        setSwitchTextOn(TypedArrayUtils.getString(typedArrayObtainStyledAttributes, C3711R.styleable.SwitchPreference_switchTextOn, C3711R.styleable.SwitchPreference_android_switchTextOn));
        setSwitchTextOff(TypedArrayUtils.getString(typedArrayObtainStyledAttributes, C3711R.styleable.SwitchPreference_switchTextOff, C3711R.styleable.SwitchPreference_android_switchTextOff));
        setDisableDependentsState(TypedArrayUtils.getBoolean(typedArrayObtainStyledAttributes, C3711R.styleable.SwitchPreference_disableDependentsState, C3711R.styleable.SwitchPreference_android_disableDependentsState, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    private boolean canHapticFeedback(boolean z, View view, SwitchCompat switchCompat) {
        return SUPPORT_TOUCH_FEEDBACK && z != switchCompat.isChecked() && view.hasWindowFocus() && SeslViewReflector.isVisibleToUser(view) && !view.isTemporarilyDetached();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void syncSwitchView(View view) {
        boolean z = view instanceof SwitchCompat;
        if (z) {
            ((SwitchCompat) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.mChecked);
        }
        if (z) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            switchCompat.setTextOn(this.mSwitchOn);
            switchCompat.setTextOff(this.mSwitchOff);
            switchCompat.setOnCheckedChangeListener(this.mListener);
            if (switchCompat.isClickable()) {
                switchCompat.setOnClickListener(this.mClickListener);
            }
            if (isTalkBackIsRunning()) {
                ViewCompat.setBackground(switchCompat, null);
                switchCompat.setClickable(false);
            }
        }
    }

    private void syncViewIfAccessibilityEnabled(View view) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        if (accessibilityManager == null || accessibilityManager.isEnabled()) {
            if (this.mIsLargeLayout != 1) {
                syncSwitchView(view.findViewById(android.R.id.switch_widget));
            }
            if (isTalkBackIsRunning()) {
                return;
            }
            syncSummaryView(view.findViewById(android.R.id.summary));
        }
    }

    private void updateLayout(View view) {
        View viewFindViewById = view.findViewById(C3711R.id.widget_frame);
        View viewFindViewById2 = view.findViewById(android.R.id.widget_frame);
        View viewFindViewById3 = view.findViewById(C3711R.id.switch_widget);
        View viewFindViewById4 = view.findViewById(android.R.id.switch_widget);
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = ((i > 320 || configuration.fontScale < 1.1f) && (i >= 411 || configuration.fontScale < 1.3f)) ? 2 : 1;
        if (i2 != 1) {
            if (this.mIsLargeLayout != i2) {
                this.mIsLargeLayout = i2;
                TextView textView = (TextView) view.findViewById(android.R.id.title);
                viewFindViewById2.setVisibility(0);
                viewFindViewById.setVisibility(8);
                textView.requestLayout();
            }
            syncSwitchView(viewFindViewById4);
            return;
        }
        this.mIsLargeLayout = i2;
        TextView textView2 = (TextView) view.findViewById(android.R.id.title);
        float fMeasureText = textView2.getPaint().measureText(textView2.getText().toString());
        TextView textView3 = (TextView) view.findViewById(android.R.id.summary);
        float fMeasureText2 = textView3.getPaint().measureText(textView3.getText().toString());
        if (textView3.getVisibility() == 8) {
            fMeasureText2 = 0.0f;
        }
        float paddingEnd = ((this.mWidth - view.getPaddingEnd()) - view.getPaddingStart()) - getContext().getResources().getDimensionPixelSize(C3711R.dimen.sesl_preference_item_switch_size);
        if (fMeasureText >= paddingEnd || fMeasureText2 >= paddingEnd) {
            viewFindViewById.setVisibility(0);
            viewFindViewById2.setVisibility(8);
            textView2.requestLayout();
            SwitchCompat switchCompat = (SwitchCompat) viewFindViewById3;
            if (!switchCompat.canHapticFeedback(this.mChecked) && canHapticFeedback(this.mChecked, view, switchCompat)) {
                switchCompat.performHapticFeedback(SeslHapticFeedbackConstantsReflector.semGetVibrationIndex(27));
            }
            syncSwitchView(viewFindViewById3);
            SwitchCompat switchCompat2 = (SwitchCompat) viewFindViewById4;
            switchCompat2.setOnCheckedChangeListener(null);
            switchCompat2.setCheckedWithoutAnimation(this.mChecked);
            return;
        }
        viewFindViewById2.setVisibility(0);
        viewFindViewById.setVisibility(8);
        textView2.requestLayout();
        SwitchCompat switchCompat3 = (SwitchCompat) viewFindViewById4;
        if (!switchCompat3.canHapticFeedback(this.mChecked) && canHapticFeedback(this.mChecked, view, switchCompat3)) {
            switchCompat3.performHapticFeedback(SeslHapticFeedbackConstantsReflector.semGetVibrationIndex(27));
        }
        syncSwitchView(viewFindViewById4);
        SwitchCompat switchCompat4 = (SwitchCompat) viewFindViewById3;
        switchCompat4.setOnCheckedChangeListener(null);
        switchCompat4.setCheckedWithoutAnimation(this.mChecked);
    }

    @Nullable
    public CharSequence getSwitchTextOff() {
        return this.mSwitchOff;
    }

    @Nullable
    public CharSequence getSwitchTextOn() {
        return this.mSwitchOn;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder, int i) {
        this.mWidth = i;
        onBindViewHolder(preferenceViewHolder);
        updateLayout(preferenceViewHolder.itemView);
    }

    @Override // androidx.preference.Preference
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void performClick(@NonNull View view) {
        super.performClick(view);
        syncViewIfAccessibilityEnabled(view);
    }

    public void setSwitchTextOff(@Nullable CharSequence charSequence) {
        this.mSwitchOff = charSequence;
        notifyChanged();
    }

    public void setSwitchTextOn(@Nullable CharSequence charSequence) {
        this.mSwitchOn = charSequence;
        notifyChanged();
    }

    public void setSwitchTextOff(int i) {
        setSwitchTextOff(getContext().getString(i));
    }

    public void setSwitchTextOn(int i) {
        setSwitchTextOn(getContext().getString(i));
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(@NonNull PreferenceViewHolder preferenceViewHolder) {
        super.onBindViewHolder(preferenceViewHolder);
        if (this.mIsLargeLayout != 1) {
            syncSwitchView(preferenceViewHolder.findViewById(android.R.id.switch_widget));
        }
        syncSummaryView(preferenceViewHolder);
    }

    public SwitchPreference(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public SwitchPreference(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.getAttr(context, C3711R.attr.switchPreferenceStyle, android.R.attr.switchPreferenceStyle));
    }

    public SwitchPreference(@NonNull Context context) {
        this(context, null);
    }
}
