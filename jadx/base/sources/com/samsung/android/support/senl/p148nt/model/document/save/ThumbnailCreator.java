package com.samsung.android.support.senl.p148nt.model.document.save;

import android.content.Context;
import android.content.Intent;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.samsung.android.sdk.composer.text.SpenBodyTextContext;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.PageCacheUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.common.utils.MainListThumbnailUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.collections.AbstractC12991c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ThumbnailCreator {
    private static final float A4_LANDSCAPE_RATIO = 0.7070707f;
    private static final String TAG = DataLogger.createTag("ThumbnailCreator");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class EditedInfo extends AbstractC12991c {
        private final RectF bodyTextRectF;
        private final int pageIndex;

        public EditedInfo(int i, RectF rectF) {
            this.pageIndex = i;
            this.bodyTextRectF = rectF;
        }

        public RectF bodyTextRectF() {
            return this.bodyTextRectF;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof EditedInfo)) {
                return false;
            }
            EditedInfo editedInfo = (EditedInfo) obj;
            return this.pageIndex == editedInfo.pageIndex && Objects.equals(this.bodyTextRectF, editedInfo.bodyTextRectF);
        }

        public final int hashCode() {
            int i = this.pageIndex;
            return Objects.hashCode(this.bodyTextRectF) + (i * 31);
        }

        public int pageIndex() {
            return this.pageIndex;
        }

        public final String toString() {
            Object[] objArr = {Integer.valueOf(this.pageIndex), this.bodyTextRectF};
            String[] strArrSplit = "pageIndex;bodyTextRectF".length() == 0 ? new String[0] : "pageIndex;bodyTextRectF".split(";");
            StringBuilder sb = new StringBuilder();
            sb.append(EditedInfo.class.getSimpleName());
            sb.append("[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb.append(strArrSplit[i]);
                sb.append(MarketingConstants.REFERRER_DELIMITER_U003D);
                sb.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb.append(SQLKeyword.COMMA);
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

    private void deleteAttachedImageFile(Context context, String str) {
        FileUtils.deleteFile(PageCacheUtils.getCacheDirectory(context, str, Constants.MAIN_THUMBNAIL_PATH) + File.separator + "image");
    }

    public static EditedInfo getEditedInfo(@NonNull Context context, @NonNull SpenWNote spenWNote) {
        SpenBodyTextContext spenBodyTextContext;
        RectF rectF = new RectF();
        if (spenWNote.getPageCount() <= 0) {
            return new EditedInfo(-1, rectF);
        }
        SpenBodyTextContext spenBodyTextContext2 = null;
        try {
            try {
                setDefaultDocumentSize(spenWNote);
                spenBodyTextContext = new SpenBodyTextContext(context);
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            spenBodyTextContext.setDocument(spenWNote);
            ArrayList<SpenWPage> pageList = spenWNote.getPageList();
            int i = 0;
            for (int i2 = 0; i2 < pageList.size(); i2++) {
                SpenWPage spenWPage = pageList.get(i2);
                spenBodyTextContext.measureTextToPage(i2);
                rectF = spenBodyTextContext.getMeasuredFitRect(i2);
                if (spenWPage.getDrawnRectOfAllObject().isEmpty() && rectF.isEmpty() && !spenWPage.hasPDF() && !PageThumbnailSaver.hasTemplate(spenWPage)) {
                }
                i = i2;
            }
            DataLogger.m12302d(TAG, "saveThumbnail# index : " + i);
            spenBodyTextContext.close();
            return new EditedInfo(i, rectF);
        } catch (Exception e2) {
            e = e2;
            spenBodyTextContext2 = spenBodyTextContext;
            DataLogger.m12303e(TAG, "saveThumbnail, fail to get edited index, e : " + e.getMessage());
            EditedInfo editedInfo = new EditedInfo(-1, rectF);
            if (spenBodyTextContext2 != null) {
                spenBodyTextContext2.close();
            }
            return editedInfo;
        } catch (Throwable th2) {
            th = th2;
            spenBodyTextContext2 = spenBodyTextContext;
            if (spenBodyTextContext2 != null) {
                spenBodyTextContext2.close();
            }
            throw th;
        }
    }

    private boolean hasTextWithObjectSpan(SpenWNote spenWNote, int i) {
        ArrayList<SpenObjectSpan> arrayListFindObjectSpan;
        SpenWNote.PageMode pageMode = spenWNote.getPageMode();
        SpenObjectTextBox bodyText = spenWNote.getBodyText();
        if (bodyText.getText() == null) {
            DataLogger.m12302d(TAG, "hasTextWithObjectSpan# body text is null, false");
            return false;
        }
        String str = TAG;
        DataLogger.m12302d(str, "hasTextWithObjectSpan# start, pageMode : " + pageMode);
        if (pageMode == SpenWNote.PageMode.SINGLE) {
            arrayListFindObjectSpan = bodyText.findObjectSpan(0, 300);
        } else {
            int textSectionStart = bodyText.getTextSectionStart(i);
            arrayListFindObjectSpan = textSectionStart >= 0 ? bodyText.findObjectSpan(textSectionStart, (bodyText.getTextSectionLength(i) + textSectionStart) - 1) : bodyText.findObjectSpan(0, 300);
        }
        if (arrayListFindObjectSpan != null && !arrayListFindObjectSpan.isEmpty()) {
            return true;
        }
        DataLogger.m12302d(str, "hasTextWithObjectSpan# objectSpanList isEmpty, false");
        return false;
    }

    public static void sendForceUpdateBroadcast(@NonNull Context context, NotesDocumentEntity notesDocumentEntity) {
        DataLogger.m12302d(TAG, "sendForceUpdateBroadcast, entity : " + notesDocumentEntity);
        if (notesDocumentEntity == null) {
            return;
        }
        Intent intent = new Intent("com.samsung.android.app.notes.memolist.ACTION_FORCE_UPDATE");
        intent.putExtra("sdoc_uuid", notesDocumentEntity.getUuid());
        intent.putExtra("doc_path", notesDocumentEntity.getFilePath());
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    private static void setDefaultDocumentSize(SpenWNote spenWNote) {
        float f;
        float f4;
        if (spenWNote.getPageMode() == SpenWNote.PageMode.SINGLE) {
            return;
        }
        SpenWNote.Orientation orientation = spenWNote.getOrientation();
        int pageDefaultWidth = spenWNote.getPageDefaultWidth();
        if (pageDefaultWidth == 0) {
            pageDefaultWidth = 1080;
        }
        if (orientation == SpenWNote.Orientation.PORTRAIT) {
            f = pageDefaultWidth;
            f4 = 1.4142857f;
        } else {
            f = pageDefaultWidth;
            f4 = A4_LANDSCAPE_RATIO;
        }
        int i = (int) (f * f4);
        spenWNote.setPageDefaultWidth(pageDefaultWidth);
        spenWNote.setPageDefaultHeight(i);
    }

    public void saveThumbnail(@NonNull Context context, @NonNull SpenWNote spenWNote, String str) {
        saveThumbnail(context, spenWNote, str, getEditedInfo(context, spenWNote));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0054 A[PHI: r2 r4 r6
      0x0054: PHI (r2v8 com.samsung.android.support.senl.nt.model.document.save.PageThumbnailSaver) = 
      (r2v7 com.samsung.android.support.senl.nt.model.document.save.PageThumbnailSaver)
      (r2v7 com.samsung.android.support.senl.nt.model.document.save.PageThumbnailSaver)
      (r2v3 com.samsung.android.support.senl.nt.model.document.save.PageThumbnailSaver)
      (r2v3 com.samsung.android.support.senl.nt.model.document.save.PageThumbnailSaver)
     binds: [B:36:0x0083, B:37:0x0085, B:17:0x0047, B:19:0x004d] A[DONT_GENERATE, DONT_INLINE]
      0x0054: PHI (r4v9 android.content.Context) = 
      (r4v14 android.content.Context)
      (r4v15 android.content.Context)
      (r4v16 android.content.Context)
      (r4v17 android.content.Context)
     binds: [B:36:0x0083, B:37:0x0085, B:17:0x0047, B:19:0x004d] A[DONT_GENERATE, DONT_INLINE]
      0x0054: PHI (r6v7 java.lang.String) = (r6v6 java.lang.String), (r6v6 java.lang.String), (r6v9 java.lang.String), (r6v9 java.lang.String) binds: [B:36:0x0083, B:37:0x0085, B:17:0x0047, B:19:0x004d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0094  */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v7, types: [android.content.Context] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void saveThumbnail(@NonNull Context context, SpenWNote spenWNote, String str, @NonNull EditedInfo editedInfo) {
        Object obj;
        String str2;
        Context context2;
        Throwable th;
        Exception exc;
        ?? r4;
        Context context3;
        Context context4;
        PageThumbnailSaver pageThumbnailSaver;
        List<String> listRun;
        String str3 = TAG;
        DataLogger.m12308p(str3, "saveThumbnail - start");
        if (spenWNote == null || editedInfo.pageIndex < 0) {
            DataLogger.m12303e(str3, "saveThumbnail# fail - invalid note");
            return;
        }
        try {
            deleteAttachedImageFile(context, str);
        } catch (Exception e) {
            obj = "saveThumbnail, deleteAttachedImageFile failed - e : ";
            AbstractC11014a.m12333r(e, new StringBuilder("saveThumbnail, deleteAttachedImageFile failed - e : "), TAG);
        }
        PageThumbnailSaver pageThumbnailSaver2 = null;
        try {
            try {
                context2 = context;
                str2 = str;
                try {
                    pageThumbnailSaver = new PageThumbnailSaver(context2, spenWNote, str2, editedInfo.pageIndex, editedInfo.bodyTextRectF, hasTextWithObjectSpan(spenWNote, editedInfo.pageIndex));
                } catch (Exception e2) {
                    e = e2;
                    exc = e;
                    context3 = context2;
                    DataLogger.m12303e(TAG, "saveThumbnail, PageThumbnailSaver failed - e : " + exc.getMessage());
                    context4 = context3;
                    if (pageThumbnailSaver2 != null) {
                        pageThumbnailSaver2.release();
                        context4 = context3;
                    }
                    MainListThumbnailUtils.removePreviousThumbnailFile(context4, str2);
                    obj = context4;
                    DataLogger.m12308p(TAG, "saveThumbnail - end");
                }
            } catch (Throwable th2) {
                th = th2;
                th = th;
                r4 = obj;
                if (pageThumbnailSaver2 != null) {
                    pageThumbnailSaver2.release();
                }
                MainListThumbnailUtils.removePreviousThumbnailFile(r4, str2);
                throw th;
            }
            try {
                listRun = pageThumbnailSaver.run();
                pageThumbnailSaver.release();
                context4 = context2;
            } catch (Exception e3) {
                exc = e3;
                pageThumbnailSaver2 = pageThumbnailSaver;
                context3 = context2;
                DataLogger.m12303e(TAG, "saveThumbnail, PageThumbnailSaver failed - e : " + exc.getMessage());
                context4 = context3;
                if (pageThumbnailSaver2 != null) {
                }
            } catch (Throwable th3) {
                th = th3;
                pageThumbnailSaver2 = pageThumbnailSaver;
                r4 = context2;
                if (pageThumbnailSaver2 != null) {
                }
                MainListThumbnailUtils.removePreviousThumbnailFile(r4, str2);
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            context2 = context;
            str2 = str;
        } catch (Throwable th4) {
            th = th4;
            obj = context;
            str2 = str;
            th = th;
            r4 = obj;
            if (pageThumbnailSaver2 != null) {
            }
            MainListThumbnailUtils.removePreviousThumbnailFile(r4, str2);
            throw th;
        }
        if (listRun != null) {
            context4 = context2;
            if (listRun.isEmpty()) {
                MainListThumbnailUtils.removePreviousThumbnailFile(context4, str2);
                obj = context4;
            } else {
                MainListThumbnailUtils.removePreviousThumbnailFile(context2, str2, listRun);
                obj = context2;
            }
        }
        DataLogger.m12308p(TAG, "saveThumbnail - end");
    }
}
