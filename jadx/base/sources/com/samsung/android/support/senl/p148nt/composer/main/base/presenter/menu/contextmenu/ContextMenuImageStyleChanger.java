package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.Menu;
import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectImage;
import com.samsung.android.sdk.pen.document.SpenObjectPainting;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.common.util.BaseImageUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectFindUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectSpanHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.TaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.Constant;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskAddImage;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskStyleChanger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerRequestCode;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerSpenWNoteUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuImageStyleChanger extends ContextMenuItem {
    private static final String PKG_NAME = "com.samsung.android.app.sketchbook";
    private static final String TAG = Logger.createTag("ContextMenuImageStyleChanger");
    ComposerViewPresenter mComposerViewPresenter;
    ObjectManager mObjectManager;
    TaskController mTaskController;

    public ContextMenuImageStyleChanger(ComposerViewPresenter composerViewPresenter, ControllerManager controllerManager) {
        this.mComposerViewPresenter = composerViewPresenter;
        this.mObjectManager = composerViewPresenter.getObjectManager();
        this.mTaskController = controllerManager.getTaskController();
    }

    @NonNull
    private Intent getCreatorCanvasIntent(String str, Uri uri) {
        Intent intentMakeBaseCreatorCanvasIntent = makeBaseCreatorCanvasIntent();
        intentMakeBaseCreatorCanvasIntent.putExtra(Constant.DRAWING_TOOLKIT_KEY_IMAGE_TYPE, uri);
        intentMakeBaseCreatorCanvasIntent.putExtra("notes_objectId", str);
        intentMakeBaseCreatorCanvasIntent.addFlags(3);
        if (Build.VERSION.SDK_INT > 30) {
            this.mActivity.grantUriPermission("com.samsung.android.app.sketchbook", uri, 3);
        }
        return intentMakeBaseCreatorCanvasIntent;
    }

    private SpenObjectBase getFindSourceImageObject(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return ObjectFindUtil.getObject(this.mComposerViewPresenter.getDoc(), 4, 3, str, new ObjectFindUtil.Finder() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.ContextMenuImageStyleChanger.3
            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.object.ObjectFindUtil.Finder
            public boolean find(@NonNull String str2, SpenObjectBase spenObjectBase) {
                return str2.equals(spenObjectBase.getId());
            }
        });
    }

    private boolean isImageSelected() {
        ArrayList<SpenObjectBase> selectedSafeObjectList = this.mObjectManager.getSelectedSafeObjectList();
        if (selectedSafeObjectList.size() != 1) {
            return false;
        }
        SpenObjectBase spenObjectBase = selectedSafeObjectList.get(0);
        return spenObjectBase.getType() == 3 || spenObjectBase.getType() == 14;
    }

    public static boolean isSupported(Activity activity) {
        return false;
    }

    private static Intent makeBaseCreatorCanvasIntent() {
        Intent intent = new Intent(Constant.DRAWING_TOOLKIT_ACTION_GET_CONTENT);
        intent.setPackage("com.samsung.android.app.sketchbook");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.putExtra("type", "image");
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceImage(String str, SpenObjectImage spenObjectImage) {
        String str2 = TAG;
        Logger.m10999d(str2, "replaceImage#");
        boolean z = (TextUtils.isEmpty(spenObjectImage.getOriginalImagePath()) || spenObjectImage.getOriginalRect() == null) ? false : true;
        spenObjectImage.setCropRect(null);
        spenObjectImage.setOriginalRect(null);
        spenObjectImage.setImage(str);
        if (z) {
            Logger.m11003i(str2, "setImage# hasLassoCrop is true.");
            spenObjectImage.setOriginalImage(null);
        }
        float imageRatio = BaseImageUtils.getImageRatio(str);
        RectF rect = spenObjectImage.getRect();
        float fHeight = rect.height() / rect.width();
        if (imageRatio - fHeight != 0.0f) {
            Logger.m10999d(str2, "setImage# adjust ratio: " + imageRatio + " - " + fHeight);
            rect.bottom = (rect.width() * imageRatio) + rect.top;
            spenObjectImage.setRect(rect, false);
        }
        this.mComposerViewPresenter.getDoc().commitHistory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replacePainting(String str, SpenObjectPainting spenObjectPainting) {
        String str2 = TAG;
        Logger.m10999d(str2, "replacePainting#");
        SpenObjectImage spenObjectImage = new SpenObjectImage();
        spenObjectImage.setImage(str);
        RectF rect = spenObjectPainting.getRect();
        spenObjectImage.setRect(rect, false);
        Integer pageIndexByObject = ComposerSpenWNoteUtils.getPageIndexByObject(this.mComposerViewPresenter.getDoc(), spenObjectPainting, 8196);
        if (pageIndexByObject == null) {
            SpenWNote doc = this.mComposerViewPresenter.getDoc();
            ArrayList arrayList = new ArrayList();
            arrayList.add(spenObjectPainting);
            ObjectSpanHelper objectSpanHelper = new ObjectSpanHelper(doc);
            List<SpenObjectSpan> listFindObjectSpan = objectSpanHelper.findObjectSpan(arrayList);
            if (listFindObjectSpan.isEmpty()) {
                Logger.m11000e(str2, "replacePainting# fail to find object span");
                return;
            }
            SpenObjectSpan spenObjectSpan = listFindObjectSpan.get(0);
            spenObjectSpan.set(spenObjectImage, spenObjectSpan.getTextIndex());
            objectSpanHelper.deleteObjectSpan(listFindObjectSpan);
            doc.getBodyText().appendObjectSpan(spenObjectSpan);
        } else {
            if (pageIndexByObject.intValue() < 0) {
                Logger.m11000e(str2, "replacePainting# fail to find page index");
                return;
            }
            SpenWPage page = this.mComposerViewPresenter.getDoc().getPage(pageIndexByObject.intValue());
            Point offset = page.getOffset();
            this.mObjectManager.getSpenNoteObjectInserter().insertObject(spenObjectImage, new PointF(offset.x + rect.left, offset.y + rect.top));
            this.mObjectManager.deleteObject(page, spenObjectPainting, true);
        }
        this.mComposerViewPresenter.getDoc().commitHistory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCreatorCanvas(String str, Uri uri) {
        String str2 = TAG;
        Logger.m11003i(str2, "startCreatorCanvas");
        if (this.mActivity == null) {
            Logger.m11000e(str2, "startCreatorCanvas# mActivity is null");
            return;
        }
        Intent creatorCanvasIntent = getCreatorCanvasIntent(str, uri);
        try {
            if (creatorCanvasIntent.resolveActivity(this.mActivity.getPackageManager()) != null) {
                Activity activity = this.mActivity;
                ComposerRequestCode composerRequestCode = ComposerRequestCode.ImageStyleChanger;
                activity.startActivityForResult(creatorCanvasIntent, composerRequestCode.getId());
                this.mComposerViewPresenter.getComposerModel().getComposerState().setLastRequestCode(composerRequestCode.getId());
            }
        } catch (ActivityNotFoundException e) {
            Logger.m11000e(TAG, "startCreatorCanvas not founded " + creatorCanvasIntent.getPackage() + ", e=" + e.getMessage());
        } catch (Exception e2) {
            AbstractC8014b.m7205g(e2, new StringBuilder("startCreatorCanvas failed e="), TAG);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void addMenu(Menu menu) {
        if (canShow()) {
            Drawable drawable = this.mActivity.getDrawable(C9086R.drawable.ic_image_stlye_changer);
            if (drawable != null && ContextUtils.isNightMode(this.mActivity)) {
                drawable.setTint(Color.parseColor("#fafafa"));
            }
            menu.add(0, ContextMenuConstants.getWritingToolkitId(), ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_FIRST.getId(), C9086R.string.composer_ctx_menu_image_style_changer).setIcon(drawable).setEnabled(canShow());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean canShow() {
        return isImageSelected();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void executeMenu() {
        Logger.m10999d(TAG, "executeMenu# " + this.mObjectManager.getSelectedSafeObjectList().get(0).getType());
        final SpenObjectBase spenObjectBase = this.mObjectManager.getSelectedSafeObjectList().get(0);
        this.mObjectManager.setClickedObject(spenObjectBase);
        this.mComposerViewPresenter.requestReadyForSave();
        this.mTaskController.execute(new TaskStyleChanger(), new TaskStyleChanger.InputValues(this.mActivity, this.mObjectManager.getNote(), spenObjectBase), new Task.Callback<TaskStyleChanger.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.ContextMenuImageStyleChanger.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskStyleChanger.ResultValues resultValues) {
                ToastHandler.show(ContextMenuImageStyleChanger.this.mActivity, C9086R.string.composer_failed_to_copy, 1);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskStyleChanger.ResultValues resultValues) {
                ContextMenuImageStyleChanger.this.startCreatorCanvas(spenObjectBase.getId(), resultValues.getUri());
                ContextMenuImageStyleChanger.this.mObjectManager.clearSelectObject();
            }
        }, false);
    }

    public void onActivityResult(int i, Intent intent) {
        if (i != -1 || intent == null) {
            Logger.m11000e(TAG, "onActivityResult# resultCode failed : " + i + " or data is null");
            return;
        }
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("resultBitmaps");
        if (parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty()) {
            Logger.m11000e(TAG, "onActivityResult# empty list");
            return;
        }
        final SpenObjectBase findSourceImageObject = getFindSourceImageObject(intent.getStringExtra("notes_objectId"));
        if (findSourceImageObject == null || findSourceImageObject.getType() != 3 || !(findSourceImageObject instanceof SpenObjectImage)) {
            String str = TAG;
            Logger.m11000e(str, "onActivityResult# imageObject is null");
            SpenObjectBase clickedObject = this.mObjectManager.getClickedObject();
            if (!(clickedObject instanceof SpenObjectImage) && !(clickedObject instanceof SpenObjectPainting)) {
                Logger.m11000e(str, "onActivityResult# clicked object is invalid");
                return;
            }
            findSourceImageObject = clickedObject;
        }
        this.mTaskController.execute(new TaskAddImage(), new TaskAddImage.InputValues((Context) this.mActivity, (List<Uri>) parcelableArrayListExtra, true, this.mObjectManager, this.mComposerViewPresenter.getComposerModel()), new Task.Callback<TaskAddImage.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.ContextMenuImageStyleChanger.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskAddImage.ResultValues resultValues) {
                resultValues.showErrorToast();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskAddImage.ResultValues resultValues) {
                boolean z = false;
                String path = resultValues.getImageDataList().get(0).getPath();
                if (!AbstractC2322a.m1607A(path)) {
                    Logger.m11000e(ContextMenuImageStyleChanger.TAG, "onActivityResult# outputImageFile not exist");
                    return;
                }
                SpenWNote doc = ContextMenuImageStyleChanger.this.mComposerViewPresenter.getDoc();
                if (!doc.isGroupingHistory()) {
                    doc.beginHistoryGroup();
                    z = true;
                }
                SpenObjectBase spenObjectBase = findSourceImageObject;
                if (spenObjectBase instanceof SpenObjectPainting) {
                    ContextMenuImageStyleChanger.this.replacePainting(path, (SpenObjectPainting) spenObjectBase);
                } else {
                    ContextMenuImageStyleChanger.this.replaceImage(path, (SpenObjectImage) spenObjectBase);
                }
                if (z) {
                    doc.endHistoryGroup();
                }
            }
        }, false);
    }
}
