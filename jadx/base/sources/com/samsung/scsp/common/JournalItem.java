package com.samsung.scsp.common;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class JournalItem {
    public final int code;
    public final String from;
    public final String name;
    public final long timestamp;
    public final int type;

    private JournalItem(String str, String str2, int i) {
        this.from = str;
        this.name = str2;
        this.timestamp = System.currentTimeMillis();
        this.code = 0;
        this.type = i;
    }

    public static JournalItem begin(String str, String str2) {
        return new JournalItem(str, str2, 1);
    }

    public static JournalItem end(String str, String str2) {
        return new JournalItem(str, str2, 2);
    }

    public static JournalItem error(String str, String str2, int i) {
        return new JournalItem(str, str2, 11, i);
    }

    public String toString() {
        return String.format("%s, %s, %d, %d, %d", this.from, this.name, Integer.valueOf(this.type), Integer.valueOf(this.code), Long.valueOf(this.timestamp));
    }

    private JournalItem(String str, String str2, int i, int i2) {
        this.from = str;
        this.name = str2;
        this.timestamp = System.currentTimeMillis();
        this.code = i2;
        this.type = i;
    }
}
