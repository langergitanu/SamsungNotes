package com.microsoft.identity.common.java.p132ui;

import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, m13886d2 = {"Lcom/microsoft/identity/common/java/ui/PreferredAuthMethod;", "", "code", "", "value", "", "(Ljava/lang/String;IILjava/lang/String;)V", CoverStickerConstants.Category.NONE.NAME, "QR", "Companion", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public enum PreferredAuthMethod {
    NONE(0, null),
    QR(18, "qrpin");


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    public final int code;

    @JvmField
    @Nullable
    public final String value;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¨\u0006\n"}, m13886d2 = {"Lcom/microsoft/identity/common/java/ui/PreferredAuthMethod$Companion;", "", "()V", "fromCode", "Lcom/microsoft/identity/common/java/ui/PreferredAuthMethod;", "code", "", "fromValue", "value", "", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final PreferredAuthMethod fromCode(int code) {
            for (PreferredAuthMethod preferredAuthMethod : PreferredAuthMethod.values()) {
                if (preferredAuthMethod.code == code) {
                    return preferredAuthMethod;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }

        @JvmStatic
        @NotNull
        public final PreferredAuthMethod fromValue(@Nullable String value) {
            for (PreferredAuthMethod preferredAuthMethod : PreferredAuthMethod.values()) {
                if (Intrinsics.areEqual(preferredAuthMethod.value, value)) {
                    return preferredAuthMethod;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }

        private Companion() {
        }
    }

    PreferredAuthMethod(int i, String str) {
        this.code = i;
        this.value = str;
    }

    @JvmStatic
    @NotNull
    public static final PreferredAuthMethod fromCode(int i) {
        return INSTANCE.fromCode(i);
    }

    @JvmStatic
    @NotNull
    public static final PreferredAuthMethod fromValue(@Nullable String str) {
        return INSTANCE.fromValue(str);
    }
}
