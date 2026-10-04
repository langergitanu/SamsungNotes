package com.samsung.android.app.notes.widget.glance.single.setting.presenter;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.widget.broadcast.WidgetBroadcast;
import com.samsung.android.app.notes.widget.capture.CacheFileManager;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.app.notes.widget.common.log.WidgetLogger;
import com.samsung.android.app.notes.widget.glance.single.setting.model.WidgetSingleGlanceSettingModel;
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
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import com.samsung.android.support.senl.p148nt.homewidget.C11391R;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p014C3.RunnableC0054a;
import p065P1.C0196b;
import p065P1.C0198d;
import p065P1.RunnableC0197c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 E2\u00020\u0001:\u0001EB\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020(H\u0016J\"\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u000f2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0006\u0010/\u001a\u00020(J\u0006\u00100\u001a\u00020(J\u0012\u00101\u001a\u00020(2\b\u00102\u001a\u0004\u0018\u00010\rH\u0002J\b\u00103\u001a\u00020(H\u0002J\u0006\u0010=\u001a\u00020\u0013J\u0006\u0010>\u001a\u00020(J\u0012\u0010>\u001a\u00020(2\b\u00102\u001a\u0004\u0018\u00010\rH\u0002J\u0006\u0010?\u001a\u00020(J\b\u0010@\u001a\u00020(H\u0002J\u0014\u0010A\u001a\u0004\u0018\u00010B2\b\u0010C\u001a\u0004\u0018\u00010DH\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R$\u0010\"\u001a\u00020!2\u0006\u0010\u000e\u001a\u00020!8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0013\u00104\u001a\u0004\u0018\u00010\r8F¢\u0006\u0006\u001a\u0004\b5\u0010\u0019R\u0013\u00106\u001a\u0004\u0018\u00010\r8F¢\u0006\u0006\u001a\u0004\b7\u0010\u0019R\u0016\u00108\u001a\u0004\u0018\u0001098BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0011\u0010<\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0015¨\u0006F"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/glance/single/setting/presenter/WidgetSingleGlanceSettingPresenter;", "Lcom/samsung/android/support/senl/nt/base/widget/setting/presenter/BaseWidgetSettingPresenter;", "bundle", "Landroid/os/Bundle;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "<init>", "(Landroid/os/Bundle;Landroid/app/Activity;)V", "mModel", "Lcom/samsung/android/app/notes/widget/glance/single/setting/model/WidgetSingleGlanceSettingModel;", "mContract", "Lcom/samsung/android/app/notes/widget/glance/single/setting/presenter/WidgetSingleGlanceSettingContract;", "mFilePath", "", "value", "", "pageColor", "getPageColor", "()I", "", "isBackgroundImage", "()Z", "mIsNewNote", "typeWidgetView", "getTypeWidgetView", "()Ljava/lang/String;", "setTypeWidgetView", "(Ljava/lang/String;)V", "mCreatedCallback", "Lcom/samsung/android/app/notes/widget/capture/CacheFileManager$Callback;", "model", "getModel", "()Lcom/samsung/android/app/notes/widget/glance/single/setting/model/WidgetSingleGlanceSettingModel;", "Lcom/samsung/android/support/senl/nt/base/widget/setting/view/BaseWidgetSettingContract;", "view", "getView", "()Lcom/samsung/android/support/senl/nt/base/widget/setting/view/BaseWidgetSettingContract;", "setView", "(Lcom/samsung/android/support/senl/nt/base/widget/setting/view/BaseWidgetSettingContract;)V", "saveAndFinish", "", "cancelAndFinish", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "updatePreviewAndSetting", "updateLoadingView", "updateColorAndBgImage", "uuid", "initSpenSdk", "recommendTitle", "getRecommendTitle", "title", DynamicActionBarProvider.METHOD_GET_DATA, "docRepository", "Lcom/samsung/android/support/senl/nt/data/database/core/document/data/MainListDocumentData;", "getDocRepository", "()Lcom/samsung/android/support/senl/nt/data/database/core/document/data/MainListDocumentData;", "isSmartPage", "isEnableBackgroundOnOff", "createCacheInfo", "onChangeClicked", "updateFilePath", "getWallpaperBitmap", "Landroid/graphics/Bitmap;", "context", "Landroid/content/Context;", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nWidgetSingleGlanceSettingPresenter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetSingleGlanceSettingPresenter.kt\ncom/samsung/android/app/notes/widget/glance/single/setting/presenter/WidgetSingleGlanceSettingPresenter\n+ 2 Uri.kt\nandroidx/core/net/UriKt\n*L\n1#1,339:1\n29#2:340\n*S KotlinDebug\n*F\n+ 1 WidgetSingleGlanceSettingPresenter.kt\ncom/samsung/android/app/notes/widget/glance/single/setting/presenter/WidgetSingleGlanceSettingPresenter\n*L\n318#1:340\n*E\n"})
public final class WidgetSingleGlanceSettingPresenter extends BaseWidgetSettingPresenter {

    @NotNull
    private static final String TAG = "WidgetSingleGlanceSettingPresenter";

    @NotNull
    private static final String TYPE = "cover_wallpaper";

    @NotNull
    private static final String URI_HEADER_KEYGUARD_IMAGE = "content://com.android.systemui.keyguard.image";
    private boolean isBackgroundImage;
    private final boolean isSmartPage;

    @Nullable
    private WidgetSingleGlanceSettingContract mContract;

    @NotNull
    private final CacheFileManager.Callback mCreatedCallback;

    @Nullable
    private String mFilePath;
    private boolean mIsNewNote;

    @NotNull
    private final WidgetSingleGlanceSettingModel mModel;
    private int pageColor;

    @NotNull
    private String typeWidgetView;
    public static final int $stable = 8;

    public WidgetSingleGlanceSettingPresenter(@Nullable Bundle bundle, @Nullable Activity activity) {
        String string;
        super(activity);
        Intrinsics.checkNotNull(activity);
        WidgetSingleGlanceSettingModel widgetSingleGlanceSettingModel = new WidgetSingleGlanceSettingModel(bundle, activity);
        this.mModel = widgetSingleGlanceSettingModel;
        this.typeWidgetView = WidgetConstant.EMPTY_VIEW;
        this.mCreatedCallback = new C0196b(this, 0);
        checkValidWidget();
        updateFilePath();
        if (WidgetUtils.INSTANCE.isSDoc(activity, widgetSingleGlanceSettingModel.getUUID())) {
            Resources resources = activity.getResources();
            if (resources != null && (string = resources.getString(C11391R.string.widget_convert_document)) != null) {
                ToastHandler.show(activity, string, 1);
            }
            activity.finishAndRemoveTask();
        } else {
            initSpenSdk();
        }
        this.isSmartPage = getOneUiWidgetSource() != null && Intrinsics.areEqual(getOneUiWidgetSource(), BaseWidgetConstant.ONE_UI_WIDGET_SOURCE_SPAGE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createCacheInfo$lambda$4(WidgetSingleGlanceSettingPresenter widgetSingleGlanceSettingPresenter, String str) {
        if (widgetSingleGlanceSettingPresenter.getMActivity() == null) {
            return;
        }
        int widgetId = widgetSingleGlanceSettingPresenter.mModel.getWidgetId();
        CacheFileManager.Companion companion = CacheFileManager.INSTANCE;
        if (!companion.getInstance().isInitialized()) {
            CacheFileManager companion2 = companion.getInstance();
            Activity mActivity = widgetSingleGlanceSettingPresenter.getMActivity();
            Intrinsics.checkNotNull(mActivity);
            companion2.init(mActivity);
        }
        if (companion.getInstance().isValidCacheFiles(String.valueOf(str))) {
            widgetSingleGlanceSettingPresenter.updatePreviewAndSetting();
            return;
        }
        Logger.m8697d(TAG, "createCacheInfo# create new cache");
        if (companion.getInstance().isCreateWidgetState(widgetSingleGlanceSettingPresenter.getMActivity(), String.valueOf(str), widgetId)) {
            CacheFileManager companion3 = companion.getInstance();
            Activity mActivity2 = widgetSingleGlanceSettingPresenter.getMActivity();
            Intrinsics.checkNotNull(mActivity2);
            companion3.removeCacheInfo(mActivity2, String.valueOf(str));
        }
        widgetSingleGlanceSettingPresenter.updateFilePath();
        CacheFileManager companion4 = companion.getInstance();
        Activity mActivity3 = widgetSingleGlanceSettingPresenter.getMActivity();
        Intrinsics.checkNotNull(mActivity3);
        companion4.createCacheInfo(mActivity3, String.valueOf(str), String.valueOf(widgetSingleGlanceSettingPresenter.mFilePath), widgetId, widgetSingleGlanceSettingPresenter.mCreatedCallback);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getWallpaperBitmap$lambda$5(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        Intrinsics.checkNotNull(imageDecoder);
        imageDecoder.setAllocator(1);
    }

    private final void initSpenSdk() {
        SpenSdkInitializer.initialize(getMActivity());
        SpenComposerSdkInitializer.initialize(getMActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mCreatedCallback$lambda$1(WidgetSingleGlanceSettingPresenter widgetSingleGlanceSettingPresenter) {
        Activity mActivity;
        Logger.m8697d(TAG, "onCacheCreated# ");
        if (widgetSingleGlanceSettingPresenter.getMActivity() != null) {
            Activity mActivity2 = widgetSingleGlanceSettingPresenter.getMActivity();
            Boolean boolValueOf = mActivity2 != null ? Boolean.valueOf(mActivity2.isDestroyed()) : null;
            Intrinsics.checkNotNull(boolValueOf);
            if (boolValueOf.booleanValue()) {
                return;
            }
            Activity mActivity3 = widgetSingleGlanceSettingPresenter.getMActivity();
            Boolean boolValueOf2 = mActivity3 != null ? Boolean.valueOf(mActivity3.isFinishing()) : null;
            Intrinsics.checkNotNull(boolValueOf2);
            if (boolValueOf2.booleanValue() || (mActivity = widgetSingleGlanceSettingPresenter.getMActivity()) == null) {
                return;
            }
            mActivity.runOnUiThread(new RunnableC0197c(widgetSingleGlanceSettingPresenter, 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mCreatedCallback$lambda$1$lambda$0(WidgetSingleGlanceSettingPresenter widgetSingleGlanceSettingPresenter) {
        if (CacheFileManager.INSTANCE.getInstance().isDoneState(String.valueOf(widgetSingleGlanceSettingPresenter.mModel.getUUID()))) {
            widgetSingleGlanceSettingPresenter.updatePreviewAndSetting();
        } else {
            widgetSingleGlanceSettingPresenter.createCacheInfo(widgetSingleGlanceSettingPresenter.mModel.getUUID());
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
            Logger.m8697d(TAG, "updateFilePath# uuid: ".concat(uuid));
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
        } else if (!Intrinsics.areEqual(BaseWidgetConstant.NONE, uuid)) {
            Logger.m8697d(TAG, "updateFilePath# file path is null");
            new ArrayList(1).add(String.valueOf(uuid));
        }
        Logger.m8697d(TAG, "updateFilePath# mFilepath: " + this.mFilePath + ", filepath: " + path);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updatePreviewAndSetting$lambda$3(WidgetSingleGlanceSettingPresenter widgetSingleGlanceSettingPresenter) {
        WidgetSingleGlanceSettingContract widgetSingleGlanceSettingContract = widgetSingleGlanceSettingPresenter.mContract;
        if (widgetSingleGlanceSettingContract != null) {
            widgetSingleGlanceSettingContract.updatePreview();
        }
        WidgetSingleGlanceSettingContract widgetSingleGlanceSettingContract2 = widgetSingleGlanceSettingPresenter.mContract;
        if (widgetSingleGlanceSettingContract2 != null) {
            widgetSingleGlanceSettingContract2.updateBgSettingMenu();
        }
        WidgetSingleGlanceSettingContract widgetSingleGlanceSettingContract3 = widgetSingleGlanceSettingPresenter.mContract;
        if (widgetSingleGlanceSettingContract3 != null) {
            widgetSingleGlanceSettingContract3.updateBackgroundOnOff(widgetSingleGlanceSettingPresenter.isEnableBackgroundOnOff());
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
                WidgetBroadcast.sendPickWidgetBroadcast(mActivity2, String.valueOf(this.mModel.getOldUUID()), this.mModel.getWidgetId(), this.mModel.getOldTransparency(), path, this.mModel.getOldBackgroundColor(), this.mModel.getOldDarkMode(), getMModel().getOldMatchSetting(), getMModel().getOldBackgroundShape(), getMModel().getOldBackgroundOnOff());
            }
        }
        super.cancelAndFinish();
    }

    public final void createCacheInfo() {
        String uuid = this.mModel.getUUID();
        if (!Intrinsics.areEqual(BaseWidgetConstant.NONE, uuid)) {
            updateLoadingView();
            new SenlThreadFactory(TAG).newThread(new RunnableC0054a(this, uuid, 3)).start();
            return;
        }
        Logger.m8703w(TAG, "createCacheInfo# uuid none");
        WidgetSingleGlanceSettingContract widgetSingleGlanceSettingContract = this.mContract;
        if (widgetSingleGlanceSettingContract != null) {
            widgetSingleGlanceSettingContract.updateBgSettingMenu();
        }
        WidgetSingleGlanceSettingContract widgetSingleGlanceSettingContract2 = this.mContract;
        if (widgetSingleGlanceSettingContract2 != null) {
            widgetSingleGlanceSettingContract2.updateWidgetSettingDarkMode();
        }
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

    @NotNull
    public final String getTypeWidgetView() {
        return this.typeWidgetView;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter
    @NotNull
    public BaseWidgetSettingContract getView() {
        WidgetSingleGlanceSettingContract widgetSingleGlanceSettingContract = this.mContract;
        Intrinsics.checkNotNull(widgetSingleGlanceSettingContract);
        return widgetSingleGlanceSettingContract;
    }

    @RequiresApi(28)
    @Nullable
    public final Bitmap getWallpaperBitmap(@Nullable Context context) {
        if (context == null) {
            return null;
        }
        ContentResolver contentResolver = context.getContentResolver();
        Intrinsics.checkNotNullExpressionValue("content://com.android.systemui.keyguard.image/portrait?type=cover_wallpaper", "toString(...)");
        ImageDecoder.Source sourceCreateSource = ImageDecoder.createSource(contentResolver, Uri.parse("content://com.android.systemui.keyguard.image/portrait?type=cover_wallpaper"));
        Intrinsics.checkNotNullExpressionValue(sourceCreateSource, "createSource(...)");
        try {
            Bitmap bitmapDecodeBitmap = ImageDecoder.decodeBitmap(sourceCreateSource, new C0198d());
            Intrinsics.checkNotNullExpressionValue(bitmapDecodeBitmap, "decodeBitmap(...)");
            return bitmapDecodeBitmap;
        } catch (IOException e) {
            WidgetLogger.INSTANCE.m5157e(TAG, "getKeyguardImageWallpaperBitmap: " + e.getMessage());
            return null;
        }
    }

    /* JADX INFO: renamed from: isBackgroundImage, reason: from getter */
    public final boolean getIsBackgroundImage() {
        return this.isBackgroundImage;
    }

    public final boolean isEnableBackgroundOnOff() {
        String title;
        if (this.isSmartPage) {
            return false;
        }
        if (!CacheFileManager.INSTANCE.getInstance().isTextOnlyNote(String.valueOf(this.mModel.getUUID()))) {
            return true;
        }
        MainListDocumentData docRepository = getDocRepository();
        String content = docRepository != null ? docRepository.getContent() : null;
        return ((content == null || content.length() == 0) && ((title = getTitle()) == null || title.length() == 0)) ? false : true;
    }

    /* JADX INFO: renamed from: isSmartPage, reason: from getter */
    public final boolean getIsSmartPage() {
        return this.isSmartPage;
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
            WidgetSingleGlanceSettingContract widgetSingleGlanceSettingContract = this.mContract;
            if (widgetSingleGlanceSettingContract != null) {
                widgetSingleGlanceSettingContract.updateNoteTitleView(getRecommendTitle());
            }
            if (companion.getInstance().isDoneState(stringExtra)) {
                updatePreviewAndSetting();
            } else {
                createCacheInfo(stringExtra);
            }
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
        NotesSamsungAnalytics.INSTANCE.insertLog("613", "6128");
        Intent intent = new Intent(getMActivity(), NoteListAccessHandler.getNotePickerClass());
        intent.setAction(WidgetConstant.ACTION_MEMO_PICK);
        intent.putExtra(WidgetConstant.EXTRA_KEY_WIDGET_PICK_MEMO, true);
        intent.putExtra(WidgetConstant.EXTRA_KEY_WIDGET_SETTING_PICK_MEMO, true);
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, this.mModel.getWidgetId());
        intent.putExtra(WidgetConstant.Pick.TYPE, 1);
        intent.putExtra(WidgetConstant.WIDGET_PROVIDER_NAME, this.mModel.getProviderName());
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
            WidgetBroadcast.sendPickWidgetBroadcast(mActivity, String.valueOf(this.mModel.getUUID()), this.mModel.getWidgetId(), this.mModel.getTransparency(), this.mFilePath, this.mModel.getBackgroundColor(), this.mModel.getDarkMode(), getMModel().getMatchSetting(), getMModel().getBackgroundShape(), getMModel().getBackgroundOnOff());
            NotesSamsungAnalytics.INSTANCE.insertLog("613", "6125");
        }
        Activity mActivity2 = getMActivity();
        if (mActivity2 != null) {
            mActivity2.finishAndRemoveTask();
        }
    }

    public final void setTypeWidgetView(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.typeWidgetView = str;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter
    public void setView(@NotNull BaseWidgetSettingContract value) {
        Intrinsics.checkNotNullParameter(value, "value");
        WidgetSingleGlanceSettingContract widgetSingleGlanceSettingContract = (WidgetSingleGlanceSettingContract) value;
        this.mContract = widgetSingleGlanceSettingContract;
        if (widgetSingleGlanceSettingContract != null) {
            widgetSingleGlanceSettingContract.setPresenter(this);
        }
    }

    public final void updateLoadingView() {
        this.typeWidgetView = WidgetConstant.LOADING_VIEW;
        WidgetSingleGlanceSettingContract widgetSingleGlanceSettingContract = this.mContract;
        if (widgetSingleGlanceSettingContract != null) {
            widgetSingleGlanceSettingContract.updatePreview();
        }
    }

    public final void updatePreviewAndSetting() {
        updateColorAndBgImage(this.mModel.getUUID());
        this.typeWidgetView = WidgetConstant.NORMAL_VIEW;
        new Handler(Looper.getMainLooper()).post(new RunnableC0197c(this, 0));
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter
    @NotNull
    /* JADX INFO: renamed from: getModel, reason: from getter */
    public WidgetSingleGlanceSettingModel getMModel() {
        return this.mModel;
    }

    private final void createCacheInfo(String uuid) {
        Logger.m8697d(TAG, "createCacheInfo#");
        updateLoadingView();
        CacheFileManager companion = CacheFileManager.INSTANCE.getInstance();
        Activity mActivity = getMActivity();
        Intrinsics.checkNotNull(mActivity);
        companion.createCacheInfo(mActivity, String.valueOf(uuid), String.valueOf(this.mFilePath), -1, this.mCreatedCallback);
    }
}
