package com.google.android.play.core.internal;

import android.content.ComponentName;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/* JADX INFO: renamed from: com.google.android.play.core.internal.bq */
/* JADX INFO: loaded from: classes5.dex */
public final class C5195bq {
    /* JADX INFO: renamed from: a */
    public static <T> C5194bp<T> m3934a(Object obj, String str, Class<T> cls) {
        return new C5194bp<>(obj, m3939a(obj, str), cls);
    }

    /* JADX INFO: renamed from: b */
    public static <T> C5194bp m3948b(Object obj, String str, Class<T> cls) {
        return new C5194bp(obj, m3939a(obj, str), cls, null);
    }

    /* JADX INFO: renamed from: a */
    public static <R, P0> R m3935a(Class cls, Class<R> cls2, Class<P0> cls3, P0 p0) {
        try {
            return cls2.cast(m3940a((Class<?>) cls, "isDexOptNeeded", (Class<?>[]) new Class[]{cls3}).invoke(null, p0));
        } catch (Exception e) {
            throw new C5196br(AbstractC2322a.m1621k("Failed to invoke static method isDexOptNeeded on type ", cls), e);
        }
    }

    /* JADX INFO: renamed from: b */
    public static <T> void m3949b(T t) {
        if (t == null) {
            throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
        }
    }

    /* JADX INFO: renamed from: a */
    public static <R, P0, P1> R m3936a(Class cls, Class<R> cls2, Class<P0> cls3, P0 p0, Class<P1> cls4, P1 p1) {
        try {
            return cls2.cast(m3940a((Class<?>) cls, "optimizedPathFor", (Class<?>[]) new Class[]{cls3, cls4}).invoke(null, p0, p1));
        } catch (Exception e) {
            throw new C5196br(AbstractC2322a.m1621k("Failed to invoke static method optimizedPathFor on type ", cls), e);
        }
    }

    /* JADX INFO: renamed from: a */
    public static <R, P0> R m3937a(Object obj, String str, Class<R> cls, Class<P0> cls2, P0 p0) {
        try {
            return cls.cast(m3941a(obj, str, (Class<?>[]) new Class[]{cls2}).invoke(obj, p0));
        } catch (Exception e) {
            throw new C5196br("Failed to invoke method " + str + " on an object of type " + obj.getClass(), e);
        }
    }

    /* JADX INFO: renamed from: a */
    public static <R, P0, P1, P2> R m3938a(Object obj, String str, Class<R> cls, Class<P0> cls2, P0 p0, Class<P1> cls3, P1 p1, Class<P2> cls4, P2 p2) {
        try {
            return cls.cast(m3941a(obj, str, (Class<?>[]) new Class[]{cls2, cls3, cls4}).invoke(obj, p0, p1, p2));
        } catch (Exception e) {
            throw new C5196br("Failed to invoke method " + str + " on an object of type " + obj.getClass(), e);
        }
    }

