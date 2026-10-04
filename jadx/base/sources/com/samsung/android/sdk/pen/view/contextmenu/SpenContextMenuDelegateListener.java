package com.samsung.android.sdk.pen.view.contextmenu;

import android.graphics.RectF;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/view/contextmenu/SpenContextMenuDelegateListener;", "", "<init>", "()V", "onShowContextMenu", "", "contentRect", "Landroid/graphics/RectF;", "enableVibration", "onHideContextMenu", "", "onUpdateContentRect", "rect", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public abstract class SpenContextMenuDelegateListener {
    public boolean onShowContextMenu(@Nullable RectF contentRect, boolean enableVibration) {
        return false;
    }

    public void onHideContextMenu() {
    }

    public void onUpdateContentRect(@Nullable RectF rect) {
    }
}
