package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.samsung.android.sdk.composer.text.ISpenNoteTextManager;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectLink;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.SpenObjectWeb;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageCopyData;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.collector.util.RecognitionUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ShareCondition {
    private static final String TAG = Logger.createTag("ShareCondition");

    public static boolean canShowWordExportOption(SpenWNote spenWNote, Context context) {
        return spenWNote.hasObject(1) && RecognitionUtil.isSupported(context);
    }

    private static String getClearObjectSpanText(SpenObjectTextBox spenObjectTextBox) {
        ArrayList<SpenObjectSpan> objectSpan = spenObjectTextBox.getObjectSpan();
        if (objectSpan == null) {
            return spenObjectTextBox.getText();
        }
        Collections.sort(objectSpan, new Comparator<SpenObjectSpan>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.share.ShareCondition.1
            @Override // java.util.Comparator
            public int compare(SpenObjectSpan spenObjectSpan, SpenObjectSpan spenObjectSpan2) {
                return spenObjectSpan.getTextIndex() - spenObjectSpan2.getTextIndex();
            }
        });
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spenObjectTextBox.getText());
        for (int size = objectSpan.size() - 1; size >= 0; size--) {
            SpenObjectSpan spenObjectSpan = objectSpan.get(size);
            spannableStringBuilder.replace(spenObjectSpan.getTextIndex(), spenObjectSpan.getTextIndex() + 1, (CharSequence) "");
        }
        return spannableStringBuilder.toString();
    }

    public static boolean hasContent(SpenWNote spenWNote) {
        if (spenWNote == null || spenWNote.isClosed()) {
            Logger.m10999d(TAG, "hasContent# spenWNote is null or already closed");
            return false;
        }
        SpenObjectTextBox bodyText = spenWNote.getBodyText();
        if (bodyText != null && isNotEmptyForText(bodyText.getText())) {
            return true;
        }
        for (SpenWPage spenWPage : spenWNote.getPageList()) {
            if (spenWPage.hasPDF()) {
                return true;
            }
            ArrayList<SpenObjectBase> objectList = spenWPage.getObjectList();
            if (objectList != null && !objectList.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasText(SpenWNote spenWNote) {
        if (spenWNote == null || spenWNote.isClosed()) {
            Logger.m10999d(TAG, "hasText# spenWNote is null or already closed");
            return false;
        }
        SpenObjectTextBox bodyText = spenWNote.getBodyText();
        if (bodyText != null && isNotEmptyForText(getClearObjectSpanText(bodyText))) {
            return true;
        }
        Iterator<SpenWPage> it = spenWNote.getPageList().iterator();
        while (it.hasNext()) {
            if (hasText(it.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNotEmptyForText(String str) {
        if (str == null) {
            return false;
        }
        return Pattern.compile("[^\\r\\s]").matcher(str).find();
    }

    public static boolean canShowWordExportOption(SpenWNote spenWNote, List<PageCopyData> list, Context context) {
        if (list == null || list.isEmpty() || !RecognitionUtil.isSupported(context)) {
            return false;
        }
        Iterator<PageCopyData> it = list.iterator();
        while (it.hasNext()) {
            ArrayList<SpenObjectBase> objectList = spenWNote.getPage(it.next().getIndex()).getObjectList(1);
            if (objectList != null && !objectList.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasText(SpenWNote spenWNote, List<PageCopyData> list, ISpenNoteTextManager iSpenNoteTextManager) {
        if (list != null && !list.isEmpty()) {
            for (PageCopyData pageCopyData : list) {
                if (hasText(spenWNote.getPage(pageCopyData.getIndex()))) {
                    return true;
                }
                SpenObjectTextBox spenObjectTextBoxCopyBodyTextFrom = iSpenNoteTextManager.copyBodyTextFrom(pageCopyData.getIndex());
                if (spenObjectTextBoxCopyBodyTextFrom != null && isNotEmptyForText(getClearObjectSpanText(spenObjectTextBoxCopyBodyTextFrom))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasContent(SpenWNote spenWNote, List<PageCopyData> list, ISpenNoteTextManager iSpenNoteTextManager) {
        if (list != null && !list.isEmpty()) {
            for (PageCopyData pageCopyData : list) {
                SpenWPage page = spenWNote.getPage(pageCopyData.getIndex());
                if (page.hasPDF()) {
                    return true;
                }
                ArrayList<SpenObjectBase> objectList = page.getObjectList();
                if (objectList != null && !objectList.isEmpty()) {
                    return true;
                }
                SpenObjectTextBox spenObjectTextBoxCopyBodyTextFrom = iSpenNoteTextManager.copyBodyTextFrom(pageCopyData.getIndex());
                if (spenObjectTextBoxCopyBodyTextFrom != null && isNotEmptyForText(spenObjectTextBoxCopyBodyTextFrom.getText())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasText(SpenWPage spenWPage) {
        if (spenWPage == null) {
            return false;
        }
        for (SpenObjectBase spenObjectBase : spenWPage.getObjectList(2)) {
            if (spenObjectBase != null && isNotEmptyForText(((SpenObjectTextBox) spenObjectBase).getText())) {
                return true;
            }
        }
        for (SpenObjectBase spenObjectBase2 : spenWPage.getObjectList(64)) {
            if (spenObjectBase2 != null && isNotEmptyForText(((SpenObjectShape) spenObjectBase2).getText())) {
                return true;
            }
        }
        for (SpenObjectBase spenObjectBase3 : spenWPage.getObjectList(4096)) {
            if (spenObjectBase3 != null && isNotEmptyForText(((SpenObjectWeb) spenObjectBase3).getUri())) {
                return true;
            }
        }
        for (SpenObjectBase spenObjectBase4 : spenWPage.getObjectList(65536)) {
            if (spenObjectBase4 != null && isNotEmptyForText(((SpenObjectLink) spenObjectBase4).getTitle())) {
                return true;
            }
        }
        return false;
    }
}
