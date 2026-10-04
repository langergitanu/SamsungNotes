package com.samsung.android.support.senl.p148nt.app.settings.common.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationResponse;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistantTTS;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p043J2.ViewOnClickListenerC0157a;
import p091W2.C0331a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001&B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0006\u0010\u0015\u001a\u00020\u0014J\u0010\u0010\u0016\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\rJ\u0018\u0010\u0018\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\nJ\u0006\u0010\u001c\u001a\u00020\u0014J\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00142\b\b\u0001\u0010!\u001a\u00020\nJ\u000e\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u0012R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010$\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006'"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/common/widget/SwitchPreferenceLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mOnCheckedChangeListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "mSwitchCompat", "Landroidx/appcompat/widget/SwitchCompat;", "mTagRes", "mContract", "Lcom/samsung/android/support/senl/nt/app/settings/common/widget/SwitchPreferenceLayout$Contract;", "init", "", "updateLayout", "setOnCheckedChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "postDelayed", "runnable", "Ljava/lang/Runnable;", MicrosoftAuthorizationResponse.INTERVAL, "setContentDescription", "setClickable", "clickable", "", "setTagRes", "tagRes", "setContract", "contract", "isChecked", "()Z", "Contract", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SwitchPreferenceLayout extends FrameLayout {

    @Nullable
    private Contract mContract;

    @Nullable
    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener;

    @Nullable
    private SwitchCompat mSwitchCompat;

    @StringRes
    private int mTagRes;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/common/widget/SwitchPreferenceLayout$Contract;", "", "isChecked", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        boolean isChecked();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchPreferenceLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context);
    }

    private final void init(Context context) {
        LayoutInflater.from(context).inflate(C8003R.layout.switch_preference_layout, (ViewGroup) this, true);
        SwitchCompat switchCompat = (SwitchCompat) findViewById(C8003R.id.switch_widget);
        this.mSwitchCompat = switchCompat;
        if (switchCompat != null) {
            switchCompat.setChecked(isChecked());
            switchCompat.setOnCheckedChangeListener(new C0331a(this, 0));
        }
        View viewFindViewById = findViewById(C8003R.id.container);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new ViewOnClickListenerC0157a(this, 2));
        }
        updateLayout();
        setContentDescription();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$1$lambda$0(SwitchPreferenceLayout switchPreferenceLayout, CompoundButton buttonView, boolean z) {
        Intrinsics.checkNotNullParameter(buttonView, "buttonView");
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = switchPreferenceLayout.mOnCheckedChangeListener;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(buttonView, z);
        }
        switchPreferenceLayout.updateLayout();
        switchPreferenceLayout.setContentDescription();
        VoiceAssistantTTS companion = VoiceAssistantTTS.INSTANCE.getInstance();
        CharSequence contentDescription = switchPreferenceLayout.getContentDescription();
        Intrinsics.checkNotNull(contentDescription, "null cannot be cast to non-null type kotlin.String");
        companion.sendTalkBackMessage((String) contentDescription);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$2(SwitchPreferenceLayout switchPreferenceLayout, View view) {
        SwitchCompat switchCompat = switchPreferenceLayout.mSwitchCompat;
        if (switchCompat != null) {
            switchCompat.toggle();
        }
    }

    public final boolean isChecked() {
        Contract contract = this.mContract;
        return contract != null && contract.isChecked();
    }

    public final void postDelayed(@Nullable Runnable runnable, int interval) {
        SwitchCompat switchCompat = this.mSwitchCompat;
        if (switchCompat != null) {
            switchCompat.postDelayed(runnable, interval);
        }
    }

    @Override // android.view.View
    public void setClickable(boolean clickable) {
        SwitchCompat switchCompat = this.mSwitchCompat;
        if (switchCompat != null) {
            switchCompat.setClickable(clickable);
        }
    }

    public final void setContentDescription() {
        String string = getContext().getString(C8003R.string.string_comma);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String strM1622l = AbstractC2322a.m1622l(getContext().getString(isChecked() ? C8003R.string.f6013on : C8003R.string.off), this.mTagRes != 0 ? AbstractC0541b.m757C(string, " ", getContext().getString(this.mTagRes)) : "", string, " ", getContext().getString(C8003R.string.base_string_switch));
        if (TextUtils.isEmpty(strM1622l)) {
            return;
        }
        setContentDescription(strM1622l);
    }

    public final void setContract(@NotNull Contract contract) {
        Intrinsics.checkNotNullParameter(contract, "contract");
        this.mContract = contract;
    }

    public final void setOnCheckedChangeListener(@Nullable CompoundButton.OnCheckedChangeListener listener) {
        this.mOnCheckedChangeListener = listener;
    }

    public final void setTagRes(@StringRes int tagRes) {
        this.mTagRes = tagRes;
    }

    public final void updateLayout() {
        SwitchCompat switchCompat = this.mSwitchCompat;
        if (switchCompat != null && switchCompat.isChecked() != isChecked()) {
            switchCompat.setChecked(isChecked());
        }
        TextView textView = (TextView) findViewById(C8003R.id.title);
        if (textView != null) {
            textView.setText(isChecked() ? C8003R.string.settings_switch_on : C8003R.string.settings_switch_off);
            textView.setTextColor(ResourcesCompat.getColor(getContext().getResources(), isChecked() ? C8003R.color.settings_switch_on_text_color : C8003R.color.settings_switch_off_text_color, getContext().getTheme()));
        }
        setBackground(ResourcesCompat.getDrawable(getContext().getResources(), isChecked() ? C8003R.drawable.settings_main_switch_on_bg : C8003R.drawable.settings_main_switch_off_bg, getContext().getTheme()));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchPreferenceLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchPreferenceLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context);
    }
}
