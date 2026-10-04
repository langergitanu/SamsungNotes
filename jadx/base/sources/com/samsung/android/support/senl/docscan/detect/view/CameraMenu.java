package com.samsung.android.support.senl.docscan.detect.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.constraintlayout.motion.widget.Key;
import com.samsung.android.support.senl.docscan.C7976R;
import com.samsung.android.support.senl.docscan.common.Logger;
import com.samsung.android.support.senl.docscan.common.util.CommonUtils;
import com.samsung.android.support.senl.docscan.detect.presenter.CameraPresenter;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.display.DisplayDeviceTypeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.winset.util.ButtonShapeUtil;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p035H2.RunnableC0116a;
import p035H2.RunnableC0117b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 32\u00020\u0001:\u00013B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J&\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011J\u0016\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0011J\u000e\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001bJ\u0016\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0011J\b\u0010!\u001a\u00020\u000fH\u0002J\b\u0010\"\u001a\u00020\u000fH\u0002J\b\u0010#\u001a\u00020\u000fH\u0002J\u0010\u0010$\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u0011H\u0002J\u0010\u0010%\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0011H\u0002J\u0010\u0010&\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0011H\u0002J\u0010\u0010'\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0011H\u0002J\u0010\u0010(\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0011H\u0002J\u0018\u0010)\u001a\u00020\u000f2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u0011J\u000e\u0010-\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u0011J\u0006\u0010/\u001a\u00020\u000fJ\u0006\u00100\u001a\u00020\u000fJ\u0010\u00101\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\u0011H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\r8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u00064"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/detect/view/CameraMenu;", "", "mCameraLayout", "Landroid/widget/FrameLayout;", "mClickListener", "Landroid/view/View$OnClickListener;", "<init>", "(Landroid/widget/FrameLayout;Landroid/view/View$OnClickListener;)V", "mHandler", "Landroid/os/Handler;", "mTakePictureBtn", "Landroid/widget/ImageView;", "cameraMenuLst", "", "initMenuLayout", "", "scanDataCount", "", "updateCameraMenuLayout", "context", "Landroid/content/Context;", "presenter", "Lcom/samsung/android/support/senl/docscan/detect/presenter/CameraPresenter;", "orientation", "updateFlashLayout", "activeTakePictureBtn", "isDetected", "", "setFlashModeActivated", "isActivated", "showFlashOptions", "visible", "flashMode", "updateFlashAutoContentDescription", "updateFlashOnContentDescription", "updateFlashOffContentDescription", "updateFlashButtonContentDescription", "getFlashButtonImageLevelFromFlashMode", "getFlashAutoImageFromFlashMode", "getFlashOnImageFromFlashMode", "getFlashOffImageFromFlashMode", "updateThumbnailView", "thumbnailBitmap", "Landroid/graphics/Bitmap;", "scanDataListSize", "performHapticTakePicture", "hapticIndex", "dismissCameraMenu", "showCameraMenu", "rotateCameraMenu", Key.ROTATION, "Companion", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CameraMenu {

    @NotNull
    private static final String TAG = "CameraMenu";

    @IdRes
    @NotNull
    private final int[] cameraMenuLst;

    @Nullable
    private final FrameLayout mCameraLayout;

    @NotNull
    private final View.OnClickListener mClickListener;

    @NotNull
    private final Handler mHandler;
    private ImageView mTakePictureBtn;

    public CameraMenu(@Nullable FrameLayout frameLayout, @NotNull View.OnClickListener mClickListener) {
        Intrinsics.checkNotNullParameter(mClickListener, "mClickListener");
        this.mCameraLayout = frameLayout;
        this.mClickListener = mClickListener;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.cameraMenuLst = new int[]{C7976R.id.flash_mode, C7976R.id.flash_on, C7976R.id.flash_off, C7976R.id.flash_auto, C7976R.id.add_to_note, C7976R.id.thumbnail, C7976R.id.thumbnail_count, C7976R.id.thumbnail_shadow};
    }

    private final int getFlashAutoImageFromFlashMode(int flashMode) {
        return flashMode != 1 ? flashMode != 2 ? flashMode != 3 ? C7976R.drawable.ic_camera_flash_auto_on : C7976R.drawable.ic_camera_flash_auto : C7976R.drawable.ic_camera_flash_auto_on : C7976R.drawable.ic_camera_flash_auto;
    }

    private final int getFlashButtonImageLevelFromFlashMode(int flashMode) {
        if (flashMode != 1) {
            return (flashMode == 2 || flashMode != 3) ? 2 : 1;
        }
        return 0;
    }

    private final int getFlashOffImageFromFlashMode(int flashMode) {
        return flashMode != 1 ? flashMode != 2 ? flashMode != 3 ? C7976R.drawable.ic_camera_flash_off : C7976R.drawable.ic_camera_flash_off : C7976R.drawable.ic_camera_flash_off : C7976R.drawable.ic_camera_flash_off_on;
    }

    private final int getFlashOnImageFromFlashMode(int flashMode) {
        return flashMode != 1 ? flashMode != 2 ? flashMode != 3 ? C7976R.drawable.ic_camera_flash_always : C7976R.drawable.ic_camera_flash_always_on : C7976R.drawable.ic_camera_flash_always : C7976R.drawable.ic_camera_flash_always;
    }

    private final void rotateCameraMenu(int rotation) {
        for (int i : this.cameraMenuLst) {
            FrameLayout frameLayout = this.mCameraLayout;
            View viewFindViewById = frameLayout != null ? frameLayout.findViewById(i) : null;
            if (viewFindViewById != null) {
                viewFindViewById.setRotation(rotation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setFlashModeActivated$lambda$0(CameraMenu cameraMenu, boolean z) {
        FrameLayout frameLayout = cameraMenu.mCameraLayout;
        Intrinsics.checkNotNull(frameLayout);
        ((ImageView) frameLayout.findViewById(C7976R.id.flash_mode)).setActivated(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showFlashOptions$lambda$1(CameraMenu cameraMenu, int i, int i2) {
        FrameLayout frameLayout = cameraMenu.mCameraLayout;
        if (frameLayout == null) {
            return;
        }
        ImageView imageView = (ImageView) frameLayout.findViewById(C7976R.id.flash_auto);
        ImageView imageView2 = (ImageView) cameraMenu.mCameraLayout.findViewById(C7976R.id.flash_on);
        ImageView imageView3 = (ImageView) cameraMenu.mCameraLayout.findViewById(C7976R.id.flash_off);
        ImageView imageView4 = (ImageView) cameraMenu.mCameraLayout.findViewById(C7976R.id.flash_mode);
        cameraMenu.updateFlashAutoContentDescription();
        cameraMenu.updateFlashOnContentDescription();
        cameraMenu.updateFlashOffContentDescription();
        cameraMenu.updateFlashButtonContentDescription(i);
        ViewCompat.Companion companion = ViewCompat.INSTANCE;
        companion.getInstance().setTooltipText(imageView, imageView.getResources().getString(C7976R.string.flash));
        companion.getInstance().setTooltipText(imageView2, imageView2.getResources().getString(C7976R.string.flash));
        companion.getInstance().setTooltipText(imageView3, imageView3.getResources().getString(C7976R.string.flash));
        companion.getInstance().setTooltipText(imageView4, imageView4.getResources().getString(C7976R.string.flash));
        imageView.setImageResource(cameraMenu.getFlashAutoImageFromFlashMode(i));
        imageView2.setImageResource(cameraMenu.getFlashOnImageFromFlashMode(i));
        imageView3.setImageResource(cameraMenu.getFlashOffImageFromFlashMode(i));
        imageView4.setImageLevel(cameraMenu.getFlashButtonImageLevelFromFlashMode(i));
        imageView.setOnClickListener(cameraMenu.mClickListener);
        imageView2.setOnClickListener(cameraMenu.mClickListener);
        imageView3.setOnClickListener(cameraMenu.mClickListener);
        imageView4.setOnClickListener(cameraMenu.mClickListener);
        imageView.setVisibility(i2);
        imageView2.setVisibility(i2);
        imageView3.setVisibility(i2);
        if (i2 == 0) {
            imageView4.setVisibility(8);
        } else {
            imageView4.setVisibility(0);
        }
    }

    private final void updateFlashAutoContentDescription() {
        FrameLayout frameLayout = this.mCameraLayout;
        Intrinsics.checkNotNull(frameLayout);
        ImageView imageView = (ImageView) frameLayout.findViewById(C7976R.id.flash_auto);
        if (imageView == null) {
            return;
        }
        imageView.setContentDescription(imageView.getResources().getString(C7976R.string.auto) + SQLKeyword.COMMA + imageView.getResources().getString(C7976R.string.flash));
    }

    private final void updateFlashButtonContentDescription(int flashMode) {
        FrameLayout frameLayout = this.mCameraLayout;
        Intrinsics.checkNotNull(frameLayout);
        ImageView imageView = (ImageView) frameLayout.findViewById(C7976R.id.flash_mode);
        ImageView imageView2 = (ImageView) this.mCameraLayout.findViewById(C7976R.id.flash_auto);
        ImageView imageView3 = (ImageView) this.mCameraLayout.findViewById(C7976R.id.flash_on);
        ImageView imageView4 = (ImageView) this.mCameraLayout.findViewById(C7976R.id.flash_off);
        if (flashMode == 1) {
            imageView.setContentDescription(imageView4.getContentDescription());
            return;
        }
        if (flashMode == 2) {
            imageView.setContentDescription(imageView2.getContentDescription());
        } else if (flashMode != 3) {
            imageView.setContentDescription(imageView2.getContentDescription());
        } else {
            imageView.setContentDescription(imageView3.getContentDescription());
        }
    }

    private final void updateFlashOffContentDescription() {
        FrameLayout frameLayout = this.mCameraLayout;
        Intrinsics.checkNotNull(frameLayout);
        ImageView imageView = (ImageView) frameLayout.findViewById(C7976R.id.flash_off);
        if (imageView == null) {
            return;
        }
        imageView.setContentDescription(imageView.getResources().getString(C7976R.string.off) + SQLKeyword.COMMA + imageView.getResources().getString(C7976R.string.flash));
    }

    private final void updateFlashOnContentDescription() {
        FrameLayout frameLayout = this.mCameraLayout;
        Intrinsics.checkNotNull(frameLayout);
        ImageView imageView = (ImageView) frameLayout.findViewById(C7976R.id.flash_on);
        if (imageView == null) {
            return;
        }
        imageView.setContentDescription(imageView.getResources().getString(C7976R.string.f5847on) + SQLKeyword.COMMA + imageView.getResources().getString(C7976R.string.flash));
    }

    public final void activeTakePictureBtn(boolean isDetected) {
        ImageView imageView = this.mTakePictureBtn;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTakePictureBtn");
            imageView = null;
        }
        imageView.setActivated(isDetected);
    }

    public final void dismissCameraMenu() {
        View viewFindViewById;
        View viewFindViewById2;
        FrameLayout frameLayout = this.mCameraLayout;
        if (frameLayout != null && (viewFindViewById2 = frameLayout.findViewById(C7976R.id.camera_menu_layout)) != null) {
            viewFindViewById2.setVisibility(4);
        }
        FrameLayout frameLayout2 = this.mCameraLayout;
        if (frameLayout2 == null || (viewFindViewById = frameLayout2.findViewById(C7976R.id.flash_layout)) == null) {
            return;
        }
        viewFindViewById.setVisibility(4);
    }

    public final void initMenuLayout(int scanDataCount) {
        FrameLayout frameLayout = this.mCameraLayout;
        if (frameLayout == null) {
            return;
        }
        ImageView imageView = (ImageView) frameLayout.findViewById(C7976R.id.thumbnail);
        imageView.setOnClickListener(this.mClickListener);
        imageView.setClipToOutline(true);
        ViewCompat.Companion companion = ViewCompat.INSTANCE;
        companion.getInstance().setTooltipText(imageView);
        ImageView imageView2 = (ImageView) this.mCameraLayout.findViewById(C7976R.id.take_picture);
        this.mTakePictureBtn = imageView2;
        ImageView imageView3 = null;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTakePictureBtn");
            imageView2 = null;
        }
        imageView2.setOnClickListener(this.mClickListener);
        ViewCompat companion2 = companion.getInstance();
        ImageView imageView4 = this.mTakePictureBtn;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTakePictureBtn");
            imageView4 = null;
        }
        companion2.setTooltipText(imageView4);
        TextView textView = (TextView) this.mCameraLayout.findViewById(C7976R.id.add_to_note);
        textView.setOnClickListener(this.mClickListener);
        companion.getInstance().setTooltipText(textView, textView.getText());
        ButtonShapeUtil.setButtonShapeEnabled(textView);
        TextView textView2 = (TextView) this.mCameraLayout.findViewById(C7976R.id.camera_notify_text_view);
        textView2.setText(textView2.getResources().getQuantityString(C7976R.plurals.can_not_scan_more_than_n_data, 50, 50));
        if (scanDataCount < 50) {
            textView2.setVisibility(8);
            ImageView imageView5 = this.mTakePictureBtn;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTakePictureBtn");
            } else {
                imageView3 = imageView5;
            }
            imageView3.setEnabled(true);
            return;
        }
        textView2.setVisibility(0);
        ImageView imageView6 = this.mTakePictureBtn;
        if (imageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTakePictureBtn");
        } else {
            imageView3 = imageView6;
        }
        imageView3.setEnabled(false);
    }

    public final void performHapticTakePicture(int hapticIndex) {
        ViewCompat companion = ViewCompat.INSTANCE.getInstance();
        ImageView imageView = this.mTakePictureBtn;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTakePictureBtn");
            imageView = null;
        }
        companion.performHapticFeedback(imageView, hapticIndex);
    }

    public final void setFlashModeActivated(boolean isActivated) {
        this.mHandler.post(new RunnableC0116a(0, this, isActivated));
    }

    public final void showCameraMenu() {
        View viewFindViewById;
        View viewFindViewById2;
        FrameLayout frameLayout = this.mCameraLayout;
        if (frameLayout != null && (viewFindViewById2 = frameLayout.findViewById(C7976R.id.camera_menu_layout)) != null) {
            viewFindViewById2.setVisibility(0);
        }
        FrameLayout frameLayout2 = this.mCameraLayout;
        if (frameLayout2 == null || (viewFindViewById = frameLayout2.findViewById(C7976R.id.flash_layout)) == null) {
            return;
        }
        viewFindViewById.setVisibility(0);
    }

    public final void showFlashOptions(int visible, int flashMode) {
        this.mHandler.post(new RunnableC0117b(this, flashMode, visible, 0));
    }

    public final void updateCameraMenuLayout(@NotNull Context context, @NotNull CameraPresenter presenter, int scanDataCount, int orientation) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        Logger.m7145d(TAG, "updateCameraMenuLayout# orientation : " + orientation);
        FrameLayout frameLayout = this.mCameraLayout;
        Intrinsics.checkNotNull(frameLayout);
        ViewGroup viewGroup = (ViewGroup) frameLayout.findViewById(C7976R.id.camera_menu_layout);
        if (viewGroup != null) {
            this.mCameraLayout.removeView(viewGroup);
        }
        boolean zIsTabletLayout = ResourceUtils.isTabletLayout(context);
        boolean z = orientation == 0 || orientation == 180;
        int i = (zIsTabletLayout || DisplayDeviceTypeCompat.INSTANCE.getInstance().isMainDisplay(context.getResources().getConfiguration())) ? z ? C7976R.layout.camera_menu_layout_port : orientation == 90 ? C7976R.layout.camera_menu_layout_land : C7976R.layout.camera_menu_layout_reverse_land : C7976R.layout.camera_menu_layout_land;
        View viewInflate = LayoutInflater.from(context).inflate(i, (ViewGroup) null);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) viewInflate;
        this.mCameraLayout.addView(viewGroup2);
        ViewGroup viewGroup3 = (ViewGroup) viewGroup2.findViewById(C7976R.id.camera_btn_layout);
        TextView textView = (TextView) this.mCameraLayout.findViewById(C7976R.id.add_to_note_container).findViewById(C7976R.id.add_to_note);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        textView.measure(0, 0);
        if (!zIsTabletLayout && !CommonUtils.isStandardViewOfFoldDevice(context)) {
            ViewGroup.LayoutParams layoutParams3 = viewGroup3.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams3;
            layoutParams4.bottomMargin = context.getResources().getDimensionPixelSize(C7976R.dimen.camera_btn_layout_margin_end_on_phone);
            layoutParams2.gravity = 81;
            layoutParams2.bottomMargin = z ? context.getResources().getDimensionPixelSize(C7976R.dimen.camera_btn_layout_margin_end_on_phone) : (textView.getMeasuredWidth() / 2) - context.getResources().getDimensionPixelSize(C7976R.dimen.camera_btn_layout_margin_end);
            textView.setLayoutParams(layoutParams2);
            viewGroup3.setLayoutParams(layoutParams4);
        } else if (z) {
            ViewGroup.LayoutParams layoutParams5 = viewGroup3.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams5, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) layoutParams5;
            layoutParams6.width = -2;
            layoutParams6.height = (int) context.getResources().getDimension(C7976R.dimen.camera_btn_layout_height);
            layoutParams6.bottomMargin = context.getResources().getDimensionPixelSize(C7976R.dimen.camera_btn_layout_margin_bottom);
            DesktopModeCompat.Companion companion = DesktopModeCompat.INSTANCE;
            if (companion.getInstance().isDexDualModeOnScreen(context) && companion.getInstance().isDexDualModeConnected(context)) {
                layoutParams6.gravity = 8388629;
            }
            if (CommonUtils.isStandardViewOfFoldDevice(context)) {
                layoutParams6.setMarginEnd(context.getResources().getDimensionPixelSize(C7976R.dimen.camera_add_to_note_btn_padding_start_end));
            } else {
                layoutParams6.setMarginEnd(context.getResources().getDimensionPixelSize(C7976R.dimen.camera_btn_layout_margin_end));
            }
            viewGroup3.setLayoutParams(layoutParams6);
        } else {
            ViewGroup.LayoutParams layoutParams7 = viewGroup3.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams7, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams) layoutParams7;
            if (i == C7976R.layout.camera_menu_layout_reverse_land) {
                layoutParams8.topMargin = context.getResources().getDimensionPixelSize(C7976R.dimen.camera_btn_layout_margin_end);
                layoutParams2.gravity = 49;
                layoutParams2.topMargin = (textView.getMeasuredWidth() / 2) - context.getResources().getDimensionPixelSize(C7976R.dimen.camera_add_to_note_btn_padding_start_end);
                textView.setLayoutParams(layoutParams2);
            } else {
                layoutParams8.bottomMargin = context.getResources().getDimensionPixelSize(C7976R.dimen.camera_btn_layout_margin_end);
                layoutParams2.gravity = 81;
                layoutParams2.bottomMargin = (textView.getMeasuredWidth() / 2) - context.getResources().getDimensionPixelSize(C7976R.dimen.camera_add_to_note_btn_padding_start_end);
                textView.setLayoutParams(layoutParams2);
            }
            viewGroup3.setLayoutParams(layoutParams8);
        }
        initMenuLayout(scanDataCount);
        presenter.loadThumbnail();
        rotateCameraMenu(orientation);
    }

    public final void updateFlashLayout(@NotNull Context context, int orientation) {
        Intrinsics.checkNotNullParameter(context, "context");
        FrameLayout frameLayout = this.mCameraLayout;
        Intrinsics.checkNotNull(frameLayout);
        this.mCameraLayout.removeView((LinearLayout) frameLayout.findViewById(C7976R.id.flash_layout));
        int i = ((ResourceUtils.isTabletLayout(context) || DisplayDeviceTypeCompat.INSTANCE.getInstance().isMainDisplay(context.getResources().getConfiguration())) && orientation == -90) ? C7976R.layout.camera_flash_layout_port : C7976R.layout.camera_flash_layout_land;
        LayoutInflater.from(context).inflate(i, (ViewGroup) this.mCameraLayout, true);
    }

    public final void updateThumbnailView(@Nullable Bitmap thumbnailBitmap, int scanDataListSize) {
        FrameLayout frameLayout = this.mCameraLayout;
        if (frameLayout == null) {
            return;
        }
        ((ImageView) frameLayout.findViewById(C7976R.id.thumbnail)).setImageBitmap(thumbnailBitmap);
        View viewFindViewById = this.mCameraLayout.findViewById(C7976R.id.thumbnail_container);
        View viewFindViewById2 = this.mCameraLayout.findViewById(C7976R.id.add_to_note_container);
        ImageView imageView = (ImageView) this.mCameraLayout.findViewById(C7976R.id.thumbnail_shadow);
        TextView textView = (TextView) this.mCameraLayout.findViewById(C7976R.id.thumbnail_count);
        viewFindViewById.setVisibility(scanDataListSize > 0 ? 0 : 8);
        viewFindViewById2.setVisibility(scanDataListSize > 0 ? 0 : 8);
        imageView.setVisibility(scanDataListSize > 1 ? 0 : 8);
        textView.setVisibility(scanDataListSize > 1 ? 0 : 8);
        textView.setText(String.valueOf(scanDataListSize));
    }
}
