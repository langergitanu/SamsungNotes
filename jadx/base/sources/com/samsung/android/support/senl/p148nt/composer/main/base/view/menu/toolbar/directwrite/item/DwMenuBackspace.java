package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.directwrite.item;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import com.samsung.android.support.senl.p148nt.base.composer.common.BaseComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.directwrite.DwToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DwMenuBackspace extends DwMenuItem {
    private static final int LONG_CLICK_DELAY_TIME = 100;
    private Handler mHandler;
    private boolean mIsLongClick;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class BackSpaceRunnable implements Runnable {
        public /* synthetic */ BackSpaceRunnable(DwMenuBackspace dwMenuBackspace, int i) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (DwMenuBackspace.this.mIsLongClick) {
                DwMenuBackspace.this.mPresenter.requestDirectWritingActionBackspace();
                DwMenuBackspace.this.mHandler.postDelayed(DwMenuBackspace.this.new BackSpaceRunnable(), 100L);
            }
        }

        private BackSpaceRunnable() {
        }
    }

    public DwMenuBackspace(View view) {
        super(view);
        this.mIsLongClick = false;
        this.mHandler = new Handler();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.directwrite.item.DwMenuItem
    public void init(DwToolbarPresenter dwToolbarPresenter) {
        super.init(dwToolbarPresenter);
        this.mView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.directwrite.item.DwMenuBackspace.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                DwMenuBackspace.this.mIsLongClick = true;
                DwMenuBackspace.this.mHandler.post(new BackSpaceRunnable(DwMenuBackspace.this, 0));
                return false;
            }
        });
        this.mView.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.directwrite.item.DwMenuBackspace.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (DwMenuBackspace.this.mIsLongClick && (action == 1 || action == 3)) {
                    DwMenuBackspace.this.mIsLongClick = false;
                }
                return false;
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.directwrite.item.DwMenuItem
    public void onClicked() {
        this.mPresenter.requestDirectWritingActionBackspace();
        ComposerSA.insertLog(BaseComposerSAConstants.SCREEN_NONE, HWToolbarSAConstants.EVENT_HW_STT_BACK_SPACE);
    }
}
