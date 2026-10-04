package com.samsung.android.support.senl.addons.brush.view.injector;

import android.content.res.Resources;
import com.samsung.android.support.senl.addons.C7944R;
import com.samsung.android.support.senl.addons.brush.model.IBrushModelInjector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/view/injector/BrushModelInjector;", "Lcom/samsung/android/support/senl/addons/brush/model/IBrushModelInjector;", "res", "Landroid/content/res/Resources;", "<init>", "(Landroid/content/res/Resources;)V", "mThumbnailMargin", "Lcom/samsung/android/support/senl/addons/brush/model/IBrushModelInjector$Margin;", "thumbnailMargin", "getThumbnailMargin", "()Lcom/samsung/android/support/senl/addons/brush/model/IBrushModelInjector$Margin;", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BrushModelInjector implements IBrushModelInjector {

    @NotNull
    private final IBrushModelInjector.Margin mThumbnailMargin;

    public BrushModelInjector(@NotNull Resources res) {
        Intrinsics.checkNotNullParameter(res, "res");
        this.mThumbnailMargin = new IBrushModelInjector.Margin((int) res.getDimension(C7944R.dimen.brush_default_thumbnail_horizontal_margin), (int) res.getDimension(C7944R.dimen.brush_default_thumbnail_vertical_margin));
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.IBrushModelInjector
    @NotNull
    /* JADX INFO: renamed from: getThumbnailMargin, reason: from getter */
    public IBrushModelInjector.Margin getMThumbnailMargin() {
        return this.mThumbnailMargin;
    }
}
