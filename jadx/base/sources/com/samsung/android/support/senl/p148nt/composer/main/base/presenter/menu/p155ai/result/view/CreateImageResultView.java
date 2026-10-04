package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiViewUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.CreateImage;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CreateImageResultView extends AbsAiActionResultView {
    private static final String TAG = Logger.createTag("CreateImageResultView", AiConstants.PREFIX_TAG);
    private final AiMenuResultCommonViews mCommonViews;
    private View mContainer;
    private final CreateImage mCreateImage;
    private View mOriginalContainer;
    private ImageView mOriginalImage;
    private final int mPageIndex;
    private ImageView mResultImage;

    public CreateImageResultView(CreateImage createImage, AiMenuResultCommonViews aiMenuResultCommonViews, int i) {
        super(aiMenuResultCommonViews);
        AbstractC0000a.m3D(i, "CreateImageResultView# ", TAG);
        this.mCreateImage = createImage;
        this.mCommonViews = aiMenuResultCommonViews;
        this.mPageIndex = i;
    }

    private String getCurrentOutputFilePath() {
        return this.mCreateImage.getSrcContentInfo().getOutputFilePaths().get(getImageIndex());
    }

    private Bitmap getCurrentOutputImage() {
        return BitmapFactory.decodeFile(this.mCreateImage.getSrcContentInfo().getOutputFilePaths().get(getImageIndex()));
    }

    private int getImageIndex() {
        return this.mCreateImage.getImageIndex(this.mPageIndex);
    }

    private Bitmap getOriginalImage(Bitmap bitmap) {
        if (!AiViewUtils.isSupportFloatingLayout()) {
            return bitmap;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(1);
        paint.setColorFilter(new PorterDuffColorFilter(this.mCommonViews.mActivity.getColor(C9086R.color.ai_drawing_original_stroke_color), PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return bitmapCreateBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPageSelected$0() {
        if (this.mPageIndex <= 0) {
            this.mCommonViews.getBottomView().getCopyBtn().setVisibility(4);
            this.mCommonViews.getBottomView().getReplaceBtn().setVisibility(4);
            this.mCommonViews.getBottomView().getAddToBtn().setVisibility(4);
            this.mCommonViews.getBottomView().getRetryBtn().setVisibility(0);
            this.mCommonViews.getBottomView().getGenerateOneMoreBtn().setVisibility(4);
        } else {
            this.mCommonViews.getBottomView().getCopyBtn().setVisibility(0);
            this.mCommonViews.getBottomView().getReplaceBtn().setVisibility(0);
            TextView replaceTextView = this.mCommonViews.getBottomView().getReplaceTextView();
            Objects.requireNonNull(replaceTextView);
            replaceTextView.post(new RunnableC9711g(replaceTextView, 13));
            this.mCommonViews.getBottomView().getAddToBtn().setVisibility(4);
            this.mCommonViews.getBottomView().getRetryBtn().setVisibility(4);
            this.mCommonViews.getBottomView().getGenerateOneMoreBtn().setVisibility(0);
            TextView generateOneMoreTextView = this.mCommonViews.getBottomView().getGenerateOneMoreTextView();
            Objects.requireNonNull(generateOneMoreTextView);
            generateOneMoreTextView.post(new RunnableC9711g(generateOneMoreTextView, 13));
        }
        this.mCommonViews.getBottomView().getView().requestLayout();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void clear() {
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public AiMenuContract.IAiAction getAction() {
        return this.mCreateImage;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public View inflateView(ViewGroup viewGroup) {
        return this.mPageIndex <= 0 ? LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.ai_create_image_result_view_original_layout, viewGroup, false) : LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.ai_create_image_result_view_layout, viewGroup, false);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void initView(View view, View view2) {
        AbstractC8014b.m7221w(new StringBuilder("initView# "), TAG, this.mPageIndex);
        this.mContainer = view2;
        updateLayout("initView");
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public boolean isInitialized() {
        return this.mPageIndex <= 0 ? this.mCreateImage.getSrcContentInfo().getSrcType() == 3 ? FileUtils.exists(this.mCreateImage.getSrcContentInfo().getInputFilePath()) : !TextUtils.isEmpty(this.mCreateImage.getSrcContentInfo().getTextData()) : FileUtils.exists(getCurrentOutputFilePath());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AbsAiActionResultView, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void onPageSelected() {
        if (this.mCommonViews.mViewPager.isInLayout()) {
            Logger.m11004w(TAG, "onPageSelected, ignore, viewpager is in layout, retry again in post logic, pageIndex: " + this.mPageIndex);
            final int i = 0;
            this.mCreateImage.getHandler().post(new Runnable(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.L

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ CreateImageResultView f6930b;

                {
                    this.f6930b = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    switch (i) {
                        case 0:
                            this.f6930b.onPageSelected();
                            break;
                        default:
                            this.f6930b.lambda$onPageSelected$0();
                            break;
                    }
                }
            });
            return;
        }
        int focusedOutputIndex = this.mCreateImage.getFocusedOutputIndex();
        int i2 = this.mPageIndex;
        if (focusedOutputIndex < i2) {
            ComposerSA.insertLog(ComposerSAConstants.SCREEN_AI_DRAWING_POPUP_RESULT, ComposerSAConstants.f7108xe374d102, "b");
        } else if (i2 < focusedOutputIndex) {
            ComposerSA.insertLog(ComposerSAConstants.SCREEN_AI_DRAWING_POPUP_RESULT, ComposerSAConstants.f7108xe374d102, "a");
        }
        this.mCreateImage.setFocusedOutputIndex(this.mPageIndex);
        if (this.mPageIndex <= 0) {
            AiMenuResultCommonViews aiMenuResultCommonViews = this.mCommonViews;
            ArrayList arrayList = new ArrayList(1);
            Object obj = new Object[]{4}[0];
            Objects.requireNonNull(obj);
            arrayList.add(obj);
            aiMenuResultCommonViews.setTopButtonsVisibility(Collections.unmodifiableList(arrayList));
        } else {
            AiMenuResultCommonViews aiMenuResultCommonViews2 = this.mCommonViews;
            Object[] objArr = {4, 2};
            ArrayList arrayList2 = new ArrayList(2);
            for (int i4 = 0; i4 < 2; i4++) {
                Object obj2 = objArr[i4];
                Objects.requireNonNull(obj2);
                arrayList2.add(obj2);
            }
            aiMenuResultCommonViews2.setTopButtonsVisibility(Collections.unmodifiableList(arrayList2));
        }
        this.mCommonViews.getBottomView().setDisabled(!this.mCreateImage.isFinishedState());
        final int i5 = 1;
        this.mCommonViews.getBottomView().getView().post(new Runnable(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.L

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CreateImageResultView f6930b;

            {
                this.f6930b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i5) {
                    case 0:
                        this.f6930b.onPageSelected();
                        break;
                    default:
                        this.f6930b.lambda$onPageSelected$0();
                        break;
                }
            }
        });
        updateLayout("onPageSelected");
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void setTitle() {
        this.mCommonViews.getTopView().setTitle(C9086R.string.ai_drawing_create_image_name, C9086R.drawable.ic_ai_menu_title, (Integer) null);
    }

    public void updateLayout(String str) {
        if (this.mContainer == null) {
            return;
        }
        boolean zIsFinishedState = this.mCreateImage.isFinishedState();
        String str2 = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("updateLayout# caller: ", str, ", pageIndex: ");
        sbM15l.append(this.mPageIndex);
        sbM15l.append(", isFinishedState: ");
        sbM15l.append(zIsFinishedState);
        Logger.m10999d(str2, sbM15l.toString());
        if (this.mPageIndex > 0) {
            ImageView imageView = (ImageView) this.mContainer.findViewById(C9086R.id.result_image);
            this.mResultImage = imageView;
            imageView.setVisibility(zIsFinishedState ? 0 : 8);
            if (zIsFinishedState) {
                this.mResultImage.setImageBitmap(getCurrentOutputImage());
                return;
            }
            return;
        }
        View viewFindViewById = this.mContainer.findViewById(C9086R.id.original_container);
        this.mOriginalContainer = viewFindViewById;
        viewFindViewById.setVisibility(zIsFinishedState ? 0 : 8);
        if (zIsFinishedState) {
            ImageView imageView2 = (ImageView) this.mContainer.findViewById(C9086R.id.original_image);
            this.mOriginalImage = imageView2;
            imageView2.setImageBitmap(getOriginalImage(BitmapFactory.decodeFile(this.mCreateImage.getSrcContentInfo().getInputFilePath())));
        }
    }
}
