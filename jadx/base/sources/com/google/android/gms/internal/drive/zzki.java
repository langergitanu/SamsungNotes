package com.google.android.gms.internal.drive;

import androidx.glance.AbstractC2821a;
import com.google.android.gms.internal.drive.zzjx;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes5.dex */
abstract class zzki<T extends zzjx> {
    private static final Logger logger = Logger.getLogger(zzjr.class.getName());
    private static String zzro = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";

    public static <T extends zzjx> T zza(Class<T> cls) {
        String strM2221l;
        ClassLoader classLoader = zzki.class.getClassLoader();
        if (cls.equals(zzjx.class)) {
            strM2221l = zzro;
        } else {
            if (!cls.getPackage().equals(zzki.class.getPackage())) {
                throw new IllegalArgumentException(cls.getName());
            }
            strM2221l = AbstractC2821a.m2221l(cls.getPackage().getName(), ".BlazeGenerated", cls.getSimpleName(), "Loader");
        }
        try {
            try {
                try {
                    try {
                        return cls.cast(((zzki) Class.forName(strM2221l, true, classLoader).getConstructor(null).newInstance(null)).zzcu());
                    } catch (InvocationTargetException e) {
                        throw new IllegalStateException(e);
                    }
                } catch (NoSuchMethodException e2) {
                    throw new IllegalStateException(e2);
                }
            } catch (IllegalAccessException e3) {
                throw new IllegalStateException(e3);
            } catch (InstantiationException e5) {
                throw new IllegalStateException(e5);
            }
        } catch (ClassNotFoundException unused) {
            Iterator it = ServiceLoader.load(zzki.class, classLoader).iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                try {
                    arrayList.add(cls.cast(((zzki) it.next()).zzcu()));
                } catch (ServiceConfigurationError e6) {
                    Logger logger2 = logger;
                    Level level = Level.SEVERE;
                    String simpleName = cls.getSimpleName();
                    logger2.logp(level, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", simpleName.length() != 0 ? "Unable to load ".concat(simpleName) : new String("Unable to load "), (Throwable) e6);
                }
            }
            if (arrayList.size() == 1) {
                return (T) arrayList.get(0);
            }
            if (arrayList.size() == 0) {
                return null;
            }
            try {
                return (T) cls.getMethod("combine", Collection.class).invoke(null, arrayList);
            } catch (IllegalAccessException e7) {
                throw new IllegalStateException(e7);
            } catch (NoSuchMethodException e8) {
                throw new IllegalStateException(e8);
            } catch (InvocationTargetException e9) {
                throw new IllegalStateException(e9);
            }
        }
    }

    public abstract T zzcu();
}
