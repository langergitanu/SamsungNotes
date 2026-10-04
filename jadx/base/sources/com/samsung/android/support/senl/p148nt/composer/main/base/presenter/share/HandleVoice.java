package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.framework.provider.ShareFileProvider;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import com.samsung.android.support.senl.p148nt.stt.base.filedata.AISpeakerAtomHelper;
import com.samsung.android.support.senl.p148nt.stt.base.filedata.AISummarySectionAtomHelper;
import com.samsung.android.support.senl.p148nt.stt.base.filedata.AudioFormat;
import com.samsung.android.support.senl.p148nt.stt.base.filedata.M4aSerializableAtomHelper;
import com.samsung.android.support.senl.p148nt.stt.base.model.SpenVoiceTextDataReader;
import com.samsung.android.support.senl.p148nt.stt.base.model.SpenVoiceTextDataReaderCache;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import p022E1.C0079e;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HandleVoice {
    private static final String TAG = "HandleVoice";
    public static final String TEMP = "temp_";
    private ShareUriHelper mShareUriHelper;

    public HandleVoice(ShareUriHelper shareUriHelper) {
        this.mShareUriHelper = shareUriHelper;
    }

    private File getTempFile(String str) {
        int i;
        File file;
        int iLastIndexOf = str.lastIndexOf(46);
        try {
            i = Integer.parseInt(str.substring(iLastIndexOf - 1, iLastIndexOf)) + 1;
            iLastIndexOf--;
        } catch (Exception e) {
            Logger.m12711e(TAG, "getTempFile last index is not number: " + e.getMessage());
            i = 0;
        }
        do {
            file = new File(str.substring(0, iLastIndexOf) + i + AudioFormat.ExtType.EXT_M4A);
            i++;
        } while (file.exists());
        return file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$handleVoiceData$0(String str, Context context, String str2, SpenVoiceTextDataReader spenVoiceTextDataReader) {
        File tempFile;
        boolean zRemoveAtom;
        Logger.m12710d(TAG, "STT data already exists on " + str);
        String strGenerateUniqueFilePath = FileUtils.generateUniqueFilePath(ShareFileProvider.getShareDir(context).getAbsolutePath(), AbstractC0541b.m772n(TEMP, str), FileUtils.getFileExt(str2));
        File tempFile2 = getTempFile(str2);
        boolean z = (spenVoiceTextDataReader.getSummaryLines() == null || spenVoiceTextDataReader.getSummaryTitle() == null) ? false : true;
        boolean z2 = spenVoiceTextDataReader.getSpeakerNameMap() != null;
        if (z) {
            zRemoveAtom = new AISummarySectionAtomHelper(str2).removeAtom(tempFile2.getAbsolutePath());
            tempFile = getTempFile(tempFile2.getAbsolutePath());
        } else {
            tempFile = tempFile2;
            zRemoveAtom = true;
        }
        String absolutePath = z ? tempFile2.getAbsolutePath() : str2;
        boolean zRemoveAtom2 = z2 ? new AISpeakerAtomHelper(absolutePath).removeAtom(tempFile.getAbsolutePath()) : true;
        if (z2) {
            absolutePath = tempFile.getAbsolutePath();
        }
        if (!new M4aSerializableAtomHelper(absolutePath).removeSTTData(strGenerateUniqueFilePath) || !zRemoveAtom2 || !zRemoveAtom) {
            Logger.m12711e(TAG, "failed to make file VoiceRecordingCompat");
            return str2;
        }
        if (tempFile.delete() && tempFile2.delete()) {
            return strGenerateUniqueFilePath;
        }
        Logger.m12711e(TAG, "handleVoiceData can not delete temp file " + tempFile.getAbsolutePath() + SQLKeyword.COMMA + tempFile2.getAbsolutePath());
        return strGenerateUniqueFilePath;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$handleVoiceData$1(String str, Context context, String str2) {
        Logger.m12710d(TAG, "STT data not exists, writing recording mode for " + str);
        String strGenerateUniqueFilePath = FileUtils.generateUniqueFilePath(ShareFileProvider.getShareDir(context).getAbsolutePath(), AbstractC0541b.m772n(TEMP, str), FileUtils.getFileExt(str2));
        if (new M4aSerializableAtomHelper(str2).makeFileForVoiceRecordingApp(strGenerateUniqueFilePath)) {
            return strGenerateUniqueFilePath;
        }
        Logger.m12711e(TAG, "failed to make file VoiceRecordingCompat");
        return str2;
    }

    private void removeTempFile(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith(ShareFileProvider.getShareDir(context).getAbsolutePath() + "/temp_")) {
            File file = new File(str);
            if (!file.exists() || file.delete()) {
                return;
            }
            Logger.m12711e(TAG, "removeTempFile failed to tempFile");
        }
    }

    public void handleVoiceContent(Context context, ArrayList<Uri> arrayList, SpenObjectVoice spenObjectVoice, boolean z) {
        Uri contextShareUri = this.mShareUriHelper.getContextShareUri(z, context, spenObjectVoice.getAttachedFile(), spenObjectVoice.getTitle(), "audio/mp4");
        if (contextShareUri != null) {
            arrayList.add(contextShareUri);
        }
    }

    public void handleVoiceData(Context context, ArrayList<Uri> arrayList, SpenVoiceData spenVoiceData, boolean z, String str) {
        String attachedFile = spenVoiceData.getAttachedFile();
        String name = spenVoiceData.getName();
        SpenVoiceTextDataReader spenVoiceTextDataReader = SpenVoiceTextDataReaderCache.getInstance().get(spenVoiceData);
        String[] voiceTexts = spenVoiceTextDataReader.getVoiceTexts();
        int[] voiceTimes = spenVoiceTextDataReader.getVoiceTimes();
        try {
            if (voiceTexts == null || voiceTimes == null) {
                String str2 = (String) DocumentFileManager.getInstance().executeAction(str, new C9922a(name, context, attachedFile));
                Uri contextShareUri = this.mShareUriHelper.getContextShareUri(z, context, str2, name, "audio/mp4");
                if (contextShareUri != null) {
                    arrayList.add(contextShareUri);
                }
                removeTempFile(context, str2);
                return;
            }
            String str3 = (String) DocumentFileManager.getInstance().executeAction(str, new C0079e(this, name, context, attachedFile, spenVoiceTextDataReader));
            Uri contextShareUri2 = this.mShareUriHelper.getContextShareUri(z, context, str3, name, "audio/mp4");
            if (contextShareUri2 != null) {
                arrayList.add(contextShareUri2);
            }
            removeTempFile(context, str3);
        } catch (IOException e) {
            Logger.m12711e(TAG, "IOException exception = " + e.getMessage());
        }
    }
}
