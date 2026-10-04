package com.samsung.android.support.senl.p148nt.model.utils;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.common.util.DataStrategy;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.data.common.constants.DocumentExtensionUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.SpenWNoteObjectHelper;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.document.save.DocumentPostSaveOperation;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DocumentCopyUtils {
    static final char CONTROL_CHARACTER = 11;
    private static final String TAG = ModelLogger.createTag("DocumentCopyUtils");
    private static Set<Character> sUnsupportedCharactersForCoeditNote = null;

    public static int canAllowToChangeCoedit(SpenWNote spenWNote) {
        if (spenWNote == null) {
            DataLogger.m12309w(TAG, "fail : canAllowToChangeCoedit, wNote is null");
            return 110;
        }
        int coeditXmlDataWeight = spenWNote.getCoeditXmlDataWeight();
        if (coeditXmlDataWeight > 30000) {
            DataLogger.m12309w(TAG, "fail : canAllowToChangeCoedit : weight = " + coeditXmlDataWeight);
            return 111;
        }
        int size = new SpenWNoteObjectHelper().getObjectList(spenWNote, 1).size();
        if (size > 15000) {
            DataLogger.m12309w(TAG, "fail : canAllowToChangeCoedit : stroke = " + size);
            return 112;
        }
        int size2 = new SpenWNoteObjectHelper().getObjectList(spenWNote, 8708).size();
        if (size2 <= 100) {
            return 101;
        }
        DataLogger.m12309w(TAG, "fail : canAllowToChangeCoedit : largeItemCount = " + size2);
        return 113;
    }

    public static boolean copy(Context context, String str, String str2) {
        return copy(context, str, str2, false);
    }

    private static void copyCoEditNote(Context context, String str, String str2) throws Throwable {
        String str3;
        Throwable th;
        IOException iOException;
        String str4;
        StringBuilder sb;
        SpenWNote spenWNoteOpen = null;
        try {
            try {
                str3 = str;
                try {
                    spenWNoteOpen = DocumentFileManager.getInstance().open(context, str3, 2160, 8500, true, true, true);
                    spenWNoteOpen.saveAsFile(str2);
                    try {
                        DocumentFileManager.getInstance().close(str3, spenWNoteOpen, true);
                    } catch (IOException e) {
                        iOException = e;
                        str4 = TAG;
                        sb = new StringBuilder("copyCoEditNote, close, e : ");
                        sb.append(iOException);
                        DataLogger.m12303e(str4, sb.toString());
                    }
                } catch (Exception e2) {
                    e = e2;
                    Exception exc = e;
                    DataLogger.m12303e(TAG, "copyCoEditNote, e: " + exc.getMessage());
                    try {
                        DocumentFileManager.getInstance().close(str3, spenWNoteOpen, true);
                    } catch (IOException e3) {
                        iOException = e3;
                        str4 = TAG;
                        sb = new StringBuilder("copyCoEditNote, close, e : ");
                        sb.append(iOException);
                        DataLogger.m12303e(str4, sb.toString());
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                th = th;
                try {
                    DocumentFileManager.getInstance().close(str3, spenWNoteOpen, true);
                    throw th;
                } catch (IOException e5) {
                    DataLogger.m12303e(TAG, "copyCoEditNote, close, e : " + e5);
                    throw th;
                }
            }
        } catch (Exception e6) {
            e = e6;
            str3 = str;
        } catch (Throwable th3) {
            th = th3;
            str3 = str;
            th = th;
            DocumentFileManager.getInstance().close(str3, spenWNoteOpen, true);
            throw th;
        }
    }

    public static boolean copyTo(@NonNull Context context, @NonNull SpenWNote spenWNote, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4) {
        String str5 = TAG;
        DataLogger.m12305f(str5, "copyTo, doc : " + spenWNote + ", srcUuid : " + str + ", newUuid : " + str2 + ", srcPath : " + DataLogger.getEncode(str3) + ", newPath : " + DataLogger.getEncode(str4));
        NotesDocumentEntity notesDocumentEntity = NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository().get(str);
        if (notesDocumentEntity == null) {
            return false;
        }
        DocumentFileManager.getInstance().copy(str3, str4);
        DataLogger.m12305f(str5, "copyTo, makeFile - success");
        NotesDocumentEntity notesDocumentEntityMo22193clone = notesDocumentEntity.mo22193clone();
        notesDocumentEntityMo22193clone.setId(null);
        notesDocumentEntityMo22193clone.setUuid(str2);
        notesDocumentEntityMo22193clone.setIsDirty(1);
        notesDocumentEntityMo22193clone.setFilePath(str4);
        boolean zSave = DocumentWriteResolver.save(context, true, str4, notesDocumentEntityMo22193clone, spenWNote, notesDocumentEntityMo22193clone.getLockAccountGuid(), true, str5);
        new DocumentPostSaveOperation(context, true, notesDocumentEntityMo22193clone, null).setStrategy(new DataStrategy(60).getMStrategy()).run();
        return zSave;
    }

    private static synchronized Set<Character> getUnsupportedCharactersForCoeditNote() {
        try {
            if (sUnsupportedCharactersForCoeditNote == null) {
                HashSet hashSet = new HashSet();
                sUnsupportedCharactersForCoeditNote = hashSet;
                hashSet.add(Character.valueOf(CONTROL_CHARACTER));
            }
        } catch (Throwable th) {
            throw th;
        }
        return sUnsupportedCharactersForCoeditNote;
    }

    public static void removeUnsupportedCharactersForCoedit(List<SpenObjectShape> list) {
        int i = 0;
        int size = 0;
        for (SpenObjectShape spenObjectShape : list) {
            String text = spenObjectShape.getText();
            if (!TextUtils.isEmpty(text)) {
                ArrayList arrayList = new ArrayList();
                for (int length = text.length() - 1; length >= 0; length--) {
                    char cCharAt = text.charAt(length);
                    Iterator<Character> it = getUnsupportedCharactersForCoeditNote().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (cCharAt == it.next().charValue()) {
                                arrayList.add(Integer.valueOf(length));
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    spenObjectShape.removeText(((Integer) it2.next()).intValue(), 1);
                }
                if (!arrayList.isEmpty()) {
                    i++;
                    size = arrayList.size() + size;
                }
            }
        }
        DataLogger.m12302d(TAG, "removeUnsupportedCharactersForCoedit, object/characters: " + i + "/" + size);
    }

    public static boolean copy(Context context, String str, String str2, boolean z) {
        if (!SpenSdkInitializer.initialize(context)) {
            return false;
        }
        if (!DocumentExtensionUtils.isSdocx(str) || !new File(str).isDirectory()) {
            BaseUtils.copyFile(str, str2);
            return true;
        }
        if (z) {
            copyCoEditNote(context, str, str2);
            return true;
        }
        DocumentFileManager.getInstance().copy(str, str2);
        return true;
    }

    public static String removeUnsupportedCharactersForCoedit(@NonNull String str) {
        int length = str.length();
        Iterator<Character> it = getUnsupportedCharactersForCoeditNote().iterator();
        while (it.hasNext()) {
            str = str.replace(String.valueOf(it.next().charValue()), "");
        }
        int length2 = str.length();
        DataLogger.m12302d(TAG, "removeUnsupportedCharactersForCoedit, src/dst: " + length + "/" + length2);
        return str;
    }

    public static CharSequence removeUnsupportedCharactersForCoedit(@NonNull SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length();
        ArrayList arrayList = new ArrayList();
        for (int i = length - 1; i >= 0; i--) {
            char cCharAt = spannableStringBuilder.charAt(i);
            Iterator<Character> it = getUnsupportedCharactersForCoeditNote().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (cCharAt == it.next().charValue()) {
                    arrayList.add(Integer.valueOf(i));
                    break;
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            int iIntValue = ((Integer) it2.next()).intValue();
            spannableStringBuilder.delete(iIntValue, iIntValue + 1);
        }
        int length2 = spannableStringBuilder.length();
        DataLogger.m12302d(TAG, "removeUnsupportedCharactersForCoedit, src/dst: " + length + "/" + length2);
        return spannableStringBuilder;
    }

    public static void removeUnsupportedCharactersForCoedit(SpenObjectTextBox spenObjectTextBox) {
        String text = spenObjectTextBox.getText();
        if (text == null) {
            return;
        }
        int length = text.length();
        for (int i = length - 1; i >= 0; i--) {
            char cCharAt = text.charAt(i);
            Iterator<Character> it = getUnsupportedCharactersForCoeditNote().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (cCharAt == it.next().charValue()) {
                        spenObjectTextBox.removeText(i, 1);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        String str = TAG;
        StringBuilder sbM778t = AbstractC0541b.m778t(length, "removeUnsupportedCharactersForCoedit, src/dst: ", "/");
        sbM778t.append(spenObjectTextBox.getText().length());
        DataLogger.m12302d(str, sbM778t.toString());
    }
}
