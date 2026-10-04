package com.samsung.android.support.senl.p148nt.app.common.util;

import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.samsung.android.settings.search.provider.SecSearchIndexablesContract;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J0\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J0\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J8\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J$\u0010 \u001a\u00020\u00192\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070\"H\u0002J\u0016\u0010%\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0006J\u0016\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0006R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/common/util/ViewShapeManager;", "", "<init>", "()V", "noteHolderRadius", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "noteHolderCutCornerRadius", "noteHolderSmallGridFavoriteCut", "noteHolderLargeGridFavoriteCut", "noteHolderListFavoriteCut", "folderPathLayoutRadius", "init", "", SecSearchIndexablesContract.ExtraInfo.EXTRA_KEY_DEX_MODE, "getNoteHolderOutlineProvider", "Landroid/view/ViewOutlineProvider;", "viewMode", "", "cut", "getDefaultNoteHolderOutlineProvider", "getFavoriteNoteHolderOutlineProvider", "getDefaultNoteHolderShapePath", "Landroid/graphics/Path;", "width", "height", "isRTLMode", "getFavoriteNoteHolderShapePath", "getNoteHolderShapePath", "rightTopCut", "roundPolygon", "points", "", "Landroid/graphics/PointF;", "radii", "getFavoriteCut", "getFolderPathOutlineProvider", "value", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nViewShapeManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewShapeManager.kt\ncom/samsung/android/support/senl/nt/app/common/util/ViewShapeManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,300:1\n1#2:301\n*E\n"})
public final class ViewShapeManager {
    private static final float EPS = 0.001f;

    @NotNull
    private static final String TAG = "ViewShapeManager";

    @Nullable
    private static ViewShapeManager mInstance;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static Map<String, Path> mNoteHolderShapePaths = new HashMap();

    @NotNull
    private HashMap<Boolean, Float> noteHolderRadius = new HashMap<>();

    @NotNull
    private HashMap<Boolean, Float> noteHolderCutCornerRadius = new HashMap<>();

    @NotNull
    private HashMap<Boolean, Float> noteHolderSmallGridFavoriteCut = new HashMap<>();

    @NotNull
    private HashMap<Boolean, Float> noteHolderLargeGridFavoriteCut = new HashMap<>();

    @NotNull
    private HashMap<Boolean, Float> noteHolderListFavoriteCut = new HashMap<>();

