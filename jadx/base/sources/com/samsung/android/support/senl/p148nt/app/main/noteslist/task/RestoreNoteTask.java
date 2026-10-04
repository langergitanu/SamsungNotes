package com.samsung.android.support.senl.p148nt.app.main.noteslist.task;

import android.content.Context;
import com.samsung.android.sdk.pen.document.SpenBoundFileNotFoundException;
import com.samsung.android.sdk.pen.document.SpenInvalidCacheException;
import com.samsung.android.sdk.pen.document.SpenUnsupportedTypeException;
import com.samsung.android.sdk.pen.document.SpenUnsupportedVersionException;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\n\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001b\u001cB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\fJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0004H\u0002J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/task/RestoreNoteTask;", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask;", "", "srcPath", "", "<init>", "(Ljava/lang/String;)V", "result", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/task/RestoreNoteTask$Result;", "execute", "", "taskParams", "(Ljava/lang/Boolean;)V", "getWNoteRestored", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "context", "Landroid/content/Context;", "handleError", "exc", "", "closeWNote", "newSpenWNote", "docPath", "isSpenBoundFileNotFoundException", "isSpenInvalidCacheException", "getTag", "getResult", "Result", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nRestoreNoteTask.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RestoreNoteTask.kt\ncom/samsung/android/support/senl/nt/app/main/noteslist/task/RestoreNoteTask\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,99:1\n1#2:100\n*E\n"})
public final class RestoreNoteTask extends WorkerTask<Boolean> {

    @NotNull
    private static final String TAG = "RestoreNoteTask";

    @NotNull
    private final Result result;

    @NotNull
    private final String srcPath;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/task/RestoreNoteTask$Result;", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask$Result;", "hashCode", "", "<init>", "(I)V", "getHashCode", "()I", "mSuccess", "", "tag", "", "getTag", "()Ljava/lang/String;", "success", "getSuccess", "()Z", "setSuccess", "", "boolean", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Result implements WorkerTask.Result {
        private final int hashCode;
        private boolean mSuccess;

        public Result(int i) {
            this.hashCode = i;
        }

        @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Result
        public int getHashCode() {
            return this.hashCode;
        }

        /* JADX INFO: renamed from: getSuccess, reason: from getter */
        public final boolean getMSuccess() {
            return this.mSuccess;
        }

        @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Result
        @NotNull
        public String getTag() {
            return RestoreNoteTask.TAG;
        }

        public final void setSuccess(boolean z) {
            this.mSuccess = z;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RestoreNoteTask(@NotNull String srcPath) {
        super(0, null, 3, null);
        Intrinsics.checkNotNullParameter(srcPath, "srcPath");
        this.srcPath = srcPath;
        this.result = new Result(getHashCode());
    }

    private final void closeWNote(SpenWNote newSpenWNote, String docPath) {
        try {
            DocumentFileManager.getInstance().close(docPath, newSpenWNote, true);
        } catch (IOException e) {
            Logger.m11000e(TAG, "restoreNote# fail to close doc, error: " + e);
        }
    }

    private final SpenWNote getWNoteRestored(Context context, String srcPath) {
        SpenWNote spenWNoteOpen = DocumentFileManager.getInstance().open(context, srcPath, 1080, 1000, true, true, false);
        Intrinsics.checkNotNullExpressionValue(spenWNoteOpen, "open(...)");
        return spenWNoteOpen;
    }

    private final boolean handleError(Throwable exc) {
        Logger.m11000e(TAG, "handleError# " + exc);
        return isSpenBoundFileNotFoundException(exc) || isSpenInvalidCacheException(exc);
    }

    private final boolean isSpenBoundFileNotFoundException(Throwable exc) {
        return (exc instanceof SpenBoundFileNotFoundException) || Intrinsics.areEqual("E_BOUND_FILE_NOT_FOUND", exc.getMessage());
    }

    private final boolean isSpenInvalidCacheException(Throwable exc) {
        return (exc instanceof SpenInvalidCacheException) || Intrinsics.areEqual("E_INVALID_CACHE", exc.getMessage());
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    @NotNull
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    public void execute(@Nullable Boolean taskParams) {
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext == null) {
            return;
        }
        try {
            SpenWNote wNoteRestored = getWNoteRestored(applicationContext, this.srcPath);
            if (wNoteRestored != null) {
                closeWNote(wNoteRestored, this.srcPath);
            }
        } catch (SpenUnsupportedTypeException e) {
            this.result.setSuccess(handleError(e));
        } catch (SpenUnsupportedVersionException e2) {
            this.result.setSuccess(handleError(e2));
        } catch (IOException e3) {
            this.result.setSuccess(handleError(e3));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    @NotNull
    public Result getResult() {
        return this.result;
    }
}
