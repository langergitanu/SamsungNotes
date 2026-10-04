package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item;

import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.SpanStates;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.setting.RtSettingPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarMenu;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.menu.ToolbarUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.util.CustomAccessibilityDelegate;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class RtMenuItem {
    private static final String TAG = Logger.createTag("RtMenuItem");
    protected boolean mIsTabletLayout;
    protected RtToolbarPresenter mPresenter;
    protected IRtToolbarMenu mRtToolbarMenu;
    protected View mView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IRtToolbarMenu extends IToolbarMenu {
        void doActionAfterDismissKeyguard(@NonNull Runnable runnable);

        int getColorTheme(int i);

        RtSettingPresenter getRtSettingPresenter();

        boolean hideAllPopup();

        void hideDirectWrite();

        boolean isDirectWriteRecognizing();

        boolean isDirectWriteUsing();

        void setDirectWrite(boolean z);

        void showDirectWrite();

        void updateDirectWrite(boolean z);
    }

    public RtMenuItem(View view) {
        this.mView = view;
    }

    public int getColorTheme(int i) {
        return this.mRtToolbarMenu.getColorTheme(i);
    }

    public int[] getHorizonOnScreen(int i) {
        return ToolbarUtil.getHorizonOnScreen(this.mView, i);
    }

    public View getView() {
        return this.mView;
    }

    public Point getViewCenterPosition() {
        return ToolbarUtil.getViewCenterPosition(this.mView);
    }

    public void hideAiMenu() {
        this.mPresenter.hideAiMenu(false);
    }

    public boolean hidePopup() {
        return false;
    }

    public void init(RtToolbarPresenter rtToolbarPresenter, IRtToolbarMenu iRtToolbarMenu) {
        this.mPresenter = rtToolbarPresenter;
        this.mRtToolbarMenu = iRtToolbarMenu;
        this.mView.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.m11003i(RtMenuItem.TAG, "onClicked " + ((Object) view.getContentDescription()));
                if (!RtMenuItem.this.mPresenter.isIdleWorkingState()) {
                    Logger.m10999d(RtMenuItem.TAG, "Not IdleWorkingState");
                } else {
                    RtMenuItem.this.onClicked();
                    RtMenuItem.this.mPresenter.setMenuDirty();
                }
            }
        });
        ViewCompat viewCompat = ViewCompat.getInstance();
        View view = this.mView;
        viewCompat.setTooltipText(view, view.getContentDescription());
        this.mIsTabletLayout = ResourceUtils.isTabletLayout(this.mView.getContext());
    }

    public void initAccessibilityDelegate() {
        Resources resources = this.mView.getResources();
        View view = this.mView;
        StringBuilder sb = new StringBuilder();
        AbstractC8014b.m7202d(resources, C9086R.string.rich_text_font_color_popup_selected, sb, SQLKeyword.COMMA);
        sb.append((Object) this.mView.getContentDescription());
        String string = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        AbstractC8014b.m7202d(resources, C9086R.string.rich_text_font_color_popup_not_selected, sb2, SQLKeyword.COMMA);
        sb2.append((Object) this.mView.getContentDescription());
        view.setAccessibilityDelegate(new CustomAccessibilityDelegate(string, sb2.toString()));
    }

    public boolean isSkipUpdateDuringDirectWriteRecognizing() {
        if (!this.mRtToolbarMenu.isDirectWriteRecognizing()) {
            return false;
        }
        Logger.m11003i(TAG, "skip update cause STT recognizing");
        return true;
    }

    @CallSuper
    void onClicked() {
        this.mRtToolbarMenu.hideAllPopup();
        hideAiMenu();
    }

    public void onDetach() {
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
    }

    public void onUpdate() {
    }

    public void release() {
    }

    public void restore(@NonNull Bundle bundle) {
    }

    public void setEnable(boolean z) {
        if (z == this.mView.isEnabled()) {
            return;
        }
        this.mView.setEnabled(z);
        this.mView.setAlpha(z ? 1.0f : 0.4f);
    }

    public void setSelected(boolean z) {
        this.mView.setSelected(z);
    }

    public void updateState(SpanStates spanStates) {
    }
}
