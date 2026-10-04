package com.samsung.android.support.senl.p148nt.stt.picker.presenter;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.list.pages.C9152a;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.ContentFileData;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.model.utils.VoiceDataUtil;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import com.samsung.android.support.senl.p148nt.stt.picker.model.FilterInfo;
import com.samsung.android.support.senl.p148nt.stt.picker.model.LoadVoiceListener;
import com.samsung.android.support.senl.p148nt.stt.picker.model.RecordingItem;
import com.samsung.android.support.senl.p148nt.stt.picker.presenter.VoiceDataUpdater;
import com.samsung.android.support.senl.p148nt.stt.picker.utils.InitialKoreanUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 K2\u00020\u0001:\u0002KLB=\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\"\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t0\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020 J\u0010\u0010(\u001a\u00020 2\b\u0010)\u001a\u0004\u0018\u00010\u001eJ\b\u0010*\u001a\u0004\u0018\u00010\u001eJ\u0006\u0010+\u001a\u00020 J&\u0010,\u001a\u00020 2\u001e\u0010-\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u0018\u00010\u001bJ\u0014\u0010.\u001a\u00020 2\f\u0010-\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001bJ\u0016\u0010/\u001a\u0002002\f\u0010-\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001bH\u0002J$\u00101\u001a\u00020 2\u001a\u00102\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tH\u0002J\b\u00103\u001a\u00020 H\u0002J\b\u00104\u001a\u00020 H\u0002J\u0006\u00105\u001a\u00020\u000fJ\u000e\u00106\u001a\u00020 2\u0006\u00107\u001a\u00020\u000fJ\u000e\u00108\u001a\u00020 2\u0006\u00109\u001a\u00020:J\u0016\u0010;\u001a\u00020 2\u0006\u0010<\u001a\u00020:2\u0006\u0010=\u001a\u000200J\u0011\u0010>\u001a\b\u0012\u0004\u0012\u00020\u000f0?¢\u0006\u0002\u0010@J\u0010\u0010A\u001a\u00020B2\u0006\u0010=\u001a\u000200H\u0002J\u0010\u0010C\u001a\u0002002\u0006\u00107\u001a\u00020\u000fH\u0002J\u001c\u0010D\u001a\u00060Ej\u0002`F2\u0006\u0010)\u001a\u00020\u001e2\u0006\u0010G\u001a\u000200H\u0002J\f\u0010H\u001a\u00060Ej\u0002`FH\u0002J\f\u0010I\u001a\u00060Ej\u0002`FH\u0002J\f\u0010J\u001a\u00060Ej\u0002`FH\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0018\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u001a\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t0\u001b0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00150#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006M"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/picker/presenter/CursorProvider;", "", "mAppContext", "Landroid/content/Context;", "mRecordingItemList", "", "", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/nt/stt/picker/model/RecordingItem;", "Lkotlin/collections/ArrayList;", "mListener", "Lcom/samsung/android/support/senl/nt/stt/picker/model/LoadVoiceListener;", "<init>", "(Landroid/content/Context;Ljava/util/Map;Lcom/samsung/android/support/senl/nt/stt/picker/model/LoadVoiceListener;)V", "mRecordingSearchTag", "", "mLastTimeOfMPChange", "", "mLastTimeOfNotesChange", "mListLiveData", "Landroidx/lifecycle/LiveData;", "", "Lcom/samsung/android/support/senl/nt/data/database/core/document/data/ContentFileData;", "mContentFileData", "mLoaderCallback", "Landroidx/loader/app/LoaderManager$LoaderCallbacks;", "mCursorChangeListeners", "Lcom/samsung/android/support/senl/nt/stt/picker/presenter/CursorProvider$OnCursorChangeListener;", "mRecordingInfoList", "mFilterInfo", "Lcom/samsung/android/support/senl/nt/stt/picker/model/FilterInfo;", "registerObservers", "", "unregisterObservers", "mListObserver", "Landroidx/lifecycle/Observer;", "mContentObserver", "Landroid/database/ContentObserver;", "mMediaProviderChangedHandler", "Landroid/os/Handler;", "setFilterInfo", "filterInfo", "getFilterInfo", "resetFilterInfo", "registerCursorChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "unregisterCursorChangeListener", "containsListener", "", "notifyCursorChangedObservers", XmlErrorCodes.LIST, "notifyCursorLoadFailObservers", "notifyDataSetChangedObservers", "getSearchTag", "setSearchTag", "searchTag", "reload", "loaderManager", "Landroidx/loader/app/LoaderManager;", "load", "manager", "limit", "getItemSummaryProjection", "", "()[Ljava/lang/String;", "getBundleArguments", "Landroid/os/Bundle;", "checkInitialSelection", "getSearchTimeFilterSelection", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "isInternal", "getSearchSelection", "getSearchSQLSelection", "getBaseQuery", "Companion", "OnCursorChangeListener", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nCursorProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CursorProvider.kt\ncom/samsung/android/support/senl/nt/stt/picker/presenter/CursorProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,426:1\n739#2,9:427\n739#2,9:440\n739#2,9:453\n37#3:436\n36#3,3:437\n37#3:449\n36#3,3:450\n37#3:462\n36#3,3:463\n*S KotlinDebug\n*F\n+ 1 CursorProvider.kt\ncom/samsung/android/support/senl/nt/stt/picker/presenter/CursorProvider\n*L\n307#1:427,9\n369#1:440,9\n396#1:453,9\n308#1:436\n308#1:437,3\n370#1:449\n370#1:450,3\n397#1:462\n397#1:463,3\n*E\n"})
public final class CursorProvider {
    private static final int MSG_MEDIA_INTERNAL_CHANGED = 2;
    private static final int MSG_MEDIA_PROVIDER_CHANGED = 1;

