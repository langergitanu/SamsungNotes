package com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.animation.starting;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.airbnb.lottie.LottieAnimationView;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.RunningChecker;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.File;
import java.io.FileInputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.p196io.CloseableKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0014J\b\u0010\n\u001a\u00020\tH\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J(\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u00058TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/animation/starting/StartingPenHoverAnimation;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/animation/starting/AbsStartingAnimation;", "<init>", "()V", "mRotation", "", "mDisplayWidth", "mDisplayHeight", "initSystemValues", "", "initPosition", "startOffset", "getStartOffset", "()I", "getSpenRipplePoint", "Landroid/graphics/PointF;", "getSpenRippleData", "", "isExceptionalCase", "", "x", "y", "maxX", "maxY", "getHeight", "displayHeight", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nStartingPenHoverAnimation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StartingPenHoverAnimation.kt\ncom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/animation/starting/StartingPenHoverAnimation\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,165:1\n37#2:166\n36#2,3:167\n*S KotlinDebug\n*F\n+ 1 StartingPenHoverAnimation.kt\ncom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/animation/starting/StartingPenHoverAnimation\n*L\n87#1:166\n87#1:167,3\n*E\n"})
public final class StartingPenHoverAnimation extends AbsStartingAnimation {

    @NotNull
    private static final String FILE_PATH_GET_EPEN_POS = "/sys/class/sec/sec_epen/get_epen_pos";
    private static final int START_OFF_SET = 300;
    private int mDisplayHeight;
    private int mDisplayWidth;
    private int mRotation;

    @NotNull
    private static final String TAG = SOLogger.createTag("StartingPenHoverAnimation");

    private final int getHeight(int displayHeight) {
        InputMethodCompat.Companion companion = InputMethodCompat.INSTANCE;
        if (companion.getInstance().isEnabledMobileKeyboard(getMContext())) {
            displayHeight += companion.getInstance().getInputMethodWindowVisibleHeight(getMContext());
        }
        AbstractC8014b.m7206h("getHeight# ", displayHeight, SOLogger.INSTANCE, TAG);
        return displayHeight;
    }

