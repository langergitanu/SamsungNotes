package com.google.api.client.testing.util;

import com.google.api.client.util.Beta;
import com.google.api.client.util.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Beta
public class LogRecordingHandler extends Handler {
    private final List<LogRecord> records = Lists.newArrayList();

    public List<String> messages() {
        ArrayList arrayListNewArrayList = Lists.newArrayList();
        Iterator<LogRecord> it = this.records.iterator();
        while (it.hasNext()) {
            arrayListNewArrayList.add(it.next().getMessage());
        }
        return arrayListNewArrayList;
    }

    @Override // java.util.logging.Handler
    public void publish(LogRecord logRecord) {
        this.records.add(logRecord);
    }

    @Override // java.util.logging.Handler
    public void close() {
    }

    @Override // java.util.logging.Handler
    public void flush() {
    }
}
