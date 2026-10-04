package com.samsung.android.sdk.composer.view.accessibility;

import android.text.Editable;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\rH&J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u0013H&J*\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0013H&J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0013H&J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0013H&J.\u0010\u001f\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010!\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010 2\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u0013H&R\u001a\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/view/accessibility/SpenAccessibilityDelegateListener;", "", "nodeList", "", "Lcom/samsung/android/sdk/composer/view/accessibility/SpenAccessibilityNodeInfo;", "getNodeList", "()Ljava/util/List;", "onAccessibilityStateChanged", "", "enabled", "", "onScroll", "dx", "", "dy", "onMove", "y", "onClick", "nativeId", "", "getObjectByNativeId", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "getCursorPos", "", "nativeID", "cursorIndex", "isNext", "selectBy", "onPerformContextMenuAction", "id", "isNodeInfoFocused", "getEditable", "Lkotlin/Triple;", "Landroid/text/Editable;", "pageIndex", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface SpenAccessibilityDelegateListener {
    @Nullable
    int[] getCursorPos(int nativeID, int cursorIndex, boolean isNext, int selectBy);

    @Nullable
    Triple<Editable, Integer, Integer> getEditable(int nativeID, int pageIndex);

    @Nullable
    List<SpenAccessibilityNodeInfo> getNodeList();

    @Nullable
    SpenObjectBase getObjectByNativeId(int nativeId);

    boolean isNodeInfoFocused(int nativeID);

    void onAccessibilityStateChanged(boolean enabled);

    void onClick(int nativeId);

    void onMove(float y2);

    boolean onPerformContextMenuAction(int id);

    void onScroll(float dx, float dy);
}
