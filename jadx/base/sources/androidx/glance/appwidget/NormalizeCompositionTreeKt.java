package androidx.glance.appwidget;

import android.os.Build;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.glance.AbstractC2821a;
import androidx.glance.BackgroundModifier;
import androidx.glance.ButtonKt;
import androidx.glance.ColorFilter;
import androidx.glance.Emittable;
import androidx.glance.EmittableButton;
import androidx.glance.EmittableImage;
import androidx.glance.EmittableLazyItemWithChildren;
import androidx.glance.EmittableWithChildren;
import androidx.glance.EmittablesKt;
import androidx.glance.GlanceModifier;
import androidx.glance.ImageKt;
import androidx.glance.ImageProvider;
import androidx.glance.action.Action;
import androidx.glance.action.ActionModifier;
import androidx.glance.action.LambdaAction;
import androidx.glance.appwidget.action.CompoundButtonAction;
import androidx.glance.layout.Alignment;
import androidx.glance.layout.EmittableBox;
import androidx.glance.layout.HeightModifier;
import androidx.glance.layout.PaddingKt;
import androidx.glance.layout.PaddingModifier;
import androidx.glance.layout.SizeModifiersKt;
import androidx.glance.layout.WidthModifier;
import androidx.glance.oneui.common.GlanceLog;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.Dimension;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Marker;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\\\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0002\u001a\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u0014\u0010\f\u001a\u00020\r*\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000eH\u0002\u001a\u001a\u0010\u000f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\r0\u0010*\u00020\rH\u0002\u001a\f\u0010\u0012\u001a\u00020\u0013*\u00020\rH\u0002\u001a\f\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0002\u001a\f\u0010\u0017\u001a\u00020\u0003*\u00020\u0005H\u0002\u001a\f\u0010\u0018\u001a\u00020\u0016*\u00020\u0016H\u0002\u001a \u0010\u0019\u001a\u00020\u0003*\u00020\u00052\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u001bH\u0002\u001a\u001e\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u001e0\u001d*\u00020\u0005H\u0000\u001a\f\u0010\u001f\u001a\u00020\u0003*\u00020\rH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006 "}, m13886d2 = {SearchConstants.TargetContents.TAG, "", "coerceToOneChild", "", "container", "Landroidx/glance/EmittableWithChildren;", "normalizeCompositionTree", "root", "Landroidx/glance/appwidget/RemoteViewsRoot;", "normalizeLazyListItem", "view", "Landroidx/glance/EmittableLazyItemWithChildren;", "collect", "Landroidx/glance/GlanceModifier;", "", "extractLambdaAction", "Lkotlin/Pair;", "Landroidx/glance/action/LambdaAction;", "extractSizeAndCornerRadiusModifiers", "Landroidx/glance/appwidget/ExtractedSizeModifiers;", "hasBuiltinRipple", "", "Landroidx/glance/Emittable;", "normalizeSizes", "transformBackgroundImageAndActionRipple", "transformTree", "block", "Lkotlin/Function1;", "updateLambdaActionKeys", "", "", "warnIfMultipleClickableActions", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nNormalizeCompositionTree.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NormalizeCompositionTree.kt\nandroidx/glance/appwidget/NormalizeCompositionTreeKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Utils.kt\nandroidx/glance/UtilsKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 7 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,400:1\n1726#2,3:401\n1855#2,2:404\n1747#2,2:413\n1749#2:422\n1747#2,2:430\n1749#2:439\n1864#2,3:440\n1804#2,3:443\n1807#2:462\n1789#2,3:527\n22#3,7:406\n22#3,7:415\n22#3,7:423\n22#3,7:432\n36#3,11:463\n36#3,11:475\n36#3,11:486\n36#3,11:497\n36#3,11:508\n22#3,7:519\n372#4,7:446\n372#4,7:454\n215#5:453\n216#5:461\n1#6:474\n154#7:526\n*S KotlinDebug\n*F\n+ 1 NormalizeCompositionTree.kt\nandroidx/glance/appwidget/NormalizeCompositionTreeKt\n*L\n70#1:401,3\n96#1:404,2\n102#1:413,2\n102#1:422\n109#1:430,2\n109#1:439\n119#1:440,3\n141#1:443,3\n141#1:462\n396#1:527,3\n101#1:406,7\n103#1:415,7\n108#1:423,7\n110#1:432,7\n164#1:463,11\n207#1:475,11\n219#1:486,11\n250#1:497,11\n300#1:508,11\n330#1:519,7\n152#1:446,7\n157#1:454,7\n156#1:453\n156#1:461\n331#1:526\n*E\n"})
public final class NormalizeCompositionTreeKt {

