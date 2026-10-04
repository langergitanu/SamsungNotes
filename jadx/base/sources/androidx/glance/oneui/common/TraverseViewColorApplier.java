package androidx.glance.oneui.common;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.BlendMode;
import android.graphics.ColorFilter;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.collection.AbstractC0622a;
import androidx.glance.oneui.common.GlanceLog;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003 !\"B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ&\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\f\u0010\u0012\u001a\u00020\u0004*\u00020\u0004H\u0002J\u0014\u0010\u0013\u001a\u00020\n*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0006H\u0002J\f\u0010\u0016\u001a\u00020\u0004*\u00020\u0017H\u0002J\u0014\u0010\u0018\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u0014\u0010\u0019\u001a\u00020\n*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J\u0014\u0010\u001c\u001a\u00020\n*\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J\u001c\u0010\u001c\u001a\u00020\n*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006#"}, m13886d2 = {"Landroidx/glance/oneui/common/TraverseViewColorApplier;", "", "()V", "MONOTONE_TEXT_SHADOW_COLOR", "", "MONOTONE_TEXT_SHADOW_RADIUS", "", SearchConstants.TargetContents.TAG, "", "traverse", "", "view", "Landroid/view/View;", "baseWidgetColor", "updateColor", "", "showShadow", "traverseInner", "alpha", "applyMaxFontScale", "Landroid/widget/TextView;", "maxFontScale", "getColor", "Landroid/graphics/PorterDuffColorFilter;", "newColor", "setMonotoneColor", "Landroid/widget/ListView;", "color", VectorDrawableReflections.SET_PATH_COLOR_METHOD, "Landroid/graphics/drawable/AnimatedVectorDrawable;", "Landroid/graphics/drawable/VectorDrawable;", "key", "AnimatedVectorDrawableReflections", "PorterDuffColorFilterReflections", "VectorDrawableReflections", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTraverseViewColorApplier.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TraverseViewColorApplier.kt\nandroidx/glance/oneui/common/TraverseViewColorApplier\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,299:1\n1109#2,2:300\n1109#2,2:303\n3792#2:305\n4307#2,2:306\n1109#2,2:312\n1#3:302\n1549#4:308\n1620#4,3:309\n1855#4,2:314\n*S KotlinDebug\n*F\n+ 1 TraverseViewColorApplier.kt\nandroidx/glance/oneui/common/TraverseViewColorApplier\n*L\n250#1:300,2\n262#1:303,2\n277#1:305\n277#1:306,2\n290#1:312,2\n281#1:308\n281#1:309,3\n97#1:314,2\n*E\n"})
public final class TraverseViewColorApplier {

    @NotNull
    public static final TraverseViewColorApplier INSTANCE = new TraverseViewColorApplier();
    private static final int MONOTONE_TEXT_SHADOW_COLOR = 218103808;
    private static final float MONOTONE_TEXT_SHADOW_RADIUS = 5.0f;

    @NotNull
    private static final String TAG = "GWT:ViewColorApplier";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m13886d2 = {"Landroidx/glance/oneui/common/TraverseViewColorApplier$AnimatedVectorDrawableReflections;", "", "()V", "SET_PATH_COLOR_METHOD", "", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class AnimatedVectorDrawableReflections {

        @NotNull
        public static final AnimatedVectorDrawableReflections INSTANCE = new AnimatedVectorDrawableReflections();

        @NotNull
        public static final String SET_PATH_COLOR_METHOD = "hidden_semSetPathColor";

        private AnimatedVectorDrawableReflections() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m13886d2 = {"Landroidx/glance/oneui/common/TraverseViewColorApplier$PorterDuffColorFilterReflections;", "", "()V", "GET_COLOR_METHOD", "", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class PorterDuffColorFilterReflections {

        @NotNull
        public static final String GET_COLOR_METHOD = "hidden_getColor";

        @NotNull
        public static final PorterDuffColorFilterReflections INSTANCE = new PorterDuffColorFilterReflections();

        private PorterDuffColorFilterReflections() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m13886d2 = {"Landroidx/glance/oneui/common/TraverseViewColorApplier$VectorDrawableReflections;", "", "()V", "SET_PATH_COLOR_METHOD", "", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class VectorDrawableReflections {

        @NotNull
        public static final VectorDrawableReflections INSTANCE = new VectorDrawableReflections();

        @NotNull
        public static final String SET_PATH_COLOR_METHOD = "setPathColor";

        private VectorDrawableReflections() {
        }
    }

    private TraverseViewColorApplier() {
    }

    private final int alpha(int i) {
        return (i >> 24) & 255;
    }

    private final void applyMaxFontScale(TextView textView, float f) {
        int i = Build.VERSION.SDK_INT;
        if (i < 30) {
            return;
        }
        Resources resources = textView.getContext().getResources();
        float f4 = resources.getConfiguration().fontScale;
        GlanceLog.Companion companion = GlanceLog.INSTANCE;
        companion.m2297d(TAG, "applyMaxFontScale: currFontScale=" + f4 + " maxFontScale=" + f);
        if (f != 0.0f && f4 > f && textView.getTextSizeUnit() == 2) {
            DisplayMetrics displayMetrics = textView.getResources().getDisplayMetrics();
            float textSize = i < 34 ? textView.getTextSize() / displayMetrics.scaledDensity : TypedValue.applyDimension(1, textView.getTextSize(), displayMetrics);
            float textSize2 = textView.getTextSize();
            float f5 = resources.getDisplayMetrics().scaledDensity;
            StringBuilder sbM1176v = AbstractC0622a.m1176v("applyMaxFontScale: originTextSize=", textSize, " currTextSize=", textSize2, " scaledDensity=");
            sbM1176v.append(f5);
            companion.m2301i(TAG, sbM1176v.toString());
            textView.setTextSize(1, textSize * f);
        }
    }

    private final int getColor(PorterDuffColorFilter porterDuffColorFilter) {
        Object objFirst;
        try {
            Method[] declaredMethods = PorterDuffColorFilter.class.getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
            ArrayList arrayList = new ArrayList();
            for (Method method : declaredMethods) {
                method.setAccessible(true);
                if (Intrinsics.areEqual(method.getName(), PorterDuffColorFilterReflections.GET_COLOR_METHOD)) {
                    arrayList.add(method);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt.m13952k(arrayList));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add((List) ((Method) it.next()).invoke(porterDuffColorFilter, null));
            }
            objFirst = CollectionsKt.first((List<? extends Object>) arrayList2);
        } catch (NoSuchElementException unused) {
            objFirst = Unit.INSTANCE;
        }
        Integer num = objFirst instanceof Integer ? (Integer) objFirst : null;
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    private final int newColor(int i, int i2) {
        return i | (i2 << 24);
    }

    private final void setMonotoneColor(ListView listView, int i) {
        Object objM22215constructorimpl;
        Method[] declaredMethods;
        int i2;
        try {
            Result.Companion companion = Result.INSTANCE;
            declaredMethods = listView.getClass().getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        for (Method method : declaredMethods) {
            method.setAccessible(true);
            if (Intrinsics.areEqual(method.getName(), "semSetMonotoneColor")) {
                objM22215constructorimpl = Result.m22215constructorimpl(method.invoke(listView, Integer.valueOf(i)));
                Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
                return;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    private final void setPathColor(VectorDrawable vectorDrawable, String str, int i) {
        Object objM22215constructorimpl;
        Method[] declaredMethods;
        int i2;
        try {
            Result.Companion companion = Result.INSTANCE;
            declaredMethods = vectorDrawable.getClass().getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        for (Method method : declaredMethods) {
            method.setAccessible(true);
            if (Intrinsics.areEqual(method.getName(), VectorDrawableReflections.SET_PATH_COLOR_METHOD)) {
                objM22215constructorimpl = Result.m22215constructorimpl(method.invoke(vectorDrawable, str, Integer.valueOf(i)));
                Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
                return;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    private static final void traverseInner$setColor(ViewGroup viewGroup, boolean z, Ref.BooleanRef booleanRef, int i, boolean z2) {
        int color;
        if (z && !booleanRef.element) {
            Drawable background = viewGroup.getBackground();
            if (background instanceof GradientDrawable) {
                ColorStateList color2 = ((GradientDrawable) background).getColor();
                int defaultColor = color2 != null ? color2.getDefaultColor() : -1;
                if (defaultColor != -1 && defaultColor != 0) {
                    if (viewGroup.getId() == 16908288) {
                        viewGroup.setBackground(null);
                    } else {
                        Drawable drawableMutate = background.mutate();
                        Intrinsics.checkNotNull(drawableMutate, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                        GradientDrawable gradientDrawable = (GradientDrawable) drawableMutate;
                        TraverseViewColorApplier traverseViewColorApplier = INSTANCE;
                        gradientDrawable.setColor(ColorStateList.valueOf(traverseViewColorApplier.newColor(i, traverseViewColorApplier.alpha(defaultColor))));
                        viewGroup.setBackground(gradientDrawable);
                    }
                }
            } else if ((background instanceof ColorDrawable) && (color = ((ColorDrawable) background).getColor()) != -1 && color != 0) {
                if (viewGroup.getId() == 16908288) {
                    viewGroup.setBackground(null);
                } else {
                    TraverseViewColorApplier traverseViewColorApplier2 = INSTANCE;
                    viewGroup.setBackgroundColor(traverseViewColorApplier2.newColor(i, traverseViewColorApplier2.alpha(color)));
                }
            }
        }
        Iterator<Integer> it = RangesKt.until(0, viewGroup.getChildCount()).iterator();
        while (it.hasNext()) {
            int iNextInt = ((IntIterator) it).nextInt();
            TraverseViewColorApplier traverseViewColorApplier3 = INSTANCE;
            View childAt = viewGroup.getChildAt(iNextInt);
            Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
            traverseViewColorApplier3.traverseInner(childAt, i, z, z2);
        }
    }

    private static final void traverseInner$setColor$1(TextView textView, boolean z, Ref.BooleanRef booleanRef, int i, boolean z2) {
        if (z && !booleanRef.element) {
            textView.setTextColor(INSTANCE.newColor(i, 255));
            textView.setShadowLayer(z2 ? MONOTONE_TEXT_SHADOW_RADIUS : 0.0f, 0.0f, 0.0f, MONOTONE_TEXT_SHADOW_COLOR);
        }
        if (textView.getTextSizeUnit() == 2 && (textView.getTag() instanceof String)) {
            Object tag = textView.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.String");
            try {
                for (String str : StringsKt__StringsKt.split$default((String) tag, new String[]{";"}, false, 0, 6, (Object) null)) {
                    if (str.length() > 0) {
                        List listSplit$default = StringsKt__StringsKt.split$default(str, new String[]{MarketingConstants.REFERRER_DELIMITER_U003D}, false, 0, 6, (Object) null);
                        if (listSplit$default.size() == 2 && Intrinsics.areEqual("maxFontScale", listSplit$default.get(0))) {
                            INSTANCE.applyMaxFontScale(textView, Float.parseFloat((String) listSplit$default.get(1)));
                        }
                    }
                }
            } catch (Exception e) {
                GlanceLog.INSTANCE.m2299e(TAG, "traverse: ex=" + e);
            }
        }
    }

    private static final void traverseInner$setColor$2(ImageView imageView, boolean z, Ref.BooleanRef booleanRef, int i) {
        if (!z || booleanRef.element) {
            return;
        }
        if (imageView instanceof ImageButton) {
            Drawable background = ((ImageButton) imageView).getBackground();
            if (background instanceof GradientDrawable) {
                GradientDrawable gradientDrawable = (GradientDrawable) background;
                ColorStateList color = gradientDrawable.getColor();
                int defaultColor = color != null ? color.getDefaultColor() : -1;
                if (defaultColor != -1) {
                    TraverseViewColorApplier traverseViewColorApplier = INSTANCE;
                    background.setTint(traverseViewColorApplier.newColor(i, traverseViewColorApplier.alpha(defaultColor)));
                    BlendMode unused = BlendMode.SRC;
                    gradientDrawable.setTintBlendMode(BlendMode.SRC);
                }
            } else if (background instanceof ColorDrawable) {
                int color2 = ((ColorDrawable) background).getColor();
                TraverseViewColorApplier traverseViewColorApplier2 = INSTANCE;
                imageView.setBackgroundColor(traverseViewColorApplier2.newColor(i, traverseViewColorApplier2.alpha(color2)));
            }
        }
        if (imageView.getImageTintList() != null) {
            imageView.setImageTintList(null);
        }
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof VectorDrawable) {
            INSTANCE.setPathColor((VectorDrawable) drawable, "all", i);
            imageView.invalidate();
            return;
        }
        if (drawable instanceof AnimatedVectorDrawable) {
            INSTANCE.setPathColor((AnimatedVectorDrawable) drawable, i);
            imageView.invalidate();
            return;
        }
        if (drawable instanceof BitmapDrawable) {
            imageView.setColorFilter(INSTANCE.newColor(i, 255));
            imageView.invalidate();
            return;
        }
        ColorFilter colorFilter = imageView.getColorFilter();
        if (colorFilter instanceof PorterDuffColorFilter) {
            TraverseViewColorApplier traverseViewColorApplier3 = INSTANCE;
            imageView.setColorFilter(traverseViewColorApplier3.newColor(i, traverseViewColorApplier3.alpha(traverseViewColorApplier3.getColor((PorterDuffColorFilter) colorFilter))));
            imageView.invalidate();
        } else if (colorFilter != null) {
            GlanceLog.INSTANCE.m2297d(TAG, "traverse: image colorFilter=" + colorFilter);
        }
    }

    private static final void traverseInner$setColor$3(ProgressBar progressBar, boolean z, Ref.BooleanRef booleanRef, int i) {
        if (!z || booleanRef.element) {
            return;
        }
        ColorStateList progressTintList = progressBar.getProgressTintList();
        int defaultColor = progressTintList != null ? progressTintList.getDefaultColor() : 872415231;
        TraverseViewColorApplier traverseViewColorApplier = INSTANCE;
        progressBar.setProgressTintList(ColorStateList.valueOf(traverseViewColorApplier.newColor(i, (defaultColor >> 24) & 255)));
        ColorStateList progressBackgroundTintList = progressBar.getProgressBackgroundTintList();
        progressBar.setProgressBackgroundTintList(ColorStateList.valueOf(traverseViewColorApplier.newColor(i, ((progressBackgroundTintList != null ? progressBackgroundTintList.getDefaultColor() : 452984831) >> 24) & 255)));
        progressBar.invalidate();
    }

    private static final void traverseInner$setColor$4(ListView listView, boolean z, int i) {
        if (z) {
            INSTANCE.setMonotoneColor(listView, i);
        }
    }

    public final void traverse(@NotNull View view, int baseWidgetColor, boolean updateColor, boolean showShadow) {
        Intrinsics.checkNotNullParameter(view, "view");
        GlanceLog.INSTANCE.m2301i(TAG, "traverse view=" + view + " baseWidgetColor=" + baseWidgetColor + " updateColor=" + updateColor + " showShadow=" + showShadow);
        traverseInner(view, baseWidgetColor, updateColor, showShadow);
    }

    public final void traverseInner(@NotNull View view, int baseWidgetColor, boolean updateColor, boolean showShadow) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (Build.VERSION.SDK_INT < 30) {
            return;
        }
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        Object tag = view.getTag(AppWidgetConstants.VIEW_TAG_KEY_KEEP_CURRENT_COLOR);
        if (tag == null) {
            tag = "";
        }
        booleanRef.element = Intrinsics.areEqual(tag, "true");
        if ((view.getTag() instanceof String) && !booleanRef.element) {
            booleanRef.element = Intrinsics.areEqual(view.getTag(), "keepColor");
        }
        if (view instanceof ListView) {
            traverseInner$setColor$4((ListView) view, updateColor, baseWidgetColor);
            return;
        }
        if (view instanceof ViewGroup) {
            traverseInner$setColor((ViewGroup) view, updateColor, booleanRef, baseWidgetColor, showShadow);
            return;
        }
        if (view instanceof TextView) {
            traverseInner$setColor$1((TextView) view, updateColor, booleanRef, baseWidgetColor, showShadow);
        } else if (view instanceof ImageView) {
            traverseInner$setColor$2((ImageView) view, updateColor, booleanRef, baseWidgetColor);
        } else if (view instanceof ProgressBar) {
            traverseInner$setColor$3((ProgressBar) view, updateColor, booleanRef, baseWidgetColor);
        }
    }

    private final void setPathColor(AnimatedVectorDrawable animatedVectorDrawable, int i) {
        Object objM22215constructorimpl;
        Method[] declaredMethods;
        int i2;
        try {
            Result.Companion companion = Result.INSTANCE;
            declaredMethods = animatedVectorDrawable.getClass().getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        for (Method method : declaredMethods) {
            method.setAccessible(true);
            if (Intrinsics.areEqual(method.getName(), AnimatedVectorDrawableReflections.SET_PATH_COLOR_METHOD)) {
                objM22215constructorimpl = Result.m22215constructorimpl(method.invoke(animatedVectorDrawable, Integer.valueOf(i)));
                Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
                return;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }
}
