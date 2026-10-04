package com.samsung.android.support.senl.p148nt.app.settings.common.component;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.appcompat.widget.SeslProgressBar;
import androidx.preference.PreferenceViewHolder;
import androidx.preference.SeslSwitchPreferenceScreen;
import com.google.common.net.HttpHeaders;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.settings.common.utils.SettingsMenuUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001.B-\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\u000bB\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\fB\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\rJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0007H\u0017J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010$\u001a\u00020\u001fH\u0002J\u0006\u0010%\u001a\u00020\u001fJ\u0010\u0010&\u001a\u00020\u001f2\b\b\u0001\u0010'\u001a\u00020\u0007J\u0010\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020*H\u0016J\u0018\u0010+\u001a\u00020\u001f2\b\u0010,\u001a\u0004\u0018\u00010\u001c2\u0006\u0010-\u001a\u00020*R\u001a\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u001a\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u001a\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u0018\u0010\u0018\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsSwitchPreferenceScreen;", "Landroidx/preference/SeslSwitchPreferenceScreen;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "mWidgetFrame", "", "Landroid/view/ViewGroup;", "[Landroid/view/ViewGroup;", "mSwitchWidget", "Landroid/view/View;", "[Landroid/view/View;", "mProgressBar", "Landroidx/appcompat/widget/SeslProgressBar;", "[Landroidx/appcompat/widget/SeslProgressBar;", "mWidgetState", "getMWidgetState$annotations", "()V", "mSecondarySummary", "", "mSecondarySummaryColor", "onBindViewHolder", "", "holder", "Landroidx/preference/PreferenceViewHolder;", HttpHeaders.WIDTH, "initWidgetInfo", "setWidgetVisibility", "release", "setWidgetState", "widgetState", "setChecked", "checked", "", "setSecondarySummary", "secondarySummary", "isSummaryPrimaryColor", "WidgetState", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SettingsSwitchPreferenceScreen extends SeslSwitchPreferenceScreen {

    @Nullable
    private SeslProgressBar[] mProgressBar;

    @Nullable
    private String mSecondarySummary;

    @ColorInt
    private int mSecondarySummaryColor;

    @Nullable
    private View[] mSwitchWidget;

    @Nullable
    private ViewGroup[] mWidgetFrame;
    private int mWidgetState;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsSwitchPreferenceScreen$WidgetState;", "", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface WidgetState {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int None = 0;
        public static final int Progress = 1;
        public static final int Switch = 2;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsSwitchPreferenceScreen$WidgetState$Companion;", "", "<init>", "()V", "None", "", "Progress", "Switch", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int None = 0;
            public static final int Progress = 1;
            public static final int Switch = 2;

            private Companion() {
            }
        }
    }

    public SettingsSwitchPreferenceScreen(@Nullable Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @WidgetState
    private static /* synthetic */ void getMWidgetState$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initWidgetInfo(PreferenceViewHolder holder) {
        if (this.mWidgetFrame == null) {
            ViewGroup[] viewGroupArr = new ViewGroup[2];
            this.mWidgetFrame = viewGroupArr;
            Intrinsics.checkNotNull(viewGroupArr);
            View viewFindViewById = holder.findViewById(R.id.widget_frame);
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.view.ViewGroup");
            viewGroupArr[0] = viewFindViewById;
            ViewGroup[] viewGroupArr2 = this.mWidgetFrame;
            Intrinsics.checkNotNull(viewGroupArr2);
            View viewFindViewById2 = holder.findViewById(C8003R.id.widget_frame);
            Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.view.ViewGroup");
            viewGroupArr2[1] = viewFindViewById2;
        }
        if (this.mSwitchWidget == null) {
            View[] viewArr = new View[2];
            this.mSwitchWidget = viewArr;
            Intrinsics.checkNotNull(viewArr);
            ViewGroup[] viewGroupArr3 = this.mWidgetFrame;
            Intrinsics.checkNotNull(viewGroupArr3);
            ViewGroup viewGroup = viewGroupArr3[0];
            Intrinsics.checkNotNull(viewGroup);
            viewArr[0] = viewGroup.getChildAt(0);
            View[] viewArr2 = this.mSwitchWidget;
            Intrinsics.checkNotNull(viewArr2);
            ViewGroup[] viewGroupArr4 = this.mWidgetFrame;
            Intrinsics.checkNotNull(viewGroupArr4);
            ViewGroup viewGroup2 = viewGroupArr4[1];
            Intrinsics.checkNotNull(viewGroup2);
            viewArr2[1] = viewGroup2.getChildAt(0);
        }
        if (this.mProgressBar == null) {
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(C8003R.dimen.settings_sync_switch_preference_screen_progress_size);
            this.mProgressBar = new SeslProgressBar[2];
            ViewGroup[] viewGroupArr5 = this.mWidgetFrame;
            Intrinsics.checkNotNull(viewGroupArr5);
            ViewGroup viewGroup3 = viewGroupArr5[0];
            Intrinsics.checkNotNull(viewGroup3);
            if (viewGroup3.findViewById(C8003R.id.sync_switch_preference_progress) == null) {
                SeslProgressBar[] seslProgressBarArr = this.mProgressBar;
                Intrinsics.checkNotNull(seslProgressBarArr);
                seslProgressBarArr[0] = new SeslProgressBar(getContext());
                SeslProgressBar[] seslProgressBarArr2 = this.mProgressBar;
                Intrinsics.checkNotNull(seslProgressBarArr2);
                SeslProgressBar seslProgressBar = seslProgressBarArr2[0];
                Intrinsics.checkNotNull(seslProgressBar);
                seslProgressBar.setId(C8003R.id.sync_switch_preference_progress);
                ViewGroup[] viewGroupArr6 = this.mWidgetFrame;
                Intrinsics.checkNotNull(viewGroupArr6);
                ViewGroup viewGroup4 = viewGroupArr6[0];
                Intrinsics.checkNotNull(viewGroup4);
                SeslProgressBar[] seslProgressBarArr3 = this.mProgressBar;
                Intrinsics.checkNotNull(seslProgressBarArr3);
                viewGroup4.addView(seslProgressBarArr3[0], dimensionPixelSize, dimensionPixelSize);
                SeslProgressBar[] seslProgressBarArr4 = this.mProgressBar;
                Intrinsics.checkNotNull(seslProgressBarArr4);
                SeslProgressBar seslProgressBar2 = seslProgressBarArr4[0];
                Intrinsics.checkNotNull(seslProgressBar2);
                seslProgressBar2.setVisibility(8);
            }
            ViewGroup[] viewGroupArr7 = this.mWidgetFrame;
            Intrinsics.checkNotNull(viewGroupArr7);
            ViewGroup viewGroup5 = viewGroupArr7[1];
            Intrinsics.checkNotNull(viewGroup5);
            if (viewGroup5.findViewById(C8003R.id.sync_switch_preference_progress) == null) {
                SeslProgressBar[] seslProgressBarArr5 = this.mProgressBar;
                Intrinsics.checkNotNull(seslProgressBarArr5);
                seslProgressBarArr5[1] = new SeslProgressBar(getContext());
                SeslProgressBar[] seslProgressBarArr6 = this.mProgressBar;
                Intrinsics.checkNotNull(seslProgressBarArr6);
                SeslProgressBar seslProgressBar3 = seslProgressBarArr6[1];
                Intrinsics.checkNotNull(seslProgressBar3);
                seslProgressBar3.setId(C8003R.id.sync_switch_preference_progress);
                ViewGroup[] viewGroupArr8 = this.mWidgetFrame;
                Intrinsics.checkNotNull(viewGroupArr8);
                ViewGroup viewGroup6 = viewGroupArr8[1];
                Intrinsics.checkNotNull(viewGroup6);
                SeslProgressBar[] seslProgressBarArr7 = this.mProgressBar;
                Intrinsics.checkNotNull(seslProgressBarArr7);
                viewGroup6.addView(seslProgressBarArr7[1], dimensionPixelSize, dimensionPixelSize);
                SeslProgressBar[] seslProgressBarArr8 = this.mProgressBar;
                Intrinsics.checkNotNull(seslProgressBarArr8);
                SeslProgressBar seslProgressBar4 = seslProgressBarArr8[1];
                Intrinsics.checkNotNull(seslProgressBar4);
                seslProgressBar4.setVisibility(8);
            }
        }
    }

    private final void setWidgetVisibility() {
        View[] viewArr = this.mSwitchWidget;
        if (viewArr == null || this.mProgressBar == null) {
            return;
        }
        int i = this.mWidgetState;
        if (i == 2) {
            Intrinsics.checkNotNull(viewArr);
            View view = viewArr[0];
            Intrinsics.checkNotNull(view);
            view.setVisibility(0);
            View[] viewArr2 = this.mSwitchWidget;
            Intrinsics.checkNotNull(viewArr2);
            View view2 = viewArr2[1];
            Intrinsics.checkNotNull(view2);
            view2.setVisibility(0);
            SeslProgressBar[] seslProgressBarArr = this.mProgressBar;
            Intrinsics.checkNotNull(seslProgressBarArr);
            SeslProgressBar seslProgressBar = seslProgressBarArr[0];
            Intrinsics.checkNotNull(seslProgressBar);
            seslProgressBar.setVisibility(8);
            SeslProgressBar[] seslProgressBarArr2 = this.mProgressBar;
            Intrinsics.checkNotNull(seslProgressBarArr2);
            SeslProgressBar seslProgressBar2 = seslProgressBarArr2[1];
            Intrinsics.checkNotNull(seslProgressBar2);
            seslProgressBar2.setVisibility(8);
            return;
        }
        if (i == 1) {
            Intrinsics.checkNotNull(viewArr);
            View view3 = viewArr[0];
            Intrinsics.checkNotNull(view3);
            view3.setVisibility(8);
            View[] viewArr3 = this.mSwitchWidget;
            Intrinsics.checkNotNull(viewArr3);
            View view4 = viewArr3[1];
            Intrinsics.checkNotNull(view4);
            view4.setVisibility(8);
            SeslProgressBar[] seslProgressBarArr3 = this.mProgressBar;
            Intrinsics.checkNotNull(seslProgressBarArr3);
            SeslProgressBar seslProgressBar3 = seslProgressBarArr3[0];
            Intrinsics.checkNotNull(seslProgressBar3);
            seslProgressBar3.setVisibility(0);
            SeslProgressBar[] seslProgressBarArr4 = this.mProgressBar;
            Intrinsics.checkNotNull(seslProgressBarArr4);
            SeslProgressBar seslProgressBar4 = seslProgressBarArr4[1];
            Intrinsics.checkNotNull(seslProgressBar4);
            seslProgressBar4.setVisibility(0);
            return;
        }
        Intrinsics.checkNotNull(viewArr);
        View view5 = viewArr[0];
        Intrinsics.checkNotNull(view5);
        view5.setVisibility(8);
        View[] viewArr4 = this.mSwitchWidget;
        Intrinsics.checkNotNull(viewArr4);
        View view6 = viewArr4[1];
        Intrinsics.checkNotNull(view6);
        view6.setVisibility(8);
        SeslProgressBar[] seslProgressBarArr5 = this.mProgressBar;
        Intrinsics.checkNotNull(seslProgressBarArr5);
        SeslProgressBar seslProgressBar5 = seslProgressBarArr5[0];
        Intrinsics.checkNotNull(seslProgressBar5);
        seslProgressBar5.setVisibility(8);
        SeslProgressBar[] seslProgressBarArr6 = this.mProgressBar;
        Intrinsics.checkNotNull(seslProgressBarArr6);
        SeslProgressBar seslProgressBar6 = seslProgressBarArr6[1];
        Intrinsics.checkNotNull(seslProgressBar6);
        seslProgressBar6.setVisibility(8);
    }

    @Override // androidx.preference.SeslSwitchPreferenceScreen, androidx.preference.SwitchPreferenceCompat, androidx.preference.Preference
    public void onBindViewHolder(@NotNull PreferenceViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder(holder);
        initWidgetInfo(holder);
        setWidgetVisibility();
        TextView textView = (TextView) holder.findViewById(R.id.summary);
        if (textView != null) {
            if (TextUtils.isEmpty(this.mSecondarySummary)) {
                textView.setText(getSummary());
                return;
            }
            CharSequence summary = getSummary();
            String str = ((Object) summary) + System.lineSeparator();
            SpannableString spannableString = new SpannableString(AbstractC0541b.m756B(str, this.mSecondarySummary));
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(this.mSecondarySummaryColor);
            int length = str.length();
            int length2 = str.length();
            String str2 = this.mSecondarySummary;
            Intrinsics.checkNotNull(str2);
            spannableString.setSpan(foregroundColorSpan, length, str2.length() + length2, 33);
            textView.setText(spannableString, TextView.BufferType.SPANNABLE);
        }
    }

    public final void release() {
        if (this.mProgressBar != null) {
            ViewGroup[] viewGroupArr = this.mWidgetFrame;
            Intrinsics.checkNotNull(viewGroupArr);
            ViewGroup viewGroup = viewGroupArr[0];
            Intrinsics.checkNotNull(viewGroup);
            SeslProgressBar[] seslProgressBarArr = this.mProgressBar;
            Intrinsics.checkNotNull(seslProgressBarArr);
            viewGroup.removeView(seslProgressBarArr[0]);
            ViewGroup[] viewGroupArr2 = this.mWidgetFrame;
            Intrinsics.checkNotNull(viewGroupArr2);
            ViewGroup viewGroup2 = viewGroupArr2[1];
            Intrinsics.checkNotNull(viewGroup2);
            SeslProgressBar[] seslProgressBarArr2 = this.mProgressBar;
            Intrinsics.checkNotNull(seslProgressBarArr2);
            viewGroup2.removeView(seslProgressBarArr2[1]);
            this.mProgressBar = null;
        }
    }

    @Override // androidx.preference.TwoStatePreference
    public void setChecked(boolean checked) {
        seslSetSummaryColor(SettingsMenuUtils.getSummaryColor(getContext(), checked));
        super.setChecked(checked);
    }

    public final void setSecondarySummary(@Nullable String secondarySummary, boolean isSummaryPrimaryColor) {
        this.mSecondarySummary = secondarySummary;
        this.mSecondarySummaryColor = SettingsMenuUtils.getSummaryColor(getContext(), isSummaryPrimaryColor);
    }

    public final void setWidgetState(@WidgetState int widgetState) {
        this.mWidgetState = widgetState;
        if (widgetState != 2) {
            seslSetSummaryColor(SettingsMenuUtils.getSummaryColor(getContext(), false));
        }
        setEnabled(widgetState != 1);
        notifyChanged();
    }

    public SettingsSwitchPreferenceScreen(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SettingsSwitchPreferenceScreen(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SettingsSwitchPreferenceScreen(@Nullable Context context) {
        super(context);
    }

    @Override // androidx.preference.SwitchPreferenceCompat
    @SuppressLint({"RestrictedApi"})
    public void onBindViewHolder(@NotNull PreferenceViewHolder holder, int Width) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder(holder, Width);
        initWidgetInfo(holder);
        setWidgetVisibility();
    }
}