    @NotNull
    private static final String TAG = "GWT:CompositionTree";

    private static final void coerceToOneChild(EmittableWithChildren emittableWithChildren) {
        if (!emittableWithChildren.getChildren().isEmpty()) {
            List<Emittable> children = emittableWithChildren.getChildren();
            if (!(children instanceof Collection) || !children.isEmpty()) {
                Iterator<T> it = children.iterator();
                while (it.hasNext()) {
                    if (!(((Emittable) it.next()) instanceof EmittableSizeBox)) {
                    }
                }
            }
            for (Emittable emittable : emittableWithChildren.getChildren()) {
                Intrinsics.checkNotNull(emittable, "null cannot be cast to non-null type androidx.glance.appwidget.EmittableSizeBox");
                EmittableSizeBox emittableSizeBox = (EmittableSizeBox) emittable;
                if (emittableSizeBox.getChildren().size() != 1) {
                    EmittableBox emittableBox = new EmittableBox();
                    CollectionsKt__MutableCollectionsKt.addAll(emittableBox.getChildren(), emittableSizeBox.getChildren());
                    emittableSizeBox.getChildren().clear();
                    emittableSizeBox.getChildren().add(emittableBox);
                }
            }
            return;
        }
        if (emittableWithChildren.getChildren().size() == 1) {
            return;
        }
        EmittableBox emittableBox2 = new EmittableBox();
        CollectionsKt__MutableCollectionsKt.addAll(emittableBox2.getChildren(), emittableWithChildren.getChildren());
        emittableWithChildren.getChildren().clear();
        emittableWithChildren.getChildren().add(emittableBox2);
    }

    private static final GlanceModifier collect(List<GlanceModifier> list) {
        GlanceModifier glanceModifierThen;
        GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
        for (GlanceModifier glanceModifier : list) {
            if (glanceModifier != null && (glanceModifierThen = companion.then(glanceModifier)) != null) {
                companion = glanceModifierThen;
            }
        }
        return companion;
    }

