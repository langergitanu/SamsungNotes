package com.microsoft.identity.common.java.platform;

import com.microsoft.identity.common.java.logging.DiagnosticContext;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.util.StringUtil;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import lombok.NonNull;
import net.jcip.annotations.GuardedBy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class Device {
    protected static final String NOT_SET = "NOT_SET";
    private static final String TAG = "Device";
    private static IDeviceMetadata sDeviceMetadata;
    private static final ReentrantReadWriteLock sLock = new ReentrantReadWriteLock();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class PlatformIdParameters {
        public static final String BROKER_VERSION = "x-client-brkrver";
        public static final String CPU_PLATFORM = "x-client-CPU";
        public static final String DEVICE_MODEL = "x-client-DM";

        /* JADX INFO: renamed from: OS */
        public static final String f3604OS = "x-client-OS";
    }

    @GuardedBy("sLock")
    public static void clearDeviceMetadata() {
        ReentrantReadWriteLock reentrantReadWriteLock = sLock;
        reentrantReadWriteLock.writeLock().lock();
        try {
            sDeviceMetadata = null;
            reentrantReadWriteLock.writeLock().unlock();
        } catch (Throwable th) {
            sLock.writeLock().unlock();
            throw th;
        }
    }

    @NonNull
    @GuardedBy("sLock")
    public static String getCpu() {
        ReentrantReadWriteLock reentrantReadWriteLock = sLock;
        reentrantReadWriteLock.readLock().lock();
        try {
            IDeviceMetadata iDeviceMetadata = sDeviceMetadata;
            String cpu = iDeviceMetadata != null ? iDeviceMetadata.getCpu() : NOT_SET;
            reentrantReadWriteLock.readLock().unlock();
            return cpu;
        } catch (Throwable th) {
            sLock.readLock().unlock();
            throw th;
        }
    }

    @NonNull
    public static String getDeviceDisplayName() {
        return getManufacturer() + getModel();
    }

    @NonNull
    @GuardedBy("sLock")
    public static String getDeviceType() {
        ReentrantReadWriteLock reentrantReadWriteLock = sLock;
        reentrantReadWriteLock.readLock().lock();
        try {
            IDeviceMetadata iDeviceMetadata = sDeviceMetadata;
            String deviceType = iDeviceMetadata != null ? iDeviceMetadata.getDeviceType() : NOT_SET;
            reentrantReadWriteLock.readLock().unlock();
            return deviceType;
        } catch (Throwable th) {
            sLock.readLock().unlock();
            throw th;
        }
    }

    @NonNull
    @GuardedBy("sLock")
    public static String getManufacturer() {
        ReentrantReadWriteLock reentrantReadWriteLock = sLock;
        reentrantReadWriteLock.readLock().lock();
        try {
            IDeviceMetadata iDeviceMetadata = sDeviceMetadata;
            String manufacturer = iDeviceMetadata != null ? iDeviceMetadata.getManufacturer() : NOT_SET;
            reentrantReadWriteLock.readLock().unlock();
            return manufacturer;
        } catch (Throwable th) {
            sLock.readLock().unlock();
            throw th;
        }
    }

    @NonNull
    @GuardedBy("sLock")
    public static String getModel() {
        ReentrantReadWriteLock reentrantReadWriteLock = sLock;
        reentrantReadWriteLock.readLock().lock();
        try {
            IDeviceMetadata iDeviceMetadata = sDeviceMetadata;
            String deviceModel = iDeviceMetadata != null ? iDeviceMetadata.getDeviceModel() : NOT_SET;
            reentrantReadWriteLock.readLock().unlock();
            return deviceModel;
        } catch (Throwable th) {
            sLock.readLock().unlock();
            throw th;
        }
    }

    @NonNull
    @GuardedBy("sLock")
    public static String getOsForDrs() {
        ReentrantReadWriteLock reentrantReadWriteLock = sLock;
        reentrantReadWriteLock.readLock().lock();
        try {
            IDeviceMetadata iDeviceMetadata = sDeviceMetadata;
            String osForDrs = iDeviceMetadata != null ? iDeviceMetadata.getOsForDrs() : NOT_SET;
            reentrantReadWriteLock.readLock().unlock();
            return osForDrs;
        } catch (Throwable th) {
            sLock.readLock().unlock();
            throw th;
        }
    }

    @NonNull
    @GuardedBy("sLock")
    public static String getOsForEsts() {
        ReentrantReadWriteLock reentrantReadWriteLock = sLock;
        reentrantReadWriteLock.readLock().lock();
        try {
            IDeviceMetadata iDeviceMetadata = sDeviceMetadata;
            String osForEsts = iDeviceMetadata != null ? iDeviceMetadata.getOsForEsts() : NOT_SET;
            reentrantReadWriteLock.readLock().unlock();
            return osForEsts;
        } catch (Throwable th) {
            sLock.readLock().unlock();
            throw th;
        }
    }

    @NonNull
    @GuardedBy("sLock")
    public static Map<String, String> getPlatformIdParameters() {
        ReentrantReadWriteLock reentrantReadWriteLock = sLock;
        reentrantReadWriteLock.readLock().lock();
        try {
            HashMap map = new HashMap();
            IDeviceMetadata iDeviceMetadata = sDeviceMetadata;
            if (iDeviceMetadata != null) {
                map.put("x-client-CPU", iDeviceMetadata.getCpu());
                map.put("x-client-OS", sDeviceMetadata.getOsForEsts());
                map.put("x-client-DM", sDeviceMetadata.getDeviceModel());
            } else {
                map.put("x-client-CPU", NOT_SET);
                map.put("x-client-OS", NOT_SET);
                map.put("x-client-DM", NOT_SET);
            }
            Map<String, String> mapUnmodifiableMap = Collections.unmodifiableMap(map);
            reentrantReadWriteLock.readLock().unlock();
            return mapUnmodifiableMap;
        } catch (Throwable th) {
            sLock.readLock().unlock();
            throw th;
        }
    }

    @NonNull
    public static String getProductVersion() {
        String str = DiagnosticContext.INSTANCE.getRequestContext().get("x-client-Ver");
        if (!StringUtil.isNullOrEmpty(str)) {
            return str;
        }
        Logger.warn(TAG + ":getProductVersion", "Product version is not set.", null);
        return StringUtil.isNullOrEmpty("") ? "1.5.9-default" : "-default";
    }

    @GuardedBy("sLock")
    public static void setDeviceMetadata(@NonNull IDeviceMetadata iDeviceMetadata) {
        if (iDeviceMetadata == null) {
            throw new NullPointerException("deviceMetadata is marked non-null but is null");
        }
        ReentrantReadWriteLock reentrantReadWriteLock = sLock;
        reentrantReadWriteLock.writeLock().lock();
        try {
            sDeviceMetadata = iDeviceMetadata;
            reentrantReadWriteLock.writeLock().unlock();
        } catch (Throwable th) {
            sLock.writeLock().unlock();
            throw th;
        }
    }
}
