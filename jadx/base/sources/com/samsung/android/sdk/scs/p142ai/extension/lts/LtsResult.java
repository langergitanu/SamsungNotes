package com.samsung.android.sdk.scs.p142ai.extension.lts;

import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.p142ai.language.Result;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class LtsResult {
    private String content;
    private boolean isSuccess;
    private int progressCount;
    private int progressRate;
    private Task<Result> task;
    private int tokenCount;
    private int totalCount;

    public LtsResult(String str, boolean z) {
        this.progressCount = 0;
        this.totalCount = 0;
        this.progressRate = 0;
        this.tokenCount = 0;
        this.task = null;
        this.content = str;
        this.isSuccess = z;
    }

    public String getContent() {
        return this.content;
    }

    public int getProgressCount() {
        return this.progressCount;
    }

    public int getProgressRate() {
        return this.progressRate;
    }

    public Task<Result> getTask() {
        return this.task;
    }

    public int getTokenCount() {
        return this.tokenCount;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public void increaseRepeatCount() {
        int i = this.progressCount + 1;
        this.progressCount = i;
        int i2 = this.totalCount;
        this.progressRate = i2 == 0 ? 100 : (int) ((i / i2) * 100.0f);
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setProgressRate(int i) {
        this.progressRate = i;
    }

    public void setSuccess(boolean z) {
        this.isSuccess = z;
    }

    public void setTask(Task<Result> task) {
        this.task = task;
    }

    public void setTokenCount(int i) {
        this.tokenCount = i;
    }

    public void setTotalCount(int i) {
        this.totalCount = i;
    }

    public LtsResult(int i, String str, boolean z) {
        this.progressCount = 0;
        this.progressRate = 0;
        this.tokenCount = 0;
        this.task = null;
        this.content = str;
        this.isSuccess = z;
        this.totalCount = i;
    }
}
