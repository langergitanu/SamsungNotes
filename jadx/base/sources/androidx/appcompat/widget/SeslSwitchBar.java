package androidx.appcompat.widget;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.appcompat.C0419R;
import androidx.appcompat.animation.SeslAnimationUtils;
import androidx.appcompat.graphics.drawable.SeslRecoilDrawable;
import androidx.appcompat.util.SeslMisc;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.ArrayList;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
public class SeslSwitchBar extends LinearLayout implements CompoundButton.OnCheckedChangeListener {
    private LinearLayout mBackground;

    @ColorInt
    private int mBackgroundActivatedColor;

    @ColorInt
    private int mBackgroundColor;
    private ValueAnimator mBackgroundColorInAnimator;
    private ValueAnimator mBackgroundColorOutAnimator;
    private SwitchBarDelegate mDelegate;
    private String mLabel;

    @ColorInt
    private int mOffTextColor;

    @StringRes
    private int mOffTextId;

    @ColorInt
    private int mOnTextColor;

    @StringRes
    private int mOnTextId;
    private SeslProgressBar mProgressBar;
    private String mSessionDesc;
    private SeslToggleSwitch mSwitch;
    private final List<OnSwitchChangeListener> mSwitchChangeListeners;
    private TextView mTextView;
    private static final int SWITCH_ON_STRING_RESOURCE_ID = C0419R.string.sesl_switchbar_on_text;
    private static final int SWITCH_OFF_STRING_RESOURCE_ID = C0419R.string.sesl_switchbar_off_text;
    private static final Long BACKGROUND_COLOR_CHANGE_DURATION = 350L;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnSwitchChangeListener {
        void onSwitchChanged(SwitchCompat switchCompat, boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.appcompat.widget.SeslSwitchBar.SavedState.1
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
        boolean checked;
        boolean visible;

        public String toString() {
            StringBuilder sb = new StringBuilder("SeslSwitchBar.SavedState{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" checked=");
            sb.append(this.checked);
            sb.append(" visible=");
            return AbstractC0000a.m14k(sb, this.visible, "}");
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.checked));
            parcel.writeValue(Boolean.valueOf(this.visible));
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.checked = ((Boolean) parcel.readValue(null)).booleanValue();
            this.visible = ((Boolean) parcel.readValue(null)).booleanValue();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SwitchBarDelegate extends AccessibilityDelegateCompat {
        private String mSessionName = "";
        private SeslToggleSwitch mSwitch;
        private TextView mText;

        public SwitchBarDelegate(View view) {
            this.mText = (TextView) view.findViewById(C0419R.id.sesl_switchbar_text);
            this.mSwitch = (SeslToggleSwitch) view.findViewById(C0419R.id.sesl_switchbar_switch);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            this.mSwitch.setContentDescription(this.mText.getText());
            if (TextUtils.isEmpty(this.mSessionName)) {
                return;
            }
            accessibilityNodeInfoCompat.setText(this.mSessionName);
        }

        public void setSessionName(String str) {
            this.mSessionName = str;
        }
    }

    public SeslSwitchBar(Context context) {
        this(context, null);
    }

    private String getActivityTitle() {
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                CharSequence title = ((Activity) context).getTitle();
                return title != null ? title.toString() : "";
            }
        }
        return "";
    }

    private void initBackgroundColorAnimator() {
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(this.mBackgroundColor), Integer.valueOf(this.mBackgroundActivatedColor));
        this.mBackgroundColorInAnimator = valueAnimatorOfObject;
        Long l = BACKGROUND_COLOR_CHANGE_DURATION;
        valueAnimatorOfObject.setDuration(l.longValue());
        ValueAnimator valueAnimator = this.mBackgroundColorInAnimator;
        Interpolator interpolator = SeslAnimationUtils.SINE_OUT_33;
        valueAnimator.setInterpolator(interpolator);
        final int i = 0;
        this.mBackgroundColorInAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: androidx.appcompat.widget.g

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ SeslSwitchBar f951b;

