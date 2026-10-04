package com.samsung.android.support.senl.p148nt.app.sync.memoconvert;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager;
import com.samsung.android.sdk.composer.pdf.SpenNotePdfImport;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.document.memoconverter.ProgressListener;
import com.samsung.android.support.senl.document.memoconverter.core.Converter;
import com.samsung.android.support.senl.document.util.SDocUtil;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.DocumentConstructor;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.WDocUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentWriteResolver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class QMemoConverter {
    private static final int DEFAULT_HEIGHT = 1527;
    private static final int DEFAULT_WIDTH = 1080;
    public static final String[] QUICK_MEMO_COLUMNS = {"title", "createdAt", "lastModifiedAt", "category", "uuid", NotesConstants.KEY_FOLDER_UUID, "content"};
    private static final String TAG = "SS$QMemoConverter";
    private final SpenNotePdfImport mSPenNotePdfImport = new SpenNotePdfImport(BaseUtils.getApplicationContext());

    public QMemoConverter(Context context) {
        Converter.loadSpenSDK(context);
    }

    private void addPageToSPenWNote(@NonNull SpenWNote spenWNote) {
        spenWNote.appendPage(1080, DEFAULT_HEIGHT);
    }

    @NonNull
    private SpenWNote createEmptySPenWNoteForPdfImport(String str) {
        SpenWNote.PageMode pageMode = getPageMode(str);
        SpenWNote spenWNoteMakeSpenWNote = DocumentConstructor.makeSpenWNote(BaseUtils.getApplicationContext(), pageMode, SpenWNote.Orientation.PORTRAIT, 1080, false);
        int i = SpenWNote.PageMode.SINGLE == pageMode ? 1 : 2;
        for (int i2 = 0; i2 < i; i2++) {
            addPageToSPenWNote(spenWNoteMakeSpenWNote);
        }
        spenWNoteMakeSpenWNote.invertBackgroundColor(isNeedToInvertBackgroundColor());
        return spenWNoteMakeSpenWNote;
    }

    @NonNull
    private NotesDocumentEntity createNotesDocumentEntityForImportPdf(String str, String str2, String str3, long j, long j2) {
        NotesDocumentEntity notesDocumentEntity = new NotesDocumentEntity();
        notesDocumentEntity.setId(null);
        notesDocumentEntity.setUuid(str);
        notesDocumentEntity.setFilePath(str2);
        notesDocumentEntity.setCategoryUuid(str3);
        notesDocumentEntity.setCreatedAt(j);
        notesDocumentEntity.setLastModifiedAt(j2);
        return notesDocumentEntity;
    }

    public static int getMemoCount(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(AbstractC0541b.m756B(str, "/memo.json")));
            try {
                FileChannel channel = fileInputStream.getChannel();
                int length = new JSONObject(Charset.defaultCharset().decode(channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size())).toString()).getJSONArray("MemoList").length();
                fileInputStream.close();
                return length;
            } finally {
            }
        } catch (IOException | JSONException e) {
            AbstractC0000a.m21r(e, new StringBuilder("getMemoCount IOException JSONException "), TAG);
            return -1;
        }
    }

    @NonNull
    private String getNewDocPath(String str) {
        return WDocUtils.getNoteFilePath(BaseUtils.getApplicationContext()) + FileUtils.extractFileName(str) + "_" + System.currentTimeMillis() + ".sdocx";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v2, types: [com.samsung.android.sdk.pen.worddoc.SpenWNote] */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    private String importPdfWithoutOpenComposer(String str, String str2, String str3, long j, long j2) throws Throwable {
        String str4;
        String strNewUUID;
        SpenWNote spenWNoteCreateEmptySPenWNoteForPdfImport;
        ?? r13;
        Throwable th;
        boolean zSaveToDB;
        String newDocPath;
        ?? r32 = 1;
        r32 = 1;
        r32 = 1;
         = 1;
         = 1;
        ?? r33 = 1;
        r32 = 1;
        try {
            try {
                try {
                    validatePdfImportAvailable(str);
                    strNewUUID = UUIDUtils.newUUID(BaseUtils.getApplicationContext());
                    try {
                        newDocPath = getNewDocPath(str);
                        spenWNoteCreateEmptySPenWNoteForPdfImport = createEmptySPenWNoteForPdfImport(str);
                        try {
                            spenWNoteCreateEmptySPenWNoteForPdfImport.getTitle().setText(str3);
                            spenWNoteCreateEmptySPenWNoteForPdfImport.setDisplayCreatedTime(j);
                            spenWNoteCreateEmptySPenWNoteForPdfImport.setDisplayModifiedTime(j2);
                            str4 = str;
                        } catch (Exception e) {
                            e = e;
                            str4 = str;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        str4 = str;
                        spenWNoteCreateEmptySPenWNoteForPdfImport = null;
                    }
                    try {
                        attachPdfFileToSPenWNote(spenWNoteCreateEmptySPenWNoteForPdfImport, str4, newDocPath);
                        zSaveToDB = saveToDB(createNotesDocumentEntityForImportPdf(strNewUUID, newDocPath, str2, j, j2), spenWNoteCreateEmptySPenWNoteForPdfImport);
                        boolean zIsClosed = spenWNoteCreateEmptySPenWNoteForPdfImport.isClosed();
                        r13 = spenWNoteCreateEmptySPenWNoteForPdfImport;
                        if (!zIsClosed) {
                            try {
                                spenWNoteCreateEmptySPenWNoteForPdfImport.close(true);
                                r13 = spenWNoteCreateEmptySPenWNoteForPdfImport;
                            } catch (IOException e3) {
                                StringBuilder sb = new StringBuilder("importPdfWithoutOpenComposer# finally: ");
                                AbstractC0000a.m20q(e3, sb, TAG);
                                r32 = sb;
                                r13 = spenWNoteCreateEmptySPenWNoteForPdfImport;
                            }
                        }
                    } catch (Exception e5) {
                        e = e5;
                        Debugger.m8609e(TAG, e.getMessage() + " pdfFilePath: " + Debugger.getEncode(str4));
                        if (spenWNoteCreateEmptySPenWNoteForPdfImport != null && !spenWNoteCreateEmptySPenWNoteForPdfImport.isClosed()) {
                            try {
                                spenWNoteCreateEmptySPenWNoteForPdfImport.close(true);
                            } catch (IOException e6) {
                                StringBuilder sb2 = new StringBuilder("importPdfWithoutOpenComposer# finally: ");
                                AbstractC0000a.m20q(e6, sb2, TAG);
                                r33 = sb2;
                            }
                        }
                        zSaveToDB = false;
                        r32 = r33;
                        r13 = spenWNoteCreateEmptySPenWNoteForPdfImport;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    th = th;
                    if (r13 != 0 || r13.isClosed()) {
                        throw th;
                    }
                    try {
                        r13.close(r32);
                        throw th;
                    } catch (IOException e7) {
                        AbstractC0000a.m20q(e7, new StringBuilder("importPdfWithoutOpenComposer# finally: "), TAG);
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                r13 = 0;
                th = th;
                if (r13 != 0) {
                    throw th;
                }
                throw th;
            }
        } catch (Exception e8) {
            e = e8;
            str4 = str;
            strNewUUID = null;
            spenWNoteCreateEmptySPenWNoteForPdfImport = null;
        }
        if (zSaveToDB) {
            return strNewUUID;
        }
        return null;
    }

    private boolean isNeedToInvertBackgroundColor() {
        return false;
    }

    private boolean saveToDB(NotesDocumentEntity notesDocumentEntity, SpenWNote spenWNote) {
        return DocumentWriteResolver.save(BaseUtils.getApplicationContext(), true, notesDocumentEntity.getFilePath(), notesDocumentEntity, spenWNote, (String) null, false, TAG);
    }

    public void attachPdfFileToSPenWNote(SpenWNote spenWNote, String str, String str2) throws Exception {
        this.mSPenNotePdfImport.setDocument(spenWNote);
        ISpenNotePdfManager.ResultType resultTypeAttachFile = this.mSPenNotePdfImport.attachFile(0, str, "");
        if (ISpenNotePdfManager.ResultType.RESULT_TYPE_SUCCESS == resultTypeAttachFile) {
            spenWNote.saveAsFile(str2);
            return;
        }
        Debugger.m8609e(TAG, "importPdfWithoutOpenComposer# attachFile errorCode: " + resultTypeAttachFile);
        throw new Exception("attachPdfFileToSPenWNote# attachFile errorCode: " + resultTypeAttachFile);
    }

    public boolean convertToSDoc(String str, ProgressListener progressListener) throws Throwable {
        String uuid;
        FileInputStream fileInputStream = new FileInputStream(new File(AbstractC0541b.m756B(str, "QuickMemoPlusBackup_rename.json")));
        try {
            FileChannel channel = fileInputStream.getChannel();
            String string = Charset.defaultCharset().decode(channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size())).toString();
            fileInputStream.close();
            JSONArray jSONArray = new JSONObject(string).getJSONArray("MemoList");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                ArrayList<String> arrayList = new ArrayList<>();
                String[] strArr = QUICK_MEMO_COLUMNS;
                String string2 = jSONObject.getString(strArr[0]);
                long j = jSONObject.getLong(strArr[1]);
                long j2 = jSONObject.getLong(strArr[2]);
                String string3 = jSONObject.getString(strArr[4]);
                try {
                    uuid = jSONObject.getString(strArr[5]);
                } catch (JSONException unused) {
                    Debugger.m8615i(TAG, "Skip categoryName");
                    uuid = null;
                }
                if (TextUtils.isEmpty(uuid)) {
                    uuid = PredefinedCategory.UNCATEGORIZED.getUuid();
                }
                String str2 = uuid;
                String string4 = jSONObject.getString(QUICK_MEMO_COLUMNS[6]);
                StringBuilder sbM1322o = AbstractC1974b.m1322o(i, " : content : ");
                sbM1322o.append(SDocUtil.logPath(string4));
                Debugger.m8615i(TAG, sbM1322o.toString());
                String strImportPdfWithoutOpenComposer = importPdfWithoutOpenComposer(str + string4, str2, string2, j, j2);
                if (TextUtils.isEmpty(strImportPdfWithoutOpenComposer)) {
                    Debugger.m8609e(TAG, i + " : failed to create a note = " + string3);
                } else {
                    arrayList.add(strImportPdfWithoutOpenComposer);
                }
                if (progressListener != null) {
                    Debugger.m8615i(TAG, i + " : old Uuid = " + string3 + " , uuidList = " + arrayList.toString());
                    progressListener.onProgress(i + 1, length, arrayList);
                }
            }
            return true;
        } finally {
        }
    }

    public SpenWNote.PageMode getPageMode(String str) {
        ISpenNotePdfManager.PageMode pageMode = this.mSPenNotePdfImport.getPageMode(str, "");
        return pageMode == ISpenNotePdfManager.PageMode.PAGE_MODE_LIST ? SpenWNote.PageMode.LIST : pageMode == ISpenNotePdfManager.PageMode.PAGE_MODE_SINGLE ? SpenWNote.PageMode.SINGLE : 1 == SharedPreferencesCompat.getInstance("Settings").getInt(SettingsConstants.SETTINGS_PREFERRED_NOTE_STYLE, 1) ? SpenWNote.PageMode.LIST : SpenWNote.PageMode.SINGLE;
    }

    public void validatePdfImportAvailable(String str) throws Exception {
        if (this.mSPenNotePdfImport.hasPassword(str)) {
            Debugger.m8609e(TAG, "validatePdfImportAvailable# pdf has password");
            throw new Exception("validatePdfImportAvailable# pdf has password");
        }
        if (ISpenNotePdfManager.ResultType.RESULT_TYPE_ERROR_PROTECTED != this.mSPenNotePdfImport.hasOwnerPermission(str, "")) {
            return;
        }
        Debugger.m8609e(TAG, "validatePdfImportAvailable# pdf has owner permission");
        throw new Exception("validatePdfImportAvailable# pdf has owner permission");
    }
}
