package com.samsung.android.support.senl.p148nt.app.settings.common.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import androidx.annotation.StringRes;
import androidx.preference.PreferenceViewHolder;
import androidx.preference.SwitchPreferenceCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationResponse;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.settings.common.widget.SwitchPreferenceLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B-\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\u000bB\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\fB\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\rJ\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\b\b\u0001\u0010\u001b\u001a\u00020\u0007J\u0010\u0010\u001c\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u0014J\u0018\u0010 \u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\u0007R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/common/component/SwitchPreference;", "Landroidx/preference/SwitchPreferenceCompat;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "mSwitchPreferenceLayout", "Lcom/samsung/android/support/senl/nt/app/settings/common/widget/SwitchPreferenceLayout;", "mOnCheckedChangeListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "mTagRes", "mIsClickable", "", "init", "", "onBindViewHolder", "holder", "Landroidx/preference/PreferenceViewHolder;", "setTagRes", "tagRes", "setOnCheckedChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickable", "clickable", "postDelayed", "runnable", "Ljava/lang/Runnable;", MicrosoftAuthorizationResponse.INTERVAL, "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SwitchPreference extends SwitchPreferenceCompat {
    private boolean mIsClickable;

    @Nullable
    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener;

    @Nullable
    private SwitchPreferenceLayout mSwitchPreferenceLayout;

    @StringRes
    private int mTagRes;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchPreference(@Nullable Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNull(context);
        this.mIsClickable = true;
        init();
    }

    private final void init() {
        setLayoutResource(C8003R.layout.settings_switch_preference_layout);
    }

    @Override // androidx.preference.SwitchPreferenceCompat, androidx.preference.Preference
    public void onBindViewHolder(@NotNull PreferenceViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder(holder);
        View view = holder.itemView;
        if (view instanceof SwitchPreferenceLayout) {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.app.settings.common.widget.SwitchPreferenceLayout");
            SwitchPreferenceLayout switchPreferenceLayout = (SwitchPreferenceLayout) view;
            this.mSwitchPreferenceLayout = switchPreferenceLayout;
            if (switchPreferenceLayout != null) {
                switchPreferenceLayout.setClickable(this.mIsClickable);
            }
            SwitchPreferenceLayout switchPreferenceLayout2 = this.mSwitchPreferenceLayout;
            if (switchPreferenceLayout2 != null) {
                switchPreferenceLayout2.setTagRes(this.mTagRes);
            }
            SwitchPreferenceLayout switchPreferenceLayout3 = this.mSwitchPreferenceLayout;
            if (switchPreferenceLayout3 != null) {
                switchPreferenceLayout3.setOnCheckedChangeListener(this.mOnCheckedChangeListener);
            }
            SwitchPreferenceLayout switchPreferenceLayout4 = this.mSwitchPreferenceLayout;
            if (switchPreferenceLayout4 != null) {
                switchPreferenceLayout4.setContract(new SwitchPreferenceLayout.Contract() { // from class: com.samsung.android.support.senl.nt.app.settings.common.component.SwitchPreference.onBindViewHolder.1
                    @Override // com.samsung.android.support.senl.nt.app.settings.common.widget.SwitchPreferenceLayout.Contract
                    public boolean isChecked() {
                        return SwitchPreference.this.isChecked();
                    }
                });
            }
            SwitchPreferenceLayout switchPreferenceLayout5 = this.mSwitchPreferenceLayout;
            if (switchPreferenceLayout5 != null) {
                switchPreferenceLayout5.updateLayout();
            }
        }
    }

    public final void postDelayed(@Nullable Runnable runnable, int interval) {
        SwitchPreferenceLayout switchPreferenceLayout = this.mSwitchPreferenceLayout;
        if (switchPreferenceLayout != null) {
            switchPreferenceLayout.postDelayed(runnable, interval);
        }
    }

    public final void setClickable(boolean clickable) {
        this.mIsClickable = clickable;
        notifyChanged();
    }

    public final void setOnCheckedChangeListener(@Nullable CompoundButton.OnCheckedChangeListener listener) {
        this.mOnCheckedChangeListener = listener;
        notifyChanged();
    }

    public final void setTagRes(@StringRes int tagRes) {
        this.mTagRes = tagRes;
        notifyChanged();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchPreference(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNull(context);
        this.mIsClickable = true;
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchPreference(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNull(context);
        this.mIsClickable = true;
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchPreference(@Nullable Context context) {
        super(context);
        Intrinsics.checkNotNull(context);
        this.mIsClickable = true;
        init();
    }
}
