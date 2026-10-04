package com.samsung.android.support.senl.p148nt.app.main.noteslist.model;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ChildDeletableData {
    private int deletableWithVerifyCount;
    private final ArrayList<String> filePathList;
    private int totalFolders;
    private int totalNotes;

    public ChildDeletableData() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.filePathList = arrayList;
        this.totalNotes = 0;
        this.deletableWithVerifyCount = 0;
        arrayList.clear();
    }

    public void addAll(ChildDeletableData childDeletableData) {
        this.totalNotes += childDeletableData.totalNotes;
        this.deletableWithVerifyCount += childDeletableData.deletableWithVerifyCount;
        this.filePathList.addAll(childDeletableData.filePathList);
    }

    public void addDeletableWithVerifyCount() {
        this.deletableWithVerifyCount++;
    }

    public void addFilePath(String str) {
        this.filePathList.add(str);
    }

    public void addTotalFolders() {
        this.totalFolders++;
    }

    public void addTotalNotes() {
        this.totalNotes++;
    }

    public int getDeletableWithVerifyCount() {
        return this.deletableWithVerifyCount;
    }

    public int getTotalItems() {
        return this.totalNotes + this.totalFolders;
    }

    public int getTotalNotes() {
        return this.totalNotes;
    }
}
