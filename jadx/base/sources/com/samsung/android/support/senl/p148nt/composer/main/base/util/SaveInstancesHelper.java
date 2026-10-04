package com.samsung.android.support.senl.p148nt.composer.main.base.util;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SaveInstancesHelper {
    private static final int BASE_SIZE = 262144;
    private static final String TAG = Logger.createTag("SaveInstancesHelper");
    private String mDirPathWithSeparator;
    private String mLastSavedFilePath;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface LargeableData {
        Parcelable getData();

        boolean isLarge();
    }

    public SaveInstancesHelper(Context context) {
        String saveInstancesFolderName = ComposerCacheFileUtil.getSaveInstancesFolderName(context);
        this.mDirPathWithSeparator = saveInstancesFolderName;
        if (saveInstancesFolderName != null) {
            this.mDirPathWithSeparator += File.separator;
        }
    }

    @Nullable
    public <T> T restore(Bundle bundle, String str, Parcelable.Creator<T> creator) {
        ByteArrayOutputStream byteArrayOutputStream;
        T t = (T) bundle.getParcelable(str);
        if (t != null) {
            return t;
        }
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        File file = new File(string);
        if (!file.exists()) {
            return null;
        }
        byte[] bArr = new byte[1024];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } finally {
            }
            while (true) {
                try {
                    int i = fileInputStream.read(bArr, 0, 1024);
                    if (i == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                } finally {
                }
            }
            byteArrayOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            fileInputStream.close();
            if (!file.delete()) {
                Logger.m11000e(TAG, "restore: savedData.delete fail");
            }
            Parcel parcelObtain = Parcel.obtain();
            parcelObtain.unmarshall(byteArray, 0, byteArray.length);
            parcelObtain.setDataPosition(0);
            T tCreateFromParcel = creator.createFromParcel(parcelObtain);
            parcelObtain.recycle();
            return tCreateFromParcel;
        } catch (IOException unused) {
            if (!file.delete()) {
                Logger.m11000e(TAG, "restore: savedData.delete fail");
            }
            return null;
        } catch (Throwable th) {
            if (!file.delete()) {
                Logger.m11000e(TAG, "restore: savedData.delete fail");
            }
            throw th;
        }
    }

    public void save(@NonNull Bundle bundle, @NonNull LargeableData largeableData, @NonNull String str) {
        if (this.mDirPathWithSeparator == null) {
            Logger.m11000e(TAG, "save# dir is null");
            return;
        }
        if (this.mLastSavedFilePath != null && new File(this.mLastSavedFilePath).delete()) {
            Logger.m11000e(TAG, "save: delete fail");
        }
        Logger.startTime(String.valueOf(largeableData.hashCode()));
        if (!largeableData.isLarge()) {
            bundle.putParcelable(str, largeableData.getData());
            Logger.endTime(String.valueOf(largeableData.hashCode()), TAG, "save# none");
            return;
        }
        Parcel parcelObtain = Parcel.obtain();
        boolean zCreateNewFile = false;
        largeableData.getData().writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        if (bArrMarshall.length < 262144) {
            bundle.putParcelable(str, largeableData.getData());
            Logger.endTime(String.valueOf(largeableData.hashCode()), TAG, "save# none");
            return;
        }
        String strGenerateUniqueFilePathNoExtension = FileUtils.generateUniqueFilePathNoExtension(this.mDirPathWithSeparator, String.valueOf(System.currentTimeMillis()));
        File file = new File(strGenerateUniqueFilePathNoExtension);
        try {
            zCreateNewFile = file.createNewFile();
        } catch (IOException unused) {
        }
        if (!zCreateNewFile) {
            Logger.endTime(String.valueOf(largeableData.hashCode()), TAG, "save# fail to create file");
            return;
        }
        this.mLastSavedFilePath = strGenerateUniqueFilePathNoExtension;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(bArrMarshall);
                fileOutputStream.close();
            } finally {
            }
        } catch (IOException e) {
            AbstractC8014b.m7204f(e, new StringBuilder("save: "), TAG);
            strGenerateUniqueFilePathNoExtension = "";
        }
        if (!strGenerateUniqueFilePathNoExtension.isEmpty()) {
            bundle.putString(str, strGenerateUniqueFilePathNoExtension.toString());
        }
        Logger.endTime(String.valueOf(largeableData.hashCode()), TAG, "save# done");
    }
}
