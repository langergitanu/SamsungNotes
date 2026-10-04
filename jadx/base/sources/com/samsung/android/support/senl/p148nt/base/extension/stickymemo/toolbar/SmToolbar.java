package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.toolbar;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.StringRes;
import androidx.core.content.res.ResourcesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.StickyMemoSAConstants;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.SmComposerView;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmModeControl;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.mode.SmMode;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.toolbar.SmMorePopup;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.toolbar.SmToolbar;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001(B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u0018H\u0002J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0003H\u0002J\u0018\u0010 \u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"H\u0002J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020\u0018J\u000e\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020$R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000¨\u0006)"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/toolbar/SmToolbar;", "", "parent", "Landroid/view/View;", "writingView", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/SmComposerView;", "<init>", "(Landroid/view/View;Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/SmComposerView;)V", "getParent", "()Landroid/view/View;", "menuContainer", "Landroid/view/ViewGroup;", "smMorePopup", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/toolbar/SmMorePopup;", "actionListener", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/toolbar/SmToolbar$ActionListener;", "getActionListener", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/toolbar/SmToolbar$ActionListener;", "setActionListener", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/toolbar/SmToolbar$ActionListener;)V", "moreIcon", "Landroid/widget/ImageView;", "minimizeIcon", "initMenus", "", "initMoreBtn", "createMoreTextMenu", "", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/toolbar/SmMorePopup$MoreTextMenu;", "initMinimizeBtn", "setRippleEffect", "view", "setTooltip", "tooltipText", "", "onBackPressed", "", "release", "updateTheme", "isViewDarkTheme", "ActionListener", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SmToolbar {

    @Nullable
    private ActionListener actionListener;

    @NotNull
    private final ViewGroup menuContainer;
    private ImageView minimizeIcon;
    private ImageView moreIcon;

    @NotNull
    private final View parent;

    @Nullable
    private SmMorePopup smMorePopup;

    @NotNull
    private final SmComposerView writingView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/toolbar/SmToolbar$ActionListener;", "", "onCloseClicked", "", "withAnimation", "", "onDeleteClicked", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ActionListener {
        void onCloseClicked(boolean withAnimation);

        void onDeleteClicked();
    }

    public SmToolbar(@NotNull View parent, @NotNull SmComposerView writingView) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(writingView, "writingView");
        this.parent = parent;
        this.writingView = writingView;
        View viewFindViewById = parent.findViewById(C8875R.id.top_menu_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ViewGroup viewGroup = (ViewGroup) viewFindViewById;
        this.menuContainer = viewGroup;
        writingView.getControlManager().getModeControl().setEditModeChangeListener(new SmModeControl.EditModeChangeListener() { // from class: com.samsung.android.support.senl.nt.base.extension.stickymemo.toolbar.SmToolbar.1
            @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.control.SmModeControl.EditModeChangeListener
            public void onEditModeChanged(SmMode mode) {
                Intrinsics.checkNotNullParameter(mode, "mode");
            }
        });
        initMenus();
        viewGroup.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.base.extension.stickymemo.toolbar.SmToolbar.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
    }

    private final List<SmMorePopup.MoreTextMenu> createMoreTextMenu() {
        return CollectionsKt.listOf(new SmMorePopup.MoreTextMenu() { // from class: com.samsung.android.support.senl.nt.base.extension.stickymemo.toolbar.SmToolbar$createMoreTextMenu$deleteMenu$1
            @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.toolbar.SmMorePopup.MoreTextMenu
            public void executeMenu() {
                NotesSamsungAnalytics.INSTANCE.insertLog(StickyMemoSAConstants.SCREEN_STICKY_NOTE_MORE_OPTION, StickyMemoSAConstants.EVENT_DELETE);
                SmMorePopup smMorePopup = this.this$0.smMorePopup;
                if (smMorePopup != null) {
                    Context context = this.this$0.getParent().getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    final SmToolbar smToolbar = this.this$0;
                    smMorePopup.showDeleteConfirmDialog(context, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.base.extension.stickymemo.toolbar.SmToolbar$createMoreTextMenu$deleteMenu$1$executeMenu$1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int which) {
                            SmToolbar.ActionListener actionListener = smToolbar.getActionListener();
                            if (actionListener != null) {
                                actionListener.onDeleteClicked();
                            }
                        }
                    });
                }
            }

            @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.toolbar.SmMorePopup.MoreTextMenu
            @StringRes
            public int getTitle() {
                return C8875R.string.sticky_memo_more_delete;
            }
        });
    }

    private final void initMenus() {
        initMoreBtn();
        initMinimizeBtn();
    }

    private final void initMinimizeBtn() {
        ViewGroup viewGroup = (ViewGroup) this.menuContainer.findViewById(C8875R.id.minimize_btn);
        View childAt = viewGroup.getChildAt(0);
        Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.ImageView");
        this.minimizeIcon = (ImageView) childAt;
        viewGroup.setOnClickListener(new ViewOnClickListenerC8939e(this, 1));
        Intrinsics.checkNotNull(viewGroup);
        CharSequence contentDescription = viewGroup.getContentDescription();
        Intrinsics.checkNotNullExpressionValue(contentDescription, "getContentDescription(...)");
        setTooltip(viewGroup, contentDescription);
        setRippleEffect(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initMinimizeBtn$lambda$2(SmToolbar smToolbar, View view) {
        NotesSamsungAnalytics.INSTANCE.insertLog(StickyMemoSAConstants.SCREEN_STICKY_NOTE, "401");
        ActionListener actionListener = smToolbar.actionListener;
        if (actionListener != null) {
            actionListener.onCloseClicked(true);
        }
    }

    private final void initMoreBtn() {
        ViewGroup viewGroup = (ViewGroup) this.menuContainer.findViewById(C8875R.id.more_btn);
        View childAt = viewGroup.getChildAt(0);
        Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.ImageView");
        this.moreIcon = (ImageView) childAt;
        viewGroup.setOnClickListener(new ViewOnClickListenerC8939e(this, 0));
        Intrinsics.checkNotNull(viewGroup);
        CharSequence contentDescription = viewGroup.getContentDescription();
        Intrinsics.checkNotNullExpressionValue(contentDescription, "getContentDescription(...)");
        setTooltip(viewGroup, contentDescription);
        setRippleEffect(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initMoreBtn$lambda$1(SmToolbar smToolbar, View view) {
        NotesSamsungAnalytics.INSTANCE.insertLog(StickyMemoSAConstants.SCREEN_STICKY_NOTE, StickyMemoSAConstants.EVENT_MORE_OPTION);
        if (smToolbar.smMorePopup == null) {
            SmMorePopup smMorePopup = new SmMorePopup(smToolbar.writingView);
            smMorePopup.setMenuList(smToolbar.createMoreTextMenu());
            smToolbar.smMorePopup = smMorePopup;
        }
        SmMorePopup smMorePopup2 = smToolbar.smMorePopup;
        Intrinsics.checkNotNull(smMorePopup2);
        Intrinsics.checkNotNull(view);
        smMorePopup2.show(view);
    }

    private final void setRippleEffect(View view) {
        int i = C8875R.drawable.sticky_memo_toolbar_button_pressed;
        int i2 = C8875R.drawable.sticky_memo_toolbar_button_selected;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_selected}, ResourcesCompat.getDrawable(view.getResources(), i2, view.getContext().getTheme()));
        stateListDrawable.addState(new int[]{R.attr.state_enabled}, ResourcesCompat.getDrawable(view.getResources(), i, view.getContext().getTheme()));
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, ResourcesCompat.getDrawable(view.getResources(), i, view.getContext().getTheme()));
        stateListDrawable.addState(new int[]{R.attr.state_focused}, ResourcesCompat.getDrawable(view.getResources(), i2, view.getContext().getTheme()));
        view.setBackground(stateListDrawable);
    }

    private final void setTooltip(View view, CharSequence tooltipText) {
        if (Build.VERSION.SDK_INT > 26) {
            ViewCompat.INSTANCE.getInstance().setTooltipText(view, tooltipText);
        }
    }

    @Nullable
    public final ActionListener getActionListener() {
        return this.actionListener;
    }

    @NotNull
    public final View getParent() {
        return this.parent;
    }

    public final boolean onBackPressed() {
        SmMorePopup smMorePopup = this.smMorePopup;
        if (smMorePopup == null || !smMorePopup.isShowing()) {
            return false;
        }
        SmMorePopup smMorePopup2 = this.smMorePopup;
        if (smMorePopup2 != null) {
            smMorePopup2.hide();
        }
        return true;
    }

    public final void release() {
        SmMorePopup smMorePopup;
        SmMorePopup smMorePopup2 = this.smMorePopup;
        if (smMorePopup2 == null || !smMorePopup2.isShowing() || (smMorePopup = this.smMorePopup) == null) {
            return;
        }
        smMorePopup.hide();
    }

    public final void setActionListener(@Nullable ActionListener actionListener) {
        this.actionListener = actionListener;
    }

    public final void updateTheme(boolean isViewDarkTheme) {
        int color = isViewDarkTheme ? this.menuContainer.getContext().getColor(C8875R.color.sticky_memo_menu_dark_color) : this.menuContainer.getContext().getColor(C8875R.color.sticky_memo_menu_light_color);
        ImageView imageView = this.moreIcon;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreIcon");
            imageView = null;
        }
        imageView.setColorFilter(color);
        ImageView imageView3 = this.minimizeIcon;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("minimizeIcon");
        } else {
            imageView2 = imageView3;
        }
        imageView2.setColorFilter(color);
    }
}
