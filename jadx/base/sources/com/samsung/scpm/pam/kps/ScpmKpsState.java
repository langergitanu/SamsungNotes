package com.samsung.scpm.pam.kps;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ScpmKpsState extends ScpmKpsResult {
    private static final String E2EE_GROUP_ID = "e2eeGroupId";
    private static final String E2EE_GROUP_IDS = "e2eeGroupIds";
    private static final String STATE = "state";
    public final String e2eeGroupId;
    public final String[] e2eeGroupIds;
    public final String state;

    public ScpmKpsState(Bundle bundle) {
        super(bundle);
        this.e2eeGroupId = bundle.getString("e2eeGroupId");
        this.e2eeGroupIds = bundle.getStringArray(E2EE_GROUP_IDS);
        this.state = bundle.getString("state");
    }
}
