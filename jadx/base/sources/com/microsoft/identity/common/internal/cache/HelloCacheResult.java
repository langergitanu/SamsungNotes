package com.microsoft.identity.common.internal.cache;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.microsoft.identity.common.logging.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u000eJ\r\u0010\u0011\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, m13886d2 = {"Lcom/microsoft/identity/common/internal/cache/HelloCacheResult;", "", "negotiatedProtocolVersion", "", "error", "timeStamp", "", "(Ljava/lang/String;Ljava/lang/String;J)V", "getError", "()Ljava/lang/String;", "getNegotiatedProtocolVersion", "getTimeStamp$common_distRelease", "()J", "isError", "", "isHandShakeError", "isSuccess", "serialize", "serialize$common_distRelease", "Companion", "common_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class HelloCacheResult {

    @NotNull
    private static final String ERROR_CACHE_VALUE_FORMAT = "E,%s,%d";

    @NotNull
    private static final String ERROR_PREFIX = "E";

    @NotNull
    private static final String HANDSHAKE_ERROR = "handshake_error";

    @NotNull
    private static final String SEPARATOR = ",";

    @NotNull
    private static final String SUCCESS_CACHE_VALUE_FORMAT = "S,%s,%d";

    @NotNull
    private static final String SUCCESS_PREFIX = "S";

    @Nullable
    private final String error;

    @Nullable
    private final String negotiatedProtocolVersion;
    private final long timeStamp;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "HelloCacheResult";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0015\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0013J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\r\u0010\u0014\u001a\u00020\rH\u0000¢\u0006\u0002\b\u0015J\u0017\u0010\u0016\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0017\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u000b*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Lcom/microsoft/identity/common/internal/cache/HelloCacheResult$Companion;", "", "()V", "ERROR_CACHE_VALUE_FORMAT", "", "ERROR_PREFIX", "HANDSHAKE_ERROR", "SEPARATOR", "SUCCESS_CACHE_VALUE_FORMAT", "SUCCESS_PREFIX", SearchConstants.TargetContents.TAG, "kotlin.jvm.PlatformType", "createError", "Lcom/microsoft/identity/common/internal/cache/HelloCacheResult;", "error", "timeStamp", "", "createFromNegotiatedProtocolVersion", "negotiatedProtocolVersion", "createFromNegotiatedProtocolVersion$common_distRelease", "createHandshakeError", "createHandshakeError$common_distRelease", "deserialize", "value", "deserialize$common_distRelease", "common_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final HelloCacheResult createError(String error, long timeStamp) {
            return new HelloCacheResult(null, error, timeStamp);
        }

        private final HelloCacheResult createFromNegotiatedProtocolVersion(String negotiatedProtocolVersion, long timeStamp) {
            return new HelloCacheResult(negotiatedProtocolVersion, null, timeStamp);
        }

        @NotNull
        public final HelloCacheResult createFromNegotiatedProtocolVersion$common_distRelease(@NotNull String negotiatedProtocolVersion) {
            Intrinsics.checkNotNullParameter(negotiatedProtocolVersion, "negotiatedProtocolVersion");
            return createFromNegotiatedProtocolVersion(negotiatedProtocolVersion, System.currentTimeMillis());
        }

        @NotNull
        public final HelloCacheResult createHandshakeError$common_distRelease() {
            return createError(HelloCacheResult.HANDSHAKE_ERROR, System.currentTimeMillis());
        }

        @Nullable
        public final HelloCacheResult deserialize$common_distRelease(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            String str = HelloCacheResult.TAG + ":deserialize";
            List listSplit$default = StringsKt__StringsKt.split$default(value, new String[]{","}, false, 0, 6, (Object) null);
            if (listSplit$default.size() != 3) {
                Logger.warn(str, "Legacy or Invalid cache entry. " + value);
                return null;
            }
            try {
                long j = Long.parseLong((String) listSplit$default.get(2));
                return Intrinsics.areEqual(listSplit$default.get(0), "E") ? createError((String) listSplit$default.get(1), j) : createFromNegotiatedProtocolVersion((String) listSplit$default.get(1), j);
            } catch (NumberFormatException e) {
                Logger.error(str, "Invalid cache entry. " + value, e);
                return null;
            }
        }

        private Companion() {
        }
    }

    public HelloCacheResult(@Nullable String str, @Nullable String str2, long j) {
        this.negotiatedProtocolVersion = str;
        this.error = str2;
        this.timeStamp = j;
        boolean z = true;
        boolean z2 = str == null || str.length() == 0;
        if (str2 != null && str2.length() != 0) {
            z = false;
        }
        if (!(z2 ^ z)) {
            throw new IllegalStateException("Either both parameters provided or none provided.");
        }
    }

    @Nullable
    public final String getError() {
        return this.error;
    }

    @Nullable
    public final String getNegotiatedProtocolVersion() {
        return this.negotiatedProtocolVersion;
    }

    /* JADX INFO: renamed from: getTimeStamp$common_distRelease, reason: from getter */
    public final long getTimeStamp() {
        return this.timeStamp;
    }

    public final boolean isError() {
        String str = this.error;
        return !(str == null || str.length() == 0);
    }

    public final boolean isHandShakeError() {
        return isError() && Intrinsics.areEqual(this.error, HANDSHAKE_ERROR);
    }

    public final boolean isSuccess() {
        String str = this.negotiatedProtocolVersion;
        return !(str == null || str.length() == 0);
    }

    @NotNull
    public final String serialize$common_distRelease() {
        String str = this.error;
        if (str == null || str.length() == 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            return AbstractC2322a.m1624n(SUCCESS_CACHE_VALUE_FORMAT, new Object[]{this.negotiatedProtocolVersion, Long.valueOf(this.timeStamp)}, 2, "format(format, *args)");
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        return AbstractC2322a.m1624n(ERROR_CACHE_VALUE_FORMAT, new Object[]{this.error, Long.valueOf(this.timeStamp)}, 2, "format(format, *args)");
    }
}
