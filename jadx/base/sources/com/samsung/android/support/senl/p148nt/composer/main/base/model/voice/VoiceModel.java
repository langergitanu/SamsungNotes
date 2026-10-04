package com.samsung.android.support.senl.p148nt.composer.main.base.model.voice;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.composer.voice.VoiceManager;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.addons.base.model.setting.C7956a;
import com.samsung.android.support.senl.p145cm.base.framework.observer.SettingsContentObserver;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.VoiceViewState;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.voice.VoiceUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import com.samsung.android.support.senl.p148nt.stt.base.model.SpenVoiceTextDataReader;
import com.samsung.android.support.senl.p148nt.stt.base.model.SpenVoiceTextDataReaderCache;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b;\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ¶\u00012\u00020\u0001:\u0006´\u0001µ\u0001¶\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020!J\u000e\u0010L\u001a\u00020J2\u0006\u0010M\u001a\u00020NJ\u000e\u0010O\u001a\u00020J2\u0006\u0010P\u001a\u00020NJ\u001a\u0010Q\u001a\u00020J2\b\u0010R\u001a\u0004\u0018\u00010\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u001a\u0010S\u001a\u00020J2\b\u0010R\u001a\u0004\u0018\u00010\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010T\u001a\u00020J2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u000e\u0010U\u001a\u00020J2\u0006\u0010V\u001a\u00020%J\u0006\u0010W\u001a\u00020JJ\u0006\u0010X\u001a\u00020JJ\u000e\u0010Y\u001a\u00020J2\u0006\u0010Z\u001a\u00020%J\u0010\u0010_\u001a\u0002042\b\u0010`\u001a\u0004\u0018\u00010aJ\u0016\u0010j\u001a\u00020J2\u0006\u0010V\u001a\u00020%2\u0006\u0010k\u001a\u00020%J\u0010\u0010n\u001a\u00020J2\b\u0010o\u001a\u0004\u0018\u00010CJ\u0010\u0010p\u001a\u00020J2\b\u0010o\u001a\u0004\u0018\u00010EJ\u0010\u0010u\u001a\u00020J2\b\u0010v\u001a\u0004\u0018\u00010>J\u0010\u0010w\u001a\u00020J2\b\u0010v\u001a\u0004\u0018\u00010>J\u0010\u0010z\u001a\u0002042\b\u0010v\u001a\u0004\u0018\u00010>J\u0006\u0010{\u001a\u00020JJ\u0006\u0010|\u001a\u000204J\u0006\u0010}\u001a\u000204J\u0006\u0010~\u001a\u00020JJ\u0006\u0010\u007f\u001a\u000204J\u0007\u0010\u0080\u0001\u001a\u00020JJ\u0007\u0010\u0085\u0001\u001a\u000204J\u0007\u0010\u0086\u0001\u001a\u000204J\u0010\u0010\u008b\u0001\u001a\u00020J2\u0007\u0010\u0087\u0001\u001a\u000204J\u000f\u0010\u0092\u0001\u001a\u00020J2\u0006\u0010V\u001a\u00020%J\u0010\u0010\u0093\u0001\u001a\u00020%2\u0007\u0010\u0094\u0001\u001a\u00020\u001bJ\u0010\u0010\u0095\u0001\u001a\u00020J2\u0007\u0010\u0094\u0001\u001a\u00020\u001bJ\u0010\u0010\u0096\u0001\u001a\u0002042\u0007\u0010\u0094\u0001\u001a\u00020\u001bJ\u0012\u0010\u009b\u0001\u001a\u0002042\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0015J\u0010\u0010\u009d\u0001\u001a\u0002042\u0007\u0010\u009c\u0001\u001a\u00020\u0015J\u0010\u0010\u009e\u0001\u001a\u0002042\u0007\u0010\u0094\u0001\u001a\u00020\u001bJ\u000f\u0010\u009f\u0001\u001a\u00020%2\u0006\u0010V\u001a\u00020%J\u0010\u0010 \u0001\u001a\u00020J2\u0007\u0010¡\u0001\u001a\u00020>J\u0007\u0010¢\u0001\u001a\u00020JJ\u0011\u0010£\u0001\u001a\u00020J2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u000f\u0010\u0092\u0001\u001a\u00020J2\u0006\u0010\u001a\u001a\u00020\u001bJ\u0011\u0010¤\u0001\u001a\u0002042\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0011\u0010¥\u0001\u001a\u00020J2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u000f\u0010¦\u0001\u001a\u0002042\u0006\u0010V\u001a\u00020%J\u0010\u0010§\u0001\u001a\u00020J2\u0007\u0010¨\u0001\u001a\u000204J\u0007\u0010¨\u0001\u001a\u000204J\u0010\u0010©\u0001\u001a\u00020J2\u0007\u0010ª\u0001\u001a\u00020\rJ\u0007\u0010«\u0001\u001a\u00020\rJ0\u0010¬\u0001\u001a\u0005\u0018\u0001H\u00ad\u0001\"\f\b\u0000\u0010\u00ad\u0001\u0018\u0001*\u00030®\u0001*\u00020N2\t\u0010¯\u0001\u001a\u0004\u0018\u00010>H\u0086\b¢\u0006\u0003\u0010°\u0001J0\u0010±\u0001\u001a\u0005\u0018\u0001H\u00ad\u0001\"\f\b\u0000\u0010\u00ad\u0001\u0018\u0001*\u00030²\u0001*\u00020N2\t\u0010¯\u0001\u001a\u0004\u0018\u00010>H\u0086\b¢\u0006\u0003\u0010³\u0001R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\u001a\u0010-\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010'\"\u0004\b/\u0010)R\u001a\u00100\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010'\"\u0004\b2\u0010)R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00105\u001a\u000204X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u000e\u0010:\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010<\u001a\u0012\u0012\u0004\u0012\u00020>0=j\b\u0012\u0004\u0012\u00020>`?X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020\u001b0AX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010[\u001a\u0002048F¢\u0006\u0006\u001a\u0004\b[\u00107R\u0011\u0010\\\u001a\u0002048F¢\u0006\u0006\u001a\u0004\b\\\u00107R\u0011\u0010]\u001a\u0002048F¢\u0006\u0006\u001a\u0004\b]\u00107R\u0011\u0010^\u001a\u0002048F¢\u0006\u0006\u001a\u0004\b^\u00107R$\u0010c\u001a\u00020a2\u0006\u0010b\u001a\u00020a8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u0011\u0010h\u001a\u00020a8F¢\u0006\u0006\u001a\u0004\bi\u0010eR\u0011\u0010l\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\bm\u0010'R\u0017\u0010q\u001a\b\u0012\u0004\u0012\u00020>0r8F¢\u0006\u0006\u001a\u0004\bs\u0010tR\u0011\u0010x\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\by\u0010'R\u0013\u0010\u0081\u0001\u001a\u0002048F¢\u0006\u0007\u001a\u0005\b\u0081\u0001\u00107R\u0013\u0010\u0082\u0001\u001a\u0002048F¢\u0006\u0007\u001a\u0005\b\u0082\u0001\u00107R\u0013\u0010\u0083\u0001\u001a\u0002048F¢\u0006\u0007\u001a\u0005\b\u0083\u0001\u00107R\u0013\u0010\u0084\u0001\u001a\u0002048F¢\u0006\u0007\u001a\u0005\b\u0084\u0001\u00107R(\u0010\u0088\u0001\u001a\u0002042\u0007\u0010\u0087\u0001\u001a\u0002048F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0088\u0001\u00107\"\u0005\b\u0089\u0001\u00109R\u0013\u0010\u008a\u0001\u001a\u0002048F¢\u0006\u0007\u001a\u0005\b\u008a\u0001\u00107R.\u0010\u008d\u0001\u001a\u0004\u0018\u00010!2\t\u0010\u008c\u0001\u001a\u0004\u0018\u00010!8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R\u0019\u0010\u0097\u0001\u001a\b\u0012\u0004\u0012\u00020\u001b0r8F¢\u0006\u0007\u001a\u0005\b\u0098\u0001\u0010tR\u0013\u0010\u0099\u0001\u001a\u00020%8F¢\u0006\u0007\u001a\u0005\b\u009a\u0001\u0010'¨\u0006·\u0001"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceModel;", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "value", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceViewState;", "viewState", "getViewState", "()Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceViewState;", "mPreviousViewState", "mEraserState", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/EraserState;", "voiceState", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceState;", "getVoiceState", "()Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceState;", "setVoiceState", "(Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceState;)V", "voiceObject", "Lcom/samsung/android/sdk/pen/document/SpenObjectVoice;", "getVoiceObject", "()Lcom/samsung/android/sdk/pen/document/SpenObjectVoice;", "setVoiceObject", "(Lcom/samsung/android/sdk/pen/document/SpenObjectVoice;)V", "voiceData", "Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;", "getVoiceData", "()Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;", "setVoiceData", "(Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;)V", "mWNote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "mContext", "Landroid/content/Context;", "audioProgress", "", "getAudioProgress", "()I", "setAudioProgress", "(I)V", "recordingTime", "getRecordingTime", "setRecordingTime", "recordPlayingIndex", "getRecordPlayingIndex", "setRecordPlayingIndex", "recordPlayingProgress", "getRecordPlayingProgress", "setRecordPlayingProgress", "mSyncEnabled", "", "selectMode", "getSelectMode", "()Z", "setSelectMode", "(Z)V", "isPlayRecordingStarted", "mIsUPSMMode", "mSelectedVoiceList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "mVoiceList", "", "mRestoreCompleteListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceModel$RestoreCompleteListener;", "mUpdateVoiceSyncListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceModel$UpdateVoiceSyncListener;", "mSettingsContentChangedCallback", "Lcom/samsung/android/support/senl/cm/base/framework/observer/SettingsContentObserver$SettingsContentChangedCallback;", "mIsNotificationClearedByUser", "init", "", FolderNodeItem.SYNC_SDOCX_FOLDER_NODE_TYPE_NOTE, "restoreState", "inState", "Landroid/os/Bundle;", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "setPlayData", "objectVoice", "restorePlayData", "setRecordData", "updateVoiceData", "index", "setStopData", "clearVoiceData", "setRecordingTimeState", "time", "isRecordingVoiceState", "isPlayingVoiceState", "isPlayingVoiceDataState", "isPlayingObjectVoiceState", "compareViewState", "type", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceViewState$Type;", "stateType", "viewStateType", "getViewStateType", "()Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceViewState$Type;", "setViewStateType", "(Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceViewState$Type;)V", "previousViewStateType", "getPreviousViewStateType", "setRecordPlayingInfo", "progress", "allRecordTime", "getAllRecordTime", "setRestoreCompleteListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUpdateVoiceSyncListener", "selectedVoiceList", "", "getSelectedVoiceList", "()Ljava/util/List;", "addSelectedVoice", "name", "removeSelectedVoice", "selectedVoiceListSize", "getSelectedVoiceListSize", "isContainSelectedVoice", "clearSelectedVoiceList", "stopPlaying", "stopRecording", "stopRecordingOrPlaying", "cancelRecording", "playVoiceData", "isPlayingState", "isPauseState", "isPlayingVoiceData", "isPauseVoiceData", "playPause", "pause", "enabled", "isSyncEnable", "setSyncEnable", "isVoiceSyncPlaying", "updateOnlyScreenOn", "wNote", "doc", "getDoc", "()Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "setDoc", "(Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;)V", "removeVoiceData", "getVoiceDataIndex", "spenVoiceData", "changeVoiceData", "isLastVoiceData", "voiceDataList", "getVoiceDataList", "voiceDataListSize", "getVoiceDataListSize", "hasObjectVoice", "spenObjectVoice", "hasCurrentObjectVoice", "hasCurrentVoiceData", "getVoiceDataTimeByIndex", "setNewName", "newName", "onDestroy", "addVoiceData", "hasVoiceData", "removeErrorVoiceData", "isVoiceDataItemSTTConverted", "setNotificationClearByUser", "isNotificationClearedByUser", "setEraserState", "state", "getEraserState", "parcelable", "T", "Landroid/os/Parcelable;", "key", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/os/Parcelable;", "serializable", "Ljava/io/Serializable;", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/io/Serializable;", "RestoreCompleteListener", "UpdateVoiceSyncListener", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVoiceModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VoiceModel.kt\ncom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceModel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,635:1\n622#1,4:636\n627#1,4:640\n1#2:644\n*S KotlinDebug\n*F\n+ 1 VoiceModel.kt\ncom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceModel\n*L\n87#1:636,4\n92#1:640,4\n*E\n"})
public final class VoiceModel {

    @NotNull
    private static final String TAG;
    private int audioProgress;
    private boolean isPlayRecordingStarted;

    @Nullable
    private Context mContext;

    @NotNull
    private EraserState mEraserState;
    private boolean mIsNotificationClearedByUser;
    private boolean mIsUPSMMode;

    @NotNull
    private final VoiceViewState mPreviousViewState;

    @Nullable
    private RestoreCompleteListener mRestoreCompleteListener;

    @NotNull
    private ArrayList<String> mSelectedVoiceList;

    @Nullable
    private SettingsContentObserver.SettingsContentChangedCallback mSettingsContentChangedCallback;
    private boolean mSyncEnabled;

    @Nullable
    private UpdateVoiceSyncListener mUpdateVoiceSyncListener;

    @NotNull
    private final List<SpenVoiceData> mVoiceList;

    @Nullable
    private SpenWNote mWNote;
    private int recordPlayingIndex;
    private int recordPlayingProgress;
    private int recordingTime;
    private boolean selectMode;

    @NotNull
    private VoiceViewState viewState;

    @Nullable
    private SpenVoiceData voiceData;

    @Nullable
    private SpenObjectVoice voiceObject;

    @NotNull
    private VoiceState voiceState;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceModel$RestoreCompleteListener;", "", "onMenuUpdate", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface RestoreCompleteListener {
        void onMenuUpdate();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceModel$UpdateVoiceSyncListener;", "", "onEnabled", "", "enabled", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface UpdateVoiceSyncListener {
        void onEnabled(boolean enabled);
    }

    static {
        String strCreateTag = Logger.createTag("VoiceModel");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    public VoiceModel(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.viewState = new VoiceViewState();
        this.mPreviousViewState = new VoiceViewState();
        this.mEraserState = EraserState.NORMAL;
        this.voiceState = VoiceState.NONE;
        this.mSyncEnabled = true;
        this.mSelectedVoiceList = new ArrayList<>();
        this.mVoiceList = new ArrayList();
        Logger.m10999d(TAG, "VoiceModel. create");
        this.mContext = activity.getApplication();
        SettingsCompat companion = SettingsCompat.INSTANCE.getInstance();
        C7956a c7956a = new C7956a(this, 2);
        this.mSettingsContentChangedCallback = c7956a;
        companion.registerUPSMChangeCallback(c7956a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(VoiceModel voiceModel, boolean z, Uri uri) {
        Context context = voiceModel.mContext;
        Boolean boolValueOf = context != null ? Boolean.valueOf(SettingsCompat.INSTANCE.getInstance().isUPSM(context)) : null;
        Logger.m10999d(TAG, "onChanged# MINIMAL_BATTERY_USE. mIsUPSMMode = " + voiceModel.mIsUPSMMode + ", isUPSM = " + boolValueOf + ", voiceState = " + voiceModel.voiceState);
        if (!voiceModel.isRecordingVoiceState() || Intrinsics.areEqual(Boolean.valueOf(voiceModel.mIsUPSMMode), boolValueOf)) {
            return;
        }
        voiceModel.stopRecording();
    }

    public final void addSelectedVoice(@Nullable String name) {
        if (name == null || this.mSelectedVoiceList.contains(name)) {
            return;
        }
        this.mSelectedVoiceList.add(name);
    }

    public final void addVoiceData(@Nullable SpenVoiceData voiceData) {
        if (voiceData != null) {
            this.mVoiceList.add(voiceData);
        }
    }

    public final boolean cancelRecording() {
        if (!isRecordingVoiceState()) {
            return false;
        }
        if (this.voiceData == null || !VoiceManager.isRecordingActivated()) {
            setStopData();
            return true;
        }
        Logger.m11003i(TAG, "cancelRecording");
        VoiceManager.cancelRecording();
        return true;
    }

    public final void changeVoiceData(@NotNull SpenVoiceData spenVoiceData) {
        Intrinsics.checkNotNullParameter(spenVoiceData, "spenVoiceData");
        int size = this.mVoiceList.size() - 1;
        if (isLastVoiceData(spenVoiceData)) {
            this.mVoiceList.set(size, spenVoiceData);
        }
    }

    public final void clearSelectedVoiceList() {
        this.mSelectedVoiceList.clear();
    }

    public final void clearVoiceData() {
        this.audioProgress = 0;
        this.voiceObject = null;
        this.recordPlayingIndex = 0;
        this.recordPlayingProgress = 0;
        this.voiceData = null;
        this.voiceState = VoiceState.NONE;
    }

    public final boolean compareViewState(@Nullable VoiceViewState.Type type) {
        return this.viewState.getType() == type;
    }

    public final int getAllRecordTime() {
        Iterator<SpenVoiceData> it = this.mVoiceList.iterator();
        int recordingTime = 0;
        while (it.hasNext()) {
            recordingTime += (int) it.next().getRecordingTime();
        }
        return recordingTime;
    }

    public final int getAudioProgress() {
        return this.audioProgress;
    }

    @Nullable
    /* JADX INFO: renamed from: getDoc, reason: from getter */
    public final SpenWNote getMWNote() {
        return this.mWNote;
    }

    @NotNull
    /* JADX INFO: renamed from: getEraserState, reason: from getter */
    public final EraserState getMEraserState() {
        return this.mEraserState;
    }

    @NotNull
    public final VoiceViewState.Type getPreviousViewStateType() {
        return this.mPreviousViewState.getType();
    }

    public final int getRecordPlayingIndex() {
        return this.recordPlayingIndex;
    }

    public final int getRecordPlayingProgress() {
        return this.recordPlayingProgress;
    }

    public final int getRecordingTime() {
        return this.recordingTime;
    }

    public final boolean getSelectMode() {
        return this.selectMode;
    }

    @NotNull
    public final List<String> getSelectedVoiceList() {
        return this.mSelectedVoiceList;
    }

    public final int getSelectedVoiceListSize() {
        return this.mSelectedVoiceList.size();
    }

    @NotNull
    public final VoiceViewState getViewState() {
        return this.viewState;
    }

    @NotNull
    public final VoiceViewState.Type getViewStateType() {
        return this.viewState.getType();
    }

    @Nullable
    public final SpenVoiceData getVoiceData() {
        return this.voiceData;
    }

    public final int getVoiceDataIndex(@NotNull SpenVoiceData spenVoiceData) {
        Intrinsics.checkNotNullParameter(spenVoiceData, "spenVoiceData");
        return this.mVoiceList.indexOf(spenVoiceData);
    }

    @NotNull
    public final List<SpenVoiceData> getVoiceDataList() {
        return this.mVoiceList;
    }

    public final int getVoiceDataListSize() {
        return this.mVoiceList.size();
    }

    public final int getVoiceDataTimeByIndex(int index) {
        if (this.mVoiceList.isEmpty() || index < 0 || index >= this.mVoiceList.size()) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < index; i2++) {
            int recordingTime = (int) this.mVoiceList.get(i2).getRecordingTime();
            if (recordingTime <= 0) {
                recordingTime = VoiceUtil.INSTANCE.changeTimeType(this.mVoiceList.get(i2).getPlayTime()) * 1000;
            }
            i += recordingTime;
        }
        return i;
    }

    @Nullable
    public final SpenObjectVoice getVoiceObject() {
        return this.voiceObject;
    }

    @NotNull
    public final VoiceState getVoiceState() {
        return this.voiceState;
    }

    public final boolean hasCurrentObjectVoice(@NotNull SpenObjectVoice spenObjectVoice) {
        Intrinsics.checkNotNullParameter(spenObjectVoice, "spenObjectVoice");
        SpenObjectVoice spenObjectVoice2 = this.voiceObject;
        return spenObjectVoice2 != null && spenObjectVoice2.getRuntimeHandle() == spenObjectVoice.getRuntimeHandle();
    }

    public final boolean hasCurrentVoiceData(@NotNull SpenVoiceData spenVoiceData) {
        Intrinsics.checkNotNullParameter(spenVoiceData, "spenVoiceData");
        SpenVoiceData spenVoiceData2 = this.voiceData;
        return spenVoiceData2 != null && spenVoiceData2.getMHandle() == spenVoiceData.getMHandle();
    }

    public final boolean hasObjectVoice(@Nullable SpenObjectVoice spenObjectVoice) {
        if (getMWNote() != null && spenObjectVoice != null) {
            SpenWNote mWNote = getMWNote();
            Intrinsics.checkNotNull(mWNote);
            Iterator<SpenWPage> it = mWNote.getPageList().iterator();
            while (it.hasNext()) {
                Iterator<SpenObjectBase> it2 = it.next().getObjectList(512).iterator();
                while (it2.hasNext()) {
                    if (it2.next().getRuntimeHandle() == spenObjectVoice.getRuntimeHandle()) {
                        return true;
                    }
                }
            }
            SpenWNote mWNote2 = getMWNote();
            Intrinsics.checkNotNull(mWNote2);
            ArrayList<SpenObjectSpan> objectSpan = mWNote2.getBodyText().getObjectSpan();
            if (objectSpan == null) {
                return false;
            }
            Iterator<SpenObjectSpan> it3 = objectSpan.iterator();
            Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
            while (it3.hasNext()) {
                SpenObjectSpan next = it3.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                SpenObjectBase object = next.getObject();
                if (object.getType() == 10 && object.getRuntimeHandle() == spenObjectVoice.getRuntimeHandle()) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean hasVoiceData(@Nullable SpenVoiceData voiceData) {
        if (voiceData == null) {
            return false;
        }
        Iterator<SpenVoiceData> it = this.mVoiceList.iterator();
        while (it.hasNext()) {
            if (it.next().getMHandle() == voiceData.getMHandle()) {
                return true;
            }
        }
        return false;
    }

    public final void init(@NotNull SpenWNote note) {
        Intrinsics.checkNotNullParameter(note, "note");
        setDoc(note);
    }

    public final boolean isContainSelectedVoice(@Nullable String name) {
        return CollectionsKt.contains(this.mSelectedVoiceList, name);
    }

    public final boolean isLastVoiceData(@NotNull SpenVoiceData spenVoiceData) {
        Intrinsics.checkNotNullParameter(spenVoiceData, "spenVoiceData");
        int size = this.mVoiceList.size() - 1;
        return size >= 0 && spenVoiceData.getMHandle() == this.mVoiceList.get(size).getMHandle();
    }

    /* JADX INFO: renamed from: isNotificationClearedByUser, reason: from getter */
    public final boolean getMIsNotificationClearedByUser() {
        return this.mIsNotificationClearedByUser;
    }

    public final boolean isPauseState() {
        return this.voiceState == VoiceState.PLAY_PAUSE;
    }

    public final boolean isPauseVoiceData() {
        return this.voiceData != null && isPauseState();
    }

    public final boolean isPlayingObjectVoiceState() {
        return this.voiceObject != null && isPlayingVoiceState();
    }

    public final boolean isPlayingState() {
        VoiceState voiceState = this.voiceState;
        return voiceState == VoiceState.PLAY_RESUMED || voiceState == VoiceState.PLAY_STARTED || voiceState == VoiceState.PLAY_PROGRESS;
    }

    public final boolean isPlayingVoiceData() {
        return this.voiceData != null && isPlayingState();
    }

    public final boolean isPlayingVoiceDataState() {
        return this.voiceData != null && isPlayingVoiceState();
    }

    public final boolean isPlayingVoiceState() {
        VoiceState voiceState = this.voiceState;
        return voiceState == VoiceState.PLAY_STARTED || voiceState == VoiceState.PLAY_PROGRESS || voiceState == VoiceState.PLAY_PAUSE || voiceState == VoiceState.PLAY_RESUMED;
    }

    public final boolean isRecordingVoiceState() {
        VoiceState voiceState = this.voiceState;
        return voiceState == VoiceState.RECORD_STARTED || voiceState == VoiceState.RECORD_PROGRESS || voiceState == VoiceState.RECORD_PAUSE || voiceState == VoiceState.RECORD_RESUMED;
    }

    /* JADX INFO: renamed from: isSyncEnable, reason: from getter */
    public final boolean getMSyncEnabled() {
        return this.mSyncEnabled;
    }

    public final boolean isVoiceDataItemSTTConverted(int index) {
        if (FeatureInfo.isSupportSTTFunction() && !this.mVoiceList.isEmpty() && index >= 0 && index < this.mVoiceList.size()) {
            SpenVoiceData spenVoiceData = this.mVoiceList.get(index);
            SpenVoiceTextDataReader spenVoiceTextDataReader = SpenVoiceTextDataReaderCache.INSTANCE.getInstance().get(spenVoiceData);
            String[] voiceTexts = spenVoiceTextDataReader.getVoiceTexts();
            int[] voiceTimes = spenVoiceTextDataReader.getVoiceTimes();
            if (voiceTexts != null && voiceTimes != null) {
                Logger.m11003i(TAG, "isVoiceDataItemSTTConverted: item " + spenVoiceData.getName() + " is converted");
                return true;
            }
        }
        return false;
    }

    public final boolean isVoiceSyncPlaying() {
        return isPlayingVoiceData() && getMSyncEnabled();
    }

    public final void onDestroy() {
        SettingsCompat.INSTANCE.getInstance().unregisterUPSMChangeCallback(this.mSettingsContentChangedCallback);
    }

    public final void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putInt(VoiceConstants.AUDIO_PROGRESS, this.audioProgress);
        outState.putInt(VoiceConstants.RECORD_TIME, this.recordingTime);
        outState.putInt(VoiceConstants.RECORD_PLAYING_INDEX, this.recordPlayingIndex);
        outState.putInt(VoiceConstants.RECORD_PLAYING_PROGRESS, this.recordPlayingProgress);
        outState.putParcelable(VoiceConstants.VOICE_VIEW_STATE, this.viewState);
        outState.putSerializable(VoiceConstants.VOICE_STATE, this.voiceState);
        outState.putStringArrayList(VoiceConstants.RECORD_DELETE_ITEM_INDEX, this.mSelectedVoiceList);
        outState.putBoolean(VoiceConstants.PLAY_RECORDING_START, this.isPlayRecordingStarted);
        outState.putInt(VoiceConstants.AUDIO_ERASER_STATE, this.mEraserState.ordinal());
    }

    public final /* synthetic */ <T extends Parcelable> T parcelable(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        if (Build.VERSION.SDK_INT >= 33) {
            Intrinsics.reifiedOperationMarker(4, "T");
            return (T) bundle.getParcelable(str, Parcelable.class);
        }
        T t = (T) bundle.getParcelable(str);
        Intrinsics.reifiedOperationMarker(2, "T");
        return t;
    }

    public final boolean pause() {
        if (!isPlayingState()) {
            return false;
        }
        Logger.m11003i(TAG, "pausePlaying");
        VoiceManager.pausePlaying();
        return true;
    }

    public final boolean playPause() {
        if (!isPauseState()) {
            return pause();
        }
        Logger.m11003i(TAG, "resumePlaying");
        VoiceManager.resumePlaying();
        return true;
    }

    public final void playVoiceData() {
        ArrayList arrayList = new ArrayList(this.mVoiceList);
        int i = this.recordPlayingIndex;
        int i2 = this.recordPlayingProgress;
        AbstractC14516b.m15114b(i, i2, "PlayVoiceData. ", SQLKeyword.COMMA, TAG);
        VoiceManager.playVoiceList(arrayList, i);
        if (i2 > 0) {
            VoiceManager.seekTo(i, i2);
        }
    }

    public final void removeErrorVoiceData(@Nullable SpenVoiceData voiceData) {
        if (this.mWNote == null || voiceData == null) {
            return;
        }
        Iterator<SpenVoiceData> it = this.mVoiceList.iterator();
        while (it.hasNext()) {
            SpenVoiceData next = it.next();
            if (next.getMHandle() == voiceData.getMHandle()) {
                int iIndexOf = this.mVoiceList.indexOf(next);
                it.remove();
                SpenWNote spenWNote = this.mWNote;
                Intrinsics.checkNotNull(spenWNote);
                spenWNote.removeVoiceData(iIndexOf);
                AbstractC8014b.m7217s(iIndexOf, "remove Voice data. ", TAG);
                return;
            }
        }
    }

    public final void removeSelectedVoice(@Nullable String name) {
        TypeIntrinsics.asMutableCollection(this.mSelectedVoiceList).remove(name);
    }

    public final void removeVoiceData(int index) {
        if (index < 0 || index >= this.mVoiceList.size()) {
            return;
        }
        this.mVoiceList.remove(index);
    }

    public final void restorePlayData(@Nullable SpenObjectVoice objectVoice, @Nullable SpenVoiceData voiceData) {
        this.voiceObject = objectVoice;
        this.voiceData = voiceData;
        if (objectVoice == null && voiceData == null) {
            clearVoiceData();
            if (this.viewState.getType() == VoiceViewState.Type.RECORD) {
                this.viewState.setType(VoiceViewState.Type.NONE);
            }
        }
    }

    public final void restoreState(@NotNull Bundle inState) {
        Parcelable parcelable;
        Object serializable;
        Intrinsics.checkNotNullParameter(inState, "inState");
        this.audioProgress = inState.getInt(VoiceConstants.AUDIO_PROGRESS, 0);
        this.recordingTime = inState.getInt(VoiceConstants.RECORD_TIME, 0);
        this.recordPlayingIndex = inState.getInt(VoiceConstants.RECORD_PLAYING_INDEX, 0);
        this.recordPlayingProgress = inState.getInt(VoiceConstants.RECORD_PLAYING_PROGRESS, 0);
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            parcelable = (Parcelable) inState.getParcelable(VoiceConstants.VOICE_VIEW_STATE, VoiceViewState.class);
        } else {
            Parcelable parcelable2 = inState.getParcelable(VoiceConstants.VOICE_VIEW_STATE);
            if (!(parcelable2 instanceof VoiceViewState)) {
                parcelable2 = null;
            }
            parcelable = (VoiceViewState) parcelable2;
        }
        VoiceViewState voiceViewState = (VoiceViewState) parcelable;
        if (voiceViewState != null) {
            this.viewState = voiceViewState;
        }
        if (i >= 33) {
            serializable = inState.getSerializable(VoiceConstants.VOICE_STATE, VoiceState.class);
        } else {
            Object serializable2 = inState.getSerializable(VoiceConstants.VOICE_STATE);
            serializable = (VoiceState) (serializable2 instanceof VoiceState ? serializable2 : null);
        }
        VoiceState voiceState = (VoiceState) serializable;
        if (voiceState != null) {
            this.voiceState = voiceState;
        }
        ArrayList<String> stringArrayList = inState.getStringArrayList(VoiceConstants.RECORD_DELETE_ITEM_INDEX);
        if (stringArrayList != null) {
            this.mSelectedVoiceList = stringArrayList;
        }
        this.isPlayRecordingStarted = inState.getBoolean(VoiceConstants.PLAY_RECORDING_START, false);
        this.mEraserState = EraserState.getEntries().get(inState.getInt(VoiceConstants.AUDIO_ERASER_STATE, 0));
        RestoreCompleteListener restoreCompleteListener = this.mRestoreCompleteListener;
        if (restoreCompleteListener != null) {
            restoreCompleteListener.onMenuUpdate();
        }
    }

    public final /* synthetic */ <T extends Serializable> T serializable(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        if (Build.VERSION.SDK_INT >= 33) {
            Intrinsics.reifiedOperationMarker(4, "T");
            return (T) bundle.getSerializable(str, Serializable.class);
        }
        T t = (T) bundle.getSerializable(str);
        Intrinsics.reifiedOperationMarker(2, "T");
        return t;
    }

    public final void setAudioProgress(int i) {
        this.audioProgress = i;
    }

    public final void setDoc(@Nullable SpenWNote spenWNote) {
        ArrayList<SpenVoiceData> voiceDataList;
        this.mWNote = spenWNote;
        this.mVoiceList.clear();
        if (spenWNote != null && (voiceDataList = spenWNote.getVoiceDataList()) != null) {
            this.mVoiceList.addAll(voiceDataList);
        }
        AbstractC8014b.m7217s(this.mVoiceList.size(), "setDoc. ", TAG);
    }

    public final void setEraserState(@NotNull EraserState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state == EraserState.ERASING || state == EraserState.ERASED) {
            VoiceManager.setAudioEraserEnabled(true);
        } else {
            VoiceManager.setAudioEraserEnabled(false);
        }
        this.mEraserState = state;
    }

    public final void setNewName(@NotNull String newName) {
        int iIndexOf;
        SpenVoiceData voiceData;
        Intrinsics.checkNotNullParameter(newName, "newName");
        String str = this.mSelectedVoiceList.get(0);
        Intrinsics.checkNotNullExpressionValue(str, "get(...)");
        String str2 = str;
        Iterator<SpenVoiceData> it = this.mVoiceList.iterator();
        while (true) {
            if (!it.hasNext()) {
                iIndexOf = -1;
                break;
            }
            SpenVoiceData next = it.next();
            if (Intrinsics.areEqual(str2, next.getName())) {
                iIndexOf = this.mVoiceList.indexOf(next);
                break;
            }
        }
        if (iIndexOf >= 0) {
            this.mVoiceList.get(iIndexOf).setName(newName);
            SpenWNote spenWNote = this.mWNote;
            if (spenWNote != null && (voiceData = spenWNote.getVoiceData(iIndexOf)) != null) {
                voiceData.setName(newName);
            }
        }
        this.mSelectedVoiceList.remove(0);
        this.mSelectedVoiceList.add(newName);
    }

    public final void setNotificationClearByUser(boolean isNotificationClearedByUser) {
        this.mIsNotificationClearedByUser = isNotificationClearedByUser;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setPlayData(@Nullable SpenObjectVoice objectVoice, @Nullable SpenVoiceData voiceData) {
        this.voiceObject = objectVoice;
        this.voiceData = voiceData;
        this.voiceState = VoiceState.PLAY_STARTED;
        this.isPlayRecordingStarted = true;
        String str = TAG;
        Object obj = objectVoice;
        if (objectVoice == null) {
            obj = "null";
        }
        if (voiceData == 0) {
            voiceData = "null";
        }
        Logger.m11003i(str, "setPlayData. " + obj + " // " + voiceData);
    }

    public final void setRecordData(@Nullable SpenVoiceData voiceData) {
        this.voiceObject = null;
        this.voiceData = voiceData;
        this.voiceState = VoiceState.RECORD_STARTED;
        this.isPlayRecordingStarted = true;
    }

    public final void setRecordPlayingIndex(int i) {
        this.recordPlayingIndex = i;
    }

    public final void setRecordPlayingInfo(int index, int progress) {
        this.recordPlayingIndex = index;
        this.recordPlayingProgress = progress;
    }

    public final void setRecordPlayingProgress(int i) {
        this.recordPlayingProgress = i;
    }

    public final void setRecordingTime(int i) {
        this.recordingTime = i;
    }

    public final void setRecordingTimeState(int time) {
        this.recordingTime = time;
        this.voiceState = VoiceState.RECORD_PROGRESS;
    }

    public final void setRestoreCompleteListener(@Nullable RestoreCompleteListener listener) {
        this.mRestoreCompleteListener = listener;
    }

    public final void setSelectMode(boolean z) {
        this.selectMode = z;
    }

    public final void setStopData() {
        String str = TAG;
        Object obj = this.voiceObject;
        if (obj == null) {
            obj = "null";
        }
        SpenVoiceData spenVoiceData = this.voiceData;
        Logger.m11003i(str, "setStopData. " + obj + " // " + (spenVoiceData != null ? spenVoiceData : "null"));
        if (this.voiceObject != null) {
            this.audioProgress = 0;
            this.voiceObject = null;
        } else if (this.voiceData != null) {
            this.recordPlayingIndex = 0;
            this.recordPlayingProgress = 0;
            this.voiceData = null;
        }
        this.voiceState = VoiceState.NONE;
    }

    public final void setSyncEnable(boolean z) {
        this.mSyncEnabled = z;
        UpdateVoiceSyncListener updateVoiceSyncListener = this.mUpdateVoiceSyncListener;
        if (updateVoiceSyncListener != null) {
            updateVoiceSyncListener.onEnabled(z);
        }
    }

    public final void setUpdateVoiceSyncListener(@Nullable UpdateVoiceSyncListener listener) {
        this.mUpdateVoiceSyncListener = listener;
    }

    public final void setViewStateType(@NotNull VoiceViewState.Type stateType) {
        Intrinsics.checkNotNullParameter(stateType, "stateType");
        if (stateType == VoiceViewState.Type.RECORD) {
            Context context = this.mContext;
            boolean z = false;
            if (context != null && SettingsCompat.INSTANCE.getInstance().isUPSM(context)) {
                z = true;
            }
            this.mIsUPSMMode = z;
        }
        this.mPreviousViewState.setType(this.viewState.getType());
        this.viewState.setType(stateType);
        Logger.m11003i(TAG, "setViewStateType " + stateType + ", mIsUPSMMode = " + this.mIsUPSMMode);
    }

    public final void setVoiceData(@Nullable SpenVoiceData spenVoiceData) {
        this.voiceData = spenVoiceData;
    }

    public final void setVoiceObject(@Nullable SpenObjectVoice spenObjectVoice) {
        this.voiceObject = spenObjectVoice;
    }

    public final void setVoiceState(@NotNull VoiceState voiceState) {
        Intrinsics.checkNotNullParameter(voiceState, "<set-?>");
        this.voiceState = voiceState;
    }

    public final boolean stopPlaying() {
        if (!isPlayingVoiceState()) {
            return false;
        }
        if ((this.voiceData == null && this.voiceObject == null) || !VoiceManager.isPlayingActivated()) {
            setStopData();
            return true;
        }
        Logger.m11003i(TAG, "stopPlaying");
        VoiceManager.stopPlaying();
        return true;
    }

    public final boolean stopRecording() {
        if (!isRecordingVoiceState()) {
            return false;
        }
        if (this.voiceData == null || !VoiceManager.isRecordingActivated()) {
            setStopData();
            return true;
        }
        Logger.m11003i(TAG, "stopRecording");
        VoiceManager.stopRecording();
        return true;
    }

    public final void stopRecordingOrPlaying() {
        stopRecording();
        stopPlaying();
    }

    public final void updateOnlyScreenOn(boolean enabled) {
        UpdateVoiceSyncListener updateVoiceSyncListener = this.mUpdateVoiceSyncListener;
        if (updateVoiceSyncListener != null) {
            updateVoiceSyncListener.onEnabled(enabled);
        }
    }

    public final void updateVoiceData(int index) {
        this.voiceData = (index < 0 || index >= this.mVoiceList.size()) ? null : this.mVoiceList.get(index);
    }

    public final void removeVoiceData(@NotNull SpenVoiceData voiceData) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        this.mVoiceList.remove(voiceData);
    }
}
