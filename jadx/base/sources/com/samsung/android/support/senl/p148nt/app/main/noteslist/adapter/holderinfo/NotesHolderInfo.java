package com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holderinfo;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class NotesHolderInfo extends CommonHolderInfo {
    private int mBackgroundColor;
    private int mBackgroundColorInverted;
    private String mHoverThumbnailFilePath;
    private int mLockType;
    private int mPrevLockType;
    private boolean mHasBackgroundColor = false;
    private boolean mHasOnlyHandwritingSdoc = false;
    private boolean mIsSupportInvertedBGColor = false;
    private boolean mIsDarkMode = false;
    private boolean mIsSdoc = false;
    private boolean mHasTextOnly = false;
    private boolean mHasTextContents = false;
    private boolean mForceUpdate = false;
    private Boolean mIsFavorite = null;
    private Boolean mIsPrevFavorite = null;
    private Boolean mIsVoice = null;
    private Boolean mIsPrevVoice = null;
    private boolean mIsVoiceChanged = false;

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public int getBackgroundColorInverted() {
        return this.mBackgroundColorInverted;
    }

    public String getHoverThumbnailFilePath() {
        return this.mHoverThumbnailFilePath;
    }

    public Drawable getImageDrawableImpl() {
        String hoverThumbnailFilePath = getHoverThumbnailFilePath();
        if (NotesUtils.isLock(getLockType()) || TextUtils.isEmpty(hoverThumbnailFilePath)) {
            return null;
        }
        return Drawable.createFromPath(hoverThumbnailFilePath);
    }

    public int getLockType() {
        return this.mLockType;
    }

    public boolean hasBackgroundColor() {
        return this.mHasBackgroundColor;
    }

    public boolean hasOnlyHandwritingSdoc() {
        return this.mHasOnlyHandwritingSdoc;
    }

    public boolean hasTextContents() {
        return this.mHasTextContents;
    }

    public boolean hasTextOnly() {
        return this.mHasTextOnly;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo
    public void initInfoViews() {
        super.initInfoViews();
        this.mCommonViewInfoController.init(getRootCardView());
    }

    public boolean isDarkMode() {
        return this.mIsDarkMode;
    }

    public Boolean isFavorite() {
        return this.mIsFavorite;
    }

    public boolean isForceUpdate() {
        return this.mForceUpdate;
    }

    public Boolean isPrevFavorite() {
        return this.mIsPrevFavorite;
    }

    public int isPrevLockType() {
        return this.mPrevLockType;
    }

    public Boolean isPrevVoice() {
        return this.mIsPrevVoice;
    }

    public boolean isSdoc() {
        return this.mIsSdoc;
    }

    public boolean isSupportInvertedBGColor() {
        return this.mIsSupportInvertedBGColor;
    }

    public Boolean isVoice() {
        return this.mIsVoice;
    }

    public boolean isVoiceChanged() {
        return this.mIsVoiceChanged;
    }

    public NotesHolderInfo setBackgroundColor(int i) {
        this.mBackgroundColor = i;
        return this;
    }

    public NotesHolderInfo setBackgroundColorInverted(int i) {
        this.mBackgroundColorInverted = i;
        return this;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo
    public void setCoeditExtraVisible(boolean z, boolean z2) {
        this.mCommonViewInfoController.setCoeditExtraVisible(getRootCardView(), z, z2);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo
    public void setCoeditLoadProgressVisible(boolean z, boolean z2) {
        this.mCommonViewInfoController.setCoeditLoadProgressVisible(getRootCardView(), z, z2);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo
    public void setCoeditSpaceExtraVisible(String str, boolean z) {
        this.mCommonViewInfoController.setCoeditSpaceExtraVisible(getRootCardView(), str, z);
    }

    public void setForceUpdate(boolean z) {
        this.mForceUpdate = z;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo
    public void setGcsExtraVisible(boolean z, boolean z2, boolean z3) {
        this.mCommonViewInfoController.setGcsExtraVisible(getRootCardView(), z, z2, z3);
    }

    public NotesHolderInfo setHasBackgroundColor(boolean z) {
        this.mHasBackgroundColor = z;
        return this;
    }

    public NotesHolderInfo setHasOnlyHandwritingSdoc(boolean z) {
        this.mHasOnlyHandwritingSdoc = z;
        return this;
    }

    public void setHasTextContents(boolean z) {
        this.mHasTextContents = z;
    }

    public NotesHolderInfo setHasTextOnly(boolean z) {
        this.mHasTextOnly = z;
        return this;
    }

    public NotesHolderInfo setHoverThumbnailFilePath(String str) {
        this.mHoverThumbnailFilePath = str;
        return this;
    }

    public NotesHolderInfo setIsDarkMode(boolean z) {
        this.mIsDarkMode = z;
        return this;
    }

    public NotesHolderInfo setIsFavorite(boolean z) {
        this.mIsPrevFavorite = this.mIsFavorite;
        this.mIsFavorite = Boolean.valueOf(z);
        return this;
    }

    public NotesHolderInfo setIsSdoc(boolean z) {
        this.mIsSdoc = z;
        return this;
    }

    public NotesHolderInfo setIsSupportInvertedBGColor(boolean z) {
        this.mIsSupportInvertedBGColor = z;
        return this;
    }

    public NotesHolderInfo setIsVoice(boolean z) {
        this.mIsPrevVoice = this.mIsVoice;
        this.mIsVoice = Boolean.valueOf(z);
        return this;
    }

    public void setIsVoiceChanged(boolean z) {
        this.mIsVoiceChanged = z;
    }

    public NotesHolderInfo setLockType(int i) {
        this.mPrevLockType = this.mLockType;
        this.mLockType = i;
        return this;
    }
}
