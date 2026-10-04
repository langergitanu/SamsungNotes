package com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class LanguageDownloadCompleteEvent extends Event {
    private static final String EVENT_NAME = "LOCALE_DOWNLOAD_COMPLETE_EVENT";
    private String mLocale;
    private int mStatus;

    public LanguageDownloadCompleteEvent(String str, int i) {
        super(EVENT_NAME);
        this.mLocale = str;
        this.mStatus = i;
    }

    public static String getDefinedEventName() {
        return EVENT_NAME;
    }

    public String getLocale() {
        return this.mLocale;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setLocale(String str) {
        this.mLocale = str;
    }

    public void setStatus(int i) {
        this.mStatus = i;
    }
}
