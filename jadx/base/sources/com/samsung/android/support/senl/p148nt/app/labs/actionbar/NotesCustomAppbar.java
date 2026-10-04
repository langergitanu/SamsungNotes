package com.samsung.android.support.senl.p148nt.app.labs.actionbar;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.sdk.pen.setting.handwriting.RunnableC7599e;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.C9086R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class NotesCustomAppbar extends RelativeLayout {
    static final String TAG = "NotesCustomAppbar";
    private RecyclerView mActionButtonList;
    private ActionButtonListAdapter mActionButtonListAdapter;
    private LinearLayout mAppbar;
    private ComposerOptionsMenu mMenu;
    private View mMoreOptionMenuButton;
    private ListPopupWindow mMoreOptionMenuList;
    private EditText mTitle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ActionButtonListAdapter extends RecyclerView.Adapter<ActionButtonViewHolder> {
        int itemCount;

        public ActionButtonListAdapter() {
            this.itemCount = NotesCustomAppbar.this.mMenu.getList().size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.itemCount;
        }

        public void setItemCount(int i) {
            this.itemCount = i;
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull ActionButtonViewHolder actionButtonViewHolder, int i) {
            ImageView imageView = actionButtonViewHolder.mActionButton;
            if (imageView == null) {
                return;
            }
            imageView.setImageResource(NotesCustomAppbar.this.mMenu.getList().get(i).icon);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public ActionButtonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new ActionButtonViewHolder(LayoutInflater.from(NotesCustomAppbar.this.getContext()).inflate(C8003R.layout.notes_appbar_action_button, viewGroup, false));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ActionButtonViewHolder extends RecyclerView.ViewHolder {
        ImageView mActionButton;

        public ActionButtonViewHolder(@NonNull View view) {
            super(view);
            if (view instanceof ImageView) {
                this.mActionButton = (ImageView) view;
            }
        }
    }

    public NotesCustomAppbar(Context context) {
        super(context);
        inflateView(context);
    }

    private void updateAppbarHeight(Configuration configuration) {
        this.mAppbar.setLayoutParams(new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(configuration.orientation == 2 ? C8003R.dimen.comp_go_to_top_size : C8003R.dimen.comp_actionbar_height)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMenu() {
        int width = ((View) this.mTitle.getParent()).getWidth();
        int width2 = this.mTitle.getWidth();
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(C8003R.dimen.drawer_list_item_settings_icon_size);
        int i = width - width2;
        int i2 = i / dimensionPixelSize;
        Logger.m8697d(TAG, width + " - " + width2);
        Logger.m8697d(TAG, i + " / " + dimensionPixelSize + "  = " + i2);
        int size = this.mMenu.getList().size();
        if (i2 > size) {
            i2 = size;
        }
        if (this.mActionButtonListAdapter.getItemCount() != i2) {
            Logger.m8697d(TAG, "update menu count " + this.mActionButtonListAdapter.getItemCount() + " -> " + i2);
            this.mActionButtonListAdapter.setItemCount(i2);
        }
    }

    public void inflateView(Context context) {
        View.inflate(context, C8003R.layout.notes_custom_appbar, this);
        this.mMenu = new ComposerOptionsMenu();
        this.mAppbar = (LinearLayout) findViewById(C8003R.id.notes_custom_appbar);
        View viewFindViewById = findViewById(C8003R.id.more_options_button);
        this.mMoreOptionMenuButton = viewFindViewById;
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.labs.actionbar.NotesCustomAppbar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NotesCustomAppbar.this.showMoreOptionsMenuList();
            }
        });
        this.mActionButtonList = (RecyclerView) findViewById(C8003R.id.action_button_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext()) { // from class: com.samsung.android.support.senl.nt.app.labs.actionbar.NotesCustomAppbar.2
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean canScrollHorizontally() {
                return false;
            }

            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean canScrollVertically() {
                return false;
            }
        };
        linearLayoutManager.setOrientation(0);
        this.mActionButtonListAdapter = new ActionButtonListAdapter();
        this.mActionButtonList.setLayoutManager(linearLayoutManager);
        this.mActionButtonList.setAdapter(this.mActionButtonListAdapter);
        EditText editText = (EditText) findViewById(C8003R.id.text_input_dialog);
        this.mTitle = editText;
        editText.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.app.labs.actionbar.NotesCustomAppbar.3
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
                if (i4 != i8) {
                    Logger.m8697d(NotesCustomAppbar.TAG, "onLayoutChange()");
                    NotesCustomAppbar.this.updateMenu();
                }
            }
        });
        updateAppbarHeight(getResources().getConfiguration());
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        updateAppbarHeight(configuration);
        this.mAppbar.postDelayed(new RunnableC7599e(this, 14), 100L);
    }

    public void showMoreOptionsMenuList() {
        int size = this.mMenu.getList().size() - this.mActionButtonListAdapter.getItemCount();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = getResources().getString(this.mMenu.getList().get(this.mActionButtonListAdapter.getItemCount() + i).title);
        }
        ListPopupWindow listPopupWindow = new ListPopupWindow(getContext());
        this.mMoreOptionMenuList = listPopupWindow;
        listPopupWindow.setWidth(400);
        this.mMoreOptionMenuList.setAdapter(new ArrayAdapter<String>(getContext(), C9086R.layout.comp_page_list_item_more_menu_item, strArr) { // from class: com.samsung.android.support.senl.nt.app.labs.actionbar.NotesCustomAppbar.4
            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            @NonNull
            public View getView(int i2, @Nullable View view, @NonNull ViewGroup viewGroup) {
                if (view == null) {
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.comp_page_list_item_more_menu_item, (ViewGroup) null);
                }
                ((TextView) view.findViewById(C9086R.id.comp_page_list_item_more_menu_title)).setText((CharSequence) getItem(i2));
                return view;
            }
        });
        this.mMoreOptionMenuList.setAnchorView(this.mMoreOptionMenuButton);
        this.mMoreOptionMenuList.setDropDownGravity(8388661);
        this.mMoreOptionMenuList.show();
    }

    public NotesCustomAppbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        inflateView(context);
    }

    public NotesCustomAppbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        inflateView(context);
    }
}
