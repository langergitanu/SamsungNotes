package com.samsung.android.support.senl.p148nt.app.main.oldnotes.adpater.holder;

import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.SettingsSAConstants;
import com.samsung.android.support.senl.p148nt.app.main.oldnotes.model.OldCategoryData;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p071Q2.ViewOnClickListenerC0219a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0002\u0010\u0011B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/oldnotes/adpater/holder/OldCategoryHolder;", "Lcom/samsung/android/support/senl/nt/app/main/oldnotes/adpater/holder/OldCommonHolder;", "itemView", "Landroid/view/View;", "contract", "Lcom/samsung/android/support/senl/nt/app/main/oldnotes/adpater/holder/OldCategoryHolder$Contract;", "<init>", "(Landroid/view/View;Lcom/samsung/android/support/senl/nt/app/main/oldnotes/adpater/holder/OldCategoryHolder$Contract;)V", "decorateItemView", "", "data", "Lcom/samsung/android/support/senl/nt/app/main/oldnotes/model/OldCategoryData;", "isLastOldCategory", "", "getType", "", "Contract", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class OldCategoryHolder extends OldCommonHolder {

    @NotNull
    public static final String TAG = "OldCategoryHolder";

    @NotNull
    private Contract contract;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/oldnotes/adpater/holder/OldCategoryHolder$Contract;", "", "onItemSelected", "", "categoryUuid", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        void onItemSelected(@Nullable String categoryUuid);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OldCategoryHolder(@NotNull View itemView, @NotNull Contract contract) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(contract, "contract");
        this.contract = contract;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void decorateItemView$lambda$0(OldCategoryHolder oldCategoryHolder, OldCategoryData oldCategoryData, View view) {
        CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_OLDNOTES, "1080");
        Contract contract = oldCategoryHolder.contract;
        Intrinsics.checkNotNull(contract);
        contract.onItemSelected(oldCategoryData.getCategoryUuid());
    }

    public final void decorateItemView(@NotNull OldCategoryData data, boolean isLastOldCategory) {
        Intrinsics.checkNotNullParameter(data, "data");
        ImageView imageView = (ImageView) this.itemView.findViewById(C8003R.id.mark_color);
        TextView textView = (TextView) this.itemView.findViewById(C8003R.id.category_title);
        TextView textView2 = (TextView) this.itemView.findViewById(C8003R.id.category_count);
        int displayNameColor = data.getDisplayNameColor();
        String displayName = data.getDisplayName();
        if (Intrinsics.areEqual("2", data.getCategoryUuid())) {
            displayNameColor = this.itemView.getResources().getColor(C8003R.color.category_mark_color_screen_off_memo, null);
        } else if (Intrinsics.areEqual("1", data.getCategoryUuid()) || displayNameColor == -1) {
            displayNameColor = this.itemView.getResources().getColor(C8003R.color.category_mark_color_background_uncategorized, null);
        }
        if (Intrinsics.areEqual("1", data.getCategoryUuid())) {
            displayName = this.itemView.getResources().getString(C8003R.string.uncategorised);
        } else if (Intrinsics.areEqual("2", data.getCategoryUuid())) {
            displayName = this.itemView.getResources().getString(C8003R.string.string_screen_off_memo);
        }
        imageView.setColorFilter(displayNameColor, PorterDuff.Mode.SRC_ATOP);
        textView.setText(displayName);
        textView2.setText(ContentUtils.convertToArabicNumber(data.getDocumentCount()));
        this.itemView.setOnClickListener(new ViewOnClickListenerC0219a(this, data, 0));
        MainLogger.m7254d(TAG, "decorateItemView# entry : " + MainLogger.getEncode(data.getDisplayName()) + " " + data.getDocumentCount());
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.oldnotes.adpater.holder.OldCommonHolder
    public int getType() {
        return 0;
    }
}
