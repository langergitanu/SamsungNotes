package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import android.content.Context;
import android.content.IntentFilter;
import com.samsung.android.sdk.composer.voice.VoiceManager;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.BroadcastCompat;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerImplContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u0011R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/listener/VoiceRecordingListenerManager;", "", "presenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/listener/ListenerImplContract$IPresenter;", "dialogManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/listener/ListenerImplContract$IDialogPresenter;", "cManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/ControllerManager;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/listener/ListenerImplContract$IPresenter;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/listener/ListenerImplContract$IDialogPresenter;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/ControllerManager;)V", "mContext", "Landroid/content/Context;", "mStopVoiceRecordingActionReceiver", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/listener/StopVoiceRecordingActionReceiver;", "mVoiceOnStateChangedListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/listener/VoiceOnStateChangedListener;", "release", "", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VoiceRecordingListenerManager {

    @NotNull
    private static final String TAG;

    @Nullable
    private Context mContext;

    @Nullable
    private StopVoiceRecordingActionReceiver mStopVoiceRecordingActionReceiver;

    @Nullable
    private VoiceOnStateChangedListener mVoiceOnStateChangedListener;

    static {
        String strCreateTag = Logger.createTag("VoiceRecordingListenerManager");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    public VoiceRecordingListenerManager(@NotNull ListenerImplContract.IPresenter presenter, @Nullable ListenerImplContract.IDialogPresenter iDialogPresenter, @Nullable ControllerManager controllerManager) {
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        this.mContext = presenter.getActivity();
        Intrinsics.checkNotNull(iDialogPresenter);
        Intrinsics.checkNotNull(controllerManager);
        VoiceOnStateChangedListener voiceOnStateChangedListener = new VoiceOnStateChangedListener(presenter, iDialogPresenter, controllerManager);
        this.mVoiceOnStateChangedListener = voiceOnStateChangedListener;
        VoiceManager voiceManager = VoiceManager.INSTANCE;
        Intrinsics.checkNotNull(voiceOnStateChangedListener);
        voiceManager.setStateListener(voiceOnStateChangedListener);
        VoiceManager.setToastActionListener(new VoiceRecordingToastActionListenerImpl());
        this.mStopVoiceRecordingActionReceiver = new StopVoiceRecordingActionReceiver();
        try {
            BroadcastCompat.Companion companion = BroadcastCompat.INSTANCE;
            Context context = this.mContext;
            Intrinsics.checkNotNull(context);
            companion.registerReceiver(context, this.mStopVoiceRecordingActionReceiver, new IntentFilter(StopVoiceRecordingActionReceiver.ACTION_VOICERECORDER_SAVE), 2);
            Context context2 = this.mContext;
            Intrinsics.checkNotNull(context2);
            companion.registerReceiver(context2, this.mStopVoiceRecordingActionReceiver, new IntentFilter(StopVoiceRecordingActionReceiver.ACTION_VOICENOTE_SAVE), 2);
            Context context3 = this.mContext;
            Intrinsics.checkNotNull(context3);
            companion.registerReceiver(context3, this.mStopVoiceRecordingActionReceiver, new IntentFilter(StopVoiceRecordingActionReceiver.ACTION_SHUTDOWN), 4);
            Context context4 = this.mContext;
            Intrinsics.checkNotNull(context4);
            companion.registerReceiver(context4, this.mStopVoiceRecordingActionReceiver, new IntentFilter(StopVoiceRecordingActionReceiver.ACTION_POWEROFF), 4);
        } catch (Exception e) {
            Logger.m11001e(TAG, e.getMessage(), e);
        }
    }

    public final void release() {
        VoiceOnStateChangedListener voiceOnStateChangedListener = this.mVoiceOnStateChangedListener;
        if (voiceOnStateChangedListener != null) {
            VoiceManager.INSTANCE.removeStateListener(voiceOnStateChangedListener);
            this.mVoiceOnStateChangedListener = null;
        }
        if (this.mStopVoiceRecordingActionReceiver != null) {
            try {
                Context context = this.mContext;
                Intrinsics.checkNotNull(context);
                context.unregisterReceiver(this.mStopVoiceRecordingActionReceiver);
                this.mStopVoiceRecordingActionReceiver = null;
            } catch (IllegalArgumentException e) {
                Logger.m11004w(TAG, e.getMessage());
            } catch (Exception e2) {
                Logger.m11001e(TAG, e2.getMessage(), e2);
            }
        }
        this.mContext = null;
    }
}
