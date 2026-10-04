package io.grpc;

import androidx.glance.AbstractC2821a;
import com.google.common.base.Preconditions;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Internal
public final class InternalLogId {
    private static final AtomicLong idAlloc = new AtomicLong();

    @Nullable
    private final String details;

    /* JADX INFO: renamed from: id */
    private final long f8816id;
    private final String typeName;

    public InternalLogId(String str, String str2, long j) {
        Preconditions.checkNotNull(str, "typeName");
        Preconditions.checkArgument(!str.isEmpty(), "empty type");
        this.typeName = str;
        this.details = str2;
        this.f8816id = j;
    }

    public static InternalLogId allocate(Class<?> cls, @Nullable String str) {
        return allocate(getClassName(cls), str);
    }

    private static String getClassName(Class<?> cls) {
        String simpleName = ((Class) Preconditions.checkNotNull(cls, "type")).getSimpleName();
        return !simpleName.isEmpty() ? simpleName : cls.getName().substring(cls.getPackage().getName().length() + 1);
    }

    public static long getNextId() {
        return idAlloc.incrementAndGet();
    }

    @Nullable
    public String getDetails() {
        return this.details;
    }

    public long getId() {
        return this.f8816id;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public String shortName() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.typeName);
        sb.append("<");
        return AbstractC2821a.m2224o(sb, ">", this.f8816id);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(shortName());
        if (this.details != null) {
            sb.append(": (");
            sb.append(this.details);
            sb.append(PropertyUtils.MAPPED_DELIM2);
        }
        return sb.toString();
    }

    public static InternalLogId allocate(String str, @Nullable String str2) {
        return new InternalLogId(str, str2, getNextId());
    }
}
