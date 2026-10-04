package io.opentelemetry.api.baggage.propagation;

import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.sec.android.app.voicenote.common.util.C11697a;
import io.opentelemetry.api.baggage.Baggage;
import io.opentelemetry.api.baggage.BaggageBuilder;
import io.opentelemetry.api.baggage.BaggageEntry;
import io.opentelemetry.api.internal.StringUtils;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.propagation.TextMapGetter;
import io.opentelemetry.context.propagation.TextMapPropagator;
import io.opentelemetry.context.propagation.TextMapSetter;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class W3CBaggagePropagator implements TextMapPropagator {
    private static final String FIELD = "baggage";
    private static final List<String> FIELDS = Collections.singletonList(FIELD);
    private static final W3CBaggagePropagator INSTANCE = new W3CBaggagePropagator();
    private static final PercentEscaper URL_ESCAPER = PercentEscaper.create();

    private W3CBaggagePropagator() {
    }

    private static boolean baggageIsInvalid(String str, BaggageEntry baggageEntry) {
        return (isValidBaggageKey(str) && isValidBaggageValue(baggageEntry.getValue())) ? false : true;
    }

    private static String baggageToString(Baggage baggage) {
        StringBuilder sb = new StringBuilder();
        baggage.forEach(new C11697a(1, sb));
        if (sb.length() == 0) {
            return "";
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    private static String encodeValue(String str) {
        return URL_ESCAPER.escape(str);
    }

    private static void extractEntries(String str, BaggageBuilder baggageBuilder) {
        new Parser(str).parseInto(baggageBuilder);
    }

    public static W3CBaggagePropagator getInstance() {
        return INSTANCE;
    }

    private static boolean isValidBaggageKey(String str) {
        return (str == null || str.isEmpty() || !StringUtils.isPrintableString(str)) ? false : true;
    }

    private static boolean isValidBaggageValue(String str) {
        return str != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$baggageToString$0(StringBuilder sb, String str, BaggageEntry baggageEntry) {
        if (baggageIsInvalid(str, baggageEntry)) {
            return;
        }
        sb.append(str);
        sb.append(MarketingConstants.REFERRER_DELIMITER_U003D);
        sb.append(encodeValue(baggageEntry.getValue()));
        String value = baggageEntry.getMetadata().getValue();
        if (value != null && !value.isEmpty()) {
            sb.append(";");
            sb.append(encodeValue(value));
        }
        sb.append(",");
    }

    @Override // io.opentelemetry.context.propagation.TextMapPropagator
    public <C> Context extract(Context context, @Nullable C c, TextMapGetter<C> textMapGetter) {
        String str;
        if (context == null) {
            return Context.root();
        }
        if (textMapGetter == null || (str = textMapGetter.get(c, FIELD)) == null || str.isEmpty()) {
            return context;
        }
        BaggageBuilder baggageBuilderBuilder = Baggage.builder();
        try {
            extractEntries(str, baggageBuilderBuilder);
            return context.with(baggageBuilderBuilder.build());
        } catch (RuntimeException unused) {
            return context;
        }
    }

    @Override // io.opentelemetry.context.propagation.TextMapPropagator
    public Collection<String> fields() {
        return FIELDS;
    }

    @Override // io.opentelemetry.context.propagation.TextMapPropagator
    public <C> void inject(Context context, @Nullable C c, TextMapSetter<C> textMapSetter) {
        if (context == null || textMapSetter == null) {
            return;
        }
        Baggage baggageFromContext = Baggage.fromContext(context);
        if (baggageFromContext.isEmpty()) {
            return;
        }
        String strBaggageToString = baggageToString(baggageFromContext);
        if (strBaggageToString.isEmpty()) {
            return;
        }
        textMapSetter.set(c, FIELD, strBaggageToString);
    }
}
