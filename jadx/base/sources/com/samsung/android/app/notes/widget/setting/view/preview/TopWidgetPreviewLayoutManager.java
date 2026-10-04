package com.samsung.android.app.notes.widget.setting.view.preview;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.homewidget.C11391R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/setting/view/preview/TopWidgetPreviewLayoutManager;", "Lcom/samsung/android/app/notes/widget/setting/view/preview/IWidgetPreviewLayoutManager;", "res", "Landroid/content/res/Resources;", "isShowNoteWidget", "", "<init>", "(Landroid/content/res/Resources;Z)V", "mWidth", "", "mHeight", "mLayoutId", "initPreview", "Landroid/view/View;", "parent", "oneUiWidgetSource", "", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class TopWidgetPreviewLayoutManager implements IWidgetPreviewLayoutManager {
    public static final int $stable = 8;
    private int mHeight;
    private int mLayoutId;
    private int mWidth;

    public TopWidgetPreviewLayoutManager(@NotNull Resources res, boolean z) {
        Intrinsics.checkNotNullParameter(res, "res");
        if (z) {
            this.mWidth = res.getDimensionPixelSize(C11391R.dimen.widget_setting_show_note_preview_width_top);
            this.mHeight = res.getDimensionPixelSize(C11391R.dimen.widget_setting_show_note_preview_height_top);
            this.mLayoutId = C11391R.layout.widget_pin_settings_preview;
        } else {
            this.mWidth = res.getDimensionPixelSize(C11391R.dimen.widget_setting_shortcut_preview_width_top);
            this.mHeight = res.getDimensionPixelSize(C11391R.dimen.widget_setting_shortcut_preview_height_top);
            this.mLayoutId = C11391R.layout.widget_pin_settings_preview_shortcut;
        }
    }

    @Override // com.samsung.android.app.notes.widget.setting.view.preview.IWidgetPreviewLayoutManager
    @NotNull
    public View initPreview(@NotNull View parent, @Nullable String oneUiWidgetSource) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewFindViewById = parent.findViewById(C11391R.id.widget_setting_preview_container);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.RelativeLayout");
        RelativeLayout relativeLayout = (RelativeLayout) viewFindViewById;
        if (oneUiWidgetSource != null && Intrinsics.areEqual(oneUiWidgetSource, BaseWidgetConstant.ONE_UI_WIDGET_SOURCE_SPAGE)) {
            relativeLayout.setBackgroundColor(ContextCompat.getColor(parent.getContext(), C11391R.color.widget_setting_background));
        }
        View viewFindViewById2 = parent.findViewById(C11391R.id.widget_setting_preview);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.RelativeLayout");
        RelativeLayout relativeLayout2 = (RelativeLayout) viewFindViewById2;
        ViewGroup.LayoutParams layoutParams = relativeLayout2.getLayoutParams();
        layoutParams.width = this.mWidth;
        layoutParams.height = this.mHeight;
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(this.mLayoutId, relativeLayout2);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.RelativeLayout");
        RelativeLayout relativeLayout3 = (RelativeLayout) viewInflate;
        relativeLayout2.setLayoutParams(layoutParams);
        return relativeLayout3;
    }
}
