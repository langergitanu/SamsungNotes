package com.samsung.android.support.senl.p148nt.app.settings.common.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.common.util.ButtonBackgroundUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B-\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\u000bB\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\fB\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\rJ\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0015\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/common/component/UpdateTipCardPreference;", "Landroidx/preference/Preference;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "mPositiveButtonClickListener", "Landroid/view/View$OnClickListener;", "mNeutralButtonClickListener", "init", "", "setPositiveButtonClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setNeutralButtonClickListener", "onBindViewHolder", "holder", "Landroidx/preference/PreferenceViewHolder;", "initTipCard", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class UpdateTipCardPreference extends Preference {

    @Nullable
    private View.OnClickListener mNeutralButtonClickListener;

    @Nullable
    private View.OnClickListener mPositiveButtonClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateTipCardPreference(@Nullable Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNull(context);
        init();
    }

    private final void init() {
        setLayoutResource(C8003R.layout.update_tipcard_layout);
    }

    private final void initTipCard(PreferenceViewHolder holder) {
        int i = DeviceInfo.isVSTModel() ? C8003R.color.tip_card_background_for_vst : C8003R.color.tip_card_background;
        View view = holder.itemView;
        view.setBackgroundColor(view.getResources().getColor(i, null));
        View viewFindViewById = holder.findViewById(C8003R.id.tipcard_message);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) viewFindViewById;
        View viewFindViewById2 = holder.findViewById(C8003R.id.tipcard_button_positive);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView2 = (TextView) viewFindViewById2;
        View viewFindViewById3 = holder.findViewById(C8003R.id.tipcard_button_neutral);
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView3 = (TextView) viewFindViewById3;
        if (ButtonBackgroundUtils.isShowButtonShapeEnabled(getContext())) {
            textView2.setBackgroundResource(C8003R.drawable.tip_card_button_shape_bg);
            textView2.setTextColor(getContext().getResources().getColor(C8003R.color.tip_card_background, null));
            textView3.setBackgroundResource(C8003R.drawable.tip_card_button_shape_bg);
            textView3.setTextColor(getContext().getResources().getColor(C8003R.color.tip_card_background, null));
        } else {
            textView2.setTextColor(getContext().getResources().getColor(C8003R.color.tip_card_button_text_color, null));
            textView3.setTextColor(getContext().getResources().getColor(C8003R.color.tip_card_button_text_color, null));
        }
        CharUtils.applyTextSizeUntilLargeSize(getContext(), textView, 15.0f);
        CharUtils.applyTextSizeUntilLargeSize(getContext(), textView2, 15.0f);
        CharUtils.applyTextSizeUntilLargeSize(getContext(), textView3, 15.0f);
        textView.setText(getContext().getString(C8003R.string.tipcard_update_content, getContext().getString(CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C8003R.string.notes_jp : C8003R.string.app_name)));
        textView2.setText(getContext().getString(C8003R.string.tipcard_update_positive_button));
        CharSequence text = textView2.getText();
        textView2.setContentDescription(((Object) text) + getContext().getResources().getString(C8003R.string.tipcard_button_content_description));
        textView2.setOnClickListener(this.mPositiveButtonClickListener);
        CharSequence text2 = textView3.getText();
        textView3.setContentDescription(((Object) text2) + getContext().getResources().getString(C8003R.string.tipcard_button_content_description));
        textView3.setOnClickListener(this.mNeutralButtonClickListener);
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(@NotNull PreferenceViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder(holder);
        initTipCard(holder);
    }

    @NotNull
    public final UpdateTipCardPreference setNeutralButtonClickListener(@Nullable View.OnClickListener listener) {
        this.mNeutralButtonClickListener = listener;
        return this;
    }

    @NotNull
    public final UpdateTipCardPreference setPositiveButtonClickListener(@Nullable View.OnClickListener listener) {
        this.mPositiveButtonClickListener = listener;
        return this;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateTipCardPreference(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNull(context);
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateTipCardPreference(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNull(context);
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateTipCardPreference(@Nullable Context context) {
        super(context);
        Intrinsics.checkNotNull(context);
        init();
    }
}