    @NotNull
    private static final String TAG = "CursorProvider";
    private static final long UPDATE_MP_TIME_MS = 10000;

    @Nullable
    private Context mAppContext;

    @Nullable
    private List<ContentFileData> mContentFileData;

    @NotNull
    private final ContentObserver mContentObserver;

    @NotNull
    private final List<OnCursorChangeListener<ArrayList<RecordingItem>>> mCursorChangeListeners;

    @Nullable
    private FilterInfo mFilterInfo;
    private long mLastTimeOfMPChange;
    private long mLastTimeOfNotesChange;

    @Nullable
    private LiveData<List<ContentFileData>> mListLiveData;

    @NotNull
    private final Observer<List<ContentFileData>> mListObserver;

    @NotNull
    private final LoadVoiceListener mListener;

    @Nullable
    private LoaderManager.LoaderCallbacks<ArrayList<RecordingItem>> mLoaderCallback;

    @NotNull
    private final Handler mMediaProviderChangedHandler;

    @Nullable
    private List<RecordingItem> mRecordingInfoList;

    @NotNull
    private final Map<Integer, ArrayList<RecordingItem>> mRecordingItemList;

    @NotNull
    private String mRecordingSearchTag;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0004H&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/picker/presenter/CursorProvider$OnCursorChangeListener;", "T", "", "onCursorChanged", "", XmlErrorCodes.LIST, "(Ljava/lang/Object;)V", "onCursorLoadFail", "notifyDataSetChanged", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnCursorChangeListener<T> {
        void notifyDataSetChanged();

        void onCursorChanged(@Nullable T list);

