package com.samsung.android.support.senl.p148nt.app.lock.presenter.convert;

import android.content.Context;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDoc;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.support.senl.p145cm.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0011R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/presenter/convert/WrappedLockFileController;", "", "context", "Landroid/content/Context;", "docPath", "", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "mSpenWNote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "mSpenWNotePath", "mSpenSDoc", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDoc;", "filePath", "getFilePath", "()Ljava/lang/String;", "release", "", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nWrappedLockFileController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WrappedLockFileController.kt\ncom/samsung/android/support/senl/nt/app/lock/presenter/convert/WrappedLockFileController\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,91:1\n37#2:92\n36#2,3:93\n*S KotlinDebug\n*F\n+ 1 WrappedLockFileController.kt\ncom/samsung/android/support/senl/nt/app/lock/presenter/convert/WrappedLockFileController\n*L\n58#1:92\n58#1:93,3\n*E\n"})
public final class WrappedLockFileController {

    @NotNull
    private static final String TAG = "WrappedLockFileController";

    @Nullable
    private SpenSDoc mSpenSDoc;

    @Nullable
    private SpenWNote mSpenWNote;

    @Nullable
    private String mSpenWNotePath;

    public WrappedLockFileController(@Nullable Context context, @NotNull String docPath) {
        Intrinsics.checkNotNullParameter(docPath, "docPath");
        if (StringsKt.m14167w(docPath, ".sdocx")) {
            this.mSpenWNote = NotesUtils.getSpenWNote(context, docPath, false);
            this.mSpenWNotePath = docPath;
        } else if (StringsKt.m14167w(docPath, ".sdoc")) {
            this.mSpenSDoc = NotesUtils.INSTANCE.getSpenSDoc(context, docPath);
        }
    }

    @NotNull
    public final String getFilePath() {
        String boundFilePath;
        try {
            SpenWNote spenWNote = this.mSpenWNote;
            if (spenWNote != null) {
                Intrinsics.checkNotNull(spenWNote);
                boundFilePath = spenWNote.getAttachedFile(Constants.SNote.WNOTE_LOCKED_FILE_KEY);
            } else {
                SpenSDoc spenSDoc = this.mSpenSDoc;
                if (spenSDoc == null) {
                    return "";
                }
                Intrinsics.checkNotNull(spenSDoc);
                boundFilePath = spenSDoc.getBoundFilePath(Constants.SNote.SDOC_LOCKED_FILE_KEY);
                Intrinsics.checkNotNull(boundFilePath);
            }
        } catch (IllegalArgumentException e) {
            AbstractC6670b.m4738C("getFilePath, e: ", e.getMessage(), TAG);
            boundFilePath = "";
        }
        if (TextUtils.isEmpty(boundFilePath)) {
            MainLogger.m7259w(TAG, "getFilePath, file path is empty");
            return boundFilePath;
        }
        String separator = File.separator;
        Intrinsics.checkNotNullExpressionValue(separator, "separator");
        String strSubstring = boundFilePath.substring(0, StringsKt.m14131E(separator, 0, 6, boundFilePath) + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        String strM756B = AbstractC0541b.m756B(strSubstring, ((String[]) AbstractC12991c.m13999t(2, Log.TAG_SEPARATOR, FileUtils.extractFile(boundFilePath)).toArray(new String[0]))[1]);
        try {
            FileUtils.forceRenameTo(boundFilePath, strM756B);
            return strM756B;
        } catch (IOException e2) {
            AbstractC6670b.m4738C("getFilePath# IOException e: ", e2.getMessage(), TAG);
            return "";
        }
    }

    public final void release() {
        if (this.mSpenWNotePath != null) {
            try {
                DocumentFileManager documentFileManager = DocumentFileManager.getInstance();
                String str = this.mSpenWNotePath;
                Intrinsics.checkNotNull(str);
                documentFileManager.close(str, this.mSpenWNote, true);
            } catch (Exception e) {
                AbstractC6670b.m4738C("releaseDocFile# fail to close SpenWnote, e : ", e.getMessage(), TAG);
            }
        }
        SpenSDoc spenSDoc = this.mSpenSDoc;
        if (spenSDoc != null) {
            Intrinsics.checkNotNull(spenSDoc);
            if (spenSDoc.isClosed()) {
                return;
            }
            try {
                SpenSDoc spenSDoc2 = this.mSpenSDoc;
                if (spenSDoc2 != null) {
                    spenSDoc2.close(true);
                }
            } catch (IOException e2) {
                AbstractC6670b.m4738C("releaseDocFile# fail to close SpenSDoc,  e : ", e2.getMessage(), TAG);
            }
        }
    }
}
