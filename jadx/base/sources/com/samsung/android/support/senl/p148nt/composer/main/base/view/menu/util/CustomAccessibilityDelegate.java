package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.util;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CustomAccessibilityDelegate extends View.AccessibilityDelegate {
    String mSelectedString;
    boolean mSelectedTalkEnabled = true;
    String mUnselectedString;

    public CustomAccessibilityDelegate(String str, String str2) {
        this.mSelectedString = str;
        this.mUnselectedString = str2;
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        if (this.mSelectedTalkEnabled) {
            return;
        }
        accessibilityNodeInfo.setSelected(false);
        if (view.isSelected()) {
            accessibilityNodeInfo.setContentDescription(this.mSelectedString);
        } else {
            accessibilityNodeInfo.setContentDescription(this.mUnselectedString);
        }
    }

    public CustomAccessibilityDelegate() {
    }
}
