package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiMenuResultViewSTTSummarizationItem {
    private String paragraph;
    private String summaryTitle;
    private int timeStamp;
    private String translatedTitle;
    private ArrayList<String> summaryLines = new ArrayList<>();
    private ArrayList<String> translatedLines = new ArrayList<>();
    private boolean mIsHidden = false;
    private boolean mIsStreamCompleted = true;

    public String getParagraph() {
        return this.paragraph;
    }

    public ArrayList<String> getSummaryLines() {
        return this.summaryLines;
    }

    public String getSummaryTitle() {
        return this.summaryTitle;
    }

    public int getTimeStamp() {
        return this.timeStamp;
    }

    public ArrayList<String> getTranslatedLines() {
        return this.translatedLines;
    }

    public String getTranslatedTitle() {
        return this.translatedTitle;
    }

    public boolean isHidden() {
        return this.mIsHidden;
    }

    public boolean isStreamCompleted() {
        return this.mIsStreamCompleted;
    }

    public void setHidden(boolean z) {
        this.mIsHidden = z;
    }

    public void setParagraph(String str) {
        this.paragraph = str;
    }

    public void setStreamCompleted(boolean z) {
        this.mIsStreamCompleted = z;
    }

    public void setSummaryLines(ArrayList<String> arrayList) {
        this.summaryLines = arrayList;
    }

    public void setSummaryTitle(String str) {
        this.summaryTitle = str;
    }

    public void setTimeStamp(int i) {
        this.timeStamp = i;
    }

    public void setTranslatedLines(ArrayList<String> arrayList) {
        this.translatedLines = arrayList;
    }

    public void setTranslatedTitle(String str) {
        this.translatedTitle = str;
    }
}
