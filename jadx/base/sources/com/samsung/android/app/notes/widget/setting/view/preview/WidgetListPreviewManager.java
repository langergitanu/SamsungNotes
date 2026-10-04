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
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/setting/view/preview/WidgetListPreviewManager;", "Lcom/samsung/android/app/notes/widget/setting/view/preview/IWidgetPreviewLayoutManager;", "res", "Landroid/content/res/Resources;", "<init>", "(Landroid/content/res/Resources;)V", "mWidth", "", "mHeight", "mLayoutId", "initPreview", "Landroid/view/View;", "parent", "oneUiWidgetSource", "", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetListPreviewManager implements IWidgetPreviewLayoutManager {
    public static final int $stable = 0;
    private final int mHeight;
    private final int mLayoutId;
    private final int mWidth;

    public WidgetListPreviewManager(@NotNull Resources res) {
        Intrinsics.checkNotNullParameter(res, "res");
        this.mWidth = res.getDimensionPixelSize(C11391R.dimen.widget_setting_show_note_preview_width);
        this.mHeight = res.getDimensionPixelSize(C11391R.dimen.widget_setting_show_note_preview_height);
        this.mLayoutId = C11391R.layout.widget_list_setting_preview;
    }

    @Override // com.samsung.android.app.notes.widget.setting.view.preview.IWidgetPreviewLayoutManager
    @Nullable
    public View initPreview(@NotNull View parent, @Nullable String oneUiWidgetSource) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewFindViewById = parent.findViewById(C11391R.id.widget_setting_preview);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.RelativeLayout");
        RelativeLayout relativeLayout = (RelativeLayout) viewFindViewById;
        View viewFindViewById2 = parent.findViewById(C11391R.id.widget_setting_preview_container);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.RelativeLayout");
        RelativeLayout relativeLayout2 = (RelativeLayout) viewFindViewById2;
        if (oneUiWidgetSource != null && Intrinsics.areEqual(oneUiWidgetSource, BaseWidgetConstant.ONE_UI_WIDGET_SOURCE_SPAGE)) {
            relativeLayout2.setBackgroundColor(ContextCompat.getColor(parent.getContext(), C11391R.color.widget_setting_background));
        }
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        layoutParams.width = this.mWidth;
        layoutParams.height = this.mHeight;
        relativeLayout.setLayoutParams(layoutParams);
        return LayoutInflater.from(parent.getContext()).inflate(this.mLayoutId, relativeLayout);
    }
}