    @NotNull
    private HashMap<Boolean, Float> folderPathLayoutRadius = new HashMap<>();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/common/util/ViewShapeManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "EPS", "", "mNoteHolderShapePaths", "", "Landroid/graphics/Path;", "mInstance", "Lcom/samsung/android/support/senl/nt/app/common/util/ViewShapeManager;", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/senl/nt/app/common/util/ViewShapeManager;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        @NotNull
        public final synchronized ViewShapeManager getInstance() {
            ViewShapeManager viewShapeManager;
            try {
                if (ViewShapeManager.mInstance == null) {
                    ViewShapeManager.mInstance = new ViewShapeManager();
                }
                viewShapeManager = ViewShapeManager.mInstance;
                Intrinsics.checkNotNull(viewShapeManager, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.app.common.util.ViewShapeManager");
            } catch (Throwable th) {
                throw th;
            }
            return viewShapeManager;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Path getDefaultNoteHolderShapePath(int viewMode, float width, float height, boolean isDexMode, boolean isRTLMode) {
        return getNoteHolderShapePath(viewMode, width, height, 0.0f, isDexMode, isRTLMode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Path getFavoriteNoteHolderShapePath(int viewMode, float width, float height, boolean isDexMode, boolean isRTLMode) {
        return getNoteHolderShapePath(viewMode, width, height, getFavoriteCut(viewMode, isDexMode), isDexMode, isRTLMode);
    }

    @NotNull
    public static final synchronized ViewShapeManager getInstance() {
        return INSTANCE.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Path getNoteHolderShapePath(int viewMode, float width, float height, float rightTopCut, boolean isDexMode, boolean isRTLMode) {
        Path pathRoundPolygon;
        String str = viewMode + "," + width + "," + height + "," + rightTopCut + "," + isDexMode + "," + isRTLMode;
        Path path = mNoteHolderShapePaths.get(str);
        if (path != null) {
            return path;
        }
        init(isDexMode);
        Float f = this.noteHolderRadius.get(Boolean.valueOf(isDexMode));
        Intrinsics.checkNotNull(f);
        float fFloatValue = f.floatValue();
        if (rightTopCut <= fFloatValue) {
            pathRoundPolygon = new Path();
            pathRoundPolygon.addRoundRect(new RectF(0.0f, 0.0f, width, height), new float[]{fFloatValue, fFloatValue, fFloatValue, fFloatValue, fFloatValue, fFloatValue, fFloatValue, fFloatValue}, Path.Direction.CW);
            pathRoundPolygon.close();
        } else {
            List<? extends PointF> listListOf = isRTLMode ? CollectionsKt.listOf((Object[]) new PointF[]{new PointF(width, 0.0f), new PointF(rightTopCut, 0.0f), new PointF(0.0f, rightTopCut), new PointF(0.0f, height), new PointF(width, height)}) : CollectionsKt.listOf((Object[]) new PointF[]{new PointF(0.0f, 0.0f), new PointF(width - rightTopCut, 0.0f), new PointF(width, rightTopCut), new PointF(width, height), new PointF(0.0f, height)});
            Float f4 = this.noteHolderCutCornerRadius.get(Boolean.valueOf(isDexMode));
            Intrinsics.checkNotNull(f4);
            float fFloatValue2 = f4.floatValue();
            pathRoundPolygon = roundPolygon(listListOf, CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(fFloatValue), Float.valueOf(fFloatValue2), Float.valueOf(fFloatValue2), Float.valueOf(fFloatValue), Float.valueOf(fFloatValue)}));
        }
        mNoteHolderShapePaths.put(str, pathRoundPolygon);
        return pathRoundPolygon;
    }

    private final Path roundPolygon(List<? extends PointF> points, List<Float> radii) {
        List<? extends PointF> list = points;
        int size = list.size();
        if (size < 3) {
            throw new IllegalArgumentException("polygon must have at least 3 points");
        }
        Path path = new Path();
        int i = 0;
        while (i < size) {
            PointF pointF = list.get(((i + size) - 1) % size);
            PointF pointF2 = list.get(i);
            int i2 = i + 1;
            PointF pointF3 = list.get(i2 % size);
            float fFloatValue = radii.get(i).floatValue();
            float f = pointF2.x;
            float f4 = f - pointF.x;
            float f5 = pointF2.y;
            float f6 = f5 - pointF.y;
            float f7 = pointF3.x - f;
            float f8 = pointF3.y - f5;
            int i4 = size;
            float fHypot = (float) Math.hypot(f4, f6);
            int i5 = i;
            float fHypot2 = (float) Math.hypot(f7, f8);
            if (fHypot < 0.001f || fHypot2 < 0.001f) {
                float f9 = pointF2.x;
                if (i5 == 0) {
                    path.moveTo(f9, pointF2.y);
                } else {
                    path.lineTo(f9, pointF2.y);
                }
            } else {
                float f10 = f4 / fHypot;
                float f11 = f6 / fHypot;
                float f12 = f7 / fHypot2;
                float f13 = f8 / fHypot2;
                float fCoerceAtMost = RangesKt.coerceAtMost(fFloatValue, RangesKt.coerceAtMost(fHypot, fHypot2) / 2.0f);
                float f14 = pointF2.x;
                float f15 = f14 - (f10 * fCoerceAtMost);
                float f16 = pointF2.y;
                float f17 = f16 - (f11 * fCoerceAtMost);
                float f18 = (f12 * fCoerceAtMost) + f14;
                float f19 = (f13 * fCoerceAtMost) + f16;
                if (i5 == 0) {
                    path.moveTo(f15, f17);
                } else {
                    path.lineTo(f15, f17);
                }
                path.quadTo(pointF2.x, pointF2.y, f18, f19);
            }
            list = points;
            i = i2;
            size = i4;
        }
        path.close();
        return path;
    }

    @NotNull
    public final ViewOutlineProvider getDefaultNoteHolderOutlineProvider(final int viewMode) {
        return new ViewOutlineProvider() { // from class: com.samsung.android.support.senl.nt.app.common.util.ViewShapeManager.getDefaultNoteHolderOutlineProvider.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(outline, "outline");
                Path defaultNoteHolderShapePath = ViewShapeManager.this.getDefaultNoteHolderShapePath(viewMode, view.getWidth(), view.getHeight(), DesktopModeCompat.INSTANCE.getInstance().isDexMode(view.getContext()), LocaleUtils.isRTLMode());
                if (Build.VERSION.SDK_INT >= 30) {
                    outline.setPath(defaultNoteHolderShapePath);
                } else {
                    outline.setConvexPath(defaultNoteHolderShapePath);
                }
            }
        };
    }

    public final float getFavoriteCut(int viewMode, boolean isDexMode) {
        init(isDexMode);
        if (viewMode == 2) {
            Float f = this.noteHolderLargeGridFavoriteCut.get(Boolean.valueOf(isDexMode));
            Intrinsics.checkNotNull(f);
            return f.floatValue();
        }
        if (viewMode != 4) {
            Float f4 = this.noteHolderListFavoriteCut.get(Boolean.valueOf(isDexMode));
            Intrinsics.checkNotNull(f4);
            return f4.floatValue();
        }
        Float f5 = this.noteHolderSmallGridFavoriteCut.get(Boolean.valueOf(isDexMode));
        Intrinsics.checkNotNull(f5);
        return f5.floatValue();
    }

    @NotNull
    public final ViewOutlineProvider getFavoriteNoteHolderOutlineProvider(final int viewMode) {
        return new ViewOutlineProvider() { // from class: com.samsung.android.support.senl.nt.app.common.util.ViewShapeManager.getFavoriteNoteHolderOutlineProvider.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(outline, "outline");
                Path favoriteNoteHolderShapePath = ViewShapeManager.this.getFavoriteNoteHolderShapePath(viewMode, view.getWidth(), view.getHeight(), DesktopModeCompat.INSTANCE.getInstance().isDexMode(view.getContext()), LocaleUtils.isRTLMode());
                if (Build.VERSION.SDK_INT >= 30) {
                    outline.setPath(favoriteNoteHolderShapePath);
                } else {
                    outline.setConvexPath(favoriteNoteHolderShapePath);
                }
            }
        };
    }

    @NotNull
    public final ViewOutlineProvider getFolderPathOutlineProvider(final float value, final boolean isDexMode) {
        return new ViewOutlineProvider() { // from class: com.samsung.android.support.senl.nt.app.common.util.ViewShapeManager.getFolderPathOutlineProvider.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(outline, "outline");
                float width = view.getWidth();
                float height = view.getHeight();
                Path path = new Path();
                float f = ((width - height) * value) + height;
                this.init(isDexMode);
                Object obj = this.folderPathLayoutRadius.get(Boolean.valueOf(isDexMode));
                Intrinsics.checkNotNull(obj);
                float fFloatValue = ((Number) obj).floatValue();
                path.addRoundRect(new RectF(0.0f, 0.0f, f, height), new float[]{fFloatValue, fFloatValue, fFloatValue, fFloatValue, fFloatValue, fFloatValue, fFloatValue, fFloatValue}, Path.Direction.CW);
                path.close();
                if (Build.VERSION.SDK_INT >= 30) {
                    outline.setPath(path);
                } else {
                    outline.setConvexPath(path);
                }
            }
        };
    }

