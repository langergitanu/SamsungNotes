package com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holderinfo;

import android.view.View;
import android.widget.TextView;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p148nt.app.common.widget.HoverPopupTextView;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b6\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0013\u0010\u0014J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0006HÆ\u0003J\t\u00108\u001a\u00020\u0006HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0091\u0001\u0010A\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010B\u001a\u00020\u00062\b\u0010C\u001a\u0004\u0018\u00010DHÖ\u0003J\t\u0010E\u001a\u00020\u0003HÖ\u0001J\t\u0010F\u001a\u00020GHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u001b\"\u0004\b\u001e\u0010\u001dR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010 \"\u0004\b,\u0010\"R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010 \"\u0004\b.\u0010\"R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010 \"\u0004\b0\u0010\"R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010 \"\u0004\b2\u0010\"R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010 \"\u0004\b4\u0010\"¨\u0006H"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/adapter/holderinfo/SubFolderHolderInfo;", "Lcom/samsung/android/support/senl/nt/app/main/common/adapter/CommonHolderInfo;", "index", "", "color", "isOldCategory", "", "isShowWithAnimation", "subFolderContainer", "Landroid/view/View;", "titleTextView", "Lcom/samsung/android/support/senl/nt/app/common/widget/HoverPopupTextView;", "countTextView", "Landroid/widget/TextView;", "folderIcon", "folderPaper", "folderShadow", "newBadge", "msIcon", "<init>", "(IIZZLandroid/view/View;Lcom/samsung/android/support/senl/nt/app/common/widget/HoverPopupTextView;Landroid/widget/TextView;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;)V", "getIndex", "()I", "setIndex", "(I)V", "getColor", "setColor", "()Z", "setOldCategory", "(Z)V", "setShowWithAnimation", "getSubFolderContainer", "()Landroid/view/View;", "setSubFolderContainer", "(Landroid/view/View;)V", "getTitleTextView", "()Lcom/samsung/android/support/senl/nt/app/common/widget/HoverPopupTextView;", "setTitleTextView", "(Lcom/samsung/android/support/senl/nt/app/common/widget/HoverPopupTextView;)V", "getCountTextView", "()Landroid/widget/TextView;", "setCountTextView", "(Landroid/widget/TextView;)V", "getFolderIcon", "setFolderIcon", "getFolderPaper", "setFolderPaper", "getFolderShadow", "setFolderShadow", "getNewBadge", "setNewBadge", "getMsIcon", "setMsIcon", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "", "hashCode", "toString", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final /* data */ class SubFolderHolderInfo extends CommonHolderInfo {
    private int color;

    @Nullable
    private TextView countTextView;

    @Nullable
    private View folderIcon;

    @Nullable
    private View folderPaper;

    @Nullable
    private View folderShadow;
    private int index;
    private boolean isOldCategory;
    private boolean isShowWithAnimation;

    @Nullable
    private View msIcon;

    @Nullable
    private View newBadge;

    @Nullable
    private View subFolderContainer;

    @Nullable
    private HoverPopupTextView titleTextView;

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ SubFolderHolderInfo(int r16, int r17, boolean r18, boolean r19, android.view.View r20, com.samsung.android.support.senl.p148nt.app.common.widget.HoverPopupTextView r21, android.widget.TextView r22, android.view.View r23, android.view.View r24, android.view.View r25, android.view.View r26, android.view.View r27, int r28, kotlin.jvm.internal.DefaultConstructorMarker r29) {
        /*
            r15 = this;
            r0 = r28
            r1 = r0 & 8
            if (r1 == 0) goto L9
            r1 = 0
            r6 = r1
            goto Lb
        L9:
            r6 = r19
        Lb:
            r1 = r0 & 16
            r2 = 0
            if (r1 == 0) goto L12
            r7 = r2
            goto L14
        L12:
            r7 = r20
        L14:
            r1 = r0 & 32
            if (r1 == 0) goto L1a
            r8 = r2
            goto L1c
        L1a:
            r8 = r21
        L1c:
            r1 = r0 & 64
            if (r1 == 0) goto L22
            r9 = r2
            goto L24
        L22:
            r9 = r22
        L24:
            r1 = r0 & 128(0x80, float:1.8E-43)
            if (r1 == 0) goto L2a
            r10 = r2
            goto L2c
        L2a:
            r10 = r23
        L2c:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L32
            r11 = r2
            goto L34
        L32:
            r11 = r24
        L34:
            r1 = r0 & 512(0x200, float:7.17E-43)
            if (r1 == 0) goto L3a
            r12 = r2
            goto L3c
        L3a:
            r12 = r25
        L3c:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L42
            r13 = r2
            goto L44
        L42:
            r13 = r26
        L44:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L51
            r14 = r2
            r3 = r16
            r4 = r17
            r5 = r18
            r2 = r15
            goto L5a
        L51:
            r14 = r27
            r2 = r15
            r3 = r16
            r4 = r17
            r5 = r18
        L5a:
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holderinfo.SubFolderHolderInfo.<init>(int, int, boolean, boolean, android.view.View, com.samsung.android.support.senl.nt.app.common.widget.HoverPopupTextView, android.widget.TextView, android.view.View, android.view.View, android.view.View, android.view.View, android.view.View, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static /* synthetic */ SubFolderHolderInfo copy$default(SubFolderHolderInfo subFolderHolderInfo, int i, int i2, boolean z, boolean z2, View view, HoverPopupTextView hoverPopupTextView, TextView textView, View view2, View view3, View view4, View view5, View view6, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = subFolderHolderInfo.index;
        }
        if ((i4 & 2) != 0) {
            i2 = subFolderHolderInfo.color;
        }
        if ((i4 & 4) != 0) {
            z = subFolderHolderInfo.isOldCategory;
        }
        if ((i4 & 8) != 0) {
            z2 = subFolderHolderInfo.isShowWithAnimation;
        }
        if ((i4 & 16) != 0) {
            view = subFolderHolderInfo.subFolderContainer;
        }
        if ((i4 & 32) != 0) {
            hoverPopupTextView = subFolderHolderInfo.titleTextView;
        }
        if ((i4 & 64) != 0) {
            textView = subFolderHolderInfo.countTextView;
        }
        if ((i4 & 128) != 0) {
            view2 = subFolderHolderInfo.folderIcon;
        }
        if ((i4 & 256) != 0) {
            view3 = subFolderHolderInfo.folderPaper;
        }
        if ((i4 & 512) != 0) {
            view4 = subFolderHolderInfo.folderShadow;
        }
        if ((i4 & 1024) != 0) {
            view5 = subFolderHolderInfo.newBadge;
        }
        if ((i4 & 2048) != 0) {
            view6 = subFolderHolderInfo.msIcon;
        }
        View view7 = view5;
        View view8 = view6;
        View view9 = view3;
        View view10 = view4;
        TextView textView2 = textView;
        View view11 = view2;
        View view12 = view;
        HoverPopupTextView hoverPopupTextView2 = hoverPopupTextView;
        return subFolderHolderInfo.copy(i, i2, z, z2, view12, hoverPopupTextView2, textView2, view11, view9, view10, view7, view8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final View getFolderShadow() {
        return this.folderShadow;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final View getNewBadge() {
        return this.newBadge;
    }

    @Nullable
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final View getMsIcon() {
        return this.msIcon;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsOldCategory() {
        return this.isOldCategory;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsShowWithAnimation() {
        return this.isShowWithAnimation;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final View getSubFolderContainer() {
        return this.subFolderContainer;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final HoverPopupTextView getTitleTextView() {
        return this.titleTextView;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final TextView getCountTextView() {
        return this.countTextView;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final View getFolderIcon() {
        return this.folderIcon;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final View getFolderPaper() {
        return this.folderPaper;
    }

    @NotNull
    public final SubFolderHolderInfo copy(int index, int color, boolean isOldCategory, boolean isShowWithAnimation, @Nullable View subFolderContainer, @Nullable HoverPopupTextView titleTextView, @Nullable TextView countTextView, @Nullable View folderIcon, @Nullable View folderPaper, @Nullable View folderShadow, @Nullable View newBadge, @Nullable View msIcon) {
        return new SubFolderHolderInfo(index, color, isOldCategory, isShowWithAnimation, subFolderContainer, titleTextView, countTextView, folderIcon, folderPaper, folderShadow, newBadge, msIcon);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubFolderHolderInfo)) {
            return false;
        }
        SubFolderHolderInfo subFolderHolderInfo = (SubFolderHolderInfo) other;
        return this.index == subFolderHolderInfo.index && this.color == subFolderHolderInfo.color && this.isOldCategory == subFolderHolderInfo.isOldCategory && this.isShowWithAnimation == subFolderHolderInfo.isShowWithAnimation && Intrinsics.areEqual(this.subFolderContainer, subFolderHolderInfo.subFolderContainer) && Intrinsics.areEqual(this.titleTextView, subFolderHolderInfo.titleTextView) && Intrinsics.areEqual(this.countTextView, subFolderHolderInfo.countTextView) && Intrinsics.areEqual(this.folderIcon, subFolderHolderInfo.folderIcon) && Intrinsics.areEqual(this.folderPaper, subFolderHolderInfo.folderPaper) && Intrinsics.areEqual(this.folderShadow, subFolderHolderInfo.folderShadow) && Intrinsics.areEqual(this.newBadge, subFolderHolderInfo.newBadge) && Intrinsics.areEqual(this.msIcon, subFolderHolderInfo.msIcon);
    }

    public final int getColor() {
        return this.color;
    }

    @Nullable
    public final TextView getCountTextView() {
        return this.countTextView;
    }

    @Nullable
    public final View getFolderIcon() {
        return this.folderIcon;
    }

    @Nullable
    public final View getFolderPaper() {
        return this.folderPaper;
    }

    @Nullable
    public final View getFolderShadow() {
        return this.folderShadow;
    }

    public final int getIndex() {
        return this.index;
    }

    @Nullable
    public final View getMsIcon() {
        return this.msIcon;
    }

    @Nullable
    public final View getNewBadge() {
        return this.newBadge;
    }

    @Nullable
    public final View getSubFolderContainer() {
        return this.subFolderContainer;
    }

    @Nullable
    public final HoverPopupTextView getTitleTextView() {
        return this.titleTextView;
    }

    public int hashCode() {
        int iM1160f = AbstractC0622a.m1160f(this.isShowWithAnimation, AbstractC0622a.m1160f(this.isOldCategory, AbstractC0622a.m1157c(this.color, Integer.hashCode(this.index) * 31, 31), 31), 31);
        View view = this.subFolderContainer;
        int iHashCode = (iM1160f + (view == null ? 0 : view.hashCode())) * 31;
        HoverPopupTextView hoverPopupTextView = this.titleTextView;
        int iHashCode2 = (iHashCode + (hoverPopupTextView == null ? 0 : hoverPopupTextView.hashCode())) * 31;
        TextView textView = this.countTextView;
        int iHashCode3 = (iHashCode2 + (textView == null ? 0 : textView.hashCode())) * 31;
        View view2 = this.folderIcon;
        int iHashCode4 = (iHashCode3 + (view2 == null ? 0 : view2.hashCode())) * 31;
        View view3 = this.folderPaper;
        int iHashCode5 = (iHashCode4 + (view3 == null ? 0 : view3.hashCode())) * 31;
        View view4 = this.folderShadow;
        int iHashCode6 = (iHashCode5 + (view4 == null ? 0 : view4.hashCode())) * 31;
        View view5 = this.newBadge;
        int iHashCode7 = (iHashCode6 + (view5 == null ? 0 : view5.hashCode())) * 31;
        View view6 = this.msIcon;
        return iHashCode7 + (view6 != null ? view6.hashCode() : 0);
    }

    public final boolean isOldCategory() {
        return this.isOldCategory;
    }

    public final boolean isShowWithAnimation() {
        return this.isShowWithAnimation;
    }

    public final void setColor(int i) {
        this.color = i;
    }

    public final void setCountTextView(@Nullable TextView textView) {
        this.countTextView = textView;
    }

    public final void setFolderIcon(@Nullable View view) {
        this.folderIcon = view;
    }

    public final void setFolderPaper(@Nullable View view) {
        this.folderPaper = view;
    }

    public final void setFolderShadow(@Nullable View view) {
        this.folderShadow = view;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public final void setMsIcon(@Nullable View view) {
        this.msIcon = view;
    }

    public final void setNewBadge(@Nullable View view) {
        this.newBadge = view;
    }

    public final void setOldCategory(boolean z) {
        this.isOldCategory = z;
    }

    public final void setShowWithAnimation(boolean z) {
        this.isShowWithAnimation = z;
    }

    public final void setSubFolderContainer(@Nullable View view) {
        this.subFolderContainer = view;
    }

    public final void setTitleTextView(@Nullable HoverPopupTextView hoverPopupTextView) {
        this.titleTextView = hoverPopupTextView;
    }

    @NotNull
    public String toString() {
        int i = this.index;
        int i2 = this.color;
        boolean z = this.isOldCategory;
        boolean z2 = this.isShowWithAnimation;
        View view = this.subFolderContainer;
        HoverPopupTextView hoverPopupTextView = this.titleTextView;
        TextView textView = this.countTextView;
        View view2 = this.folderIcon;
        View view3 = this.folderPaper;
        View view4 = this.folderShadow;
        View view5 = this.newBadge;
        View view6 = this.msIcon;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "SubFolderHolderInfo(index=", ", color=", ", isOldCategory=");
        AbstractC2821a.m2208C(sbM1173s, z, ", isShowWithAnimation=", z2, ", subFolderContainer=");
        sbM1173s.append(view);
        sbM1173s.append(", titleTextView=");
        sbM1173s.append(hoverPopupTextView);
        sbM1173s.append(", countTextView=");
        sbM1173s.append(textView);
        sbM1173s.append(", folderIcon=");
        sbM1173s.append(view2);
        sbM1173s.append(", folderPaper=");
        sbM1173s.append(view3);
        sbM1173s.append(", folderShadow=");
        sbM1173s.append(view4);
        sbM1173s.append(", newBadge=");
        sbM1173s.append(view5);
        sbM1173s.append(", msIcon=");
        sbM1173s.append(view6);
        sbM1173s.append(")");
        return sbM1173s.toString();
    }

    public SubFolderHolderInfo(int i, int i2, boolean z, boolean z2, @Nullable View view, @Nullable HoverPopupTextView hoverPopupTextView, @Nullable TextView textView, @Nullable View view2, @Nullable View view3, @Nullable View view4, @Nullable View view5, @Nullable View view6) {
        this.index = i;
        this.color = i2;
        this.isOldCategory = z;
        this.isShowWithAnimation = z2;
        this.subFolderContainer = view;
        this.titleTextView = hoverPopupTextView;
        this.countTextView = textView;
        this.folderIcon = view2;
        this.folderPaper = view3;
        this.folderShadow = view4;
        this.newBadge = view5;
        this.msIcon = view6;
    }
}
