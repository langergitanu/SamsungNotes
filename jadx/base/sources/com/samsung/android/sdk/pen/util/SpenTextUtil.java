package com.samsung.android.sdk.pen.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.Log;
import com.samsung.android.sdk.pen.Spen;
import com.samsung.android.spen.libwrapper.TypefaceWrapper;
import com.samsung.android.spen.libwrapper.utils.PlatformException;
import java.util.Hashtable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0018\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/util/SpenTextUtil;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mSdkResources", "Landroid/content/res/Resources;", "setString", "", "strName", "getFontPathFlipFont", "typefaceIndex", "", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenTextUtil {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Hashtable<String, Typeface> mTyfaceMap = new Hashtable<>();

    @Nullable
    private Resources mSdkResources;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0006R\u001e\u0010\u0004\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/util/SpenTextUtil$Companion;", "", "<init>", "()V", "mTyfaceMap", "Ljava/util/Hashtable;", "", "Landroid/graphics/Typeface;", "getTyface", "tyfacePath", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final Typeface getTyface(@Nullable String tyfacePath) {
            Typeface typeface;
            synchronized (SpenTextUtil.mTyfaceMap) {
                if (!SpenTextUtil.mTyfaceMap.containsKey(tyfacePath)) {
                    try {
                    } catch (Exception unused) {
                        return null;
                    }
                }
                typeface = (Typeface) SpenTextUtil.mTyfaceMap.get(tyfacePath);
            }
            return typeface;
        }

        private Companion() {
        }
    }

    public SpenTextUtil(@NotNull Context context) {
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

    @Nullable
    public final String getFontPathFlipFont(@NotNull Context context, int typefaceIndex) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            return TypefaceWrapper.create(context).getFontPathOfCurrentFontStyle(context, typefaceIndex);
        } catch (PlatformException e) {
            Log.e("SpenUtilText", "Exception is occurred with reflection of getFontPathFlipFont.");
            e.printStackTrace();
            return null;
        }
    }

    @NotNull
    public final String setString(@Nullable String strName) {
        try {
            Resources resources = this.mSdkResources;
            int identifier = resources != null ? resources.getIdentifier(strName, "string", Spen.INSTANCE.getSpenPackageName()) : 0;
            if (identifier != 0) {
                Resources resources2 = this.mSdkResources;
                return String.valueOf(resources2 != null ? resources2.getString(identifier) : null);
            }
            Log.e("SpenUtilText", "setString() strID is zero = " + strName);
            return " ";
        } catch (Resources.NotFoundException e) {
            Log.e("SpenUtilText", "setString() not found = " + strName);
            e.printStackTrace();
            return " ";
        } catch (NullPointerException e2) {
            Log.e("SpenUtilText", "setString() null point = " + strName);
            e2.printStackTrace();
            return " ";
        }
    }
}
