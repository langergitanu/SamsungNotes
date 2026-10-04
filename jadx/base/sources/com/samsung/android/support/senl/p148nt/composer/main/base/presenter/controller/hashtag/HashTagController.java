package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.hashtag;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectLink;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.document.SpenObjectWeb;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.base.common.access.hashtag.HashTagAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.external.tageditor.TagEditorActivity;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.hashtag.HashTagDataHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.hashtag.HashTagContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.hashtag.HashTagParam;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.hashtag.constants.HashTagConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.hashtag.util.HashTagUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerRequestCode;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectResolver;
import com.samsung.android.support.senl.p148nt.model.collector.util.RecognitionUtil;
import com.samsung.android.support.senl.p148nt.model.documents.data.TagData;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;
import com.samsung.android.support.senl.p148nt.model.repository.data.tag.DocumentTagFactory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HashTagController {
    private static final String TAG = Logger.createTag("HashTagController");
    private static final int TAG_BUFFER_LIMIT_SIZE = 10000;
    private Activity mActivity;
    private HashTagActionListener mHashTagActionListener;
    private final HashTagListManager mHashTagListManager = new HashTagListManager();
    private HashTagContract.Presenter mHashTagPresenter;
    private ComposerModel mModel;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface HashTagActionListener {
        void onHashTagAdded();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class HashTagListManager {
        private static final boolean IS_TEST_MODE = false;
        private List<TagData> mHashTagList;
        private ComposerModel mModel;

        public HashTagListManager() {
        }

        public List<TagData> getTagList() {
            return this.mModel.getDocState() == null ? new ArrayList() : this.mModel.getDocState().getTagDataSource().cloneChangedSortedList();
        }

        public void init(ComposerModel composerModel) {
            this.mModel = composerModel;
        }

        public void saveHashTagList(List<TagData> list, boolean z) {
            Logger.m10999d(HashTagController.TAG, "saveHashTags#");
            NotesDocument<SpenWordDocument> docState = this.mModel.getDocState();
            if (docState != null) {
                docState.getTagDataSource().setChangedSortedList(list);
            }
            if (z) {
                HashTagController.this.mHashTagPresenter.getView().updateTagListView();
            }
        }
    }

    private void convertRecommendationByObjects(SpenWNote spenWNote, StringBuffer stringBuffer, StringBuffer stringBuffer2, String str) {
        Iterator<SpenWPage> it = spenWNote.getPageList().iterator();
        while (it.hasNext()) {
            for (SpenObjectBase spenObjectBase : it.next().getObjectList()) {
                int type = spenObjectBase.getType();
                if (type == 2) {
                    String text = ((SpenObjectTextBox) spenObjectBase).getText();
                    if (!TextUtils.isEmpty(text)) {
                        stringBuffer.append(text);
                        stringBuffer.append(str);
                    }
                } else if (type == 10) {
                    String title = ((SpenObjectVoice) spenObjectBase).getTitle();
                    if (!TextUtils.isEmpty(title)) {
                        stringBuffer2.append(title);
                        stringBuffer2.append(str);
                    }
                } else if (type == 13) {
                    String title2 = ((SpenObjectWeb) spenObjectBase).getTitle();
                    if (!TextUtils.isEmpty(title2)) {
                        stringBuffer.append(title2);
                        stringBuffer.append(str);
                    }
                } else if (type == 17) {
                    String title3 = ((SpenObjectLink) spenObjectBase).getTitle();
                    if (!TextUtils.isEmpty(title3)) {
                        stringBuffer.append(title3);
                        stringBuffer.append(str);
                    }
                }
            }
        }
    }

    @NotNull
    private StringBuffer getHandwritingForRecommendation(String str) {
        List<String> recognizeTextsWithExcludedTypes;
        StringBuffer stringBuffer = new StringBuffer();
        if (RecognitionUtil.isSupported(this.mActivity.getApplicationContext()) && !this.mModel.getDocState().isContentChanged() && (recognizeTextsWithExcludedTypes = CollectResolver.getRecognizeTextsWithExcludedTypes(this.mModel.getDocInfo().getUuid(), 3)) != null && !recognizeTextsWithExcludedTypes.isEmpty()) {
            Iterator<String> it = recognizeTextsWithExcludedTypes.iterator();
            while (it.hasNext()) {
                stringBuffer.append(it.next());
                stringBuffer.append(str);
            }
        }
        return stringBuffer;
    }

    @NonNull
    private Bundle getTagEditorBundle(String str, HashTagParam hashTagParam) {
        Bundle bundle = new Bundle();
        bundle.putString(HashTagConstants.KEY_TAG_RECOGNITION_TITLE_STRING, hashTagParam.getTitleForRecommendation());
        bundle.putString(HashTagConstants.KEY_TAG_RECOGNITION_CONTENT_STRING, hashTagParam.getTextContentsForRecommendation());
        bundle.putString(HashTagConstants.KEY_TAG_RECOGNITION_ATTACHMENT_STRING, hashTagParam.getAttachmentFileNameForRecommendation());
        if (TextUtils.isEmpty(str)) {
            bundle.putString(HashTagConstants.KEY_TAG_RECOGNITION_HW_STRING, hashTagParam.getHandwritingForRecommendation());
        } else {
            bundle.putString(HashTagConstants.KEY_TAG_RECOGNITION_HW_STRING, str);
        }
        bundle.putString(HashTagConstants.KEY_TAG_RECOGNITION_BULLET_LIST_STRING, hashTagParam.getBulletListTextForRecommendation());
        bundle.putString(HashTagConstants.KEY_TAG_RECOGNITION_TODO_LIST_STRING, hashTagParam.getTodoListTextForRecommendation());
        bundle.putString(HashTagConstants.KEY_TAG_RECOGNITION_NUMBER_LIST_STRING, hashTagParam.getNumberListTextForRecommendation());
        return bundle;
    }

    private HashTagParam.Builder setRecommendationString(HashTagParam.Builder builder) {
        String str = TAG;
        Logger.m10999d(str, "getTextForRecommendation() - start");
        SpenWNote doc = this.mModel.getDoc();
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        StringBuffer stringBuffer3 = new StringBuffer();
        String text = doc.getTitle().getText();
        if (!TextUtils.isEmpty(text)) {
            stringBuffer.append(text);
        }
        String text2 = doc.getBodyText().getText();
        if (!TextUtils.isEmpty(text2)) {
            stringBuffer2.append(text2);
            stringBuffer2.append("\n");
        }
        convertRecommendationByObjects(doc, stringBuffer2, stringBuffer3, "\n");
        StringBuffer handwritingForRecommendation = getHandwritingForRecommendation("\n");
        checkLimitLength(stringBuffer);
        checkLimitLength(stringBuffer2);
        checkLimitLength(stringBuffer3);
        checkLimitLength(handwritingForRecommendation);
        Logger.m10999d(str, "getTextForRecommendation() - end");
        return builder.setTitleForRecommendation(stringBuffer.toString()).setTextContentsForRecommendation(stringBuffer2.toString()).setAttachmentFileNameForRecommendation(stringBuffer3.toString()).setNumberListTextForRecommendation("").setBulletListTextForRecommendation("").setTodoListTextForRecommendation("").setHandwritingForRecommendation(handwritingForRecommendation.toString());
    }

    public void checkLimitLength(StringBuffer stringBuffer) {
        if (stringBuffer.length() > 10000) {
            stringBuffer.setLength(10000);
        }
    }

    public void executeHashNotesActivity(String str) {
        Logger.m10999d(TAG, "executeHashNotesActivity.");
        Intent intent = new Intent(this.mActivity, HashTagAccessHandler.getHashTagNotesActivityClass());
        HashSet hashSet = new HashSet();
        hashSet.add(str.toLowerCase());
        intent.putExtra(Constants.KEY_SELECTED_TAGS, hashSet);
        intent.addFlags(131072);
        this.mActivity.startActivity(intent);
    }

    public void executeHashTagEditor(String str) {
        HashTagParam hashTagParamBuild;
        Intent intent;
        ComposerModel composerModel = this.mModel;
        if (composerModel == null || composerModel.getDoc() == null) {
            Logger.m11000e(TAG, "executeHashTagEditor() - mModel or getDoc is null");
            return;
        }
        HashTagParam.Builder selectedTags = new HashTagParam.Builder().setMaxSelectableTagCount(30).setSelectedTags(HashTagDataHelper.convertToTagStringList(this.mHashTagListManager.getTagList()));
        if (HashTagUtils.isSupportedTagEditor(this.mActivity)) {
            Logger.m11003i(TAG, "executeHashTagEditor() - start a TagEditor by tagService");
            hashTagParamBuild = setRecommendationString(selectedTags).build();
            intent = new Intent();
            intent.setClassName("com.samsung.android.service.tagservice", "com.samsung.android.service.tagservice.ui.tageditor.TagEditorActivity");
            intent.putExtra(HashTagConstants.KEY_TAG_RECOGNITION_NOTE, getTagEditorBundle(str, hashTagParamBuild));
            intent.putExtra("app_name", this.mActivity.getString(CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C9086R.string.notes_jp : C9086R.string.notes));
        } else {
            Logger.m11003i(TAG, "executeHashTagEditor() - start a custom tag editor");
            hashTagParamBuild = selectedTags.build();
            intent = new Intent(this.mActivity, (Class<?>) TagEditorActivity.class);
        }
        intent.addFlags(67108864);
        intent.putStringArrayListExtra(ComposerConstants.INTENT_KEY_SELECTED_TAG, hashTagParamBuild.getSelectedTags());
        intent.putExtra(ComposerConstants.INTENT_KEY_MAX_SELECTABLE_TAGS, hashTagParamBuild.getMaxSelectableTagCount());
        Activity activity = this.mActivity;
        ComposerRequestCode composerRequestCode = ComposerRequestCode.HashTag;
        activity.startActivityForResult(intent, composerRequestCode.getId());
        this.mModel.getComposerState().setLastRequestCode(composerRequestCode.getId());
    }

    public List<String> getTagList() {
        return HashTagDataHelper.convertToTagStringList(this.mHashTagListManager.getTagList());
    }

    public void init(ComposerModel composerModel) {
        this.mModel = composerModel;
        this.mHashTagListManager.init(composerModel);
    }

    public void initPresenter(HashTagContract.Presenter presenter) {
        this.mHashTagPresenter = presenter;
    }

    public boolean insertHashTagList(Intent intent) {
        String str = TAG;
        Logger.m10999d(str, "insertHashTagList#" + intent);
        if (intent == null) {
            Logger.m11000e(str, "insertHashTagList#, the result data is null");
            return false;
        }
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(ComposerConstants.INTENT_KEY_RESULT_SELECT_TAGS);
        if (stringArrayListExtra == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList(stringArrayListExtra.size());
        Iterator<String> it = stringArrayListExtra.iterator();
        while (it.hasNext()) {
            arrayList.add(DocumentTagFactory.create(it.next()));
        }
        if (this.mModel.getComposerState().isInAppCollaborationMode()) {
            ComposerSA.insertLog(ComposerSAConstants.SCREEN_IN_APP_SERVER, ComposerSAConstants.EVENT_IN_APP_EDIT_TAG, stringArrayListExtra.size());
        } else if (this.mModel.getModeManager().isEditMode()) {
            if (this.mHashTagPresenter.getTagList().isEmpty()) {
                ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_ADD_TAG, stringArrayListExtra.size());
            } else {
                ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_EDIT_TAG, stringArrayListExtra.size());
            }
        } else if (this.mHashTagPresenter.getTagList().isEmpty()) {
            ComposerSA.insertLog("301", ComposerSAConstants.EVENT_VIEW_ADD_TAG, stringArrayListExtra.size());
        } else {
            ComposerSA.insertLog("301", ComposerSAConstants.EVENT_VIEW_EDIT_TAG, stringArrayListExtra.size());
        }
        this.mHashTagListManager.saveHashTagList(arrayList, true);
        this.mModel.getComposerState().setIsExceptionalSIPStateHiddenOnUos(true);
        this.mHashTagPresenter.setTagListToComposerView(stringArrayListExtra);
        return true;
    }

    public boolean isNeedToExecuteAsyncForRecognition() {
        return HashTagUtils.isSupportedTagEditor(this.mActivity) && this.mModel.getDocState().isContentChanged() && !this.mModel.getDocState().isContentEmpty();
    }

    public boolean onActivityResult(int i, Intent intent) {
        Activity activity;
        Logger.m10999d(TAG, "onActivityResult#");
        if (i != -1) {
            return false;
        }
        boolean zInsertHashTagList = insertHashTagList(intent);
        ComposerModel composerModel = this.mModel;
        if (composerModel != null && composerModel.getModeManager().isMode(Mode.View)) {
            this.mModel.saveAsync(false, true);
        }
        if (zInsertHashTagList && (activity = this.mActivity) != null) {
            activity.invalidateOptionsMenu();
        }
        return zInsertHashTagList;
    }

    public void onAttachView(Activity activity) {
        this.mActivity = activity;
    }

    public void onDetachView() {
        this.mActivity = null;
    }

    public void onHashTagAdded(String str) {
        onHashTagAdded(str, false);
    }

    public void onHashTagRemoved(String str) {
        String str2 = TAG;
        Logger.m10999d(str2, "onHashTagRemoved()#");
        if (TextUtils.isEmpty(str)) {
            Logger.m10999d(str2, "onHashTagRemoved()# Failed to remove a tag by filter");
            return;
        }
        List<TagData> tagList = this.mHashTagListManager.getTagList();
        int i = 0;
        while (true) {
            if (i >= tagList.size()) {
                i = -1;
                break;
            } else if (tagList.get(i).getName().equalsIgnoreCase(str)) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            Logger.m10999d(TAG, "onHashTagRemoved() : removed tag " + i);
            tagList.remove(i);
            this.mHashTagListManager.saveHashTagList(tagList, false);
            this.mHashTagPresenter.setTagListToComposerView(HashTagDataHelper.convertToTagStringList(tagList));
        }
    }

    public void onHashTagRenameed(String str, String str2) {
        List<TagData> tagList = this.mHashTagListManager.getTagList();
        String strConvertByFilter = HashTagUtils.convertByFilter(str2);
        if (TextUtils.isEmpty(strConvertByFilter)) {
            Logger.m10999d(TAG, "onHashTagAdded() : Failed to add a tag by filter");
            return;
        }
        int iContainsIgnoreCase = HashTagUtils.containsIgnoreCase(tagList, str);
        if (iContainsIgnoreCase >= 0) {
            TagData tagData = tagList.get(iContainsIgnoreCase);
            int iContainsIgnoreCase2 = HashTagUtils.containsIgnoreCase(tagList, strConvertByFilter);
            if (iContainsIgnoreCase2 >= 0 && iContainsIgnoreCase2 != iContainsIgnoreCase) {
                tagList.remove(iContainsIgnoreCase2);
            }
            tagData.setName(strConvertByFilter);
            this.mHashTagListManager.saveHashTagList(tagList, true);
            this.mHashTagPresenter.setTagListToComposerView(HashTagDataHelper.convertToTagStringList(tagList));
        }
    }

    public void saveHashTagList(List<TagData> list) {
        this.mHashTagListManager.saveHashTagList(list, true);
    }

    public void setActionListener(HashTagActionListener hashTagActionListener) {
        this.mHashTagActionListener = hashTagActionListener;
    }

    public void onHashTagAdded(String str, boolean z) {
        HashTagActionListener hashTagActionListener;
        String str2 = TAG;
        Logger.m10999d(str2, "onHashTagAdded#");
        List<TagData> tagList = this.mHashTagListManager.getTagList();
        String strConvertByFilter = HashTagUtils.convertByFilter(str);
        if (TextUtils.isEmpty(strConvertByFilter)) {
            Logger.m10999d(str2, "onHashTagAdded# Failed to add a tag by filter");
            return;
        }
        TagData tagDataCreate = DocumentTagFactory.create(strConvertByFilter);
        if (tagList.size() >= 30) {
            Logger.m10999d(str2, "onHashTagAdded() : Failed to add a tag by max.");
            Activity activity = this.mActivity;
            ToastHandler.show(activity, activity.getResources().getString(C9086R.string.tag_toast_input_error_max_number_tag, 30), 0);
            return;
        }
        int iContainsIgnoreCase = HashTagUtils.containsIgnoreCase(tagList, str);
        if (iContainsIgnoreCase >= 0) {
            tagList.get(iContainsIgnoreCase).setName(str);
        } else {
            tagList.add(tagDataCreate);
        }
        this.mHashTagListManager.saveHashTagList(tagList, true);
        this.mHashTagPresenter.setTagListToComposerView(HashTagDataHelper.convertToTagStringList(tagList));
        if (z && (hashTagActionListener = this.mHashTagActionListener) != null) {
            hashTagActionListener.onHashTagAdded();
        }
        ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_CREATE_TAG_BUTTON);
    }
}
