package com.samsung.android.support.senl.p148nt.stt.view.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.sdk.composer.voice.VoiceManager;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.ViewOnClickListenerC8556a;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.stt.C11493R;
import com.samsung.android.support.senl.p148nt.stt.base.audio.ConvertUtils;
import com.samsung.android.support.senl.p148nt.stt.base.audio.FastConvertController;
import com.samsung.android.support.senl.p148nt.stt.base.listener.ChooseVoiceItemDialogListener;
import com.samsung.android.support.senl.p148nt.stt.base.model.SpenVoiceTextDataReader;
import com.samsung.android.support.senl.p148nt.stt.base.model.SpenVoiceTextDataReaderCache;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 02\u00020\u0001:\u0004-./0B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0019\b\u0016\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0002\u0010\u0007J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u001e\u001a\u00020\u001fH\u0004J\b\u0010 \u001a\u00020\u0016H\u0016J\b\u0010!\u001a\u00020\u0016H\u0002J\b\u0010\"\u001a\u00020\u0016H\u0016J\u0014\u0010#\u001a\u00020\u00162\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0006\u0010)\u001a\u00020\u0016J\u0006\u0010*\u001a\u00020\u0016J\b\u0010+\u001a\u00020\u0016H\u0002J\b\u0010,\u001a\u00020\u0016H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010$\u001a\u0004\u0018\u00010\u00062\b\u0010$\u001a\u0004\u0018\u00010\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u00061"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/view/dialog/STTSelectTranscribeDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "voiceDataList", "", "Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;", "(Ljava/util/List;)V", "mVoiceItemAdapter", "Lcom/samsung/android/support/senl/nt/stt/view/dialog/STTSelectTranscribeDialogFragment$VoiceItemAdapter;", "mView", "Landroid/view/View;", "mVoiceItemRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mChooseVoiceItemDialogListener", "Lcom/samsung/android/support/senl/nt/stt/base/listener/ChooseVoiceItemDialogListener;", "value", "showingVoiceDataList", "getShowingVoiceDataList", "()Ljava/util/List;", "mSelectedVoice", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "", "outState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "setDialogListener", "chooseVoiceItemDialogListener", "createAlertDialog", "Landroidx/appcompat/app/AlertDialog;", "onResume", "updateOKButton", "onDestroyView", "setVoiceDataList", "selectedVoice", "getSelectedVoice", "()Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;", "setSelectedVoice", "(Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;)V", "notifyDatasetChanged", "clearState", "enableOKButton", "disableOKButton", "VoiceItemAdapter", "ViewHolder", "AdapterContract", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class STTSelectTranscribeDialogFragment extends DialogFragment {

    @NotNull
    private static final String TAG = "STTSelectTranscribeDialogFragment";

    @Nullable
    private ChooseVoiceItemDialogListener mChooseVoiceItemDialogListener;

    @Nullable
    private SpenVoiceData mSelectedVoice;

    @Nullable
    private View mView;

    @Nullable
    private VoiceItemAdapter mVoiceItemAdapter;

    @Nullable
    private RecyclerView mVoiceItemRecyclerView;

    @Nullable
    private List<SpenVoiceData> showingVoiceDataList;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/view/dialog/STTSelectTranscribeDialogFragment$AdapterContract;", "", "onSelectItem", "", "position", "", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface AdapterContract {
        void onSelectItem(int position);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/view/dialog/STTSelectTranscribeDialogFragment$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "mAdapterContract", "Lcom/samsung/android/support/senl/nt/stt/view/dialog/STTSelectTranscribeDialogFragment$AdapterContract;", "<init>", "(Landroid/view/View;Lcom/samsung/android/support/senl/nt/stt/view/dialog/STTSelectTranscribeDialogFragment$AdapterContract;)V", "mPosition", "", "getMPosition", "()I", "setMPosition", "(I)V", "mRadioButton", "Landroid/widget/RadioButton;", "mVoiceTitle", "Landroid/widget/TextView;", "getMVoiceTitle", "()Landroid/widget/TextView;", "setMVoiceTitle", "(Landroid/widget/TextView;)V", "mVoiceSummary", "getMVoiceSummary", "setMVoiceSummary", "mVoiceCreateDate", "getMVoiceCreateDate", "setMVoiceCreateDate", "mVoicePlayTime", "getMVoicePlayTime", "setMVoicePlayTime", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        @NotNull
        private final AdapterContract mAdapterContract;
        private int mPosition;

        @JvmField
        @NotNull
        public RadioButton mRadioButton;

        @NotNull
        private TextView mVoiceCreateDate;

        @NotNull
        private TextView mVoicePlayTime;

        @NotNull
        private TextView mVoiceSummary;

        @NotNull
        private TextView mVoiceTitle;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull View itemView, @NotNull AdapterContract mAdapterContract) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(mAdapterContract, "mAdapterContract");
            this.mAdapterContract = mAdapterContract;
            View viewFindViewById = itemView.findViewById(C11493R.id.radio_item);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.mRadioButton = (RadioButton) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(C11493R.id.voice_title);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.mVoiceTitle = (TextView) viewFindViewById2;
            View viewFindViewById3 = itemView.findViewById(C11493R.id.voice_summary);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.mVoiceSummary = (TextView) viewFindViewById3;
            View viewFindViewById4 = itemView.findViewById(C11493R.id.voice_create_date);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
            this.mVoiceCreateDate = (TextView) viewFindViewById4;
            View viewFindViewById5 = itemView.findViewById(C11493R.id.voice_play_time);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
            this.mVoicePlayTime = (TextView) viewFindViewById5;
            itemView.setOnClickListener(new ViewOnClickListenerC8556a(this, 27));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void _init_$lambda$0(ViewHolder viewHolder, View view) {
            AdapterContract adapterContract = viewHolder.mAdapterContract;
            if (adapterContract != null) {
                Intrinsics.checkNotNull(adapterContract);
                adapterContract.onSelectItem(viewHolder.mPosition);
            }
        }

        public final int getMPosition() {
            return this.mPosition;
        }

        @NotNull
        public final TextView getMVoiceCreateDate() {
            return this.mVoiceCreateDate;
        }

        @NotNull
        public final TextView getMVoicePlayTime() {
            return this.mVoicePlayTime;
        }

        @NotNull
        public final TextView getMVoiceSummary() {
            return this.mVoiceSummary;
        }

        @NotNull
        public final TextView getMVoiceTitle() {
            return this.mVoiceTitle;
        }

        public final void setMPosition(int i) {
            this.mPosition = i;
        }

        public final void setMVoiceCreateDate(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mVoiceCreateDate = textView;
        }

        public final void setMVoicePlayTime(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mVoicePlayTime = textView;
        }

        public final void setMVoiceSummary(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mVoiceSummary = textView;
        }

        public final void setMVoiceTitle(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mVoiceTitle = textView;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0016\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000eJ\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0016H\u0017J\b\u0010\u001a\u001a\u00020\u0016H\u0016J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0012\u0010\u001f\u001a\u00020\u00162\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\u0010\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0016H\u0002J\u0018\u0010$\u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/view/dialog/STTSelectTranscribeDialogFragment$VoiceItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/samsung/android/support/senl/nt/stt/view/dialog/STTSelectTranscribeDialogFragment$ViewHolder;", "mAdapterContract", "Lcom/samsung/android/support/senl/nt/stt/view/dialog/STTSelectTranscribeDialogFragment$AdapterContract;", "<init>", "(Lcom/samsung/android/support/senl/nt/stt/view/dialog/STTSelectTranscribeDialogFragment$AdapterContract;)V", "selectedVoice", "Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;", "getSelectedVoice", "()Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;", "setSelectedVoice", "(Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;)V", "mVoiceDataList", "", "setVoiceDataList", "", "voiceDataList", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "viewHolder", "position", "getItemCount", "isTimeDisplayFor24hour", "", "context", "Landroid/content/Context;", "changeTimeType", "timeStr", "", "createTimeString", "timeInSecond", "getSummaryText", "spenVoiceData", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nSTTSelectTranscribeDialogFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 STTSelectTranscribeDialogFragment.kt\ncom/samsung/android/support/senl/nt/stt/view/dialog/STTSelectTranscribeDialogFragment$VoiceItemAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,351:1\n739#2,9:352\n37#3:361\n36#3,3:362\n*S KotlinDebug\n*F\n+ 1 STTSelectTranscribeDialogFragment.kt\ncom/samsung/android/support/senl/nt/stt/view/dialog/STTSelectTranscribeDialogFragment$VoiceItemAdapter\n*L\n253#1:352,9\n254#1:361\n254#1:362,3\n*E\n"})
    public static class VoiceItemAdapter extends RecyclerView.Adapter<ViewHolder> {
        public static final int MAX_STT_DATA_DISPLAY_SIZE = 1000;

        @NotNull
        public static final String TIME_SPLIT = ":";

        @NotNull
        private final AdapterContract mAdapterContract;

        @Nullable
        private List<SpenVoiceData> mVoiceDataList;

        @Nullable
        private SpenVoiceData selectedVoice;

        public VoiceItemAdapter(@NotNull AdapterContract mAdapterContract) {
            Intrinsics.checkNotNullParameter(mAdapterContract, "mAdapterContract");
            this.mAdapterContract = mAdapterContract;
            this.mVoiceDataList = new ArrayList();
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x006b A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final int changeTimeType(String timeStr) {
            List listEmptyList;
            String[] strArr;
            int length;
            int i = 0;
            if (timeStr != null && !TextUtils.isEmpty(timeStr)) {
                List listM13999t = AbstractC12991c.m13999t(0, ":", timeStr);
                if (listM13999t.isEmpty()) {
                    listEmptyList = CollectionsKt.emptyList();
                    strArr = (String[]) listEmptyList.toArray(new String[0]);
                    length = strArr.length - 1;
                    if (length >= 0) {
                    }
                } else {
                    ListIterator listIterator = listM13999t.listIterator(listM13999t.size());
                    while (listIterator.hasPrevious()) {
                        if (((String) listIterator.previous()).length() != 0) {
                            listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listM13999t);
                            break;
                        }
                    }
                    listEmptyList = CollectionsKt.emptyList();
                    strArr = (String[]) listEmptyList.toArray(new String[0]);
                    try {
                        length = strArr.length - 1;
                        if (length >= 0) {
                            return 0;
                        }
                        int i2 = length;
                        int i4 = 0;
                        while (true) {
                            int i5 = i2 - 1;
                            int i6 = i4 + 1;
                            i += Integer.parseInt(strArr[i2]) * ((int) Math.pow(60.0d, i4));
                            if (i5 < 0) {
                                return i;
                            }
                            i2 = i5;
                            i4 = i6;
                        }
                    } catch (NumberFormatException e) {
                        AbstractC12991c.m14005z("changeTimeType, e: ", e.getMessage(), STTSelectTranscribeDialogFragment.TAG);
                    }
                }
            }
            return i;
        }

        private final String createTimeString(int timeInSecond) {
            int i = timeInSecond / 3600;
            int i2 = (timeInSecond % 3600) / 60;
            int i4 = timeInSecond % 60;
            if (i <= 0) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                return AbstractC11014a.m12323h(new Object[]{Integer.valueOf(i2), Integer.valueOf(i4)}, 2, Locale.getDefault(), "%02d:%02d", "format(...)");
            }
            if (i > 9) {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                return AbstractC11014a.m12323h(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4)}, 3, Locale.getDefault(), "%02d:%02d:%02d", "format(...)");
            }
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            return AbstractC11014a.m12323h(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4)}, 3, Locale.getDefault(), "%d:%02d:%02d", "format(...)");
        }

        private final String getSummaryText(Context context, SpenVoiceData spenVoiceData) {
            String sessionID = ConvertUtils.getSessionID(spenVoiceData);
            FastConvertController companion = FastConvertController.INSTANCE.getInstance();
            Intrinsics.checkNotNull(companion);
            if (companion.isConverting(sessionID)) {
                String string = context.getString(C11493R.string.stt_transcribing);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                return string;
            }
            SpenVoiceTextDataReaderCache companion2 = SpenVoiceTextDataReaderCache.INSTANCE.getInstance();
            Intrinsics.checkNotNull(companion2);
            SpenVoiceTextDataReader spenVoiceTextDataReader = companion2.get(spenVoiceData);
            String[] summaryTitle = spenVoiceTextDataReader.getSummaryTitle();
            if (summaryTitle != null && summaryTitle.length > 0) {
                return summaryTitle[0];
            }
            String[] voiceTexts = spenVoiceTextDataReader.getVoiceTexts();
            StringBuilder sb = new StringBuilder();
            if (voiceTexts != null) {
                Iterator it = ArrayIteratorKt.iterator(voiceTexts);
                while (it.hasNext()) {
                    sb.append((String) it.next());
                }
            }
            String string2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
            String strSubstring = string2.substring(0, Math.min(sb.length(), 1000));
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return strSubstring;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<SpenVoiceData> list = this.mVoiceDataList;
            if (list == null) {
                return 0;
            }
            Intrinsics.checkNotNull(list);
            return list.size();
        }

        @Nullable
        public final SpenVoiceData getSelectedVoice() {
            return this.selectedVoice;
        }

        public final boolean isTimeDisplayFor24hour(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            String string = Settings.System.getString(context.getContentResolver(), "time_12_24");
            return string != null && Integer.parseInt(string) == 24;
        }

        public final void setSelectedVoice(@Nullable SpenVoiceData spenVoiceData) {
            this.selectedVoice = spenVoiceData;
        }

        public final void setVoiceDataList(@Nullable List<SpenVoiceData> voiceDataList) {
            this.mVoiceDataList = voiceDataList;
            notifyDataSetChanged();
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0027  */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @SuppressLint({"RecyclerView"})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onBindViewHolder(@NotNull ViewHolder viewHolder, int position) {
            boolean z;
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            List<SpenVoiceData> list = this.mVoiceDataList;
            Intrinsics.checkNotNull(list);
            SpenVoiceData spenVoiceData = list.get(position);
            SpenVoiceData spenVoiceData2 = this.selectedVoice;
            if (spenVoiceData2 != null) {
                Intrinsics.checkNotNull(spenVoiceData2);
                z = Intrinsics.areEqual(spenVoiceData2.getName(), spenVoiceData.getName());
            }
            viewHolder.mRadioButton.setChecked(z);
            viewHolder.mRadioButton.setContentDescription(spenVoiceData.getName());
            viewHolder.getMVoiceTitle().setText(spenVoiceData.getName());
            TextView mVoiceSummary = viewHolder.getMVoiceSummary();
            Context context = viewHolder.getMVoiceSummary().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            mVoiceSummary.setText(getSummaryText(context, spenVoiceData));
            Context context2 = viewHolder.getMVoiceCreateDate().getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            viewHolder.getMVoiceCreateDate().setText(new SimpleDateFormat(DateFormat.getBestDateTimePattern(Locale.getDefault(), isTimeDisplayFor24hour(context2) ? "MM.dd HH:mm" : "MM.dd hh:mm"), Locale.getDefault()).format(new Date(spenVoiceData.getCreationTime())));
            viewHolder.getMVoicePlayTime().setText(createTimeString(changeTimeType(spenVoiceData.getPlayTime())));
            viewHolder.setMPosition(position);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int viewType) {
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(C11493R.layout.select_voice_stt_item, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
            return new ViewHolder(viewInflate, this.mAdapterContract);
        }
    }

    public STTSelectTranscribeDialogFragment() {
        this.showingVoiceDataList = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createAlertDialog$lambda$0(STTSelectTranscribeDialogFragment sTTSelectTranscribeDialogFragment, DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        ChooseVoiceItemDialogListener chooseVoiceItemDialogListener = sTTSelectTranscribeDialogFragment.mChooseVoiceItemDialogListener;
        if (chooseVoiceItemDialogListener != null) {
            Intrinsics.checkNotNull(chooseVoiceItemDialogListener);
            chooseVoiceItemDialogListener.onDialogClickCancelButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createAlertDialog$lambda$1(STTSelectTranscribeDialogFragment sTTSelectTranscribeDialogFragment, DialogInterface dialogInterface, int i) {
        ChooseVoiceItemDialogListener chooseVoiceItemDialogListener = sTTSelectTranscribeDialogFragment.mChooseVoiceItemDialogListener;
        if (chooseVoiceItemDialogListener != null) {
            Intrinsics.checkNotNull(chooseVoiceItemDialogListener);
            chooseVoiceItemDialogListener.onDialogClickTranscribeButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createAlertDialog$lambda$2(AlertDialog alertDialog, DialogInterface dialogInterface) {
        Button button = alertDialog.getButton(-1);
        ViewGroup.LayoutParams layoutParams = button.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.weight = 1.0f;
        layoutParams2.width = -1;
        button.setLayoutParams(layoutParams2);
        Button button2 = alertDialog.getButton(-2);
        ViewGroup.LayoutParams layoutParams3 = button2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams3;
        layoutParams4.weight = 1.0f;
        layoutParams4.width = -1;
        button2.setLayoutParams(layoutParams4);
        button.invalidate();
        button2.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disableOKButton() {
        AlertDialog alertDialog = (AlertDialog) getDialog();
        if (alertDialog != null) {
            alertDialog.getButton(-1).setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enableOKButton() {
        AlertDialog alertDialog = (AlertDialog) getDialog();
        if (alertDialog != null) {
            alertDialog.getButton(-1).setEnabled(true);
        }
    }

    private final void updateOKButton() {
        SpenVoiceData spenVoiceData;
        if (this.mVoiceItemAdapter != null && (spenVoiceData = this.mSelectedVoice) != null) {
            Intrinsics.checkNotNull(spenVoiceData);
            if (spenVoiceData.getPlayTime() != null) {
                SpenVoiceData spenVoiceData2 = this.mSelectedVoice;
                Intrinsics.checkNotNull(spenVoiceData2);
                if (spenVoiceData2.getAttachedFile() != null) {
                    enableOKButton();
                    return;
                }
            }
        }
        disableOKButton();
    }

    public final void clearState() {
        VoiceItemAdapter voiceItemAdapter = this.mVoiceItemAdapter;
        if (voiceItemAdapter == null) {
            return;
        }
        this.mSelectedVoice = null;
        Intrinsics.checkNotNull(voiceItemAdapter);
        voiceItemAdapter.setSelectedVoice(null);
    }

    @NotNull
    public final AlertDialog createAlertDialog() {
        AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(getContext(), 0, 2, null).create();
        alertDialogCreate.setTitle(C11493R.string.stt_select_recordings);
        alertDialogCreate.setView(this.mView);
        final int i = 0;
        alertDialogCreate.setButton(-2, getString(C11493R.string.dialog_cancel), new DialogInterface.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.stt.view.dialog.d

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ STTSelectTranscribeDialogFragment f7932b;

            {
                this.f7932b = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                switch (i) {
                    case 0:
                        STTSelectTranscribeDialogFragment.createAlertDialog$lambda$0(this.f7932b, dialogInterface, i2);
                        break;
                    default:
                        STTSelectTranscribeDialogFragment.createAlertDialog$lambda$1(this.f7932b, dialogInterface, i2);
                        break;
                }
            }
        });
        final int i2 = 1;
        alertDialogCreate.setButton(-1, getString(C11493R.string.f7820OK), new DialogInterface.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.stt.view.dialog.d

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ STTSelectTranscribeDialogFragment f7932b;

            {
                this.f7932b = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i22) {
                switch (i2) {
                    case 0:
                        STTSelectTranscribeDialogFragment.createAlertDialog$lambda$0(this.f7932b, dialogInterface, i22);
                        break;
                    default:
                        STTSelectTranscribeDialogFragment.createAlertDialog$lambda$1(this.f7932b, dialogInterface, i22);
                        break;
                }
            }
        });
        alertDialogCreate.setOnShowListener(new DialogInterfaceOnShowListenerC11559e(alertDialogCreate, 0));
        return alertDialogCreate;
    }

    @Nullable
    public final SpenVoiceData getSelectedVoice() {
        VoiceItemAdapter voiceItemAdapter = this.mVoiceItemAdapter;
        Intrinsics.checkNotNull(voiceItemAdapter);
        return voiceItemAdapter.getSelectedVoice();
    }

    @Nullable
    public final List<SpenVoiceData> getShowingVoiceDataList() {
        return this.showingVoiceDataList;
    }

    public final void notifyDatasetChanged() {
        VoiceItemAdapter voiceItemAdapter = this.mVoiceItemAdapter;
        if (voiceItemAdapter == null) {
            return;
        }
        Intrinsics.checkNotNull(voiceItemAdapter);
        voiceItemAdapter.notifyDataSetChanged();
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View viewInflate = View.inflate(getContext(), C11493R.layout.stt_select_transcribe_dialog_layout, null);
        this.mView = viewInflate;
        RecyclerView recyclerView = viewInflate != null ? (RecyclerView) viewInflate.findViewById(C11493R.id.select_transcribe_recyclerview) : null;
        this.mVoiceItemRecyclerView = recyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        VoiceItemAdapter voiceItemAdapter = new VoiceItemAdapter(new AdapterContract() { // from class: com.samsung.android.support.senl.nt.stt.view.dialog.STTSelectTranscribeDialogFragment.onCreateDialog.1
            /* JADX WARN: Removed duplicated region for block: B:10:0x0063  */
            @Override // com.samsung.android.support.senl.nt.stt.view.dialog.STTSelectTranscribeDialogFragment.AdapterContract
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onSelectItem(int position) {
                STTSelectTranscribeDialogFragment sTTSelectTranscribeDialogFragment = STTSelectTranscribeDialogFragment.this;
                List<SpenVoiceData> showingVoiceDataList = sTTSelectTranscribeDialogFragment.getShowingVoiceDataList();
                sTTSelectTranscribeDialogFragment.mSelectedVoice = showingVoiceDataList != null ? showingVoiceDataList.get(position) : null;
                VoiceItemAdapter voiceItemAdapter2 = STTSelectTranscribeDialogFragment.this.mVoiceItemAdapter;
                Intrinsics.checkNotNull(voiceItemAdapter2);
                voiceItemAdapter2.setSelectedVoice(STTSelectTranscribeDialogFragment.this.mSelectedVoice);
                SpenVoiceData spenVoiceData = STTSelectTranscribeDialogFragment.this.mSelectedVoice;
                Intrinsics.checkNotNull(spenVoiceData);
                Logger.m12710d(STTSelectTranscribeDialogFragment.TAG, "onClick(). selectedVoice : " + spenVoiceData.getName());
                SpenVoiceData spenVoiceData2 = STTSelectTranscribeDialogFragment.this.mSelectedVoice;
                Intrinsics.checkNotNull(spenVoiceData2);
                if (spenVoiceData2.getPlayTime() != null) {
                    SpenVoiceData spenVoiceData3 = STTSelectTranscribeDialogFragment.this.mSelectedVoice;
                    Intrinsics.checkNotNull(spenVoiceData3);
                    if (spenVoiceData3.getAttachedFile() == null) {
                        if (VoiceManager.isRecording()) {
                            Logger.m12710d(STTSelectTranscribeDialogFragment.TAG, "onClick# isRecording");
                            FragmentActivity activity = STTSelectTranscribeDialogFragment.this.getActivity();
                            String string = STTSelectTranscribeDialogFragment.this.getString(C11493R.string.stt_can_not_transcribe_while_recording);
                            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                            ToastHandler.show(activity, string, 0);
                            STTSelectTranscribeDialogFragment.this.disableOKButton();
                            return;
                        }
                    }
                }
                STTSelectTranscribeDialogFragment.this.notifyDatasetChanged();
                STTSelectTranscribeDialogFragment.this.enableOKButton();
            }
        });
        this.mVoiceItemAdapter = voiceItemAdapter;
        Intrinsics.checkNotNull(voiceItemAdapter);
        voiceItemAdapter.setVoiceDataList(this.showingVoiceDataList);
        RecyclerView recyclerView2 = this.mVoiceItemRecyclerView;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.mVoiceItemAdapter);
        }
        return createAlertDialog();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (this.mView != null) {
            this.mView = null;
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        updateOKButton();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
    }

    public final void setDialogListener(@Nullable ChooseVoiceItemDialogListener chooseVoiceItemDialogListener) {
        this.mChooseVoiceItemDialogListener = chooseVoiceItemDialogListener;
    }

    public final void setSelectedVoice(@Nullable SpenVoiceData spenVoiceData) {
        this.mSelectedVoice = spenVoiceData;
        VoiceItemAdapter voiceItemAdapter = this.mVoiceItemAdapter;
        if (voiceItemAdapter == null || this.mVoiceItemRecyclerView == null) {
            Logger.m12711e(TAG, "setSelectedVoice# view is null");
            return;
        }
        Intrinsics.checkNotNull(voiceItemAdapter);
        voiceItemAdapter.setSelectedVoice(this.mSelectedVoice);
        updateOKButton();
    }

    public final void setVoiceDataList(@NotNull List<SpenVoiceData> voiceDataList) {
        Intrinsics.checkNotNullParameter(voiceDataList, "voiceDataList");
        this.showingVoiceDataList = voiceDataList;
        VoiceItemAdapter voiceItemAdapter = this.mVoiceItemAdapter;
        if (voiceItemAdapter == null || this.mVoiceItemRecyclerView == null) {
            Logger.m12711e(TAG, "setVoiceDataList# view is null");
            return;
        }
        Intrinsics.checkNotNull(voiceItemAdapter);
        voiceItemAdapter.setVoiceDataList(this.showingVoiceDataList);
        RecyclerView recyclerView = this.mVoiceItemRecyclerView;
        Intrinsics.checkNotNull(recyclerView);
        recyclerView.setAdapter(this.mVoiceItemAdapter);
    }

    public STTSelectTranscribeDialogFragment(@Nullable List<SpenVoiceData> list) {
        new ArrayList();
        this.showingVoiceDataList = list;
    }
}
