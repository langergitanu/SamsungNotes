package com.samsung.android.support.senl.p148nt.stt.picker.view;

import android.content.Context;
import android.content.res.Resources;
import android.icu.util.Calendar;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.format.DateFormat;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.smartswitchfileshare.Constants;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.text.TextUtilsCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.RunnableC9767a;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.stt.C11493R;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import com.samsung.android.support.senl.p148nt.stt.picker.model.LoadVoiceListener;
import com.samsung.android.support.senl.p148nt.stt.picker.model.RecordingItem;
import com.samsung.android.support.senl.p148nt.stt.picker.utils.InitialKoreanUtil;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 M2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0002MNB=\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\"\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e0\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000bJ\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u000bJ*\u0010#\u001a\u00020\u001e2\"\u0010$\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e0\nJ\u0006\u0010%\u001a\u00020\u001eJ\u0018\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u000bH\u0016J\u0010\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u000bH\u0016J\b\u0010,\u001a\u00020\u000bH\u0016J\b\u0010-\u001a\u00020\u000bH\u0002J\u0018\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u000bH\u0016J\u0018\u00100\u001a\u00020\u001e2\u0006\u0010/\u001a\u0002012\u0006\u00102\u001a\u00020\rH\u0002J\u0006\u00103\u001a\u00020\u001eJ\u0018\u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0013H\u0002J\u0016\u00108\u001a\u00020\u001e2\u0006\u00102\u001a\u00020\r2\u0006\u00109\u001a\u00020\u000bJ\u0018\u0010:\u001a\u00020\u001e2\u0006\u0010/\u001a\u0002012\u0006\u0010;\u001a\u00020\u001cH\u0002J\b\u0010<\u001a\u00020\u001eH\u0016J\u0010\u0010=\u001a\u00020\u001e2\u0006\u0010>\u001a\u00020?H\u0016J\b\u0010@\u001a\u00020\u001eH\u0002J\u0010\u0010A\u001a\u00020\u00132\u0006\u0010B\u001a\u00020CH\u0002J\b\u0010D\u001a\u00020EH\u0002J\b\u0010F\u001a\u00020EH\u0002J\b\u0010G\u001a\u00020EH\u0002J\u0010\u0010H\u001a\u00020\u00132\u0006\u0010I\u001a\u00020\u000bH\u0002J\u0016\u0010J\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000bJ\u000e\u0010K\u001a\u00020\u001e2\u0006\u0010L\u001a\u00020\u0013R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/picker/view/AudioPickerListViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/samsung/android/support/senl/nt/stt/picker/model/LoadVoiceListener;", "Landroid/view/View$OnClickListener;", "mContext", "Landroid/content/Context;", "mAdapterContract", "Lcom/samsung/android/support/senl/nt/stt/picker/view/AudioPickerListViewAdapterContract;", "mAudioFileMap", "", "", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/nt/stt/picker/model/RecordingItem;", "Lkotlin/collections/ArrayList;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/support/senl/nt/stt/picker/view/AudioPickerListViewAdapterContract;Ljava/util/Map;)V", "mTimeFormat", "mCurrentLanguage", "", "mPrevItemSelect", "mRecordingMode", "mCurrentSortType", "mCurrentSortOrder", "mReInitSelectedMode", "mReInitSelectedItem", "mHighlightText", "isExpandSearchView", "", "setSortState", "", "sortType", "sortOrder", "setRecordingMode", "recordingMode", "setData", "audioFileMap", "updateData", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemViewType", "position", "getItemCount", "getSearchResultCount", "onBindViewHolder", "holder", "selectItem", "Lcom/samsung/android/support/senl/nt/stt/picker/view/AudioPickerListViewAdapter$AudioPickerViewHolder;", "recordingItem", "resetPrevItemSelect", "setTitleViewColor", "textView", "Landroid/widget/TextView;", "title", "setReInitItemSelect", "selectMode", "updateItemLayout", "selected", "onUpdate", "onClick", VPathDataCmd.RCurveTo, "Landroid/view/View;", "updateTimeFormat", "getMediumDateFormat", "date", "", "getDateFormatWithYear", "Ljava/text/SimpleDateFormat;", "getDateFormatWithMonth", "getDateFormatWithHour", "getSizeFormat", "size", "sortItem", "setHighlightText", "highlightText", "Companion", "AudioPickerViewHolder", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAudioPickerListViewAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AudioPickerListViewAdapter.kt\ncom/samsung/android/support/senl/nt/stt/picker/view/AudioPickerListViewAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,489:1\n739#2,9:490\n37#3:499\n36#3,3:500\n*S KotlinDebug\n*F\n+ 1 AudioPickerListViewAdapter.kt\ncom/samsung/android/support/senl/nt/stt/picker/view/AudioPickerListViewAdapter\n*L\n201#1:490,9\n202#1:499\n202#1:500,3\n*E\n"})
public class AudioPickerListViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements LoadVoiceListener, View.OnClickListener {
    private static final int SORT_BAR_VIEW = 2;

