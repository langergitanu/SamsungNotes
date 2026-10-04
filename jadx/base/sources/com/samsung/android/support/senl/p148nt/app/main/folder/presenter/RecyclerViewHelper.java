package com.samsung.android.support.senl.p148nt.app.main.folder.presenter;

import android.content.ClipData;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.oneui.floatingactioncontainer.FloatingBottomLayout;
import com.google.android.material.oneui.floatingactioncontainer.FloatingToolbarLayout;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p145cm.base.framework.media.AudioManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.penrecyclerview.PenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.common.util.FolderUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.FolderHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.view.FolderPenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.main.common.view.NumberedBadgeShadowBuilder;
import com.samsung.android.support.senl.p148nt.app.main.folder.adapter.FolderHolder;
import com.samsung.android.support.senl.p148nt.app.main.folder.model.FolderModel;
import com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.OnPenMultiSelectionListener;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistantTTS;
import com.samsung.android.support.senl.p148nt.base.winset.util.AnchorViewUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class RecyclerViewHelper {
    private static final String TAG = "RecyclerViewHelper";
    private FloatingBottomLayout mFloatingBottomLayout;
    private final FolderModel mFolderModel;
    private LongPressMultiSelectionListener mLongPressMultiSelectionListener;
    private final IPresenter mPresenter;
    private final FolderPenRecyclerView mRecyclerView;
    private AudioManagerCompat.SoundManager mSoundManager;
    private final OnPenMultiSelectionListener mPenMultiSelectionListener = new OnPenMultiSelectionListener() { // from class: com.samsung.android.support.senl.nt.app.main.folder.presenter.RecyclerViewHelper.1
        @Override // com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.OnPenMultiSelectionListener
        public void onSelectedItemPosition(ArrayList<Integer> arrayList, int i, int i2, int i4) {
            int size = arrayList == null ? 0 : arrayList.size();
            if (size <= 0) {
                return;
            }
            int i5 = size - 1;
            FolderHolder folderHolder = (FolderHolder) RecyclerViewHelper.this.mRecyclerView.findViewHolderForLayoutPosition(arrayList.get(i5).intValue());
            if (folderHolder != null && folderHolder.getFolderHolderInfo() != null && FolderUtils.isNotSelectableFolder(folderHolder.getFolderHolderInfo().getViewType())) {
                if (size <= 2) {
                    return;
                } else {
                    arrayList.remove(i5);
                }
            }
            RecyclerViewHelper.this.mPresenter.setMode(3);
            if (RecyclerViewHelper.this.mFolderModel.getFolderDisplayDataList().size() == 1) {
                return;
            }
            MainLogger.m7258i(RecyclerViewHelper.TAG, "OnPenMultiSelectionListener# onSelectedItemPosition list size : " + arrayList.size());
            for (Integer num : arrayList) {
                NotesFolder folderDisplayData = RecyclerViewHelper.this.mFolderModel.getFolderDisplayData(num.intValue());
                if (folderDisplayData != null) {
                    String uuid = folderDisplayData.getUuid();
                    if (!FolderConstants.MyFolders.UUID.equals(uuid) && !"addFolder:///".equals(uuid) && !FolderUtils.isStaticFolder(uuid)) {
                        boolean z = !RecyclerViewHelper.this.mPresenter.isCheckedItem(uuid);
                        RecyclerViewHelper.this.mPresenter.toggleCheckBox(uuid, z);
                        FolderHolder folderHolder2 = (FolderHolder) RecyclerViewHelper.this.mRecyclerView.findViewHolderForAdapterPosition(num.intValue());
                        if (folderHolder2 != null) {
                            FolderHolderInfo folderHolderInfo = folderHolder2.getFolderHolderInfo();
                            folderHolderInfo.toggleCheckBox(z);
                            RecyclerViewHelper.this.updateContentDescription(folderHolderInfo);
                        }
                    }
                }
            }
        }
    };
    private final RecyclerView.SeslOnGoToTopClickListener mGoToTopClickListener = new RecyclerView.SeslOnGoToTopClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.folder.presenter.RecyclerViewHelper.2
        @Override // androidx.recyclerview.widget.RecyclerView.SeslOnGoToTopClickListener
        public boolean onGoToTopClick(RecyclerView recyclerView) {
            if (!SettingsCompat.getInstance().isAccessibilityAnimationDisabled(recyclerView.getContext())) {
                return false;
            }
            RecyclerViewHelper.this.mRecyclerView.scrollToPosition(0);
            return true;
        }
    };
    private final RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.samsung.android.support.senl.nt.app.main.folder.presenter.RecyclerViewHelper.3
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IPresenter {
        int getModeIndex();

        void initializeDragAndDrop(boolean z);

        boolean isCheckedItem(String str);

        boolean isDimItem(String str);

        void setExpandedStatus(boolean z, String str, int i);

        boolean setMode(int i);

        void showBottomNavigation();

        void showMoveFolderConfirmDialog(String str, int i);

        void toggleCheckBox(String str, boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class LongPressMultiSelectionListener extends PenRecyclerView.LongPressMultiSelectionListener {
        protected boolean mIsTouchMoved;

        public /* synthetic */ LongPressMultiSelectionListener(RecyclerViewHelper recyclerViewHelper, int i) {
            this();
        }

        public boolean isTouchMoved() {
            return this.mIsTouchMoved;
        }

        @Override // com.samsung.android.support.senl.nt.app.common.penrecyclerview.PenRecyclerView.LongPressMultiSelectionListener, androidx.recyclerview.widget.RecyclerView.SeslLongPressMultiSelectionListener
        public void onItemSelected(RecyclerView recyclerView, View view, int i, long j) {
            if (RecyclerViewHelper.this.mPresenter.getModeIndex() != 3) {
                return;
            }
            super.onItemSelected(recyclerView, view, i, j);
            RecyclerViewHelper.this.mRecyclerView.setLongPressed(true);
            MainLogger.m7258i(RecyclerViewHelper.TAG, "SeslLongPressMultiSelectionListener# onItemSelected position : " + i);
            FolderHolder folderHolder = (FolderHolder) RecyclerViewHelper.this.mRecyclerView.findViewHolderForAdapterPosition(i);
            if (folderHolder == null) {
                MainLogger.m7258i(RecyclerViewHelper.TAG, "holder is null!!");
                return;
            }
            RecyclerViewHelper.this.mFolderModel.setSelectedUuid(this.selectedItemPositionList.contains(Integer.valueOf(i)) ? folderHolder.getFolderHolderInfo().getUuid() : null);
            RecyclerViewHelper.this.toggleCheckBox(folderHolder.getFolderHolderInfo(), this.selectedItemPositionList.contains(Integer.valueOf(i)));
            this.mIsTouchMoved = true;
        }

        @Override // com.samsung.android.support.senl.nt.app.common.penrecyclerview.PenRecyclerView.LongPressMultiSelectionListener, androidx.recyclerview.widget.RecyclerView.SeslLongPressMultiSelectionListener
        public void onLongPressMultiSelectionEnded(int i, int i2) {
            super.onLongPressMultiSelectionEnded(i, i2);
            RecyclerViewHelper.this.mRecyclerView.setLongPressed(false);
            RecyclerViewHelper.this.mPresenter.showBottomNavigation();
            this.mIsTouchMoved = false;
        }

        @Override // com.samsung.android.support.senl.nt.app.common.penrecyclerview.PenRecyclerView.LongPressMultiSelectionListener, androidx.recyclerview.widget.RecyclerView.SeslLongPressMultiSelectionListener
        public void onLongPressMultiSelectionStarted(int i, int i2) {
            super.onLongPressMultiSelectionStarted(i, i2);
            this.mIsTouchMoved = false;
        }

        private LongPressMultiSelectionListener() {
            this.mIsTouchMoved = false;
        }
    }

    public RecyclerViewHelper(FragmentActivity fragmentActivity, FolderPenRecyclerView folderPenRecyclerView, FolderModel folderModel, IPresenter iPresenter) throws Exception {
        this.mRecyclerView = folderPenRecyclerView;
        this.mFolderModel = folderModel;
        this.mPresenter = iPresenter;
        this.mSoundManager = AudioManagerCompat.getInstance().createHapticDetachSound(folderPenRecyclerView.getContext().getApplicationContext());
        if (fragmentActivity == null) {
            return;
        }
        FloatingBottomLayout floatingBottomLayout = (FloatingBottomLayout) fragmentActivity.findViewById(C8003R.id.floating_bottom_layout);
        this.mFloatingBottomLayout = floatingBottomLayout;
        if (floatingBottomLayout != null) {
            floatingBottomLayout.setRecyclerView(folderPenRecyclerView);
        }
        FloatingToolbarLayout floatingToolbarLayout = (FloatingToolbarLayout) fragmentActivity.findViewById(C8003R.id.sesl_floating_toolbar_layout);
        if (floatingToolbarLayout != null) {
            floatingToolbarLayout.setRecyclerView(folderPenRecyclerView);
        }
    }

    private String getColorName(int i) {
        int[] intArray = this.mRecyclerView.getResources().getIntArray(C8003R.array.folder_mark_new_color);
        String[] stringArray = this.mRecyclerView.getResources().getStringArray(C8003R.array.folder_mark_new_color_name);
        for (int i2 = 0; i2 < intArray.length; i2++) {
            if (i == intArray[i2]) {
                return stringArray[i2];
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Point getTouchPositionFromDragEvent(View view, DragEvent dragEvent) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return new Point(Math.round(dragEvent.getX()) + iArr[0], Math.round(dragEvent.getY()) + iArr[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDragEnabledFolder(String str) {
        return (FolderUtils.isStaticFolder(str) || "addFolder:///".equals(str) || this.mPresenter.isDimItem(str)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFolderDrag(boolean z) {
        AbstractC6670b.m4739D("onFolderDrag: isFinished : ", TAG, z);
        this.mPresenter.initializeDragAndDrop(z);
        int childCount = this.mRecyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mRecyclerView.getChildAt(i);
            if (childAt != null) {
                FolderHolder folderHolder = (FolderHolder) this.mRecyclerView.getChildViewHolder(childAt);
                folderHolder.setFolderItemDim(this.mPresenter.isDimItem(folderHolder.getFolderHolderInfo().getUuid()));
            }
        }
    }

    private void setToggleCheckBoxData(String str, boolean z) {
        if (TextUtils.isEmpty(str) || FolderConstants.MyFolders.UUID.equals(str) || "addFolder:///".equals(str)) {
            return;
        }
        NotesFolder folderData = this.mFolderModel.getFolderData(str);
        if (z && folderData != null && folderData.isExpanded()) {
            Iterator<NotesFolder> it = folderData.getChildren().iterator();
            while (it.hasNext()) {
                setToggleCheckBoxData(it.next().getUuid(), z);
            }
        }
        this.mPresenter.toggleCheckBox(str, z);
    }

    private void setToggleCheckBoxLayout(FolderHolderInfo folderHolderInfo, boolean z) {
        if (folderHolderInfo == null || FolderConstants.MyFolders.UUID.equals(folderHolderInfo.getUuid()) || "addFolder:///".equals(folderHolderInfo.getUuid())) {
            return;
        }
        VoiceAssistantTTS.getInstance().sendTalkBackMessage(z ? this.mRecyclerView.getResources().getString(C8003R.string.selectall_voice_ass_checked) : this.mRecyclerView.getResources().getString(C8003R.string.selectall_voice_ass_not_checked));
        String uuid = folderHolderInfo.getUuid();
        folderHolderInfo.toggleCheckBox(z);
        updateContentDescription(folderHolderInfo);
        NotesFolder folderData = this.mFolderModel.getFolderData(uuid);
        if (z && folderData != null && folderData.isExpanded()) {
            Iterator<NotesFolder> it = folderData.getChildren().iterator();
            while (it.hasNext()) {
                FolderHolder folderHolder = getFolderHolder(it.next().getUuid());
                if (folderHolder != null) {
                    toggleCheckBox(folderHolder.getFolderHolderInfo(), true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startDragAndDrop(FolderHolderInfo folderHolderInfo, int i, int i2) {
        String uuid = folderHolderInfo.getUuid();
        if ("addFolder:///".equals(uuid) || FolderConstants.MyFolders.UUID.equals(uuid) || FolderUtils.isStaticFolder(uuid)) {
            return;
        }
        AbstractC8014b.m7209k("onItemTouched: reorder : ", uuid, TAG);
        if (this.mFolderModel.getFolderDisplayData(i).isExpanded()) {
            this.mPresenter.setExpandedStatus(true, uuid, i);
        }
        View folderItemContainer = folderHolderInfo.getFolderItemContainer();
        folderItemContainer.setPressed(false);
        ViewCompat.getInstance().startDragAndDrop(folderItemContainer, ClipData.newPlainText("drag", "drag..."), new NumberedBadgeShadowBuilder(this.mRecyclerView.getContext(), i2, new NumberedBadgeShadowBuilder.ShadowBuilderContract() { // from class: com.samsung.android.support.senl.nt.app.main.folder.presenter.RecyclerViewHelper.5
            @Override // com.samsung.android.support.senl.nt.app.main.common.view.NumberedBadgeShadowBuilder.ShadowBuilderContract
            public void setImageView(ImageView imageView) {
                imageView.setVisibility(8);
            }
        }), null, 0);
        setInteractionMedia(folderHolderInfo.getFolderItemContainer());
    }

    public FolderHolder getFolderHolder(String str) {
        if (this.mRecyclerView != null && !TextUtils.isEmpty(str)) {
            int childCount = this.mRecyclerView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                FolderPenRecyclerView folderPenRecyclerView = this.mRecyclerView;
                FolderHolder folderHolder = (FolderHolder) folderPenRecyclerView.getChildViewHolder(folderPenRecyclerView.getChildAt(i));
                if (folderHolder != null && str.equals(folderHolder.getFolderHolderInfo().getUuid())) {
                    return folderHolder;
                }
            }
        }
        return null;
    }

    public boolean isDragAndDropEnable() {
        return this.mRecyclerView.isLongPressed() && !this.mLongPressMultiSelectionListener.isTouchMoved();
    }

    public void postStartDragAndDrop(final FolderHolderInfo folderHolderInfo, final int i, final int i2, long j) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.folder.presenter.RecyclerViewHelper.6
            @Override // java.lang.Runnable
            public void run() {
                if (RecyclerViewHelper.this.isDragAndDropEnable()) {
                    RecyclerViewHelper.this.startDragAndDrop(folderHolderInfo, i, i2);
                } else if (RecyclerViewHelper.this.mPresenter.getModeIndex() == 3) {
                    RecyclerViewHelper.this.mPresenter.showBottomNavigation();
                }
            }
        }, j);
    }

    public void registerListener() {
        if (this.mPresenter.getModeIndex() != 1) {
            this.mRecyclerView.setOnPenMultiSelectionListener(this.mPenMultiSelectionListener);
            LongPressMultiSelectionListener longPressMultiSelectionListener = new LongPressMultiSelectionListener(this, 0);
            this.mLongPressMultiSelectionListener = longPressMultiSelectionListener;
            this.mRecyclerView.seslSetLongPressMultiSelectionListener(longPressMultiSelectionListener);
        }
        this.mRecyclerView.addOnScrollListener(this.mOnScrollListener);
        this.mRecyclerView.seslSetOnGoToTopClickListener(this.mGoToTopClickListener);
    }

    public void release() {
        AudioManagerCompat.SoundManager soundManager = this.mSoundManager;
        if (soundManager != null) {
            soundManager.release();
            this.mSoundManager = null;
        }
    }

    public void setDragListener(final FolderHolderInfo folderHolderInfo) {
        View folderItemLayout = folderHolderInfo.getFolderItemLayout();
        if (folderItemLayout == null) {
            return;
        }
        final int viewType = folderHolderInfo.getViewType();
        final int i = this.mRecyclerView.getResources().getDisplayMetrics().heightPixels;
        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.mRecyclerView.getLayoutManager();
        folderItemLayout.setTag(Integer.valueOf(viewType));
        folderItemLayout.setOnDragListener(new View.OnDragListener() { // from class: com.samsung.android.support.senl.nt.app.main.folder.presenter.RecyclerViewHelper.4
            @Override // android.view.View.OnDragListener
            public boolean onDrag(View view, DragEvent dragEvent) {
                if (viewType != 4) {
                    String uuid = folderHolderInfo.getUuid();
                    List<NotesFolder> folderDisplayDataList = RecyclerViewHelper.this.mFolderModel.getFolderDisplayDataList();
                    int action = dragEvent.getAction();
                    if (action == 1) {
                        RecyclerViewHelper.this.onFolderDrag(false);
                        MainLogger.m7258i(RecyclerViewHelper.TAG, "drag_drop_started");
                        return true;
                    }
                    if (action == 3) {
                        if (!RecyclerViewHelper.this.isDragEnabledFolder(uuid)) {
                            return false;
                        }
                        folderHolderInfo.setBackground(folderDisplayDataList.indexOf(RecyclerViewHelper.this.mFolderModel.getFolderData(uuid)), folderDisplayDataList.size());
                        folderHolderInfo.setSelectedFolder(false);
                        if (view instanceof ViewGroup) {
                            RecyclerViewHelper.this.mPresenter.showMoveFolderConfirmDialog(uuid, AnchorViewUtils.getAnchorView(RecyclerViewHelper.this.mRecyclerView, (ViewGroup) view, dragEvent.getX(), dragEvent.getY()).getId());
                        }
                        MainLogger.m7258i(RecyclerViewHelper.TAG, "drag_drop");
                        return true;
                    }
                    if (action == 4) {
                        RecyclerViewHelper.this.onFolderDrag(true);
                        MainLogger.m7258i(RecyclerViewHelper.TAG, "drag_drop_ended");
                        return true;
                    }
                    if (action == 5) {
                        if (RecyclerViewHelper.this.isDragEnabledFolder(uuid)) {
                            folderHolderInfo.setBackground(folderDisplayDataList.indexOf(RecyclerViewHelper.this.mFolderModel.getFolderData(uuid)), folderDisplayDataList.size());
                            folderHolderInfo.setSelectedFolder(true);
                            NotesFolder folderData = RecyclerViewHelper.this.mFolderModel.getFolderData(uuid);
                            if (folderData != null && !folderData.isExpanded() && viewType != 1009) {
                                RecyclerViewHelper.this.mPresenter.setExpandedStatus(folderData.isExpanded(), uuid, folderDisplayDataList.indexOf(folderData));
                            }
                        }
                        Point touchPositionFromDragEvent = RecyclerViewHelper.this.getTouchPositionFromDragEvent(view, dragEvent);
                        int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                        int iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                        double d = touchPositionFromDragEvent.y;
                        double d2 = i;
                        if (d < 0.2d * d2) {
                            RecyclerViewHelper.this.mRecyclerView.smoothScrollToPositionForDrawer(Math.max(iFindFirstVisibleItemPosition - 1, 0));
                        } else if (d > d2 * 0.8d) {
                            RecyclerViewHelper.this.mRecyclerView.smoothScrollToPositionForDrawer(Math.min(iFindLastVisibleItemPosition + 1, RecyclerViewHelper.this.mRecyclerView.getAdapter().getItemCount()));
                        }
                        MainLogger.m7258i(RecyclerViewHelper.TAG, "drag_entered");
                        return true;
                    }
                    if (action == 6) {
                        if (RecyclerViewHelper.this.isDragEnabledFolder(uuid)) {
                            folderHolderInfo.setBackground(folderDisplayDataList.indexOf(RecyclerViewHelper.this.mFolderModel.getFolderData(uuid)), folderDisplayDataList.size());
                            folderHolderInfo.setSelectedFolder(false);
                        }
                        MainLogger.m7258i(RecyclerViewHelper.TAG, "drag_exited");
                        return true;
                    }
                }
                return true;
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

    public void toggleCheckBox(FolderHolderInfo folderHolderInfo, boolean z) {
        if (folderHolderInfo == null || FolderConstants.MyFolders.UUID.equals(folderHolderInfo.getUuid()) || "addFolder:///".equals(folderHolderInfo.getUuid())) {
            return;
        }
        setToggleCheckBoxData(folderHolderInfo.getUuid(), z);
        setToggleCheckBoxLayout(folderHolderInfo, z);
    }

    public void updateContentDescription(FolderHolderInfo folderHolderInfo) {
        if (folderHolderInfo == null) {
            return;
        }
        Resources resources = this.mRecyclerView.getResources();
        StringBuilder sb = new StringBuilder();
        String string = resources.getString(C8003R.string.string_comma);
        String title = folderHolderInfo.getTitle();
        if (FolderConstants.MyFolders.UUID.equals(folderHolderInfo.getUuid())) {
            title = resources.getString(C8003R.string.settings_my_folders);
        } else if ("addFolder:///".equals(folderHolderInfo.getUuid())) {
            title = resources.getString(C8003R.string.add_category);
        }
        int count = folderHolderInfo.getCount();
        if (folderHolderInfo.getViewType() == 4) {
            if (TextUtils.isEmpty(title)) {
                title = "";
            }
            sb.append(title);
            sb.append(string);
            sb.append(' ');
            sb.append(resources.getString(C8003R.string.button_string_button));
        } else if (folderHolderInfo.isCheckboxVisible()) {
            sb.append(folderHolderInfo.getCheckBox().isChecked() ? resources.getString(C8003R.string.selectall_voice_ass_checked) : resources.getString(C8003R.string.selectall_voice_ass_not_checked));
            sb.append(string);
            sb.append(' ');
            sb.append(getColorName(folderHolderInfo.getColor()));
            sb.append(TextUtils.isEmpty(title) ? "" : AbstractC0541b.m757C(string, " ", title));
            sb.append(string);
            sb.append(' ');
            sb.append(resources.getQuantityString(C8003R.plurals.plurals_count_items, count, Integer.valueOf(count)));
            sb.append(string);
            sb.append(' ');
            sb.append(resources.getString(C8003R.string.selectall_voice_ass_tick_box));
        } else {
            sb.append(resources.getString(C8003R.string.folder_string));
            sb.append(string);
            sb.append(' ');
            sb.append(getColorName(folderHolderInfo.getColor()));
            sb.append(TextUtils.isEmpty(title) ? "" : AbstractC0541b.m757C(string, " ", title));
            sb.append(string);
            sb.append(' ');
            sb.append(resources.getQuantityString(C8003R.plurals.plurals_count_items, count, Integer.valueOf(count)));
        }
        folderHolderInfo.getFolderItemContainer().setContentDescription(sb.toString());
    }
}
