package kotlin.uuid;

import java.io.Serializable;
import java.util.Comparator;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.UByteArray;
import kotlin.ULong;
import kotlin.comparisons.ComparisonsKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@SinceKotlin(version = "2.0")
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u0003:\u0001*B\u0019\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\\\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u001026\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u0002H\u00100\u0012H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0015J\\\u0010\u0016\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u001026\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u0002H\u00100\u0012H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0015J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0007J\u0006\u0010\u001b\u001a\u00020\u0019J\u0006\u0010\u001c\u001a\u00020\u001dJ\u000f\u0010\u001e\u001a\u00020\u001fH\u0007¢\u0006\u0004\b \u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0096\u0002J\u0011\u0010&\u001a\u00020'2\u0006\u0010$\u001a\u00020\u0000H\u0097\u0002J\b\u0010(\u001a\u00020'H\u0016J\b\u0010)\u001a\u00020%H\u0002R\u001c\u0010\u0004\u001a\u00020\u00058\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0006\u001a\u00020\u00058\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006+"}, m13886d2 = {"Lkotlin/uuid/Uuid;", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "mostSignificantBits", "", "leastSignificantBits", "<init>", "(JJ)V", "getMostSignificantBits$annotations", "()V", "getMostSignificantBits", "()J", "getLeastSignificantBits$annotations", "getLeastSignificantBits", "toLongs", "T", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "toULongs", "Lkotlin/ULong;", "toString", "", "toHexDashString", "toHexString", "toByteArray", "", "toUByteArray", "Lkotlin/UByteArray;", "toUByteArray-TcUX1vc", "()[B", "equals", "", "other", "", "compareTo", "", "hashCode", "writeReplace", "Companion", "kotlin-stdlib"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@ExperimentalUuidApi
public final class Uuid implements Comparable<Uuid>, Serializable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Uuid NIL = new Uuid(0, 0);
    public static final int SIZE_BITS = 128;
    public static final int SIZE_BYTES = 16;
    private final long leastSignificantBits;
    private final long mostSignificantBits;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ\u001d\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001dH\u0007J\u000e\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u001dJ\u0006\u0010\"\u001a\u00020\u0005R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R*\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00050$j\b\u0012\u0004\u0012\u00020\u0005`%8FX\u0087\u0004¢\u0006\f\u0012\u0004\b&\u0010\u0003\u001a\u0004\b'\u0010(¨\u0006)"}, m13886d2 = {"Lkotlin/uuid/Uuid$Companion;", "", "<init>", "()V", "NIL", "Lkotlin/uuid/Uuid;", "getNIL", "()Lkotlin/uuid/Uuid;", "SIZE_BYTES", "", "SIZE_BITS", "fromLongs", "mostSignificantBits", "", "leastSignificantBits", "fromULongs", "Lkotlin/ULong;", "fromULongs-eb3DHEI", "(JJ)Lkotlin/uuid/Uuid;", "fromByteArray", "byteArray", "", "fromUByteArray", "ubyteArray", "Lkotlin/UByteArray;", "fromUByteArray-GBYM_sE", "([B)Lkotlin/uuid/Uuid;", "parse", "uuidString", "", "parseHexDash", "hexDashString", "parseHex", "hexString", "random", "LEXICAL_ORDER", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "getLEXICAL_ORDER$annotations", "getLEXICAL_ORDER", "()Ljava/util/Comparator;", "kotlin-stdlib"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Uuid fromByteArray(@NotNull byte[] byteArray) {
            Intrinsics.checkNotNullParameter(byteArray, "byteArray");
            if (byteArray.length == 16) {
                return fromLongs(UuidKt__UuidJVMKt.getLongAt(byteArray, 0), UuidKt__UuidJVMKt.getLongAt(byteArray, 8));
            }
            throw new IllegalArgumentException(("Expected exactly 16 bytes, but was " + UuidKt__UuidKt.truncateForErrorMessage$UuidKt__UuidKt(byteArray, 32) + " of size " + byteArray.length).toString());
        }

        @NotNull
        public final Uuid fromLongs(long mostSignificantBits, long leastSignificantBits) {
            return (mostSignificantBits == 0 && leastSignificantBits == 0) ? getNIL() : new Uuid(mostSignificantBits, leastSignificantBits, null);
        }

        @SinceKotlin(version = "2.1")
        @ExperimentalUnsignedTypes
        @NotNull
        /* JADX INFO: renamed from: fromUByteArray-GBYM_sE, reason: not valid java name */
        public final Uuid m23691fromUByteArrayGBYM_sE(@NotNull byte[] ubyteArray) {
            Intrinsics.checkNotNullParameter(ubyteArray, "ubyteArray");
            return fromByteArray(ubyteArray);
        }

        @NotNull
        /* JADX INFO: renamed from: fromULongs-eb3DHEI, reason: not valid java name */
        public final Uuid m23692fromULongseb3DHEI(long mostSignificantBits, long leastSignificantBits) {
            return fromLongs(mostSignificantBits, leastSignificantBits);
        }

        @NotNull
        public final Comparator<Uuid> getLEXICAL_ORDER() {
            return ComparisonsKt.naturalOrder();
        }

        @NotNull
        public final Uuid getNIL() {
            return Uuid.NIL;
        }

        @NotNull
        public final Uuid parse(@NotNull String uuidString) {
            Intrinsics.checkNotNullParameter(uuidString, "uuidString");
            int length = uuidString.length();
            if (length == 32) {
                return UuidKt__UuidJVMKt.uuidParseHex(uuidString);
            }
            if (length == 36) {
                return UuidKt__UuidJVMKt.uuidParseHexDash(uuidString);
            }
            throw new IllegalArgumentException("Expected either a 36-char string in the standard hex-and-dash UUID format or a 32-char hexadecimal string, but was \"" + UuidKt__UuidKt.truncateForErrorMessage$UuidKt__UuidKt(uuidString, 64) + "\" of length " + uuidString.length());
        }

        @NotNull
        public final Uuid parseHex(@NotNull String hexString) {
            Intrinsics.checkNotNullParameter(hexString, "hexString");
            if (hexString.length() == 32) {
                return UuidKt__UuidJVMKt.uuidParseHex(hexString);
            }
            throw new IllegalArgumentException(("Expected a 32-char hexadecimal string, but was \"" + UuidKt__UuidKt.truncateForErrorMessage$UuidKt__UuidKt(hexString, 64) + "\" of length " + hexString.length()).toString());
        }

        @SinceKotlin(version = "2.1")
        @NotNull
        public final Uuid parseHexDash(@NotNull String hexDashString) {
            Intrinsics.checkNotNullParameter(hexDashString, "hexDashString");
            if (hexDashString.length() == 36) {
                return UuidKt__UuidJVMKt.uuidParseHexDash(hexDashString);
            }
            throw new IllegalArgumentException(("Expected a 36-char string in the standard hex-and-dash UUID format, but was \"" + UuidKt__UuidKt.truncateForErrorMessage$UuidKt__UuidKt(hexDashString, 64) + "\" of length " + hexDashString.length()).toString());
        }

        @NotNull
        public final Uuid random() {
            return UuidKt__UuidJVMKt.secureRandomUuid();
        }

        private Companion() {
        }

        @Deprecated(message = "Use naturalOrder<Uuid>() instead", replaceWith = @ReplaceWith(expression = "naturalOrder<Uuid>()", imports = {"kotlin.comparisons.naturalOrder"}))
        @DeprecatedSinceKotlin(warningSince = "2.1")
        public static /* synthetic */ void getLEXICAL_ORDER$annotations() {
        }
    }

    public /* synthetic */ Uuid(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2);
    }

    @InlineOnly
    private final <T> T toLongs(Function2<? super Long, ? super Long, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Long.valueOf(getMostSignificantBits()), Long.valueOf(getLeastSignificantBits()));
    }

    @InlineOnly
    private final <T> T toULongs(Function2<? super ULong, ? super ULong, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(ULong.m22383boximpl(ULong.m22389constructorimpl(getMostSignificantBits())), ULong.m22383boximpl(ULong.m22389constructorimpl(getLeastSignificantBits())));
    }

    private final Object writeReplace() {
        return UuidKt__UuidJVMKt.serializedUuid(this);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Uuid)) {
            return false;
        }
        Uuid uuid = (Uuid) other;
        return this.mostSignificantBits == uuid.mostSignificantBits && this.leastSignificantBits == uuid.leastSignificantBits;
    }

    public final long getLeastSignificantBits() {
        return this.leastSignificantBits;
    }

    public final long getMostSignificantBits() {
        return this.mostSignificantBits;
    }

    public int hashCode() {
        return Long.hashCode(this.mostSignificantBits ^ this.leastSignificantBits);
    }

    @NotNull
    public final byte[] toByteArray() {
        byte[] bArr = new byte[16];
        UuidKt__UuidJVMKt.setLongAt(bArr, 0, this.mostSignificantBits);
        UuidKt__UuidJVMKt.setLongAt(bArr, 8, this.leastSignificantBits);
        return bArr;
    }

    @SinceKotlin(version = "2.1")
    @NotNull
    public final String toHexDashString() {
        byte[] bArr = new byte[36];
        UuidKt__UuidJVMKt.formatBytesInto(this.mostSignificantBits, bArr, 0, 0, 4);
        bArr[8] = 45;
        UuidKt__UuidJVMKt.formatBytesInto(this.mostSignificantBits, bArr, 9, 4, 6);
        bArr[13] = 45;
        UuidKt__UuidJVMKt.formatBytesInto(this.mostSignificantBits, bArr, 14, 6, 8);
        bArr[18] = 45;
        UuidKt__UuidJVMKt.formatBytesInto(this.leastSignificantBits, bArr, 19, 0, 2);
        bArr[23] = 45;
        UuidKt__UuidJVMKt.formatBytesInto(this.leastSignificantBits, bArr, 24, 2, 8);
        return StringsKt.decodeToString(bArr);
    }

    @NotNull
    public final String toHexString() {
        byte[] bArr = new byte[32];
        UuidKt__UuidJVMKt.formatBytesInto(this.mostSignificantBits, bArr, 0, 0, 8);
        UuidKt__UuidJVMKt.formatBytesInto(this.leastSignificantBits, bArr, 16, 0, 8);
        return StringsKt.decodeToString(bArr);
    }

    @NotNull
    public String toString() {
        return toHexDashString();
    }

    @SinceKotlin(version = "2.1")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: toUByteArray-TcUX1vc, reason: not valid java name */
    public final byte[] m23690toUByteArrayTcUX1vc() {
        return UByteArray.m22286constructorimpl(toByteArray());
    }

    private Uuid(long j, long j2) {
        this.mostSignificantBits = j;
        this.leastSignificantBits = j2;
    }

    @Override // java.lang.Comparable
    @SinceKotlin(version = "2.1")
    public int compareTo(@NotNull Uuid other) {
        Intrinsics.checkNotNullParameter(other, "other");
        long j = this.mostSignificantBits;
        return j != other.mostSignificantBits ? Long.compareUnsigned(ULong.m22389constructorimpl(j), ULong.m22389constructorimpl(other.mostSignificantBits)) : Long.compareUnsigned(ULong.m22389constructorimpl(this.leastSignificantBits), ULong.m22389constructorimpl(other.leastSignificantBits));
    }

    @PublishedApi
    public static /* synthetic */ void getLeastSignificantBits$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getMostSignificantBits$annotations() {
    }
}
