package com.samsung.android.sdk.pen.objectruntime.preload;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.widget.glance.single.setting.view.ViewOnTouchListenerC7004e;
import com.samsung.android.sdk.pen.Spen;
import com.samsung.android.sdk.pen.objectruntime.preload.VideoIntentFragment;
import com.samsung.android.sdk.pen.objectruntime.preload.WrapperVideoView;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenObjectRuntimeInterface;
import com.samsung.android.sdk.pen.util.SpenScreenCodecDecoder;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 h2\u00020\u0001:\u0001hB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0016J:\u00101\u001a\u00020.2\u0006\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u00020\u00172\b\u00104\u001a\u0004\u0018\u00010\u00192\u0006\u00105\u001a\u00020\u001b2\u0006\u00106\u001a\u00020\u00192\u0006\u00107\u001a\u00020$H\u0016J\u0010\u00108\u001a\u00020.2\u0006\u00109\u001a\u00020:H\u0016J\u0012\u0010;\u001a\u00020.2\b\u0010<\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010=\u001a\u00020:2\b\u0010>\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010?\u001a\u00020.2\u0006\u0010@\u001a\u00020AH\u0016J\b\u0010B\u001a\u00020.H\u0016J\u0010\u0010C\u001a\u00020.2\u0006\u0010@\u001a\u00020AH\u0016J\b\u0010D\u001a\u00020EH\u0016J\u0010\u0010F\u001a\u00020.2\u0006\u0010G\u001a\u00020HH\u0016J\u0010\u0010I\u001a\u00020:2\u0006\u0010J\u001a\u00020\u001eH\u0016J\n\u0010K\u001a\u0004\u0018\u00010\u001eH\u0016JG\u0010P\u001a\u0004\u0018\u00010\u00152\u0006\u0010Q\u001a\u00020\u00152\u0006\u0010R\u001a\u00020\u001e2\u0012\u0010S\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010U0T2\u0012\u0010V\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150T\"\u00020\u0015H\u0002¢\u0006\u0002\u0010WJ \u0010X\u001a\u00020\u00172\u0006\u0010Y\u001a\u00020M2\u0006\u0010Z\u001a\u00020M2\u0006\u0010[\u001a\u00020\u0017H\u0002J\b\u0010\\\u001a\u00020:H\u0003J\u001a\u0010]\u001a\u0004\u0018\u00010^2\u0006\u0010_\u001a\u00020^2\u0006\u0010`\u001a\u00020\u0017H\u0003J\u0012\u0010a\u001a\u00020\u00172\b\u00103\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u00109\u001a\u00020.2\u0006\u0010b\u001a\u00020MH\u0002J\b\u0010c\u001a\u00020.H\u0002J\b\u0010d\u001a\u00020.H\u0002J\u0018\u0010e\u001a\u00020M2\u0006\u0010f\u001a\u00020\u001b2\u0006\u0010g\u001a\u00020\u001bH\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010L\u001a\u00020M8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bN\u0010O¨\u0006i"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/objectruntime/preload/Video;", "Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenObjectRuntimeInterface;", "<init>", "()V", "mAudioManager", "Landroid/media/AudioManager;", "getMAudioManager", "()Landroid/media/AudioManager;", "setMAudioManager", "(Landroid/media/AudioManager;)V", "mAudioLisner", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "getMAudioLisner", "()Landroid/media/AudioManager$OnAudioFocusChangeListener;", "setMAudioLisner", "(Landroid/media/AudioManager$OnAudioFocusChangeListener;)V", "mActivity", "Landroid/app/Activity;", "fm", "Landroid/app/FragmentManager;", "mObject", "", "mRect", "Landroid/graphics/RectF;", "mPan", "Landroid/graphics/PointF;", "mRatio", "", "mStartFramePosition", "mVideoFilePath", "", "mVideoView", "Lcom/samsung/android/sdk/pen/objectruntime/preload/WrapperVideoView;", "mVideoViewListener", "Lcom/samsung/android/sdk/pen/objectruntime/preload/WrapperVideoView$WrapperVideoViewListener;", "mViewGroup", "Landroid/view/ViewGroup;", "mVideoViewLayoutParams", "Landroid/widget/RelativeLayout$LayoutParams;", "mListener", "Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenObjectRuntimeInterface$UpdateListener;", "mFragment", "Lcom/samsung/android/sdk/pen/objectruntime/preload/VideoIntentFragment;", "mFragmentListener", "Lcom/samsung/android/sdk/pen/objectruntime/preload/VideoIntentFragment$OnVideoIntentFragmentListener;", "onLoad", "", "context", "Landroid/content/Context;", "start", "objectBase", "relativeRect", "pan", "zoomRatio", "frameStartPosition", DBSchema.DocumentThumbnail.LAYOUT, "stop", "cancel", "", Video.SETRECT_FUNCTION, "rect", "setListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getProperty", "propertyMap", "Landroid/os/Bundle;", "onUnload", "setProperty", "getNativeHandle", "", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "unlock", "key", "getPrivateKeyHint", "type", "", "getType", "()I", "mInvoke", "instance", "runner", "clazz", "", "Ljava/lang/Class;", "args", "(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;", "getRatioRect", "w", "h", "outNoneRatioRect", "startVideoPlay", "createPlayVideoBitmap", "Landroid/graphics/Bitmap;", "srcBitmap", "noneRatioRect", "convertAbsolute", "action", "complete", "cleanResource", "getIntValueAppliedDensity", "paramFloat", "density", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"UseSparseArrays"})
@SourceDebugExtension({"SMAP\nVideo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Video.kt\ncom/samsung/android/sdk/pen/objectruntime/preload/Video\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,665:1\n1#2:666\n*E\n"})
public final class Video implements SpenObjectRuntimeInterface {

    @NotNull
    private static final String EXTRADATASTRING_VIDEOPATH_KEY = "VideoPath";

    @NotNull
    private static final String GETEXTRADATASTRING_FUNCTION = "getExtraDataString";

    @NotNull
    private static final Class<?>[] GETEXTRADATASTRING_FUNCTION_ARG_SIGNATURE;
    private static final int HASH_KEY_IMAGE_MARGIN = 1;
    private static final int HASH_KEY_IMAGE_SIZE = 0;
    private static final int HASH_KEY_PIXEL_1080_1920 = 3000;
    private static final int HASH_KEY_PIXEL_2560_1600 = 4160;
    private static final int HASH_KEY_PIXEL_720_1280 = 2000;
    private static final int HASH_KEY_PIXEL_DEFAULT = 3000;
    private static final int KK_VERSION_CODE = 19;

    @NotNull
    private static final String SETEXTRADATASTRING_FUNCTION = "setExtraDataString";

    @NotNull
    private static final Class<?>[] SETEXTRADATASTRING_FUNCTION_ARG_SIGNATURE;

    @NotNull
    private static final String SETIMAGE_FUNCTION = "setImage";

    @NotNull
    private static final String SETRECT_FUNCTION = "setRect";

    @NotNull
    private static final Class<? extends Object>[] SETRECT_FUNCTION_ARG_SIGNATURE;

    @NotNull
    private static final String SETRESIZEOPTION_FUNCTION = "setResizeOption";

    @NotNull
    private static final Class<?>[] SETRESIZEOPTION_FUNCTION_ARG_SIGNATURE;

    @NotNull
    private static final String SETROTATABLE_FUNCTION = "setRotatable";

    @NotNull
    private static final Class<?>[] SETROTATABLE_FUNCTION_ARG_SIGNATURE;

    @NotNull
    private static final String SETVISIBILITY_FUNCTION = "setVisibility";

    @NotNull
    private static final Class<?>[] SETVISIBILITY_FUNCTION_ARG_SIGNATURE;

    @NotNull
    private static final String SETWFDTCPDISABLE_FUNCTION = "setWFDTcpDisable";

    @NotNull
    private static final Class<?>[] SETWFDTCPDISABLE_FUNCTION_ARG_SIGNATURE;

    @NotNull
    private static final String TAG = "Video";

    @NotNull
    private static final String VIDEOPLAY_IMAGE_NAME = "snote_insert_video_icon_cue";

    @NotNull
    private static final HashMap<Integer, HashMap<Integer, Rect>> VIDEOPLAY_IMAGE_UX_TABLE;

    @Nullable
    private FragmentManager fm;

    @Nullable
    private Activity mActivity;

    @Nullable
    private AudioManager.OnAudioFocusChangeListener mAudioLisner;

    @Nullable
    private AudioManager mAudioManager;

    @Nullable
    private VideoIntentFragment mFragment;

    @Nullable
    private VideoIntentFragment.OnVideoIntentFragmentListener mFragmentListener;

    @Nullable
    private SpenObjectRuntimeInterface.UpdateListener mListener;

    @Nullable
    private Object mObject;

    @Nullable
    private PointF mPan;
    private float mRatio;

    @Nullable
    private RectF mRect;

    @Nullable
    private PointF mStartFramePosition;

    @Nullable
    private String mVideoFilePath;

    @Nullable
    private WrapperVideoView mVideoView;

    @Nullable
    private RelativeLayout.LayoutParams mVideoViewLayoutParams;

    @Nullable
    private WrapperVideoView.WrapperVideoViewListener mVideoViewListener;

    @Nullable
    private ViewGroup mViewGroup;
    private static final int mSdkVersion = Build.VERSION.SDK_INT;

    @NotNull
    private static final Class<?>[] SETIMAGE_FUNCTION_ARG_SIGNATURE = {Bitmap.class};

    static {
        Class cls = Boolean.TYPE;
        SETRECT_FUNCTION_ARG_SIGNATURE = new Class[]{RectF.class, cls};
        GETEXTRADATASTRING_FUNCTION_ARG_SIGNATURE = new Class[]{String.class};
        SETEXTRADATASTRING_FUNCTION_ARG_SIGNATURE = new Class[]{String.class, String.class};
        SETROTATABLE_FUNCTION_ARG_SIGNATURE = new Class[]{cls};
        SETVISIBILITY_FUNCTION_ARG_SIGNATURE = new Class[]{cls};
        SETRESIZEOPTION_FUNCTION_ARG_SIGNATURE = new Class[]{Integer.TYPE};
        SETWFDTCPDISABLE_FUNCTION_ARG_SIGNATURE = new Class[]{cls};
        HashMap<Integer, HashMap<Integer, Rect>> map = new HashMap<>();
        VIDEOPLAY_IMAGE_UX_TABLE = map;
        Rect rect = new Rect(0, 0, 22, 22);
        Rect rect2 = new Rect(0, 7, 7, 0);
        HashMap<Integer, Rect> map2 = new HashMap<>();
        map2.put(0, rect);
        map2.put(1, rect2);
        map.put(3000, map2);
        Rect rect3 = new Rect(0, 0, 33, 33);
        Rect rect4 = new Rect(0, 10, 10, 0);
        HashMap<Integer, Rect> map3 = new HashMap<>();
        map3.put(0, rect3);
        map3.put(1, rect4);
        map.put(Integer.valueOf(HASH_KEY_PIXEL_2560_1600), map3);
        Rect rect5 = new Rect(0, 0, 22, 22);
        Rect rect6 = new Rect(0, 7, 7, 0);
        HashMap<Integer, Rect> map4 = new HashMap<>();
        map4.put(0, rect5);
        map4.put(1, rect6);
        map.put(2000, map4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancel(int action) {
        SpenObjectRuntimeInterface.UpdateListener updateListener;
        cleanResource();
        Object obj = this.mObject;
        if (obj == null || (updateListener = this.mListener) == null) {
            return;
        }
        updateListener.onCanceled(action, obj);
    }

    private final void cleanResource() {
        FragmentTransaction fragmentTransactionBeginTransaction;
        FragmentTransaction fragmentTransactionRemove;
        Object[] objArr = {Boolean.TRUE};
        Object obj = this.mObject;
        if (obj != null) {
            mInvoke(obj, SETVISIBILITY_FUNCTION, SETVISIBILITY_FUNCTION_ARG_SIGNATURE, objArr);
            SpenObjectRuntimeInterface.UpdateListener updateListener = this.mListener;
            if (updateListener != null) {
                updateListener.onObjectUpdated(this.mRect, obj);
            }
        }
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(this.mAudioLisner);
        }
        ViewGroup viewGroup = this.mViewGroup;
        if (viewGroup != null) {
            viewGroup.removeView(this.mVideoView);
        }
        this.mVideoView = null;
        VideoIntentFragment videoIntentFragment = this.mFragment;
        if (videoIntentFragment != null) {
            videoIntentFragment.setVideoIntentFragmentListener(null);
            FragmentManager fragmentManager = this.fm;
            if ((fragmentManager != null ? fragmentManager.findFragmentById(videoIntentFragment.getId()) : null) != null) {
                try {
                    FragmentManager fragmentManager2 = this.fm;
                    if (fragmentManager2 != null && (fragmentTransactionBeginTransaction = fragmentManager2.beginTransaction()) != null && (fragmentTransactionRemove = fragmentTransactionBeginTransaction.remove(videoIntentFragment)) != null) {
                        fragmentTransactionRemove.commitAllowingStateLoss();
                    }
                } catch (IllegalStateException unused) {
                    Log.v(TAG, "commitAllowingStateLoss IllegalStateException is occurred. but is not problem.");
                }
            }
        }
        this.mFragment = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void complete() {
        SpenObjectRuntimeInterface.UpdateListener updateListener;
        cleanResource();
        Object obj = this.mObject;
        if (obj == null || (updateListener = this.mListener) == null) {
            return;
        }
        updateListener.onCompleted(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RectF convertAbsolute(RectF relativeRect) {
        PointF pointF;
        PointF pointF2;
        RectF rectF = new RectF();
        if (relativeRect != null && (pointF = this.mStartFramePosition) != null && (pointF2 = this.mPan) != null) {
            float f = relativeRect.left;
            float f4 = pointF.x;
            float f5 = this.mRatio;
            float f6 = pointF2.x;
            rectF.left = ((f - f4) / f5) + f6;
            rectF.right = AbstractC0622a.m1155a(relativeRect.right, f4, f5, f6);
            float f7 = relativeRect.top;
            float f8 = pointF.y;
            float f9 = pointF2.y;
            rectF.top = ((f7 - f8) / f5) + f9;
            rectF.bottom = AbstractC0622a.m1155a(relativeRect.bottom, f8, f5, f9);
        }
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"DiscouragedApi"})
    public final Bitmap createPlayVideoBitmap(Bitmap srcBitmap, RectF noneRatioRect) {
        Activity activity = this.mActivity;
        PackageManager packageManager = activity != null ? activity.getPackageManager() : null;
        if (packageManager == null) {
            Log.v(TAG, "PackageManager is null.");
            return null;
        }
        try {
            Spen.Companion companion = Spen.INSTANCE;
            Resources resourcesForApplication = packageManager.getResourcesForApplication(companion.getSpenPackageName());
            DisplayMetrics displayMetrics = resourcesForApplication.getDisplayMetrics();
            if (displayMetrics == null) {
                Log.v(TAG, "DisplayMetrics Get is failed");
                return null;
            }
            int identifier = resourcesForApplication.getIdentifier(VIDEOPLAY_IMAGE_NAME, "drawable", companion.getSpenPackageName());
            if (identifier == 0) {
                Log.v(TAG, "Resource is not founded");
                return null;
            }
            try {
                Bitmap bitmapDecodeStream = SpenScreenCodecDecoder.decodeStream(resourcesForApplication.openRawResource(identifier));
                if (bitmapDecodeStream == null) {
                    Log.v(TAG, "The bitmap of resource is null.");
                    return null;
                }
                try {
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) noneRatioRect.width(), (int) noneRatioRect.height(), Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(bitmapCreateBitmap);
                    Rect rect = new Rect();
                    rect.set(0, 0, srcBitmap.getWidth(), srcBitmap.getHeight());
                    Rect rect2 = new Rect();
                    rect2.set(0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight());
                    Paint paint = new Paint(7);
                    canvas.drawBitmap(srcBitmap, rect, rect2, paint);
                    rect.set(0, 0, bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight());
                    int i = displayMetrics.widthPixels + displayMetrics.heightPixels;
                    HashMap<Integer, HashMap<Integer, Rect>> map = VIDEOPLAY_IMAGE_UX_TABLE;
                    if (!map.containsKey(Integer.valueOf(i))) {
                        i = 3000;
                    }
                    HashMap<Integer, Rect> map2 = map.get(Integer.valueOf(i));
                    Rect rect3 = map2 != null ? map2.get(1) : null;
                    HashMap<Integer, Rect> map3 = map.get(Integer.valueOf(i));
                    Rect rect4 = map3 != null ? map3.get(0) : null;
                    if (rect3 != null && rect4 != null) {
                        rect2.left = (bitmapCreateBitmap.getWidth() - getIntValueAppliedDensity(rect4.width(), displayMetrics.density)) - getIntValueAppliedDensity(rect3.right, displayMetrics.density);
                        rect2.top = getIntValueAppliedDensity(rect3.top, displayMetrics.density);
                        rect2.right = rect2.left + getIntValueAppliedDensity(rect4.width(), displayMetrics.density);
                        rect2.bottom = rect2.top + getIntValueAppliedDensity(rect4.height(), displayMetrics.density);
                    }
                    canvas.drawBitmap(bitmapDecodeStream, rect, rect2, paint);
                    bitmapDecodeStream.recycle();
                    return bitmapCreateBitmap;
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                    Log.e(TAG, "Failed to create bitmap " + Unit.INSTANCE);
                    bitmapDecodeStream.recycle();
                    return null;
                }
            } catch (Resources.NotFoundException e2) {
                e2.printStackTrace();
                return null;
            }
        } catch (PackageManager.NameNotFoundException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    private final int getIntValueAppliedDensity(float paramFloat, float density) {
        return Math.round(paramFloat * density);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RectF getRatioRect(int w, int h, RectF outNoneRatioRect) {
        float f;
        float f4;
        float fHeight;
        float fHeight2;
        float f5 = w / h;
        RectF rectF = this.mRect;
        if (rectF == null) {
            f = 0.0f;
            f4 = 0.0f;
        } else if (rectF.width() < rectF.height()) {
            if (w > h) {
                fHeight2 = rectF.width();
                f = fHeight2 * 0.6666667f;
                f4 = f / f5;
            } else {
                fHeight = rectF.width();
                f4 = fHeight * 0.6666667f;
                f = f4 * f5;
            }
        } else if (w > h) {
            fHeight2 = rectF.height();
            f = fHeight2 * 0.6666667f;
            f4 = f / f5;
        } else {
            fHeight = rectF.height();
            f4 = fHeight * 0.6666667f;
            f = f4 * f5;
        }
        ViewGroup viewGroup = this.mViewGroup;
        int width = (viewGroup != null ? viewGroup.getWidth() : 0) / 2;
        ViewGroup viewGroup2 = this.mViewGroup;
        int height = viewGroup2 != null ? viewGroup2.getHeight() : 0;
        float f6 = width;
        float f7 = 2;
        float f8 = f6 - (f / f7);
        outNoneRatioRect.left = f8;
        float f9 = height / 2;
        float f10 = f9 - (f4 / f7);
        outNoneRatioRect.top = f10;
        outNoneRatioRect.right = f8 + f;
        outNoneRatioRect.bottom = f10 + f4;
        float f11 = this.mRatio;
        float f12 = f * f11;
        float f13 = f4 * f11;
        RectF rectF2 = new RectF();
        float f14 = f6 - (f12 / f7);
        rectF2.left = f14;
        float f15 = f9 - (f13 / f7);
        rectF2.top = f15;
        rectF2.right = f14 + f12;
        rectF2.bottom = f15 + f13;
        return rectF2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object mInvoke(Object instance, String runner, Class<?>[] clazz, Object... args) {
        try {
            return instance.getClass().getMethod(runner, (Class[]) Arrays.copyOf(clazz, clazz.length)).invoke(instance, Arrays.copyOf(args, args.length));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onLoad$lambda$0(Video video, int i) {
        WrapperVideoView wrapperVideoView;
        if ((i == -2 || i == -1) && (wrapperVideoView = video.mVideoView) != null) {
            wrapperVideoView.pause();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final boolean startVideoPlay() {
        this.mVideoView = new WrapperVideoView(this.mActivity);
        WrapperVideoView.WrapperVideoViewListener wrapperVideoViewListener = new WrapperVideoView.WrapperVideoViewListener() { // from class: com.samsung.android.sdk.pen.objectruntime.preload.Video.startVideoPlay.1
            @Override // com.samsung.android.sdk.pen.objectruntime.preload.WrapperVideoView.WrapperVideoViewListener
            public void onStart() {
            }
        };
        this.mVideoViewListener = wrapperVideoViewListener;
        final WrapperVideoView wrapperVideoView = this.mVideoView;
        if (wrapperVideoView != null) {
            wrapperVideoView.setListener(wrapperVideoViewListener);
            wrapperVideoView.requestFocusFromTouch();
            wrapperVideoView.setVideoPath(this.mVideoFilePath);
            wrapperVideoView.setLayoutParams(this.mVideoViewLayoutParams);
            wrapperVideoView.setZOrderMediaOverlay(true);
            wrapperVideoView.setBackgroundColor(0);
            ViewGroup viewGroup = this.mViewGroup;
            if (viewGroup != null) {
                viewGroup.addView(wrapperVideoView);
            }
            if (mSdkVersion >= 19) {
                try {
                    WrapperVideoView.class.getMethod("setStopMusic", (Class[]) Arrays.copyOf(new Class[]{Boolean.TYPE}, 1)).invoke(wrapperVideoView, Arrays.copyOf(new Object[]{Boolean.FALSE}, 1));
                } catch (Exception e) {
                    AbstractC2322a.m1609C("setStopMusic() ", e.getMessage(), TAG);
                } catch (NoSuchMethodError unused) {
                    Log.d(TAG, "setStopMusic() NoSuchMethodError");
                }
            }
            AudioManager audioManager = this.mAudioManager;
            if (audioManager != null) {
                audioManager.requestAudioFocus(this.mAudioLisner, 3, 1);
            }
            wrapperVideoView.setZOrderOnTop(true);
            wrapperVideoView.start();
            wrapperVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.samsung.android.sdk.pen.objectruntime.preload.a
                @Override // android.media.MediaPlayer.OnCompletionListener
                public final void onCompletion(MediaPlayer mediaPlayer) {
                    this.f4981a.complete();
                }
            });
            wrapperVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.samsung.android.sdk.pen.objectruntime.preload.b
                @Override // android.media.MediaPlayer.OnPreparedListener
                public final void onPrepared(MediaPlayer mediaPlayer) {
                    Video.startVideoPlay$lambda$8$lambda$6(wrapperVideoView, this, mediaPlayer);
                }
            });
            wrapperVideoView.setOnTouchListener(new ViewOnTouchListenerC7004e(wrapperVideoView, this, 2));
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startVideoPlay$lambda$8$lambda$6(WrapperVideoView wrapperVideoView, Video video, MediaPlayer mediaPlayer) {
        wrapperVideoView.start();
        AudioManager audioManager = video.mAudioManager;
        if (audioManager != null) {
            audioManager.requestAudioFocus(video.mAudioLisner, 3, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean startVideoPlay$lambda$8$lambda$7(WrapperVideoView wrapperVideoView, Video video, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (wrapperVideoView.isPlaying() && wrapperVideoView.canPause()) {
                wrapperVideoView.pause();
            } else {
                wrapperVideoView.start();
                AudioManager audioManager = video.mAudioManager;
                if (audioManager != null) {
                    audioManager.requestAudioFocus(video.mAudioLisner, 3, 1);
                }
            }
        }
        return true;
    }

    @Nullable
    public final AudioManager.OnAudioFocusChangeListener getMAudioLisner() {
        return this.mAudioLisner;
    }

    @Nullable
    public final AudioManager getMAudioManager() {
        return this.mAudioManager;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenNativeHandleInterface
    /* JADX INFO: renamed from: getNativeHandle */
    public long getMEngine() {
        return 0L;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    @Nullable
    public String getPrivateKeyHint() {
        return null;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public void getProperty(@NotNull Bundle propertyMap) {
        Intrinsics.checkNotNullParameter(propertyMap, "propertyMap");
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenObjectRuntimeInterface
    public int getType() {
        return 1;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public void onLoad(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Activity activity = (Activity) context;
        this.mActivity = activity;
        this.fm = activity != null ? activity.getFragmentManager() : null;
        Activity activity2 = this.mActivity;
        Object systemService = activity2 != null ? activity2.getSystemService("audio") : null;
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.mAudioManager = (AudioManager) systemService;
        this.mAudioLisner = new AudioManager.OnAudioFocusChangeListener() { // from class: com.samsung.android.sdk.pen.objectruntime.preload.c
            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public final void onAudioFocusChange(int i) {
                Video.onLoad$lambda$0(this.f4984a, i);
            }
        };
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenObjectRuntimeInterface
    public void onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public void onUnload() {
        this.mActivity = null;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenObjectRuntimeInterface
    public boolean setListener(@Nullable SpenObjectRuntimeInterface.UpdateListener listener) {
        if (listener == null) {
            Log.v(TAG, "argument listener is null.");
            return false;
        }
        this.mListener = listener;
        return true;
    }

    public final void setMAudioLisner(@Nullable AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener) {
        this.mAudioLisner = onAudioFocusChangeListener;
    }

    public final void setMAudioManager(@Nullable AudioManager audioManager) {
        this.mAudioManager = audioManager;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public void setProperty(@NotNull Bundle propertyMap) {
        Intrinsics.checkNotNullParameter(propertyMap, "propertyMap");
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenObjectRuntimeInterface
    public void setRect(@Nullable RectF rect) {
        if (rect == null || this.mViewGroup == null) {
            Log.v(TAG, "rect = " + rect + " or viewGroup = " + this.mViewGroup + " This SOR started yet.");
            return;
        }
        this.mRect = rect;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) rect.width(), (int) rect.height());
        this.mVideoViewLayoutParams = layoutParams;
        layoutParams.setMargins((int) rect.left, (int) rect.top, 0, 0);
        WrapperVideoView wrapperVideoView = this.mVideoView;
        if (wrapperVideoView != null) {
            wrapperVideoView.setLayoutParams(this.mVideoViewLayoutParams);
            wrapperVideoView.getHolder().setSizeFromLayout();
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenObjectRuntimeInterface
    public void start(@NotNull Object objectBase, @NotNull RectF relativeRect, @Nullable PointF pan, float zoomRatio, @NotNull PointF frameStartPosition, @NotNull ViewGroup layout) {
        FragmentTransaction fragmentTransactionBeginTransaction;
        FragmentTransaction fragmentTransactionAdd;
        Intrinsics.checkNotNullParameter(objectBase, "objectBase");
        Intrinsics.checkNotNullParameter(relativeRect, "relativeRect");
        Intrinsics.checkNotNullParameter(frameStartPosition, "frameStartPosition");
        Intrinsics.checkNotNullParameter(layout, "layout");
        this.mObject = objectBase;
        this.mViewGroup = layout;
        this.mPan = pan;
        this.mRatio = zoomRatio;
        this.mStartFramePosition = frameStartPosition;
        this.mVideoFilePath = objectBase != null ? (String) mInvoke(objectBase, GETEXTRADATASTRING_FUNCTION, GETEXTRADATASTRING_FUNCTION_ARG_SIGNATURE, new Object[]{EXTRADATASTRING_VIDEOPATH_KEY}) : null;
        setRect(relativeRect);
        if (this.mVideoFilePath != null) {
            if (startVideoPlay()) {
                return;
            }
            Log.v(TAG, "StartVideoPlay is failed.");
            cancel(1);
            return;
        }
        this.mFragment = new VideoIntentFragment();
        VideoIntentFragment.OnVideoIntentFragmentListener onVideoIntentFragmentListener = new VideoIntentFragment.OnVideoIntentFragmentListener() { // from class: com.samsung.android.sdk.pen.objectruntime.preload.Video.start.2
            @Override // com.samsung.android.sdk.pen.objectruntime.preload.VideoIntentFragment.OnVideoIntentFragmentListener
            public void onDestroy() {
                Video.this.cancel(0);
            }

            @Override // com.samsung.android.sdk.pen.objectruntime.preload.VideoIntentFragment.OnVideoIntentFragmentListener
            @SuppressLint({"Range"})
            public void onResult(Intent data) {
                Activity activity;
                ContentResolver contentResolver;
                if (data == null) {
                    Log.v(Video.TAG, "Video file was not selected.");
                    Video.this.cancel(0);
                    return;
                }
                Uri data2 = data.getData();
                if (data2 == null) {
                    Log.v(Video.TAG, "The extra data of video file is null.");
                    data2 = (Uri) data.getParcelableExtra("android.intent.extra.STREAM");
                }
                Uri uri = data2;
                Cursor cursorQuery = (uri == null || (activity = Video.this.mActivity) == null || (contentResolver = activity.getContentResolver()) == null) ? null : contentResolver.query(uri, new String[]{"_id", "_data"}, null, null, null);
                if (cursorQuery == null) {
                    Video video = Video.this;
                    Log.v(Video.TAG, "The extra data of video file query is failed.");
                    video.cancel(0);
                    return;
                }
                Video video2 = Video.this;
                cursorQuery.moveToFirst();
                if (cursorQuery.getCount() == 0) {
                    Log.v(Video.TAG, "The extra data of video file is empty.");
                    cursorQuery.close();
                    video2.cancel(0);
                    return;
                }
                video2.mVideoFilePath = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
                cursorQuery.close();
                String str = video2.mVideoFilePath;
                Bitmap bitmapCreateVideoThumbnail = str != null ? ThumbnailUtils.createVideoThumbnail(str, 1) : null;
                if (bitmapCreateVideoThumbnail == null) {
                    Log.v(Video.TAG, "The bitmap of video is null");
                    video2.cancel(0);
                    return;
                }
                RectF rectF = new RectF();
                video2.mRect = video2.getRatioRect(bitmapCreateVideoThumbnail.getWidth(), bitmapCreateVideoThumbnail.getHeight(), rectF);
                Object[] objArr = {video2.convertAbsolute(video2.mRect), Boolean.TRUE};
                Object obj = video2.mObject;
                if (obj != null) {
                    video2.mInvoke(obj, Video.SETRECT_FUNCTION, Video.SETRECT_FUNCTION_ARG_SIGNATURE, objArr);
                }
                Bitmap bitmapCreatePlayVideoBitmap = video2.createPlayVideoBitmap(bitmapCreateVideoThumbnail, rectF);
                if (bitmapCreatePlayVideoBitmap == null) {
                    Log.v(Video.TAG, "PlayVideo merge process is failed");
                    video2.cancel(0);
                    return;
                }
                Object[] objArr2 = {bitmapCreatePlayVideoBitmap};
                Object obj2 = video2.mObject;
                if (obj2 != null) {
                    video2.mInvoke(obj2, Video.SETIMAGE_FUNCTION, Video.SETIMAGE_FUNCTION_ARG_SIGNATURE, objArr2);
                }
                Object[] objArr3 = {Video.EXTRADATASTRING_VIDEOPATH_KEY, video2.mVideoFilePath};
                Object obj3 = video2.mObject;
                if (obj3 != null) {
                    video2.mInvoke(obj3, Video.SETEXTRADATASTRING_FUNCTION, Video.SETEXTRADATASTRING_FUNCTION_ARG_SIGNATURE, objArr3);
                }
                Object[] objArr4 = {Boolean.FALSE};
                Object obj4 = video2.mObject;
                if (obj4 != null) {
                    video2.mInvoke(obj4, Video.SETROTATABLE_FUNCTION, Video.SETROTATABLE_FUNCTION_ARG_SIGNATURE, objArr4);
                }
                Object[] objArr5 = {1};
                Object obj5 = video2.mObject;
                if (obj5 != null) {
                    video2.mInvoke(obj5, Video.SETRESIZEOPTION_FUNCTION, Video.SETRESIZEOPTION_FUNCTION_ARG_SIGNATURE, objArr5);
                    SpenObjectRuntimeInterface.UpdateListener updateListener = video2.mListener;
                    if (updateListener != null) {
                        updateListener.onObjectUpdated(video2.mRect, obj5);
                    }
                }
                video2.complete();
            }
        };
        this.mFragmentListener = onVideoIntentFragmentListener;
        VideoIntentFragment videoIntentFragment = this.mFragment;
        if (videoIntentFragment != null) {
            videoIntentFragment.setVideoIntentFragmentListener(onVideoIntentFragmentListener);
        }
        FragmentManager fragmentManager = this.fm;
        if (fragmentManager == null || (fragmentTransactionBeginTransaction = fragmentManager.beginTransaction()) == null || (fragmentTransactionAdd = fragmentTransactionBeginTransaction.add(this.mFragment, "PlayVideo")) == null) {
            return;
        }
        fragmentTransactionAdd.commitAllowingStateLoss();
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenObjectRuntimeInterface
    public void stop(boolean cancel) {
        cleanResource();
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public boolean unlock(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return true;
    }
}
