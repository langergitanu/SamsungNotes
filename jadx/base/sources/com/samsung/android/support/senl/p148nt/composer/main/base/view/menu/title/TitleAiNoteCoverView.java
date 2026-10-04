package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.airbnb.lottie.LottieAnimationView;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.cover.AiCoverDataCreatorManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.cover.AiCoverMenuViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.cover.view.VIResultView;
import com.samsung.android.support.senl.p148nt.model.document.save.CoverThumbnailCreator;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TitleAiNoteCoverView implements View.OnClickListener {
    private static final String TAG = "TitleAiNoteCoverView";
    private final AiCoverMenuViewPresenter mAiCoverMenuViewPresenter;
    private final TextView mCancelView;
    private boolean mIsDarkTheme;
    private final View mPreview;
    private Drawable mPreviewBG;
    private final View mView;

    public TitleAiNoteCoverView(View view, AiCoverMenuViewPresenter aiCoverMenuViewPresenter) {
        this.mView = view.findViewById(C9086R.id.comp_title_ai_note_cover_container);
        this.mPreview = view.findViewById(C9086R.id.comp_title_ai_note_cover_thumbnail);
        this.mCancelView = (TextView) view.findViewById(C9086R.id.cover_loading_cancel);
        this.mAiCoverMenuViewPresenter = aiCoverMenuViewPresenter;
        initView();
    }

    private void cancelLoadingCover() {
        AiCoverDataCreatorManager.getInstance().cancelCreateCover(this.mAiCoverMenuViewPresenter.getUuid());
    }

    private void initView() {
        updateView();
        this.mPreview.setOnClickListener(this);
    }

    private void openCoverEditor() {
        this.mAiCoverMenuViewPresenter.onClickCoverView();
    }

    private void setDarkThemeInConfirmView() {
        int color;
        int color2;
        TextView textView = this.mCancelView;
        if (textView == null) {
            return;
        }
        if (this.mIsDarkTheme) {
            color = textView.getResources().getColor(C9086R.color.cover_generate_cancel_icon_text_color_dark, null);
            color2 = this.mCancelView.getResources().getColor(C9086R.color.cover_generate_cancel_icon_bg_color_dark, null);
        } else {
            color = textView.getResources().getColor(C9086R.color.cover_generate_cancel_icon_text_color, null);
            color2 = this.mCancelView.getResources().getColor(C9086R.color.cover_generate_cancel_icon_bg_color, null);
        }
        this.mCancelView.getBackground().setTint(color2);
        this.mCancelView.setTextColor(color);
    }

    private void setDarkThemeInPreviewBG() {
        View view = this.mView;
        if (view == null) {
            return;
        }
        int color = this.mIsDarkTheme ? view.getResources().getColor(C9086R.color.ai_menu_icon_bg_color_dark, null) : view.getResources().getColor(C9086R.color.ai_menu_icon_bg_color, null);
        Drawable drawable = this.mPreviewBG;
        if (drawable != null) {
            drawable.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN));
        }
    }

    public void completeView() {
        updateView();
        final VIResultView vIResultView = (VIResultView) this.mView.findViewById(C9086R.id.comp_title_ai_note_cover_border);
        vIResultView.setVisibility(0);
        vIResultView.setAnimContract(new VIResultView.AnimContract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.TitleAiNoteCoverView.1
            @Override // com.samsung.android.support.senl.nt.composer.main.cover.view.VIResultView.AnimContract
            public void onEnd() {
                vIResultView.setVisibility(8);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.cover.view.VIResultView.AnimContract
            public void onStart() {
            }
        });
        vIResultView.startAnimation();
    }

    public int getBottom() {
        Rect rect = new Rect();
        getView().getHitRect(rect);
        if (rect.height() != 0) {
            return rect.bottom;
        }
        return this.mView.getResources().getDimensionPixelSize(C9086R.dimen.comp_title_text_top_margin) + this.mView.getResources().getDimensionPixelSize(C9086R.dimen.comp_title_height_with_cover);
    }

    public View getView() {
        return this.mView;
    }

    public void hide() {
        Logger.m10999d(TAG, "hide#");
        this.mView.setVisibility(8);
        setLoadingView(8);
        setVisibleCancelView(8);
    }

    public void initCancelView() {
        this.mCancelView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        Logger.m10999d(TAG, "onClick# item : " + view.getTag());
        if (id == C9086R.id.comp_title_ai_note_cover_thumbnail) {
            openCoverEditor();
        } else if (id == C9086R.id.cover_loading_cancel) {
            cancelLoadingCover();
        }
    }

    public void setBackgroundColor(boolean z) {
        this.mIsDarkTheme = z;
        setDarkThemeInConfirmView();
        setDarkThemeInPreviewBG();
    }

    public void setLoadingView(int i) {
        this.mPreview.setBackground(this.mPreviewBG);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) this.mPreview.findViewById(C9086R.id.comp_title_ai_note_cover_progress);
        if (lottieAnimationView.getVisibility() == i) {
            return;
        }
        AbstractC0000a.m3D(i, "setLoadingView# visibility : ", TAG);
        if (i == 0) {
            this.mView.setVisibility(0);
            lottieAnimationView.setAnimation(ComposerConstants.COVER_PROGRESS_LOTTIE_FILE);
            lottieAnimationView.setRepeatCount(-1);
            lottieAnimationView.playAnimation();
        }
        lottieAnimationView.setVisibility(i);
    }

    public void setVisibleCancelView(int i) {
        this.mCancelView.setVisibility(i);
        this.mAiCoverMenuViewPresenter.updateNoteCoverConfirm(i);
    }

    public void show() {
        Logger.m10999d(TAG, "show#");
        this.mView.setVisibility(0);
    }

    public void updateView() {
        setLoadingView(8);
        this.mPreviewBG = ResourcesCompat.getDrawable(this.mView.getResources(), C9086R.drawable.cover_preview_background, null);
        setDarkThemeInPreviewBG();
        if (this.mAiCoverMenuViewPresenter.hasCover()) {
            String uuid = CoverThumbnailCreator.COVER_PATH_PREFIX + this.mAiCoverMenuViewPresenter.getUuid();
            if (!CoverThumbnailCreator.isExistCoverFile(BaseUtils.getApplicationContext(), uuid, CoverThumbnailCreator.ThumbnailType.SQUARE)) {
                uuid = this.mAiCoverMenuViewPresenter.getUuid();
            }
            Drawable coverThumbnail = CoverThumbnailCreator.getCoverThumbnail(BaseUtils.getApplicationContext(), uuid, CoverThumbnailCreator.ThumbnailType.RECT);
            float dimensionPixelSize = this.mView.getResources().getDimensionPixelSize(C9086R.dimen.cover_ai_note_cover_radius);
            RoundedBitmapDrawable roundedBitmapDrawableCreate = RoundedBitmapDrawableFactory.create(this.mView.getResources(), ((BitmapDrawable) coverThumbnail).getBitmap());
            roundedBitmapDrawableCreate.setCornerRadius(dimensionPixelSize);
            roundedBitmapDrawableCreate.setAntiAlias(true);
            this.mPreview.setBackground(roundedBitmapDrawableCreate);
        }
    }
}
