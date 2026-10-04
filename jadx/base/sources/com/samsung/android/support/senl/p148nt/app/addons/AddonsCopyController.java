package com.samsung.android.support.senl.p148nt.app.addons;

import android.content.Context;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.framework.provider.ShareFileProvider;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0003\u001f !B\u001d\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0002J\u0006\u0010\u0015\u001a\u00020\u000fJ\u0010\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bJ\u0018\u0010\u0018\u001a\u00020\u000f2\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u001aH\u0002J\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u00020\u000fH\u0002J\u0006\u0010\u001e\u001a\u00020\u000fR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/addons/AddonsCopyController;", "", "mAppContext", "Landroid/content/Context;", "mProgressController", "Lcom/samsung/android/support/senl/nt/app/addons/AddonsProgressController;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/support/senl/nt/app/addons/AddonsProgressController;)V", "mCopyThread", "Lcom/samsung/android/support/senl/nt/app/addons/AddonsCopyController$CopyThread;", "mNowCopyingDstPath", "", "mCopyDstPaths", "", "copySdocToExternalDir", "", "uuid", "filePath", NotesConstants.KEY_CALLER, "Lcom/samsung/android/support/senl/nt/app/addons/AddonsCopyController$IAddonsCaller;", "createDstPath", "deleteAllTempFiles", "deleteFile", "path", "deleteFiles", "paths", "", "onBackPressed", "", "cancelCopyTask", "onDestroy", "IAddonsCaller", "CopyThread", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AddonsCopyController {

    @NotNull
    private static final String TAG = "AddonsCopyController";

    @Nullable
    private Context mAppContext;

    @NotNull
    private final Set<String> mCopyDstPaths = new HashSet();

    @Nullable
    private CopyThread mCopyThread;

    @Nullable
    private String mNowCopyingDstPath;

    @Nullable
    private AddonsProgressController mProgressController;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0002\u000b\fB%\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/addons/AddonsCopyController$CopyThread;", "Ljava/lang/Thread;", "mSrcPath", "", "mDstPath", "mListener", "Lcom/samsung/android/support/senl/nt/app/addons/AddonsCopyController$CopyThread$ICopyListener;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/samsung/android/support/senl/nt/app/addons/AddonsCopyController$CopyThread$ICopyListener;)V", "run", "", "ICopyListener", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class CopyThread extends Thread {

        @NotNull
        private static final String TAG = "CopyThread";

        @Nullable
        private final String mDstPath;

        @NotNull
        private final ICopyListener mListener;

        @Nullable
        private final String mSrcPath;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/addons/AddonsCopyController$CopyThread$ICopyListener;", "", "onFailed", "", "onFinished", "srcFile", "Ljava/io/File;", "dstFile", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public interface ICopyListener {
            void onFailed();

            void onFinished(@NotNull File srcFile, @NotNull File dstFile);
        }

        public CopyThread(@Nullable String str, @Nullable String str2, @NotNull ICopyListener mListener) {
            Intrinsics.checkNotNullParameter(mListener, "mListener");
            this.mSrcPath = str;
            this.mDstPath = str2;
            this.mListener = mListener;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                File file = new File(this.mSrcPath);
                File file2 = new File(this.mDstPath);
                FileUtils.copyFile(file, file2);
                if (isInterrupted()) {
                    return;
                }
                this.mListener.onFinished(file, file2);
            } catch (IOException e) {
                MainLogger.m7255e(TAG, e.getMessage());
                this.mListener.onFailed();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/addons/AddonsCopyController$IAddonsCaller;", "", "onAddonsCalled", "", "srcFile", "Ljava/io/File;", "dstFile", "onFailed", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IAddonsCaller {
        void onAddonsCalled(@NotNull File srcFile, @NotNull File dstFile);

        void onFailed();
    }

    public AddonsCopyController(@Nullable Context context, @Nullable AddonsProgressController addonsProgressController) {
        this.mAppContext = context;
        this.mProgressController = addonsProgressController;
    }

    private final void cancelCopyTask() {
        MainLogger.m7254d(TAG, "cancelCopyTask");
        CopyThread copyThread = this.mCopyThread;
        if (copyThread != null) {
            Intrinsics.checkNotNull(copyThread);
            if (copyThread.isAlive()) {
                CopyThread copyThread2 = this.mCopyThread;
                Intrinsics.checkNotNull(copyThread2);
                copyThread2.interrupt();
                this.mCopyThread = null;
            }
        }
        deleteFile(this.mNowCopyingDstPath);
        AddonsProgressController addonsProgressController = this.mProgressController;
        if (addonsProgressController != null) {
            addonsProgressController.hideProgress();
        }
    }

    private final String createDstPath(String uuid) {
        File externalDir;
        Context context = this.mAppContext;
        if (context != null) {
            ShareFileProvider.Companion companion = ShareFileProvider.INSTANCE;
            Intrinsics.checkNotNull(context);
            externalDir = companion.getExternalDir(context);
        } else {
            externalDir = null;
        }
        File file = new File(AbstractC0541b.m756B(externalDir != null ? externalDir.getPath() : null, AddonsConstants.ADDONS_TEMP_DIR_NAME));
        if (!file.exists()) {
            AbstractC6670b.m4739D("createDstPath, mkdir : ", TAG, file.mkdir());
        }
        return AbstractC2821a.m2221l(file.getPath(), File.separator, uuid, ".sdoc");
    }

    private final void deleteFiles(Collection<String> paths) {
        MainLogger.m7254d(TAG, "deleteFiles, size: " + paths.size());
        new SenlThreadFactory(TAG).newThread(new RunnableC8013a(paths, 0)).start();
        this.mCopyDstPaths.removeAll(paths);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteFiles$lambda$0(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            try {
                FileUtils.deleteFile(new File((String) it.next()));
            } catch (IOException e) {
                AbstractC6670b.m4738C("deleteTempFiles, e : ", e.getMessage(), TAG);
            }
        }
    }

    public final void copySdocToExternalDir(@NotNull String uuid, @Nullable String filePath, @NotNull final IAddonsCaller caller) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(caller, "caller");
        AddonsProgressController addonsProgressController = this.mProgressController;
        if (addonsProgressController != null) {
            addonsProgressController.showProgress();
        }
        String strCreateDstPath = createDstPath(uuid);
        this.mNowCopyingDstPath = strCreateDstPath;
        this.mCopyDstPaths.add(strCreateDstPath);
        CopyThread copyThread = new CopyThread(filePath, this.mNowCopyingDstPath, new CopyThread.ICopyListener() { // from class: com.samsung.android.support.senl.nt.app.addons.AddonsCopyController.copySdocToExternalDir.1
            @Override // com.samsung.android.support.senl.nt.app.addons.AddonsCopyController.CopyThread.ICopyListener
            public void onFailed() {
                MainLogger.m7254d(AddonsCopyController.TAG, "onFailed");
                if (AddonsCopyController.this.mProgressController != null) {
                    AddonsProgressController addonsProgressController2 = AddonsCopyController.this.mProgressController;
                    Intrinsics.checkNotNull(addonsProgressController2);
                    addonsProgressController2.hideProgress();
                    AddonsCopyController.this.mNowCopyingDstPath = null;
                }
                caller.onFailed();
            }

            @Override // com.samsung.android.support.senl.nt.app.addons.AddonsCopyController.CopyThread.ICopyListener
            public void onFinished(File srcFile, File dstFile) {
                Intrinsics.checkNotNullParameter(srcFile, "srcFile");
                Intrinsics.checkNotNullParameter(dstFile, "dstFile");
                AbstractC0000a.m25v("onCopyFinished : ", MainLogger.getEncode(dstFile.getAbsolutePath()), AddonsCopyController.TAG);
                caller.onAddonsCalled(srcFile, dstFile);
                if (AddonsCopyController.this.mProgressController != null) {
                    AddonsProgressController addonsProgressController2 = AddonsCopyController.this.mProgressController;
                    Intrinsics.checkNotNull(addonsProgressController2);
                    addonsProgressController2.hideProgress();
                    AddonsCopyController.this.mNowCopyingDstPath = null;
                }
            }
        });
        this.mCopyThread = copyThread;
        copyThread.start();
    }

    public final void deleteAllTempFiles() {
        MainLogger.m7254d(TAG, "deleteAllTempFiles");
        deleteFiles(new HashSet(this.mCopyDstPaths));
    }

    public final void deleteFile(@Nullable String path) {
        MainLogger.m7254d(TAG, "deleteFile : " + MainLogger.getEncode(path));
        if (TextUtils.isEmpty(path)) {
            return;
        }
        deleteFiles(CollectionsKt.listOf(path));
    }

    public final boolean onBackPressed() {
        AddonsProgressController addonsProgressController = this.mProgressController;
        if (addonsProgressController == null) {
            return false;
        }
        Intrinsics.checkNotNull(addonsProgressController);
        if (!addonsProgressController.isShowing()) {
            return false;
        }
        cancelCopyTask();
        return true;
    }

    public final void onDestroy() {
        cancelCopyTask();
        deleteAllTempFiles();
        this.mProgressController = null;
        this.mAppContext = null;
    }
}
