package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.controller;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import androidx.collection.AbstractC0622a;
import androidx.fragment.app.Fragment;
import androidx.glance.AbstractC2821a;
import androidx.picker.app.SeslDatePickerDialog;
import androidx.picker.widget.SeslDatePicker;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.changedInfo.SpenObjectChangedInfo;
import com.samsung.android.sdk.pen.document.changedInfo.SpenObjectChangedTextInfo;
import com.samsung.android.sdk.pen.document.textspan.SpenBulletParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenTextParagraphBase;
import com.samsung.android.support.senl.p148nt.base.winset.app.picker.image.ImagePicker;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.common.DynamicTemplateObjectUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.common.DynamicTemplateUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.object.DynamicTemplateObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p079T.C0287e;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 22\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0012\u0010\u0018\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J1\u0010\u001b\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010!\u001a\u00020\"¢\u0006\u0002\u0010#J \u0010$\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001d2\b\u0010&\u001a\u0004\u0018\u00010'J\u000e\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020*J \u0010+\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\u001dH\u0002J\u001c\u0010.\u001a\u00020\u00112\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001a002\u0006\u00101\u001a\u00020\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000¨\u00063"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/controller/DynamicTemplateTextController;", "", "<init>", "()V", "imagePicker", "Lcom/samsung/android/support/senl/nt/base/winset/app/picker/image/ImagePicker;", "templateObjectManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/object/DynamicTemplateObjectManager;", "composerViewPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;", "controllerManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/ControllerManager;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "fragment", "Landroidx/fragment/app/Fragment;", "init", "", "onAttachView", "onItemClicked", "", "objectBase", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "onItemLongClicked", "showDatePicker", "targetObject", "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "", "grantResults", "", "(Landroid/app/Activity;I[Ljava/lang/String;[I)Z", "onActivityResult", "resultCode", "data", "Landroid/content/Intent;", "onObjectChanged", "changedInfo", "Lcom/samsung/android/sdk/pen/document/changedInfo/SpenObjectChangedInfo;", "isToDoBulletParagraphExist", "start", "end", "onObjectSelected", "objectBases", "", "selected", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DynamicTemplateTextController {
    private static final String TAG = Logger.createDynamicTemplateLog("TextController");
    private Activity activity;
    private ComposerViewPresenter composerViewPresenter;
    private ControllerManager controllerManager;
    private Fragment fragment;

    @NotNull
    private final ImagePicker imagePicker;
    private DynamicTemplateObjectManager templateObjectManager;

    public DynamicTemplateTextController() {
        ImagePicker imagePicker = new ImagePicker();
        this.imagePicker = imagePicker;
        imagePicker.setGalleryPickMaxItemCount(0);
    }

    private final boolean isToDoBulletParagraphExist(SpenObjectTextBox objectBase, int start, int end) {
        List<SpenTextParagraphBase> listFindTextParagraph = objectBase.findTextParagraph(start, end);
        if (listFindTextParagraph == null) {
            listFindTextParagraph = CollectionsKt.emptyList();
        }
        for (SpenTextParagraphBase spenTextParagraphBase : listFindTextParagraph) {
            if ((spenTextParagraphBase instanceof SpenBulletParagraph) && ((SpenBulletParagraph) spenTextParagraphBase).getBulletType() == 2) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v9, types: [T, com.samsung.android.sdk.pen.document.SpenObjectTextBox] */
    private final void showDatePicker(SpenObjectTextBox targetObject) {
        Activity activity;
        Logger.m10999d(TAG, "showDatePicker");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = targetObject;
        if (!DynamicTemplateUtil.hasDateTextBoxTimeInMillis(targetObject)) {
            DynamicTemplateObjectManager dynamicTemplateObjectManager = this.templateObjectManager;
            if (dynamicTemplateObjectManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("templateObjectManager");
                dynamicTemplateObjectManager = null;
            }
            objectRef.element = dynamicTemplateObjectManager.findObjectTextBoxById(null, DynamicTemplateUtil.INSTANCE.getGroupedObjectId((SpenObjectBase) objectRef.element));
        }
        Calendar calendar = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance(...)");
        calendar.setTimeInMillis(DynamicTemplateUtil.getDateTextBoxTimeInMillis((SpenObjectBase) objectRef.element));
        int i = calendar.get(1);
        int i2 = calendar.get(2);
        int i4 = calendar.get(5);
        Activity activity2 = this.activity;
        if (activity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Constants.StringExtra.EXECUTE_TYPE_ACTIVITY);
            activity = null;
        } else {
            activity = activity2;
        }
        SeslDatePickerDialog seslDatePickerDialog = new SeslDatePickerDialog(activity, new C0287e(objectRef, this, 16), i, i2, i4);
        seslDatePickerDialog.getDatePicker().init(i, i2, i4, null);
        seslDatePickerDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void showDatePicker$lambda$0(Ref.ObjectRef objectRef, DynamicTemplateTextController dynamicTemplateTextController, SeslDatePicker seslDatePicker, int i, int i2, int i4) {
        Calendar calendar = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance(...)");
        calendar.set(i, i2, i4);
        Logger.m10999d(TAG, "showDatePicker, onDateSet: " + calendar);
        DynamicTemplateUtil.setDateTextBoxTimeInMillis((SpenObjectBase) objectRef.element, calendar.getTimeInMillis());
        DynamicTemplateObjectManager dynamicTemplateObjectManager = dynamicTemplateTextController.templateObjectManager;
        DynamicTemplateObjectManager dynamicTemplateObjectManager2 = null;
        if (dynamicTemplateObjectManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("templateObjectManager");
            dynamicTemplateObjectManager = null;
        }
        dynamicTemplateObjectManager.updateDateTextBox((SpenObjectTextBox) objectRef.element);
        DynamicTemplateObjectManager dynamicTemplateObjectManager3 = dynamicTemplateTextController.templateObjectManager;
        if (dynamicTemplateObjectManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("templateObjectManager");
        } else {
            dynamicTemplateObjectManager2 = dynamicTemplateObjectManager3;
        }
        dynamicTemplateObjectManager2.updateDayOfWeekTextBox(DynamicTemplateUtil.INSTANCE.getGroupedObjectId((SpenObjectBase) objectRef.element));
    }

    public final void init(@NotNull DynamicTemplateObjectManager templateObjectManager, @NotNull ControllerManager controllerManager, @NotNull ComposerViewPresenter composerViewPresenter) {
        Intrinsics.checkNotNullParameter(templateObjectManager, "templateObjectManager");
        Intrinsics.checkNotNullParameter(controllerManager, "controllerManager");
        Intrinsics.checkNotNullParameter(composerViewPresenter, "composerViewPresenter");
        this.templateObjectManager = templateObjectManager;
        this.controllerManager = controllerManager;
        this.composerViewPresenter = composerViewPresenter;
    }

    public final boolean onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        return false;
    }

    public final void onAttachView(@NotNull Activity activity, @NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.activity = activity;
        this.fragment = fragment;
    }

    public final boolean onItemClicked(@Nullable SpenObjectBase objectBase) {
        if (objectBase instanceof SpenObjectTextBox) {
            SpenObjectTextBox spenObjectTextBox = (SpenObjectTextBox) objectBase;
            if (!spenObjectTextBox.getTextEditable() && DynamicTemplateUtil.isShowDatePickerActionObject(objectBase)) {
                showDatePicker(spenObjectTextBox);
                return true;
            }
        }
        return false;
    }

    public final boolean onItemLongClicked(@Nullable SpenObjectBase objectBase) {
        return false;
    }

    public final void onObjectChanged(@NotNull SpenObjectChangedInfo changedInfo) {
        Intrinsics.checkNotNullParameter(changedInfo, "changedInfo");
        SpenObjectBase spenObjectBase = changedInfo.objectBase;
        if (TextUtils.isEmpty(DynamicTemplateUtil.INSTANCE.getObjectId(spenObjectBase)) || !(spenObjectBase instanceof SpenObjectTextBox)) {
            return;
        }
        if (DynamicTemplateUtil.isShowDatePickerActionObject(spenObjectBase) && DynamicTemplateUtil.hasDateTextBoxTimeInMillis(spenObjectBase)) {
            DynamicTemplateUtil.setDateTextBoxTimeInMillis(spenObjectBase, DynamicTemplateUtil.convertStringToTimeInMillis(((SpenObjectTextBox) spenObjectBase).getText(), DynamicTemplateUtil.getDateTextBoxFormat(spenObjectBase)));
            return;
        }
        if (DynamicTemplateObjectUtil.isTaskTextBox(spenObjectBase)) {
            SpenObjectChangedTextInfo spenObjectChangedTextInfo = (SpenObjectChangedTextInfo) changedInfo;
            if (spenObjectChangedTextInfo.textChangedType != 1) {
                return;
            }
            SpenObjectTextBox spenObjectTextBox = (SpenObjectTextBox) spenObjectBase;
            int cursorPosition = spenObjectTextBox.getCursorPosition();
            ComposerViewPresenter composerViewPresenter = this.composerViewPresenter;
            ComposerViewPresenter composerViewPresenter2 = null;
            if (composerViewPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("composerViewPresenter");
                composerViewPresenter = null;
            }
            int[] paragraphIndex = composerViewPresenter.getObjectManager().getTextManager().getParagraphIndex((SpenObjectShape) spenObjectBase, new int[]{cursorPosition, cursorPosition});
            if (isToDoBulletParagraphExist(spenObjectTextBox, paragraphIndex[0], paragraphIndex[1])) {
                return;
            }
            int i = spenObjectChangedTextInfo.before;
            int i2 = spenObjectChangedTextInfo.count;
            boolean z = i < i2;
            String str = TAG;
            StringBuilder sbM1173s = AbstractC0622a.m1173s(paragraphIndex[0], paragraphIndex[1], "onObjectChanged, startParagraphIndex: ", ", endParagraphIndex: ", ", cursorPosition: ");
            AbstractC2821a.m2235z(sbM1173s, cursorPosition, i, ", before: ", ", count: ");
            sbM1173s.append(i2);
            sbM1173s.append(", enable: ");
            sbM1173s.append(z);
            Logger.m10999d(str, sbM1173s.toString());
            ComposerViewPresenter composerViewPresenter3 = this.composerViewPresenter;
            if (composerViewPresenter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("composerViewPresenter");
            } else {
                composerViewPresenter2 = composerViewPresenter3;
            }
            composerViewPresenter2.getObjectManager().getTextManager().setTask(2, z);
        }
    }

    public final void onObjectSelected(@NotNull List<SpenObjectTextBox> objectBases, boolean selected) {
        Intrinsics.checkNotNullParameter(objectBases, "objectBases");
        if (DynamicTemplateObjectUtil.isTaskTextBoxContained(objectBases)) {
            ComposerViewPresenter composerViewPresenter = this.composerViewPresenter;
            if (composerViewPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("composerViewPresenter");
                composerViewPresenter = null;
            }
            composerViewPresenter.getTextManager().enableTaskNIndentSpan(!selected);
        }
    }

    public final boolean onRequestPermissionsResult(@NotNull Activity activity, int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        return false;
    }
}
