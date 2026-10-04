package com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.save;

import android.content.Context;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.info.DocInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.StartCommandFactory;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.IStartCommand;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.LoadNoteByDoubleTapOnAOD;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical.PenConvertingColorModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical.PenInfoModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.common.utils.NotesDocumentFileUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentAdjustData;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentEntityContainer;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentRepository;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;
import com.samsung.android.support.senl.p148nt.model.service.NotesWordDocumentServiceIntent;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentCacheUtils;
import com.samsung.android.support.senl.p148nt.model.utils.NotesDocumentDeleteUtils;
import com.samsung.android.support.senl.p148nt.model.utils.SpenDocumentDisplayUtils;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 52\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001a\u001a\u00020\rJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u0017J\u000e\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u0012J\u0006\u0010!\u001a\u00020\u0017J\u0006\u0010\"\u001a\u00020\u0017J\u0006\u0010#\u001a\u00020\u0017J\u000e\u0010$\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\tJ\u0006\u0010%\u001a\u00020\u0017J\u0018\u0010&\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010\tJ\u0018\u0010(\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010\tJ\u0018\u0010)\u001a\u00020\u00172\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0+H\u0002J\u0006\u0010 \u001a\u00020\u0017J\u0012\u0010,\u001a\u00020\u00172\b\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010-\u001a\u00020\u00172\b\u0010.\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010/\u001a\u0004\u0018\u00010\tJ\b\u00100\u001a\u0004\u0018\u00010\tJ\u0006\u00101\u001a\u00020\u0017J\u0006\u00102\u001a\u00020\u0017J\b\u00103\u001a\u0004\u0018\u00010\tR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u001b\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015R\u0014\u00104\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\u0015¨\u00066"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/save/SaveModel;", "", "<init>", "()V", "mComposerViewPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;", "mComposerModel", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/ComposerModel;", "mNotePath", "", "mPrimitiveDocument", "Lcom/samsung/android/support/senl/nt/model/documents/spen/SpenWordDocument;", "mDefaultBackgroundColor", "", "value", "uuid", "getUuid", "()Ljava/lang/String;", "", "saveResult", "getSaveResult", "()Z", "init", "", "composerViewPresenter", "composerModel", "defaultBackgroundColor", "isEmpty", "createAdjustData", "Lcom/samsung/android/support/senl/nt/model/documents/data/DocumentAdjustData;", "requestReadyForSave", "setSaveModelDiscard", ClientCookie.DISCARD_ATTR, "save", "saveChanged", "saveCache", "savePinCache", "savePrimitiveDocument", "saveCachePrimitiveDocument", "path", "saveCacheEditedPinDocument", "createServiceCache", ExternalDataConstants.DOCUMENT_TABLE_NAME, "Lcom/samsung/android/support/senl/nt/model/repository/data/NotesDocument;", "saveCachedNoteUuid", "saveCachedNotePath", "notePath", "loadCachedNoteUuid", "loadCacheNotePath", "removeCachedNoteUuid", "removeCachedNotePath", "getNotePath", "isValidDocState", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSaveModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SaveModel.kt\ncom/samsung/android/support/senl/nt/composer/main/screenoff/model/save/SaveModel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,380:1\n1#2:381\n*E\n"})
public final class SaveModel {
    public static final int DEFAULT_SCREEN_OFF_CLOSE_STRATEGY = 3136;
    public static final int DEFAULT_SCREEN_OFF_SAVE_CACHE_STRATEGY = 1088;
    public static final int DEFAULT_SCREEN_OFF_SAVE_STRATEGY = 67592;

    @Nullable
    private ComposerModel mComposerModel;

    @Nullable
    private ComposerViewPresenter mComposerViewPresenter;
    private int mDefaultBackgroundColor;

    @Nullable
    private String mNotePath;

    @Nullable
    private SpenWordDocument mPrimitiveDocument;
    private boolean saveResult;

    @Nullable
    private String uuid;

    @NotNull
    private static final String TAG = SOLogger.createTag("SaveModel");

