package com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.presenter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.CoeditInvitationHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.CoeditSpaceHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.DeleteConvertedNotesMessageHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.DummyHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.FolderExpandBarHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.GridSmallViewHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.GridViewHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.ListViewHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.RecylebinMessageHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.RelatedHashTagListHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.SOMRecognizedCardHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.SearchFilterHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.SimpleViewHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.SimpleViewNoThumbnailHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.SsmProgressBarHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.SubFolderHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.SubHeaderHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.SyncProgressBarHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.TipCardHolder;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0007J$\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/adapter/presenter/ViewHolderFactory;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "createHolder", "Lcom/samsung/android/support/senl/nt/app/main/common/adapter/CommonHolder;", "viewGroup", "Landroid/view/ViewGroup;", "inflatedView", "Landroid/view/View;", "viewType", "", "subFolderColumn", "viewMode", "onCreateNoteHolder", "itemView", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ViewHolderFactory {

    @NotNull
    public static final ViewHolderFactory INSTANCE = new ViewHolderFactory();

    @NotNull
    private static final String TAG = "ViewHolderFactory";

    private ViewHolderFactory() {
    }

    @JvmStatic
    @Nullable
    public static final CommonHolder createHolder(@NotNull ViewGroup viewGroup, @Nullable View inflatedView, int viewType, int subFolderColumn, int viewMode) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        if (viewType != 1 && viewType != 2) {
            switch (viewType) {
                case 4:
                case 8:
                case 16:
                case 32:
                case 64:
                case 256:
                case 512:
                case 1024:
                    break;
                case 2048:
                    return INSTANCE.onCreateNoteHolder(viewGroup, inflatedView, viewMode);
                case 4096:
                    if (inflatedView == null) {
                        inflatedView = LayoutInflater.from(viewGroup.getContext()).inflate(C8003R.layout.notes_subheader_holder, viewGroup, false);
                        MainLogger.m7254d(TAG, "onCreateViewHolder - inflate subHeader");
                    } else {
                        MainLogger.m7254d(TAG, "onCreateViewHolder - already inflated subHeader");
                    }
                    Intrinsics.checkNotNull(inflatedView);
                    return new SubHeaderHolder(inflatedView, viewMode);
                case 8192:
                    return new CoeditSpaceHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C8003R.layout.notes_coedit_space_holder, viewGroup, false), viewMode);
                case 16384:
                    return new TipCardHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C8003R.layout.tipcard_viewpager, viewGroup, false), viewMode);
                case 32768:
                    return new SsmProgressBarHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C8003R.layout.notes_ssm_progress_holder, viewGroup, false), viewMode);
                case 65536:
                    return new RelatedHashTagListHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C8003R.layout.notes_related_hash_tag_list_holder, viewGroup, false), viewMode);
                case 131072:
                    return new CoeditInvitationHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C8003R.layout.notes_coedit_invitation_holder, viewGroup, false), viewMode);
                case 262144:
                    View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(C8003R.layout.som_recognized_card_view, viewGroup, false);
                    Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
                    return new SOMRecognizedCardHolder(viewInflate, viewMode);
                case 524288:
                    return new SyncProgressBarHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C8003R.layout.notes_sync_progress_holder, viewGroup, false), viewMode);
                case 2097152:
                    View viewInflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(C8003R.layout.search_filter_layout, viewGroup, false);
                    Intrinsics.checkNotNullExpressionValue(viewInflate2, "inflate(...)");
                    return new SearchFilterHolder(viewInflate2, viewMode);
                case 4194304:
                    View viewInflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(C8003R.layout.expand_bar_holder, viewGroup, false);
                    Intrinsics.checkNotNullExpressionValue(viewInflate3, "inflate(...)");
                    return new FolderExpandBarHolder(viewInflate3, viewMode);
                case 16777216:
                    View viewInflate4 = LayoutInflater.from(viewGroup.getContext()).inflate(C8003R.layout.recyclebin_message, viewGroup, false);
                    Intrinsics.checkNotNullExpressionValue(viewInflate4, "inflate(...)");
                    return new RecylebinMessageHolder(viewInflate4, viewMode);
                case 33554432:
                    return new DeleteConvertedNotesMessageHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C8003R.layout.delete_converted_notes_message, viewGroup, false), viewMode);
                default:
                    return new DummyHolder(viewGroup, viewMode);
            }
        }
        View viewInflate5 = LayoutInflater.from(viewGroup.getContext()).inflate(C8003R.layout.sub_folder_list_layout, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate5, "inflate(...)");
        return new SubFolderHolder(viewInflate5, viewMode, subFolderColumn);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final CommonHolder onCreateNoteHolder(ViewGroup viewGroup, View itemView, int viewMode) {
        if (itemView == null) {
            if (viewMode == 1) {
                itemView = LayoutInflater.from(viewGroup.getContext()).inflate(C8003R.layout.notes_list_item, viewGroup, false);
            } else if (viewMode == 2) {
                itemView = LayoutInflater.from(viewGroup.getContext()).inflate(C8003R.layout.notes_grid_item, viewGroup, false);
            } else if (viewMode == 3) {
                itemView = LayoutInflater.from(viewGroup.getContext()).inflate(C8003R.layout.notes_simple_item, viewGroup, false);
            } else if (viewMode != 4) {
                if (viewMode == 6) {
                    itemView = LayoutInflater.from(viewGroup.getContext()).inflate(C8003R.layout.notes_simple_item_no_thumbnail, viewGroup, false);
                }
            }
            MainLogger.m7254d(TAG, "onCreateNoteHolder - inflate");
        } else {
            MainLogger.m7254d(TAG, "onCreateNoteHolder - already inflated");
        }
        if (viewMode == 1) {
            return new ListViewHolder(itemView);
        }
        if (viewMode == 2) {
            return new GridViewHolder(itemView);
        }
        if (viewMode == 3) {
            return new SimpleViewHolder(itemView);
        }
        if (viewMode == 4) {
            return new GridSmallViewHolder(itemView);
        }
        if (viewMode != 6) {
            return null;
        }
        return new SimpleViewNoThumbnailHolder(itemView);
    }
}
