package com.samsung.android.sdk.pen.setting;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenBrushColorDragAreaHelper;", "Lcom/samsung/android/sdk/pen/setting/SpenBrushDragAreaHelper;", "guide", "Landroid/view/View;", "hasTarget", "", "withYourPartner", "<init>", "(Landroid/view/View;ZZ)V", "startDrag", "", "partnerGuide", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenBrushColorDragAreaHelper extends SpenBrushDragAreaHelper {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenBrushColorDragAreaHelper(@NotNull View guide, boolean z, boolean z2) {
        super(guide, z, z2);
        Intrinsics.checkNotNullParameter(guide, "guide");
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenBrushDragAreaHelper
    public void startDrag(@NotNull View partnerGuide) {
        Intrinsics.checkNotNullParameter(partnerGuide, "partnerGuide");
        if (getMHasTarget()) {
            setGuideVisibility(0);
            partnerGuide.setAlpha(0.0f);
        } else {
            setGuideVisibility(8);
            partnerGuide.setAlpha(1.0f);
        }
    }
}
