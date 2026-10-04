package com.samsung.context.sdk.samsunganalytics.internal.sender;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SimpleLog {
    private String _id;
    private String data;
    private long timestamp;
    private LogType type;

    public SimpleLog() {
    }

    public String getData() {
        return this.data;
    }

    public String getId() {
        return this._id;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public LogType getType() {
        return this.type;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setId(String str) {
        this._id = str;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public void setType(LogType logType) {
        this.type = logType;
    }

    public SimpleLog(long j, String str, LogType logType) {
        this("", j, str, logType);
    }

    public SimpleLog(String str, long j, String str2, LogType logType) {
        this._id = str;
        this.timestamp = j;
        this.data = str2;
        this.type = logType;
    }
}
