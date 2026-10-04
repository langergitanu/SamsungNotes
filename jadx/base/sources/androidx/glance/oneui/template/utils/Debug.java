package androidx.glance.oneui.template.utils;

import android.graphics.Paint;
import androidx.annotation.RestrictTo;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.draw.DrawModifierKt;
import androidx.compose.p109ui.geometry.OffsetKt;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.p109ui.graphics.AndroidPaint_androidKt;
import androidx.compose.p109ui.graphics.Canvas;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.p109ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p109ui.graphics.drawscope.DrawScope;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.AbstractC2821a;
import androidx.glance.AndroidResourceImageProvider;
import androidx.glance.BackgroundKt;
import androidx.glance.ColorFilter;
import androidx.glance.GlanceModifier;
import androidx.glance.appwidget.AppWidgetModifiersKt;
import androidx.glance.appwidget.animation.RemoteAnimation;
import androidx.glance.layout.Alignment;
import androidx.glance.layout.BoxKt;
import androidx.glance.layout.HeightModifier;
import androidx.glance.layout.SizeModifiersKt;
import androidx.glance.layout.WidthModifier;
import androidx.glance.oneui.template.C3094R;
import androidx.glance.oneui.template.TextData;
import androidx.glance.oneui.template.component.glance.TextKt;
import androidx.glance.text.FontFamily;
import androidx.glance.text.FontWeight;
import androidx.glance.text.TextDecoration;
import androidx.glance.text.TextShadowStyle;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.ColorProviderKt;
import androidx.glance.unit.Dimension;
import com.samsung.android.imagetranslation.common.LttEngineErrors;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0003¢\u0006\u0002\u0010\u0007JJ\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00040\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0015H\u0002J \u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J \u0010\u0019\u001a\u00020\u00042\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00040\u0011¢\u0006\u0002\b\u0012H\u0003¢\u0006\u0002\u0010\u001aJ%\u0010\u001b\u001a\u0004\u0018\u00010\u00062\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0002¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020 H\u0002J\b\u0010%\u001a\u00020 H\u0002J\b\u0010&\u001a\u00020\u000fH\u0002J\u0016\u0010\b\u001a\u00020'*\u00020'2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006J\f\u0010(\u001a\u00020\u000f*\u00020\nH\u0002¨\u0006)"}, m13886d2 = {"Landroidx/glance/oneui/template/utils/Debug;", "", "()V", "addDebugText", "", "text", "", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "debugBox", "modifier", "Landroidx/glance/GlanceModifier;", "contentAlignment", "Landroidx/glance/layout/Alignment;", "debugText", "debugOnly", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/glance/GlanceModifier;Landroidx/glance/layout/Alignment;Ljava/lang/String;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "drawGrid", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "drawText", "size", "", "fillGrid", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "getCaller", "callStack", "", "Ljava/lang/StackTraceElement;", DBSchema.CategoryTreeClosure.DEPTH, "", "([Ljava/lang/StackTraceElement;I)Ljava/lang/String;", "getCallers", "getComplementaryColor", "color", "getRandomColor", "isDebugLayoutGlanceEnabled", "Landroidx/compose/ui/Modifier;", "hasFillMaxSize", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nDebug.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Debug.kt\nandroidx/glance/oneui/template/utils/Debug\n+ 2 DrawScope.kt\nandroidx/compose/ui/graphics/drawscope/DrawScopeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,243:1\n246#2:244\n1549#3:245\n1620#3,3:246\n1549#3:249\n1620#3,3:250\n1855#3,2:253\n1855#3,2:255\n*S KotlinDebug\n*F\n+ 1 Debug.kt\nandroidx/glance/oneui/template/utils/Debug\n*L\n192#1:244\n223#1:245\n223#1:246,3\n224#1:249\n224#1:250,3\n225#1:253,2\n233#1:255,2\n*E\n"})
public final class Debug {
    public static final int $stable = 0;

    @NotNull
    public static final Debug INSTANCE = new Debug();

