package com.samsung.android.support.senl.p148nt.app.common.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.Property;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.DrawableUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.common.ImportFolderConstants;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.common.utils.ImportFolderUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ButtonBackgroundUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.FontUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class FolderPathLayout extends LinearLayout implements View.OnClickListener {
    private static final String TAG = "FolderPathLayout";
    private final float FOLDER_ICON_WIDTH;
    private NotesFolder mCurFolder;
    private int mCurFolderColor;
    private AnimatorSet mDepthInAnimation;
    private View mFolderHomeButton;
    private LinearLayout mFolderPathLayout;
    private boolean mHasPaddingInActivity;
    private HorizontalScrollView mHorizontalScrollView;
    private IFolderPathLayoutListener mIFolderPathLayoutListener;
    private boolean mIsDepthIn;

    public FolderPathLayout(Context context) {
        super(context);
        this.FOLDER_ICON_WIDTH = getResources().getDimension(C8003R.dimen.folderpath_folder_width);
        this.mCurFolder = DataManager.getInstance().getFolderData("uncategorized:///");
        this.mIsDepthIn = false;
        this.mCurFolderColor = 0;
        this.mHasPaddingInActivity = false;
    }

    private void addFolderPathView(String str, String str2, boolean z) {
        StringBuilder sbM15l = AbstractC0000a.m15l("folderUuid: ", str, ", displayName: ");
        sbM15l.append(MainLogger.getEncode(str2));
        sbM15l.append(", isLast: ");
        sbM15l.append(z);
        MainLogger.m7258i(TAG, sbM15l.toString());
        View viewInflate = LayoutInflater.from(getContext()).inflate(C8003R.layout.folderpath_item, (ViewGroup) this.mFolderPathLayout, false);
        View viewFindViewById = viewInflate.findViewById(C8003R.id.folderpath_arrow);
        if (LocaleUtils.isRTLMode()) {
            viewFindViewById.setRotation(180.0f);
        }
        TextView folderNameView = getFolderNameView(viewInflate, str, str2);
        if (z) {
            applyFolderTextStyle(folderNameView, true);
            ImageView imageView = (ImageView) viewInflate.findViewById(C8003R.id.folderpath_folder);
            imageView.setColorFilter(this.mCurFolderColor);
            imageView.setVisibility(0);
        } else {
            applyFolderTextStyle(folderNameView, false);
        }
        viewInflate.setTag(str);
        this.mFolderPathLayout.addView(viewInflate);
    }

    private boolean addLastItem(NotesFolder notesFolder) {
        if (!PredefinedCategory.isRootFolder(this.mCurFolder.getUuid()) && this.mFolderPathLayout.findViewWithTag(this.mCurFolder.getUuid()) == null) {
            return false;
        }
        AnimatorSet animatorSet = this.mDepthInAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        View viewFindViewWithTag = this.mFolderPathLayout.findViewWithTag(this.mCurFolder.getUuid());
        if (viewFindViewWithTag != null) {
            applyFolderTextStyle((TextView) viewFindViewWithTag.findViewById(C8003R.id.folderpath_text), false);
        }
        View viewInflate = LayoutInflater.from(getContext()).inflate(C8003R.layout.folderpath_item, (ViewGroup) this.mFolderPathLayout, false);
        View viewFindViewById = viewInflate.findViewById(C8003R.id.folderpath_arrow);
        if (LocaleUtils.isRTLMode()) {
            viewFindViewById.setRotation(180.0f);
        }
        applyFolderTextStyle(getFolderNameView(viewInflate, notesFolder.getUuid(), notesFolder.getDisplayName()), true);
        ImageView imageView = (ImageView) viewInflate.findViewById(C8003R.id.folderpath_folder);
        imageView.setColorFilter(this.mCurFolderColor);
        imageView.setVisibility(0);
        viewInflate.setTag(notesFolder.getUuid());
        depthInAnimation(viewInflate, viewFindViewWithTag);
        return true;
    }

    private void applyFolderTextStyle(TextView textView, boolean z) {
        CharUtils.applyTextSizeUntilLargeSize(textView.getContext(), textView, 13.0f);
        if (z) {
            FontUtils.setFont(textView, "Roboto_Medium");
            textView.setTextColor(getResources().getColor(C8003R.color.folderpath_selected_text_color, null));
            textView.setBackgroundColor(getResources().getColor(C8003R.color.transparent, null));
            return;
        }
        FontUtils.setFont(textView, "Roboto_Regular");
        if (ButtonBackgroundUtils.isShowButtonShapeEnabled(getContext())) {
            textView.setBackgroundResource(C8003R.drawable.accessability_folderpath_text_bg);
            textView.setTextColor(getResources().getColor(NotesUtils.getAntiGreenisFilteredColor(C8003R.color.settings_list_background_color), null));
        } else {
            textView.setBackgroundResource(C8003R.drawable.text_only_flat_button_ripple_bg);
            textView.setTextColor(getResources().getColor(C8003R.color.folderpath_text_color, null));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0071, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean deleteChildFolder(String str) {
        if (this.mFolderPathLayout.findViewWithTag(str) != null && this.mFolderPathLayout.findViewWithTag(this.mCurFolder.getUuid()) != null) {
            NotesFolder parent = this.mCurFolder;
            while (true) {
                if (PredefinedCategory.isRootFolder(parent.getUuid())) {
                    break;
                }
                View viewFindViewWithTag = this.mFolderPathLayout.findViewWithTag(parent.getUuid());
                if (parent.getUuid().equals(str)) {
                    ((ImageView) viewFindViewWithTag.findViewById(C8003R.id.folderpath_folder)).setColorFilter(this.mCurFolderColor);
                    depthOutAnimation(viewFindViewWithTag, true);
                    break;
                }
                MainLogger.m7254d(TAG, "deleteChildFolder: " + parent.getUuid());
                if (viewFindViewWithTag == null) {
                    MainLogger.m7254d(TAG, "deleteChildFolder: EMPTY VIEW");
                    return false;
                }
                depthOutAnimation(viewFindViewWithTag, false);
                parent = parent.getParent();
            }
        } else {
            MainLogger.m7258i(TAG, "deleteChildFolder: WRONG PATH");
            return false;
        }
    }

    private void depthInAnimation(View view, @Nullable View view2) {
        this.mIsDepthIn = true;
        this.mFolderPathLayout.post(new RunnableC8044b(this, view, view2, view2 == null ? null : (ImageView) view2.findViewById(C8003R.id.folderpath_folder), 1));
    }

    private void depthOutAnimation(final View view, final boolean z) {
        ObjectAnimator transAnimator;
        ObjectAnimator alphaAnimator;
        final ImageView imageView;
        this.mIsDepthIn = false;
        AnimatorSet animatorSet = this.mDepthInAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        float fApplyDimension = TypedValue.applyDimension(1, 5.0f, getContext().getResources().getDisplayMetrics());
        AnimatorSet animatorSet2 = new AnimatorSet();
        if (z) {
            View view2 = (TextView) view.findViewById(C8003R.id.folderpath_text);
            imageView = (ImageView) view.findViewById(C8003R.id.folderpath_folder);
            view2.setTranslationX(0.0f);
            transAnimator = getTransAnimator(view2, view2.getTranslationX() - this.FOLDER_ICON_WIDTH, view2.getTranslationX());
            alphaAnimator = getAlphaAnimator(imageView, true, 200);
        } else {
            transAnimator = getTransAnimator(view, view.getTranslationX() - this.FOLDER_ICON_WIDTH, (view.getTranslationX() - this.FOLDER_ICON_WIDTH) - fApplyDimension);
            alphaAnimator = getAlphaAnimator(view, false, 200);
            imageView = null;
        }
        animatorSet2.playTogether(transAnimator, alphaAnimator);
        animatorSet2.addListener(new Animator.AnimatorListener() { // from class: com.samsung.android.support.senl.nt.app.common.widget.FolderPathLayout.2
            private void onAnimationFinished() {
                if (z) {
                    return;
                }
                FolderPathLayout.this.mFolderPathLayout.removeView(view);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NonNull Animator animator) {
                onAnimationFinished();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NonNull Animator animator) {
                onAnimationFinished();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@NonNull Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NonNull Animator animator) {
                if (z) {
                    FolderPathLayout.this.mHorizontalScrollView.smoothScrollTo((view.getRight() - FolderPathLayout.this.mHorizontalScrollView.getWidth()) + ((int) FolderPathLayout.this.FOLDER_ICON_WIDTH), 0);
                    imageView.setAlpha(0.0f);
                    imageView.setVisibility(0);
                }
            }
        });
        animatorSet2.start();
    }

    private ObjectAnimator getAlphaAnimator(View view, boolean z, int i) {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.ALPHA, z ? 0.0f : 1.0f, z ? 1.0f : 0.0f));
        objectAnimatorOfPropertyValuesHolder.setDuration(i);
        return objectAnimatorOfPropertyValuesHolder;
    }

    private void getDepthInAnimation(final View view, @Nullable final View view2, @Nullable final ImageView imageView) {
        ObjectAnimator alphaAnimator;
        float fApplyDimension = TypedValue.applyDimension(1, 5.0f, getContext().getResources().getDisplayMetrics());
        float f = this.FOLDER_ICON_WIDTH;
        ObjectAnimator transAnimator = null;
        final TextView textView = view2 == null ? null : (TextView) view2.findViewById(C8003R.id.folderpath_text);
        if (view2 != null) {
            transAnimator = getTransAnimator(textView, textView.getTranslationX(), textView.getTranslationX() - f);
            alphaAnimator = getAlphaAnimator(imageView, false, 100);
        } else {
            f = 0.0f;
            alphaAnimator = null;
        }
        ObjectAnimator transAnimator2 = getTransAnimator(view, (view.getTranslationX() - f) - fApplyDimension, view.getTranslationX() - f);
        ObjectAnimator alphaAnimator2 = getAlphaAnimator(view, true, 200);
        AnimatorSet animatorSet = this.mDepthInAnimation;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.mDepthInAnimation = animatorSet2;
        if (transAnimator != null) {
            animatorSet2.playTogether(transAnimator, alphaAnimator, transAnimator2, alphaAnimator2);
        } else {
            animatorSet2.playTogether(transAnimator2, alphaAnimator2);
        }
        this.mDepthInAnimation.addListener(new Animator.AnimatorListener() { // from class: com.samsung.android.support.senl.nt.app.common.widget.FolderPathLayout.1
            private void onAnimationFinished() {
                ImageView imageView2;
                if (view2 != null) {
                    if (FolderPathLayout.this.mIsDepthIn && (imageView2 = imageView) != null) {
                        imageView2.setVisibility(8);
                    }
                    textView.setTranslationX(0.0f);
                }
                view.setAlpha(1.0f);
                view.setTranslationX(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NonNull Animator animator) {
                onAnimationFinished();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NonNull Animator animator) {
                onAnimationFinished();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@NonNull Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NonNull Animator animator) {
            }
        });
        this.mDepthInAnimation.start();
    }

    private TextView getFolderNameView(View view, String str, String str2) {
        return getFolderNameView(view, str, str2, true);
    }

    private ObjectAnimator getTransAnimator(View view, float f, float f4) {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, f, f4));
        objectAnimatorOfPropertyValuesHolder.setInterpolator(PathInterpolatorCompat.create(0.22f, 0.25f, 0.0f, 1.0f));
        objectAnimatorOfPropertyValuesHolder.setDuration(450L);
        return objectAnimatorOfPropertyValuesHolder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$depthInAnimation$2(View view, View view2, ImageView imageView) {
        this.mHorizontalScrollView.smoothScrollTo((this.mFolderPathLayout.getMeasuredWidth() - this.mHorizontalScrollView.getMeasuredWidth()) - ((int) this.FOLDER_ICON_WIDTH), 0);
        getDepthInAnimation(view, view2, imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$depthInAnimation$3(View view, View view2, ImageView imageView) {
        view.setAlpha(0.0f);
        this.mFolderPathLayout.addView(view);
        this.mHorizontalScrollView.post(new RunnableC8044b(this, view, view2, imageView, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$resetFolderPath$1() {
        if (LocaleUtils.isRTLMode()) {
            this.mHorizontalScrollView.fullScroll(17);
        } else {
            this.mHorizontalScrollView.fullScroll(66);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateCurrentPath$0() {
        if (LocaleUtils.isRTLMode()) {
            this.mHorizontalScrollView.fullScroll(17);
        } else {
            this.mHorizontalScrollView.fullScroll(66);
        }
    }

    private void resetFolderPath(NotesFolder notesFolder) {
        this.mFolderPathLayout.removeAllViews();
        updateParentPath(notesFolder.getParent());
        addFolderPathView(notesFolder.getUuid(), notesFolder.getDisplayName(), true);
        this.mFolderPathLayout.invalidate();
        this.mFolderPathLayout.post(new RunnableC8043a(this, 1));
    }

    private void updateParentPath(NotesFolder notesFolder) {
        if (notesFolder == null || notesFolder.getParent() == null) {
            return;
        }
        if (!PredefinedCategory.isRootFolder(notesFolder.getParentUuid())) {
            updateParentPath(notesFolder.getParent());
        }
        addFolderPathView(notesFolder.getUuid(), notesFolder.getDisplayName(), false);
    }

    public boolean getHasPaddingInActivity() {
        return this.mHasPaddingInActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str = (String) view.getTag();
        if (view.getId() == C8003R.id.folderpath_home) {
            str = FolderConstants.MyFolders.UUID;
        }
        if (str == null || str.isEmpty() || str.equals(this.mIFolderPathLayoutListener.getFolderUuid())) {
            return;
        }
        MainLogger.m7258i(TAG, "uuid: ".concat(str));
        this.mIFolderPathLayoutListener.onFolderLayoutSelected(str);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        View viewFindViewById = findViewById(C8003R.id.folderpath_home);
        this.mFolderHomeButton = viewFindViewById;
        viewFindViewById.setOnClickListener(this);
        ViewCompat.getInstance().setTooltipText(this.mFolderHomeButton, getContext().getString(C8003R.string.settings_my_folders));
        this.mFolderHomeButton.setContentDescription(getContext().getResources().getString(C8003R.string.go_to_home_folder, getContext().getString(C8003R.string.settings_my_folders)));
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) findViewById(C8003R.id.folderpath_scrollview);
        this.mHorizontalScrollView = horizontalScrollView;
        horizontalScrollView.fullScroll(LocaleUtils.isRTLMode() ? 17 : 66);
        this.mHorizontalScrollView.setHorizontalFadingEdgeEnabled(true);
        this.mHorizontalScrollView.setFadingEdgeLength(getResources().getDimensionPixelSize(C8003R.dimen.folderpath_layout_left_dim_width));
        this.mFolderPathLayout = (LinearLayout) findViewById(C8003R.id.folderpath_layout);
    }

    public void onVisibilityGone(boolean z, boolean z2) {
        if (z) {
            this.mFolderPathLayout.removeAllViews();
        }
        if (z2) {
            this.mCurFolder = DataManager.getInstance().getFolderData("uncategorized:///");
        }
    }

    public void playHomeIcAnimation() {
        View view = this.mFolderHomeButton;
        if (view != null) {
            view.setScaleX(0.0f);
            this.mFolderHomeButton.setScaleY(0.0f);
            ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.mFolderHomeButton, PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, 0.0f, 1.0f), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, 0.0f, 1.0f));
            objectAnimatorOfPropertyValuesHolder.setInterpolator(PathInterpolatorCompat.create(0.22f, 0.25f, 0.0f, 1.0f));
            objectAnimatorOfPropertyValuesHolder.setDuration(450L);
            objectAnimatorOfPropertyValuesHolder.start();
        }
    }

    public void setFolderHomeButtonVisibility(boolean z) {
        findViewById(C8003R.id.folderpath_home).setVisibility(z ? 0 : 8);
    }

    public void setHasPaddingInActivity(boolean z) {
        this.mHasPaddingInActivity = z;
    }

    public void setIFolderPathLayoutListener(IFolderPathLayoutListener iFolderPathLayoutListener) {
        this.mIFolderPathLayoutListener = iFolderPathLayoutListener;
    }

    public void updateBackgroundColor(@ColorRes int i) {
        GradientDrawable gradientDrawable = (GradientDrawable) getResources().getDrawable(C8003R.drawable.folder_path_bg, null);
        gradientDrawable.setColor(getResources().getColor(i, null));
        setBackground(gradientDrawable);
    }

    public void updateCurrentPath(String[] strArr) {
        this.mHorizontalScrollView.setHorizontalFadingEdgeEnabled(false);
        this.mFolderPathLayout.removeAllViews();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < strArr.length) {
            sb.append(strArr[i]);
            String string = sb.toString();
            sb.append('/');
            View viewInflate = LayoutInflater.from(getContext()).inflate(C8003R.layout.folderpath_item, (ViewGroup) this.mFolderPathLayout, false);
            View viewFindViewById = viewInflate.findViewById(C8003R.id.folderpath_arrow);
            if (i == 0) {
                viewFindViewById.setVisibility(8);
            } else if (LocaleUtils.isRTLMode()) {
                viewFindViewById.setRotation(180.0f);
            }
            boolean z = true;
            TextView folderNameView = getFolderNameView(viewInflate, string, strArr[i], i > 2 || ImportFolderUtils.getSnotePickerType() != ImportFolderConstants.SnotePickerType.RESTRICTED_LOCAL);
            i++;
            if (i != strArr.length) {
                z = false;
            }
            applyFolderTextStyle(folderNameView, z);
            this.mFolderPathLayout.addView(viewInflate);
        }
        this.mFolderPathLayout.invalidate();
        this.mFolderPathLayout.post(new RunnableC8043a(this, 0));
    }

    private TextView getFolderNameView(View view, String str, String str2, boolean z) {
        TextView textView = (TextView) view.findViewById(C8003R.id.folderpath_text);
        if (FolderConstants.MyFolders.UUID.equals(str)) {
            str2 = getContext().getString(C8003R.string.settings_my_folders);
        }
        textView.setText(str2);
        textView.setClickable(z);
        if (z) {
            textView.setTag(str);
            textView.setOnClickListener(this);
        }
        textView.setContentDescription(textView.getText().toString() + view.getResources().getString(C8003R.string.string_comma) + ' ' + view.getResources().getString(C8003R.string.tipcard_button_content_description));
        return textView;
    }

    public FolderPathLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.FOLDER_ICON_WIDTH = getResources().getDimension(C8003R.dimen.folderpath_folder_width);
        this.mCurFolder = DataManager.getInstance().getFolderData("uncategorized:///");
        this.mIsDepthIn = false;
        this.mCurFolderColor = 0;
        this.mHasPaddingInActivity = false;
    }

    public FolderPathLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.FOLDER_ICON_WIDTH = getResources().getDimension(C8003R.dimen.folderpath_folder_width);
        this.mCurFolder = DataManager.getInstance().getFolderData("uncategorized:///");
        this.mIsDepthIn = false;
        this.mCurFolderColor = 0;
        this.mHasPaddingInActivity = false;
    }

    public void updateCurrentPath(NotesFolder notesFolder, boolean z) {
        NotesFolder notesFolder2;
        boolean zAddLastItem;
        if (notesFolder == null || (notesFolder2 = this.mCurFolder) == null || notesFolder2.getUuid().equals(notesFolder.getUuid())) {
            return;
        }
        MainLogger.m7254d(TAG, "updateCurrentPath# curFolder : " + this.mCurFolder.getUuid() + ", newFolder : " + notesFolder.getUuid());
        if (PredefinedCategory.isRootFolder(notesFolder.getUuid())) {
            this.mCurFolder = notesFolder;
            return;
        }
        updateBackgroundColor(C8003R.color.folderpath_bg_color);
        this.mCurFolderColor = getContext().getColor(DrawableUtils.getConvertedNewFolderColor(getContext(), notesFolder.getDisplayNameColor()));
        if (z) {
            MainLogger.m7254d(TAG, "updateCurrentPath# deleteChildFolder()");
            zAddLastItem = deleteChildFolder(notesFolder.getUuid());
            if (zAddLastItem) {
                applyFolderTextStyle((TextView) this.mFolderPathLayout.findViewWithTag(notesFolder.getUuid()).findViewById(C8003R.id.folderpath_text), true);
            }
        } else if (this.mCurFolder.getUuid().equals(notesFolder.getParentUuid())) {
            MainLogger.m7254d(TAG, "updateCurrentPath# addLastItem()");
            zAddLastItem = addLastItem(notesFolder);
        } else {
            zAddLastItem = false;
        }
        if (!zAddLastItem) {
            MainLogger.m7254d(TAG, "updateCurrentPath: resetFolderPath()");
            resetFolderPath(notesFolder);
        }
        this.mCurFolder = notesFolder;
    }
}
