package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.controller;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.fragment.app.Fragment;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectImage;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.scs.p142ai.downloader.C7728a;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.picker.image.AppInfo;
import com.samsung.android.support.senl.p148nt.base.winset.app.picker.image.ImagePicker;
import com.samsung.android.support.senl.p148nt.base.winset.app.picker.image.PendingData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.AiDrawingUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.DrawingToolkitsPopOverUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.common.Constant;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.common.DynamicTemplateUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.object.DynamicTemplateObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskAddImage;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.model.base.utils.image.DownloadBitmap;
import com.samsung.android.support.senl.p148nt.model.base.utils.image.ImageUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 12\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0010\u0010\u0019\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u000e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001cJ\u0018\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0018\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001cJ\"\u0010\u001d\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001cH\u0002J1\u0010\u001f\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\u0006\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001c0#2\u0006\u0010$\u001a\u00020%¢\u0006\u0002\u0010&J \u0010'\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!2\u0006\u0010(\u001a\u00020!2\b\u0010)\u001a\u0004\u0018\u00010*J\u001c\u0010+\u001a\u0004\u0018\u00010\u001c2\u0006\u0010(\u001a\u00020!2\b\u0010)\u001a\u0004\u0018\u00010*H\u0002J\u000e\u0010,\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\u00020.8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00062"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/controller/DynamicTemplateImageController;", "", "<init>", "()V", "imagePicker", "Lcom/samsung/android/support/senl/nt/base/winset/app/picker/image/ImagePicker;", "templateObjectManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/object/DynamicTemplateObjectManager;", "composerViewPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;", "controllerManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/ControllerManager;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "fragment", "Landroidx/fragment/app/Fragment;", "pendingData", "Lcom/samsung/android/support/senl/nt/base/winset/app/picker/image/PendingData;", "init", "", "onAttachView", "onItemClicked", "", "objectBase", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "onItemLongClicked", "showImagePicker", "clickedObjectId", "", "showDrawingToolkitsPopOver", "message", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "grantResults", "", "(Landroid/app/Activity;I[Ljava/lang/String;[I)Z", "onActivityResult", "resultCode", "data", "Landroid/content/Intent;", "downloadImageFromResult", "onObjectChanged", "softInputManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/SoftInputManager;", "getSoftInputManager", "()Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/SoftInputManager;", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DynamicTemplateImageController {

    @NotNull
    private static final String KEY_DRAWING_TOOLKIT_RESULT = "resultBitmaps";
    private static final int REQUEST_CODE_FOR_IMAGE_GENERATE = 300003;
    private static final int REQUEST_CODE_FOR_IMAGE_PICKER = 300002;
    private Activity activity;
    private ComposerViewPresenter composerViewPresenter;
    private ControllerManager controllerManager;
    private Fragment fragment;

    @NotNull
    private final ImagePicker imagePicker;

    @Nullable
    private PendingData pendingData;
    private DynamicTemplateObjectManager templateObjectManager;
    private static final String TAG = Logger.createDynamicTemplateLog("ImageController");

    public DynamicTemplateImageController() {
        ImagePicker imagePicker = new ImagePicker();
        this.imagePicker = imagePicker;
        imagePicker.setGalleryPickMaxItemCount(0);
    }

    private final String downloadImageFromResult(int resultCode, Intent data) throws InterruptedException {
        Uri uri;
        File cacheDir;
        List<Uri> urisFromResult = this.imagePicker.getUrisFromResult(data, resultCode);
        if (urisFromResult != null && (uri = urisFromResult.get(0)) != null) {
            ComposerViewPresenter composerViewPresenter = this.composerViewPresenter;
            if (composerViewPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("composerViewPresenter");
                composerViewPresenter = null;
            }
            Context baseContext = composerViewPresenter.getActivity().getBaseContext();
            Intrinsics.checkNotNull(baseContext);
            String mimeType = UriFileUtils.getMimeType(baseContext, uri);
            Logger.m11003i(TAG, "downloadImageFromResult image# mimeType : " + mimeType);
            if (!TextUtils.isEmpty(mimeType)) {
                Intrinsics.checkNotNull(mimeType);
                if (!StringsKt.m14145S(mimeType, com.samsung.android.support.senl.p148nt.base.common.constants.Constants.MIME_VIDEO_START) && (cacheDir = baseContext.getCacheDir()) != null) {
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    String strSaveImageFromUri = DownloadBitmap.saveImageFromUri(baseContext, uri, mimeType, cacheDir.getPath(), new C7728a(countDownLatch));
                    Intrinsics.checkNotNullExpressionValue(strSaveImageFromUri, "saveImageFromUri(...)");
                    countDownLatch.await(10000L, TimeUnit.MILLISECONDS);
                    return strSaveImageFromUri;
                }
            }
        }
        return null;
    }

    private final SoftInputManager getSoftInputManager() {
        ControllerManager controllerManager = this.controllerManager;
        if (controllerManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("controllerManager");
            controllerManager = null;
        }
        SoftInputManager softInputManager = controllerManager.getSoftInputManager();
        Intrinsics.checkNotNullExpressionValue(softInputManager, "getSoftInputManager(...)");
        return softInputManager;
    }

    public static /* synthetic */ void showDrawingToolkitsPopOver$default(DynamicTemplateImageController dynamicTemplateImageController, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        dynamicTemplateImageController.showDrawingToolkitsPopOver(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showImagePicker$lambda$0(DialogInterface dialogInterface) {
        Logger.m10999d(TAG, "onDismissed");
    }

    public final void init(@NotNull DynamicTemplateObjectManager templateObjectManager, @NotNull ControllerManager controllerManager, @NotNull ComposerViewPresenter composerViewPresenter) {
        Intrinsics.checkNotNullParameter(templateObjectManager, "templateObjectManager");
        Intrinsics.checkNotNullParameter(controllerManager, "controllerManager");
        Intrinsics.checkNotNullParameter(composerViewPresenter, "composerViewPresenter");
        this.templateObjectManager = templateObjectManager;
        this.controllerManager = controllerManager;
        this.composerViewPresenter = composerViewPresenter;
    }

    public final boolean onActivityResult(int requestCode, int resultCode, @Nullable Intent data) throws InterruptedException {
        Intent pendingIntent;
        Intent pendingIntent2;
        Intent pendingIntent3;
        Intent pendingIntent4;
        if (requestCode != REQUEST_CODE_FOR_IMAGE_PICKER && requestCode != REQUEST_CODE_FOR_IMAGE_GENERATE) {
            return false;
        }
        if (resultCode != -1) {
            Logger.m11004w(TAG, "onActivityResult, ignore, resultCode: " + resultCode);
            return false;
        }
        if (data == null) {
            Logger.m11004w(TAG, "onActivityResult, ignore, data is null");
            return false;
        }
        String str = TAG;
        AbstractC0000a.m3D(requestCode, "onActivityResult, requestCode: ", str);
        DynamicTemplateObjectManager dynamicTemplateObjectManager = null;
        ControllerManager controllerManager = null;
        switch (requestCode) {
            case REQUEST_CODE_FOR_IMAGE_PICKER /* 300002 */:
                String strDownloadImageFromResult = downloadImageFromResult(resultCode, data);
                PendingData pendingData = this.pendingData;
                String stringExtra = (pendingData == null || (pendingIntent2 = pendingData.getPendingIntent()) == null) ? null : pendingIntent2.getStringExtra(Constant.KEY_TARGET_OBJECT_ID);
                PendingData pendingData2 = this.pendingData;
                Integer numValueOf = (pendingData2 == null || (pendingIntent = pendingData2.getPendingIntent()) == null) ? null : Integer.valueOf(pendingIntent.getIntExtra(Constant.KEY_TARGET_PAGE_INDEX, -1));
                if (TextUtils.isEmpty(stringExtra) || numValueOf == null || numValueOf.intValue() < 0) {
                    Logger.m11004w(str, "onActivityResult, ignore image picker result, data is invalid, targetId: " + stringExtra + ", targetPageIndex: " + numValueOf);
                    return false;
                }
                Logger.m11000e(str, "onActivityResult, targetObjectId: " + stringExtra + ", path: " + Logger.getEncode(strDownloadImageFromResult));
                DynamicTemplateObjectManager dynamicTemplateObjectManager2 = this.templateObjectManager;
                if (dynamicTemplateObjectManager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("templateObjectManager");
                } else {
                    dynamicTemplateObjectManager = dynamicTemplateObjectManager2;
                }
                Intrinsics.checkNotNull(stringExtra);
                return dynamicTemplateObjectManager.updateImage(stringExtra, numValueOf.intValue(), strDownloadImageFromResult);
            case REQUEST_CODE_FOR_IMAGE_GENERATE /* 300003 */:
                PendingData pendingData3 = this.pendingData;
                final String stringExtra2 = (pendingData3 == null || (pendingIntent4 = pendingData3.getPendingIntent()) == null) ? null : pendingIntent4.getStringExtra(Constant.KEY_TARGET_OBJECT_ID);
                PendingData pendingData4 = this.pendingData;
                final Integer numValueOf2 = (pendingData4 == null || (pendingIntent3 = pendingData4.getPendingIntent()) == null) ? null : Integer.valueOf(pendingIntent3.getIntExtra(Constant.KEY_TARGET_PAGE_INDEX, -1));
                if (TextUtils.isEmpty(stringExtra2) || numValueOf2 == null || numValueOf2.intValue() < 0) {
                    Logger.m11004w(str, "onActivityResult, ignore drawing toolkit result, data is invalid, targetId: " + stringExtra2 + ", targetPageIndex: " + numValueOf2);
                    return false;
                }
                ArrayList parcelableArrayListExtra = data.getParcelableArrayListExtra(KEY_DRAWING_TOOLKIT_RESULT);
                if (parcelableArrayListExtra != null) {
                    if (parcelableArrayListExtra.isEmpty()) {
                        Logger.m11000e(str, "onActivityResult# empty list");
                        return false;
                    }
                    ComposerViewPresenter composerViewPresenter = this.composerViewPresenter;
                    if (composerViewPresenter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("composerViewPresenter");
                        composerViewPresenter = null;
                    }
                    Activity activity = composerViewPresenter.getActivity();
                    ComposerViewPresenter composerViewPresenter2 = this.composerViewPresenter;
                    if (composerViewPresenter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("composerViewPresenter");
                        composerViewPresenter2 = null;
                    }
                    ObjectManager objectManager = composerViewPresenter2.getObjectManager();
                    ComposerViewPresenter composerViewPresenter3 = this.composerViewPresenter;
                    if (composerViewPresenter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("composerViewPresenter");
                        composerViewPresenter3 = null;
                    }
                    TaskAddImage.InputValues inputValues = new TaskAddImage.InputValues((Context) activity, (List<Uri>) parcelableArrayListExtra, true, objectManager, composerViewPresenter3.getComposerModel());
                    ControllerManager controllerManager2 = this.controllerManager;
                    if (controllerManager2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("controllerManager");
                    } else {
                        controllerManager = controllerManager2;
                    }
                    controllerManager.getTaskController().execute(new TaskAddImage(), inputValues, new Task.Callback<TaskAddImage.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.template.dynamic.controller.DynamicTemplateImageController$onActivityResult$1$1
                        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
                        public void onError(TaskAddImage.ResultValues result) {
                            Intrinsics.checkNotNull(result);
                            result.showErrorToast();
                        }

                        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
                        public void onSuccess(TaskAddImage.ResultValues result) {
                            Intrinsics.checkNotNull(result);
                            String path = result.getImageDataList().get(0).getPath();
                            if (!AbstractC2322a.m1607A(path)) {
                                Logger.m11000e(DynamicTemplateImageController.TAG, "onActivityResult# outputImageFile not exist");
                                return;
                            }
                            DynamicTemplateObjectManager dynamicTemplateObjectManager3 = this.this$0.templateObjectManager;
                            if (dynamicTemplateObjectManager3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("templateObjectManager");
                                dynamicTemplateObjectManager3 = null;
                            }
                            String str2 = stringExtra2;
                            Intrinsics.checkNotNull(str2);
                            dynamicTemplateObjectManager3.updateImage(str2, numValueOf2.intValue(), path);
                        }
                    }, false);
                    return true;
                }
            default:
                return false;
        }
    }

    public final void onAttachView(@NotNull Activity activity, @NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.activity = activity;
        this.fragment = fragment;
    }

    public final boolean onItemClicked(@Nullable SpenObjectBase objectBase) {
        if ((objectBase instanceof SpenObjectImage) && ((SpenObjectImage) objectBase).getImage() != null) {
            return false;
        }
        if (DynamicTemplateUtil.isInsertImageActionObject(objectBase)) {
            showImagePicker(DynamicTemplateUtil.INSTANCE.getInsertImageTargetObjectId(objectBase));
            return true;
        }
        if (!DynamicTemplateUtil.isInsertGeneratedImageActionObject(objectBase)) {
            return false;
        }
        if (AiDrawingUtil.isDrawingToolkitUsed()) {
            showDrawingToolkitsPopOver$default(this, DynamicTemplateUtil.INSTANCE.getInsertImageTargetObjectId(objectBase), null, 2, null);
        } else {
            showImagePicker(DynamicTemplateUtil.INSTANCE.getInsertImageTargetObjectId(objectBase));
        }
        return true;
    }

    public final boolean onItemLongClicked(@Nullable SpenObjectBase objectBase) {
        if (objectBase instanceof SpenObjectTextBox) {
            return DynamicTemplateUtil.isInsertImageActionObject(objectBase) || DynamicTemplateUtil.isInsertGeneratedImageActionObject(objectBase);
        }
        return false;
    }

    public final void onObjectChanged(@NotNull SpenObjectBase objectBase) {
        Intrinsics.checkNotNullParameter(objectBase, "objectBase");
        String objectId = DynamicTemplateUtil.INSTANCE.getObjectId(objectBase);
        if (!TextUtils.isEmpty(objectId) && DynamicTemplateUtil.isInsertGeneratedImageActionObject(objectBase) && DynamicTemplateUtil.isDynamicTemplateGenerativeObject(objectBase)) {
            DynamicTemplateObjectManager dynamicTemplateObjectManager = this.templateObjectManager;
            if (dynamicTemplateObjectManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("templateObjectManager");
                dynamicTemplateObjectManager = null;
            }
            SpenObjectTextBox spenObjectTextBoxFindObjectTextBoxById = dynamicTemplateObjectManager.findObjectTextBoxById(null, objectId);
            if (spenObjectTextBoxFindObjectTextBoxById == null || spenObjectTextBoxFindObjectTextBoxById.getVisible()) {
                return;
            }
            ImageUtil.removeGenerativeEditExtraData(objectBase);
        }
    }

    public final boolean onRequestPermissionsResult(@NotNull Activity activity, int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        return this.imagePicker.onRequestPermissionsResult(activity, requestCode, (String[]) Arrays.copyOf(permissions, permissions.length), grantResults, this.pendingData);
    }

    public final void showDrawingToolkitsPopOver(@NotNull String clickedObjectId, @NotNull String message) {
        Intrinsics.checkNotNullParameter(clickedObjectId, "clickedObjectId");
        Intrinsics.checkNotNullParameter(message, "message");
        Activity activity = this.activity;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Constants.StringExtra.EXECUTE_TYPE_ACTIVITY);
            activity = null;
        }
        showDrawingToolkitsPopOver(activity, clickedObjectId, message);
    }

    public final void showImagePicker(@NotNull String clickedObjectId) {
        Intrinsics.checkNotNullParameter(clickedObjectId, "clickedObjectId");
        Fragment fragment = this.fragment;
        if (fragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragment");
            fragment = null;
        }
        showImagePicker(fragment, clickedObjectId);
    }

    private final void showDrawingToolkitsPopOver(Activity activity, String clickedObjectId, String message) {
        Intent pendingIntent;
        Intent pendingIntent2;
        DynamicTemplateObjectManager dynamicTemplateObjectManager = null;
        getSoftInputManager().hide((View) null);
        ComposerViewPresenter composerViewPresenter = this.composerViewPresenter;
        if (composerViewPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("composerViewPresenter");
            composerViewPresenter = null;
        }
        if (composerViewPresenter.getDoc() != null) {
            PendingData pendingData = new PendingData();
            this.pendingData = pendingData;
            pendingData.setPendingIntent(new Intent());
            PendingData pendingData2 = this.pendingData;
            if (pendingData2 != null && (pendingIntent2 = pendingData2.getPendingIntent()) != null) {
                pendingIntent2.putExtra(Constant.KEY_TARGET_OBJECT_ID, clickedObjectId);
            }
            PendingData pendingData3 = this.pendingData;
            if (pendingData3 != null && (pendingIntent = pendingData3.getPendingIntent()) != null) {
                DynamicTemplateObjectManager dynamicTemplateObjectManager2 = this.templateObjectManager;
                if (dynamicTemplateObjectManager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("templateObjectManager");
                } else {
                    dynamicTemplateObjectManager = dynamicTemplateObjectManager2;
                }
                pendingIntent.putExtra(Constant.KEY_TARGET_PAGE_INDEX, dynamicTemplateObjectManager.findPageIndexByObjectId(clickedObjectId));
            }
            DrawingToolkitsPopOverUtils.INSTANCE.showDrawingToolkitsPopOver(activity, message, REQUEST_CODE_FOR_IMAGE_GENERATE);
        }
    }

    private final void showImagePicker(Fragment fragment, final String clickedObjectId) {
        getSoftInputManager().hide((View) null);
        this.imagePicker.show(fragment, null, AppInfo.APP_GALLERY, false, Integer.valueOf(REQUEST_CODE_FOR_IMAGE_PICKER), new ImagePicker.OnItemClickedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.template.dynamic.controller.DynamicTemplateImageController.showImagePicker.1
            @Override // com.samsung.android.support.senl.nt.base.winset.app.picker.image.ImagePicker.OnItemClickedListener
            public void onItemClicked(int requestCode, PendingData pendingData) {
                Intent pendingIntent;
                Logger.m10999d(DynamicTemplateImageController.TAG, "onItemClicked, " + requestCode + SQLKeyword.COMMA + pendingData);
                if (pendingData != null) {
                    DynamicTemplateImageController.this.pendingData = pendingData;
                } else {
                    DynamicTemplateImageController.this.pendingData = new PendingData();
                }
                DynamicTemplateObjectManager dynamicTemplateObjectManager = DynamicTemplateImageController.this.templateObjectManager;
                if (dynamicTemplateObjectManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("templateObjectManager");
                    dynamicTemplateObjectManager = null;
                }
                int iFindPageIndexByObjectId = dynamicTemplateObjectManager.findPageIndexByObjectId(clickedObjectId);
                PendingData pendingData2 = DynamicTemplateImageController.this.pendingData;
                if (pendingData2 != null && (pendingIntent = pendingData2.getPendingIntent()) != null) {
                    pendingIntent.putExtra(Constant.KEY_TARGET_OBJECT_ID, clickedObjectId);
                    pendingIntent.putExtra(Constant.KEY_TARGET_PAGE_INDEX, iFindPageIndexByObjectId);
                    return;
                }
                String str = clickedObjectId;
                DynamicTemplateImageController dynamicTemplateImageController = DynamicTemplateImageController.this;
                Intent intent = new Intent();
                intent.putExtra(Constant.KEY_TARGET_OBJECT_ID, str);
                intent.putExtra(Constant.KEY_TARGET_PAGE_INDEX, iFindPageIndexByObjectId);
                PendingData pendingData3 = dynamicTemplateImageController.pendingData;
                if (pendingData3 != null) {
                    pendingData3.setPendingIntent(intent);
                }
            }

            @Override // com.samsung.android.support.senl.nt.base.winset.app.picker.image.ImagePicker.OnItemClickedListener
            public void printMemory() {
                Logger.m10999d(DynamicTemplateImageController.TAG, "printMemory");
            }

            @Override // com.samsung.android.support.senl.nt.base.winset.app.picker.image.ImagePicker.OnItemClickedListener
            public void setRequestCode(int requestCode) {
                AbstractC0000a.m3D(requestCode, "setRequestCode, ", DynamicTemplateImageController.TAG);
            }
        }, new DialogInterfaceOnDismissListenerC9877a(0));
    }

    public static /* synthetic */ void showDrawingToolkitsPopOver$default(DynamicTemplateImageController dynamicTemplateImageController, Activity activity, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "";
        }
        dynamicTemplateImageController.showDrawingToolkitsPopOver(activity, str, str2);
    }
}
