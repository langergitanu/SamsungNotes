package io.netty.util;

import androidx.compose.runtime.AbstractC1974b;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class ResourceLeakDetector<T> {
    private static final Level DEFAULT_LEVEL;
    private static final int DEFAULT_SAMPLING_INTERVAL = 128;
    private static final int DEFAULT_TARGET_RECORDS = 4;
    private static final String PROP_LEVEL = "io.netty.leakDetection.level";
    private static final String PROP_LEVEL_OLD = "io.netty.leakDetectionLevel";
    private static final String PROP_SAMPLING_INTERVAL = "io.netty.leakDetection.samplingInterval";
    private static final String PROP_TARGET_RECORDS = "io.netty.leakDetection.targetRecords";
    static final int SAMPLING_INTERVAL;
    private static final int TARGET_RECORDS;
    private static final AtomicReference<String[]> excludedMethods;
    private static Level level;
    private static final InternalLogger logger;
    private final Set<DefaultResourceLeak<?>> allLeaks;
    private final ReferenceQueue<Object> refQueue;
    private final Set<String> reportedLeaks;
    private final String resourceType;
    private final int samplingInterval;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class DefaultResourceLeak<T> extends WeakReference<Object> implements ResourceLeakTracker<T>, ResourceLeak {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Set<DefaultResourceLeak<?>> allLeaks;
        private volatile int droppedRecords;
        private volatile TraceRecord head;
        private final int trackedHash;
        private static final AtomicReferenceFieldUpdater<DefaultResourceLeak<?>, TraceRecord> headUpdater = AtomicReferenceFieldUpdater.newUpdater(DefaultResourceLeak.class, TraceRecord.class, "head");
        private static final AtomicIntegerFieldUpdater<DefaultResourceLeak<?>> droppedRecordsUpdater = AtomicIntegerFieldUpdater.newUpdater(DefaultResourceLeak.class, "droppedRecords");

        public DefaultResourceLeak(Object obj, ReferenceQueue<Object> referenceQueue, Set<DefaultResourceLeak<?>> set, Object obj2) {
            super(obj, referenceQueue);
            this.trackedHash = System.identityHashCode(obj);
            set.add(this);
            headUpdater.set(this, obj2 == null ? new TraceRecord(TraceRecord.BOTTOM) : new TraceRecord(TraceRecord.BOTTOM, obj2));
            this.allLeaks = set;
        }

        private String generateReport(TraceRecord traceRecord) {
            if (traceRecord == null) {
                return "";
            }
            int i = droppedRecordsUpdater.get(this);
            int i2 = 1;
            int i4 = traceRecord.pos + 1;
            StringBuilder sb = new StringBuilder(i4 * 2048);
            String str = StringUtil.NEWLINE;
            sb.append(str);
            sb.append("Recent access records: ");
            sb.append(str);
            HashSet hashSet = new HashSet(i4);
            int i5 = 0;
            while (traceRecord != TraceRecord.BOTTOM) {
                String string = traceRecord.toString();
                if (!hashSet.add(string)) {
                    i5++;
                } else if (traceRecord.next == TraceRecord.BOTTOM) {
                    sb.append("Created at:");
                    sb.append(StringUtil.NEWLINE);
                    sb.append(string);
                } else {
                    sb.append('#');
                    sb.append(i2);
                    sb.append(':');
                    sb.append(StringUtil.NEWLINE);
                    sb.append(string);
                    i2++;
                }
                traceRecord = traceRecord.next;
            }
            if (i5 > 0) {
                AbstractC1974b.m1330w(i5, ": ", " leak records were discarded because they were duplicates", sb);
                sb.append(StringUtil.NEWLINE);
            }
            if (i > 0) {
                sb.append(": ");
                sb.append(i);
                sb.append(" leak records were discarded because the leak record count is targeted to ");
                sb.append(ResourceLeakDetector.TARGET_RECORDS);
                sb.append(". Use system property io.netty.leakDetection.targetRecords to increase the limit.");
                sb.append(StringUtil.NEWLINE);
            }
            sb.setLength(sb.length() - StringUtil.NEWLINE.length());
            return sb.toString();
        }

        private static void reachabilityFence0(Object obj) {
            if (obj != null) {
                synchronized (obj) {
                }
            }
        }

        private void record0(Object obj) {
            TraceRecord traceRecord;
            if (ResourceLeakDetector.TARGET_RECORDS > 0) {
                while (true) {
                    AtomicReferenceFieldUpdater<DefaultResourceLeak<?>, TraceRecord> atomicReferenceFieldUpdater = headUpdater;
                    TraceRecord traceRecord2 = atomicReferenceFieldUpdater.get(this);
                    if (traceRecord2 == null) {
                        return;
                    }
                    int i = traceRecord2.pos + 1;
                    boolean z = false;
                    if (i >= ResourceLeakDetector.TARGET_RECORDS) {
                        boolean z2 = PlatformDependent.threadLocalRandom().nextInt(1 << Math.min(i - ResourceLeakDetector.TARGET_RECORDS, 30)) != 0;
                        traceRecord = z2 ? traceRecord2.next : traceRecord2;
                        z = z2;
                    } else {
                        traceRecord = traceRecord2;
                    }
                    TraceRecord traceRecord3 = obj != null ? new TraceRecord(traceRecord, obj) : new TraceRecord(traceRecord);
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, traceRecord2, traceRecord3)) {
                        if (atomicReferenceFieldUpdater.get(this) != traceRecord2) {
                            break;
                        }
                    }
                    if (z) {
                        droppedRecordsUpdater.incrementAndGet(this);
                        return;
                    }
                    return;
                }
            }
        }

        @Override // io.netty.util.ResourceLeak
        public boolean close() {
            if (!this.allLeaks.remove(this)) {
                return false;
            }
            clear();
            headUpdater.set(this, null);
            return true;
        }

        public boolean dispose() {
            clear();
            return this.allLeaks.remove(this);
        }

        public String getReportAndClearRecords() {
            return generateReport(headUpdater.getAndSet(this, null));
        }

        @Override // io.netty.util.ResourceLeakTracker, io.netty.util.ResourceLeak
        public void record() {
            record0(null);
        }

        public String toString() {
            return generateReport(headUpdater.get(this));
        }

        @Override // io.netty.util.ResourceLeakTracker, io.netty.util.ResourceLeak
        public void record(Object obj) {
            record0(obj);
        }

        @Override // io.netty.util.ResourceLeakTracker
        public boolean close(T t) {
            try {
                return close();
            } finally {
                reachabilityFence0(t);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Level {
        DISABLED,
        SIMPLE,
        ADVANCED,
        PARANOID;

        public static Level parseLevel(String str) {
            String strTrim = str.trim();
            for (Level level : values()) {
                if (strTrim.equalsIgnoreCase(level.name()) || strTrim.equals(String.valueOf(level.ordinal()))) {
                    return level;
                }
            }
            return ResourceLeakDetector.DEFAULT_LEVEL;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TraceRecord extends Throwable {
        private static final TraceRecord BOTTOM = new TraceRecord() { // from class: io.netty.util.ResourceLeakDetector.TraceRecord.1
            private static final long serialVersionUID = 7396077602074694571L;

            @Override // java.lang.Throwable
            public Throwable fillInStackTrace() {
                return this;
            }
        };
        private static final long serialVersionUID = 6065153674892850720L;
        private final String hintString;
        private final TraceRecord next;
        private final int pos;

        @Override // java.lang.Throwable
        public String toString() {
            int i;
            StringBuilder sb = new StringBuilder(2048);
            if (this.hintString != null) {
                sb.append("\tHint: ");
                sb.append(this.hintString);
                sb.append(StringUtil.NEWLINE);
            }
            StackTraceElement[] stackTrace = getStackTrace();
            for (int i2 = 3; i2 < stackTrace.length; i2++) {
                StackTraceElement stackTraceElement = stackTrace[i2];
                String[] strArr = (String[]) ResourceLeakDetector.excludedMethods.get();
                while (true) {
                    if (i >= strArr.length) {
                        sb.append('\t');
                        sb.append(stackTraceElement.toString());
                        sb.append(StringUtil.NEWLINE);
                        break;
                    }
                    i = (strArr[i].equals(stackTraceElement.getClassName()) && strArr[i + 1].equals(stackTraceElement.getMethodName())) ? 0 : i + 2;
                }
            }
            return sb.toString();
        }

        public TraceRecord(TraceRecord traceRecord, Object obj) {
            this.hintString = obj instanceof ResourceLeakHint ? ((ResourceLeakHint) obj).toHintString() : obj.toString();
            this.next = traceRecord;
            this.pos = traceRecord.pos + 1;
        }

        public TraceRecord(TraceRecord traceRecord) {
            this.hintString = null;
            this.next = traceRecord;
            this.pos = traceRecord.pos + 1;
        }

        private TraceRecord() {
            this.hintString = null;
            this.next = null;
            this.pos = -1;
        }
    }

    static {
        Level level2 = Level.SIMPLE;
        DEFAULT_LEVEL = level2;
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) ResourceLeakDetector.class);
        logger = internalLoggerFactory;
        boolean z = false;
        if (SystemPropertyUtil.get("io.netty.noResourceLeakDetection") != null) {
            z = SystemPropertyUtil.getBoolean("io.netty.noResourceLeakDetection", false);
            internalLoggerFactory.debug("-Dio.netty.noResourceLeakDetection: {}", Boolean.valueOf(z));
            internalLoggerFactory.warn("-Dio.netty.noResourceLeakDetection is deprecated. Use '-D{}={}' instead.", PROP_LEVEL, Level.DISABLED.name().toLowerCase());
        }
        if (z) {
            level2 = Level.DISABLED;
        }
        Level level3 = Level.parseLevel(SystemPropertyUtil.get(PROP_LEVEL, SystemPropertyUtil.get(PROP_LEVEL_OLD, level2.name())));
        int i = SystemPropertyUtil.getInt(PROP_TARGET_RECORDS, 4);
        TARGET_RECORDS = i;
        SAMPLING_INTERVAL = SystemPropertyUtil.getInt(PROP_SAMPLING_INTERVAL, 128);
        level = level3;
        if (internalLoggerFactory.isDebugEnabled()) {
            internalLoggerFactory.debug("-D{}: {}", PROP_LEVEL, level3.name().toLowerCase());
            internalLoggerFactory.debug("-D{}: {}", PROP_TARGET_RECORDS, Integer.valueOf(i));
        }
        excludedMethods = new AtomicReference<>(EmptyArrays.EMPTY_STRINGS);
    }

    @Deprecated
    public ResourceLeakDetector(Class<?> cls) {
        this(StringUtil.simpleClassName(cls));
    }

    public static void addExclusions(Class cls, String... strArr) {
        HashSet hashSet = new HashSet(Arrays.asList(strArr));
        Method[] declaredMethods = cls.getDeclaredMethods();
        int length = declaredMethods.length;
        for (int i = 0; i < length && (!hashSet.remove(declaredMethods[i].getName()) || !hashSet.isEmpty()); i++) {
        }
        if (!hashSet.isEmpty()) {
            throw new IllegalArgumentException("Can't find '" + hashSet + "' in " + cls.getName());
        }
        while (true) {
            String[] strArr2 = excludedMethods.get();
            String[] strArr3 = (String[]) Arrays.copyOf(strArr2, (strArr.length * 2) + strArr2.length);
            for (int i2 = 0; i2 < strArr.length; i2++) {
                int i4 = i2 * 2;
                strArr3[strArr2.length + i4] = cls.getName();
                strArr3[strArr2.length + i4 + 1] = strArr[i2];
            }
            AtomicReference<String[]> atomicReference = excludedMethods;
            while (!atomicReference.compareAndSet(strArr2, strArr3)) {
                if (atomicReference.get() != strArr2) {
                    break;
                }
            }
            return;
        }
    }

    private void clearRefQueue() {
        while (true) {
            DefaultResourceLeak defaultResourceLeak = (DefaultResourceLeak) this.refQueue.poll();
            if (defaultResourceLeak == null) {
                return;
            } else {
                defaultResourceLeak.dispose();
            }
        }
    }

    public static Level getLevel() {
        return level;
    }

    public static boolean isEnabled() {
        return getLevel().ordinal() > Level.DISABLED.ordinal();
    }

    private void reportLeak() {
        if (!needReport()) {
            clearRefQueue();
            return;
        }
        while (true) {
            DefaultResourceLeak defaultResourceLeak = (DefaultResourceLeak) this.refQueue.poll();
            if (defaultResourceLeak == null) {
                return;
            }
            if (defaultResourceLeak.dispose()) {
                String reportAndClearRecords = defaultResourceLeak.getReportAndClearRecords();
                if (this.reportedLeaks.add(reportAndClearRecords)) {
                    if (reportAndClearRecords.isEmpty()) {
                        reportUntracedLeak(this.resourceType);
                    } else {
                        reportTracedLeak(this.resourceType, reportAndClearRecords);
                    }
                }
            }
        }
    }

    @Deprecated
    public static void setEnabled(boolean z) {
        setLevel(z ? Level.SIMPLE : Level.DISABLED);
    }

    public static void setLevel(Level level2) {
        level = (Level) ObjectUtil.checkNotNull(level2, "level");
    }

    private DefaultResourceLeak track0(T t) {
        Level level2 = level;
        if (level2 == Level.DISABLED) {
            return null;
        }
        if (level2.ordinal() >= Level.PARANOID.ordinal()) {
            reportLeak();
            return new DefaultResourceLeak(t, this.refQueue, this.allLeaks, getInitialHint(this.resourceType));
        }
        if (PlatformDependent.threadLocalRandom().nextInt(this.samplingInterval) != 0) {
            return null;
        }
        reportLeak();
        return new DefaultResourceLeak(t, this.refQueue, this.allLeaks, getInitialHint(this.resourceType));
    }

    public Object getInitialHint(String str) {
        return null;
    }

    public boolean needReport() {
        return logger.isErrorEnabled();
    }

    @Deprecated
    public final ResourceLeak open(T t) {
        return track0(t);
    }

    public void reportTracedLeak(String str, String str2) {
        logger.error("LEAK: {}.release() was not called before it's garbage-collected. See https://netty.io/wiki/reference-counted-objects.html for more information.{}", str, str2);
    }

    public void reportUntracedLeak(String str) {
        logger.error("LEAK: {}.release() was not called before it's garbage-collected. Enable advanced leak reporting to find out where the leak occurred. To enable advanced leak reporting, specify the JVM option '-D{}={}' or call {}.setLevel() See https://netty.io/wiki/reference-counted-objects.html for more information.", str, PROP_LEVEL, Level.ADVANCED.name().toLowerCase(), StringUtil.simpleClassName(this));
    }

    public final ResourceLeakTracker<T> track(T t) {
        return track0(t);
    }

    @Deprecated
    public ResourceLeakDetector(String str) {
        this(str, 128, Long.MAX_VALUE);
    }

    @Deprecated
    public ResourceLeakDetector(Class<?> cls, int i, long j) {
        this(cls, i);
    }

    public ResourceLeakDetector(Class<?> cls, int i) {
        this(StringUtil.simpleClassName(cls), i, Long.MAX_VALUE);
    }

    @Deprecated
    public ResourceLeakDetector(String str, int i, long j) {
        this.allLeaks = Collections.newSetFromMap(new ConcurrentHashMap());
        this.refQueue = new ReferenceQueue<>();
        this.reportedLeaks = Collections.newSetFromMap(new ConcurrentHashMap());
        this.resourceType = (String) ObjectUtil.checkNotNull(str, "resourceType");
        this.samplingInterval = i;
    }

    @Deprecated
    public void reportInstancesLeak(String str) {
    }
}