    private final String getSpenRippleData() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "getSpenRippleData#");
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(FILE_PATH_GET_EPEN_POS));
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr, 0, fileInputStream.available());
                fileInputStream.close();
                String str = new String(bArr, Charsets.UTF_8);
                CloseableKt.closeFinally(fileInputStream, null);
                return str;
            } finally {
            }
        } catch (Exception e) {
            SOLogger.INSTANCE.SOLoggerE(TAG, "getSpenRippleData# ", e);
            return null;
        }
    }

    private final PointF getSpenRipplePoint() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "getSpenRipplePoint#");
        String spenRippleData = getSpenRippleData();
        if (spenRippleData == null) {
            return new PointF(this.mDisplayWidth / 2.0f, this.mDisplayHeight / 2.0f);
        }
        String[] strArr = (String[]) StringsKt__StringsKt.split$default(spenRippleData, new String[]{","}, false, 0, 6, (Object) null).toArray(new String[0]);
        byte[] bytes = strArr[4].getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        int length = bytes.length;
        for (int i = 0; i < length; i++) {
            byte b = bytes[i];
            if ((b < 48 || b > 57) && b != 46) {
                bytes[i] = 32;
            }
        }
        String str = new String(bytes, Charsets.UTF_8);
        strArr[4] = str;
        String string = StringsKt.trim((CharSequence) str).toString();
        strArr[4] = string;
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str2 = TAG;
        String str3 = strArr[0];
        String str4 = strArr[1];
        String str5 = strArr[2];
        String str6 = strArr[3];
        StringBuilder sbM16m = AbstractC0000a.m16m("getSpenRipplePoint# ", str3, SQLKeyword.COMMA, str4, SQLKeyword.COMMA);
        AbstractC2821a.m2207B(sbM16m, str5, SQLKeyword.COMMA, str6, SQLKeyword.COMMA);
        sbM16m.append(string);
        sOLogger.SOLoggerD(str2, sbM16m.toString());
        if (strArr[0].compareTo("1") != 0) {
            return new PointF(this.mDisplayWidth / 2.0f, this.mDisplayHeight / 2.0f);
        }
        int i2 = Integer.parseInt(strArr[1]);
        int i4 = Integer.parseInt(strArr[2]);
        int i5 = Integer.parseInt(strArr[3]);
        int i6 = Integer.parseInt(strArr[4]);
        if (isExceptionalCase(i2, i4, i5, i6)) {
            return new PointF(this.mDisplayWidth / 2.0f, this.mDisplayHeight / 2.0f);
        }
        sOLogger.SOLoggerD(str2, "getSpenRipplePoint# getPhysicalScreenSize " + DisplayUtils.INSTANCE.getPhysicalScreenSize(getMContext()));
        int i7 = this.mRotation;
        if (i7 == 0) {
            return new PointF((i2 * this.mDisplayWidth) / i5, (i4 * getHeight(this.mDisplayHeight)) / i6);
        }
        if (2 != i7) {
            return new PointF((i2 * getHeight(this.mDisplayHeight)) / i5, (i4 * this.mDisplayWidth) / i6);
        }
        return new PointF(this.mDisplayWidth - ((i2 * r6) / i5), this.mDisplayHeight - ((i4 * getHeight(r2)) / i6));
    }

    private final boolean isExceptionalCase(int x, int y2, int maxX, int maxY) {
        if (maxX <= 0 || maxY <= 0) {
            SOLogger.INSTANCE.SOLoggerD(TAG, "isExceptionalCase# maxX/Y is zero");
            return true;
        }
        if (x >= 0 && x <= maxX && y2 >= 0 && y2 <= maxY) {
            return false;
        }
        SOLogger.INSTANCE.SOLoggerD(TAG, "isExceptionalCase# wrong point");
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.animation.starting.AbsStartingAnimation
    public int getStartOffset() {
        return RunningChecker.INSTANCE.isScreenOffActivityRunning() ? 300 : 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.animation.starting.AbsStartingAnimation
    public void initPosition() {
        Resources resources;
        Resources resources2;
        ViewGroup viewGroup;
        LottieAnimationView mAnimationView = getMAnimationView();
        if ((mAnimationView != null ? mAnimationView.getParent() : null) != null) {
            try {
                LottieAnimationView mAnimationView2 = getMAnimationView();
                ViewParent parent = mAnimationView2 != null ? mAnimationView2.getParent() : null;
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent).removeView(getMAnimationView());
            } catch (Exception e) {
                AbstractC0000a.m24u("initPosition# animationView is already removed, ", e.getMessage(), SOLogger.INSTANCE, TAG);
            }
        }
        View mContainer = getMContainer();
        if (mContainer != null && (viewGroup = (ViewGroup) mContainer.findViewById(C9086R.id.main_layout)) != null) {
            viewGroup.addView(getMAnimationView());
        }
        Context mContext = getMContext();
        int dimension = 0;
        int dimension2 = (mContext == null || (resources2 = mContext.getResources()) == null) ? 0 : (int) resources2.getDimension(C9086R.dimen.screenoff_pen_hover_animation_width);
        Context mContext2 = getMContext();
        if (mContext2 != null && (resources = mContext2.getResources()) != null) {
            dimension = (int) resources.getDimension(C9086R.dimen.screenoff_pen_hover_animation_height);
        }
        LottieAnimationView mAnimationView3 = getMAnimationView();
        ViewGroup.LayoutParams layoutParams = mAnimationView3 != null ? mAnimationView3.getLayoutParams() : null;
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.width = dimension2;
        layoutParams2.height = dimension;
        PointF spenRipplePoint = getSpenRipplePoint();
        SOLogger.INSTANCE.SOLoggerD(TAG, "initPosition# ripplePoint " + spenRipplePoint);
        int i = this.mRotation;
        if (i == 0 || 2 == i) {
            layoutParams2.setMarginStart(((int) spenRipplePoint.x) - ((int) (dimension2 / 2.0f)));
            layoutParams2.topMargin = ((int) spenRipplePoint.y) - ((int) (dimension / 2.0f));
        } else if (3 == i) {
            layoutParams2.setMarginStart(this.mDisplayWidth - (((int) spenRipplePoint.y) + ((int) (dimension2 / 2.0f))));
            layoutParams2.topMargin = ((int) spenRipplePoint.x) - ((int) (dimension / 2.0f));
        } else {
            layoutParams2.setMarginStart(((int) spenRipplePoint.y) - ((int) (dimension2 / 2.0f)));
            layoutParams2.topMargin = (this.mDisplayHeight - ((int) spenRipplePoint.x)) - ((int) (dimension / 2.0f));
        }
        LottieAnimationView mAnimationView4 = getMAnimationView();
        if (mAnimationView4 != null) {
            mAnimationView4.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.animation.starting.AbsStartingAnimation
    public void initSystemValues() {
        Context mContext = getMContext();
        Object systemService = mContext != null ? mContext.getSystemService("window") : null;
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager windowManager = (WindowManager) systemService;
        this.mRotation = windowManager.getDefaultDisplay().getRotation();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        this.mDisplayWidth = i;
        int i2 = displayMetrics.heightPixels;
        this.mDisplayHeight = i2;
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(this.mRotation, i, "initSystemValues# rotation/displayWidth/displayHeight ", "/", "/");
        sbM1173s.append(i2);
        sOLogger.SOLoggerD(str, sbM1173s.toString());
    }
}
