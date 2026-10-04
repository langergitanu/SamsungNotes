package com.samsung.android.support.senl.p148nt.data.common.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DataUtils {
    private static final String ANALYTIC_CONTENT_AUDIO = "Au";
    private static final String ANALYTIC_CONTENT_BRUSH = "Br";
    private static final String ANALYTIC_CONTENT_CODE_BLOCK = "CB";
    private static final String ANALYTIC_CONTENT_IMAGE = "Im";
    private static final String ANALYTIC_CONTENT_PDF = "PDF";
    private static final String ANALYTIC_CONTENT_RECORDING = "Vo";
    private static final String ANALYTIC_CONTENT_STICKY_NOTE = "SN";
    private static final String ANALYTIC_CONTENT_STROKE = "Pe";
    private static final String ANALYTIC_CONTENT_TABLE = "Tb";
    private static final String ANALYTIC_CONTENT_TEXT = "Ke";
    private static final String ANALYTIC_CONTENT_URL = "URL";
    private static final String ANALYTIC_CONTENT_WEB_CARD = "Wc";
    private static final String TAG = DataLogger.createTag("DataUtils");
    private static Context sAppContext = null;

    public static synchronized Context getContext() {
        return sAppContext;
    }

    public static String newUuid() {
        return UUIDUtils.newUUID(sAppContext);
    }

    public static void sendAnalytics(@NonNull SpenWNote spenWNote) {
        DataLogger.m12307i(TAG, "[sendAnalytics - start]");
        String text = spenWNote.getBodyText().getText();
        boolean zIsEmpty = TextUtils.isEmpty(spenWNote.getTitle().getText());
        boolean zIsEmptyBodyText = SpenWNoteObjectHelper.isEmptyBodyText(text);
        int iHasBodyObjects = spenWNote.hasBodyObjects(6304260);
        int iHasObjects = spenWNote.hasObjects(12805);
        boolean z = (iHasObjects & 1) != 0;
        boolean z2 = ((iHasBodyObjects & 8192) == 0 && (iHasObjects & 8192) == 0) ? false : true;
        boolean z3 = ((iHasBodyObjects & 4) == 0 && (iHasObjects & 4) == 0) ? false : true;
        boolean z4 = ((iHasBodyObjects & 512) == 0 && (iHasObjects & 512) == 0) ? false : true;
        boolean z5 = ((iHasBodyObjects & 4096) == 0 && (iHasObjects & 4096) == 0) ? false : true;
        ArrayList<SpenVoiceData> voiceDataList = spenWNote.getVoiceDataList();
        boolean z6 = (voiceDataList == null || voiceDataList.isEmpty()) ? false : true;
        boolean zHasCustomObject = spenWNote.hasCustomObject();
        boolean z7 = (2097152 & iHasBodyObjects) != 0;
        boolean z8 = (iHasBodyObjects & 4194304) != 0;
        boolean zHasPdfObject = spenWNote.hasPdfObject();
        boolean z9 = (spenWNote.hasHyperTextSpan(8) & 8) != 0;
        ArrayList arrayList = new ArrayList();
        if (!zIsEmptyBodyText) {
            arrayList.add(ANALYTIC_CONTENT_TEXT);
        }
        if (z) {
            arrayList.add("Pe");
        }
        if (z2) {
            arrayList.add(ANALYTIC_CONTENT_BRUSH);
        }
        if (z3) {
            arrayList.add(ANALYTIC_CONTENT_IMAGE);
        }
        if (z6) {
            arrayList.add(ANALYTIC_CONTENT_RECORDING);
        }
        if (zHasCustomObject) {
            arrayList.add(ANALYTIC_CONTENT_STICKY_NOTE);
        }
        if (z7) {
            arrayList.add(ANALYTIC_CONTENT_TABLE);
        }
        if (z8) {
            arrayList.add(ANALYTIC_CONTENT_CODE_BLOCK);
        }
        if (z4) {
            arrayList.add(ANALYTIC_CONTENT_AUDIO);
        }
        if (z5) {
            arrayList.add(ANALYTIC_CONTENT_WEB_CARD);
        }
        if (zHasPdfObject) {
            arrayList.add("PDF");
        }
        if (z9) {
            arrayList.add("URL");
        }
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            sb.append((String) arrayList.get(i));
            if (i < arrayList.size() - 1) {
                sb.append('_');
            }
        }
        NotesSamsungAnalytics.insertLog((String) null, "9915", !zIsEmpty ? "b" : "a");
        if (!TextUtils.isEmpty(sb.toString())) {
            DataLogger.m12307i(TAG, "[sendAnalytics - end] sendingString : " + ((Object) sb));
            NotesSamsungAnalytics.insertLog((String) null, "9917", sb.toString());
        }
        NotesSamsungAnalytics.insertLog((String) null, "9996", spenWNote.getPageMode() == SpenWNote.PageMode.LIST ? "1" : "2");
    }

    public static synchronized void setContext(Context context) {
        sAppContext = context;
    }
}
