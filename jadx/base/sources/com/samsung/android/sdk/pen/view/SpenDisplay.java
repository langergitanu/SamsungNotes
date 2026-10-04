package com.samsung.android.sdk.pen.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.view.SpenConfiguration;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0000J\u0010\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u000eR\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/view/SpenDisplay;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "handle", "", "widthPixels", "", "heightPixels", "bitmapWidth", "bitmapHeight", "copy", "", "display", "updateScreenOrientation", "close", "updateDebugLevel", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenDisplay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenDisplay.kt\ncom/samsung/android/sdk/pen/view/SpenDisplay\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,196:1\n1#2:197\n*E\n"})
public final class SpenDisplay {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String DISPLAY_CATEGORY_BUILTIN = "com.samsung.android.hardware.display.category.BUILTIN";
    private static final boolean IS_ENG_BUILD;
    private static final boolean IS_USER_DEBUG_BUILD;

    @NotNull
    private static final String TAG = "SpenDisplay";

    @JvmField
    public int bitmapHeight;

    @JvmField
    public int bitmapWidth;

    @JvmField
    public long handle;

    @JvmField
    public int heightPixels;

    @JvmField
    public int widthPixels;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0089\u0001\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\bH\u0083 J\u0011\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0013H\u0083 J\u0019\u0010(\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u0013H\u0083 J\u0019\u0010*\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eH\u0083 J\u0019\u0010+\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u000eH\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u001a\u0010\r\u001a\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\u0010\u0010\u0011¨\u0006,"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/view/SpenDisplay$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "DISPLAY_CATEGORY_BUILTIN", "IS_ENG_BUILD", "", "getIS_ENG_BUILD", "()Z", "IS_USER_DEBUG_BUILD", "getIS_USER_DEBUG_BUILD", "debugLevel", "", "getDebugLevel$annotations", "getDebugLevel", "()I", "Native_init", "", "systemWidth", "systemHeight", "systemDensity", "", "localWidth", "localHeight", "density", "scaledDensity", "densityDpi", "xdpi", "ydpi", "direction", "orientation", "screenOrientation", "isTablet", "appVsyncOffsetNanos", "isLandscapeQuirk", "Native_finalize", "", "handle", "Native_copy", "srcHandle", "Native_setDebugLevel", "Native_updateScreenOrientation", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_copy(long handle, long srcHandle) {
            SpenDisplay.Native_copy(handle, srcHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long handle) {
            SpenDisplay.Native_finalize(handle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_init(int systemWidth, int systemHeight, float systemDensity, int localWidth, int localHeight, float density, float scaledDensity, int densityDpi, float xdpi, float ydpi, int direction, int orientation, int screenOrientation, boolean isTablet, long appVsyncOffsetNanos, boolean isLandscapeQuirk) {
            return SpenDisplay.Native_init(systemWidth, systemHeight, systemDensity, localWidth, localHeight, density, scaledDensity, densityDpi, xdpi, ydpi, direction, orientation, screenOrientation, isTablet, appVsyncOffsetNanos, isLandscapeQuirk);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setDebugLevel(long handle, int debugLevel) {
            SpenDisplay.Native_setDebugLevel(handle, debugLevel);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_updateScreenOrientation(long handle, int screenOrientation) {
            SpenDisplay.Native_updateScreenOrientation(handle, screenOrientation);
        }

        public final int getDebugLevel() {
            if (!getIS_ENG_BUILD() && !getIS_USER_DEBUG_BUILD()) {
                return 0;
            }
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                Object objInvoke = cls.getMethod("getInt", String.class, Integer.TYPE).invoke(cls, "persist.sys.spensdk.debug", 0);
                Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Int");
                return ((Integer) objInvoke).intValue();
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }

        public final boolean getIS_ENG_BUILD() {
            return SpenDisplay.IS_ENG_BUILD;
        }

        public final boolean getIS_USER_DEBUG_BUILD() {
            return SpenDisplay.IS_USER_DEBUG_BUILD;
        }

        private Companion() {
        }

        @JvmStatic
        public static /* synthetic */ void getDebugLevel$annotations() {
        }
    }

    static {
        String str = Build.TYPE;
        IS_ENG_BUILD = Intrinsics.areEqual("eng", str);
        IS_USER_DEBUG_BUILD = Intrinsics.areEqual("userdebug", str);
    }

    public SpenDisplay(@Nullable Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context must be not null");
        }
        Object systemService = context.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        Object systemService2 = context.getSystemService("display");
        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
        Display[] displays = ((DisplayManager) systemService2).getDisplays(DISPLAY_CATEGORY_BUILTIN);
        AbstractC0541b.m783y(displayMetrics.widthPixels, displayMetrics.heightPixels, "DisplayMetrics WidthPixels : ", ", HeightPixels : ", TAG);
        int i = displayMetrics.widthPixels;
        this.widthPixels = i;
        int i2 = displayMetrics.heightPixels;
        this.heightPixels = i2;
        i = i >= i2 ? i2 : i;
        Iterator it = ArrayIteratorKt.iterator(displays);
        while (it.hasNext()) {
            Display display = (Display) it.next();
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            display.getRealMetrics(displayMetrics2);
            int i4 = displayMetrics2.widthPixels;
            int i5 = displayMetrics2.heightPixels;
            if (i < (i4 > i5 ? i5 : i4)) {
                this.widthPixels = i4;
                this.heightPixels = i5;
            }
            AbstractC0541b.m783y(i4, i5, "Display info WidthPixels : ", ", HeightPixels : ", TAG);
        }
        AbstractC0541b.m783y(this.widthPixels, this.heightPixels, "Apply display info WidthPixels : ", ", HeightPixels : ", TAG);
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics3 = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        AbstractC0541b.m783y(displayMetrics3.widthPixels, displayMetrics3.heightPixels, "Current display displayMetrics.WidthPixels : ", ", displayMetrics.HeightPixels : ", TAG);
        SpenConfiguration.Companion companion = SpenConfiguration.INSTANCE;
        boolean zIsTabletUX = companion.isTabletUX(context);
        Log.d(TAG, "isTablet : " + zIsTabletUX);
        boolean zIsLandscapeQuirk = companion.isLandscapeQuirk();
        AbstractC6670b.m4759t("isLandscapeQuirk : ", TAG, zIsLandscapeQuirk);
        this.handle = INSTANCE.Native_init(this.widthPixels, this.heightPixels, displayMetrics.density, displayMetrics3.widthPixels, displayMetrics3.heightPixels, displayMetrics3.density, displayMetrics3.scaledDensity, displayMetrics3.densityDpi, displayMetrics3.xdpi, displayMetrics3.ydpi, configuration.getLayoutDirection(), defaultDisplay.getRotation(), configuration.orientation, zIsTabletUX, defaultDisplay.getAppVsyncOffsetNanos(), zIsLandscapeQuirk);
        int i6 = this.widthPixels;
        int i7 = this.heightPixels;
        i6 = i6 >= i7 ? i7 : i6;
        this.bitmapWidth = i6;
        float f = (i6 / displayMetrics3.xdpi) * 500;
        this.bitmapWidth = ((float) i6) >= f ? (int) f : i6;
        int iFloor = (int) Math.floor((((r1 * 16.0f) / 9.0f) * 1.5f) + 0.5f);
        this.bitmapHeight = iFloor;
        AbstractC0541b.m783y(this.bitmapWidth, iFloor, "BitmapWidth : ", ", BitmapHeight : ", TAG);
        updateDebugLevel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_copy(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_init(int i, int i2, float f, int i4, int i5, float f4, float f5, int i6, float f6, float f7, int i7, int i8, int i9, boolean z, long j, boolean z2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setDebugLevel(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_updateScreenOrientation(long j, int i);

    public static final int getDebugLevel() {
        return INSTANCE.getDebugLevel();
    }

    public final void close() {
        long j = this.handle;
        if (j != 0) {
            INSTANCE.Native_finalize(j);
        }
        this.handle = 0L;
    }

    public final void copy(@NotNull SpenDisplay display) {
        Intrinsics.checkNotNullParameter(display, "display");
        long j = this.handle;
        if (j != 0) {
            INSTANCE.Native_copy(j, display.handle);
        }
    }

    public final void updateDebugLevel() {
        long j = this.handle;
        if (j != 0) {
            Companion companion = INSTANCE;
            companion.Native_setDebugLevel(j, companion.getDebugLevel());
        }
    }

    public final void updateScreenOrientation(@Nullable Context context) {
        if (this.handle == 0 || context == null) {
            return;
        }
        INSTANCE.Native_updateScreenOrientation(this.handle, context.getResources().getConfiguration().orientation);
    }
}
