package com.samsung.android.sdk.bixby2.action;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class ActionHandler {
    public static final String ACTION_BACKGROUND = "background";
    public static final String ACTION_PUNCH_OUT = "punchOut";
    public static final String ACTION_TYPE = "actionType";
    public static final String PARAMS = "params";

    public abstract void executeAction(Context context, String str, Bundle bundle, @Nullable ResponseCallback responseCallback);
}
