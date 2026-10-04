package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.SeslSeekBar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.sdk.smp.SmpConstants;
import com.samsung.android.support.senl.p145cm.base.framework.feature.FloatingFeature;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.VoiceViewState;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.RunnableC9767a;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.RunnableC9844c;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.voice.VoiceUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.VoiceRecordMenuAdapter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.animation.STTGuideTip;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.animation.VoiceRecordItemAnimator;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;
import p070Q1.RunnableC0218a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\u0011\b\u0000\u0018\u0000 V2\u00020\u0001:\u0003TUVB#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0002J\b\u0010 \u001a\u00020\u0017H\u0002J\b\u0010&\u001a\u00020\u0017H\u0002J\u0006\u0010'\u001a\u00020\u0017J\u0010\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u0013H\u0002J\u000e\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u0013J\u0006\u0010,\u001a\u00020\u0017J\u0006\u0010-\u001a\u00020\u0017J\b\u0010.\u001a\u00020\u0017H\u0007J\u000e\u0010/\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u0013J\u000e\u00100\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u0013J\u000e\u00101\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u0013J\u0010\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u000204H\u0002J\u0006\u00105\u001a\u00020\u0017J\u0016\u00106\u001a\u00020\u00172\u0006\u00107\u001a\u00020\u00132\u0006\u00108\u001a\u00020\u0011J\u0014\u00109\u001a\u00020\u00172\f\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;J\u0006\u0010=\u001a\u00020\u0017J\u0006\u0010>\u001a\u00020\u0017J\u0010\u0010?\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u0006\u0010@\u001a\u00020\u0017J\b\u0010A\u001a\u00020\u0017H\u0002J\u0006\u0010B\u001a\u00020\u0017J.\u0010A\u001a\u00020\u00172\u0006\u0010C\u001a\u00020\u00132\u0006\u00107\u001a\u00020\u00132\u0006\u0010D\u001a\u00020\u00132\u0006\u00108\u001a\u00020\u00112\u0006\u0010E\u001a\u00020FJ\u0010\u0010G\u001a\u00020\u00172\u0006\u0010H\u001a\u00020\u0011H\u0002J\u000e\u0010I\u001a\u00020\u00172\u0006\u0010J\u001a\u00020\u0011J\u000e\u0010K\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u0013J\u000e\u0010L\u001a\u00020\u00172\u0006\u0010M\u001a\u00020\u0011J\u0016\u0010N\u001a\u00020\u00172\u0006\u0010O\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u0013J\b\u0010P\u001a\u00020\u0017H\u0016J\b\u0010Q\u001a\u00020\u0017H\u0016J\b\u0010R\u001a\u00020\u0017H\u0016J\u0006\u0010S\u001a\u00020\u0017R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u0004\u0018\u00010\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0016\u0010$\u001a\u0004\u0018\u00010\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010#¨\u0006W"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceRecordExpandSubMenu;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceRecordControlMenu;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "presenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordMenuPresenter;", "parent", "Landroid/view/View;", "<init>", "(Landroid/app/Activity;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordMenuPresenter;Landroid/view/View;)V", "mPlayTimeView", "Landroid/widget/TextView;", "mPlayListView", "Landroidx/recyclerview/widget/RecyclerView;", "mVoiceRecordMenuAdapter", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceRecordMenuAdapter;", "mIsTablet", "", "mStartSelect", "", "mOptionMenu", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceRecordExpandOptionMenu;", "insertSALog", "", "setPlayTimeView", "time", "", "initListView", SmpConstants.MARKETING_TYPE_POPUP, "Landroid/widget/PopupWindow;", "getPopup", "()Landroid/widget/PopupWindow;", "setPlayListViewOnMultiSelectedListener", "stateBadgeView", "getStateBadgeView", "()Landroid/view/View;", "guiView", "getGuiView", "showBadgeStt", "hideBadge", "toggleCheckBox", "position", "showEditTrashView", "selectedItem", "hideEditTrashView", "initRecordingList", "notifyDataSetChanged", "notifyItemRemoved", "notifyItemChanged", "notifyItemInserted", "notifyAdapter", "runnable", "Ljava/lang/Runnable;", "invalidateSeekBar", "setTheme", "bgColor", "isDarkTheme", "setPlayPoint", "voiceDataPlayPoints", "", "", "updatePlayPoint", "showRecordingPlayView", "setRecordPlayTime", "showRecordingListView", "updateBackground", "hideRecordingListView", "textIconColor", "dividerColor", "themeColor", "", "addItemDecoration", "isBackgroundDarkTheme", "setVoiceItemSelectMode", "selectMode", "updateSelectedItemText", "changeMode", "isEditMode", "showEditView", "selectedMode", "moveForwardSALog", "moveBackwardSALog", "updateView", "hidePopUpMenu", "LinearLayoutManagerWrapper", "VoiceRecordItemDecoration", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVoiceRecordExpandSubMenu.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VoiceRecordExpandSubMenu.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceRecordExpandSubMenu\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,520:1\n1#2:521\n*E\n"})
public final class VoiceRecordExpandSubMenu extends VoiceRecordControlMenu {

