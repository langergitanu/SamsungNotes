package com.samsung.android.support.senl.p148nt.model.converter.task.common;

import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.common.ISDocXConverter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ConvertInfo implements IConvertInfo {
    private final int mCallerId;
    private final String mSrcPath;
    private String mUuid;
    private int mSrcType = 0;
    private int mDstType = 9;
    private int mGroupId = -1;
    private int mLockType = 0;
    private String mDstUuid = null;
    private boolean mIsImported = true;
    private boolean mIsAuthenticated = false;
    private long mReqFileSize = 0;
    private boolean mIsWidgetMemo = false;
    private boolean mIsIndividualPage = false;
    private ISDocXConverter mConverter = null;
    private String mDstFilePreFix = "";
    private String mDstFilePath = "";
    private int mWritingMode = 0;
    private boolean mIsWrappingWhenLocked = false;
    private String mFolderName = "";

    public ConvertInfo(String str, int i) {
        this.mSrcPath = str;
        this.mCallerId = i;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo
    public int getCallerId() {
        return this.mCallerId;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo
    @Nullable
    public ISDocXConverter getConverter() {
        return this.mConverter;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo
    public String getDstFilePrefix() {
        return this.mDstFilePreFix;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo
    public String getDstPath() {
        return this.mDstFilePath;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo
    public int getDstType() {
        return this.mDstType;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo
    public String getDstUuid() {
        return this.mDstUuid;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo
    public String getFolderName() {
        return this.mFolderName;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo
    public int getGroupId() {
        return this.mGroupId;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo
    public boolean getIsAuthenticated() {
        return this.mIsAuthenticated;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo
    public boolean getIsWidgetMemo() {
        return this.mIsWidgetMemo;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo
    public int getLockType() {
        return this.mLockType;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo
    public long getReqFileSize() {
        return this.mReqFileSize;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo, com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.common.IConvertItem
    public String getSrcPath() {
        return this.mSrcPath;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo
    public int getSrcType() {
        return this.mSrcType;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo
    public String getUuid() {
        return this.mUuid;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.common.IConvertItem
    public int getWritingMode() {
        return this.mWritingMode;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo
    public boolean isImported() {
        return this.mIsImported;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo
    public boolean isIndividualPage() {
        return this.mIsIndividualPage;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.common.IConvertItem
    public boolean isWrappingWhenLocked() {
        return this.mIsWrappingWhenLocked;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo
    public ConvertInfo setConverter(@Nullable ISDocXConverter iSDocXConverter) {
        this.mConverter = iSDocXConverter;
        return this;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo
    public ConvertInfo setDstFilePrefix(String str) {
        this.mDstFilePreFix = str;
        return this;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo
    public ConvertInfo setDstPath(String str) {
        this.mDstFilePath = str;
        return this;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo
    public ConvertInfo setDstType(int i) {
        this.mDstType = i;
        return this;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo
    public ConvertInfo setDstUuid(String str) {
        this.mDstUuid = str;
        return this;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo
    public ConvertInfo setFolderName(String str) {
        this.mFolderName = str;
        return this;
    }

    public ConvertInfo setGroupId(int i) {
        this.mGroupId = i;
        return this;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo
    public ConvertInfo setIsAuthenticated(boolean z) {
        this.mIsAuthenticated = z;
        return this;
    }

    public ConvertInfo setIsImported(boolean z) {
        this.mIsImported = z;
        return this;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo
    public ConvertInfo setIsIndividualPage(boolean z) {
        this.mIsIndividualPage = z;
        return this;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo
    public ConvertInfo setIsWidgetMemo(boolean z) {
        this.mIsWidgetMemo = z;
        return this;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo
    public ConvertInfo setIsWrappingWhenLocked(boolean z) {
        this.mIsWrappingWhenLocked = z;
        return this;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo
    public ConvertInfo setLockType(int i) {
        this.mLockType = i;
        return this;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo
    public ConvertInfo setReqFileSize(long j) {
        this.mReqFileSize = j;
        return this;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo
    public ConvertInfo setSrcType(int i) {
        this.mSrcType = i;
        return this;
    }

    public ConvertInfo setUuid(String str) {
        this.mUuid = str;
        return this;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo
    public ConvertInfo setWriteMode(int i) {
        this.mWritingMode = i;
        return this;
    }
}
