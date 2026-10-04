package com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder;
import com.samsung.android.support.senl.p148nt.app.main.common.data.HighlightText;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holderinfo.NotesHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.presenter.ThumbnailHandler;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.utils.ThumbnailColorUtils;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.utils.ThumbnailPathUtils;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.view.OnHolderTouchListener;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.view.ThumbnailContract;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public abstract class NotesHolder extends CommonHolder implements OnHolderTouchListener, ThumbnailContract {
    protected final String NULL;
    private NotesFolder mFolderData;
    protected final NotesHolderInfo mNotesHolderInfo;
    protected ThumbnailHandler mThumbnailHandler;
    private int mToolType;

    public NotesHolder(View view, int i) {
        super(view, i);
        this.mToolType = 1;
        this.NULL = "null";
        setHolderType(2048);
        this.mNotesHolderInfo = (NotesHolderInfo) new NotesHolderInfo().setIsDarkMode(ContextUtils.isNightMode(view.getContext())).setRootCardView(view.findViewById(C8003R.id.root_cardview)).setHolderType(getMHolderType()).setEnable(true);
        createThumbnailHandler();
        initInteractionListener();
    }

    private void initInteractionListener() {
        View viewFindViewById = this.itemView.findViewById(C8003R.id.root_cardview);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.adapter.holder.NotesHolder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NotesHolder.this.onClick();
            }
        });
        viewFindViewById.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.adapter.holder.NotesHolder.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return NotesHolder.this.onLongClick();
            }
        });
        viewFindViewById.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.adapter.holder.NotesHolder.3
            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return NotesHolder.this.onTouch(motionEvent);
            }
        });
        viewFindViewById.setOnContextClickListener(new View.OnContextClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.adapter.holder.NotesHolder.4
            @Override // android.view.View.OnContextClickListener
            public boolean onContextClick(View view) {
                return NotesHolder.this.onContextClick();
            }
        });
    }

    public void clearThumbnailHolder() {
        this.mThumbnailHandler.clearThumbnailHolder();
    }

    public void createTextBitmap(ImageView imageView, MainListDocumentData mainListDocumentData) {
        this.mThumbnailHandler.createTextBitmap(imageView, mainListDocumentData);
    }

    public abstract void createThumbnailHandler();

    public void decorate(MainListDocumentData mainListDocumentData, HighlightText highlightText) {
        init();
        if (mainListDocumentData == null) {
            return;
        }
        boolean zHasBackgroundColorNotes = ContentUtils.hasBackgroundColorNotes(mainListDocumentData.getBackgroundColor(), mainListDocumentData.isSDoc());
        this.mNotesHolderInfo.setIsVoice((mainListDocumentData.getVrUuid() == null || mainListDocumentData.getVrUuid().isEmpty()) ? false : true).setIsFavorite(mainListDocumentData.getIsFavorite() == 1).setHoverThumbnailFilePath(null).setHasTextOnly(ThumbnailPathUtils.hasTextOnly(mainListDocumentData.getUuid(), this.mNotesHolderInfo.isDarkMode())).setLockType(mainListDocumentData.getIsLock()).setIsSdoc(mainListDocumentData.isSDoc()).setBackgroundColor(mainListDocumentData.getBackgroundColor()).setBackgroundColorInverted(mainListDocumentData.getBackgroundColorInverted()).setHasBackgroundColor(zHasBackgroundColorNotes).setIsSupportInvertedBGColor(ContentUtils.supportInvertedBGColor(zHasBackgroundColorNotes, mainListDocumentData.getBackgroundColorInverted())).setHasOnlyHandwritingSdoc(false).setUuid(mainListDocumentData.getUuid()).setDateText(ContentUtils.getDate(this.itemView.getContext(), NotesConstants.Sort.isModifiedType(NotesUtils.getSortType()) ? mainListDocumentData.getLastModifiedAt() : mainListDocumentData.getCreatedAt())).setLastModifiedAt(mainListDocumentData.getLastModifiedAt()).setEnable(true);
        this.mThumbnailHandler.checkTextContent(mainListDocumentData);
        this.mNotesHolderInfo.getRootCardView().setNextFocusDownId(-1);
    }

    public void decorateExtra(MainListDocumentData mainListDocumentData) {
        this.mThumbnailHandler.decorateExtra(mainListDocumentData);
    }

    public void decorateOldNoteThumbnail(MainListDocumentData mainListDocumentData, HighlightText highlightText) {
        this.mThumbnailHandler.decorateOldNoteThumbnail(mainListDocumentData, highlightText);
    }

    public abstract void decorateThumbnail(MainListDocumentData mainListDocumentData, HighlightText highlightText);

    public abstract void decorateTitle(MainListDocumentData mainListDocumentData, HighlightText highlightText);

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.view.ThumbnailContract
    public Context getContext() {
        return this.itemView.getContext();
    }

    public NotesFolder getFolderData() {
        return this.mFolderData;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.view.ThumbnailContract
    public NotesHolderInfo getNotesHolderInfo() {
        return this.mNotesHolderInfo;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.view.ThumbnailContract
    public Resources getResources() {
        return this.itemView.getResources();
    }

    public abstract String getTag();

    public int getToolType() {
        return this.mToolType;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder, com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.view.ThumbnailContract, com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.presenter.HolderListener
    public int getViewMode() {
        return super.getViewMode();
    }

    public void init() {
        this.mNotesHolderInfo.initInfoViews();
        this.mThumbnailHandler.initView();
    }

    public void initLockInteractionListener() {
        View lockIcon = this.mThumbnailHandler.getLockIcon();
        lockIcon.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.adapter.holder.NotesHolder.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NotesHolder.this.onClick();
            }
        });
        lockIcon.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.adapter.holder.NotesHolder.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return NotesHolder.this.onLongClick();
            }
        });
        lockIcon.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.adapter.holder.NotesHolder.7
            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return NotesHolder.this.onTouch(motionEvent);
            }
        });
        lockIcon.setOnContextClickListener(new View.OnContextClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.adapter.holder.NotesHolder.8
            @Override // android.view.View.OnContextClickListener
            public boolean onContextClick(View view) {
                return NotesHolder.this.onContextClick();
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder
    public void onBindViewHolder(int i) {
        this.mNotesHolderInfo.setPosition(i);
        getMAdapterContract().onBindViewHolder(this.mNotesHolderInfo);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.view.OnHolderTouchListener
    public void onClick() {
        getMAdapterContract().onNoteSelected(this.mNotesHolderInfo.getUuid(), this.mToolType, this.mThumbnailHandler.getTitle());
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.view.OnHolderTouchListener
    public boolean onContextClick() {
        NotesHolderInfo notesHolderInfo = this.mNotesHolderInfo;
        if (notesHolderInfo == null || !notesHolderInfo.getIsEnable()) {
            return false;
        }
        return getMAdapterContract().onContextClick(this.mNotesHolderInfo);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.view.OnHolderTouchListener
    public boolean onLongClick() {
        getMAdapterContract().onItemLongPressed(this.mNotesHolderInfo.getUuid());
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.view.OnHolderTouchListener
    public boolean onTouch(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1) {
            this.mNotesHolderInfo.setTouchPos(motionEvent.getX(), motionEvent.getY());
            this.mToolType = motionEvent.getToolType(motionEvent.getPointerCount() - 1);
            return false;
        }
        if (action != 0 || 3 != motionEvent.getToolType(motionEvent.getPointerCount() - 1)) {
            return false;
        }
        this.mNotesHolderInfo.setTouchPos(motionEvent.getX(), motionEvent.getY());
        this.mToolType = 3;
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder
    public void onViewAttachedToWindow(@NonNull CommonHolder commonHolder) {
        getMAdapterContract().onViewAttachedToWindow(this.mNotesHolderInfo);
    }

    public void setFolderData(NotesFolder notesFolder) {
        this.mFolderData = notesFolder;
    }

    public void setLockState(boolean z) {
        this.mThumbnailHandler.setLockState(z);
    }

    public void setSimpleViewBackgroundColor(ImageView imageView) {
        NotesHolderInfo notesHolderInfo = this.mNotesHolderInfo;
        ThumbnailColorUtils.setSimpleViewBackgroundColor(imageView, notesHolderInfo, NotesUtils.isLock(notesHolderInfo.getLockType()));
    }
}