    private final void createServiceCache(NotesDocument<SpenWordDocument> document) {
        String canonicalPath;
        try {
            Context applicationContext = BaseUtils.getApplicationContext();
            String strSOLoggerGetEncord = null;
            File fileSaveDocumentDat = applicationContext != null ? DocumentCacheUtils.saveDocumentDat(applicationContext, document.getUuid(), document) : null;
            SOLogger sOLogger = SOLogger.INSTANCE;
            String str = TAG;
            if (fileSaveDocumentDat != null && (canonicalPath = fileSaveDocumentDat.getCanonicalPath()) != null) {
                strSOLoggerGetEncord = sOLogger.SOLoggerGetEncord(canonicalPath);
            }
            sOLogger.SOLoggerD(str, "createServiceCache# : " + strSOLoggerGetEncord);
        } catch (Exception e) {
            AbstractC0000a.m24u("createServiceCache# : ", e.getMessage(), SOLogger.INSTANCE, TAG);
        }
    }

    private final boolean isValidDocState() {
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel != null) {
            return (composerModel != null ? composerModel.getDocState() : null) != null;
        }
        return false;
    }

    private final void saveCachedNotePath(String notePath) {
        AbstractC8014b.m7208j("saveCachedNotePath# notePath ", Logger.getEncode(notePath), SOLogger.INSTANCE, TAG);
        SharedPreferencesCompat.INSTANCE.getInstance(Constants.Preference.SCREEN_OFF_SAVE_PREF).putString(Constants.Preference.PREF_KEY_CACHED_NOTE_PATH, notePath);
    }

    private final void saveCachedNoteUuid(String uuid) {
        AbstractC8014b.m7208j("saveCacheNoteUuid# uuid ", uuid, SOLogger.INSTANCE, TAG);
        SharedPreferencesCompat.INSTANCE.getInstance(Constants.Preference.SCREEN_OFF_SAVE_PREF).putString(Constants.Preference.PREF_KEY_CACHED_NOTE_UUID, uuid);
    }

    @NotNull
    public final DocumentAdjustData createAdjustData() {
        SpenWNote doc;
        SpenWNote doc2;
        ComposerModel composerModel = this.mComposerModel;
        int pageDefaultWidth = (composerModel == null || (doc2 = composerModel.getDoc()) == null) ? 1080 : doc2.getPageDefaultWidth();
        ComposerModel composerModel2 = this.mComposerModel;
        return new DocumentAdjustData(pageDefaultWidth, (composerModel2 == null || (doc = composerModel2.getDoc()) == null) ? 1527 : doc.getPageDefaultHeight(), this.mDefaultBackgroundColor, 0, 2, SharedPreferencesCompat.INSTANCE.getInstance("Settings").getInt(SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE, 0), PenConvertingColorModel.INSTANCE.getConvertingColorSet());
    }

    public final void discard() {
        SOLogger.INSTANCE.SOLoggerD(TAG, ClientCookie.DISCARD_ATTR);
        IStartCommand primitiveStartCommand = StartCommandFactory.INSTANCE.getInstance().getPrimitiveStartCommand();
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel != null) {
            composerModel.discard(true);
        }
        if (primitiveStartCommand instanceof LoadNoteByDoubleTapOnAOD) {
            return;
        }
        NotesDocumentDeleteUtils.deleteDocumentFile(BaseUtils.getApplicationContext(), this.uuid, this.mNotePath, null, null, 1);
    }

    @Nullable
    /* JADX INFO: renamed from: getNotePath, reason: from getter */
    public final String getMNotePath() {
        return this.mNotePath;
    }

    public final boolean getSaveResult() {
        return this.saveResult;
    }

    @Nullable
    public final String getUuid() {
        return this.uuid;
    }

    public final void init(@Nullable ComposerViewPresenter composerViewPresenter, @Nullable ComposerModel composerModel, int defaultBackgroundColor) {
        SpenWNote doc;
        SpenWNote doc2;
        SpenWNote doc3;
        SpenWNote doc4;
        SpenWNote doc5;
        SpenWNote doc6;
        DocInfo docInfo;
        DocInfo docInfo2;
        this.mComposerViewPresenter = composerViewPresenter;
        this.mComposerModel = composerModel;
        IStartCommand primitiveStartCommand = StartCommandFactory.INSTANCE.getInstance().getPrimitiveStartCommand();
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        sOLogger.SOLoggerD(str, "init# primitiveStartCommand ".concat(primitiveStartCommand.getClass().getSimpleName()));
        String docPath = null;
        if (primitiveStartCommand instanceof LoadNoteByDoubleTapOnAOD) {
            try {
                Context applicationContext = BaseUtils.getApplicationContext();
                String strCreateSavedPath = NotesDocumentFileUtils.createSavedPath(BaseUtils.getApplicationContext(), ".sdocx");
                ComposerModel composerModel2 = this.mComposerModel;
                SpenWNote.Orientation orientation = (composerModel2 == null || (doc6 = composerModel2.getDoc()) == null) ? null : doc6.getOrientation();
                ComposerModel composerModel3 = this.mComposerModel;
                int width = (composerModel3 == null || (doc5 = composerModel3.getDoc()) == null) ? 0 : doc5.getWidth();
                ComposerModel composerModel4 = this.mComposerModel;
                SpenWordDocument spenWordDocumentCreate = SpenWordDocument.create(applicationContext, strCreateSavedPath, orientation, width, (composerModel4 == null || (doc4 = composerModel4.getDoc()) == null) ? null : doc4.getPageMode(), false);
                this.mPrimitiveDocument = spenWordDocumentCreate;
                if (spenWordDocumentCreate != null) {
                    ComposerModel composerModel5 = this.mComposerModel;
                    spenWordDocumentCreate.setPageDefaultHeight((composerModel5 == null || (doc3 = composerModel5.getDoc()) == null) ? 0 : doc3.getPageDefaultHeight());
                }
                SpenWordDocument spenWordDocument = this.mPrimitiveDocument;
                if (spenWordDocument != null) {
                    ComposerModel composerModel6 = this.mComposerModel;
                    spenWordDocument.copyPage((composerModel6 == null || (doc2 = composerModel6.getDoc()) == null) ? null : doc2.getPage(0), 0);
                }
                ComposerModel composerModel7 = this.mComposerModel;
                SpenSettingUIPenInfo lastPenInfo = (composerModel7 == null || (doc = composerModel7.getDoc()) == null) ? null : doc.getLastPenInfo();
                if (lastPenInfo == null) {
                    lastPenInfo = PenInfoModel.INSTANCE.getSpenSettingPenInfo();
                }
                SpenWordDocument spenWordDocument2 = this.mPrimitiveDocument;
                if (spenWordDocument2 != null) {
                    spenWordDocument2.setLastPenInfo(lastPenInfo);
                }
                SpenWordDocument spenWordDocument3 = this.mPrimitiveDocument;
                sOLogger.SOLoggerD(str, "init# primitiveDocument " + (spenWordDocument3 != null ? spenWordDocument3.hashCode() : 0));
            } catch (IOException e) {
                AbstractC0000a.m24u("init# ", e.getMessage(), SOLogger.INSTANCE, TAG);
            }
        }
        ComposerModel composerModel8 = this.mComposerModel;
        this.uuid = (composerModel8 == null || (docInfo2 = composerModel8.getDocInfo()) == null) ? null : docInfo2.getUuid();
        ComposerModel composerModel9 = this.mComposerModel;
        if (composerModel9 != null && (docInfo = composerModel9.getDocInfo()) != null) {
            docPath = docInfo.getDocPath();
        }
        this.mNotePath = docPath;
        this.mDefaultBackgroundColor = defaultBackgroundColor;
        SOLogger sOLogger2 = SOLogger.INSTANCE;
        String str2 = TAG;
        String str3 = this.uuid;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        sOLogger2.SOLoggerD(str2, AbstractC0541b.m774p("init# uuid/defaultBackgroundColor ", str3, "/", AbstractC2322a.m1624n("#%06X", new Object[]{Integer.valueOf(defaultBackgroundColor & 16777215)}, 1, "format(...)")));
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean isEmpty() {
        boolean z;
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel == null || composerModel == null) {
            z = false;
        } else {
            z = true;
            if (!composerModel.isEmpty()) {
            }
        }
        AbstractC8014b.m7211m("isEmpty# ", z, SOLogger.INSTANCE, TAG);
        return z;
    }

    @Nullable
    public final String loadCacheNotePath() {
        String string = SharedPreferencesCompat.INSTANCE.getInstance(Constants.Preference.SCREEN_OFF_SAVE_PREF).getString(Constants.Preference.PREF_KEY_CACHED_NOTE_PATH, "");
        AbstractC8014b.m7208j("loadCacheNotePath# notPath ", Logger.getEncode(string), SOLogger.INSTANCE, TAG);
        return string;
    }

    @Nullable
    public final String loadCachedNoteUuid() {
        String string = SharedPreferencesCompat.INSTANCE.getInstance(Constants.Preference.SCREEN_OFF_SAVE_PREF).getString(Constants.Preference.PREF_KEY_CACHED_NOTE_UUID, "");
        AbstractC8014b.m7208j("loadCachedNoteUuid# uuid ", string, SOLogger.INSTANCE, TAG);
        return string;
    }

    public final void removeCachedNotePath() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "removeCachedNotePath#");
        SharedPreferencesCompat.INSTANCE.getInstance(Constants.Preference.SCREEN_OFF_SAVE_PREF).putString(Constants.Preference.PREF_KEY_CACHED_NOTE_PATH, "");
    }

    public final void removeCachedNoteUuid() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "removeCachedNoteUuid#");
        SharedPreferencesCompat.INSTANCE.getInstance(Constants.Preference.SCREEN_OFF_SAVE_PREF).putString(Constants.Preference.PREF_KEY_CACHED_NOTE_UUID, "");
    }

    public final void requestReadyForSave() {
        if (this.mComposerViewPresenter != null) {
            SOLogger.INSTANCE.SOLoggerD(TAG, "requestReadyForSave#");
            ComposerViewPresenter composerViewPresenter = this.mComposerViewPresenter;
            if (composerViewPresenter != null) {
                composerViewPresenter.requestReadyForSave();
            }
        }
    }

    public final void save() {
        NotesDocument<SpenWordDocument> docState;
        DocumentEntityContainer documentEntityContainer;
        NotesDocument<SpenWordDocument> docState2;
        DocumentEntityContainer documentEntityContainer2;
        NotesDocument<SpenWordDocument> docState3;
        DocumentRepository<SpenDocument, ? extends DocumentEntityContainer> documentRepository;
        NotesDocument<SpenWordDocument> docState4;
        if (isValidDocState()) {
            ComposerViewPresenter composerViewPresenter = this.mComposerViewPresenter;
            if (composerViewPresenter != null) {
                composerViewPresenter.releaseView(false, false);
            }
            ComposerModel composerModel = this.mComposerModel;
            if (composerModel != null && (docState4 = composerModel.getDocState()) != null) {
                docState4.setDirty(true);
            }
            ComposerModel composerModel2 = this.mComposerModel;
            if (composerModel2 != null && (docState3 = composerModel2.getDocState()) != null && (documentRepository = docState3.getDocumentRepository()) != 0) {
                documentRepository.setAdjustData(createAdjustData());
            }
            SOLogger sOLogger = SOLogger.INSTANCE;
            String str = TAG;
            ComposerModel composerModel3 = this.mComposerModel;
            NotesDocumentEntity entity = null;
            sOLogger.SOLoggerD(str, "save# start entity : " + ((composerModel3 == null || (docState2 = composerModel3.getDocState()) == null || (documentEntityContainer2 = docState2.getDocumentEntityContainer()) == null) ? null : documentEntityContainer2.getEntity()));
            ComposerModel composerModel4 = this.mComposerModel;
            this.saveResult = composerModel4 != null ? composerModel4.save(false, true, false, 67592, true) : false;
            ComposerModel composerModel5 = this.mComposerModel;
            if (composerModel5 != null && (docState = composerModel5.getDocState()) != null && (documentEntityContainer = docState.getDocumentEntityContainer()) != null) {
                entity = documentEntityContainer.getEntity();
            }
            sOLogger.SOLoggerD(str, "save# end entity : " + entity);
        }
    }

    public final void saveCache() {
        NotesDocument<SpenWordDocument> docState;
        DocumentRepository<SpenDocument, ? extends DocumentEntityContainer> documentRepository;
        NotesDocument<SpenWordDocument> docState2;
        if (isValidDocState()) {
            SOLogger.INSTANCE.SOLoggerD(TAG, "saveCache#");
            saveCachedNoteUuid(this.uuid);
            saveCachedNotePath(this.mNotePath);
            requestReadyForSave();
            ComposerModel composerModel = this.mComposerModel;
            if (composerModel != null && (docState2 = composerModel.getDocState()) != null) {
                docState2.setDirty(true);
            }
            ComposerModel composerModel2 = this.mComposerModel;
            if (composerModel2 != null && (docState = composerModel2.getDocState()) != null && (documentRepository = docState.getDocumentRepository()) != 0) {
                documentRepository.setAdjustData(createAdjustData());
            }
            ComposerModel composerModel3 = this.mComposerModel;
            if (composerModel3 != null) {
                composerModel3.saveCache(false, DEFAULT_SCREEN_OFF_SAVE_CACHE_STRATEGY);
            }
        }
    }

    public final void saveCacheEditedPinDocument(@NotNull String uuid, @Nullable String path) throws Throwable {
        Throwable th;
        Exception exc;
        SpenWordDocument spenWordDocumentCreate;
        SpenSettingUIPenInfo spenSettingPenInfo;
        ComposerModel composerModel;
        NotesDocument<SpenWordDocument> docState;
        SpenWNote doc;
        SpenWNote doc2;
        SpenWNote doc3;
        SpenWNote doc4;
        SpenWNote doc5;
        SpenWNote doc6;
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        if (isValidDocState()) {
            SOLogger.INSTANCE.SOLoggerD(TAG, AbstractC0541b.m774p("saveCacheEditedPinDocument# uuid/path ", uuid, "/", Logger.getEncode(path)));
            saveCachedNoteUuid(uuid);
            saveCachedNotePath(path);
            SpenWordDocument spenWordDocument = null;
            objCloneDocument = null;
            objCloneDocument = null;
            Object objCloneDocument = null;
            spenWordDocument = null;
            try {
                try {
                    try {
                        Context applicationContext = BaseUtils.getApplicationContext();
                        String strCreateSavedPath = NotesDocumentFileUtils.createSavedPath(BaseUtils.getApplicationContext(), ".sdocx");
                        ComposerModel composerModel2 = this.mComposerModel;
                        SpenWNote.Orientation orientation = (composerModel2 == null || (doc6 = composerModel2.getDoc()) == null) ? null : doc6.getOrientation();
                        ComposerModel composerModel3 = this.mComposerModel;
                        int width = (composerModel3 == null || (doc5 = composerModel3.getDoc()) == null) ? 0 : doc5.getWidth();
                        ComposerModel composerModel4 = this.mComposerModel;
                        spenWordDocumentCreate = SpenWordDocument.create(applicationContext, strCreateSavedPath, orientation, width, (composerModel4 == null || (doc4 = composerModel4.getDoc()) == null) ? null : doc4.getPageMode(), false);
                    } catch (IOException e) {
                        AbstractC0000a.m24u("saveCacheEditedPinDocument#, fail to close : ", e.getMessage(), SOLogger.INSTANCE, TAG);
                        return;
                    }
                } catch (Exception e2) {
                    exc = e2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                ComposerModel composerModel5 = this.mComposerModel;
                spenWordDocumentCreate.setPageDefaultHeight((composerModel5 == null || (doc3 = composerModel5.getDoc()) == null) ? 0 : doc3.getPageDefaultHeight());
                ComposerModel composerModel6 = this.mComposerModel;
                spenWordDocumentCreate.copyPage((composerModel6 == null || (doc2 = composerModel6.getDoc()) == null) ? null : doc2.getPage(0), 0);
                ComposerModel composerModel7 = this.mComposerModel;
                if (composerModel7 == null || (doc = composerModel7.getDoc()) == null || (spenSettingPenInfo = doc.getLastPenInfo()) == null) {
                    spenSettingPenInfo = PenInfoModel.INSTANCE.getSpenSettingPenInfo();
                }
                spenWordDocumentCreate.setLastPenInfo(spenSettingPenInfo);
                Context applicationContext2 = BaseUtils.getApplicationContext();
                if (applicationContext2 != null && (composerModel = this.mComposerModel) != null && (docState = composerModel.getDocState()) != null) {
                    objCloneDocument = docState.cloneDocument(DocumentSubscriptionId.create("ScreenOffMemo", null), applicationContext2);
                }
                Intrinsics.checkNotNull(objCloneDocument, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.model.repository.data.NotesDocument<com.samsung.android.support.senl.nt.model.documents.spen.SpenWordDocument?>");
                NotesDocument<SpenWordDocument> notesDocument = (NotesDocument) objCloneDocument;
                notesDocument.setDirty(true);
                notesDocument.setDoc(spenWordDocumentCreate);
                notesDocument.getDocumentRepository().setNewDocument(true);
                notesDocument.getDocumentRepository().setUuid(uuid);
                notesDocument.getDocumentRepository().savePath(path);
                notesDocument.getDocumentRepository().loadPath(path);
                notesDocument.getDocumentRepository().setAdjustData(createAdjustData());
                notesDocument.getDocumentRepository().setSaveStrategy(DEFAULT_SCREEN_OFF_SAVE_CACHE_STRATEGY);
                notesDocument.getDocumentRepository().getDocumentEntity().getEntity().setUuid(uuid);
                notesDocument.getDocumentRepository().getDocumentEntity().getEntity().setCategoryUuid(PredefinedCategory.SCREEN_OFF_MEMO.getUuid());
                spenWordDocumentCreate.quickSave(path);
                createServiceCache(notesDocument);
                if (!spenWordDocumentCreate.isClosed()) {
                    spenWordDocumentCreate.close(true);
                }
            } catch (Exception e3) {
                exc = e3;
                spenWordDocument = spenWordDocumentCreate;
                SOLogger.INSTANCE.SOLoggerE(TAG, "saveCacheEditedPinDocument# " + exc.getMessage());
                if (spenWordDocument == null) {
                    return;
                }
                if (!spenWordDocument.isClosed()) {
                    spenWordDocument.close(true);
                }
            } catch (Throwable th3) {
                th = th3;
                spenWordDocument = spenWordDocumentCreate;
                if (spenWordDocument == null) {
                    throw th;
                }
                try {
                    if (spenWordDocument.isClosed()) {
                        throw th;
                    }
                    spenWordDocument.close(true);
                    throw th;
                } catch (IOException e5) {
                    AbstractC0000a.m24u("saveCacheEditedPinDocument#, fail to close : ", e5.getMessage(), SOLogger.INSTANCE, TAG);
                    throw th;
                }
            }
        }
    }

    public final void saveCachePrimitiveDocument(@NotNull String uuid, @Nullable String path) {
        SpenWordDocument spenWordDocument;
        SpenWordDocument spenWordDocument2;
        SpenWordDocument spenWordDocument3;
        ComposerModel composerModel;
        NotesDocument<SpenWordDocument> docState;
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        if (!isValidDocState() || (spenWordDocument = this.mPrimitiveDocument) == null) {
            return;
        }
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        int iHashCode = spenWordDocument != null ? spenWordDocument.hashCode() : 0;
        String encode = Logger.getEncode(path);
        StringBuilder sbM1629s = AbstractC2322a.m1629s("saveCachePrimitiveDocument# primitiveDocument/uuid/path ", iHashCode, "/", uuid, "/");
        sbM1629s.append(encode);
        sOLogger.SOLoggerD(str, sbM1629s.toString());
        try {
            try {
                try {
                    Context applicationContext = BaseUtils.getApplicationContext();
                    DocumentDataSource documentDataSourceCloneDocument = null;
                    if (applicationContext != null && (composerModel = this.mComposerModel) != null && (docState = composerModel.getDocState()) != null) {
                        documentDataSourceCloneDocument = docState.cloneDocument(DocumentSubscriptionId.create("ScreenOffMemo", null), applicationContext);
                    }
                    Intrinsics.checkNotNull(documentDataSourceCloneDocument, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.model.repository.data.NotesDocument<com.samsung.android.support.senl.nt.model.documents.spen.SpenWordDocument?>");
                    NotesDocument<SpenWordDocument> notesDocument = (NotesDocument) documentDataSourceCloneDocument;
                    notesDocument.setDirty(true);
                    notesDocument.setDoc(this.mPrimitiveDocument);
                    notesDocument.getDocumentRepository().setNewDocument(true);
                    notesDocument.getDocumentRepository().setUuid(uuid);
                    notesDocument.getDocumentRepository().savePath(path);
                    notesDocument.getDocumentRepository().loadPath(path);
                    notesDocument.getDocumentRepository().setAdjustData(createAdjustData());
                    notesDocument.getDocumentRepository().setSaveStrategy(DEFAULT_SCREEN_OFF_SAVE_CACHE_STRATEGY);
                    notesDocument.getDocumentRepository().getDocumentEntity().getEntity().setUuid(uuid);
                    notesDocument.getDocumentRepository().getDocumentEntity().getEntity().setCategoryUuid(PredefinedCategory.SCREEN_OFF_MEMO.getUuid());
                    SpenWordDocument spenWordDocument4 = this.mPrimitiveDocument;
                    if (spenWordDocument4 != null) {
                        spenWordDocument4.quickSave(path);
                    }
                    createServiceCache(notesDocument);
                    SpenWordDocument spenWordDocument5 = this.mPrimitiveDocument;
                    if (spenWordDocument5 == null || spenWordDocument5.isClosed() || (spenWordDocument3 = this.mPrimitiveDocument) == null) {
                        return;
                    }
                } catch (Exception e) {
                    SOLogger.INSTANCE.SOLoggerE(TAG, "saveCachePrimitiveDocument# " + e.getMessage());
                    SpenWordDocument spenWordDocument6 = this.mPrimitiveDocument;
                    if (spenWordDocument6 == null || spenWordDocument6.isClosed() || (spenWordDocument3 = this.mPrimitiveDocument) == null) {
                        return;
                    }
                }
                spenWordDocument3.close(true);
            } catch (Throwable th) {
                try {
                    SpenWordDocument spenWordDocument7 = this.mPrimitiveDocument;
                    if (spenWordDocument7 != null && !spenWordDocument7.isClosed() && (spenWordDocument2 = this.mPrimitiveDocument) != null) {
                        spenWordDocument2.close(true);
                    }
                } catch (IOException e2) {
                    AbstractC0000a.m24u("saveCachePrimitiveDocument#, fail to close : ", e2.getMessage(), SOLogger.INSTANCE, TAG);
                }
                throw th;
            }
        } catch (IOException e3) {
            AbstractC0000a.m24u("saveCachePrimitiveDocument#, fail to close : ", e3.getMessage(), SOLogger.INSTANCE, TAG);
        }
    }

    public final void saveChanged() {
        NotesDocument<SpenWordDocument> docState;
        DocumentEntityContainer documentEntityContainer;
        NotesDocument<SpenWordDocument> docState2;
        DocumentEntityContainer documentEntityContainer2;
        NotesDocument<SpenWordDocument> docState3;
        DocumentRepository<SpenDocument, ? extends DocumentEntityContainer> documentRepository;
        NotesDocument<SpenWordDocument> docState4;
        if (isValidDocState()) {
            ComposerModel composerModel = this.mComposerModel;
            if (composerModel != null && (docState4 = composerModel.getDocState()) != null) {
                docState4.setDirty(true);
            }
            ComposerModel composerModel2 = this.mComposerModel;
            if (composerModel2 != null && (docState3 = composerModel2.getDocState()) != null && (documentRepository = docState3.getDocumentRepository()) != 0) {
                documentRepository.setAdjustData(createAdjustData());
            }
            SOLogger sOLogger = SOLogger.INSTANCE;
            String str = TAG;
            ComposerModel composerModel3 = this.mComposerModel;
            NotesDocumentEntity entity = null;
            sOLogger.SOLoggerD(str, "saveChanged# start entity : " + ((composerModel3 == null || (docState2 = composerModel3.getDocState()) == null || (documentEntityContainer2 = docState2.getDocumentEntityContainer()) == null) ? null : documentEntityContainer2.getEntity()));
            ComposerModel composerModel4 = this.mComposerModel;
            if (composerModel4 != null) {
                composerModel4.save(false, true, false, 67592, true);
            }
            ComposerModel composerModel5 = this.mComposerModel;
            if (composerModel5 != null && (docState = composerModel5.getDocState()) != null && (documentEntityContainer = docState.getDocumentEntityContainer()) != null) {
                entity = documentEntityContainer.getEntity();
            }
            sOLogger.SOLoggerD(str, "saveChanged# end entity : " + entity);
        }
    }

    public final void savePinCache(@NotNull String uuid) {
        NotesDocument<SpenWordDocument> docState;
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        if (isValidDocState()) {
            SOLogger.INSTANCE.SOLoggerD(TAG, "savePinCache# " + uuid);
            Context applicationContext = BaseUtils.getApplicationContext();
            if (applicationContext != null) {
                String uuid2 = PredefinedCategory.SCREEN_OFF_MEMO.getUuid();
                ComposerModel composerModel = this.mComposerModel;
                NotesWordDocumentServiceIntent.restoreCaches(applicationContext, uuid, uuid2, (composerModel == null || (docState = composerModel.getDocState()) == null) ? null : docState.getSubscriptionId());
            }
        }
    }

    public final void savePrimitiveDocument() {
        SpenWordDocument spenWordDocument;
        SpenWordDocument spenWordDocument2;
        SpenWordDocument spenWordDocument3;
        ComposerModel composerModel;
        NotesDocument<SpenWordDocument> docState;
        if (!isValidDocState() || (spenWordDocument = this.mPrimitiveDocument) == null) {
            return;
        }
        AbstractC8014b.m7206h("savePrimitiveDocument# primitiveDocument ", spenWordDocument != null ? spenWordDocument.hashCode() : 0, SOLogger.INSTANCE, TAG);
        try {
            try {
                try {
                    String strCreateSavedPath = NotesDocumentFileUtils.createSavedPath(BaseUtils.getApplicationContext(), ".sdocx");
                    Intrinsics.checkNotNullExpressionValue(strCreateSavedPath, "createSavedPath(...)");
                    Context applicationContext = BaseUtils.getApplicationContext();
                    DocumentDataSource documentDataSourceCloneDocument = (applicationContext == null || (composerModel = this.mComposerModel) == null || (docState = composerModel.getDocState()) == null) ? null : docState.cloneDocument(DocumentSubscriptionId.create("ScreenOffMemo", null), applicationContext);
                    Intrinsics.checkNotNull(documentDataSourceCloneDocument, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.model.repository.data.NotesDocument<com.samsung.android.support.senl.nt.model.documents.spen.SpenWordDocument>");
                    NotesDocument notesDocument = (NotesDocument) documentDataSourceCloneDocument;
                    notesDocument.setDirty(true);
                    notesDocument.setDoc(this.mPrimitiveDocument);
                    notesDocument.getDocumentRepository().setNewDocument(true);
                    notesDocument.getDocumentRepository().savePath(strCreateSavedPath);
                    notesDocument.getDocumentRepository().loadPath(strCreateSavedPath);
                    notesDocument.getDocumentRepository().setSaveStrategy(67592);
                    notesDocument.getDocumentRepository().getDocumentEntity().getEntity().setCategoryUuid(PredefinedCategory.SCREEN_OFF_MEMO.getUuid());
                    DocumentAdjustData documentAdjustDataCreateAdjustData = createAdjustData();
                    SpenWordDocument spenWordDocument4 = this.mPrimitiveDocument;
                    SpenDocumentDisplayUtils.adjustSize(spenWordDocument4 != null ? spenWordDocument4.getPage(documentAdjustDataCreateAdjustData.getPageIndex()) : null, documentAdjustDataCreateAdjustData.getDefaultPageHeight(), documentAdjustDataCreateAdjustData.getPageDefaultNumber());
                    int penColorType = documentAdjustDataCreateAdjustData.getPenColorType();
                    SpenWordDocument spenWordDocument5 = this.mPrimitiveDocument;
                    SpenDocumentDisplayUtils.convertColors(penColorType, spenWordDocument5 != null ? spenWordDocument5.getPage(documentAdjustDataCreateAdjustData.getPageIndex()) : null, documentAdjustDataCreateAdjustData.getDefaultBackgroundColor(), documentAdjustDataCreateAdjustData.getColorSet());
                    SpenDocumentDisplayUtils.convertLastPenInfo(this.mPrimitiveDocument, documentAdjustDataCreateAdjustData.getPenColorType(), documentAdjustDataCreateAdjustData.getColorSet());
                    Context applicationContext2 = BaseUtils.getApplicationContext();
                    if (applicationContext2 != null) {
                        notesDocument.save(applicationContext2);
                    }
                    SpenWordDocument spenWordDocument6 = this.mPrimitiveDocument;
                    if (spenWordDocument6 == null || spenWordDocument6.isClosed() || (spenWordDocument2 = this.mPrimitiveDocument) == null) {
                        return;
                    }
                } catch (Throwable th) {
                    try {
                        SpenWordDocument spenWordDocument7 = this.mPrimitiveDocument;
                        if (spenWordDocument7 != null && !spenWordDocument7.isClosed() && (spenWordDocument3 = this.mPrimitiveDocument) != null) {
                            spenWordDocument3.close(true);
                        }
                    } catch (IOException e) {
                        AbstractC0000a.m24u("savePrimitiveDocument#, fail to close : ", e.getMessage(), SOLogger.INSTANCE, TAG);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                SOLogger.INSTANCE.SOLoggerE(TAG, "savePrimitiveDocument# : " + e2.getMessage());
                SpenWordDocument spenWordDocument8 = this.mPrimitiveDocument;
                if (spenWordDocument8 == null || spenWordDocument8.isClosed() || (spenWordDocument2 = this.mPrimitiveDocument) == null) {
                    return;
                }
            }
            spenWordDocument2.close(true);
        } catch (IOException e3) {
            AbstractC0000a.m24u("savePrimitiveDocument#, fail to close : ", e3.getMessage(), SOLogger.INSTANCE, TAG);
        }
    }

    public final void setSaveModelDiscard(boolean discard) {
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel != null) {
            composerModel.setSaveModelDiscard(discard);
        }
    }
}
