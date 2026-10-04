package com.samsung.android.sdk.smp.task;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import java.util.EnumSet;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class STask {
    protected static final int BASE_JOB_ID_SELECTION_KEY = 10000000;
    protected static final int DEFAULT_TASKID = 9000000;
    private static final String EXTRA_DATA = "EXTRA_DATA";
    private static final String EXTRA_TASKID = "EXTRA_TASKID";
    private static int mJobIdSelectionKey = -1;
    private final Action mAction;
    private final Bundle mData;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Action {
        int value();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum CommonAction implements Action {
        UPLOAD_CLIENTS(9000002),
        SEND_ACK(9000005),
        HANDLE_APP_UPDATE_EVENT(9000007),
        HANDLE_INCOMP_MARKETING_REQUESTS(9000008),
        SAVE_APP_USAGE(9000009),
        INITIALIZE(9000010),
        GDPR(9000011),
        HANDLE_BOOT_COMPLETED_EVENT(9000012),
        DEACTIVATE(9000013),
        FCM_SERVICE_COMPLEMENTARY_EVENT(9000014),
        UPLOAD_EXTERNAL_FEEDBACK(9000015);

        private final int value;

        CommonAction(int i) {
            this.value = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static CommonAction getAction(int i) {
            for (CommonAction commonAction : EnumSet.allOf(CommonAction.class)) {
                if (commonAction.value() == i) {
                    return commonAction;
                }
            }
            return null;
        }

        @Override // com.samsung.android.sdk.smp.task.STask.Action
        public int value() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum MarketingAction implements Action {
        BASIC(9001000),
        CLEAR(9002000),
        CUSTOM_FEEDBACK(9004000),
        SCREEN_ON(9005000),
        CHECK_NOTIFICATION_CLEARED(9006000);

        private final int value;

        MarketingAction(int i) {
            this.value = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static MarketingAction getAction(int i) {
            for (MarketingAction marketingAction : EnumSet.allOf(MarketingAction.class)) {
                if (marketingAction.value() <= i && i < marketingAction.value() + 1000) {
                    return marketingAction;
                }
            }
            return null;
        }

        @Override // com.samsung.android.sdk.smp.task.STask.Action
        public int value() {
            return this.value;
        }
    }

    public STask(Action action, Bundle bundle) {
        this.mAction = action;
        this.mData = bundle;
    }

    public static STask fromBundle(Bundle bundle) {
        int i = bundle.getInt(EXTRA_TASKID) % BASE_JOB_ID_SELECTION_KEY;
        Bundle bundle2 = bundle.getBundle(EXTRA_DATA);
        if (i < MarketingAction.BASIC.value()) {
            return new STask(CommonAction.getAction(i), bundle2);
        }
        return new SMarketingTask(MarketingAction.getAction(i), bundle2, bundle.getString("EXTRA_MID"));
    }

    public static int getJobIdSelectionValue(Context context) {
        if (mJobIdSelectionKey < 0) {
            mJobIdSelectionKey = DeviceInfoUtil.getJobIdSelectionKey(context, context.getPackageName());
        }
        return mJobIdSelectionKey * BASE_JOB_ID_SELECTION_KEY;
    }

    public Action getAction() {
        return this.mAction;
    }

    public Bundle getData() {
        return this.mData;
    }

    public int getTaskId(Context context) {
        Action action = this.mAction;
        return getJobIdSelectionValue(context) + (action != null ? action.value() : DEFAULT_TASKID);
    }

    public Bundle toBundle(Context context) {
        Bundle bundle = new Bundle();
        bundle.putInt(EXTRA_TASKID, getTaskId(context));
        Bundle bundle2 = this.mData;
        if (bundle2 != null) {
            bundle.putBundle(EXTRA_DATA, bundle2);
        }
        return bundle;
    }

    @NonNull
    public String toString() {
        Action action = this.mAction;
        return action != null ? action.toString() : "";
    }
}
