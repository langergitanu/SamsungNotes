package io.grpc.internal;

import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import java.util.ArrayList;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class InsightBuilder {
    private final ArrayList<String> buffer = new ArrayList<>();

    public InsightBuilder append(@Nullable Object obj) {
        this.buffer.add(String.valueOf(obj));
        return this;
    }

    public InsightBuilder appendKeyValue(String str, @Nullable Object obj) {
        this.buffer.add(str + MarketingConstants.REFERRER_DELIMITER_U003D + obj);
        return this;
    }

    public String toString() {
        return this.buffer.toString();
    }
}
