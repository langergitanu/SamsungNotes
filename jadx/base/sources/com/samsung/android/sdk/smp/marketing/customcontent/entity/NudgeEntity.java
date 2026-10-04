package com.samsung.android.sdk.smp.marketing.customcontent.entity;

import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class NudgeEntity extends CustomContentEntity {
    public static final String DISPLAY_TIME = "cardDisplayTime";
    public static final String DISPLAY_TIME_MIN = "cardDisplayTimeMin";
    public static final String RANDOM_RANGE = "random";
    private static final String TAG = "NudgeEntity";

    public NudgeEntity(String str, String str2, String str3) {
        super(MarketingConstants.CustomContentConst.NUDGE, str, str2, str3);
    }

    @Override // com.samsung.android.sdk.smp.marketing.customcontent.entity.CustomContentEntity
    public Map<String, String> getRequestQueries() {
        return Collections.EMPTY_MAP;
    }

    @Override // com.samsung.android.sdk.smp.marketing.customcontent.entity.CustomContentEntity
    public String printData() {
        return TAG + ": {mid: " + this.mid + ", uid: " + this.uid + ", queries: " + getRequestQueries() + "}";
    }
}
