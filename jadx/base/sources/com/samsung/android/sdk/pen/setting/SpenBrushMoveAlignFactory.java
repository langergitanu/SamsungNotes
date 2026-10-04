package com.samsung.android.sdk.pen.setting;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenBrushMoveAlignFactory;", "", "<init>", "()V", "createBrushMoveAlign", "Lcom/samsung/android/sdk/pen/setting/SpenBrushMoveAlign;", "align", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenBrushMoveAlignFactory {

    @NotNull
    public static final SpenBrushMoveAlignFactory INSTANCE = new SpenBrushMoveAlignFactory();

    private SpenBrushMoveAlignFactory() {
    }

    @JvmStatic
    @NotNull
    public static final SpenBrushMoveAlign createBrushMoveAlign(int align) {
        return align != 1 ? align != 2 ? align != 3 ? new SpenBrushMoveAlignNull() : new SpenBrushMoveAlignTop() : new SpenBrushMoveAlignStart() : new SpenBrushMoveAlignEnd();
    }
}
