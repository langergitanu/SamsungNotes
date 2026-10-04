package com.samsung.android.support.senl.p148nt.stt.picker.presenter;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.RunnableC9767a;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.ContentFileData;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import com.samsung.android.support.senl.p148nt.stt.picker.model.LoadVoiceListener;
import com.samsung.android.support.senl.p148nt.stt.picker.model.RecordingItem;
import com.samsung.android.support.senl.p148nt.stt.picker.model.UpdateCallable;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.p196io.CloseableKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 &2\u00020\u0001:\u0002&'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rJ6\u0010\u000e\u001a\u00020\r2$\u0010\u000f\u001a \u0012\u0004\u0012\u00020\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u0011\u001a\u00020\rJ\u0018\u0010\u0012\u001a\u00020\r2\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0014J\u001a\u0010\u0016\u001a\u00020\r2\u0010\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0014H\u0002J\u0010\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0014H\u0002J \u0010\u001a\u001a\u00020\r2\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0007j\b\u0012\u0004\u0012\u00020\u0019`\tH\u0002J\b\u0010\u001c\u001a\u00020\rH\u0002J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0014H\u0002J \u0010\"\u001a\u00020\r2\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020!0\u0007j\b\u0012\u0004\u0012\u00020!`\tH\u0002J$\u0010$\u001a\u00020\r2\u001a\u0010%\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tH\u0002R,\u0010\u0004\u001a \u0012\u0004\u0012\u00020\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/picker/presenter/VoiceDataUpdater;", "", "<init>", "()V", "mRecordingItemList", "", "", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/nt/stt/picker/model/RecordingItem;", "Lkotlin/collections/ArrayList;", "mListener", "Lcom/samsung/android/support/senl/nt/stt/picker/model/LoadVoiceListener;", "clear", "", "setItemInfo", "recordingItemList", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "syncVoiceProviderWithMediaProvider", "syncVoiceObserver", "contentFileData", "", "Lcom/samsung/android/support/senl/nt/data/database/core/document/data/ContentFileData;", "startSyncAllVoiceInternalNotes", "notesVoiceDataList", "getAllPath", "", "deleteRecordingPathItem", "m4aMediaProviderPathList", "startSyncAllVoices", "syncToVoice", "mediaProviderCursor", "Landroid/database/Cursor;", "getAllID", "", "deleteRecordingItem", "m4aMediaProviderIdList", "insertRecordingItem", "mediaUpdateItemList", "Companion", "SplitM4a", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVoiceDataUpdater.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VoiceDataUpdater.kt\ncom/samsung/android/support/senl/nt/stt/picker/presenter/VoiceDataUpdater\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,321:1\n1#2:322\n*E\n"})
public final class VoiceDataUpdater {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int MAX_POOL_SIZE = Runtime.getRuntime().availableProcessors();

    @NotNull
    private static final String TAG = "VoiceDataUpdater";

    @Nullable
    private static VoiceDataUpdater mInstance;

    @Nullable
    private LoadVoiceListener mListener;

