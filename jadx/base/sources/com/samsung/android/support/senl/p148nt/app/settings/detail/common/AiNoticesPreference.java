package com.samsung.android.support.senl.p148nt.app.settings.detail.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B-\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\u000bB\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\fB\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0006\u0010\u001a\u001a\u00020\u000fR\u0012\u0010\u0010\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0016\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/detail/common/AiNoticesPreference;", "Landroidx/preference/Preference;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "init", "", "settingLayoutResource", "getSettingLayoutResource", "()I", "onBindViewHolder", "holder", "Landroidx/preference/PreferenceViewHolder;", "tag", "", "getTag", "()Ljava/lang/String;", "onConfigurationChanged", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AiNoticesPreference extends Preference {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiNoticesPreference(@Nullable Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNull(context);
        init();
    }

    private final void init() {
        setLayoutResource(getSettingLayoutResource());
        seslSetSubheaderRoundedBackground(0);
    }

    public abstract int getSettingLayoutResource();

    @NotNull
    public abstract String getTag();

    /* JADX WARN: Removed duplicated region for block: B:15:0x0071  */
    @Override // androidx.preference.Preference
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindViewHolder(@NotNull PreferenceViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder(holder);
        if (holder.itemView instanceof LinearLayout) {
            MainLogger.m7258i(getTag(), "onBindViewHolder");
            View view = holder.itemView;
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.LinearLayout");
            LinearLayout linearLayout = (LinearLayout) view;
            View viewFindViewById = linearLayout.findViewById(C8003R.id.image_notice_container);
            View viewFindViewById2 = linearLayout.findViewById(C8003R.id.text_notice_container);
            if (viewFindViewById == null || viewFindViewById2 == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = viewFindViewById2.getLayoutParams();
            if (getContext().getResources().getConfiguration().orientation != 2) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                if (DisplayUtils.getWidthDp(context) > 615.0f) {
                    linearLayout.setOrientation(0);
                    layoutParams2.width = 0;
                    layoutParams.width = 0;
                    layoutParams2.height = -1;
                    layoutParams.height = -1;
                } else {
                    linearLayout.setOrientation(1);
                    layoutParams2.width = -1;
                    layoutParams.width = -1;
                    layoutParams2.height = -2;
                    layoutParams.height = -2;
                }
            }
            viewFindViewById.setLayoutParams(layoutParams);
            viewFindViewById2.setLayoutParams(layoutParams2);
            viewFindViewById2.setPaddingRelative(0, (int) viewFindViewById2.getResources().getDimension(C8003R.dimen.settings_notes_assist_text_notice_container_padding_top), 0, 0);
        }
    }

    public final void onConfigurationChanged() {
        notifyChanged();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiNoticesPreference(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNull(context);
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiNoticesPreference(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNull(context);
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiNoticesPreference(@Nullable Context context) {
        super(context);
        Intrinsics.checkNotNull(context);
        init();
    }
}
