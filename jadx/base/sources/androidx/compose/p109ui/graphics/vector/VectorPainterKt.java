package androidx.compose.p109ui.graphics.vector;

import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.geometry.SizeKt;
import androidx.compose.p109ui.graphics.BlendMode;
import androidx.compose.p109ui.graphics.Brush;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorFilter;
import androidx.compose.p109ui.graphics.drawscope.DrawContext;
import androidx.compose.p109ui.graphics.drawscope.DrawScope;
import androidx.compose.p109ui.graphics.vector.VectorProperty;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.runtime.AbstractC1974b;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableOpenTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.google.android.gms.drive.DriveFile;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a+\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\u0010\t\u001a$\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0000\u001a*\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u0015\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010$\u001a\u0096\u0001\u0010\"\u001a\u00020\u00132\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010(\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2@\u0010)\u001a<\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b+\u0012\b\b(\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b+\u0012\b\b(\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00030*¢\u0006\u0002\b,¢\u0006\u0002\b-H\u0007ø\u0001\u0000¢\u0006\u0004\b.\u0010/\u001a \u0001\u0010\"\u001a\u00020\u00132\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010(\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u0002012@\u0010)\u001a<\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b+\u0012\b\b(\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b+\u0012\b\b(\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00030*¢\u0006\u0002\b,¢\u0006\u0002\b-H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001aD\u00104\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\u001b2\b\b\u0002\u0010(\u001a\u00020\u00012\b\u00106\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u00100\u001a\u000201H\u0000ø\u0001\u0000¢\u0006\u0004\b7\u00108\u001a\u0014\u00109\u001a\u00020\u0019*\u00020\u00192\u0006\u0010:\u001a\u00020\u0005H\u0000\u001a&\u0010;\u001a\u00020\u0003*\u00020<2\u0017\u0010=\u001a\u0013\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u00030>¢\u0006\u0002\b?H\u0082\b\u001a&\u0010@\u001a\u00020\u001b*\u00020\u00152\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0002ø\u0001\u0000¢\u0006\u0004\bA\u0010B\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006C"}, m13886d2 = {"RootGroupName", "", "RenderVectorGroup", "", "group", "Landroidx/compose/ui/graphics/vector/VectorGroup;", "configs", "", "Landroidx/compose/ui/graphics/vector/VectorConfig;", "(Landroidx/compose/ui/graphics/vector/VectorGroup;Ljava/util/Map;Landroidx/compose/runtime/Composer;II)V", "createColorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "tintColor", "Landroidx/compose/ui/graphics/Color;", "tintBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "createColorFilter-xETnrds", "(JI)Landroidx/compose/ui/graphics/ColorFilter;", "createVectorPainterFromImageVector", "Landroidx/compose/ui/graphics/vector/VectorPainter;", "density", "Landroidx/compose/ui/unit/Density;", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "root", "Landroidx/compose/ui/graphics/vector/GroupComponent;", "obtainViewportSize", "Landroidx/compose/ui/geometry/Size;", "defaultSize", "viewportWidth", "", "viewportHeight", "obtainViewportSize-Pq9zytI", "(JFF)J", "rememberVectorPainter", "image", "(Landroidx/compose/ui/graphics/vector/ImageVector;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/vector/VectorPainter;", "defaultWidth", "Landroidx/compose/ui/unit/Dp;", "defaultHeight", "name", "content", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/graphics/vector/VectorComposable;", "rememberVectorPainter-mlNsNFs", "(FFFFLjava/lang/String;JILkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/graphics/vector/VectorPainter;", "autoMirror", "", "rememberVectorPainter-vIP8VLU", "(FFFFLjava/lang/String;JIZLkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/graphics/vector/VectorPainter;", "configureVectorPainter", "viewportSize", "intrinsicColorFilter", "configureVectorPainter-T4PVSW8", "(Landroidx/compose/ui/graphics/vector/VectorPainter;JJLjava/lang/String;Landroidx/compose/ui/graphics/ColorFilter;Z)Landroidx/compose/ui/graphics/vector/VectorPainter;", "createGroupComponent", "currentGroup", "mirror", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "obtainSizePx", "obtainSizePx-VpY3zN4", "(Landroidx/compose/ui/unit/Density;FF)J", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVectorPainter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VectorPainter.kt\nandroidx/compose/ui/graphics/vector/VectorPainterKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 4 InlineClassHelper.kt\nandroidx/compose/ui/util/InlineClassHelperKt\n+ 5 DrawScope.kt\nandroidx/compose/ui/graphics/drawscope/DrawScopeKt\n+ 6 Color.kt\nandroidx/compose/ui/graphics/ColorKt\n*L\n1#1,520:1\n77#2:521\n77#2:540\n1225#3,6:522\n1225#3,6:528\n1225#3,6:534\n1225#3,6:544\n63#4,3:541\n184#5,6:550\n272#5,14:556\n696#6:570\n*S KotlinDebug\n*F\n+ 1 VectorPainter.kt\nandroidx/compose/ui/graphics/vector/VectorPainterKt\n*L\n132#1:521\n173#1:540\n135#1:522,6\n138#1:528,6\n147#1:534,6\n175#1:544,6\n174#1:541,3\n270#1:550,6\n270#1:556,14\n330#1:570\n*E\n"})
public final class VectorPainterKt {

    @NotNull
    public static final String RootGroupName = "VectorRootGroup";

    /* JADX WARN: Removed duplicated region for block: B:30:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    @ComposableTarget(applier = "androidx.compose.ui.graphics.vector.VectorComposable")
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void RenderVectorGroup(@NotNull final VectorGroup vectorGroup, @Nullable Map<String, ? extends VectorConfig> map, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        final Map<String, ? extends VectorConfig> map2;
        Iterator<VectorNode> it;
        Map<String, ? extends VectorConfig> map3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-446179233);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(vectorGroup) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i5 = i2 & 2;
        if (i5 == 0) {
            if ((i & 48) == 0) {
                map2 = map;
                i4 |= composerStartRestartGroup.changedInstance(map2) ? 32 : 16;
            }
            if ((i4 & 19) == 18 || !composerStartRestartGroup.getSkipping()) {
                Map<String, ? extends VectorConfig> mapEmptyMap = i5 == 0 ? MapsKt.emptyMap() : map2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-446179233, i4, -1, "androidx.compose.ui.graphics.vector.RenderVectorGroup (VectorPainter.kt:430)");
                }
                it = vectorGroup.iterator();
                while (it.hasNext()) {
                    final VectorNode next = it.next();
                    if (next instanceof VectorPath) {
                        composerStartRestartGroup.startReplaceGroup(-23647808);
                        VectorPath vectorPath = (VectorPath) next;
                        VectorConfig vectorConfig = mapEmptyMap.get(vectorPath.getName());
                        if (vectorConfig == null) {
                            vectorConfig = new VectorConfig() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$config$1
                            };
                        }
                        Composer composer2 = composerStartRestartGroup;
                        VectorComposeKt.m19223Path9cdaXJ4((List) vectorConfig.getOrDefault(VectorProperty.PathData.INSTANCE, vectorPath.getPathData()), vectorPath.getPathFillType(), vectorPath.getName(), (Brush) vectorConfig.getOrDefault(VectorProperty.Fill.INSTANCE, vectorPath.getFill()), ((Number) vectorConfig.getOrDefault(VectorProperty.FillAlpha.INSTANCE, Float.valueOf(vectorPath.getFillAlpha()))).floatValue(), (Brush) vectorConfig.getOrDefault(VectorProperty.Stroke.INSTANCE, vectorPath.getStroke()), ((Number) vectorConfig.getOrDefault(VectorProperty.StrokeAlpha.INSTANCE, Float.valueOf(vectorPath.getStrokeAlpha()))).floatValue(), ((Number) vectorConfig.getOrDefault(VectorProperty.StrokeLineWidth.INSTANCE, Float.valueOf(vectorPath.getStrokeLineWidth()))).floatValue(), vectorPath.getStrokeLineCap(), vectorPath.getStrokeLineJoin(), vectorPath.getStrokeLineMiter(), ((Number) vectorConfig.getOrDefault(VectorProperty.TrimPathStart.INSTANCE, Float.valueOf(vectorPath.getTrimPathStart()))).floatValue(), ((Number) vectorConfig.getOrDefault(VectorProperty.TrimPathEnd.INSTANCE, Float.valueOf(vectorPath.getTrimPathEnd()))).floatValue(), ((Number) vectorConfig.getOrDefault(VectorProperty.TrimPathOffset.INSTANCE, Float.valueOf(vectorPath.getTrimPathOffset()))).floatValue(), composer2, 0, 0, 0);
                        composerStartRestartGroup = composer2;
                        composerStartRestartGroup.endReplaceGroup();
                        mapEmptyMap = mapEmptyMap;
                        it = it;
                    } else {
                        Iterator<VectorNode> it2 = it;
                        final Map<String, ? extends VectorConfig> map4 = mapEmptyMap;
                        if (next instanceof VectorGroup) {
                            composerStartRestartGroup.startReplaceGroup(-21815553);
                            VectorGroup vectorGroup2 = (VectorGroup) next;
                            VectorConfig vectorConfig2 = map4.get(vectorGroup2.getName());
                            if (vectorConfig2 == null) {
                                vectorConfig2 = new VectorConfig() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$config$2
                                };
                            }
                            map3 = map4;
                            VectorComposeKt.Group(vectorGroup2.getName(), ((Number) vectorConfig2.getOrDefault(VectorProperty.Rotation.INSTANCE, Float.valueOf(vectorGroup2.getRotation()))).floatValue(), ((Number) vectorConfig2.getOrDefault(VectorProperty.PivotX.INSTANCE, Float.valueOf(vectorGroup2.getPivotX()))).floatValue(), ((Number) vectorConfig2.getOrDefault(VectorProperty.PivotY.INSTANCE, Float.valueOf(vectorGroup2.getPivotY()))).floatValue(), ((Number) vectorConfig2.getOrDefault(VectorProperty.ScaleX.INSTANCE, Float.valueOf(vectorGroup2.getScaleX()))).floatValue(), ((Number) vectorConfig2.getOrDefault(VectorProperty.ScaleY.INSTANCE, Float.valueOf(vectorGroup2.getScaleY()))).floatValue(), ((Number) vectorConfig2.getOrDefault(VectorProperty.TranslateX.INSTANCE, Float.valueOf(vectorGroup2.getTranslationX()))).floatValue(), ((Number) vectorConfig2.getOrDefault(VectorProperty.TranslateY.INSTANCE, Float.valueOf(vectorGroup2.getTranslationY()))).floatValue(), (List) vectorConfig2.getOrDefault(VectorProperty.PathData.INSTANCE, vectorGroup2.getClipPathData()), ComposableLambdaKt.rememberComposableLambda(1450046638, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt.RenderVectorGroup.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @ComposableTarget(applier = "androidx.compose.ui.graphics.vector.VectorComposable")
                                @Composable
                                public final void invoke(@Nullable Composer composer3, int i6) {
                                    if ((i6 & 3) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1450046638, i6, -1, "androidx.compose.ui.graphics.vector.RenderVectorGroup.<anonymous> (VectorPainter.kt:514)");
                                    }
                                    VectorPainterKt.RenderVectorGroup((VectorGroup) next, map4, composer3, 0, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, DriveFile.MODE_READ_WRITE, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            map3 = map4;
                            composerStartRestartGroup.startReplaceGroup(-20402883);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        it = it2;
                        mapEmptyMap = map3;
                    }
                }
                Map<String, ? extends VectorConfig> map5 = mapEmptyMap;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                map2 = map5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt.RenderVectorGroup.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@Nullable Composer composer3, int i6) {
                        VectorPainterKt.RenderVectorGroup(vectorGroup, map2, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i4 |= 48;
        map2 = map;
        if ((i4 & 19) == 18) {
            if (i5 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            it = vectorGroup.iterator();
            while (it.hasNext()) {
            }
            Map<String, ? extends VectorConfig> map52 = mapEmptyMap;
            if (ComposerKt.isTraceInProgress()) {
            }
            map2 = map52;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    @NotNull
    /* JADX INFO: renamed from: configureVectorPainter-T4PVSW8, reason: not valid java name */
    public static final VectorPainter m19233configureVectorPainterT4PVSW8(@NotNull VectorPainter vectorPainter, long j, long j2, @NotNull String str, @Nullable ColorFilter colorFilter, boolean z) {
        vectorPainter.m19231setSizeuvyYCjk$ui_release(j);
        vectorPainter.setAutoMirror$ui_release(z);
        vectorPainter.setIntrinsicColorFilter$ui_release(colorFilter);
        vectorPainter.m19232setViewportSizeuvyYCjk$ui_release(j2);
        vectorPainter.setName$ui_release(str);
        return vectorPainter;
    }

    /* JADX INFO: renamed from: configureVectorPainter-T4PVSW8$default, reason: not valid java name */
    public static /* synthetic */ VectorPainter m19234configureVectorPainterT4PVSW8$default(VectorPainter vectorPainter, long j, long j2, String str, ColorFilter colorFilter, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            str = RootGroupName;
        }
        return m19233configureVectorPainterT4PVSW8(vectorPainter, j, j2, str, colorFilter, (i & 16) != 0 ? false : z);
    }

    /* JADX INFO: renamed from: createColorFilter-xETnrds, reason: not valid java name */
    private static final ColorFilter m19235createColorFilterxETnrds(long j, int i) {
        if (j != 16) {
            return ColorFilter.INSTANCE.m18569tintxETnrds(j, i);
        }
        return null;
    }

    @NotNull
    public static final GroupComponent createGroupComponent(@NotNull GroupComponent groupComponent, @NotNull VectorGroup vectorGroup) {
        int size = vectorGroup.getSize();
        for (int i = 0; i < size; i++) {
            VectorNode vectorNode = vectorGroup.get(i);
            if (vectorNode instanceof VectorPath) {
                PathComponent pathComponent = new PathComponent();
                VectorPath vectorPath = (VectorPath) vectorNode;
                pathComponent.setPathData(vectorPath.getPathData());
                pathComponent.m19217setPathFillTypeoQ8Xj4U(vectorPath.getPathFillType());
                pathComponent.setName(vectorPath.getName());
                pathComponent.setFill(vectorPath.getFill());
                pathComponent.setFillAlpha(vectorPath.getFillAlpha());
                pathComponent.setStroke(vectorPath.getStroke());
                pathComponent.setStrokeAlpha(vectorPath.getStrokeAlpha());
                pathComponent.setStrokeLineWidth(vectorPath.getStrokeLineWidth());
                pathComponent.m19218setStrokeLineCapBeK7IIE(vectorPath.getStrokeLineCap());
                pathComponent.m19219setStrokeLineJoinWw9F2mQ(vectorPath.getStrokeLineJoin());
                pathComponent.setStrokeLineMiter(vectorPath.getStrokeLineMiter());
                pathComponent.setTrimPathStart(vectorPath.getTrimPathStart());
                pathComponent.setTrimPathEnd(vectorPath.getTrimPathEnd());
                pathComponent.setTrimPathOffset(vectorPath.getTrimPathOffset());
                groupComponent.insertAt(i, pathComponent);
            } else if (vectorNode instanceof VectorGroup) {
                GroupComponent groupComponent2 = new GroupComponent();
                VectorGroup vectorGroup2 = (VectorGroup) vectorNode;
                groupComponent2.setName(vectorGroup2.getName());
                groupComponent2.setRotation(vectorGroup2.getRotation());
                groupComponent2.setScaleX(vectorGroup2.getScaleX());
                groupComponent2.setScaleY(vectorGroup2.getScaleY());
                groupComponent2.setTranslationX(vectorGroup2.getTranslationX());
                groupComponent2.setTranslationY(vectorGroup2.getTranslationY());
                groupComponent2.setPivotX(vectorGroup2.getPivotX());
                groupComponent2.setPivotY(vectorGroup2.getPivotY());
                groupComponent2.setClipPathData(vectorGroup2.getClipPathData());
                createGroupComponent(groupComponent2, vectorGroup2);
                groupComponent.insertAt(i, groupComponent2);
            }
        }
        return groupComponent;
    }

    @NotNull
    public static final VectorPainter createVectorPainterFromImageVector(@NotNull Density density, @NotNull ImageVector imageVector, @NotNull GroupComponent groupComponent) {
        long jM19236obtainSizePxVpY3zN4 = m19236obtainSizePxVpY3zN4(density, imageVector.getDefaultWidth(), imageVector.getDefaultHeight());
        return m19233configureVectorPainterT4PVSW8(new VectorPainter(groupComponent), jM19236obtainSizePxVpY3zN4, m19237obtainViewportSizePq9zytI(jM19236obtainSizePxVpY3zN4, imageVector.getViewportWidth(), imageVector.getViewportHeight()), imageVector.getName(), m19235createColorFilterxETnrds(imageVector.getTintColor(), imageVector.getTintBlendMode()), imageVector.getAutoMirror());
    }

    private static final void mirror(DrawScope drawScope, Function1<? super DrawScope, Unit> function1) {
        long jMo19075getCenterF1C5BW0 = drawScope.mo19075getCenterF1C5BW0();
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo18997getSizeNHjbRc = drawContext.mo18997getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo19004scale0AR0LA0(-1.0f, 1.0f, jMo19075getCenterF1C5BW0);
            function1.invoke(drawScope);
        } finally {
            AbstractC1974b.m1329v(1, drawContext, jMo18997getSizeNHjbRc, 1);
        }
    }

    /* JADX INFO: renamed from: obtainSizePx-VpY3zN4, reason: not valid java name */
    private static final long m19236obtainSizePxVpY3zN4(Density density, float f, float f4) {
        return SizeKt.Size(density.mo15546toPx0680j_4(f), density.mo15546toPx0680j_4(f4));
    }

    /* JADX INFO: renamed from: obtainViewportSize-Pq9zytI, reason: not valid java name */
    private static final long m19237obtainViewportSizePq9zytI(long j, float f, float f4) {
        if (Float.isNaN(f)) {
            f = Size.m18353getWidthimpl(j);
        }
        if (Float.isNaN(f4)) {
            f4 = Size.m18350getHeightimpl(j);
        }
        return SizeKt.Size(f, f4);
    }

    @Composable
    @NotNull
    public static final VectorPainter rememberVectorPainter(@NotNull ImageVector imageVector, @Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1413834416, i, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:171)");
        }
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        float genId = imageVector.getGenId();
        boolean zChanged = composer.changed((((long) Float.floatToRawIntBits(density.getDensity())) & 4294967295L) | (Float.floatToRawIntBits(genId) << 32));
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            GroupComponent groupComponent = new GroupComponent();
            createGroupComponent(groupComponent, imageVector.getRoot());
            Unit unit = Unit.INSTANCE;
            objRememberedValue = createVectorPainterFromImageVector(density, imageVector, groupComponent);
            composer.updateRememberedValue(objRememberedValue);
        }
        VectorPainter vectorPainter = (VectorPainter) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return vectorPainter;
    }

    @ComposableOpenTarget(index = -1)
    @NotNull
    @Deprecated(message = "Replace rememberVectorPainter graphicsLayer that consumes the auto mirror flag", replaceWith = @ReplaceWith(expression = "rememberVectorPainter(defaultWidth, defaultHeight, viewportWidth, viewportHeight, name, tintColor, tintBlendMode, false, content)", imports = {"androidx.compose.ui.graphics.vector"}))
    @Composable
    /* JADX INFO: renamed from: rememberVectorPainter-mlNsNFs, reason: not valid java name */
    public static final VectorPainter m19238rememberVectorPaintermlNsNFs(float f, float f4, float f5, float f6, @Nullable String str, long j, int i, @NotNull Function4<? super Float, ? super Float, ? super Composer, ? super Integer, Unit> function4, @Nullable Composer composer, int i2, int i4) {
        float f7 = (i4 & 4) != 0 ? Float.NaN : f5;
        float f8 = (i4 & 8) != 0 ? Float.NaN : f6;
        String str2 = (i4 & 16) != 0 ? RootGroupName : str;
        long jM18561getUnspecified0d7_KjU = (i4 & 32) != 0 ? Color.INSTANCE.m18561getUnspecified0d7_KjU() : j;
        int iM18465getSrcIn0nO6VwU = (i4 & 64) != 0 ? BlendMode.INSTANCE.m18465getSrcIn0nO6VwU() : i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-964365210, i2, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:86)");
        }
        VectorPainter vectorPainterM19239rememberVectorPaintervIP8VLU = m19239rememberVectorPaintervIP8VLU(f, f4, f7, f8, str2, jM18561getUnspecified0d7_KjU, iM18465getSrcIn0nO6VwU, false, function4, composer, (i2 & 14) | 12582912 | (i2 & 112) | (i2 & 896) | (i2 & 7168) | (57344 & i2) | (458752 & i2) | (3670016 & i2) | ((i2 << 3) & 234881024), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return vectorPainterM19239rememberVectorPaintervIP8VLU;
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x0132  */
    @Composable
    @ComposableOpenTarget(index = -1)
    @NotNull
    /* JADX INFO: renamed from: rememberVectorPainter-vIP8VLU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final VectorPainter m19239rememberVectorPaintervIP8VLU(float f, float f4, float f5, float f6, @Nullable String str, long j, int i, boolean z, @NotNull final Function4<? super Float, ? super Float, ? super Composer, ? super Integer, Unit> function4, @Nullable Composer composer, int i2, int i4) {
        Object obj;
        float f7 = (i4 & 4) != 0 ? Float.NaN : f5;
        float f8 = (i4 & 8) == 0 ? f6 : Float.NaN;
        String str2 = (i4 & 16) != 0 ? RootGroupName : str;
        long jM18561getUnspecified0d7_KjU = (i4 & 32) != 0 ? Color.INSTANCE.m18561getUnspecified0d7_KjU() : j;
        int iM18465getSrcIn0nO6VwU = (i4 & 64) != 0 ? BlendMode.INSTANCE.m18465getSrcIn0nO6VwU() : i;
        boolean z2 = (i4 & 128) != 0 ? false : z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1068590786, i2, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:130)");
        }
        long jM19236obtainSizePxVpY3zN4 = m19236obtainSizePxVpY3zN4((Density) composer.consume(CompositionLocalsKt.getLocalDensity()), f, f4);
        final long jM19237obtainViewportSizePq9zytI = m19237obtainViewportSizePq9zytI(jM19236obtainSizePxVpY3zN4, f7, f8);
        boolean z3 = z2;
        boolean z4 = ((((3670016 & i2) ^ 1572864) > 1048576 && composer.changed(iM18465getSrcIn0nO6VwU)) || (i2 & 1572864) == 1048576) | ((((458752 & i2) ^ 196608) > 131072 && composer.changed(jM18561getUnspecified0d7_KjU)) || (i2 & 196608) == 131072);
        Object objRememberedValue = composer.rememberedValue();
        if (z4 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = m19235createColorFilterxETnrds(jM18561getUnspecified0d7_KjU, iM18465getSrcIn0nO6VwU);
            composer.updateRememberedValue(objRememberedValue);
        }
        ColorFilter colorFilter = (ColorFilter) objRememberedValue;
        composer.startReplaceGroup(-1837510348);
        Object objRememberedValue2 = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = new VectorPainter(null, 1, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        VectorPainter vectorPainter = (VectorPainter) objRememberedValue2;
        m19233configureVectorPainterT4PVSW8(vectorPainter, jM19236obtainSizePxVpY3zN4, jM19237obtainViewportSizePq9zytI, str2, colorFilter, z3);
        CompositionContext compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composer, 0);
        boolean z5 = ((((i2 & 896) ^ 384) > 256 && composer.changed(f7)) || (i2 & 384) == 256) | ((((i2 & 7168) ^ 3072) > 2048 && composer.changed(f8)) || (i2 & 3072) == 2048) | ((((234881024 & i2) ^ 100663296) > 67108864 && composer.changed(function4)) || (i2 & 100663296) == 67108864);
        Object objRememberedValue3 = composer.rememberedValue();
        if (!z5) {
            obj = objRememberedValue3;
            if (objRememberedValue3 == companion.getEmpty()) {
                Composition composition = vectorPainter.getComposition();
                if (composition == null || composition.getDisposed()) {
                    composition = CompositionKt.Composition(new VectorApplier(vectorPainter.getVector().getRoot()), compositionContextRememberCompositionContext);
                }
                Composition composition2 = composition;
                composition2.setContent(ComposableLambdaKt.composableLambdaInstance(-824421385, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt$rememberVectorPainter$2$1$1
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
                    public final void invoke(@Nullable Composer composer2, int i5) {
                        if ((i5 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-824421385, i5, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter.<anonymous>.<anonymous>.<anonymous> (VectorPainter.kt:157)");
                        }
                        function4.invoke(Float.valueOf(Size.m18353getWidthimpl(jM19237obtainViewportSizePq9zytI)), Float.valueOf(Size.m18350getHeightimpl(jM19237obtainViewportSizePq9zytI)), composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }));
                composer.updateRememberedValue(composition2);
                obj = composition2;
            }
        }
        vectorPainter.setComposition$ui_release((Composition) obj);
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return vectorPainter;
    }
}
