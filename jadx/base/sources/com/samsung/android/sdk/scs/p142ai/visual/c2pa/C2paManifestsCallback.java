package com.samsung.android.sdk.scs.p142ai.visual.c2pa;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.samsung.android.visual.p167ai.sdkcommon.IC2paManifestsCallback;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class C2paManifestsCallback extends IC2paManifestsCallback.Stub {
    @Override // com.samsung.android.visual.p167ai.sdkcommon.IC2paManifestsCallback
    public void onPfdCreation(ParcelFileDescriptor parcelFileDescriptor, boolean z) {
        try {
            try {
                try {
                    FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptor.getFileDescriptor());
                    try {
                        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                        try {
                            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                            try {
                                onResult((String) bufferedReader.lines().collect(Collectors.joining("\n")), z, true);
                                bufferedReader.close();
                                inputStreamReader.close();
                                fileInputStream.close();
                                parcelFileDescriptor.close();
                            } finally {
                            }
                        } finally {
                        }
                    } catch (Throwable th) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (Exception unused) {
                    onError(C2paError.PFD_READ_ERROR.getErrString());
                    Log.e("C2paClient", "Error while reading c2pa manifest from pfd");
                    parcelFileDescriptor.close();
                }
            } catch (IOException | SecurityException e) {
                Log.e("C2paClient", "Error while closing pfd");
                onError(C2paError.PFD_READ_ERROR.getErrString());
                e.printStackTrace();
            }
        } catch (Throwable th3) {
            try {
                parcelFileDescriptor.close();
            } catch (IOException | SecurityException e2) {
                Log.e("C2paClient", "Error while closing pfd");
                onError(C2paError.PFD_READ_ERROR.getErrString());
                e2.printStackTrace();
            }
            throw th3;
        }
    }
}
