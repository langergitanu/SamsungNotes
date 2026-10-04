package com.samsung.android.support.senl.p148nt.data.contract;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.base.common.constants.DataBaseConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.DocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DataToSyncManager {
    private static DataToSyncManager sInstance;
    private DataContract mDataContract;
    private DataObserver mObserver;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface DataContract {
        String createHWThumbnailFiles(Context context, List<Bitmap> list, String str, List<String> list2, String str2, boolean z);

        String createThumbnailFile(Context context, Bitmap bitmap, String str);

        Bitmap decodeSampledBitmapFromFile(Context context, String str);

        void deleteDocumentFile(Context context, List<DocumentData> list, @DataBaseConstants.DeletedBy int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface DataObserver {
        void onCoeditDocumentSaved(String str, long j);

        void onCoverUpdated(String str);

        void onMappedDocumentChanged(String str);

        void onPostDocumentSaved(@NonNull NotesDocumentEntity notesDocumentEntity);

        void onTagUpdated(Collection<String> collection);
    }

    private DataToSyncManager() {
    }

    public static synchronized DataToSyncManager getInstance() {
        try {
            if (sInstance == null) {
                sInstance = new DataToSyncManager();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    public String createHWThumbnailFiles(Context context, List<Bitmap> list, String str, List<String> list2, String str2, boolean z) {
        DataContract dataContract = this.mDataContract;
        return dataContract != null ? dataContract.createHWThumbnailFiles(context, list, str, list2, str2, z) : "";
    }

    public String createThumbnailFile(Context context, Bitmap bitmap, String str) {
        DataContract dataContract = this.mDataContract;
        return dataContract != null ? dataContract.createThumbnailFile(context, bitmap, str) : "";
    }

    public Bitmap decodeSampledBitmapFromFile(Context context, String str) {
        DataContract dataContract = this.mDataContract;
        if (dataContract != null) {
            return dataContract.decodeSampledBitmapFromFile(context, str);
        }
        return null;
    }

    public void deleteDocumentFile(Context context, List<DocumentData> list, @DataBaseConstants.DeletedBy int i) {
        DataContract dataContract = this.mDataContract;
        if (dataContract != null) {
            dataContract.deleteDocumentFile(context, list, i);
        }
    }

    public void init(@NonNull DataObserver dataObserver) {
        this.mObserver = dataObserver;
        if (dataObserver instanceof DataContract) {
            this.mDataContract = (DataContract) dataObserver;
        }
    }

    public void onCoeditDocumentSaved(String str, long j) {
        DataObserver dataObserver = this.mObserver;
        if (dataObserver != null) {
            dataObserver.onCoeditDocumentSaved(str, j);
        }
    }

    public void onCoverUpdated(String str) {
        DataObserver dataObserver = this.mObserver;
        if (dataObserver != null) {
            dataObserver.onCoverUpdated(str);
        }
    }

    public void onMappedDocumentChanged(String str) {
        DataObserver dataObserver = this.mObserver;
        if (dataObserver != null) {
            dataObserver.onMappedDocumentChanged(str);
        }
    }

    public void onPostDocumentSaved(@NonNull NotesDocumentEntity notesDocumentEntity) {
        DataObserver dataObserver = this.mObserver;
        if (dataObserver != null) {
            dataObserver.onPostDocumentSaved(notesDocumentEntity);
        }
    }

    public void onTagUpdated(Collection<String> collection) {
        DataObserver dataObserver = this.mObserver;
        if (dataObserver != null) {
            dataObserver.onTagUpdated(collection);
        }
    }
}
