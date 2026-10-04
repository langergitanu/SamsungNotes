package com.samsung.android.sdk.composer.listener;

import android.view.MotionEvent;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.composer.document.search.SearchData;
import com.samsung.android.sdk.pen.worddoc.SpenCustomObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0007J(\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J0\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0016J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u0007H\u0016J\u001a\u0010!\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020\u0007H\u0016J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0007H\u0016¨\u0006+"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/listener/SpenComposerActionListener;", "", "<init>", "()V", "onEditModeChanged", "", "mode", "", "onInitLayoutFinished", "onComposerClicked", "event", "Landroid/view/MotionEvent;", "onSearchingText", "totalCount", "searchData", "Lcom/samsung/android/sdk/composer/document/search/SearchData;", "onSearchTextFinished", "onPullGestureAnimationUpdated", "animatedValue", "", "viewX", "viewY", "isReleased", "", "onSmoothScrollEnd", "onLayout", "changed", "oldWidth", "oldHeight", "newWidth", "newHeight", "onPerformContextMenuAction", "id", "onActionLinkClicked", "text", "", "linkType", "onStickyMemoClicked", "customObject", "Lcom/samsung/android/sdk/pen/worddoc/SpenCustomObject;", "onStickyMemoMovedByUser", "onTextContentOverflow", TextConst.KEY_START_INDEX, "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public abstract class SpenComposerActionListener {
    public void onActionLinkClicked(@Nullable String text, int linkType) {
    }

    public void onComposerClicked(@Nullable MotionEvent event) {
    }

    public void onEditModeChanged(int mode) {
    }

    public void onInitLayoutFinished() {
    }

    public void onLayout(boolean changed, int oldWidth, int oldHeight, int newWidth, int newHeight) {
    }

    public boolean onPerformContextMenuAction(int id) {
        return false;
    }

    public void onPullGestureAnimationUpdated(float animatedValue, float viewX, float viewY, boolean isReleased) {
    }

    public final void onSearchTextFinished(int totalCount) {
    }

    public void onSearchingText(int totalCount, @Nullable SearchData searchData) {
    }

    public void onSmoothScrollEnd() {
    }

    public void onStickyMemoClicked(@NotNull SpenCustomObject customObject) {
        Intrinsics.checkNotNullParameter(customObject, "customObject");
    }

    public void onStickyMemoMovedByUser(@NotNull SpenCustomObject customObject) {
        Intrinsics.checkNotNullParameter(customObject, "customObject");
    }

    public void onTextContentOverflow(int startIndex) {
    }
}
