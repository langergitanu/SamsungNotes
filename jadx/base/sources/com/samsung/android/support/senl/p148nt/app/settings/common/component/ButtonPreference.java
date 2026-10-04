package com.samsung.android.support.senl.p148nt.app.settings.common.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B-\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB%\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\n\u0010\fB\u001d\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\rB\u0013\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000eJ\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\bJ\u0010\u0010\u001a\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u001d\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!H\u0016R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/common/component/ButtonPreference;", "Landroidx/preference/Preference;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "mButton", "Landroid/widget/Button;", "mTextResId", "mText", "", "mOnClickListener", "init", "", "onBindViewHolder", "holder", "Landroidx/preference/PreferenceViewHolder;", "setText", "textResId", "text", "setOnClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "onClick", VPathDataCmd.RCurveTo, "Landroid/view/View;", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ButtonPreference extends Preference implements View.OnClickListener {

    @NotNull
    private static final String TAG = "ButtonPreference";

    @Nullable
    private Button mButton;

    @Nullable
    private View.OnClickListener mOnClickListener;

    @Nullable
    private String mText;
    private int mTextResId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ButtonPreference(@Nullable Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNull(context);
        init();
    }

    private final void init() {
        setLayoutResource(C8003R.layout.settings_button);
        seslSetSubheaderRoundedBackground(0);
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(@NotNull PreferenceViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        MainLogger.m7258i(TAG, "onBindViewHolder");
        super.onBindViewHolder(holder);
        Button button = (Button) holder.itemView.findViewById(C8003R.id.button);
        this.mButton = button;
        String str = this.mText;
        if (str == null) {
            int i = this.mTextResId;
            if (i > 0 && button != null) {
                button.setText(i);
            }
        } else if (button != null) {
            button.setText(str);
        }
        Button button2 = this.mButton;
        if (button2 != null) {
            button2.setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        View.OnClickListener onClickListener = this.mOnClickListener;
        if (onClickListener != null) {
            Intrinsics.checkNotNull(onClickListener);
            onClickListener.onClick(v);
        }
    }

    public final void setOnClickListener(@Nullable View.OnClickListener listener) {
        this.mOnClickListener = listener;
    }

    public final void setText(int textResId) {
        this.mTextResId = textResId;
        this.mText = null;
        Button button = this.mButton;
        if (button != null) {
            Intrinsics.checkNotNull(button);
            button.setText(this.mTextResId);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ButtonPreference(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNull(context);
        init();
    }

    public final void setText(@Nullable String text) {
        this.mText = text;
        this.mTextResId = 0;
        Button button = this.mButton;
        if (button != null) {
            Intrinsics.checkNotNull(button);
            button.setText(this.mText);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ButtonPreference(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNull(context);
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ButtonPreference(@Nullable Context context) {
        super(context);
        Intrinsics.checkNotNull(context);
        init();
    }
}
