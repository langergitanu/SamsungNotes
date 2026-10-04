package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import java.text.DecimalFormat;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p071Q2.ViewOnClickListenerC0220b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0017\u0018B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceSpeedAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceSpeedAdapter$VoiceMenuViewHolder;", "mCurrentSpeed", "", "onItemCLickListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceSpeedAdapter$VoiceSpeedListener;", "mIsDarkTheme", "", "<init>", "(FLcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceSpeedAdapter$VoiceSpeedListener;Z)V", "items", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "VoiceMenuViewHolder", "VoiceSpeedListener", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VoiceSpeedAdapter extends RecyclerView.Adapter<VoiceMenuViewHolder> {

    @NotNull
    private final List<Float> items;
    private float mCurrentSpeed;
    private final boolean mIsDarkTheme;

    @NotNull
    private final VoiceSpeedListener onItemCLickListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceSpeedAdapter$VoiceMenuViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "checkedTextView", "Landroid/widget/TextView;", "getCheckedTextView", "()Landroid/widget/TextView;", "checkedImageView", "Landroid/widget/ImageView;", "getCheckedImageView", "()Landroid/widget/ImageView;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class VoiceMenuViewHolder extends RecyclerView.ViewHolder {

        @NotNull
        private final ImageView checkedImageView;

        @NotNull
        private final TextView checkedTextView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VoiceMenuViewHolder(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View viewFindViewById = itemView.findViewById(C9086R.id.speed_text_checked);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.checkedTextView = (TextView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(C9086R.id.speed_checked_icon);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.checkedImageView = (ImageView) viewFindViewById2;
        }

        @NotNull
        public final ImageView getCheckedImageView() {
            return this.checkedImageView;
        }

        @NotNull
        public final TextView getCheckedTextView() {
            return this.checkedTextView;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceSpeedAdapter$VoiceSpeedListener;", "", "<init>", "()V", "onItemCLick", "", "changeSpeed", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static abstract class VoiceSpeedListener {
        public abstract void onItemCLick(float changeSpeed);
    }

    public VoiceSpeedAdapter(float f, @NotNull VoiceSpeedListener onItemCLickListener, boolean z) {
        Intrinsics.checkNotNullParameter(onItemCLickListener, "onItemCLickListener");
        this.mCurrentSpeed = f;
        this.onItemCLickListener = onItemCLickListener;
        this.mIsDarkTheme = z;
        this.items = CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(0.5f), Float.valueOf(0.75f), Float.valueOf(1.0f), Float.valueOf(1.25f), Float.valueOf(1.5f), Float.valueOf(2.0f)});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(VoiceSpeedAdapter voiceSpeedAdapter, int i, View view) {
        float fFloatValue = voiceSpeedAdapter.items.get(i).floatValue();
        voiceSpeedAdapter.mCurrentSpeed = fFloatValue;
        voiceSpeedAdapter.onItemCLickListener.onItemCLick(fFloatValue);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull VoiceMenuViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Context applicationContext = BaseUtils.getApplicationContext();
        DecimalFormat decimalFormat = new DecimalFormat("0.0#");
        String string = null;
        if (LocaleUtils.isRTLMode()) {
            if (applicationContext != null) {
                string = applicationContext.getString(C9086R.string.composer_voice_record_play_speed_arabic, 'x', decimalFormat.format(this.items.get(position).floatValue()));
            }
        } else if (applicationContext != null) {
            string = applicationContext.getString(C9086R.string.composer_voice_record_play_speed, decimalFormat.format(this.items.get(position).floatValue()), 'x');
        }
        if (this.items.get(position).floatValue() == this.mCurrentSpeed) {
            holder.getCheckedTextView().setTextColor(ResourceUtils.getColor(applicationContext, C9086R.color.composer_voice_menu_text_playing_item_color));
            holder.getCheckedTextView().setTextAppearance(C9086R.style.RobotoMediumStyle);
            holder.getCheckedImageView().setVisibility(0);
        } else {
            holder.getCheckedTextView().setTextColor(ResourceUtils.getColor(applicationContext, this.mIsDarkTheme ? C9086R.color.composer_voice_item_text_color_dark : C9086R.color.composer_voice_item_text_color));
            holder.getCheckedTextView().setTextAppearance(C9086R.style.RobotoRegularStyle);
            holder.getCheckedImageView().setVisibility(8);
        }
        holder.getCheckedTextView().setText(string);
        holder.itemView.setOnClickListener(new ViewOnClickListenerC0220b(this, position, 4));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public VoiceMenuViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Object systemService = parent.getContext().getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View viewInflate = ((LayoutInflater) systemService).inflate(C9086R.layout.speed_checked_item_layout, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new VoiceMenuViewHolder(viewInflate);
    }
}
