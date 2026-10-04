package com.samsung.android.support.senl.p148nt.stt.base.audio;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.stt.base.audio.FastConvertWorker;
import com.samsung.android.support.senl.p148nt.stt.base.model.SpenVoiceTextDataReader;
import com.samsung.android.support.senl.p148nt.stt.base.model.SpenVoiceTextDataReaderCache;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 U2\u00020\u0001:\u0003STUB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020 J\u0010\u0010$\u001a\u00020\"2\b\u0010%\u001a\u0004\u0018\u00010\u001eJ*\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\r2\b\u0010+\u001a\u0004\u0018\u00010\u00062\u0006\u0010,\u001a\u00020\rH\u0016J\u0018\u0010-\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\rH\u0016J\u001a\u0010/\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u00062\b\u00100\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u00101\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u00062\b\u00100\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u00102\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u0006H\u0016J\u0012\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u0006J\u0010\u00106\u001a\u00020 2\b\u00107\u001a\u0004\u0018\u00010\u0006J\u0010\u00109\u001a\u00020\r2\b\u00107\u001a\u0004\u0018\u00010\u0006J\u0012\u0010>\u001a\u00020 2\b\u0010?\u001a\u0004\u0018\u00010\u0013H\u0002J\u0012\u0010@\u001a\u00020\"2\b\u0010?\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010:\u001a\u00020\"2\b\u0010?\u001a\u0004\u0018\u00010\u0013J\u0010\u0010A\u001a\u00020\"2\b\u0010?\u001a\u0004\u0018\u00010\u0013J,\u0010B\u001a\u00020\"2\b\u00105\u001a\u0004\u0018\u00010\u00062\u0006\u0010*\u001a\u00020\r2\b\u0010+\u001a\u0004\u0018\u00010\u00062\u0006\u0010,\u001a\u00020\rH\u0004J\b\u0010C\u001a\u00020 H\u0002J\u0016\u0010D\u001a\u00020 2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020 J\u000e\u0010H\u001a\u00020 2\u0006\u0010E\u001a\u00020FJ\u0010\u0010I\u001a\u00020 2\b\u00105\u001a\u0004\u0018\u00010\u0006J\u0010\u0010J\u001a\u00020\r2\b\u00105\u001a\u0004\u0018\u00010\u0006J\u0010\u0010K\u001a\u00020\"2\b\u00105\u001a\u0004\u0018\u00010\u0006J\u0010\u0010L\u001a\u00020\"2\b\u00105\u001a\u0004\u0018\u00010\u0006J\u0018\u0010N\u001a\u00020\"2\u0006\u00105\u001a\u00020\u00062\u0006\u0010O\u001a\u00020\u0006H\u0002J\u0010\u0010P\u001a\u00020\"2\b\u00105\u001a\u0004\u0018\u00010\u0006J\u0006\u0010Q\u001a\u00020\"J\u0010\u0010R\u001a\u00020\"2\b\u00105\u001a\u0004\u0018\u00010\u0006R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R>\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR>\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\b2\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0013`\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010&\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0011\u00108\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b8\u0010'R\u0019\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130;8F¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0011\u0010M\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\bM\u0010'¨\u0006V"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/audio/FastConvertController;", "Lcom/samsung/android/support/senl/nt/stt/base/audio/FastConvertStateListener;", "<init>", "()V", "mPendingFastConvertSessionIds", "Ljava/util/LinkedList;", "", "value", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/samsung/android/support/senl/nt/stt/base/audio/FastConvertController$FastConvertItem;", "fastConvertList", "getFastConvertList", "()Ljava/util/concurrent/ConcurrentHashMap;", "", "autoTranscribeList", "getAutoTranscribeList", "mConvertingThreadCount", "mListeners", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/nt/stt/base/audio/FastConvertController$FastConvertViewChangedListener;", "Lkotlin/collections/ArrayList;", "currentFastConvertState", "getCurrentFastConvertState", "()I", "setCurrentFastConvertState", "(I)V", "currentFastConvertSessionID", "getCurrentFastConvertSessionID", "()Ljava/lang/String;", "mConvertLocale", "Ljava/util/Locale;", "mIsEnableAutoDetect", "", "setEnableAutoDetect", "", "enableAutoDetect", "setConvertLocale", "convertLocale", "isMaxPollSizeReached", "()Z", "updateState", "sessionId", "state", "error", "errorCode", "onUpdateProgress", "percent", "onNoLangPackInstalled", "locale", "onLocaleChanged", "onNoMatch", "getFastConvertResultData", "Lcom/samsung/android/support/senl/nt/stt/base/audio/FastConvertResultData;", "sessionID", "isConverting", "currentConvertSession", "isHasItemConverting", "getConvertingPercent", "registerListener", "", "getRegisterListener", "()Ljava/util/List;", "containsListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeListener", "unregisterListener", "notifyObservers", "handleNextItem", "addFastConvertItem", "item", "Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;", "forceConvert", "addAutoTranscribeItem", "isAutoTranscribeConverting", "getFastConvertState", "removeConvertItem", "removeAutoTranscribeConvertItem", "isConvertDone", "startFastConvert", "filePath", "cancelFastConvert", "resetThreadCount", "release", "FastConvertViewChangedListener", "FastConvertItem", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class FastConvertController implements FastConvertStateListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int MAX_CONVERTING_THREAD = 1;
    private static final int MAX_WAITING_POLL_SIZE = 10;

    @NotNull
    private static final String TAG = "FastConvertController";

    @Nullable
    private static FastConvertController mInstance;

    @Nullable
    private ConcurrentHashMap<String, Integer> autoTranscribeList;

    @NotNull
    private String currentFastConvertSessionID;
    private int currentFastConvertState;

    @Nullable
    private ConcurrentHashMap<String, FastConvertItem> fastConvertList;

    @Nullable
    private Locale mConvertLocale;
    private int mConvertingThreadCount;
    private boolean mIsEnableAutoDetect;

    @NotNull
    private final ArrayList<FastConvertViewChangedListener> mListeners;

    @Nullable
    private LinkedList<String> mPendingFastConvertSessionIds;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\n8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/audio/FastConvertController$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "MAX_CONVERTING_THREAD", "", "MAX_WAITING_POLL_SIZE", "mInstance", "Lcom/samsung/android/support/senl/nt/stt/base/audio/FastConvertController;", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/senl/nt/stt/base/audio/FastConvertController;", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized FastConvertController getInstance() {
            FastConvertController fastConvertController;
            try {
                if (FastConvertController.mInstance == null) {
                    FastConvertController.mInstance = new FastConvertController(null);
                }
                fastConvertController = FastConvertController.mInstance;
                Intrinsics.checkNotNull(fastConvertController);
            } catch (Throwable th) {
                throw th;
            }
            return fastConvertController;
        }

        private Companion() {
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/audio/FastConvertController$FastConvertItem;", "", "sessionId", "", "filePath", "convertState", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getSessionId", "()Ljava/lang/String;", "setSessionId", "(Ljava/lang/String;)V", "getFilePath", "setFilePath", "getConvertState", "()I", "setConvertState", "(I)V", "convertingPercent", "getConvertingPercent", "setConvertingPercent", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class FastConvertItem {
        private int convertState;
        private int convertingPercent;

        @NotNull
        private String filePath;

        @NotNull
        private String sessionId;

        public FastConvertItem(@NotNull String sessionId, @NotNull String filePath, int i) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            this.sessionId = sessionId;
            this.filePath = filePath;
            this.convertState = i;
        }

        public final int getConvertState() {
            return this.convertState;
        }

        public final int getConvertingPercent() {
            return this.convertingPercent;
        }

        @NotNull
        public final String getFilePath() {
            return this.filePath;
        }

        @NotNull
        public final String getSessionId() {
            return this.sessionId;
        }

        public final void setConvertState(int i) {
            this.convertState = i;
        }

        public final void setConvertingPercent(int i) {
            this.convertingPercent = i;
        }

        public final void setFilePath(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.filePath = str;
        }

        public final void setSessionId(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.sessionId = str;
        }
    }

    public /* synthetic */ FastConvertController(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final boolean containsListener(FastConvertViewChangedListener listener) {
        if (listener == null) {
            return false;
        }
        Iterator<FastConvertViewChangedListener> it = this.mListeners.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            if (Intrinsics.areEqual(listener, it.next())) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final synchronized FastConvertController getInstance() {
        return INSTANCE.getInstance();
    }

    private final boolean handleNextItem() {
        Logger.m12713i(TAG, "handleNextItem");
        int i = this.mConvertingThreadCount - 1;
        this.mConvertingThreadCount = i;
        if (i < 0) {
            this.mConvertingThreadCount = 0;
        }
        LinkedList<String> linkedList = this.mPendingFastConvertSessionIds;
        if (linkedList != null) {
            Intrinsics.checkNotNull(linkedList);
            if (!linkedList.isEmpty()) {
                if (this.mConvertingThreadCount < 1) {
                    LinkedList<String> linkedList2 = this.mPendingFastConvertSessionIds;
                    Intrinsics.checkNotNull(linkedList2);
                    String strPoll = linkedList2.poll();
                    if (strPoll != null) {
                        ConcurrentHashMap<String, FastConvertItem> concurrentHashMap = this.fastConvertList;
                        Intrinsics.checkNotNull(concurrentHashMap);
                        FastConvertItem fastConvertItem = concurrentHashMap.get(strPoll);
                        if (fastConvertItem != null) {
                            notifyObservers(strPoll, 11, null, -1);
                            this.currentFastConvertSessionID = strPoll;
                            this.currentFastConvertState = 11;
                            ConcurrentHashMap<String, FastConvertItem> concurrentHashMap2 = this.fastConvertList;
                            Intrinsics.checkNotNull(concurrentHashMap2);
                            FastConvertItem fastConvertItem2 = concurrentHashMap2.get(strPoll);
                            Objects.requireNonNull(fastConvertItem2);
                            Intrinsics.checkNotNull(fastConvertItem2);
                            fastConvertItem2.setConvertState(11);
                            startFastConvert(strPoll, fastConvertItem.getFilePath());
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }

    private final void removeListener(FastConvertViewChangedListener listener) {
        if (listener == null) {
            return;
        }
        Iterator<FastConvertViewChangedListener> it = this.mListeners.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next(), listener)) {
                it.remove();
            }
        }
    }

    private final void startFastConvert(String sessionID, String filePath) {
        Logger.m12713i(TAG, "startFastConvert: " + sessionID + " " + this.mConvertingThreadCount);
        FastConvertWorker.Companion companion = FastConvertWorker.INSTANCE;
        companion.getInstance(sessionID).registerListener(this);
        companion.getInstance(sessionID).startConvert(BaseUtils.getApplicationContext(), filePath, this.mIsEnableAutoDetect, this.mConvertLocale);
        this.mConvertingThreadCount = this.mConvertingThreadCount + 1;
    }

    public final boolean addAutoTranscribeItem(@NotNull SpenVoiceData item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (this.autoTranscribeList == null) {
            this.autoTranscribeList = new ConcurrentHashMap<>();
        }
        String strValueOf = String.valueOf(item.getMHandle());
        ConcurrentHashMap<String, Integer> concurrentHashMap = this.autoTranscribeList;
        Intrinsics.checkNotNull(concurrentHashMap);
        if (concurrentHashMap.containsKey(strValueOf)) {
            Logger.m12713i(TAG, "addAutoTranscribeItem: " + strValueOf + " already added - currentThreadCount " + this.mConvertingThreadCount);
            return false;
        }
        Logger.m12710d(TAG, "addAutoTranscribeItem starting " + item.getName());
        ConcurrentHashMap<String, Integer> concurrentHashMap2 = this.autoTranscribeList;
        Intrinsics.checkNotNull(concurrentHashMap2);
        concurrentHashMap2.putIfAbsent(strValueOf, 11);
        return true;
    }

    public final boolean addFastConvertItem(@NotNull SpenVoiceData item, boolean forceConvert) {
        Intrinsics.checkNotNullParameter(item, "item");
        SpenVoiceTextDataReaderCache companion = SpenVoiceTextDataReaderCache.INSTANCE.getInstance();
        Intrinsics.checkNotNull(companion);
        SpenVoiceTextDataReader spenVoiceTextDataReader = companion.get(item);
        String[] voiceTexts = spenVoiceTextDataReader.getVoiceTexts();
        int[] voiceTimes = spenVoiceTextDataReader.getVoiceTimes();
        if (voiceTexts != null && voiceTimes != null && !forceConvert) {
            Logger.m12713i(TAG, "addFastConvertItem: the item " + item.getName() + " is converted");
            return false;
        }
        if (this.fastConvertList == null) {
            this.fastConvertList = new ConcurrentHashMap<>();
        }
        String sessionID = ConvertUtils.getSessionID(item);
        String attachedFile = item.getAttachedFile();
        if (sessionID == null) {
            AbstractC11014a.m12327l(this.mConvertingThreadCount, "addFastConvertItem: sessionID null ", TAG);
            return false;
        }
        ConcurrentHashMap<String, FastConvertItem> concurrentHashMap = this.fastConvertList;
        Intrinsics.checkNotNull(concurrentHashMap);
        if (concurrentHashMap.containsKey(sessionID)) {
            Logger.m12713i(TAG, "addFastConvertItem: " + sessionID + " already added - currentThreadCount " + this.mConvertingThreadCount);
            return false;
        }
        Logger.m12713i(TAG, "addFastConvertItem: " + sessionID + " currentThreadCount " + this.mConvertingThreadCount);
        if (this.mPendingFastConvertSessionIds == null) {
            this.mPendingFastConvertSessionIds = new LinkedList<>();
        }
        if (this.mConvertingThreadCount < 1) {
            Logger.m12710d(TAG, "addFastConvertItem starting " + item.getName());
            ConcurrentHashMap<String, FastConvertItem> concurrentHashMap2 = this.fastConvertList;
            Intrinsics.checkNotNull(concurrentHashMap2);
            Intrinsics.checkNotNull(attachedFile);
            concurrentHashMap2.putIfAbsent(sessionID, new FastConvertItem(sessionID, attachedFile, 11));
            notifyObservers(sessionID, 11, null, -1);
            this.currentFastConvertState = 11;
            this.currentFastConvertSessionID = sessionID;
            startFastConvert(sessionID, attachedFile);
        } else {
            Logger.m12710d(TAG, "addFastConvertItem pending " + item.getName());
            ConcurrentHashMap<String, FastConvertItem> concurrentHashMap3 = this.fastConvertList;
            Intrinsics.checkNotNull(concurrentHashMap3);
            Intrinsics.checkNotNull(attachedFile);
            concurrentHashMap3.putIfAbsent(sessionID, new FastConvertItem(sessionID, attachedFile, 12));
            LinkedList<String> linkedList = this.mPendingFastConvertSessionIds;
            Intrinsics.checkNotNull(linkedList);
            linkedList.add(sessionID);
            notifyObservers(sessionID, 12, null, -1);
        }
        return true;
    }

    public final void cancelFastConvert(@Nullable String sessionID) {
        Logger.m12713i(TAG, "cancelFastConvert " + sessionID);
        FastConvertWorker.INSTANCE.getInstance(sessionID).cancelConvert();
        removeConvertItem(sessionID);
        notifyObservers(sessionID, 17, null, -1);
        handleNextItem();
    }

    @Nullable
    public final ConcurrentHashMap<String, Integer> getAutoTranscribeList() {
        return this.autoTranscribeList;
    }

    public final int getConvertingPercent(@Nullable String currentConvertSession) {
        if (currentConvertSession == null) {
            return 0;
        }
        ConcurrentHashMap<String, FastConvertItem> concurrentHashMap = this.fastConvertList;
        Intrinsics.checkNotNull(concurrentHashMap);
        FastConvertItem fastConvertItem = concurrentHashMap.get(currentConvertSession);
        if (fastConvertItem == null) {
            return 0;
        }
        return fastConvertItem.getConvertingPercent();
    }

    @NotNull
    public final String getCurrentFastConvertSessionID() {
        return this.currentFastConvertSessionID;
    }

    public final int getCurrentFastConvertState() {
        return this.currentFastConvertState;
    }

    @Nullable
    public final ConcurrentHashMap<String, FastConvertItem> getFastConvertList() {
        return this.fastConvertList;
    }

    @Nullable
    public final FastConvertResultData getFastConvertResultData(@Nullable String sessionID) {
        return FastConvertWorker.INSTANCE.getInstance(sessionID).getFastConvertResultData();
    }

    public final int getFastConvertState(@Nullable String sessionID) {
        if (sessionID == null) {
            return 1;
        }
        ConcurrentHashMap<String, FastConvertItem> concurrentHashMap = this.fastConvertList;
        Intrinsics.checkNotNull(concurrentHashMap);
        FastConvertItem fastConvertItem = concurrentHashMap.get(sessionID);
        if (fastConvertItem != null) {
            return fastConvertItem.getConvertState();
        }
        return 1;
    }

    @NotNull
    public final List<FastConvertViewChangedListener> getRegisterListener() {
        return this.mListeners;
    }

    public final boolean isAutoTranscribeConverting(@Nullable String sessionID) {
        Logger.m12710d(TAG, "isAutoTranscribeItem " + sessionID);
        if (sessionID == null) {
            return false;
        }
        ConcurrentHashMap<String, Integer> concurrentHashMap = this.autoTranscribeList;
        Intrinsics.checkNotNull(concurrentHashMap);
        if (concurrentHashMap.get(sessionID) != null) {
            ConcurrentHashMap<String, Integer> concurrentHashMap2 = this.autoTranscribeList;
            Intrinsics.checkNotNull(concurrentHashMap2);
            if (!concurrentHashMap2.isEmpty()) {
                ConcurrentHashMap<String, Integer> concurrentHashMap3 = this.autoTranscribeList;
                Intrinsics.checkNotNull(concurrentHashMap3);
                return concurrentHashMap3.containsKey(sessionID);
            }
        }
        Logger.m12711e(TAG, "list autoTranscribeItem doesn't contain ".concat(sessionID));
        return false;
    }

    public final boolean isConvertDone() {
        ConcurrentHashMap<String, FastConvertItem> concurrentHashMap = this.fastConvertList;
        Intrinsics.checkNotNull(concurrentHashMap);
        return concurrentHashMap.isEmpty();
    }

    public final boolean isConverting(@Nullable String currentConvertSession) {
        if (currentConvertSession == null) {
            return false;
        }
        ConcurrentHashMap<String, FastConvertItem> concurrentHashMap = this.fastConvertList;
        Intrinsics.checkNotNull(concurrentHashMap);
        return concurrentHashMap.get(currentConvertSession) != null;
    }

    public final boolean isHasItemConverting() {
        ConcurrentHashMap<String, FastConvertItem> concurrentHashMap = this.fastConvertList;
        return !(concurrentHashMap == null || concurrentHashMap.isEmpty());
    }

    public final boolean isMaxPollSizeReached() {
        LinkedList<String> linkedList = this.mPendingFastConvertSessionIds;
        if (linkedList != null) {
            int i = this.mConvertingThreadCount;
            Intrinsics.checkNotNull(linkedList);
            if (linkedList.size() + i >= 10) {
                return true;
            }
        }
        return false;
    }

    public final void notifyObservers(@Nullable String sessionID, int state, @Nullable String error, int errorCode) {
        Iterator<FastConvertViewChangedListener> it = this.mListeners.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            FastConvertViewChangedListener next = it.next();
            Intrinsics.checkNotNull(next);
            next.notifyFastConvertStatusChanged(sessionID, state, error, errorCode);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.base.audio.FastConvertStateListener
    public void onLocaleChanged(@NotNull String sessionId, @Nullable Locale locale) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Logger.m12713i(TAG, "onLocaleChanged: " + sessionId + " locale " + (locale != null ? locale.toLanguageTag() : null));
        ConcurrentHashMap<String, FastConvertItem> concurrentHashMap = this.fastConvertList;
        if (concurrentHashMap != null) {
            Intrinsics.checkNotNull(concurrentHashMap);
            if (concurrentHashMap.get(sessionId) != null) {
                ConcurrentHashMap<String, FastConvertItem> concurrentHashMap2 = this.fastConvertList;
                Intrinsics.checkNotNull(concurrentHashMap2);
                if (!concurrentHashMap2.isEmpty()) {
                    Iterator<FastConvertViewChangedListener> it = this.mListeners.iterator();
                    Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                    while (it.hasNext()) {
                        FastConvertViewChangedListener next = it.next();
                        Intrinsics.checkNotNull(next);
                        next.onLocaleChanged(sessionId, locale);
                    }
                    return;
                }
            }
        }
        AbstractC12991c.m14005z("list doesn't contain ", sessionId, TAG);
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.base.audio.FastConvertStateListener
    public void onNoLangPackInstalled(@NotNull String sessionId, @Nullable Locale locale) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        if (locale != null) {
            Logger.m12713i(TAG, "onNoLangPackInstalled: " + sessionId + " locale " + locale.toLanguageTag());
        }
        ConcurrentHashMap<String, FastConvertItem> concurrentHashMap = this.fastConvertList;
        if (concurrentHashMap != null) {
            Intrinsics.checkNotNull(concurrentHashMap);
            if (concurrentHashMap.get(sessionId) != null) {
                ConcurrentHashMap<String, FastConvertItem> concurrentHashMap2 = this.fastConvertList;
                Intrinsics.checkNotNull(concurrentHashMap2);
                if (!concurrentHashMap2.isEmpty()) {
                    Iterator<FastConvertViewChangedListener> it = this.mListeners.iterator();
                    Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                    while (it.hasNext()) {
                        FastConvertViewChangedListener next = it.next();
                        Intrinsics.checkNotNull(next);
                        next.onNoLangPackInstalled(sessionId, locale);
                    }
                    return;
                }
            }
        }
        AbstractC12991c.m14005z("list doesn't contain ", sessionId, TAG);
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.base.audio.FastConvertStateListener
    public void onNoMatch(@NotNull String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Logger.m12713i(TAG, "onNoMatch: " + sessionId);
        ConcurrentHashMap<String, FastConvertItem> concurrentHashMap = this.fastConvertList;
        if (concurrentHashMap != null) {
            Intrinsics.checkNotNull(concurrentHashMap);
            if (concurrentHashMap.get(sessionId) != null) {
                ConcurrentHashMap<String, FastConvertItem> concurrentHashMap2 = this.fastConvertList;
                Intrinsics.checkNotNull(concurrentHashMap2);
                if (!concurrentHashMap2.isEmpty()) {
                    Iterator<FastConvertViewChangedListener> it = this.mListeners.iterator();
                    Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                    while (it.hasNext()) {
                        FastConvertViewChangedListener next = it.next();
                        Intrinsics.checkNotNull(next);
                        next.onNoMatch(sessionId);
                    }
                    return;
                }
            }
        }
        AbstractC12991c.m14005z("list doesn't contain ", sessionId, TAG);
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.base.audio.FastConvertStateListener
    public void onUpdateProgress(@NotNull String sessionId, int percent) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Logger.m12710d(TAG, "onUpdateProgress: " + sessionId + " percent: " + percent);
        ConcurrentHashMap<String, FastConvertItem> concurrentHashMap = this.fastConvertList;
        if (concurrentHashMap == null) {
            Logger.m12711e(TAG, "mFastConvertList null");
            return;
        }
        Intrinsics.checkNotNull(concurrentHashMap);
        FastConvertItem fastConvertItem = concurrentHashMap.get(sessionId);
        if (fastConvertItem != null) {
            ConcurrentHashMap<String, FastConvertItem> concurrentHashMap2 = this.fastConvertList;
            Intrinsics.checkNotNull(concurrentHashMap2);
            if (!concurrentHashMap2.isEmpty()) {
                fastConvertItem.setConvertingPercent(percent);
                ArrayList<FastConvertViewChangedListener> arrayList = this.mListeners;
                Intrinsics.checkNotNull(arrayList);
                Iterator<FastConvertViewChangedListener> it = arrayList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    FastConvertViewChangedListener next = it.next();
                    Intrinsics.checkNotNull(next);
                    next.notifyFastConvertProgressUpdated(sessionId, percent);
                }
                return;
            }
        }
        AbstractC12991c.m14005z("list doesn't contain ", sessionId, TAG);
    }

    public final void registerListener(@Nullable FastConvertViewChangedListener listener) {
        if (listener == null) {
            return;
        }
        if (containsListener(listener)) {
            Logger.m12710d(TAG, "registerListener containsListener " + listener.hashCode());
            return;
        }
        Logger.m12710d(TAG, "registerListener " + listener.hashCode());
        this.mListeners.add(listener);
    }

    public final void release(@Nullable String sessionID) {
        FastConvertWorker.INSTANCE.release(sessionID);
        removeConvertItem(sessionID);
    }

    public final void removeAutoTranscribeConvertItem(@Nullable String sessionID) {
        if (sessionID == null) {
            return;
        }
        ConcurrentHashMap<String, Integer> concurrentHashMap = this.autoTranscribeList;
        Intrinsics.checkNotNull(concurrentHashMap);
        if (concurrentHashMap.get(sessionID) != null) {
            Logger.m12710d(TAG, "removeAutoTranscribeConvertItem ".concat(sessionID));
            ConcurrentHashMap<String, Integer> concurrentHashMap2 = this.autoTranscribeList;
            Intrinsics.checkNotNull(concurrentHashMap2);
            concurrentHashMap2.remove(sessionID);
        }
    }

    public final void removeConvertItem(@Nullable String sessionID) {
        if (sessionID == null) {
            return;
        }
        ConcurrentHashMap<String, FastConvertItem> concurrentHashMap = this.fastConvertList;
        Intrinsics.checkNotNull(concurrentHashMap);
        if (concurrentHashMap.get(sessionID) != null) {
            ConcurrentHashMap<String, FastConvertItem> concurrentHashMap2 = this.fastConvertList;
            Intrinsics.checkNotNull(concurrentHashMap2);
            concurrentHashMap2.remove(sessionID);
        }
    }

    public final void resetThreadCount() {
        this.mConvertingThreadCount = 0;
    }

    public final void setConvertLocale(@Nullable Locale convertLocale) {
        this.mConvertLocale = convertLocale;
    }

    public final void setCurrentFastConvertState(int i) {
        this.currentFastConvertState = i;
    }

    public final void setEnableAutoDetect(boolean enableAutoDetect) {
        this.mIsEnableAutoDetect = enableAutoDetect;
    }

    public final void unregisterListener(@Nullable FastConvertViewChangedListener listener) {
        if (containsListener(listener)) {
            removeListener(listener);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.base.audio.FastConvertStateListener
    public void updateState(@NotNull String sessionId, int state, @Nullable String error, int errorCode) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        String str = error == null ? "null" : error;
        StringBuilder sbM780v = AbstractC0541b.m780v("updateState: ", state, sessionId, " state: ", " error: ");
        sbM780v.append(str);
        Logger.m12713i(TAG, sbM780v.toString());
        ConcurrentHashMap<String, FastConvertItem> concurrentHashMap = this.fastConvertList;
        if (concurrentHashMap != null) {
            Intrinsics.checkNotNull(concurrentHashMap);
            if (concurrentHashMap.get(sessionId) != null) {
                ConcurrentHashMap<String, FastConvertItem> concurrentHashMap2 = this.fastConvertList;
                Intrinsics.checkNotNull(concurrentHashMap2);
                if (!concurrentHashMap2.isEmpty()) {
                    ConcurrentHashMap<String, FastConvertItem> concurrentHashMap3 = this.fastConvertList;
                    Intrinsics.checkNotNull(concurrentHashMap3);
                    FastConvertItem fastConvertItem = concurrentHashMap3.get(sessionId);
                    Objects.requireNonNull(fastConvertItem);
                    Intrinsics.checkNotNull(fastConvertItem);
                    fastConvertItem.setConvertState(state);
                    notifyObservers(sessionId, state, error, errorCode);
                    this.currentFastConvertState = state;
                    this.currentFastConvertSessionID = sessionId;
                    if (state == 15 || state == 16) {
                        handleNextItem();
                        return;
                    }
                    return;
                }
            }
        }
        AbstractC12991c.m14005z("list doesn't contain ", sessionId, TAG);
    }

    private FastConvertController() {
        this.fastConvertList = new ConcurrentHashMap<>();
        this.autoTranscribeList = new ConcurrentHashMap<>();
        this.mListeners = new ArrayList<>();
        this.currentFastConvertState = -1;
        this.currentFastConvertSessionID = "";
        AbstractC11014a.m12327l(this.mConvertingThreadCount, "count ", TAG);
        this.mConvertingThreadCount = 0;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u0007H&J\u001a\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u001c\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/audio/FastConvertController$FastConvertViewChangedListener;", "", "notifyFastConvertStatusChanged", "", "sessionID", "", "state", "", "error", "errorCode", "notifyFastConvertProgressUpdated", "percent", "onNoLangPackInstalled", "locale", "Ljava/util/Locale;", "onLocaleChanged", "onNoMatch", "sessionId", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface FastConvertViewChangedListener {
        void notifyFastConvertProgressUpdated(@Nullable String sessionID, int percent);

        void notifyFastConvertStatusChanged(@Nullable String sessionID, int state, @Nullable String error, int errorCode);

        void onLocaleChanged(@Nullable String sessionID, @Nullable Locale locale);

        void onNoLangPackInstalled(@Nullable String sessionID, @Nullable Locale locale);

        void onNoMatch(@Nullable String sessionId);

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class DefaultImpls {
            public static void onNoMatch(@NotNull FastConvertViewChangedListener fastConvertViewChangedListener, @Nullable String str) {
            }

            public static void notifyFastConvertProgressUpdated(@NotNull FastConvertViewChangedListener fastConvertViewChangedListener, @Nullable String str, int i) {
            }

            public static void onLocaleChanged(@NotNull FastConvertViewChangedListener fastConvertViewChangedListener, @Nullable String str, @Nullable Locale locale) {
            }

            public static void onNoLangPackInstalled(@NotNull FastConvertViewChangedListener fastConvertViewChangedListener, @Nullable String str, @Nullable Locale locale) {
            }
        }
    }
}
