package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.ClipData;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Property;
import android.view.DragEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.PathInterpolator;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.content.res.ResourcesCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.fragment.app.FragmentActivity;
import androidx.transition.C3970a;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p145cm.base.framework.media.AudioManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.sem.widget.PopupMenuImpl;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.penrecyclerview.OnDragAndDropListener;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.FolderUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NoteListToDrag;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.ThumbnailBitmapUtil;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.view.NotesPenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.main.common.view.NumberedBadgeShadowBuilder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.NotesHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.SubFolderHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holderinfo.NotesHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holderinfo.SubFolderHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.utils.ThumbnailPathUtils;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.DocumentMap;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.NotesModel;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.StateInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.checkdata.CheckNotesCountInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.C8416h;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ViewParams;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import p001A.AbstractC0000a;
import p122b2.RunnableC4199v;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class DragAndDropHelper {
    private static final String TAG = "DragAndDropHelper";
    private final DocumentMap mDocumentMap;
    private final NotesModel mNotesModel;
    private NumberedBadgeShadowBuilder mNumberedBadgeShadowBuilder;
    private PopupMenuImpl mPopupMenu;
    private final IPresenter mPresenter;
    private View mPreviewImageView;
    private final NotesPenRecyclerView mRecyclerView;
    private final AudioManagerCompat.SoundManager mSoundManager;
    private final StateInfo mStateInfo;
    private final ViewParams mViewParams;
    private final Set<String> mResetPressedStateUuids = new HashSet();
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private DragCardView mDragCardView = null;
    private final Runnable mDragAndDropRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DragAndDropHelper.1
        @Override // java.lang.Runnable
        public void run() {
            MainLogger.m7254d("DragAndDropHelper", "DragAndDropRunnable run");
            String postDragAndDropUuid = DragAndDropHelper.this.mNotesModel.getPostDragAndDropUuid();
            if (DragAndDropHelper.this.isDragAndDropEnableMode() && DragAndDropHelper.this.mNotesModel.isUuidInCheckedData(postDragAndDropUuid) && DragAndDropHelper.this.isDragAndDropEnable(postDragAndDropUuid)) {
                if (!DragAndDropHelper.this.isPopupMenuOnlyEnable()) {
                    DragAndDropHelper.this.startDragAndDrop(postDragAndDropUuid);
                    return;
                }
                CommonHolder commonHolder = (CommonHolder) DragAndDropHelper.this.mRecyclerView.findViewHolderForAdapterPosition(DragAndDropHelper.this.mDocumentMap.indexOfDisplayData(postDragAndDropUuid));
                if (commonHolder != null) {
                    DragAndDropHelper dragAndDropHelper = DragAndDropHelper.this;
                    dragAndDropHelper.createPopupMenu(dragAndDropHelper.getRootCardView(postDragAndDropUuid, commonHolder));
                    return;
                }
            }
            DragAndDropHelper.this.resetHolderPressedState();
            DragAndDropHelper.this.cancelDragAndDrop();
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DragCardView {
        final View rootCardView;
        boolean scrollBlockedOnce = false;
        final String uuid;

        public DragCardView(View view, String str) {
            this.rootCardView = view;
            this.uuid = str;
        }

        public View getRootCardView() {
            return this.rootCardView;
        }

        public String getUuid() {
            return this.uuid;
        }

        public boolean isScrollBlockedOnce() {
            return this.scrollBlockedOnce;
        }

        public void setScrollBlockedOnce(boolean z) {
            this.scrollBlockedOnce = z;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IPresenter {
        void endLongPressed();

        boolean isLongPressMoved();

        void resumeLongPressMultiSelection();

        void showDragAndDropImage(int i, View view, int i2);

        void showProgressCircle(int i);

        void stopLongPressMultiSelection();

        void toggleFolderExpandCollapseState();

        void updateContentDescription(CommonHolderInfo commonHolderInfo, boolean z);
    }

    public DragAndDropHelper(ViewParams viewParams, StateInfo stateInfo, NotesModel notesModel, DocumentMap documentMap, IPresenter iPresenter) {
        this.mViewParams = viewParams;
        this.mStateInfo = stateInfo;
        this.mNotesModel = notesModel;
        this.mDocumentMap = documentMap;
        this.mPresenter = iPresenter;
        this.mRecyclerView = viewParams.getNotesRecyclerView();
        this.mSoundManager = AudioManagerCompat.getInstance().createHapticDetachSound(viewParams.getContext());
    }

    private void addFakeDragAndDropShadow() {
        if (this.mPreviewImageView.getParent() == null) {
            this.mPreviewImageView.setAlpha(0.7071f);
            this.mPresenter.showDragAndDropImage(200, this.mPreviewImageView, getShadowSize());
            moveFakeDragAndDropShadow();
        }
    }

    private void addUuidToResetPressedStateUuids(String str) {
        synchronized (this.mResetPressedStateUuids) {
            this.mResetPressedStateUuids.add(str);
        }
    }

    private void animate3DRotation(View view, float f, float f4, PathInterpolator pathInterpolator, final Runnable runnable, final View view2) {
        Animation animationCreate3DRotationAnimation = create3DRotationAnimation(f, f4, view.getWidth() / 2.0f, view.getHeight());
        animationCreate3DRotationAnimation.setDuration(450L);
        animationCreate3DRotationAnimation.setInterpolator(pathInterpolator);
        animationCreate3DRotationAnimation.setFillAfter(true);
        if (runnable != null) {
            animationCreate3DRotationAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DragAndDropHelper.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DragAndDropHelper.animateSpring(view2, 0.77f, 300.0f, 50.0f);
                    runnable.run();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
        }
        view.startAnimation(animationCreate3DRotationAnimation);
    }

    private void animateScale(View view, float f, float f4, int i, PathInterpolator pathInterpolator) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_X, f, f4);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_Y, f, f4);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        animatorSet.setDuration(i);
        animatorSet.setInterpolator(pathInterpolator);
        animatorSet.start();
    }

    public static void animateSpring(final View view, final float f, final float f4, final float f5) {
        if (view.getVisibility() != 0) {
            view.setTranslationY(f5);
            view.postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.f
                @Override // java.lang.Runnable
                public final void run() {
                    DragAndDropHelper.lambda$animateSpring$7(view, f, f4);
                }
            }, 0L);
        } else {
            view.setPivotX(view.getWidth() / 2.0f);
            view.setPivotY(view.getHeight() / 2.0f);
            view.animate().scaleX(0.0f).scaleY(0.0f).setDuration(0L).setInterpolator(new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f)).withEndAction(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.e
                @Override // java.lang.Runnable
                public final void run() {
                    DragAndDropHelper.lambda$animateSpring$6(view, f5, f, f4);
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelDragAndDrop() {
        MainLogger.m7254d("DragAndDropHelper", "cancelDragAndDrop");
        this.mRecyclerView.removeOnDragAndDropListener();
        this.mViewParams.getNotesView().getMode().showBottomNavigation(!this.mRecyclerView.isLongPressed() && this.mNotesModel.getCheckedDataCount() > 0);
        this.mNumberedBadgeShadowBuilder = null;
        this.mDragCardView = null;
        if (this.mPresenter.isLongPressMoved()) {
            return;
        }
        this.mPresenter.endLongPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: createNoteShadow, reason: merged with bridge method [inline-methods] */
    public void lambda$getNumberedBadgeShadowBuilder$2(String str, NotesHolder notesHolder, ImageView imageView) {
        MainListDocumentData noteData = this.mDocumentMap.getNoteData(str);
        if (noteData == null) {
            return;
        }
        if (NotesUtils.isLock(noteData.getIsLock())) {
            imageView.setImageDrawable(ResourcesCompat.getDrawable(imageView.getResources(), C8003R.drawable.ic_lock, null));
        } else {
            notesHolder.setSimpleViewBackgroundColor(imageView);
            if (noteData.isSDoc()) {
                int iIntValue = noteData.getFirstContentType().intValue();
                if (iIntValue == 1) {
                    notesHolder.createTextBitmap(imageView, noteData);
                } else if (iIntValue != 3) {
                    imageView.setImageBitmap(ThumbnailBitmapUtil.getBitmapInfoForImageView(imageView, ThumbnailPathUtils.getSdocThumbnailFilePath(noteData.getContentUuid()), 3).bitmap);
                } else {
                    imageView.setImageBitmap(ThumbnailBitmapUtil.getBitmapInfoForImageView(imageView, ThumbnailPathUtils.getSdocHWThumbnailFilePath(noteData.getStrokeUuid(), 3), 3).bitmap);
                }
            } else {
                imageView.setImageBitmap(ThumbnailBitmapUtil.getBitmapInfoForImageView(imageView, ThumbnailPathUtils.getSimpleThumbnailFilePath(str, notesHolder.getNotesHolderInfo().isDarkMode(), notesHolder.getNotesHolderInfo().isSupportInvertedBGColor()), 3).bitmap);
            }
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PopupWindow createPopupMenu(View view) {
        if (view == null) {
            MainLogger.m7255e("DragAndDropHelper", "createPopupMenu# anchorView null");
            return null;
        }
        int optionMenuRes = this.mViewParams.getNotesView().getMode().getOptionMenuRes();
        if (optionMenuRes == 0) {
            MainLogger.m7255e("DragAndDropHelper", "createPopupMenu# not defined option menu");
            return null;
        }
        int shadowSize = getShadowSize();
        PopupMenuImpl popupMenuImpl = new PopupMenuImpl(this.mViewParams.getContext(), view, 8388611);
        this.mPopupMenu = popupMenuImpl;
        popupMenuImpl.seslSetOverflowOnly(false);
        this.mPopupMenu.inflate(optionMenuRes);
        this.mViewParams.getNotesView().getMode().onPrepareContextMenu(this.mPopupMenu.getMenu());
        View view2 = this.mPreviewImageView;
        this.mPopupMenu.seslSetOffset((int) (((double) (this.mRecyclerView.getStartX() - view.getX())) + ((view2 == null ? this.mRecyclerView.getRawX() : view2.getX()) < ((float) this.mRecyclerView.getWidth()) / 2.0f ? ((double) shadowSize) / 1.5d : ((double) (-shadowSize)) * 2.5d)), 0);
        this.mPopupMenu.show();
        PopupWindow popupWindowSeslGetPopupWindow = this.mPopupMenu.seslGetPopupWindow();
        if (popupWindowSeslGetPopupWindow == null) {
            return null;
        }
        popupWindowSeslGetPopupWindow.setSplitTouchEnabled(true);
        popupWindowSeslGetPopupWindow.setOutsideTouchable(true);
        this.mPopupMenu.seslUpdate();
        this.mPopupMenu.setOnMenuItemClickListener(new C8497c(this));
        return popupWindowSeslGetPopupWindow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public NumberedBadgeShadowBuilder getNumberedBadgeShadowBuilder(String str, CommonHolder commonHolder) {
        return commonHolder.getMHolderType() > 1024 ? new NumberedBadgeShadowBuilder(this.mViewParams.getContext(), this.mNotesModel.getCheckedDataCount(), new C3970a(this, 3, str, commonHolder)) : new NumberedBadgeShadowBuilder(this.mViewParams.getContext(), this.mNotesModel.getCheckedDataCount(), new C8416h(1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getRootCardView(String str, CommonHolder commonHolder) {
        int holderType = commonHolder.getMHolderType();
        CommonHolderInfo subFolderHolderInfo = holderType <= 1024 ? ((SubFolderHolder) commonHolder).getSubFolderHolderInfo(str) : holderType <= 2048 ? ((NotesHolder) commonHolder).getNotesHolderInfo() : null;
        if (subFolderHolderInfo == null) {
            return null;
        }
        return subFolderHolderInfo.getRootCardView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getShadowSize() {
        return this.mViewParams.getContext().getResources().getDimensionPixelSize(C8003R.dimen.note_drag_n_drop_shadow_width);
    }

    private boolean isDestinationFolderInvisible() {
        return !NotesUtils.isTabletLayout(this.mViewParams.getContext()) && (this.mDocumentMap.getCommonDisplayList().size() - this.mDocumentMap.getHolderInfoDisplayedCount()) - this.mDocumentMap.getNoteDataCount() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDragAndDropEnable(String str) {
        return (!this.mRecyclerView.isLongPressed() || this.mPresenter.isLongPressMoved() || TextUtils.isEmpty(str) || this.mViewParams.getNotesRecyclerView().isPenMultiSelectionOn()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDragAndDropEnableMode() {
        int modeIndex = this.mViewParams.getModeIndex();
        return (FeatureUtils.isMDEMode(modeIndex) || FeatureUtils.isRecyclebinMode(modeIndex) || FeatureUtils.isDrawerInvisibleMode(modeIndex) || this.mViewParams.getNotesRecyclerView().isPenMultiSelectionOn()) ? false : true;
    }

    private boolean isEdgePanelDnD(CheckNotesCountInfo checkNotesCountInfo) {
        return this.mNotesModel.getCheckedNotesCount() == 1 && checkNotesCountInfo.getLockedNotesCount() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPopupMenuOnlyEnable() {
        return this.mNotesModel.getCheckedNotesCount() > 1 && !this.mViewParams.getNotesRecyclerView().isPenMultiSelectionOn() && isDestinationFolderInvisible();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$animateSpring$6(View view, float f, float f4, float f5) {
        view.setTranslationY(f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        startSpringTranslateY(view, f4, f5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$animateSpring$7(View view, float f, float f4) {
        view.setVisibility(0);
        startSpringTranslateY(view, f, f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$createPopupMenu$0(MenuItem menuItem) {
        return this.mViewParams.getNotesView().getMode().onOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setDragListener$4(String str) {
        this.mViewParams.getNotesView().dragAndDropFinished(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setDragListener$5(CommonHolderInfo commonHolderInfo, View view, DragEvent dragEvent) {
        int iIndexOfDefaultDisplayData;
        int iIndexOfDefaultDisplayData2;
        if (commonHolderInfo.getHolderType() == 4096) {
            if (dragEvent.getAction() == 5 && (iIndexOfDefaultDisplayData2 = this.mDocumentMap.indexOfDefaultDisplayData(6) - 1) >= 0) {
                this.mRecyclerView.smoothScrollToPosition(iIndexOfDefaultDisplayData2);
                return true;
            }
        } else if (commonHolderInfo.getHolderType() != 4194304) {
            String uuid = commonHolderInfo.getUuid();
            PopupMenuImpl popupMenuImpl = this.mPopupMenu;
            if (popupMenuImpl != null) {
                popupMenuImpl.dismiss();
                this.mPopupMenu = null;
            }
            int action = dragEvent.getAction();
            if (action == 3) {
                this.mDragCardView = null;
                if (commonHolderInfo.getHolderType() > 1024 || (FolderUtils.isStaticFolder(uuid) && this.mNotesModel.getCheckedFoldersCount() > 0)) {
                    return false;
                }
                onFolderDragEventEnter(false, view.findViewById(C8003R.id.sub_folder_container), new RunnableC4199v(this, uuid, 27));
                MainLogger.m7254d("DragAndDropHelper", "setDragListener#onDrag# drop");
                return true;
            }
            if (action == 4) {
                this.mViewParams.getNotesView().setDrawerIconDimDragStatus(false, null);
                this.mViewParams.getNotesView().getMode().showBottomNavigation(this.mNotesModel.getCheckedDataCount() > 0);
                this.mNumberedBadgeShadowBuilder = null;
                this.mDragCardView = null;
                return true;
            }
            if (action == 5) {
                if (commonHolderInfo.getHolderType() <= 1024 && (!FolderUtils.isStaticFolder(uuid) || this.mNotesModel.getCheckedFoldersCount() <= 0)) {
                    ViewCompat.getInstance().performHapticFeedback(view, 110);
                    onFolderDragEventEnter(true, view.findViewById(C8003R.id.sub_folder_container), null);
                }
                DragCardView dragCardView = this.mDragCardView;
                if (dragCardView != null) {
                    if (dragCardView.isScrollBlockedOnce() || !uuid.equals(this.mDragCardView.getUuid())) {
                        this.mRecyclerView.smoothScrollToPosition(this.mRecyclerView.getDragAndDropScrollPosition(commonHolderInfo.getHolderType(), this.mDocumentMap.indexOfDisplayData(commonHolderInfo.getUuid()), commonHolderInfo.getHolderType() <= 2048 ? this.mStateInfo.getNotesSpan() : 1), view, dragEvent);
                        return true;
                    }
                    this.mDragCardView.setScrollBlockedOnce(true);
                    return true;
                }
            } else if (action == 6 && commonHolderInfo.getHolderType() <= 1024) {
                onFolderDragEventEnter(false, view.findViewById(C8003R.id.sub_folder_container), null);
                return true;
            }
        } else if (dragEvent.getAction() == 5 && (iIndexOfDefaultDisplayData = this.mDocumentMap.indexOfDefaultDisplayData(12) - 1) >= 0) {
            this.mRecyclerView.smoothScrollToPosition(iIndexOfDefaultDisplayData);
            if (!this.mStateInfo.isExpandedFolderBar()) {
                this.mPresenter.toggleFolderExpandCollapseState();
                return true;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPopupMenuWithDragAction$1(PopupMenu popupMenu) {
        if (this.mPreviewImageView != null) {
            removeFakeDragAndDropShadow();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveFakeDragAndDropShadow() {
        View view = this.mPreviewImageView;
        if (view == null) {
            return;
        }
        float width = view.getWidth();
        float height = this.mPreviewImageView.getHeight();
        FragmentActivity activity = this.mViewParams.getAbsFragment().getActivity();
        if (activity == null || activity.isFinishing()) {
            MainLogger.m7255e("DragAndDropHelper", "activity is null or finishing");
            return;
        }
        activity.getWindow().getDecorView().getLocationOnScreen(new int[2]);
        this.mPreviewImageView.setTranslationX((this.mRecyclerView.getRawX() - r3[0]) - (width / 2.0f));
        this.mPreviewImageView.setTranslationY((this.mRecyclerView.getRawY() - r3[1]) - (height / 2.0f));
    }

    private void onFolderDragEventEnter(boolean z, View view, Runnable runnable) {
        View viewFindViewById = view.findViewById(C8003R.id.sub_folder_container);
        View viewFindViewById2 = view.findViewById(C8003R.id.sub_folder_icon);
        View viewFindViewById3 = view.findViewById(C8003R.id.sub_folder_shadow);
        View viewFindViewById4 = view.findViewById(C8003R.id.title);
        View viewFindViewById5 = view.findViewById(C8003R.id.sub_folder_paper);
        if (viewFindViewById == null || viewFindViewById2 == null || viewFindViewById3 == null || viewFindViewById5 == null || viewFindViewById4 == null) {
            return;
        }
        PathInterpolator pathInterpolator = new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f);
        float f = z ? 1.0f : 1.05f;
        float f4 = z ? 1.05f : 1.0f;
        float f5 = z ? 0.0f : -45.0f;
        float f6 = z ? -45.0f : 0.0f;
        if (z || runnable == null) {
            runnable = null;
        }
        animateScale(viewFindViewById, f, f4, 450, pathInterpolator);
        float f7 = f5;
        float f8 = f6;
        animate3DRotation(viewFindViewById2, f7, f8, pathInterpolator, runnable, viewFindViewById5);
        animate3DRotation(viewFindViewById3, f7, f8, pathInterpolator, null, viewFindViewById5);
        animate3DRotation(viewFindViewById4, f7, f8, pathInterpolator, null, viewFindViewById5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFakeDragAndDropShadow() {
        this.mViewParams.getNotesView().setDrawerIconDimDragStatus(false, null);
        this.mPresenter.showProgressCircle(0);
        NumberedBadgeShadowBuilder numberedBadgeShadowBuilder = this.mNumberedBadgeShadowBuilder;
        if (numberedBadgeShadowBuilder != null) {
            numberedBadgeShadowBuilder.releaseShadow();
        }
        this.mPreviewImageView = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetHolderPressedState() {
        CopyOnWriteArraySet<String> copyOnWriteArraySet;
        CommonHolder commonHolder;
        View rootCardView;
        synchronized (this.mResetPressedStateUuids) {
            copyOnWriteArraySet = new CopyOnWriteArraySet(this.mResetPressedStateUuids);
        }
        for (String str : copyOnWriteArraySet) {
            if (!TextUtils.isEmpty(str) && (commonHolder = (CommonHolder) this.mRecyclerView.findViewHolderForAdapterPosition(this.mDocumentMap.indexOfDisplayData(str))) != null && (rootCardView = getRootCardView(str, commonHolder)) != null) {
                rootCardView.setPressed(false);
            }
        }
    }

    private void showPopupMenuWithDragAction(View view) {
        final PopupWindow popupWindowCreatePopupMenu = createPopupMenu(view);
        if (popupWindowCreatePopupMenu == null) {
            return;
        }
        this.mPopupMenu.setOnDismissListener(new C8497c(this));
        popupWindowCreatePopupMenu.setTouchInterceptor(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DragAndDropHelper.3
            @Override // android.view.View.OnTouchListener
            @SuppressLint({WarningType.NewApi, "ClickableViewAccessibility"})
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0 && DragAndDropHelper.this.mPreviewImageView != null && DragAndDropHelper.this.mPreviewImageView.getParent() != null) {
                    int[] iArr = new int[2];
                    DragAndDropHelper.this.mPreviewImageView.getLocationOnScreen(iArr);
                    int shadowSize = DragAndDropHelper.this.getShadowSize();
                    int i = iArr[0];
                    int i2 = iArr[1];
                    Rect rect = new Rect(i, i2, i + shadowSize, shadowSize + i2);
                    View contentView = popupWindowCreatePopupMenu.getContentView();
                    int[] iArr2 = new int[2];
                    contentView.getLocationOnScreen(iArr2);
                    int i4 = iArr2[0];
                    Rect rect2 = new Rect(i4, iArr2[1], contentView.getWidth() + i4, contentView.getHeight() + iArr2[1]);
                    boolean zContains = rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
                    boolean zContains2 = rect2.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
                    if (!zContains && !zContains2) {
                        DragAndDropHelper.this.removeFakeDragAndDropShadow();
                        DragAndDropHelper.this.mPopupMenu.dismiss();
                        return false;
                    }
                    if (DragAndDropHelper.this.mDragCardView != null && !zContains2) {
                        String str = DragAndDropHelper.this.mDragCardView.uuid;
                        DragAndDropHelper.this.mDragCardView = new DragCardView(view2, str);
                        CommonHolder commonHolder = (CommonHolder) DragAndDropHelper.this.mRecyclerView.findViewHolderForAdapterPosition(DragAndDropHelper.this.mDocumentMap.indexOfDisplayData(str));
                        if (commonHolder != null) {
                            DragAndDropHelper dragAndDropHelper = DragAndDropHelper.this;
                            dragAndDropHelper.mNumberedBadgeShadowBuilder = dragAndDropHelper.getNumberedBadgeShadowBuilder(str, commonHolder);
                        }
                        DragAndDropHelper.this.removeFakeDragAndDropShadow();
                        DragAndDropHelper.this.startDragAndDrop();
                        return false;
                    }
                    if (!zContains) {
                        DragAndDropHelper.this.removeFakeDragAndDropShadow();
                    }
                }
                return false;
            }
        });
    }

    private void startNewDragAndDrop(CommonHolder commonHolder) {
        this.mPresenter.stopLongPressMultiSelection();
        this.mRecyclerView.removeOnLongPressMultiSelectionListener();
        this.mPreviewImageView = this.mNumberedBadgeShadowBuilder.onCreateShadow();
        if (commonHolder.getMHolderType() > 1024) {
            lambda$getNumberedBadgeShadowBuilder$2(this.mDragCardView.uuid, (NotesHolder) commonHolder, (ImageView) this.mPreviewImageView.findViewById(C8003R.id.imageView));
        } else {
            this.mPreviewImageView.findViewById(C8003R.id.imageView).setVisibility(8);
        }
        addFakeDragAndDropShadow();
        moveFakeDragAndDropShadow();
        this.mViewParams.getNotesRecyclerView().setOnDragAndDropListener(new OnDragAndDropListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DragAndDropHelper.2
            @Override // com.samsung.android.support.senl.p148nt.app.common.penrecyclerview.OnDragAndDropListener
            public void onMoveImage(float f, float f4) {
                if (Math.abs(f * f4) < 360.0f) {
                    DragAndDropHelper.this.moveFakeDragAndDropShadow();
                    return;
                }
                if (DragAndDropHelper.this.mPopupMenu != null) {
                    DragAndDropHelper.this.mPopupMenu.dismiss();
                }
                DragAndDropHelper.this.removeFakeDragAndDropShadow();
                DragAndDropHelper.this.startDragAndDrop();
            }

            @Override // com.samsung.android.support.senl.p148nt.app.common.penrecyclerview.OnDragAndDropListener
            public void onReleaseListener() {
                DragAndDropHelper.this.stopDragAndDrop();
                DragAndDropHelper.this.mViewParams.getNotesView().getMode().showBottomNavigation(true);
            }
        });
        showPopupMenuWithDragAction(this.mDragCardView.rootCardView);
    }

    private static void startSpringTranslateY(View view, float f, float f4) {
        new SpringAnimation(view, DynamicAnimation.TRANSLATION_Y).setSpring(new SpringForce(0.0f).setDampingRatio(f).setStiffness(f4)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopDragAndDrop() {
        MainLogger.m7254d("DragAndDropHelper", "stopDragAndDrop");
        if (this.mPopupMenu == null) {
            removeFakeDragAndDropShadow();
        }
        this.mRecyclerView.removeOnDragAndDropListener();
        this.mPresenter.resumeLongPressMultiSelection();
        if (this.mPresenter.isLongPressMoved()) {
            return;
        }
        this.mPresenter.endLongPressed();
    }

    public Animation create3DRotationAnimation(final float f, final float f4, final float f5, final float f6) {
        return new Animation() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DragAndDropHelper.5
            @Override // android.view.animation.Animation
            public void applyTransformation(float f7, Transformation transformation) {
                float f8 = f;
                float fM29z = AbstractC0000a.m29z(f4, f8, f7, f8);
                Camera camera2 = new Camera();
                Matrix matrix = transformation.getMatrix();
                camera2.save();
                camera2.translate(0.0f, 0.0f, 0.0f);
                camera2.rotateX(fM29z);
                camera2.getMatrix(matrix);
                camera2.restore();
                matrix.preTranslate(-f5, -f6);
                matrix.postTranslate(f5, f6);
            }
        };
    }

    public void dragFolderSelectState(int i, boolean z, int i2) {
        CommonHolder commonHolder;
        SubFolderHolderInfo subFolderHolderInfo;
        if (i < 0 || FeatureUtils.isPickEditMode(this.mViewParams.getModeIndex()) || (commonHolder = (CommonHolder) this.mRecyclerView.findViewHolderForAdapterPosition(i / i2)) == null || commonHolder.getMHolderType() == 2048 || commonHolder.getMHolderType() == 4096 || commonHolder.getMHolderType() >= 16384 || (subFolderHolderInfo = ((SubFolderHolder) commonHolder).getSubFolderHolderInfo(i % i2)) == null || FolderUtils.isStaticFolder(subFolderHolderInfo.getUuid()) || subFolderHolderInfo.getCheckBox().getTag() == null) {
            return;
        }
        if (!subFolderHolderInfo.getIsEnable()) {
            subFolderHolderInfo.getCheckBox().setChecked(false);
            this.mPresenter.updateContentDescription(subFolderHolderInfo, false);
            return;
        }
        if (this.mRecyclerView.isLongPressed() && z) {
            postStartDragAndDrop(subFolderHolderInfo.getUuid(), 1000L);
        }
        if (this.mNotesModel.isUuidInCheckedFolder(subFolderHolderInfo.getUuid()) && z) {
            return;
        }
        this.mNotesModel.toggleCheckedFolder(z, subFolderHolderInfo.getUuid());
        subFolderHolderInfo.getCheckBox().setChecked(this.mNotesModel.isUuidInCheckedFolder(subFolderHolderInfo.getUuid()));
        this.mPresenter.updateContentDescription(subFolderHolderInfo, true);
    }

    public void dragNoteSelectState(int i, boolean z) {
        NotesHolder notesHolder;
        NotesHolderInfo notesHolderInfo;
        CommonHolder commonHolder = (CommonHolder) this.mRecyclerView.findViewHolderForAdapterPosition(i);
        if (commonHolder == null || commonHolder.getMHolderType() != 2048 || (notesHolderInfo = (notesHolder = (NotesHolder) commonHolder).getNotesHolderInfo()) == null || FolderUtils.isStaticFolder(notesHolderInfo.getUuid()) || notesHolderInfo.getCheckBox().getTag() == null) {
            return;
        }
        if (!notesHolderInfo.getIsEnable()) {
            notesHolderInfo.getCheckBox().setChecked(false);
            this.mPresenter.updateContentDescription(notesHolder.getNotesHolderInfo(), false);
            return;
        }
        if (this.mRecyclerView.isLongPressed() && z) {
            postStartDragAndDrop(notesHolderInfo.getUuid(), 1000L);
        }
        MainListDocumentData noteData = this.mDocumentMap.getNoteData(notesHolderInfo.getUuid());
        if (noteData == null) {
            return;
        }
        this.mNotesModel.toggleCheckedNote(z, noteData);
        notesHolderInfo.getCheckBox().setChecked(this.mNotesModel.isUuidInCheckedNotes(noteData.getUuid()));
        this.mPresenter.updateContentDescription(notesHolder.getNotesHolderInfo(), true);
    }

    public void onDestroy() {
        AudioManagerCompat.SoundManager soundManager = this.mSoundManager;
        if (soundManager != null) {
            soundManager.release();
        }
    }

    public void postStartDragAndDrop(String str, long j) {
        addUuidToResetPressedStateUuids(str);
        this.mNotesModel.setPostDragAndDropUuid(str);
        this.mHandler.removeCallbacks(this.mDragAndDropRunnable);
        this.mHandler.postDelayed(this.mDragAndDropRunnable, j);
    }

    public void releaseDragAndDrop() {
        MainLogger.m7254d("DragAndDropHelper", "releaseDragAndDrop");
        DragCardView dragCardView = this.mDragCardView;
        if (dragCardView != null && this.mDocumentMap.indexOfDisplayData(dragCardView.getUuid()) == -1) {
            ViewCompat.getInstance().cancelDragAndDrop(this.mDragCardView.getRootCardView());
            this.mDragCardView = null;
        }
    }

    public void setDragListener(final CommonHolderInfo commonHolderInfo) {
        View rootCardView = commonHolderInfo.getRootCardView();
        if (rootCardView == null) {
            return;
        }
        rootCardView.setOnDragListener(new View.OnDragListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.d
            @Override // android.view.View.OnDragListener
            public final boolean onDrag(View view, DragEvent dragEvent) {
                return this.f6200a.lambda$setDragListener$5(commonHolderInfo, view, dragEvent);
            }
        });
    }

    public void setInteractionMedia(View view) {
        AudioManagerCompat.SoundManager soundManager = this.mSoundManager;
        if (soundManager != null) {
            soundManager.play();
        }
        ViewCompat.getInstance().performHapticFeedback(view, 108);
    }

    public void startDragAndDrop(String str) {
        CommonHolder commonHolder = (CommonHolder) this.mRecyclerView.findViewHolderForAdapterPosition(this.mDocumentMap.indexOfDisplayData(str));
        if (commonHolder == null) {
            return;
        }
        MainLogger.m7254d("DragAndDropHelper", "startDragAndDrop");
        View rootCardView = getRootCardView(str, commonHolder);
        if (rootCardView == null) {
            return;
        }
        PopupMenuImpl popupMenuImpl = this.mPopupMenu;
        if (popupMenuImpl == null || !popupMenuImpl.seslIsShowing()) {
            this.mDragCardView = new DragCardView(rootCardView, str);
            this.mNumberedBadgeShadowBuilder = getNumberedBadgeShadowBuilder(str, commonHolder);
            if (DeviceInfo.isVSTModel()) {
                startDragAndDrop();
            } else {
                startNewDragAndDrop(commonHolder);
            }
        }
    }

    public void updateDragShadow(int i) {
        if (this.mNumberedBadgeShadowBuilder == null) {
            return;
        }
        AbstractC6670b.m4736A(i, "updateDragShadow# count : ", "DragAndDropHelper");
        this.mNumberedBadgeShadowBuilder.setShadowBadge(i);
        this.mRecyclerView.updateDragShadow(this.mNumberedBadgeShadowBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startDragAndDrop() {
        ClipData clipDataNewPlainText;
        int i;
        if (this.mDragCardView == null) {
            cancelDragAndDrop();
            return;
        }
        CheckNotesCountInfo checkNotesCountInfo = this.mNotesModel.getCheckNotesCountInfo();
        if (isEdgePanelDnD(checkNotesCountInfo)) {
            clipDataNewPlainText = NoteListToDrag.getClipData(this.mViewParams.getContext(), this.mDragCardView.uuid);
            i = 257;
        } else {
            clipDataNewPlainText = ClipData.newPlainText("drag", "drag...");
            i = 0;
        }
        ClipData clipData = clipDataNewPlainText;
        resetHolderPressedState();
        this.mRecyclerView.removeOnDragAndDropListener();
        this.mPresenter.resumeLongPressMultiSelection();
        boolean zStartDragAndDrop = ViewCompat.getInstance().startDragAndDrop(this.mDragCardView.rootCardView, clipData, this.mNumberedBadgeShadowBuilder, null, i);
        AbstractC8014b.m7210l("startDragAndDrop result : ", "DragAndDropHelper", zStartDragAndDrop);
        if (!zStartDragAndDrop) {
            cancelDragAndDrop();
            return;
        }
        this.mViewParams.getNotesView().getMode().showBottomNavigation(false);
        setInteractionMedia(this.mDragCardView.rootCardView);
        if (checkNotesCountInfo.getOldNotesCount() == 0) {
            this.mViewParams.getNotesView().setDrawerIconDimDragStatus(true, this.mNotesModel.getCheckedFoldersUUID());
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(FolderConstants.MyFolders.UUID);
        this.mViewParams.getNotesView().setDrawerIconDimDragStatus(true, arrayList);
    }
}