            {
                this.f951b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                switch (i) {
                    case 0:
                        this.f951b.lambda$initBackgroundColorAnimator$0(valueAnimator2);
                        break;
                    default:
                        this.f951b.lambda$initBackgroundColorAnimator$1(valueAnimator2);
                        break;
                }
            }
        });
        ValueAnimator valueAnimatorOfObject2 = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(this.mBackgroundActivatedColor), Integer.valueOf(this.mBackgroundColor));
        this.mBackgroundColorOutAnimator = valueAnimatorOfObject2;
        valueAnimatorOfObject2.setDuration(l.longValue());
        this.mBackgroundColorOutAnimator.setInterpolator(interpolator);
        final int i2 = 1;
        this.mBackgroundColorOutAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: androidx.appcompat.widget.g

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ SeslSwitchBar f951b;

            {
                this.f951b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                switch (i2) {
                    case 0:
                        this.f951b.lambda$initBackgroundColorAnimator$0(valueAnimator2);
                        break;
                    default:
                        this.f951b.lambda$initBackgroundColorAnimator$1(valueAnimator2);
                        break;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initBackgroundColorAnimator$0(ValueAnimator valueAnimator) {
        setSwitchBarBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initBackgroundColorAnimator$1(ValueAnimator valueAnimator) {
        setSwitchBarBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }

    private void propagateChecked(boolean z) {
        int size = this.mSwitchChangeListeners.size();
        for (int i = 0; i < size; i++) {
            this.mSwitchChangeListeners.get(i).onSwitchChanged(this.mSwitch, z);
        }
    }

    private void setSwitchBarBackgroundColor(@ColorInt int i) {
        LinearLayout linearLayout = this.mBackground;
        if (linearLayout != null) {
            Drawable drawableMutate = DrawableCompat.wrap(linearLayout.getBackground().mutate()).mutate();
            if (!(drawableMutate instanceof SeslRecoilDrawable)) {
                DrawableCompat.setTintList(drawableMutate, ColorStateList.valueOf(i));
                return;
            }
            SeslRecoilDrawable seslRecoilDrawable = (SeslRecoilDrawable) drawableMutate;
            if (seslRecoilDrawable.getNumberOfLayers() > 0) {
                Drawable drawable = seslRecoilDrawable.getDrawable(0);
                if (drawable instanceof GradientDrawable) {
                    ((GradientDrawable) drawable).setColor(i);
                }
            }
        }
    }

    public void addOnSwitchChangeListener(OnSwitchChangeListener onSwitchChangeListener) {
        if (this.mSwitchChangeListeners.contains(onSwitchChangeListener)) {
            throw new IllegalStateException("Cannot add twice the same OnSwitchChangeListener");
        }
        this.mSwitchChangeListeners.add(onSwitchChangeListener);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return SeslSwitchBar.class.getName();
    }

    public final SeslToggleSwitch getSwitch() {
        return this.mSwitch;
    }

    public void hide() {
        if (isShowing()) {
            setVisibility(8);
            this.mSwitch.setOnCheckedChangeListener(null);
        }
        this.mDelegate.setSessionName(" ");
        this.mSessionDesc = null;
    }

    public boolean isChecked() {
        return this.mSwitch.isChecked();
    }

    public boolean isShowing() {
        return getVisibility() == 0;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        propagateChecked(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.mBackgroundColorInAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator2 = this.mBackgroundColorOutAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllUpdateListeners();
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mSwitch.setCheckedInternal(savedState.checked);
        setTextViewLabelAndBackground(savedState.checked, false);
        setVisibility(savedState.visible ? 0 : 8);
        this.mSwitch.setOnCheckedChangeListener(savedState.visible ? this : null);
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.checked = this.mSwitch.isChecked();
        savedState.visible = isShowing();
        return savedState;
    }

    @Override // android.view.View
    public boolean performClick() {
        return this.mSwitch.performClick();
    }

    public void removeOnSwitchChangeListener(OnSwitchChangeListener onSwitchChangeListener) {
        if (!this.mSwitchChangeListeners.contains(onSwitchChangeListener)) {
            throw new IllegalStateException("Cannot remove OnSwitchChangeListener");
        }
        this.mSwitchChangeListeners.remove(onSwitchChangeListener);
    }

    public void setChecked(boolean z) {
        setTextViewLabelAndBackground(z, false);
        this.mSwitch.setChecked(z);
    }

    public void setCheckedInternal(boolean z) {
        setTextViewLabelAndBackground(z, false);
        this.mSwitch.setCheckedInternal(z);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.mTextView.setEnabled(z);
        this.mSwitch.setEnabled(z);
        this.mBackground.setEnabled(z);
        setTextViewLabelAndBackground(isChecked(), false);
    }

    public void setProgressBarVisible(boolean z) {
        try {
            this.mProgressBar.setVisibility(z ? 0 : 8);
        } catch (IndexOutOfBoundsException e) {
            Log.i("SetProgressBarVisible", "Invalid argument" + e);
        }
    }

    public void setSessionDescription(String str) {
        this.mSessionDesc = str;
        this.mDelegate.setSessionName(str);
    }

    public void setSwitchBarText(int i, int i2) {
        this.mOnTextId = i;
        this.mOffTextId = i2;
        setTextViewLabelAndBackground(isChecked(), false);
    }

    public void setTextViewLabel(boolean z) {
        String string = getResources().getString(z ? this.mOnTextId : this.mOffTextId);
        this.mLabel = string;
        this.mTextView.setText(string);
    }

    public void setTextViewLabelAndBackground(boolean z, boolean z2) {
        this.mLabel = getResources().getString(z ? this.mOnTextId : this.mOffTextId);
        if (z2) {
            if (this.mBackgroundColorInAnimator == null || this.mBackgroundColorOutAnimator == null) {
                initBackgroundColorAnimator();
            }
            if (z) {
                if (this.mBackgroundColorOutAnimator.isRunning()) {
                    this.mBackgroundColorOutAnimator.cancel();
                }
                this.mBackgroundColorInAnimator.start();
            } else {
                if (this.mBackgroundColorInAnimator.isRunning()) {
                    this.mBackgroundColorInAnimator.cancel();
                }
                this.mBackgroundColorOutAnimator.start();
            }
        } else {
            setSwitchBarBackgroundColor(z ? this.mBackgroundActivatedColor : this.mBackgroundColor);
        }
        this.mTextView.setTextColor(z ? this.mOnTextColor : this.mOffTextColor);
        if (isEnabled()) {
            this.mTextView.setAlpha(1.0f);
        } else if (SeslMisc.isLightTheme(getContext()) && z) {
            this.mTextView.setAlpha(0.55f);
        } else {
            this.mTextView.setAlpha(0.4f);
        }
        String str = this.mLabel;
        if (str == null || !str.contentEquals(this.mTextView.getText())) {
            this.mTextView.setText(this.mLabel);
        }
    }

    public void show() {
        if (!isShowing()) {
            setVisibility(0);
            this.mSwitch.setOnCheckedChangeListener(this);
        }
        if (TextUtils.isEmpty(this.mSessionDesc)) {
            this.mDelegate.setSessionName(getActivityTitle());
        } else {
            this.mDelegate.setSessionName(this.mSessionDesc);
        }
    }

    public void updateHorizontalMargins() {
        Resources resources = getResources();
        TextView textView = this.mTextView;
        if (textView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.setMarginStart((int) resources.getDimension(C0419R.dimen.sesl_switchbar_margin_start));
            this.mTextView.setLayoutParams(marginLayoutParams);
        }
        SeslToggleSwitch seslToggleSwitch = this.mSwitch;
        if (seslToggleSwitch != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) seslToggleSwitch.getLayoutParams();
            marginLayoutParams2.setMarginEnd((int) resources.getDimension(C0419R.dimen.sesl_switchbar_margin_end));
            this.mSwitch.setLayoutParams(marginLayoutParams2);
        }
    }

    public SeslSwitchBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0419R.attr.seslSwitchBarStyle);
    }

    public SeslSwitchBar(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public SeslSwitchBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mSwitchChangeListeners = new ArrayList();
        this.mSessionDesc = null;
        LayoutInflater.from(context).inflate(C0419R.layout.sesl_switchbar, this);
        Resources resources = getResources();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0419R.styleable.SeslSwitchBar, i, i2);
        this.mBackgroundColor = typedArrayObtainStyledAttributes.getColor(C0419R.styleable.SeslSwitchBar_seslSwitchBarBackgroundColor, resources.getColor(C0419R.color.sesl_switchbar_off_background_color_light));
        this.mBackgroundActivatedColor = typedArrayObtainStyledAttributes.getColor(C0419R.styleable.SeslSwitchBar_seslSwitchBarBackgroundActivatedColor, resources.getColor(C0419R.color.sesl_switchbar_on_background_color_light));
        this.mOnTextColor = typedArrayObtainStyledAttributes.getColor(C0419R.styleable.SeslSwitchBar_seslSwitchBarTextActivatedColor, resources.getColor(C0419R.color.sesl_switchbar_on_text_color_light));
        this.mOffTextColor = typedArrayObtainStyledAttributes.getColor(C0419R.styleable.SeslSwitchBar_seslSwitchBarTextColor, resources.getColor(C0419R.color.sesl_switchbar_on_text_color_light));
        typedArrayObtainStyledAttributes.recycle();
        this.mProgressBar = (SeslProgressBar) findViewById(C0419R.id.sesl_switchbar_progress);
        LinearLayout linearLayout = (LinearLayout) findViewById(C0419R.id.sesl_switchbar_container);
        this.mBackground = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.widget.SeslSwitchBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SeslSwitchBar.this.mSwitch == null || !SeslSwitchBar.this.mSwitch.isEnabled()) {
                    return;
                }
                SeslSwitchBar.this.mSwitch.setChecked(!SeslSwitchBar.this.mSwitch.isChecked());
            }
        });
        initBackgroundColorAnimator();
        this.mOnTextId = SWITCH_ON_STRING_RESOURCE_ID;
        this.mOffTextId = SWITCH_OFF_STRING_RESOURCE_ID;
        TextView textView = (TextView) findViewById(C0419R.id.sesl_switchbar_text);
        this.mTextView = textView;
        ((ViewGroup.MarginLayoutParams) textView.getLayoutParams()).setMarginStart((int) resources.getDimension(C0419R.dimen.sesl_switchbar_margin_start));
        SeslToggleSwitch seslToggleSwitch = (SeslToggleSwitch) findViewById(C0419R.id.sesl_switchbar_switch);
        this.mSwitch = seslToggleSwitch;
        seslToggleSwitch.setSaveEnabled(false);
        this.mSwitch.setFocusable(false);
        this.mSwitch.setClickable(false);
        this.mSwitch.setOnCheckedChangeListener(this);
        setSwitchBarText(this.mOnTextId, this.mOffTextId);
        addOnSwitchChangeListener(new OnSwitchChangeListener() { // from class: androidx.appcompat.widget.SeslSwitchBar.2
            @Override // androidx.appcompat.widget.SeslSwitchBar.OnSwitchChangeListener
            public void onSwitchChanged(SwitchCompat switchCompat, boolean z) {
                SeslSwitchBar.this.setTextViewLabelAndBackground(z, true);
            }
        });
        ((ViewGroup.MarginLayoutParams) this.mSwitch.getLayoutParams()).setMarginEnd((int) resources.getDimension(C0419R.dimen.sesl_switchbar_margin_end));
        SwitchBarDelegate switchBarDelegate = new SwitchBarDelegate(this);
        this.mDelegate = switchBarDelegate;
        ViewCompat.setAccessibilityDelegate(this.mBackground, switchBarDelegate);
        setSessionDescription(getActivityTitle());
    }
}
