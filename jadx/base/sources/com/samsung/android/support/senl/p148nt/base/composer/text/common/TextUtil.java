package com.samsung.android.support.senl.p148nt.base.composer.text.common;

import android.text.TextUtils;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class TextUtil {
    private static final String TAG = Logger.createTag("CPLog$TextUtil");

    private static String createLineFeed(int i) {
        StringBuilder sb = new StringBuilder(i);
        for (int i2 = 0; i2 < i; i2++) {
            sb.append('\n');
        }
        return sb.toString();
    }

    public static int[] getCursor(SpenObjectShape spenObjectShape) {
        int selectedEnd;
        int cursorPosition = spenObjectShape.getCursorPosition();
        if (cursorPosition == -1) {
            cursorPosition = spenObjectShape.getSelectedStart();
            selectedEnd = spenObjectShape.getSelectedEnd();
            if (cursorPosition > selectedEnd) {
                cursorPosition = selectedEnd;
                selectedEnd = cursorPosition;
            }
        } else {
            selectedEnd = cursorPosition;
        }
        if (cursorPosition == -1) {
            Logger.m8703w(TAG, "getCursor# position is -1");
            cursorPosition = 0;
            selectedEnd = 0;
        }
        return new int[]{cursorPosition, selectedEnd};
    }

    public static int[] getCursorToDocIndex(SpenObjectShape spenObjectShape) {
        int length;
        int i;
        int[] cursor = getCursor(spenObjectShape);
        if (cursor[1] > cursor[0] && (length = spenObjectShape.getText().length()) > 0 && cursor[1] > (i = length - 1)) {
            cursor[1] = i;
        }
        return cursor;
    }

    private static int[] getEnterCount(SpenObjectShape spenObjectShape, int[] iArr) {
        String text = spenObjectShape.getText();
        int i = 0;
        int i2 = 1;
        if (text != null) {
            int iMin = Math.min(text.length(), Math.max(iArr[0], iArr[1]));
            int i4 = iArr[0];
            int i5 = iArr[1];
            if (i4 == i5) {
                int i6 = 0;
                while (i < iMin) {
                    char cCharAt = text.charAt(i);
                    if (cCharAt == '\n' || cCharAt == '\r') {
                        i6++;
                    }
                    i++;
                }
                i2 = i6 + 1;
                i = i6;
            } else {
                if (i4 > i5) {
                    iArr[0] = i5;
                    iArr[1] = i4;
                }
                int i7 = 0;
                int i8 = 1;
                for (int i9 = 0; i9 < iMin; i9++) {
                    char cCharAt2 = text.charAt(i9);
                    if (i9 < iArr[1] && (cCharAt2 == '\n' || cCharAt2 == '\r')) {
                        if (i9 < iArr[0]) {
                            i7++;
                        }
                        i8++;
                    }
                }
                i = i7;
                i2 = i8;
            }
        }
        return new int[]{i, i2};
    }

    public static int[] getParagraphIndex(SpenObjectShape spenObjectShape, int[] iArr) {
        return getEnterCount(spenObjectShape, iArr);
    }

    public static void insertLineFeed(SpenObjectShape spenObjectShape, int i) {
        if (i == 0) {
            return;
        }
        String text = spenObjectShape.getText();
        spenObjectShape.insertText(createLineFeed(i), (text == null || text.length() <= 0) ? 0 : spenObjectShape.getText().length(), false);
    }

    public static String subString(String str, int i, int i2, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (!DeviceInfo.isUserMode()) {
            return str.substring(i, i2);
        }
        try {
            return str.substring(i, i2);
        } catch (StringIndexOutOfBoundsException e) {
            Logger.m8698e(TAG, "subString# : " + e);
            return z ? "" : str;
        }
    }
}
