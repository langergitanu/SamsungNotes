package com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class LanguageDownloadProgressEvent extends Event {
    public static final String EVENT_NAME = "LOCALE_DOWNLOAD_PROGRESS";
    private String mLocale;
    private int mMax;
    private int mProgress;

    public LanguageDownloadProgressEvent(String str, int i, int i2) {
        super(EVENT_NAME);
        this.mLocale = str;
        this.mProgress = i;
        this.mMax = i2;
    }

    public static String getDefinedEventName() {
        return EVENT_NAME;
    }

    public String getLocale() {
        return this.mLocale;
    }

    public int getMax() {
        return this.mMax;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void setLocale(String str) {
        this.mLocale = str;
    }

    public void setMax(int i) {
        this.mMax = i;
    }

    public void setProgress(int i) {
        this.mProgress = i;
    }

    public LanguageDownloadProgressEvent() {
        super(EVENT_NAME);
    }
}
