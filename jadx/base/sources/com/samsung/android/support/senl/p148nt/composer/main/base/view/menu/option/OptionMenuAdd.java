package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.util.CaptionBarHelper;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuAddPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.BackgroundColorUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.common.OptionMenuPopupWindowHelper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OptionMenuAdd {
    private static final String TAG = Logger.createTag("OptionMenuAdd");
    protected final Activity mActivity;
    private PopupWindow mAddMenuPopup;
    protected final OptionMenuAddPresenter mPresenter;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public abstract class AbsInsertMenuAdapter extends RecyclerView.Adapter<ViewHolder> {
        protected List<MenuItem> itemArray;

        public /* synthetic */ AbsInsertMenuAdapter(OptionMenuAdd optionMenuAdd, int i) {
            this();
        }

        public void bindItemView(LinearLayout linearLayout, MenuItem menuItem) {
            ((TextView) linearLayout.findViewById(C9086R.id.item_text)).setText(OptionMenuAdd.this.mActivity.getResources().getString(menuItem.name));
            ImageView imageView = (ImageView) linearLayout.findViewById(C9086R.id.item_button);
            int i = menuItem.icon;
            if (i > 0) {
                imageView.setImageResource(i);
                imageView.setColorFilter(linearLayout.getResources().getColor(C9086R.color.composer_moreoption_icon_color_filter, null));
            }
            imageView.setVisibility(0);
        }

        public abstract View.OnClickListener createItemOnClickListener();

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<MenuItem> list = this.itemArray;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        private AbsInsertMenuAdapter() {
            this.itemArray = new ArrayList();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            bindItemView((LinearLayout) viewHolder.itemView, this.itemArray.get(i));
            viewHolder.itemView.setTag(Integer.valueOf(i));
            viewHolder.itemView.setOnClickListener(createItemOnClickListener());
            if (i == 0 && (this instanceof InsertMenuTopAdapter)) {
                viewHolder.itemView.setBackgroundResource(C9086R.drawable.comp_ripple_effect_top);
            } else if (i == this.itemArray.size() - 1 && (this instanceof InsertMenuBottomAdapter)) {
                viewHolder.itemView.setBackgroundResource(C9086R.drawable.comp_ripple_effect_bottom);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class GridItemDecoration extends RecyclerView.ItemDecoration {
        private final int mBottomSpacing;
        private final int mSideSpacing;

        public GridItemDecoration(int i) {
            this.mBottomSpacing = i;
            this.mSideSpacing = i / 2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            int i = this.mSideSpacing;
            rect.right = i;
            rect.left = i;
            rect.bottom = this.mBottomSpacing;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class InsertMenuBottomAdapter extends AbsInsertMenuAdapter {
        public InsertMenuBottomAdapter() {
            super(OptionMenuAdd.this, 0);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.OptionMenuAdd.AbsInsertMenuAdapter
        public View.OnClickListener createItemOnClickListener() {
            return new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.OptionMenuAdd.InsertMenuBottomAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = InsertMenuBottomAdapter.this.itemArray.get(((Integer) view.getTag()).intValue()).name;
                    Logger.m11003i(OptionMenuAdd.TAG, "showAddMenuListDialog$onClick, which: " + OptionMenuAdd.this.mActivity.getResources().getString(i));
                    OptionMenuAdd.this.onBottomMenuClicked(i);
                }
            };
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.OptionMenuAdd.AbsInsertMenuAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ int getItemCount() {
            return super.getItemCount();
        }

        public void init() {
            this.itemArray.add(new MenuItem(C9086R.string.composer_add_image, C9086R.drawable.composer_add_image));
            if (OptionMenuAdd.this.mPresenter.isSupportCamera()) {
                this.itemArray.add(new MenuItem(C9086R.string.composer_add_camera, C9086R.drawable.composer_add_camera));
            }
            if (OptionMenuAdd.this.mPresenter.isSupportDocScan()) {
                this.itemArray.add(new MenuItem(C9086R.string.composer_add_scan, C9086R.drawable.composer_add_scan));
            }
            if (OptionMenuAdd.this.mPresenter.isAudioFileEnabled()) {
                this.itemArray.add(new MenuItem(C9086R.string.composer_add_audio, C9086R.drawable.composer_add_audio));
            }
            if (OptionMenuAdd.this.mPresenter.isTextFileEnabled()) {
                this.itemArray.add(new MenuItem(C9086R.string.composer_share_text_only, C9086R.drawable.composer_add_text_box));
            }
            this.itemArray.add(new MenuItem(C9086R.string.composer_add_drawing, C9086R.drawable.composer_add_drawing));
            if (OptionMenuAdd.this.mPresenter.isStickyMemoEnabled()) {
                this.itemArray.add(new MenuItem(C9086R.string.composer_add_sticky_memo, C9086R.drawable.composer_add_sticky_memo));
            }
            if (OptionMenuAdd.this.mPresenter.isTableEnabled()) {
                this.itemArray.add(new MenuItem(C9086R.string.composer_add_table, C9086R.drawable.composer_add_table));
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.OptionMenuAdd.AbsInsertMenuAdapter
        public /* bridge */ /* synthetic */ void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            super.onBindViewHolder(viewHolder, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.comp_insert_menu_bottom_list_item, viewGroup, false));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class InsertMenuTopAdapter extends AbsInsertMenuAdapter {
        public InsertMenuTopAdapter() {
            super(OptionMenuAdd.this, 0);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.OptionMenuAdd.AbsInsertMenuAdapter
        public View.OnClickListener createItemOnClickListener() {
            return new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.OptionMenuAdd.InsertMenuTopAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = InsertMenuTopAdapter.this.itemArray.get(((Integer) view.getTag()).intValue()).name;
                    Logger.m11003i(OptionMenuAdd.TAG, "showAddMenuListDialog$onClick, which: " + OptionMenuAdd.this.mActivity.getResources().getString(i));
                    OptionMenuAdd.this.onTopMenuClicked(i);
                }
            };
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.OptionMenuAdd.AbsInsertMenuAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ int getItemCount() {
            return super.getItemCount();
        }

        public void init() {
            if (OptionMenuAdd.this.mPresenter.isPDFEnabled()) {
                this.itemArray.add(new MenuItem(C9086R.string.composer_add_pdf, C9086R.drawable.composer_add_pdf));
            }
            if (OptionMenuAdd.this.mPresenter.isVoiceEnabled()) {
                FeatureInfo.isSupportSTTFunction();
                this.itemArray.add(new MenuItem(C9086R.string.voice_notification_channel_name, C9086R.drawable.composer_add_voice));
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.OptionMenuAdd.AbsInsertMenuAdapter
        public /* bridge */ /* synthetic */ void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            super.onBindViewHolder(viewHolder, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.comp_insert_menu_bottom_list_item, viewGroup, false));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MenuItem {
        int icon;
        int name;

        public MenuItem(int i, int i2) {
            this.name = i;
            this.icon = i2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View view) {
            super(view);
        }
    }

    public OptionMenuAdd(Activity activity, OptionMenuPresenter optionMenuPresenter) {
        this.mActivity = activity;
        this.mPresenter = optionMenuPresenter.getOptionMenuAddPresenter();
    }

    private void initMenuView() {
        View viewInflate = View.inflate(this.mActivity, C9086R.layout.comp_insert_menu_layout, null);
        BackgroundColorUtil.setBlurInfoPopup(this.mActivity, viewInflate);
        InsertMenuTopAdapter insertMenuTopAdapterCreateInsertMenuTopAdapter = createInsertMenuTopAdapter();
        insertMenuTopAdapterCreateInsertMenuTopAdapter.init();
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(C9086R.id.menu_top_recycler_view);
        recyclerView.setAdapter(insertMenuTopAdapterCreateInsertMenuTopAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity));
        checkDividerVisibility(viewInflate);
        InsertMenuBottomAdapter insertMenuBottomAdapterCreateInsertMenuBottomAdapter = createInsertMenuBottomAdapter();
        insertMenuBottomAdapterCreateInsertMenuBottomAdapter.init();
        RecyclerView recyclerView2 = (RecyclerView) viewInflate.findViewById(C9086R.id.menu_bottom_recycler_view);
        recyclerView2.setAdapter(insertMenuBottomAdapterCreateInsertMenuBottomAdapter);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this.mActivity));
        PopupWindow popupWindow = new PopupWindow(viewInflate, -2, -2);
        this.mAddMenuPopup = popupWindow;
        OptionMenuPopupWindowHelper.setDefaultState(popupWindow, this.mActivity);
    }

    public void checkDividerVisibility(View view) {
    }

    public InsertMenuBottomAdapter createInsertMenuBottomAdapter() {
        return new InsertMenuBottomAdapter();
    }

    public InsertMenuTopAdapter createInsertMenuTopAdapter() {
        return new InsertMenuTopAdapter();
    }

    public void hideAddMenuPopup() {
        Logger.m11003i(TAG, "hideAddMenuPopup#");
        PopupWindow popupWindow = this.mAddMenuPopup;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        this.mAddMenuPopup.dismiss();
    }

    public void onBottomMenuClicked(int i) {
        String str = this.mPresenter.isCoeditNote() ? "683" : "401";
        if (C9086R.string.composer_add_image == i) {
            this.mPresenter.addImage();
            ComposerSA.insertLog(str, ComposerSAConstants.EVENT_EDIT_IMAGE);
        } else if (C9086R.string.composer_add_camera == i) {
            this.mPresenter.addCameraImage();
            ComposerSA.insertLog(str, ComposerSAConstants.EVENT_EDIT_CAMERA);
        } else if (C9086R.string.composer_add_scan == i) {
            this.mPresenter.addScan();
            ComposerSA.insertLog(str, ComposerSAConstants.EVENT_EDIT_SCAN);
        } else if (C9086R.string.composer_add_text_box == i) {
            this.mPresenter.addTextBox();
            ComposerSA.insertLog(str, ComposerSAConstants.EVENT_EDIT_TEXTBOX_IN_WRITING);
        } else if (C9086R.string.composer_add_drawing == i) {
            InputMethodCompat.getInstance().forceHideSoftInput(this.mActivity.getApplicationContext());
            this.mPresenter.addDrawing();
            ComposerSA.insertLog(str, ComposerSAConstants.EVENT_EDIT_DRAWING);
        } else if (C9086R.string.stt_convert_speech_to_text == i) {
            this.mPresenter.addAudioFileForConvertVoiceToText();
            ComposerSA.insertLog(str, ComposerSAConstants.EVENT_EDIT_AUDIO_FILE);
        } else if (C9086R.string.composer_add_audio == i) {
            this.mPresenter.addAudioFile();
            ComposerSA.insertLog(str, ComposerSAConstants.EVENT_EDIT_AUDIO_FILE);
        } else if (C9086R.string.composer_share_text_only == i) {
            this.mPresenter.addTextFile();
        } else if (C9086R.string.composer_add_math == i) {
            this.mPresenter.addMath();
            ComposerSA.insertLog(str, ComposerSAConstants.EVENT_EDIT_EQUATION);
        } else if (C9086R.string.composer_add_table == i) {
            this.mPresenter.addTable();
            ComposerSA.insertLog(str, ComposerSAConstants.EVENT_EDIT_TABLE);
        } else if (C9086R.string.composer_add_sticky_memo == i) {
            this.mPresenter.addStickyMemo();
            ComposerSA.insertLog(str, ComposerSAConstants.EVENT_EDIT_STICKY_NOTE);
        }
        hideAddMenuPopup();
    }

    public void onTopMenuClicked(int i) {
        String str = this.mPresenter.isCoeditNote() ? "683" : "401";
        if (C9086R.string.composer_add_pdf == i) {
            this.mPresenter.addPdf();
            ComposerSA.insertLog(str, ComposerSAConstants.EVENT_EDIT_PDF);
        } else if (C9086R.string.voice_notification_channel_name == i) {
            this.mPresenter.addVoice();
            ComposerSA.insertLog(str, ComposerSAConstants.EVENT_EDIT_VOICE);
        }
        hideAddMenuPopup();
    }

    public void showAddMenuPopup() {
        Logger.m11003i(TAG, "showAddMenuPopup#");
        if (this.mPresenter.isNotAvailableStorage()) {
            return;
        }
        initMenuView();
        View anchorViewInToolbar = OptionMenuPopupWindowHelper.getAnchorViewInToolbar(this.mActivity, C9086R.id.action_add);
        if (Build.VERSION.SDK_INT <= 34 || LocaleUtils.isRTLMode()) {
            this.mAddMenuPopup.showAtLocation(anchorViewInToolbar, OptionMenuPopupWindowHelper.getPopupWindowGravity(), 0, CaptionBarHelper.getCaptionBarHeight(this.mActivity));
        } else {
            this.mAddMenuPopup.showAsDropDown(anchorViewInToolbar);
        }
    }
}
