package com.google.android.material.color;

import android.content.Context;
import android.content.res.loader.ResourcesLoader;
import android.content.res.loader.ResourcesProvider;
import android.os.ParcelFileDescriptor;
import android.system.Os;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.work.impl.utils.AbstractC4113a;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(30)
final class ColorResourcesLoaderCreator {
    private static final String TAG = "ColorResLoaderCreator";

    private ColorResourcesLoaderCreator() {
    }

    @Nullable
    public static ResourcesLoader create(@NonNull Context context, @NonNull Map<Integer, Integer> map) throws Throwable {
        FileDescriptor fileDescriptorMemfd_create;
        try {
            byte[] bArrCreate = ColorResourcesTableCreator.create(context, map);
            Log.i(TAG, "Table created, length: " + bArrCreate.length);
            if (bArrCreate.length != 0) {
                try {
                    fileDescriptorMemfd_create = Os.memfd_create("temp.arsc", 0);
                    try {
                        if (fileDescriptorMemfd_create != null) {
                            FileOutputStream fileOutputStream = new FileOutputStream(fileDescriptorMemfd_create);
                            try {
                                fileOutputStream.write(bArrCreate);
                                ParcelFileDescriptor parcelFileDescriptorDup = ParcelFileDescriptor.dup(fileDescriptorMemfd_create);
                                try {
                                    AbstractC4113a.m2457k();
                                    ResourcesLoader resourcesLoaderM2449c = AbstractC4113a.m2449c();
                                    resourcesLoaderM2449c.addProvider(ResourcesProvider.loadFromTable(parcelFileDescriptorDup, null));
                                    if (parcelFileDescriptorDup != null) {
                                        parcelFileDescriptorDup.close();
                                    }
                                    fileOutputStream.close();
                                    Os.close(fileDescriptorMemfd_create);
                                    return resourcesLoaderM2449c;
                                } finally {
                                }
                            } finally {
                            }
                        }
                        Log.w(TAG, "Cannot create memory file descriptor.");
                        if (fileDescriptorMemfd_create != null) {
                            Os.close(fileDescriptorMemfd_create);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (fileDescriptorMemfd_create != null) {
                            Os.close(fileDescriptorMemfd_create);
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileDescriptorMemfd_create = null;
                }
            }
            return null;
        } catch (Exception e) {
            Log.e(TAG, "Failed to create the ColorResourcesTableCreator.", e);
            return null;
        }
    }
}