    /* JADX INFO: renamed from: a */
    private static Field m3939a(Object obj, String str) {
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
            }
        }
        throw new C5196br(AbstractC0541b.m774p("Failed to find a field named ", str, " on an object of instance ", obj.getClass().getName()));
    }

    /* JADX INFO: renamed from: a */
    private static Method m3940a(Class<?> cls, String str, Class<?>... clsArr) {
        for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Method declaredMethod = superclass.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
            }
        }
        throw new C5196br(String.format("Could not find a method named %s with parameters %s in type %s", str, Arrays.asList(clsArr), cls));
    }

    /* JADX INFO: renamed from: a */
    private static Method m3941a(Object obj, String str, Class<?>... clsArr) {
        return m3940a(obj.getClass(), str, clsArr);
    }

    /* JADX INFO: renamed from: a */
    public static void m3942a(PackageManager packageManager, ComponentName componentName, int i) {
        ComponentInfo componentInfo;
        int componentEnabledSetting = packageManager.getComponentEnabledSetting(componentName);
        if (componentEnabledSetting != 1) {
            if (componentEnabledSetting != 2) {
                String packageName = componentName.getPackageName();
                String className = componentName.getClassName();
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(packageName, i | 512);
                    ComponentInfo[][] componentInfoArr = {packageInfo.activities, packageInfo.services, packageInfo.providers};
                    int i2 = 0;
                    loop0: while (true) {
                        if (i2 >= 3) {
                            componentInfo = null;
                            break;
                        }
                        ComponentInfo[] componentInfoArr2 = componentInfoArr[i2];
                        if (componentInfoArr2 != null) {
                            int length = componentInfoArr2.length;
                            for (int i4 = 0; i4 < length; i4++) {
                                componentInfo = componentInfoArr2[i4];
                                if (componentInfo.name.equals(className)) {
                                    break loop0;
                                }
                            }
                        }
                        i2++;
                    }
                    if (componentInfo != null) {
                        if (componentInfo.isEnabled()) {
                            return;
                        }
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m3943a(AbstractC5206ca abstractC5206ca, InputStream inputStream, OutputStream outputStream, long j) throws Throwable {
        OutputStream outputStream2;
        long j2;
        DataInputStream dataInputStream;
        AbstractC5206ca abstractC5206ca2;
        long unsignedShort;
        int unsignedShort2;
        byte[] bArr = new byte[16384];
        DataInputStream dataInputStream2 = new DataInputStream(new BufferedInputStream(inputStream, 4096));
        int i = dataInputStream2.readInt();
        if (i != -771763713) {
            String str = String.format("%x", Integer.valueOf(i));
            throw new C5204bz(str.length() != 0 ? "Unexpected magic=".concat(str) : new String("Unexpected magic="));
        }
        int i2 = dataInputStream2.read();
        if (i2 != 4) {
            throw new C5204bz(AbstractC4539a.m3197g(30, i2, "Unexpected version="));
        }
        long j3 = 0;
        while (true) {
            long j5 = j - j3;
            try {
                int unsignedShort3 = dataInputStream2.read();
                if (unsignedShort3 == -1) {
                    throw new IOException("Patch file overrun");
                }
                if (unsignedShort3 == 0) {
                    outputStream.flush();
                    return;
                }
                outputStream2 = outputStream;
                switch (unsignedShort3) {
                    case 247:
                        unsignedShort3 = dataInputStream2.readUnsignedShort();
                        j2 = j5;
                        m3947a(bArr, dataInputStream2, outputStream2, unsignedShort3, j2);
                        j3 += (long) unsignedShort3;
                        outputStream = outputStream2;
                        break;
                    case 248:
                        unsignedShort3 = dataInputStream2.readInt();
                        j2 = j5;
                        m3947a(bArr, dataInputStream2, outputStream2, unsignedShort3, j2);
                        j3 += (long) unsignedShort3;
                        outputStream = outputStream2;
                        break;
                    case 249:
                        DataInputStream dataInputStream3 = dataInputStream2;
                        AbstractC5206ca abstractC5206ca3 = abstractC5206ca;
                        long unsignedShort4 = dataInputStream3.readUnsignedShort();
                        int i4 = dataInputStream3.read();
                        if (i4 == -1) {
                            throw new IOException("Unexpected end of patch");
                        }
                        m3946a(bArr, abstractC5206ca3, outputStream2, unsignedShort4, i4, j5);
                        abstractC5206ca = abstractC5206ca3;
                        dataInputStream2 = dataInputStream3;
                        unsignedShort3 = i4;
                        j3 += (long) unsignedShort3;
                        outputStream = outputStream2;
                        break;
                        break;
                    case 250:
                        dataInputStream = dataInputStream2;
                        abstractC5206ca2 = abstractC5206ca;
                        unsignedShort = dataInputStream.readUnsignedShort();
                        unsignedShort2 = dataInputStream.readUnsignedShort();
                        m3946a(bArr, abstractC5206ca2, outputStream2, unsignedShort, unsignedShort2, j5);
                        abstractC5206ca = abstractC5206ca2;
                        unsignedShort3 = unsignedShort2;
                        dataInputStream2 = dataInputStream;
                        j3 += (long) unsignedShort3;
                        outputStream = outputStream2;
                        break;
                    case 251:
                        dataInputStream = dataInputStream2;
                        abstractC5206ca2 = abstractC5206ca;
                        unsignedShort = dataInputStream.readUnsignedShort();
                        unsignedShort2 = dataInputStream.readInt();
                        m3946a(bArr, abstractC5206ca2, outputStream2, unsignedShort, unsignedShort2, j5);
                        abstractC5206ca = abstractC5206ca2;
                        unsignedShort3 = unsignedShort2;
                        dataInputStream2 = dataInputStream;
                        j3 += (long) unsignedShort3;
                        outputStream = outputStream2;
                        break;
                    case 252:
                        dataInputStream = dataInputStream2;
                        abstractC5206ca2 = abstractC5206ca;
                        unsignedShort = dataInputStream.readInt();
                        unsignedShort2 = dataInputStream.read();
                        if (unsignedShort2 == -1) {
                            throw new IOException("Unexpected end of patch");
                        }
                        m3946a(bArr, abstractC5206ca2, outputStream2, unsignedShort, unsignedShort2, j5);
                        abstractC5206ca = abstractC5206ca2;
                        unsignedShort3 = unsignedShort2;
                        dataInputStream2 = dataInputStream;
                        j3 += (long) unsignedShort3;
                        outputStream = outputStream2;
                        break;
                        break;
                    case 253:
                        dataInputStream = dataInputStream2;
                        abstractC5206ca2 = abstractC5206ca;
                        unsignedShort = dataInputStream.readInt();
                        unsignedShort2 = dataInputStream.readUnsignedShort();
                        m3946a(bArr, abstractC5206ca2, outputStream2, unsignedShort, unsignedShort2, j5);
                        abstractC5206ca = abstractC5206ca2;
                        unsignedShort3 = unsignedShort2;
                        dataInputStream2 = dataInputStream;
                        j3 += (long) unsignedShort3;
                        outputStream = outputStream2;
                        break;
                    case JPEG.COM /* 254 */:
                        dataInputStream = dataInputStream2;
                        abstractC5206ca2 = abstractC5206ca;
                        unsignedShort = dataInputStream.readInt();
                        unsignedShort2 = dataInputStream.readInt();
                        m3946a(bArr, abstractC5206ca2, outputStream2, unsignedShort, unsignedShort2, j5);
                        abstractC5206ca = abstractC5206ca2;
                        unsignedShort3 = unsignedShort2;
                        dataInputStream2 = dataInputStream;
                        j3 += (long) unsignedShort3;
                        outputStream = outputStream2;
                        break;
                    case 255:
                        dataInputStream = dataInputStream2;
                        unsignedShort = dataInputStream.readLong();
                        unsignedShort2 = dataInputStream.readInt();
                        abstractC5206ca2 = abstractC5206ca;
                        m3946a(bArr, abstractC5206ca2, outputStream2, unsignedShort, unsignedShort2, j5);
                        abstractC5206ca = abstractC5206ca2;
                        unsignedShort3 = unsignedShort2;
                        dataInputStream2 = dataInputStream;
                        j3 += (long) unsignedShort3;
                        outputStream = outputStream2;
                        break;
                    default:
                        try {
                            m3947a(bArr, dataInputStream2, outputStream2, unsignedShort3, j5);
                            dataInputStream = dataInputStream2;
                            dataInputStream2 = dataInputStream;
                            j3 += (long) unsignedShort3;
                            outputStream = outputStream2;
                        } catch (Throwable th) {
                            th = th;
                            Throwable th2 = th;
                            outputStream2.flush();
                            throw th2;
                        }
                        break;
                }
            } catch (Throwable th3) {
                th = th3;
                outputStream2 = outputStream;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static <T> void m3944a(T t) {
        t.getClass();
    }

    /* JADX INFO: renamed from: a */
    public static <T> void m3945a(T t, Class<T> cls) {
        if (t == null) {
            throw new IllegalStateException(String.valueOf(cls.getCanonicalName()).concat(" must be set"));
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m3946a(byte[] bArr, AbstractC5206ca abstractC5206ca, OutputStream outputStream, long j, int i, long j2) throws IOException {
        InputStream inputStreamM3974b;
        if (i < 0) {
            throw new IOException("copyLength negative");
        }
        if (j < 0) {
            throw new IOException("inputOffset negative");
        }
        long j3 = i;
        if (j3 > j2) {
            throw new IOException("Output length overrun");
        }
        try {
            inputStreamM3974b = new C5207cb(abstractC5206ca, j, j3).m3974b();
        } catch (EOFException e) {
            throw new IOException("patch underrun", e);
        }
        while (i > 0) {
            try {
                int iMin = Math.min(i, 16384);
                int i2 = 0;
                while (i2 < iMin) {
                    int i4 = inputStreamM3974b.read(bArr, i2, iMin - i2);
                    if (i4 == -1) {
                        throw new IOException("truncated input stream");
                    }
                    i2 += i4;
                    throw new IOException("patch underrun", e);
                }
                outputStream.write(bArr, 0, iMin);
                i -= iMin;
            } finally {
            }
        }
        if (inputStreamM3974b != null) {
            inputStreamM3974b.close();
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m3947a(byte[] bArr, DataInputStream dataInputStream, OutputStream outputStream, int i, long j) throws IOException {
        if (i < 0) {
            throw new IOException("copyLength negative");
        }
        if (i > j) {
            throw new IOException("Output length overrun");
        }
        while (i > 0) {
            try {
                int iMin = Math.min(i, 16384);
                dataInputStream.readFully(bArr, 0, iMin);
                outputStream.write(bArr, 0, iMin);
                i -= iMin;
            } catch (EOFException unused) {
                throw new IOException("patch underrun");
            }
        }
    }
}
