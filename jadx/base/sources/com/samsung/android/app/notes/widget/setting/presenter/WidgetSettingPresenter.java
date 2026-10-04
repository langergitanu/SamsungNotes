package com.samsung.android.app.notes.widget.setting.presenter;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.widget.broadcast.WidgetBroadcast;
import com.samsung.android.app.notes.widget.capture.CacheFileManager;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.app.notes.widget.setting.model.WidgetSettingModel;
import com.samsung.android.app.notes.widget.setting.view.WidgetSettingContract;
import com.samsung.android.app.notes.widget.util.WidgetUtils;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.base.common.access.notelist.NoteListAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenComposerSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter;
import com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingContract;
import com.samsung.android.support.senl.p148nt.base.widget.util.BaseWidgetUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import com.samsung.android.support.senl.p148nt.homewidget.C11391R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p004A2.RunnableC0015b;
import p014C3.RunnableC0054a;
import p065P1.C0196b;
import p070Q1.RunnableC0218a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 B2\u00020\u0001:\u0001BB\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020#H\u0016J\"\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u000f2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0006\u0010*\u001a\u00020#J\u0012\u0010+\u001a\u00020#2\b\u0010,\u001a\u0004\u0018\u00010\rH\u0002J\u0006\u0010-\u001a\u00020#J\b\u0010.\u001a\u00020#H\u0002J\u0006\u00108\u001a\u00020#J\u0012\u00108\u001a\u00020#2\b\u0010,\u001a\u0004\u0018\u00010\rH\u0002J\u0006\u00109\u001a\u00020#J\b\u0010:\u001a\u00020#H\u0002J\u0006\u0010;\u001a\u00020#J\u0006\u0010<\u001a\u00020#J\u0006\u0010=\u001a\u00020#J\u0006\u0010>\u001a\u00020#R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR$\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\u001c8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0013\u0010/\u001a\u0004\u0018\u00010\r8F¢\u0006\u0006\u001a\u0004\b0\u00101R\u0013\u00102\u001a\u0004\u0018\u00010\r8F¢\u0006\u0006\u001a\u0004\b3\u00101R\u0016\u00104\u001a\u0004\u0018\u0001058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0013\u0010,\u001a\u0004\u0018\u00010\r8F¢\u0006\u0006\u001a\u0004\b?\u00101R\u0011\u0010@\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\bA\u0010\u0012¨\u0006C"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/setting/presenter/WidgetSettingPresenter;", "Lcom/samsung/android/support/senl/nt/base/widget/setting/presenter/BaseWidgetSettingPresenter;", "bundle", "Landroid/os/Bundle;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "<init>", "(Landroid/os/Bundle;Landroid/app/Activity;)V", "mModel", "Lcom/samsung/android/app/notes/widget/setting/model/WidgetSettingModel;", "mContract", "Lcom/samsung/android/app/notes/widget/setting/view/WidgetSettingContract;", "mFilePath", "", "value", "", "pageColor", "getPageColor", "()I", "", "isBackgroundImage", "()Z", "mIsNewNote", "mCreatedCallback", "Lcom/samsung/android/app/notes/widget/capture/CacheFileManager$Callback;", "model", "getModel", "()Lcom/samsung/android/app/notes/widget/setting/model/WidgetSettingModel;", "Lcom/samsung/android/support/senl/nt/base/widget/setting/view/BaseWidgetSettingContract;", "view", "getView", "()Lcom/samsung/android/support/senl/nt/base/widget/setting/view/BaseWidgetSettingContract;", "setView", "(Lcom/samsung/android/support/senl/nt/base/widget/setting/view/BaseWidgetSettingContract;)V", "saveAndFinish", "", "cancelAndFinish", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "updatePreviewAndSetting", "updateColorAndBgImage", "uuid", "updateEmptyPreview", "initSpenSdk", "recommendTitle", "getRecommendTitle", "()Ljava/lang/String;", "title", DynamicActionBarProvider.METHOD_GET_DATA, "docRepository", "Lcom/samsung/android/support/senl/nt/data/database/core/document/data/MainListDocumentData;", "getDocRepository", "()Lcom/samsung/android/support/senl/nt/data/database/core/document/data/MainListDocumentData;", "createCacheInfo", "onChangeClicked", "updateFilePath", "showLoadingView", "updateNoteTitle", "updatePreviewTitle", "hideLoadingView", "getUuid", "mWidgetId", "getMWidgetId", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetSettingPresenter extends BaseWidgetSettingPresenter {

    @NotNull
    private static final String TAG = "WidgetSettingPresenter";
    private boolean isBackgroundImage;

    @Nullable
    private WidgetSettingContract mContract;

    @NotNull
    private final CacheFileManager.Callback mCreatedCallback;

    @Nullable
    private String mFilePath;
    private boolean mIsNewNote;

    @NotNull
    private final WidgetSettingModel mModel;
    private int pageColor;
    public static final int $stable = 8;

    public WidgetSettingPresenter(@Nullable Bundle bundle, @Nullable Activity activity) {
        String string;
        super(activity);
        Intrinsics.checkNotNull(activity);
        WidgetSettingModel widgetSettingModel = new WidgetSettingModel(bundle, activity);
        this.mModel = widgetSettingModel;
        this.mCreatedCallback = new C0196b(this, 1);
        checkValidWidget();
        updateFilePath();
        if (!WidgetUtils.INSTANCE.isSDoc(activity, widgetSettingModel.getUUID())) {
            initSpenSdk();
            return;
        }
        Resources resources = activity.getResources();
        if (resources != null && (string = resources.getString(C11391R.string.widget_convert_document)) != null) {
            ToastHandler.show(activity, string, 1);
        }
        activity.finishAndRemoveTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createCacheInfo$lambda$4(WidgetSettingPresenter widgetSettingPresenter, String str) {
        if (widgetSettingPresenter.getMActivity() == null) {
            return;
        }
        int widgetId = widgetSettingPresenter.mModel.getWidgetId();
        CacheFileManager.Companion companion = CacheFileManager.INSTANCE;
        if (!companion.getInstance().isInitialized()) {
            CacheFileManager companion2 = companion.getInstance();
            Activity mActivity = widgetSettingPresenter.getMActivity();
            Intrinsics.checkNotNull(mActivity);
            companion2.init(mActivity);
        }
        if (companion.getInstance().isValidCacheFiles(String.valueOf(str))) {
            widgetSettingPresenter.updatePreviewAndSetting();
            return;
        }
        Logger.m8697d(TAG, "createCacheInfo# create new cache");
        if (companion.getInstance().isCreateWidgetState(widgetSettingPresenter.getMActivity(), String.valueOf(str), widgetId)) {
            CacheFileManager companion3 = companion.getInstance();
            Activity mActivity2 = widgetSettingPresenter.getMActivity();
            Intrinsics.checkNotNull(mActivity2);
            companion3.removeCacheInfo(mActivity2, String.valueOf(str));
        }
        widgetSettingPresenter.updateFilePath();
        CacheFileManager companion4 = companion.getInstance();
        Activity mActivity3 = widgetSettingPresenter.getMActivity();
        Intrinsics.checkNotNull(mActivity3);
        companion4.createCacheInfo(mActivity3, String.valueOf(str), String.valueOf(widgetSettingPresenter.mFilePath), widgetId, widgetSettingPresenter.mCreatedCallback);
    }

    private final MainListDocumentData getDocRepository() {
        try {
            Activity mActivity = getMActivity();
            Intrinsics.checkNotNull(mActivity);
            return NotesDataRepositoryFactory.newInstance(mActivity).createMainListDocumentDataRepository().get(String.valueOf(this.mModel.getUUID()));
        } catch (Exception unused) {
            Logger.m8698e(TAG, "getDocRepository# fail to docRepository");
            return null;
        }
    }

    private final void initSpenSdk() {
        SpenSdkInitializer.initialize(getMActivity());
        SpenComposerSdkInitializer.initialize(getMActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mCreatedCallback$lambda$1(WidgetSettingPresenter widgetSettingPresenter) {
        Activity mActivity;
        Logger.m8697d(TAG, "onCacheCreated# ");
        if (widgetSettingPresenter.getMActivity() != null) {
            Activity mActivity2 = widgetSettingPresenter.getMActivity();
            Boolean boolValueOf = mActivity2 != null ? Boolean.valueOf(mActivity2.isDestroyed()) : null;
            Intrinsics.checkNotNull(boolValueOf);
            if (boolValueOf.booleanValue()) {
                return;
            }
            Activity mActivity3 = widgetSettingPresenter.getMActivity();
            Boolean boolValueOf2 = mActivity3 != null ? Boolean.valueOf(mActivity3.isFinishing()) : null;
            Intrinsics.checkNotNull(boolValueOf2);
            if (boolValueOf2.booleanValue() || (mActivity = widgetSettingPresenter.getMActivity()) == null) {
                return;
            }
            mActivity.runOnUiThread(new RunnableC0015b(widgetSettingPresenter, 12));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mCreatedCallback$lambda$1$lambda$0(WidgetSettingPresenter widgetSettingPresenter) {
        if (CacheFileManager.INSTANCE.getInstance().isDoneState(String.valueOf(widgetSettingPresenter.mModel.getUUID()))) {
            widgetSettingPresenter.updatePreviewAndSetting();
        } else {
            widgetSettingPresenter.createCacheInfo(widgetSettingPresenter.mModel.getUUID());
        }
    }

    private final void updateColorAndBgImage(String uuid) {
        int pageColor;
        if (Intrinsics.areEqual(BaseWidgetConstant.NONE, uuid)) {
            Activity mActivity = getMActivity();
            Intrinsics.checkNotNull(mActivity);
            pageColor = ContextCompat.getColor(mActivity, C11391R.color.widget_bg_color);
        } else {
            pageColor = CacheFileManager.INSTANCE.getInstance().getPageColor(String.valueOf(uuid));
        }
        this.pageColor = pageColor;
        this.isBackgroundImage = CacheFileManager.INSTANCE.getInstance().hasBackgroundImage(String.valueOf(uuid));
    }

    private final void updateFilePath() {
        String path;
        String uuid = this.mModel.getUUID();
        if (uuid != null) {
            Logger.m8697d(TAG, "updateFilePath# ".concat(uuid));
            Activity mActivity = getMActivity();
            Intrinsics.checkNotNull(mActivity);
            NotesDocumentRepository notesDocumentRepositoryCreateDocumentDataRepository = NotesDataRepositoryFactory.newInstance(mActivity).createDocumentDataRepository();
            Intrinsics.checkNotNullExpressionValue(notesDocumentRepositoryCreateDocumentDataRepository, "createDocumentDataRepository(...)");
            path = notesDocumentRepositoryCreateDocumentDataRepository.getPath(uuid);
        } else {
            Logger.m8697d(TAG, "updateFilePath# uuid is null");
            path = null;
        }
        if (path == null) {
            path = this.mFilePath;
        }
        if (path != null) {
            this.mFilePath = path;
            return;
        }
        if (Intrinsics.areEqual(BaseWidgetConstant.NONE, uuid)) {
            return;
        }
        Logger.m8697d(TAG, "updateFilePath# file path is null");
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(String.valueOf(uuid));
        Activity mActivity2 = getMActivity();
        Intrinsics.checkNotNull(mActivity2);
        WidgetBroadcast.sendDeleteUUIDWidgetBroadcast(mActivity2, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updatePreviewAndSetting$lambda$3(WidgetSettingPresenter widgetSettingPresenter, Bitmap bitmap, Bitmap bitmap2, String str) {
        WidgetSettingContract widgetSettingContract = widgetSettingPresenter.mContract;
        if (widgetSettingContract != null) {
            widgetSettingContract.updatePreview(bitmap, bitmap2);
        }
        WidgetSettingContract widgetSettingContract2 = widgetSettingPresenter.mContract;
        if (widgetSettingContract2 != null) {
            widgetSettingContract2.updateTitleVoice(CacheFileManager.INSTANCE.getInstance().existVoiceRecording(String.valueOf(str)));
        }
        WidgetSettingContract widgetSettingContract3 = widgetSettingPresenter.mContract;
        if (widgetSettingContract3 != null) {
            widgetSettingContract3.updateBgSettingMenu();
        }
        WidgetSettingContract widgetSettingContract4 = widgetSettingPresenter.mContract;
        if (widgetSettingContract4 != null) {
            widgetSettingContract4.hideLoadingView();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter
    public void cancelAndFinish() {
        if (!Intrinsics.areEqual(this.mModel.getUUID(), this.mModel.getOldUUID())) {
            Activity mActivity = getMActivity();
            Intrinsics.checkNotNull(mActivity);
            NotesDocumentRepository notesDocumentRepositoryCreateDocumentDataRepository = NotesDataRepositoryFactory.newInstance(mActivity).createDocumentDataRepository();
            Intrinsics.checkNotNullExpressionValue(notesDocumentRepositoryCreateDocumentDataRepository, "createDocumentDataRepository(...)");
            String path = notesDocumentRepositoryCreateDocumentDataRepository.getPath(String.valueOf(this.mModel.getOldUUID()));
            if (!TextUtils.isEmpty(path)) {
                Activity mActivity2 = getMActivity();
                Intrinsics.checkNotNull(mActivity2);
                WidgetBroadcast.sendPickWidgetBroadcast(mActivity2, String.valueOf(this.mModel.getOldUUID()), this.mModel.getWidgetId(), this.mModel.getOldTransparency(), path, this.mModel.getOldBackgroundColor(), this.mModel.getOldDarkMode(), false, -1, false);
            }
        }
        super.cancelAndFinish();
    }

    public final void createCacheInfo() {
        String uuid = this.mModel.getUUID();
        if (!Intrinsics.areEqual(BaseWidgetConstant.NONE, uuid)) {
            WidgetSettingContract widgetSettingContract = this.mContract;
            if (widgetSettingContract != null) {
                widgetSettingContract.showLoadingView();
            }
            new SenlThreadFactory(TAG).newThread(new RunnableC0054a(this, uuid, 4)).start();
            return;
        }
        Logger.m8703w(TAG, "createCacheInfo# uuid none");
        WidgetSettingContract widgetSettingContract2 = this.mContract;
        if (widgetSettingContract2 != null) {
            widgetSettingContract2.updateBgSettingMenu();
        }
        WidgetSettingContract widgetSettingContract3 = this.mContract;
        if (widgetSettingContract3 != null) {
            widgetSettingContract3.updateWidgetSettingDarkMode();
        }
    }

    public final int getMWidgetId() {
        return this.mModel.getWidgetId();
    }

    public final int getPageColor() {
        return this.pageColor;
    }

    @Nullable
    public final String getRecommendTitle() {
        String title = getTitle();
        MainListDocumentData docRepository = getDocRepository();
        if (!TextUtils.isEmpty(title) || docRepository == null) {
            return title;
        }
        WidgetUtils.Companion companion = WidgetUtils.INSTANCE;
        Activity mActivity = getMActivity();
        Intrinsics.checkNotNull(mActivity);
        return String.valueOf(companion.getRecommendTitleText(mActivity, docRepository));
    }

    @Nullable
    public final String getTitle() {
        MainListDocumentData docRepository = getDocRepository();
        if (docRepository == null) {
            return null;
        }
        return docRepository.getTitle();
    }

    @Nullable
    public final String getUuid() {
        return this.mModel.getUUID();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter
    @NotNull
    public BaseWidgetSettingContract getView() {
        WidgetSettingContract widgetSettingContract = this.mContract;
        Intrinsics.checkNotNull(widgetSettingContract);
        return widgetSettingContract;
    }

    public final void hideLoadingView() {
        WidgetSettingContract widgetSettingContract = this.mContract;
        if (widgetSettingContract != null) {
            widgetSettingContract.hideLoadingView();
        }
    }

    /* JADX INFO: renamed from: isBackgroundImage, reason: from getter */
    public final boolean getIsBackgroundImage() {
        return this.isBackgroundImage;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        AbstractC4539a.m3188B("onActivityResult# ", this.mModel.getUUID(), TAG);
        if (requestCode != 1 || resultCode != -1) {
            this.mIsNewNote = false;
            return;
        }
        String stringExtra = data != null ? data.getStringExtra(WidgetConstant.EXTRA_KEY_UUID) : null;
        if (stringExtra != null) {
            Logger.m8697d(TAG, "onActivityResult# new uuid : " + stringExtra + " old uuid :" + this.mModel.getUUID());
        } else {
            Logger.m8697d(TAG, "onActivityResult# new uuid null");
        }
        String stringExtra2 = data != null ? data.getStringExtra(WidgetConstant.EXTRA_KEY_FILE_PATH) : null;
        this.mIsNewNote = !TextUtils.isEmpty(stringExtra2);
        if (stringExtra == null || StringsKt.contentEquals((CharSequence) this.mModel.getUUID(), (CharSequence) stringExtra)) {
            return;
        }
        Activity mActivity = getMActivity();
        Intrinsics.checkNotNull(mActivity);
        NotesDocumentRepository notesDocumentRepositoryCreateDocumentDataRepository = NotesDataRepositoryFactory.newInstance(mActivity).createDocumentDataRepository();
        Intrinsics.checkNotNullExpressionValue(notesDocumentRepositoryCreateDocumentDataRepository, "createDocumentDataRepository(...)");
        String path = notesDocumentRepositoryCreateDocumentDataRepository.getPath(stringExtra);
        this.mFilePath = path;
        if (path == null) {
            this.mFilePath = stringExtra2;
        }
        try {
            CacheFileManager.Companion companion = CacheFileManager.INSTANCE;
            CacheFileManager companion2 = companion.getInstance();
            Activity mActivity2 = getMActivity();
            Intrinsics.checkNotNull(mActivity2);
            companion2.removeCacheInfo(mActivity2, String.valueOf(this.mModel.getUUID()));
            this.mModel.setUUID(stringExtra);
            WidgetSettingContract widgetSettingContract = this.mContract;
            if (widgetSettingContract != null) {
                widgetSettingContract.updateNoteTitleView(getRecommendTitle());
            }
            WidgetSettingContract widgetSettingContract2 = this.mContract;
            if (widgetSettingContract2 != null) {
                widgetSettingContract2.updatePreviewTitleView(getTitle());
            }
            if (companion.getInstance().isDoneState(stringExtra)) {
                WidgetSettingContract widgetSettingContract3 = this.mContract;
                if (widgetSettingContract3 != null) {
                    widgetSettingContract3.hideEmptyView();
                }
                updatePreviewAndSetting();
                return;
            }
            WidgetSettingContract widgetSettingContract4 = this.mContract;
            if (widgetSettingContract4 != null) {
                widgetSettingContract4.showLoadingView();
            }
            createCacheInfo(stringExtra);
        } catch (Exception e) {
            Logger.m8699e(TAG, "onActivityResult# exception : ", e);
            ToastHandler.show(getMActivity(), C11391R.string.unable_to_open_note, 0);
        }
    }

    public final void onChangeClicked() {
        Logger.m8702i(TAG, "onChangeClicked# " + this.mModel.getWidgetId());
        if (NoteListAccessHandler.getNotePickerClass() == null) {
            PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(1);
        }
        NotesSamsungAnalytics.INSTANCE.insertLog("616", "6128");
        Intent intent = new Intent(getMActivity(), NoteListAccessHandler.getNotePickerClass());
        intent.setAction(WidgetConstant.ACTION_MEMO_PICK);
        intent.putExtra(WidgetConstant.EXTRA_KEY_WIDGET_PICK_MEMO, true);
        intent.putExtra(WidgetConstant.EXTRA_KEY_WIDGET_SETTING_PICK_MEMO, true);
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, this.mModel.getWidgetId());
        intent.putExtra(WidgetConstant.Pick.TYPE, 1);
        Activity mActivity = getMActivity();
        if (mActivity != null) {
            mActivity.startActivityForResult(intent, 1);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter
    public void saveAndFinish() {
        if (this.mIsNewNote && this.mModel.isOnlyUUIDChanged()) {
            Logger.m8697d(TAG, "saveAndFinish# widget changed new note");
        } else if (this.mModel.isChanged()) {
            Activity mActivity = getMActivity();
            Intrinsics.checkNotNull(mActivity);
            WidgetBroadcast.sendPickWidgetBroadcast(mActivity, String.valueOf(this.mModel.getUUID()), this.mModel.getWidgetId(), this.mModel.getTransparency(), this.mFilePath, this.mModel.getBackgroundColor(), this.mModel.getDarkMode(), false, -1, false);
            NotesSamsungAnalytics.INSTANCE.insertStatusLog("9980", BaseWidgetUtils.INSTANCE.convertAlpha(this.mModel.getReverseTransparency()));
        }
        Activity mActivity2 = getMActivity();
        if (mActivity2 != null) {
            mActivity2.finishAndRemoveTask();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter
    public void setView(@NotNull BaseWidgetSettingContract value) {
        Intrinsics.checkNotNullParameter(value, "value");
        WidgetSettingContract widgetSettingContract = (WidgetSettingContract) value;
        this.mContract = widgetSettingContract;
        if (widgetSettingContract != null) {
            widgetSettingContract.setPresenter(this);
        }
    }

    public final void showLoadingView() {
        WidgetSettingContract widgetSettingContract = this.mContract;
        if (widgetSettingContract != null) {
            widgetSettingContract.showLoadingView();
        }
    }

    public final void updateEmptyPreview() {
        Activity mActivity = getMActivity();
        Intrinsics.checkNotNull(mActivity);
        MainListDocumentData mainListDocumentData = NotesDataRepositoryFactory.newInstance(mActivity).createMainListDocumentDataRepository().get(String.valueOf(this.mModel.getUUID()));
        if (mainListDocumentData == null || mainListDocumentData.getIsDeleted() == 0) {
            return;
        }
        Logger.m8697d(TAG, "updateEmptyPreview# deleted note");
        WidgetSettingContract widgetSettingContract = this.mContract;
        if (widgetSettingContract != null) {
            widgetSettingContract.updateEmptyPreview();
        }
    }

    public final void updateNoteTitle() {
        WidgetSettingContract widgetSettingContract = this.mContract;
        if (widgetSettingContract != null) {
            widgetSettingContract.updateNoteTitleView(getRecommendTitle());
        }
    }

    public final void updatePreviewAndSetting() {
        String uuid = this.mModel.getUUID();
        updateColorAndBgImage(uuid);
        CacheFileManager.Companion companion = CacheFileManager.INSTANCE;
        String thumbnailPath = companion.getInstance().getThumbnailPath(String.valueOf(uuid), 0, false);
        String thumbnailPath2 = companion.getInstance().getThumbnailPath(String.valueOf(uuid), 0, true);
        WidgetUtils.Companion companion2 = WidgetUtils.INSTANCE;
        new Handler(Looper.getMainLooper()).post(new RunnableC0218a(0, this, companion2.getCacheThumbnailFile(thumbnailPath), companion2.getCacheThumbnailFile(thumbnailPath2), uuid));
    }

    public final void updatePreviewTitle() {
        WidgetSettingContract widgetSettingContract = this.mContract;
        if (widgetSettingContract != null) {
            widgetSettingContract.updatePreviewTitleView(getTitle());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter
    @NotNull
    /* JADX INFO: renamed from: getModel, reason: from getter */
    public WidgetSettingModel getMModel() {
        return this.mModel;
    }

    private final void createCacheInfo(String uuid) {
        Logger.m8697d(TAG, "createCacheInfo#");
        CacheFileManager companion = CacheFileManager.INSTANCE.getInstance();
        Activity mActivity = getMActivity();
        Intrinsics.checkNotNull(mActivity);
        companion.createCacheInfo(mActivity, String.valueOf(uuid), String.valueOf(this.mFilePath), -1, this.mCreatedCallback);
    }
}
