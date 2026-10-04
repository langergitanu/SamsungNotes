package androidx.compose.foundation;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.compose.foundation.AndroidExternalSurfaceZOrder;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.p109ui.graphics.Matrix;
import androidx.compose.p109ui.unit.IntSize;
import androidx.compose.p109ui.viewinterop.AndroidView_androidKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aU\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a]\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00052\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\r\u0010\u0016\u001a\u00020\u0017H\u0003¢\u0006\u0002\u0010\u0018\u001a\r\u0010\u0019\u001a\u00020\u001aH\u0003¢\u0006\u0002\u0010\u001b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, m13886d2 = {"AndroidEmbeddedExternalSurface", "", "modifier", "Landroidx/compose/ui/Modifier;", "isOpaque", "", "surfaceSize", "Landroidx/compose/ui/unit/IntSize;", "transform", "Landroidx/compose/ui/graphics/Matrix;", "onInit", "Lkotlin/Function1;", "Landroidx/compose/foundation/AndroidExternalSurfaceScope;", "Lkotlin/ExtensionFunctionType;", "AndroidEmbeddedExternalSurface-sv6N_fY", "(Landroidx/compose/ui/Modifier;ZJ[FLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "AndroidExternalSurface", "zOrder", "Landroidx/compose/foundation/AndroidExternalSurfaceZOrder;", "isSecure", "AndroidExternalSurface-58FFMhA", "(Landroidx/compose/ui/Modifier;ZJIZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "rememberAndroidEmbeddedExternalSurfaceState", "Landroidx/compose/foundation/AndroidEmbeddedExternalSurfaceState;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/AndroidEmbeddedExternalSurfaceState;", "rememberAndroidExternalSurfaceState", "Landroidx/compose/foundation/AndroidExternalSurfaceState;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/AndroidExternalSurfaceState;", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAndroidExternalSurface.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AndroidExternalSurface.android.kt\nandroidx/compose/foundation/AndroidExternalSurface_androidKt\n+ 2 Effects.kt\nandroidx/compose/runtime/EffectsKt\n+ 3 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 4 Effects.kt\nandroidx/compose/runtime/EffectsKt$rememberCoroutineScope$1\n*L\n1#1,478:1\n481#2:479\n480#2,4:480\n484#2,2:487\n488#2:493\n481#2:512\n480#2,4:513\n484#2,2:520\n488#2:526\n1225#3,3:484\n1228#3,3:490\n1225#3,6:494\n1225#3,6:500\n1225#3,6:506\n1225#3,3:517\n1228#3,3:523\n1225#3,6:527\n1225#3,6:533\n480#4:489\n480#4:522\n*S KotlinDebug\n*F\n+ 1 AndroidExternalSurface.android.kt\nandroidx/compose/foundation/AndroidExternalSurface_androidKt\n*L\n191#1:479\n191#1:480,4\n191#1:487,2\n191#1:493\n385#1:512\n385#1:513,4\n385#1:520,2\n385#1:526\n191#1:484,3\n191#1:490,3\n192#1:494,6\n292#1:500,6\n300#1:506,6\n385#1:517,3\n385#1:523,3\n386#1:527,6\n462#1:533,6\n191#1:489\n385#1:522\n*E\n"})
public final class AndroidExternalSurface_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:103:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0128  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: AndroidEmbeddedExternalSurface-sv6N_fY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m15406AndroidEmbeddedExternalSurfacesv6N_fY(@Nullable Modifier modifier, boolean z, long j, @Nullable float[] fArr, @NotNull final Function1<? super AndroidExternalSurfaceScope, Unit> function1, @Nullable Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i4;
        boolean z2;
        long jM21143getZeroYbymL2g;
        int i5;
        Function1<? super AndroidExternalSurfaceScope, Unit> function12;
        Modifier modifier3;
        final float[] fArr2;
        final boolean z3;
        final AndroidEmbeddedExternalSurfaceState androidEmbeddedExternalSurfaceStateRememberAndroidEmbeddedExternalSurfaceState;
        boolean zChangedInstance;
        Object objRememberedValue;
        final long j2;
        final Modifier modifier4;
        final long j3;
        final boolean z4;
        final float[] fArr3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(217541314);
        int i6 = i2 & 1;
        if (i6 != 0) {
            i4 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i4 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i4 = i;
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i4 |= 48;
        } else {
            if ((i & 48) == 0) {
                z2 = z;
                i4 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
            }
            if ((i & 384) != 0) {
                jM21143getZeroYbymL2g = j;
                i4 |= ((i2 & 4) == 0 && composerStartRestartGroup.changed(jM21143getZeroYbymL2g)) ? 256 : 128;
            } else {
                jM21143getZeroYbymL2g = j;
            }
            i5 = i2 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(fArr != null ? Matrix.m18754boximpl(fArr) : null) ? 2048 : 1024;
            }
            if ((i2 & 16) != 0) {
                if ((i & 24576) == 0) {
                    function12 = function1;
                    i4 |= composerStartRestartGroup.changedInstance(function12) ? 16384 : 8192;
                }
                if ((i4 & 9363) == 9362 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    fArr3 = fArr;
                    modifier4 = modifier2;
                    z4 = z2;
                    j3 = jM21143getZeroYbymL2g;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        modifier3 = i6 == 0 ? Modifier.INSTANCE : modifier2;
                        if (i7 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 4) != 0) {
                            i4 &= -897;
                            jM21143getZeroYbymL2g = IntSize.INSTANCE.m21143getZeroYbymL2g();
                        }
                        if (i5 == 0) {
                            z3 = z2;
                            fArr2 = null;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(217541314, i4, -1, "androidx.compose.foundation.AndroidEmbeddedExternalSurface (AndroidExternalSurface.android.kt:454)");
                            }
                            androidEmbeddedExternalSurfaceStateRememberAndroidEmbeddedExternalSurfaceState = rememberAndroidEmbeddedExternalSurfaceState(composerStartRestartGroup, 0);
                            C0764x1320780e c0764x1320780e = new Function1<Context, TextureView>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidEmbeddedExternalSurface$1
                                @Override // kotlin.jvm.functions.Function1
                                @NotNull
                                public final TextureView invoke(@NotNull Context context) {
                                    return new TextureView(context);
                                }
                            };
                            C0765x1320780f c0765x1320780f = new Function1<TextureView, Unit>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidEmbeddedExternalSurface$2
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull TextureView textureView) {
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextureView textureView) {
                                    invoke2(textureView);
                                    return Unit.INSTANCE;
                                }
                            };
                            zChangedInstance = ((((i4 & 896) ^ 384) <= 256 && composerStartRestartGroup.changed(jM21143getZeroYbymL2g)) || (i4 & 384) == 256) | composerStartRestartGroup.changedInstance(androidEmbeddedExternalSurfaceStateRememberAndroidEmbeddedExternalSurfaceState) | ((57344 & i4) == 16384) | ((i4 & 112) == 32) | composerStartRestartGroup.changedInstance(fArr2 != null ? Matrix.m18754boximpl(fArr2) : null);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                j2 = jM21143getZeroYbymL2g;
                                final Function1<? super AndroidExternalSurfaceScope, Unit> function13 = function12;
                                objRememberedValue = new Function1<TextureView, Unit>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidEmbeddedExternalSurface$3$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(TextureView textureView) {
                                        invoke2(textureView);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@NotNull TextureView textureView) {
                                        android.graphics.Matrix matrix;
                                        SurfaceTexture surfaceTexture;
                                        if (!IntSize.m21136equalsimpl0(j2, IntSize.INSTANCE.m21143getZeroYbymL2g()) && (surfaceTexture = textureView.getSurfaceTexture()) != null) {
                                            surfaceTexture.setDefaultBufferSize(IntSize.m21138getWidthimpl(j2), IntSize.m21137getHeightimpl(j2));
                                        }
                                        androidEmbeddedExternalSurfaceStateRememberAndroidEmbeddedExternalSurfaceState.m15395setSurfaceSizeozmzZPI(j2);
                                        TextureView.SurfaceTextureListener surfaceTextureListener = textureView.getSurfaceTextureListener();
                                        AndroidEmbeddedExternalSurfaceState androidEmbeddedExternalSurfaceState = androidEmbeddedExternalSurfaceStateRememberAndroidEmbeddedExternalSurfaceState;
                                        if (surfaceTextureListener != androidEmbeddedExternalSurfaceState) {
                                            function13.invoke(androidEmbeddedExternalSurfaceState);
                                            textureView.setSurfaceTextureListener(androidEmbeddedExternalSurfaceStateRememberAndroidEmbeddedExternalSurfaceState);
                                        }
                                        textureView.setOpaque(z3);
                                        float[] fArr4 = fArr2;
                                        if (fArr4 != null) {
                                            matrix = androidEmbeddedExternalSurfaceStateRememberAndroidEmbeddedExternalSurfaceState.getMatrix();
                                            AndroidMatrixConversions_androidKt.m18395setFromEL8BTi8(matrix, fArr4);
                                        } else {
                                            matrix = null;
                                        }
                                        textureView.setTransform(matrix);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                j2 = jM21143getZeroYbymL2g;
                            }
                            Modifier modifier5 = modifier3;
                            AndroidView_androidKt.AndroidView(c0764x1320780e, modifier5, c0765x1320780f, null, (Function1) objRememberedValue, composerStartRestartGroup, ((i4 << 3) & 112) | 390, 8);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier5;
                            j3 = j2;
                            z4 = z3;
                            fArr3 = fArr2;
                        } else {
                            fArr2 = fArr;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i4 &= -897;
                        }
                        fArr2 = fArr;
                        modifier3 = modifier2;
                    }
                    z3 = z2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    androidEmbeddedExternalSurfaceStateRememberAndroidEmbeddedExternalSurfaceState = rememberAndroidEmbeddedExternalSurfaceState(composerStartRestartGroup, 0);
                    C0764x1320780e c0764x1320780e2 = new Function1<Context, TextureView>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidEmbeddedExternalSurface$1
                        @Override // kotlin.jvm.functions.Function1
                        @NotNull
                        public final TextureView invoke(@NotNull Context context) {
                            return new TextureView(context);
                        }
                    };
                    C0765x1320780f c0765x1320780f2 = new Function1<TextureView, Unit>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidEmbeddedExternalSurface$2
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull TextureView textureView) {
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextureView textureView) {
                            invoke2(textureView);
                            return Unit.INSTANCE;
                        }
                    };
                    if (((i4 & 896) ^ 384) <= 256) {
                        zChangedInstance = ((((i4 & 896) ^ 384) <= 256 && composerStartRestartGroup.changed(jM21143getZeroYbymL2g)) || (i4 & 384) == 256) | composerStartRestartGroup.changedInstance(androidEmbeddedExternalSurfaceStateRememberAndroidEmbeddedExternalSurfaceState) | ((57344 & i4) == 16384) | ((i4 & 112) == 32) | composerStartRestartGroup.changedInstance(fArr2 != null ? Matrix.m18754boximpl(fArr2) : null);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance) {
                            j2 = jM21143getZeroYbymL2g;
                            final Function1<? super AndroidExternalSurfaceScope, Unit> function132 = function12;
                            objRememberedValue = new Function1<TextureView, Unit>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidEmbeddedExternalSurface$3$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextureView textureView) {
                                    invoke2(textureView);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull TextureView textureView) {
                                    android.graphics.Matrix matrix;
                                    SurfaceTexture surfaceTexture;
                                    if (!IntSize.m21136equalsimpl0(j2, IntSize.INSTANCE.m21143getZeroYbymL2g()) && (surfaceTexture = textureView.getSurfaceTexture()) != null) {
                                        surfaceTexture.setDefaultBufferSize(IntSize.m21138getWidthimpl(j2), IntSize.m21137getHeightimpl(j2));
                                    }
                                    androidEmbeddedExternalSurfaceStateRememberAndroidEmbeddedExternalSurfaceState.m15395setSurfaceSizeozmzZPI(j2);
                                    TextureView.SurfaceTextureListener surfaceTextureListener = textureView.getSurfaceTextureListener();
                                    AndroidEmbeddedExternalSurfaceState androidEmbeddedExternalSurfaceState = androidEmbeddedExternalSurfaceStateRememberAndroidEmbeddedExternalSurfaceState;
                                    if (surfaceTextureListener != androidEmbeddedExternalSurfaceState) {
                                        function132.invoke(androidEmbeddedExternalSurfaceState);
                                        textureView.setSurfaceTextureListener(androidEmbeddedExternalSurfaceStateRememberAndroidEmbeddedExternalSurfaceState);
                                    }
                                    textureView.setOpaque(z3);
                                    float[] fArr4 = fArr2;
                                    if (fArr4 != null) {
                                        matrix = androidEmbeddedExternalSurfaceStateRememberAndroidEmbeddedExternalSurfaceState.getMatrix();
                                        AndroidMatrixConversions_androidKt.m18395setFromEL8BTi8(matrix, fArr4);
                                    } else {
                                        matrix = null;
                                    }
                                    textureView.setTransform(matrix);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            Modifier modifier52 = modifier3;
                            AndroidView_androidKt.AndroidView(c0764x1320780e2, modifier52, c0765x1320780f2, null, (Function1) objRememberedValue, composerStartRestartGroup, ((i4 << 3) & 112) | 390, 8);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier4 = modifier52;
                            j3 = j2;
                            z4 = z3;
                            fArr3 = fArr2;
                        }
                    } else {
                        zChangedInstance = ((((i4 & 896) ^ 384) <= 256 && composerStartRestartGroup.changed(jM21143getZeroYbymL2g)) || (i4 & 384) == 256) | composerStartRestartGroup.changedInstance(androidEmbeddedExternalSurfaceStateRememberAndroidEmbeddedExternalSurfaceState) | ((57344 & i4) == 16384) | ((i4 & 112) == 32) | composerStartRestartGroup.changedInstance(fArr2 != null ? Matrix.m18754boximpl(fArr2) : null);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance) {
                        }
                    }
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidEmbeddedExternalSurface$4
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

                        public final void invoke(@Nullable Composer composer2, int i8) {
                            AndroidExternalSurface_androidKt.m15406AndroidEmbeddedExternalSurfacesv6N_fY(modifier4, z4, j3, fArr3, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            i4 |= 24576;
            function12 = function1;
            if ((i4 & 9363) == 9362) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 == 0) {
                    }
                    if (i7 != 0) {
                    }
                    if ((i2 & 4) != 0) {
                    }
                    if (i5 == 0) {
                    }
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        z2 = z;
        if ((i & 384) != 0) {
        }
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        if ((i2 & 16) != 0) {
        }
        function12 = function1;
        if ((i4 & 9363) == 9362) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:139:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0128  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: AndroidExternalSurface-58FFMhA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m15407AndroidExternalSurface58FFMhA(@Nullable Modifier modifier, boolean z, long j, int i, boolean z2, @NotNull final Function1<? super AndroidExternalSurfaceScope, Unit> function1, @Nullable Composer composer, final int i2, final int i4) {
        Modifier modifier2;
        int i5;
        boolean z3;
        long jM21143getZeroYbymL2g;
        int i6;
        int iM15403getBehindB_4ceCc;
        int i7;
        boolean z4;
        Modifier modifier3;
        final AndroidExternalSurfaceState androidExternalSurfaceStateRememberAndroidExternalSurfaceState;
        boolean zChangedInstance;
        Object objRememberedValue;
        boolean z5;
        Object objRememberedValue2;
        long j2;
        final boolean z6;
        int i8;
        boolean z7;
        final long j3;
        final Modifier modifier4;
        final int i9;
        final boolean z8;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(640888974);
        int i10 = i4 & 1;
        if (i10 != 0) {
            i5 = i2 | 6;
            modifier2 = modifier;
        } else if ((i2 & 6) == 0) {
            modifier2 = modifier;
            i5 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i2;
        } else {
            modifier2 = modifier;
            i5 = i2;
        }
        int i11 = i4 & 2;
        if (i11 != 0) {
            i5 |= 48;
        } else {
            if ((i2 & 48) == 0) {
                z3 = z;
                i5 |= composerStartRestartGroup.changed(z3) ? 32 : 16;
            }
            if ((i2 & 384) != 0) {
                jM21143getZeroYbymL2g = j;
                i5 |= ((i4 & 4) == 0 && composerStartRestartGroup.changed(jM21143getZeroYbymL2g)) ? 256 : 128;
            } else {
                jM21143getZeroYbymL2g = j;
            }
            i6 = i4 & 8;
            if (i6 == 0) {
                i5 |= 3072;
            } else {
                if ((i2 & 3072) == 0) {
                    iM15403getBehindB_4ceCc = i;
                    i5 |= composerStartRestartGroup.changed(iM15403getBehindB_4ceCc) ? 2048 : 1024;
                }
                i7 = i4 & 16;
                if (i7 == 0) {
                    if ((i2 & 24576) == 0) {
                        z4 = z2;
                        i5 |= composerStartRestartGroup.changed(z4) ? 16384 : 8192;
                    }
                    if ((i4 & 32) == 0) {
                        i5 |= 196608;
                    } else if ((i2 & 196608) == 0) {
                        i5 |= composerStartRestartGroup.changedInstance(function1) ? 131072 : 65536;
                    }
                    if ((i5 & 74899) == 74898 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            modifier3 = i10 == 0 ? Modifier.INSTANCE : modifier2;
                            if (i11 != 0) {
                                z3 = true;
                            }
                            if ((i4 & 4) != 0) {
                                i5 &= -897;
                                jM21143getZeroYbymL2g = IntSize.INSTANCE.m21143getZeroYbymL2g();
                            }
                            if (i6 != 0) {
                                iM15403getBehindB_4ceCc = AndroidExternalSurfaceZOrder.INSTANCE.m15403getBehindB_4ceCc();
                            }
                            if (i7 != 0) {
                                z4 = false;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i4 & 4) != 0) {
                                i5 &= -897;
                            }
                            modifier3 = modifier2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(640888974, i5, -1, "androidx.compose.foundation.AndroidExternalSurface (AndroidExternalSurface.android.kt:287)");
                        }
                        androidExternalSurfaceStateRememberAndroidExternalSurfaceState = rememberAndroidExternalSurfaceState(composerStartRestartGroup, 0);
                        zChangedInstance = ((458752 & i5) != 131072) | composerStartRestartGroup.changedInstance(androidExternalSurfaceStateRememberAndroidExternalSurfaceState);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1<Context, SurfaceView>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                @NotNull
                                public final SurfaceView invoke(@NotNull Context context) {
                                    SurfaceView surfaceView = new SurfaceView(context);
                                    Function1<AndroidExternalSurfaceScope, Unit> function12 = function1;
                                    AndroidExternalSurfaceState androidExternalSurfaceState = androidExternalSurfaceStateRememberAndroidExternalSurfaceState;
                                    function12.invoke(androidExternalSurfaceState);
                                    surfaceView.getHolder().addCallback(androidExternalSurfaceState);
                                    return surfaceView;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        Function1 function12 = (Function1) objRememberedValue;
                        AndroidExternalSurface_androidKt$AndroidExternalSurface$2 androidExternalSurface_androidKt$AndroidExternalSurface$2 = new Function1<SurfaceView, Unit>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$2
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull SurfaceView surfaceView) {
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SurfaceView surfaceView) {
                                invoke2(surfaceView);
                                return Unit.INSTANCE;
                            }
                        };
                        z5 = ((((i5 & 896) ^ 384) <= 256 && composerStartRestartGroup.changed(jM21143getZeroYbymL2g)) || (i5 & 384) == 256) | ((i5 & 112) == 32) | ((i5 & 7168) == 2048) | ((57344 & i5) == 16384);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (z5 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            final boolean z9 = z3;
                            final long j5 = jM21143getZeroYbymL2g;
                            final boolean z10 = z4;
                            final int i12 = iM15403getBehindB_4ceCc;
                            objRememberedValue2 = new Function1<SurfaceView, Unit>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$3$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SurfaceView surfaceView) {
                                    invoke2(surfaceView);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull SurfaceView surfaceView) {
                                    if (IntSize.m21136equalsimpl0(j5, IntSize.INSTANCE.m21143getZeroYbymL2g())) {
                                        surfaceView.getHolder().setSizeFromLayout();
                                    } else {
                                        surfaceView.getHolder().setFixedSize(IntSize.m21138getWidthimpl(j5), IntSize.m21137getHeightimpl(j5));
                                    }
                                    surfaceView.getHolder().setFormat(z9 ? -1 : -3);
                                    int i13 = i12;
                                    AndroidExternalSurfaceZOrder.Companion companion = AndroidExternalSurfaceZOrder.INSTANCE;
                                    if (AndroidExternalSurfaceZOrder.m15399equalsimpl0(i13, companion.m15403getBehindB_4ceCc())) {
                                        surfaceView.setZOrderOnTop(false);
                                    } else if (AndroidExternalSurfaceZOrder.m15399equalsimpl0(i13, companion.m15404getMediaOverlayB_4ceCc())) {
                                        surfaceView.setZOrderMediaOverlay(true);
                                    } else if (AndroidExternalSurfaceZOrder.m15399equalsimpl0(i13, companion.m15405getOnTopB_4ceCc())) {
                                        surfaceView.setZOrderOnTop(true);
                                    }
                                    surfaceView.setSecure(z10);
                                }
                            };
                            j2 = j5;
                            z6 = z9;
                            i8 = i12;
                            z7 = z10;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            z6 = z3;
                            j2 = jM21143getZeroYbymL2g;
                            z7 = z4;
                            i8 = iM15403getBehindB_4ceCc;
                        }
                        Modifier modifier5 = modifier3;
                        AndroidView_androidKt.AndroidView(function12, modifier5, androidExternalSurface_androidKt$AndroidExternalSurface$2, null, (Function1) objRememberedValue2, composerStartRestartGroup, ((i5 << 3) & 112) | 384, 8);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j3 = j2;
                        modifier4 = modifier5;
                        i9 = i8;
                        z8 = z7;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier4 = modifier2;
                        z6 = z3;
                        j3 = jM21143getZeroYbymL2g;
                        z8 = z4;
                        i9 = iM15403getBehindB_4ceCc;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$4
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

                            public final void invoke(@Nullable Composer composer2, int i13) {
                                AndroidExternalSurface_androidKt.m15407AndroidExternalSurface58FFMhA(modifier4, z6, j3, i9, z8, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                            }
                        });
                        return;
                    }
                    return;
                }
                i5 |= 24576;
                z4 = z2;
                if ((i4 & 32) == 0) {
                }
                if ((i5 & 74899) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i10 == 0) {
                        }
                        if (i11 != 0) {
                        }
                        if ((i4 & 4) != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if (i7 != 0) {
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        androidExternalSurfaceStateRememberAndroidExternalSurfaceState = rememberAndroidExternalSurfaceState(composerStartRestartGroup, 0);
                        zChangedInstance = ((458752 & i5) != 131072) | composerStartRestartGroup.changedInstance(androidExternalSurfaceStateRememberAndroidExternalSurfaceState);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance) {
                            objRememberedValue = new Function1<Context, SurfaceView>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                @NotNull
                                public final SurfaceView invoke(@NotNull Context context) {
                                    SurfaceView surfaceView = new SurfaceView(context);
                                    Function1<AndroidExternalSurfaceScope, Unit> function122 = function1;
                                    AndroidExternalSurfaceState androidExternalSurfaceState = androidExternalSurfaceStateRememberAndroidExternalSurfaceState;
                                    function122.invoke(androidExternalSurfaceState);
                                    surfaceView.getHolder().addCallback(androidExternalSurfaceState);
                                    return surfaceView;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            Function1 function122 = (Function1) objRememberedValue;
                            AndroidExternalSurface_androidKt$AndroidExternalSurface$2 androidExternalSurface_androidKt$AndroidExternalSurface$22 = new Function1<SurfaceView, Unit>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$2
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull SurfaceView surfaceView) {
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SurfaceView surfaceView) {
                                    invoke2(surfaceView);
                                    return Unit.INSTANCE;
                                }
                            };
                            if (((i5 & 896) ^ 384) <= 256) {
                                z5 = ((((i5 & 896) ^ 384) <= 256 && composerStartRestartGroup.changed(jM21143getZeroYbymL2g)) || (i5 & 384) == 256) | ((i5 & 112) == 32) | ((i5 & 7168) == 2048) | ((57344 & i5) == 16384);
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (z5) {
                                    final boolean z92 = z3;
                                    final long j52 = jM21143getZeroYbymL2g;
                                    final boolean z102 = z4;
                                    final int i122 = iM15403getBehindB_4ceCc;
                                    objRememberedValue2 = new Function1<SurfaceView, Unit>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$3$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(SurfaceView surfaceView) {
                                            invoke2(surfaceView);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(@NotNull SurfaceView surfaceView) {
                                            if (IntSize.m21136equalsimpl0(j52, IntSize.INSTANCE.m21143getZeroYbymL2g())) {
                                                surfaceView.getHolder().setSizeFromLayout();
                                            } else {
                                                surfaceView.getHolder().setFixedSize(IntSize.m21138getWidthimpl(j52), IntSize.m21137getHeightimpl(j52));
                                            }
                                            surfaceView.getHolder().setFormat(z92 ? -1 : -3);
                                            int i13 = i122;
                                            AndroidExternalSurfaceZOrder.Companion companion = AndroidExternalSurfaceZOrder.INSTANCE;
                                            if (AndroidExternalSurfaceZOrder.m15399equalsimpl0(i13, companion.m15403getBehindB_4ceCc())) {
                                                surfaceView.setZOrderOnTop(false);
                                            } else if (AndroidExternalSurfaceZOrder.m15399equalsimpl0(i13, companion.m15404getMediaOverlayB_4ceCc())) {
                                                surfaceView.setZOrderMediaOverlay(true);
                                            } else if (AndroidExternalSurfaceZOrder.m15399equalsimpl0(i13, companion.m15405getOnTopB_4ceCc())) {
                                                surfaceView.setZOrderOnTop(true);
                                            }
                                            surfaceView.setSecure(z102);
                                        }
                                    };
                                    j2 = j52;
                                    z6 = z92;
                                    i8 = i122;
                                    z7 = z102;
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                    Modifier modifier52 = modifier3;
                                    AndroidView_androidKt.AndroidView(function122, modifier52, androidExternalSurface_androidKt$AndroidExternalSurface$22, null, (Function1) objRememberedValue2, composerStartRestartGroup, ((i5 << 3) & 112) | 384, 8);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    j3 = j2;
                                    modifier4 = modifier52;
                                    i9 = i8;
                                    z8 = z7;
                                }
                            } else {
                                z5 = ((((i5 & 896) ^ 384) <= 256 && composerStartRestartGroup.changed(jM21143getZeroYbymL2g)) || (i5 & 384) == 256) | ((i5 & 112) == 32) | ((i5 & 7168) == 2048) | ((57344 & i5) == 16384);
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (z5) {
                                }
                            }
                        }
                    }
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            iM15403getBehindB_4ceCc = i;
            i7 = i4 & 16;
            if (i7 == 0) {
            }
            z4 = z2;
            if ((i4 & 32) == 0) {
            }
            if ((i5 & 74899) == 74898) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        z3 = z;
        if ((i2 & 384) != 0) {
        }
        i6 = i4 & 8;
        if (i6 == 0) {
        }
        iM15403getBehindB_4ceCc = i;
        i7 = i4 & 16;
        if (i7 == 0) {
        }
        z4 = z2;
        if ((i4 & 32) == 0) {
        }
        if ((i5 & 74899) == 74898) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    @Composable
    private static final AndroidEmbeddedExternalSurfaceState rememberAndroidEmbeddedExternalSurfaceState(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1057437053, i, -1, "androidx.compose.foundation.rememberAndroidEmbeddedExternalSurfaceState (AndroidExternalSurface.android.kt:383)");
        }
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = AbstractC0000a.m8e(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer), composer);
        }
        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = new AndroidEmbeddedExternalSurfaceState(coroutineScope);
            composer.updateRememberedValue(objRememberedValue2);
        }
        AndroidEmbeddedExternalSurfaceState androidEmbeddedExternalSurfaceState = (AndroidEmbeddedExternalSurfaceState) objRememberedValue2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return androidEmbeddedExternalSurfaceState;
    }

    @Composable
    private static final AndroidExternalSurfaceState rememberAndroidExternalSurfaceState(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-873615933, i, -1, "androidx.compose.foundation.rememberAndroidExternalSurfaceState (AndroidExternalSurface.android.kt:189)");
        }
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = AbstractC0000a.m8e(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer), composer);
        }
        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = new AndroidExternalSurfaceState(coroutineScope);
            composer.updateRememberedValue(objRememberedValue2);
        }
        AndroidExternalSurfaceState androidExternalSurfaceState = (AndroidExternalSurfaceState) objRememberedValue2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return androidExternalSurfaceState;
    }
}
