package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@SourceDebugExtension({"SMAP\nBinaryVersion.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BinaryVersion.kt\norg/jetbrains/kotlin/metadata/deserialization/BinaryVersion\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,101:1\n5343#2,7:102\n*S KotlinDebug\n*F\n+ 1 BinaryVersion.kt\norg/jetbrains/kotlin/metadata/deserialization/BinaryVersion\n*L\n73#1:102,7\n*E\n"})
public abstract class BinaryVersion {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private final int major;
    private final int minor;

    @NotNull
    private final int[] numbers;
    private final int patch;

    @NotNull
    private final List<Integer> rest;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @SourceDebugExtension({"SMAP\nBinaryVersion.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BinaryVersion.kt\norg/jetbrains/kotlin/metadata/deserialization/BinaryVersion$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,101:1\n1557#2:102\n1628#2,3:103\n37#3,2:106\n*S KotlinDebug\n*F\n+ 1 BinaryVersion.kt\norg/jetbrains/kotlin/metadata/deserialization/BinaryVersion$Companion\n*L\n97#1:102\n97#1:103,3\n98#1:106,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public BinaryVersion(@NotNull int... numbers) {
        List<Integer> listEmptyList;
        Intrinsics.checkNotNullParameter(numbers, "numbers");
        this.numbers = numbers;
        Integer orNull = ArraysKt.getOrNull(numbers, 0);
        this.major = orNull != null ? orNull.intValue() : -1;
        Integer orNull2 = ArraysKt.getOrNull(numbers, 1);
        this.minor = orNull2 != null ? orNull2.intValue() : -1;
        Integer orNull3 = ArraysKt.getOrNull(numbers, 2);
        this.patch = orNull3 != null ? orNull3.intValue() : -1;
        if (numbers.length <= 3) {
            listEmptyList = CollectionsKt.emptyList();
        } else {
            if (numbers.length > 1024) {
                throw new IllegalArgumentException(AbstractC0000a.m13j(new StringBuilder("BinaryVersion with length more than 1024 are not supported. Provided length "), numbers.length, '.'));
            }
            listEmptyList = CollectionsKt.toList(ArraysKt.asList(numbers).subList(3, numbers.length));
        }
        this.rest = listEmptyList;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null || !Intrinsics.areEqual(getClass(), obj.getClass())) {
            return false;
        }
        BinaryVersion binaryVersion = (BinaryVersion) obj;
        return this.major == binaryVersion.major && this.minor == binaryVersion.minor && this.patch == binaryVersion.patch && Intrinsics.areEqual(this.rest, binaryVersion.rest);
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public int hashCode() {
        int i = this.major;
        int i2 = (i * 31) + this.minor + i;
        int i4 = (i2 * 31) + this.patch + i2;
        return this.rest.hashCode() + (i4 * 31) + i4;
    }

    public final boolean isAtLeast(@NotNull BinaryVersion version) {
        Intrinsics.checkNotNullParameter(version, "version");
        return isAtLeast(version.major, version.minor, version.patch);
    }

    public final boolean isAtMost(int i, int i2, int i4) {
        int i5 = this.major;
        if (i5 < i) {
            return true;
        }
        if (i5 > i) {
            return false;
        }
        int i6 = this.minor;
        if (i6 < i2) {
            return true;
        }
        return i6 <= i2 && this.patch <= i4;
    }

    public final boolean isCompatibleTo(@NotNull BinaryVersion ourVersion) {
        Intrinsics.checkNotNullParameter(ourVersion, "ourVersion");
        int i = this.major;
        return i == 0 ? ourVersion.major == 0 && this.minor == ourVersion.minor : i == ourVersion.major && this.minor <= ourVersion.minor;
    }

    @NotNull
    public final int[] toArray() {
        return this.numbers;
    }

    @NotNull
    public String toString() {
        int[] array = toArray();
        ArrayList arrayList = new ArrayList();
        int length = array.length;
        int iM1200a = 0;
        while (iM1200a < length) {
            int i = array[iM1200a];
            if (i == -1) {
                break;
            }
            iM1200a = AbstractC1038a.m1200a(i, iM1200a, 1, arrayList);
        }
        return arrayList.isEmpty() ? "unknown" : CollectionsKt.m13955n(arrayList, Extension.DOT, null, null, null, 62);
    }

    public final boolean isAtLeast(int i, int i2, int i4) {
        int i5 = this.major;
        if (i5 > i) {
            return true;
        }
        if (i5 < i) {
            return false;
        }
        int i6 = this.minor;
        if (i6 > i2) {
            return true;
        }
        return i6 >= i2 && this.patch >= i4;
    }
}
