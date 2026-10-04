package com.samsung.android.support.senl.p148nt.base.common.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.SharedPreferencesConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0003J\u0012\u0010\u0016\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0007J\u001a\u0010\u001b\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001c\u001a\u00020\u0019H\u0007J\u0012\u0010\u001d\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\u001e\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u0012\u0010\u001f\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010 \u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0007J\"\u0010!\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0007J\u0012\u0010%\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010&\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\u001b\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u001a\u0010'\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010(\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0017\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/UUIDUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "COEDIT_POST_FIX", "GEN_POST_FIX", "AI_TEMPLATE_POST_FIX", "byteTable", "", "HSTART", "", "HMULT", "hashCode", "cs", "getUniqueId", "context", "Landroid/content/Context;", "serial", "getSerial", "()Ljava/lang/String;", "getMostSigBits", "previousTimeMillis", "isCoeditUuid", "", "uuid", "newUUID", "isCoedit", "isGenUuid", "newGenUUID", "isDynamicTemplateUuid", "isDynamicTemplateUuidCompatible", "newDynamicTemplateUUID", "templateType", "", "templateIndex", "getDynamicTemplateUuidType", "getDynamicTemplateUuidIndex", "newUUIDFromSourceUUID", "sourceUuid", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class UUIDUtils {

    @NotNull
    public static final String AI_TEMPLATE_POST_FIX = "_DYNAMIC_TEMPLATE";

    @NotNull
    public static final String COEDIT_POST_FIX = "_COEDIT";

    @NotNull
    public static final String GEN_POST_FIX = "_GEN";
    private static final long HMULT = 7664345821815920749L;
    private static final long HSTART = -4953706369002393500L;

    @NotNull
    private static final String TAG = "UUIDUtils";
    private static long previousTimeMillis;

    @NotNull
    public static final UUIDUtils INSTANCE = new UUIDUtils();

    @NotNull
    private static final long[] byteTable = new long[256];

    static {
        long j = 6074001001750140548L;
        for (int i = 0; i < 256; i++) {
            for (int i2 = 0; i2 < 31; i2++) {
                long j2 = j ^ (j >>> 7);
                long j3 = j2 ^ (j2 << 11);
                j = j3 ^ (j3 >>> 10);
            }
            byteTable[i] = j;
        }
    }

    private UUIDUtils() {
    }

    @JvmStatic
    @NotNull
    public static final String getDynamicTemplateUuidIndex(@Nullable String uuid) {
        return DynamicTemplateUuidUtil.INSTANCE.getIndexFromUuid(uuid);
    }

    @JvmStatic
    @NotNull
    public static final String getDynamicTemplateUuidType(@Nullable String uuid) {
        return DynamicTemplateUuidUtil.INSTANCE.getTypeFromUuid(uuid);
    }

    private final long getMostSigBits(Context context) {
        return getUniqueId(context);
    }

    private final String getSerial() {
        String serial;
        try {
            serial = Build.getSerial();
        } catch (SecurityException e) {
            AbstractC4539a.m3214x("getSerial# SecurityException:", e.getMessage(), TAG);
            serial = null;
        }
        return TextUtils.isEmpty(serial) ? Build.SERIAL : serial;
    }

    @SuppressLint({"HardwareIds"})
    private final long getUniqueId(Context context) {
        String string;
        String serial = getSerial();
        if (!TextUtils.isEmpty(serial) && !Intrinsics.areEqual("0", serial) && !Intrinsics.areEqual("unknown", serial)) {
            long jHashCode = hashCode(serial);
            if (jHashCode != 0) {
                return jHashCode;
            }
        }
        if (context != null) {
            try {
                string = Settings.Secure.getString(context.getContentResolver(), SharedPreferencesConstants.COMPOSER_SP_KEY_ANDROID_ID);
            } catch (SecurityException e) {
                AbstractC4539a.m3214x("getUniqueId# Settings.Secure.getString:", e.getMessage(), TAG);
                string = null;
            }
        } else {
            string = null;
        }
        if (!TextUtils.isEmpty(string) && !Intrinsics.areEqual("0", string)) {
            long jHashCode2 = hashCode(string);
            if (jHashCode2 != 0) {
                return jHashCode2;
            }
        }
        return System.currentTimeMillis();
    }

    private final long hashCode(String cs) {
        if (cs == null) {
            return 1L;
        }
        long[] jArr = byteTable;
        long j = HSTART;
        for (int length = cs.length() - 1; -1 < length; length--) {
            char cCharAt = cs.charAt(length);
            j = (((j * HMULT) ^ jArr[cCharAt & 255]) * HMULT) ^ jArr[(cCharAt >>> '\b') & 255];
        }
        return j;
    }

    @JvmStatic
    public static final boolean isCoeditUuid(@Nullable String uuid) {
        return uuid != null && StringsKt.m14167w(uuid, COEDIT_POST_FIX);
    }

    @JvmStatic
    public static final boolean isDynamicTemplateUuid(@Nullable String uuid) {
        return DynamicTemplateUuidUtil.INSTANCE.isPostFixContained(uuid);
    }

    @JvmStatic
    public static final boolean isDynamicTemplateUuidCompatible(@Nullable String uuid) {
        return DynamicTemplateUuidUtil.INSTANCE.isCompatibleNote(uuid);
    }

    @JvmStatic
    public static final boolean isGenUuid(@Nullable String uuid) {
        return uuid != null && StringsKt.m14162r(uuid, GEN_POST_FIX);
    }

    @JvmStatic
    @NotNull
    public static final String newDynamicTemplateUUID(@Nullable Context context, int templateType, int templateIndex) {
        return AbstractC0541b.m756B(newUUID(context), DynamicTemplateUuidUtil.INSTANCE.getPostFixForUuid(templateType, templateIndex));
    }

    @JvmStatic
    @NotNull
    public static final String newGenUUID(@Nullable Context context) {
        return AbstractC0541b.m756B(newUUID(context), GEN_POST_FIX);
    }

    @JvmStatic
    @NotNull
    public static final String newUUID(@Nullable Context context, boolean isCoedit) {
        return AbstractC0541b.m756B(newUUID(context), isCoedit ? COEDIT_POST_FIX : "");
    }

    @JvmStatic
    @NotNull
    public static final String newUUIDFromSourceUUID(@Nullable Context context, @NotNull String sourceUuid) {
        Intrinsics.checkNotNullParameter(sourceUuid, "sourceUuid");
        String strNewUUID = newUUID(context);
        if (isGenUuid(sourceUuid)) {
            strNewUUID = AbstractC0541b.m756B(strNewUUID, GEN_POST_FIX);
        }
        return isDynamicTemplateUuid(sourceUuid) ? AbstractC0541b.m756B(strNewUUID, DynamicTemplateUuidUtil.INSTANCE.getPostFixFromUuid(sourceUuid)) : strNewUUID;
    }

    @JvmStatic
    @NotNull
    public static final synchronized String newUUID(@Nullable Context context) {
        String string;
        while (previousTimeMillis == System.currentTimeMillis()) {
            try {
                Thread.sleep(1L);
            } catch (InterruptedException e) {
                Logger.m8698e(TAG, "newUUID, e : " + e.getMessage());
            }
        }
        UUID uuid = new UUID(INSTANCE.getMostSigBits(context), System.currentTimeMillis());
        previousTimeMillis = System.currentTimeMillis();
        string = uuid.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
