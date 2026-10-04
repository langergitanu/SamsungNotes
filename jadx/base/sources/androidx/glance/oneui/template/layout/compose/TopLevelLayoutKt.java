package androidx.glance.oneui.template.layout.compose;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.SemBlurInfo;
import android.view.View;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.draw.AlphaKt;
import androidx.compose.p109ui.draw.ClipKt;
import androidx.compose.p109ui.draw.ScaleKt;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.CompositingStrategy;
import androidx.compose.p109ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p109ui.layout.ContentScale;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.res.PrimitiveResources_androidKt;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.p109ui.viewinterop.AndroidView_androidKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.glance.AbstractC2821a;
import androidx.glance.GlanceTheme;
import androidx.glance.oneui.common.AppWidgetHostType;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.common.DeviceConfigUtilsKt;
import androidx.glance.oneui.common.DeviceType;
import androidx.glance.oneui.common.GlanceLog;
import androidx.glance.oneui.template.AppWidgetBackground;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.ImageData;
import androidx.glance.oneui.template.SettingPreviewUtilsKt;
import androidx.glance.oneui.template.Shape;
import androidx.glance.oneui.template.TemplateState;
import androidx.glance.oneui.template.TitleBarData;
import androidx.glance.oneui.template.component.compose.ImageKt;
import androidx.glance.oneui.template.component.compose.TitleBarKt;
import androidx.glance.oneui.template.layout.CommonDimensions;
import androidx.glance.oneui.template.utils.ComposeModifierUtilsKt;
import androidx.glance.oneui.template.utils.ComposeUtilsKt;
import androidx.glance.oneui.template.utils.SmoothRoundedCornerShape;
import com.nimbusds.jose.jwk.JWKParameterNames;
import com.samsung.android.feature.SemFloatingFeature;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000`\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aH\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\tH\u0003ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001aR\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0013\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0015¢\u0006\u0002\b\u00162\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0015¢\u0006\u0002\b\u00162\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00070\u0015¢\u0006\u0002\b\u0016H\u0001¢\u0006\u0002\u0010\u0019\u001a<\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00070\u0015¢\u0006\u0002\b\u0016H\u0001¢\u0006\u0002\u0010\u001e\u001a\u001a\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0003ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&\u001a\"\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\tH\u0002ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a\u000e\u0010-\u001a\u0004\u0018\u00010.*\u00020)H\u0002\u001a4\u0010/\u001a\u00020\u0007*\u0002002\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tø\u0001\u0000¢\u0006\u0004\b1\u00102\"\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00063"}, m13886d2 = {"BLUR_PRESET", "", "", "[[F", SearchConstants.TargetContents.TAG, "", "BlurView", "", "previewWidth", "Landroidx/compose/ui/unit/Dp;", "previewHeight", "topLeftRadius", "topRightRadius", "bottomLeftRadius", "bottomRightRadius", "BlurView-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)V", "ComposeTitleBarLayout", "titleBar", "Landroidx/glance/oneui/template/TitleBarData;", "subtitleContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "actionContent", "content", "(Landroidx/glance/oneui/template/TitleBarData;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ComposeTopLevelLayout", "previewDescription", "previewBackground", "Landroidx/glance/oneui/template/AppWidgetBackground;", "(Ljava/lang/String;Landroidx/glance/oneui/template/AppWidgetBackground;Landroidx/glance/oneui/template/TitleBarData;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "adjustDpValueForAntialiasing", "inputDp", "adjustDpValueForAntialiasing-8Feqmps", "(FLandroidx/compose/runtime/Composer;I)F", "getContentScale", "", "appWidgetOptions", "Landroid/os/Bundle;", "toPixel", "context", "Landroid/content/Context;", JWKParameterNames.RSA_FIRST_FACTOR_CRT_EXPONENT, "toPixel-3ABfNKs", "(Landroid/content/Context;F)F", "getActivity", "Landroid/app/Activity;", "setBlur", "Landroid/view/View;", "setBlur-qDBjuR0", "(Landroid/view/View;FFFF)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTopLevelLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TopLevelLayout.kt\nandroidx/glance/oneui/template/layout/compose/TopLevelLayoutKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 4 Dp.kt\nandroidx/compose/ui/unit/Dp\n+ 5 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 6 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 7 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 8 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 9 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,393:1\n74#2:394\n74#2:395\n74#2:396\n74#2:397\n74#2:398\n74#2:399\n74#2:402\n74#2:403\n74#2:405\n74#2:407\n76#2:419\n74#2:456\n74#2:457\n174#3:400\n154#3:401\n71#4:404\n71#4:406\n71#4:408\n71#4:409\n71#4:410\n71#4:411\n71#4:412\n88#4:459\n88#4:460\n88#4:461\n88#4:462\n88#4:463\n68#5,5:413\n73#5:444\n77#5:449\n75#6:418\n76#6,11:420\n89#6:448\n460#7,13:431\n473#7,3:445\n1116#8,6:450\n1#9:458\n*S KotlinDebug\n*F\n+ 1 TopLevelLayout.kt\nandroidx/glance/oneui/template/layout/compose/TopLevelLayoutKt\n*L\n111#1:394\n112#1:395\n113#1:396\n115#1:397\n129#1:398\n130#1:399\n143#1:402\n146#1:403\n147#1:405\n148#1:407\n237#1:419\n346#1:456\n372#1:457\n134#1:400\n138#1:401\n146#1:404\n147#1:406\n228#1:408\n229#1:409\n230#1:410\n231#1:411\n234#1:412\n172#1:459\n173#1:460\n174#1:461\n175#1:462\n178#1:463\n237#1:413,5\n237#1:444\n237#1:449\n237#1:418\n237#1:420,11\n237#1:448\n237#1:431,13\n237#1:445,3\n283#1:450,6\n*E\n"})
public final class TopLevelLayoutKt {

    @NotNull
    private static final float[][] BLUR_PRESET = {new float[]{300.0f, 0.3f, 12.0f, 5.0f, 235.0f, 17.8f, 247.3f}, new float[]{300.0f, 0.35f, -5.0f, 0.0f, 255.0f, 13.3f, 235.1f}};

    @NotNull
    private static final String TAG = "GWT:TopLevelLayout";

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x010c  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: BlurView-aqJV_2Y, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m21813BlurViewaqJV_2Y(final float f, final float f4, final float f5, float f6, float f7, float f8, Composer composer, final int i, final int i2) {
        int i4;
        final float f9;
        final float f10;
        float f11;
        int i5;
        final float f12;
        boolean zChanged;
        Object objRememberedValue;
        final float f13;
        final float f14;
        final float f15;
        Composer composerStartRestartGroup = composer.startRestartGroup(698855460);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(f4) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 896) == 0) {
            i4 |= composerStartRestartGroup.changed(f5) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            if ((i2 & 8) == 0) {
                f9 = f6;
                int i6 = composerStartRestartGroup.changed(f9) ? 2048 : 1024;
                i4 |= i6;
            } else {
                f9 = f6;
            }
            i4 |= i6;
        } else {
            f9 = f6;
        }
        if ((57344 & i) == 0) {
            if ((i2 & 16) == 0) {
                f10 = f7;
                int i7 = composerStartRestartGroup.changed(f10) ? 16384 : 8192;
                i4 |= i7;
            } else {
                f10 = f7;
            }
            i4 |= i7;
        } else {
            f10 = f7;
        }
        if ((458752 & i) == 0) {
            if ((i2 & 32) == 0) {
                f11 = f8;
                int i8 = composerStartRestartGroup.changed(f11) ? 131072 : 65536;
                i4 |= i8;
            } else {
                f11 = f8;
            }
            i4 |= i8;
        } else {
            f11 = f8;
        }
        if ((374491 & i4) == 74898 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            f14 = f9;
            f15 = f10;
            f13 = f11;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 8) != 0) {
                    i4 &= -7169;
                    f9 = f5;
                }
                if ((i2 & 16) != 0) {
                    i4 &= -57345;
                    f10 = f5;
                }
                if ((i2 & 32) != 0) {
                    i5 = i4 & (-458753);
                    f12 = f5;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(698855460, i5, -1, "androidx.glance.oneui.template.layout.compose.BlurView (TopLevelLayout.kt:270)");
                }
                float fM21815adjustDpValueForAntialiasing8Feqmps = m21815adjustDpValueForAntialiasing8Feqmps(f, composerStartRestartGroup, i5 & 14);
                float fM21815adjustDpValueForAntialiasing8Feqmps2 = m21815adjustDpValueForAntialiasing8Feqmps(f4, composerStartRestartGroup, (i5 >> 3) & 14);
                composerStartRestartGroup.startMovableGroup(-1521377411, Integer.valueOf(CollectionsKt.m13955n(CollectionsKt.listOf((Object[]) new C2256Dp[]{C2256Dp.m20966boximpl(f5), C2256Dp.m20966boximpl(f9), C2256Dp.m20966boximpl(f10), C2256Dp.m20966boximpl(f12)}), ",", null, null, null, 62).hashCode()));
                Modifier modifierM15885height3ABfNKs = SizeKt.m15885height3ABfNKs(SizeKt.m15904width3ABfNKs(Modifier.INSTANCE, fM21815adjustDpValueForAntialiasing8Feqmps), fM21815adjustDpValueForAntialiasing8Feqmps2);
                composerStartRestartGroup.startReplaceableGroup(-2004098765);
                zChanged = composerStartRestartGroup.changed(f5) | composerStartRestartGroup.changed(f9) | composerStartRestartGroup.changed(f10) | composerStartRestartGroup.changed(f12);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1<Context, View>() { // from class: androidx.glance.oneui.template.layout.compose.TopLevelLayoutKt$BlurView$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        @NotNull
                        public final View invoke(@NotNull Context context) {
                            Intrinsics.checkNotNullParameter(context, "context");
                            View view = new View(context);
                            TopLevelLayoutKt.m21816setBlurqDBjuR0(view, f5, f9, f10, f12);
                            view.setBackgroundColor(0);
                            return view;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                AndroidView_androidKt.AndroidView((Function1) objRememberedValue, modifierM15885height3ABfNKs, null, composerStartRestartGroup, 0, 4);
                composerStartRestartGroup.endMovableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                float f16 = f10;
                f13 = f12;
                f14 = f9;
                f15 = f16;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 8) != 0) {
                    i4 &= -7169;
                }
                if ((i2 & 16) != 0) {
                    i4 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    i4 &= -458753;
                }
            }
            float f17 = f11;
            i5 = i4;
            f12 = f17;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            float fM21815adjustDpValueForAntialiasing8Feqmps3 = m21815adjustDpValueForAntialiasing8Feqmps(f, composerStartRestartGroup, i5 & 14);
            float fM21815adjustDpValueForAntialiasing8Feqmps22 = m21815adjustDpValueForAntialiasing8Feqmps(f4, composerStartRestartGroup, (i5 >> 3) & 14);
            composerStartRestartGroup.startMovableGroup(-1521377411, Integer.valueOf(CollectionsKt.m13955n(CollectionsKt.listOf((Object[]) new C2256Dp[]{C2256Dp.m20966boximpl(f5), C2256Dp.m20966boximpl(f9), C2256Dp.m20966boximpl(f10), C2256Dp.m20966boximpl(f12)}), ",", null, null, null, 62).hashCode()));
            Modifier modifierM15885height3ABfNKs2 = SizeKt.m15885height3ABfNKs(SizeKt.m15904width3ABfNKs(Modifier.INSTANCE, fM21815adjustDpValueForAntialiasing8Feqmps3), fM21815adjustDpValueForAntialiasing8Feqmps22);
            composerStartRestartGroup.startReplaceableGroup(-2004098765);
            zChanged = composerStartRestartGroup.changed(f5) | composerStartRestartGroup.changed(f9) | composerStartRestartGroup.changed(f10) | composerStartRestartGroup.changed(f12);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue = new Function1<Context, View>() { // from class: androidx.glance.oneui.template.layout.compose.TopLevelLayoutKt$BlurView$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final View invoke(@NotNull Context context) {
                        Intrinsics.checkNotNullParameter(context, "context");
                        View view = new View(context);
                        TopLevelLayoutKt.m21816setBlurqDBjuR0(view, f5, f9, f10, f12);
                        view.setBackgroundColor(0);
                        return view;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                composerStartRestartGroup.endReplaceableGroup();
                AndroidView_androidKt.AndroidView((Function1) objRememberedValue, modifierM15885height3ABfNKs2, null, composerStartRestartGroup, 0, 4);
                composerStartRestartGroup.endMovableGroup();
                if (ComposerKt.isTraceInProgress()) {
                }
                float f162 = f10;
                f13 = f12;
                f14 = f9;
                f15 = f162;
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.TopLevelLayoutKt$BlurView$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i9) {
                    TopLevelLayoutKt.m21813BlurViewaqJV_2Y(f, f4, f5, f14, f15, f13, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void ComposeTitleBarLayout(@NotNull final TitleBarData titleBar, @Nullable final Function2<? super Composer, ? super Integer, Unit> function2, @Nullable final Function2<? super Composer, ? super Integer, Unit> function22, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(titleBar, "titleBar");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-72644146);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-72644146, i, -1, "androidx.glance.oneui.template.layout.compose.ComposeTitleBarLayout (TopLevelLayout.kt:368)");
        }
        ProvidableCompositionLocal<TemplateState> localTemplateState = CompositionLocalsKt.getLocalTemplateState();
        composerStartRestartGroup.startReplaceableGroup(920964285);
        TemplateState templateState = (TemplateState) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTemplateState());
        templateState.setHasTitleBar(titleBar.getShowTitleBar(composerStartRestartGroup, 8));
        composerStartRestartGroup.endReplaceableGroup();
        CompositionLocalKt.CompositionLocalProvider(localTemplateState.provides(templateState), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1699517170, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.TopLevelLayoutKt.ComposeTitleBarLayout.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void invoke(@Nullable Composer composer2, int i2) {
                if ((i2 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1699517170, i2, -1, "androidx.glance.oneui.template.layout.compose.ComposeTitleBarLayout.<anonymous> (TopLevelLayout.kt:373)");
                }
                if (titleBar.getIsOverlayWithContent()) {
                    composer2.startReplaceableGroup(1130783295);
                    Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Function2<Composer, Integer, Unit> function23 = content;
                    TitleBarData titleBarData = titleBar;
                    Function2<Composer, Integer, Unit> function24 = function2;
                    Function2<Composer, Integer, Unit> function25 = function22;
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, false, composer2, 0, -1323940314);
                    Density density = (Density) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor = companion.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierFillMaxSize$default);
                    if (composer2.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    composer2.disableReusing();
                    Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer2);
                    Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
                    function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    composer2.startReplaceableGroup(-1743499748);
                    if (!AppWidgetSize.m21550equalsimpl0(((AppWidgetSize) composer2.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21573getWideSmallrx25Pp4())) {
                        function23.invoke(composer2, 0);
                    }
                    composer2.endReplaceableGroup();
                    TitleBarKt.ComposeContent(titleBarData, function24, function25, composer2, 8);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                } else {
                    composer2.startReplaceableGroup(1130783562);
                    Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    TitleBarData titleBarData2 = titleBar;
                    Function2<Composer, Integer, Unit> function26 = function2;
                    Function2<Composer, Integer, Unit> function27 = function22;
                    Function2<Composer, Integer, Unit> function28 = content;
                    composer2.startReplaceableGroup(-483455358);
                    MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(Alignment.INSTANCE, Arrangement.INSTANCE.getTop(), composer2, 0, -1323940314);
                    Density density2 = (Density) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection2 = (LayoutDirection) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierFillMaxSize$default2);
                    if (composer2.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor2);
                    } else {
                        composer2.useNode();
                    }
                    composer2.disableReusing();
                    Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer2);
                    Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl2, measurePolicyM1209j, composerM18018constructorimpl2, density2));
                    function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl2, viewConfiguration2, composer2, composer2), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    TitleBarKt.ComposeContent(titleBarData2, function26, function27, composer2, 8);
                    composer2.startReplaceableGroup(1130783697);
                    if (!AppWidgetSize.m21550equalsimpl0(((AppWidgetSize) composer2.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21573getWideSmallrx25Pp4())) {
                        function28.invoke(composer2, 0);
                    }
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composerStartRestartGroup, 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.TopLevelLayoutKt.ComposeTitleBarLayout.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i2) {
                    TopLevelLayoutKt.ComposeTitleBarLayout(titleBar, function2, function22, content, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.glance.GlanceComposable[androidx.compose.ui.UiComposable]]")
    public static final void ComposeTopLevelLayout(@Nullable final String str, @NotNull final AppWidgetBackground previewBackground, @Nullable final TitleBarData titleBarData, @NotNull Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i) {
        float fM21777getMaxAppWidgetCornerRadiusD9Ej5fM;
        Function2<? super Composer, ? super Integer, Unit> function2;
        Intrinsics.checkNotNullParameter(previewBackground, "previewBackground");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(251870368);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(251870368, i, -1, "androidx.glance.oneui.template.layout.compose.ComposeTopLevelLayout (TopLevelLayout.kt:109)");
        }
        Bundle bundle = (Bundle) composerStartRestartGroup.consume(androidx.glance.appwidget.CompositionLocalsKt.getLocalAppWidgetOptions());
        int mask = ((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        Configuration configuration = ((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext())).getResources().getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration, "getConfiguration(...)");
        boolean zIsPortrait = DeviceConfigUtilsKt.isPortrait(configuration);
        Point grid = SettingPreviewUtilsKt.getGrid(bundle, zIsPortrait);
        float f = (((DeviceType) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDeviceType())) != DeviceType.Phone || !(SettingPreviewUtilsKt.is5x6(grid, zIsPortrait) || SettingPreviewUtilsKt.is6x3(grid, zIsPortrait)) || Build.VERSION.SDK_INT > 35) ? 1.0f : 0.83f;
        composerStartRestartGroup.startReplaceableGroup(1384925349);
        if (AppWidgetHostType.m21524equalsimpl0(((AppWidgetHostType) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalHostType())).getMask(), AppWidgetHostType.INSTANCE.m21537getUnknownmn_SBp8())) {
            Resources resources = ((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext())).getResources();
            fM21777getMaxAppWidgetCornerRadiusD9Ej5fM = C2256Dp.m20968constructorimpl(resources.getDimension(R.dimen.system_app_widget_background_radius) / resources.getDisplayMetrics().density);
        } else {
            fM21777getMaxAppWidgetCornerRadiusD9Ej5fM = AppWidgetSize.m21546compareToL2j3NV4(mask, AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4()) < 0 ? CommonDimensions.INSTANCE.m21777getMaxAppWidgetCornerRadiusD9Ej5fM() : C2256Dp.m20968constructorimpl(24);
        }
        float f4 = fM21777getMaxAppWidgetCornerRadiusD9Ej5fM;
        composerStartRestartGroup.endReplaceableGroup();
        long jConvert = ComposeUtilsKt.convert(GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getBackground(), composerStartRestartGroup, 8);
        boolean z = Color.m18527getAlphaimpl(jConvert) > 0.0f && previewBackground.isBlurAvailable();
        composerStartRestartGroup.startReplaceableGroup(1384925968);
        boolean z2 = previewBackground.getShape() != Shape.None && SettingPreviewUtilsKt.is2x2((Bundle) composerStartRestartGroup.consume(androidx.glance.appwidget.CompositionLocalsKt.getLocalAppWidgetOptions()));
        composerStartRestartGroup.endReplaceableGroup();
        float contentScale = getContentScale(bundle);
        float fM20968constructorimpl = C2256Dp.m20968constructorimpl(DpSize.m21066getWidthD9Ej5fM(((DpSize) composerStartRestartGroup.consume(androidx.glance.CompositionLocalsKt.getLocalSize())).getPackedValue()) / f);
        float fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(DpSize.m21064getHeightD9Ej5fM(((DpSize) composerStartRestartGroup.consume(androidx.glance.CompositionLocalsKt.getLocalSize())).getPackedValue()) / f);
        Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        float scale = SettingPreviewUtilsKt.getScale(bundle) * contentScale * f;
        composerStartRestartGroup.startReplaceableGroup(1384929138);
        SmoothRoundedCornerShape smoothRoundedCornerShape = z2 ? new SmoothRoundedCornerShape(C2256Dp.m20968constructorimpl(PrimitiveResources_androidKt.dimensionResource(previewBackground.getShape().getTopLeftRadius(), composerStartRestartGroup, 0) / f), C2256Dp.m20968constructorimpl(PrimitiveResources_androidKt.dimensionResource(previewBackground.getShape().getTopRightRadius(), composerStartRestartGroup, 0) / f), C2256Dp.m20968constructorimpl(PrimitiveResources_androidKt.dimensionResource(previewBackground.getShape().getBottomRightRadius(), composerStartRestartGroup, 0) / f), C2256Dp.m20968constructorimpl(PrimitiveResources_androidKt.dimensionResource(previewBackground.getShape().getBottomLeftRadius(), composerStartRestartGroup, 0) / f), null) : new SmoothRoundedCornerShape(C2256Dp.m20968constructorimpl(f4 / f), null);
        composerStartRestartGroup.endReplaceableGroup();
        Modifier.Companion companion = Modifier.INSTANCE;
        Modifier modifierM18686graphicsLayerAp8cVGQ$default = GraphicsLayerModifierKt.m18686graphicsLayerAp8cVGQ$default(ComposeModifierUtilsKt.contentDescription(ClipKt.clip(ScaleKt.scale(SizeKt.m15885height3ABfNKs(SizeKt.m15904width3ABfNKs(companion, fM20968constructorimpl), fM20968constructorimpl2), scale), smoothRoundedCornerShape), str), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, CompositingStrategy.INSTANCE.m18616getOffscreenNrFUSI(), 65535, null);
        Alignment center = Alignment.INSTANCE.getCenter();
        composerStartRestartGroup.startReplaceableGroup(733328855);
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composerStartRestartGroup, 6);
        Density density = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion2.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM18686graphicsLayerAp8cVGQ$default);
        if (composerStartRestartGroup.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startReusableNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(constructor);
        } else {
            composerStartRestartGroup.useNode();
        }
        composerStartRestartGroup.disableReusing();
        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
        AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 2058660585);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        boolean z3 = z;
        ComposeTopLevelLayout$Blur(context, z3, z2, fM20968constructorimpl, fM20968constructorimpl2, previewBackground, contentScale, f4, composerStartRestartGroup, 0);
        ComposeTopLevelLayout$Background(previewBackground, jConvert, z3, SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), composerStartRestartGroup, 6);
        if (titleBarData != null) {
            composerStartRestartGroup.startReplaceableGroup(-716312907);
            function2 = content;
            androidx.glance.oneui.template.layout.TopLevelLayoutKt.TitleBarLayout(titleBarData, null, null, function2, composerStartRestartGroup, (i & 7168) | 8, 6);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            function2 = content;
            composerStartRestartGroup.startReplaceableGroup(-716312834);
            AbstractC1038a.m1198C(composerStartRestartGroup, (i >> 9) & 14, function2);
        }
        if (AbstractC2821a.m2209D(composerStartRestartGroup)) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function2<? super Composer, ? super Integer, Unit> function22 = function2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.TopLevelLayoutKt.ComposeTopLevelLayout.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i2) {
                    TopLevelLayoutKt.ComposeTopLevelLayout(str, previewBackground, titleBarData, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x010a  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void ComposeTopLevelLayout$Background(AppWidgetBackground appWidgetBackground, long j, boolean z, Modifier modifier, Composer composer, int i) {
        Composer composer2;
        composer.startReplaceableGroup(1290417595);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1290417595, i, -1, "androidx.glance.oneui.template.layout.compose.ComposeTopLevelLayout.Background (TopLevelLayout.kt:183)");
        }
        if (appWidgetBackground instanceof AppWidgetBackground.Image) {
            composer.startReplaceableGroup(-1395467071);
            AppWidgetBackground.Image image = (AppWidgetBackground.Image) appWidgetBackground;
            ImageKt.ComposeImage(new ImageData(image.getImageProvider(), null, null, null, null, false, 62, null), modifier, ComposeUtilsKt.m21962convertNx_grj4(image.getContentScale(), composer, 0), false, composer, ((i << 3) & 112) | 3080, 0);
            composer.endReplaceableGroup();
        } else {
            if (!(appWidgetBackground instanceof AppWidgetBackground.Gradient)) {
                if (appWidgetBackground instanceof AppWidgetBackground.Bitmap) {
                    composer.startReplaceableGroup(-1395466391);
                    AppWidgetBackground.Bitmap bitmap = (AppWidgetBackground.Bitmap) appWidgetBackground;
                    ImageKt.ComposeImage(new ImageData(androidx.glance.ImageKt.ImageProvider(bitmap.getBitmap()), null, null, null, null, false, 62, null), AlphaKt.alpha(modifier, bitmap.getAlpha()), ContentScale.INSTANCE.getCrop(), false, composer, 3464, 0);
                    composer2 = composer;
                    composer2.endReplaceableGroup();
                } else {
                    composer2 = composer;
                    composer2.startReplaceableGroup(-1395466056);
                    GlanceLog.INSTANCE.m2301i(TAG, "AppWidgetBackground color : " + Color.m18533toStringimpl(j));
                    SpacerKt.Spacer(BackgroundKt.m15409backgroundbw27NRU$default(modifier, z ? j : Color.INSTANCE.m18560getTransparent0d7_KjU(), null, 2, null), composer2, 0);
                    composer2.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2.endReplaceableGroup();
            }
            composer.startReplaceableGroup(-1395466725);
            ImageKt.ComposeImage(new ImageData(androidx.glance.ImageKt.ImageProvider(((AppWidgetBackground.Gradient) appWidgetBackground).getResId()), null, null, null, null, false, 62, null), modifier, ContentScale.INSTANCE.getFillBounds(), false, composer, ((i << 3) & 112) | 3464, 0);
            composer.endReplaceableGroup();
        }
        composer2 = composer;
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2.endReplaceableGroup();
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    private static final void ComposeTopLevelLayout$Blur(Context context, boolean z, boolean z2, float f, float f4, AppWidgetBackground appWidgetBackground, float f5, float f6, Composer composer, int i) {
        composer.startReplaceableGroup(81322315);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(81322315, i, -1, "androidx.glance.oneui.template.layout.compose.ComposeTopLevelLayout.Blur (TopLevelLayout.kt:150)");
        }
        boolean zComposeTopLevelLayout$Blur$isShowWindowWallpaper = ComposeTopLevelLayout$Blur$isShowWindowWallpaper(context);
        GlanceLog.INSTANCE.m2301i(TAG, "showBlur : " + zComposeTopLevelLayout$Blur$isShowWindowWallpaper + " / " + z);
        if (z && zComposeTopLevelLayout$Blur$isShowWindowWallpaper) {
            if (z2) {
                composer.startReplaceableGroup(102443964);
                m21813BlurViewaqJV_2Y(f, f4, C2256Dp.m20968constructorimpl(PrimitiveResources_androidKt.dimensionResource(appWidgetBackground.getShape().getTopLeftRadius(), composer, 0) * f5), C2256Dp.m20968constructorimpl(PrimitiveResources_androidKt.dimensionResource(appWidgetBackground.getShape().getTopRightRadius(), composer, 0) * f5), C2256Dp.m20968constructorimpl(PrimitiveResources_androidKt.dimensionResource(appWidgetBackground.getShape().getBottomLeftRadius(), composer, 0) * f5), C2256Dp.m20968constructorimpl(PrimitiveResources_androidKt.dimensionResource(appWidgetBackground.getShape().getBottomRightRadius(), composer, 0) * f5), composer, 0, 0);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(102444472);
                m21813BlurViewaqJV_2Y(f, f4, C2256Dp.m20968constructorimpl(f6 * f5), 0.0f, 0.0f, 0.0f, composer, 0, 56);
                composer.endReplaceableGroup();
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    private static final boolean ComposeTopLevelLayout$Blur$isShowWindowWallpaper(Context context) {
        Activity activity = getActivity(context);
        if (activity == null) {
            return false;
        }
        Resources.Theme theme = activity.getTheme();
        TypedValue typedValue = new TypedValue();
        return theme.resolveAttribute(R.attr.windowShowWallpaper, typedValue, true) && typedValue.data != 0;
    }

    @Composable
    /* JADX INFO: renamed from: adjustDpValueForAntialiasing-8Feqmps, reason: not valid java name */
    private static final float m21815adjustDpValueForAntialiasing8Feqmps(float f, Composer composer, int i) {
        composer.startReplaceableGroup(12789469);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(12789469, i, -1, "androidx.glance.oneui.template.layout.compose.adjustDpValueForAntialiasing (TopLevelLayout.kt:344)");
        }
        Density density = (Density) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
        float fMo15542toDpu2uoSUM = density.mo15542toDpu2uoSUM(density.mo15546toPx0680j_4(f) - 2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return fMo15542toDpu2uoSUM;
    }

    private static final Activity getActivity(Context context) {
        while (context instanceof ContextThemeWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextThemeWrapper) context).getBaseContext();
            Intrinsics.checkNotNullExpressionValue(context, "getBaseContext(...)");
        }
        return null;
    }

    public static final float getContentScale(@NotNull Bundle appWidgetOptions) {
        Intrinsics.checkNotNullParameter(appWidgetOptions, "appWidgetOptions");
        if (SettingPreviewUtilsKt.isEasyMode(appWidgetOptions)) {
            if (SettingPreviewUtilsKt.getColumnSpan(appWidgetOptions) >= 3) {
                return SettingPreviewUtilsKt.getRowSpan(appWidgetOptions) <= 3 ? 0.8f : 0.6f;
            }
            return 1.0f;
        }
        if (SettingPreviewUtilsKt.getColumnSpan(appWidgetOptions) >= 4) {
            return SettingPreviewUtilsKt.getRowSpan(appWidgetOptions) <= 4 ? 0.8f : 0.6f;
        }
        return 1.0f;
    }

    /* JADX INFO: renamed from: setBlur-qDBjuR0, reason: not valid java name */
    public static final void m21816setBlurqDBjuR0(@NotNull View setBlur, float f, float f4, float f5, float f6) {
        Intrinsics.checkNotNullParameter(setBlur, "$this$setBlur");
        try {
            boolean z = (setBlur.getContext().getResources().getConfiguration().uiMode & 48) == 32;
            if (!SemFloatingFeature.getInstance().getBoolean("SEC_FLOATING_FEATURE_GRAPHICS_SUPPORT_3D_SURFACE_TRANSITION_FLAG")) {
                GlanceLog.INSTANCE.m2301i(TAG, "Models that don't support Real-Time Blur won't show Blur in the preview of Widget Settings.");
                return;
            }
            SemBlurInfo.Builder builder = new SemBlurInfo.Builder(0);
            Context context = setBlur.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            float fM21817toPixel3ABfNKs = m21817toPixel3ABfNKs(context, f);
            Context context2 = setBlur.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            float fM21817toPixel3ABfNKs2 = m21817toPixel3ABfNKs(context2, f4);
            Context context3 = setBlur.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
            float fM21817toPixel3ABfNKs3 = m21817toPixel3ABfNKs(context3, f5);
            Context context4 = setBlur.getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
            builder.setBackgroundCornerRadius(fM21817toPixel3ABfNKs, fM21817toPixel3ABfNKs2, fM21817toPixel3ABfNKs3, m21817toPixel3ABfNKs(context4, f6));
            float[] fArr = z ? BLUR_PRESET[1] : BLUR_PRESET[0];
            SemBlurInfo semBlurInfoBuild = builder.setRadius((int) fArr[0]).setColorCurve(fArr[1], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6]).build();
            Intrinsics.checkNotNullExpressionValue(semBlurInfoBuild, "build(...)");
            setBlur.semSetBlurInfo(semBlurInfoBuild);
        } catch (Exception e) {
            GlanceLog.INSTANCE.m2300e(TAG, "Fail to apply blur effect", e);
        } catch (Throwable th) {
            GlanceLog.INSTANCE.m2300e(TAG, "Fail to apply blur effect", th);
        }
    }

    /* JADX INFO: renamed from: toPixel-3ABfNKs, reason: not valid java name */
    private static final float m21817toPixel3ABfNKs(Context context, float f) {
        return TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }
}
