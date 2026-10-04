package com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.collection.AbstractC0622a;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.google.android.material.datepicker.ViewOnFocusChangeListenerC4697c;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.handwriting.RunnableC7599e;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.badge.BadgeHelper;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.DrawableUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.FolderUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.ResourcesUtils;
import com.samsung.android.support.senl.p148nt.app.common.widget.HoverPopupTextView;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder;
import com.samsung.android.support.senl.p148nt.app.main.common.data.HighlightText;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holderinfo.SubFolderHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.Common;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.StateInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.util.NotesHolderUtil;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.CategoryConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.vladsch.flexmark.util.sequence.builder.tree.SegmentTree;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p066P2.RunnableC0201c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 F2\u00020\u0001:\u0001FB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0001H\u0016J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0001H\u0016J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0005H\u0016J\u001c\u0010\u001f\u001a\u00020\u001a2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u0005H\u0002J2\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020(2\u0006\u0010%\u001a\u00020\u00052\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0002J2\u0010.\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u000eH\u0002J \u00101\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u0005H\u0002J\u0018\u00103\u001a\u0002042\u0006\u00102\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u0005H\u0002J\u0018\u00105\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u0005H\u0002J\u0006\u00106\u001a\u00020\u001aJ\u0018\u00106\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u000eH\u0002J\u0010\u00106\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u0005H\u0002J\u001a\u00107\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J\u0018\u00108\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010'\u001a\u00020(H\u0002J\u0006\u00109\u001a\u00020\u0005J\u0018\u0010:\u001a\u00020\u001a2\u0006\u0010;\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0005H\u0002J\b\u0010<\u001a\u00020\u001aH\u0002J\u0010\u0010=\u001a\u00020\u001a2\u0006\u0010>\u001a\u00020\u0005H\u0002J\u0010\u0010?\u001a\u0004\u0018\u00010\u000b2\u0006\u0010%\u001a\u00020\u0005J\u0012\u0010?\u001a\u0004\u0018\u00010\u000b2\b\u00100\u001a\u0004\u0018\u00010\u000eJ\u0018\u0010@\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0006\u0010A\u001a\u00020\u0005J \u0010B\u001a\u00020\u001a2\u0006\u0010C\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u0005H\u0002R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00050\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/adapter/holder/SubFolderHolder;", "Lcom/samsung/android/support/senl/nt/app/main/common/adapter/CommonHolder;", "itemView", "Landroid/view/View;", "viewMode", "", "maxSubFolderColumn", "<init>", "(Landroid/view/View;II)V", "mSubFolderHolderInfoList", "", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/adapter/holderinfo/SubFolderHolderInfo;", "mSubFolderHolderIndexMap", "", "", "mOnClickListener", "Landroid/view/View$OnClickListener;", "mOnLongClickListener", "Landroid/view/View$OnLongClickListener;", "mOnContextClickListener", "Landroid/view/View$OnContextClickListener;", "mOnTouchListener", "Landroid/view/View$OnTouchListener;", "mExpandSubFolderHolderAction", "Ljava/lang/Runnable;", "onViewAttachedToWindow", "", "commonHolder", "onViewDetachedFromWindow", "onBindViewHolder", "position", "decorate", "holderData", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/model/Common;", "stateInfo", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/model/StateInfo;", "initSubFolderView", "idx", "decorateSubFolderHolder", "folderData", "Lcom/samsung/android/support/senl/nt/data/database/core/document/folder/NotesFolder;", "highlightText", "Lcom/samsung/android/support/senl/nt/app/main/common/data/HighlightText;", "isShowWithAnimation", "", "isExpandableSubFolder", "updateTitleCountTextView", "count", "uuid", "updateFolderIcon", "folderColor", "getFolderIcon", "Landroid/graphics/drawable/Drawable;", "updatePaperView", "decorateSOMSubFolderNewBadge", "decorateFolderBackground", "decorateMsIcon", "getSubFolderCount", "showSubFolderHolderList", "scrollState", "initHolder", "initialize", "subFoldersSpan", "getSubFolderHolderInfo", "expandSubFolderHolder", "getItemHeightDirectly", "updateHolderHeight", "newHeight", "newTopMargin", "newBottomMargin", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSubFolderHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SubFolderHolder.kt\ncom/samsung/android/support/senl/nt/app/main/noteslist/adapter/holder/SubFolderHolder\n+ 2 BitmapDrawable.kt\nandroidx/core/graphics/drawable/BitmapDrawableKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,623:1\n27#2:624\n1#3:625\n1869#4,2:626\n*S KotlinDebug\n*F\n+ 1 SubFolderHolder.kt\ncom/samsung/android/support/senl/nt/app/main/noteslist/adapter/holder/SubFolderHolder\n*L\n291#1:624\n450#1:626,2\n*E\n"})
public final class SubFolderHolder extends CommonHolder {
    private static final boolean BG_BLUR_SUPPORT;
    private static final boolean FOREGROUND_SUPPORT;

    @NotNull
    private static final String TAG = "SubFolderHolder";

    @Nullable
    private Runnable mExpandSubFolderHolderAction;

    @NotNull
    private final View.OnClickListener mOnClickListener;

    @NotNull
    private final View.OnContextClickListener mOnContextClickListener;

    @NotNull
    private final View.OnLongClickListener mOnLongClickListener;

    @NotNull
    private final View.OnTouchListener mOnTouchListener;

    @NotNull
    private final Map<String, Integer> mSubFolderHolderIndexMap;

    @NotNull
    private final List<SubFolderHolderInfo> mSubFolderHolderInfoList;

    static {
        FOREGROUND_SUPPORT = Build.VERSION.SDK_INT > 35;
        BG_BLUR_SUPPORT = ResourceUtils.isSupportBackgroundBlur();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubFolderHolder(@NotNull View itemView, int i, int i2) {
        super(itemView, i);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.mSubFolderHolderInfoList = new ArrayList();
        this.mSubFolderHolderIndexMap = new LinkedHashMap();
        this.mOnClickListener = new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.adapter.holder.SubFolderHolder$mOnClickListener$1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                Object tag = view.getTag();
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Int");
                SubFolderHolderInfo subFolderHolderInfo = this.this$0.getSubFolderHolderInfo(((Integer) tag).intValue());
                if (subFolderHolderInfo == null) {
                    return;
                }
                String uuid = subFolderHolderInfo.getUuid();
                if (TextUtils.isEmpty(uuid)) {
                    return;
                }
                if (subFolderHolderInfo.isOldCategory()) {
                    AdapterContract mAdapterContract = this.this$0.getMAdapterContract();
                    if (mAdapterContract != null) {
                        mAdapterContract.onOldCategorySelected(uuid);
                        return;
                    }
                    return;
                }
                AdapterContract mAdapterContract2 = this.this$0.getMAdapterContract();
                if (mAdapterContract2 != null) {
                    mAdapterContract2.onSubFolderSelected(uuid);
                }
            }
        };
        this.mOnLongClickListener = new View.OnLongClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.adapter.holder.SubFolderHolder$mOnLongClickListener$1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                Object tag = view.getTag();
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Int");
                SubFolderHolderInfo subFolderHolderInfo = this.this$0.getSubFolderHolderInfo(((Integer) tag).intValue());
                if (subFolderHolderInfo == null) {
                    return false;
                }
                String uuid = subFolderHolderInfo.getUuid();
                if (TextUtils.isEmpty(uuid) || FolderUtils.isStaticFolder(uuid)) {
                    return false;
                }
                AdapterContract mAdapterContract = this.this$0.getMAdapterContract();
                if (mAdapterContract == null) {
                    return true;
                }
                mAdapterContract.onItemLongPressed(uuid);
                return true;
            }
        };
        this.mOnContextClickListener = new View.OnContextClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.adapter.holder.SubFolderHolder$mOnContextClickListener$1
            @Override // android.view.View.OnContextClickListener
            public boolean onContextClick(View v) {
                AdapterContract mAdapterContract;
                Intrinsics.checkNotNullParameter(v, "v");
                Object tag = v.getTag();
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Int");
                SubFolderHolderInfo subFolderHolderInfo = this.this$0.getSubFolderHolderInfo(((Integer) tag).intValue());
                if (subFolderHolderInfo == null || !subFolderHolderInfo.getIsEnable() || (mAdapterContract = this.this$0.getMAdapterContract()) == null) {
                    return false;
                }
                return mAdapterContract.onContextClick(subFolderHolderInfo);
            }
        };
        this.mOnTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.adapter.holder.SubFolderHolder$mOnTouchListener$1
            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View v, MotionEvent event) {
                Intrinsics.checkNotNullParameter(v, "v");
                Intrinsics.checkNotNullParameter(event, "event");
                Object tag = v.getTag();
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Int");
                SubFolderHolderInfo subFolderHolderInfo = this.this$0.getSubFolderHolderInfo(((Integer) tag).intValue());
                if (subFolderHolderInfo == null) {
                    return false;
                }
                subFolderHolderInfo.setTouchPos(event.getX(), event.getY());
                return false;
            }
        };
        setHolderType(FeatureUtils.getFolderSpanHolderType(i2));
        initHolder();
        AbstractC6670b.m4736A(getMHolderType(), "SubFolderHolder# create, HolderType : ", TAG);
    }

    private final void decorateFolderBackground(int idx, NotesFolder folderData) {
        SubFolderHolderInfo subFolderHolderInfo;
        View folderIcon;
        if (FOREGROUND_SUPPORT && (subFolderHolderInfo = getSubFolderHolderInfo(idx)) != null && (folderIcon = subFolderHolderInfo.getFolderIcon()) != null) {
            folderIcon.setForeground(AppCompatResources.getDrawable(folderIcon.getContext(), C8003R.drawable.sub_folder_list_item_fg_recoil));
        }
        SubFolderHolderInfo subFolderHolderInfo2 = getSubFolderHolderInfo(idx);
        View subFolderContainer = subFolderHolderInfo2 != null ? subFolderHolderInfo2.getSubFolderContainer() : null;
        if (folderData == null || subFolderContainer == null) {
            return;
        }
        int displayNameColor = folderData.getDisplayNameColor();
        Drawable background = subFolderContainer.getBackground();
        if (background != null) {
            if (BG_BLUR_SUPPORT) {
                displayNameColor = subFolderContainer.getContext().getColor(DrawableUtils.getNewFolderColor(subFolderContainer.getContext(), displayNameColor));
            } else if (DrawableUtils.getColorStyle(subFolderContainer.getContext(), displayNameColor) == C8003R.style.DefaultFolderColorGrey) {
                displayNameColor = subFolderContainer.getContext().getColor(C8003R.color.sub_folder_icon_default_bg_color);
            }
            background.setColorFilter(displayNameColor, PorterDuff.Mode.SRC);
        }
    }

    private final void decorateMsIcon(int idx, NotesFolder folderData) {
        View msIcon;
        SubFolderHolderInfo subFolderHolderInfo = getSubFolderHolderInfo(idx);
        if (subFolderHolderInfo == null || (msIcon = subFolderHolderInfo.getMsIcon()) == null) {
            return;
        }
        msIcon.setVisibility(NotesUtils.hasMsSyncIcon(folderData) ? 0 : 8);
    }

    private final void decorateSubFolderHolder(NotesFolder folderData, int idx, HighlightText highlightText, boolean isShowWithAnimation, boolean isExpandableSubFolder) {
        SubFolderHolderInfo subFolderHolderInfo = getSubFolderHolderInfo(idx);
        if (subFolderHolderInfo == null) {
            return;
        }
        String uuid = folderData.getUuid();
        Intrinsics.checkNotNullExpressionValue(uuid, "getUuid(...)");
        this.mSubFolderHolderIndexMap.put(uuid, Integer.valueOf(idx));
        subFolderHolderInfo.initInfoViews();
        subFolderHolderInfo.setColor(folderData.getDisplayNameColor());
        subFolderHolderInfo.setOldCategory(Intrinsics.areEqual(FolderConstants.OldNotes.UUID, folderData.getParentUuid()));
        subFolderHolderInfo.setExpandable(isExpandableSubFolder);
        subFolderHolderInfo.setUuid(uuid);
        subFolderHolderInfo.setDateText(ContentUtils.getDate(this.itemView.getContext(), NotesConstants.Sort.isModifiedType(NotesUtils.getSortType()) ? folderData.getLastModifiedAt() : folderData.getCreatedAt()));
        subFolderHolderInfo.setEnable(true);
        subFolderHolderInfo.setShowWithAnimation(isShowWithAnimation);
        int documentCount = folderData.getDocumentCount();
        int size = folderData.getChildren().size();
        int i = documentCount + size;
        MainLogger.m7254d(TAG, "decorateSubFolderHolder# noteCount : " + documentCount + ", folderCount : " + size);
        decorateSOMSubFolderNewBadge(idx, uuid);
        updateTitleCountTextView(idx, folderData, highlightText, i, uuid);
        updatePaperView(idx, i);
        updateFolderIcon(idx, folderData.getDisplayNameColor(), i);
    }

    private final void expandSubFolderHolder(Common holderData, StateInfo stateInfo) {
        if (holderData.isExpandableSubFolder && holderData.showWithExpandAnimation) {
            holderData.showWithExpandAnimation = false;
            final int itemHeightDirectly = getItemHeightDirectly();
            MainLogger.m7254d(TAG, "expandSubFolderHolder, scrollState: " + stateInfo.getScrollState() + ", targetHeight: " + itemHeightDirectly);
            final float dimension = this.itemView.getResources().getDimension(C8003R.dimen.sub_folder_layout_margin_vertical);
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.setDuration(400L);
            valueAnimatorOfFloat.setInterpolator(PathInterpolatorCompat.create(0.22f, 0.25f, 0.0f, 1.0f));
            valueAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.adapter.holder.SubFolderHolder.expandSubFolderHolder.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    SubFolderHolder subFolderHolder = SubFolderHolder.this;
                    float f = dimension;
                    subFolderHolder.updateHolderHeight(-2, (int) f, (int) f);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    SubFolderHolder.this.updateHolderHeight(0, 0, 0);
                }
            });
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.adapter.holder.a
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    SubFolderHolder.expandSubFolderHolder$lambda$17(this.f6173a, itemHeightDirectly, dimension, valueAnimator);
                }
            });
            valueAnimatorOfFloat.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void expandSubFolderHolder$lambda$17(SubFolderHolder subFolderHolder, int i, float f, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) AbstractC6670b.m4742c(valueAnimator, "valueAnimator", "null cannot be cast to non-null type kotlin.Float")).floatValue();
        int i2 = (int) (f * fFloatValue);
        subFolderHolder.updateHolderHeight((int) (i * fFloatValue), i2, i2);
    }

    private final Drawable getFolderIcon(int folderColor, int count) {
        AdapterContract adapterContract = getMAdapterContract();
        Drawable subFolderBitmap = adapterContract != null ? adapterContract.getSubFolderBitmap(count, folderColor) : null;
        if (subFolderBitmap != null) {
            return subFolderBitmap;
        }
        boolean zIsNightMode = ContextUtils.isNightMode(this.itemView.getContext());
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(this.itemView.getResources(), count < 1 ? zIsNightMode ? C8003R.drawable.sub_folder_icon_blur_dark_empty : C8003R.drawable.sub_folder_icon_blur_light_empty : count == 1 ? DrawableUtils.getFolderBlur(this.itemView.getContext(), folderColor, zIsNightMode) : DrawableUtils.getFolderBlur(this.itemView.getContext(), folderColor, zIsNightMode));
        Intrinsics.checkNotNullExpressionValue(bitmapDecodeResource, "decodeResource(...)");
        Resources resources = this.itemView.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, bitmapDecodeResource);
        bitmapDrawable.setAlpha(count < 1 ? 178 : 255);
        AdapterContract adapterContract2 = getMAdapterContract();
        if (adapterContract2 != null) {
            adapterContract2.addSubFolderBitmap(count, folderColor, bitmapDrawable);
        }
        return bitmapDrawable;
    }

    private final void initHolder() {
        for (int i = 0; i < 14; i++) {
            View viewFindViewById = this.itemView.findViewById(NotesHolderUtil.getSubFolderViewById(i));
            if (viewFindViewById != null) {
                viewFindViewById.setFocusable(true);
                SubFolderHolderInfo subFolderHolderInfo = new SubFolderHolderInfo(i, 0, false, false, null, null, null, null, null, null, null, null, 4080, null);
                viewFindViewById.setOnFocusChangeListener(new ViewOnFocusChangeListenerC4697c(subFolderHolderInfo, 2));
                subFolderHolderInfo.setRootCardView(viewFindViewById);
                subFolderHolderInfo.getRootCardView().setVisibility(4);
                subFolderHolderInfo.setSubFolderContainer(viewFindViewById.findViewById(C8003R.id.sub_folder_container));
                subFolderHolderInfo.setTitleTextView((HoverPopupTextView) viewFindViewById.findViewById(C8003R.id.title));
                HoverPopupTextView titleTextView = subFolderHolderInfo.getTitleTextView();
                if (titleTextView != null) {
                    CharUtils.applyTextSizeUntilSmallSize(titleTextView.getContext(), titleTextView, 11.0f);
                }
                subFolderHolderInfo.setCountTextView((TextView) viewFindViewById.findViewById(C8003R.id.count));
                TextView countTextView = subFolderHolderInfo.getCountTextView();
                if (countTextView != null) {
                    CharUtils.applyTextSizeUntilSmallSize(countTextView.getContext(), countTextView, 8.0f);
                }
                View viewFindViewById2 = viewFindViewById.findViewById(C8003R.id.sub_folder_icon);
                if (viewFindViewById2 != null) {
                    viewFindViewById2.setOnClickListener(this.mOnClickListener);
                    viewFindViewById2.setOnLongClickListener(this.mOnLongClickListener);
                    viewFindViewById2.setOnContextClickListener(this.mOnContextClickListener);
                    viewFindViewById2.setOnTouchListener(this.mOnTouchListener);
                } else {
                    viewFindViewById2 = null;
                }
                subFolderHolderInfo.setFolderIcon(viewFindViewById2);
                View folderIcon = subFolderHolderInfo.getFolderIcon();
                if (folderIcon != null) {
                    folderIcon.setTag(Integer.valueOf(i));
                }
                subFolderHolderInfo.setFolderPaper(viewFindViewById.findViewById(C8003R.id.sub_folder_paper));
                subFolderHolderInfo.setFolderShadow(viewFindViewById.findViewById(C8003R.id.sub_folder_shadow));
                subFolderHolderInfo.setNewBadge(viewFindViewById.findViewById(C8003R.id.folder_new_badge));
                subFolderHolderInfo.setMsIcon(viewFindViewById.findViewById(C8003R.id.ms_icon));
                this.mSubFolderHolderInfoList.add(subFolderHolderInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initHolder$lambda$13$lambda$12(SubFolderHolderInfo subFolderHolderInfo, View view, boolean z) {
        View folderIcon;
        if (!z || (folderIcon = subFolderHolderInfo.getFolderIcon()) == null) {
            return;
        }
        folderIcon.requestFocus();
    }

    private final void initSubFolderView(int idx) {
        View rootCardView;
        View newBadge;
        Drawable background;
        SubFolderHolderInfo subFolderHolderInfo = getSubFolderHolderInfo(idx);
        if (subFolderHolderInfo == null || (rootCardView = subFolderHolderInfo.getRootCardView()) == null) {
            return;
        }
        SubFolderHolderInfo subFolderHolderInfo2 = getSubFolderHolderInfo(idx);
        View subFolderContainer = subFolderHolderInfo2 != null ? subFolderHolderInfo2.getSubFolderContainer() : null;
        rootCardView.setVisibility(4);
        if (subFolderContainer != null && (background = subFolderContainer.getBackground()) != null) {
            background.setColorFilter(new PorterDuffColorFilter(rootCardView.getResources().getColor(C8003R.color.sub_folder_icon_default_bg_color, null), PorterDuff.Mode.SRC));
        }
        SubFolderHolderInfo subFolderHolderInfo3 = getSubFolderHolderInfo(idx);
        if (subFolderHolderInfo3 == null || (newBadge = subFolderHolderInfo3.getNewBadge()) == null) {
            return;
        }
        newBadge.setVisibility(8);
    }

    private final void initialize(int subFoldersSpan) {
        View rootCardView;
        View rootCardView2;
        this.itemView.setAlpha(1.0f);
        this.itemView.setVisibility(0);
        int dimension = (int) this.itemView.getResources().getDimension(C8003R.dimen.sub_folder_layout_margin_vertical);
        updateHolderHeight(-2, dimension, dimension);
        int iMax = Math.max(4, Math.min(subFoldersSpan, 14));
        for (int i = 0; i < iMax; i++) {
            SubFolderHolderInfo subFolderHolderInfo = getSubFolderHolderInfo(i);
            if (subFolderHolderInfo != null && (rootCardView2 = subFolderHolderInfo.getRootCardView()) != null) {
                rootCardView2.setVisibility(4);
            }
        }
        while (iMax < 14) {
            SubFolderHolderInfo subFolderHolderInfo2 = getSubFolderHolderInfo(iMax);
            if (subFolderHolderInfo2 != null && (rootCardView = subFolderHolderInfo2.getRootCardView()) != null) {
                rootCardView.setVisibility(8);
            }
            iMax++;
        }
    }

    private final void showSubFolderHolderList(int scrollState, int idx) {
        SubFolderHolderInfo subFolderHolderInfo;
        if (idx < 0 || this.mSubFolderHolderInfoList.size() <= idx || (subFolderHolderInfo = getSubFolderHolderInfo(idx)) == null || TextUtils.isEmpty(subFolderHolderInfo.getUuid())) {
            return;
        }
        if (subFolderHolderInfo.isShowWithAnimation() && scrollState == 0) {
            subFolderHolderInfo.setShowWithAnimation(false);
            subFolderHolderInfo.getRootCardView().postDelayed(new RunnableC7599e(subFolderHolderInfo, 24), ((long) (idx + 1)) * 50);
        } else {
            subFolderHolderInfo.setShowWithAnimation(false);
            subFolderHolderInfo.getRootCardView().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSubFolderHolderList$lambda$11(SubFolderHolderInfo subFolderHolderInfo) {
        View rootCardView = subFolderHolderInfo.getRootCardView();
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.22f, 0.25f, 0.0f, 1.0f);
        Intrinsics.checkNotNullExpressionValue(interpolatorCreate, "create(...)");
        rootCardView.setScaleX(0.0f);
        rootCardView.setScaleY(0.0f);
        rootCardView.setAlpha(0.0f);
        rootCardView.setVisibility(0);
        rootCardView.post(new RunnableC0201c(rootCardView, 25, CollectionsKt.listOfNotNull((Object[]) new View[]{subFolderHolderInfo.getFolderPaper(), subFolderHolderInfo.getFolderShadow(), subFolderHolderInfo.getFolderIcon(), subFolderHolderInfo.getTitleTextView(), subFolderHolderInfo.getCountTextView()}), interpolatorCreate));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSubFolderHolderList$lambda$11$lambda$10(View view, List list, long j, Interpolator interpolator, long j2) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_X, 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(j);
        objectAnimatorOfFloat.setInterpolator(interpolator);
        arrayList.add(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_Y, 0.0f, 1.0f);
        objectAnimatorOfFloat2.setDuration(j);
        objectAnimatorOfFloat2.setInterpolator(interpolator);
        arrayList.add(objectAnimatorOfFloat2);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f);
        objectAnimatorOfFloat3.setDuration(j2);
        objectAnimatorOfFloat3.setInterpolator(new LinearInterpolator());
        arrayList.add(objectAnimatorOfFloat3);
        Float fValueOf = Float.valueOf(view.getHeight());
        if (fValueOf.floatValue() <= 0.0f) {
            fValueOf = null;
        }
        float fFloatValue = fValueOf != null ? fValueOf.floatValue() : view.getMeasuredHeight();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            View view2 = (View) it.next();
            view2.setTranslationY(fFloatValue);
            ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, fFloatValue, 0.0f);
            objectAnimatorOfFloat4.setDuration(j);
            objectAnimatorOfFloat4.setInterpolator(interpolator);
            arrayList.add(objectAnimatorOfFloat4);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    private final void updateFolderIcon(int idx, int folderColor, int count) {
        SubFolderHolderInfo subFolderHolderInfo = getSubFolderHolderInfo(idx);
        View folderIcon = subFolderHolderInfo != null ? subFolderHolderInfo.getFolderIcon() : null;
        if (folderIcon != null) {
            folderIcon.setBackground(getFolderIcon(folderColor, count));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateHolderHeight(int newHeight, int newTopMargin, int newBottomMargin) {
        View view = this.itemView;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.height = newHeight;
        marginLayoutParams.topMargin = newTopMargin;
        marginLayoutParams.bottomMargin = newBottomMargin;
        view.setLayoutParams(marginLayoutParams);
    }

    private final void updatePaperView(int idx, int count) {
        SubFolderHolderInfo subFolderHolderInfo = getSubFolderHolderInfo(idx);
        View folderPaper = subFolderHolderInfo != null ? subFolderHolderInfo.getFolderPaper() : null;
        if (folderPaper == null) {
            return;
        }
        if (count < 1) {
            folderPaper.setVisibility(8);
        } else {
            folderPaper.setVisibility(0);
            folderPaper.setBackground(this.itemView.getResources().getDrawable(count == 1 ? C8003R.drawable.sub_folder_paper_single : C8003R.drawable.sub_folder_paper_multi, null));
        }
    }

    private final void updateTitleCountTextView(int idx, NotesFolder folderData, HighlightText highlightText, int count, String uuid) {
        Context context = this.itemView.getContext();
        SubFolderHolderInfo subFolderHolderInfo = getSubFolderHolderInfo(idx);
        HoverPopupTextView titleTextView = subFolderHolderInfo != null ? subFolderHolderInfo.getTitleTextView() : null;
        SubFolderHolderInfo subFolderHolderInfo2 = getSubFolderHolderInfo(idx);
        TextView countTextView = subFolderHolderInfo2 != null ? subFolderHolderInfo2.getCountTextView() : null;
        CharSequence prefixedFolderName = FolderUtils.getPrefixedFolderName(context, uuid);
        if (TextUtils.isEmpty(prefixedFolderName)) {
            prefixedFolderName = folderData.getDisplayName();
        }
        SpannableString highlightText2 = NotesHolderUtil.setHighlightText(titleTextView, new SpannableString(prefixedFolderName), highlightText == null ? new ArrayList<>() : highlightText.getHighlightText());
        String strConvertToArabicNumber = ContentUtils.convertToArabicNumber(count);
        if (count >= 1000) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            strConvertToArabicNumber = AbstractC11014a.m12323h(new Object[]{Float.valueOf(count / 1000.0f)}, 1, Locale.getDefault(), "%.1fk", "format(...)");
        }
        if (titleTextView != null) {
            if (highlightText2 != null) {
                prefixedFolderName = highlightText2;
            }
            titleTextView.setTitleOriginalTitle(prefixedFolderName, ResourcesUtils.getDefaultBackgroundColor(this.itemView.getResources()), false, true);
        }
        if (countTextView != null) {
            countTextView.setText(strConvertToArabicNumber);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void decorate(@Nullable Common holderData, @Nullable StateInfo stateInfo) {
        List<NotesFolder> list;
        int dimensionPixelOffset;
        if (stateInfo == null || holderData == null || (list = holderData.folders) == null) {
            return;
        }
        if (!getMIsBottomOfSameViewType() || getMAdapterContract() == null) {
            dimensionPixelOffset = 0;
        } else {
            AdapterContract adapterContract = getMAdapterContract();
            Intrinsics.checkNotNull(adapterContract);
            if (!adapterContract.hasHolderInfo(12)) {
                dimensionPixelOffset = this.itemView.getResources().getDimensionPixelOffset(C8003R.dimen.sub_folder_layout_margin_vertical_bottom);
            }
        }
        View view = this.itemView;
        view.setPadding(view.getPaddingLeft(), this.itemView.getPaddingTop(), this.itemView.getPaddingRight(), dimensionPixelOffset);
        int subFoldersSpan = stateInfo.getSubFoldersSpan();
        MainLogger.m7255e(TAG, AbstractC0622a.m1164j(getMHolderType(), subFoldersSpan, "decorate start : ", "(", ")"));
        initialize(subFoldersSpan);
        int iMin = Math.min(subFoldersSpan, Math.min(list.size(), holderData.showWithScaleAnimation.size()));
        for (int i = 0; i < iMin; i++) {
            NotesFolder notesFolder = list.get(i);
            if (notesFolder != null) {
                initSubFolderView(i);
                HighlightText highlightText = stateInfo.getHighlightText();
                Boolean bool = holderData.showWithScaleAnimation.get(i);
                Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
                decorateSubFolderHolder(notesFolder, i, highlightText, bool.booleanValue(), holderData.isExpandableSubFolder);
                decorateFolderBackground(i, notesFolder);
                decorateMsIcon(i, notesFolder);
                showSubFolderHolderList(stateInfo.getScrollState(), i);
                holderData.showWithScaleAnimation.set(i, Boolean.FALSE);
            }
        }
        expandSubFolderHolder(holderData, stateInfo);
        MainLogger.m7255e(TAG, "decorate end");
    }

    public final void decorateSOMSubFolderNewBadge() {
        SubFolderHolderInfo subFolderHolderInfo = getSubFolderHolderInfo(FolderConstants.ScreenOffMemo.UUID);
        if (subFolderHolderInfo == null) {
            return;
        }
        decorateSOMSubFolderNewBadge(subFolderHolderInfo.getIndex());
    }

    public final int getItemHeightDirectly() {
        if (this.itemView.isLaidOut() && this.itemView.getMeasuredHeight() > 0) {
            return this.itemView.getMeasuredHeight();
        }
        this.itemView.measure(View.MeasureSpec.makeMeasureSpec(this.itemView.getResources().getDisplayMetrics().widthPixels, 1073741824), View.MeasureSpec.makeMeasureSpec(SegmentTree.MAX_VALUE, Integer.MIN_VALUE));
        return this.itemView.getMeasuredHeight();
    }

    public final int getSubFolderCount() {
        Iterator<SubFolderHolderInfo> it = this.mSubFolderHolderInfoList.iterator();
        int i = 0;
        while (it.hasNext() && it.next() != null) {
            i++;
        }
        return i;
    }

    @Nullable
    public final SubFolderHolderInfo getSubFolderHolderInfo(int idx) {
        if (idx >= this.mSubFolderHolderInfoList.size() || idx < 0) {
            return null;
        }
        return this.mSubFolderHolderInfoList.get(idx);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder
    public void onBindViewHolder(int position) {
        int subFolderCount = getSubFolderCount();
        for (int i = 0; i < subFolderCount; i++) {
            SubFolderHolderInfo subFolderHolderInfo = getSubFolderHolderInfo(i);
            if (subFolderHolderInfo != null) {
                AdapterContract adapterContract = getMAdapterContract();
                Intrinsics.checkNotNull(adapterContract);
                adapterContract.onBindViewHolder(subFolderHolderInfo);
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder
    public void onViewAttachedToWindow(@NotNull CommonHolder commonHolder) {
        Intrinsics.checkNotNullParameter(commonHolder, "commonHolder");
        int subFolderCount = ((SubFolderHolder) commonHolder).getSubFolderCount();
        for (int i = 0; i < subFolderCount; i++) {
            AdapterContract adapterContract = getMAdapterContract();
            Intrinsics.checkNotNull(adapterContract);
            adapterContract.onViewAttachedToWindow(getSubFolderHolderInfo(i));
        }
        Runnable runnable = this.mExpandSubFolderHolderAction;
        if (runnable != null) {
            runnable.run();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder
    public void onViewDetachedFromWindow(@NotNull CommonHolder commonHolder) {
        View rootCardView;
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        Intrinsics.checkNotNullParameter(commonHolder, "commonHolder");
        super.onViewDetachedFromWindow(commonHolder);
        for (SubFolderHolderInfo subFolderHolderInfo : this.mSubFolderHolderInfoList) {
            if (subFolderHolderInfo != null && (rootCardView = subFolderHolderInfo.getRootCardView()) != null && (viewPropertyAnimatorAnimate = rootCardView.animate()) != null) {
                viewPropertyAnimatorAnimate.cancel();
            }
        }
    }

    private final void decorateSOMSubFolderNewBadge(int idx, String uuid) {
        if (Intrinsics.areEqual(CategoryConstants.ScreenOffMemo.UUID, uuid)) {
            decorateSOMSubFolderNewBadge(idx);
        }
    }

    @Nullable
    public final SubFolderHolderInfo getSubFolderHolderInfo(@Nullable String uuid) {
        Integer num = this.mSubFolderHolderIndexMap.get(uuid);
        if (num == null) {
            return null;
        }
        return this.mSubFolderHolderInfoList.get(num.intValue());
    }

    private final void decorateSOMSubFolderNewBadge(int idx) {
        SubFolderHolderInfo subFolderHolderInfo = getSubFolderHolderInfo(idx);
        View newBadge = subFolderHolderInfo != null ? subFolderHolderInfo.getNewBadge() : null;
        if (newBadge == null) {
            return;
        }
        boolean zHasSOMFolderNewBadge = BadgeHelper.hasSOMFolderNewBadge();
        AbstractC8014b.m7210l("updateSOMSubFolderNewBadge, isSOMNewBadgeNeed: ", TAG, zHasSOMFolderNewBadge);
        newBadge.setVisibility(zHasSOMFolderNewBadge ? 0 : 8);
    }
}
