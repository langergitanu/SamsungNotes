package com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.adapter;

import android.animation.StateListAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomappbar.RunnableC4587a;
import com.google.android.material.datepicker.ViewOnFocusChangeListenerC4697c;
import com.samsung.android.sdk.pen.setting.common.ViewOnLongClickListenerC7556a;
import com.samsung.android.spr.drawable.Spr;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.DrawableUtils;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.adapter.holder.ImportFolderHolder;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.model.ImportFolderInfo;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001e\u001fB\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u0013H\u0016J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0002H\u0002J\u001a\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/adapter/ImportFolderAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/adapter/holder/ImportFolderHolder;", "mContract", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/adapter/ImportFolderAdapterContract;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/adapter/ImportFolderAdapterContract;)V", "mItemAccessibilityDelegate", "Landroid/view/View$AccessibilityDelegate;", "mContainerAccessibilityDelegate", "mFileClickListener", "Landroid/view/View$OnClickListener;", "mFolderClickListener", "mLongClickListener", "Landroid/view/View$OnLongClickListener;", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "i", "", "onBindViewHolder", "", "viewHolder", "position", "onViewAttachedToWindow", "getItemCount", "toggleItemCheckState", "updateContentDescription", "fileData", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/model/ImportFolderInfo;", "RunnableWithView", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nImportFolderAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImportFolderAdapter.kt\ncom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/adapter/ImportFolderAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,250:1\n1#2:251\n*E\n"})
public final class ImportFolderAdapter extends RecyclerView.Adapter<ImportFolderHolder> {

    @NotNull
    private static final String TAG = "ImportFolderAdapter";

    @Nullable
    private final ImportFolderAdapterContract mContract;

    @NotNull
    private final View.OnClickListener mFileClickListener;

    @NotNull
    private final View.OnClickListener mFolderClickListener;