    @Nullable
    private Map<Integer, ArrayList<RecordingItem>> mRecordingItemList;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/picker/presenter/VoiceDataUpdater$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "MAX_POOL_SIZE", "", "mInstance", "Lcom/samsung/android/support/senl/nt/stt/picker/presenter/VoiceDataUpdater;", "getInstance", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final synchronized VoiceDataUpdater getInstance() {
            try {
                if (VoiceDataUpdater.mInstance == null) {
                    VoiceDataUpdater.mInstance = new VoiceDataUpdater();
                }
            } catch (Throwable th) {
                throw th;
            }
            return VoiceDataUpdater.mInstance;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004JB\u0010\u0005\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007`\b2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0006j\b\u0012\u0004\u0012\u00028\u0000`\b2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/picker/presenter/VoiceDataUpdater$SplitM4a;", "T", "", "<init>", "()V", "splitM4aList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "mediaUpdateItemList", "chunkSize", "", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class SplitM4a<T> {
        @NotNull
        public final ArrayList<List<T>> splitM4aList(@NotNull ArrayList<T> mediaUpdateItemList, int chunkSize) {
            Intrinsics.checkNotNullParameter(mediaUpdateItemList, "mediaUpdateItemList");
            ArrayList<List<T>> arrayList = new ArrayList<>();
            int size = mediaUpdateItemList.size();
            int i = 0;
            int i2 = chunkSize;
            while (i2 < mediaUpdateItemList.size()) {
                arrayList.add(mediaUpdateItemList.subList(i, i2));
                size -= chunkSize;
                i += chunkSize;
                i2 += chunkSize;
            }
            if (size > 0) {
                arrayList.add(mediaUpdateItemList.subList(i, size + i));
            }
            return arrayList;
        }
    }

    private final void deleteRecordingItem(ArrayList<Long> m4aMediaProviderIdList) {
        int size = m4aMediaProviderIdList.size();
        for (int i = 0; i < size; i++) {
            boolean z = false;
            for (int i2 = 0; i2 < 3; i2++) {
                Map<Integer, ArrayList<RecordingItem>> map = this.mRecordingItemList;
                Intrinsics.checkNotNull(map);
                ArrayList<RecordingItem> arrayList = map.get(Integer.valueOf(i2));
                if (arrayList != null) {
                    int size2 = arrayList.size();
                    int i4 = 0;
                    while (true) {
                        if (i4 >= size2) {
                            break;
                        }
                        long mediaId = arrayList.get(i4).getMediaId();
                        Long l = m4aMediaProviderIdList.get(i);
                        if (l != null && mediaId == l.longValue()) {
                            arrayList.remove(i4);
                            z = true;
                            break;
                        }
                        i4++;
                    }
                    if (z) {
                        break;
                    }
                }
            }
        }
    }

    private final void deleteRecordingPathItem(ArrayList<String> m4aMediaProviderPathList) {
        LoadVoiceListener loadVoiceListener;
        Map<Integer, ArrayList<RecordingItem>> map = this.mRecordingItemList;
        Intrinsics.checkNotNull(map);
        ArrayList<RecordingItem> arrayList = map.get(0);
        if (arrayList != null) {
            int size = m4aMediaProviderPathList.size();
            for (int i = 0; i < size; i++) {
                int size2 = arrayList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size2) {
                        break;
                    }
                    if (Intrinsics.areEqual(arrayList.get(i2).getPath(), m4aMediaProviderPathList.get(i))) {
                        arrayList.remove(i2);
                        break;
                    }
                    i2++;
                }
            }
        }
        if (m4aMediaProviderPathList.isEmpty() || (loadVoiceListener = this.mListener) == null) {
            return;
        }
        loadVoiceListener.onUpdate();
    }

    private final List<Long> getAllID() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 3; i++) {
            Map<Integer, ArrayList<RecordingItem>> map = this.mRecordingItemList;
            Intrinsics.checkNotNull(map);
            ArrayList<RecordingItem> arrayList2 = map.get(Integer.valueOf(i));
            if (arrayList2 != null) {
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (!arrayList2.get(i2).getIsInternalPath()) {
                        arrayList.add(Long.valueOf(arrayList2.get(i2).getMediaId()));
                    }
                }
            }
        }
        return arrayList;
    }

    private final List<String> getAllPath() {
        ArrayList arrayList = new ArrayList();
        Map<Integer, ArrayList<RecordingItem>> map = this.mRecordingItemList;
        Intrinsics.checkNotNull(map);
        ArrayList<RecordingItem> arrayList2 = map.get(0);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                if (arrayList2.get(i).getIsInternalPath()) {
                    arrayList.add(arrayList2.get(i).getPath());
                }
            }
        }
        return arrayList;
    }

    private final void insertRecordingItem(ArrayList<RecordingItem> mediaUpdateItemList) {
        if (mediaUpdateItemList == null) {
            return;
        }
        int size = mediaUpdateItemList.size();
        AbstractC11014a.m12327l(size, "insertRecordingItem - list updated m4a size = ", TAG);
        int i = MAX_POOL_SIZE;
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(i);
        ArrayList arrayList = new ArrayList();
        try {
            try {
                if (size < 50) {
                    arrayList.add(new UpdateCallable(mediaUpdateItemList, this.mRecordingItemList, this.mListener));
                } else {
                    if (i != 1) {
                        i /= 2;
                    }
                    Iterator it = new SplitM4a().splitM4aList(mediaUpdateItemList, size % i != 0 ? (size / i) + 1 : size / i).iterator();
                    Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                    while (it.hasNext()) {
                        Object next = it.next();
                        Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                        arrayList.add(new UpdateCallable((List) next, this.mRecordingItemList, this.mListener));
                    }
                }
                executorServiceNewFixedThreadPool.invokeAll(arrayList);
                executorServiceNewFixedThreadPool.shutdown();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } catch (Throwable th) {
            executorServiceNewFixedThreadPool.shutdown();
            throw th;
        }
    }

    private final void startSyncAllVoiceInternalNotes(List<? extends ContentFileData> notesVoiceDataList) {
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(MAX_POOL_SIZE);
        TreeSet treeSet = new TreeSet(getAllPath());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            if (notesVoiceDataList == null) {
                executorServiceNewFixedThreadPool.shutdown();
                return;
            }
            try {
                Iterator<? extends ContentFileData> it = notesVoiceDataList.iterator();
                while (it.hasNext()) {
                    ContentFileData next = it.next();
                    String str = next != null ? next.docPath : null;
                    String str2 = File.separator;
                    String str3 = str + str2 + "media" + str2 + (next != null ? next.contentFilePath : null);
                    if (!treeSet.remove(str3)) {
                        Long lValueOf = next != null ? Long.valueOf(next.createdAt) : null;
                        Intrinsics.checkNotNull(lValueOf);
                        arrayList2.add(new RecordingItem(-1L, str3, "", lValueOf.longValue(), next.displayName, (int) next.size, true));
                    }
                }
                int size = arrayList2.size();
                if (size < 50) {
                    arrayList.add(new UpdateCallable(arrayList2, this.mRecordingItemList, this.mListener));
                } else {
                    int i = MAX_POOL_SIZE;
                    if (i != 1) {
                        i /= 2;
                    }
                    Iterator it2 = new SplitM4a().splitM4aList(new ArrayList(arrayList2), size % i != 0 ? (size / i) + 1 : size / i).iterator();
                    Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                    while (it2.hasNext()) {
                        Object next2 = it2.next();
                        Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                        arrayList.add(new UpdateCallable((List) next2, this.mRecordingItemList, this.mListener));
                    }
                }
                deleteRecordingPathItem(new ArrayList<>(treeSet));
                executorServiceNewFixedThreadPool.invokeAll(arrayList);
                executorServiceNewFixedThreadPool.shutdown();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } catch (Throwable th) {
            executorServiceNewFixedThreadPool.shutdown();
            throw th;
        }
    }

    private final void startSyncAllVoices() {
        Logger.m12713i(TAG, "Start sync Voice with MediaProvider");
        new Thread(new RunnableC9767a(this, 26)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startSyncAllVoices$lambda$3(VoiceDataUpdater voiceDataUpdater) {
        ContentResolver contentResolver;
        String[] strArr = {"_id", "_data", "album", "title", "datetaken", "_size"};
        Context applicationContext = BaseUtils.getApplicationContext();
        Cursor cursorQuery = (applicationContext == null || (contentResolver = applicationContext.getContentResolver()) == null) ? null : contentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, strArr, null, null, "title DESC");
        try {
            Cursor cursor = cursorQuery;
            if (cursor != null && !cursor.isClosed()) {
                Logger.m12713i(TAG, "syncVoiceProviderWithMediaProvider, cursor count = " + cursor.getCount());
                voiceDataUpdater.syncToVoice(cursor);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursorQuery, null);
                return;
            }
            Logger.m12711e(TAG, "Return here because mCursor is null or closed");
            CloseableKt.closeFinally(cursorQuery, null);
        } finally {
        }
    }

    private final void syncToVoice(Cursor mediaProviderCursor) {
        TreeSet treeSet = new TreeSet(getAllID());
        ArrayList<RecordingItem> arrayList = new ArrayList<>();
        if (mediaProviderCursor.isClosed() || mediaProviderCursor.getCount() < 0) {
            return;
        }
        int columnIndex = mediaProviderCursor.getColumnIndex("_id");
        int columnIndex2 = mediaProviderCursor.getColumnIndex("_data");
        int columnIndex3 = mediaProviderCursor.getColumnIndex("album");
        int columnIndex4 = mediaProviderCursor.getColumnIndex("datetaken");
        int columnIndex5 = mediaProviderCursor.getColumnIndex("title");
        int columnIndex6 = mediaProviderCursor.getColumnIndex("_size");
        while (mediaProviderCursor.moveToNext()) {
            long j = mediaProviderCursor.getLong(columnIndex);
            if (!treeSet.remove(Long.valueOf(j))) {
                arrayList.add(new RecordingItem(j, mediaProviderCursor.getString(columnIndex2), mediaProviderCursor.getString(columnIndex3), mediaProviderCursor.getLong(columnIndex4), mediaProviderCursor.getString(columnIndex5), mediaProviderCursor.getInt(columnIndex6), false));
            }
        }
        deleteRecordingItem(new ArrayList<>(treeSet));
        insertRecordingItem(arrayList);
    }

    public final void clear() {
        this.mListener = null;
        mInstance = null;
    }

    public final void setItemInfo(@Nullable Map<Integer, ArrayList<RecordingItem>> recordingItemList, @Nullable LoadVoiceListener listener) {
        this.mRecordingItemList = recordingItemList;
        this.mListener = listener;
    }

    public final void syncVoiceObserver(@Nullable List<? extends ContentFileData> contentFileData) {
        synchronized (this) {
            startSyncAllVoiceInternalNotes(contentFileData);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void syncVoiceProviderWithMediaProvider() {
        synchronized (this) {
            startSyncAllVoices();
            Unit unit = Unit.INSTANCE;
        }
    }
}
