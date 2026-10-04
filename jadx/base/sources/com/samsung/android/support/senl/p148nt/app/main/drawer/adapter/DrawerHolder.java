package com.samsung.android.support.senl.p148nt.app.main.drawer.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.glance.AbstractC2821a;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesShareReadResolver;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.badge.BadgeHelper;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.FolderUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.FolderHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.view.CenterImageSpan;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class DrawerHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener, View.OnKeyListener, View.OnTouchListener, View.OnContextClickListener, View.OnHoverListener {
    private static final String TAG = "DrawerHolder";
    private final AdapterContract mAdapterContract;
    private final ImageView mArrow;
    private final TextView mCountView;
    private final int mDirectoryDepthWidth;
    private final View mFolderItemContainer;
    private final View mFolderItemLayout;
    private FolderHolderInfo mHolderInfo;
    private final ImageView mIcon;
    private final View mIconLayout;
    private final View mItemDivider;
    private final TextView mManageLayout;
    private final View mSelectedHolderLayout;
    private ImageView mSettingIcon;
    private final View mSettingLayout;
    private View mSettingNewBadge;
    private final TextView mTitle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class RtlBetaImageSpan extends CenterImageSpan {
        public RtlBetaImageSpan(@NonNull Drawable drawable) {
            super(drawable);
        }

        @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.CenterImageSpan, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i4, int i5, int i6, @NonNull Paint paint) {
            Drawable cachedDrawable = getCachedDrawable();
            canvas.save();
            int intrinsicHeight = cachedDrawable.getIntrinsicHeight();
            canvas.translate(f - BaseUtils.getApplicationContext().getResources().getDimensionPixelSize(C8003R.dimen.co_edit_beta_view_margin_start), (((intrinsicHeight - paint.getFontMetricsInt().descent) + paint.getFontMetricsInt().ascent) / 2) + (i6 - cachedDrawable.getBounds().bottom));
            cachedDrawable.draw(canvas);
            canvas.restore();
        }
    }

    public DrawerHolder(@NonNull View view, AdapterContract adapterContract, int i) {
        super(view);
        this.mAdapterContract = adapterContract;
        View viewFindViewById = view.findViewById(C8003R.id.drawer_item_container);
        this.mFolderItemContainer = viewFindViewById;
        View viewFindViewById2 = viewFindViewById.findViewById(C8003R.id.folder_item_layout);
        this.mFolderItemLayout = viewFindViewById2;
        View viewFindViewById3 = view.findViewById(C8003R.id.drawer_setting_layout);
        this.mSettingLayout = viewFindViewById3;
        if (viewFindViewById3 != null) {
            this.mSettingIcon = (ImageView) viewFindViewById3.findViewById(C8003R.id.drawer_setting_icon);
            this.mSettingNewBadge = viewFindViewById3.findViewById(C8003R.id.drawer_setting_new_badge);
        }
        this.mItemDivider = view.findViewById(C8003R.id.item_divider);
        this.mManageLayout = (TextView) view.findViewById(C8003R.id.manage_folder);
        View viewFindViewById4 = viewFindViewById2.findViewById(C8003R.id.icon_layout);
        this.mIconLayout = viewFindViewById4;
        this.mArrow = (ImageView) viewFindViewById4.findViewById(C8003R.id.arrow_icon);
        this.mIcon = (ImageView) viewFindViewById4.findViewById(C8003R.id.icon);
        View viewFindViewById5 = view.findViewById(C8003R.id.selected_holder);
        this.mSelectedHolderLayout = viewFindViewById5;
        viewFindViewById5.setOnTouchListener(this);
        viewFindViewById5.setOnClickListener(this);
        viewFindViewById5.setOnLongClickListener(this);
        viewFindViewById5.setOnContextClickListener(this);
        viewFindViewById5.setOnHoverListener(this);
        this.mDirectoryDepthWidth = i;
        this.mTitle = (TextView) view.findViewById(C8003R.id.title);
        this.mCountView = (TextView) view.findViewById(C8003R.id.count);
        setBackgroundResources();
    }

    private void decorateMsSyncIcon(NotesFolder notesFolder) {
        this.itemView.findViewById(C8003R.id.ms_icon).setVisibility(NotesUtils.hasMsSyncIcon(notesFolder) ? 0 : 8);
    }

    private void decorateUserFolder(NotesFolder notesFolder) {
        int depth = this.mHolderInfo.getDepth();
        if (depth > 5) {
            depth = 5;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mFolderItemLayout.getLayoutParams();
        layoutParams.setMarginStart(depth * this.mDirectoryDepthWidth);
        this.mFolderItemLayout.setLayoutParams(layoutParams);
        setArrowIconLayout(false, notesFolder.hasChild(), notesFolder.isExpanded(), notesFolder.getDisplayNameColor());
        decorateMsSyncIcon(notesFolder);
    }

    private void initView() {
        this.mFolderItemLayout.setVisibility(8);
        View view = this.mSettingLayout;
        if (view != null) {
            view.setVisibility(8);
        }
        this.mItemDivider.setVisibility(8);
        this.mManageLayout.setVisibility(8);
    }

    private void setArrowIconLayout(boolean z, boolean z2, boolean z3, int i) {
        int i2;
        Resources resources = this.itemView.getResources();
        this.mHolderInfo.setArrow(this.mArrow);
        int folderHomeDrawable = z3 ? C8003R.drawable.ic_folder_open : C8003R.drawable.ic_folder;
        int adjustedFolderDefaultColor = FolderUtils.getAdjustedFolderDefaultColor(i, this.mFolderItemLayout.getContext());
        float f = 0.0f;
        if (z2) {
            i2 = C8003R.drawable.ic_drawer_open;
            if (!z3) {
                f = LocaleUtils.isRTLMode() ? 90.0f : -90.0f;
            }
        } else {
            i2 = -1;
        }
        if (z) {
            this.mArrow.setVisibility(8);
            if (z2) {
                folderHomeDrawable = FolderUtils.getFolderHomeDrawable(z3, this.mHolderInfo.isSolid());
            }
            adjustedFolderDefaultColor = this.itemView.getContext().getColor(C8003R.color.folder_list_item_filter_icon_color);
        } else if (i2 == -1) {
            this.mArrow.setVisibility(4);
        } else {
            this.mArrow.setVisibility(0);
            this.mArrow.setRotation(f);
            this.mArrow.setImageDrawable(ResourcesCompat.getDrawable(resources, i2, null));
        }
        setIconLayout(folderHomeDrawable, adjustedFolderDefaultColor, z2, z3);
    }

    private void setBackgroundResources() {
        if (DeviceInfo.isVSTModel()) {
            this.mManageLayout.getBackground().setTint(ContextCompat.getColor(this.itemView.getContext(), C8003R.color.drawer_manage_folder_bg_color_for_vst));
        }
    }

    private void setIconLayout(int i) {
        this.mFolderItemLayout.setVisibility(0);
        this.mIcon.setImageResource(i);
        this.mIcon.setColorFilter(new PorterDuffColorFilter(this.itemView.getContext().getColor(C8003R.color.folder_list_item_filter_icon_color), PorterDuff.Mode.SRC_IN));
        this.mIconLayout.setBackground(null);
        this.mHolderInfo.setIconLayout(this.mIconLayout);
        this.mHolderInfo.setArrowIconLayout(this.mArrow);
    }

    private void updateSettingsIconNewBadge(int i, int i2) {
        String strM12i;
        View view = this.mSettingNewBadge;
        if (view != null && view.getVisibility() != i) {
            this.mSettingNewBadge.setVisibility(i);
        }
        ImageView imageView = this.mSettingIcon;
        if (imageView != null) {
            Resources resources = imageView.getResources();
            String string = resources.getString(CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C8003R.string.action_notes_settings_jp : C8003R.string.action_notes_settings);
            if (i2 == 1) {
                StringBuilder sbM1324q = AbstractC1974b.m1324q(string);
                AbstractC8014b.m7202d(resources, C8003R.string.string_comma, sbM1324q, " ");
                strM12i = AbstractC0000a.m12i(resources, C8003R.string.badge_new_notification, sbM1324q);
            } else if (i2 > 1) {
                StringBuilder sbM1324q2 = AbstractC1974b.m1324q(string);
                AbstractC8014b.m7202d(resources, C8003R.string.string_comma, sbM1324q2, " ");
                strM12i = AbstractC0000a.m12i(resources, C8003R.string.badge_new_notifications, sbM1324q2);
            } else {
                strM12i = string;
            }
            this.mSettingIcon.setContentDescription(strM12i);
            ViewCompat.getInstance().setTooltipText(this.mSettingIcon, string);
        }
    }

    public void applyHighlightSelectedHolder(boolean z) {
        MainLogger.m7254d(TAG, "applyHighlightSelectedHolder# holder : " + this.mHolderInfo.getUuid() + ", isSelected : " + z);
        this.mHolderInfo.setIsSolid(z);
        this.mHolderInfo.setHighlightSelectedFolder(z);
    }

    public void decorate(NotesFolder notesFolder) {
        if (notesFolder == null) {
            return;
        }
        initView();
        String uuid = notesFolder.getUuid();
        int viewType = notesFolder.getViewType();
        int iDecorateCount = viewType != 1007 ? decorateCount(notesFolder) : 0;
        FolderHolderInfo folderHolderInfo = this.mHolderInfo;
        if (folderHolderInfo == null) {
            this.mHolderInfo = new FolderHolderInfo().setUuid(uuid).setFolderItemLayout(this.mFolderItemLayout).setViewType(viewType).setDepth(notesFolder.getDepth()).setHasChild(notesFolder.hasChild()).setExpanded(notesFolder.isExpanded()).setColor(notesFolder.getDisplayNameColor()).setTitleView(this.mTitle).setSelectedHolderLayout(this.mSelectedHolderLayout).setFolderItemContainer(this.mFolderItemContainer);
        } else {
            folderHolderInfo.setUuid(uuid).setViewType(viewType).setDepth(notesFolder.getDepth()).setHasChild(notesFolder.hasChild()).setExpanded(notesFolder.isExpanded());
        }
        Context context = this.itemView.getContext();
        if (viewType == 0) {
            this.mTitle.setText(notesFolder.getDisplayName());
            decorateUserFolder(notesFolder);
        } else if (viewType == 1) {
            updateNewBadge(viewType, notesFolder.isExpanded());
            this.mTitle.setText(C8003R.string.string_screen_off_memo);
            decorateUserFolder(notesFolder);
        } else if (viewType == 2) {
            this.mTitle.setText(C8003R.string.string_math_notes);
            decorateUserFolder(notesFolder);
        } else if (viewType == 3) {
            this.mTitle.setText(C8003R.string.settings_my_folders);
            setArrowIconLayout(true, notesFolder.hasChild(), notesFolder.isExpanded(), -1);
            decorateMsSyncIcon(notesFolder);
            updateNewBadge(viewType, notesFolder.isExpanded());
        } else if (viewType != 5) {
            switch (viewType) {
                case 1001:
                    if (this.mSettingLayout == null) {
                        MainLogger.m7258i(TAG, "mSettingLayout is null");
                        return;
                    }
                    this.itemView.setBackground(null);
                    this.mSettingIcon.setOnClickListener(this);
                    this.mSettingLayout.setVisibility(0);
                    this.mHolderInfo.setIconLayout(this.mSettingIcon);
                    this.mTitle.setText(C8003R.string.action_settings);
                    updateNewBadge(viewType, notesFolder.isExpanded());
                    break;
                case 1002:
                    setIconLayout(C8003R.drawable.ic_all);
                    this.mTitle.setText(C8003R.string.all_notes);
                    break;
                case 1003:
                    setIconLayout(C8003R.drawable.ic_old_notes);
                    this.mTitle.setText(C8003R.string.upgradable_notes);
                    break;
                case 1004:
                    setIconLayout(C8003R.drawable.ic_favorite);
                    this.mTitle.setText(C8003R.string.favorite_notes);
                    break;
                case 1005:
                    setIconLayout(C8003R.drawable.ic_drawer_lock);
                    this.mTitle.setText(C8003R.string.locked_notes);
                    break;
                case 1006:
                    setIconLayout(C8003R.drawable.ic_import);
                    this.mTitle.setText(C8003R.string.folder_recently_imported);
                    break;
                case 1007:
                    setIconLayout(C8003R.drawable.ic_shared_notebooks);
                    this.mTitle.setText(C8003R.string.shared_notebooks);
                    int sharedItemCount = NotesUtils.isMDEFeatureEnabled() ? SesShareReadResolver.getInstance().getSharedItemCount() : 0;
                    this.mCountView.setText(ContentUtils.convertToArabicNumber(sharedItemCount));
                    updateNewBadge(viewType, notesFolder.isExpanded());
                    iDecorateCount = sharedItemCount;
                    break;
                case 1008:
                    setIconLayout(C8003R.drawable.ic_drawer_coedit);
                    String string = context.getString(C8003R.string.co_edit_title);
                    Editable editableNewEditable = Editable.Factory.getInstance().newEditable(string);
                    int length = string.length();
                    boolean zIsRTLMode = LocaleUtils.isRTLMode();
                    if (zIsRTLMode) {
                        editableNewEditable.insert(length, UnicodeUtils.RLM);
                    } else {
                        editableNewEditable.insert(length, "\u200e");
                    }
                    int dimensionPixelSize = context.getResources().getDimensionPixelSize(C8003R.dimen.co_edit_beta_view_margin_start);
                    Drawable drawable = ResourcesCompat.getDrawable(context.getResources(), C8003R.drawable.ic_beta, null);
                    drawable.setBounds(dimensionPixelSize, 0, drawable.getIntrinsicWidth() + dimensionPixelSize, drawable.getIntrinsicHeight());
                    editableNewEditable.setSpan(zIsRTLMode ? new RtlBetaImageSpan(drawable) : new CenterImageSpan(drawable), length, length + 1, 33);
                    this.mTitle.setText(editableNewEditable);
                    updateNewBadge(viewType, notesFolder.isExpanded());
                    break;
                case 1009:
                    setIconLayout(C8003R.drawable.ic_delete);
                    this.mTitle.setText(C8003R.string.recycle_bin_title);
                    break;
                case 1010:
                    this.itemView.setBackground(null);
                    this.mHolderInfo.setIconLayout(this.mItemDivider);
                    this.mItemDivider.setImportantForAccessibility(2);
                    this.mItemDivider.setVisibility(0);
                    break;
                default:
                    AbstractC8014b.m7201c(viewType, "decorate# unexpected viewType: ", TAG);
                    break;
            }
        } else {
            this.itemView.setBackground(null);
            this.mManageLayout.setOnClickListener(this);
            this.mManageLayout.setVisibility(0);
            CharUtils.applyTextSizeUntilLargeSize(context, this.mManageLayout, 15.0f);
            this.mTitle.setText(C8003R.string.manage_folder);
        }
        applyHighlightSelectedHolder(uuid.equals(FolderConstants.SharedNotes.UUID.equals(this.mAdapterContract.getFolderUuid()) ? FolderConstants.Coedit.UUID : this.mAdapterContract.getFolderUuid()));
        this.mAdapterContract.setDragListener(this);
        setContentDescription(uuid, viewType);
        StringBuilder sb = new StringBuilder("decorate# viewType ");
        AbstractC2821a.m2235z(sb, viewType, iDecorateCount, " count : ", ", hasChild : ");
        sb.append(notesFolder.hasChild());
        sb.append(", isExpanded : ");
        sb.append(notesFolder.isExpanded());
        MainLogger.m7258i(TAG, sb.toString());
    }

    public int decorateCount(NotesFolder notesFolder) {
        if (notesFolder == null) {
            return 0;
        }
        String uuid = notesFolder.getUuid();
        int viewType = notesFolder.getViewType();
        int documentCount = this.mAdapterContract.getModel().getDocumentCount(uuid, viewType) + (FeatureUtils.isNeedFolderCount(viewType) ? this.mAdapterContract.getModel().getFolderDocumentCount(uuid) : 0);
        this.mCountView.setText(ContentUtils.convertToArabicNumber(documentCount));
        if (documentCount <= 0) {
            this.mCountView.setVisibility(8);
        } else {
            this.mCountView.setVisibility(0);
        }
        if (this.mAdapterContract.isFreeFormWindow()) {
            CharUtils.applyTextSizeUntilLargeSize(this.itemView.getContext(), this.mTitle, 18.0f);
            CharUtils.applyTextSizeUntilLargeSize(this.itemView.getContext(), this.mCountView, 13.0f);
            return documentCount;
        }
        this.mTitle.setTextSize(18.0f);
        this.mCountView.setTextSize(13.0f);
        return documentCount;
    }

    public void decorateIcon(NotesFolder notesFolder) {
        if (notesFolder == null) {
            return;
        }
        boolean zHasChildFolder = FolderUtils.hasChildFolder(notesFolder);
        this.mHolderInfo.setHasChild(zHasChildFolder);
        setArrowIconLayout(notesFolder.getViewType() == 3, zHasChildFolder, notesFolder.isExpanded(), notesFolder.getDisplayNameColor());
    }

    public FolderHolderInfo getDrawerHolderInfo() {
        return this.mHolderInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.Drawer;
        if (UserInputSkipper.isValidEvent(tag)) {
            UserInputSkipper.setHoldingEventTime(300L, tag);
            if (this.mAdapterContract == null || this.mHolderInfo == null) {
                return;
            }
            if (view.equals(this.itemView) && (this.mHolderInfo.getViewType() == 1001 || this.mHolderInfo.getViewType() == 1010 || this.mHolderInfo.getViewType() == 5)) {
                return;
            }
            this.mAdapterContract.onFolderSelected(this.mHolderInfo, getLayoutPosition(), (view != this.mIconLayout) || this.mHolderInfo.getViewType() > 3);
        }
    }

    @Override // android.view.View.OnContextClickListener
    public boolean onContextClick(View view) {
        return onLongClick(view);
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (view.isSelected()) {
            return false;
        }
        if (motionEvent.getAction() == 10) {
            view.setBackgroundResource(C8003R.color.transparent);
        } else {
            view.setBackgroundResource(C8003R.drawable.drawer_item_selector_bg);
        }
        return false;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        FolderHolderInfo folderHolderInfo;
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.Drawer;
        if (!UserInputSkipper.isValidEvent(tag)) {
            return false;
        }
        UserInputSkipper.setHoldingEventTime(300L, tag);
        if (this.mAdapterContract == null || (folderHolderInfo = this.mHolderInfo) == null || folderHolderInfo.getViewType() > 3) {
            return false;
        }
        this.mHolderInfo.setTouchedView(view);
        this.mAdapterContract.onItemLongPressed(this.mHolderInfo);
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.mHolderInfo.setTouchPos(motionEvent.getX(), motionEvent.getY());
        this.mHolderInfo.setTouchedView(view);
        return false;
    }

    public void onViewAttachedToWindow() {
        applyHighlightSelectedHolder(getDrawerHolderInfo().getUuid().equals(FolderConstants.SharedNotes.UUID.equals(this.mAdapterContract.getFolderUuid()) ? FolderConstants.Coedit.UUID : this.mAdapterContract.getFolderUuid()));
    }

    public void setContentDescription(String str, int i) {
        String strM12i;
        String string = this.mTitle.getText().toString();
        int i2 = Integer.parseInt(this.mCountView.getText().toString());
        Resources resources = this.itemView.getContext().getResources();
        if (i == 3 || i == 0 || FolderUtils.isStaticFolder(str)) {
            strM12i = resources.getString(C8003R.string.folder_string) + SQLKeyword.COMMA + string + SQLKeyword.COMMA + resources.getQuantityString(C8003R.plurals.plurals_count_items, i2, Integer.valueOf(i2));
        } else if (i == 5) {
            strM12i = AbstractC0000a.m12i(resources, C8003R.string.tipcard_button_content_description, AbstractC0541b.m781w(string, SQLKeyword.COMMA));
            this.mManageLayout.setContentDescription(strM12i);
        } else {
            StringBuilder sbM781w = AbstractC0541b.m781w(string, SQLKeyword.COMMA);
            sbM781w.append(resources.getQuantityString(C8003R.plurals.plurals_count_items, i2, Integer.valueOf(i2)));
            sbM781w.append(SQLKeyword.COMMA);
            strM12i = AbstractC0000a.m12i(resources, C8003R.string.tipcard_button_content_description, sbM781w);
        }
        this.mFolderItemLayout.setContentDescription(strM12i);
    }

    public void updateNewBadge(int i, boolean z) {
        if (i == 1001) {
            int numOfSettingsNewBadgeReason = BadgeHelper.getNumOfSettingsNewBadgeReason();
            updateSettingsIconNewBadge(numOfSettingsNewBadgeReason <= 0 ? 8 : 0, numOfSettingsNewBadgeReason);
        } else if (i == 1007) {
            TextView textView = (TextView) this.mFolderItemLayout.findViewById(C8003R.id.new_badge);
            i = BadgeHelper.hasGcsDrawerBadge() ? 0 : 8;
            if (textView.getVisibility() != i) {
                textView.setVisibility(i);
            }
        } else if (i == 1008) {
            TextView textView2 = (TextView) this.mFolderItemLayout.findViewById(C8003R.id.new_badge);
            if (!BadgeHelper.hasCoeditBadge() && !BadgeHelper.hasGcsDrawerBadge()) {
                i = 8;
            }
            textView2.setVisibility(i);
        } else if (i == 3) {
            TextView textView3 = (TextView) this.mFolderItemLayout.findViewById(C8003R.id.new_badge);
            if (z) {
                textView3.setVisibility(8);
            } else {
                textView3.setVisibility(BadgeHelper.hasSOMFolderNewBadge() ? 0 : 8);
            }
        } else if (i != 1) {
            return;
        } else {
            ((TextView) this.mFolderItemLayout.findViewById(C8003R.id.new_badge)).setVisibility(BadgeHelper.hasSOMFolderNewBadge() ? 0 : 8);
        }
        this.mAdapterContract.updateNewBadge();
    }

    private void setIconLayout(int i, int i2, boolean z, boolean z2) {
        this.mFolderItemLayout.setVisibility(0);
        this.mIcon.setImageResource(i);
        this.mIcon.setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_IN));
        String str = (String) this.mTitle.getText();
        Resources resources = this.mIconLayout.getResources();
        StringBuilder sb = new StringBuilder();
        sb.append(resources.getString(C8003R.string.ps_folder_tts, str));
        sb.append(SQLKeyword.COMMA);
        sb.append(resources.getString(C8003R.string.ps_button_tts, resources.getString(z2 ? C8003R.string.collapse : C8003R.string.expand)));
        this.mIconLayout.setContentDescription(sb.toString());
        this.mIconLayout.setImportantForAccessibility(z ? 1 : 2);
        this.mIconLayout.setOnTouchListener(this);
        this.mIconLayout.setOnClickListener(this);
        this.mIconLayout.setOnLongClickListener(this);
        this.mHolderInfo.setIconLayout(this.mIconLayout);
        this.mHolderInfo.setArrowIconLayout(this.mArrow);
    }
}
