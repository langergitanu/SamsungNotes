package com.samsung.android.sdk.mobileservice;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
enum SessionErrorCode {
    NO_PROBLEM(0, 100),
    CAUSE_AGENT_NOT_INSTALLED(1, 0),
    CAUSE_AGENT_DISABLED(2, 1),
    CAUSE_AGENT_NOT_AVAILABLE(3, 2),
    CAUSE_AGENT_OLD_VERSION(4, 3),
    CAUSE_SDK_OLD_VERSION(5, 4),
    CAUSE_CONNECT_CANCELED(6, 5),
    CAUSE_CONNECT_TIMEOUT(7, 6),
    CAUSE_AGENT_FORCE_UPDATE_REQUIRED(8, 7),
    CAUSE_UNDEFINED(99, 0);

    private int mPriority;
    private int mValue;

    SessionErrorCode(int i, int i2) {
        this.mValue = i;
        this.mPriority = i2;
    }

    public static SessionErrorCode getErrorCode(int i) {
        for (SessionErrorCode sessionErrorCode : values()) {
            if (sessionErrorCode.getValue() == i) {
                return sessionErrorCode;
            }
        }
        return null;
    }

    public int comparePriority(SessionErrorCode sessionErrorCode) {
        if (this.mPriority < sessionErrorCode.getPriority()) {
            return -1;
        }
        return this.mPriority == sessionErrorCode.getPriority() ? 0 : 1;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public int getValue() {
        return this.mValue;
    }
}
