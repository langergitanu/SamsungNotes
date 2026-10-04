package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sesl.visualeffect.lighteffects.processinglight.C7868a;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTCircularRoundLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.animation.QTAnimationKt;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\f\u0018\u0000 )2\u00020\u0001:\u0005%&'()B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015J\u0014\u0010\u0016\u001a\u00020\u00122\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018J\u000e\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0007J\u0016\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eJ\u001e\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u0015J\u0006\u0010$\u001a\u00020\u0012R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTColorDialLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mActionListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTColorDialLayout$ActionListener;", "mCircularViewAdapter", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorAdapter;", "mCircularRecycleView", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorRecycleView;", "mCircularRoundLayout", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTCircularRoundLayout;", "mSelectedDialItemIdx", "", "mDialItemCount", "close", "", "showAnimation", "isShown", "", "setDialItems", "items", "", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTColorDialLayout$ColorDialItem;", "setActionListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "isScrollAt", "rawX", "", "rawY", "setDialItemSelected", "index", "selected", "moveToCurrent", Constants.IntentExtraValue.SHOW, "DialItemType", "ColorDialItem", "FixedItem", "ActionListener", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SettingQTColorDialLayout extends RelativeLayout {
    public static final float BACKGROUND_END_ANGLE = 45.0f;
    public static final float BACKGROUND_START_ANGLE = 300.0f;
    public static final long SCALE_IN_DURATION = 400;
    public static final long SCALE_OUT_DURATION = 350;
    public static final long START_DELAY_PER_ITEM = 16;

    @NotNull
    private static final String TAG = "SettingQTColorDialLayout";
    public static final int VISIBLE_ITEM_SIZE = 8;

    @Nullable
    private ActionListener mActionListener;

    @NotNull
    private final QTColorRecycleView mCircularRecycleView;

    @NotNull
    private final QTCircularRoundLayout mCircularRoundLayout;

    @NotNull
    private final QTColorAdapter mCircularViewAdapter;
    private int mDialItemCount;
    private int mSelectedDialItemIdx;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTColorDialLayout$ActionListener;", "", "onDialButtonClick", "", "oldIndex", "", "newIndex", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ActionListener {
        void onDialButtonClick(int oldIndex, int newIndex);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTColorDialLayout$DialItemType;", "", "<init>", "(Ljava/lang/String;I)V", "COLOR", "EMPTY", "DIVIDER", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class DialItemType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ DialItemType[] $VALUES;
        public static final DialItemType COLOR = new DialItemType("COLOR", 0);
        public static final DialItemType EMPTY = new DialItemType("EMPTY", 1);
        public static final DialItemType DIVIDER = new DialItemType("DIVIDER", 2);

        private static final /* synthetic */ DialItemType[] $values() {
            return new DialItemType[]{COLOR, EMPTY, DIVIDER};
        }

        static {
            DialItemType[] dialItemTypeArr$values = $values();
            $VALUES = dialItemTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(dialItemTypeArr$values);
        }

        private DialItemType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<DialItemType> getEntries() {
            return $ENTRIES;
        }

        public static DialItemType valueOf(String str) {
            return (DialItemType) Enum.valueOf(DialItemType.class, str);
        }

        public static DialItemType[] values() {
            return (DialItemType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingQTColorDialLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(C9086R.layout.qt_dial_layout, (ViewGroup) this, true);
        View viewFindViewById = findViewById(C9086R.id.circular_mask_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        QTCircularRoundLayout qTCircularRoundLayout = (QTCircularRoundLayout) viewFindViewById;
        this.mCircularRoundLayout = qTCircularRoundLayout;
        qTCircularRoundLayout.setAngle(300.0f, 45.0f);
        qTCircularRoundLayout.setAnimationFillType(QTCircularRoundLayout.AnimationFillType.START_TO_END);
        QTColorAdapter qTColorAdapter = new QTColorAdapter(new C7868a(this, 3));
        this.mCircularViewAdapter = qTColorAdapter;
        View viewFindViewById2 = findViewById(C9086R.id.circular_recycle_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        QTColorRecycleView qTColorRecycleView = (QTColorRecycleView) viewFindViewById2;
        this.mCircularRecycleView = qTColorRecycleView;
        qTColorRecycleView.setAdapter(qTColorAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(SettingQTColorDialLayout settingQTColorDialLayout, View view, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        ActionListener actionListener = settingQTColorDialLayout.mActionListener;
        if (actionListener != null) {
            actionListener.onDialButtonClick(i, i2);
        }
        return Unit.INSTANCE;
    }

    public final void close() {
        this.mActionListener = null;
        this.mCircularRecycleView.close();
    }

    public final boolean isScrollAt(float rawX, float rawY) {
        return this.mCircularRoundLayout.isRawPointInPath(rawX, rawY);
    }

    public final void setActionListener(@NotNull ActionListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mActionListener = listener;
    }

    public final void setDialItemSelected(int index, boolean selected, boolean moveToCurrent) {
        AbstractC8014b.m7222x(AbstractC2821a.m2226q("setDialItemSelected index=", index, " selected=", selected, " moveToCurrent="), moveToCurrent, TAG);
        if (selected) {
            this.mCircularRecycleView.setSelectedColor(index, moveToCurrent);
            if (index >= 0) {
                this.mSelectedDialItemIdx = index;
            }
        }
    }

    public final void setDialItems(@NotNull List<ColorDialItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        Logger.m11003i(TAG, "setDialItems() size=" + items.size());
        this.mDialItemCount = items.size();
        this.mCircularViewAdapter.updateDialItems(items);
        this.mCircularRecycleView.setDialItems(items);
    }

    public final void show() {
        this.mCircularRoundLayout.startAnimation(true);
        RecyclerView.LayoutManager layoutManager = this.mCircularRecycleView.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTColorLayoutManager");
        int firstVisiblePosition = ((QTColorLayoutManager) layoutManager).getMFirstVisibleItemPos();
        for (int i = 1; i < 9; i++) {
            RecyclerView.ViewHolder viewHolderFindViewHolderForLayoutPosition = this.mCircularRecycleView.findViewHolderForLayoutPosition((i + firstVisiblePosition) % this.mDialItemCount);
            if (viewHolderFindViewHolderForLayoutPosition != null) {
                View itemView = viewHolderFindViewHolderForLayoutPosition.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                QTAnimationKt.scale(itemView, 0.0f, 1.0f, ((long) i) * 16, 400L);
            }
        }
    }

    public final void showAnimation(boolean isShown) {
        if (isShown) {
            if (getWidth() == 0 || getHeight() == 0) {
                this.mCircularRecycleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTColorDialLayout.showAnimation.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        SettingQTColorDialLayout.this.mCircularRecycleView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        SettingQTColorDialLayout.this.show();
                    }
                });
            } else {
                show();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTColorDialLayout$FixedItem;", "", "resourceId", "", "selectorResId", "description", "", "<init>", "(IILjava/lang/CharSequence;)V", "getResourceId", "()I", "getSelectorResId", "getDescription", "()Ljava/lang/CharSequence;", "setDescription", "(Ljava/lang/CharSequence;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final /* data */ class FixedItem {

        @Nullable
        private CharSequence description;
        private final int resourceId;
        private final int selectorResId;

        public FixedItem(int i, int i2, @Nullable CharSequence charSequence) {
            this.resourceId = i;
            this.selectorResId = i2;
            this.description = charSequence;
        }

        public static /* synthetic */ FixedItem copy$default(FixedItem fixedItem, int i, int i2, CharSequence charSequence, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = fixedItem.resourceId;
            }
            if ((i4 & 2) != 0) {
                i2 = fixedItem.selectorResId;
            }
            if ((i4 & 4) != 0) {
                charSequence = fixedItem.description;
            }
            return fixedItem.copy(i, i2, charSequence);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getResourceId() {
            return this.resourceId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getSelectorResId() {
            return this.selectorResId;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final CharSequence getDescription() {
            return this.description;
        }

        @NotNull
        public final FixedItem copy(int resourceId, int selectorResId, @Nullable CharSequence description) {
            return new FixedItem(resourceId, selectorResId, description);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FixedItem)) {
                return false;
            }
            FixedItem fixedItem = (FixedItem) other;
            return this.resourceId == fixedItem.resourceId && this.selectorResId == fixedItem.selectorResId && Intrinsics.areEqual(this.description, fixedItem.description);
        }

        @Nullable
        public final CharSequence getDescription() {
            return this.description;
        }

        public final int getResourceId() {
            return this.resourceId;
        }

        public final int getSelectorResId() {
            return this.selectorResId;
        }

        public int hashCode() {
            int iM1157c = AbstractC0622a.m1157c(this.selectorResId, Integer.hashCode(this.resourceId) * 31, 31);
            CharSequence charSequence = this.description;
            return iM1157c + (charSequence == null ? 0 : charSequence.hashCode());
        }

        public final void setDescription(@Nullable CharSequence charSequence) {
            this.description = charSequence;
        }

        @NotNull
        public String toString() {
            int i = this.resourceId;
            int i2 = this.selectorResId;
            CharSequence charSequence = this.description;
            StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "FixedItem(resourceId=", ", selectorResId=", ", description=");
            sbM1173s.append((Object) charSequence);
            sbM1173s.append(")");
            return sbM1173s.toString();
        }

        public /* synthetic */ FixedItem(int i, int i2, CharSequence charSequence, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? null : charSequence);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J=\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010!\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0005HÖ\u0001J\t\u0010$\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0017R\u001a\u0010\n\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0017\"\u0004\b\u0019\u0010\u001a¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTColorDialLayout$ColorDialItem;", "", "type", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTColorDialLayout$DialItemType;", "color", "", "description", "", "isRecent", "", "selected", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTColorDialLayout$DialItemType;ILjava/lang/String;ZZ)V", "getType", "()Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTColorDialLayout$DialItemType;", "setType", "(Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTColorDialLayout$DialItemType;)V", "getColor", "()I", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "()Z", "getSelected", "setSelected", "(Z)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final /* data */ class ColorDialItem {
        private final int color;

        @Nullable
        private String description;
        private final boolean isRecent;
        private boolean selected;

        @NotNull
        private DialItemType type;

        public ColorDialItem(@NotNull DialItemType type, int i, @Nullable String str, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
            this.color = i;
            this.description = str;
            this.isRecent = z;
            this.selected = z2;
        }

        public static /* synthetic */ ColorDialItem copy$default(ColorDialItem colorDialItem, DialItemType dialItemType, int i, String str, boolean z, boolean z2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                dialItemType = colorDialItem.type;
            }
            if ((i2 & 2) != 0) {
                i = colorDialItem.color;
            }
            if ((i2 & 4) != 0) {
                str = colorDialItem.description;
            }
            if ((i2 & 8) != 0) {
                z = colorDialItem.isRecent;
            }
            if ((i2 & 16) != 0) {
                z2 = colorDialItem.selected;
            }
            boolean z3 = z2;
            String str2 = str;
            return colorDialItem.copy(dialItemType, i, str2, z, z3);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final DialItemType getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getColor() {
            return this.color;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsRecent() {
            return this.isRecent;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getSelected() {
            return this.selected;
        }

        @NotNull
        public final ColorDialItem copy(@NotNull DialItemType type, int color, @Nullable String description, boolean isRecent, boolean selected) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new ColorDialItem(type, color, description, isRecent, selected);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ColorDialItem)) {
                return false;
            }
            ColorDialItem colorDialItem = (ColorDialItem) other;
            return this.type == colorDialItem.type && this.color == colorDialItem.color && Intrinsics.areEqual(this.description, colorDialItem.description) && this.isRecent == colorDialItem.isRecent && this.selected == colorDialItem.selected;
        }

        public final int getColor() {
            return this.color;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        public final boolean getSelected() {
            return this.selected;
        }

        @NotNull
        public final DialItemType getType() {
            return this.type;
        }

        public int hashCode() {
            int iM1157c = AbstractC0622a.m1157c(this.color, this.type.hashCode() * 31, 31);
            String str = this.description;
            return Boolean.hashCode(this.selected) + AbstractC0622a.m1160f(this.isRecent, (iM1157c + (str == null ? 0 : str.hashCode())) * 31, 31);
        }

        public final boolean isRecent() {
            return this.isRecent;
        }

        public final void setDescription(@Nullable String str) {
            this.description = str;
        }

        public final void setSelected(boolean z) {
            this.selected = z;
        }

        public final void setType(@NotNull DialItemType dialItemType) {
            Intrinsics.checkNotNullParameter(dialItemType, "<set-?>");
            this.type = dialItemType;
        }

        @NotNull
        public String toString() {
            DialItemType dialItemType = this.type;
            int i = this.color;
            String str = this.description;
            boolean z = this.isRecent;
            boolean z2 = this.selected;
            StringBuilder sb = new StringBuilder("ColorDialItem(type=");
            sb.append(dialItemType);
            sb.append(", color=");
            sb.append(i);
            sb.append(", description=");
            sb.append(str);
            sb.append(", isRecent=");
            sb.append(z);
            sb.append(", selected=");
            return AbstractC0000a.m14k(sb, z2, ")");
        }

        public /* synthetic */ ColorDialItem(DialItemType dialItemType, int i, String str, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(dialItemType, i, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? false : z2);
        }
    }
}
