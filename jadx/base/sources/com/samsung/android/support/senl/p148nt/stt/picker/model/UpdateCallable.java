package com.samsung.android.support.senl.p148nt.stt.picker.model;

import androidx.core.app.NotificationCompat;
import com.samsung.android.support.senl.p148nt.stt.base.filedata.M4aConsts;
import com.samsung.android.support.senl.p148nt.stt.base.filedata.M4aInfo;
import com.samsung.android.support.senl.p148nt.stt.base.filedata.M4aReader;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u0012BE\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012$\u0010\u0006\u001a \u0012\u0004\u0012\u00020\b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\tj\b\u0012\u0004\u0012\u00020\u0005`\n\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\n\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u0006\u001a \u0012\u0004\u0012\u00020\b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\tj\b\u0012\u0004\u0012\u00020\u0005`\n\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/picker/model/UpdateCallable;", "Ljava/util/concurrent/Callable;", "", "mMediaItemsList", "", "Lcom/samsung/android/support/senl/nt/stt/picker/model/RecordingItem;", "mRecordingItemList", "", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mListener", "Lcom/samsung/android/support/senl/nt/stt/picker/model/LoadVoiceListener;", "<init>", "(Ljava/util/List;Ljava/util/Map;Lcom/samsung/android/support/senl/nt/stt/picker/model/LoadVoiceListener;)V", NotificationCompat.CATEGORY_CALL, "updateRecordingItemAdapter", "", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class UpdateCallable implements Callable<Object> {

    @NotNull
    private static final String TAG = "UpdateCallable";

    @Nullable
    private final LoadVoiceListener mListener;

    @NotNull
    private final List<RecordingItem> mMediaItemsList;

    @Nullable
    private final Map<Integer, ArrayList<RecordingItem>> mRecordingItemList;

    /* JADX WARN: Multi-variable type inference failed */
    public UpdateCallable(@NotNull List<? extends RecordingItem> mMediaItemsList, @Nullable Map<Integer, ArrayList<RecordingItem>> map, @Nullable LoadVoiceListener loadVoiceListener) {
        Intrinsics.checkNotNullParameter(mMediaItemsList, "mMediaItemsList");
        this.mMediaItemsList = mMediaItemsList;
        this.mRecordingItemList = map;
        this.mListener = loadVoiceListener;
    }

    private final void updateRecordingItemAdapter() {
        Logger.m12713i(TAG, "Update Voice Data Info Adapter, Current Thread " + Thread.currentThread().getName());
        Map<Integer, ArrayList<RecordingItem>> map = this.mRecordingItemList;
        ArrayList<RecordingItem> arrayList = map != null ? map.get(0) : null;
        Map<Integer, ArrayList<RecordingItem>> map2 = this.mRecordingItemList;
        ArrayList<RecordingItem> arrayList2 = map2 != null ? map2.get(1) : null;
        Map<Integer, ArrayList<RecordingItem>> map3 = this.mRecordingItemList;
        ArrayList<RecordingItem> arrayList3 = map3 != null ? map3.get(2) : null;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            Map<Integer, ArrayList<RecordingItem>> map4 = this.mRecordingItemList;
            if (map4 != null) {
                map4.put(0, arrayList);
            }
        }
        if (arrayList2 == null) {
            arrayList2 = new ArrayList<>();
            Map<Integer, ArrayList<RecordingItem>> map5 = this.mRecordingItemList;
            if (map5 != null) {
                map5.put(1, arrayList2);
            }
        }
        if (arrayList3 == null) {
            arrayList3 = new ArrayList<>();
            Map<Integer, ArrayList<RecordingItem>> map6 = this.mRecordingItemList;
            if (map6 != null) {
                map6.put(2, arrayList3);
            }
        }
        for (RecordingItem recordingItem : this.mMediaItemsList) {
            if (recordingItem.getIsInternalPath()) {
                arrayList.add(recordingItem);
            } else {
                String path = recordingItem.getPath();
                if (M4aReader.isM4A(path)) {
                    M4aInfo file = new M4aReader(path).readFile();
                    if (file.hasAtom(M4aConsts.SMTA)) {
                        int recordingMode = file.getRecordingMode();
                        if (100 <= recordingMode && recordingMode < 200) {
                            arrayList2.add(recordingItem);
                        } else if (200 > recordingMode || recordingMode >= 300) {
                            arrayList3.add(recordingItem);
                        } else {
                            arrayList.add(recordingItem);
                        }
                    }
                }
            }
        }
        LoadVoiceListener loadVoiceListener = this.mListener;
        if (loadVoiceListener != null) {
            loadVoiceListener.onUpdate();
        }
    }

    @Override // java.util.concurrent.Callable
    @Nullable
    public Object call() {
        Logger.m12713i(TAG, "call()");
        try {
            if (Thread.interrupted()) {
                Logger.m12711e(TAG, "call(), InterruptedException");
                throw new InterruptedException();
            }
            updateRecordingItemAdapter();
            return null;
        } catch (InterruptedException e) {
            Logger.m12711e(TAG, "InterruptedException: " + e);
            return null;
        }
    }
}
