package com.samsung.android.support.senl.p148nt.composer.main.simple.view;

import android.R;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.graphics.ColorUtils;
import androidx.fragment.app.Fragment;
import com.samsung.android.sdk.composer.SpenComposer;
import com.samsung.android.sdk.composer.listener.SpenComposerActionListener;
import com.samsung.android.sdk.composer.text.ISpenNoteTextManager;
import com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager;
import com.samsung.android.sdk.pen.engine.power.SpenDvfsInterface;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.feature.FloatingFeature;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.DVFSHelperCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.BackgroundColorUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.composer.ComposerViewState;
import com.samsung.android.support.senl.p148nt.composer.main.compare.presenter.CompareViewerContract;
import com.samsung.android.support.senl.p148nt.composer.main.simple.common.SimpleComposerConstant;
import com.samsung.android.support.senl.p148nt.composer.main.simple.presenter.SimpleComposerViewContract;
import com.samsung.android.support.senl.p148nt.composer.main.simple.presenter.SimpleComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.simple.presenter.listener.SimpleComposerListenerManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SimpleComposerView implements SimpleComposerViewContract.IView {
    private static final String TAG = Logger.createTag("SimpleComposerView", SimpleComposerConstant.TAG_PREFIX);
    private ComposerViewState mComposerViewState;
    private DVFSHelperCompat mDVFSHelperForSpenFling;
    private SimpleComposerListenerManager mListenerManager;
    private SimpleComposerViewPresenter mPresenter;
    private ScrollZoomManagerAdapter mScrollZoomManagerAdapter;
    private SpenComposer mView;

    public SimpleComposerView(Fragment fragment) {
        if (fragment.getContext() == null) {
            return;
        }
        this.mView = new SpenComposer(fragment.getContext(), 1);
        ComposerViewState composerViewState = new ComposerViewState();
        this.mComposerViewState = composerViewState;
        composerViewState.setComposerMode(3);
        this.mScrollZoomManagerAdapter = new ScrollZoomManagerAdapter(this.mComposerViewState);
    }

    private void iniSpenDvfsInterface(Context context) {
        DVFSHelperCompat dVFSHelperCompat = this.mDVFSHelperForSpenFling;
        if (dVFSHelperCompat != null) {
            dVFSHelperCompat.release();
        }
        DVFSHelperCompat dVFSHelperCompat2 = new DVFSHelperCompat(context);
        this.mDVFSHelperForSpenFling = dVFSHelperCompat2;
        dVFSHelperCompat2.initScenarioType(context, 1500);
        this.mView.setDvfsFling(new SpenDvfsInterface() { // from class: com.samsung.android.support.senl.nt.composer.main.simple.view.SimpleComposerView.1
            @Override // com.samsung.android.sdk.pen.engine.power.SpenDvfsInterface
            public void acquire() {
                SimpleComposerView.this.mDVFSHelperForSpenFling.acquire();
            }

            @Override // com.samsung.android.sdk.pen.engine.power.SpenDvfsInterface
            public void release() {
                SimpleComposerView.this.mDVFSHelperForSpenFling.release();
            }
        });
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void initBackgroundColor(Context context, SpenWNote spenWNote) {
        boolean zIsComposerViewDarkTheme = BackgroundColorUtil.isComposerViewDarkTheme(context, spenWNote.getPage(0).getBackgroundColor(), spenWNote.isBackgroundColorInverted(), BackgroundColorUtil.hasBackgroundImage(spenWNote.getPageList()));
        this.mView.setDarkModeEnabled(ContextUtils.isNightMode(context));
        this.mView.setColorTheme(zIsComposerViewDarkTheme ? 1 : 0);
    }

    private void initBackgroundState(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        int color = context.getColor(C9086R.color.composer_container_background);
        if (ContextUtils.isNightMode(context)) {
            color = FloatingFeature.INSTANCE.getAntiGreenishColor();
        }
        if (DesktopModeCompat.INSTANCE.getInstance().isDexDualModeOnScreen(context)) {
            color = ColorUtils.blendARGB(color, -16777216, 0.3f);
        }
        stateListDrawable.addState(new int[]{R.attr.background}, new ColorDrawable(color));
        stateListDrawable.addState(new int[]{R.attr.state_focused}, new ColorDrawable(color));
        stateListDrawable.addState(new int[]{-16842908}, new ColorDrawable(color));
        this.mView.setBackground(stateListDrawable);
    }

    private void initFBR() {
        ISpenNoteWritingViewManager noteWritingViewManager = this.mView.getNoteWritingViewManager();
        if (noteWritingViewManager != null) {
            noteWritingViewManager.setFrontBufferRenderingEnabled(false, new boolean[0]);
            noteWritingViewManager.setToolTypeAction(2, 1);
        }
        this.mView.setFrontBufferRenderingEnabledInEWP(false);
    }

    private void initFeature() {
        ISpenNoteTextManager textManager = this.mView.getTextManager();
        textManager.setHyperTextEnabled(false);
        textManager.setHashTagEnabled(false);
        this.mView.setActionLinkEnabled(false);
        textManager.setDoubleTapSelectionEnabled(!SystemPropertiesCompat.INSTANCE.getInstance().isUSAModel());
    }

    private void initFocusState() {
        this.mView.setClickable(true);
        this.mView.setFocusable(true);
        this.mView.setFocusableInTouchMode(true);
    }

    private void initViewState(Context context) {
        initFBR();
        iniSpenDvfsInterface(context);
        initFocusState();
        initBackgroundState(context);
    }

    public void attachView(ViewGroup viewGroup) {
        if (this.mView != null) {
            initViewState(viewGroup.getContext());
            this.mView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            viewGroup.addView(this.mView, 0);
            this.mScrollZoomManagerAdapter.onAttachedView(viewGroup);
        }
    }

    public RectF convertViewRectIntoContentRect(RectF rectF) {
        SpenComposer spenComposer = this.mView;
        if (spenComposer != null) {
            return spenComposer.getNoteZoomScroller().convertContentRectIntoViewRect(rectF);
        }
        return null;
    }

    public float getScrollY() {
        SpenComposer spenComposer = this.mView;
        if (spenComposer != null) {
            return spenComposer.getNoteZoomScroller().getPan().y;
        }
        return -1.0f;
    }

    public ISpenNoteTextManager getTextManager() {
        SpenComposer spenComposer = this.mView;
        if (spenComposer != null) {
            return spenComposer.getTextManager();
        }
        return null;
    }

    public void initScrollManager(SpenWNote spenWNote) {
        Logger.m11003i(TAG, "initScrollManager#");
        this.mScrollZoomManagerAdapter.init(this.mView, spenWNote, this.mPresenter);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.simple.presenter.SimpleComposerViewContract.IView
    public void initView(SpenWNote spenWNote) {
        if (this.mView == null) {
            return;
        }
        initFeature();
        this.mView.setDocument(spenWNote);
        initBackgroundColor(this.mView.getContext(), spenWNote);
        this.mView.setMode(this.mComposerViewState.getComposerMode());
        initScrollManager(spenWNote);
        this.mListenerManager.init();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.simple.presenter.SimpleComposerViewContract.IView
    public void release() {
        Logger.m10999d(TAG, "release#");
        if (this.mView == null) {
            return;
        }
        this.mScrollZoomManagerAdapter.release();
        this.mView.setDocument(null);
        this.mView.close();
        DVFSHelperCompat dVFSHelperCompat = this.mDVFSHelperForSpenFling;
        if (dVFSHelperCompat != null) {
            dVFSHelperCompat.release();
            this.mDVFSHelperForSpenFling = null;
        }
        this.mView = null;
    }

    public void requestFitToScreenPreview() {
        SpenComposer spenComposer = this.mView;
        if (spenComposer != null) {
            spenComposer.setAllwaysFitPageToScreen(true);
        }
    }

    public void requestPageLayout() {
        SpenComposer spenComposer = this.mView;
        if (spenComposer == null) {
            return;
        }
        spenComposer.getNotePageLayouter().requestPageLayout();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.simple.presenter.SimpleComposerViewContract.IView
    public void setActionListener(SpenComposerActionListener spenComposerActionListener) {
        SpenComposer spenComposer = this.mView;
        if (spenComposer == null) {
            return;
        }
        spenComposer.getListenerManager().setComposerActionListener(spenComposerActionListener);
    }

    public void setAutoScroll(boolean z) {
        SpenComposer spenComposer = this.mView;
        if (spenComposer != null) {
            spenComposer.setAutoScrollEnabled(z);
        }
    }

    public void setCompareMainPresenter(CompareViewerContract.IPresenter iPresenter, String str) {
        ScrollZoomManagerAdapter scrollZoomManagerAdapter = this.mScrollZoomManagerAdapter;
        if (scrollZoomManagerAdapter == null) {
            return;
        }
        scrollZoomManagerAdapter.setCompareMainPresenter(iPresenter, str);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.simple.presenter.SimpleComposerViewContract.IView
    public void setContentPan(float f, float f4, float f5, int i) {
        SpenComposer spenComposer = this.mView;
        if (spenComposer == null) {
            return;
        }
        spenComposer.getNoteZoomScroller().setZoomScale(f, f4, f5);
        this.mView.getNoteZoomScroller().setPan(new PointF(f4, f5));
        if (i != -1) {
            this.mView.requestAlignmentContent(i);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.simple.presenter.SimpleComposerViewContract.IView
    public void setPan(PointF pointF) {
        SpenComposer spenComposer = this.mView;
        if (spenComposer == null) {
            return;
        }
        spenComposer.getNoteZoomScroller().setPan(pointF);
    }

    public void setPresenter(SimpleComposerViewPresenter simpleComposerViewPresenter, String str) {
        this.mPresenter = simpleComposerViewPresenter;
        simpleComposerViewPresenter.setView(this);
        this.mListenerManager = new SimpleComposerListenerManager(simpleComposerViewPresenter, this.mView, str);
    }

    public void setScrollForModeCompare(float f) {
        SpenComposer spenComposer = this.mView;
        if (spenComposer != null) {
            this.mView.getNoteZoomScroller().setPan(new PointF(spenComposer.getNoteZoomScroller().getPan().x, f));
        }
    }

    public void setZoomScale(float f) {
        SpenComposer spenComposer = this.mView;
        if (spenComposer != null) {
            spenComposer.getNoteZoomScroller().setZoomScale(f);
        }
    }

    public void updateByMultiWindowMode() {
        SpenComposer spenComposer = this.mView;
        if (spenComposer == null) {
            return;
        }
        spenComposer.requestResetZoomScaleToDefault();
    }

    public void setScrollForModeCompare(float f, float f4) {
        SpenComposer spenComposer = this.mView;
        if (spenComposer != null) {
            spenComposer.getNoteZoomScroller().setPan(new PointF(f, f4));
        }
    }
}
