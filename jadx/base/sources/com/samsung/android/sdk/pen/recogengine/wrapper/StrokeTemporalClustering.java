package com.samsung.android.sdk.pen.recogengine.wrapper;

import android.util.Log;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nJ\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0006\u0010\u0010\u001a\u00020\fJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\u00122\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\nH\u0002R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0017\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0007\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/wrapper/StrokeTemporalClustering;", "", "<init>", "()V", "cluster", "", "strokes", "", "Lcom/samsung/android/sdk/pen/document/SpenObjectStroke;", "threshold", "", "clusterCount", "", "getClusterCount", "()I", "getStrokeIndicesOfCluster", "clusterIndex", "printLog", "", "makeTimeStamps", "analyzeTimeStamps", "clusterStrokesByTimeDiff", "diff", "mDiffAverage", "mDiffMax", "mTimestamps", "", "mTimeDiffs", "mClusterStrokesIndices", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class StrokeTemporalClustering {

    @NotNull
    private static final String TAG = "StrokeTemporalCluster";

    @Nullable
    private List<List<Integer>> mClusterStrokesIndices;
    private long mDiffAverage;
    private long mDiffMax;

    @Nullable
    private List<Long> mTimeDiffs;

    @Nullable
    private List<Long> mTimestamps;

    private final boolean analyzeTimeStamps() {
        int size;
        List<Long> list = this.mTimeDiffs;
        if (list == null || (size = list.size()) == 0) {
            return false;
        }
        Iterator<Long> it = list.iterator();
        long j = 0;
        long j2 = 0;
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            j2 += jLongValue;
            if (jLongValue > j) {
                j = jLongValue;
            }
        }
        this.mDiffMax = j;
        this.mDiffAverage = j2 / ((long) size);
        return true;
    }

    private final boolean clusterStrokesByTimeDiff(long diff) {
        int size;
        List<Long> list = this.mTimeDiffs;
        if (list == null || (size = list.size()) == 0) {
            return false;
        }
        this.mClusterStrokesIndices = new ArrayList();
        ArrayList arrayList = new ArrayList();
        arrayList.add(0);
        if (diff < 0) {
            diff = (this.mDiffAverage + this.mDiffMax) / ((long) 2);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Log.i(TAG, AbstractC11014a.m12323h(new Object[]{Long.valueOf(diff), Long.valueOf(this.mDiffAverage), Long.valueOf(this.mDiffMax)}, 3, Locale.getDefault(), "Use clustering threshold as mean(%d) of AverageDiff(%d), MaxDiff(%d)", "format(locale, format, *args)"));
        } else {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            Log.i(TAG, AbstractC11014a.m12323h(new Object[]{Long.valueOf(diff)}, 1, Locale.getDefault(), "Use clustering threshold as specified value: %d", "format(locale, format, *args)"));
        }
        List<List<Integer>> list2 = this.mClusterStrokesIndices;
        if (list2 != null) {
            for (int i = 0; i < size; i++) {
                if (list.get(i).longValue() > diff) {
                    list2.add(arrayList);
                    Log.i(TAG, "Add new cluster : #strokes = " + arrayList.size());
                    Log.i(TAG, "Total number of Cluster = " + list2.size());
                    arrayList = new ArrayList();
                    arrayList.add(Integer.valueOf(i + 1));
                    StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                    Locale locale = Locale.getDefault();
                    List<Long> list3 = this.mTimeDiffs;
                    Intrinsics.checkNotNull(list3);
                    Log.i(TAG, AbstractC11014a.m12323h(new Object[]{list3.get(i), Long.valueOf(diff)}, 2, locale, "Create new cluster : Time diff(%d) > Avg(%d)", "format(locale, format, *args)"));
                } else {
                    arrayList.add(Integer.valueOf(i + 1));
                }
            }
            if (arrayList.size() > 0) {
                list2.add(arrayList);
                Log.i(TAG, "Add new cluster : #strokes = " + arrayList.size());
                AbstractC2322a.m1631u(list2.size(), "Total number of Cluster = ", TAG);
            }
            return true;
        }
        return false;
    }

    private final void makeTimeStamps(List<SpenObjectStroke> strokes) {
        this.mTimestamps = new ArrayList();
        this.mTimeDiffs = new ArrayList();
        Iterator<SpenObjectStroke> it = strokes.iterator();
        long j = -1;
        long j2 = -1;
        while (it.hasNext()) {
            long appendTime = it.next().getAppendTime();
            if (j < 0) {
                j2 = appendTime;
                j = 0;
            } else {
                long j3 = appendTime - j2;
                List<Long> list = this.mTimestamps;
                if (list != null) {
                    list.add(Long.valueOf(j3));
                }
                List<Long> list2 = this.mTimeDiffs;
                if (list2 != null) {
                    list2.add(Long.valueOf(j3 - j));
                }
                j = j3;
            }
        }
    }

    public final boolean cluster(@Nullable List<SpenObjectStroke> strokes, long threshold) {
        if (strokes == null || strokes.size() == 0) {
            return false;
        }
        makeTimeStamps(strokes);
        if (analyzeTimeStamps()) {
            return clusterStrokesByTimeDiff(threshold);
        }
        return false;
    }

    public final int getClusterCount() {
        List<List<Integer>> list = this.mClusterStrokesIndices;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @NotNull
    public final List<Integer> getStrokeIndicesOfCluster(int clusterIndex) {
        List<Integer> list;
        int clusterCount = getClusterCount();
        if (clusterIndex < 0 || clusterIndex >= clusterCount) {
            return new ArrayList();
        }
        List<List<Integer>> list2 = this.mClusterStrokesIndices;
        return (list2 == null || (list = list2.get(clusterIndex)) == null) ? new ArrayList() : list;
    }

    public final void printLog() {
        List<Long> list = this.mTimestamps;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                Log.i(TAG, AbstractC11014a.m12323h(new Object[]{list.get(i), list.get(i)}, 2, Locale.getDefault(), "[%d] (+%d)", "format(locale, format, *args)"));
            }
            Log.i(TAG, "Writing Time: " + list.get(size - 1));
            Log.i(TAG, "Average Time Diff: " + this.mDiffAverage);
            Log.i(TAG, "Max Time Diff: " + this.mDiffMax);
        }
        List<List<Integer>> list2 = this.mClusterStrokesIndices;
        if (list2 != null) {
            int size2 = list2.size();
            AbstractC2322a.m1631u(size2, "Total Clusters : ", TAG);
            for (int i2 = 0; i2 < size2; i2++) {
                List<Integer> list3 = list2.get(i2);
                StringBuilder sbM1173s = AbstractC0622a.m1173s(i2, list3.size(), "Cluster[", "] : ", " strokes - ");
                sbM1173s.append(list3);
                Log.i(TAG, sbM1173s.toString());
            }
        }
    }
}
