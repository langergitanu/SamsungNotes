package com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class Event {
    private Object mEventData;
    private final String mName;

    public Event(String str) {
        this.mName = str;
    }

    public Object getEventData() {
        return this.mEventData;
    }

    public String getEventType() {
        return this.mName;
    }

    public void setEventData(Object obj) {
        this.mEventData = obj;
    }
}
