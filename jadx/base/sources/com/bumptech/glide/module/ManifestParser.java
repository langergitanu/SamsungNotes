package com.bumptech.glide.module;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class ManifestParser {
    private static final String GLIDE_MODULE_VALUE = "GlideModule";
    private static final String TAG = "ManifestParser";
    private final Context context;

    public ManifestParser(Context context) {
        this.context = context;
    }

    @Nullable
    private ApplicationInfo getOurApplicationInfo() {
        return this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128);
    }

    private static GlideModule parseModule(String str) {
        try {
            Class<?> cls = Class.forName(str);
            Object objNewInstance = null;
            try {
                objNewInstance = cls.getDeclaredConstructor(null).newInstance(null);
            } catch (IllegalAccessException e) {
                throwInstantiateGlideModuleException(cls, e);
            } catch (InstantiationException e2) {
                throwInstantiateGlideModuleException(cls, e2);
            } catch (NoSuchMethodException e3) {
                throwInstantiateGlideModuleException(cls, e3);
            } catch (InvocationTargetException e5) {
                throwInstantiateGlideModuleException(cls, e5);
            }
            if (objNewInstance instanceof GlideModule) {
                return (GlideModule) objNewInstance;
            }
            throw new RuntimeException(AbstractC0541b.m769k(objNewInstance, "Expected instanceof GlideModule, but found: "));
        } catch (ClassNotFoundException e6) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e6);
        }
    }

    private static void throwInstantiateGlideModuleException(Class<?> cls, Exception exc) {
        throw new RuntimeException(AbstractC2322a.m1621k("Unable to instantiate GlideModule implementation for ", cls), exc);
    }

    public List<GlideModule> parse() {
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "Loading Glide modules");
        }
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo ourApplicationInfo = getOurApplicationInfo();
            if (ourApplicationInfo != null && ourApplicationInfo.metaData != null) {
                if (Log.isLoggable(TAG, 2)) {
                    Log.v(TAG, "Got app info metadata: " + ourApplicationInfo.metaData);
                }
                for (String str : ourApplicationInfo.metaData.keySet()) {
                    if (GLIDE_MODULE_VALUE.equals(ourApplicationInfo.metaData.get(str))) {
                        arrayList.add(parseModule(str));
                        if (Log.isLoggable(TAG, 3)) {
                            Log.d(TAG, "Loaded Glide module: " + str);
                        }
                    }
                }
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Finished loading Glide modules");
                    return arrayList;
                }
            } else if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Got null app info metadata");
                return arrayList;
            }
        } catch (PackageManager.NameNotFoundException e) {
            if (Log.isLoggable(TAG, 6)) {
                Log.e(TAG, "Failed to parse glide modules", e);
            }
        }
        return arrayList;
    }
}
