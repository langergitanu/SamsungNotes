package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.cover;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.fragment.app.Fragment;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.ApplicationManager;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.cover.AiCoverContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.cover.AiCoverDataCreator;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.title.TitleEditorPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerRequestCode;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.NoteStyleActivity;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.common.Constant;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.util.CoverStyleUtils;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.keyguard.KeyguardPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.cover.model.CoverData;
import com.samsung.android.support.senl.p148nt.composer.main.cover.presenter.CoverEditorUtils;
import com.samsung.android.support.senl.p148nt.model.assist.llm.p166sa.AssistSAConstants;
import com.samsung.android.support.senl.p148nt.model.documents.data.CoverDataSource;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiCoverMenuViewPresenter implements AiCoverDataCreator.ProcessCallback {
    private static final String TAG = Logger.createTag("AiCoverMenuViewPresenter");
    private ComposerModel mComposerModel;
    private ComposerViewPresenter mComposerViewPresenter;
    private CoverDataSource mCoverDataSource;
    private CoverEditorListener mCoverEditorListener;
    private Fragment mFragment;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    protected KeyguardPresenter mKeyguardPresenter;
    String mOriginalTitle;
    private TitleEditorPresenter mTitleEditorPresenter;
    private AiCoverContract.IView mView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface CoverEditorListener {
        void onCompleteCover();

        void onCreateCover();

        void onHideCover();

        void onUpdateCover();

        void updateNoteCoverConfirm(int i);
    }

    private Intent createCoverIntent(String str) {
        Intent intent = new Intent(this.mFragment.getContext(), (Class<?>) NoteStyleActivity.class);
        intent.putExtra("key_type", Constant.Type.COVER_EDIT.ordinal());
        intent.putExtra(Constant.KEY_GRAVITY, 81);
        intent.putExtra("sdoc_uuid", getUuid());
        intent.putExtra(CoverData.KEY_COVER_DATA, createCoverData());
        if (str != null) {
            intent.putExtra(CoverData.KEY_EXTRACT_TEXT, str);
        }
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createDefaultCover() {
        saveDataToDocState(this.mComposerViewPresenter.getTextManager().getTitle(), "", CoverEditorUtils.getDefaultCategory(), CoverEditorUtils.getRandomTemplate(), CoverEditorUtils.getRandomColor());
        CoverEditorListener coverEditorListener = this.mCoverEditorListener;
        if (coverEditorListener != null) {
            coverEditorListener.onCompleteCover();
        }
    }

    private void hide() {
        AiCoverContract.IView iView = this.mView;
        if (iView != null) {
            iView.hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isConnectedView() {
        return this.mView != null;
    }

    private void showCoverEditor() {
        this.mComposerModel.setRunningCoverEditor(true);
        InputMethodCompat.getInstance().forceHideSoftInput(this.mFragment.getContext());
        CoverStyleUtils.INSTANCE.extractTextWithReceiver(this.mFragment.getContext(), this.mComposerModel.getDoc(), this.mComposerModel.getDocInfo().getDocPath(), this.mComposerModel.getDocInfo().getUuid(), false);
        showCoverEditorActivity();
    }

    private void startCoverActivity(Intent intent) {
        this.mFragment.getActivity().startActivityForResult(intent, ComposerRequestCode.ChangeNoteStyle.getId());
    }

    public void clearRecommendedCover() {
        if (isRecommended()) {
            this.mCoverDataSource.setState(1);
        }
    }

    public CoverData createCoverData() {
        CoverData coverData = new CoverData(this.mComposerModel.getDocInfo().getUuid());
        coverData.setDocPath(this.mComposerModel.getDocInfo().getDocPath());
        coverData.setState(this.mCoverDataSource.getState());
        coverData.setEnabled(this.mCoverDataSource.isEnabled());
        coverData.setCategoryUuid(this.mCoverDataSource.getCategoryUuid());
        coverData.setTemplateUuid(this.mCoverDataSource.getTemplateUuid());
        coverData.setTitle(this.mTitleEditorPresenter.getEditorViewTitle());
        coverData.setSummary(this.mCoverDataSource.getSummary());
        coverData.setColorId(this.mCoverDataSource.getBackgroundColor());
        coverData.setCreatedAt(this.mCoverDataSource.getCreatedAt());
        coverData.setLastModifiedAt(this.mCoverDataSource.getLastModifiedAt());
        coverData.setBackgroundColor(this.mComposerViewPresenter.getBackgroundColor());
        coverData.setBackgroundColorInverted(this.mComposerViewPresenter.isBackgroundColorInverted() ? 1 : 0);
        return coverData;
    }

    public Activity getActivity() {
        return this.mFragment.getActivity();
    }

    public String getBackgroundColor() {
        return this.mCoverDataSource.getBackgroundColor();
    }

    public String getCategoryUuid() {
        return this.mCoverDataSource.getCategoryUuid();
    }

    public String getUuid() {
        return this.mComposerModel.getDocInfo().getUuid();
    }

    public boolean hasCover() {
        if (this.mComposerModel.getMdeInfo().isMde()) {
            Logger.m10999d(TAG, "hasCover# isMdeMode");
            return false;
        }
        int state = this.mCoverDataSource.getState();
        AbstractC0000a.m3D(state, "hasCover# cover state : ", TAG);
        return state == 1 || state == 2 || state == 3 || state == 4;
    }

    public void hideCoverView() {
        CoverEditorListener coverEditorListener = this.mCoverEditorListener;
        if (coverEditorListener != null) {
            coverEditorListener.onHideCover();
        }
    }

    public void init(ComposerViewPresenter composerViewPresenter, TitleEditorPresenter titleEditorPresenter, @NonNull KeyguardPresenter keyguardPresenter) {
        this.mComposerViewPresenter = composerViewPresenter;
        this.mTitleEditorPresenter = titleEditorPresenter;
        this.mKeyguardPresenter = keyguardPresenter;
        ComposerModel composerModel = composerViewPresenter.getComposerModel();
        this.mComposerModel = composerModel;
        this.mCoverDataSource = composerModel.getDocState().getCoverDataSource();
    }

    public boolean isApplied() {
        int state = this.mCoverDataSource.getState();
        AbstractC0000a.m3D(state, "isApplied# state : ", TAG);
        return state == 1 || state == 2 || state == 4;
    }

    public boolean isCoverEnabled() {
        Logger.m10999d(TAG, "isCoverEnabled# enable : " + this.mCoverDataSource.isEnabled());
        return this.mCoverDataSource.isEnabled();
    }

    public boolean isCoverMenuEnabled(boolean z) {
        if (!this.mComposerModel.getComposerState().isSupportedAiCover()) {
            return false;
        }
        if (z) {
            return FeatureInfo.isAiFeatureEnabled();
        }
        return true;
    }

    public boolean isRecommended() {
        Logger.m10999d(TAG, "isRecommended# cover state : " + this.mCoverDataSource.getState());
        return this.mCoverDataSource.getState() == 3;
    }

    public void makeCoverDirectlyWithActivity(String str) {
        Logger.m10999d(TAG, "makeCoverDirectlyWithActivity#");
        this.mCoverDataSource.setEnable(true);
        Intent intentCreateCoverIntent = createCoverIntent(str);
        intentCreateCoverIntent.putExtra(CoverData.KEY_GENERATE_COVER, true);
        startCoverActivity(intentCreateCoverIntent);
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        String str = TAG;
        AbstractC8014b.m7216r(i, i2, "onActivityResult# requestCode : ", ", resultCode : ", str);
        if (i != ComposerRequestCode.ChangeNoteStyle.getId()) {
            return false;
        }
        this.mComposerModel.setRunningCoverEditor(false);
        if (intent == null) {
            Logger.m11000e(str, "onActivityResult# intent is null");
            return true;
        }
        CoverData coverData = (CoverData) intent.getParcelableExtra(CoverData.KEY_COVER_DATA);
        if (coverData == null) {
            Logger.m11000e(str, "onActivityResult# coverData is null");
            return true;
        }
        saveDataToDocState(coverData, intent.getBooleanExtra(CoverData.KEY_IS_CHANGED, false));
        if (i2 == -1) {
            hide();
            if (isCoverEnabled()) {
                this.mComposerViewPresenter.getTextManager().setTitle(coverData.getTitle());
                updateCoverView();
            } else {
                show();
                hideCoverView();
            }
        } else if (i2 == 0) {
            show();
            hideCoverView();
        }
        return true;
    }

    public void onAttachView(Fragment fragment) {
        this.mFragment = fragment;
    }

    public void onClickButton() {
        Logger.m10999d(TAG, "onClickButton#");
        showCoverEditor();
        ComposerSA.insertLog(AssistSAConstants.SCREEN_COMPOSER_EXTENDED_TITLE, AssistSAConstants.EVENT_EDIT_COVER, "a");
    }

    public void onClickCoverView() {
        Logger.m10999d(TAG, "onClickCoverView#");
        showCoverEditor();
        ComposerSA.insertLog(AssistSAConstants.SCREEN_COMPOSER_EXTENDED_TITLE, AssistSAConstants.EVENT_EDIT_COVER, "a");
    }

    public void onClickOptionMenu() {
        Logger.m10999d(TAG, "onClickOptionMenu#");
        showCoverEditor();
        ComposerSA.insertLog(AssistSAConstants.SCREEN_COMPOSER_EXTENDED_TITLE, AssistSAConstants.EVENT_EDIT_COVER, "b");
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.cover.AiCoverDataCreator.Callback
    @WorkerThread
    public void onCompleted(final String str, final String str2, final String str3) {
        final String randomTemplate = CoverEditorUtils.getRandomTemplate();
        final String randomColor = CoverEditorUtils.getRandomColor();
        CoverEditorUtils.savePreviewJpg(ApplicationManager.getInstance().getAppContext(), str2, str3, randomTemplate, randomColor, getUuid(), 0);
        this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.cover.AiCoverMenuViewPresenter.1
            @Override // java.lang.Runnable
            public void run() {
                Logger.m10999d(AiCoverMenuViewPresenter.TAG, "onCompleted#");
                if (AiCoverMenuViewPresenter.this.isConnectedView()) {
                    String editorViewTitle = str;
                    if (TextUtils.isEmpty(AiCoverMenuViewPresenter.this.mTitleEditorPresenter.getEditorViewTitle())) {
                        AiCoverMenuViewPresenter aiCoverMenuViewPresenter = AiCoverMenuViewPresenter.this;
                        aiCoverMenuViewPresenter.mOriginalTitle = aiCoverMenuViewPresenter.mComposerViewPresenter.getTextManager().getTitle();
                        AiCoverMenuViewPresenter.this.mComposerViewPresenter.getTextManager().setTitle(editorViewTitle);
                    } else {
                        editorViewTitle = AiCoverMenuViewPresenter.this.mTitleEditorPresenter.getEditorViewTitle();
                    }
                    AiCoverMenuViewPresenter.this.saveDataToDocState(editorViewTitle, str2, str3, randomTemplate, randomColor);
                    if (AiCoverMenuViewPresenter.this.mCoverEditorListener != null) {
                        AiCoverMenuViewPresenter.this.mCoverEditorListener.onCompleteCover();
                    }
                }
            }
        });
    }

    public void onDetachView() {
        this.mFragment = null;
        this.mView = null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.cover.AiCoverDataCreator.Callback
    @WorkerThread
    public void onFailed(final String str) {
        if ("RESTRICTED_USER_ERROR".equals(str)) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.cover.AiCoverMenuViewPresenter.2
            @Override // java.lang.Runnable
            public void run() {
                if (AiCoverMenuViewPresenter.this.isConnectedView()) {
                    if ("SAFE_FILTER_ERROR_UNSUPPORTED_LANGUAGE".equals(str)) {
                        AiCoverMenuViewPresenter.this.createDefaultCover();
                        return;
                    }
                    if (AiCoverMenuViewPresenter.this.getActivity() != null && !TextUtils.isEmpty(str)) {
                        ToastHandler.show(AiCoverMenuViewPresenter.this.getActivity(), str, 1);
                    }
                    AiCoverMenuViewPresenter.this.mView.onFailed(str);
                    AiCoverMenuViewPresenter.this.hideCoverView();
                }
            }
        });
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.cover.AiCoverDataCreator.ProcessCallback
    public void onStart() {
        Logger.m10999d(TAG, "onStart#");
        this.mView.hide();
        CoverEditorListener coverEditorListener = this.mCoverEditorListener;
        if (coverEditorListener != null) {
            coverEditorListener.onCreateCover();
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void saveDataToDocState(CoverData coverData, boolean z) {
        AbstractC8014b.m7220v("saveDataToDocState# isChanged : ", TAG, z);
        ComposerModel composerModel = this.mComposerModel;
        String title = coverData.getTitle();
        String summary = coverData.getSummary();
        String templateUuid = coverData.getTemplateUuid();
        String categoryUuid = coverData.getCategoryUuid();
        String colorId = coverData.getColorId();
        boolean zIsEnabled = coverData.isEnabled();
        composerModel.setCoverData(title, summary, templateUuid, categoryUuid, colorId, zIsEnabled ? 1 : 0, coverData.getState(), 0, 0, z);
    }

    public void setCoverEditorListener(CoverEditorListener coverEditorListener) {
        this.mCoverEditorListener = coverEditorListener;
    }

    public void setViewOnTitle(AiCoverContract.IView iView) {
        this.mView = iView;
    }

    public void show() {
        AiCoverContract.IView iView = this.mView;
        if (iView != null) {
            iView.show();
        }
    }

    public void showCoverEditorActivity() {
        Logger.m10999d(TAG, "showCoverEditorActivity#");
        startCoverActivity(createCoverIntent(null));
    }

    public void updateCoverView() {
        CoverEditorListener coverEditorListener = this.mCoverEditorListener;
        if (coverEditorListener != null) {
            coverEditorListener.onUpdateCover();
        }
    }

    public void updateNoteCoverConfirm(int i) {
        CoverEditorListener coverEditorListener = this.mCoverEditorListener;
        if (coverEditorListener != null) {
            coverEditorListener.updateNoteCoverConfirm(i);
        }
    }

    public void saveDataToDocState(String str, String str2, String str3, String str4, String str5) {
        Logger.m10999d(TAG, "saveDataToDocState");
        this.mComposerModel.setCoverData(str, str2, str4, str3, str5, 1, 1, 0, 0, true);
    }
}
