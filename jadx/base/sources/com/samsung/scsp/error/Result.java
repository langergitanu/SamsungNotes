package com.samsung.scsp.error;

import android.os.Bundle;
import com.samsung.android.scloud.rpc.SamsungCloudRPCStatus;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Result {
    private static final int FAIL = 2;
    private static final String RCODE = "rcode";
    private static final String RESULT = "result";
    private static final String RMSG = "rmsg";
    private static final int SUCCESS = 1;
    public final int rcode;
    public final int result;
    public final String rmsg;
    public final boolean success;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Holder {
        public Result result = new Result();
    }

    public Result(int i, String str) {
        this.success = false;
        this.result = 2;
        this.rcode = i;
        this.rmsg = str;
    }

    public static boolean isSuccess(Bundle bundle) {
        return bundle.getInt("result") == 1;
    }

    public Bundle bundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("result", this.result);
        bundle.putInt("rcode", this.rcode);
        bundle.putString("rmsg", this.rmsg);
        return bundle;
    }

    public Result() {
        this.success = true;
        this.result = 1;
        this.rcode = SamsungCloudRPCStatus.Value.SUCCESS;
        this.rmsg = "";
    }
}
