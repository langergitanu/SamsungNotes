package androidx.glance.appwidget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.annotation.IdRes;
import androidx.annotation.IntegerRes;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.core.widget.RemoteViewsCompat;
import androidx.glance.AndroidResourceImageProvider;
import androidx.glance.BackgroundModifier;
import androidx.glance.GlanceModifier;
import androidx.glance.ImageProvider;
import androidx.glance.Visibility;
import androidx.glance.VisibilityModifier;
import androidx.glance.action.ActionModifier;
import androidx.glance.appwidget.action.ApplyActionKt;
import androidx.glance.appwidget.animation.RemoteAnimation;
import androidx.glance.appwidget.percent.PercentActionsKt;
import androidx.glance.appwidget.percent.PercentHeightModifier;
import androidx.glance.appwidget.percent.PercentPaddingModifier;
import androidx.glance.appwidget.percent.PercentRatioSizeModifier;
import androidx.glance.appwidget.percent.PercentWidthModifier;
import androidx.glance.appwidget.util.Constants;
import androidx.glance.appwidget.util.RemoteViewsExtensionKt;
import androidx.glance.appwidget.util.RemoteViewsReflections;
import androidx.glance.appwidget.util.SemRemoteViewsAnimationReflections;
import androidx.glance.color.DayNightColorProvider;
import androidx.glance.layout.HeightModifier;
import androidx.glance.layout.PaddingInDp;
import androidx.glance.layout.PaddingModifier;
import androidx.glance.layout.WidthModifier;
import androidx.glance.oneui.common.GlanceLog;
import androidx.glance.semantics.SemanticsModifier;
import androidx.glance.semantics.SemanticsProperties;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.Dimension;
import androidx.glance.unit.FixedColorProvider;
import androidx.glance.unit.ResourceColorProvider;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0096\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001a\"\u0010\u0010\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a4\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0000\u001a \u0010\u001c\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0004H\u0002\u001a \u0010\u001e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u001f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a(\u0010 \u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020!2\u0006\u0010\u0013\u001a\u00020\u0014H\u0000\u001a(\u0010\"\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020#2\u0006\u0010\u0013\u001a\u00020\u0014H\u0000\u001a4\u0010$\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010#2\b\u0010&\u001a\u0004\u0018\u00010!2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001a$\u0010'\u001a\u0004\u0018\u00010(2\b\b\u0001\u0010\u0013\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020(H\u0002\u001a\u001c\u0010+\u001a\u0004\u0018\u00010(2\b\b\u0001\u0010\u0013\u001a\u00020\u00142\u0006\u0010,\u001a\u00020\u0014H\u0002\u001a@\u0010-\u001a\u0004\u0018\u00010(2\b\b\u0001\u0010\u0013\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u00012\u0006\u0010/\u001a\u00020\u00012\b\u00100\u001a\u0004\u0018\u00010(2\b\u00101\u001a\u0004\u0018\u00010(2\u0006\u00102\u001a\u000203H\u0002\u001a\u001c\u00104\u001a\u0004\u0018\u00010(2\b\b\u0001\u0010\u0013\u001a\u00020\u00142\u0006\u0010,\u001a\u00020\u0014H\u0002\u001a(\u00105\u001a\u00020\u0007*\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u00106\u001a\u0002072\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002\u001a*\u00108\u001a\u00020\u0007*\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\n\u00106\u001a\u0006\u0012\u0002\b\u0003092\b\u0010:\u001a\u0004\u0018\u00010\u001bH\u0002\u001a&\u0010;\u001a\u00020\u0003*\u00020\u000b2\u0006\u0010<\u001a\u00020\u00142\u0006\u0010=\u001a\u00020\u00012\b\b\u0001\u0010>\u001a\u00020\u0014H\u0002\u001a\u0016\u0010?\u001a\u00020\u0007*\u00020\u000b2\b\u00106\u001a\u0004\u0018\u00010(H\u0002\u001a$\u0010@\u001a\u00020\u0007*\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010A\u001a\u00020\u00142\b\u0010B\u001a\u0004\u0018\u00010(\u001a$\u0010C\u001a\u00020\u0007*\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u0014H\u0002\u001a\f\u0010G\u001a\u00020\u0014*\u00020HH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001a\u0010\u0002\u001a\u00020\u0003*\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005¨\u0006I"}, m13886d2 = {SearchConstants.TargetContents.TAG, "", "isFixed", "", "Landroidx/glance/unit/Dimension;", "(Landroidx/glance/unit/Dimension;)Z", "applyBackgroundModifier", "", "context", "Landroid/content/Context;", "rv", "Landroid/widget/RemoteViews;", "modifier", "Landroidx/glance/BackgroundModifier;", "viewDef", "Landroidx/glance/appwidget/InsertedViewInfo;", "applyBackgroundTintModifier", "colorProvider", "Landroidx/glance/unit/ColorProvider;", "viewId", "", "applyModifiers", "translationContext", "Landroidx/glance/appwidget/TranslationContext;", "modifiers", "Landroidx/glance/GlanceModifier;", "textOptions", "Landroid/os/Bundle;", "applyRoundedCorners", "radius", "applyShapeBackgroundModifier", "Landroidx/glance/appwidget/ShapeBackgroundModifier;", "applySimpleHeightModifier", "Landroidx/glance/layout/HeightModifier;", "applySimpleWidthModifier", "Landroidx/glance/layout/WidthModifier;", "applySizeModifiers", "widthModifier", "heightModifier", "createSemRemoteViewsDrawableAnimation", "", "needToStart", "resValue", "createSemRemoteViewsPropertyAnimation", "animResId", "createSemRemoteViewsValueAnimation", "animationType", "valueType", "valueFrom", "valueTo", XmlErrorCodes.DURATION, "", "createSemRemoteViewsViewAnimation", "applyAnimation", "animation", "Landroidx/glance/appwidget/animation/RemoteAnimation;", "setDecimalTextAnimation", "Landroidx/glance/appwidget/animation/RemoteAnimation$RemoteTextAnimation;", "options", "setIntInteger", "resId", "methodName", "integerResource", "setSemAnimation", "setTag", "key", "tag", "setViewMargin", "margin", "Landroidx/glance/appwidget/MarginDimension;", "type", "toViewVisibility", "Landroidx/glance/Visibility;", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nApplyModifiers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ApplyModifiers.kt\nandroidx/glance/appwidget/ApplyModifiersKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,830:1\n1#2:831\n1109#3,2:832\n1109#3,2:834\n1109#3,2:836\n1109#3,2:838\n*S KotlinDebug\n*F\n+ 1 ApplyModifiers.kt\nandroidx/glance/appwidget/ApplyModifiersKt\n*L\n673#1:832,2\n693#1:834,2\n797#1:836,2\n815#1:838,2\n*E\n"})
public final class ApplyModifiersKt {

    @NotNull
    private static final String TAG = "GWT:ApplyModifiers";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Visibility.values().length];
            try {
                iArr[Visibility.Visible.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Visibility.Invisible.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Visibility.Gone.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final void applyAnimation(RemoteViews remoteViews, int i, RemoteAnimation remoteAnimation, Bundle bundle) {
        if (remoteAnimation instanceof RemoteAnimation.DrawableAnimation) {
            if (Build.VERSION.SDK_INT >= 29) {
                RemoteAnimation.DrawableAnimation drawableAnimation = (RemoteAnimation.DrawableAnimation) remoteAnimation;
                setSemAnimation(remoteViews, createSemRemoteViewsDrawableAnimation(i, drawableAnimation.getStart(), drawableAnimation.getResValue()));
                return;
            }
            return;
        }
        if (remoteAnimation instanceof RemoteAnimation.PropertyAnimation) {
            setSemAnimation(remoteViews, createSemRemoteViewsPropertyAnimation(i, ((RemoteAnimation.PropertyAnimation) remoteAnimation).getAnimResId()));
            return;
        }
        if (remoteAnimation instanceof RemoteAnimation.ViewAnimation) {
            setSemAnimation(remoteViews, createSemRemoteViewsViewAnimation(i, ((RemoteAnimation.ViewAnimation) remoteAnimation).getAnimResId()));
            return;
        }
        if (remoteAnimation instanceof RemoteAnimation.ColorAnimation) {
            return;
        }
        if (remoteAnimation instanceof RemoteAnimation.ProgressAnimation) {
            RemoteAnimation.ProgressAnimation progressAnimation = (RemoteAnimation.ProgressAnimation) remoteAnimation;
            float f = 100;
            setSemAnimation(remoteViews, createSemRemoteViewsValueAnimation(i, "progress", XmlErrorCodes.INT, Integer.valueOf((int) (progressAnimation.getFrom() * f)), Integer.valueOf((int) (progressAnimation.getTo() * f)), progressAnimation.getDuration()));
        } else if (remoteAnimation instanceof RemoteAnimation.WidthAnimation) {
            RemoteAnimation.WidthAnimation widthAnimation = (RemoteAnimation.WidthAnimation) remoteAnimation;
            setSemAnimation(remoteViews, createSemRemoteViewsValueAnimation(i, "width", XmlErrorCodes.INT, Integer.valueOf((int) widthAnimation.getFrom()), Integer.valueOf((int) widthAnimation.getTo()), widthAnimation.getDuration()));
        } else if (remoteAnimation instanceof RemoteAnimation.RemoteTextAnimation) {
            setDecimalTextAnimation(remoteViews, i, (RemoteAnimation.RemoteTextAnimation) remoteAnimation, bundle);
        }
    }

    public static /* synthetic */ void applyAnimation$default(RemoteViews remoteViews, int i, RemoteAnimation remoteAnimation, Bundle bundle, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            bundle = null;
        }
        applyAnimation(remoteViews, i, remoteAnimation, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyBackgroundModifier(Context context, RemoteViews remoteViews, BackgroundModifier backgroundModifier, InsertedViewInfo insertedViewInfo) {
        int mainViewId = insertedViewInfo.getMainViewId();
        if (backgroundModifier instanceof BackgroundModifier.Image) {
            applyBackgroundModifier$applyBackgroundImageModifier(remoteViews, mainViewId, (BackgroundModifier.Image) backgroundModifier);
        } else if (backgroundModifier instanceof BackgroundModifier.Color) {
            applyBackgroundModifier$applyBackgroundColorModifier(remoteViews, mainViewId, context, (BackgroundModifier.Color) backgroundModifier);
        } else if (backgroundModifier instanceof BackgroundModifier.Bitmap) {
            applyBackgroundModifier$applyBackgroundBitmapModifier((BackgroundModifier.Bitmap) backgroundModifier);
        }
    }

    private static final void applyBackgroundModifier$applyBackgroundColorModifier(RemoteViews remoteViews, int i, Context context, BackgroundModifier.Color color) {
        ColorProvider colorProvider = color.getColorProvider();
        if (colorProvider instanceof FixedColorProvider) {
            RemoteViewsCompat.setViewBackgroundColor(remoteViews, i, ColorKt.m18579toArgb8_81llA(((FixedColorProvider) colorProvider).m22060getColor0d7_KjU()));
            return;
        }
        if (colorProvider instanceof ResourceColorProvider) {
            RemoteViewsCompat.setViewBackgroundColorResource(remoteViews, i, ((ResourceColorProvider) colorProvider).getResId());
            return;
        }
        if (!(colorProvider instanceof DayNightColorProvider)) {
            GlanceLog.INSTANCE.m2305w(TAG, "Unexpected background color modifier: " + colorProvider);
            return;
        }
        if (Build.VERSION.SDK_INT < 31) {
            RemoteViewsCompat.setViewBackgroundColor(remoteViews, i, ColorKt.m18579toArgb8_81llA(colorProvider.mo21422getColorvNxB06k(context)));
        } else {
            DayNightColorProvider dayNightColorProvider = (DayNightColorProvider) colorProvider;
            RemoteViewsCompat.setViewBackgroundColor(remoteViews, i, ColorKt.m18579toArgb8_81llA(dayNightColorProvider.m21424getDay0d7_KjU()), ColorKt.m18579toArgb8_81llA(dayNightColorProvider.m21425getNight0d7_KjU()));
        }
    }

    private static final void applyBackgroundModifier$applyBackgroundImageModifier(RemoteViews remoteViews, int i, BackgroundModifier.Image image) {
        ImageProvider imageProvider = image.getImageProvider();
        if (imageProvider instanceof AndroidResourceImageProvider) {
            RemoteViewsCompat.setViewBackgroundResource(remoteViews, i, ((AndroidResourceImageProvider) imageProvider).getResId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyBackgroundTintModifier(RemoteViews remoteViews, ColorProvider colorProvider, int i) {
        if (Build.VERSION.SDK_INT >= 31) {
            if (colorProvider instanceof FixedColorProvider) {
                RemoteViewsCompat.setViewBackgroundTintList(remoteViews, i, ColorStateList.valueOf(ColorKt.m18579toArgb8_81llA(((FixedColorProvider) colorProvider).m22060getColor0d7_KjU())));
                return;
            }
            if (colorProvider instanceof ResourceColorProvider) {
                RemoteViewsCompat.setViewBackgroundTintList(remoteViews, i, ((ResourceColorProvider) colorProvider).getResId());
            } else if (!(colorProvider instanceof DayNightColorProvider)) {
                RemoteViewsCompat.setViewBackgroundTintList(remoteViews, i, (ColorStateList) null);
            } else {
                DayNightColorProvider dayNightColorProvider = (DayNightColorProvider) colorProvider;
                RemoteViewsCompat.setViewBackgroundTintList(remoteViews, i, ColorStateList.valueOf(ColorKt.m18579toArgb8_81llA(dayNightColorProvider.m21424getDay0d7_KjU())), ColorStateList.valueOf(ColorKt.m18579toArgb8_81llA(dayNightColorProvider.m21425getNight0d7_KjU())));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [T, androidx.glance.Visibility] */
    public static final void applyModifiers(@NotNull final TranslationContext translationContext, @NotNull final RemoteViews rv, @NotNull GlanceModifier modifiers, @NotNull final InsertedViewInfo viewDef, @Nullable Bundle bundle) {
        List list;
        MarginModifier marginModifier;
        Intrinsics.checkNotNullParameter(translationContext, "translationContext");
        Intrinsics.checkNotNullParameter(rv, "rv");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        Intrinsics.checkNotNullParameter(viewDef, "viewDef");
        final Context context = translationContext.getContext();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef5 = new Ref.ObjectRef();
        objectRef5.element = Visibility.Visible;
        final Ref.IntRef intRef = new Ref.IntRef();
        final Ref.ObjectRef objectRef6 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef7 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef8 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef9 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef10 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef11 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef12 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef13 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef14 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef15 = new Ref.ObjectRef();
        Unit unit = Unit.INSTANCE;
        Function2<Unit, GlanceModifier.Element, Unit> function2 = new Function2<Unit, GlanceModifier.Element, Unit>() { // from class: androidx.glance.appwidget.ApplyModifiersKt.applyModifiers.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit2, GlanceModifier.Element element) throws IllegalAccessException, InvocationTargetException {
                invoke2(unit2, element);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:35:0x0081  */
            /* JADX WARN: Type inference failed for: r5v15, types: [T, androidx.glance.unit.Dimension] */
            /* JADX WARN: Type inference failed for: r5v17, types: [T, androidx.glance.Visibility] */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(@NotNull Unit unit2, @NotNull GlanceModifier.Element modifier) throws IllegalAccessException, InvocationTargetException {
                T t;
                Intrinsics.checkNotNullParameter(unit2, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(modifier, "modifier");
                if (modifier instanceof ActionModifier) {
                    if (objectRef6.element != null) {
                        GlanceLog.INSTANCE.m2305w(ApplyModifiersKt.TAG, "More than one clickable defined on the same GlanceModifier, only the last one will be used.");
                    }
                    objectRef6.element = modifier;
                    return;
                }
                if (modifier instanceof WidthModifier) {
                    objectRef.element = modifier;
                    return;
                }
                if (modifier instanceof HeightModifier) {
                    objectRef2.element = modifier;
                    return;
                }
                if (modifier instanceof BackgroundModifier) {
                    ApplyModifiersKt.applyBackgroundModifier(context, rv, (BackgroundModifier) modifier, viewDef);
                    return;
                }
                if (modifier instanceof ShapeBackgroundModifier) {
                    ApplyModifiersKt.applyShapeBackgroundModifier(rv, (ShapeBackgroundModifier) modifier, viewDef.getMainViewId());
                    return;
                }
                if (modifier instanceof BackgroundTintModifier) {
                    ApplyModifiersKt.applyBackgroundTintModifier(rv, ((BackgroundTintModifier) modifier).getTint(), viewDef.getMainViewId());
                    return;
                }
                if (modifier instanceof PaddingModifier) {
                    Ref.ObjectRef<PaddingModifier> objectRef16 = objectRef3;
                    PaddingModifier paddingModifier = objectRef16.element;
                    if (paddingModifier != null) {
                        PaddingModifier paddingModifierPlus = paddingModifier.plus((PaddingModifier) modifier);
                        t = paddingModifierPlus;
                        if (paddingModifierPlus == null) {
                            t = (PaddingModifier) modifier;
                        }
                    }
                    objectRef16.element = t;
                    return;
                }
                if (modifier instanceof MarginModifier) {
                    objectRef11.element = modifier;
                    return;
                }
                if (modifier instanceof PercentRatioSizeModifier) {
                    objectRef12.element = modifier;
                    return;
                }
                if (modifier instanceof PercentWidthModifier) {
                    objectRef13.element = modifier;
                    return;
                }
                if (modifier instanceof PercentHeightModifier) {
                    objectRef14.element = modifier;
                    return;
                }
                if (modifier instanceof PercentPaddingModifier) {
                    objectRef15.element = modifier;
                    return;
                }
                if (modifier instanceof VisibilityModifier) {
                    VisibilityModifier visibilityModifier = (VisibilityModifier) modifier;
                    if (visibilityModifier.getIntegerResource() != 0) {
                        intRef.element = visibilityModifier.getIntegerResource();
                        return;
                    } else {
                        objectRef5.element = visibilityModifier.getVisibility();
                        return;
                    }
                }
                if (modifier instanceof CornerRadiusModifier) {
                    objectRef4.element = ((CornerRadiusModifier) modifier).getRadius();
                    return;
                }
                if (modifier instanceof AppWidgetBackgroundModifier) {
                    return;
                }
                if (modifier instanceof SelectableGroupModifier) {
                    if (!translationContext.getCanUseSelectableGroup()) {
                        throw new IllegalStateException("GlanceModifier.selectableGroup() can only be used on Row or Column composables.");
                    }
                    return;
                }
                if (modifier instanceof AlignmentModifier) {
                    return;
                }
                if (modifier instanceof ClipToOutlineModifier) {
                    objectRef8.element = modifier;
                    return;
                }
                if (modifier instanceof EnabledModifier) {
                    objectRef7.element = modifier;
                    return;
                }
                if (modifier instanceof SemanticsModifier) {
                    objectRef9.element = modifier;
                    return;
                }
                if (modifier instanceof AnimationModifier) {
                    objectRef10.element = modifier;
                    return;
                }
                if (modifier instanceof KeyedTagModifier) {
                    KeyedTagModifier keyedTagModifier = (KeyedTagModifier) modifier;
                    ApplyModifiersKt.setTag(rv, viewDef.getMainViewId(), keyedTagModifier.getKey(), keyedTagModifier.getTag());
                    return;
                }
                if (modifier instanceof AlphaModifier) {
                    rv.setFloat(viewDef.getMainViewId(), "setAlpha", ((AlphaModifier) modifier).getAlpha());
                    return;
                }
                if (modifier instanceof ScrollModifier) {
                    if (translationContext.isListView()) {
                        rv.setScrollPosition(viewDef.getMainViewId(), ((ScrollModifier) modifier).getPosition());
                    }
                } else if (modifier instanceof FadingEdgeModifier) {
                    if (translationContext.isListView()) {
                        RemoteViewsExtensionKt.m21415setFadingEdgeOnListViewwH6b6FI(rv, viewDef.getMainViewId(), ((FadingEdgeModifier) modifier).m21292getEdgeLengthD9Ej5fM());
                    }
                } else {
                    if (modifier instanceof LayoutDirectionModifier) {
                        RemoteViewsCompat.setViewLayoutDirection(rv, viewDef.getMainViewId(), ((LayoutDirectionModifier) modifier).getLayoutDirection());
                        return;
                    }
                    GlanceLog.INSTANCE.m2305w(ApplyModifiersKt.TAG, "Unknown modifier '" + modifier + "', nothing done.");
                }
            }
        };
        RemoteViews remoteViews = rv;
        modifiers.foldIn(unit, function2);
        applySizeModifiers(translationContext, remoteViews, (WidthModifier) objectRef.element, (HeightModifier) objectRef2.element, viewDef);
        PercentActionsKt.applyPercentSizeModifiers(translationContext, remoteViews, (PercentRatioSizeModifier) objectRef12.element, (PercentWidthModifier) objectRef13.element, (PercentHeightModifier) objectRef14.element, viewDef);
        PercentPaddingModifier percentPaddingModifier = (PercentPaddingModifier) objectRef15.element;
        if (percentPaddingModifier != null) {
            PercentActionsKt.applyPercentPaddingModifiers(translationContext, remoteViews, percentPaddingModifier, viewDef);
        }
        ActionModifier actionModifier = (ActionModifier) objectRef6.element;
        if (actionModifier != null && !translationContext.getSkipInteraction()) {
            ApplyActionKt.applyAction(translationContext, remoteViews, actionModifier.getAction(), viewDef.getMainViewId());
        }
        Dimension dimension = (Dimension) objectRef4.element;
        if (dimension != null) {
            applyRoundedCorners(remoteViews, viewDef.getMainViewId(), dimension);
        }
        PaddingModifier paddingModifier = (PaddingModifier) objectRef3.element;
        if (paddingModifier != null) {
            Resources resources = context.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            PaddingInDp absolute = paddingModifier.toDp(resources).toAbsolute(translationContext.isRtl());
            float currentDensity = translationContext.getDensity() == -1.0f ? AppWidgetUtilsKt.getCurrentDensity(translationContext.getAppWidgetId(), context) : translationContext.getDensity();
            rv.setViewPadding(viewDef.getMainViewId(), UtilsKt.m21327toPixelsD5KLDUw(absolute.m21490getLeftD9Ej5fM(), currentDensity), UtilsKt.m21327toPixelsD5KLDUw(absolute.m21493getTopD9Ej5fM(), currentDensity), UtilsKt.m21327toPixelsD5KLDUw(absolute.m21491getRightD9Ej5fM(), currentDensity), UtilsKt.m21327toPixelsD5KLDUw(absolute.m21488getBottomD9Ej5fM(), currentDensity));
            remoteViews = rv;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 31 && (marginModifier = (MarginModifier) objectRef11.element) != null) {
            setViewMargin(remoteViews, viewDef.getMainViewId(), marginModifier.getLeft(), 0);
            setViewMargin(remoteViews, viewDef.getMainViewId(), marginModifier.getStart(), 4);
            setViewMargin(remoteViews, viewDef.getMainViewId(), marginModifier.getTop(), 1);
            setViewMargin(remoteViews, viewDef.getMainViewId(), marginModifier.getRight(), 2);
            setViewMargin(remoteViews, viewDef.getMainViewId(), marginModifier.getEnd(), 5);
            setViewMargin(remoteViews, viewDef.getMainViewId(), marginModifier.getBottom(), 3);
        }
        ClipToOutlineModifier clipToOutlineModifier = (ClipToOutlineModifier) objectRef8.element;
        if (clipToOutlineModifier != null && i >= 31) {
            remoteViews.setBoolean(viewDef.getMainViewId(), "setClipToOutline", clipToOutlineModifier.getClip());
        }
        EnabledModifier enabledModifier = (EnabledModifier) objectRef7.element;
        if (enabledModifier != null) {
            remoteViews.setBoolean(viewDef.getMainViewId(), "setEnabled", enabledModifier.getEnabled());
        }
        SemanticsModifier semanticsModifier = (SemanticsModifier) objectRef9.element;
        if (semanticsModifier != null && (list = (List) semanticsModifier.getConfiguration().getOrNull(SemanticsProperties.INSTANCE.getContentDescription())) != null) {
            remoteViews.setContentDescription(viewDef.getMainViewId(), CollectionsKt.m13955n(list, null, null, null, null, 63));
        }
        if (intRef.element == 0) {
            remoteViews.setViewVisibility(viewDef.getMainViewId(), toViewVisibility((Visibility) objectRef5.element));
        } else if (!setIntInteger(remoteViews, viewDef.getMainViewId(), "setVisibility", intRef.element)) {
            int mainViewId = viewDef.getMainViewId();
            int integer = context.getResources().getInteger(intRef.element);
            remoteViews.setViewVisibility(mainViewId, integer != 1 ? integer != 2 ? 0 : 8 : 4);
        }
        if (!Constants.INSTANCE.getVERSION_ONE_UI_7() || objectRef10.element == 0 || translationContext.getSkipInteraction()) {
            return;
        }
        int mainViewId2 = viewDef.getMainViewId();
        T t = objectRef10.element;
        Intrinsics.checkNotNull(t);
        applyAnimation(remoteViews, mainViewId2, ((AnimationModifier) t).getAnimation(), bundle);
    }

    public static /* synthetic */ void applyModifiers$default(TranslationContext translationContext, RemoteViews remoteViews, GlanceModifier glanceModifier, InsertedViewInfo insertedViewInfo, Bundle bundle, int i, Object obj) {
        if ((i & 16) != 0) {
            bundle = null;
        }
        applyModifiers(translationContext, remoteViews, glanceModifier, insertedViewInfo, bundle);
    }

    private static final void applyRoundedCorners(RemoteViews remoteViews, int i, Dimension dimension) {
        if (Build.VERSION.SDK_INT >= 31) {
            ApplyModifiersApi31Impl.INSTANCE.applyRoundedCorners(remoteViews, i, dimension);
        } else {
            GlanceLog.INSTANCE.m2305w(TAG, "Cannot set the rounded corner of views before Api 31.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyShapeBackgroundModifier(RemoteViews remoteViews, ShapeBackgroundModifier shapeBackgroundModifier, int i) {
        RemoteViewsCompat.setViewBackgroundResource(remoteViews, i, shapeBackgroundModifier.getResId());
        if (Build.VERSION.SDK_INT >= 31) {
            applyBackgroundTintModifier(remoteViews, shapeBackgroundModifier.getColorProvider(), i);
        }
    }

    public static final void applySimpleHeightModifier(@NotNull Context context, @NotNull RemoteViews rv, @NotNull HeightModifier modifier, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rv, "rv");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Dimension height = modifier.getHeight();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 31) {
            if (i2 >= 33 || !CollectionsKt.listOf((Object[]) new Dimension[]{Dimension.Wrap.INSTANCE, Dimension.Expand.INSTANCE}).contains(height)) {
                ApplyModifiersApi31Impl.INSTANCE.setViewHeight(rv, i, height);
                return;
            }
            return;
        }
        if (CollectionsKt.listOf((Object[]) new Dimension[]{Dimension.Wrap.INSTANCE, Dimension.Fill.INSTANCE, Dimension.Expand.INSTANCE}).contains(LayoutSelectionKt.resolveDimension(height, context))) {
            return;
        }
        throw new IllegalArgumentException("Using a height of " + height + " requires a complex layout before API 31");
    }

    public static final void applySimpleWidthModifier(@NotNull Context context, @NotNull RemoteViews rv, @NotNull WidthModifier modifier, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rv, "rv");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Dimension width = modifier.getWidth();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 31) {
            if (i2 >= 33 || !CollectionsKt.listOf((Object[]) new Dimension[]{Dimension.Wrap.INSTANCE, Dimension.Expand.INSTANCE}).contains(width)) {
                ApplyModifiersApi31Impl.INSTANCE.setViewWidth(rv, i, width);
                return;
            }
            return;
        }
        if (CollectionsKt.listOf((Object[]) new Dimension[]{Dimension.Wrap.INSTANCE, Dimension.Fill.INSTANCE, Dimension.Expand.INSTANCE}).contains(LayoutSelectionKt.resolveDimension(width, context))) {
            return;
        }
        throw new IllegalArgumentException("Using a width of " + width + " requires a complex layout before API 31");
    }

    private static final void applySizeModifiers(TranslationContext translationContext, RemoteViews remoteViews, WidthModifier widthModifier, HeightModifier heightModifier, InsertedViewInfo insertedViewInfo) {
        Context context = translationContext.getContext();
        if (LayoutSelectionKt.isSimple(insertedViewInfo)) {
            if (widthModifier != null) {
                applySimpleWidthModifier(context, remoteViews, widthModifier, insertedViewInfo.getMainViewId());
            }
            if (heightModifier != null) {
                applySimpleHeightModifier(context, remoteViews, heightModifier, insertedViewInfo.getMainViewId());
                return;
            }
            return;
        }
        if (Build.VERSION.SDK_INT >= 31) {
            throw new IllegalStateException("There is currently no valid use case where a complex view is used on Android S");
        }
        Dimension width = widthModifier != null ? widthModifier.getWidth() : null;
        Dimension height = heightModifier != null ? heightModifier.getHeight() : null;
        if (isFixed(width) || isFixed(height)) {
            boolean z = (width instanceof Dimension.Fill) || (width instanceof Dimension.Expand);
            boolean z2 = (height instanceof Dimension.Fill) || (height instanceof Dimension.Expand);
            int iInflateViewStub$default = UtilsKt.inflateViewStub$default(remoteViews, translationContext, C2902R.id.sizeViewStub, (z && z2) ? C2902R.layout.size_match_match : z ? C2902R.layout.size_match_wrap : z2 ? C2902R.layout.size_wrap_match : C2902R.layout.size_wrap_wrap, null, 8, null);
            if (width instanceof Dimension.C3532Dp) {
                RemoteViewsCompat.setTextViewWidth(remoteViews, iInflateViewStub$default, applySizeModifiers$toPixels((Dimension.C3532Dp) width, translationContext));
            } else if (width instanceof Dimension.Resource) {
                RemoteViewsCompat.setTextViewWidth(remoteViews, iInflateViewStub$default, applySizeModifiers$toPixels$11((Dimension.Resource) width, context));
            } else {
                if (!((Intrinsics.areEqual(width, Dimension.Expand.INSTANCE) ? true : Intrinsics.areEqual(width, Dimension.Fill.INSTANCE) ? true : Intrinsics.areEqual(width, Dimension.Wrap.INSTANCE)) || width == null)) {
                    throw new NoWhenBranchMatchedException();
                }
            }
            Unit unit = Unit.INSTANCE;
            if (height instanceof Dimension.C3532Dp) {
                RemoteViewsCompat.setTextViewHeight(remoteViews, iInflateViewStub$default, applySizeModifiers$toPixels((Dimension.C3532Dp) height, translationContext));
            } else if (height instanceof Dimension.Resource) {
                RemoteViewsCompat.setTextViewHeight(remoteViews, iInflateViewStub$default, applySizeModifiers$toPixels$11((Dimension.Resource) height, context));
            } else {
                if (!((Intrinsics.areEqual(height, Dimension.Expand.INSTANCE) ? true : Intrinsics.areEqual(height, Dimension.Fill.INSTANCE) ? true : Intrinsics.areEqual(height, Dimension.Wrap.INSTANCE)) || height == null)) {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
    }

    private static final int applySizeModifiers$toPixels(Dimension.C3532Dp c3532Dp, TranslationContext translationContext) {
        return UtilsKt.m21327toPixelsD5KLDUw(c3532Dp.getDp(), translationContext.getDensity() == -1.0f ? AppWidgetUtilsKt.getCurrentDensity(translationContext.getAppWidgetId(), translationContext.getContext()) : translationContext.getDensity());
    }

    private static final int applySizeModifiers$toPixels$11(Dimension.Resource resource, Context context) {
        return context.getResources().getDimensionPixelSize(resource.getRes());
    }

    private static final Object createSemRemoteViewsDrawableAnimation(@IdRes int i, boolean z, Object obj) {
        Class<Uri> cls;
        Object objM22215constructorimpl;
        boolean z2 = obj instanceof Integer;
        Class<Uri> cls2 = Integer.TYPE;
        if (z2) {
            cls = cls2;
        } else {
            if (!(obj instanceof Uri)) {
                return null;
            }
            cls = Uri.class;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(Class.forName(SemRemoteViewsAnimationReflections.REMOTE_VIEWS_DRAWABLE_ANIMATION).getConstructor(cls2, Boolean.TYPE, cls).newInstance(Integer.valueOf(i), Boolean.valueOf(z), obj));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
        if (thM22218exceptionOrNullimpl != null) {
            GlanceLog.INSTANCE.m2305w(TAG, "Create SemRemoteViewsDrawableAnimation Exception : " + thM22218exceptionOrNullimpl.getMessage());
        }
        if (Result.m22221isFailureimpl(objM22215constructorimpl)) {
            return null;
        }
        return objM22215constructorimpl;
    }

    private static final Object createSemRemoteViewsPropertyAnimation(@IdRes int i, int i2) {
        Object objM22215constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            Class<?> cls = Class.forName(SemRemoteViewsAnimationReflections.REMOTE_VIEWS_PROPERTY_ANIMATION);
            Class cls2 = Integer.TYPE;
            objM22215constructorimpl = Result.m22215constructorimpl(cls.getConstructor(cls2, cls2).newInstance(Integer.valueOf(i), Integer.valueOf(i2)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
        if (thM22218exceptionOrNullimpl != null) {
            GlanceLog.INSTANCE.m2305w(TAG, "Create SemRemoteViewsPropertyAnimation Exception : " + thM22218exceptionOrNullimpl.getMessage());
        }
        if (Result.m22221isFailureimpl(objM22215constructorimpl)) {
            return null;
        }
        return objM22215constructorimpl;
    }

    private static final Object createSemRemoteViewsValueAnimation(@IdRes int i, String str, String str2, Object obj, Object obj2, long j) {
        Object objM22215constructorimpl;
        Class cls;
        try {
            Result.Companion companion = Result.INSTANCE;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        if (obj == null || obj2 == null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if ((obj instanceof Integer) && (obj2 instanceof Integer)) {
            cls = Integer.TYPE;
        } else {
            if (!(obj instanceof Float) || !(obj2 instanceof Float)) {
                return null;
            }
            cls = Float.TYPE;
        }
        Class cls2 = cls;
        objM22215constructorimpl = Result.m22215constructorimpl(Class.forName(SemRemoteViewsAnimationReflections.REMOTE_VIEWS_VALUE_ANIMATION).getConstructor(Integer.TYPE, String.class, String.class, cls2, cls2, Long.TYPE).newInstance(Integer.valueOf(i), str, str2, obj, obj2, Long.valueOf(j)));
        Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
        if (thM22218exceptionOrNullimpl != null) {
            GlanceLog.INSTANCE.m2305w(TAG, "Create SemRemoteViewsValueAnimation Exception : " + thM22218exceptionOrNullimpl.getMessage());
        }
        if (Result.m22221isFailureimpl(objM22215constructorimpl)) {
            return null;
        }
        return objM22215constructorimpl;
    }

    private static final Object createSemRemoteViewsViewAnimation(@IdRes int i, int i2) {
        Object objM22215constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            Class<?> cls = Class.forName(SemRemoteViewsAnimationReflections.REMOTE_VIEWS_VIEW_ANIMATION);
            Class cls2 = Integer.TYPE;
            objM22215constructorimpl = Result.m22215constructorimpl(cls.getConstructor(cls2, cls2).newInstance(Integer.valueOf(i), Integer.valueOf(i2)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
        if (thM22218exceptionOrNullimpl != null) {
            GlanceLog.INSTANCE.m2305w(TAG, "Create SemRemoteViewsViewAnimation Exception : " + thM22218exceptionOrNullimpl.getMessage());
        }
        if (Result.m22221isFailureimpl(objM22215constructorimpl)) {
            return null;
        }
        return objM22215constructorimpl;
    }

    private static final boolean isFixed(Dimension dimension) {
        boolean z = true;
        if (dimension instanceof Dimension.C3532Dp ? true : dimension instanceof Dimension.Resource) {
            return true;
        }
        if (!(Intrinsics.areEqual(dimension, Dimension.Expand.INSTANCE) ? true : Intrinsics.areEqual(dimension, Dimension.Fill.INSTANCE) ? true : Intrinsics.areEqual(dimension, Dimension.Wrap.INSTANCE)) && dimension != null) {
            z = false;
        }
        if (z) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final void setDecimalTextAnimation(RemoteViews remoteViews, int i, RemoteAnimation.RemoteTextAnimation<?> remoteTextAnimation, Bundle bundle) {
        Object objM22215constructorimpl;
        Method[] declaredMethods;
        int i2;
        try {
            Result.Companion companion = Result.INSTANCE;
            declaredMethods = remoteViews.getClass().getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        for (Method method : declaredMethods) {
            method.setAccessible(true);
            if (Intrinsics.areEqual(method.getName(), RemoteViewsReflections.SET_VALUE_ANIMATION_METHOD)) {
                objM22215constructorimpl = Result.m22215constructorimpl(method.invoke(remoteViews, Integer.valueOf(i), "decimal_text", remoteTextAnimation.getValueType(), remoteTextAnimation.getFrom(), remoteTextAnimation.getTo(), Integer.valueOf(remoteTextAnimation.getDuration()), bundle));
                Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
                if (thM22218exceptionOrNullimpl != null) {
                    GlanceLog.INSTANCE.m2305w(TAG, "RemoteViews.setDecimalTextAnimation Exception : " + thM22218exceptionOrNullimpl.getMessage());
                    return;
                }
                return;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    private static final boolean setIntInteger(RemoteViews remoteViews, int i, String str, @IntegerRes int i2) throws IllegalAccessException, InvocationTargetException {
        Method method;
        boolean z = false;
        int i4 = 0;
        try {
            Method[] declaredMethods = remoteViews.getClass().getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
            int length = declaredMethods.length;
            boolean z2 = false;
            while (i4 < length) {
                try {
                    method = declaredMethods[i4];
                } catch (NoSuchElementException unused) {
                    z = z2;
                }
                try {
                    method.setAccessible(true);
                    if (Intrinsics.areEqual(method.getName(), RemoteViewsReflections.SET_INT_INTEGER_METHOD)) {
                        method.invoke(remoteViews, Integer.valueOf(i), str, Integer.valueOf(i2));
                        return true;
                    }
                    i4++;
                    z2 = true;
                } catch (NoSuchElementException unused2) {
                    z = true;
                    GlanceLog.INSTANCE.m2305w(TAG, "hidden_semSetIntInteger isn't supported.");
                    return z;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        } catch (NoSuchElementException unused3) {
        }
    }

    private static final void setSemAnimation(RemoteViews remoteViews, Object obj) {
        Object objM22215constructorimpl;
        Method[] declaredMethods;
        int i;
        try {
            Result.Companion companion = Result.INSTANCE;
            declaredMethods = remoteViews.getClass().getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        for (Method method : declaredMethods) {
            method.setAccessible(true);
            if (Intrinsics.areEqual(method.getName(), RemoteViewsReflections.SET_ANIMATION_METHOD)) {
                objM22215constructorimpl = Result.m22215constructorimpl(method.invoke(remoteViews, obj));
                Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
                if (thM22218exceptionOrNullimpl != null) {
                    GlanceLog.INSTANCE.m2305w(TAG, "RemoteViews.setSemAnimation Exception : " + thM22218exceptionOrNullimpl.getMessage());
                    return;
                }
                return;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final void setTag(@NotNull RemoteViews remoteViews, int i, int i2, @Nullable Object obj) throws IllegalAccessException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        try {
            Method[] declaredMethods = remoteViews.getClass().getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
            for (Method method : declaredMethods) {
                method.setAccessible(true);
                if (Intrinsics.areEqual(method.getName(), RemoteViewsReflections.SET_STRING_TAG_METHOD)) {
                    method.invoke(remoteViews, Integer.valueOf(i), Integer.valueOf(i2), obj);
                    return;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        } catch (NoSuchElementException unused) {
            GlanceLog.INSTANCE.m2305w(TAG, "hidden_semSetStringTag isn't supported.");
        }
    }

    private static final void setViewMargin(RemoteViews remoteViews, int i, MarginDimension marginDimension, int i2) {
        if (Build.VERSION.SDK_INT >= 31) {
            if (marginDimension.getResourceId() != 0) {
                remoteViews.setViewLayoutMarginDimen(i, i2, marginDimension.getResourceId());
            } else {
                remoteViews.setViewLayoutMargin(i, i2, marginDimension.m21303getDpD9Ej5fM(), 1);
            }
        }
    }

    private static final int toViewVisibility(Visibility visibility) {
        int i = WhenMappings.$EnumSwitchMapping$0[visibility.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 4;
        }
        if (i == 3) {
            return 8;
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final void applyBackgroundModifier$applyBackgroundBitmapModifier(BackgroundModifier.Bitmap bitmap) {
    }
}