    private Debug() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public final void addDebugText(final String str, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1247059308);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(this) ? 32 : 16;
        }
        if ((i2 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1247059308, i2, -1, "androidx.glance.oneui.template.utils.Debug.addDebugText (Debug.kt:161)");
            }
            final int randomColor = getRandomColor();
            BoxKt.Box(AppWidgetModifiersKt.keepColor(SizeModifiersKt.wrapContentSize(BackgroundKt.m21250background4WTKRHQ(GlanceModifier.INSTANCE, ColorKt.Color(getComplementaryColor(randomColor)))), true), null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1714650038, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.utils.Debug.addDebugText.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                @Composable
                public final void invoke(@Nullable Composer composer2, int i4) {
                    if ((i4 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1714650038, i4, -1, "androidx.glance.oneui.template.utils.Debug.addDebugText.<anonymous> (Debug.kt:168)");
                    }
                    TextKt.m21752GlanceTextFbLeKfk(new TextData(str, (ColorProvider) null, 0, (TextDecoration) null, 0, (FontFamily) null, 0, false, false, (TextShadowStyle) null, (String) null, (RemoteAnimation) null, false, 0, 0, 32766, (DefaultConstructorMarker) null), C2256Dp.m20968constructorimpl(8), FontWeight.INSTANCE.m21998getNormalWjrlUT0(), ColorProviderKt.m22055ColorProvider8_81llA(Color.m18524copywmQWz5c$default(ColorKt.Color(randomColor), 0.5f, 0.0f, 0.0f, 0.0f, 14, null)), AppWidgetModifiersKt.keepColor(GlanceModifier.INSTANCE, true), composer2, 4152, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composerStartRestartGroup, 384, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.utils.Debug.addDebugText.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i4) {
                    Debug.this.addDebugText(str, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static /* synthetic */ Modifier debugBox$default(Debug debug, Modifier modifier, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return debug.debugBox(modifier, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void drawGrid(ContentDrawScope content) {
        int randomColor = getRandomColor();
        Float fValueOf = Float.valueOf(0.0f);
        Float fValueOf2 = Float.valueOf(0.25f);
        Float fValueOf3 = Float.valueOf(0.5f);
        Float fValueOf4 = Float.valueOf(0.75f);
        Float fValueOf5 = Float.valueOf(1.0f);
        List listListOf = CollectionsKt.listOf((Object[]) new Float[]{fValueOf, fValueOf2, fValueOf3, fValueOf4, fValueOf5});
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(listListOf));
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(Size.m18353getWidthimpl(content.mo19076getSizeNHjbRc()) * ((Number) it.next()).floatValue()));
        }
        List listListOf2 = CollectionsKt.listOf((Object[]) new Float[]{fValueOf, fValueOf2, fValueOf3, fValueOf4, fValueOf5});
        ArrayList arrayList2 = new ArrayList(CollectionsKt.m13952k(listListOf2));
        Iterator it2 = listListOf2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Float.valueOf(Size.m18350getHeightimpl(content.mo19076getSizeNHjbRc()) * ((Number) it2.next()).floatValue()));
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            float fFloatValue = ((Number) it3.next()).floatValue();
            DrawScope.m19062drawLineNGM6Ib0$default(content, ColorKt.Color(randomColor), OffsetKt.Offset(fFloatValue, 0.0f), OffsetKt.Offset(fFloatValue, Size.m18350getHeightimpl(content.mo19076getSizeNHjbRc())), 1.0f, 0, null, 0.0f, null, 0, 496, null);
        }
        Iterator it4 = arrayList2.iterator();
        while (it4.hasNext()) {
            float fFloatValue2 = ((Number) it4.next()).floatValue();
            DrawScope.m19062drawLineNGM6Ib0$default(content, ColorKt.Color(randomColor), OffsetKt.Offset(0.0f, fFloatValue2), OffsetKt.Offset(Size.m18353getWidthimpl(content.mo19076getSizeNHjbRc()), fFloatValue2), 1.0f, 0, null, 0.0f, null, 0, 496, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void drawText(ContentDrawScope content, String debugText, float size) {
        Canvas canvas = content.getDrawContext().getCanvas();
        Debug debug = INSTANCE;
        int randomColor = debug.getRandomColor();
        Paint paint = new Paint();
        paint.setColor(randomColor);
        paint.setTextSize(size);
        paint.setTextAlign(Paint.Align.CENTER);
        float fMeasureText = paint.measureText(debugText);
        float f = 2;
        float fM18353getWidthimpl = Size.m18353getWidthimpl(content.mo19076getSizeNHjbRc()) / f;
        float fM18350getHeightimpl = (Size.m18350getHeightimpl(content.mo19076getSizeNHjbRc()) / f) - ((paint.ascent() + paint.descent()) / f);
        float f4 = fMeasureText / f;
        Rect rect = new Rect(fM18353getWidthimpl - f4, paint.ascent() + fM18350getHeightimpl, f4 + fM18353getWidthimpl, paint.descent() + fM18350getHeightimpl);
        androidx.compose.p109ui.graphics.Paint Paint = AndroidPaint_androidKt.Paint();
        Paint.mo18404setColor8_81llA(ColorKt.Color(debug.getComplementaryColor(randomColor)));
        Unit unit = Unit.INSTANCE;
        canvas.drawRect(rect, Paint);
        AndroidCanvas_androidKt.getNativeCanvas(canvas).drawText(debugText, fM18353getWidthimpl, fM18350getHeightimpl, paint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public final void fillGrid(final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1439160327);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(this) ? 32 : 16;
        }
        if ((i2 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1439160327, i2, -1, "androidx.glance.oneui.template.utils.Debug.fillGrid (Debug.kt:143)");
            }
            BoxKt.Box(AppWidgetModifiersKt.keepColor(BackgroundKt.m21252backgroundPLcKuY0$default(GlanceModifier.INSTANCE, new AndroidResourceImageProvider(C3094R.drawable.grid), 0, ColorFilter.INSTANCE.tint(ColorProviderKt.m22055ColorProvider8_81llA(Color.m18524copywmQWz5c$default(ColorKt.Color(getRandomColor()), 0.5f, 0.0f, 0.0f, 0.0f, 14, null))), 2, null), true), Alignment.INSTANCE.getCenterEnd(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1704419991, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.utils.Debug.fillGrid.1
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

                @Composable
                public final void invoke(@Nullable Composer composer2, int i4) {
                    if ((i4 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1704419991, i4, -1, "androidx.glance.oneui.template.utils.Debug.fillGrid.<anonymous> (Debug.kt:156)");
                    }
                    if (AbstractC1038a.m1196A(composer2, 0, function2)) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composerStartRestartGroup, (Alignment.$stable << 3) | 384, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.utils.Debug.fillGrid.2
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

                public final void invoke(@Nullable Composer composer2, int i4) {
                    Debug.this.fillGrid(function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private final String getCaller(StackTraceElement[] callStack, int depth) {
        int i = depth + 4;
        if (i >= callStack.length) {
            return "<bottom of call stack>";
        }
        StackTraceElement stackTraceElement = callStack[i];
        return stackTraceElement.getClassName() + Extension.DOT + stackTraceElement.getMethodName() + ":" + stackTraceElement.getLineNumber();
    }

    private final int getComplementaryColor(int color) {
        float[] fArr = new float[3];
        android.graphics.Color.colorToHSV(color, fArr);
        fArr[0] = (fArr[0] + 180) % PopOverActivityWrapper.DEFAULT_WIDTH;
        return android.graphics.Color.HSVToColor(220, fArr);
    }

    private final int getRandomColor() {
        double d = 256;
        return android.graphics.Color.rgb((int) (Math.random() * d), (int) (Math.random() * d), (int) (Math.random() * d));
    }

    private final boolean hasFillMaxSize(GlanceModifier glanceModifier) {
        return glanceModifier.any(new Function1<GlanceModifier.Element, Boolean>() { // from class: androidx.glance.oneui.template.utils.Debug$hasFillMaxSize$hasWidthFill$1
            /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Boolean invoke(@NotNull GlanceModifier.Element element) {
                boolean z;
                Intrinsics.checkNotNullParameter(element, "element");
                if (element instanceof WidthModifier) {
                    WidthModifier widthModifier = (WidthModifier) element;
                    z = Intrinsics.areEqual(widthModifier.getWidth(), Dimension.Fill.INSTANCE) || Intrinsics.areEqual(widthModifier.getWidth(), Dimension.Wrap.INSTANCE) || (widthModifier.getWidth() instanceof Dimension.C3532Dp);
                }
                return Boolean.valueOf(z);
            }
        }) && glanceModifier.any(new Function1<GlanceModifier.Element, Boolean>() { // from class: androidx.glance.oneui.template.utils.Debug.hasFillMaxSize.1
            /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Boolean invoke(@NotNull GlanceModifier.Element element) {
                boolean z;
                Intrinsics.checkNotNullParameter(element, "element");
                if (element instanceof HeightModifier) {
                    HeightModifier heightModifier = (HeightModifier) element;
                    z = Intrinsics.areEqual(heightModifier.getHeight(), Dimension.Fill.INSTANCE) || Intrinsics.areEqual(heightModifier.getHeight(), Dimension.Wrap.INSTANCE) || (heightModifier.getHeight() instanceof Dimension.C3532Dp);
                }
                return Boolean.valueOf(z);
            }
        });
    }

    private final boolean isDebugLayoutGlanceEnabled() {
        try {
            Object objInvoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, "debug.layout.glance");
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.String");
            return Intrinsics.areEqual((String) objInvoke, "true");
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0122  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.glance.GlanceComposable[androidx.glance.GlanceComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void debugBox(@Nullable GlanceModifier glanceModifier, @Nullable Alignment alignment, @Nullable String str, boolean z, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        GlanceModifier glanceModifier2;
        int i4;
        Alignment alignment2;
        String str2;
        int i5;
        boolean z2;
        final GlanceModifier glanceModifier3;
        boolean z3;
        final Alignment alignment3;
        final String str3;
        String str4;
        final GlanceModifier glanceModifier4;
        final String str5;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i6;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-64107199);
        int i7 = i2 & 1;
        if (i7 != 0) {
            i4 = i | 6;
            glanceModifier2 = glanceModifier;
        } else if ((i & 14) == 0) {
            glanceModifier2 = glanceModifier;
            i4 = (composerStartRestartGroup.changed(glanceModifier2) ? 4 : 2) | i;
        } else {
            glanceModifier2 = glanceModifier;
            i4 = i;
        }
        if ((i & 112) == 0) {
            if ((i2 & 2) == 0) {
                alignment2 = alignment;
                int i8 = composerStartRestartGroup.changed(alignment2) ? 32 : 16;
                i4 |= i8;
            } else {
                alignment2 = alignment;
            }
            i4 |= i8;
        } else {
            alignment2 = alignment;
        }
        int i9 = i2 & 4;
        if (i9 != 0) {
            i4 |= 384;
        } else {
            if ((i & 896) == 0) {
                str2 = str;
                i4 |= composerStartRestartGroup.changed(str2) ? 256 : 128;
            }
            i5 = i2 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 7168) == 0) {
                    z2 = z;
                    i4 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
                if ((i2 & 16) != 0) {
                    i4 |= 24576;
                } else if ((57344 & i) == 0) {
                    i4 |= composerStartRestartGroup.changedInstance(content) ? 16384 : 8192;
                }
                if ((i2 & 32) == 0) {
                    i6 = (458752 & i) == 0 ? composerStartRestartGroup.changed(this) ? 131072 : 65536 : 196608;
                    if ((374491 & i4) == 74898 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            GlanceModifier glanceModifier5 = i7 == 0 ? GlanceModifier.INSTANCE : glanceModifier2;
                            if ((i2 & 2) != 0) {
                                Alignment topStart = Alignment.INSTANCE.getTopStart();
                                i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                                alignment2 = topStart;
                            }
                            if (i9 != 0) {
                                str2 = null;
                            }
                            if (i5 == 0) {
                                glanceModifier3 = glanceModifier5;
                                z3 = false;
                                alignment3 = alignment2;
                                str3 = str2;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-64107199, i4, -1, "androidx.glance.oneui.template.utils.Debug.debugBox (Debug.kt:111)");
                                }
                                if (isDebugLayoutGlanceEnabled()) {
                                    str4 = str3;
                                    if (z3) {
                                        composerStartRestartGroup.startReplaceableGroup(1729455465);
                                        AbstractC1038a.m1198C(composerStartRestartGroup, (i4 >> 12) & 14, content);
                                    } else {
                                        composerStartRestartGroup.startReplaceableGroup(1729455511);
                                        BoxKt.Box(glanceModifier3, alignment3, content, composerStartRestartGroup, (i4 & 14) | (Alignment.$stable << 3) | (i4 & 112) | ((i4 >> 6) & 896), 0);
                                        composerStartRestartGroup.endReplaceableGroup();
                                    }
                                } else {
                                    composerStartRestartGroup.startReplaceableGroup(1729454578);
                                    if (hasFillMaxSize(glanceModifier3)) {
                                        composerStartRestartGroup.startReplaceableGroup(1729454623);
                                        fillGrid(ComposableLambdaKt.composableLambda(composerStartRestartGroup, -887045003, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.utils.Debug.debugBox.1
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

                                            @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                                            @Composable
                                            public final void invoke(@Nullable Composer composer2, int i10) {
                                                if ((i10 & 11) == 2 && composer2.getSkipping()) {
                                                    composer2.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-887045003, i10, -1, "androidx.glance.oneui.template.utils.Debug.debugBox.<anonymous> (Debug.kt:115)");
                                                }
                                                BoxKt.Box(glanceModifier3, alignment3, content, composer2, Alignment.$stable << 3, 0);
                                                String str6 = str3;
                                                if (str6 != null) {
                                                    Debug.INSTANCE.addDebugText(str6, composer2, 48);
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }), composerStartRestartGroup, ((i4 >> 12) & 112) | 6);
                                        composerStartRestartGroup.endReplaceableGroup();
                                        str4 = str3;
                                    } else {
                                        composerStartRestartGroup.startReplaceableGroup(1729454806);
                                        str4 = str3;
                                        BoxKt.Box(AppWidgetModifiersKt.keepColor(BackgroundKt.m21252backgroundPLcKuY0$default(glanceModifier3, new AndroidResourceImageProvider(C3094R.drawable.grid), 0, ColorFilter.INSTANCE.tint(ColorProviderKt.m22055ColorProvider8_81llA(Color.m18524copywmQWz5c$default(ColorKt.Color(getRandomColor()), 0.5f, 0.0f, 0.0f, 0.0f, 14, null))), 2, null), true), alignment3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -983713276, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.utils.Debug.debugBox.2
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

                                            @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                                            @Composable
                                            public final void invoke(@Nullable Composer composer2, int i10) {
                                                if ((i10 & 11) == 2 && composer2.getSkipping()) {
                                                    composer2.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-983713276, i10, -1, "androidx.glance.oneui.template.utils.Debug.debugBox.<anonymous> (Debug.kt:131)");
                                                }
                                                content.invoke(composer2, 0);
                                                String str6 = str3;
                                                if (str6 != null) {
                                                    Debug.INSTANCE.addDebugText(str6, composer2, 48);
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }), composerStartRestartGroup, (Alignment.$stable << 3) | 384 | (i4 & 112), 0);
                                        composerStartRestartGroup.endReplaceableGroup();
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                glanceModifier4 = glanceModifier3;
                                str5 = str4;
                                z4 = z3;
                            } else {
                                glanceModifier3 = glanceModifier5;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 2) != 0) {
                                i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                            }
                            glanceModifier3 = glanceModifier2;
                        }
                        alignment3 = alignment2;
                        str3 = str2;
                        z3 = z2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        if (isDebugLayoutGlanceEnabled()) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        glanceModifier4 = glanceModifier3;
                        str5 = str4;
                        z4 = z3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        glanceModifier4 = glanceModifier2;
                        alignment3 = alignment2;
                        str5 = str2;
                        z4 = z2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.utils.Debug.debugBox.3
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

                            public final void invoke(@Nullable Composer composer2, int i10) {
                                Debug.this.debugBox(glanceModifier4, alignment3, str5, z4, content, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                i4 |= i6;
                if ((374491 & i4) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i7 == 0) {
                        }
                        if ((i2 & 2) != 0) {
                        }
                        if (i9 != 0) {
                        }
                        if (i5 == 0) {
                        }
                    }
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i2 & 16) != 0) {
            }
            if ((i2 & 32) == 0) {
            }
            i4 |= i6;
            if ((374491 & i4) == 74898) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        str2 = str;
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        z2 = z;
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) == 0) {
        }
        i4 |= i6;
        if ((374491 & i4) == 74898) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    @Nullable
    public final String getCallers(int depth) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringBuilder sb = new StringBuilder();
        int iM2213d = 0;
        while (iM2213d < depth) {
            Intrinsics.checkNotNull(stackTrace);
            iM2213d = AbstractC2821a.m2213d(sb, iM2213d, 1, getCaller(stackTrace, iM2213d), " ");
        }
        return sb.toString();
    }

    @NotNull
    public final Modifier debugBox(@NotNull Modifier modifier, @Nullable final String str) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return !isDebugLayoutGlanceEnabled() ? modifier : modifier.then(DrawModifierKt.drawWithContent(Modifier.INSTANCE, new Function1<ContentDrawScope, Unit>() { // from class: androidx.glance.oneui.template.utils.Debug.debugBox.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ContentDrawScope drawWithContent) {
                Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
                drawWithContent.drawContent();
                Debug debug = Debug.INSTANCE;
                debug.drawGrid(drawWithContent);
                String str2 = str;
                if (str2 != null) {
                    debug.drawText(drawWithContent, str2, drawWithContent.mo15546toPx0680j_4(C2256Dp.m20968constructorimpl(8)));
                }
            }
        }));
    }
}
