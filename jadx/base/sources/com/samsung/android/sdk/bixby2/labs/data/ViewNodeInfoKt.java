package com.samsung.android.sdk.bixby2.labs.data;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0001¨\u0006\u0003"}, m13886d2 = {"toViewNodeInfo", "Lcom/samsung/android/sdk/bixby2/labs/data/ViewNodeInfo;", "Landroid/view/accessibility/AccessibilityNodeInfo;", "bixbyappsdk_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class ViewNodeInfoKt {
    @RequiresApi(26)
    @NotNull
    public static final ViewNodeInfo toViewNodeInfo(@NotNull AccessibilityNodeInfo accessibilityNodeInfo) {
        String string;
        String str;
        Intrinsics.checkNotNullParameter(accessibilityNodeInfo, "<this>");
        Rect rect = new Rect();
        accessibilityNodeInfo.getBoundsInScreen(rect);
        ArrayList arrayList = new ArrayList();
        int childCount = accessibilityNodeInfo.getChildCount();
        for (int i = 0; i < childCount; i++) {
            AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i);
            if (child != null) {
                arrayList.add(toViewNodeInfo(child));
            }
        }
        boolean zIsCheckable = accessibilityNodeInfo.isCheckable();
        boolean zIsChecked = accessibilityNodeInfo.isChecked();
        String string2 = accessibilityNodeInfo.getClassName().toString();
        boolean zIsClickable = accessibilityNodeInfo.isClickable();
        CharSequence contentDescription = accessibilityNodeInfo.getContentDescription();
        if (contentDescription != null) {
            string = contentDescription.toString();
            str = null;
        } else {
            string = null;
            str = null;
        }
        boolean zIsEnabled = accessibilityNodeInfo.isEnabled();
        String str2 = str;
        boolean zIsFocusable = accessibilityNodeInfo.isFocusable();
        boolean zIsFocused = accessibilityNodeInfo.isFocused();
        CharSequence hintText = accessibilityNodeInfo.getHintText();
        String string3 = hintText != null ? hintText.toString() : str2;
        boolean zIsLongClickable = accessibilityNodeInfo.isLongClickable();
        String string4 = str2;
        String str3 = string3;
        boolean zIsSelected = accessibilityNodeInfo.isSelected();
        CharSequence text = accessibilityNodeInfo.getText();
        if (text != null) {
            string4 = text.toString();
        }
        return new ViewNodeInfo(zIsCheckable, zIsChecked, string2, zIsClickable, string, rect, zIsEnabled, zIsFocusable, zIsFocused, str3, zIsLongClickable, zIsSelected, string4, !accessibilityNodeInfo.isVisibleToUser() ? 1 : 0, accessibilityNodeInfo.getChildCount(), arrayList);
    }
}
