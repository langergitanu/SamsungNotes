package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import androidx.compose.foundation.layout.AbstractC1038a;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class IncompatibleVersionErrorData<T> {
    private final T actualVersion;

    @NotNull
    private final ClassId classId;
    private final T compilerVersion;
    private final T expectedVersion;

    @NotNull
    private final String filePath;
    private final T languageVersion;

    public IncompatibleVersionErrorData(T t, T t2, T t5, T t6, @NotNull String filePath, @NotNull ClassId classId) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(classId, "classId");
        this.actualVersion = t;
        this.compilerVersion = t2;
        this.languageVersion = t5;
        this.expectedVersion = t6;
        this.filePath = filePath;
        this.classId = classId;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IncompatibleVersionErrorData)) {
            return false;
        }
        IncompatibleVersionErrorData incompatibleVersionErrorData = (IncompatibleVersionErrorData) obj;
        return Intrinsics.areEqual(this.actualVersion, incompatibleVersionErrorData.actualVersion) && Intrinsics.areEqual(this.compilerVersion, incompatibleVersionErrorData.compilerVersion) && Intrinsics.areEqual(this.languageVersion, incompatibleVersionErrorData.languageVersion) && Intrinsics.areEqual(this.expectedVersion, incompatibleVersionErrorData.expectedVersion) && Intrinsics.areEqual(this.filePath, incompatibleVersionErrorData.filePath) && Intrinsics.areEqual(this.classId, incompatibleVersionErrorData.classId);
    }

    public int hashCode() {
        T t = this.actualVersion;
        int iHashCode = (t == null ? 0 : t.hashCode()) * 31;
        T t2 = this.compilerVersion;
        int iHashCode2 = (iHashCode + (t2 == null ? 0 : t2.hashCode())) * 31;
        T t5 = this.languageVersion;
        int iHashCode3 = (iHashCode2 + (t5 == null ? 0 : t5.hashCode())) * 31;
        T t6 = this.expectedVersion;
        return this.classId.hashCode() + AbstractC1038a.m1202c((iHashCode3 + (t6 != null ? t6.hashCode() : 0)) * 31, 31, this.filePath);
    }

    @NotNull
    public String toString() {
        return "IncompatibleVersionErrorData(actualVersion=" + this.actualVersion + ", compilerVersion=" + this.compilerVersion + ", languageVersion=" + this.languageVersion + ", expectedVersion=" + this.expectedVersion + ", filePath=" + this.filePath + ", classId=" + this.classId + PropertyUtils.MAPPED_DELIM2;
    }
}
