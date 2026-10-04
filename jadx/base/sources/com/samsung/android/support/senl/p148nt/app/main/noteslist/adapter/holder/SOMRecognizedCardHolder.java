package com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder;

import android.view.View;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.pen.setting.colorpalette.ViewOnClickListenerC7538b;
import com.samsung.android.sdk.scs.p142ai.language.C7737b;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.badge.BadgeHelper;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.Common;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.SOMRecognizedInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.StateInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.widget.somrecognizedcard.SOMRecognizedCardExpandCollapseBtn;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.widget.somrecognizedcard.SOMRecognizedList;
import com.samsung.android.support.senl.p148nt.app.sync.cloudsettings.callee.NotesSyncRpcProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\u000e\u001a\u00020\u0005J\b\u0010\u000f\u001a\u00020\tH\u0002J\u0006\u0010\u0010\u001a\u00020\tJ\u0012\u0010\u0011\u001a\u00020\t2\b\b\u0001\u0010\u000e\u001a\u00020\u0005H\u0002J\u0006\u0010\u0012\u001a\u00020\tJ\u001a\u0010\u0013\u001a\u00020\t2\b\b\u0001\u0010\u0014\u001a\u00020\u00052\b\b\u0001\u0010\u000e\u001a\u00020\u0005J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0006\u0010\u0017\u001a\u00020\tJ\u0010\u0010\u0018\u001a\u00020\t2\b\b\u0001\u0010\u000e\u001a\u00020\u0005J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0016H\u0002J\u0012\u0010\u001b\u001a\u00020\t2\b\b\u0001\u0010\u000e\u001a\u00020\u0005H\u0002J\u0012\u0010\u001c\u001a\u00020\t2\b\b\u0001\u0010\u000e\u001a\u00020\u0005H\u0002J\u001c\u0010\u001d\u001a\u00020\t2\b\b\u0001\u0010\u0014\u001a\u00020\u00052\b\b\u0001\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u001e\u001a\u00020\tH\u0002J\u001a\u0010\u001f\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\u0016H\u0002J\u0010\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u0001H\u0016J\u0010\u00100\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u0001H\u0016J\b\u00101\u001a\u00020\tH\u0002R\u0016\u0010#\u001a\u0004\u0018\u00010$8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0016\u0010'\u001a\u0004\u0018\u00010(8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0016\u0010+\u001a\u0004\u0018\u00010\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u00062"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/adapter/holder/SOMRecognizedCardHolder;", "Lcom/samsung/android/support/senl/nt/app/main/common/adapter/CommonHolder;", "itemView", "Landroid/view/View;", "viewMode", "", "<init>", "(Landroid/view/View;I)V", "decorate", "", "holderData", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/model/Common;", "stateInfo", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/model/StateInfo;", "cardShape", "decorateNoteOrganizeInfo", "decorateRunningState", "decorateSOMRecognizedCardLayout", "onListScrollStateChangeToIdle", "onCardShapeChanged", "prevCardShape", "isSOMRecognitionStateProgressing", "", "decorateNewBadge", "updateLayout", "updateRunningState", "isRecognizeTextInfoRunning", "updateExpandCollapseBtn", "animateExpandCollapseBtn", "animateLayoutHeight", "updateSOMRecognizedInfo", "handlePendedNotify", NotesConstants.KEY_CALLER, "", NotesSyncRpcProvider.FORCE_SYNC, "somRecognizedList", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/view/widget/somrecognizedcard/SOMRecognizedList;", "getSomRecognizedList", "()Lcom/samsung/android/support/senl/nt/app/main/noteslist/view/widget/somrecognizedcard/SOMRecognizedList;", "expandCollapseBtn", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/view/widget/somrecognizedcard/SOMRecognizedCardExpandCollapseBtn;", "getExpandCollapseBtn", "()Lcom/samsung/android/support/senl/nt/app/main/noteslist/view/widget/somrecognizedcard/SOMRecognizedCardExpandCollapseBtn;", "newBadge", "getNewBadge", "()Landroid/view/View;", "onViewAttachedToWindow", "commonHolder", "onViewDetachedFromWindow", "toggleSOMRecognizedCardExpandCollapseState", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SOMRecognizedCardHolder extends CommonHolder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SOMRecognizedCardHolder(@NotNull View itemView, int i) {
        super(itemView, i);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        setHolderType(262144);
        itemView.findViewById(C8003R.id.som_recognized_list_header_container).setOnClickListener(new ViewOnClickListenerC7538b(this, 28));
        SOMRecognizedList somRecognizedList = getSomRecognizedList();
        if (somRecognizedList != null) {
            somRecognizedList.setContract(new SOMRecognizedList.Contract() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.adapter.holder.SOMRecognizedCardHolder.2
                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.widget.somrecognizedcard.SOMRecognizedList.Contract
                public int getNoteListHeight() {
                    AdapterContract adapterContract = SOMRecognizedCardHolder.this.getMAdapterContract();
                    if (adapterContract != null) {
                        return adapterContract.getNoteListHeight();
                    }
                    return 0;
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.widget.somrecognizedcard.SOMRecognizedList.Contract
                public List<SOMRecognizedInfo> getSOMRecognizedInfo() {
                    List<SOMRecognizedInfo> sOMRecognizedInfo;
                    AdapterContract adapterContract = SOMRecognizedCardHolder.this.getMAdapterContract();
                    return (adapterContract == null || (sOMRecognizedInfo = adapterContract.getSOMRecognizedInfo()) == null) ? CollectionsKt.emptyList() : sOMRecognizedInfo;
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.widget.somrecognizedcard.SOMRecognizedList.Contract
                public boolean isNotifyPendingRequired() {
                    AdapterContract adapterContract = SOMRecognizedCardHolder.this.getMAdapterContract();
                    if (adapterContract != null) {
                        return adapterContract.isSOMDataChangeNotifyPendingRequired();
                    }
                    return false;
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.widget.somrecognizedcard.SOMRecognizedList.Contract
                public void onNoteSelectedBySOMRecognizedCard(String uuid, int toolType) {
                    Intrinsics.checkNotNullParameter(uuid, "uuid");
                    AdapterContract adapterContract = SOMRecognizedCardHolder.this.getMAdapterContract();
                    if (adapterContract != null) {
                        adapterContract.onNoteSelectedBySOMRecognizedCard(uuid, toolType);
                    }
                }
            });
        }
        SOMRecognizedCardExpandCollapseBtn expandCollapseBtn = getExpandCollapseBtn();
        if (expandCollapseBtn != null) {
            expandCollapseBtn.setContract(new C7737b(this, 13));
        }
    }

    private final void animateExpandCollapseBtn(@NotesConstants.SOMRecognizedCardShape int cardShape) {
        SOMRecognizedCardExpandCollapseBtn expandCollapseBtn = getExpandCollapseBtn();
        if (expandCollapseBtn != null) {
            expandCollapseBtn.animateExpandCollapseBtn(cardShape == 0);
        }
    }

    private final void animateLayoutHeight(@NotesConstants.SOMRecognizedCardShape int prevCardShape, @NotesConstants.SOMRecognizedCardShape int cardShape) {
        SOMRecognizedList somRecognizedList = getSomRecognizedList();
        if (somRecognizedList != null) {
            somRecognizedList.animateLayoutHeight(prevCardShape, cardShape);
        }
    }

    private final void decorateNoteOrganizeInfo() {
        updateSOMRecognizedInfo();
    }

    private final void decorateSOMRecognizedCardLayout(@NotesConstants.SOMRecognizedCardShape int cardShape) {
        updateLayout(cardShape);
    }

    private final SOMRecognizedCardExpandCollapseBtn getExpandCollapseBtn() {
        return (SOMRecognizedCardExpandCollapseBtn) this.itemView.findViewById(C8003R.id.fixed_expand_collapse_btn_container);
    }

    private final View getNewBadge() {
        return this.itemView.findViewById(C8003R.id.new_badge);
    }

    private final SOMRecognizedList getSomRecognizedList() {
        return (SOMRecognizedList) this.itemView.findViewById(C8003R.id.som_recognized_list_container);
    }

    private final void handlePendedNotify(String caller, boolean force) {
        SOMRecognizedList somRecognizedList = getSomRecognizedList();
        if (somRecognizedList != null) {
            somRecognizedList.handlePendedNotify(caller, force);
        }
    }

    private final boolean isSOMRecognitionStateProgressing() {
        AdapterContract adapterContract = getMAdapterContract();
        if (adapterContract != null) {
            return adapterContract.isSOMRecognitionStateProgressing();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toggleSOMRecognizedCardExpandCollapseState() {
        AdapterContract adapterContract = getMAdapterContract();
        if (adapterContract != null) {
            adapterContract.toggleSOMRecognizedCardExpandCollapseState();
        }
    }

    private final void updateExpandCollapseBtn(@NotesConstants.SOMRecognizedCardShape int cardShape) {
        SOMRecognizedCardExpandCollapseBtn expandCollapseBtn = getExpandCollapseBtn();
        if (expandCollapseBtn != null) {
            expandCollapseBtn.updateExpandCollapseBtn(cardShape == 0);
        }
    }

    private final void updateRunningState(boolean isRecognizeTextInfoRunning) {
        SOMRecognizedCardExpandCollapseBtn expandCollapseBtn = getExpandCollapseBtn();
        if (expandCollapseBtn != null) {
            expandCollapseBtn.updateRunningState(isRecognizeTextInfoRunning);
        }
        SOMRecognizedList somRecognizedList = getSomRecognizedList();
        if (somRecognizedList != null) {
            somRecognizedList.updateRunningState(isRecognizeTextInfoRunning);
        }
    }

    private final void updateSOMRecognizedInfo() {
        SOMRecognizedList somRecognizedList = getSomRecognizedList();
        if (somRecognizedList != null) {
            somRecognizedList.updateSOMRecognizedInfo();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder
    public void decorate(@Nullable Common holderData, @Nullable StateInfo stateInfo) {
        decorate(stateInfo != null ? stateInfo.getSOMRecognizedCardShape() : 0);
    }

    public final void decorateNewBadge() {
        View newBadge = getNewBadge();
        if (newBadge != null) {
            newBadge.setVisibility(BadgeHelper.hasSOMFolderNewBadge() ? 0 : 8);
        }
    }

    public final void decorateRunningState() {
        updateRunningState(isSOMRecognitionStateProgressing());
    }

    public final void onCardShapeChanged(@NotesConstants.SOMRecognizedCardShape int prevCardShape, @NotesConstants.SOMRecognizedCardShape int cardShape) {
        handlePendedNotify(AbstractC0541b.m767i(cardShape, "onCardShapeChanged(", ")"), true);
        animateExpandCollapseBtn(cardShape);
        animateLayoutHeight(prevCardShape, cardShape);
    }

    public final void onListScrollStateChangeToIdle() {
        handlePendedNotify("onListScrollStateChangeToIdle", false);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder
    public void onViewAttachedToWindow(@NotNull CommonHolder commonHolder) {
        Intrinsics.checkNotNullParameter(commonHolder, "commonHolder");
        super.onViewAttachedToWindow(commonHolder);
        AdapterContract adapterContract = getMAdapterContract();
        if (adapterContract != null) {
            adapterContract.onSOMRecognizedCardAttachedToWindow();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder
    public void onViewDetachedFromWindow(@NotNull CommonHolder commonHolder) {
        Intrinsics.checkNotNullParameter(commonHolder, "commonHolder");
        AdapterContract adapterContract = getMAdapterContract();
        if (adapterContract != null) {
            adapterContract.onSOMRecognizedCardDetachedFromWindow();
        }
        super.onViewDetachedFromWindow(commonHolder);
    }

    public final void updateLayout(@NotesConstants.SOMRecognizedCardShape int cardShape) {
        updateExpandCollapseBtn(cardShape);
        SOMRecognizedList somRecognizedList = getSomRecognizedList();
        if (somRecognizedList != null) {
            somRecognizedList.updateLayout(cardShape);
        }
    }

    public final void decorate(@NotesConstants.SOMRecognizedCardShape int cardShape) {
        decorateNoteOrganizeInfo();
        decorateRunningState();
        decorateNewBadge();
        decorateSOMRecognizedCardLayout(cardShape);
    }
}
