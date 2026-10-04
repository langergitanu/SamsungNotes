package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice;

import android.app.Activity;
import android.content.Intent;
import android.media.session.MediaSession;
import android.view.KeyEvent;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.composer.voice.VoiceManager;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.inapp.common.InAppLogger;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.controller.ViewState;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.EraserState;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.VoiceModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.VoiceState;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.VoiceViewState;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.VoiceRecordingEventListener;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.MenuPresenterContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.RunnableC9767a;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.RunnableC9844c;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.voice.EarphoneButtonManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.voice.VoiceService;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.stt.common.constant.STTConstant;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 a2\u00020\u0001:\u0004^_`aBA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020'J\b\u0010(\u001a\u00020$H\u0002J\u0018\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016J\u0018\u0010.\u001a\u00020$2\u0006\u0010*\u001a\u00020+2\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020$2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u00102\u001a\u00020$2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u00103\u001a\u00020$2\u0006\u0010*\u001a\u00020+H\u0016J\b\u00104\u001a\u00020$H\u0002J\u0018\u00105\u001a\u00020$2\u0006\u0010*\u001a\u00020+2\u0006\u00106\u001a\u00020-H\u0016J\u0010\u00107\u001a\u00020$2\u0006\u0010*\u001a\u00020+H\u0016J\u0018\u00108\u001a\u00020$2\u0006\u00109\u001a\u00020:2\u0006\u00106\u001a\u00020-H\u0016J\u0018\u0010;\u001a\u00020$2\u0006\u00109\u001a\u00020:2\u0006\u00106\u001a\u00020-H\u0016J\u0010\u0010<\u001a\u00020$2\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010=\u001a\u00020$2\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010>\u001a\u00020$2\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010?\u001a\u00020$2\u0006\u00109\u001a\u00020:H\u0016J\u0018\u0010@\u001a\u00020$2\u0006\u00109\u001a\u00020:2\u0006\u00106\u001a\u00020-H\u0016J\u0010\u0010A\u001a\u00020$2\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010B\u001a\u00020$2\u0006\u0010C\u001a\u00020:H\u0016J\u0018\u0010D\u001a\u00020$2\u0006\u0010*\u001a\u00020+2\u0006\u0010E\u001a\u00020-H\u0016J\u0018\u0010F\u001a\u00020$2\u0006\u0010*\u001a\u00020+2\u0006\u0010G\u001a\u00020-H\u0016J\u0010\u0010H\u001a\u00020$2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010I\u001a\u00020$2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010J\u001a\u00020$2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010K\u001a\u00020$2\u0006\u0010*\u001a\u00020+H\u0016J\u0018\u0010L\u001a\u00020$2\u0006\u0010*\u001a\u00020+2\u0006\u0010M\u001a\u00020-H\u0016J\u0010\u0010N\u001a\u00020$2\u0006\u0010*\u001a\u00020+H\u0016J\u0018\u0010O\u001a\u00020$2\u0006\u0010*\u001a\u00020+2\u0006\u0010P\u001a\u00020-H\u0016J\u0010\u0010Q\u001a\u00020$2\u0006\u0010*\u001a\u00020+H\u0002J\u000e\u0010R\u001a\u00020$2\u0006\u0010S\u001a\u00020\u001aJ\u0006\u0010T\u001a\u00020\u001aJ\u000e\u0010U\u001a\u00020$2\u0006\u0010S\u001a\u00020\u001aJ\u0006\u0010V\u001a\u00020\u001aJ\u0010\u0010W\u001a\u00020$2\b\u0010X\u001a\u0004\u0018\u00010\u0018J\u0006\u0010Y\u001a\u00020$J\u000e\u0010Z\u001a\u00020$2\u0006\u0010[\u001a\u000200R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u00060 R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020]X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordingEventListenerImpl;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/VoiceRecordingEventListener;", "mMenuManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/common/MenuPresenterContract$IMenuManager;", "composerModel", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/ComposerModel;", "viewState", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/controller/ViewState;", "presenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordListPresenter;", "sttPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/STTPresenterImpl;", "objectManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/ObjectManager;", "mVoiceSubPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordMenuSubPresenter;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/common/MenuPresenterContract$IMenuManager;Lcom/samsung/android/support/senl/nt/composer/main/base/model/ComposerModel;Lcom/samsung/android/support/senl/nt/composer/main/base/model/controller/ViewState;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordListPresenter;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/STTPresenterImpl;Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/ObjectManager;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordMenuSubPresenter;)V", "mComposerModel", "mVoiceModel", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceModel;", "mViewState", "mVoiceListPresenter", "mActivity", "Landroid/app/Activity;", "mPlayingAudio", "", "mPlayingVoice", "mInitPlayAudioEraser", "mVoiceStateAfterInit", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceState;", "mRecordingEventAction", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordingEventListenerImpl$AbsRecordingEventAction;", "mSttPresenter", "mObjectManager", "setCoedit", "", "isCoedit", "composerPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;", "startVoiceService", "onUpdateRecordTime", "voiceData", "Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;", "time", "", "onRecordStart", "cachePath", "", "onRecordStop", "onRecordResume", "onRecordCancel", "updateVoiceView", "onRecordError", "i", "onRecordPause", "onPlayError", "spenObjectVoice", "Lcom/samsung/android/sdk/pen/document/SpenObjectVoice;", "onPlayPrepared", "onPlayStarted", "onPlayPaused", "onPlayResumed", "onPlayStopped", "onPlaySeekComplete", "onPlayComplete", "onPlayClicked", "objectVoice", "onRecordPlayError", "errorCode", "onRecordPlayPrepared", XmlErrorCodes.DURATION, "onRecordPlayStart", "onRecordPlayStop", "onRecordPlayPause", "onRecordPlayResume", "onUpdateRecordPlayTime", "position", "onRecordPlayComplete", "onRecordPlayInfo", "mediaInfo", "errorRecording", "setPlayingVoice", "playing", "isPlayingVoice", "setPlayingAudio", "isPlayingAudio", "onAttachView", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "onDetachView", "updateMediaSession", "tag", "mCallback", "Landroid/media/session/MediaSession$Callback;", "AbsRecordingEventAction", "RecordingEventAction", "CoeditRecordingEventAction", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VoiceRecordingEventListenerImpl implements VoiceRecordingEventListener {

    @NotNull
    private static final String TAG;

    @Nullable
    private Activity mActivity;

    @NotNull
    private final MediaSession.Callback mCallback;

    @NotNull
    private final ComposerModel mComposerModel;
    private boolean mInitPlayAudioEraser;

    @NotNull
    private final MenuPresenterContract.IMenuManager mMenuManager;

    @NotNull
    private final ObjectManager mObjectManager;
    private boolean mPlayingAudio;
    private boolean mPlayingVoice;

    @NotNull
    private AbsRecordingEventAction mRecordingEventAction;

    @Nullable
    private final STTPresenterImpl mSttPresenter;

    @NotNull
    private final ViewState mViewState;

    @NotNull
    private final VoiceRecordListPresenter mVoiceListPresenter;

    @NotNull
    private final VoiceModel mVoiceModel;

    @NotNull
    private VoiceState mVoiceStateAfterInit;

    @NotNull
    private final VoiceRecordMenuSubPresenter mVoiceSubPresenter;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b¢\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH&J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordingEventListenerImpl$AbsRecordingEventAction;", "", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordingEventListenerImpl;)V", "onUpdateRecordTime", "", "voiceData", "Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;", "time", "", "getRecordingTimeState", "onRecordStop", "updateRecordStopState", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public abstract class AbsRecordingEventAction {
        public AbsRecordingEventAction() {
        }

        public abstract int getRecordingTimeState(int time);

        public final void onRecordStop(@NotNull SpenVoiceData voiceData) {
            Intrinsics.checkNotNullParameter(voiceData, "voiceData");
            if (VoiceRecordingEventListenerImpl.this.mVoiceModel.hasVoiceData(voiceData)) {
                VoiceRecordingEventListenerImpl.this.mVoiceModel.changeVoiceData(voiceData);
                VoiceRecordingEventListenerImpl.this.mVoiceModel.setStopData();
                updateRecordStopState(voiceData);
            }
            EarphoneButtonManager.INSTANCE.getInstance().updateMediaSession(VoiceRecordingEventListenerImpl.this.mActivity, "onRecordStop", VoiceRecordingEventListenerImpl.this.mViewState, VoiceRecordingEventListenerImpl.this.mCallback);
        }

        public final void onUpdateRecordTime(@NotNull SpenVoiceData voiceData, int time) {
            Intrinsics.checkNotNullParameter(voiceData, "voiceData");
            if (VoiceRecordingEventListenerImpl.this.mVoiceModel.hasCurrentVoiceData(voiceData)) {
                VoiceRecordingEventListenerImpl.this.mVoiceModel.setRecordingTimeState(getRecordingTimeState(time));
                VoiceRecordingEventListenerImpl.this.mVoiceListPresenter.setRecordingTime();
            }
        }

        public abstract void updateRecordStopState(@NotNull SpenVoiceData voiceData);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordingEventListenerImpl$CoeditRecordingEventAction;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordingEventListenerImpl$AbsRecordingEventAction;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordingEventListenerImpl;", "mComposerPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordingEventListenerImpl;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;)V", "getRecordingTimeState", "", "time", "updateRecordStopState", "", "voiceData", "Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nVoiceRecordingEventListenerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VoiceRecordingEventListenerImpl.kt\ncom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordingEventListenerImpl$CoeditRecordingEventAction\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,550:1\n739#2,9:551\n37#3:560\n36#3,3:561\n*S KotlinDebug\n*F\n+ 1 VoiceRecordingEventListenerImpl.kt\ncom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordingEventListenerImpl$CoeditRecordingEventAction\n*L\n530#1:551,9\n531#1:560\n531#1:561,3\n*E\n"})
    public final class CoeditRecordingEventAction extends AbsRecordingEventAction {

        @NotNull
        private final ComposerViewPresenter mComposerPresenter;
        final /* synthetic */ VoiceRecordingEventListenerImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CoeditRecordingEventAction(@NotNull VoiceRecordingEventListenerImpl voiceRecordingEventListenerImpl, ComposerViewPresenter mComposerPresenter) {
            super();
            Intrinsics.checkNotNullParameter(mComposerPresenter, "mComposerPresenter");
            this.this$0 = voiceRecordingEventListenerImpl;
            this.mComposerPresenter = mComposerPresenter;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordingEventListenerImpl.AbsRecordingEventAction
        public int getRecordingTimeState(int time) {
            return time;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordingEventListenerImpl.AbsRecordingEventAction
        public void updateRecordStopState(@NotNull SpenVoiceData voiceData) {
            List listEmptyList;
            Intrinsics.checkNotNullParameter(voiceData, "voiceData");
            int currentPageIndex = this.mComposerPresenter.getPageManager().getDocPageInfo().getCurrentPageIndex();
            String name = voiceData.getName();
            Intrinsics.checkNotNull(name);
            List<String> listSplit = new Regex(" ").split(name, 0);
            if (listSplit.isEmpty()) {
                listEmptyList = CollectionsKt.emptyList();
            } else {
                ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
                while (listIterator.hasPrevious()) {
                    if (listIterator.previous().length() != 0) {
                        listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listSplit);
                        break;
                    }
                }
                listEmptyList = CollectionsKt.emptyList();
            }
            this.mComposerPresenter.getObjectManager().insertObjectVoice(currentPageIndex, voiceData.getAttachedFile(), ((String[]) listEmptyList.toArray(new String[0]))[0]);
            this.this$0.mVoiceModel.removeErrorVoiceData(voiceData);
            this.this$0.mVoiceListPresenter.recordStop();
            if (this.this$0.mVoiceModel.getVoiceDataListSize() == 0) {
                this.this$0.mVoiceListPresenter.hideAllView();
            } else {
                this.this$0.mVoiceListPresenter.showInitView();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordingEventListenerImpl$RecordingEventAction;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordingEventListenerImpl$AbsRecordingEventAction;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordingEventListenerImpl;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordingEventListenerImpl;)V", "getRecordingTimeState", "", "time", "updateRecordStopState", "", "voiceData", "Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class RecordingEventAction extends AbsRecordingEventAction {
        public RecordingEventAction() {
            super();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordingEventListenerImpl.AbsRecordingEventAction
        public int getRecordingTimeState(int time) {
            return (VoiceRecordingEventListenerImpl.this.mVoiceModel.getAllRecordTime() / 1000) + time;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordingEventListenerImpl.AbsRecordingEventAction
        public void updateRecordStopState(@NotNull SpenVoiceData voiceData) {
            Intrinsics.checkNotNullParameter(voiceData, "voiceData");
            VoiceRecordListPresenter voiceRecordListPresenter = VoiceRecordingEventListenerImpl.this.mVoiceListPresenter;
            String playTime = voiceData.getPlayTime();
            Intrinsics.checkNotNull(playTime);
            voiceRecordListPresenter.updateLastItemPlayTime(playTime);
            VoiceRecordingEventListenerImpl.this.mVoiceListPresenter.recordStop();
            VoiceRecordingEventListenerImpl.this.mVoiceListPresenter.showInitView();
        }
    }

    static {
        String strCreateTag = Logger.createTag("VoiceRecordingEventListenerImpl");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    public VoiceRecordingEventListenerImpl(@NotNull MenuPresenterContract.IMenuManager mMenuManager, @NotNull ComposerModel composerModel, @NotNull ViewState viewState, @NotNull VoiceRecordListPresenter presenter, @Nullable STTPresenterImpl sTTPresenterImpl, @NotNull ObjectManager objectManager, @NotNull VoiceRecordMenuSubPresenter mVoiceSubPresenter) {
        Intrinsics.checkNotNullParameter(mMenuManager, "mMenuManager");
        Intrinsics.checkNotNullParameter(composerModel, "composerModel");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        Intrinsics.checkNotNullParameter(objectManager, "objectManager");
        Intrinsics.checkNotNullParameter(mVoiceSubPresenter, "mVoiceSubPresenter");
        this.mMenuManager = mMenuManager;
        this.mVoiceSubPresenter = mVoiceSubPresenter;
        this.mComposerModel = composerModel;
        VoiceModel voiceModel = composerModel.getVoiceModel();
        Intrinsics.checkNotNullExpressionValue(voiceModel, "getVoiceModel(...)");
        this.mVoiceModel = voiceModel;
        this.mViewState = viewState;
        this.mVoiceListPresenter = presenter;
        this.mInitPlayAudioEraser = true;
        this.mVoiceStateAfterInit = voiceModel.getVoiceState();
        this.mCallback = new MediaSession.Callback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordingEventListenerImpl$mCallback$1
            @Override // android.media.session.MediaSession.Callback
            public boolean onMediaButtonEvent(Intent mediaButtonIntent) {
                KeyEvent keyEvent;
                Intrinsics.checkNotNullParameter(mediaButtonIntent, "mediaButtonIntent");
                if (!EarphoneButtonManager.INSTANCE.getInstance().isValidMediaButtonEvent() || !Intrinsics.areEqual("android.intent.action.MEDIA_BUTTON", mediaButtonIntent.getAction()) || (keyEvent = (KeyEvent) mediaButtonIntent.getParcelableExtra("android.intent.extra.KEY_EVENT", KeyEvent.class)) == null || keyEvent.getAction() != 0) {
                    return false;
                }
                int keyCode = keyEvent.getKeyCode();
                if (keyCode == 79 || keyCode == 85 || keyCode == 126 || keyCode == 127) {
                    return this.this$0.mVoiceListPresenter.startNewRecordingByMediaEvent();
                }
                return false;
            }
        };
        this.mRecordingEventAction = new RecordingEventAction();
        this.mSttPresenter = sTTPresenterImpl;
        this.mObjectManager = objectManager;
    }

    private final void errorRecording(SpenVoiceData voiceData) {
        if (this.mVoiceModel.getMWNote() != null) {
            SpenWNote mWNote = this.mVoiceModel.getMWNote();
            Intrinsics.checkNotNull(mWNote);
            if (mWNote.isClosed()) {
                return;
            }
            this.mVoiceListPresenter.getVoiceMenuList();
            VoiceRecordListPresenter voiceRecordListPresenter = this.mVoiceListPresenter;
            String name = voiceData.getName();
            Intrinsics.checkNotNull(name);
            voiceRecordListPresenter.removeOnlyItem(name);
            this.mVoiceModel.removeErrorVoiceData(voiceData);
            updateVoiceView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPlayStopped$lambda$0(VoiceRecordingEventListenerImpl voiceRecordingEventListenerImpl) {
        voiceRecordingEventListenerImpl.mVoiceListPresenter.hideAudioPlayView();
    }

    private final void startVoiceService() {
        Logger.m11003i(TAG, "startVoiceService");
        VoiceService.INSTANCE.startService(this.mActivity, this.mComposerModel, this.mObjectManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateMediaSession$lambda$1(VoiceRecordingEventListenerImpl voiceRecordingEventListenerImpl, String str) {
        EarphoneButtonManager.INSTANCE.getInstance().updateMediaSession(voiceRecordingEventListenerImpl.mActivity, str, voiceRecordingEventListenerImpl.mViewState, voiceRecordingEventListenerImpl.mCallback);
    }

    private final void updateVoiceView() {
        if (this.mVoiceModel.getVoiceDataList().isEmpty()) {
            this.mVoiceModel.setViewStateType(VoiceViewState.Type.HIDE);
        } else if (this.mVoiceModel.compareViewState(VoiceViewState.Type.RECORD_MINIMIZED)) {
            this.mVoiceModel.setViewStateType(VoiceViewState.Type.VOICEINIT_MINIMIZED);
        } else {
            this.mVoiceModel.setViewStateType(VoiceViewState.Type.VOICEINIT);
        }
        this.mVoiceListPresenter.updateVoiceMenu();
    }

    /* JADX INFO: renamed from: isPlayingAudio, reason: from getter */
    public final boolean getMPlayingAudio() {
        return this.mPlayingAudio;
    }

    /* JADX INFO: renamed from: isPlayingVoice, reason: from getter */
    public final boolean getMPlayingVoice() {
        return this.mPlayingVoice;
    }

    public final void onAttachView(@Nullable Activity activity) {
        this.mActivity = activity;
    }

    public final void onDetachView() {
        this.mActivity = null;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.VoiceRecordingEventListener
    public void onPlayClicked(@NotNull SpenObjectVoice objectVoice) {
        Intrinsics.checkNotNullParameter(objectVoice, "objectVoice");
        if (!this.mVoiceModel.hasObjectVoice(objectVoice)) {
            Logger.m11000e(TAG, "onPlayClicked. hasObjectVoice is false. " + objectVoice);
            return;
        }
        if (this.mVoiceModel.isPlayingObjectVoiceState()) {
            this.mPlayingAudio = true;
            this.mVoiceModel.stopPlaying();
        }
        Logger.m11003i(TAG, "onPlayClicked.");
        VoiceManager.play(objectVoice);
        this.mVoiceListPresenter.clearSelectionObject();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.VoiceRecordingEventListener
    public void onPlayComplete(@NotNull SpenObjectVoice spenObjectVoice) {
        Intrinsics.checkNotNullParameter(spenObjectVoice, "spenObjectVoice");
        if (this.mVoiceModel.hasCurrentObjectVoice(spenObjectVoice)) {
            if (this.mVoiceModel.hasCurrentObjectVoice(spenObjectVoice)) {
                this.mVoiceModel.setStopData();
                this.mPlayingAudio = false;
            }
            if (this.mVoiceModel.getViewState().isVisibleState()) {
                this.mVoiceListPresenter.hideAudioPlayView();
            }
            updateMediaSession("onPlayComplete");
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.VoiceRecordingEventListener
    public void onPlayError(@NotNull SpenObjectVoice spenObjectVoice, int i) {
        Intrinsics.checkNotNullParameter(spenObjectVoice, "spenObjectVoice");
        if (this.mVoiceModel.hasCurrentObjectVoice(spenObjectVoice)) {
            this.mVoiceModel.setVoiceState(VoiceState.ERROR);
            this.mVoiceModel.setStopData();
            this.mPlayingAudio = false;
        }
        if (this.mVoiceModel.getViewState().isVisibleState()) {
            this.mVoiceListPresenter.hideAudioPlayView();
        }
        updateMediaSession("onPlayError");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.VoiceRecordingEventListener
    public void onPlayPaused(@NotNull SpenObjectVoice spenObjectVoice) {
        Intrinsics.checkNotNullParameter(spenObjectVoice, "spenObjectVoice");
        if (this.mVoiceModel.hasCurrentObjectVoice(spenObjectVoice)) {
            this.mVoiceModel.setVoiceState(VoiceState.PLAY_PAUSE);
            this.mVoiceListPresenter.setPlayPauseViewVoiceObject(false);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.VoiceRecordingEventListener
    public void onPlayPrepared(@NotNull SpenObjectVoice spenObjectVoice, int i) {
        Intrinsics.checkNotNullParameter(spenObjectVoice, "spenObjectVoice");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.VoiceRecordingEventListener
    public void onPlayResumed(@NotNull SpenObjectVoice spenObjectVoice) {
        Intrinsics.checkNotNullParameter(spenObjectVoice, "spenObjectVoice");
        if (this.mVoiceModel.hasCurrentObjectVoice(spenObjectVoice)) {
            this.mVoiceModel.setVoiceState(VoiceState.PLAY_RESUMED);
            this.mVoiceListPresenter.setPlayPauseViewVoiceObject(true);
            startVoiceService();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.VoiceRecordingEventListener
    public void onPlaySeekComplete(@NotNull SpenObjectVoice spenObjectVoice, int i) {
        Intrinsics.checkNotNullParameter(spenObjectVoice, "spenObjectVoice");
        if (this.mVoiceModel.hasCurrentObjectVoice(spenObjectVoice)) {
            this.mVoiceModel.setAudioProgress(i);
            if (this.mVoiceModel.isPlayingState()) {
                this.mVoiceModel.setVoiceState(VoiceState.PLAY_PROGRESS);
            }
            this.mVoiceListPresenter.setUpdatePlayTime(i);
            this.mPlayingAudio = false;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.VoiceRecordingEventListener
    public void onPlayStarted(@NotNull SpenObjectVoice spenObjectVoice) {
        Intrinsics.checkNotNullParameter(spenObjectVoice, "spenObjectVoice");
        if (this.mVoiceModel.hasObjectVoice(spenObjectVoice)) {
            this.mVoiceModel.setPlayData(spenObjectVoice, null);
            this.mVoiceListPresenter.showAudioPlayView(spenObjectVoice, this.mVoiceModel.getAudioProgress(), true);
            startVoiceService();
            return;
        }
        String attachedFile = spenObjectVoice.getAttachedFile();
        if (attachedFile == null || !AbstractC2322a.m1607A(attachedFile)) {
            Logger.m11004w(TAG, "onPlayStarted# does not exist. ");
        } else if (Intrinsics.areEqual(this.mVoiceListPresenter.getPlaySPDVoiceTag(), attachedFile)) {
            Logger.m11003i(TAG, "onPlayStarted# for SPD voice tag ");
            this.mVoiceModel.setPlayData(spenObjectVoice, null);
            this.mVoiceListPresenter.showAudioPlayView(spenObjectVoice, this.mVoiceModel.getAudioProgress(), true);
            startVoiceService();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.VoiceRecordingEventListener
    public void onPlayStopped(@NotNull SpenObjectVoice spenObjectVoice) {
        Intrinsics.checkNotNullParameter(spenObjectVoice, "spenObjectVoice");
        if (this.mVoiceModel.hasCurrentObjectVoice(spenObjectVoice)) {
            this.mVoiceModel.setStopData();
            this.mPlayingAudio = false;
            if (this.mVoiceModel.getViewState().isVisibleState()) {
                Activity activity = this.mActivity;
                Intrinsics.checkNotNull(activity);
                activity.runOnUiThread(new RunnableC9767a(this, 3));
            }
            updateMediaSession("onPlayStopped");
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.VoiceRecordingEventListener
    public void onRecordCancel(@NotNull SpenVoiceData voiceData) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        if (this.mVoiceModel.hasVoiceData(voiceData)) {
            this.mVoiceModel.setVoiceState(VoiceState.CANCEL);
            errorRecording(voiceData);
            this.mVoiceListPresenter.saveCache(false);
        } else {
            updateVoiceView();
        }
        updateMediaSession("onRecordCancel");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.VoiceRecordingEventListener
    public void onRecordError(@NotNull SpenVoiceData voiceData, int i) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        if (this.mVoiceModel.hasCurrentVoiceData(voiceData)) {
            this.mVoiceModel.setVoiceState(VoiceState.ERROR);
            errorRecording(voiceData);
        }
        if (FeatureInfo.isSupportSTTFunction()) {
            AbstractC8014b.m7220v("onRecordError# isSupportSTTFunction# ", TAG, FeatureInfo.isSupportSTTFunction());
            STTPresenterImpl sTTPresenterImpl = this.mSttPresenter;
            if (sTTPresenterImpl != null) {
                sTTPresenterImpl.onRecordStop(voiceData);
            }
        }
        updateMediaSession("onRecordError");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.VoiceRecordingEventListener
    public void onRecordPause(@NotNull SpenVoiceData voiceData) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        if (this.mVoiceModel.hasCurrentVoiceData(voiceData)) {
            this.mVoiceModel.setVoiceState(VoiceState.RECORD_PAUSE);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.VoiceRecordingEventListener
    public void onRecordPlayComplete(@NotNull SpenVoiceData voiceData) {
        STTPresenterImpl sTTPresenterImpl;
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        if (this.mVoiceModel.hasCurrentVoiceData(voiceData)) {
            if (this.mVoiceModel.isLastVoiceData(voiceData)) {
                this.mVoiceModel.setStopData();
                this.mVoiceListPresenter.recordPlayStop();
                VoiceRecordListPresenter voiceRecordListPresenter = this.mVoiceListPresenter;
                String name = voiceData.getName();
                Intrinsics.checkNotNull(name);
                voiceRecordListPresenter.updatePlayingItemByName(name);
                if (this.mVoiceModel.getMEraserState() == EraserState.ERASING) {
                    this.mVoiceSubPresenter.onAudioEraserInitCompleted();
                } else {
                    this.mVoiceSubPresenter.updateAudioEraserAnimation(false);
                }
            }
            if (FeatureInfo.isSupportSTTFunction() && (sTTPresenterImpl = this.mSttPresenter) != null) {
                sTTPresenterImpl.updateSTTReplayComplete(voiceData);
            }
            this.mPlayingVoice = false;
        }
        updateMediaSession("onRecordPlayComplete");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.VoiceRecordingEventListener
    public void onRecordPlayError(@NotNull SpenVoiceData voiceData, int errorCode) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        if (this.mVoiceModel.hasCurrentVoiceData(voiceData)) {
            this.mVoiceModel.setVoiceState(VoiceState.ERROR);
        }
        if (voiceData.getAttachedFile() == null) {
            Logger.m11004w(TAG, "VoiceData has no file path. errorCode = " + errorCode);
            errorRecording(voiceData);
        }
        this.mPlayingVoice = false;
        updateMediaSession("onRecordPlayError");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.VoiceRecordingEventListener
    public void onRecordPlayInfo(@NotNull SpenVoiceData voiceData, int mediaInfo) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        if (this.mVoiceModel.hasCurrentVoiceData(voiceData) && mediaInfo == 10982) {
            this.mVoiceSubPresenter.onAudioEraserInitCompleted();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.VoiceRecordingEventListener
    public void onRecordPlayPause(@NotNull SpenVoiceData voiceData) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        if (this.mVoiceModel.hasCurrentVoiceData(voiceData)) {
            this.mVoiceModel.setVoiceState(VoiceState.PLAY_PAUSE);
            if (this.mInitPlayAudioEraser && this.mVoiceModel.getMEraserState() == EraserState.ERASING) {
                this.mVoiceModel.setVoiceState(this.mVoiceStateAfterInit);
                this.mInitPlayAudioEraser = false;
            } else {
                this.mVoiceListPresenter.setPlayPauseView(false);
                this.mVoiceSubPresenter.updateAudioEraserAnimation(false);
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.VoiceRecordingEventListener
    public void onRecordPlayPrepared(@NotNull SpenVoiceData voiceData, int duration) {
        STTPresenterImpl sTTPresenterImpl;
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        if (!FeatureInfo.isSupportSTTFunction() || (sTTPresenterImpl = this.mSttPresenter) == null) {
            return;
        }
        sTTPresenterImpl.updateSTTReplay(voiceData, 0);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.VoiceRecordingEventListener
    public void onRecordPlayResume(@NotNull SpenVoiceData voiceData) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        if (this.mVoiceModel.hasCurrentVoiceData(voiceData)) {
            VoiceState voiceState = this.mVoiceModel.getVoiceState();
            this.mVoiceModel.setVoiceState(VoiceState.PLAY_RESUMED);
            if (this.mInitPlayAudioEraser && this.mVoiceModel.getMEraserState() == EraserState.ERASING) {
                this.mVoiceStateAfterInit = voiceState;
                this.mVoiceModel.pause();
            } else {
                this.mVoiceListPresenter.updateVoiceSyncPlayOption();
                this.mVoiceListPresenter.setPlayPauseView(true);
                this.mVoiceSubPresenter.updateAudioEraserAnimation(true);
                startVoiceService();
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.VoiceRecordingEventListener
    public void onRecordPlayStart(@NotNull SpenVoiceData voiceData) {
        STTPresenterImpl sTTPresenterImpl;
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        if (this.mVoiceModel.hasVoiceData(voiceData)) {
            if (this.mInitPlayAudioEraser && this.mVoiceModel.getMEraserState() == EraserState.ERASING && !this.mVoiceModel.isPlayingVoiceData()) {
                this.mVoiceStateAfterInit = this.mVoiceModel.getVoiceState();
                this.mVoiceModel.setPlayData(null, voiceData);
                this.mVoiceModel.pause();
                return;
            }
            if (!this.mVoiceModel.isPlayingVoiceDataState()) {
                if (this.mVoiceModel.getVoiceState() != VoiceState.PLAY_RESUMED) {
                    if (this.mComposerModel.getComposerState().isInAppCollaborationMode()) {
                        InAppLogger.m8595d(TAG, "onRecordPlayStart# Do not set ReadOnly in InAppCollaboration");
                    } else {
                        if (this.mComposerModel.getComposerState().isLaserPenMode()) {
                            this.mComposerModel.getComposerState().setLaserPenMode(false);
                        }
                        this.mComposerModel.getModeManager().setMode(Mode.ReadOnly, "onRecordPlayStart", true);
                        this.mMenuManager.invalidateOptionsMenu();
                    }
                }
                if (this.mVoiceModel.getVoiceData() == null) {
                    this.mVoiceListPresenter.updateVoiceSyncPlayOption();
                }
            }
            this.mVoiceModel.setPlayData(null, voiceData);
            this.mVoiceListPresenter.setPlayPauseView(true);
            VoiceRecordListPresenter voiceRecordListPresenter = this.mVoiceListPresenter;
            String name = voiceData.getName();
            Intrinsics.checkNotNull(name);
            voiceRecordListPresenter.updatePlayingItemByName(name);
            this.mVoiceSubPresenter.updateAudioEraserAnimation(true);
            this.mPlayingVoice = false;
            if (FeatureInfo.isSupportSTTFunction() && (sTTPresenterImpl = this.mSttPresenter) != null) {
                sTTPresenterImpl.updateSTTReplayStart(voiceData);
            }
            startVoiceService();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.VoiceRecordingEventListener
    public void onRecordPlayStop(@NotNull SpenVoiceData voiceData) {
        STTPresenterImpl sTTPresenterImpl;
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        if (this.mVoiceModel.hasCurrentVoiceData(voiceData)) {
            if (!this.mPlayingVoice) {
                this.mVoiceListPresenter.recordPlayStop();
                if (FeatureInfo.isSupportSTTFunction() && (sTTPresenterImpl = this.mSttPresenter) != null) {
                    sTTPresenterImpl.updateSTTReplayStop(voiceData);
                }
                this.mVoiceModel.setStopData();
            }
            this.mPlayingVoice = false;
            this.mVoiceSubPresenter.updateAudioEraserAnimation(false);
        }
        updateMediaSession("onRecordPlayStop");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.VoiceRecordingEventListener
    public void onRecordResume(@NotNull SpenVoiceData voiceData) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        if (this.mVoiceModel.hasCurrentVoiceData(voiceData)) {
            this.mVoiceModel.setVoiceState(VoiceState.RECORD_RESUMED);
            startVoiceService();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.VoiceRecordingEventListener
    public void onRecordStart(@NotNull SpenVoiceData voiceData, @NotNull String cachePath) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        Intrinsics.checkNotNullParameter(cachePath, "cachePath");
        AbstractC8014b.m7220v("onRecordStart. ", TAG, this.mVoiceModel.hasVoiceData(voiceData));
        if (this.mVoiceModel.hasVoiceData(voiceData)) {
            this.mVoiceModel.setRecordData(voiceData);
            VoiceModel voiceModel = this.mVoiceModel;
            voiceModel.setRecordingTime(voiceModel.getAllRecordTime() / 1000);
            this.mVoiceListPresenter.setRecordingTime();
            this.mVoiceListPresenter.showRecordingView();
            startVoiceService();
            this.mVoiceSubPresenter.clearErasingState();
            EarphoneButtonManager.INSTANCE.getInstance().releaseMediaSession();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.VoiceRecordingEventListener
    public void onRecordStop(@NotNull SpenVoiceData voiceData) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        this.mRecordingEventAction.onRecordStop(voiceData);
        if (FeatureInfo.isSupportSTTFunction()) {
            AbstractC8014b.m7220v("onRecordStop# isSupportSTTFunction# ", TAG, FeatureInfo.isSupportSTTFunction());
            STTPresenterImpl sTTPresenterImpl = this.mSttPresenter;
            if (sTTPresenterImpl != null) {
                sTTPresenterImpl.onRecordStop(voiceData);
            }
        }
        ComposerSA.insertLog("815", STTConstant.EVENT_RECORDING_TIME, String.valueOf(voiceData.getRecordingTime() / ((long) 1000)));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.VoiceRecordingEventListener
    public void onUpdateRecordPlayTime(@NotNull SpenVoiceData voiceData, int position) {
        STTPresenterImpl sTTPresenterImpl;
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        if (this.mVoiceModel.hasCurrentVoiceData(voiceData)) {
            this.mVoiceModel.setRecordPlayingInfo(this.mVoiceModel.getVoiceDataIndex(voiceData), position);
            if (this.mVoiceModel.isPlayingState()) {
                this.mVoiceModel.setVoiceState(VoiceState.PLAY_PROGRESS);
            }
            this.mVoiceListPresenter.setUpdateRecordPlayTime(voiceData, position);
            if (!FeatureInfo.isSupportSTTFunction() || (sTTPresenterImpl = this.mSttPresenter) == null) {
                return;
            }
            sTTPresenterImpl.updateSTTReplay(voiceData, position);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.VoiceRecordingEventListener
    public void onUpdateRecordTime(@NotNull SpenVoiceData voiceData, int time) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        this.mRecordingEventAction.onUpdateRecordTime(voiceData, time);
        startVoiceService();
    }

    public final void setCoedit(boolean isCoedit, @NotNull ComposerViewPresenter composerPresenter) {
        Intrinsics.checkNotNullParameter(composerPresenter, "composerPresenter");
        this.mRecordingEventAction = isCoedit ? new CoeditRecordingEventAction(this, composerPresenter) : new RecordingEventAction();
    }

    public final void setPlayingAudio(boolean playing) {
        this.mPlayingAudio = playing;
    }

    public final void setPlayingVoice(boolean playing) {
        this.mPlayingVoice = playing;
    }

    public final void updateMediaSession(@NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Activity activity = this.mActivity;
        if (activity != null) {
            activity.runOnUiThread(new RunnableC9844c(this, tag, 6));
        }
    }
}
