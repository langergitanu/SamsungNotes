package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.controller;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.samsung.android.sdk.composer.listener.SpenObjectSelectListener;
import com.samsung.android.sdk.pen.control.SpenControlObjectListener;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectImage;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.changedInfo.SpenObjectChangedInfo;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.AttachMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuAddPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.common.DynamicTemplateUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.object.DynamicTemplateObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000£\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0003\u0017\u001a\u001d\u0018\u0000 E2\u00020\u0001:\u0002DEB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u001f\u001a\u00020 2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010!\u001a\u00020 J\u0016\u0010\"\u001a\u00020 2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J)\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(2\u0006\u0010*\u001a\u00020+¢\u0006\u0002\u0010,J \u0010-\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010.\u001a\u00020&2\b\u0010/\u001a\u0004\u0018\u000100J\b\u00101\u001a\u00020 H\u0002J\b\u00102\u001a\u00020 H\u0002J\u001c\u00103\u001a\u00020 2\u0006\u00104\u001a\u0002052\f\u00106\u001a\b\u0012\u0004\u0012\u00020807J\u0010\u00109\u001a\u00020 2\b\u0010:\u001a\u0004\u0018\u000108J\u0010\u0010;\u001a\u00020 2\b\u0010:\u001a\u0004\u0018\u000108R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u0016\u0010<\u001a\u0004\u0018\u00010=8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0016\u0010@\u001a\u0004\u0018\u00010A8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bB\u0010C¨\u0006F"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/controller/DynamicTemplateController;", "", "<init>", "()V", "imageController", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/controller/DynamicTemplateImageController;", "textController", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/controller/DynamicTemplateTextController;", "templateObjectManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/object/DynamicTemplateObjectManager;", "controllerManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/ControllerManager;", "composerViewPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;", "optionMenuAddPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/option/OptionMenuAddPresenter;", "attachMenuPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/option/AttachMenuPresenter;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "fragment", "Landroidx/fragment/app/Fragment;", "objectEventListener", "com/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/controller/DynamicTemplateController$objectEventListener$1", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/controller/DynamicTemplateController$objectEventListener$1;", "controlObjectListener", "com/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/controller/DynamicTemplateController$controlObjectListener$1", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/controller/DynamicTemplateController$controlObjectListener$1;", "objectSelectListener", "com/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/controller/DynamicTemplateController$objectSelectListener$1", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/controller/DynamicTemplateController$objectSelectListener$1;", "init", "", "release", "onAttachView", "onRequestPermissionsResult", "", "requestCode", "", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)Z", "onActivityResult", "resultCode", "data", "Landroid/content/Intent;", "registerListeners", "unregisterListeners", "deleteObjectList", "page", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "objectBaseList", "", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "showImagePicker", "objectBase", "showDrawingToolkitsPopOver", "objectManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/ObjectManager;", "getObjectManager", "()Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/ObjectManager;", "listenerManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/listener/ListenerManager;", "getListenerManager", "()Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/listener/ListenerManager;", "SpenObjectEventListener", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DynamicTemplateController {
    private static final String TAG = Logger.createDynamicTemplateLog("Controller");

    @Nullable
    private Activity activity;

    @Nullable
    private AttachMenuPresenter attachMenuPresenter;

    @Nullable
    private ComposerViewPresenter composerViewPresenter;

    @Nullable
    private ControllerManager controllerManager;

    @Nullable
    private Fragment fragment;

    @Nullable
    private OptionMenuAddPresenter optionMenuAddPresenter;

    @Nullable
    private DynamicTemplateObjectManager templateObjectManager;

    @NotNull
    private final DynamicTemplateImageController imageController = new DynamicTemplateImageController();

    @NotNull
    private final DynamicTemplateTextController textController = new DynamicTemplateTextController();

    @NotNull
    private final DynamicTemplateController$objectEventListener$1 objectEventListener = new DynamicTemplateController$objectEventListener$1(this);

    @NotNull
    private final DynamicTemplateController$controlObjectListener$1 controlObjectListener = new SpenControlObjectListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.template.dynamic.controller.DynamicTemplateController$controlObjectListener$1
        @Override // com.samsung.android.sdk.pen.control.SpenControlObjectListener
        public boolean onItemClicked(int toolType, SpenObjectBase objectBase) {
            UserInputSkipper.Tag tag = UserInputSkipper.Tag.ComposerActivity;
            if (!UserInputSkipper.isValidEvent(tag)) {
                return false;
            }
            UserInputSkipper.setHoldingEventTime(300L, tag);
            if (DynamicTemplateUtil.isControllableObject(objectBase)) {
                return this.this$0.imageController.onItemClicked(objectBase) || this.this$0.textController.onItemClicked(objectBase);
            }
            return false;
        }

        @Override // com.samsung.android.sdk.pen.control.SpenControlObjectListener
        public boolean onItemLongClicked(int toolType, SpenObjectBase objectBase) {
            UserInputSkipper.Tag tag = UserInputSkipper.Tag.ComposerActivity;
            if (!UserInputSkipper.isValidEvent(tag)) {
                return false;
            }
            UserInputSkipper.setHoldingEventTime(300L, tag);
            if (!DynamicTemplateUtil.isControllableObject(objectBase)) {
                return false;
            }
            if (this.this$0.imageController.onItemLongClicked(objectBase)) {
                ObjectManager objectManager = this.this$0.getObjectManager();
                if (objectManager != null) {
                    objectManager.clearSelectObject();
                }
                return true;
            }
            if (!this.this$0.textController.onItemLongClicked(objectBase)) {
                return super.onItemLongClicked(toolType, objectBase);
            }
            ObjectManager objectManager2 = this.this$0.getObjectManager();
            if (objectManager2 != null) {
                objectManager2.clearSelectObject();
            }
            return true;
        }
    };

    @NotNull
    private final DynamicTemplateController$objectSelectListener$1 objectSelectListener = new SpenObjectSelectListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.template.dynamic.controller.DynamicTemplateController$objectSelectListener$1
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.samsung.android.sdk.composer.listener.SpenObjectSelectListener
        public void onObjectSelected(ArrayList<SpenWPage> pageList, ArrayList<SpenObjectBase> objectList, boolean selected) {
            List listEmptyList;
            super.onObjectSelected(pageList, objectList, selected);
            DynamicTemplateTextController dynamicTemplateTextController = this.this$0.textController;
            if (objectList != null) {
                listEmptyList = new ArrayList();
                for (Object obj : objectList) {
                    if (obj instanceof SpenObjectTextBox) {
                        listEmptyList.add(obj);
                    }
                }
            } else {
                listEmptyList = CollectionsKt.emptyList();
            }
            dynamicTemplateTextController.onObjectSelected(listEmptyList, selected);
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\"\u0010\u000e\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\rH\u0016J2\u0010\u0011\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/controller/DynamicTemplateController$SpenObjectEventListener;", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote$ObjectEventListener;", "<init>", "()V", "onObjectAdded", "", "page", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "objectList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "Lkotlin/collections/ArrayList;", "historyEventType", "", "onObjectChanged", "changedInfo", "Lcom/samsung/android/sdk/pen/document/changedInfo/SpenObjectChangedInfo;", "onObjectRemoved", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class SpenObjectEventListener implements SpenWNote.ObjectEventListener {
        @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.ObjectEventListener
        public void onObjectAdded(@Nullable SpenWPage page, @NotNull ArrayList<SpenObjectBase> objectList, int historyEventType) {
            Intrinsics.checkNotNullParameter(objectList, "objectList");
        }

        @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.ObjectEventListener
        public void onObjectChanged(@Nullable SpenWPage page, @NotNull SpenObjectChangedInfo changedInfo, int historyEventType) {
            Intrinsics.checkNotNullParameter(changedInfo, "changedInfo");
        }

        @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.ObjectEventListener
        public void onObjectRemoved(@Nullable SpenWPage page, @NotNull ArrayList<SpenObjectBase> objectList, int historyEventType) {
            Intrinsics.checkNotNullParameter(objectList, "objectList");
        }
    }

    private final ListenerManager getListenerManager() {
        ComposerViewPresenter composerViewPresenter = this.composerViewPresenter;
        if (composerViewPresenter != null) {
            return composerViewPresenter.getListenerManager();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ObjectManager getObjectManager() {
        ComposerViewPresenter composerViewPresenter = this.composerViewPresenter;
        if (composerViewPresenter != null) {
            return composerViewPresenter.getObjectManager();
        }
        return null;
    }

    private final void registerListeners() {
        ListenerManager listenerManager = getListenerManager();
        if (listenerManager != null) {
            listenerManager.addSpenObjectEventListener(this.objectEventListener);
        }
        ListenerManager listenerManager2 = getListenerManager();
        if (listenerManager2 != null) {
            listenerManager2.addSpenControlObjectListener(this.controlObjectListener);
        }
        ListenerManager listenerManager3 = getListenerManager();
        if (listenerManager3 != null) {
            listenerManager3.addSpenObjectSelectListener(this.objectSelectListener);
        }
    }

    private final void unregisterListeners() {
        ListenerManager listenerManager = getListenerManager();
        if (listenerManager != null) {
            listenerManager.removeSpenObjectEventListener(this.objectEventListener);
        }
        ListenerManager listenerManager2 = getListenerManager();
        if (listenerManager2 != null) {
            listenerManager2.removeSpenControlObjectListener(this.controlObjectListener);
        }
        ListenerManager listenerManager3 = getListenerManager();
        if (listenerManager3 != null) {
            listenerManager3.removeSpenObjectSelectListener(this.objectSelectListener);
        }
    }

    public final void deleteObjectList(@NotNull SpenWPage page, @NotNull List<? extends SpenObjectBase> objectBaseList) {
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(objectBaseList, "objectBaseList");
        for (SpenObjectBase spenObjectBase : objectBaseList) {
            if (spenObjectBase instanceof SpenObjectImage) {
                DynamicTemplateObjectManager dynamicTemplateObjectManager = this.templateObjectManager;
                if (dynamicTemplateObjectManager != null) {
                    dynamicTemplateObjectManager.releaseImage(page, (SpenObjectImage) spenObjectBase);
                }
            } else {
                ObjectManager objectManager = getObjectManager();
                if (objectManager != null) {
                    objectManager.deleteObject(page, spenObjectBase, false);
                }
            }
        }
    }

    public final void init(@NotNull DynamicTemplateObjectManager templateObjectManager, @NotNull ControllerManager controllerManager, @NotNull ComposerViewPresenter composerViewPresenter, @NotNull OptionMenuAddPresenter optionMenuAddPresenter, @NotNull AttachMenuPresenter attachMenuPresenter) {
        Intrinsics.checkNotNullParameter(templateObjectManager, "templateObjectManager");
        Intrinsics.checkNotNullParameter(controllerManager, "controllerManager");
        Intrinsics.checkNotNullParameter(composerViewPresenter, "composerViewPresenter");
        Intrinsics.checkNotNullParameter(optionMenuAddPresenter, "optionMenuAddPresenter");
        Intrinsics.checkNotNullParameter(attachMenuPresenter, "attachMenuPresenter");
        Logger.m10999d(TAG, "init");
        this.templateObjectManager = templateObjectManager;
        this.controllerManager = controllerManager;
        this.composerViewPresenter = composerViewPresenter;
        this.optionMenuAddPresenter = optionMenuAddPresenter;
        this.attachMenuPresenter = attachMenuPresenter;
        this.imageController.init(templateObjectManager, controllerManager, composerViewPresenter);
        this.textController.init(templateObjectManager, controllerManager, composerViewPresenter);
        registerListeners();
    }

    public final boolean onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (!this.imageController.onActivityResult(requestCode, resultCode, data)) {
            return false;
        }
        Logger.m10999d(TAG, "onActivityResult, handled by dynamicTemplateImageController");
        return true;
    }

    public final void onAttachView(@NotNull Activity activity, @NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.activity = activity;
        this.fragment = fragment;
        this.imageController.onAttachView(activity, fragment);
        this.textController.onAttachView(activity, fragment);
    }

    public final boolean onRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        Activity activity = this.activity;
        if (activity != null) {
            return this.imageController.onRequestPermissionsResult(activity, requestCode, permissions, grantResults);
        }
        return false;
    }

    public final void release() {
        Logger.m10999d(TAG, "release");
        unregisterListeners();
    }

    public final void showDrawingToolkitsPopOver(@Nullable SpenObjectBase objectBase) {
        DynamicTemplateImageController.showDrawingToolkitsPopOver$default(this.imageController, DynamicTemplateUtil.INSTANCE.getObjectId(objectBase), null, 2, null);
    }

    public final void showImagePicker(@Nullable SpenObjectBase objectBase) {
        this.imageController.showImagePicker(DynamicTemplateUtil.INSTANCE.getObjectId(objectBase));
    }
}
