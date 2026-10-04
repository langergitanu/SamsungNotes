package com.samsung.android.sdk.pen.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.util.Log;
import com.samsung.android.sdk.pen.Spen;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00010\fR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/util/SpenTypedArrayUtil;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mSdkResources", "Landroid/content/res/Resources;", "setStringArray", "", "strArray", "", "", "strName", "([Ljava/lang/String;Ljava/lang/String;)V", "setColorArray", "colorArray", "", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenTypedArrayUtil {

    @NotNull
    private static final String TAG = "SpenUtilTypedArray";

    @Nullable
    private Resources mSdkResources;

    public SpenTypedArrayUtil(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                this.mSdkResources = packageManager.getResourcesForApplication(Spen.INSTANCE.getSpenPackageName());
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setColorArray(@NotNull int[] colorArray, @Nullable String strName) {
        Intrinsics.checkNotNullParameter(colorArray, "colorArray");
        Resources resources = this.mSdkResources;
        int identifier = resources != null ? resources.getIdentifier(strName, "array", Spen.INSTANCE.getSpenPackageName()) : 0;
        if (identifier == 0) {
            Log.e(TAG, "setColorArray(" + strName + ") = 0");
            return;
        }
        try {
            try {
                Resources resources2 = this.mSdkResources;
                typedArrayObtainTypedArray = resources2 != null ? resources2.obtainTypedArray(identifier) : null;
                if (typedArrayObtainTypedArray == null) {
                    return;
                }
                int length = colorArray.length;
                if (length > typedArrayObtainTypedArray.length()) {
                    length = typedArrayObtainTypedArray.length();
                    Log.d(TAG, "color Array(" + strName + ") is smaller than input");
                }
                for (int i = 0; i < length; i++) {
                    colorArray[i] = typedArrayObtainTypedArray.getColor(i, 0);
                }
                typedArrayObtainTypedArray.recycle();
                return;
            } catch (Resources.NotFoundException e) {
                e.printStackTrace();
                if (typedArrayObtainTypedArray != null) {
                    typedArrayObtainTypedArray.recycle();
                    return;
                }
                return;
            }
        } catch (Throwable th) {
            if (typedArrayObtainTypedArray != null) {
            }
            throw th;
        }
        if (typedArrayObtainTypedArray != null) {
            typedArrayObtainTypedArray.recycle();
        }
        throw th;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setStringArray(@NotNull String[] strArray, @Nullable String strName) {
        Intrinsics.checkNotNullParameter(strArray, "strArray");
        Resources resources = this.mSdkResources;
        int identifier = resources != null ? resources.getIdentifier(strName, "array", Spen.INSTANCE.getSpenPackageName()) : 0;
        if (identifier == 0) {
            Log.e(TAG, "setStringArray(" + strName + ") = 0");
            return;
        }
        try {
            try {
                Resources resources2 = this.mSdkResources;
                typedArrayObtainTypedArray = resources2 != null ? resources2.obtainTypedArray(identifier) : null;
                if (typedArrayObtainTypedArray == null) {
                    return;
                }
                int length = strArray.length;
                if (length > typedArrayObtainTypedArray.length()) {
                    length = typedArrayObtainTypedArray.length();
                    Log.d(TAG, "str Array(" + strName + ") is smaller than input");
                }
                int length2 = strArray.length;
                for (int i = 0; i < length2; i++) {
                    if (i >= length) {
                        strArray[i] = " ";
                    } else {
                        strArray[i] = typedArrayObtainTypedArray.getString(i);
                    }
                }
                typedArrayObtainTypedArray.recycle();
                return;
            } catch (Resources.NotFoundException e) {
                e.printStackTrace();
                if (typedArrayObtainTypedArray != null) {
                    typedArrayObtainTypedArray.recycle();
                    return;
                }
                return;
            }
        } catch (Throwable th) {
            if (typedArrayObtainTypedArray != null) {
            }
            throw th;
        }
        if (typedArrayObtainTypedArray != null) {
            typedArrayObtainTypedArray.recycle();
        }
        throw th;
    }
}
