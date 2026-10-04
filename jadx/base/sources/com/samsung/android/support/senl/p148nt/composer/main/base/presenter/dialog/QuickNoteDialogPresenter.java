package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.quicknote.QuickNoteModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.common.factory.ConfigurationFactory;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.IContextAwarenessResult;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.MediaObjectSuggestionInfo;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.MessageSuggestionInfo;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.SuggestionInfo;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.WebPageSuggestionInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class QuickNoteDialogPresenter implements DialogContract.IPresenter {
    private static final String TAG = Logger.createTag("QuickNoteDialogPresenter");
    private ActionListener mActionListener;
    private Activity mActivity;
    private final ConfigurationFactory mComponentFactory;
    private final DialogContract.IDialogCreator mCreator;
    private DialogContract.IQuickNoteDialog mDialog;
    private boolean mIsBlocking;
    private final SoftInputManager mSoftInputManager;
    private QuickNoteModel.SuggestedData mSuggestedData;
    private List<ViewData> mViewDataList;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ActionListener {
        void onAddContent(SuggestionInfo suggestionInfo);

        void onAddLink(SuggestionInfo suggestionInfo);

        void onCancel();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class GallerySA extends SaAction {
        public /* synthetic */ GallerySA(int i) {
            this();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.QuickNoteDialogPresenter.SaAction
        public void insertClippingOptionLog(int i) {
            if (i == 1) {
                ComposerSA.insertLog("120", ComposerSAConstants.EVENT_QUICK_NOTE_CLIPPING_OPTIONS, "b");
            } else if (i == 2) {
                ComposerSA.insertLog("120", ComposerSAConstants.EVENT_QUICK_NOTE_CLIPPING_OPTIONS, "e");
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.QuickNoteDialogPresenter.SaAction
        public void insertContentLog() {
            ComposerSA.insertLog("120", ComposerSAConstants.EVENT_QUICK_NOTE_ATTACH, "5");
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.QuickNoteDialogPresenter.SaAction
        public void insertLinkLog() {
            ComposerSA.insertLog("120", ComposerSAConstants.EVENT_QUICK_NOTE_LINK_OF_GALLERY);
        }

        private GallerySA() {
            super(0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InternetSA extends SaAction {
        public /* synthetic */ InternetSA(int i) {
            this();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.QuickNoteDialogPresenter.SaAction
        public void insertClippingOptionLog(int i) {
            if (i == 1) {
                ComposerSA.insertLog("120", ComposerSAConstants.EVENT_QUICK_NOTE_CLIPPING_OPTIONS, "a");
            } else if (i == 2) {
                ComposerSA.insertLog("120", ComposerSAConstants.EVENT_QUICK_NOTE_CLIPPING_OPTIONS, "d");
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.QuickNoteDialogPresenter.SaAction
        public void insertContentLog() {
            ComposerSA.insertLog("120", ComposerSAConstants.EVENT_QUICK_NOTE_WEB_CLIP);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.QuickNoteDialogPresenter.SaAction
        public void insertLinkLog() {
            ComposerSA.insertLog("120", ComposerSAConstants.EVENT_QUICK_NOTE_LINK_OF_INTERNET);
        }

        private InternetSA() {
            super(0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MessageSA extends SaAction {
        public /* synthetic */ MessageSA(int i) {
            this();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.QuickNoteDialogPresenter.SaAction
        public void insertClippingOptionLog(int i) {
            if (i == 1) {
                ComposerSA.insertLog("120", ComposerSAConstants.EVENT_QUICK_NOTE_CLIPPING_OPTIONS, "c");
            } else if (i == 2) {
                ComposerSA.insertLog("120", ComposerSAConstants.EVENT_QUICK_NOTE_CLIPPING_OPTIONS, "f");
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.QuickNoteDialogPresenter.SaAction
        public void insertContentLog() {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.QuickNoteDialogPresenter.SaAction
        public void insertLinkLog() {
            ComposerSA.insertLog("120", ComposerSAConstants.EVENT_QUICK_NOTE_LINK_OF_CONVERSATION);
        }

        private MessageSA() {
            super(0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class SaAction {
        public /* synthetic */ SaAction(int i) {
            this();
        }

        public abstract void insertClippingOptionLog(int i);

        public abstract void insertContentLog();

        public abstract void insertLinkLog();

        private SaAction() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ViewData {

        @StringRes
        int mContentBtnStrId;
        boolean mContentEnabled;
        Drawable mIcon;
        boolean mLinkEnabled;
        SaAction mSaAction;
        SuggestionInfo mSuggestionInfo;
        String mTitle;

        public ViewData(SuggestionInfo suggestionInfo) {
            this.mSuggestionInfo = suggestionInfo;
            if (suggestionInfo != null) {
                this.mTitle = suggestionInfo.getTitle();
                this.mIcon = suggestionInfo.getAppIcon();
            }
            int i = 0;
            if (suggestionInfo instanceof MediaObjectSuggestionInfo) {
                setButtonData(false, true, C9086R.string.quick_note_btn_attach);
                this.mSaAction = new GallerySA(i);
                return;
            }
            if (suggestionInfo instanceof WebPageSuggestionInfo) {
                setButtonData(true, true, C9086R.string.quick_note_btn_whole_page);
                this.mSaAction = new InternetSA(i);
                return;
            }
            if (suggestionInfo instanceof MessageSuggestionInfo) {
                setButtonData(true, false, -1);
                this.mSaAction = new MessageSA(i);
                return;
            }
            this.mTitle = "ERROR";
            setButtonData(false, false, -1);
            this.mSaAction = new SaAction() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.QuickNoteDialogPresenter.ViewData.1
                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.QuickNoteDialogPresenter.SaAction
                public void insertClippingOptionLog(int i2) {
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.QuickNoteDialogPresenter.SaAction
                public void insertContentLog() {
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.QuickNoteDialogPresenter.SaAction
                public void insertLinkLog() {
                }
            };
            Logger.m11000e(QuickNoteDialogPresenter.TAG, "ViewData# unexpected " + suggestionInfo);
        }

        private void setButtonData(boolean z, boolean z2, int i) {
            this.mLinkEnabled = z;
            this.mContentEnabled = z2;
            this.mContentBtnStrId = i;
        }
    }

    public QuickNoteDialogPresenter(DialogContract.IDialogCreator iDialogCreator, ControllerManager controllerManager, ConfigurationFactory configurationFactory) {
        this.mCreator = iDialogCreator;
        this.mComponentFactory = configurationFactory;
        this.mSoftInputManager = controllerManager.getSoftInputManager();
    }

    private boolean checkSameData(QuickNoteModel.SuggestedData suggestedData) {
        if (!isShowing() || this.mViewDataList.size() != suggestedData.getSuggestionInfoList().size()) {
            return false;
        }
        int size = this.mViewDataList.size();
        for (int i = 0; i < size; i++) {
            if (!this.mViewDataList.get(i).mSuggestionInfo.getId().equals(suggestedData.getSuggestionInfoList().get(i).getId())) {
                return false;
            }
        }
        return true;
    }

    private int getSelectedItemIndex() {
        return this.mViewDataList.size() - 1;
    }

    private void initViewData(List<SuggestionInfo> list) {
        this.mViewDataList = new ArrayList(list.size());
        for (int size = list.size() - 1; size >= 0; size--) {
            this.mViewDataList.add(new ViewData(list.get(size)));
        }
    }

    private void setDataModel(QuickNoteModel.SuggestedData suggestedData) {
        this.mSuggestedData = suggestedData;
        if (suggestedData != null) {
            initViewData(suggestedData.getSuggestionInfoList());
        } else {
            this.mViewDataList.clear();
            this.mViewDataList = null;
        }
    }

    public void addContent(SuggestionInfo suggestionInfo) {
        ActionListener actionListener = this.mActionListener;
        if (actionListener != null) {
            actionListener.onAddContent(suggestionInfo);
        }
        this.mViewDataList.get(getSelectedItemIndex()).mSaAction.insertContentLog();
    }

    public void addLink(SuggestionInfo suggestionInfo) {
        ActionListener actionListener = this.mActionListener;
        if (actionListener != null) {
            actionListener.onAddLink(suggestionInfo);
        }
        this.mViewDataList.get(getSelectedItemIndex()).mSaAction.insertLinkLog();
    }

    public void blockToShow(boolean z) {
        this.mIsBlocking = z;
        if (z) {
            hide("blockToShow", null, false);
        }
    }

    public Activity getActivity() {
        return this.mActivity;
    }

    @StringRes
    public int getContentButtonStr() {
        return this.mViewDataList.get(getSelectedItemIndex()).mContentBtnStrId;
    }

    public IContextAwarenessResult getContextAwarenessResult() {
        return this.mSuggestedData.getResult();
    }

    public List<String> getExcludedIds() {
        return new ArrayList(this.mSuggestedData.getExcludedIds());
    }

    public Drawable getIcon() {
        return this.mViewDataList.get(getSelectedItemIndex()).mIcon;
    }

    public List<Drawable> getIconList() {
        ArrayList arrayList = new ArrayList(this.mViewDataList.size());
        for (int i = 0; i < this.mViewDataList.size(); i++) {
            arrayList.add(this.mViewDataList.get(i).mIcon);
        }
        return arrayList;
    }

    public String getSelectedItemId() {
        return this.mViewDataList.get(getSelectedItemIndex()).mSuggestionInfo.getId();
    }

    public String getTitle() {
        return this.mViewDataList.get(getSelectedItemIndex()).mTitle;
    }

    public boolean hasCollapsedIcons() {
        return this.mViewDataList.size() > 1;
    }

    public synchronized void hide(String str, @Nullable List<String> list, boolean z) {
        try {
            Logger.m10999d(TAG, "hide# " + str);
            if (this.mActivity != null && isShowing() && this.mViewDataList != null) {
                if (list != null && !list.isEmpty()) {
                    for (String str2 : list) {
                        if (!TextUtils.isEmpty(str2)) {
                            Iterator<ViewData> it = this.mViewDataList.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (str2.equals(it.next().mSuggestionInfo.getId())) {
                                        it.remove();
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                    if (this.mViewDataList.isEmpty()) {
                        this.mDialog.dismiss(true ^ z);
                    } else {
                        Logger.m11004w(TAG, "update# dialog is already shown");
                        this.mDialog.update();
                    }
                    return;
                }
                this.mDialog.dismiss(true);
            }
        } finally {
        }
    }

    public void hideSoftInput() {
        this.mSoftInputManager.hide((View) null);
    }

    public boolean isEnabledContentButton() {
        return this.mViewDataList.get(getSelectedItemIndex()).mContentEnabled;
    }

    public boolean isEnabledLinkButton() {
        return this.mViewDataList.get(getSelectedItemIndex()).mLinkEnabled;
    }

    public boolean isInputMethodShown() {
        return this.mSoftInputManager.isInputMethodShown();
    }

    public boolean isShowing() {
        DialogContract.IQuickNoteDialog iQuickNoteDialog = this.mDialog;
        return iQuickNoteDialog != null && iQuickNoteDialog.isShowing();
    }

    public void onAttachView(Activity activity) {
        this.mActivity = activity;
        blockToShow(false);
    }

    public void onCancel() {
        ActionListener actionListener = this.mActionListener;
        if (actionListener != null) {
            actionListener.onCancel();
        }
    }

    public void onDetachView() {
        DialogContract.IQuickNoteDialog iQuickNoteDialog = this.mDialog;
        if (iQuickNoteDialog != null && iQuickNoteDialog.isShowing()) {
            this.mDialog.dismiss(true);
        }
        this.mActivity = null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IPresenter
    public void onDismiss() {
        Logger.m10999d(TAG, "onDismiss# ");
        this.mDialog = null;
        setDataModel(null);
    }

    public void onItemSelected(int i) {
        this.mViewDataList.add(this.mViewDataList.remove(i));
        this.mDialog.update();
    }

    public void show(QuickNoteModel.SuggestedData suggestedData, ActionListener actionListener) {
        String str = TAG;
        Logger.m10999d(str, "show# ");
        if (CommonUtil.isNotAvailableActivity(this.mActivity)) {
            Logger.m10999d(str, "show# " + this.mActivity);
            return;
        }
        if (this.mIsBlocking || !this.mComponentFactory.getConfig().isQuickNoteEnabled()) {
            Logger.m10999d(str, "show# blocking");
            return;
        }
        boolean zCheckSameData = checkSameData(suggestedData);
        setDataModel(suggestedData);
        this.mViewDataList.get(getSelectedItemIndex()).mSaAction.insertClippingOptionLog(WindowManagerCompat.getInstance().getMultiWindowMode(this.mActivity));
        this.mActionListener = actionListener;
        if (isShowing()) {
            Logger.m11004w(str, "show# dialog is already shown - " + zCheckSameData);
            if (zCheckSameData) {
                return;
            }
            this.mDialog.update();
            return;
        }
        if (this.mSoftInputManager.isInputMethodShown()) {
            this.mSoftInputManager.hide((View) null);
        }
        DialogContract.IDialog iDialogCreateQuickNoteDialog = this.mCreator.createQuickNoteDialog(this);
        if (iDialogCreateQuickNoteDialog instanceof DialogContract.IQuickNoteDialog) {
            DialogContract.IQuickNoteDialog iQuickNoteDialog = (DialogContract.IQuickNoteDialog) iDialogCreateQuickNoteDialog;
            this.mDialog = iQuickNoteDialog;
            iQuickNoteDialog.show();
        }
    }
}
