package com.samsung.android.sdk.scs.p142ai.asr;

import android.os.Bundle;
import android.util.ArraySet;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.ServerFeature;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.ServerInfo;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.SpeechRecognitionConst;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class RecognitionConfig {
    private static final String TAG = "RecognitionConfig";
    private boolean enableDetailedSegment;
    private boolean enabledAudioCompression;
    private boolean enabledPartial;
    private boolean isCensored;
    private Locale locale;
    private Bundle mExtraBundle;
    private Locale mTargetLocale;
    private int sdNotifyIntervalTime;
    private SDRecordingType sdRecordingType;
    private ServerInfo serverInfo;

    @SpeechRecognitionConst.ServerType
    private int serverType;
    private boolean speakerDiarisation;
    private ConnectionType type;
    private Set<DictationType> dictationType = new ArraySet();
    private int viewType = 0;
    private boolean enabledProgress = false;
    private long mVoiceFilterId = -1;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder {
        private Locale locale;
        private Locale targetLocale;
        private boolean enabledPartial = false;
        private boolean enabledAudioCompression = false;
        private boolean isCensored = false;
        private ConnectionType type = ConnectionType.NETWORK;

        @SpeechRecognitionConst.ServerType
        private int serverType = 0;
        private final Set<DictationType> dictationType = new ArraySet();
        private ServerInfo serverInfo = null;
        private int viewType = 0;
        private boolean speakerDiarisation = false;
        private int sdNotifyIntervalTime = 0;
        private SDRecordingType sdRecordingType = SDRecordingType.TYPE_NORMAL;
        private Bundle bundle = null;
        private boolean enabledProgress = false;
        private boolean lid = false;
        private Locale[] locs = null;
        private long voiceFilterId = -1;
        private boolean enableDetailedSegment = false;

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Set lambda$addDictationType$0(Stream stream) {
            return (Set) stream.collect(Collectors.toSet());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ ServerInfo lambda$build$2() {
            return Environment.getCurrentServerInfo(ServerFeature.DICTATION_ASR);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Set lambda$removeDictationType$1(Stream stream) {
            return (Set) stream.collect(Collectors.toSet());
        }

        public Builder addDictationType(DictationType... dictationTypeArr) {
            this.dictationType.addAll((Collection) Optional.ofNullable(dictationTypeArr).map(new C7690f(29)).map(new C7691g(0)).orElseGet(new C7692h(4)));
            return this;
        }

        public RecognitionConfig build() {
            RecognitionConfig recognitionConfig = new RecognitionConfig();
            if (this.lid) {
                recognitionConfig.setLocale(Locale.ROOT);
                if (this.bundle == null) {
                    this.bundle = new Bundle();
                }
                this.bundle.putSerializable(SpeechRecognitionConst.Key.PRIMARY_LOCALE, this.locale);
            } else {
                recognitionConfig.setLocale(this.locale);
            }
            recognitionConfig.setConnectionType(this.type);
            recognitionConfig.enablePartialResult(this.enabledPartial);
            recognitionConfig.enableAudioCompression(this.enabledAudioCompression);
            recognitionConfig.enableCensor(this.isCensored);
            recognitionConfig.enableProgress(this.enabledProgress);
            recognitionConfig.setServerType(this.serverType);
            recognitionConfig.setViewType(this.viewType);
            recognitionConfig.setDictationTypes(this.dictationType);
            recognitionConfig.setServerInfo((ServerInfo) Optional.ofNullable(this.serverInfo).orElseGet(new C7692h(5)));
            recognitionConfig.setSpeakerDiarisation(this.speakerDiarisation);
            recognitionConfig.setTargetLocale(this.targetLocale);
            recognitionConfig.setExtras(this.bundle);
            int i = this.sdNotifyIntervalTime;
            if (i > 0) {
                recognitionConfig.setSDNotifyIntervalTime(i);
            }
            recognitionConfig.setSdRecordingType(this.sdRecordingType);
            recognitionConfig.ignoreDictationByView();
            recognitionConfig.setVoiceFilterId(this.voiceFilterId);
            recognitionConfig.enableDetailedSegment(this.enableDetailedSegment);
            return recognitionConfig;
        }

        public Builder enableAudioCompression(boolean z) {
            this.enabledAudioCompression = z;
            return this;
        }

        public Builder enableCensor(boolean z) {
            this.isCensored = z;
            return this;
        }

        public Builder enableDetailedSegment(boolean z) {
            this.enableDetailedSegment = z;
            return this;
        }

        public Builder enableLocaleRecognition(boolean z) {
            this.lid = z;
            return this;
        }

        public Builder enablePartialResult(boolean z) {
            this.enabledPartial = z;
            return this;
        }

        public Builder enableProgress(boolean z) {
            this.enabledProgress = z;
            return this;
        }

        public Builder enableSpeakerDiarisation(boolean z) {
            this.speakerDiarisation = z;
            return this;
        }

        public Builder generateVoiceFilterId() {
            this.voiceFilterId = 0L;
            return this;
        }

        public Builder putExtras(Bundle bundle) {
            if (bundle != null && !bundle.isEmpty()) {
                if (this.bundle == null) {
                    this.bundle = new Bundle();
                }
                this.bundle.putAll(bundle);
            }
            return this;
        }

        public Builder removeDictationType(DictationType... dictationTypeArr) {
            this.dictationType.removeAll((Collection) Optional.ofNullable(dictationTypeArr).map(new C7690f(29)).map(new C7691g(1)).orElseGet(new C7692h(4)));
            return this;
        }

        public Builder setAlternativeLocales(Locale... localeArr) {
            this.locs = localeArr;
            Bundle bundle = new Bundle();
            ArrayList<String> arrayList = new ArrayList<>();
            Stream.of((Object[]) this.locs).map(new C7691g(2)).forEach(new C7695k(arrayList, 1));
            bundle.putStringArrayList(SpeechRecognitionConst.Key.ALTERNATIVE_LOCALE, arrayList);
            putExtras(bundle);
            return this;
        }

        public Builder setLocale(@NonNull Locale locale) {
            this.locale = locale;
            if (this.targetLocale == null) {
                this.targetLocale = locale;
            }
            return this;
        }

        public Builder setSDNotifyIntervalTime(int i) {
            this.sdNotifyIntervalTime = i;
            return this;
        }

        public Builder setSdRecordingType(SDRecordingType sDRecordingType) {
            this.sdRecordingType = sDRecordingType;
            return this;
        }

        public Builder setServerInfo(ServerInfo serverInfo) {
            this.serverInfo = serverInfo;
            return this;
        }

        public Builder setServerType(@SpeechRecognitionConst.ServerType int i) {
            this.serverType = i;
            return this;
        }

        public Builder setTargetLocale(Locale locale) {
            this.targetLocale = locale;
            return this;
        }

        public Builder setType(ConnectionType connectionType) {
            this.type = connectionType;
            return this;
        }

        public Builder setViewType(int i) {
            this.viewType = i;
            return this;
        }

        public Builder setVoiceFilterId(long j) {
            if (j > 0) {
                this.voiceFilterId = j;
            }
            return this;
        }
    }

    private void disableSpakerDiarisation() {
        if (this.type != ConnectionType.LOCAL) {
            this.speakerDiarisation = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enableDetailedSegment(boolean z) {
        this.enableDetailedSegment = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTargetLocale(Locale locale) {
        this.mTargetLocale = locale;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVoiceFilterId(long j) {
        this.mVoiceFilterId = j;
    }

    public void enableAudioCompression(boolean z) {
        this.enabledAudioCompression = z;
    }

    public void enableCensor(boolean z) {
        this.isCensored = z;
    }

    public void enablePartialResult(boolean z) {
        this.enabledPartial = z;
    }

    public void enableProgress(boolean z) {
        this.enabledProgress = z;
    }

    public boolean enabledPartialResult() {
        return this.enabledPartial;
    }

    public ConnectionType getConnectionType() {
        return this.type;
    }

    public Set<DictationType> getDictationTypes() {
        return (Set) Optional.ofNullable(this.dictationType).orElseGet(new C7692h(4));
    }

    public Bundle getExtras() {
        return this.mExtraBundle;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public int getSdNotifyIntervalTime() {
        return this.sdNotifyIntervalTime;
    }

    public SDRecordingType getSdRecordingType() {
        return this.sdRecordingType;
    }

    public ServerInfo getServerInfo() {
        return this.serverInfo;
    }

    @SpeechRecognitionConst.ServerType
    public int getServerType() {
        return this.serverType;
    }

    public Locale getTargetLocale() {
        return this.mTargetLocale;
    }

    public long getVoiceFilterId() {
        return this.mVoiceFilterId;
    }

    public boolean hasExtras() {
        Bundle bundle = this.mExtraBundle;
        return (bundle == null || bundle.isEmpty()) ? false : true;
    }

    public void ignoreDictationByView() {
        if (this.viewType != 3) {
            return;
        }
        Set<DictationType> set = this.dictationType;
        DictationType dictationType = DictationType.TYPING;
        if (set.contains(dictationType)) {
            Log.m6485d(TAG, "ignored Dictation by View due to view type");
            this.dictationType.remove(dictationType);
        }
    }

    public boolean isCensored() {
        return this.isCensored;
    }

    public boolean isEnabledAudioCompression() {
        return this.enabledAudioCompression;
    }

    public boolean isEnabledDetailedSegment() {
        return this.enableDetailedSegment;
    }

    public boolean isSpeakerDiarisation() {
        return this.speakerDiarisation;
    }

    public boolean needProgress() {
        return this.enabledProgress;
    }

    public void setConnectionType(ConnectionType connectionType) {
        this.type = connectionType;
    }

    public void setDictationTypes(Set<DictationType> set) {
        this.dictationType = set;
    }

    public void setExtras(Bundle bundle) {
        this.mExtraBundle = bundle;
    }

    public void setLocale(@NonNull Locale locale) {
        this.locale = locale;
    }

    public void setSDNotifyIntervalTime(int i) {
        this.sdNotifyIntervalTime = i;
    }

    public void setSdRecordingType(SDRecordingType sDRecordingType) {
        this.sdRecordingType = sDRecordingType;
    }

    public void setServerInfo(ServerInfo serverInfo) {
        this.serverInfo = serverInfo;
    }

    public void setServerType(@SpeechRecognitionConst.ServerType int i) {
        this.serverType = i;
    }

    public void setSpeakerDiarisation(boolean z) {
        this.speakerDiarisation = z;
    }

    public void setViewType(int i) {
        this.viewType = i;
    }
}