    @NotNull
    private static final String TAG;
    private final boolean mIsTablet;

    @NotNull
    private final VoiceRecordExpandOptionMenu mOptionMenu;

    @Nullable
    private RecyclerView mPlayListView;

    @Nullable
    private TextView mPlayTimeView;
    private int mStartSelect;

    @Nullable
    private VoiceRecordMenuAdapter mVoiceRecordMenuAdapter;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tR\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceRecordExpandSubMenu$LinearLayoutManagerWrapper;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "onLayoutChildren", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class LinearLayoutManagerWrapper extends LinearLayoutManager {
        public LinearLayoutManagerWrapper(@Nullable Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onLayoutChildren(@NotNull RecyclerView.Recycler recycler, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(recycler, "recycler");
            Intrinsics.checkNotNullParameter(state, "state");
            try {
                super.onLayoutChildren(recycler, state);
            } catch (IndexOutOfBoundsException e) {
                AbstractC8014b.m7198D("LinearLayoutManagerWrapper#onLayoutChildren# ", e.getMessage(), VoiceRecordExpandSubMenu.TAG);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceRecordExpandSubMenu$VoiceRecordItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "mColor", "", "mSize", "mMargin", "<init>", "(III)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class VoiceRecordItemDecoration extends RecyclerView.ItemDecoration {
        private final int mColor;
        private final int mMargin;
        private final int mSize;

        public VoiceRecordItemDecoration(int i, int i2, int i4) {
            this.mColor = i;
            this.mSize = i2;
            this.mMargin = i4;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDraw(@NotNull Canvas canvas, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            Paint paint = new Paint();
            paint.setColor(this.mColor);
            int left = parent.getLeft() + this.mMargin;
            int right = parent.getRight() - this.mMargin;
            int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                canvas.drawRect(left, parent.getChildAt(i).getBottom(), right, this.mSize + r1, paint);
            }
        }
    }

    static {
        String strCreateTag = Logger.createTag("VoiceRecordExpandSubMenu");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceRecordExpandSubMenu(@Nullable Activity activity, @NotNull VoiceRecordMenuPresenter presenter, @Nullable View view) {
        super(activity, presenter, view != null ? view.findViewById(C9086R.id.voice_menu_expand_simple) : null, false);
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        this.mIsTablet = presenter.isTabletLayout();
        this.mOptionMenu = new VoiceRecordExpandOptionMenu(activity, presenter);
    }

    private final void addItemDecoration(boolean isBackgroundDarkTheme) {
        Activity mActivity;
        RecyclerView recyclerView = this.mPlayListView;
        if (recyclerView == null || (mActivity = getMActivity()) == null) {
            return;
        }
        int itemDecorationCount = recyclerView.getItemDecorationCount();
        for (int i = 0; i < itemDecorationCount; i++) {
            recyclerView.removeItemDecorationAt(i);
        }
        recyclerView.addItemDecoration(new VoiceRecordItemDecoration(isBackgroundDarkTheme ? ContextCompat.getColor(mActivity, C9086R.color.composer_voice_menu_dark_item_divider) : ContextCompat.getColor(mActivity, C9086R.color.composer_voice_menu_item_divider), mActivity.getResources().getDimensionPixelSize(C9086R.dimen.voice_recording_divider_height), (int) mActivity.getResources().getDimension(C9086R.dimen.voice_recording_list_margin)));
    }

    private final View getGuiView() {
        RecyclerView recyclerView = this.mPlayListView;
        VoiceRecordMenuAdapter.VoiceMenuViewHolder voiceMenuViewHolder = (VoiceRecordMenuAdapter.VoiceMenuViewHolder) (recyclerView != null ? recyclerView.findViewHolderForAdapterPosition(0) : null);
        if (voiceMenuViewHolder != null) {
            return voiceMenuViewHolder.getSttStateButton();
        }
        return null;
    }

    private final View getStateBadgeView() {
        RecyclerView recyclerView = this.mPlayListView;
        VoiceRecordMenuAdapter.VoiceMenuViewHolder voiceMenuViewHolder = (VoiceRecordMenuAdapter.VoiceMenuViewHolder) (recyclerView != null ? recyclerView.findViewHolderForAdapterPosition(0) : null);
        if (voiceMenuViewHolder != null) {
            return voiceMenuViewHolder.getMBadgeSttStateButton();
        }
        return null;
    }

    private final void initListView() {
        VoiceRecordMenuAdapter voiceRecordMenuAdapter;
        View contentView;
        View mVoiceMenu = getMVoiceMenu();
        this.mPlayTimeView = mVoiceMenu != null ? (TextView) mVoiceMenu.findViewById(C9086R.id.voice_record_first_play_time) : null;
        PopupWindow popup = getPopup();
        this.mPlayListView = (popup == null || (contentView = popup.getContentView()) == null) ? null : (RecyclerView) contentView.findViewById(C9086R.id.voice_record_list);
        LinearLayoutManagerWrapper linearLayoutManagerWrapper = new LinearLayoutManagerWrapper(getMActivity());
        linearLayoutManagerWrapper.setOrientation(1);
        RecyclerView recyclerView = this.mPlayListView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManagerWrapper);
        }
        Activity mActivity = getMActivity();
        VoiceRecordMenuAdapter voiceRecordMenuAdapter2 = mActivity != null ? new VoiceRecordMenuAdapter(mActivity, getMPresenter(), new VoiceRecordMenuAdapter.LongPressListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.VoiceRecordExpandSubMenu$initListView$1$1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.VoiceRecordMenuAdapter.LongPressListener
            public void startLongPress() {
                RecyclerView recyclerView2 = this.this$0.mPlayListView;
                if (recyclerView2 != null) {
                    recyclerView2.seslStartLongPressMultiSelection();
                }
            }
        }) : null;
        this.mVoiceRecordMenuAdapter = voiceRecordMenuAdapter2;
        RecyclerView recyclerView2 = this.mPlayListView;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(voiceRecordMenuAdapter2);
        }
        RecyclerView recyclerView3 = this.mPlayListView;
        if (recyclerView3 != null) {
            recyclerView3.setItemAnimator(new VoiceRecordItemAnimator());
        }
        setPlayListViewOnMultiSelectedListener();
        boolean zIsBackgroundDarkTheme = getMPresenter().isBackgroundDarkTheme();
        addItemDecoration(zIsBackgroundDarkTheme);
        Activity mActivity2 = getMActivity();
        if (mActivity2 == null || (voiceRecordMenuAdapter = this.mVoiceRecordMenuAdapter) == null) {
            return;
        }
        voiceRecordMenuAdapter.updateColorTheme(mActivity2, zIsBackgroundDarkTheme);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyAdapter(Runnable runnable) {
        RecyclerView recyclerView = this.mPlayListView;
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.isAnimating()) {
            recyclerView.post(new RunnableC9844c(this, runnable, 29));
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyDataSetChanged$lambda$2(VoiceRecordExpandSubMenu voiceRecordExpandSubMenu) {
        VoiceRecordMenuAdapter voiceRecordMenuAdapter = voiceRecordExpandSubMenu.mVoiceRecordMenuAdapter;
        if (voiceRecordMenuAdapter != null) {
            voiceRecordMenuAdapter.notifyDataSetChanged();
        }
        Logger.m10999d(TAG, "notifyDataSetChanged ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyItemChanged$lambda$4(VoiceRecordExpandSubMenu voiceRecordExpandSubMenu, int i) {
        VoiceRecordMenuAdapter voiceRecordMenuAdapter = voiceRecordExpandSubMenu.mVoiceRecordMenuAdapter;
        if (voiceRecordMenuAdapter != null) {
            voiceRecordMenuAdapter.notifyItemChanged(i);
        }
        AbstractC0000a.m3D(i, "notifyItemChanged ", TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyItemInserted$lambda$5(VoiceRecordExpandSubMenu voiceRecordExpandSubMenu, int i) {
        VoiceRecordMenuAdapter voiceRecordMenuAdapter = voiceRecordExpandSubMenu.mVoiceRecordMenuAdapter;
        if (voiceRecordMenuAdapter != null) {
            voiceRecordMenuAdapter.notifyItemInserted(i);
        }
        AbstractC0000a.m3D(i, "notifyItemInserted ", TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyItemRemoved$lambda$3(VoiceRecordExpandSubMenu voiceRecordExpandSubMenu, int i) {
        VoiceRecordMenuAdapter voiceRecordMenuAdapter = voiceRecordExpandSubMenu.mVoiceRecordMenuAdapter;
        if (voiceRecordMenuAdapter != null) {
            voiceRecordMenuAdapter.notifyItemRemoved(i);
        }
        AbstractC0000a.m3D(i, "notifyItemRemoved ", TAG);
    }

    private final void setPlayListViewOnMultiSelectedListener() {
        RecyclerView recyclerView = this.mPlayListView;
        if (recyclerView != null) {
            recyclerView.seslSetOnMultiSelectedListener(new RecyclerView.SeslOnMultiSelectedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.VoiceRecordExpandSubMenu.setPlayListViewOnMultiSelectedListener.1
                @Override // androidx.recyclerview.widget.RecyclerView.SeslOnMultiSelectedListener
                public void onMultiSelectStart(int startX, int startY) {
                    View viewFindChildViewUnder;
                    RecyclerView recyclerView2 = VoiceRecordExpandSubMenu.this.mPlayListView;
                    if (recyclerView2 == null || (viewFindChildViewUnder = recyclerView2.findChildViewUnder(startX, startY)) == null) {
                        return;
                    }
                    if (!VoiceRecordExpandSubMenu.this.getMPresenter().compareViewState(VoiceViewState.Type.EDIT)) {
                        VoiceRecordExpandSubMenu.this.getMPresenter().onEditClick();
                    }
                    VoiceRecordExpandSubMenu.this.mStartSelect = recyclerView2.getChildLayoutPosition(viewFindChildViewUnder);
                    if (VoiceRecordExpandSubMenu.this.mStartSelect == -1) {
                        VoiceRecordExpandSubMenu.this.mStartSelect = recyclerView2.getChildCount();
                    }
                }

                @Override // androidx.recyclerview.widget.RecyclerView.SeslOnMultiSelectedListener
                public void onMultiSelectStop(int endX, int endY) {
                    View viewFindChildViewUnder;
                    VoiceRecordMenuAdapter voiceRecordMenuAdapter;
                    RecyclerView recyclerView2 = VoiceRecordExpandSubMenu.this.mPlayListView;
                    if (recyclerView2 == null || (viewFindChildViewUnder = recyclerView2.findChildViewUnder(endX, endY)) == null || (voiceRecordMenuAdapter = VoiceRecordExpandSubMenu.this.mVoiceRecordMenuAdapter) == null) {
                        return;
                    }
                    int childLayoutPosition = recyclerView2.getChildLayoutPosition(viewFindChildViewUnder);
                    if (childLayoutPosition == -1) {
                        childLayoutPosition = recyclerView2.getTop() > endY ? 0 : recyclerView2.getChildCount();
                    }
                    double d = childLayoutPosition;
                    int iMin = (int) Math.min(VoiceRecordExpandSubMenu.this.mStartSelect, d);
                    int iMax = (int) Math.max(VoiceRecordExpandSubMenu.this.mStartSelect, d);
                    if (iMin > iMax) {
                        return;
                    }
                    while (true) {
                        if (iMin < voiceRecordMenuAdapter.getItemCount()) {
                            VoiceRecordExpandSubMenu.this.toggleCheckBox(iMin);
                        }
                        if (iMin == iMax) {
                            return;
                        } else {
                            iMin++;
                        }
                    }
                }

                @Override // androidx.recyclerview.widget.RecyclerView.SeslOnMultiSelectedListener
                public void onMultiSelected(RecyclerView recyclerView2, View view, int position, long id) {
                    Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                    Intrinsics.checkNotNullParameter(view, "view");
                }
            });
        }
        RecyclerView recyclerView2 = this.mPlayListView;
        if (recyclerView2 != null) {
            recyclerView2.seslSetLongPressMultiSelectionListener(new RecyclerView.SeslLongPressMultiSelectionListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.VoiceRecordExpandSubMenu.setPlayListViewOnMultiSelectedListener.2
                @Override // androidx.recyclerview.widget.RecyclerView.SeslLongPressMultiSelectionListener
                public void onItemSelected(RecyclerView recyclerView3, View view, int position, long id) {
                    Intrinsics.checkNotNullParameter(recyclerView3, "recyclerView");
                    Intrinsics.checkNotNullParameter(view, "view");
                    VoiceRecordExpandSubMenu.this.toggleCheckBox(position);
                }

                @Override // androidx.recyclerview.widget.RecyclerView.SeslLongPressMultiSelectionListener
                public void onLongPressMultiSelectionEnded(int endX, int endY) {
                }

                @Override // androidx.recyclerview.widget.RecyclerView.SeslLongPressMultiSelectionListener
                public void onLongPressMultiSelectionStarted(int startX, int startY) {
                }
            });
        }
    }

    private final void showBadgeStt() {
        RecyclerView recyclerView = this.mPlayListView;
        VoiceRecordMenuAdapter.VoiceMenuViewHolder voiceMenuViewHolder = (VoiceRecordMenuAdapter.VoiceMenuViewHolder) (recyclerView != null ? recyclerView.findViewHolderForAdapterPosition(0) : null);
        if (voiceMenuViewHolder != null) {
            voiceMenuViewHolder.showBadgeStt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showRecordingListView$lambda$7(View view, VoiceRecordExpandSubMenu voiceRecordExpandSubMenu, View view2, Activity activity) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        View stateBadgeView = voiceRecordExpandSubMenu.getStateBadgeView();
        View guiView = voiceRecordExpandSubMenu.getGuiView();
        if (guiView == null) {
            Logger.m10999d(TAG, "showRecordingListView #stateBtn is null# ");
            return;
        }
        int[] iArr2 = new int[2];
        guiView.getLocationInWindow(iArr2);
        int width = (view2.getWidth() - iArr2[0]) - activity.getResources().getDimensionPixelSize(C9086R.dimen.voice_recording_list_layout_margin_end);
        int height = guiView.getHeight() + view.getHeight() + iArr2[1];
        int[] iArr3 = {(view.getWidth() + iArr[0]) - width, iArr[1] + height};
        if (voiceRecordExpandSubMenu.getMPresenter().isShareOldNotebook() || voiceRecordExpandSubMenu.getMPresenter().isCoedit()) {
            return;
        }
        STTGuideTip.Companion companion = STTGuideTip.INSTANCE;
        if (!companion.hasShowCondition()) {
            voiceRecordExpandSubMenu.showBadgeStt();
        } else if (stateBadgeView != null) {
            companion.show(view, stateBadgeView, iArr3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toggleCheckBox(int position) {
        RecyclerView recyclerView = this.mPlayListView;
        VoiceRecordMenuAdapter.VoiceMenuViewHolder voiceMenuViewHolder = (VoiceRecordMenuAdapter.VoiceMenuViewHolder) (recyclerView != null ? recyclerView.findViewHolderForAdapterPosition(position) : null);
        if (voiceMenuViewHolder != null) {
            voiceMenuViewHolder.toggleCheckBox();
        }
    }

    private final void updateBackground() {
        Activity mActivity = getMActivity();
        if (mActivity != null) {
            VoiceRecordMenuPresenter mPresenter = getMPresenter();
            int[] backgroundThemeColorTable = mPresenter.getBackgroundThemeColorTable();
            boolean z = backgroundThemeColorTable[2] == 1;
            int alphaComponent = ColorUtils.setAlphaComponent(backgroundThemeColorTable[1], 230);
            int iCompositeColors = ColorUtils.compositeColors(ContextCompat.getColor(mActivity, C9086R.color.composer_voice_menu_composite_alpha_background), mPresenter.getBackgroundColor());
            int color = ContextCompat.getColor(mActivity, C9086R.color.composer_voice_menu_item_divider);
            if (z) {
                iCompositeColors = ContextCompat.getColor(mActivity, C9086R.color.composer_voice_menu_dark_background);
                if (ContextUtils.isNightMode(mActivity)) {
                    iCompositeColors = FloatingFeature.INSTANCE.getAntiGreenishColor();
                }
                color = ContextCompat.getColor(mActivity, C9086R.color.composer_voice_menu_dark_item_divider);
            }
            updateBackground(alphaComponent, iCompositeColors, color, z, backgroundThemeColorTable);
        }
    }

    public final void changeMode(boolean isEditMode) {
        this.mOptionMenu.changeMode(isEditMode);
    }

    @Nullable
    public final PopupWindow getPopup() {
        return this.mOptionMenu.getPopup();
    }

    public final void hideBadge() {
        RecyclerView recyclerView = this.mPlayListView;
        VoiceRecordMenuAdapter.VoiceMenuViewHolder voiceMenuViewHolder = (VoiceRecordMenuAdapter.VoiceMenuViewHolder) (recyclerView != null ? recyclerView.findViewHolderForAdapterPosition(0) : null);
        if (voiceMenuViewHolder != null) {
            voiceMenuViewHolder.hideBadgeStt();
        }
    }

    public final void hideEditTrashView() {
        this.mOptionMenu.hideEditView();
    }

    public final void hidePopUpMenu() {
        this.mOptionMenu.hidePopUpMenu();
    }

    public final void hideRecordingListView() {
        VoiceRecordMenuAdapter voiceRecordMenuAdapter = this.mVoiceRecordMenuAdapter;
        if (voiceRecordMenuAdapter != null) {
            voiceRecordMenuAdapter.removeAllProgressingLightEffect();
        }
        RecyclerView recyclerView = this.mPlayListView;
        if (recyclerView != null) {
            recyclerView.setAdapter(null);
        }
        this.mOptionMenu.setListContainerVisibility(false);
        this.mOptionMenu.hidePopup();
    }

    public final void initRecordingList() {
        this.mOptionMenu.initRecordingList();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.VoiceRecordControlMenu
    public void insertSALog() {
        ComposerSA.insertLog("815", ComposerSAConstants.EVENT_VOICE_RECORDING_PANEL_PROGRESS_BAR);
    }

    public final void invalidateSeekBar() {
        SeslSeekBar mSeekBar = getMSeekBar();
        if (mSeekBar != null) {
            mSeekBar.invalidate();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.VoiceRecordControlMenu
    public void moveBackwardSALog() {
        if (getMPresenter().isEditMode()) {
            ComposerSA.insertLog(ComposerSAConstants.SCREEN_RECORDING, ComposerSAConstants.EVENT_VOICE_RECORDING_PANEL_10_SEC_BACKWARD);
        } else {
            ComposerSA.insertLog(ComposerSAConstants.SCREEN_VIEW_303, ComposerSAConstants.EVENT_VOICE_VIEW_10_SEC_BACKWARD);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.VoiceRecordControlMenu
    public void moveForwardSALog() {
        if (getMPresenter().isEditMode()) {
            ComposerSA.insertLog(ComposerSAConstants.SCREEN_RECORDING, ComposerSAConstants.EVENT_VOICE_RECORDING_PANEL_10_SEC_FORWARD);
        } else {
            ComposerSA.insertLog(ComposerSAConstants.SCREEN_VIEW_303, ComposerSAConstants.EVENT_VOICE_VIEW_10_SEC_FORWARD);
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void notifyDataSetChanged() {
        notifyAdapter(new RunnableC9767a(this, 17));
    }

    public final void notifyItemChanged(int position) {
        notifyAdapter(new RunnableC10883i(this, position, 0));
    }

    public final void notifyItemInserted(int position) {
        notifyAdapter(new RunnableC10883i(this, position, 2));
    }

    public final void notifyItemRemoved(int position) {
        notifyAdapter(new RunnableC10883i(this, position, 1));
    }

    public final void setPlayPoint(@NotNull List<Float> voiceDataPlayPoints) {
        Intrinsics.checkNotNullParameter(voiceDataPlayPoints, "voiceDataPlayPoints");
        SeslSeekBar mSeekBar = getMSeekBar();
        Intrinsics.checkNotNull(mSeekBar, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.VoiceSeekBar");
        ((VoiceSeekBar) mSeekBar).setPlayPoint(voiceDataPlayPoints);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.VoiceRecordControlMenu
    public void setPlayTimeView(@Nullable String time) {
        if (!this.mIsTablet) {
            VoiceUtil.INSTANCE.updateTimeEms(this.mPlayTimeView, time);
        }
        setRecordPlayTime(time);
    }

    public final void setRecordPlayTime(@Nullable String time) {
        VoiceUtil.INSTANCE.updateTimeEms(getMPlayTime(), time);
    }

    public final void setTheme(int bgColor, boolean isDarkTheme) {
        SeslSeekBar mSeekBar = getMSeekBar();
        Intrinsics.checkNotNull(mSeekBar, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.VoiceSeekBar");
        ((VoiceSeekBar) mSeekBar).setTheme(bgColor, isDarkTheme);
    }

    public final void setVoiceItemSelectMode(boolean selectMode) {
        VoiceRecordMenuAdapter voiceRecordMenuAdapter = this.mVoiceRecordMenuAdapter;
        if (voiceRecordMenuAdapter != null) {
            voiceRecordMenuAdapter.setSelectMode(selectMode);
        }
        this.mOptionMenu.updateSelectAll(selectMode);
    }

    public final void showEditTrashView(int selectedItem) {
        VoiceRecordMenuAdapter voiceRecordMenuAdapter = this.mVoiceRecordMenuAdapter;
        if (voiceRecordMenuAdapter != null) {
            voiceRecordMenuAdapter.setSelectMode(true);
        }
        this.mOptionMenu.showEditView(selectedItem);
        getMPresenter().setViewStateType(VoiceViewState.Type.EDIT);
    }

    public final void showEditView(boolean selectedMode, int selectedItem) {
        setVoiceItemSelectMode(selectedMode);
        this.mOptionMenu.showEditView(selectedItem);
        if (getMPresenter().getItemList().size() == 1) {
            getMPresenter().checkAllItem(true);
        }
        updateAudioEraserAnimation(false);
    }

    public final void showRecordingListView() {
        Activity mActivity = getMActivity();
        if (mActivity == null) {
            return;
        }
        if (!this.mOptionMenu.initPopupWindow()) {
            initListView();
            initRecordingList();
            changeMode(getMPresenter().isEditMode());
            updateBackground();
        }
        RecyclerView recyclerView = this.mPlayListView;
        if (recyclerView != null) {
            recyclerView.setAdapter(this.mVoiceRecordMenuAdapter);
        }
        this.mOptionMenu.setListContainerVisibility(true);
        if (this.mOptionMenu.isShowing()) {
            return;
        }
        this.mOptionMenu.showPopUp();
        View viewFindViewById = mActivity.findViewById(C9086R.id.voice_menu_expand_simple);
        PopupWindow popup = getPopup();
        View contentView = popup != null ? popup.getContentView() : null;
        if (contentView == null || viewFindViewById == null) {
            return;
        }
        contentView.postDelayed(new RunnableC0218a(18, viewFindViewById, this, contentView, mActivity), 400L);
    }

    public final void showRecordingPlayView() {
        TextView mTotalTime;
        VoiceUtil voiceUtil = VoiceUtil.INSTANCE;
        voiceUtil.updateTimeEms(getMPlayTime(), VoiceUtil.createTimeString$default(voiceUtil, 0, false, 2, null));
        TextView mPlayTime = getMPlayTime();
        if (mPlayTime != null) {
            mPlayTime.setVisibility(0);
        }
        String totalRecordTimeString = getMPresenter().getTotalRecordTimeString();
        if (!TextUtils.isEmpty(totalRecordTimeString) && (mTotalTime = getMTotalTime()) != null) {
            mTotalTime.setText(totalRecordTimeString);
        }
        if (!getMPresenter().isSupportAudioEraser() || voiceUtil.changeTimeType(totalRecordTimeString) < 2) {
            updateAudioEraserLayout(false);
        } else {
            makeAudioEraserEffect();
            updateViewEraser();
        }
    }

    public final void updatePlayPoint() {
        String totalRecordTimeString = getMPresenter().getTotalRecordTimeString();
        if (TextUtils.isEmpty(totalRecordTimeString)) {
            return;
        }
        VoiceUtil.INSTANCE.updateTimeEms(getMTotalTime(), totalRecordTimeString);
    }

    public final void updateSelectedItemText(int selectedItem) {
        this.mOptionMenu.updateSelectedItemText(selectedItem);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.VoiceRecordControlMenu
    public void updateView() {
        super.updateView();
        this.mOptionMenu.updateView();
    }

    public final void updateBackground(int textIconColor, int bgColor, int dividerColor, boolean isDarkTheme, @NotNull int[] themeColor) {
        Intrinsics.checkNotNullParameter(themeColor, "themeColor");
        Activity mActivity = getMActivity();
        if (mActivity == null) {
            return;
        }
        updateBackground(textIconColor, isDarkTheme, themeColor[1]);
        int iCompositeColors = ColorUtils.compositeColors(ContextCompat.getColor(mActivity, C9086R.color.composer_voice_seek_bar_tick_and_background), themeColor[0]);
        if (isDarkTheme) {
            iCompositeColors = ColorUtils.compositeColors(ContextCompat.getColor(mActivity, C9086R.color.composer_voice_seek_bar_dark_tick_and_background), themeColor[0]);
        }
        SeslSeekBar mSeekBar = getMSeekBar();
        if (mSeekBar != null) {
            mSeekBar.setProgressBackgroundTintList(ColorStateList.valueOf(iCompositeColors));
        }
        VoiceRecordMenuAdapter voiceRecordMenuAdapter = this.mVoiceRecordMenuAdapter;
        if (voiceRecordMenuAdapter != null) {
            voiceRecordMenuAdapter.updateColorTheme(mActivity, isDarkTheme);
        }
        notifyDataSetChanged();
        addItemDecoration(getMPresenter().isBackgroundDarkTheme());
        this.mOptionMenu.updateBackground(textIconColor, bgColor, dividerColor);
    }
}
