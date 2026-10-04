package com.samsung.android.sdk.composer.video;

import android.graphics.RectF;
import android.util.Log;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.document.SpenObjectVideo;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0019H\u0007J\u0012\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0007J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u000fH\u0007J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0018\u0010 \u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u0007H\u0007J\b\u0010$\u001a\u00020\u0019H\u0002J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010&\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010'\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010(\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0011\u0010,\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0082 J\u0019\u0010-\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u0007H\u0082 J\t\u0010.\u001a\u00020\u0019H\u0082 J\t\u0010/\u001a\u00020\u001fH\u0082 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0003\u001a\u0004\b\"\u0010#¨\u00060"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/video/VideoManager;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "STATE_IDLE", "", "STATE_PLAY", "STATE_PAUSE", "STATE_RESUME", "STATE_STOP", "STATE_MAX", "mListenerList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/composer/video/SpenVideoListener;", "Lkotlin/collections/ArrayList;", "mIsAddCallbackListener", "", "value", "state", "getState", "()I", "mSync", "initialize", "", "addListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeListener", "setObject", "objectVideo", "Lcom/samsung/android/sdk/pen/document/SpenObjectVideo;", "setState", "getObjectVideo$annotations", "getObjectVideo", "()Lcom/samsung/android/sdk/pen/document/SpenObjectVideo;", "addCallbackListener", "onPaused", "onResumed", "onStopped", "onPositionUpdated", "position", "Landroid/graphics/RectF;", "onPlayClicked", "Native_SetObject", "Native_SetState", "Native_SetStateListener", "Native_GetObjectVideo", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class VideoManager {
    public static final int STATE_IDLE = 0;
    public static final int STATE_MAX = 5;
    public static final int STATE_PAUSE = 2;
    public static final int STATE_PLAY = 1;
    public static final int STATE_RESUME = 3;
    public static final int STATE_STOP = 4;

    @NotNull
    private static final String TAG = "VideoManager";
    private static boolean mIsAddCallbackListener;
    private static int state;

    @NotNull
    public static final VideoManager INSTANCE = new VideoManager();

    @NotNull
    private static final ArrayList<SpenVideoListener> mListenerList = new ArrayList<>();

    @NotNull
    private static final Object mSync = new Object();

    private VideoManager() {
    }

    private final native SpenObjectVideo Native_GetObjectVideo();

    private final native void Native_SetObject(SpenObjectVideo objectVideo);

    private final native void Native_SetState(SpenObjectVideo objectVideo, int state2);

    private final native void Native_SetStateListener();

    private final void addCallbackListener() {
        synchronized (mSync) {
            try {
                if (!mIsAddCallbackListener) {
                    INSTANCE.Native_SetStateListener();
                    mIsAddCallbackListener = true;
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @JvmStatic
    public static final void addListener(@Nullable SpenVideoListener listener) {
        if (listener == null) {
            Log.d(TAG, "[addListener] got empty observer");
            return;
        }
        synchronized (mSync) {
            try {
                ArrayList<SpenVideoListener> arrayList = mListenerList;
                if (arrayList.indexOf(listener) < 0) {
                    arrayList.add(listener);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NotNull
    public static final SpenObjectVideo getObjectVideo() {
        return INSTANCE.Native_GetObjectVideo();
    }

    @JvmStatic
    public static /* synthetic */ void getObjectVideo$annotations() {
    }

    @JvmStatic
    public static final void initialize() {
        INSTANCE.addCallbackListener();
    }

    private final void onPaused(SpenObjectVideo objectVideo) {
        synchronized (mSync) {
            try {
                Iterator<SpenVideoListener> it = mListenerList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    SpenVideoListener next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    next.onPaused(objectVideo);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void onPlayClicked(SpenObjectVideo objectVideo) {
        synchronized (mSync) {
            try {
                Iterator<SpenVideoListener> it = mListenerList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    SpenVideoListener next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    next.onPlayClicked(objectVideo);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void onPositionUpdated(SpenObjectVideo objectVideo, RectF position) {
        synchronized (mSync) {
            try {
                Iterator<SpenVideoListener> it = mListenerList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    SpenVideoListener next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    next.onPositionUpdated(objectVideo, position);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void onResumed(SpenObjectVideo objectVideo) {
        synchronized (mSync) {
            try {
                Iterator<SpenVideoListener> it = mListenerList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    SpenVideoListener next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    next.onResumed(objectVideo);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void onStopped(SpenObjectVideo objectVideo) {
        synchronized (mSync) {
            try {
                Iterator<SpenVideoListener> it = mListenerList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    SpenVideoListener next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    next.onStopped(objectVideo);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @JvmStatic
    public static final void removeListener(@NotNull SpenVideoListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (mSync) {
            mListenerList.remove(listener);
        }
    }

    @JvmStatic
    public static final void setObject(@NotNull SpenObjectVideo objectVideo) {
        Intrinsics.checkNotNullParameter(objectVideo, "objectVideo");
        VideoManager videoManager = INSTANCE;
        videoManager.addCallbackListener();
        synchronized (mSync) {
            videoManager.Native_SetObject(objectVideo);
            Unit unit = Unit.INSTANCE;
        }
    }

    @JvmStatic
    public static final void setState(@NotNull SpenObjectVideo objectVideo, int state2) {
        Intrinsics.checkNotNullParameter(objectVideo, "objectVideo");
        if (state2 >= 0 || state2 < 5) {
            state = state2;
            INSTANCE.Native_SetState(objectVideo, state2);
        }
    }

    public final int getState() {
        return state;
    }
}
