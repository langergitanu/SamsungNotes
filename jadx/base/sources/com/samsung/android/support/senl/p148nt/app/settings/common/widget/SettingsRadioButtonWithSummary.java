package com.samsung.android.support.senl.p148nt.app.settings.common.widget;

import android.R;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\nJ\u0010\u0010\u001a\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u000fJ\u0006\u0010 \u001a\u00020\u000fJ\b\u0010!\u001a\u00020\u0016H\u0014J\u000e\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u000fR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/common/widget/SettingsRadioButtonWithSummary;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mIsButtonEnabled", "", "mRadioButton", "Landroid/widget/RadioButton;", "mTitle", "Landroid/widget/TextView;", "mSummary", "init", "", "setText", "text", "", "setSummary", "summaryRes", DBSchema.DocumentCover.SUMMARY, "", "setChecked", "checked", "isChecked", "onAttachedToWindow", "setButtonEnabled", "isEnabled", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SettingsRadioButtonWithSummary extends FrameLayout {
    private boolean mIsButtonEnabled;

    @Nullable
    private RadioButton mRadioButton;

    @Nullable
    private TextView mSummary;

    @Nullable
    private TextView mTitle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsRadioButtonWithSummary(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mIsButtonEnabled = true;
        init(context);
    }

    private final void init(Context context) {
        LayoutInflater.from(context).inflate(C8003R.layout.settings_radio_button_with_summary, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.mSummary = (TextView) findViewById(R.id.summary);
        this.mRadioButton = (RadioButton) findViewById(C8003R.id.checkbox);
        TextView textView = this.mSummary;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public final boolean isChecked() {
        RadioButton radioButton = this.mRadioButton;
        if (radioButton != null) {
            return radioButton.isChecked();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        RadioButton radioButton = this.mRadioButton;
        Intrinsics.checkNotNull(radioButton);
        radioButton.setVisibility(this.mIsButtonEnabled ? 0 : 8);
    }

    public final void setButtonEnabled(boolean isEnabled) {
        this.mIsButtonEnabled = isEnabled;
        RadioButton radioButton = this.mRadioButton;
        Intrinsics.checkNotNull(radioButton);
        radioButton.setVisibility(this.mIsButtonEnabled ? 0 : 8);
    }

    public final void setChecked(boolean checked) {
        RadioButton radioButton = this.mRadioButton;
        Intrinsics.checkNotNull(radioButton);
        radioButton.setChecked(checked);
    }

    public final void setSummary(int summaryRes) {
        if (summaryRes <= 0) {
            TextView textView = this.mSummary;
            Intrinsics.checkNotNull(textView);
            textView.setVisibility(8);
        } else {
            TextView textView2 = this.mSummary;
            Intrinsics.checkNotNull(textView2);
            textView2.setVisibility(0);
            TextView textView3 = this.mSummary;
            Intrinsics.checkNotNull(textView3);
            textView3.setText(summaryRes);
        }
    }

    public final void setText(@Nullable String text) {
        TextView textView = this.mTitle;
        Intrinsics.checkNotNull(textView);
        textView.setText(text);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsRadioButtonWithSummary(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mIsButtonEnabled = true;
        init(context);
    }

    public final void setSummary(@Nullable CharSequence summary) {
        if (TextUtils.isEmpty(summary)) {
            TextView textView = this.mSummary;
            Intrinsics.checkNotNull(textView);
            textView.setVisibility(8);
        } else {
            TextView textView2 = this.mSummary;
            Intrinsics.checkNotNull(textView2);
            textView2.setVisibility(0);
            TextView textView3 = this.mSummary;
            Intrinsics.checkNotNull(textView3);
            textView3.setText(summary);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsRadioButtonWithSummary(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mIsButtonEnabled = true;
        init(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsRadioButtonWithSummary(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mIsButtonEnabled = true;
        init(context);
    }
}
