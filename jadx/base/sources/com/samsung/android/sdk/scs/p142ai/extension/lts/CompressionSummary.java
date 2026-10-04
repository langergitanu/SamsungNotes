package com.samsung.android.sdk.scs.p142ai.extension.lts;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
class CompressionSummary {

    /* JADX INFO: renamed from: N */
    private int f5179N;
    private final String TAG;
    private List<String> chunkedSummarySentence;
    private List<Integer> dividedCount;
    private Queue<Integer> dividedCountQueue;
    private Queue<Queue<Integer>> dividedNQueue;
    private Queue<String> summarySentence;

    public CompressionSummary() {
        this.TAG = "CompressionSummary";
        this.dividedCount = new ArrayList();
        this.dividedCountQueue = new LinkedList();
        this.dividedNQueue = new LinkedList();
        this.summarySentence = new LinkedList();
        this.chunkedSummarySentence = new ArrayList();
        this.f5179N = 4;
    }

    public int addSentence(String str) {
        this.summarySentence.add(str);
        return this.summarySentence.size();
    }

    public Queue<Queue<Integer>> balanceGroup() {
        int i;
        this.dividedNQueue.clear();
        for (int i2 = 0; i2 < this.dividedCount.size(); i2++) {
            LinkedList linkedList = new LinkedList();
            this.dividedNQueue.add(linkedList);
            int iIntValue = this.dividedCount.get(i2).intValue();
            int iCeil = this.f5179N;
            if (iIntValue > iCeil) {
                if (iCeil - (this.dividedCount.get(i2).intValue() % this.f5179N) > Math.ceil(((double) this.dividedCount.get(i2).intValue()) / ((double) this.f5179N))) {
                    iCeil = (int) Math.ceil(((double) this.dividedCount.get(i2).intValue()) / Math.ceil(((double) this.dividedCount.get(i2).intValue()) / ((double) this.f5179N)));
                }
                int iIntValue2 = this.dividedCount.get(i2).intValue();
                while (iIntValue2 >= 0) {
                    if (iIntValue2 > iCeil) {
                        int i4 = iIntValue2 % iCeil == 0 ? iCeil : iCeil - 1;
                        int i5 = i4;
                        i = iIntValue2 - i4;
                        iIntValue2 = i5;
                    } else {
                        i = -iIntValue2;
                    }
                    linkedList.add(Integer.valueOf(iIntValue2));
                    iIntValue2 = i;
                }
            } else {
                Integer num = this.dividedCount.get(i2);
                num.intValue();
                linkedList.add(num);
            }
        }
        Log.i("CompressionSummary", "dividedNQueue " + this.dividedNQueue);
        return this.dividedNQueue;
    }

    public List<Integer> divideAndCeil(int i) {
        this.dividedCount.clear();
        this.dividedCountQueue.clear();
        if (i <= 0) {
            return this.dividedCount;
        }
        this.dividedCount.add(Integer.valueOf(i));
        int iCeil = i;
        while (iCeil > 1) {
            iCeil = (int) Math.ceil(((double) iCeil) / ((double) this.f5179N));
            this.dividedCount.add(Integer.valueOf(iCeil));
        }
        if (i <= this.f5179N) {
            this.dividedCount.add(1);
        }
        Log.i("CompressionSummary", "dividedCount" + this.dividedCount);
        this.dividedCountQueue.addAll(this.dividedCount);
        return this.dividedCount;
    }

    public List<String> getChunkedSummarySentence() {
        return this.chunkedSummarySentence;
    }

    public List<String> getChunkedSummarySentenceList() {
        this.chunkedSummarySentence.clear();
        Queue<Integer> queuePoll = this.dividedNQueue.poll();
        Integer numPoll = this.dividedCountQueue.poll();
        if (numPoll.intValue() != this.summarySentence.size()) {
            Log.e("CompressionSummary", "size error Text size " + this.summarySentence.size() + " Q size " + numPoll);
        }
        if (queuePoll == null) {
            return new ArrayList();
        }
        int i = 0;
        while (!queuePoll.isEmpty()) {
            Integer numPoll2 = queuePoll.poll();
            this.chunkedSummarySentence.add("");
            for (int i2 = 0; i2 < numPoll2.intValue(); i2++) {
                this.chunkedSummarySentence.set(i, this.chunkedSummarySentence.get(i) + this.summarySentence.poll() + " ");
            }
            i++;
        }
        this.summarySentence.clear();
        return this.chunkedSummarySentence;
    }

    public List<Integer> getDividedCount() {
        return this.dividedCount;
    }

    public Queue<Queue<Integer>> getDividedNQueue() {
        return this.dividedNQueue;
    }

    public int getSeparateN() {
        return this.f5179N;
    }

    public String getSummary() {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = getSummarySentence().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }

    public Queue<String> getSummarySentence() {
        return new LinkedList(this.summarySentence);
    }

    public void setChunkedSummarySentence(List<String> list) {
        this.chunkedSummarySentence = list;
    }

    public void setDividedCount(List<Integer> list) {
        this.dividedCount = list;
        this.dividedCountQueue.addAll(list);
    }

    public void setDividedNQueue(Queue<Queue<Integer>> queue) {
        this.dividedNQueue = queue;
    }

    public CompressionSummary(int i) {
        this.TAG = "CompressionSummary";
        this.dividedCount = new ArrayList();
        this.dividedCountQueue = new LinkedList();
        this.dividedNQueue = new LinkedList();
        this.summarySentence = new LinkedList();
        this.chunkedSummarySentence = new ArrayList();
        this.f5179N = i;
    }
}
