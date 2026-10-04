package com.samsung.android.sdk.scs.p142ai.asr_6_0;

import android.util.ArraySet;
import android.util.Log;
import androidx.annotation.NonNull;
import com.samsung.android.scs.p140ai.sdkcommon.asr.ServerFeature;
import com.samsung.android.scs.p140ai.sdkcommon.asr.ServerInfo;
import com.samsung.android.scs.p140ai.sdkcommon.asr.SpeechRecognitionConst;
import com.samsung.android.sdk.scs.p142ai.asr.C7692h;
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
    private Set<DictationType> dictationType;
    private boolean enabledAudioCompression;
    private boolean enabledPartial;
    private boolean isCensored;
    private Locale locale;
    private ServerInfo serverInfo;

    @SpeechRecognitionConst.ServerType
    private int serverType;
    private boolean speakerDiarisation;
    private ConnectionType type;
    private int viewType;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder {
        private Locale locale;
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
            this.dictationType.addAll((Collection) Optional.ofNullable(dictationTypeArr).map(new C7715c(20)).map(new C7715c(21)).orElseGet(new C7692h(4)));
            return this;
        }

        public RecognitionConfig build() {
            RecognitionConfig recognitionConfig = new RecognitionConfig(0);
            recognitionConfig.setLocale(this.locale);
            recognitionConfig.setConnectionType(this.type);
            recognitionConfig.enablePartialResult(this.enabledPartial);
            recognitionConfig.enableAudioCompression(this.enabledAudioCompression);
            recognitionConfig.enableCensor(this.isCensored);
            recognitionConfig.setServerType(this.serverType);
            recognitionConfig.setViewType(this.viewType);
            recognitionConfig.setDictationTypes(this.dictationType);
            recognitionConfig.setServerInfo((ServerInfo) Optional.ofNullable(this.serverInfo).orElseGet(new C7718f(3)));
            recognitionConfig.setSpeakerDiarisation(this.speakerDiarisation);
            recognitionConfig.ignoreDictationByView();
            recognitionConfig.disableSpakerDiarisation();
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

        public Builder enablePartialResult(boolean z) {
            this.enabledPartial = z;
            return this;
        }

        public Builder enableSpeakerDiarisation(boolean z) {
            this.speakerDiarisation = z;
            return this;
        }

        public Builder removeDictationType(DictationType... dictationTypeArr) {
            this.dictationType.removeAll((Collection) Optional.ofNullable(dictationTypeArr).map(new C7715c(20)).map(new C7715c(22)).orElseGet(new C7692h(4)));
            return this;
        }

        public Builder setLocale(@NonNull Locale locale) {
            this.locale = locale;
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

        public Builder setType(ConnectionType connectionType) {
            this.type = connectionType;
            return this;
        }

        public Builder setViewType(int i) {
            this.viewType = i;
            return this;
        }
    }

    public /* synthetic */ RecognitionConfig(int i) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disableSpakerDiarisation() {
        if (this.type != ConnectionType.LOCAL) {
            this.speakerDiarisation = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enableAudioCompression(boolean z) {
        this.enabledAudioCompression = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enableCensor(boolean z) {
        this.isCensored = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enablePartialResult(boolean z) {
        this.enabledPartial = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ignoreDictationByView() {
        if (this.viewType != 3) {
            return;
        }
        Set<DictationType> set = this.dictationType;
        DictationType dictationType = DictationType.TYPING;
        if (set.contains(dictationType)) {
            Log.d(TAG, "ignored Dictation by View due to view type");
            this.dictationType.remove(dictationType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConnectionType(ConnectionType connectionType) {
        this.type = connectionType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDictationTypes(Set<DictationType> set) {
        this.dictationType = set;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServerInfo(ServerInfo serverInfo) {
        this.serverInfo = serverInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServerType(@SpeechRecognitionConst.ServerType int i) {
        this.serverType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSpeakerDiarisation(boolean z) {
        this.speakerDiarisation = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewType(int i) {
        this.viewType = i;
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

    public Locale getLocale() {
        return this.locale;
    }

    public ServerInfo getServerInfo() {
        return this.serverInfo;
    }

    @SpeechRecognitionConst.ServerType
    public int getServerType() {
        return this.serverType;
    }

    public boolean isCensored() {
        return this.isCensored;
    }

    public boolean isEnabledAudioCompression() {
        return this.enabledAudioCompression;
    }

    public boolean isSpeakerDiarisation() {
        return this.speakerDiarisation;
    }

    private RecognitionConfig() {
        this.dictationType = new ArraySet();
        this.viewType = 0;
    }
}
