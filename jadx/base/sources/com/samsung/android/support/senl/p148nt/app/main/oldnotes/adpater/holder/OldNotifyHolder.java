package com.samsung.android.support.senl.p148nt.app.main.oldnotes.adpater.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import p071Q2.ViewOnClickListenerC0220b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0002\u0014\u0015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\u0013\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/oldnotes/adpater/holder/OldNotifyHolder;", "Lcom/samsung/android/support/senl/nt/app/main/oldnotes/adpater/holder/OldCommonHolder;", "itemView", "Landroid/view/View;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/app/main/oldnotes/adpater/holder/OldNotifyHolder$Contract;", "<init>", "(Landroid/view/View;Lcom/samsung/android/support/senl/nt/app/main/oldnotes/adpater/holder/OldNotifyHolder$Contract;)V", "decorateItemView", "", "type", "", "isVisible", "", "margin", DynamicActionBarProvider.METHOD_GET_DATA, "", "getMessage", "getButtonMessage", "getType", "Contract", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nOldNotifyHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OldNotifyHolder.kt\ncom/samsung/android/support/senl/nt/app/main/oldnotes/adpater/holder/OldNotifyHolder\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,83:1\n348#2:84\n*S KotlinDebug\n*F\n+ 1 OldNotifyHolder.kt\ncom/samsung/android/support/senl/nt/app/main/oldnotes/adpater/holder/OldNotifyHolder\n*L\n40#1:84\n*E\n"})
public final class OldNotifyHolder extends OldCommonHolder {

    @NotNull
    public static final String TAG = "OldCategoryNotifyHolder";
    public static final int TYPE_CHECK = 2;
    public static final int TYPE_CONVERT = 1;
    public static final int TYPE_INVALID = 0;

    @NotNull
    private final Contract listener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/oldnotes/adpater/holder/OldNotifyHolder$Contract;", "", "onNotifyBtnClicked", "", "type", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        void onNotifyBtnClicked(int type);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OldNotifyHolder(@NotNull View itemView, @NotNull Contract listener) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void decorateItemView$lambda$0(OldNotifyHolder oldNotifyHolder, int i, View view) {
        oldNotifyHolder.listener.onNotifyBtnClicked(i);
    }

    private final String getButtonMessage(int type) {
        if (type == 1) {
            String string = this.itemView.getResources().getString(C8003R.string.convert_all_to_new_format);
            Intrinsics.checkNotNull(string);
            return string;
        }
        String string2 = this.itemView.getResources().getString(C8003R.string.tipcard_check_converted_notes_positive_btn);
        Intrinsics.checkNotNull(string2);
        return string2;
    }

    private final String getMessage(int type) {
        if (type == 1) {
            return AbstractC0541b.m757C(this.itemView.getResources().getString(C8003R.string.tipcard_convert_suggestion_body), "\n", this.itemView.getResources().getString(C8003R.string.converted_note_description_automatically_convert));
        }
        String string = this.itemView.getResources().getString(C8003R.string.converted_note_description_avoid_duplicates);
        Intrinsics.checkNotNull(string);
        return string;
    }

    private final String getTitle(int type) {
        if (type == 1) {
            String string = this.itemView.getResources().getString(C8003R.string.unconverted_notes);
            Intrinsics.checkNotNull(string);
            return string;
        }
        String string2 = this.itemView.getResources().getString(C8003R.string.converted_notes);
        Intrinsics.checkNotNull(string2);
        return string2;
    }

    public final void decorateItemView(int type, boolean isVisible, int margin) {
        int dimension;
        FrameLayout frameLayout = (FrameLayout) this.itemView.findViewById(C8003R.id.category_divider);
        TextView textView = (TextView) this.itemView.findViewById(C8003R.id.category_converted_notes_title);
        TextView textView2 = (TextView) this.itemView.findViewById(C8003R.id.category_converted_notes_description);
        Button button = (Button) this.itemView.findViewById(C8003R.id.check_converted_notes_button);
        if (type != 1) {
            if (type == 2) {
                if (!isVisible) {
                    this.itemView.setVisibility(8);
                    return;
                }
                frameLayout.setVisibility(0);
            }
            dimension = 0;
        } else {
            frameLayout.setVisibility(8);
            dimension = (int) this.itemView.getResources().getDimension(C8003R.dimen.old_category_list_recyclerview_container_margin_top_bottom);
        }
        this.itemView.setVisibility(0);
        textView.setText(getTitle(type));
        textView2.setText(getMessage(type));
        button.setText(getButtonMessage(type));
        button.setOnClickListener(new ViewOnClickListenerC0220b(this, type, 0));
        ViewGroup.LayoutParams layoutParams = button.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        Intrinsics.checkNotNull(button);
        ViewGroup.LayoutParams layoutParams2 = button.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
        marginLayoutParams.setMargins(margin, marginLayoutParams2 != null ? marginLayoutParams2.topMargin : 0, margin, dimension);
        button.setLayoutParams(marginLayoutParams);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.oldnotes.adpater.holder.OldCommonHolder
    public int getType() {
        return 1;
    }
}