        void onCursorLoadFail();
    }

    public CursorProvider(@Nullable Context context, @NotNull Map<Integer, ArrayList<RecordingItem>> mRecordingItemList, @NotNull LoadVoiceListener mListener) {
        Intrinsics.checkNotNullParameter(mRecordingItemList, "mRecordingItemList");
        Intrinsics.checkNotNullParameter(mListener, "mListener");
        this.mAppContext = context;
        this.mRecordingItemList = mRecordingItemList;
        this.mListener = mListener;
        this.mRecordingSearchTag = "";
        this.mCursorChangeListeners = new ArrayList();
        this.mFilterInfo = new FilterInfo(-1);
        this.mListObserver = new C9152a(this, 1);
        this.mContentObserver = new ContentObserver() { // from class: com.samsung.android.support.senl.nt.stt.picker.presenter.CursorProvider$mContentObserver$1
            {
                super(null);
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean selfChange) {
                if (this.this$0.mLastTimeOfMPChange == 0) {
                    this.this$0.mLastTimeOfMPChange = System.currentTimeMillis();
                }
                if (System.currentTimeMillis() - this.this$0.mLastTimeOfMPChange < 10000) {
                    this.this$0.mMediaProviderChangedHandler.removeMessages(1);
                }
                this.this$0.mMediaProviderChangedHandler.sendEmptyMessageDelayed(1, 200L);
                super.onChange(selfChange);
            }
        };
        final Looper mainLooper = Looper.getMainLooper();
        this.mMediaProviderChangedHandler = new Handler(mainLooper) { // from class: com.samsung.android.support.senl.nt.stt.picker.presenter.CursorProvider$mMediaProviderChangedHandler$1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                int i = msg.what;
                if (i == 1) {
                    Logger.m12713i("CursorProvider", "Handle onChange from MP");
                    VoiceDataUpdater companion = VoiceDataUpdater.INSTANCE.getInstance();
                    if (companion != null) {
                        companion.setItemInfo(this.this$0.mRecordingItemList, this.this$0.mListener);
                    }
                    if (companion != null) {
                        companion.syncVoiceProviderWithMediaProvider();
                    }
                    this.this$0.mLastTimeOfMPChange = 0L;
                    return;
                }
                if (i == 2) {
                    Logger.m12710d("CursorProvider", "mListObserver#onChanged");
                    VoiceDataUpdater.Companion companion2 = VoiceDataUpdater.INSTANCE;
                    VoiceDataUpdater companion3 = companion2.getInstance();
                    if (companion3 != null) {
                        companion3.setItemInfo(this.this$0.mRecordingItemList, this.this$0.mListener);
                    }
                    VoiceDataUpdater companion4 = companion2.getInstance();
                    if (companion4 != null) {
                        companion4.syncVoiceObserver(this.this$0.mContentFileData);
                    }
                    this.this$0.mLastTimeOfNotesChange = 0L;
                }
            }
        };
    }

    private final boolean checkInitialSelection(String searchTag) {
        List listEmptyList;
        if (!Intrinsics.areEqual(Locale.getDefault(), Locale.KOREA)) {
            return false;
        }
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String lowerCase = searchTag.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        List listM13999t = AbstractC12991c.m13999t(0, " +", lowerCase);
        if (listM13999t.isEmpty()) {
            listEmptyList = CollectionsKt.emptyList();
        } else {
            ListIterator listIterator = listM13999t.listIterator(listM13999t.size());
            while (listIterator.hasPrevious()) {
                if (((String) listIterator.previous()).length() != 0) {
                    listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listM13999t);
                    break;
                }
            }
            listEmptyList = CollectionsKt.emptyList();
        }
        boolean zCheckInitialCharacter = false;
        for (String str : (String[]) listEmptyList.toArray(new String[0])) {
            zCheckInitialCharacter = InitialKoreanUtil.INSTANCE.checkInitialCharacter(str);
            if (!zCheckInitialCharacter) {
                return zCheckInitialCharacter;
            }
        }
        return zCheckInitialCharacter;
    }

    private final synchronized boolean containsListener(OnCursorChangeListener<?> listener) {
        if (listener == null) {
            return false;
        }
        Iterator<OnCursorChangeListener<ArrayList<RecordingItem>>> it = this.mCursorChangeListeners.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(listener, it.next())) {
                return true;
            }
        }
        return false;
    }

    private final StringBuilder getBaseQuery() {
        return AbstractC1974b.m1324q("(_data LIKE '%.m4a') and (_data NOT LIKE '%/.393857/%') and (mime_type LIKE 'audio/mp4') and (_size != '0')");
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Bundle getBundleArguments(boolean limit) {
        Bundle bundle = new Bundle();
        StringBuilder baseQuery = getBaseQuery();
        StringBuilder sb = new StringBuilder();
        if (this.mRecordingSearchTag.length() <= 0) {
            FilterInfo filterInfo = this.mFilterInfo;
            if (filterInfo != null) {
                Intrinsics.checkNotNull(filterInfo);
                if (filterInfo.hasTimeFilter()) {
                    if (this.mRecordingSearchTag.length() > 0) {
                        bundle.putString("searchTag", this.mRecordingSearchTag);
                        if (checkInitialSelection(this.mRecordingSearchTag)) {
                            bundle.putBoolean("searchInitial", true);
                        } else {
                            baseQuery.append((CharSequence) getSearchSelection());
                            sb.append((CharSequence) getSearchSQLSelection());
                        }
                    }
                    FilterInfo filterInfo2 = this.mFilterInfo;
                    if (filterInfo2 != null) {
                        Intrinsics.checkNotNull(filterInfo2);
                        if (filterInfo2.hasTimeFilter()) {
                            FilterInfo filterInfo3 = this.mFilterInfo;
                            Intrinsics.checkNotNull(filterInfo3);
                            baseQuery.append((CharSequence) getSearchTimeFilterSelection(filterInfo3, false));
                            FilterInfo filterInfo4 = this.mFilterInfo;
                            Intrinsics.checkNotNull(filterInfo4);
                            sb.append((CharSequence) getSearchTimeFilterSelection(filterInfo4, true));
                        }
                    }
                }
            }
        }
        bundle.putString("selectionQuery", baseQuery.toString());
        bundle.putInt("limit", limit ? 100 : Integer.MAX_VALUE);
        bundle.putString("SQLQuery", sb.toString());
        FilterInfo filterInfo5 = this.mFilterInfo;
        if (filterInfo5 != null) {
            Intrinsics.checkNotNull(filterInfo5);
            bundle.putInt("FilterInfo", filterInfo5.getTime());
        }
        return bundle;
    }

    private final StringBuilder getSearchSQLSelection() {
        List listEmptyList;
        StringBuilder sb = new StringBuilder();
        String str = this.mRecordingSearchTag;
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        List listM13999t = AbstractC12991c.m13999t(0, " +", lowerCase);
        if (listM13999t.isEmpty()) {
            listEmptyList = CollectionsKt.emptyList();
        } else {
            ListIterator listIterator = listM13999t.listIterator(listM13999t.size());
            while (listIterator.hasPrevious()) {
                if (((String) listIterator.previous()).length() != 0) {
                    listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listM13999t);
                    break;
                }
            }
            listEmptyList = CollectionsKt.emptyList();
        }
        String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
        if (strArr.length == 0) {
            return sb;
        }
        sb.append(" AND (");
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            String strM14139M = StringsKt.m14139M(StringsKt.m14139M(new Regex("'").replace(strArr[i], "''"), "%", "\\%"), "_", "\\_");
            sb.append("displayName LIKE '%");
            sb.append(strM14139M);
            sb.append("%' ESCAPE'\\'");
            if (i != strArr.length - 1) {
                sb.append(SQLKeyword.AND);
            }
        }
        sb.append(")");
        return sb;
    }

    private final StringBuilder getSearchSelection() {
        List listEmptyList;
        StringBuilder sb = new StringBuilder();
        String str = this.mRecordingSearchTag;
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        List listM13999t = AbstractC12991c.m13999t(0, " +", lowerCase);
        if (listM13999t.isEmpty()) {
            listEmptyList = CollectionsKt.emptyList();
        } else {
            ListIterator listIterator = listM13999t.listIterator(listM13999t.size());
            while (listIterator.hasPrevious()) {
                if (((String) listIterator.previous()).length() != 0) {
                    listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listM13999t);
                    break;
                }
            }
            listEmptyList = CollectionsKt.emptyList();
        }
        String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
        if (strArr.length == 0) {
            return sb;
        }
        sb.append(" AND (");
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            String strM14139M = StringsKt.m14139M(StringsKt.m14139M(new Regex("'").replace(strArr[i], "''"), "%", "\\%"), "_", "\\_");
            sb.append("substr(LOWER(_display_name), 1, LENGTH(_display_name) - 4) LIKE '%");
            sb.append(strM14139M);
            sb.append("%' ESCAPE'\\'");
            if (i != strArr.length - 1) {
                sb.append(SQLKeyword.AND);
            }
        }
        sb.append(")");
        return sb;
    }

    private final StringBuilder getSearchTimeFilterSelection(FilterInfo filterInfo, boolean isInternal) {
        StringBuilder sb = new StringBuilder();
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        int time = filterInfo.getTime();
        if (time == 0) {
            calendar2.add(5, -1);
            calendar2.set(11, 23);
            calendar2.set(12, 59);
            calendar2.set(13, 59);
            calendar.add(5, -1);
        } else if (time == 1) {
            calendar.add(5, -7);
        } else if (time == 2) {
            calendar.add(5, -30);
        }
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        long timeInMillis = calendar.getTimeInMillis();
        long timeInMillis2 = calendar2.getTimeInMillis();
        if (isInternal) {
            AbstractC1038a.m1223x(sb, " AND (content.createdAt BETWEEN ", timeInMillis, SQLKeyword.AND);
            sb.append(timeInMillis2);
            sb.append(")");
            return sb;
        }
        AbstractC1038a.m1223x(sb, " and ((datetaken BETWEEN ", timeInMillis, SQLKeyword.AND);
        sb.append(timeInMillis2);
        sb.append(") OR ((_data LIKE '%.amr') and (date_added BETWEEN ");
        long j = 1000;
        sb.append(timeInMillis / j);
        sb.append(SQLKeyword.AND);
        sb.append(timeInMillis2 / j);
        sb.append(")))");
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mListObserver$lambda$0(CursorProvider cursorProvider, List contentFileData) {
        Intrinsics.checkNotNullParameter(contentFileData, "contentFileData");
        cursorProvider.mContentFileData = contentFileData;
        if (cursorProvider.mLastTimeOfNotesChange == 0) {
            cursorProvider.mLastTimeOfNotesChange = System.currentTimeMillis();
        }
        if (System.currentTimeMillis() - cursorProvider.mLastTimeOfNotesChange < 10000) {
            cursorProvider.mMediaProviderChangedHandler.removeMessages(2);
        }
        cursorProvider.mMediaProviderChangedHandler.sendEmptyMessageDelayed(2, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void notifyCursorChangedObservers(ArrayList<RecordingItem> list) {
        Iterator<OnCursorChangeListener<ArrayList<RecordingItem>>> it = this.mCursorChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().onCursorChanged(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void notifyCursorLoadFailObservers() {
        Iterator<OnCursorChangeListener<ArrayList<RecordingItem>>> it = this.mCursorChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().onCursorLoadFail();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void notifyDataSetChangedObservers() {
        Iterator<OnCursorChangeListener<ArrayList<RecordingItem>>> it = this.mCursorChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().notifyDataSetChanged();
        }
    }

    @Nullable
    /* JADX INFO: renamed from: getFilterInfo, reason: from getter */
    public final FilterInfo getMFilterInfo() {
        return this.mFilterInfo;
    }

    @NotNull
    public final String[] getItemSummaryProjection() {
        return new String[]{"_id", "title", "_display_name", "datetaken", "date_modified", XmlErrorCodes.DURATION, "mime_type", "_data", "_size"};
    }

    @NotNull
    public final String getSearchTag() {
        String str = this.mRecordingSearchTag;
        return str.length() == 0 ? "" : str;
    }

    public final void load(@NotNull LoaderManager manager, boolean limit) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        if (this.mLoaderCallback == null) {
            this.mLoaderCallback = new LoaderManager.LoaderCallbacks<ArrayList<RecordingItem>>() { // from class: com.samsung.android.support.senl.nt.stt.picker.presenter.CursorProvider.load.1
                @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
                public void onLoaderReset(Loader<ArrayList<RecordingItem>> loader) {
                    Intrinsics.checkNotNullParameter(loader, "loader");
                    Logger.m12713i(CursorProvider.TAG, "onLoaderReset");
                }

                @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
                public Loader<ArrayList<RecordingItem>> onCreateLoader(int id, Bundle args) {
                    Logger.m12713i(CursorProvider.TAG, "onCreateLoader mRecordingSearchTag : " + CursorProvider.this.mRecordingSearchTag);
                    Context context = CursorProvider.this.mAppContext;
                    Intrinsics.checkNotNull(context);
                    Uri EXTERNAL_CONTENT_URI = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    Intrinsics.checkNotNullExpressionValue(EXTERNAL_CONTENT_URI, "EXTERNAL_CONTENT_URI");
                    String[] itemSummaryProjection = CursorProvider.this.getItemSummaryProjection();
                    Intrinsics.checkNotNull(args);
                    CursorLoaderTask cursorLoaderTask = new CursorLoaderTask(context, EXTERNAL_CONTENT_URI, itemSummaryProjection, args, CursorProvider.this.mRecordingItemList);
                    cursorLoaderTask.forceLoad();
                    return cursorLoaderTask;
                }

                @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
                public synchronized void onLoadFinished(Loader<ArrayList<RecordingItem>> loader, ArrayList<RecordingItem> data) {
                    Intrinsics.checkNotNullParameter(loader, "loader");
                    Logger.m12713i(CursorProvider.TAG, "onLoadFinished");
                    if (data == null) {
                        Logger.m12711e(CursorProvider.TAG, "onLoadFinished - new list is NULL");
                        if (!CursorProvider.this.mCursorChangeListeners.isEmpty()) {
                            CursorProvider.this.notifyCursorLoadFailObservers();
                        }
                        return;
                    }
                    if (!CursorProvider.this.mCursorChangeListeners.isEmpty()) {
                        if (CursorProvider.this.mRecordingInfoList != null) {
                            List list = CursorProvider.this.mRecordingInfoList;
                            Intrinsics.checkNotNull(list);
                            if (list.size() != data.size()) {
                                CursorProvider.this.notifyDataSetChangedObservers();
                            }
                        }
                        CursorProvider.this.notifyCursorChangedObservers(data);
                    }
                    CursorProvider.this.mRecordingInfoList = data;
                }
            };
        }
        Bundle bundleArguments = getBundleArguments(limit);
        LoaderManager.LoaderCallbacks<ArrayList<RecordingItem>> loaderCallbacks = this.mLoaderCallback;
        Intrinsics.checkNotNull(loaderCallbacks);
        manager.initLoader(0, bundleArguments, loaderCallbacks);
    }

    public final synchronized void registerCursorChangeListener(@Nullable OnCursorChangeListener<ArrayList<RecordingItem>> listener) {
        if (listener != null) {
            if (!containsListener(listener)) {
                this.mCursorChangeListeners.add(listener);
            }
        }
    }

    public final void registerObservers() {
        if (this.mAppContext == null) {
            this.mAppContext = BaseUtils.getApplicationContext();
        }
        Context context = this.mAppContext;
        if (context != null) {
            Intrinsics.checkNotNull(context);
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver != null) {
                contentResolver.registerContentObserver(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, true, this.mContentObserver);
            }
            LiveData<List<ContentFileData>> liveContentFileData = VoiceDataUtil.getLiveContentFileData(this.mAppContext);
            this.mListLiveData = liveContentFileData;
            if (liveContentFileData != null) {
                liveContentFileData.observeForever(this.mListObserver);
            }
        }
    }

    public final void reload(@NotNull LoaderManager loaderManager) {
        Intrinsics.checkNotNullParameter(loaderManager, "loaderManager");
        Logger.m12713i(TAG, "reload");
        if (this.mLoaderCallback == null) {
            load(loaderManager, true);
            return;
        }
        Bundle bundleArguments = getBundleArguments(false);
        LoaderManager.LoaderCallbacks<ArrayList<RecordingItem>> loaderCallbacks = this.mLoaderCallback;
        Intrinsics.checkNotNull(loaderCallbacks);
        Intrinsics.checkNotNull(loaderManager.restartLoader(0, bundleArguments, loaderCallbacks));
    }

    public final void resetFilterInfo() {
        if (this.mFilterInfo != null) {
            this.mFilterInfo = new FilterInfo(-1);
        }
    }

    public final void setFilterInfo(@Nullable FilterInfo filterInfo) {
        this.mFilterInfo = filterInfo;
    }

    public final void setSearchTag(@NotNull String searchTag) {
        Intrinsics.checkNotNullParameter(searchTag, "searchTag");
        this.mRecordingSearchTag = searchTag;
    }

    public final synchronized void unregisterCursorChangeListener(@Nullable OnCursorChangeListener<?> listener) {
        if (listener != null) {
            if (containsListener(listener)) {
                TypeIntrinsics.asMutableCollection(this.mCursorChangeListeners).remove(listener);
            }
        }
    }

    public final void unregisterObservers() {
        Logger.m12710d(TAG, "unregisterObservers");
        Context context = this.mAppContext;
        if (context != null) {
            Intrinsics.checkNotNull(context);
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver != null) {
                contentResolver.unregisterContentObserver(this.mContentObserver);
            }
        }
        LiveData<List<ContentFileData>> liveData = this.mListLiveData;
        if (liveData != null) {
            liveData.removeObserver(this.mListObserver);
        }
    }
}
