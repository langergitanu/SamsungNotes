package com.samsung.android.sdk.pen.setting.patternpalette;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.common.SpenTabGroup;
import com.samsung.android.sdk.pen.setting.patternpalette.SpenPatternLayoutInterface;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilOutlineProvider;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.request.ImportHandler;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0017\b\u0000\u0018\u0000 12\u00020\u00012\u00020\u0002:\u000212B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\u0018\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\u0012\u0010\u001d\u001a\u00020\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u0011H\u0016J&\u0010\u001f\u001a\u00020\u00152\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\b2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\bH\u0016J\u0018\u0010 \u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\tH\u0002J&\u0010\"\u001a\u00020\u00132\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\b2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\bH\u0002J\b\u0010#\u001a\u00020\u0013H\u0002J*\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00012\b\u0010&\u001a\u0004\u0018\u00010\f2\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\tH\u0002J\u0010\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\tH\u0002J\u0010\u0010)\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u001cH\u0002J\u0012\u0010,\u001a\u0004\u0018\u00010\f2\u0006\u0010-\u001a\u00020\tH\u0002J\u0012\u0010.\u001a\u00020\u00132\b\u0010&\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\u0019H\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/patternpalette/SpenMosaicPatternLayout;", "Landroid/widget/FrameLayout;", "Lcom/samsung/android/sdk/pen/setting/patternpalette/SpenPatternLayoutInterface;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "itemIds", "", "", "items", "", "Lcom/samsung/android/sdk/pen/setting/patternpalette/SpenMosaicPatternLayout$Item;", "tabGroup", "Lcom/samsung/android/sdk/pen/setting/common/SpenTabGroup;", "selectResourceId", "patternChangedListener", "Lcom/samsung/android/sdk/pen/setting/patternpalette/SpenPatternLayoutInterface$OnPatternChangeListener;", "close", "", "setPattern", "", "patternResId", "needAnimation", "patternResName", "", "setPatternSize", "patternSize", "", "setOnPatternChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setPatternList", "construct", "layoutId", "setData", "updateViews", "updateView", "typeView", "item", "current", ImportHandler.KEY_TOTAL, "findViewId", "resourceId", "size", "findItem", "viewId", "changePattern", "getDrawableId", "drawable", "Companion", "Item", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenMosaicPatternLayout extends FrameLayout implements SpenPatternLayoutInterface {
    private static final int NO_SELECTED_PATTERN = 0;

    @NotNull
    private static final String TAG = "SpenMosaicPatternLayout";

    @NotNull
    private final List<Integer> itemIds;

    @NotNull
    private final List<Item> items;

    @Nullable
    private SpenPatternLayoutInterface.OnPatternChangeListener patternChangedListener;
    private int selectResourceId;
    private SpenTabGroup tabGroup;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/patternpalette/SpenMosaicPatternLayout$Item;", "", "resourceName", "", "resourceId", "", "size", "", "<init>", "(Ljava/lang/String;IF)V", "getResourceName", "()Ljava/lang/String;", "getResourceId", "()I", "getSize", "()F", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final /* data */ class Item {
        private final int resourceId;

        @NotNull
        private final String resourceName;
        private final float size;

        public Item(@NotNull String resourceName, int i, float f) {
            Intrinsics.checkNotNullParameter(resourceName, "resourceName");
            this.resourceName = resourceName;
            this.resourceId = i;
            this.size = f;
        }

        public static /* synthetic */ Item copy$default(Item item, String str, int i, float f, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = item.resourceName;
            }
            if ((i2 & 2) != 0) {
                i = item.resourceId;
            }
            if ((i2 & 4) != 0) {
                f = item.size;
            }
            return item.copy(str, i, f);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getResourceName() {
            return this.resourceName;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getResourceId() {
            return this.resourceId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final float getSize() {
            return this.size;
        }

        @NotNull
        public final Item copy(@NotNull String resourceName, int resourceId, float size) {
            Intrinsics.checkNotNullParameter(resourceName, "resourceName");
            return new Item(resourceName, resourceId, size);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Item)) {
                return false;
            }
            Item item = (Item) other;
            return Intrinsics.areEqual(this.resourceName, item.resourceName) && this.resourceId == item.resourceId && Float.compare(this.size, item.size) == 0;
        }

        public final int getResourceId() {
            return this.resourceId;
        }

        @NotNull
        public final String getResourceName() {
            return this.resourceName;
        }

        public final float getSize() {
            return this.size;
        }

        public int hashCode() {
            return Float.hashCode(this.size) + AbstractC0622a.m1157c(this.resourceId, this.resourceName.hashCode() * 31, 31);
        }

        @NotNull
        public String toString() {
            String str = this.resourceName;
            int i = this.resourceId;
            return AbstractC1038a.m1217r(AbstractC0541b.m780v("Item(resourceName=", i, str, ", resourceId=", ", size="), ")", this.size);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenMosaicPatternLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.itemIds = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(C7932R.id.pattern_view_level1), Integer.valueOf(C7932R.id.pattern_view_level2), Integer.valueOf(C7932R.id.pattern_view_level3)});
        this.items = new ArrayList();
        construct(context, C7932R.layout.setting_mosaic_pattern_layout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void changePattern(Item item) {
        if (item == null || item.getResourceId() == this.selectResourceId) {
            return;
        }
        this.selectResourceId = item.getResourceId();
        Log.i(TAG, "onPatternChanged() [" + item.getResourceName() + SQLKeyword.COMMA + item.getSize() + "]");
        SpenPatternLayoutInterface.OnPatternChangeListener onPatternChangeListener = this.patternChangedListener;
        if (onPatternChangeListener != null) {
            onPatternChangeListener.onPatternChanged(item.getResourceName(), item.getResourceId(), item.getSize());
        }
    }

    private final void construct(Context context, int layoutId) {
        SpenTabGroup spenTabGroup;
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        ((LayoutInflater) systemService).inflate(layoutId, (ViewGroup) this, true);
        this.tabGroup = new SpenTabGroup();
        Iterator<Integer> it = this.itemIds.iterator();
        while (true) {
            spenTabGroup = null;
            if (!it.hasNext()) {
                break;
            }
            int iIntValue = it.next().intValue();
            SpenTabGroup spenTabGroup2 = this.tabGroup;
            if (spenTabGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabGroup");
            } else {
                spenTabGroup = spenTabGroup2;
            }
            spenTabGroup.addTab(findViewById(iIntValue));
        }
        SpenTabGroup spenTabGroup3 = this.tabGroup;
        if (spenTabGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabGroup");
        } else {
            spenTabGroup = spenTabGroup3;
        }
        spenTabGroup.setOnTabSelectedListener(new SpenTabGroup.OnTabSelectedListener() { // from class: com.samsung.android.sdk.pen.setting.patternpalette.SpenMosaicPatternLayout.construct.1
            @Override // com.samsung.android.sdk.pen.setting.common.SpenTabGroup.OnTabSelectedListener
            public void onTabSelected(View tab) {
                Log.i(SpenMosaicPatternLayout.TAG, "onTabSelected()");
                if (tab == null) {
                    return;
                }
                SpenMosaicPatternLayout spenMosaicPatternLayout = SpenMosaicPatternLayout.this;
                spenMosaicPatternLayout.changePattern(spenMosaicPatternLayout.findItem(tab.getId()));
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenTabGroup.OnTabSelectedListener
            public void onTabReselected(View tab) {
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenTabGroup.OnTabSelectedListener
            public void onTabUnselected(View tab) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Item findItem(int viewId) {
        int iIndexOf = this.itemIds.indexOf(Integer.valueOf(viewId));
        if (iIndexOf <= -1 || iIndexOf >= this.items.size()) {
            return null;
        }
        return this.items.get(iIndexOf);
    }

    private final int findViewId(int resourceId) {
        Iterator<T> it = this.items.iterator();
        int i = -1;
        int i2 = 0;
        while (it.hasNext()) {
            int i4 = i2 + 1;
            if (((Item) it.next()).getResourceId() == resourceId) {
                i = i2;
            }
            i2 = i4;
        }
        if (i == -1) {
            return 0;
        }
        return this.itemIds.get(i).intValue();
    }

    private final int getDrawableId(String drawable) {
        int identifier = getContext().getResources().getIdentifier(drawable, "drawable", getContext().getPackageName());
        if (identifier == 0) {
            Log.e(TAG, "Resource is not founded");
        }
        return identifier;
    }

    private final void setData(List<String> patternResName, List<Float> patternSize) {
        this.items.clear();
        int iMin = Math.min(patternResName.size(), this.itemIds.size());
        int i = 0;
        while (i < iMin) {
            int drawableId = getDrawableId(patternResName.get(i));
            if (drawableId != 0) {
                this.items.add(new Item(patternResName.get(i), drawableId, (patternSize == null || patternSize.size() <= i) ? 0.0f : patternSize.get(i).floatValue()));
            }
            i++;
        }
    }

    private final void updateView(FrameLayout typeView, Item item, int current, int total) {
        if (item == null) {
            View childAt = typeView.getChildAt(0);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.ImageView");
            ((ImageView) childAt).setImageResource(0);
            typeView.setTooltipText(null);
            typeView.setContentDescription(null);
            typeView.setOnClickListener(new ViewOnClickListenerC7602a(0));
            return;
        }
        String string = getContext().getResources().getString(C7932R.string.pen_string_lever, Integer.valueOf(current), Integer.valueOf(total));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        View childAt2 = typeView.getChildAt(0);
        Intrinsics.checkNotNull(childAt2, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) childAt2;
        imageView.setImageResource(item.getResourceId());
        imageView.setClipToOutline(true);
        imageView.setOutlineProvider(SpenSettingUtilOutlineProvider.INSTANCE.getCircleOutlineProvider());
        typeView.setTooltipText(string);
        typeView.setContentDescription(string);
    }

    private final void updateViews() {
        Iterator<Integer> it = this.itemIds.iterator();
        int i = 0;
        while (it.hasNext()) {
            View viewFindViewById = findViewById(it.next().intValue());
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            Item item = (Item) CollectionsKt.getOrNull(this.items, i);
            i++;
            updateView((FrameLayout) viewFindViewById, item, i, this.itemIds.size());
        }
        int i2 = this.selectResourceId;
        if (i2 != 0) {
            setPattern(i2, false);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.patternpalette.SpenPatternLayoutInterface
    public void close() {
        SpenTabGroup spenTabGroup = this.tabGroup;
        if (spenTabGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabGroup");
            spenTabGroup = null;
        }
        spenTabGroup.close();
        this.patternChangedListener = null;
        this.selectResourceId = 0;
    }

    @Override // com.samsung.android.sdk.pen.setting.patternpalette.SpenPatternLayoutInterface
    public void setOnPatternChangedListener(@Nullable SpenPatternLayoutInterface.OnPatternChangeListener listener) {
        this.patternChangedListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.patternpalette.SpenPatternLayoutInterface
    public boolean setPattern(int patternResId, boolean needAnimation) {
        Log.d(TAG, "setPattern() patternResId=" + patternResId + " animation=" + needAnimation);
        this.selectResourceId = patternResId;
        SpenTabGroup spenTabGroup = this.tabGroup;
        if (spenTabGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabGroup");
            spenTabGroup = null;
        }
        spenTabGroup.select(findViewId(patternResId));
        return true;
    }

    @Override // com.samsung.android.sdk.pen.setting.patternpalette.SpenPatternLayoutInterface
    public boolean setPatternList(@NotNull List<String> patternResName, @Nullable List<Float> patternSize) {
        Intrinsics.checkNotNullParameter(patternResName, "patternResName");
        AbstractC2322a.m1631u(patternResName.size(), "setPatternList() size=", TAG);
        setData(patternResName, patternSize);
        updateViews();
        return true;
    }

    @Override // com.samsung.android.sdk.pen.setting.patternpalette.SpenPatternLayoutInterface
    public boolean setPatternSize(float patternSize, boolean needAnimation) {
        Log.d(TAG, "setPattern() patternSize=" + patternSize + " animation=" + needAnimation);
        Item itemFindItem = findItem(findViewId(patternSize));
        if (itemFindItem == null) {
            return true;
        }
        setPattern(itemFindItem.getResourceId(), needAnimation);
        return true;
    }

    private final int findViewId(float size) {
        Iterator<T> it = this.items.iterator();
        int i = -1;
        int i2 = 0;
        while (it.hasNext()) {
            int i4 = i2 + 1;
            if (((Item) it.next()).getSize() == size) {
                i = i2;
            }
            i2 = i4;
        }
        if (i == -1) {
            return 0;
        }
        return this.itemIds.get(i).intValue();
    }

    @Override // com.samsung.android.sdk.pen.setting.patternpalette.SpenPatternLayoutInterface
    public boolean setPattern(@NotNull String patternResName, boolean needAnimation) {
        Intrinsics.checkNotNullParameter(patternResName, "patternResName");
        Log.d(TAG, "setPattern() resName=" + patternResName);
        return setPattern(getDrawableId(patternResName), needAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateView$lambda$4$lambda$3(View view) {
    }
}
