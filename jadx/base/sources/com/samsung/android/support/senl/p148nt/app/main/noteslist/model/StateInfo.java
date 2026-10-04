package com.samsung.android.support.senl.p148nt.app.main.noteslist.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.GcsConstants;
import com.samsung.android.support.senl.p148nt.app.main.common.data.HighlightText;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class StateInfo implements Parcelable {
    public static final Parcelable.Creator<StateInfo> CREATOR = new Parcelable.Creator<StateInfo>() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.model.StateInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StateInfo createFromParcel(Parcel parcel) {
            return new StateInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StateInfo[] newArray(int i) {
            return new StateInfo[i];
        }
    };
    private static final String KEY_BACK_HISTORY = "key_back_history";
    private static final String TAG = "StateInfo";
    private int mCaller;
    private boolean mCanRestoreNote;
    private String mCategoryUuid;
    private float mDrawerMovedPercentage;
    protected FilterInfo mFilterInfo;
    private Stack<String> mFolderBackHistory;
    private String mFolderUuid;
    private String mForceUpdateUuid;
    private String mGroupId;
    private String mGroupName;
    private HighlightText mHighlightText;
    private boolean mInvitationAcceptedByNotification;
    private boolean mIsBackFolder;
    private Boolean mIsExpandedFolderBar;
    private Boolean mIsInAppSearch;
    private Boolean mIsPrevExpandedFolderBar;
    private Boolean mIsSearchInsideFolder;
    private boolean mIsShowSearchFilterWithAnimation;
    private boolean mIsShowSubFolderWithAnimation;
    private int mModeIndex;

    @NotesConstants.NoteSpan
    private int mNotesSpan;
    private int mPrevModeIndex;

    @NotesConstants.SOMRecognizedCardShape
    private int mPrevSOMRecognizedCardShape;

    @NotesConstants.SOMRecognitionState
    private int mSOMRecognitionState;

    @NotesConstants.SOMRecognizedCardShape
    private int mSOMRecognizedCardShape;
    private String mSavedCoverSearchText;
    private String mSavedSearchText;
    private int mScrollState;
    private int mSearchCallerMode;
    private Set<String> mSelectedTags;
    private String mSpaceId;

    @NotesConstants.FolderSpan
    private int mSubFoldersSpan;
    private boolean mTipCardSyncOffAvailable;

    public StateInfo() {
        this.mFolderUuid = null;
        this.mCategoryUuid = null;
        this.mGroupId = null;
        this.mSpaceId = null;
        this.mGroupName = null;
        this.mSavedSearchText = "";
        this.mSavedCoverSearchText = "";
        this.mHighlightText = new HighlightText();
        this.mForceUpdateUuid = null;
        this.mIsInAppSearch = Boolean.TRUE;
        this.mIsSearchInsideFolder = Boolean.FALSE;
        this.mSelectedTags = null;
        this.mCaller = 0;
        this.mModeIndex = 1;
        this.mPrevModeIndex = 1;
        this.mSearchCallerMode = 1;
        this.mSubFoldersSpan = 4;
        this.mNotesSpan = 1;
        this.mIsBackFolder = false;
        this.mIsExpandedFolderBar = null;
        this.mIsPrevExpandedFolderBar = null;
        this.mSOMRecognitionState = 0;
        this.mSOMRecognizedCardShape = 0;
        this.mPrevSOMRecognizedCardShape = 0;
        this.mInvitationAcceptedByNotification = false;
        this.mDrawerMovedPercentage = 0.0f;
        this.mIsShowSubFolderWithAnimation = false;
        this.mIsShowSearchFilterWithAnimation = false;
        this.mScrollState = 0;
        this.mTipCardSyncOffAvailable = true;
        this.mCanRestoreNote = true;
        this.mFolderBackHistory = new Stack<>();
        this.mFilterInfo = new FilterInfo();
    }

    private Stack<String> loadBackHistory(Bundle bundle) {
        return (bundle == null || (bundle.getSerializable(KEY_BACK_HISTORY) instanceof ArrayList)) ? new Stack<>() : (Stack) bundle.getSerializable(KEY_BACK_HISTORY);
    }

    private HighlightText loadHighlightText(Bundle bundle) {
        if (bundle == null) {
            return new HighlightText();
        }
        HighlightText highlightText = (HighlightText) bundle.getSerializable(NotesConstants.KEY_HIGHLIGHT_TEXT);
        return highlightText == null ? new HighlightText() : highlightText;
    }

    private Set<String> loadSelectedTags(Bundle bundle) {
        if (bundle == null) {
            return new HashSet();
        }
        Set<String> set = (Set) bundle.getSerializable(Constants.KEY_SELECTED_TAGS);
        return set == null ? new HashSet() : set;
    }

    public void clearFolderBackHistory() {
        this.mFolderBackHistory.clear();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCaller() {
        return this.mCaller;
    }

    public boolean getCanRestoreNote() {
        return this.mCanRestoreNote;
    }

    public String getCategoryUuid() {
        return this.mCategoryUuid;
    }

    public FilterInfo getFilterInfo() {
        return this.mFilterInfo;
    }

    public Stack<String> getFolderBackHistory() {
        return this.mFolderBackHistory;
    }

    public String getFolderUuid() {
        if (this.mFolderUuid == null) {
            this.mFolderUuid = NotesUtils.getLastSelectedFolder();
        }
        return this.mFolderUuid;
    }

    public String getGroupId() {
        return this.mGroupId;
    }

    public String getGroupName() {
        return this.mGroupName;
    }

    public HighlightText getHighlightText() {
        return this.mHighlightText;
    }

    public boolean getIsInAppSearch() {
        return this.mIsInAppSearch.booleanValue();
    }

    public int getModeIndex() {
        return this.mModeIndex;
    }

    public int getNotesSpan() {
        return this.mNotesSpan;
    }

    public int getPrevModeIndex() {
        return this.mPrevModeIndex;
    }

    @NotesConstants.SOMRecognizedCardShape
    public int getPrevSOMRecognizedCardShape() {
        return this.mPrevSOMRecognizedCardShape;
    }

    @NotesConstants.SOMRecognizedCardShape
    public int getSOMRecognizedCardShape() {
        return this.mSOMRecognizedCardShape;
    }

    @NonNull
    public String getSavedSearchText() {
        return TextUtils.isEmpty(this.mSavedSearchText) ? "" : this.mSavedSearchText;
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public int getSearchCallerMode() {
        return this.mSearchCallerMode;
    }

    @NonNull
    public String getSearchCoverData() {
        return TextUtils.isEmpty(this.mSavedCoverSearchText) ? CoverStickerConstants.Category.NONE.UUID : this.mSavedCoverSearchText;
    }

    public String getSearchFolderUuid() {
        if (this.mFolderUuid == null) {
            this.mFolderUuid = NotesUtils.getLastSelectedFolder();
        }
        return this.mIsSearchInsideFolder.booleanValue() ? this.mFolderUuid : "";
    }

    public Set<String> getSelectedTags() {
        if (this.mSelectedTags == null) {
            this.mSelectedTags = new HashSet();
        }
        return this.mSelectedTags;
    }

    public String getSpaceId() {
        return this.mSpaceId;
    }

    public int getSubFoldersSpan() {
        return this.mSubFoldersSpan;
    }

    public boolean getTipCardSyncOffAvailable() {
        return this.mTipCardSyncOffAvailable;
    }

    public void initFolderBackHistory() {
        String lastSelectedFolder = NotesUtils.getLastSelectedFolder();
        String str = FolderConstants.AllNotes.UUID;
        if (str.equals(lastSelectedFolder)) {
            return;
        }
        String str2 = FolderConstants.MyFolders.UUID;
        if (str2.equals(lastSelectedFolder) || NotesUtils.isOpenedTrashByOtherApps()) {
            return;
        }
        if (FeatureUtils.isPreDefinedFolderUuid(lastSelectedFolder)) {
            this.mFolderBackHistory.push(str);
        } else {
            this.mFolderBackHistory.push(str2);
        }
    }

    public boolean isBackFolder() {
        return this.mIsBackFolder;
    }

    public boolean isCoeditMode() {
        return FeatureUtils.isCoeditMode(this.mModeIndex);
    }

    public boolean isCoeditSpaceMode() {
        return FeatureUtils.isCoeditSpaceMode(this.mModeIndex);
    }

    public boolean isExpandedFolderBar() {
        if (this.mIsExpandedFolderBar == null) {
            Boolean boolValueOf = Boolean.valueOf(SharedPreferencesCompat.getInstance(NotesConstants.PREF_NOTES_FRAGMENT).getBoolean(NotesConstants.KEY_IS_EXPANDED_FOLDER_BAR, false));
            this.mIsExpandedFolderBar = boolValueOf;
            this.mIsPrevExpandedFolderBar = boolValueOf;
        }
        return this.mIsExpandedFolderBar.booleanValue();
    }

    public boolean isExpandedFolderBarStatusChanged() {
        Boolean bool = this.mIsPrevExpandedFolderBar;
        Boolean bool2 = this.mIsExpandedFolderBar;
        boolean z = bool != bool2;
        this.mIsPrevExpandedFolderBar = bool2;
        return z;
    }

    public boolean isForceUpdateThumbnail(String str) {
        String str2 = this.mForceUpdateUuid;
        if (str2 == null) {
            return false;
        }
        return str2.equals(str);
    }

    public boolean isGcsSpaceMode() {
        return FeatureUtils.isGcsSpaceMode(this.mModeIndex);
    }

    public boolean isHashTagMode() {
        return FeatureUtils.isHashTagMode(this.mModeIndex);
    }

    public boolean isInvitationAcceptedByNotification() {
        return this.mInvitationAcceptedByNotification;
    }

    public boolean isOldMode() {
        return FeatureUtils.isOldMode(this.mModeIndex);
    }

    public boolean isPickMode() {
        return FeatureUtils.isPickMode(this.mModeIndex);
    }

    public boolean isRecyclebinMode() {
        return FeatureUtils.isRecyclebinMode(this.mModeIndex);
    }

    public boolean isSOMRecognitionStateProgressing() {
        return this.mSOMRecognitionState == 1;
    }

    public boolean isSOMRecognizeTaskIdle() {
        return this.mSOMRecognitionState == 0;
    }

    public boolean isSOMRecognizedCardCollapsed() {
        return this.mSOMRecognizedCardShape == 0;
    }

    public boolean isSearchInsideFolder() {
        return this.mIsSearchInsideFolder.booleanValue();
    }

    public boolean isSearchMode() {
        return FeatureUtils.isSearchMode(this.mModeIndex);
    }

    public boolean isShowSearchFilterWithAnimation() {
        return this.mIsShowSearchFilterWithAnimation;
    }

    public boolean isShowSubFolderWithAnimation() {
        return this.mIsShowSubFolderWithAnimation;
    }

    public void onRestoreInstanceState(Bundle bundle) {
        this.mFolderBackHistory = loadBackHistory(bundle);
        this.mFolderUuid = bundle.getString(NotesConstants.KEY_FOLDER_UUID, NotesUtils.getLastSelectedFolder());
        this.mGroupName = bundle.getString("group_name");
        this.mGroupId = bundle.getString(Constants.KEY_GROUP_ID);
        this.mSpaceId = bundle.getString(Constants.KEY_SPACE_ID);
        this.mCategoryUuid = bundle.getString(NotesConstants.KEY_CATEGORY_UUID);
        this.mSavedSearchText = bundle.getString(NotesConstants.BUNDLE_KEY_SEARCH, "");
        this.mSavedCoverSearchText = bundle.getString(NotesConstants.BUNDLE_KEY_SEARCH_COVER, "");
        this.mHighlightText = loadHighlightText(bundle);
        this.mSelectedTags = loadSelectedTags(bundle);
        this.mCaller = bundle.getInt(NotesConstants.KEY_CALLER);
        this.mModeIndex = bundle.getInt("mode", 1);
        this.mPrevModeIndex = bundle.getInt(NotesConstants.KEY_PREV_MODE_INDEX, 1);
        this.mSOMRecognitionState = bundle.getInt(NotesConstants.KEY_SOM_RECOGNITION_STATE, 0);
        this.mSOMRecognizedCardShape = bundle.getInt(NotesConstants.KEY_SOM_RECOGNIZED_CARD_SHAPE, 0);
        this.mPrevSOMRecognizedCardShape = bundle.getInt(NotesConstants.KEY_PREV_SOM_RECOGNIZED_CARD_SHAPE, 0);
        this.mInvitationAcceptedByNotification = bundle.getBoolean(GcsConstants.SES_ACCEPTED_BY_NOTIFICATION);
        this.mTipCardSyncOffAvailable = bundle.getBoolean(NotesConstants.KEY_TIP_CARD_SYNC_OFF_AVAILABLE, true);
        this.mIsInAppSearch = Boolean.valueOf(bundle.getBoolean(NotesConstants.KEY_IS_IN_APP_SEARCH, true));
        this.mIsSearchInsideFolder = Boolean.valueOf(bundle.getBoolean(NotesConstants.KEY_IS_SEARCH_INSIDE_FOLDER, false));
        this.mFilterInfo.onRestoreInstanceState(bundle);
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.putSerializable(KEY_BACK_HISTORY, this.mFolderBackHistory);
        bundle.putString(NotesConstants.KEY_FOLDER_UUID, this.mFolderUuid);
        bundle.putString("group_name", this.mGroupName);
        bundle.putString(Constants.KEY_GROUP_ID, this.mGroupId);
        bundle.putString(Constants.KEY_SPACE_ID, this.mSpaceId);
        bundle.putString(NotesConstants.KEY_CATEGORY_UUID, this.mCategoryUuid);
        bundle.putSerializable(NotesConstants.KEY_HIGHLIGHT_TEXT, this.mHighlightText);
        bundle.putSerializable(Constants.KEY_SELECTED_TAGS, (Serializable) this.mSelectedTags);
        bundle.putInt(NotesConstants.KEY_CALLER, this.mCaller);
        bundle.putInt("mode", this.mModeIndex);
        bundle.putInt(NotesConstants.KEY_PREV_MODE_INDEX, this.mPrevModeIndex);
        bundle.putInt(NotesConstants.KEY_SOM_RECOGNITION_STATE, this.mSOMRecognitionState);
        bundle.putInt(NotesConstants.KEY_SOM_RECOGNIZED_CARD_SHAPE, this.mSOMRecognizedCardShape);
        bundle.putInt(NotesConstants.KEY_PREV_SOM_RECOGNIZED_CARD_SHAPE, this.mPrevSOMRecognizedCardShape);
        bundle.putBoolean(GcsConstants.SES_ACCEPTED_BY_NOTIFICATION, this.mInvitationAcceptedByNotification);
        bundle.putBoolean(NotesConstants.KEY_TIP_CARD_SYNC_OFF_AVAILABLE, this.mTipCardSyncOffAvailable);
        this.mFilterInfo.onSaveInstanceState(bundle);
    }

    public void onScrollStateChanged(int i) {
        this.mScrollState = i;
    }

    public void saveArguments(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.mFolderUuid = bundle.getString(NotesConstants.KEY_FOLDER_UUID, NotesUtils.getLastSelectedFolder());
        this.mGroupName = bundle.getString("group_name");
        this.mGroupId = bundle.getString(Constants.KEY_GROUP_ID);
        this.mSpaceId = bundle.getString(Constants.KEY_SPACE_ID);
        this.mCategoryUuid = bundle.getString(NotesConstants.KEY_CATEGORY_UUID);
        this.mSelectedTags = loadSelectedTags(bundle);
        this.mSavedSearchText = bundle.getString(NotesConstants.BUNDLE_KEY_SEARCH, "");
        this.mSavedCoverSearchText = bundle.getString(NotesConstants.BUNDLE_KEY_SEARCH_COVER, "");
        this.mCaller = bundle.getInt(NotesConstants.KEY_CALLER, 0);
        this.mModeIndex = bundle.getInt("mode", 1);
        this.mPrevModeIndex = bundle.getInt(NotesConstants.KEY_PREV_MODE_INDEX, 1);
        this.mSOMRecognitionState = bundle.getInt(NotesConstants.KEY_SOM_RECOGNITION_STATE, 0);
        this.mSOMRecognizedCardShape = bundle.getInt(NotesConstants.KEY_SOM_RECOGNIZED_CARD_SHAPE, 0);
        this.mPrevSOMRecognizedCardShape = bundle.getInt(NotesConstants.KEY_PREV_SOM_RECOGNIZED_CARD_SHAPE, 0);
        this.mInvitationAcceptedByNotification = bundle.getBoolean(GcsConstants.SES_ACCEPTED_BY_NOTIFICATION, false);
        this.mTipCardSyncOffAvailable = bundle.getBoolean(NotesConstants.KEY_TIP_CARD_SYNC_OFF_AVAILABLE, true);
        this.mIsInAppSearch = Boolean.valueOf(bundle.getBoolean(NotesConstants.KEY_IS_IN_APP_SEARCH, true));
        this.mIsSearchInsideFolder = Boolean.valueOf(bundle.getBoolean(NotesConstants.KEY_IS_SEARCH_INSIDE_FOLDER, false));
    }

    public void setBackFolder(boolean z) {
        this.mIsBackFolder = z;
    }

    public void setCaller(int i) {
        this.mCaller = i;
    }

    public void setCanRestoreNote(boolean z) {
        this.mCanRestoreNote = z;
    }

    public void setCategoryUuid(String str) {
        this.mCategoryUuid = str;
    }

    public void setDrawerMovedPercentage(float f) {
        this.mDrawerMovedPercentage = f;
    }

    public void setExpandedFolderBar(boolean z) {
        SharedPreferencesCompat.getInstance(NotesConstants.PREF_NOTES_FRAGMENT).putBoolean(NotesConstants.KEY_IS_EXPANDED_FOLDER_BAR, z);
        this.mIsPrevExpandedFolderBar = this.mIsExpandedFolderBar;
        this.mIsExpandedFolderBar = Boolean.valueOf(z);
    }

    public void setFolderUuid(String str) {
        this.mFolderUuid = str;
        setShowSubFolderWithAnimation(true);
    }

    public void setForceUpdateThumbnail(String str) {
        this.mForceUpdateUuid = str;
    }

    public void setGroupId(String str) {
        this.mGroupId = str;
    }

    public void setGroupName(String str) {
        this.mGroupName = str;
    }

    public void setHighlightText(HighlightText highlightText) {
        this.mHighlightText = highlightText;
    }

    public void setInvitationAcceptedByNotification(boolean z) {
        this.mInvitationAcceptedByNotification = z;
    }

    public void setIsInAppSearch(boolean z) {
        this.mIsInAppSearch = Boolean.valueOf(z);
    }

    public void setModeIndex(int i) {
        this.mModeIndex = i;
    }

    public void setNotesSpan(int i) {
        this.mNotesSpan = i;
    }

    public void setPrevModeIndex(int i) {
        this.mPrevModeIndex = i;
    }

    public void setSOMRecognitionStateIdle() {
        this.mSOMRecognitionState = 0;
    }

    public void setSOMRecognitionStateProgressing() {
        this.mSOMRecognitionState = 1;
    }

    public void setSOMRecognizedCardShape(@NotesConstants.SOMRecognizedCardShape int i) {
        this.mPrevSOMRecognizedCardShape = this.mSOMRecognizedCardShape;
        this.mSOMRecognizedCardShape = i;
    }

    public void setSavedSearchText(@NonNull String str) {
        MainLogger.m7254d(TAG, "setSavedSearchText# " + MainLogger.getEncode(str));
        this.mSavedSearchText = str;
    }

    public void setSearchCallerMode(int i) {
        this.mSearchCallerMode = i;
    }

    public void setSearchCoverData(@NonNull String str) {
        this.mSavedCoverSearchText = str;
    }

    public void setSearchInsideFolder(boolean z) {
        this.mIsSearchInsideFolder = Boolean.valueOf(z);
    }

    public void setSelectedTags(Set<String> set) {
        this.mSelectedTags = set;
    }

    public void setShowSearchFilterWithAnimation(boolean z) {
        AbstractC8014b.m7210l("setShowSearchFilterWithAnimation# ", TAG, z);
        this.mIsShowSearchFilterWithAnimation = z;
    }

    public void setShowSubFolderWithAnimation(boolean z) {
        AbstractC8014b.m7210l("setShowSubFolderWithAnimation# ", TAG, z);
        this.mIsShowSubFolderWithAnimation = z;
    }

    public void setSpaceId(String str) {
        this.mSpaceId = str;
    }

    public void setSubFoldersSpan(int i) {
        this.mSubFoldersSpan = i;
    }

    public void setTipCardSyncOffAvailable(boolean z) {
        this.mTipCardSyncOffAvailable = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
    }

    public StateInfo(Parcel parcel) {
        this.mFolderUuid = null;
        this.mCategoryUuid = null;
        this.mGroupId = null;
        this.mSpaceId = null;
        this.mGroupName = null;
        this.mSavedSearchText = "";
        this.mSavedCoverSearchText = "";
        this.mHighlightText = new HighlightText();
        this.mForceUpdateUuid = null;
        this.mIsInAppSearch = Boolean.TRUE;
        this.mIsSearchInsideFolder = Boolean.FALSE;
        this.mSelectedTags = null;
        this.mCaller = 0;
        this.mModeIndex = 1;
        this.mPrevModeIndex = 1;
        this.mSearchCallerMode = 1;
        this.mSubFoldersSpan = 4;
        this.mNotesSpan = 1;
        this.mIsBackFolder = false;
        this.mIsExpandedFolderBar = null;
        this.mIsPrevExpandedFolderBar = null;
        this.mSOMRecognitionState = 0;
        this.mSOMRecognizedCardShape = 0;
        this.mPrevSOMRecognizedCardShape = 0;
        this.mInvitationAcceptedByNotification = false;
        this.mDrawerMovedPercentage = 0.0f;
        this.mIsShowSubFolderWithAnimation = false;
        this.mIsShowSearchFilterWithAnimation = false;
        this.mScrollState = 0;
        this.mTipCardSyncOffAvailable = true;
        this.mCanRestoreNote = true;
    }
}
