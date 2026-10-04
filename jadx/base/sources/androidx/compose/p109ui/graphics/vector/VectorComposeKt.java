package androidx.compose.p109ui.graphics.vector;

import androidx.compose.p109ui.graphics.Brush;
import androidx.compose.p109ui.graphics.PathFillType;
import androidx.compose.p109ui.graphics.StrokeCap;
import androidx.compose.p109ui.graphics.StrokeJoin;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.constraintlayout.motion.widget.Key;
import com.google.android.gms.drive.DriveFile;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementKey;
import io.netty.handler.codec.http.cookie.CookieHeaderNames;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0085\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0002\u0010\u0013\u001a¦\u0001\u0010\u0014\u001a\u00020\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u00052\b\b\u0002\u0010%\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006("}, m13886d2 = {"Group", "", "name", "", Key.ROTATION, "", "pivotX", "pivotY", "scaleX", "scaleY", "translationX", "translationY", "clipPathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/graphics/vector/VectorComposable;", "(Ljava/lang/String;FFFFFFFLjava/util/List;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", CookieHeaderNames.PATH, "pathData", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", VElementKey.FILL, "Landroidx/compose/ui/graphics/Brush;", "fillAlpha", "stroke", "strokeAlpha", "strokeLineWidth", "strokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineMiter", "trimPathStart", "trimPathEnd", "trimPathOffset", "Path-9cdaXJ4", "(Ljava/util/List;ILjava/lang/String;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Brush;FFIIFFFFLandroidx/compose/runtime/Composer;III)V", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVectorCompose.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VectorCompose.kt\nandroidx/compose/ui/graphics/vector/VectorComposeKt\n+ 2 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n*L\n1#1,165:1\n328#2,12:166\n254#2,11:178\n*S KotlinDebug\n*F\n+ 1 VectorCompose.kt\nandroidx/compose/ui/graphics/vector/VectorComposeKt\n*L\n59#1:166,12\n116#1:178,11\n*E\n"})
public final class VectorComposeKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:169:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0114  */
    @VectorComposable
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Group(@Nullable String str, float f, float f4, float f5, float f6, float f7, float f8, float f9, @Nullable List<? extends PathNode> list, @NotNull final Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, final int i, final int i2) {
        String str2;
        int i4;
        float f10;
        int i5;
        float f11;
        int i6;
        float f12;
        int i7;
        float f13;
        int i8;
        int i9;
        int i10;
        int i11;
        float f14;
        final float f15;
        float f16;
        final List<? extends PathNode> emptyPath;
        float f17;
        float f18;
        final float f19;
        final float f20;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-213417674);
        int i12 = i2 & 1;
        if (i12 != 0) {
            i4 = i | 6;
            str2 = str;
        } else if ((i & 6) == 0) {
            str2 = str;
            i4 = (composerStartRestartGroup.changed(str2) ? 4 : 2) | i;
        } else {
            str2 = str;
            i4 = i;
        }
        int i13 = i2 & 2;
        if (i13 != 0) {
            i4 |= 48;
        } else {
            if ((i & 48) == 0) {
                f10 = f;
                i4 |= composerStartRestartGroup.changed(f10) ? 32 : 16;
            }
            i5 = i2 & 4;
            if (i5 == 0) {
                i4 |= 384;
            } else {
                if ((i & 384) == 0) {
                    f11 = f4;
                    i4 |= composerStartRestartGroup.changed(f11) ? 256 : 128;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    i4 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        f12 = f5;
                        i4 |= composerStartRestartGroup.changed(f12) ? 2048 : 1024;
                    }
                    i7 = i2 & 16;
                    if (i7 == 0) {
                        i4 |= 24576;
                    } else {
                        if ((i & 24576) == 0) {
                            f13 = f6;
                            i4 |= composerStartRestartGroup.changed(f13) ? 16384 : 8192;
                        }
                        i8 = i2 & 32;
                        if (i8 != 0) {
                            i4 |= 196608;
                        } else if ((i & 196608) == 0) {
                            i4 |= composerStartRestartGroup.changed(f7) ? 131072 : 65536;
                        }
                        i9 = i2 & 64;
                        if (i9 != 0) {
                            i4 |= 1572864;
                        } else if ((i & 1572864) == 0) {
                            i4 |= composerStartRestartGroup.changed(f8) ? 1048576 : 524288;
                        }
                        i10 = i2 & 128;
                        if (i10 == 0) {
                            if ((i & 12582912) == 0) {
                                i11 = i10;
                                i4 |= composerStartRestartGroup.changed(f9) ? 8388608 : 4194304;
                            }
                            if ((i & 100663296) == 0) {
                                i4 |= ((i2 & 256) == 0 && composerStartRestartGroup.changedInstance(list)) ? 67108864 : 33554432;
                            }
                            if ((i2 & 512) == 0) {
                                i4 |= DriveFile.MODE_READ_WRITE;
                            } else if ((i & DriveFile.MODE_READ_WRITE) == 0) {
                                i4 |= composerStartRestartGroup.changedInstance(function2) ? 536870912 : 268435456;
                            }
                            if ((306783379 & i4) == 306783378 || !composerStartRestartGroup.getSkipping()) {
                                composerStartRestartGroup.startDefaults();
                                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i12 != 0) {
                                        str2 = "";
                                    }
                                    if (i13 != 0) {
                                        f10 = 0.0f;
                                    }
                                    if (i5 != 0) {
                                        f11 = 0.0f;
                                    }
                                    if (i6 != 0) {
                                        f12 = 0.0f;
                                    }
                                    if (i7 != 0) {
                                        f13 = 1.0f;
                                    }
                                    f14 = i8 == 0 ? f7 : 1.0f;
                                    f15 = i9 == 0 ? 0.0f : f8;
                                    f16 = i11 == 0 ? f9 : 0.0f;
                                    if ((i2 & 256) == 0) {
                                        emptyPath = VectorKt.getEmptyPath();
                                        i4 &= -234881025;
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        f17 = f16;
                                        ComposerKt.traceEventStart(-213417674, i4, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:57)");
                                    } else {
                                        f17 = f16;
                                    }
                                    C20631 c20631 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        @NotNull
                                        public final GroupComponent invoke() {
                                            return new GroupComponent();
                                        }
                                    };
                                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composerStartRestartGroup.startNode();
                                    if (composerStartRestartGroup.getInserting()) {
                                        composerStartRestartGroup.createNode(c20631);
                                    } else {
                                        composerStartRestartGroup.useNode();
                                    }
                                    Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                                    Updater.m18025setimpl(composerM18018constructorimpl, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str3) {
                                            invoke2(groupComponent, str3);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(@NotNull GroupComponent groupComponent, @NotNull String str3) {
                                            groupComponent.setName(str3);
                                        }
                                    });
                                    Updater.m18025setimpl(composerM18018constructorimpl, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f21) {
                                            invoke(groupComponent, f21.floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(@NotNull GroupComponent groupComponent, float f21) {
                                            groupComponent.setRotation(f21);
                                        }
                                    });
                                    Updater.m18025setimpl(composerM18018constructorimpl, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f21) {
                                            invoke(groupComponent, f21.floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(@NotNull GroupComponent groupComponent, float f21) {
                                            groupComponent.setPivotX(f21);
                                        }
                                    });
                                    Updater.m18025setimpl(composerM18018constructorimpl, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f21) {
                                            invoke(groupComponent, f21.floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(@NotNull GroupComponent groupComponent, float f21) {
                                            groupComponent.setPivotY(f21);
                                        }
                                    });
                                    Updater.m18025setimpl(composerM18018constructorimpl, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f21) {
                                            invoke(groupComponent, f21.floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(@NotNull GroupComponent groupComponent, float f21) {
                                            groupComponent.setScaleX(f21);
                                        }
                                    });
                                    Updater.m18025setimpl(composerM18018constructorimpl, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f21) {
                                            invoke(groupComponent, f21.floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(@NotNull GroupComponent groupComponent, float f21) {
                                            groupComponent.setScaleY(f21);
                                        }
                                    });
                                    Updater.m18025setimpl(composerM18018constructorimpl, Float.valueOf(f15), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f21) {
                                            invoke(groupComponent, f21.floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(@NotNull GroupComponent groupComponent, float f21) {
                                            groupComponent.setTranslationX(f21);
                                        }
                                    });
                                    Updater.m18025setimpl(composerM18018constructorimpl, Float.valueOf(f17), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f21) {
                                            invoke(groupComponent, f21.floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(@NotNull GroupComponent groupComponent, float f21) {
                                            groupComponent.setTranslationY(f21);
                                        }
                                    });
                                    Updater.m18025setimpl(composerM18018constructorimpl, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list2) {
                                            invoke2(groupComponent, list2);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(@NotNull GroupComponent groupComponent, @NotNull List<? extends PathNode> list2) {
                                            groupComponent.setClipPathData(list2);
                                        }
                                    });
                                    function2.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 27) & 14));
                                    composerStartRestartGroup.endNode();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    f18 = f17;
                                    f19 = f10;
                                    f20 = f14;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i2 & 256) != 0) {
                                        i4 &= -234881025;
                                    }
                                    f14 = f7;
                                    f15 = f8;
                                    f16 = f9;
                                }
                                emptyPath = list;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                C20631 c206312 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    @NotNull
                                    public final GroupComponent invoke() {
                                        return new GroupComponent();
                                    }
                                };
                                if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                                }
                                composerStartRestartGroup.startNode();
                                if (composerStartRestartGroup.getInserting()) {
                                }
                                Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composerStartRestartGroup);
                                Updater.m18025setimpl(composerM18018constructorimpl2, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str3) {
                                        invoke2(groupComponent, str3);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@NotNull GroupComponent groupComponent, @NotNull String str3) {
                                        groupComponent.setName(str3);
                                    }
                                });
                                Updater.m18025setimpl(composerM18018constructorimpl2, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f21) {
                                        invoke(groupComponent, f21.floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(@NotNull GroupComponent groupComponent, float f21) {
                                        groupComponent.setRotation(f21);
                                    }
                                });
                                Updater.m18025setimpl(composerM18018constructorimpl2, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f21) {
                                        invoke(groupComponent, f21.floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(@NotNull GroupComponent groupComponent, float f21) {
                                        groupComponent.setPivotX(f21);
                                    }
                                });
                                Updater.m18025setimpl(composerM18018constructorimpl2, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f21) {
                                        invoke(groupComponent, f21.floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(@NotNull GroupComponent groupComponent, float f21) {
                                        groupComponent.setPivotY(f21);
                                    }
                                });
                                Updater.m18025setimpl(composerM18018constructorimpl2, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f21) {
                                        invoke(groupComponent, f21.floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(@NotNull GroupComponent groupComponent, float f21) {
                                        groupComponent.setScaleX(f21);
                                    }
                                });
                                Updater.m18025setimpl(composerM18018constructorimpl2, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f21) {
                                        invoke(groupComponent, f21.floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(@NotNull GroupComponent groupComponent, float f21) {
                                        groupComponent.setScaleY(f21);
                                    }
                                });
                                Updater.m18025setimpl(composerM18018constructorimpl2, Float.valueOf(f15), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f21) {
                                        invoke(groupComponent, f21.floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(@NotNull GroupComponent groupComponent, float f21) {
                                        groupComponent.setTranslationX(f21);
                                    }
                                });
                                Updater.m18025setimpl(composerM18018constructorimpl2, Float.valueOf(f17), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f21) {
                                        invoke(groupComponent, f21.floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(@NotNull GroupComponent groupComponent, float f21) {
                                        groupComponent.setTranslationY(f21);
                                    }
                                });
                                Updater.m18025setimpl(composerM18018constructorimpl2, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list2) {
                                        invoke2(groupComponent, list2);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@NotNull GroupComponent groupComponent, @NotNull List<? extends PathNode> list2) {
                                        groupComponent.setClipPathData(list2);
                                    }
                                });
                                function2.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 27) & 14));
                                composerStartRestartGroup.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                f18 = f17;
                                f19 = f10;
                                f20 = f14;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                f15 = f8;
                                f18 = f9;
                                emptyPath = list;
                                f19 = f10;
                                f20 = f7;
                            }
                            final float f21 = f12;
                            final float f22 = f13;
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                final String str3 = str2;
                                final float f23 = f11;
                                final float f24 = f18;
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.4
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

                                    public final void invoke(@Nullable Composer composer2, int i14) {
                                        VectorComposeKt.Group(str3, f19, f23, f21, f22, f20, f15, f24, emptyPath, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i4 |= 12582912;
                        i11 = i10;
                        if ((i & 100663296) == 0) {
                        }
                        if ((i2 & 512) == 0) {
                        }
                        if ((306783379 & i4) == 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i12 != 0) {
                                }
                                if (i13 != 0) {
                                }
                                if (i5 != 0) {
                                }
                                if (i6 != 0) {
                                }
                                if (i7 != 0) {
                                }
                                if (i8 == 0) {
                                }
                                if (i9 == 0) {
                                }
                                if (i11 == 0) {
                                }
                                if ((i2 & 256) == 0) {
                                    emptyPath = list;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                C20631 c2063122 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    @NotNull
                                    public final GroupComponent invoke() {
                                        return new GroupComponent();
                                    }
                                };
                                if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                                }
                                composerStartRestartGroup.startNode();
                                if (composerStartRestartGroup.getInserting()) {
                                }
                                Composer composerM18018constructorimpl22 = Updater.m18018constructorimpl(composerStartRestartGroup);
                                Updater.m18025setimpl(composerM18018constructorimpl22, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str32) {
                                        invoke2(groupComponent, str32);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@NotNull GroupComponent groupComponent, @NotNull String str32) {
                                        groupComponent.setName(str32);
                                    }
                                });
                                Updater.m18025setimpl(composerM18018constructorimpl22, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f212) {
                                        invoke(groupComponent, f212.floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(@NotNull GroupComponent groupComponent, float f212) {
                                        groupComponent.setRotation(f212);
                                    }
                                });
                                Updater.m18025setimpl(composerM18018constructorimpl22, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f212) {
                                        invoke(groupComponent, f212.floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(@NotNull GroupComponent groupComponent, float f212) {
                                        groupComponent.setPivotX(f212);
                                    }
                                });
                                Updater.m18025setimpl(composerM18018constructorimpl22, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f212) {
                                        invoke(groupComponent, f212.floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(@NotNull GroupComponent groupComponent, float f212) {
                                        groupComponent.setPivotY(f212);
                                    }
                                });
                                Updater.m18025setimpl(composerM18018constructorimpl22, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f212) {
                                        invoke(groupComponent, f212.floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(@NotNull GroupComponent groupComponent, float f212) {
                                        groupComponent.setScaleX(f212);
                                    }
                                });
                                Updater.m18025setimpl(composerM18018constructorimpl22, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f212) {
                                        invoke(groupComponent, f212.floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(@NotNull GroupComponent groupComponent, float f212) {
                                        groupComponent.setScaleY(f212);
                                    }
                                });
                                Updater.m18025setimpl(composerM18018constructorimpl22, Float.valueOf(f15), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f212) {
                                        invoke(groupComponent, f212.floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(@NotNull GroupComponent groupComponent, float f212) {
                                        groupComponent.setTranslationX(f212);
                                    }
                                });
                                Updater.m18025setimpl(composerM18018constructorimpl22, Float.valueOf(f17), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f212) {
                                        invoke(groupComponent, f212.floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(@NotNull GroupComponent groupComponent, float f212) {
                                        groupComponent.setTranslationY(f212);
                                    }
                                });
                                Updater.m18025setimpl(composerM18018constructorimpl22, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list2) {
                                        invoke2(groupComponent, list2);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@NotNull GroupComponent groupComponent, @NotNull List<? extends PathNode> list2) {
                                        groupComponent.setClipPathData(list2);
                                    }
                                });
                                function2.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 27) & 14));
                                composerStartRestartGroup.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                f18 = f17;
                                f19 = f10;
                                f20 = f14;
                            }
                        }
                        final float f212 = f12;
                        final float f222 = f13;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    f13 = f6;
                    i8 = i2 & 32;
                    if (i8 != 0) {
                    }
                    i9 = i2 & 64;
                    if (i9 != 0) {
                    }
                    i10 = i2 & 128;
                    if (i10 == 0) {
                    }
                    i11 = i10;
                    if ((i & 100663296) == 0) {
                    }
                    if ((i2 & 512) == 0) {
                    }
                    if ((306783379 & i4) == 306783378) {
                    }
                    final float f2122 = f12;
                    final float f2222 = f13;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                f12 = f5;
                i7 = i2 & 16;
                if (i7 == 0) {
                }
                f13 = f6;
                i8 = i2 & 32;
                if (i8 != 0) {
                }
                i9 = i2 & 64;
                if (i9 != 0) {
                }
                i10 = i2 & 128;
                if (i10 == 0) {
                }
                i11 = i10;
                if ((i & 100663296) == 0) {
                }
                if ((i2 & 512) == 0) {
                }
                if ((306783379 & i4) == 306783378) {
                }
                final float f21222 = f12;
                final float f22222 = f13;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            f11 = f4;
            i6 = i2 & 8;
            if (i6 != 0) {
            }
            f12 = f5;
            i7 = i2 & 16;
            if (i7 == 0) {
            }
            f13 = f6;
            i8 = i2 & 32;
            if (i8 != 0) {
            }
            i9 = i2 & 64;
            if (i9 != 0) {
            }
            i10 = i2 & 128;
            if (i10 == 0) {
            }
            i11 = i10;
            if ((i & 100663296) == 0) {
            }
            if ((i2 & 512) == 0) {
            }
            if ((306783379 & i4) == 306783378) {
            }
            final float f212222 = f12;
            final float f222222 = f13;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        f10 = f;
        i5 = i2 & 4;
        if (i5 == 0) {
        }
        f11 = f4;
        i6 = i2 & 8;
        if (i6 != 0) {
        }
        f12 = f5;
        i7 = i2 & 16;
        if (i7 == 0) {
        }
        f13 = f6;
        i8 = i2 & 32;
        if (i8 != 0) {
        }
        i9 = i2 & 64;
        if (i9 != 0) {
        }
        i10 = i2 & 128;
        if (i10 == 0) {
        }
        i11 = i10;
        if ((i & 100663296) == 0) {
        }
        if ((i2 & 512) == 0) {
        }
        if ((306783379 & i4) == 306783378) {
        }
        final float f2122222 = f12;
        final float f2222222 = f13;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:218:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0102  */
    @VectorComposable
    @Composable
    /* JADX INFO: renamed from: Path-9cdaXJ4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m19223Path9cdaXJ4(@NotNull final List<? extends PathNode> list, int i, @Nullable String str, @Nullable Brush brush, float f, @Nullable Brush brush2, float f4, float f5, int i2, int i4, float f6, float f7, float f8, float f9, @Nullable Composer composer, final int i5, final int i6, final int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        Brush brush3;
        int i12;
        float f10;
        int i13;
        Brush brush4;
        int i14;
        float f11;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        final String str2;
        Composer composer2;
        final Brush brush5;
        final float f12;
        final Brush brush6;
        final float f13;
        final int i29;
        final int i30;
        final int i31;
        final float f14;
        final float f15;
        final float f16;
        final float f17;
        final float f18;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1478270750);
        if ((i7 & 1) != 0) {
            i8 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i8 = (composerStartRestartGroup.changedInstance(list) ? 4 : 2) | i5;
        } else {
            i8 = i5;
        }
        int i32 = i7 & 2;
        if (i32 != 0) {
            i8 |= 48;
        } else {
            if ((i5 & 48) == 0) {
                i9 = i;
                i8 |= composerStartRestartGroup.changed(i9) ? 32 : 16;
            }
            i10 = i7 & 4;
            if (i10 == 0) {
                i8 |= 384;
            } else {
                if ((i5 & 384) == 0) {
                    i8 |= composerStartRestartGroup.changed(str) ? 256 : 128;
                }
                i11 = i7 & 8;
                if (i11 != 0) {
                    i8 |= 3072;
                } else {
                    if ((i5 & 3072) == 0) {
                        brush3 = brush;
                        i8 |= composerStartRestartGroup.changed(brush3) ? 2048 : 1024;
                    }
                    i12 = i7 & 16;
                    if (i12 == 0) {
                        i8 |= 24576;
                    } else {
                        if ((i5 & 24576) == 0) {
                            f10 = f;
                            i8 |= composerStartRestartGroup.changed(f10) ? 16384 : 8192;
                        }
                        i13 = i7 & 32;
                        if (i13 != 0) {
                            i8 |= 196608;
                            brush4 = brush2;
                        } else {
                            brush4 = brush2;
                            if ((i5 & 196608) == 0) {
                                i8 |= composerStartRestartGroup.changed(brush4) ? 131072 : 65536;
                            }
                        }
                        i14 = i7 & 64;
                        if (i14 != 0) {
                            i8 |= 1572864;
                            f11 = f4;
                        } else {
                            f11 = f4;
                            if ((i5 & 1572864) == 0) {
                                i8 |= composerStartRestartGroup.changed(f11) ? 1048576 : 524288;
                            }
                        }
                        i15 = i7 & 128;
                        if (i15 != 0) {
                            i8 |= 12582912;
                        } else if ((i5 & 12582912) == 0) {
                            i8 |= composerStartRestartGroup.changed(f5) ? 8388608 : 4194304;
                        }
                        i16 = i7 & 256;
                        if (i16 != 0) {
                            i8 |= 100663296;
                        } else {
                            if ((i5 & 100663296) == 0) {
                                i17 = i16;
                                i8 |= composerStartRestartGroup.changed(i2) ? 67108864 : 33554432;
                            }
                            i18 = i7 & 512;
                            if (i18 == 0) {
                                i8 |= DriveFile.MODE_READ_WRITE;
                            } else {
                                if ((i5 & DriveFile.MODE_READ_WRITE) == 0) {
                                    i19 = i18;
                                    i8 |= composerStartRestartGroup.changed(i4) ? 536870912 : 268435456;
                                }
                                i20 = i7 & 1024;
                                if (i20 != 0) {
                                    i22 = i6 | 6;
                                    i21 = i20;
                                } else if ((i6 & 6) == 0) {
                                    i21 = i20;
                                    i22 = i6 | (composerStartRestartGroup.changed(f6) ? 4 : 2);
                                } else {
                                    i21 = i20;
                                    i22 = i6;
                                }
                                i23 = i7 & 2048;
                                if (i23 != 0) {
                                    i22 |= 48;
                                    i24 = i23;
                                } else if ((i6 & 48) == 0) {
                                    i24 = i23;
                                    i22 |= composerStartRestartGroup.changed(f7) ? 32 : 16;
                                } else {
                                    i24 = i23;
                                }
                                int i33 = i22;
                                i25 = i7 & 4096;
                                if (i25 != 0) {
                                    i26 = i33 | 384;
                                } else {
                                    int i34 = i33;
                                    if ((i6 & 384) == 0) {
                                        i34 |= composerStartRestartGroup.changed(f8) ? 256 : 128;
                                    }
                                    i26 = i34;
                                }
                                i27 = i7 & 8192;
                                if (i27 == 0) {
                                    if ((i6 & 3072) == 0) {
                                        i26 |= composerStartRestartGroup.changed(f9) ? 2048 : 1024;
                                    }
                                    if ((i8 & 306783379) != 306783378 && (i26 & 1171) == 1170 && composerStartRestartGroup.getSkipping()) {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        str2 = str;
                                        f16 = f5;
                                        f18 = f7;
                                        f15 = f9;
                                        composer2 = composerStartRestartGroup;
                                        brush5 = brush3;
                                        f12 = f10;
                                        brush6 = brush4;
                                        i31 = i9;
                                        f13 = f11;
                                        i29 = i2;
                                        i30 = i4;
                                        f17 = f6;
                                        f14 = f8;
                                    } else {
                                        int defaultFillType = i32 == 0 ? VectorKt.getDefaultFillType() : i9;
                                        String str3 = i10 == 0 ? "" : str;
                                        if (i11 != 0) {
                                            brush3 = null;
                                        }
                                        if (i12 != 0) {
                                            f10 = 1.0f;
                                        }
                                        if (i13 != 0) {
                                            brush4 = null;
                                        }
                                        if (i14 != 0) {
                                            f11 = 1.0f;
                                        }
                                        float f19 = i15 == 0 ? 0.0f : f5;
                                        int defaultStrokeLineCap = i17 == 0 ? VectorKt.getDefaultStrokeLineCap() : i2;
                                        int defaultStrokeLineJoin = i19 == 0 ? VectorKt.getDefaultStrokeLineJoin() : i4;
                                        float f20 = i21 == 0 ? 4.0f : f6;
                                        float f21 = i24 == 0 ? 0.0f : f7;
                                        float f22 = i25 == 0 ? f8 : 1.0f;
                                        float f23 = i27 == 0 ? f9 : 0.0f;
                                        if (ComposerKt.isTraceInProgress()) {
                                            i28 = defaultFillType;
                                        } else {
                                            i28 = defaultFillType;
                                            ComposerKt.traceEventStart(-1478270750, i8, i26, "androidx.compose.ui.graphics.vector.Path (VectorCompose.kt:114)");
                                        }
                                        VectorComposeKt$Path$1 vectorComposeKt$Path$1 = new Function0<PathComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$1
                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            @NotNull
                                            public final PathComponent invoke() {
                                                return new PathComponent();
                                            }
                                        };
                                        if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composerStartRestartGroup.startNode();
                                        if (composerStartRestartGroup.getInserting()) {
                                            composerStartRestartGroup.useNode();
                                        } else {
                                            composerStartRestartGroup.createNode(vectorComposeKt$Path$1);
                                        }
                                        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                                        Updater.m18025setimpl(composerM18018constructorimpl, str3, new Function2<PathComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$1
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, String str4) {
                                                invoke2(pathComponent, str4);
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(@NotNull PathComponent pathComponent, @NotNull String str4) {
                                                pathComponent.setName(str4);
                                            }
                                        });
                                        Updater.m18025setimpl(composerM18018constructorimpl, list, new Function2<PathComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$2
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, List<? extends PathNode> list2) {
                                                invoke2(pathComponent, list2);
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(@NotNull PathComponent pathComponent, @NotNull List<? extends PathNode> list2) {
                                                pathComponent.setPathData(list2);
                                            }
                                        });
                                        Updater.m18025setimpl(composerM18018constructorimpl, PathFillType.m18800boximpl(i28), new Function2<PathComponent, PathFillType, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$3
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, PathFillType pathFillType) {
                                                m19225invokepweu1eQ(pathComponent, pathFillType.getValue());
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke-pweu1eQ, reason: not valid java name */
                                            public final void m19225invokepweu1eQ(@NotNull PathComponent pathComponent, int i35) {
                                                pathComponent.m19217setPathFillTypeoQ8Xj4U(i35);
                                            }
                                        });
                                        Updater.m18025setimpl(composerM18018constructorimpl, brush3, new Function2<PathComponent, Brush, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$4
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Brush brush7) {
                                                invoke2(pathComponent, brush7);
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(@NotNull PathComponent pathComponent, @Nullable Brush brush7) {
                                                pathComponent.setFill(brush7);
                                            }
                                        });
                                        Updater.m18025setimpl(composerM18018constructorimpl, Float.valueOf(f10), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$5
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f24) {
                                                invoke(pathComponent, f24.floatValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(@NotNull PathComponent pathComponent, float f24) {
                                                pathComponent.setFillAlpha(f24);
                                            }
                                        });
                                        Updater.m18025setimpl(composerM18018constructorimpl, brush4, new Function2<PathComponent, Brush, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$6
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Brush brush7) {
                                                invoke2(pathComponent, brush7);
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(@NotNull PathComponent pathComponent, @Nullable Brush brush7) {
                                                pathComponent.setStroke(brush7);
                                            }
                                        });
                                        Updater.m18025setimpl(composerM18018constructorimpl, Float.valueOf(f11), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$7
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f24) {
                                                invoke(pathComponent, f24.floatValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(@NotNull PathComponent pathComponent, float f24) {
                                                pathComponent.setStrokeAlpha(f24);
                                            }
                                        });
                                        Updater.m18025setimpl(composerM18018constructorimpl, Float.valueOf(f19), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$8
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f24) {
                                                invoke(pathComponent, f24.floatValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(@NotNull PathComponent pathComponent, float f24) {
                                                pathComponent.setStrokeLineWidth(f24);
                                            }
                                        });
                                        Updater.m18025setimpl(composerM18018constructorimpl, StrokeJoin.m18881boximpl(defaultStrokeLineJoin), new Function2<PathComponent, StrokeJoin, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$9
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, StrokeJoin strokeJoin) {
                                                m19226invokekLtJ_vA(pathComponent, strokeJoin.getValue());
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke-kLtJ_vA, reason: not valid java name */
                                            public final void m19226invokekLtJ_vA(@NotNull PathComponent pathComponent, int i35) {
                                                pathComponent.m19219setStrokeLineJoinWw9F2mQ(i35);
                                            }
                                        });
                                        Updater.m18025setimpl(composerM18018constructorimpl, StrokeCap.m18871boximpl(defaultStrokeLineCap), new Function2<PathComponent, StrokeCap, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$10
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, StrokeCap strokeCap) {
                                                m19224invokeCSYIeUk(pathComponent, strokeCap.getValue());
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke-CSYIeUk, reason: not valid java name */
                                            public final void m19224invokeCSYIeUk(@NotNull PathComponent pathComponent, int i35) {
                                                pathComponent.m19218setStrokeLineCapBeK7IIE(i35);
                                            }
                                        });
                                        Updater.m18025setimpl(composerM18018constructorimpl, Float.valueOf(f20), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$11
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f24) {
                                                invoke(pathComponent, f24.floatValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(@NotNull PathComponent pathComponent, float f24) {
                                                pathComponent.setStrokeLineMiter(f24);
                                            }
                                        });
                                        Updater.m18025setimpl(composerM18018constructorimpl, Float.valueOf(f21), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$12
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f24) {
                                                invoke(pathComponent, f24.floatValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(@NotNull PathComponent pathComponent, float f24) {
                                                pathComponent.setTrimPathStart(f24);
                                            }
                                        });
                                        Updater.m18025setimpl(composerM18018constructorimpl, Float.valueOf(f22), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$13
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f24) {
                                                invoke(pathComponent, f24.floatValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(@NotNull PathComponent pathComponent, float f24) {
                                                pathComponent.setTrimPathEnd(f24);
                                            }
                                        });
                                        Updater.m18025setimpl(composerM18018constructorimpl, Float.valueOf(f23), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$14
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f24) {
                                                invoke(pathComponent, f24.floatValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(@NotNull PathComponent pathComponent, float f24) {
                                                pathComponent.setTrimPathOffset(f24);
                                            }
                                        });
                                        composerStartRestartGroup.endNode();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        str2 = str3;
                                        composer2 = composerStartRestartGroup;
                                        brush5 = brush3;
                                        f12 = f10;
                                        brush6 = brush4;
                                        f13 = f11;
                                        i29 = defaultStrokeLineCap;
                                        i30 = defaultStrokeLineJoin;
                                        i31 = i28;
                                        f14 = f22;
                                        f15 = f23;
                                        f16 = f19;
                                        f17 = f20;
                                        f18 = f21;
                                    }
                                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                    if (scopeUpdateScopeEndRestartGroup == null) {
                                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$3
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

                                            public final void invoke(@Nullable Composer composer3, int i35) {
                                                VectorComposeKt.m19223Path9cdaXJ4(list, i31, str2, brush5, f12, brush6, f13, f16, i29, i30, f17, f18, f14, f15, composer3, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6), i7);
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                                i26 |= 3072;
                                if ((i8 & 306783379) != 306783378) {
                                    if (i32 == 0) {
                                    }
                                    if (i10 == 0) {
                                    }
                                    if (i11 != 0) {
                                    }
                                    if (i12 != 0) {
                                    }
                                    if (i13 != 0) {
                                    }
                                    if (i14 != 0) {
                                    }
                                    if (i15 == 0) {
                                    }
                                    if (i17 == 0) {
                                    }
                                    if (i19 == 0) {
                                    }
                                    if (i21 == 0) {
                                    }
                                    if (i24 == 0) {
                                    }
                                    if (i25 == 0) {
                                    }
                                    if (i27 == 0) {
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    VectorComposeKt$Path$1 vectorComposeKt$Path$12 = new Function0<PathComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$1
                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        @NotNull
                                        public final PathComponent invoke() {
                                            return new PathComponent();
                                        }
                                    };
                                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                                    }
                                    composerStartRestartGroup.startNode();
                                    if (composerStartRestartGroup.getInserting()) {
                                    }
                                    Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composerStartRestartGroup);
                                    Updater.m18025setimpl(composerM18018constructorimpl2, str3, new Function2<PathComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$1
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, String str4) {
                                            invoke2(pathComponent, str4);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(@NotNull PathComponent pathComponent, @NotNull String str4) {
                                            pathComponent.setName(str4);
                                        }
                                    });
                                    Updater.m18025setimpl(composerM18018constructorimpl2, list, new Function2<PathComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$2
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, List<? extends PathNode> list2) {
                                            invoke2(pathComponent, list2);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(@NotNull PathComponent pathComponent, @NotNull List<? extends PathNode> list2) {
                                            pathComponent.setPathData(list2);
                                        }
                                    });
                                    Updater.m18025setimpl(composerM18018constructorimpl2, PathFillType.m18800boximpl(i28), new Function2<PathComponent, PathFillType, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$3
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, PathFillType pathFillType) {
                                            m19225invokepweu1eQ(pathComponent, pathFillType.getValue());
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke-pweu1eQ, reason: not valid java name */
                                        public final void m19225invokepweu1eQ(@NotNull PathComponent pathComponent, int i35) {
                                            pathComponent.m19217setPathFillTypeoQ8Xj4U(i35);
                                        }
                                    });
                                    Updater.m18025setimpl(composerM18018constructorimpl2, brush3, new Function2<PathComponent, Brush, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$4
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Brush brush7) {
                                            invoke2(pathComponent, brush7);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(@NotNull PathComponent pathComponent, @Nullable Brush brush7) {
                                            pathComponent.setFill(brush7);
                                        }
                                    });
                                    Updater.m18025setimpl(composerM18018constructorimpl2, Float.valueOf(f10), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$5
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f24) {
                                            invoke(pathComponent, f24.floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(@NotNull PathComponent pathComponent, float f24) {
                                            pathComponent.setFillAlpha(f24);
                                        }
                                    });
                                    Updater.m18025setimpl(composerM18018constructorimpl2, brush4, new Function2<PathComponent, Brush, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$6
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Brush brush7) {
                                            invoke2(pathComponent, brush7);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(@NotNull PathComponent pathComponent, @Nullable Brush brush7) {
                                            pathComponent.setStroke(brush7);
                                        }
                                    });
                                    Updater.m18025setimpl(composerM18018constructorimpl2, Float.valueOf(f11), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$7
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f24) {
                                            invoke(pathComponent, f24.floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(@NotNull PathComponent pathComponent, float f24) {
                                            pathComponent.setStrokeAlpha(f24);
                                        }
                                    });
                                    Updater.m18025setimpl(composerM18018constructorimpl2, Float.valueOf(f19), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$8
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f24) {
                                            invoke(pathComponent, f24.floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(@NotNull PathComponent pathComponent, float f24) {
                                            pathComponent.setStrokeLineWidth(f24);
                                        }
                                    });
                                    Updater.m18025setimpl(composerM18018constructorimpl2, StrokeJoin.m18881boximpl(defaultStrokeLineJoin), new Function2<PathComponent, StrokeJoin, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$9
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, StrokeJoin strokeJoin) {
                                            m19226invokekLtJ_vA(pathComponent, strokeJoin.getValue());
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke-kLtJ_vA, reason: not valid java name */
                                        public final void m19226invokekLtJ_vA(@NotNull PathComponent pathComponent, int i35) {
                                            pathComponent.m19219setStrokeLineJoinWw9F2mQ(i35);
                                        }
                                    });
                                    Updater.m18025setimpl(composerM18018constructorimpl2, StrokeCap.m18871boximpl(defaultStrokeLineCap), new Function2<PathComponent, StrokeCap, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$10
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, StrokeCap strokeCap) {
                                            m19224invokeCSYIeUk(pathComponent, strokeCap.getValue());
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke-CSYIeUk, reason: not valid java name */
                                        public final void m19224invokeCSYIeUk(@NotNull PathComponent pathComponent, int i35) {
                                            pathComponent.m19218setStrokeLineCapBeK7IIE(i35);
                                        }
                                    });
                                    Updater.m18025setimpl(composerM18018constructorimpl2, Float.valueOf(f20), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$11
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f24) {
                                            invoke(pathComponent, f24.floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(@NotNull PathComponent pathComponent, float f24) {
                                            pathComponent.setStrokeLineMiter(f24);
                                        }
                                    });
                                    Updater.m18025setimpl(composerM18018constructorimpl2, Float.valueOf(f21), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$12
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f24) {
                                            invoke(pathComponent, f24.floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(@NotNull PathComponent pathComponent, float f24) {
                                            pathComponent.setTrimPathStart(f24);
                                        }
                                    });
                                    Updater.m18025setimpl(composerM18018constructorimpl2, Float.valueOf(f22), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$13
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f24) {
                                            invoke(pathComponent, f24.floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(@NotNull PathComponent pathComponent, float f24) {
                                            pathComponent.setTrimPathEnd(f24);
                                        }
                                    });
                                    Updater.m18025setimpl(composerM18018constructorimpl2, Float.valueOf(f23), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$14
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f24) {
                                            invoke(pathComponent, f24.floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(@NotNull PathComponent pathComponent, float f24) {
                                            pathComponent.setTrimPathOffset(f24);
                                        }
                                    });
                                    composerStartRestartGroup.endNode();
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    str2 = str3;
                                    composer2 = composerStartRestartGroup;
                                    brush5 = brush3;
                                    f12 = f10;
                                    brush6 = brush4;
                                    f13 = f11;
                                    i29 = defaultStrokeLineCap;
                                    i30 = defaultStrokeLineJoin;
                                    i31 = i28;
                                    f14 = f22;
                                    f15 = f23;
                                    f16 = f19;
                                    f17 = f20;
                                    f18 = f21;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup == null) {
                                }
                            }
                            i19 = i18;
                            i20 = i7 & 1024;
                            if (i20 != 0) {
                            }
                            i23 = i7 & 2048;
                            if (i23 != 0) {
                            }
                            int i332 = i22;
                            i25 = i7 & 4096;
                            if (i25 != 0) {
                            }
                            i27 = i7 & 8192;
                            if (i27 == 0) {
                            }
                            if ((i8 & 306783379) != 306783378) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                            }
                        }
                        i17 = i16;
                        i18 = i7 & 512;
                        if (i18 == 0) {
                        }
                        i19 = i18;
                        i20 = i7 & 1024;
                        if (i20 != 0) {
                        }
                        i23 = i7 & 2048;
                        if (i23 != 0) {
                        }
                        int i3322 = i22;
                        i25 = i7 & 4096;
                        if (i25 != 0) {
                        }
                        i27 = i7 & 8192;
                        if (i27 == 0) {
                        }
                        if ((i8 & 306783379) != 306783378) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    f10 = f;
                    i13 = i7 & 32;
                    if (i13 != 0) {
                    }
                    i14 = i7 & 64;
                    if (i14 != 0) {
                    }
                    i15 = i7 & 128;
                    if (i15 != 0) {
                    }
                    i16 = i7 & 256;
                    if (i16 != 0) {
                    }
                    i17 = i16;
                    i18 = i7 & 512;
                    if (i18 == 0) {
                    }
                    i19 = i18;
                    i20 = i7 & 1024;
                    if (i20 != 0) {
                    }
                    i23 = i7 & 2048;
                    if (i23 != 0) {
                    }
                    int i33222 = i22;
                    i25 = i7 & 4096;
                    if (i25 != 0) {
                    }
                    i27 = i7 & 8192;
                    if (i27 == 0) {
                    }
                    if ((i8 & 306783379) != 306783378) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                brush3 = brush;
                i12 = i7 & 16;
                if (i12 == 0) {
                }
                f10 = f;
                i13 = i7 & 32;
                if (i13 != 0) {
                }
                i14 = i7 & 64;
                if (i14 != 0) {
                }
                i15 = i7 & 128;
                if (i15 != 0) {
                }
                i16 = i7 & 256;
                if (i16 != 0) {
                }
                i17 = i16;
                i18 = i7 & 512;
                if (i18 == 0) {
                }
                i19 = i18;
                i20 = i7 & 1024;
                if (i20 != 0) {
                }
                i23 = i7 & 2048;
                if (i23 != 0) {
                }
                int i332222 = i22;
                i25 = i7 & 4096;
                if (i25 != 0) {
                }
                i27 = i7 & 8192;
                if (i27 == 0) {
                }
                if ((i8 & 306783379) != 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            i11 = i7 & 8;
            if (i11 != 0) {
            }
            brush3 = brush;
            i12 = i7 & 16;
            if (i12 == 0) {
            }
            f10 = f;
            i13 = i7 & 32;
            if (i13 != 0) {
            }
            i14 = i7 & 64;
            if (i14 != 0) {
            }
            i15 = i7 & 128;
            if (i15 != 0) {
            }
            i16 = i7 & 256;
            if (i16 != 0) {
            }
            i17 = i16;
            i18 = i7 & 512;
            if (i18 == 0) {
            }
            i19 = i18;
            i20 = i7 & 1024;
            if (i20 != 0) {
            }
            i23 = i7 & 2048;
            if (i23 != 0) {
            }
            int i3322222 = i22;
            i25 = i7 & 4096;
            if (i25 != 0) {
            }
            i27 = i7 & 8192;
            if (i27 == 0) {
            }
            if ((i8 & 306783379) != 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        i9 = i;
        i10 = i7 & 4;
        if (i10 == 0) {
        }
        i11 = i7 & 8;
        if (i11 != 0) {
        }
        brush3 = brush;
        i12 = i7 & 16;
        if (i12 == 0) {
        }
        f10 = f;
        i13 = i7 & 32;
        if (i13 != 0) {
        }
        i14 = i7 & 64;
        if (i14 != 0) {
        }
        i15 = i7 & 128;
        if (i15 != 0) {
        }
        i16 = i7 & 256;
        if (i16 != 0) {
        }
        i17 = i16;
        i18 = i7 & 512;
        if (i18 == 0) {
        }
        i19 = i18;
        i20 = i7 & 1024;
        if (i20 != 0) {
        }
        i23 = i7 & 2048;
        if (i23 != 0) {
        }
        int i33222222 = i22;
        i25 = i7 & 4096;
        if (i25 != 0) {
        }
        i27 = i7 & 8192;
        if (i27 == 0) {
        }
        if ((i8 & 306783379) != 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }
}
