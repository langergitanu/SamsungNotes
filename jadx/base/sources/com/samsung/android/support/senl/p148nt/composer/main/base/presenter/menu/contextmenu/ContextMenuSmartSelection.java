package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.app.Activity;
import android.app.RemoteAction;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.util.Pair;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.textspan.SpenHyperTextSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenTextSpanBase;
import com.samsung.android.support.senl.p148nt.base.composer.contextmenu.TextClassification;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.link.CustomLinkSpec;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.link.LinkActionHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.link.LinkAction;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuSmartSelection extends ContextMenuItem {
    public static final int MAX_TEXT_LENGTH = 1500;
    private static final String TAG = Logger.createTag("ContextMenuSmartSelection");
    private final ObjectManager mObjectManager;
    private ISmartSelection mSmartSelection;
    private final TextManager mTextManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ISmartSelection {
        void setMenu(Menu menu, String str);

        void startActivity(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(api = 30)
    public class SmartSelectionTextClassification extends TextClassification implements ISmartSelection {
        public SmartSelectionTextClassification() {
            super(ContextMenuSmartSelection.this.mActivity);
        }

        @Override // com.samsung.android.support.senl.p148nt.base.composer.contextmenu.TextClassification
        @NonNull
        public MenuItem addItem(@NonNull Menu menu, @NonNull RemoteAction remoteAction, int i) {
            if (i != 0) {
                MenuItem contentDescription = menu.add(0, 100, i + 100, remoteAction.getTitle()).setContentDescription(remoteAction.getContentDescription());
                contentDescription.setShowAsAction(0);
                return contentDescription;
            }
            MenuItem menuItemAdd = menu.add(0, 16908353, ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_FIRST.getId(), remoteAction.getTitle());
            if (remoteAction.shouldShowIcon()) {
                menuItemAdd.setIcon(remoteAction.getIcon().loadDrawable(ContextMenuSmartSelection.this.mActivity));
            }
            return menuItemAdd;
        }

        @Override // com.samsung.android.support.senl.p148nt.base.composer.contextmenu.TextClassification
        @NonNull
        public String getTag() {
            return ContextMenuSmartSelection.TAG;
        }

        @Override // com.samsung.android.support.senl.p148nt.base.composer.contextmenu.TextClassification
        public void runAfterStartActivity() {
            ContextMenuSmartSelection.this.mObjectManager.clearSelectObject();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.ContextMenuSmartSelection.ISmartSelection
        public void setMenu(Menu menu, String str) {
            addMenu(menu, str);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.ContextMenuSmartSelection.ISmartSelection
        public void startActivity(String str) {
            startActivity(ContextMenuSmartSelection.this.mExecuteMenuItem);
        }
    }

    public ContextMenuSmartSelection(ComposerViewPresenter composerViewPresenter) {
        this.mObjectManager = composerViewPresenter.getObjectManager();
        this.mTextManager = composerViewPresenter.getTextManager();
    }

    private String getSelectedText() {
        String selectedText = this.mTextManager.getSelectedText();
        SpenObjectShape textBox = this.mTextManager.getTextBox();
        int[] cursor = this.mTextManager.getCursor(textBox);
        ArrayList<SpenTextSpanBase> arrayListFindTextSpan = textBox.findTextSpan(cursor[0], cursor[1], 512);
        if (arrayListFindTextSpan == null || arrayListFindTextSpan.isEmpty()) {
            return selectedText;
        }
        for (SpenTextSpanBase spenTextSpanBase : arrayListFindTextSpan) {
            if (spenTextSpanBase.getType() == 9 && spenTextSpanBase.getStart() == cursor[0] && spenTextSpanBase.getEnd() == cursor[1] && (spenTextSpanBase instanceof SpenHyperTextSpan)) {
                SpenHyperTextSpan spenHyperTextSpan = (SpenHyperTextSpan) spenTextSpanBase;
                return !TextUtils.isEmpty(spenHyperTextSpan.getCustomData()) ? spenHyperTextSpan.getCustomData() : selectedText;
            }
        }
        return selectedText;
    }

    private ISmartSelection getSmartSelection() {
        ISmartSelection iSmartSelection = this.mSmartSelection;
        if (iSmartSelection != null) {
            return iSmartSelection;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            this.mSmartSelection = new SmartSelectionTextClassification();
        } else {
            this.mSmartSelection = new SmartSelectionLinkAction();
        }
        return this.mSmartSelection;
    }

    private boolean isAvailableToParse() {
        int length;
        if (!this.mObjectManager.isFocusedTextBox()) {
            return false;
        }
        SpenObjectShape textBox = this.mTextManager.getTextBox();
        int[] cursor = this.mTextManager.getCursor(textBox);
        if (cursor[0] != cursor[1] && (length = textBox.getText().length()) >= cursor[0] && length >= cursor[1]) {
            String selectedText = this.mTextManager.getSelectedText();
            if (!TextUtils.isEmpty(selectedText) && selectedText.length() <= 1500) {
                return true;
            }
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void addMenu(Menu menu) {
        if (isAvailableToParse()) {
            getSmartSelection().setMenu(menu, getSelectedText());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean canShow() {
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void executeMenu() {
        String selectedText = this.mTextManager.getSelectedText();
        if (TextUtils.isEmpty(selectedText)) {
            Logger.m11000e(TAG, "executeMenu# selected text is invalid");
        } else {
            getSmartSelection().startActivity(selectedText);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class SmartSelectionLinkAction implements ISmartSelection {
        public SmartSelectionLinkAction() {
        }

        public static void setMenu(Activity activity, Menu menu, String str, CustomLinkSpec customLinkSpec) {
            LinkActionHelper.setLastHypertextType(customLinkSpec);
            Pair<CharSequence, Drawable> titleIconByType = new ContextMenuSmartSelectionLabel().getTitleIconByType(activity, str.substring(customLinkSpec.getStart(), customLinkSpec.getEnd()), customLinkSpec.getType());
            if (titleIconByType != null) {
                menu.add(0, 16908353, ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_FIRST.getId(), titleIconByType.first).setIcon(titleIconByType.second);
                Logger.m11003i(ContextMenuSmartSelection.TAG, "setMenu# done");
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.ContextMenuSmartSelection.ISmartSelection
        public void startActivity(String str) {
            CustomLinkSpec lastHypertextType = LinkActionHelper.getLastHypertextType();
            if (str.length() < lastHypertextType.getEnd()) {
                Logger.m11000e(ContextMenuSmartSelection.TAG, "startActivity# span is invalid");
                return;
            }
            Logger.m11003i(ContextMenuSmartSelection.TAG, "startActivity# " + lastHypertextType.getType());
            new LinkAction().startActivityHyperTextByType(ContextMenuSmartSelection.this.mActivity, str.substring(lastHypertextType.getStart(), lastHypertextType.getEnd()), lastHypertextType.getType());
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.ContextMenuSmartSelection.ISmartSelection
        public void setMenu(Menu menu, String str) {
            LinkActionHelper.setLastHypertextType(null);
            CustomLinkSpec firstLinkOnParsing = LinkActionHelper.getFirstLinkOnParsing(ContextMenuSmartSelection.this.mActivity, str);
            if (firstLinkOnParsing.getEnd() < firstLinkOnParsing.getStart() || firstLinkOnParsing.getStart() < 0 || firstLinkOnParsing.getEnd() > str.length()) {
                Logger.m11000e(ContextMenuSmartSelection.TAG, "setMenu# IndexOutOfBounds (length:" + str.length() + ", start:" + firstLinkOnParsing.getStart() + ", end:" + firstLinkOnParsing.getEnd() + ")");
                return;
            }
            if (firstLinkOnParsing.getType() == 0) {
                return;
            }
            setMenu(ContextMenuSmartSelection.this.mActivity, menu, str, firstLinkOnParsing);
        }
    }
}
