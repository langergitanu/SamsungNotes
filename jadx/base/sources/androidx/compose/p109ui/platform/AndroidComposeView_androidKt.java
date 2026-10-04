package androidx.compose.p109ui.platform;

import android.view.View;
import android.view.ViewParent;
import androidx.compose.p109ui.graphics.Matrix;
import androidx.compose.p109ui.platform.coreshims.ContentCaptureSessionCompat;
import androidx.compose.p109ui.platform.coreshims.ViewCompatShims;
import androidx.compose.p109ui.text.input.PlatformTextInputService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u001a2\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0014\u0010\u0013\u001a\u00020\u0014*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002\u001a\u000e\u0010\u0017\u001a\u0004\u0018\u00010\u0018*\u00020\u0015H\u0002\u001a\u001e\u0010\u0019\u001a\u00020\u001a*\u00020\f2\u0006\u0010\u0016\u001a\u00020\fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a.\u0010\u001d\u001a\u00020\u001a*\u00020\f2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\fH\u0002ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"&\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006#"}, m13886d2 = {"ONE_FRAME_120_HERTZ_IN_MILLISECONDS", "", "platformTextInputServiceInterceptor", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/PlatformTextInputService;", "getPlatformTextInputServiceInterceptor", "()Lkotlin/jvm/functions/Function1;", "setPlatformTextInputServiceInterceptor", "(Lkotlin/jvm/functions/Function1;)V", "dot", "", "m1", "Landroidx/compose/ui/graphics/Matrix;", "row", "", "m2", "column", "dot-p89u6pk", "([FI[FI)F", "containsDescendant", "", "Landroid/view/View;", "other", "getContentCaptureSessionCompat", "Landroidx/compose/ui/platform/coreshims/ContentCaptureSessionCompat;", "preTransform", "", "preTransform-JiSxe2E", "([F[F)V", "preTranslate", "x", "y", "tmpMatrix", "preTranslate-cG2Xzmc", "([FFF[F)V", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAndroidComposeView.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AndroidComposeView.android.kt\nandroidx/compose/ui/platform/AndroidComposeView_androidKt\n+ 2 Matrix.kt\nandroidx/compose/ui/graphics/Matrix\n*L\n1#1,2770:1\n42#2,2:2771\n42#2,2:2773\n42#2,2:2775\n42#2,2:2777\n42#2,2:2779\n42#2,2:2781\n42#2,2:2783\n42#2,2:2785\n42#2,2:2787\n42#2,2:2789\n42#2,2:2791\n42#2,2:2793\n42#2,2:2795\n42#2,2:2797\n42#2,2:2799\n42#2,2:2801\n39#2:2803\n39#2:2804\n39#2:2805\n39#2:2806\n*S KotlinDebug\n*F\n+ 1 AndroidComposeView.android.kt\nandroidx/compose/ui/platform/AndroidComposeView_androidKt\n*L\n2528#1:2771,2\n2529#1:2773,2\n2530#1:2775,2\n2531#1:2777,2\n2532#1:2779,2\n2533#1:2781,2\n2534#1:2783,2\n2535#1:2785,2\n2536#1:2787,2\n2537#1:2789,2\n2538#1:2791,2\n2539#1:2793,2\n2540#1:2795,2\n2541#1:2797,2\n2542#1:2799,2\n2543#1:2801,2\n2557#1:2803\n2558#1:2804\n2559#1:2805\n2560#1:2806\n*E\n"})
public final class AndroidComposeView_androidKt {
    private static final long ONE_FRAME_120_HERTZ_IN_MILLISECONDS = 8;

    @NotNull
    private static Function1<? super PlatformTextInputService, ? extends PlatformTextInputService> platformTextInputServiceInterceptor = new Function1<PlatformTextInputService, PlatformTextInputService>() { // from class: androidx.compose.ui.platform.AndroidComposeView_androidKt$platformTextInputServiceInterceptor$1
        @Override // kotlin.jvm.functions.Function1
        @NotNull
        public final PlatformTextInputService invoke(@NotNull PlatformTextInputService platformTextInputService) {
            return platformTextInputService;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean containsDescendant(View view, View view2) {
        if (Intrinsics.areEqual(view2, view)) {
            return false;
        }
        for (ViewParent parent = view2.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == view) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: dot-p89u6pk, reason: not valid java name */
    private static final float m20185dotp89u6pk(float[] fArr, int i, float[] fArr2, int i2) {
        int i4 = i * 4;
        return (fArr[i4 + 3] * fArr2[12 + i2]) + (fArr[i4 + 2] * fArr2[8 + i2]) + (fArr[i4 + 1] * fArr2[4 + i2]) + (fArr[i4] * fArr2[i2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContentCaptureSessionCompat getContentCaptureSessionCompat(View view) {
        ViewCompatShims.setImportantForContentCapture(view, 1);
        return ViewCompatShims.getContentCaptureSession(view);
    }

    @NotNull
    public static final Function1<PlatformTextInputService, PlatformTextInputService> getPlatformTextInputServiceInterceptor() {
        return platformTextInputServiceInterceptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: preTransform-JiSxe2E, reason: not valid java name */
    public static final void m20186preTransformJiSxe2E(float[] fArr, float[] fArr2) {
        float fM20185dotp89u6pk = m20185dotp89u6pk(fArr2, 0, fArr, 0);
        float fM20185dotp89u6pk2 = m20185dotp89u6pk(fArr2, 0, fArr, 1);
        float fM20185dotp89u6pk3 = m20185dotp89u6pk(fArr2, 0, fArr, 2);
        float fM20185dotp89u6pk4 = m20185dotp89u6pk(fArr2, 0, fArr, 3);
        float fM20185dotp89u6pk5 = m20185dotp89u6pk(fArr2, 1, fArr, 0);
        float fM20185dotp89u6pk6 = m20185dotp89u6pk(fArr2, 1, fArr, 1);
        float fM20185dotp89u6pk7 = m20185dotp89u6pk(fArr2, 1, fArr, 2);
        float fM20185dotp89u6pk8 = m20185dotp89u6pk(fArr2, 1, fArr, 3);
        float fM20185dotp89u6pk9 = m20185dotp89u6pk(fArr2, 2, fArr, 0);
        float fM20185dotp89u6pk10 = m20185dotp89u6pk(fArr2, 2, fArr, 1);
        float fM20185dotp89u6pk11 = m20185dotp89u6pk(fArr2, 2, fArr, 2);
        float fM20185dotp89u6pk12 = m20185dotp89u6pk(fArr2, 2, fArr, 3);
        float fM20185dotp89u6pk13 = m20185dotp89u6pk(fArr2, 3, fArr, 0);
        float fM20185dotp89u6pk14 = m20185dotp89u6pk(fArr2, 3, fArr, 1);
        float fM20185dotp89u6pk15 = m20185dotp89u6pk(fArr2, 3, fArr, 2);
        float fM20185dotp89u6pk16 = m20185dotp89u6pk(fArr2, 3, fArr, 3);
        fArr[0] = fM20185dotp89u6pk;
        fArr[1] = fM20185dotp89u6pk2;
        fArr[2] = fM20185dotp89u6pk3;
        fArr[3] = fM20185dotp89u6pk4;
        fArr[4] = fM20185dotp89u6pk5;
        fArr[5] = fM20185dotp89u6pk6;
        fArr[6] = fM20185dotp89u6pk7;
        fArr[7] = fM20185dotp89u6pk8;
        fArr[8] = fM20185dotp89u6pk9;
        fArr[9] = fM20185dotp89u6pk10;
        fArr[10] = fM20185dotp89u6pk11;
        fArr[11] = fM20185dotp89u6pk12;
        fArr[12] = fM20185dotp89u6pk13;
        fArr[13] = fM20185dotp89u6pk14;
        fArr[14] = fM20185dotp89u6pk15;
        fArr[15] = fM20185dotp89u6pk16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: preTranslate-cG2Xzmc, reason: not valid java name */
    public static final void m20187preTranslatecG2Xzmc(float[] fArr, float f, float f4, float[] fArr2) {
        Matrix.m18765resetimpl(fArr2);
        Matrix.m18776translateimpl$default(fArr2, f, f4, 0.0f, 4, null);
        m20186preTransformJiSxe2E(fArr, fArr2);
    }

    public static final void setPlatformTextInputServiceInterceptor(@NotNull Function1<? super PlatformTextInputService, ? extends PlatformTextInputService> function1) {
        platformTextInputServiceInterceptor = function1;
    }
}
