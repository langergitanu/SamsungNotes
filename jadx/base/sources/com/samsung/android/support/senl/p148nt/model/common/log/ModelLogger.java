package com.samsung.android.support.senl.p148nt.model.common.log;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ModelLogger extends DataLogger {
    protected static final String TAG = "ntModel$";

    public static String createConverterTag(@NonNull String str) {
        return AbstractC0541b.m772n("ntModel$CV$", str);
    }

    public static String createSecureFolderTag(@NonNull String str) {
        return AbstractC0541b.m772n("ntModel$SF$", str);
    }

    public static String createTag(@NonNull String str) {
        return AbstractC0541b.m772n(TAG, str);
    }

    public static String getContentLog(@NonNull SpenWNote spenWNote) {
        String str;
        StringBuilder sb = new StringBuilder(", [#CONT] pageMode: ");
        sb.append(spenWNote.getPageMode());
        sb.append(", pageC: ");
        sb.append(spenWNote.getPageCount());
        sb.append(", titLen: ");
        sb.append(getTextBoxLength(spenWNote.getTitle()));
        sb.append(", bodyTLen: ");
        sb.append(getTextBoxLength(spenWNote.getBodyText()));
        sb.append(", objC: ");
        sb.append(spenWNote.getAllObjectCount());
        sb.append(", isPdfR: ");
        sb.append(spenWNote.isPDFReaderMode());
        sb.append(", orient: ");
        sb.append(spenWNote.getOrientation());
        sb.append(", w: ");
        sb.append(spenWNote.getPageDefaultWidth());
        sb.append(", h: ");
        sb.append(spenWNote.getPageDefaultHeight());
        if (spenWNote.isCoeditMode()) {
            str = ", serverCP: " + spenWNote.getServerCheckPoint();
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(getVoiceRecordingLog(spenWNote));
        return sb.toString();
    }

    public static int getTextBoxLength(@Nullable SpenObjectTextBox spenObjectTextBox) {
        if (spenObjectTextBox == null) {
            return 0;
        }
        String text = spenObjectTextBox.getText();
        if (TextUtils.isEmpty(text)) {
            return 0;
        }
        return text.length();
    }

    private static String getVoiceRecordingLog(SpenWNote spenWNote) {
        StringBuilder sb = new StringBuilder();
        ArrayList<SpenVoiceData> voiceDataList = spenWNote.getVoiceDataList();
        if (voiceDataList != null) {
            for (SpenVoiceData spenVoiceData : voiceDataList) {
                sb.append(" / ");
                sb.append(spenVoiceData.getPlayTime());
            }
        }
        int iIndexOf = sb.indexOf(" / ");
        return ", voiceRec: [" + sb.toString().substring(iIndexOf < 0 ? 0 : iIndexOf + 3) + "]";
    }
}
