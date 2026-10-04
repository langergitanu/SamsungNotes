package com.samsung.android.support.senl.p148nt.composer.main.base.util;

import androidx.annotation.Nullable;
import com.samsung.android.sdk.composer.text.ISpenNoteTextManager;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenFontSizeSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenForegroundColorSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenTextSpanBase;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ComposerSpenWNoteUtils {
    private static final String TAG = Logger.createTag("ComposerSpenWNoteUtils");

    public static void changeFontSizeSpan(SpenObjectTextBox spenObjectTextBox, int i) {
        Logger.m10999d(TAG, "changeFontSizeSpan# = " + i);
        removeFontSizeSpan(spenObjectTextBox);
        spenObjectTextBox.appendTextSpan(new SpenFontSizeSpan(0, spenObjectTextBox.getText().length(), 3, (float) i));
    }

    public static float convertDocumentPX(SpenWNote spenWNote, float f) {
        return (f * spenWNote.getWidth()) / 360.0f;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getCursorFontSize(ISpenNoteTextManager iSpenNoteTextManager, int i, SpenObjectTextBox spenObjectTextBox, int i2) {
        ArrayList<SpenTextSpanBase> arrayListFindTextSpan;
        int startCursorIndexByPage = iSpenNoteTextManager.getStartCursorIndexByPage(i);
        if (startCursorIndexByPage >= 0) {
            arrayListFindTextSpan = spenObjectTextBox.findTextSpan(startCursorIndexByPage, startCursorIndexByPage);
            if (arrayListFindTextSpan != null && !arrayListFindTextSpan.isEmpty()) {
                for (SpenTextSpanBase spenTextSpanBase : arrayListFindTextSpan) {
                    if (spenTextSpanBase.getType() == 3) {
                        int size = (int) ((SpenFontSizeSpan) spenTextSpanBase).getSize();
                        AbstractC8014b.m7216r(startCursorIndexByPage, size, "getCursorFontSize# cursor = ", " / font size = ", TAG);
                        return size;
                    }
                }
            }
        } else if (spenObjectTextBox != null && spenObjectTextBox.getText() != null) {
            startCursorIndexByPage = spenObjectTextBox.getText().length();
            AbstractC0000a.m3D(startCursorIndexByPage, "getCursorFontSize# cursor length", TAG);
            arrayListFindTextSpan = spenObjectTextBox.findTextSpan(startCursorIndexByPage, startCursorIndexByPage);
            if (arrayListFindTextSpan != null) {
                while (r3.hasNext()) {
                }
            }
        }
        return i2;
    }

    public static int getDefaultFontSize(ArrayList<SpenTextSpanBase> arrayList, int i, int i2) {
        int i4 = 15;
        if (arrayList != null && !arrayList.isEmpty()) {
            int[] iArr = new int[59];
            int i5 = 0;
            Arrays.fill(iArr, 0);
            for (SpenTextSpanBase spenTextSpanBase : arrayList) {
                if (spenTextSpanBase.getType() == 3) {
                    SpenFontSizeSpan spenFontSizeSpan = (SpenFontSizeSpan) spenTextSpanBase;
                    int iMin = Math.min(Math.max((int) (spenFontSizeSpan.getSize() - 6), 0), 58);
                    iArr[iMin] = (Math.min(spenFontSizeSpan.getEnd(), i2) - Math.max(spenFontSizeSpan.getStart(), i)) + iArr[iMin];
                }
            }
            int i6 = iArr[0];
            for (int i7 = 1; i7 < 59; i7++) {
                int i8 = iArr[i7];
                if (i6 < i8) {
                    i5 = i7;
                    i6 = i8;
                }
            }
            if (i6 == 0) {
                Logger.m10999d(TAG, "getDefaultFontSize# fail");
            } else {
                i4 = i5 + 6;
            }
            AbstractC0000a.m3D(i4, "getDefaultFontSize# ", TAG);
        }
        return i4;
    }

    public static Integer getFGColor(SpenObjectTextBox spenObjectTextBox, int i) {
        ArrayList<SpenTextSpanBase> arrayListFindTextSpan;
        Integer numValueOf = null;
        if (spenObjectTextBox != null && spenObjectTextBox.getText() != null && (arrayListFindTextSpan = spenObjectTextBox.findTextSpan(i, i)) != null && !arrayListFindTextSpan.isEmpty()) {
            for (SpenTextSpanBase spenTextSpanBase : arrayListFindTextSpan) {
                if (spenTextSpanBase.getType() == 1) {
                    SpenForegroundColorSpan spenForegroundColorSpan = (SpenForegroundColorSpan) spenTextSpanBase;
                    if (numValueOf == null || spenForegroundColorSpan.getStart() == i) {
                        numValueOf = Integer.valueOf(spenForegroundColorSpan.getColor());
                    }
                }
            }
        }
        return numValueOf;
    }

    public static int getLastCursorFontSize(SpenObjectTextBox spenObjectTextBox, int i) {
        int length;
        ArrayList<SpenTextSpanBase> arrayListFindTextSpan;
        if (spenObjectTextBox != null && spenObjectTextBox.getText() != null && (arrayListFindTextSpan = spenObjectTextBox.findTextSpan((length = spenObjectTextBox.getText().length()), length)) != null && !arrayListFindTextSpan.isEmpty()) {
            for (SpenTextSpanBase spenTextSpanBase : arrayListFindTextSpan) {
                if (spenTextSpanBase.getType() == 3) {
                    int size = (int) ((SpenFontSizeSpan) spenTextSpanBase).getSize();
                    AbstractC8014b.m7216r(length, size, "getLastCursorFontSize# cursor = ", " / font size = ", TAG);
                    return size;
                }
            }
        }
        return i;
    }

    @Nullable
    public static Integer getPageIndexByObject(SpenWNote spenWNote, SpenObjectBase spenObjectBase, int i) {
        ArrayList<SpenWPage> pageList = spenWNote.getPageList();
        for (int i2 = 0; i2 < pageList.size(); i2++) {
            SpenWPage spenWPage = pageList.get(i2);
            if (spenWPage.getObjectList(i) != null) {
                Iterator<SpenObjectBase> it = spenWPage.getObjectList().iterator();
                while (it.hasNext()) {
                    if (it.next().getRuntimeHandle() == spenObjectBase.getRuntimeHandle()) {
                        return Integer.valueOf(i2);
                    }
                }
            }
        }
        return null;
    }

    public static boolean hasFontSizeSpan(SpenObjectTextBox spenObjectTextBox) {
        ArrayList<SpenTextSpanBase> textSpan = spenObjectTextBox.getTextSpan();
        if (textSpan == null || textSpan.isEmpty()) {
            return false;
        }
        Iterator<SpenTextSpanBase> it = textSpan.iterator();
        while (it.hasNext()) {
            if (it.next().getType() == 3) {
                return true;
            }
        }
        return false;
    }

    public static void removeFontSizeSpan(SpenObjectTextBox spenObjectTextBox) {
        ArrayList<SpenTextSpanBase> textSpan = spenObjectTextBox.getTextSpan();
        if (textSpan == null || textSpan.isEmpty()) {
            return;
        }
        for (SpenTextSpanBase spenTextSpanBase : textSpan) {
            if (spenTextSpanBase.getType() == 3) {
                spenObjectTextBox.removeTextSpan(spenTextSpanBase);
            }
        }
    }
}
