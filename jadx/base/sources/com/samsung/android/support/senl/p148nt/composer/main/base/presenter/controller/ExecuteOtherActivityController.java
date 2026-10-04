package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.addons.executor.BrushExecuteIntentBuilder;
import com.samsung.android.support.senl.addons.executor.IBrushExecuteIntentBuilder;
import com.samsung.android.support.senl.p145cm.base.common.method.CloseableActivity;
import com.samsung.android.support.senl.p148nt.base.common.ApplicationManager;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.PageCacheUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectFindUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerCacheFileUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerRequestCode;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.NoteStyleActivity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ExecuteOtherActivityController {
    private static final String FILE_DAT = "BrushInfo.dat";
    private static final String TAG = Logger.createTag("ExecuteOtherActivityController");
    private Activity mActivity;
    private ComposerModel mComposerModel;
    private PageManager mPageManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BrushExecuteInfo implements Serializable {
        private static final long serialVersionUID = 1;
        private final int mCurrentPageIndex;
        private final String mInputBrushPath;
        private final String mInputThumbPath;
        private final String mObjectId;
        private final String mOutputBrushPath;
        private final String mOutputThumbPath;
        private final String mUuid;

        public BrushExecuteInfo(String str, String str2, String str3, String str4, String str5, String str6, int i) {
            this.mUuid = str;
            this.mObjectId = str2;
            this.mInputBrushPath = str3;
            this.mInputThumbPath = str4;
            this.mOutputBrushPath = str5;
            this.mOutputThumbPath = str6;
            this.mCurrentPageIndex = i;
        }

        public int getCurrentPageIndex() {
            return this.mCurrentPageIndex;
        }

        public String getInputBrushPath() {
            return this.mInputBrushPath;
        }

        public String getInputThumbPath() {
            return this.mInputThumbPath;
        }

        public String getObjectId() {
            return this.mObjectId;
        }

        public String getOutputBrushPath() {
            return this.mOutputBrushPath;
        }

        public String getOutputThumbPath() {
            return this.mOutputThumbPath;
        }

        public String getUuid() {
            return this.mUuid;
        }
    }

    public static void deleteBrushFileInfo(Activity activity, String str) {
        String cacheDirectory = PageCacheUtils.getCacheDirectory(activity, str);
        StringBuilder sb = new StringBuilder();
        sb.append(new File(cacheDirectory).getAbsolutePath());
        File file = new File(AbstractC0622a.m1170p(File.separator, FILE_DAT, sb));
        if (file.exists()) {
            try {
                file.delete();
            } catch (Exception e) {
                Logger.m11001e(TAG, e.getMessage(), e);
            }
        }
    }

    public static boolean executeBrushStatic(Activity activity, String str, String str2, String str3, String str4, int i) {
        if (activity == null) {
            Logger.m10999d(TAG, "executeBrush, mActivity is null");
            return false;
        }
        String paintingDir = ComposerCacheFileUtil.getPaintingDir(activity);
        String cacheDirectory = PageCacheUtils.getCacheDirectory(activity, str);
        String str5 = new SimpleDateFormat("yyMMdd_HHmmss_SSS", Locale.ENGLISH).format(new Date());
        Logger.m10999d(TAG, "executeBrushStatic : " + str5);
        String strGenerateUniqueFilePath = FileUtils.generateUniqueFilePath(new File(paintingDir).getAbsolutePath(), str5, "spp");
        String strGenerateUniqueFilePath2 = FileUtils.generateUniqueFilePath(new File(paintingDir).getAbsolutePath(), str5, "jpg");
        saveBrushFileInfo(new BrushExecuteInfo(str, str2, str3, str4, strGenerateUniqueFilePath, strGenerateUniqueFilePath2, i), cacheDirectory);
        activity.startActivityForResult(new BrushExecuteIntentBuilder().setInputPaintingDocPath(str3).setInputThumbnailPath(str4).setOutputThumbnailPath(strGenerateUniqueFilePath2).setOutputPaintingDocPath(strGenerateUniqueFilePath).setInternalPath(paintingDir).build(activity), ComposerRequestCode.BrushDrawing.getId());
        return true;
    }

    private SpenObjectBase getPaintingObjectWithId(SpenWNote spenWNote, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return ObjectFindUtil.getObject(spenWNote, 8192, 14, str, new ObjectFindUtil.Finder() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.ExecuteOtherActivityController.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.object.ObjectFindUtil.Finder
            public boolean find(@NonNull String str2, SpenObjectBase spenObjectBase) {
                return str2.equals(spenObjectBase.getId());
            }
        });
    }

    public static BrushExecuteInfo loadBrushFileInfo(String str) throws Throwable {
        StringBuilder sb = new StringBuilder();
        sb.append(new File(str).getAbsolutePath());
        File file = new File(AbstractC0622a.m1170p(File.separator, FILE_DAT, sb));
        BrushExecuteInfo brushExecuteInfo = null;
        if (!file.exists()) {
            return null;
        }
        Logger.m10999d(TAG, "loadBrushFileInfo# start");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                try {
                    BrushExecuteInfo brushExecuteInfo2 = (BrushExecuteInfo) objectInputStream.readObject();
                    try {
                        objectInputStream.close();
                        try {
                            fileInputStream.close();
                            return brushExecuteInfo2;
                        } catch (IOException | ClassNotFoundException e) {
                            e = e;
                            brushExecuteInfo = brushExecuteInfo2;
                            Logger.m11001e(TAG, e.getMessage(), e);
                            return brushExecuteInfo;
                        }
                    } catch (Throwable th) {
                        th = th;
                        brushExecuteInfo = brushExecuteInfo2;
                        try {
                            fileInputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream.close();
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
        } catch (ClassNotFoundException e3) {
            e = e3;
        }
    }

    private static void saveBrushFileInfo(BrushExecuteInfo brushExecuteInfo, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(new File(str).getAbsolutePath());
        File file = new File(AbstractC0622a.m1170p(File.separator, FILE_DAT, sb));
        if (!file.exists()) {
            try {
                if (!file.createNewFile()) {
                    return;
                }
            } catch (IOException e) {
                Logger.m11001e(TAG, e.getMessage(), e);
                return;
            }
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                try {
                    objectOutputStream.writeObject(brushExecuteInfo);
                    objectOutputStream.close();
                    fileOutputStream.close();
                } finally {
                }
            } finally {
            }
        } catch (IOException e2) {
            Logger.m11001e(TAG, e2.getMessage(), e2);
        }
    }

    public boolean executeBrush(String str, String str2, String str3) {
        if (this.mComposerModel.isRunningDrawing()) {
            Logger.m11000e(TAG, "executeBrush, brush is already called");
            return false;
        }
        Logger.m10999d(TAG, "executeBrush");
        boolean zExecuteBrushStatic = executeBrushStatic(this.mActivity, this.mComposerModel.getDocInfo().getUuid(), str, str2, str3, this.mPageManager.getDocPageInfo().getCurrentPageIndex());
        this.mComposerModel.setRunningDrawing(zExecuteBrushStatic);
        return zExecuteBrushStatic;
    }

    public void finishBrush(@Nullable CloseableActivity.Callback callback) {
        finishBrush(true, callback);
    }

    public boolean finishCoverEditor() {
        if (this.mActivity != null && this.mComposerModel.isRunningCoverEditor()) {
            Intent intent = new Intent(this.mActivity, (Class<?>) NoteStyleActivity.class);
            intent.putExtra(ComposerConstants.ARG_COVER_EDITOR_FORCE_FINISH, true);
            intent.setFlags(603979776);
            this.mActivity.startActivity(intent);
            Logger.m10999d(TAG, "finishCoverEditor");
            return true;
        }
        String str = TAG;
        StringBuilder sb = new StringBuilder("cannot finishCoverEditor : null activity ? ");
        sb.append(this.mActivity == null);
        sb.append(" or not cover ? ");
        sb.append(this.mComposerModel.isRunningCoverEditor());
        Logger.m10999d(str, sb.toString());
        return false;
    }

    public SpenObjectBase getPaintingObjectWithPaintingDocPath(SpenWNote spenWNote, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return ObjectFindUtil.getObject(spenWNote, 8192, 14, str, new ObjectFindUtil.Finder() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.ExecuteOtherActivityController.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.object.ObjectFindUtil.Finder
            public boolean find(@NonNull String str2, SpenObjectBase spenObjectBase) {
                return str2.equals(spenObjectBase.getAttachedFile());
            }
        });
    }

    public void init(ComposerModel composerModel, PageManager pageManager) {
        this.mComposerModel = composerModel;
        this.mPageManager = pageManager;
    }

    public void onAttachView(Activity activity) {
        this.mActivity = activity;
    }

    public void onDetachView() {
        this.mActivity = null;
    }

    public void releaseExecutedBrush() {
        this.mComposerModel.setRunningDrawing(false);
        deleteBrushFileInfo(this.mActivity, this.mComposerModel.getDocInfo().getUuid());
        Logger.m10999d(TAG, "releaseExecutedBrush");
    }

    public void updateBrushFileInfo(Activity activity, String str, SpenWNote spenWNote, ObjectManager objectManager) {
        BrushExecuteInfo brushExecuteInfoLoadBrushFileInfo;
        String str2;
        String str3;
        String cacheDirectory = PageCacheUtils.getCacheDirectory((Context) activity, str, false);
        if (AbstractC2322a.m1607A(cacheDirectory) && (brushExecuteInfoLoadBrushFileInfo = loadBrushFileInfo(cacheDirectory)) != null) {
            String inputThumbPath = brushExecuteInfoLoadBrushFileInfo.getInputThumbPath();
            String inputBrushPath = brushExecuteInfoLoadBrushFileInfo.getInputBrushPath();
            String outputThumbPath = brushExecuteInfoLoadBrushFileInfo.getOutputThumbPath();
            String outputBrushPath = brushExecuteInfoLoadBrushFileInfo.getOutputBrushPath();
            if (!FileUtils.exists(outputThumbPath) || !FileUtils.exists(outputBrushPath)) {
                deleteBrushFileInfo(activity, str);
                Logger.m11004w(TAG, "updateBrushFileInfo# output path invalid ");
                return;
            }
            int currentPageIndex = brushExecuteInfoLoadBrushFileInfo.getCurrentPageIndex();
            int i = spenWNote.getPageCount() <= currentPageIndex ? 0 : currentPageIndex;
            if (brushExecuteInfoLoadBrushFileInfo.getInputBrushPath() == null || TextUtils.isEmpty(brushExecuteInfoLoadBrushFileInfo.getObjectId())) {
                str2 = inputThumbPath;
                str3 = inputBrushPath;
            } else {
                SpenObjectBase paintingObjectWithId = getPaintingObjectWithId(spenWNote, brushExecuteInfoLoadBrushFileInfo.getObjectId());
                if (paintingObjectWithId != null) {
                    objectManager.setClickedObject(paintingObjectWithId);
                    objectManager.addPainting(i, brushExecuteInfoLoadBrushFileInfo.getInputThumbPath(), outputThumbPath, brushExecuteInfoLoadBrushFileInfo.getInputBrushPath(), outputBrushPath, this.mComposerModel.isTabletLayout(), false);
                    deleteBrushFileInfo(activity, str);
                    Logger.m11004w(TAG, "updateBrushFileInfo# update page : " + i);
                    return;
                }
                Logger.m11000e(TAG, "updateBrushFileInfo# not found id : " + brushExecuteInfoLoadBrushFileInfo.getObjectId());
                str2 = null;
                str3 = null;
            }
            objectManager.addPainting(i, str2, outputThumbPath, str3, outputBrushPath, this.mComposerModel.isTabletLayout(), false);
            deleteBrushFileInfo(activity, str);
            Logger.m11004w(TAG, "updateBrushFileInfo# add page : " + i);
        }
    }

    public boolean finishBrush(boolean z, @Nullable CloseableActivity.Callback callback) {
        if (this.mActivity == null || !this.mComposerModel.isRunningDrawing()) {
            String str = TAG;
            StringBuilder sb = new StringBuilder("cannot finishBrush : null activity ? ");
            sb.append(this.mActivity == null);
            sb.append(" or not brush ? ");
            sb.append(this.mComposerModel.isRunningDrawing());
            Logger.m10999d(str, sb.toString());
            return false;
        }
        IBrushExecuteIntentBuilder closeCommand = new BrushExecuteIntentBuilder().setCloseCommand(z);
        Intent intentBuild = closeCommand.build(this.mActivity);
        if (intentBuild.getComponent() != null) {
            String className = intentBuild.getComponent().getClassName();
            ApplicationManager.getInstance().getActivityTracker().requestCloseActionToActivity(this.mActivity, className.substring(className.lastIndexOf(46) + 1), intentBuild, callback);
        } else {
            Activity activity = this.mActivity;
            activity.startActivity(closeCommand.build(activity));
        }
        Logger.m10999d(TAG, "finishBrush");
        return true;
    }
}
