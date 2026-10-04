package com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.controller;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.info.DocInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.controller.pin.PinData;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.executor.ExecutorFactory;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.save.SaveModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentEntityContainer;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentRepository;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;
import com.samsung.android.support.senl.p148nt.model.utils.NotesDocumentDeleteUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u0000 32\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u0018\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005J \u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\rH\u0007J&\u0010\u001e\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0007J\u0006\u0010$\u001a\u00020\u0015J\u001c\u0010%\u001a\u0004\u0018\u00010\"2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010&\u001a\u0004\u0018\u00010\"J\u001c\u0010'\u001a\u00020\u00152\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010&\u001a\u0004\u0018\u00010\"H\u0002J\u001a\u0010(\u001a\u00020\u00152\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010&\u001a\u0004\u0018\u00010\"J\u0010\u0010)\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\"J\u0010\u0010*\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\"J\u001c\u0010+\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0003J\u0012\u0010,\u001a\u00020\u00152\b\u0010#\u001a\u0004\u0018\u00010\"H\u0007J \u0010-\u001a\u00020\u00152\b\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010.\u001a\u00020\"2\u0006\u0010&\u001a\u00020\"J\u000e\u00102\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020 R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0013\u0010/\u001a\u0004\u0018\u00010\"8F¢\u0006\u0006\u001a\u0004\b0\u00101¨\u00064"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/controller/PinController;", "", "<init>", "()V", "mActivity", "Landroid/app/Activity;", "mPinData", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/controller/pin/PinData;", "mComposerModel", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/ComposerModel;", "mSaveModel", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/save/SaveModel;", "mScrollPanY", "", Constants.IntentExtraName.EDITED, "", "getEdited", "()Z", "setEdited", "(Z)V", "init", "", "composerModel", "saveModel", "onAttachView", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "pinToAOD", "bitmap", "Landroid/graphics/Bitmap;", "scrollPanY", "unPinFromAOD", "contentResolver", "Landroid/content/ContentResolver;", "internalFilesDir", "", "uri", "savePinCache", "loadExistingPinnedLegacyNotePathByPath", "path", "deleteExistingPinnedLegacyNoteByPath", "deleteExistingPinnedLegacyNoteByExceptedPath", "loadPinnedNoteUuidByUri", "loadPinnedNotePathByUri", "deleteExistingPinnedDataByUri", "deleteExistingPinnedDataByExceptedUri", "replacePinnedNoteData", "uuid", "currentPinnedNoteUri", "getCurrentPinnedNoteUri", "()Ljava/lang/String;", "getAODPinnedContent", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPinController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PinController.kt\ncom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/controller/PinController\n+ 2 Uri.kt\nandroidx/core/net/UriKt\n*L\n1#1,141:1\n29#2:142\n*S KotlinDebug\n*F\n+ 1 PinController.kt\ncom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/controller/PinController\n*L\n120#1:142\n*E\n"})
public final class PinController {

    @NotNull
    private static final String TAG = SOLogger.createTag("PinController");
    private boolean edited;

    @Nullable
    private Activity mActivity;

    @Nullable
    private ComposerModel mComposerModel;

    @NotNull
    private final PinData mPinData = new PinData();

    @Nullable
    private SaveModel mSaveModel;
    private float mScrollPanY;

    @RequiresApi(29)
    private final void deleteExistingPinnedDataByUri(ContentResolver contentResolver, String uri) {
        this.mPinData.deleteExistingPinnedDataByUri(contentResolver, uri);
    }

    private final void deleteExistingPinnedLegacyNoteByPath(String internalFilesDir, String path) {
        this.mPinData.deleteExistingPinnedLegacyNoteByPath(internalFilesDir, path);
    }

    @RequiresApi(29)
    public final void deleteExistingPinnedDataByExceptedUri(@Nullable String uri) {
        this.mPinData.deleteExistingPinnedDataByExceptedUri(uri);
    }

    public final void deleteExistingPinnedLegacyNoteByExceptedPath(@Nullable String internalFilesDir, @Nullable String path) {
        this.mPinData.deleteExistingPinnedLegacyNoteByExceptedPath(internalFilesDir, path);
    }

