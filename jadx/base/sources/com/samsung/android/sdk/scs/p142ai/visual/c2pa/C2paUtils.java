package com.samsung.android.sdk.scs.p142ai.visual.c2pa;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.drive.DriveFile;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class C2paUtils {
    private static final String TAG = "C2paUtils";

    public static String getFileExtension(@NonNull String str) {
        File file = new File(str);
        if (!file.exists() || !file.canRead()) {
            AbstractC2322a.m1636z("getFileExtension: File does not exist or cannot be read/written:", str, TAG);
            return null;
        }
        String name = file.getName();
        int iLastIndexOf = name.lastIndexOf(46);
        if (iLastIndexOf >= 0 && iLastIndexOf < name.length() - 1) {
            return name.substring(iLastIndexOf + 1);
        }
        Log.e(TAG, "getFileExtension: Unable to find extension".concat(name));
        return null;
    }

    public static ParcelFileDescriptor getParcelFileDescriptor(@NonNull String str) {
        try {
            File file = new File(str);
            if (file.exists() && file.canRead() && file.canWrite()) {
                return ParcelFileDescriptor.open(file, DriveFile.MODE_READ_WRITE);
            }
            Log.e(TAG, "File does not exist or cannot be read/written: " + str);
            return null;
        } catch (IOException unused) {
            AbstractC2322a.m1636z("IOException Occurred in getParcelFileDescriptor: ", str, TAG);
            return null;
        } catch (SecurityException unused2) {
            AbstractC2322a.m1636z("SecurityException Occurred in getParcelFileDescriptor: ", str, TAG);
            return null;
        }
    }
}