    @NotNull
    public final ViewOutlineProvider getNoteHolderOutlineProvider(final int viewMode, final float cut) {
        return new ViewOutlineProvider() { // from class: com.samsung.android.support.senl.nt.app.common.util.ViewShapeManager.getNoteHolderOutlineProvider.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(outline, "outline");
                Path noteHolderShapePath = ViewShapeManager.this.getNoteHolderShapePath(viewMode, view.getWidth(), view.getHeight(), cut, DesktopModeCompat.INSTANCE.getInstance().isDexMode(view.getContext()), LocaleUtils.isRTLMode());
                if (Build.VERSION.SDK_INT >= 30) {
                    outline.setPath(noteHolderShapePath);
                } else {
                    outline.setConvexPath(noteHolderShapePath);
                }
            }
        };
    }

    public final void init(boolean isDexMode) {
        if (this.noteHolderRadius.containsKey(Boolean.valueOf(isDexMode))) {
            return;
        }
        this.noteHolderRadius.put(Boolean.valueOf(isDexMode), Float.valueOf(BaseUtils.getContext().getResources().getDimension(C8003R.dimen.notes_grid_item_radius)));
        this.noteHolderCutCornerRadius.put(Boolean.valueOf(isDexMode), Float.valueOf(BaseUtils.getContext().getResources().getDimension(C8003R.dimen.notes_grid_item_cut_corner_radius)));
        this.noteHolderSmallGridFavoriteCut.put(Boolean.valueOf(isDexMode), Float.valueOf(BaseUtils.getContext().getResources().getDimension(C8003R.dimen.noteslist_item_small_grid_favorite_cut_radius)));
        this.noteHolderLargeGridFavoriteCut.put(Boolean.valueOf(isDexMode), Float.valueOf(BaseUtils.getContext().getResources().getDimension(C8003R.dimen.noteslist_item_large_grid_favorite_cut_radius)));
        this.noteHolderListFavoriteCut.put(Boolean.valueOf(isDexMode), Float.valueOf(BaseUtils.getContext().getResources().getDimension(C8003R.dimen.noteslist_item_list_favorite_cut_radius)));
        this.folderPathLayoutRadius.put(Boolean.valueOf(isDexMode), Float.valueOf(BaseUtils.getContext().getResources().getDimension(C8003R.dimen.folderpath_layout_background_radius)));
    }
}
