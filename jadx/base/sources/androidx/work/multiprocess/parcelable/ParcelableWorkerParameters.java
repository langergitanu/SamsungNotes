package androidx.work.multiprocess.parcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Configuration;
import androidx.work.Data;
import androidx.work.ForegroundUpdater;
import androidx.work.ProgressUpdater;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.WorkForegroundUpdater;
import androidx.work.impl.utils.WorkProgressUpdater;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ParcelableWorkerParameters implements Parcelable {
    public static final Parcelable.Creator<ParcelableWorkerParameters> CREATOR = new Parcelable.Creator<ParcelableWorkerParameters>() { // from class: androidx.work.multiprocess.parcelable.ParcelableWorkerParameters.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NonNull
        public ParcelableWorkerParameters createFromParcel(Parcel parcel) {
            return new ParcelableWorkerParameters(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableWorkerParameters[] newArray(int i) {
            return new ParcelableWorkerParameters[i];
        }
    };

    @NonNull
    private final Data mData;
    private final int mGeneration;

    @NonNull
    private final UUID mId;
    private final int mRunAttemptCount;

    @NonNull
    private final WorkerParameters.RuntimeExtras mRuntimeExtras;

    @NonNull
    private final Set<String> mTags;

    public ParcelableWorkerParameters(@NonNull WorkerParameters workerParameters) {
        this.mId = workerParameters.getId();
        this.mData = workerParameters.getInputData();
        this.mTags = workerParameters.getTags();
        this.mRuntimeExtras = workerParameters.getRuntimeExtras();
        this.mRunAttemptCount = workerParameters.getRunAttemptCount();
        this.mGeneration = workerParameters.getGeneration();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public Data getData() {
        return this.mData;
    }

    @NonNull
    public UUID getId() {
        return this.mId;
    }

    public int getRunAttemptCount() {
        return this.mRunAttemptCount;
    }

    @NonNull
    public Set<String> getTags() {
        return this.mTags;
    }

    @NonNull
    public WorkerParameters toWorkerParameters(@NonNull WorkManagerImpl workManagerImpl) {
        Configuration configuration = workManagerImpl.getConfiguration();
        WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
        TaskExecutor workTaskExecutor = workManagerImpl.getWorkTaskExecutor();
        return toWorkerParameters(configuration, workTaskExecutor, new WorkProgressUpdater(workDatabase, workTaskExecutor), new WorkForegroundUpdater(workDatabase, workManagerImpl.getProcessor(), workTaskExecutor));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.mId.toString());
        new ParcelableData(this.mData).writeToParcel(parcel, i);
        parcel.writeStringList(new ArrayList(this.mTags));
        new ParcelableRuntimeExtras(this.mRuntimeExtras).writeToParcel(parcel, i);
        parcel.writeInt(this.mRunAttemptCount);
        parcel.writeInt(this.mGeneration);
    }

    public ParcelableWorkerParameters(@NonNull Parcel parcel) {
        this.mId = UUID.fromString(parcel.readString());
        this.mData = new ParcelableData(parcel).getData();
        this.mTags = new HashSet(parcel.createStringArrayList());
        this.mRuntimeExtras = new ParcelableRuntimeExtras(parcel).getRuntimeExtras();
        this.mRunAttemptCount = parcel.readInt();
        this.mGeneration = parcel.readInt();
    }

    @NonNull
    public WorkerParameters toWorkerParameters(@NonNull Configuration configuration, @NonNull TaskExecutor taskExecutor, @NonNull ProgressUpdater progressUpdater, @NonNull ForegroundUpdater foregroundUpdater) {
        return new WorkerParameters(this.mId, this.mData, this.mTags, this.mRuntimeExtras, this.mRunAttemptCount, this.mGeneration, configuration.getExecutor(), taskExecutor, configuration.getWorkerFactory(), progressUpdater, foregroundUpdater);
    }
}