    private static final Pair<LambdaAction, GlanceModifier> extractLambdaAction(GlanceModifier glanceModifier) {
        Pair pairM13893to = glanceModifier.any(new Function1<GlanceModifier.Element, Boolean>() { // from class: androidx.glance.appwidget.NormalizeCompositionTreeKt$extractLambdaAction$$inlined$extractModifier$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull GlanceModifier.Element it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it instanceof ActionModifier);
            }
        }) ? (Pair) glanceModifier.foldIn(TuplesKt.m13893to(null, GlanceModifier.INSTANCE), new Function2<Pair<? extends ActionModifier, ? extends GlanceModifier>, GlanceModifier.Element, Pair<? extends ActionModifier, ? extends GlanceModifier>>() { // from class: androidx.glance.appwidget.NormalizeCompositionTreeKt$extractLambdaAction$$inlined$extractModifier$2
            @Override // kotlin.jvm.functions.Function2
            @NotNull
            public final Pair<ActionModifier, GlanceModifier> invoke(@NotNull Pair<? extends ActionModifier, ? extends GlanceModifier> acc, @NotNull GlanceModifier.Element cur) {
                Intrinsics.checkNotNullParameter(acc, "acc");
                Intrinsics.checkNotNullParameter(cur, "cur");
                return cur instanceof ActionModifier ? TuplesKt.m13893to(cur, acc.getSecond()) : TuplesKt.m13893to(acc.getFirst(), acc.getSecond().then(cur));
            }
        }) : TuplesKt.m13893to(null, glanceModifier);
        ActionModifier actionModifier = (ActionModifier) pairM13893to.component1();
        GlanceModifier glanceModifier2 = (GlanceModifier) pairM13893to.component2();
        Action action = actionModifier != null ? actionModifier.getAction() : null;
        if (action instanceof LambdaAction) {
            return TuplesKt.m13893to(action, glanceModifier2);
        }
        if (action instanceof CompoundButtonAction) {
            CompoundButtonAction compoundButtonAction = (CompoundButtonAction) action;
            if (compoundButtonAction.getInnerAction() instanceof LambdaAction) {
                return TuplesKt.m13893to(compoundButtonAction.getInnerAction(), glanceModifier2);
            }
        }
        return TuplesKt.m13893to(null, glanceModifier2);
    }

    private static final ExtractedSizeModifiers extractSizeAndCornerRadiusModifiers(GlanceModifier glanceModifier) {
        return glanceModifier.any(new Function1<GlanceModifier.Element, Boolean>() { // from class: androidx.glance.appwidget.NormalizeCompositionTreeKt.extractSizeAndCornerRadiusModifiers.1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull GlanceModifier.Element it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf((it instanceof WidthModifier) || (it instanceof HeightModifier) || (it instanceof CornerRadiusModifier));
            }
        }) ? (ExtractedSizeModifiers) glanceModifier.foldIn(new ExtractedSizeModifiers(null, null, 3, null), new Function2<ExtractedSizeModifiers, GlanceModifier.Element, ExtractedSizeModifiers>() { // from class: androidx.glance.appwidget.NormalizeCompositionTreeKt.extractSizeAndCornerRadiusModifiers.2
            @Override // kotlin.jvm.functions.Function2
            @NotNull
            public final ExtractedSizeModifiers invoke(@NotNull ExtractedSizeModifiers acc, @NotNull GlanceModifier.Element modifier) {
                Intrinsics.checkNotNullParameter(acc, "acc");
                Intrinsics.checkNotNullParameter(modifier, "modifier");
                return ((modifier instanceof WidthModifier) || (modifier instanceof HeightModifier) || (modifier instanceof CornerRadiusModifier)) ? ExtractedSizeModifiers.copy$default(acc, acc.getSizeModifiers().then(modifier), null, 2, null) : ExtractedSizeModifiers.copy$default(acc, null, acc.getNonSizeModifiers().then(modifier), 1, null);
            }
        }) : new ExtractedSizeModifiers(null, glanceModifier, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hasBuiltinRipple(Emittable emittable) {
        if ((emittable instanceof EmittableSwitch) || (emittable instanceof EmittableRadioButton) || (emittable instanceof EmittableCheckBox) || (emittable instanceof EmittableImageButton)) {
            return true;
        }
        return (emittable instanceof EmittableButton) && Build.VERSION.SDK_INT >= 31;
    }

    public static final void normalizeCompositionTree(@NotNull RemoteViewsRoot root) {
        Intrinsics.checkNotNullParameter(root, "root");
        coerceToOneChild(root);
        normalizeSizes(root);
        transformTree(root, new Function1<Emittable, Emittable>() { // from class: androidx.glance.appwidget.NormalizeCompositionTreeKt.normalizeCompositionTree.1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Emittable invoke(@NotNull Emittable view) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (view instanceof EmittableLazyItemWithChildren) {
                    NormalizeCompositionTreeKt.normalizeLazyListItem((EmittableLazyItemWithChildren) view);
                }
                return NormalizeCompositionTreeKt.transformBackgroundImageAndActionRipple(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void normalizeLazyListItem(EmittableLazyItemWithChildren emittableLazyItemWithChildren) {
        EmittableBox emittableBox = new EmittableBox();
        CollectionsKt__MutableCollectionsKt.addAll(emittableBox.getChildren(), emittableLazyItemWithChildren.getChildren());
        emittableBox.setContentAlignment(emittableLazyItemWithChildren.getAlignment());
        emittableBox.setModifier(emittableLazyItemWithChildren.getModifier());
        emittableLazyItemWithChildren.getChildren().clear();
        emittableLazyItemWithChildren.getChildren().add(emittableBox);
        emittableLazyItemWithChildren.setAlignment(Alignment.INSTANCE.getCenterStart());
    }

    private static final void normalizeSizes(EmittableWithChildren emittableWithChildren) {
        Dimension height;
        Dimension width;
        for (Emittable emittable : emittableWithChildren.getChildren()) {
            if (emittable instanceof EmittableWithChildren) {
                normalizeSizes((EmittableWithChildren) emittable);
            }
        }
        HeightModifier heightModifier = (HeightModifier) emittableWithChildren.getModifier().foldIn(null, new Function2<HeightModifier, GlanceModifier.Element, HeightModifier>() { // from class: androidx.glance.appwidget.NormalizeCompositionTreeKt$normalizeSizes$$inlined$findModifier$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final HeightModifier invoke(@Nullable HeightModifier heightModifier2, @NotNull GlanceModifier.Element cur) {
                Intrinsics.checkNotNullParameter(cur, "cur");
                return cur instanceof HeightModifier ? cur : heightModifier2;
            }
        });
        if (heightModifier == null || (height = heightModifier.getHeight()) == null) {
            height = Dimension.Wrap.INSTANCE;
        }
        if (height instanceof Dimension.Wrap) {
            List<Emittable> children = emittableWithChildren.getChildren();
            if (!(children instanceof Collection) || !children.isEmpty()) {
                Iterator<T> it = children.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    HeightModifier heightModifier2 = (HeightModifier) ((Emittable) it.next()).getModifier().foldIn(null, new Function2<HeightModifier, GlanceModifier.Element, HeightModifier>() { // from class: androidx.glance.appwidget.NormalizeCompositionTreeKt$normalizeSizes$lambda$2$$inlined$findModifier$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // kotlin.jvm.functions.Function2
                        @Nullable
                        public final HeightModifier invoke(@Nullable HeightModifier heightModifier3, @NotNull GlanceModifier.Element cur) {
                            Intrinsics.checkNotNullParameter(cur, "cur");
                            return cur instanceof HeightModifier ? cur : heightModifier3;
                        }
                    });
                    if ((heightModifier2 != null ? heightModifier2.getHeight() : null) instanceof Dimension.Fill) {
                        emittableWithChildren.setModifier(SizeModifiersKt.fillMaxHeight(emittableWithChildren.getModifier()));
                        break;
                    }
                }
            }
        }
        WidthModifier widthModifier = (WidthModifier) emittableWithChildren.getModifier().foldIn(null, new Function2<WidthModifier, GlanceModifier.Element, WidthModifier>() { // from class: androidx.glance.appwidget.NormalizeCompositionTreeKt$normalizeSizes$$inlined$findModifier$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final WidthModifier invoke(@Nullable WidthModifier widthModifier2, @NotNull GlanceModifier.Element cur) {
                Intrinsics.checkNotNullParameter(cur, "cur");
                return cur instanceof WidthModifier ? cur : widthModifier2;
            }
        });
        if (widthModifier == null || (width = widthModifier.getWidth()) == null) {
            width = Dimension.Wrap.INSTANCE;
        }
        if (width instanceof Dimension.Wrap) {
            List<Emittable> children2 = emittableWithChildren.getChildren();
            if ((children2 instanceof Collection) && children2.isEmpty()) {
                return;
            }
            Iterator<T> it2 = children2.iterator();
            while (it2.hasNext()) {
                WidthModifier widthModifier2 = (WidthModifier) ((Emittable) it2.next()).getModifier().foldIn(null, new Function2<WidthModifier, GlanceModifier.Element, WidthModifier>() { // from class: androidx.glance.appwidget.NormalizeCompositionTreeKt$normalizeSizes$lambda$3$$inlined$findModifier$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlin.jvm.functions.Function2
                    @Nullable
                    public final WidthModifier invoke(@Nullable WidthModifier widthModifier3, @NotNull GlanceModifier.Element cur) {
                        Intrinsics.checkNotNullParameter(cur, "cur");
                        return cur instanceof WidthModifier ? cur : widthModifier3;
                    }
                });
                if ((widthModifier2 != null ? widthModifier2.getWidth() : null) instanceof Dimension.Fill) {
                    emittableWithChildren.setModifier(SizeModifiersKt.fillMaxWidth(emittableWithChildren.getModifier()));
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Emittable transformBackgroundImageAndActionRipple(final Emittable emittable) {
        EmittableImage emittableImage;
        EmittableImage emittableImage2;
        ColorProvider colorProvider;
        if ((emittable instanceof EmittableLazyItemWithChildren) || (emittable instanceof EmittableSizeBox)) {
            return emittable;
        }
        final boolean z = emittable instanceof EmittableButton;
        if (z && Build.VERSION.SDK_INT > 30) {
            GlanceModifier modifier = emittable.getModifier();
            Pair pairM13893to = modifier.any(new Function1<GlanceModifier.Element, Boolean>() { // from class: androidx.glance.appwidget.NormalizeCompositionTreeKt$transformBackgroundImageAndActionRipple$$inlined$extractModifier$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull GlanceModifier.Element it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(it instanceof BackgroundModifier.Image);
                }
            }) ? (Pair) modifier.foldIn(TuplesKt.m13893to(null, GlanceModifier.INSTANCE), new Function2<Pair<? extends BackgroundModifier.Image, ? extends GlanceModifier>, GlanceModifier.Element, Pair<? extends BackgroundModifier.Image, ? extends GlanceModifier>>() { // from class: androidx.glance.appwidget.NormalizeCompositionTreeKt$transformBackgroundImageAndActionRipple$$inlined$extractModifier$2
                @Override // kotlin.jvm.functions.Function2
                @NotNull
                public final Pair<BackgroundModifier.Image, GlanceModifier> invoke(@NotNull Pair<? extends BackgroundModifier.Image, ? extends GlanceModifier> acc, @NotNull GlanceModifier.Element cur) {
                    Intrinsics.checkNotNullParameter(acc, "acc");
                    Intrinsics.checkNotNullParameter(cur, "cur");
                    return cur instanceof BackgroundModifier.Image ? TuplesKt.m13893to(cur, acc.getSecond()) : TuplesKt.m13893to(acc.getFirst(), acc.getSecond().then(cur));
                }
            }) : TuplesKt.m13893to(null, modifier);
            BackgroundModifier.Image image = (BackgroundModifier.Image) pairM13893to.component1();
            GlanceModifier glanceModifier = (GlanceModifier) pairM13893to.component2();
            if (image != null) {
                GlanceLog.INSTANCE.m2305w(TAG, "Glance Buttons should not have a background image modifier. Consider an image with a clickable modifier.");
                emittable.setModifier(glanceModifier);
            }
            GlanceModifier modifier2 = emittable.getModifier();
            Pair pairM13893to2 = modifier2.any(new Function1<GlanceModifier.Element, Boolean>() { // from class: androidx.glance.appwidget.NormalizeCompositionTreeKt$transformBackgroundImageAndActionRipple$$inlined$extractModifier$3
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull GlanceModifier.Element it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(it instanceof BackgroundModifier.Image);
                }
            }) ? (Pair) modifier2.foldIn(TuplesKt.m13893to(null, GlanceModifier.INSTANCE), new Function2<Pair<? extends BackgroundModifier.Image, ? extends GlanceModifier>, GlanceModifier.Element, Pair<? extends BackgroundModifier.Image, ? extends GlanceModifier>>() { // from class: androidx.glance.appwidget.NormalizeCompositionTreeKt$transformBackgroundImageAndActionRipple$$inlined$extractModifier$4
                @Override // kotlin.jvm.functions.Function2
                @NotNull
                public final Pair<BackgroundModifier.Image, GlanceModifier> invoke(@NotNull Pair<? extends BackgroundModifier.Image, ? extends GlanceModifier> acc, @NotNull GlanceModifier.Element cur) {
                    Intrinsics.checkNotNullParameter(acc, "acc");
                    Intrinsics.checkNotNullParameter(cur, "cur");
                    return cur instanceof BackgroundModifier.Image ? TuplesKt.m13893to(cur, acc.getSecond()) : TuplesKt.m13893to(acc.getFirst(), acc.getSecond().then(cur));
                }
            }) : TuplesKt.m13893to(null, modifier2);
            BackgroundModifier.Image image2 = (BackgroundModifier.Image) pairM13893to2.component1();
            GlanceModifier glanceModifier2 = (GlanceModifier) pairM13893to2.component2();
            if (image2 != null) {
                GlanceLog.INSTANCE.m2305w(TAG, "Glance Buttons should not have a background color modifier. Consider a tinted image with a clickable modifier");
                emittable.setModifier(glanceModifier2);
            }
        }
        if (!emittable.getModifier().any(new Function1<GlanceModifier.Element, Boolean>() { // from class: androidx.glance.appwidget.NormalizeCompositionTreeKt$transformBackgroundImageAndActionRipple$shouldWrapTargetInABox$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull GlanceModifier.Element it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf((it instanceof BackgroundModifier.Image) || (z && Build.VERSION.SDK_INT <= 30) || ((it instanceof ActionModifier) && !NormalizeCompositionTreeKt.hasBuiltinRipple(emittable)));
            }
        })) {
            return emittable;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        GlanceModifier modifier3 = emittable.getModifier();
        Pair pairM13893to3 = modifier3.any(new Function1<GlanceModifier.Element, Boolean>() { // from class: androidx.glance.appwidget.NormalizeCompositionTreeKt$transformBackgroundImageAndActionRipple$$inlined$extractModifier$5
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull GlanceModifier.Element it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it instanceof BackgroundModifier);
            }
        }) ? (Pair) modifier3.foldIn(TuplesKt.m13893to(null, GlanceModifier.INSTANCE), new Function2<Pair<? extends BackgroundModifier, ? extends GlanceModifier>, GlanceModifier.Element, Pair<? extends BackgroundModifier, ? extends GlanceModifier>>() { // from class: androidx.glance.appwidget.NormalizeCompositionTreeKt$transformBackgroundImageAndActionRipple$$inlined$extractModifier$6
            @Override // kotlin.jvm.functions.Function2
            @NotNull
            public final Pair<BackgroundModifier, GlanceModifier> invoke(@NotNull Pair<? extends BackgroundModifier, ? extends GlanceModifier> acc, @NotNull GlanceModifier.Element cur) {
                Intrinsics.checkNotNullParameter(acc, "acc");
                Intrinsics.checkNotNullParameter(cur, "cur");
                return cur instanceof BackgroundModifier ? TuplesKt.m13893to(cur, acc.getSecond()) : TuplesKt.m13893to(acc.getFirst(), acc.getSecond().then(cur));
            }
        }) : TuplesKt.m13893to(null, modifier3);
        BackgroundModifier backgroundModifier = (BackgroundModifier) pairM13893to3.component1();
        GlanceModifier glanceModifier3 = (GlanceModifier) pairM13893to3.component2();
        if (backgroundModifier == null) {
            emittableImage = null;
        } else if (z) {
            emittableImage = new EmittableImage();
            emittableImage.setModifier(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE));
            emittableImage.setProvider(ImageKt.ImageProvider(C2902R.drawable.glance_button_outline));
            BackgroundModifier.Color color = backgroundModifier instanceof BackgroundModifier.Color ? (BackgroundModifier.Color) backgroundModifier : null;
            if (color != null && (colorProvider = color.getColorProvider()) != null) {
                emittableImage.setColorFilterParams(new TintAndAlphaColorFilterParams(colorProvider));
            }
            emittableImage.m21258setContentScaleHwT0Evw(androidx.glance.layout.ContentScale.INSTANCE.m21466getFillBoundsAe3V0ko());
        } else if (backgroundModifier instanceof BackgroundModifier.Image) {
            emittableImage = new EmittableImage();
            emittableImage.setModifier(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE));
            BackgroundModifier.Image image3 = (BackgroundModifier.Image) backgroundModifier;
            emittableImage.setProvider(image3.getImageProvider());
            emittableImage.m21258setContentScaleHwT0Evw(image3.getContentScale());
            ColorFilter colorFilter = image3.getColorFilter();
            emittableImage.setColorFilterParams(colorFilter != null ? colorFilter.getColorFilterParams() : null);
        } else {
            if (backgroundModifier instanceof BackgroundModifier.Color) {
                arrayList2.add(backgroundModifier);
            }
            emittableImage = null;
        }
        warnIfMultipleClickableActions(glanceModifier3);
        Pair pairM13893to4 = glanceModifier3.any(new Function1<GlanceModifier.Element, Boolean>() { // from class: androidx.glance.appwidget.NormalizeCompositionTreeKt$transformBackgroundImageAndActionRipple$$inlined$extractModifier$7
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull GlanceModifier.Element it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it instanceof ActionModifier);
            }
        }) ? (Pair) glanceModifier3.foldIn(TuplesKt.m13893to(null, GlanceModifier.INSTANCE), new Function2<Pair<? extends ActionModifier, ? extends GlanceModifier>, GlanceModifier.Element, Pair<? extends ActionModifier, ? extends GlanceModifier>>() { // from class: androidx.glance.appwidget.NormalizeCompositionTreeKt$transformBackgroundImageAndActionRipple$$inlined$extractModifier$8
            @Override // kotlin.jvm.functions.Function2
            @NotNull
            public final Pair<ActionModifier, GlanceModifier> invoke(@NotNull Pair<? extends ActionModifier, ? extends GlanceModifier> acc, @NotNull GlanceModifier.Element cur) {
                Intrinsics.checkNotNullParameter(acc, "acc");
                Intrinsics.checkNotNullParameter(cur, "cur");
                return cur instanceof ActionModifier ? TuplesKt.m13893to(cur, acc.getSecond()) : TuplesKt.m13893to(acc.getFirst(), acc.getSecond().then(cur));
            }
        }) : TuplesKt.m13893to(null, glanceModifier3);
        ActionModifier actionModifier = (ActionModifier) pairM13893to4.component1();
        GlanceModifier glanceModifier4 = (GlanceModifier) pairM13893to4.component2();
        arrayList.add(actionModifier);
        if (actionModifier == null || hasBuiltinRipple(emittable) || actionModifier.getRemoveRipple()) {
            emittableImage2 = null;
        } else {
            int rippleOverride = actionModifier.getRippleOverride();
            ImageProvider ImageProvider = rippleOverride != 0 ? ImageKt.ImageProvider(rippleOverride) : z ? ImageKt.ImageProvider(C2902R.drawable.glance_button_ripple) : ImageKt.ImageProvider(C2902R.drawable.glance_ripple);
            emittableImage2 = new EmittableImage();
            emittableImage2.setModifier(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE));
            emittableImage2.setProvider(ImageProvider);
        }
        ExtractedSizeModifiers extractedSizeModifiersExtractSizeAndCornerRadiusModifiers = extractSizeAndCornerRadiusModifiers(glanceModifier4);
        GlanceModifier sizeModifiers = extractedSizeModifiersExtractSizeAndCornerRadiusModifiers.getSizeModifiers();
        GlanceModifier nonSizeModifiers = extractedSizeModifiersExtractSizeAndCornerRadiusModifiers.getNonSizeModifiers();
        arrayList.add(sizeModifiers);
        arrayList2.add(SizeModifiersKt.fillMaxSize(nonSizeModifiers));
        if (emittable instanceof EmittableButton) {
            GlanceModifier.Companion companion = GlanceModifier.INSTANCE;
            EmittableButton emittableButton = (EmittableButton) emittable;
            arrayList.add(AppWidgetModifiersKt.enabled(companion, emittableButton.getEnabled()));
            emittable = ButtonKt.toEmittableText(emittableButton);
            if (emittable.getModifier().foldIn(null, new Function2<PaddingModifier, GlanceModifier.Element, PaddingModifier>() { // from class: androidx.glance.appwidget.NormalizeCompositionTreeKt$transformBackgroundImageAndActionRipple$$inlined$findModifier$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final PaddingModifier invoke(@Nullable PaddingModifier paddingModifier, @NotNull GlanceModifier.Element cur) {
                    Intrinsics.checkNotNullParameter(cur, "cur");
                    return cur instanceof PaddingModifier ? cur : paddingModifier;
                }
            }) == null) {
                arrayList2.add(PaddingKt.m21497paddingVpY3zN4(companion, C2256Dp.m20968constructorimpl(16), C2256Dp.m20968constructorimpl(8)));
            }
        }
        EmittableBox emittableBox = new EmittableBox();
        emittableBox.setModifier(collect(arrayList));
        emittable.setModifier(collect(arrayList2));
        if (z) {
            emittableBox.setContentAlignment(Alignment.INSTANCE.getCenter());
        }
        EmittablesKt.addChildIfNotNull(emittableBox, emittableImage);
        EmittablesKt.addChild(emittableBox, emittable);
        EmittablesKt.addChildIfNotNull(emittableBox, emittableImage2);
        return emittableBox;
    }

    private static final void transformTree(EmittableWithChildren emittableWithChildren, Function1<? super Emittable, ? extends Emittable> function1) {
        int i = 0;
        for (Object obj : emittableWithChildren.getChildren()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Emittable emittableInvoke = function1.invoke((Emittable) obj);
            emittableWithChildren.getChildren().set(i, emittableInvoke);
            if (emittableInvoke instanceof EmittableWithChildren) {
                transformTree((EmittableWithChildren) emittableInvoke, function1);
            }
            i = i2;
        }
    }

    @NotNull
    public static final Map<String, List<LambdaAction>> updateLambdaActionKeys(@NotNull EmittableWithChildren emittableWithChildren) {
        Intrinsics.checkNotNullParameter(emittableWithChildren, "<this>");
        List<Emittable> children = emittableWithChildren.getChildren();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = 0;
        for (Object obj : children) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Emittable emittable = (Emittable) obj;
            Pair<LambdaAction, GlanceModifier> pairExtractLambdaAction = extractLambdaAction(emittable.getModifier());
            LambdaAction lambdaActionComponent1 = pairExtractLambdaAction.component1();
            GlanceModifier glanceModifierComponent2 = pairExtractLambdaAction.component2();
            if (lambdaActionComponent1 != null && !(emittable instanceof EmittableSizeBox) && !(emittable instanceof EmittableLazyItemWithChildren)) {
                String strM2218i = AbstractC2821a.m2218i(i, lambdaActionComponent1.getKey(), Marker.ANY_NON_NULL_MARKER);
                LambdaAction lambdaAction = new LambdaAction(strM2218i, lambdaActionComponent1.getBlock());
                Object arrayList = linkedHashMap.get(strM2218i);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(strM2218i, arrayList);
                }
                ((List) arrayList).add(lambdaAction);
                emittable.setModifier(glanceModifierComponent2.then(new ActionModifier(lambdaAction, 0, false, false, 14, null)));
            }
            if (emittable instanceof EmittableWithChildren) {
                for (Map.Entry<String, List<LambdaAction>> entry : updateLambdaActionKeys((EmittableWithChildren) emittable).entrySet()) {
                    String key = entry.getKey();
                    List<LambdaAction> value = entry.getValue();
                    Object arrayList2 = linkedHashMap.get(key);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                        linkedHashMap.put(key, arrayList2);
                    }
                    ((List) arrayList2).addAll(value);
                }
            }
            i = i2;
        }
        return linkedHashMap;
    }

    private static final void warnIfMultipleClickableActions(GlanceModifier glanceModifier) {
        if (((Number) glanceModifier.foldIn(0, new Function2<Integer, GlanceModifier.Element, Integer>() { // from class: androidx.glance.appwidget.NormalizeCompositionTreeKt$warnIfMultipleClickableActions$actionCount$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Integer invoke(Integer num, GlanceModifier.Element element) {
                return invoke(num.intValue(), element);
            }

            @NotNull
            public final Integer invoke(int i, @NotNull GlanceModifier.Element modifier) {
                Intrinsics.checkNotNullParameter(modifier, "modifier");
                if (modifier instanceof ActionModifier) {
                    i++;
                }
                return Integer.valueOf(i);
            }
        })).intValue() > 1) {
            GlanceLog.INSTANCE.m2305w(TAG, "More than one clickable defined on the same GlanceModifier, only the last one will be used.");
        }
    }
}