    @NotNull
    public final String getAODPinnedContent(@NotNull ContentResolver contentResolver) {
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        Cursor cursorQuery = contentResolver.query(Uri.parse(Constants.ExternalProviderInformation.AOD_PINNED_CONTENT_INFO_URI), null, null, null, null);
        String str = "";
        try {
            if (cursorQuery != null) {
                if (cursorQuery.getCount() > 0) {
                    cursorQuery.moveToFirst();
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex(Constants.ExternalProviderInformation.SCREEN_OFF_PINNED_DATA_COLUMN_NAME));
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    str = string;
                }
                return str;
            }
        } catch (Exception e) {
            SOLogger.INSTANCE.SOLoggerE(TAG, "getAODPinnedContent# ", e);
        } finally {
            cursorQuery.close();
        }
        return "";
    }

    @Nullable
    public final String getCurrentPinnedNoteUri() {
        return this.mPinData.getCurrentPinnedNoteUri();
    }

    public final boolean getEdited() {
        return this.edited;
    }

    public final void init(@Nullable ComposerModel composerModel, @Nullable SaveModel saveModel) {
        String absolutePath;
        DocInfo docInfo;
        DocInfo docInfo2;
        this.mComposerModel = composerModel;
        this.mSaveModel = saveModel;
        Activity activity = this.mActivity;
        String docPath = null;
        File cacheDir = activity != null ? activity.getCacheDir() : null;
        Activity activity2 = this.mActivity;
        File externalFilesDir = activity2 != null ? activity2.getExternalFilesDir(null) : null;
        PinData pinData = this.mPinData;
        Activity activity3 = this.mActivity;
        ContentResolver contentResolver = activity3 != null ? activity3.getContentResolver() : null;
        String absolutePath2 = cacheDir != null ? cacheDir.getAbsolutePath() : null;
        if (externalFilesDir == null || (absolutePath = externalFilesDir.getAbsolutePath()) == null) {
            absolutePath = "";
        }
        String str = absolutePath;
        ComposerModel composerModel2 = this.mComposerModel;
        String uuid = (composerModel2 == null || (docInfo2 = composerModel2.getDocInfo()) == null) ? null : docInfo2.getUuid();
        ComposerModel composerModel3 = this.mComposerModel;
        if (composerModel3 != null && (docInfo = composerModel3.getDocInfo()) != null) {
            docPath = docInfo.getDocPath();
        }
        pinData.init(contentResolver, absolutePath2, str, uuid, docPath);
    }

    @Nullable
    public final String loadExistingPinnedLegacyNotePathByPath(@Nullable String internalFilesDir, @Nullable String path) {
        return this.mPinData.loadExistingPinnedLegacyNotePathByPath(internalFilesDir, path);
    }

    @NotNull
    public final String loadPinnedNotePathByUri(@Nullable String uri) {
        return this.mPinData.loadPinnedNotePathByUri(uri);
    }

    @NotNull
    public final String loadPinnedNoteUuidByUri(@Nullable String uri) {
        return this.mPinData.loadPinnedNoteUuidByUri(uri);
    }

    public final void onAttachView(@Nullable Activity activity) {
        this.mActivity = activity;
    }

    @RequiresApi(29)
    public final void pinToAOD(@NotNull Bitmap bitmap, boolean edited, float scrollPanY) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        SOLogger.INSTANCE.SOLoggerD(TAG, "pinToAOD# execute AODPinExecutor, edited/scrollPanY " + edited + "/" + scrollPanY);
        this.mPinData.makePinData(bitmap, edited);
        this.mScrollPanY = scrollPanY;
        Intent intent = new Intent();
        intent.setAction(Constants.IntentAction.PIN);
        intent.putExtra(Constants.IntentExtraName.PIN_IMAGE_PATH, this.mPinData.getPinImagePath());
        intent.putExtra(Constants.IntentExtraName.PIN_URI, this.mPinData.getPinUri());
        intent.putExtra(Constants.IntentExtraName.IS_EDITED, this.mPinData.getEdited());
        ExecutorFactory.INSTANCE.createExecutor(intent).execute(this.mActivity, intent);
    }

    public final void replacePinnedNoteData(@Nullable String uri, @NotNull String uuid, @NotNull String path) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(path, "path");
        this.mPinData.replacePinnedNoteData(uri, uuid, path);
    }

    public final void savePinCache() {
        NotesDocument<SpenWordDocument> docState;
        DocumentRepository<SpenDocument, ? extends DocumentEntityContainer> documentRepository;
        this.mPinData.savePinnedNoteData(this.mScrollPanY);
        SaveModel saveModel = this.mSaveModel;
        if (saveModel != null) {
            saveModel.requestReadyForSave();
        }
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel != null && (docState = composerModel.getDocState()) != null && (documentRepository = docState.getDocumentRepository()) != 0) {
            SaveModel saveModel2 = this.mSaveModel;
            documentRepository.setAdjustData(saveModel2 != null ? saveModel2.createAdjustData() : null);
        }
        ComposerModel composerModel2 = this.mComposerModel;
        if (composerModel2 != null) {
            composerModel2.saveCache(false, SaveModel.DEFAULT_SCREEN_OFF_SAVE_CACHE_STRATEGY);
        }
    }

    public final void setEdited(boolean z) {
        this.edited = z;
    }

    @RequiresApi(29)
    public final void unPinFromAOD(@Nullable ContentResolver contentResolver, @Nullable String internalFilesDir, @Nullable String uri) {
        String strLoadExistingPinnedLegacyNotePathByPath = new PinData().loadExistingPinnedLegacyNotePathByPath(internalFilesDir, uri);
        SOLogger.INSTANCE.SOLoggerD(TAG, AbstractC0541b.m774p("unPinFromAOD# uri/legacyPinPath ", Logger.getEncode(uri), "/", Logger.getEncode(strLoadExistingPinnedLegacyNotePathByPath)));
        if (strLoadExistingPinnedLegacyNotePathByPath.length() > 0) {
            deleteExistingPinnedLegacyNoteByPath(internalFilesDir, uri);
        } else {
            NotesDocumentDeleteUtils.deleteDocumentFile(BaseUtils.getApplicationContext(), loadPinnedNoteUuidByUri(uri), loadPinnedNotePathByUri(uri), null, null, 1);
            deleteExistingPinnedDataByUri(contentResolver, uri);
        }
    }
}
