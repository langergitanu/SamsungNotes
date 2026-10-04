package com.samsung.android.support.senl.p148nt.composer.main.base.model.mde;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.samsung.android.support.senl.p148nt.base.common.sync.CoeditResolverContract;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mde.MdeInfoResolver;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class MdeManager {
    private static final String KEY_INSTANCE_STATE = "key_MdeManager";
    private static final String TAG = Logger.createTag("MdeManager");
    private final MdeInfo mMdeInfo;
    private MdeInfoResolver mMdeInfoResolver;
    private LiveData<List<CoeditResolverContract.MemberInfo>> mMemberListLiveData;
    private Observer<List<CoeditResolverContract.MemberInfo>> mMemberListLiveDataObserver;
    private SavedState mSavedState;
    private stateForSA mStateForSA;
    private boolean mIsReopening = false;
    private final CoeditAdapter mCoeditAdapter = new CoeditAdapter();

    public MdeManager(Intent intent, NotesDocumentRepository notesDocumentRepository) {
        this.mMdeInfo = createMdeInfo(intent);
        initCoedit(intent, notesDocumentRepository);
        this.mStateForSA = new stateForSA();
    }

    private MdeInfo createMdeInfo(Intent intent) {
        return new MdeInfo(intent.getStringExtra(ComposerConstants.ARG_MDE_SPACE_ID), intent.getStringExtra(ComposerConstants.ARG_MDE_GROUP_ID), intent.getStringExtra(ComposerConstants.ARG_MDE_OWNER_ID), "", intent.getIntExtra(ComposerConstants.ARG_MDE_ACCOUNT_TYPE, 0));
    }

    private void initCoedit(Intent intent, NotesDocumentRepository notesDocumentRepository) {
        String stringExtra = intent.getStringExtra("category_id");
        if (TextUtils.isEmpty(stringExtra)) {
            NotesDocumentEntity notesDocumentEntity = notesDocumentRepository.get(intent.getStringExtra("sdoc_uuid"));
            stringExtra = notesDocumentEntity != null ? notesDocumentEntity.getCategoryUuid() : "";
        }
        if (this.mCoeditAdapter.isCoeditNote(stringExtra)) {
            this.mCoeditAdapter.setCoeditNote(true);
            initMdeInfoResolver(true);
        }
        if (this.mCoeditAdapter.isSharedNote(stringExtra)) {
            this.mCoeditAdapter.setSharedNote(true);
        }
    }

    private void setMemberListLiveDataObserver(Context context) {
        if (this.mMemberListLiveData != null) {
            Logger.m11000e(TAG, "setMemberListLiveDataObserver# old data was remained");
            release();
        }
        LiveData<List<CoeditResolverContract.MemberInfo>> memberListLiveData = this.mMdeInfoResolver.getMemberListLiveData(context, this.mMdeInfo.getGroupId());
        this.mMemberListLiveData = memberListLiveData;
        if (memberListLiveData == null) {
            Logger.m11000e(TAG, "setMemberListLiveDataObserver# mMemberListLiveData is null");
            return;
        }
        Observer<List<CoeditResolverContract.MemberInfo>> observer = new Observer<List<CoeditResolverContract.MemberInfo>>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeManager.2
            @Override // androidx.lifecycle.Observer
            public void onChanged(List<CoeditResolverContract.MemberInfo> list) {
                String leaderId = MdeManager.this.mMdeInfoResolver.getLeaderId(MdeManager.this.mMdeInfo.getGroupId());
                Logger.m11003i(MdeManager.TAG, "setMemberListLiveDataObserver# onChanged - leaderId:" + leaderId + ", result:" + list);
                MdeManager.this.mMdeInfo.setLeaderId(leaderId);
                MdeManager.this.mMdeInfo.setCoeditMemberList(list);
            }
        };
        this.mMemberListLiveDataObserver = observer;
        try {
            this.mMemberListLiveData.observeForever(observer);
        } catch (IllegalStateException e) {
            Logger.m11000e(TAG, "setMemberListLiveDataObserver# " + this.mMemberListLiveData.toString() + " IllegalStateException: " + e.getMessage());
        }
    }

    public void clearSession() {
        if (this.mMdeInfoResolver == null || !this.mMdeInfo.isMde()) {
            return;
        }
        this.mMdeInfoResolver.requestDisConnectSessionAsync();
    }

    public void connectSession() {
        if (this.mMdeInfoResolver == null || !this.mMdeInfo.isMde()) {
            return;
        }
        this.mMdeInfoResolver.requestConnectSessionAsync();
    }

    public void deleteCoeditNoteDataAndDownload(Context context, String str, String str2) {
        this.mMdeInfoResolver.deleteCoeditNoteDataAndDownload(context, str, str2);
    }

    public void deleteNote(Context context, String str, String str2) {
        this.mMdeInfoResolver.deleteNote(context, str, str2);
    }

    public void deleteSpace(String str, String str2) {
        this.mMdeInfoResolver.deleteSpace(str, str2);
    }

    public CoeditAdapter getCoeditAdapter() {
        return this.mCoeditAdapter;
    }

    public int getMaximumCountOnCoedit() {
        return this.mStateForSA.getMaximumCountOnCoedit();
    }

    public MdeInfo getMdeInfo() {
        return this.mMdeInfo;
    }

    public SavedState getSavedState() {
        SavedState savedState = this.mSavedState;
        this.mSavedState = null;
        return savedState;
    }

    public void init(Context context, String str) {
        if (!this.mMdeInfo.isMde()) {
            this.mCoeditAdapter.setCoeditEnabled(RequestToSyncManager.INSTANCE.isCoeditFeatureSupported(context.getApplicationContext()));
            return;
        }
        Logger.m11003i(TAG, "init# isCoeditNote : " + this.mCoeditAdapter.isCoeditNote());
        initMdeInfoResolver(this.mCoeditAdapter.isCoeditNote());
        connectSession();
        if (this.mCoeditAdapter.isCoeditNote()) {
            setMemberListLiveDataObserver(context);
        }
        this.mMdeInfoResolver.getCreatorName(this.mMdeInfo.getGroupId(), this.mMdeInfo.getOwnerId(), this.mMdeInfo.getSpaceId(), str, new MdeInfoResolver.Callback<String>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeManager.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfoResolver.Callback
            public void onResult(String str2) {
                MdeManager.this.mMdeInfo.setCreatorName(str2);
            }
        });
        MdeInfo mdeInfo = this.mMdeInfo;
        mdeInfo.setLeaderId(this.mMdeInfoResolver.getLeaderId(mdeInfo.getGroupId()));
        this.mMdeInfo.setMyId(this.mMdeInfoResolver.getCurrentUserOwnerId());
        MdeInfo mdeInfo2 = this.mMdeInfo;
        mdeInfo2.setStandAlone(this.mMdeInfoResolver.isStandAlone(mdeInfo2.getSpaceId()));
        MdeInfo mdeInfo3 = this.mMdeInfo;
        mdeInfo3.setSpaceName(this.mMdeInfoResolver.getSpaceName(context, mdeInfo3.getSpaceId()));
    }

    public void initMdeInfoResolver(boolean z) {
        if (this.mMdeInfoResolver == null) {
            this.mMdeInfoResolver = new MdeInfoResolver();
        }
        this.mMdeInfoResolver.init(z);
        this.mCoeditAdapter.setMdeInfoResolver(this.mMdeInfoResolver);
    }

    public boolean isCreator(@NonNull String str) {
        return str.equals(this.mMdeInfoResolver.getCurrentUserOwnerId());
    }

    public boolean isReopening() {
        return this.mIsReopening;
    }

    public void leaveNote() {
        this.mMdeInfoResolver.leave(this.mMdeInfo.getSpaceId(), this.mMdeInfo.getGroupId());
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelable(KEY_INSTANCE_STATE, this.mStateForSA);
    }

    public void refreshMyId() {
        if (TextUtils.isEmpty(this.mMdeInfo.getMyId())) {
            this.mMdeInfo.setMyId(this.mMdeInfoResolver.getCurrentUserOwnerId());
        }
    }

    public void release() {
        if (this.mMemberListLiveData == null || this.mMemberListLiveDataObserver == null) {
            return;
        }
        Logger.m11003i(TAG, "release# mMemberListLiveData.removeObserver");
        this.mMemberListLiveData.removeObserver(this.mMemberListLiveDataObserver);
        this.mMemberListLiveDataObserver = null;
        this.mMemberListLiveData = null;
    }

    public void restoreState(Bundle bundle) {
        stateForSA stateforsa = (stateForSA) bundle.getParcelable(KEY_INSTANCE_STATE);
        if (stateforsa != null) {
            this.mStateForSA = stateforsa;
        }
    }

    public void setMaximumCountOnCoedit(int i) {
        this.mStateForSA.setMaximumCountOnCoedit(i);
    }

    public void setReopening(boolean z) {
        this.mIsReopening = z;
    }

    public void setSavedState(SavedState savedState) {
        this.mSavedState = savedState;
    }

    public void updateMdeEntity(NotesDocumentEntity notesDocumentEntity) {
        if (this.mMdeInfo.getSpaceId() != null) {
            notesDocumentEntity.setMdeSpaceId(this.mMdeInfo.getSpaceId());
        }
        if (this.mMdeInfo.getGroupId() != null) {
            notesDocumentEntity.setMdeGroupId(this.mMdeInfo.getGroupId());
        }
        if (this.mMdeInfo.getOwnerId() != null) {
            notesDocumentEntity.setMdeOwnerId(this.mMdeInfo.getOwnerId());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class stateForSA implements Parcelable {
        public static final Parcelable.Creator<stateForSA> CREATOR = new Parcelable.Creator<stateForSA>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeManager.stateForSA.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public stateForSA createFromParcel(Parcel parcel) {
                return new stateForSA(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public stateForSA[] newArray(int i) {
                return new stateForSA[i];
            }
        };
        private int mMaximumCountOnCoedit;

        public stateForSA() {
            this.mMaximumCountOnCoedit = 0;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int getMaximumCountOnCoedit() {
            return this.mMaximumCountOnCoedit;
        }

        public void setMaximumCountOnCoedit(int i) {
            if (this.mMaximumCountOnCoedit < i) {
                this.mMaximumCountOnCoedit = i;
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mMaximumCountOnCoedit);
        }

        public stateForSA(Parcel parcel) {
            this.mMaximumCountOnCoedit = 0;
            this.mMaximumCountOnCoedit = parcel.readInt();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeManager.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public int mPageLayoutColumn;
        public boolean mPageLayoutFitToScreen;
        public int mPageLayoutRow;
        public boolean mScrollVertical;

        public SavedState() {
            this.mPageLayoutColumn = 1;
            this.mPageLayoutRow = 1;
            this.mPageLayoutFitToScreen = false;
            this.mScrollVertical = true;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void setPageSetting(int i, int i2, boolean z, boolean z2) {
            this.mPageLayoutColumn = i;
            this.mPageLayoutRow = i2;
            this.mPageLayoutFitToScreen = z;
            this.mScrollVertical = z2;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mPageLayoutColumn);
            parcel.writeInt(this.mPageLayoutRow);
            parcel.writeByte(this.mPageLayoutFitToScreen ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.mScrollVertical ? (byte) 1 : (byte) 0);
        }

        public SavedState(Parcel parcel) {
            this.mPageLayoutColumn = 1;
            this.mPageLayoutRow = 1;
            this.mPageLayoutFitToScreen = false;
            this.mScrollVertical = true;
            this.mPageLayoutColumn = parcel.readInt();
            this.mPageLayoutRow = parcel.readInt();
            this.mPageLayoutFitToScreen = parcel.readByte() != 0;
            this.mScrollVertical = parcel.readByte() != 0;
        }
    }
}
