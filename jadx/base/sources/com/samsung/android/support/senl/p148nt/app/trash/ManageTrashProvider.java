package com.samsung.android.support.senl.p148nt.app.trash;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.data.common.utils.DataUtils;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import java.util.concurrent.ForkJoinPool;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ManageTrashProvider extends ContentProvider {
    private static final String TAG = "ManageTrashProvider";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ManageTrash {
        public static final String GET_TRASH_INFO = "getTrashInfo";

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public enum RequestType {
            TRASH_INTERNAL_CAPACITY,
            TRASH_SDCARD_CAPACITY,
            TRASH_INTENT_ACTION,
            TRASH_ITEM_COUNT,
            TRASH_APP_DATA_CAPACITY
        }
    }

    private long calculateRecycleBinStorage(@NonNull Context context) {
        try {
            return ((Long) new ForkJoinPool().invoke(new StorageUtils.GetSDocStorageTask(NotesDataRepositoryFactory.newInstance(context).createNotesRecycleBinRepository().getAllFilePathsInRecycleBin()))).longValue();
        } catch (RuntimeException e) {
            MainLogger.m7255e(TAG, "RuntimeException" + e.getMessage());
            return 0L;
        }
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Bundle call(@NonNull String str, @Nullable String str2, @Nullable Bundle bundle) {
        Context context = getContext();
        if (context == null || !ManageTrash.GET_TRASH_INFO.equals(str)) {
            return null;
        }
        DataUtils.setContext(context.getApplicationContext());
        Bundle bundle2 = new Bundle();
        long jCalculateRecycleBinStorage = calculateRecycleBinStorage(context);
        bundle2.putLong(ManageTrash.RequestType.TRASH_INTERNAL_CAPACITY.name(), jCalculateRecycleBinStorage);
        bundle2.putLong(ManageTrash.RequestType.TRASH_SDCARD_CAPACITY.name(), 0L);
        bundle2.putLong(ManageTrash.RequestType.TRASH_APP_DATA_CAPACITY.name(), jCalculateRecycleBinStorage);
        bundle2.putString(ManageTrash.RequestType.TRASH_INTENT_ACTION.name(), NotesConstants.ACTION_VIEW_TRASH);
        if (Build.VERSION.SDK_INT >= 34) {
            bundle2.putInt(ManageTrash.RequestType.TRASH_ITEM_COUNT.name(), NotesDataRepositoryFactory.newInstance(context).createNotesRecycleBinRepository().getItemCount());
        }
        return bundle2;
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        MainLogger.m7254d(TAG, "onCreate");
        return true;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }
}