    @NotNull
    private static final String TAG = "AudioPickerAdapter";
    private boolean isExpandSearchView;

    @NotNull
    private AudioPickerListViewAdapterContract mAdapterContract;

    @NotNull
    private Map<Integer, ? extends ArrayList<RecordingItem>> mAudioFileMap;

    @Nullable
    private Context mContext;

    @Nullable
    private String mCurrentLanguage;
    private int mCurrentSortOrder;
    private int mCurrentSortType;

    @Nullable
    private String mHighlightText;

    @Nullable
    private RecordingItem mPrevItemSelect;

    @Nullable
    private RecordingItem mReInitSelectedItem;
    private int mReInitSelectedMode;
    private int mRecordingMode;
    private int mTimeFormat;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\u0005R\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006("}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/picker/view/AudioPickerListViewAdapter$AudioPickerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mTitle", "Landroid/widget/TextView;", "getMTitle", "()Landroid/widget/TextView;", "setMTitle", "(Landroid/widget/TextView;)V", "mDate", "getMDate", "setMDate", "mSize", "getMSize", "setMSize", "mSelectButton", "Landroid/widget/RadioButton;", "getMSelectButton", "()Landroid/widget/RadioButton;", "setMSelectButton", "(Landroid/widget/RadioButton;)V", "mItemContainer", "Landroid/widget/LinearLayout;", "getMItemContainer", "()Landroid/widget/LinearLayout;", "setMItemContainer", "(Landroid/widget/LinearLayout;)V", "mDividerItem", "getMDividerItem", "()Landroid/view/View;", "setMDividerItem", "mPlayContainer", "Landroid/widget/RelativeLayout;", "getMPlayContainer", "()Landroid/widget/RelativeLayout;", "setMPlayContainer", "(Landroid/widget/RelativeLayout;)V", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class AudioPickerViewHolder extends RecyclerView.ViewHolder {

        @NotNull
        private TextView mDate;

        @NotNull
        private View mDividerItem;

        @NotNull
        private LinearLayout mItemContainer;

        @NotNull
        private RelativeLayout mPlayContainer;

        @NotNull
        private RadioButton mSelectButton;

        @NotNull
        private TextView mSize;

        @NotNull
        private TextView mTitle;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AudioPickerViewHolder(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View viewFindViewById = itemView.findViewById(C11493R.id.title);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.mTitle = (TextView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(C11493R.id.date);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.mDate = (TextView) viewFindViewById2;
            View viewFindViewById3 = itemView.findViewById(C11493R.id.size);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.mSize = (TextView) viewFindViewById3;
            View viewFindViewById4 = itemView.findViewById(C11493R.id.select_button);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
            this.mSelectButton = (RadioButton) viewFindViewById4;
            View viewFindViewById5 = itemView.findViewById(C11493R.id.record_item_container);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
            this.mItemContainer = (LinearLayout) viewFindViewById5;
            View viewFindViewById6 = itemView.findViewById(C11493R.id.divider_item);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
            this.mDividerItem = viewFindViewById6;
            View viewFindViewById7 = itemView.findViewById(C11493R.id.play_container);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
            this.mPlayContainer = (RelativeLayout) viewFindViewById7;
        }

        @NotNull
        public final TextView getMDate() {
            return this.mDate;
        }

        @NotNull
        public final View getMDividerItem() {
            return this.mDividerItem;
        }

        @NotNull
        public final LinearLayout getMItemContainer() {
            return this.mItemContainer;
        }

        @NotNull
        public final RelativeLayout getMPlayContainer() {
            return this.mPlayContainer;
        }

        @NotNull
        public final RadioButton getMSelectButton() {
            return this.mSelectButton;
        }

        @NotNull
        public final TextView getMSize() {
            return this.mSize;
        }

        @NotNull
        public final TextView getMTitle() {
            return this.mTitle;
        }

        public final void setMDate(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mDate = textView;
        }

        public final void setMDividerItem(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.mDividerItem = view;
        }

        public final void setMItemContainer(@NotNull LinearLayout linearLayout) {
            Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
            this.mItemContainer = linearLayout;
        }

        public final void setMPlayContainer(@NotNull RelativeLayout relativeLayout) {
            Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
            this.mPlayContainer = relativeLayout;
        }

        public final void setMSelectButton(@NotNull RadioButton radioButton) {
            Intrinsics.checkNotNullParameter(radioButton, "<set-?>");
            this.mSelectButton = radioButton;
        }

        public final void setMSize(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mSize = textView;
        }

        public final void setMTitle(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mTitle = textView;
        }
    }

    public AudioPickerListViewAdapter(@Nullable Context context, @NotNull AudioPickerListViewAdapterContract mAdapterContract, @NotNull Map<Integer, ? extends ArrayList<RecordingItem>> mAudioFileMap) {
        Intrinsics.checkNotNullParameter(mAdapterContract, "mAdapterContract");
        Intrinsics.checkNotNullParameter(mAudioFileMap, "mAudioFileMap");
        this.mContext = context;
        this.mAdapterContract = mAdapterContract;
        this.mAudioFileMap = mAudioFileMap;
        this.isExpandSearchView = true;
        this.mCurrentLanguage = Locale.getDefault().getLanguage();
        this.mReInitSelectedMode = -1;
        updateTimeFormat();
    }

    private final SimpleDateFormat getDateFormatWithHour() {
        return this.mTimeFormat == 24 ? new SimpleDateFormat("HH:mm") : (Intrinsics.areEqual(Locale.KOREAN.getLanguage(), this.mCurrentLanguage) || LocaleUtils.isChinaLanguage()) ? new SimpleDateFormat("a h:mm") : Intrinsics.areEqual(Locale.JAPANESE.getLanguage(), this.mCurrentLanguage) ? new SimpleDateFormat("a K:mm") : new SimpleDateFormat("h:mm a");
    }

    private final SimpleDateFormat getDateFormatWithMonth() {
        return new SimpleDateFormat(DateFormat.getBestDateTimePattern(Locale.getDefault(), "MMMd"), Locale.getDefault());
    }

    private final SimpleDateFormat getDateFormatWithYear() {
        return new SimpleDateFormat(DateFormat.getBestDateTimePattern(Locale.getDefault(), "MMMdyyyy"), Locale.getDefault());
    }

    private final String getMediumDateFormat(long date) {
        StringBuilder sb;
        if (this.mContext == null) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(1);
        int i2 = calendar.get(2);
        int i4 = calendar.get(5);
        calendar.setTimeInMillis(date);
        SimpleDateFormat dateFormatWithYear = getDateFormatWithYear();
        SimpleDateFormat dateFormatWithMonth = getDateFormatWithMonth();
        SimpleDateFormat dateFormatWithHour = getDateFormatWithHour();
        if (calendar.get(1) == i && calendar.get(2) == i2 && calendar.get(5) == i4) {
            Context context = this.mContext;
            Intrinsics.checkNotNull(context);
            sb = context.getResources().getConfiguration().getLayoutDirection() == 1 ? new StringBuilder(AbstractC0541b.m772n("\u200e", dateFormatWithHour.format(calendar.getTime()))) : new StringBuilder(dateFormatWithHour.format(calendar.getTime()));
        } else if (calendar.get(1) < i) {
            Context context2 = this.mContext;
            Intrinsics.checkNotNull(context2);
            sb = context2.getResources().getConfiguration().getLayoutDirection() == 1 ? new StringBuilder(AbstractC0541b.m757C(dateFormatWithYear.format(calendar.getTime()), " \u200e", dateFormatWithHour.format(calendar.getTime()))) : new StringBuilder(AbstractC0541b.m757C(dateFormatWithYear.format(calendar.getTime()), " ", dateFormatWithHour.format(calendar.getTime())));
        } else {
            Context context3 = this.mContext;
            Intrinsics.checkNotNull(context3);
            sb = context3.getResources().getConfiguration().getLayoutDirection() == 1 ? new StringBuilder(AbstractC0541b.m757C(dateFormatWithMonth.format(calendar.getTime()), " \u200e", dateFormatWithHour.format(calendar.getTime()))) : new StringBuilder(AbstractC0541b.m757C(dateFormatWithMonth.format(calendar.getTime()), " ", dateFormatWithHour.format(calendar.getTime())));
        }
        String language = Locale.getDefault().getLanguage();
        if (Intrinsics.areEqual("ar", language) || Intrinsics.areEqual(MarketingConstants.NotificationConst.FLIPPING_ANIMATION, language) || Intrinsics.areEqual("ur", language) || Intrinsics.areEqual("iw", language)) {
            sb.append("\u200f\u200e");
        } else {
            sb.append("");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private final int getSearchResultCount() {
        if (this.mAudioFileMap.containsKey(Integer.valueOf(this.mRecordingMode))) {
            return ((ArrayList) MapsKt.getValue(this.mAudioFileMap, Integer.valueOf(this.mRecordingMode))).size() + 1;
        }
        return 1;
    }

    private final String getSizeFormat(int size) {
        if (size <= 0) {
            return "0";
        }
        String[] strArr = {"B", "kB", "MB", Constants.GIGABYTE, "TB", "PB", "EB"};
        double d = size;
        int iLog10 = (int) (Math.log10(d) / Math.log10(1024.0d));
        return AbstractC0541b.m757C(new DecimalFormat("#,##0.#").format(d / Math.pow(1024.0d, iLog10)), " ", strArr[iLog10]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2(AudioPickerListViewAdapter audioPickerListViewAdapter, RecordingItem recordingItem, View view) {
        audioPickerListViewAdapter.mAdapterContract.onAudioPlay(recordingItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onUpdate$lambda$4(AudioPickerListViewAdapter audioPickerListViewAdapter) {
        audioPickerListViewAdapter.updateData();
        audioPickerListViewAdapter.mAdapterContract.disableProgressBar();
        audioPickerListViewAdapter.mAdapterContract.updateNoResultView(audioPickerListViewAdapter.getItemCount() == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void selectItem(AudioPickerViewHolder holder, RecordingItem recordingItem) {
        if (recordingItem.getIsSelected()) {
            return;
        }
        recordingItem.setSelected(true);
        updateItemLayout(holder, true);
        RecordingItem recordingItem2 = this.mPrevItemSelect;
        if (recordingItem2 != null) {
            Intrinsics.checkNotNull(recordingItem2);
            recordingItem2.setSelected(false);
            notifyDataSetChanged();
        }
        this.mPrevItemSelect = recordingItem;
        this.mAdapterContract.onAudioSelected(recordingItem);
    }

    private final void setTitleViewColor(TextView textView, String title) {
        List listEmptyList;
        String str = this.mHighlightText;
        if (str == null || str.length() == 0) {
            textView.setText(title);
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(title);
        String str2 = this.mHighlightText;
        Intrinsics.checkNotNull(str2);
        int i = 0;
        List<String> listSplit = new Regex(" +").split(str2, 0);
        boolean z = true;
        if (listSplit.isEmpty()) {
            listEmptyList = CollectionsKt.emptyList();
        } else {
            ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().length() != 0) {
                    listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listSplit);
                    break;
                }
            }
            listEmptyList = CollectionsKt.emptyList();
        }
        String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
        ArrayList<Integer> arrayList = new ArrayList<>();
        Context context = this.mContext;
        Intrinsics.checkNotNull(context);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(context.getResources().getColor(C11493R.color.search_recent_clear_all_color, null));
        int length = strArr.length;
        int i2 = 0;
        while (i2 < length) {
            String str3 = strArr[i2];
            int length2 = str3.length();
            TextUtilsCompat textUtilsCompat = TextUtilsCompat.INSTANCE;
            boolean z2 = z;
            TextPaint paint = textView.getPaint();
            Intrinsics.checkNotNullExpressionValue(paint, "getPaint(...)");
            char[] charArray = str3.toCharArray();
            Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
            char[] cArrSemGetPrefixCharForSpan = textUtilsCompat.semGetPrefixCharForSpan(paint, title, charArray);
            arrayList.clear();
            if (cArrSemGetPrefixCharForSpan != null) {
                String str4 = new String(cArrSemGetPrefixCharForSpan);
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                String lowerCase = str4.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                Locale locale2 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale2, "getDefault(...)");
                String lowerCase2 = title.toLowerCase(locale2);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                int iM14129C = StringsKt.m14129C(lowerCase, i, 6, lowerCase2);
                length2 = lowerCase.length();
                while (iM14129C >= 0 && iM14129C <= title.length()) {
                    arrayList.add(Integer.valueOf(iM14129C));
                    Locale locale3 = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale3, "getDefault(...)");
                    String lowerCase3 = title.toLowerCase(locale3);
                    Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                    iM14129C = StringsKt.m14129C(lowerCase, iM14129C + 1, 4, lowerCase3);
                }
            } else {
                Locale locale4 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale4, "getDefault(...)");
                String lowerCase4 = title.toLowerCase(locale4);
                Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                Locale locale5 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale5, "getDefault(...)");
                String lowerCase5 = str3.toLowerCase(locale5);
                Intrinsics.checkNotNullExpressionValue(lowerCase5, "toLowerCase(...)");
                int iM14129C2 = StringsKt.m14129C(lowerCase5, 0, 6, lowerCase4);
                while (iM14129C2 >= 0 && iM14129C2 <= title.length()) {
                    arrayList.add(Integer.valueOf(iM14129C2));
                    Locale locale6 = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale6, "getDefault(...)");
                    String lowerCase6 = title.toLowerCase(locale6);
                    Intrinsics.checkNotNullExpressionValue(lowerCase6, "toLowerCase(...)");
                    Locale locale7 = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale7, "getDefault(...)");
                    String lowerCase7 = str3.toLowerCase(locale7);
                    Intrinsics.checkNotNullExpressionValue(lowerCase7, "toLowerCase(...)");
                    iM14129C2 = StringsKt.m14129C(lowerCase7, iM14129C2 + 1, 4, lowerCase6);
                }
            }
            Iterator<Integer> it = arrayList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                Integer next = it.next();
                if (next != null && next.intValue() >= 0 && next.intValue() + length2 <= title.length()) {
                    spannableStringBuilder.setSpan(CharacterStyle.wrap(foregroundColorSpan), next.intValue(), next.intValue() + length2, 33);
                }
            }
            i2++;
            z = z2;
            i = 0;
        }
        if (Intrinsics.areEqual(Locale.getDefault(), Locale.KOREA) && strArr.length != 0 && arrayList.isEmpty()) {
            for (String str5 : strArr) {
                InitialKoreanUtil initialKoreanUtil = InitialKoreanUtil.INSTANCE;
                if (initialKoreanUtil.checkInitialCharacter(str5)) {
                    char[] charArray2 = str5.toCharArray();
                    Intrinsics.checkNotNullExpressionValue(charArray2, "toCharArray(...)");
                    if (initialKoreanUtil.checkInitialTitle(charArray2, title, arrayList)) {
                        Iterator<Integer> it2 = arrayList.iterator();
                        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                        while (it2.hasNext()) {
                            Integer next2 = it2.next();
                            if (next2 != null && next2.intValue() >= 0 && next2.intValue() + 1 <= title.length()) {
                                spannableStringBuilder.setSpan(CharacterStyle.wrap(foregroundColorSpan), next2.intValue(), next2.intValue() + 1, 33);
                            }
                        }
                    }
                }
            }
        }
        textView.setText(spannableStringBuilder);
    }

    private final void updateItemLayout(AudioPickerViewHolder holder, boolean selected) {
        holder.getMSelectButton().setChecked(selected);
        if (this.mContext == null) {
            return;
        }
        if (!selected) {
            LinearLayout mItemContainer = holder.getMItemContainer();
            Context context = this.mContext;
            Intrinsics.checkNotNull(context);
            Resources resources = context.getResources();
            int i = C11493R.color.audio_picker_bg_color;
            Context context2 = this.mContext;
            mItemContainer.setBackgroundColor(resources.getColor(i, context2 != null ? context2.getTheme() : null));
            return;
        }
        holder.getMItemContainer().requestFocus();
        LinearLayout mItemContainer2 = holder.getMItemContainer();
        Context context3 = this.mContext;
        Intrinsics.checkNotNull(context3);
        Resources resources2 = context3.getResources();
        int i2 = C11493R.color.audio_picker_bg_color_selected;
        Context context4 = this.mContext;
        mItemContainer2.setBackgroundColor(resources2.getColor(i2, context4 != null ? context4.getTheme() : null));
    }

    private final void updateTimeFormat() {
        Context context = this.mContext;
        if (context == null) {
            Logger.m12713i(TAG, "updateTimeFormat mContext is null!!");
            return;
        }
        int i = DateFormat.is24HourFormat(context) ? 24 : 12;
        this.mTimeFormat = i;
        AbstractC11014a.m12327l(i, "updateTimeFormat mTimeFormat = ", TAG);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int i = this.mRecordingMode;
        if ((i != 3 || this.isExpandSearchView) && this.mAudioFileMap.containsKey(Integer.valueOf(i))) {
            return ((ArrayList) MapsKt.getValue(this.mAudioFileMap, Integer.valueOf(this.mRecordingMode))).size() + 1;
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (position == 0) {
            return 2;
        }
        return super.getItemViewType(position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof AudioPickerSortBarHolder) {
            AudioPickerSortBarHolder audioPickerSortBarHolder = (AudioPickerSortBarHolder) holder;
            audioPickerSortBarHolder.initSortState(this.mCurrentSortType, this.mCurrentSortOrder);
            if (this.mRecordingMode == 3) {
                audioPickerSortBarHolder.initInternalStorage(getSearchResultCount() - 1);
                if (this.isExpandSearchView != audioPickerSortBarHolder.getMIsExpand()) {
                    audioPickerSortBarHolder.updateExpandIcon(this.isExpandSearchView);
                }
                ConstraintLayout mInternalStorageLayout = audioPickerSortBarHolder.getMInternalStorageLayout();
                Intrinsics.checkNotNull(mInternalStorageLayout);
                mInternalStorageLayout.setOnClickListener(this);
                ImageView mInternalExpand = audioPickerSortBarHolder.getMInternalExpand();
                Intrinsics.checkNotNull(mInternalExpand);
                mInternalExpand.setOnClickListener(this);
                return;
            }
            return;
        }
        final AudioPickerViewHolder audioPickerViewHolder = (AudioPickerViewHolder) holder;
        if (this.mAudioFileMap.containsKey(Integer.valueOf(this.mRecordingMode))) {
            ArrayList<RecordingItem> arrayList = this.mAudioFileMap.get(Integer.valueOf(this.mRecordingMode));
            final RecordingItem recordingItem = arrayList != null ? arrayList.get(position - 1) : null;
            if (recordingItem != null) {
                if (this.mReInitSelectedItem != null && this.mRecordingMode == this.mReInitSelectedMode) {
                    String path = recordingItem.getPath();
                    RecordingItem recordingItem2 = this.mReInitSelectedItem;
                    Intrinsics.checkNotNull(recordingItem2);
                    if (Intrinsics.areEqual(path, recordingItem2.getPath())) {
                        this.mPrevItemSelect = recordingItem;
                        recordingItem.setSelected(true);
                        this.mReInitSelectedItem = null;
                    }
                }
                if (recordingItem.getTitle() != null) {
                    TextView mTitle = audioPickerViewHolder.getMTitle();
                    String title = recordingItem.getTitle();
                    Intrinsics.checkNotNull(title);
                    setTitleViewColor(mTitle, title);
                }
                audioPickerViewHolder.getMDate().setText(getMediumDateFormat(recordingItem.getDate()));
                audioPickerViewHolder.getMSize().setText(getSizeFormat(recordingItem.getSize()));
                updateItemLayout(audioPickerViewHolder, recordingItem.getIsSelected());
                final int i = 0;
                audioPickerViewHolder.getMItemContainer().setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.stt.picker.view.a

                    /* JADX INFO: renamed from: b */
                    public final /* synthetic */ AudioPickerListViewAdapter f7867b;

                    {
                        this.f7867b = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        switch (i) {
                            case 0:
                                this.f7867b.selectItem(audioPickerViewHolder, recordingItem);
                                break;
                            default:
                                this.f7867b.selectItem(audioPickerViewHolder, recordingItem);
                                break;
                        }
                    }
                });
                final int i2 = 1;
                audioPickerViewHolder.getMSelectButton().setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.stt.picker.view.a

                    /* JADX INFO: renamed from: b */
                    public final /* synthetic */ AudioPickerListViewAdapter f7867b;

                    {
                        this.f7867b = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        switch (i2) {
                            case 0:
                                this.f7867b.selectItem(audioPickerViewHolder, recordingItem);
                                break;
                            default:
                                this.f7867b.selectItem(audioPickerViewHolder, recordingItem);
                                break;
                        }
                    }
                });
                audioPickerViewHolder.getMPlayContainer().setOnClickListener(new ViewOnClickListenerC11512c(this, recordingItem, 2));
            }
            if (position == getItemCount() - 1) {
                audioPickerViewHolder.getMDividerItem().setVisibility(8);
            } else {
                audioPickerViewHolder.getMDividerItem().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        int id = v.getId();
        if (id == C11493R.id.internal_expand_ic || id == C11493R.id.internal_storage_infor_layout) {
            this.isExpandSearchView = !this.isExpandSearchView;
            InputMethodCompat.INSTANCE.getInstance().hideSoftInput(this.mContext, v);
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 2) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(C11493R.layout.audio_picker_sort_bar_layout, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
            return new AudioPickerSortBarHolder(viewInflate, this.mAdapterContract);
        }
        View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(C11493R.layout.audio_picker_item_layout, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate2, "inflate(...)");
        return new AudioPickerViewHolder(viewInflate2);
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.picker.model.LoadVoiceListener
    public void onUpdate() {
        new Handler(Looper.getMainLooper()).post(new RunnableC9767a(this, 27));
    }

    public final void resetPrevItemSelect() {
        this.mPrevItemSelect = null;
    }

    public final void setData(@NotNull Map<Integer, ? extends ArrayList<RecordingItem>> audioFileMap) {
        Intrinsics.checkNotNullParameter(audioFileMap, "audioFileMap");
        this.mAudioFileMap = audioFileMap;
    }

    public final void setHighlightText(@NotNull String highlightText) {
        Intrinsics.checkNotNullParameter(highlightText, "highlightText");
        this.mHighlightText = highlightText;
        notifyDataSetChanged();
    }

    public final void setReInitItemSelect(@NotNull RecordingItem recordingItem, int selectMode) {
        Intrinsics.checkNotNullParameter(recordingItem, "recordingItem");
        this.mReInitSelectedItem = recordingItem;
        this.mReInitSelectedMode = selectMode;
        notifyDataSetChanged();
    }

    public final void setRecordingMode(int recordingMode) {
        this.mRecordingMode = recordingMode;
        updateData();
        if (this.mRecordingMode != 3) {
            this.mAdapterContract.updateNoResultView(getItemCount() == 1);
        }
    }

    public final void setSortState(int sortType, int sortOrder) {
        this.mCurrentSortType = sortType;
        this.mCurrentSortOrder = sortOrder;
    }

    public final void sortItem(final int sortType, final int sortOrder) {
        this.mCurrentSortType = sortType;
        this.mCurrentSortOrder = sortOrder;
        ArrayList arrayList = this.mAudioFileMap.get(Integer.valueOf(this.mRecordingMode));
        if (arrayList == null || arrayList.size() == 0) {
            notifyDataSetChanged();
            return;
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        Collections.sort(arrayList2, new Comparator<RecordingItem>() { // from class: com.samsung.android.support.senl.nt.stt.picker.view.AudioPickerListViewAdapter.sortItem.1
            @Override // java.util.Comparator
            public int compare(RecordingItem o12, RecordingItem o22) {
                Intrinsics.checkNotNullParameter(o12, "o1");
                Intrinsics.checkNotNullParameter(o22, "o2");
                int i = sortType;
                if (i == 1) {
                    return sortOrder == 4 ? Intrinsics.compare(o12.getDate(), o22.getDate()) : Intrinsics.compare(o22.getDate(), o12.getDate());
                }
                if (i != 2) {
                    if (i != 3) {
                        return 0;
                    }
                    return sortOrder == 4 ? Intrinsics.compare(o12.getSize(), o22.getSize()) : Intrinsics.compare(o22.getSize(), o12.getSize());
                }
                if (sortOrder == 4) {
                    String title = o12.getTitle();
                    Intrinsics.checkNotNull(title);
                    String title2 = o22.getTitle();
                    Intrinsics.checkNotNull(title2);
                    return title.compareTo(title2);
                }
                String title3 = o22.getTitle();
                Intrinsics.checkNotNull(title3);
                String title4 = o12.getTitle();
                Intrinsics.checkNotNull(title4);
                return title3.compareTo(title4);
            }
        });
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            arrayList.set(i, arrayList2.get(i));
        }
        notifyDataSetChanged();
    }

    public final void updateData() {
        sortItem(this.mCurrentSortType, this.mCurrentSortOrder);
    }
}
