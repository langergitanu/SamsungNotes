package io.opentelemetry.api.trace.propagation.internal;

import com.sec.android.app.voicenote.common.util.C11697a;
import io.opentelemetry.api.internal.Utils;
import io.opentelemetry.api.trace.TraceState;
import io.opentelemetry.api.trace.TraceStateBuilder;
import java.util.regex.Pattern;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Immutable
public final class W3CTraceContextEncoding {
    private static final char TRACESTATE_ENTRY_DELIMITER = ',';
    private static final Pattern TRACESTATE_ENTRY_DELIMITER_SPLIT_PATTERN = Pattern.compile("[ \t]*,[ \t]*");
    private static final char TRACESTATE_KEY_VALUE_DELIMITER = '=';
    private static final int TRACESTATE_MAX_MEMBERS = 32;
    private static final int TRACESTATE_MAX_SIZE = 512;

    private W3CTraceContextEncoding() {
    }

    public static TraceState decodeTraceState(String str) {
        TraceStateBuilder traceStateBuilderBuilder = TraceState.builder();
        String[] strArrSplit = TRACESTATE_ENTRY_DELIMITER_SPLIT_PATTERN.split(str);
        Utils.checkArgument(strArrSplit.length <= 32, "TraceState has too many elements.");
        for (int length = strArrSplit.length - 1; length >= 0; length--) {
            String str2 = strArrSplit[length];
            int iIndexOf = str2.indexOf(61);
            Utils.checkArgument(iIndexOf != -1, "Invalid TraceState list-member format.");
            traceStateBuilderBuilder.put(str2.substring(0, iIndexOf), str2.substring(iIndexOf + 1));
        }
        TraceState traceStateBuild = traceStateBuilderBuilder.build();
        return traceStateBuild.size() != strArrSplit.length ? TraceState.getDefault() : traceStateBuild;
    }

    public static String encodeTraceState(TraceState traceState) {
        if (traceState.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder(512);
        traceState.forEach(new C11697a(2, sb));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$encodeTraceState$0(StringBuilder sb, String str, String str2) {
        if (sb.length() != 0) {
            sb.append(',');
        }
        sb.append(str);
        sb.append(TRACESTATE_KEY_VALUE_DELIMITER);
        sb.append(str2);
    }
}