    @NotNull
    private final View.AccessibilityDelegate mItemAccessibilityDelegate = new View.AccessibilityDelegate() { // from class: com.samsung.android.support.senl.nt.app.settings.importnotes.folderlist.adapter.ImportFolderAdapter$mItemAccessibilityDelegate$1
        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
            Intrinsics.checkNotNullParameter(host, "host");
            Intrinsics.checkNotNullParameter(info, "info");
            super.onInitializeAccessibilityNodeInfo(host, info);
            info.setCheckable(true);
            Object tag = host.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.app.settings.importnotes.folderlist.adapter.holder.ImportFolderHolder");
            CheckBox checkBox = ((ImportFolderHolder) tag).mCheckBox;
            Intrinsics.checkNotNull(checkBox);
            info.setChecked(checkBox.isChecked());
        }
    };

    @NotNull
    private final View.AccessibilityDelegate mContainerAccessibilityDelegate = new View.AccessibilityDelegate() { // from class: com.samsung.android.support.senl.nt.app.settings.importnotes.folderlist.adapter.ImportFolderAdapter$mContainerAccessibilityDelegate$1
        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
            Intrinsics.checkNotNullParameter(host, "host");
            Intrinsics.checkNotNullParameter(event, "event");
            super.onInitializeAccessibilityEvent(host, event);
            Object tag = host.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.app.settings.importnotes.folderlist.adapter.holder.ImportFolderHolder");
            ImportFolderHolder importFolderHolder = (ImportFolderHolder) tag;
            int eventType = event.getEventType();
            if (eventType == 32768) {
                importFolderHolder.mAccessibilityFocused = true;
            } else {
                if (eventType != 65536) {
                    return;
                }
                importFolderHolder.mAccessibilityFocused = false;
            }
        }
    };

    @NotNull
    private final View.OnLongClickListener mLongClickListener = new ViewOnLongClickListenerC7556a(this, 2);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0012\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/adapter/ImportFolderAdapter$RunnableWithView;", "Ljava/lang/Runnable;", "mView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "getMView", "()Landroid/view/View;", "run", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class RunnableWithView implements Runnable {

        @Nullable
        private final View mView;

        public RunnableWithView(@Nullable View view) {
            this.mView = view;
        }

        @Nullable
        public final View getMView() {
            return this.mView;
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public ImportFolderAdapter(@Nullable ImportFolderAdapterContract importFolderAdapterContract) {
        this.mContract = importFolderAdapterContract;
        final int i = 0;
        this.mFileClickListener = new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.app.settings.importnotes.folderlist.adapter.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ ImportFolderAdapter f6328b;

            {
                this.f6328b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i) {
                    case 0:
                        ImportFolderAdapter.mFileClickListener$lambda$0(this.f6328b, view);
                        break;
                    default:
                        ImportFolderAdapter.mFolderClickListener$lambda$5(this.f6328b, view);
                        break;
                }
            }
        };
        final int i2 = 1;
        this.mFolderClickListener = new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.app.settings.importnotes.folderlist.adapter.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ ImportFolderAdapter f6328b;

            {
                this.f6328b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i2) {
                    case 0:
                        ImportFolderAdapter.mFileClickListener$lambda$0(this.f6328b, view);
                        break;
                    default:
                        ImportFolderAdapter.mFolderClickListener$lambda$5(this.f6328b, view);
                        break;
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mFileClickListener$lambda$0(ImportFolderAdapter importFolderAdapter, View view) {
        Object tag = view.getTag();
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.app.settings.importnotes.folderlist.adapter.holder.ImportFolderHolder");
        ImportFolderHolder importFolderHolder = (ImportFolderHolder) tag;
        if (importFolderHolder.getAdapterPosition() < 0) {
            return;
        }
        importFolderAdapter.toggleItemCheckState(importFolderHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mFolderClickListener$lambda$5(ImportFolderAdapter importFolderAdapter, View view) {
        Object tag = view.getTag();
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.app.settings.importnotes.folderlist.adapter.holder.ImportFolderHolder");
        ImportFolderHolder importFolderHolder = (ImportFolderHolder) tag;
        if (importFolderHolder.getAdapterPosition() < 0) {
            return;
        }
        ImportFolderAdapterContract importFolderAdapterContract = importFolderAdapter.mContract;
        Intrinsics.checkNotNull(importFolderAdapterContract);
        ImportFolderInfo importFolderInfo = importFolderAdapterContract.getImportFolderInfo(importFolderHolder.getAdapterPosition());
        Intrinsics.checkNotNull(importFolderInfo);
        if (importFolderInfo.getType() == 1) {
            Object systemService = view.getContext().getSystemService("accessibility");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
            AccessibilityManager accessibilityManager = (AccessibilityManager) systemService;
            if (!accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled()) {
                String name = importFolderInfo.getName();
                if (name != null) {
                    importFolderAdapter.mContract.onFolderClicked(name);
                    return;
                }
                return;
            }
            if (!importFolderHolder.mAccessibilityFocused) {
                importFolderHolder.mItemContainer.post(new RunnableC4587a(view, 11));
                return;
            }
            String name2 = importFolderInfo.getName();
            if (name2 != null) {
                importFolderAdapter.mContract.onFolderClicked(name2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mFolderClickListener$lambda$5$lambda$3(View view) {
        if (view != null) {
            Object tag = view.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.app.settings.importnotes.folderlist.adapter.holder.ImportFolderHolder");
            ((ImportFolderHolder) tag).mItemContainer.performClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mLongClickListener$lambda$6(ImportFolderAdapter importFolderAdapter, View view) {
        Object tag = view.getTag();
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.app.settings.importnotes.folderlist.adapter.holder.ImportFolderHolder");
        ImportFolderHolder importFolderHolder = (ImportFolderHolder) tag;
        if (importFolderHolder.getAdapterPosition() < 0) {
            return false;
        }
        ImportFolderAdapterContract importFolderAdapterContract = importFolderAdapter.mContract;
        Intrinsics.checkNotNull(importFolderAdapterContract);
        importFolderAdapterContract.onItemLongPressed();
        CheckBox checkBox = importFolderHolder.mCheckBox;
        Intrinsics.checkNotNull(checkBox);
        if (checkBox.isChecked()) {
            return true;
        }
        importFolderAdapter.toggleItemCheckState(importFolderHolder);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$7(ImportFolderHolder importFolderHolder, View view, boolean z) {
        if (z) {
            importFolderHolder.mItemContainer.setFocusable(false);
        } else {
            importFolderHolder.mItemContainer.setFocusable(true);
        }
    }

    private final void toggleItemCheckState(ImportFolderHolder viewHolder) {
        ImportFolderAdapterContract importFolderAdapterContract = this.mContract;
        if (importFolderAdapterContract == null) {
            MainLogger.m7259w(TAG, "toggleItemCheckState# mContract is null");
            return;
        }
        ImportFolderInfo importFolderInfo = importFolderAdapterContract.getImportFolderInfo(viewHolder.getAdapterPosition());
        Intrinsics.checkNotNull(importFolderInfo);
        importFolderInfo.setChecked(!importFolderInfo.getIsChecked());
        CheckBox checkBox = viewHolder.mCheckBox;
        Intrinsics.checkNotNull(checkBox);
        checkBox.setChecked(importFolderInfo.getIsChecked());
        this.mContract.onItemChecked();
    }

    private final void updateContentDescription(ImportFolderHolder viewHolder, ImportFolderInfo fileData) {
        ImportFolderAdapterContract importFolderAdapterContract;
        String itemContainerContentDescription = null;
        String containerContentDescription = (fileData == null || (importFolderAdapterContract = this.mContract) == null) ? null : importFolderAdapterContract.getContainerContentDescription(viewHolder.mName.getText(), fileData.getType());
        if (!TextUtils.isEmpty(containerContentDescription)) {
            viewHolder.mContainer.setContentDescription(containerContentDescription);
        }
        if (fileData != null) {
            int type = fileData.getType();
            ImportFolderAdapterContract importFolderAdapterContract2 = this.mContract;
            if (importFolderAdapterContract2 != null) {
                CharSequence text = viewHolder.mName.getText();
                Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
                CharSequence text2 = viewHolder.mTime.getText();
                Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                itemContainerContentDescription = importFolderAdapterContract2.getItemContainerContentDescription(text, text2, type);
            }
        }
        if (itemContainerContentDescription == null || itemContainerContentDescription.length() == 0) {
            return;
        }
        viewHolder.mItemContainer.setContentDescription(itemContainerContentDescription);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ImportFolderAdapterContract importFolderAdapterContract = this.mContract;
        Intrinsics.checkNotNull(importFolderAdapterContract);
        return importFolderAdapterContract.getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull ImportFolderHolder viewHolder, int position) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        MainLogger.m7258i(TAG, "onBindViewHolder# " + position);
        Context context = viewHolder.itemView.getContext();
        ImportFolderAdapterContract importFolderAdapterContract = this.mContract;
        Intrinsics.checkNotNull(importFolderAdapterContract);
        ImportFolderInfo importFolderInfo = importFolderAdapterContract.getImportFolderInfo(viewHolder.getAdapterPosition());
        TextView textView = viewHolder.mName;
        Intrinsics.checkNotNull(importFolderInfo);
        textView.setText(importFolderInfo.getName());
        CheckBox checkBox = viewHolder.mCheckBox;
        Intrinsics.checkNotNull(checkBox);
        checkBox.setChecked(importFolderInfo.getIsChecked());
        viewHolder.mCheckBox.setClickable(false);
        viewHolder.mCheckBox.setFocusable(false);
        viewHolder.mItemContainer.setBackground(DrawableUtils.setRippleSelected(context));
        if (importFolderInfo.getType() == 1) {
            viewHolder.mIcon.setImageDrawable(Spr.getDrawable(context.getResources(), C8003R.drawable.myfiles_list_folder, null));
            viewHolder.mTime.setVisibility(8);
            viewHolder.mContainer.setOnClickListener(this.mFolderClickListener);
            viewHolder.mContainer.setOnLongClickListener(this.mLongClickListener);
            viewHolder.mContainer.setClickable(true);
            viewHolder.mContainer.setOnFocusChangeListener(new ViewOnFocusChangeListenerC4697c(viewHolder, 3));
            viewHolder.mContainer.setBackground(DrawableUtils.setRippleSelected(context));
            viewHolder.mContainer.setAccessibilityDelegate(this.mContainerAccessibilityDelegate);
            viewHolder.mItemContainer.setNextFocusRightId(viewHolder.mContainer.getId());
        } else {
            viewHolder.mTime.setVisibility(0);
            viewHolder.mTime.setText(ContentUtils.getDate(context, importFolderInfo.getModifiedTime()));
            viewHolder.mContainer.setFocusable(false);
            viewHolder.mContainer.setClickable(false);
            viewHolder.mContainer.setLongClickable(false);
            viewHolder.mContainer.setBackground(null);
            String name = importFolderInfo.getName();
            Intrinsics.checkNotNull(name);
            String strSubstring = name.substring(StringsKt.m14130D(name, '.') + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String lowerCase = strSubstring.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (Intrinsics.areEqual(lowerCase, "snb")) {
                viewHolder.mIcon.setImageDrawable(Spr.getDrawable(context.getResources(), C8003R.drawable.myfiles_list_snb, null));
            } else if (Intrinsics.areEqual(lowerCase, "spd")) {
                viewHolder.mIcon.setImageDrawable(Spr.getDrawable(context.getResources(), C8003R.drawable.myfiles_list_spd, null));
            } else {
                viewHolder.mIcon.setImageDrawable(Spr.getDrawable(context.getResources(), C8003R.drawable.myfiles_list_etc, null));
            }
        }
        updateContentDescription(viewHolder, importFolderInfo);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public ImportFolderHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(C8003R.layout.file_picker_item, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        ImportFolderHolder importFolderHolder = new ImportFolderHolder(viewInflate);
        importFolderHolder.mItemContainer.setAccessibilityDelegate(this.mItemAccessibilityDelegate);
        importFolderHolder.mItemContainer.setOnClickListener(this.mFileClickListener);
        importFolderHolder.mItemContainer.setOnLongClickListener(this.mLongClickListener);
        importFolderHolder.mItemContainer.setTag(importFolderHolder);
        importFolderHolder.mContainer.setTag(importFolderHolder);
        return importFolderHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NotNull ImportFolderHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        super.onViewAttachedToWindow(viewHolder);
        int adapterPosition = viewHolder.getAdapterPosition();
        ImportFolderAdapterContract importFolderAdapterContract = this.mContract;
        Intrinsics.checkNotNull(importFolderAdapterContract);
        ImportFolderInfo importFolderInfo = importFolderAdapterContract.getImportFolderInfo(adapterPosition);
        CheckBox checkBox = viewHolder.mCheckBox;
        Intrinsics.checkNotNull(checkBox);
        StateListAnimator stateListAnimator = checkBox.getStateListAnimator();
        viewHolder.mCheckBox.setStateListAnimator(null);
        CheckBox checkBox2 = viewHolder.mCheckBox;
        Intrinsics.checkNotNull(importFolderInfo);
        checkBox2.setChecked(importFolderInfo.getIsChecked());
        viewHolder.mCheckBox.setStateListAnimator(stateListAnimator);
    }
}
