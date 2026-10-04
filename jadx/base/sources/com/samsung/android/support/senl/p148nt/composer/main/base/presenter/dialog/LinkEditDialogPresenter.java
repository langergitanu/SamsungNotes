package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.fragment.app.DialogFragment;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenHyperTextSpan;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 -2\u00020\u0001:\u0001-B#\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001c\u001a\u00020\u0017H\u0014J&\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u0019J\u0006\u0010\u001d\u001a\u00020\u001eJ\n\u0010#\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u0017H\u0016J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u0017H\u0016J\u0010\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020)H\u0002J\u000e\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/dialog/LinkEditDialogPresenter;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/dialog/RenameDialogCommonPresenter;", "creator", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/dialog/DialogContract$IDialogCreator;", "mCompViewPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;", "controllerManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/ControllerManager;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/dialog/DialogContract$IDialogCreator;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/ControllerManager;)V", "mObjectManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/ObjectManager;", "mModeManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/mode/ModeManager;", "mTextManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/TextManager;", "mSoftInputManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/SoftInputManager;", "mSpenObjectTextBox", "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "mSpenHyperTextSpan", "Lcom/samsung/android/sdk/pen/document/textspan/SpenHyperTextSpan;", "mDisplayText", "", "mIsTextToShow", "", "mIsConvertToTextLink", "mIsNeedToShowKeyboard", "getTag", "showEditDialog", "", "displayText", "span", "isTextToShow", "isConvertToTextLink", "getDefaultName", "isExistName", "newName", "setNewName", "dismiss", "view", "Landroid/view/View;", "hideSoftInput", "setBlockContextMenu", "block", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class LinkEditDialogPresenter extends RenameDialogCommonPresenter {

    @NotNull
    private static final String TAG;

    @NotNull
    private final ComposerViewPresenter mCompViewPresenter;

    @Nullable
    private String mDisplayText;
    private boolean mIsConvertToTextLink;
    private boolean mIsNeedToShowKeyboard;
    private boolean mIsTextToShow;

    @NotNull
    private final ModeManager mModeManager;

    @NotNull
    private final ObjectManager mObjectManager;

    @NotNull
    private final SoftInputManager mSoftInputManager;

    @Nullable
    private SpenHyperTextSpan mSpenHyperTextSpan;

    @Nullable
    private SpenObjectTextBox mSpenObjectTextBox;

    @NotNull
    private final TextManager mTextManager;

    static {
        String strCreateTag = Logger.createTag("LinkEditDialogPresenter");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkEditDialogPresenter(@Nullable DialogContract.IDialogCreator iDialogCreator, @NotNull ComposerViewPresenter mCompViewPresenter, @NotNull ControllerManager controllerManager) {
        super(iDialogCreator);
        Intrinsics.checkNotNullParameter(mCompViewPresenter, "mCompViewPresenter");
        Intrinsics.checkNotNullParameter(controllerManager, "controllerManager");
        this.mCompViewPresenter = mCompViewPresenter;
        ObjectManager objectManager = mCompViewPresenter.getObjectManager();
        Intrinsics.checkNotNullExpressionValue(objectManager, "getObjectManager(...)");
        this.mObjectManager = objectManager;
        ModeManager modeManager = mCompViewPresenter.getComposerModel().getModeManager();
        Intrinsics.checkNotNullExpressionValue(modeManager, "getModeManager(...)");
        this.mModeManager = modeManager;
        TextManager textManager = mCompViewPresenter.getTextManager();
        Intrinsics.checkNotNullExpressionValue(textManager, "getTextManager(...)");
        this.mTextManager = textManager;
        SoftInputManager softInputManager = controllerManager.getSoftInputManager();
        Intrinsics.checkNotNullExpressionValue(softInputManager, "getSoftInputManager(...)");
        this.mSoftInputManager = softInputManager;
    }

    private final void hideSoftInput(View view) {
        if (this.mModeManager.isMode(Mode.Text)) {
            return;
        }
        this.mSoftInputManager.hide(view);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.RenameDialogCommonPresenter
    public void dismiss(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.mModeManager.isMode(Mode.Text)) {
            this.mObjectManager.selectObject(this.mTextManager.getTextBox());
            AbstractC8014b.m7220v("LinkEdit#dismiss# mIsNeedToShowKeyboard: ", getTag(), this.mIsNeedToShowKeyboard);
            if (this.mIsNeedToShowKeyboard) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.LinkEditDialogPresenter.dismiss.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LinkEditDialogPresenter.this.mSoftInputManager.forceToShow(null, 1000L);
                    }
                }, 100L);
            }
        } else {
            this.mObjectManager.clearSelectObject(false);
            hideSoftInput(view);
        }
        this.mIsNeedToShowKeyboard = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0029, code lost:
    
        if (android.text.TextUtils.isEmpty(r0.getCustomData()) != false) goto L13;
     */
    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.RenameDialogCommonPresenter
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getDefaultName() {
        if (!this.mIsTextToShow) {
            if (!this.mIsConvertToTextLink) {
                SpenHyperTextSpan spenHyperTextSpan = this.mSpenHyperTextSpan;
                Intrinsics.checkNotNull(spenHyperTextSpan);
                int start = spenHyperTextSpan.getStart();
                SpenHyperTextSpan spenHyperTextSpan2 = this.mSpenHyperTextSpan;
                Intrinsics.checkNotNull(spenHyperTextSpan2);
                if (start != spenHyperTextSpan2.getEnd()) {
                    SpenHyperTextSpan spenHyperTextSpan3 = this.mSpenHyperTextSpan;
                    Intrinsics.checkNotNull(spenHyperTextSpan3);
                }
            }
            SpenHyperTextSpan spenHyperTextSpan4 = this.mSpenHyperTextSpan;
            Intrinsics.checkNotNull(spenHyperTextSpan4);
            return spenHyperTextSpan4.getCustomData();
        }
        return this.mDisplayText;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.RenameDialogCommonPresenter
    @NotNull
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.RenameDialogCommonPresenter
    public boolean isExistName(@NotNull String newName) {
        Intrinsics.checkNotNullParameter(newName, "newName");
        return false;
    }

    public final void setBlockContextMenu(boolean block) {
        this.mCompViewPresenter.getListenerManager().getContextMenuListener().blockContextMenu(getTag(), block);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.RenameDialogCommonPresenter
    public void setNewName(@NotNull String newName) {
        Intrinsics.checkNotNullParameter(newName, "newName");
        Logger.m10999d(getTag(), "LinkEdit#setNewName# isTextToShow(" + this.mIsTextToShow + ") : " + newName);
        if (!this.mIsTextToShow) {
            SpenHyperTextSpan spenHyperTextSpan = this.mSpenHyperTextSpan;
            Intrinsics.checkNotNull(spenHyperTextSpan);
            int end = spenHyperTextSpan.getEnd();
            SpenHyperTextSpan spenHyperTextSpan2 = this.mSpenHyperTextSpan;
            Intrinsics.checkNotNull(spenHyperTextSpan2);
            if (end == spenHyperTextSpan2.getStart() && !TextUtils.isEmpty(this.mDisplayText)) {
                SpenHyperTextSpan spenHyperTextSpan3 = this.mSpenHyperTextSpan;
                Intrinsics.checkNotNull(spenHyperTextSpan3);
                int start = spenHyperTextSpan3.getStart();
                String str = this.mDisplayText;
                Intrinsics.checkNotNull(str);
                end = start + str.length();
            }
            SpenHyperTextSpan spenHyperTextSpan4 = this.mSpenHyperTextSpan;
            Intrinsics.checkNotNull(spenHyperTextSpan4);
            SpenHyperTextSpan spenHyperTextSpan5 = new SpenHyperTextSpan(spenHyperTextSpan4.getStart(), end, 2);
            spenHyperTextSpan5.setHyperTextType(3);
            spenHyperTextSpan5.setCustomData(newName);
            String tag = getTag();
            SpenHyperTextSpan spenHyperTextSpan6 = this.mSpenHyperTextSpan;
            Intrinsics.checkNotNull(spenHyperTextSpan6);
            String customData = spenHyperTextSpan6.getCustomData();
            SpenHyperTextSpan spenHyperTextSpan7 = this.mSpenHyperTextSpan;
            Intrinsics.checkNotNull(spenHyperTextSpan7);
            int start2 = spenHyperTextSpan7.getStart();
            SpenHyperTextSpan spenHyperTextSpan8 = this.mSpenHyperTextSpan;
            Intrinsics.checkNotNull(spenHyperTextSpan8);
            AbstractC8014b.m7221w(AbstractC0541b.m780v("LinkEdit#setNewName# invoke removeTextSpan : ", start2, customData, SQLKeyword.COMMA, SQLKeyword.COMMA), tag, spenHyperTextSpan8.getEnd());
            SpenObjectTextBox spenObjectTextBox = this.mSpenObjectTextBox;
            if (spenObjectTextBox != null) {
                spenObjectTextBox.removeTextSpan(this.mSpenHyperTextSpan);
            }
            AbstractC8014b.m7213o(AbstractC0622a.m1173s(spenHyperTextSpan5.getStart(), spenHyperTextSpan5.getEnd(), "LinkEdit#setNewName# invoke appendTextSpan : ", SQLKeyword.COMMA, SQLKeyword.COMMA), spenHyperTextSpan5.getCustomData(), getTag());
            SpenObjectTextBox spenObjectTextBox2 = this.mSpenObjectTextBox;
            if (spenObjectTextBox2 != null) {
                spenObjectTextBox2.appendTextSpan(spenHyperTextSpan5);
                return;
            }
            return;
        }
        SpenHyperTextSpan spenHyperTextSpan9 = this.mSpenHyperTextSpan;
        Intrinsics.checkNotNull(spenHyperTextSpan9);
        int start3 = spenHyperTextSpan9.getStart();
        SpenHyperTextSpan spenHyperTextSpan10 = this.mSpenHyperTextSpan;
        Intrinsics.checkNotNull(spenHyperTextSpan10);
        int end2 = spenHyperTextSpan10.getEnd();
        SpenHyperTextSpan spenHyperTextSpan11 = this.mSpenHyperTextSpan;
        Intrinsics.checkNotNull(spenHyperTextSpan11);
        int start4 = end2 - spenHyperTextSpan11.getStart();
        String tag2 = getTag();
        SpenHyperTextSpan spenHyperTextSpan12 = this.mSpenHyperTextSpan;
        Intrinsics.checkNotNull(spenHyperTextSpan12);
        String customData2 = spenHyperTextSpan12.getCustomData();
        SpenHyperTextSpan spenHyperTextSpan13 = this.mSpenHyperTextSpan;
        Intrinsics.checkNotNull(spenHyperTextSpan13);
        int start5 = spenHyperTextSpan13.getStart();
        SpenHyperTextSpan spenHyperTextSpan14 = this.mSpenHyperTextSpan;
        Intrinsics.checkNotNull(spenHyperTextSpan14);
        AbstractC8014b.m7221w(AbstractC0541b.m780v("LinkEdit#setNewName# invoke removeTextSpan : ", start5, customData2, SQLKeyword.COMMA, SQLKeyword.COMMA), tag2, spenHyperTextSpan14.getEnd());
        SpenObjectTextBox spenObjectTextBox3 = this.mSpenObjectTextBox;
        if (spenObjectTextBox3 != null) {
            spenObjectTextBox3.removeTextSpan(this.mSpenHyperTextSpan);
        }
        AbstractC8014b.m7221w(AbstractC0541b.m780v("LinkEdit#setNewName# invoke replaceText : ", start3, newName, SQLKeyword.COMMA, SQLKeyword.COMMA), getTag(), start4);
        SpenObjectTextBox spenObjectTextBox4 = this.mSpenObjectTextBox;
        if (spenObjectTextBox4 != null) {
            spenObjectTextBox4.replaceText(newName, start3, start4);
        }
        SpenHyperTextSpan spenHyperTextSpan15 = this.mSpenHyperTextSpan;
        Intrinsics.checkNotNull(spenHyperTextSpan15);
        int start6 = spenHyperTextSpan15.getStart();
        SpenHyperTextSpan spenHyperTextSpan16 = this.mSpenHyperTextSpan;
        Intrinsics.checkNotNull(spenHyperTextSpan16);
        SpenHyperTextSpan spenHyperTextSpan17 = new SpenHyperTextSpan(start6, newName.length() + spenHyperTextSpan16.getStart(), 2);
        spenHyperTextSpan17.setHyperTextType(3);
        SpenHyperTextSpan spenHyperTextSpan18 = this.mSpenHyperTextSpan;
        Intrinsics.checkNotNull(spenHyperTextSpan18);
        if (TextUtils.isEmpty(spenHyperTextSpan18.getCustomData())) {
            String str2 = this.mDisplayText;
            if (str2 == null) {
                str2 = "";
            }
            spenHyperTextSpan17.setCustomData(str2);
        } else {
            SpenHyperTextSpan spenHyperTextSpan19 = this.mSpenHyperTextSpan;
            Intrinsics.checkNotNull(spenHyperTextSpan19);
            spenHyperTextSpan17.setCustomData(spenHyperTextSpan19.getCustomData());
        }
        AbstractC8014b.m7213o(AbstractC0622a.m1173s(spenHyperTextSpan17.getStart(), spenHyperTextSpan17.getEnd(), "LinkEdit#setNewName# appendTextSpan : ", SQLKeyword.COMMA, SQLKeyword.COMMA), spenHyperTextSpan17.getCustomData(), getTag());
        SpenObjectTextBox spenObjectTextBox5 = this.mSpenObjectTextBox;
        if (spenObjectTextBox5 != null) {
            spenObjectTextBox5.appendTextSpan(spenHyperTextSpan17);
        }
    }

    public final void showEditDialog(@NotNull String displayText, @NotNull SpenHyperTextSpan span, boolean isTextToShow, boolean isConvertToTextLink) {
        Intrinsics.checkNotNullParameter(displayText, "displayText");
        Intrinsics.checkNotNullParameter(span, "span");
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing() || this.mActivity.isDestroyed()) {
            Logger.m10999d(getTag(), "LinkEdit#showEditDialog# mActivity is null or finishing or destroyed");
            return;
        }
        String tag = getTag();
        int start = span.getStart();
        int end = span.getEnd();
        String customData = span.getCustomData();
        StringBuilder sb = new StringBuilder("LinkEdit#showEditDialog# isTextToShow: ");
        sb.append(isTextToShow);
        sb.append(", displayText: ");
        sb.append(displayText);
        sb.append(", span.start: ");
        AbstractC2821a.m2235z(sb, start, end, ", span.end ", ", span.customData: ");
        AbstractC8014b.m7213o(sb, customData, tag);
        this.mDisplayText = displayText;
        this.mSpenHyperTextSpan = span;
        this.mIsTextToShow = isTextToShow;
        this.mIsConvertToTextLink = isConvertToTextLink;
        Context applicationContext = this.mActivity.getApplicationContext();
        InputMethodCompat.Companion companion = InputMethodCompat.INSTANCE;
        boolean zIsInputMethodShown = companion.getInstance().isInputMethodShown(applicationContext, this.mActivity.getWindow().getCurrentFocus(), companion.getInstance().isEnabledMobileKeyboard(applicationContext));
        AbstractC8014b.m7220v("LinkEdit#showEditDialog# isKeyboardShown: ", getTag(), zIsInputMethodShown);
        if (!zIsInputMethodShown) {
            this.mIsNeedToShowKeyboard = false;
            showEditDialog();
            return;
        }
        this.mIsNeedToShowKeyboard = true;
        InputMethodCompat companion2 = companion.getInstance();
        Activity activity2 = this.mActivity;
        companion2.hideSoftInput(activity2, activity2.getWindow().getDecorView());
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.LinkEditDialogPresenter.showEditDialog.1
            @Override // java.lang.Runnable
            public void run() {
                LinkEditDialogPresenter.this.showEditDialog();
            }
        }, 100L);
    }

    public final void showEditDialog() {
        DialogFragment dialogFragmentCreateLinkEditDialogFragment = this.mCreator.createLinkEditDialogFragment(this.mIsTextToShow);
        Activity activity = this.mActivity;
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        ((AppCompatActivity) activity).getSupportFragmentManager().beginTransaction().add(dialogFragmentCreateLinkEditDialogFragment, getTag()).commitAllowingStateLoss();
        Activity activity2 = this.mActivity;
        Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        ((AppCompatActivity) activity2).getSupportFragmentManager().executePendingTransactions();
        List<SpenObjectBase> selectedObjectList = this.mObjectManager.getSelectedObjectList();
        if (selectedObjectList != null) {
            for (SpenObjectBase spenObjectBase : selectedObjectList) {
                if (spenObjectBase != null && spenObjectBase.getType() == 2) {
                    this.mSpenObjectTextBox = (SpenObjectTextBox) spenObjectBase;
                }
            }
        }
    }
}
