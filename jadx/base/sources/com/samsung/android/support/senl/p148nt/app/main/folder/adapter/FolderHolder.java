package com.samsung.android.support.senl.p148nt.app.main.folder.adapter;

import android.animation.LayoutTransition;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.res.ResourcesCompat;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.FolderUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.FolderCommonHolder;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.FolderHolderInfo;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistAsButton;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistantTTS;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class FolderHolder extends FolderCommonHolder implements View.OnLongClickListener, View.OnClickListener, View.OnKeyListener, View.OnTouchListener {
    private final AdapterContract mAdapterContract;
    private final ImageView mAddFolder;
    private final int mAddFolderIconMarginStart;
    private final int mCheckBoxMarginStart;
    private final int mCheckBoxWidth;
    private final View mDivider;
    private final View mFolderItem;
    private final View mFolderItemContainer;
    private final View mFolderItemLayout;
    private final int mFolderListItemDepthMargin;
    private final int mFolderListItemMarginStart;
    private FolderHolderInfo mHolderInfo;
    private final View mIconLayout;
    private final View mReorder;

    public FolderHolder(@NonNull View view, AdapterContract adapterContract, int i, int i2, int i4, int i5, int i6) {
        super(view);
        View viewFindViewById = view.findViewById(C8003R.id.folder_item_holder_layout);
        this.mFolderItemContainer = viewFindViewById;
        this.mFolderItem = view.findViewById(C8003R.id.folder_item_holder);
        this.mFolderItemLayout = view.findViewById(C8003R.id.folder_item_layout);
        View viewFindViewById2 = view.findViewById(C8003R.id.icon_layout);
        this.mIconLayout = viewFindViewById2;
        View viewFindViewById3 = view.findViewById(C8003R.id.reorder);
        this.mReorder = viewFindViewById3;
        this.mAddFolder = (ImageView) view.findViewById(C8003R.id.add_folder);
        this.mDivider = view.findViewById(C8003R.id.divider);
        viewFindViewById.setOnClickListener(this);
        viewFindViewById.setOnLongClickListener(this);
        viewFindViewById.setOnTouchListener(this);
        viewFindViewById2.setOnClickListener(this);
        viewFindViewById2.setOnTouchListener(this);
        viewFindViewById3.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.app.main.folder.adapter.FolderHolder.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                AdapterContract adapterContract2 = FolderHolder.this.mAdapterContract;
                FolderHolder folderHolder = FolderHolder.this;
                adapterContract2.onTouch(folderHolder, folderHolder.getLayoutPosition());
                return false;
            }
        });
        this.mAdapterContract = adapterContract;
        this.mFolderListItemMarginStart = i;
        this.mFolderListItemDepthMargin = i2;
        this.mCheckBoxWidth = i4;
        this.mCheckBoxMarginStart = i5;
        this.mAddFolderIconMarginStart = i6;
    }

    private void decorateFolderToSyncSwitch(NotesFolder notesFolder) {
        if (this.mAdapterContract.getModeIndex() != 4 || notesFolder == null) {
            return;
        }
        initMS();
        SwitchCompat folderSyncSwitch = this.mHolderInfo.getFolderSyncSwitch();
        folderSyncSwitch.setChecked(notesFolder.isSyncWithMS() != 0);
        folderSyncSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.samsung.android.support.senl.nt.app.main.folder.adapter.FolderHolder.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                FolderHolder.this.mAdapterContract.toggleFolderSyncSwitch(FolderHolder.this.getFolderHolderInfo());
            }
        });
    }

    private void decorateMsSyncIcon(NotesFolder notesFolder) {
        this.itemView.findViewById(C8003R.id.ms_icon).setVisibility((this.mAdapterContract.getModeIndex() == 4 || !NotesUtils.hasMsSyncIcon(notesFolder)) ? 8 : 0);
    }

    private void initMS() {
        this.mHolderInfo.getFolderSyncSwitch().setOnCheckedChangeListener(null);
    }

    private boolean needColorFilter(int i) {
        if (i == C8003R.drawable.ic_folder_home_close && i == C8003R.drawable.ic_folder_home_close_solid) {
            return false;
        }
        return (i == C8003R.drawable.ic_folder_home && i == C8003R.drawable.ic_folder_home_solid) ? false : true;
    }

    private void setArrowIconLayout(String str, boolean z, boolean z2, int i) {
        int i2;
        ImageView imageView = (ImageView) this.mFolderItemLayout.findViewById(C8003R.id.arrow_icon);
        this.mHolderInfo.setArrow(imageView);
        float f = 0.0f;
        if (z) {
            i2 = C8003R.drawable.ic_drawer_open;
            if (!z2) {
                f = LocaleUtils.isRTLMode() ? 90.0f : -90.0f;
            }
        } else {
            i2 = -1;
        }
        String str2 = FolderConstants.MyFolders.UUID;
        if (str2.equals(str) || i2 == -1) {
            imageView.setVisibility(4);
        } else {
            imageView.setVisibility(0);
            Drawable drawable = ResourcesCompat.getDrawable(this.itemView.getResources(), i2, null);
            imageView.setRotation(f);
            imageView.setImageDrawable(drawable);
        }
        if (str2.equals(str)) {
            setIconLayout(z ? FolderUtils.getFolderHomeDrawable(z2, this.mHolderInfo.isSolid()) : C8003R.drawable.ic_folder, this.mFolderItemLayout.getResources().getColor(C8003R.color.folder_list_item_icon_default_bg_color, null));
        } else if (FolderConstants.AllNotes.UUID.equals(str)) {
            setIconLayout(C8003R.drawable.ic_all, this.mFolderItemLayout.getResources().getColor(C8003R.color.folder_list_item_icon_default_bg_color, null));
        } else {
            setIconLayout(z ? FolderUtils.getUserFolderDrawable(z2, this.mHolderInfo.isSolid()) : C8003R.drawable.ic_folder, FolderUtils.getAdjustedFolderDefaultColor(i, this.mFolderItemLayout.getContext()));
        }
        if (z) {
            View view = this.mIconLayout;
            view.setContentDescription(view.getResources().getString(C8003R.string.ps_button_tts, this.mIconLayout.getResources().getString(z2 ? C8003R.string.folder_collapse_tts : C8003R.string.folder_expand_tts)));
        }
        this.mIconLayout.setImportantForAccessibility(z ? 1 : 2);
    }

    private void setFolderItemMarginStart(boolean z) {
        int i;
        int i2;
        int depth = this.mHolderInfo.getDepth();
        if (depth > 5) {
            depth = 5;
        }
        int i4 = this.mFolderListItemMarginStart;
        if (z) {
            if (this.mHolderInfo.getViewType() == 4) {
                i2 = this.mAddFolderIconMarginStart;
            } else {
                i = (this.mFolderListItemDepthMargin * depth) + this.mCheckBoxMarginStart + this.mCheckBoxWidth;
                i2 = i + i4;
            }
        } else if (this.mHolderInfo.getViewType() == 4) {
            i2 = this.mAddFolderIconMarginStart;
        } else {
            i = this.mFolderListItemDepthMargin * depth;
            i2 = i + i4;
        }
        setFolderItemLayoutTransition();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mFolderItemLayout.getLayoutParams();
        layoutParams.setMarginStart(i2);
        this.mFolderItemLayout.setLayoutParams(layoutParams);
    }

    private void setHolderInfo(NotesFolder notesFolder) {
        FolderHolderInfo folderHolderInfo = this.mHolderInfo;
        if (folderHolderInfo == null) {
            this.mHolderInfo = new FolderHolderInfo().setTitle(getTitle(notesFolder)).setUuid(notesFolder.getUuid()).setTitleView((TextView) this.itemView.findViewById(C8003R.id.title)).setFolderItemContainer(this.mFolderItemContainer).setFolderItemLayout(this.mFolderItemLayout).setFolderItem(this.mFolderItem).setColor(notesFolder.getDisplayNameColor()).setViewType(notesFolder.getViewType()).setDepth(notesFolder.getDepth()).setHasChild(notesFolder.hasChild()).setExpanded(notesFolder.isExpanded());
        } else {
            folderHolderInfo.setUuid(notesFolder.getUuid()).setViewType(notesFolder.getViewType()).setDepth(notesFolder.getDepth()).setHasChild(notesFolder.hasChild()).setExpanded(notesFolder.isExpanded());
        }
    }

    private void setIconLayout(int i, int i2) {
        this.mFolderItemLayout.setVisibility(0);
        ImageView imageView = (ImageView) this.mFolderItemLayout.findViewById(C8003R.id.icon);
        imageView.setImageResource(i);
        if (needColorFilter(i)) {
            imageView.setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_IN));
        } else {
            imageView.clearColorFilter();
        }
        this.mHolderInfo.setIconLayout(this.mIconLayout);
    }

    private void setItemMarginStartWithCheckbox(boolean z, String str) {
        boolean z2 = FolderConstants.MyFolders.UUID.equals(str) || "addFolder:///".equals(str);
        setFolderItemMarginStart(z);
        this.mHolderInfo.getCheckBox().setVisibility((!z || z2) ? 4 : 0);
    }

    public void applySelectedViewHolder(boolean z) {
        this.mHolderInfo.setHighlightSelectedFolder(z);
    }

    public void decorate(NotesFolder notesFolder) {
        notesFolder.setExpanded(notesFolder.isExpanded());
        setHolderInfo(notesFolder);
        int layoutMode = this.mAdapterContract.getLayoutMode();
        int viewType = notesFolder.getViewType();
        if (viewType == 4) {
            this.mAddFolder.setVisibility(0);
            this.mIconLayout.setVisibility(8);
            this.mDivider.setVisibility(8);
            View view = this.mFolderItemContainer;
            StringBuilder sb = new StringBuilder();
            AbstractC8014b.m7202d(this.itemView.getResources(), C8003R.string.add_category, sb, SQLKeyword.COMMA);
            sb.append(this.itemView.getResources().getString(C8003R.string.button_string_button));
            view.setContentDescription(sb.toString());
        } else if (viewType != 1002) {
            this.mAddFolder.setVisibility(8);
            if ((layoutMode & 8) > 0) {
                this.mDivider.setVisibility(4);
            } else {
                this.mDivider.setVisibility(0);
            }
            decorateIcon(notesFolder);
        } else {
            this.mAddFolder.setVisibility(8);
            this.mDivider.setVisibility(8);
            decorateIcon(notesFolder);
            View view2 = this.mFolderItemContainer;
            StringBuilder sb2 = new StringBuilder();
            AbstractC8014b.m7202d(this.itemView.getResources(), C8003R.string.all_notes, sb2, SQLKeyword.COMMA);
            sb2.append(this.itemView.getResources().getString(C8003R.string.button_string_button));
            view2.setContentDescription(sb2.toString());
        }
        decorateReorder(notesFolder);
        decorateTitle(notesFolder);
        decorateMsSyncIcon(notesFolder);
        decorateCount(notesFolder);
        decorateFolderToSyncSwitch(notesFolder);
        String uuid = notesFolder.getUuid();
        setItemMarginStartWithCheckbox(this.mAdapterContract.getModeIndex() == 3, uuid);
        setFolderItemDim(this.mAdapterContract.isDimItem(uuid));
        this.mAdapterContract.setDragListener(this.mHolderInfo);
    }

    public void decorateCount(NotesFolder notesFolder) {
        TextView textView = (TextView) this.itemView.findViewById(C8003R.id.count);
        if (this.mAdapterContract.getModeIndex() == 4) {
            textView.setVisibility(8);
            return;
        }
        String str = FolderConstants.AllNotes.UUID;
        int i = str.equals(notesFolder.getUuid()) ? SharedPreferencesCompat.getInstance(FolderConstants.PREF_FOLDER_INFO).getInt(str, 0) : notesFolder.getDocumentCount() + notesFolder.getChildren().size();
        if (FolderConstants.MyFolders.UUID.equals(notesFolder.getUuid())) {
            Iterator<NotesFolder> it = notesFolder.getChildren().iterator();
            while (it.hasNext()) {
                if (FolderUtils.isIgnoreFolder(it.next())) {
                    i--;
                }
            }
        }
        this.mHolderInfo.setCount(i);
        String strConvertToArabicNumber = ContentUtils.convertToArabicNumber(i);
        try {
            if (Integer.parseInt(strConvertToArabicNumber) != 0 && notesFolder.getViewType() != 4) {
                textView.setVisibility(0);
                textView.setText(strConvertToArabicNumber);
                return;
            }
            textView.setVisibility(8);
        } catch (NumberFormatException unused) {
            textView.setVisibility(8);
        }
    }

    public void decorateIcon(NotesFolder notesFolder) {
        boolean zHasChildFolder = FolderUtils.hasChildFolder(notesFolder);
        this.mHolderInfo.setHasChild(zHasChildFolder);
        setArrowIconLayout(notesFolder.getUuid(), zHasChildFolder, notesFolder.isExpanded(), notesFolder.getDisplayNameColor());
    }

    public void decorateReorder(NotesFolder notesFolder) {
        if (this.mAdapterContract.getModeIndex() == 4 || (this.mAdapterContract.getLayoutMode() & 16) == 0) {
            this.mReorder.setVisibility(8);
            return;
        }
        if ((this.mAdapterContract.getLayoutMode() & 16) > 0) {
            if (FolderConstants.MyFolders.UUID.equals(notesFolder.getUuid())) {
                this.mReorder.setVisibility(4);
                return;
            }
            if ("addFolder:///".equals(notesFolder.getUuid())) {
                this.mReorder.setVisibility(8);
                return;
            }
            this.mReorder.setVisibility(0);
            if (!VoiceAssistantTTS.isVoiceAssistantEnabled(this.mReorder.getContext())) {
                ViewCompat viewCompat = ViewCompat.getInstance();
                View view = this.mReorder;
                viewCompat.setTooltipText(view, view.getResources().getText(C8003R.string.reorder_folder));
                return;
            }
            this.mReorder.setContentDescription(notesFolder.getDisplayName() + SQLKeyword.COMMA + ((Object) this.mReorder.getResources().getText(C8003R.string.reorder_folder_tts)));
            this.mReorder.setAccessibilityDelegate(new VoiceAssistAsButton());
            ViewCompat.getInstance().setTooltipText(this.mReorder, "");
        }
    }

    public void decorateTitle(NotesFolder notesFolder) {
        ((TextView) this.itemView.findViewById(C8003R.id.title)).setText(getTitle(notesFolder));
    }

    public FolderHolderInfo getFolderHolderInfo() {
        return this.mHolderInfo;
    }

    public String getTitle(NotesFolder notesFolder) {
        String uuid = notesFolder.getUuid();
        return FolderConstants.MyFolders.UUID.equals(uuid) ? this.mFolderItemLayout.getResources().getString(C8003R.string.settings_my_folders) : FolderConstants.ScreenOffMemo.UUID.equals(uuid) ? this.mFolderItemLayout.getResources().getString(C8003R.string.string_screen_off_memo) : FolderConstants.MathNotes.UUID.equals(uuid) ? this.mFolderItemLayout.getResources().getString(C8003R.string.string_math_notes) : "addFolder:///".equals(uuid) ? this.itemView.getResources().getString(C8003R.string.add_category) : FolderConstants.AllNotes.UUID.equals(uuid) ? this.itemView.getResources().getString(C8003R.string.all_notes) : notesFolder.getDisplayName();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mAdapterContract == null || this.mHolderInfo == null) {
            return;
        }
        this.mAdapterContract.onFolderSelected(this.mHolderInfo, getLayoutPosition(), (!view.equals(this.mIconLayout) && view != this.itemView.findViewById(C8003R.id.arrow_icon) && view != this.itemView.findViewById(C8003R.id.icon)) || this.mHolderInfo.getViewType() > 3);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (this.mHolderInfo.getViewType() > 3) {
            return true;
        }
        this.mHolderInfo.setTouchedView(view);
        return this.mAdapterContract.onItemLongPressed(this.mHolderInfo);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, @NonNull MotionEvent motionEvent) {
        this.mHolderInfo.setTouchPos(motionEvent.getX(), motionEvent.getY());
        this.mHolderInfo.setTouchedView(view);
        if (motionEvent.getActionMasked() != 1) {
            return false;
        }
        this.mAdapterContract.onItemPressReleased();
        return false;
    }

    public void setCheckBoxStatus(int i) {
        String uuid = this.mHolderInfo.getUuid();
        boolean z = i != this.mHolderInfo.getCheckBox().getVisibility();
        if (i == 0) {
            boolean zIsCheckedItem = this.mAdapterContract.isCheckedItem(uuid);
            this.mFolderItemLayout.setSelected(zIsCheckedItem);
            this.mHolderInfo.getCheckBox().setChecked(zIsCheckedItem);
            this.mHolderInfo.getCheckBox().jumpDrawablesToCurrentState();
        } else {
            this.mFolderItemLayout.setSelected(false);
        }
        if (z) {
            setItemMarginStartWithCheckbox(i == 0, uuid);
        }
        this.mAdapterContract.updateContentDescription(this.mHolderInfo);
    }

    public void setFolderItemDim(boolean z) {
        float f = z ? 0.4f : 1.0f;
        this.mFolderItemContainer.setEnabled(!z);
        if (this.mHolderInfo.isFolderSyncSwitch()) {
            this.mHolderInfo.getFolderSyncSwitch().setEnabled(!z);
        }
        this.mAddFolder.setAlpha(f);
        this.itemView.findViewById(C8003R.id.arrow_icon).setAlpha(f);
        this.itemView.findViewById(C8003R.id.title).setAlpha(f);
        this.itemView.findViewById(C8003R.id.icon).setAlpha(f);
    }

    public void setFolderItemLayoutTransition() {
        LayoutTransition layoutTransition = ((ViewGroup) this.mFolderItemLayout).getLayoutTransition();
        if (this.mAdapterContract.isAnimateItem(this.mHolderInfo.getUuid())) {
            layoutTransition.enableTransitionType(4);
        } else {
            if (this.mAdapterContract.isAnimateItem(this.mHolderInfo.getUuid())) {
                return;
            }
            layoutTransition.disableTransitionType(4);
        }
    }
}
