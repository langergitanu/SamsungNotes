package com.samsung.android.support.senl.p148nt.composer.main.base.model.data;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SyncConflictDataManager implements Observer<Integer> {
    private static final String TAG = Logger.createTag("SyncConflictDataManager");
    private boolean mConflicted = false;
    private LiveData<Integer> mLiveDataIsConflicted;
    private Observer<Integer> mObserverIsConflicted;
    private Runnable mShowConfirmSyncConflictDialogRunnable;
    private final SyncNoteDataRepository mSyncNoteDataRepository;
    private String mUuid;

    public SyncConflictDataManager(NotesDataRepositoryFactory notesDataRepositoryFactory) {
        this.mSyncNoteDataRepository = notesDataRepositoryFactory.createSyncNoteDataRepository();
    }

    private void addObserverIsConflicted(Observer<Integer> observer, @NonNull String str, LifecycleOwner lifecycleOwner) {
        LiveData<Integer> liveData = this.mLiveDataIsConflicted;
        if (liveData != null) {
            liveData.removeObserver(this.mObserverIsConflicted);
        }
        this.mObserverIsConflicted = observer;
        LiveData<Integer> liveDataIsConflicted_LiveData = this.mSyncNoteDataRepository.isConflicted_LiveData(str);
        this.mLiveDataIsConflicted = liveDataIsConflicted_LiveData;
        Observer<Integer> observer2 = this.mObserverIsConflicted;
        if (observer2 != null) {
            liveDataIsConflicted_LiveData.observe(lifecycleOwner, observer2);
        }
    }

    public void clearReplaceConflictStrategy() {
        if (this.mSyncNoteDataRepository.isConflicted(this.mUuid) <= 0 || this.mSyncNoteDataRepository.getConflictStrategy(this.mUuid) != 1) {
            return;
        }
        updateConflictStrategy(this.mUuid, 0);
    }

    public void connectObserver(@NonNull String str, LifecycleOwner lifecycleOwner) {
        Observer<Integer> observer = this.mObserverIsConflicted;
        if (observer == null) {
            return;
        }
        addObserverIsConflicted(observer, str, lifecycleOwner);
    }

    public String getDeviceName() {
        return this.mSyncNoteDataRepository.getDeviceName(this.mUuid);
    }

    public long getNoteSyncState() {
        return this.mSyncNoteDataRepository.getNoteSyncState(this.mUuid);
    }

    public void removeObserverIsConflicted() {
        LiveData<Integer> liveData = this.mLiveDataIsConflicted;
        if (liveData == null) {
            return;
        }
        Observer<Integer> observer = this.mObserverIsConflicted;
        if (observer != null) {
            liveData.removeObserver(observer);
            this.mObserverIsConflicted = null;
        }
        this.mLiveDataIsConflicted = null;
    }

    public void setObserverIsConflicted(@NonNull String str, LifecycleOwner lifecycleOwner, Runnable runnable) {
        if (!str.equals(this.mUuid)) {
            removeObserverIsConflicted();
        }
        this.mShowConfirmSyncConflictDialogRunnable = runnable;
        addObserverIsConflicted(this, str, lifecycleOwner);
    }

    public void setUuid(String str) {
        this.mUuid = str;
    }

    public void updateConflictStrategy(@NonNull String str, int i) {
        this.mSyncNoteDataRepository.updateConflictStrategy(str, i);
        RequestToSyncManager.INSTANCE.requestSyncForConflictedNote(str, i);
    }

    @Override // androidx.lifecycle.Observer
    public void onChanged(Integer num) {
        int conflictStrategy;
        if (num == null) {
            return;
        }
        boolean z = num.intValue() > 0;
        if (this.mConflicted == z) {
            return;
        }
        this.mConflicted = z;
        if (z) {
            conflictStrategy = this.mSyncNoteDataRepository.getConflictStrategy(this.mUuid);
            if (conflictStrategy == 0) {
                this.mShowConfirmSyncConflictDialogRunnable.run();
            }
        } else {
            conflictStrategy = -1;
        }
        Logger.m11003i(TAG, "isConflicted_LiveData onChanged : " + num + " / " + conflictStrategy);
    }
}
