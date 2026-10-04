package com.samsung.android.support.senl.p148nt.stt.view;

import android.content.Context;
import android.graphics.PointF;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.glance.AbstractC2821a;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.BasePenRecyclerView;
import com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.OnPenMultiSelectionListener;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.RunnableC9767a;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.RunnableC10887m;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.stt.C11493R;
import com.samsung.android.support.senl.p148nt.stt.base.model.AiParagraphInfo;
import com.samsung.android.support.senl.p148nt.stt.base.model.AiTextData;
import com.samsung.android.support.senl.p148nt.stt.base.model.AiTextDataTask;
import com.samsung.android.support.senl.p148nt.stt.base.model.TextData;
import com.samsung.android.support.senl.p148nt.stt.base.model.TextDataCreator;
import com.samsung.android.support.senl.p148nt.stt.base.model.mode.STTMode;
import com.samsung.android.support.senl.p148nt.stt.base.model.paint.PaintHelper;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import com.samsung.android.support.senl.p148nt.stt.common.constant.DialogConstant;
import com.samsung.android.support.senl.p148nt.stt.contract.STTPresenterContract;
import com.samsung.android.support.senl.p148nt.stt.presenter.STTPresenter;
import com.samsung.android.support.senl.p148nt.stt.view.AiSTTListViewAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import org.bitbucket.cowwoc.diffmatchpatch.DiffMatchPatch;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p012C1.RunnableC0050f;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u008f\u00012\u00020\u0001:\b\u008c\u0001\u008d\u0001\u008e\u0001\u008f\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u0010\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010\u001aJ\b\u0010?\u001a\u00020=H\u0002J\b\u0010@\u001a\u00020=H\u0002J\u0018\u0010A\u001a\u00020=2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\nH\u0002J\u0006\u0010E\u001a\u00020=J\u000e\u0010F\u001a\u00020=2\u0006\u0010G\u001a\u00020!J \u0010H\u001a\u00020=2\u0016\u0010I\u001a\u0012\u0012\u0004\u0012\u00020K0Jj\b\u0012\u0004\u0012\u00020K`LH\u0002J \u0010M\u001a\u0002022\u0016\u0010I\u001a\u0012\u0012\u0004\u0012\u00020K0Jj\b\u0012\u0004\u0012\u00020K`LH\u0002J$\u0010N\u001a\u00020=2\u001a\u0010O\u001a\u0016\u0012\u0004\u0012\u00020K\u0018\u00010Jj\n\u0012\u0004\u0012\u00020K\u0018\u0001`LH\u0002J\u0012\u0010P\u001a\u0004\u0018\u00010$2\u0006\u0010Q\u001a\u00020\nH\u0002J$\u0010R\u001a\u0002022\u001a\u0010O\u001a\u0016\u0012\u0004\u0012\u00020K\u0018\u00010Jj\n\u0012\u0004\u0012\u00020K\u0018\u0001`LH\u0002J\u0018\u0010S\u001a\u00020=2\u0006\u0010D\u001a\u00020\n2\b\b\u0002\u0010T\u001a\u000202J\u0006\u0010U\u001a\u00020=J\u000e\u0010V\u001a\u00020=2\u0006\u0010W\u001a\u00020XJ\u0006\u0010Y\u001a\u00020=J\u000e\u0010Z\u001a\u00020=2\u0006\u0010[\u001a\u000202J\u000e\u0010\\\u001a\u00020=2\u0006\u0010]\u001a\u000202J\b\u0010_\u001a\u00020=H\u0002J\b\u0010`\u001a\u00020=H\u0002J\u0006\u0010S\u001a\u00020=J4\u0010a\u001a\u00020=2\u0006\u0010b\u001a\u00020\n2\u0006\u0010c\u001a\u00020\n2\b\b\u0002\u0010d\u001a\u0002022\b\b\u0002\u0010e\u001a\u00020f2\b\b\u0002\u0010g\u001a\u00020hJ\u001a\u0010i\u001a\u00020\n2\b\u0010j\u001a\u0004\u0018\u00010k2\u0006\u0010c\u001a\u00020\nH\u0002J\u0016\u0010l\u001a\u00020=2\u000e\u0010m\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eJ\u000e\u0010n\u001a\u00020$2\u0006\u0010o\u001a\u000202J\u000e\u0010s\u001a\u00020=2\u0006\u0010t\u001a\u00020\nJ\u0006\u0010u\u001a\u00020=J\u0010\u0010v\u001a\u00020=2\b\u0010w\u001a\u0004\u0018\u00010xJ\u000e\u0010|\u001a\u00020=2\u0006\u0010}\u001a\u000202J\u000e\u0010~\u001a\u00020=2\u0006\u0010D\u001a\u00020\nJ\u0007\u0010\u0081\u0001\u001a\u00020=J\u001e\u0010\u0082\u0001\u001a\u00020=2\u0015\u0010\u0083\u0001\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u000202\u0018\u00010#J\u0007\u0010\u0087\u0001\u001a\u00020=J\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u001cJc\u0010\u0089\u0001\u001aE\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n0Jj\b\u0012\u0004\u0012\u00020\n`L\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020+0Jj\b\u0012\u0004\u0012\u00020+`L\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020+0Jj\b\u0012\u0004\u0012\u00020+`L0\u008a\u00012\u0017\u0010\u008b\u0001\u001a\u0012\u0012\u0004\u0012\u0002060Jj\b\u0012\u0004\u0012\u000206`LR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020$0#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u000e\u00100\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00101\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u000202\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00105\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00107\u001a\u000202X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0011\u0010^\u001a\u0002028F¢\u0006\u0006\u001a\u0004\b^\u00109R\u0011\u0010p\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\bq\u0010rR\u0019\u0010m\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010y8F¢\u0006\u0006\u001a\u0004\bz\u0010{R%\u0010\u007f\u001a\u0002022\u0006\u0010\u007f\u001a\u0002028F@FX\u0086\u000e¢\u0006\r\u001a\u0004\b\u007f\u00109\"\u0005\b\u0080\u0001\u0010;R#\u0010\u0083\u0001\u001a\u0011\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u000202\u0018\u00010\u0084\u00018F¢\u0006\b\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001¨\u0006\u0090\u0001"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/view/AiSTTListView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "sttRecyclerView", "Lcom/samsung/android/support/senl/nt/base/common/view/penrecyclerview/BasePenRecyclerView;", "getSttRecyclerView", "()Lcom/samsung/android/support/senl/nt/base/common/view/penrecyclerview/BasePenRecyclerView;", "setSttRecyclerView", "(Lcom/samsung/android/support/senl/nt/base/common/view/penrecyclerview/BasePenRecyclerView;)V", "value", "Lcom/samsung/android/support/senl/nt/stt/view/AiSTTListView$ScrollLinearLayoutManager;", "sttLayoutManager", "getSttLayoutManager", "()Lcom/samsung/android/support/senl/nt/stt/view/AiSTTListView$ScrollLinearLayoutManager;", "mSTTPresenterContract", "Lcom/samsung/android/support/senl/nt/stt/contract/STTPresenterContract;", "mAiSTTListViewAdapter", "Lcom/samsung/android/support/senl/nt/stt/view/AiSTTListViewAdapter;", "mAiTextDataList", "", "Lcom/samsung/android/support/senl/nt/stt/base/model/AiTextData;", "mSTTVoiceItem", "Lcom/samsung/android/support/senl/nt/stt/view/STTVoiceItem;", "mSpeakerNameMap", "", "", "mContext", "mPaintHelper", "Lcom/samsung/android/support/senl/nt/stt/base/model/paint/PaintHelper;", "mSmoothScroller", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "mUserScrollTime", "", "getMUserScrollTime", "()J", "setMUserScrollTime", "(J)V", "mDiffY", "mSelectedItemMap", "", "lastScrollPosition", "calculatedScrollDistance", "mAiParagraphInfo", "Lcom/samsung/android/support/senl/nt/stt/base/model/AiParagraphInfo;", "mIsNeedToUpdateParagraphInfo", "getMIsNeedToUpdateParagraphInfo", "()Z", "setMIsNeedToUpdateParagraphInfo", "(Z)V", "setSTTPresenterContract", "", "sttPresenterContract", "init", "initAdapter", "renameSpeaker", "bundle", "Landroid/os/Bundle;", "position", "initPainter", "initSTTVoiceItems", "voiceItem", "initAiTextDataList", "textDataList", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/nt/stt/base/model/TextData;", "Lkotlin/collections/ArrayList;", "isParagraphInfoValid", "updateAiTextDataList", "result", "getSpeakerName", "speakerId", "isEmptyResultTextData", "updateSTTReplay", "forceUpdate", "scrollToLastPosition", "onModeChanged", "mode", "Lcom/samsung/android/support/senl/nt/stt/base/model/mode/STTMode;", "onShowSpeakerLabelChanged", "setEditMode", "isEditMode", "saveSTTData", "isUpdated", "isDataChanged", "resetAiTextData", "updateAiTextData", "scrollToItem", "positionItem", TextConst.KEY_START_INDEX, "forceScroll", "scrollType", "Lcom/samsung/android/support/senl/nt/stt/view/AiSTTListView$ScrollItemType;", "scrollDirection", "Lcom/samsung/android/support/senl/nt/stt/view/AiSTTListView$ScrollItemDirection;", "getTopPosition", "textView", "Landroid/widget/TextView;", "setAiTextDataList", "aiTextDataList", "getSTTCurrentVoiceItemText", "isContainHeader", "currentVoiceItemSelectedText", "getCurrentVoiceItemSelectedText", "()Ljava/lang/String;", "notifyItemChanged", "index", "notifyDataSetChanged", "notifyAdapter", "runnable", "Ljava/lang/Runnable;", "", "getAiTextDataList", "()Ljava/util/List;", "setTranslateMode", "isTranslateMode", "setSelected", "isSelectionMode", "setSelectionMode", "deleteSelectedItem", "setSelectedItemMap", "selectedItemMap", "", "getSelectedItemMap", "()Ljava/util/Map;", "updateListMargin", "getAdapter", "convertParagraphInfoToArrays", "Lkotlin/Triple;", "paragraphInfoList", "ScrollItemType", "ScrollItemDirection", "ScrollLinearLayoutManager", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAiSTTListView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AiSTTListView.kt\ncom/samsung/android/support/senl/nt/stt/view/AiSTTListView\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,985:1\n1878#2,3:986\n*S KotlinDebug\n*F\n+ 1 AiSTTListView.kt\ncom/samsung/android/support/senl/nt/stt/view/AiSTTListView\n*L\n571#1:986,3\n*E\n"})
public final class AiSTTListView extends RelativeLayout {

    @NotNull
    private static final String TAG = "AiSTTListView";
    public static final long USER_SCROLL_INTERVAL = 3000;
    private int calculatedScrollDistance;
    private int lastScrollPosition;

    @Nullable
    private List<AiParagraphInfo> mAiParagraphInfo;

    @Nullable
    private AiSTTListViewAdapter mAiSTTListViewAdapter;

    @Nullable
    private List<AiTextData> mAiTextDataList;

    @NotNull
    private Context mContext;
    private int mDiffY;
    private boolean mIsNeedToUpdateParagraphInfo;

    @Nullable
    private PaintHelper mPaintHelper;

    @Nullable
    private STTPresenterContract mSTTPresenterContract;

    @Nullable
    private STTVoiceItem mSTTVoiceItem;

    @Nullable
    private Map<Integer, Boolean> mSelectedItemMap;

    @Nullable
    private LinearSmoothScroller mSmoothScroller;

    @NotNull
    private Map<Integer, String> mSpeakerNameMap;
    private long mUserScrollTime;

    @Nullable
    private ScrollLinearLayoutManager sttLayoutManager;

    @Nullable
    private BasePenRecyclerView sttRecyclerView;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/view/AiSTTListView$ScrollItemDirection;", "", "<init>", "(Ljava/lang/String;I)V", "UP", "DOWN", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ScrollItemDirection {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ScrollItemDirection[] $VALUES;

        /* JADX INFO: renamed from: UP */
        public static final ScrollItemDirection f7921UP = new ScrollItemDirection("UP", 0);
        public static final ScrollItemDirection DOWN = new ScrollItemDirection("DOWN", 1);

        private static final /* synthetic */ ScrollItemDirection[] $values() {
            return new ScrollItemDirection[]{f7921UP, DOWN};
        }

        static {
            ScrollItemDirection[] scrollItemDirectionArr$values = $values();
            $VALUES = scrollItemDirectionArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(scrollItemDirectionArr$values);
        }

        private ScrollItemDirection(String str, int i) {
        }

        @NotNull
        public static EnumEntries<ScrollItemDirection> getEntries() {
            return $ENTRIES;
        }

        public static ScrollItemDirection valueOf(String str) {
            return (ScrollItemDirection) Enum.valueOf(ScrollItemDirection.class, str);
        }

        public static ScrollItemDirection[] values() {
            return (ScrollItemDirection[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/view/AiSTTListView$ScrollItemType;", "", "<init>", "(Ljava/lang/String;I)V", "SPEAKER_NAME", SearchConstants.TargetContents.STT_CONTENT, "TRANSLATE_TEXT", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ScrollItemType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ScrollItemType[] $VALUES;
        public static final ScrollItemType SPEAKER_NAME = new ScrollItemType("SPEAKER_NAME", 0);
        public static final ScrollItemType STT_CONTENT = new ScrollItemType(SearchConstants.TargetContents.STT_CONTENT, 1);
        public static final ScrollItemType TRANSLATE_TEXT = new ScrollItemType("TRANSLATE_TEXT", 2);

        private static final /* synthetic */ ScrollItemType[] $values() {
            return new ScrollItemType[]{SPEAKER_NAME, STT_CONTENT, TRANSLATE_TEXT};
        }

        static {
            ScrollItemType[] scrollItemTypeArr$values = $values();
            $VALUES = scrollItemTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(scrollItemTypeArr$values);
        }

        private ScrollItemType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<ScrollItemType> getEntries() {
            return $ENTRIES;
        }

        public static ScrollItemType valueOf(String str) {
            return (ScrollItemType) Enum.valueOf(ScrollItemType.class, str);
        }

        public static ScrollItemType[] values() {
            return (ScrollItemType[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u00020\u0007H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\n¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/view/AiSTTListView$ScrollLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "isScrollable", "", "()Z", "setScrollable", "(Z)V", "canScrollVertically", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ScrollLinearLayoutManager extends LinearLayoutManager {
        private boolean isScrollable;

        public ScrollLinearLayoutManager(@Nullable Context context) {
            super(context);
            this.isScrollable = true;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            if (this.isScrollable) {
                return super.canScrollVertically();
            }
            return false;
        }

        /* JADX INFO: renamed from: isScrollable, reason: from getter */
        public final boolean getIsScrollable() {
            return this.isScrollable;
        }

        public final void setScrollable(boolean z) {
            this.isScrollable = z;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ScrollItemType.values().length];
            try {
                iArr[ScrollItemType.SPEAKER_NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ScrollItemType.STT_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ScrollItemType.TRANSLATE_TEXT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiSTTListView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mAiTextDataList = new ArrayList();
        this.mSpeakerNameMap = new HashMap();
        this.mSelectedItemMap = new TreeMap();
        this.lastScrollPosition = -1;
        this.mAiParagraphInfo = new ArrayList();
        this.mContext = context;
        init();
    }

    private final String getSpeakerName(int speakerId) {
        String string = getResources().getString(C11493R.string.stt_speaker_pd, Integer.valueOf(speakerId));
        Map<Integer, String> map = this.mSpeakerNameMap;
        return (map == null || !map.containsKey(Integer.valueOf(speakerId))) ? string : this.mSpeakerNameMap.get(Integer.valueOf(speakerId));
    }

    private final int getTopPosition(TextView textView, int startIndex) {
        if (textView == null || textView.getLayout() == null) {
            return 0;
        }
        return textView.getLayout().getLineTop(textView.getLayout().getLineForOffset(startIndex));
    }

    private final void init() {
        this.mPaintHelper = new PaintHelper(this.mContext);
        this.sttRecyclerView = new BasePenRecyclerView(new ContextThemeWrapper(this.mContext, C11493R.style.ScrollbarRecyclerView));
        ScrollLinearLayoutManager scrollLinearLayoutManager = new ScrollLinearLayoutManager(this.mContext);
        this.sttLayoutManager = scrollLinearLayoutManager;
        scrollLinearLayoutManager.setOrientation(1);
        ScrollLinearLayoutManager scrollLinearLayoutManager2 = this.sttLayoutManager;
        if (scrollLinearLayoutManager2 != null) {
            scrollLinearLayoutManager2.setScrollable(true);
        }
        BasePenRecyclerView basePenRecyclerView = this.sttRecyclerView;
        Intrinsics.checkNotNull(basePenRecyclerView);
        basePenRecyclerView.setLayoutManager(this.sttLayoutManager);
        BasePenRecyclerView basePenRecyclerView2 = this.sttRecyclerView;
        Intrinsics.checkNotNull(basePenRecyclerView2);
        RecyclerView.ItemAnimator itemAnimator = basePenRecyclerView2.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        }
        BasePenRecyclerView basePenRecyclerView3 = this.sttRecyclerView;
        Intrinsics.checkNotNull(basePenRecyclerView3);
        basePenRecyclerView3.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        this.mUserScrollTime = 0L;
        BasePenRecyclerView basePenRecyclerView4 = this.sttRecyclerView;
        Intrinsics.checkNotNull(basePenRecyclerView4);
        basePenRecyclerView4.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.samsung.android.support.senl.nt.stt.view.AiSTTListView.init.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                if (newState == 1) {
                    AiSTTListView.this.setMUserScrollTime(System.currentTimeMillis());
                }
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrolled(recyclerView, dx, dy);
            }
        });
        this.mSmoothScroller = new LinearSmoothScroller(getContext()) { // from class: com.samsung.android.support.senl.nt.stt.view.AiSTTListView.init.2
            private final int DURATION = 200;

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public int calculateDtToFit(int viewStart, int viewEnd, int boxStart, int boxEnd, int snapPreference) {
                AiSTTListView aiSTTListView = AiSTTListView.this;
                aiSTTListView.calculatedScrollDistance = (boxStart - aiSTTListView.mDiffY) - viewStart;
                int i = AiSTTListView.this.mDiffY;
                int i2 = AiSTTListView.this.calculatedScrollDistance;
                StringBuilder sbM1173s = AbstractC0622a.m1173s(viewStart, viewEnd, "calculateDtToFit : ", " ", " ");
                AbstractC2821a.m2235z(sbM1173s, boxStart, boxEnd, " ", " ");
                sbM1173s.append(i);
                sbM1173s.append(" ");
                sbM1173s.append(i2);
                Logger.m12713i(AiSTTListView.TAG, sbM1173s.toString());
                return AiSTTListView.this.calculatedScrollDistance;
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public int calculateDyToMakeVisible(View view, int snapPreference) {
                Intrinsics.checkNotNullParameter(view, "view");
                return super.calculateDyToMakeVisible(view, snapPreference);
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public int calculateTimeForScrolling(int dx) {
                return this.DURATION;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
            public PointF computeScrollVectorForPosition(int targetPosition) {
                return super.computeScrollVectorForPosition(targetPosition);
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public int getVerticalSnapPreference() {
                return -1;
            }
        };
        BasePenRecyclerView basePenRecyclerView5 = this.sttRecyclerView;
        Intrinsics.checkNotNull(basePenRecyclerView5);
        basePenRecyclerView5.setOnPenMultiSelectionListener(new OnPenMultiSelectionListener() { // from class: com.samsung.android.support.senl.nt.stt.view.AiSTTListView.init.3
            @Override // com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.OnPenMultiSelectionListener
            public void onSelectedItemPosition(ArrayList<Integer> selectedItemPosition, int recyclerViewWidth, int penDragLeft, int penDragRight) {
                Intrinsics.checkNotNullParameter(selectedItemPosition, "selectedItemPosition");
                if (selectedItemPosition.isEmpty()) {
                    return;
                }
                STTPresenterContract sTTPresenterContract = AiSTTListView.this.mSTTPresenterContract;
                Intrinsics.checkNotNull(sTTPresenterContract);
                if (!sTTPresenterContract.getSTTPresenter().isSelectionMode()) {
                    STTPresenterContract sTTPresenterContract2 = AiSTTListView.this.mSTTPresenterContract;
                    Intrinsics.checkNotNull(sTTPresenterContract2);
                    sTTPresenterContract2.getSTTPresenter().toggleSTTSelectionMode(true);
                }
                Iterator<Integer> it = selectedItemPosition.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    int iIntValue = it.next().intValue();
                    AiSTTListViewAdapter aiSTTListViewAdapter = AiSTTListView.this.mAiSTTListViewAdapter;
                    if (aiSTTListViewAdapter != null) {
                        aiSTTListViewAdapter.toggleSelectItem(iIntValue);
                    }
                }
            }
        });
        initAdapter();
        BasePenRecyclerView basePenRecyclerView6 = this.sttRecyclerView;
        Intrinsics.checkNotNull(basePenRecyclerView6);
        basePenRecyclerView6.setAdapter(this.mAiSTTListViewAdapter);
        removeAllViews();
        addView(this.sttRecyclerView);
    }

    private final void initAdapter() {
        this.mAiSTTListViewAdapter = new AiSTTListViewAdapter(new AiSTTListViewAdapterContract() { // from class: com.samsung.android.support.senl.nt.stt.view.AiSTTListView.initAdapter.1
            @Override // com.samsung.android.support.senl.p148nt.stt.view.AiSTTListViewAdapterContract
            public void clearSTTFocus() {
                AiSTTListView.this.clearFocus();
            }

            @Override // com.samsung.android.support.senl.p148nt.stt.view.AiSTTListViewAdapterContract
            public PaintHelper getPaintHelper() {
                return AiSTTListView.this.mPaintHelper;
            }

            @Override // com.samsung.android.support.senl.p148nt.stt.view.AiSTTListViewAdapterContract
            public Map<Integer, String> getSpeakerNameMap() {
                return AiSTTListView.this.mSpeakerNameMap;
            }

            @Override // com.samsung.android.support.senl.p148nt.stt.view.AiSTTListViewAdapterContract
            public void onEditTextChanged(String string, int pos) {
                Intrinsics.checkNotNullParameter(string, "string");
                STTPresenterContract sTTPresenterContract = AiSTTListView.this.mSTTPresenterContract;
                Intrinsics.checkNotNull(sTTPresenterContract);
                sTTPresenterContract.onEditTextChanged(string, pos);
            }

            @Override // com.samsung.android.support.senl.p148nt.stt.view.AiSTTListViewAdapterContract
            public void onEditWordTouched() {
                STTPresenterContract sTTPresenterContract = AiSTTListView.this.mSTTPresenterContract;
                Intrinsics.checkNotNull(sTTPresenterContract);
                sTTPresenterContract.onEditWordTouch();
            }

            @Override // com.samsung.android.support.senl.p148nt.stt.view.AiSTTListViewAdapterContract
            public void onItemCheckedChange(int position, boolean isChecked) {
                if (AiSTTListView.this.mSTTPresenterContract != null) {
                    STTPresenterContract sTTPresenterContract = AiSTTListView.this.mSTTPresenterContract;
                    Intrinsics.checkNotNull(sTTPresenterContract);
                    sTTPresenterContract.onSTTItemCheckedChange(position, isChecked);
                }
            }

            @Override // com.samsung.android.support.senl.p148nt.stt.view.AiSTTListViewAdapterContract
            public void onSpeakerRename(Bundle bundle, int position) {
                Intrinsics.checkNotNullParameter(bundle, "bundle");
                AiSTTListView.this.renameSpeaker(bundle, position);
            }

            @Override // com.samsung.android.support.senl.p148nt.stt.view.AiSTTListViewAdapterContract
            public void onWordTouched(int touchedWordTimestamp) {
                if (AiSTTListView.this.mSTTPresenterContract != null) {
                    STTPresenterContract sTTPresenterContract = AiSTTListView.this.mSTTPresenterContract;
                    Intrinsics.checkNotNull(sTTPresenterContract);
                    sTTPresenterContract.onWordTouch(touchedWordTimestamp);
                }
            }
        });
    }

    private final synchronized void initAiTextDataList(ArrayList<TextData> textDataList) {
        try {
            List<AiTextData> list = this.mAiTextDataList;
            Intrinsics.checkNotNull(list);
            list.clear();
            if (this.mAiParagraphInfo == null) {
                this.mAiParagraphInfo = new ArrayList();
            }
            List<AiParagraphInfo> list2 = this.mAiParagraphInfo;
            Intrinsics.checkNotNull(list2);
            if (list2.isEmpty()) {
                Logger.m12713i(TAG, "initAiTextDataList# mAiParagraphInfo is empty");
            } else if (isParagraphInfoValid(textDataList)) {
                Logger.m12713i(TAG, "initAiTextDataList# mAiParagraphInfo is valid");
                setAiTextDataList(this.mAiTextDataList);
                return;
            } else {
                Logger.m12713i(TAG, "initAiTextDataList# mAiParagraphInfo is invalid, need to clear and generate again");
                this.mIsNeedToUpdateParagraphInfo = true;
                List<AiParagraphInfo> list3 = this.mAiParagraphInfo;
                Intrinsics.checkNotNull(list3);
                list3.clear();
            }
            List<AiTextData> list4 = this.mAiTextDataList;
            int iHashCode = list4 != null ? list4.hashCode() : 0;
            List<AiTextData> list5 = this.mAiTextDataList;
            Logger.m12710d(TAG, "initAiTextDataList# mAiTextDataList before " + iHashCode + " size " + (list5 != null ? Integer.valueOf(list5.size()) : null));
            List<AiParagraphInfo> list6 = this.mAiParagraphInfo;
            Intrinsics.checkNotNull(list6);
            if (list6.isEmpty()) {
                new AiTextDataTask(textDataList, new AiTextDataTask.Callback() { // from class: com.samsung.android.support.senl.nt.stt.view.AiSTTListView.initAiTextDataList.1
                    @Override // com.samsung.android.support.senl.nt.stt.base.model.AiTextDataTask.Callback
                    public void onResult(ArrayList<TextData> result) {
                        List list7 = AiSTTListView.this.mAiTextDataList;
                        int iHashCode2 = list7 != null ? list7.hashCode() : 0;
                        List list8 = AiSTTListView.this.mAiTextDataList;
                        Logger.m12710d(AiSTTListView.TAG, "initAiTextDataList# mAiTextDataList after " + iHashCode2 + " size " + (list8 != null ? Integer.valueOf(list8.size()) : null));
                        AiSTTListView.this.updateAiTextDataList(result);
                        AiSTTListView aiSTTListView = AiSTTListView.this;
                        aiSTTListView.setAiTextDataList(aiSTTListView.mAiTextDataList);
                    }

                    @Override // com.samsung.android.support.senl.nt.stt.base.model.AiTextDataTask.Callback
                    public void onUpdate(ArrayList<TextData> result) {
                        AiSTTListView.this.updateAiTextDataList(result);
                    }
                }).start();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private final boolean isEmptyResultTextData(ArrayList<TextData> result) {
        return result != null && result.size() == 1 && Intrinsics.areEqual(result.get(0).getText(), "... ");
    }

    private final boolean isParagraphInfoValid(ArrayList<TextData> textDataList) {
        List<AiParagraphInfo> list = this.mAiParagraphInfo;
        Intrinsics.checkNotNull(list);
        if (list.isEmpty()) {
            return false;
        }
        List<AiParagraphInfo> list2 = this.mAiParagraphInfo;
        Intrinsics.checkNotNull(list2);
        for (AiParagraphInfo aiParagraphInfo : list2) {
            Integer speakerId = aiParagraphInfo.getSpeakerId();
            Long startTime = aiParagraphInfo.getStartTime();
            Long endTime = aiParagraphInfo.getEndTime();
            ArrayList<AiTextData.SpannableIndex> arrayList = new ArrayList<>();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            ArrayList arrayList2 = new ArrayList();
            Iterator<TextData> it = textDataList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                TextData next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                TextData textData = next;
                long startTime2 = textData.getStartTime();
                Intrinsics.checkNotNull(startTime);
                if (startTime2 >= startTime.longValue()) {
                    long endTime2 = textData.getEndTime();
                    Intrinsics.checkNotNull(endTime);
                    if (endTime2 <= endTime.longValue() && (textData.getStartTime() != textData.getEndTime() || textData.getStartTime() == endTime.longValue())) {
                        arrayList2.add(textData);
                        arrayList.add(new AiTextData.SpannableIndex(spannableStringBuilder.length(), (textData.getTextLength() + spannableStringBuilder.length()) - 1));
                        spannableStringBuilder.append((CharSequence) textData.getText());
                    }
                }
            }
            if (spannableStringBuilder.length() > 1010) {
                List<AiTextData> list3 = this.mAiTextDataList;
                Intrinsics.checkNotNull(list3);
                list3.clear();
                return false;
            }
            Intrinsics.checkNotNull(speakerId);
            int iIntValue = speakerId.intValue();
            String speakerName = getSpeakerName(speakerId.intValue());
            Intrinsics.checkNotNull(speakerName);
            Intrinsics.checkNotNull(startTime);
            int iLongValue = (int) startTime.longValue();
            Intrinsics.checkNotNull(endTime);
            AiTextData aiTextData = new AiTextData(iIntValue, speakerName, iLongValue, (int) endTime.longValue(), spannableStringBuilder, arrayList2);
            aiTextData.setSpannableIndexList(arrayList);
            List<AiTextData> list4 = this.mAiTextDataList;
            Intrinsics.checkNotNull(list4);
            list4.add(aiTextData);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyAdapter$lambda$4(AiSTTListView aiSTTListView, Runnable runnable) {
        BasePenRecyclerView basePenRecyclerView = aiSTTListView.sttRecyclerView;
        Intrinsics.checkNotNull(basePenRecyclerView);
        basePenRecyclerView.post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyDataSetChanged$lambda$3(AiSTTListView aiSTTListView) {
        AiSTTListViewAdapter aiSTTListViewAdapter = aiSTTListView.mAiSTTListViewAdapter;
        Intrinsics.checkNotNull(aiSTTListViewAdapter);
        aiSTTListViewAdapter.notifyDataSetChanged();
        Logger.m12710d(TAG, "notifyDataSetChanged");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyItemChanged$lambda$2(AiSTTListView aiSTTListView, int i) {
        AiSTTListViewAdapter aiSTTListViewAdapter = aiSTTListView.mAiSTTListViewAdapter;
        Intrinsics.checkNotNull(aiSTTListViewAdapter);
        aiSTTListViewAdapter.notifyItemChanged(i);
        Logger.m12710d(TAG, "notifyItemChanged " + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renameSpeaker(Bundle bundle, int position) {
        int i;
        if (position >= 0) {
            List<AiTextData> list = this.mAiTextDataList;
            Intrinsics.checkNotNull(list);
            if (position >= list.size()) {
                return;
            }
            if (bundle.containsKey(DialogConstant.BUNDLE_NEW_SPEAKER_ID)) {
                i = bundle.getInt(DialogConstant.BUNDLE_NEW_SPEAKER_ID);
                AbstractC11014a.m12327l(i, "speakerId from BUNDLE ", TAG);
            } else {
                ArrayList arrayList = new ArrayList();
                List<AiTextData> list2 = this.mAiTextDataList;
                Intrinsics.checkNotNull(list2);
                Iterator<AiTextData> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(Integer.valueOf(it.next().getSpeakerId()));
                }
                int i2 = 1;
                while (arrayList.contains(Integer.valueOf(i2))) {
                    i2++;
                }
                AbstractC11014a.m12327l(i2, "new speakerId added ", TAG);
                i = i2;
            }
            String string = bundle.getString("name");
            Integer numValueOf = Integer.valueOf(i);
            Map<Integer, String> map = this.mSpeakerNameMap;
            Intrinsics.checkNotNull(string);
            map.put(numValueOf, string);
            STTPresenterContract sTTPresenterContract = this.mSTTPresenterContract;
            Intrinsics.checkNotNull(sTTPresenterContract);
            sTTPresenterContract.onSpeakerNameMapChanged(this.mSpeakerNameMap);
            Logger.m12713i(TAG, "renameSpeaker#onDialogResult - speakerId : " + i + " speakerName : " + string);
            int i4 = bundle.getInt(DialogConstant.BUNDLE_SPEAKER_EDIT_OPTION);
            List<AiTextData> list3 = this.mAiTextDataList;
            Intrinsics.checkNotNull(list3);
            int speakerId = list3.get(position).getSpeakerId();
            if (i4 == 0) {
                Logger.m12713i(TAG, "onDialogResult - this");
                List<AiTextData> list4 = this.mAiTextDataList;
                Intrinsics.checkNotNull(list4);
                AiTextData aiTextData = list4.get(position);
                aiTextData.setSpeakerName(string);
                aiTextData.setSpeakerId(i);
                List<AiParagraphInfo> list5 = this.mAiParagraphInfo;
                Intrinsics.checkNotNull(list5);
                list5.get(position).setSpeakerId(Integer.valueOf(i));
            } else if (i4 == 1) {
                List<AiTextData> list6 = this.mAiTextDataList;
                Intrinsics.checkNotNull(list6);
                int i5 = 0;
                for (AiTextData aiTextData2 : list6) {
                    if (aiTextData2.getSpeakerId() == speakerId) {
                        aiTextData2.setSpeakerName(string);
                        aiTextData2.setSpeakerId(i);
                        List<AiParagraphInfo> list7 = this.mAiParagraphInfo;
                        Intrinsics.checkNotNull(list7);
                        list7.get(i5).setSpeakerId(Integer.valueOf(i));
                    }
                    i5++;
                }
            }
            List<AiTextData> list8 = this.mAiTextDataList;
            Intrinsics.checkNotNull(list8);
            Iterator<AiTextData> it2 = list8.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    this.mSpeakerNameMap.remove(Integer.valueOf(speakerId));
                    STTPresenterContract sTTPresenterContract2 = this.mSTTPresenterContract;
                    Intrinsics.checkNotNull(sTTPresenterContract2);
                    sTTPresenterContract2.onSpeakerNameMapChanged(this.mSpeakerNameMap);
                    break;
                }
                if (it2.next().getSpeakerId() == speakerId) {
                    break;
                }
            }
            STTPresenterContract sTTPresenterContract3 = this.mSTTPresenterContract;
            Intrinsics.checkNotNull(sTTPresenterContract3);
            sTTPresenterContract3.onParagraphInfoChanged(this.mAiParagraphInfo);
            notifyDataSetChanged();
        }
    }

    private final void resetAiTextData() {
        Logger.m12713i(TAG, "resetAiTextData#");
        this.mSpeakerNameMap.clear();
        STTVoiceItem sTTVoiceItem = this.mSTTVoiceItem;
        if (sTTVoiceItem != null) {
            Intrinsics.checkNotNull(sTTVoiceItem);
            if (sTTVoiceItem.getSpeakerNameMap() != null) {
                STTVoiceItem sTTVoiceItem2 = this.mSTTVoiceItem;
                Intrinsics.checkNotNull(sTTVoiceItem2);
                this.mSpeakerNameMap = new HashMap(sTTVoiceItem2.getSpeakerNameMap());
                STTPresenterContract sTTPresenterContract = this.mSTTPresenterContract;
                Intrinsics.checkNotNull(sTTPresenterContract);
                sTTPresenterContract.onSpeakerNameMapChanged(this.mSpeakerNameMap);
            }
        }
        List<AiTextData> list = this.mAiTextDataList;
        Intrinsics.checkNotNull(list);
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            AiTextData aiTextData = (AiTextData) obj;
            aiTextData.resetDisplayText();
            List<AiParagraphInfo> list2 = this.mAiParagraphInfo;
            Intrinsics.checkNotNull(list2);
            list2.get(i).setSpeakerId(Integer.valueOf(aiTextData.getOriginalId()));
            i = i2;
        }
        STTPresenterContract sTTPresenterContract2 = this.mSTTPresenterContract;
        Intrinsics.checkNotNull(sTTPresenterContract2);
        sTTPresenterContract2.onParagraphInfoChanged(this.mAiParagraphInfo);
    }

    public static /* synthetic */ void scrollToItem$default(AiSTTListView aiSTTListView, int i, int i2, boolean z, ScrollItemType scrollItemType, ScrollItemDirection scrollItemDirection, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i4 & 8) != 0) {
            scrollItemType = ScrollItemType.STT_CONTENT;
        }
        ScrollItemType scrollItemType2 = scrollItemType;
        if ((i4 & 16) != 0) {
            scrollItemDirection = ScrollItemDirection.DOWN;
        }
        aiSTTListView.scrollToItem(i, i2, z2, scrollItemType2, scrollItemDirection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scrollToItem$lambda$1(AiSTTListView aiSTTListView, int i, ScrollItemType scrollItemType, int i2, boolean z) {
        BasePenRecyclerView basePenRecyclerView = aiSTTListView.sttRecyclerView;
        Intrinsics.checkNotNull(basePenRecyclerView);
        AiSTTListViewAdapter.AiSTTListViewHolder aiSTTListViewHolder = (AiSTTListViewAdapter.AiSTTListViewHolder) basePenRecyclerView.findViewHolderForAdapterPosition(i);
        if (aiSTTListViewHolder != null) {
            aiSTTListView.mDiffY = (int) ResourceUtils.convertDpToPixel(aiSTTListViewHolder.getTranslatedText().getContext(), 35.0f);
            if (aiSTTListViewHolder.getTranslatedText().getMeasuredHeight() > 0) {
                aiSTTListView.mDiffY -= (int) ResourceUtils.convertDpToPixel(aiSTTListViewHolder.getTranslatedText().getContext(), 12.0f);
            }
            int i4 = WhenMappings.$EnumSwitchMapping$0[scrollItemType.ordinal()];
            if (i4 == 1) {
                aiSTTListView.mDiffY = 0;
                aiSTTListView.mDiffY = aiSTTListView.getTopPosition(aiSTTListViewHolder.getSpeakerName(), i2);
            } else if (i4 == 2) {
                aiSTTListView.mDiffY += aiSTTListView.getTopPosition(aiSTTListViewHolder.getContent(), i2);
            } else {
                if (i4 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                int measuredHeight = aiSTTListViewHolder.getSpeakerName().getMeasuredHeight() + aiSTTListView.mDiffY;
                aiSTTListView.mDiffY = measuredHeight;
                int measuredHeight2 = aiSTTListViewHolder.getContent().getMeasuredHeight() + measuredHeight;
                aiSTTListView.mDiffY = measuredHeight2;
                aiSTTListView.mDiffY = measuredHeight2 + aiSTTListView.getTopPosition(aiSTTListViewHolder.getTranslatedText(), i2);
            }
        }
        BasePenRecyclerView basePenRecyclerView2 = aiSTTListView.sttRecyclerView;
        Intrinsics.checkNotNull(basePenRecyclerView2);
        if (basePenRecyclerView2.getLayoutManager() != null) {
            LinearSmoothScroller linearSmoothScroller = aiSTTListView.mSmoothScroller;
            Intrinsics.checkNotNull(linearSmoothScroller);
            linearSmoothScroller.setTargetPosition(i);
            BasePenRecyclerView basePenRecyclerView3 = aiSTTListView.sttRecyclerView;
            Intrinsics.checkNotNull(basePenRecyclerView3);
            if (basePenRecyclerView3.canScrollVertically(-aiSTTListView.calculatedScrollDistance) || z || aiSTTListView.calculatedScrollDistance == 0) {
                BasePenRecyclerView basePenRecyclerView4 = aiSTTListView.sttRecyclerView;
                Intrinsics.checkNotNull(basePenRecyclerView4);
                RecyclerView.LayoutManager layoutManager = basePenRecyclerView4.getLayoutManager();
                Intrinsics.checkNotNull(layoutManager);
                layoutManager.startSmoothScroll(aiSTTListView.mSmoothScroller);
            }
        }
    }

    private final void updateAiTextData() {
        DiffMatchPatch diffMatchPatch;
        Iterator<AiTextData> it;
        ArrayList<TextData> arrayList;
        int i;
        int length;
        ArrayList<TextData> arrayList2;
        int i2;
        int i4;
        int textLength;
        AiSTTListView aiSTTListView = this;
        Logger.m12713i(TAG, "updateAiTextData#");
        ArrayList<TextData> arrayList3 = new ArrayList<>();
        DiffMatchPatch diffMatchPatch2 = new DiffMatchPatch();
        List<AiTextData> list = aiSTTListView.mAiTextDataList;
        Intrinsics.checkNotNull(list);
        Iterator<AiTextData> it2 = list.iterator();
        while (it2.hasNext()) {
            AiTextData next = it2.next();
            String originalText = next.getOriginalText();
            String string = next.getText().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            int speakerId = next.getSpeakerId();
            if (Intrinsics.areEqual(originalText, string)) {
                Iterator<TextData> it3 = next.getTextDataList().iterator();
                Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
                while (it3.hasNext()) {
                    TextData next2 = it3.next();
                    Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                    TextData textData = next2;
                    arrayList3.add(TextDataCreator.INSTANCE.createTextData(textData.getText(), speakerId, textData.getStartTime(), textData.getEndTime()));
                }
                Logger.m12713i(TAG, "updateAiTextData# add all aiTextData : " + LoggerBase.INSTANCE.getEncode(next.getText().toString()));
            } else {
                int startIdx = 0;
                LinkedList<DiffMatchPatch.Diff> linkedListDiffMain = diffMatchPatch2.diffMain(originalText, string, false);
                ArrayList<TextData> textDataList = next.getTextDataList();
                ArrayList<AiTextData.SpannableIndex> spannableIndexList = next.getSpannableIndexList();
                Iterator<DiffMatchPatch.Diff> it4 = linkedListDiffMain.iterator();
                Intrinsics.checkNotNullExpressionValue(it4, "iterator(...)");
                int i5 = 0;
                int length2 = -1;
                int i6 = -1;
                int textLength2 = 0;
                while (true) {
                    diffMatchPatch = diffMatchPatch2;
                    it = it2;
                    if (!it4.hasNext()) {
                        break;
                    }
                    DiffMatchPatch.Diff next3 = it4.next();
                    Iterator<DiffMatchPatch.Diff> it5 = it4;
                    DiffMatchPatch.Operation operation = next3.operation;
                    if (operation == DiffMatchPatch.Operation.EQUAL) {
                        int length3 = next3.text.length();
                        int size = spannableIndexList.size();
                        ArrayList<TextData> arrayList4 = arrayList3;
                        String encode = LoggerBase.INSTANCE.getEncode(next3.text);
                        int i7 = speakerId;
                        ArrayList<TextData> arrayList5 = textDataList;
                        StringBuilder sbM1173s = AbstractC0622a.m1173s(startIdx, length2, "updateAiTextData# startOri: ", ", endOri: ", ", startCur: ");
                        AbstractC2821a.m2235z(sbM1173s, textLength2, i6, ", endCur: ", ", textLength: ");
                        AbstractC2821a.m2235z(sbM1173s, length3, size, ", indexList.size ", ", EQUAL ");
                        sbM1173s.append(encode);
                        Logger.m12713i(TAG, sbM1173s.toString());
                        int i8 = length2 + 1;
                        int length4 = next3.text.length() + length2;
                        int i9 = i5;
                        while (true) {
                            if (i9 >= spannableIndexList.size()) {
                                textDataList = arrayList5;
                                diffMatchPatch2 = diffMatchPatch;
                                it2 = it;
                                it4 = it5;
                                arrayList3 = arrayList4;
                                speakerId = i7;
                                break;
                            }
                            if (i8 > spannableIndexList.get(i9).getStartIdx() || spannableIndexList.get(i9).getEndIdx() > length4) {
                                arrayList = arrayList4;
                                textDataList = arrayList5;
                                int i10 = i6;
                                i = i7;
                                int i11 = i8;
                                if (length4 < spannableIndexList.get(i9).getStartIdx()) {
                                    length = next3.text.length() + i10;
                                    length2 = length4;
                                    break;
                                }
                                i9++;
                                arrayList4 = arrayList;
                                i8 = i11;
                                i7 = i;
                                i6 = i10;
                                arrayList5 = textDataList;
                            } else {
                                if (i9 > i5) {
                                    int startIdx2 = spannableIndexList.get(i9).getStartIdx() - length2;
                                    TextDataCreator.Companion companion = TextDataCreator.INSTANCE;
                                    textLength = startIdx2 + i6;
                                    String strSubstring = string.substring(textLength2, textLength);
                                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                                    textDataList = arrayList5;
                                    i2 = i6;
                                    i4 = i7;
                                    TextData textDataCreateTextData = companion.createTextData(strSubstring, i4, textDataList.get(i5).getStartTime(), textDataList.get(i9 - 1).getEndTime());
                                    arrayList2 = arrayList4;
                                    arrayList2.add(textDataCreateTextData);
                                } else {
                                    arrayList2 = arrayList4;
                                    textDataList = arrayList5;
                                    i2 = i6;
                                    i4 = i7;
                                    int startIdx3 = spannableIndexList.get(i9).getStartIdx() - length2;
                                    TextDataCreator.Companion companion2 = TextDataCreator.INSTANCE;
                                    int i12 = i2 + startIdx3;
                                    String strSubstring2 = string.substring(textLength2, textDataList.get(i9).getTextLength() + i12);
                                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                                    arrayList2.add(companion2.createTextData(strSubstring2, i4, textDataList.get(i9).getStartTime(), textDataList.get(i9).getEndTime()));
                                    textLength = textDataList.get(i9).getTextLength() + i12;
                                    i9++;
                                }
                                int length5 = next3.text.length() + i2;
                                i5 = i9;
                                textLength2 = textLength;
                                while (i5 < spannableIndexList.size() && i8 <= spannableIndexList.get(i5).getStartIdx() && spannableIndexList.get(i5).getEndIdx() <= length4) {
                                    int i13 = i8;
                                    TextData textDataCreateTextData2 = TextDataCreator.INSTANCE.createTextData(textDataList.get(i5).getText(), i4, textDataList.get(i5).getStartTime(), textDataList.get(i5).getEndTime());
                                    arrayList2.add(textDataCreateTextData2);
                                    textLength2 += textDataCreateTextData2.getTextLength();
                                    i5++;
                                    i8 = i13;
                                }
                                if (i5 < spannableIndexList.size()) {
                                    startIdx = spannableIndexList.get(i5).getStartIdx();
                                    length2 = length4;
                                }
                                arrayList3 = arrayList2;
                                speakerId = i4;
                                diffMatchPatch2 = diffMatchPatch;
                                it4 = it5;
                                i6 = length5;
                                it2 = it;
                            }
                        }
                        arrayList3 = arrayList;
                        speakerId = i;
                        diffMatchPatch2 = diffMatchPatch;
                        it2 = it;
                        it4 = it5;
                        i6 = length;
                    } else {
                        int i14 = i6;
                        i = speakerId;
                        arrayList = arrayList3;
                        if (operation == DiffMatchPatch.Operation.DELETE) {
                            length2 += next3.text.length();
                            Logger.m12713i(TAG, "updateAiTextData# DELETE endOri: " + length2 + " " + LoggerBase.INSTANCE.getEncode(next3.text));
                            arrayList3 = arrayList;
                            speakerId = i;
                            diffMatchPatch2 = diffMatchPatch;
                            it2 = it;
                            it4 = it5;
                            i6 = i14;
                        } else {
                            length = next3.text.length() + i14;
                            Logger.m12713i(TAG, "updateAiTextData# INSERT endCur: " + length + " " + LoggerBase.INSTANCE.getEncode(next3.text));
                            arrayList3 = arrayList;
                            speakerId = i;
                            diffMatchPatch2 = diffMatchPatch;
                            it2 = it;
                            it4 = it5;
                            i6 = length;
                        }
                    }
                }
                int i15 = i6;
                int i16 = speakerId;
                ArrayList<TextData> arrayList6 = arrayList3;
                int size2 = spannableIndexList.size();
                StringBuilder sbM1173s2 = AbstractC0622a.m1173s(startIdx, length2, "updateAiTextData startOri : ", " endOri : ", " startCur : ");
                AbstractC2821a.m2235z(sbM1173s2, textLength2, i15, " endCur : ", " ");
                sbM1173s2.append(i5);
                sbM1173s2.append(" ");
                sbM1173s2.append(size2);
                Logger.m12713i(TAG, sbM1173s2.toString());
                if (i5 < spannableIndexList.size()) {
                    TextDataCreator.Companion companion3 = TextDataCreator.INSTANCE;
                    String strSubstring3 = string.substring(textLength2);
                    Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
                    TextData textDataCreateTextData3 = companion3.createTextData(strSubstring3, i16, textDataList.get(i5).getStartTime(), textDataList.get(spannableIndexList.size() - 1).getEndTime());
                    arrayList6.add(textDataCreateTextData3);
                    Logger.m12713i(TAG, "updateAiTextData# add textData : " + LoggerBase.INSTANCE.getEncode(textDataCreateTextData3.getText()));
                } else if (textLength2 < string.length()) {
                    TextDataCreator.Companion companion4 = TextDataCreator.INSTANCE;
                    String strSubstring4 = string.substring(textLength2);
                    Intrinsics.checkNotNullExpressionValue(strSubstring4, "substring(...)");
                    TextData textDataCreateTextData4 = companion4.createTextData(strSubstring4, i16, textDataList.get(spannableIndexList.size() - 1).getEndTime(), textDataList.get(spannableIndexList.size() - 1).getEndTime());
                    arrayList6.add(textDataCreateTextData4);
                    Logger.m12713i(TAG, "updateAiTextData# add new textData : " + LoggerBase.INSTANCE.getEncode(textDataCreateTextData4.getText()));
                }
                aiSTTListView = this;
                arrayList3 = arrayList6;
                diffMatchPatch2 = diffMatchPatch;
                it2 = it;
            }
        }
        ArrayList<TextData> arrayList7 = arrayList3;
        aiSTTListView.initAiTextDataList(arrayList7);
        Triple<ArrayList<Integer>, ArrayList<Long>, ArrayList<Long>> tripleConvertParagraphInfoToArrays = aiSTTListView.convertParagraphInfoToArrays(new ArrayList<>(aiSTTListView.mAiParagraphInfo));
        ArrayList<Integer> arrayListComponent1 = tripleConvertParagraphInfoToArrays.component1();
        ArrayList<Long> arrayListComponent2 = tripleConvertParagraphInfoToArrays.component2();
        ArrayList<Long> arrayListComponent3 = tripleConvertParagraphInfoToArrays.component3();
        STTPresenterContract sTTPresenterContract = aiSTTListView.mSTTPresenterContract;
        Intrinsics.checkNotNull(sTTPresenterContract);
        sTTPresenterContract.onSTTDataChanged(arrayList7, aiSTTListView.mSpeakerNameMap, CollectionsKt.toIntArray(arrayListComponent1), CollectionsKt.toLongArray(arrayListComponent2), CollectionsKt.toLongArray(arrayListComponent3));
        Logger.m12713i(TAG, "updateAiTextData# Done");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateAiTextDataList(ArrayList<TextData> result) {
        if (result == null || result.isEmpty()) {
            return;
        }
        int speakerId = result.get(0).getSpeakerId();
        int i = speakerId == 0 ? 1 : speakerId;
        int startTime = result.get(0).getStartTime();
        int endTime = ((TextData) AbstractC1974b.m1313f(1, result)).getEndTime();
        ArrayList<AiTextData.SpannableIndex> arrayList = new ArrayList<>();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayList arrayList2 = new ArrayList();
        Iterator<TextData> it = result.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            TextData next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            TextData textData = next;
            arrayList2.add(textData);
            arrayList.add(new AiTextData.SpannableIndex(spannableStringBuilder.length(), (textData.getTextLength() + spannableStringBuilder.length()) - 1));
            spannableStringBuilder.append((CharSequence) textData.getText());
        }
        String speakerName = getSpeakerName(i);
        Intrinsics.checkNotNull(speakerName);
        AiTextData aiTextData = new AiTextData(i, speakerName, startTime, endTime, spannableStringBuilder, arrayList2);
        aiTextData.setSpannableIndexList(arrayList);
        List<AiTextData> list = this.mAiTextDataList;
        Intrinsics.checkNotNull(list);
        list.add(aiTextData);
        if (isEmptyResultTextData(result)) {
            return;
        }
        AiParagraphInfo aiParagraphInfo = new AiParagraphInfo(Integer.valueOf(i), Long.valueOf(startTime), Long.valueOf(endTime));
        List<AiParagraphInfo> list2 = this.mAiParagraphInfo;
        Intrinsics.checkNotNull(list2);
        list2.add(aiParagraphInfo);
    }

    public static /* synthetic */ void updateSTTReplay$default(AiSTTListView aiSTTListView, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        aiSTTListView.updateSTTReplay(i, z);
    }

    @NotNull
    public final Triple<ArrayList<Integer>, ArrayList<Long>, ArrayList<Long>> convertParagraphInfoToArrays(@NotNull ArrayList<AiParagraphInfo> paragraphInfoList) {
        Intrinsics.checkNotNullParameter(paragraphInfoList, "paragraphInfoList");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator<AiParagraphInfo> it = paragraphInfoList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            AiParagraphInfo next = it.next();
            if (next.getSpeakerId() != null) {
                Integer speakerId = next.getSpeakerId();
                Intrinsics.checkNotNull(speakerId);
                arrayList.add(speakerId);
            }
            if (next.getStartTime() != null) {
                Long startTime = next.getStartTime();
                Intrinsics.checkNotNull(startTime);
                arrayList2.add(startTime);
            }
            if (next.getEndTime() != null) {
                Long endTime = next.getEndTime();
                Intrinsics.checkNotNull(endTime);
                arrayList3.add(endTime);
            }
        }
        return new Triple<>(arrayList, arrayList2, arrayList3);
    }

    public final void deleteSelectedItem() {
        Map<Integer, Boolean> map = this.mSelectedItemMap;
        Intrinsics.checkNotNull(map);
        for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            if (entry.getValue().booleanValue()) {
                List<AiTextData> list = this.mAiTextDataList;
                Intrinsics.checkNotNull(list);
                list.get(iIntValue).setNeedToBeDeleted(true);
                Logger.m12710d(TAG, "deleteSelectedItem " + iIntValue);
            }
        }
        Map<Integer, Boolean> map2 = this.mSelectedItemMap;
        Intrinsics.checkNotNull(map2);
        map2.clear();
        ArrayList<TextData> arrayList = new ArrayList<>();
        List<AiTextData> list2 = this.mAiTextDataList;
        Intrinsics.checkNotNull(list2);
        Iterator<AiTextData> it = list2.iterator();
        ArrayList<AiParagraphInfo> arrayList2 = new ArrayList<>();
        List<AiParagraphInfo> list3 = this.mAiParagraphInfo;
        Intrinsics.checkNotNull(list3);
        Iterator<AiParagraphInfo> it2 = list3.iterator();
        while (it.hasNext()) {
            AiTextData next = it.next();
            AiParagraphInfo next2 = it2.next();
            if (next.getIsNeedToBeDeleted()) {
                it.remove();
                it2.remove();
            } else {
                arrayList.addAll(next.getTextDataList());
                arrayList2.add(next2);
            }
        }
        STTPresenterContract sTTPresenterContract = this.mSTTPresenterContract;
        Intrinsics.checkNotNull(sTTPresenterContract);
        sTTPresenterContract.onTextDataListChanged(this.mAiTextDataList);
        STTPresenterContract sTTPresenterContract2 = this.mSTTPresenterContract;
        Intrinsics.checkNotNull(sTTPresenterContract2);
        sTTPresenterContract2.onParagraphInfoChanged(this.mAiParagraphInfo);
        Triple<ArrayList<Integer>, ArrayList<Long>, ArrayList<Long>> tripleConvertParagraphInfoToArrays = convertParagraphInfoToArrays(arrayList2);
        ArrayList<Integer> arrayListComponent1 = tripleConvertParagraphInfoToArrays.component1();
        ArrayList<Long> arrayListComponent2 = tripleConvertParagraphInfoToArrays.component2();
        ArrayList<Long> arrayListComponent3 = tripleConvertParagraphInfoToArrays.component3();
        STTPresenterContract sTTPresenterContract3 = this.mSTTPresenterContract;
        Intrinsics.checkNotNull(sTTPresenterContract3);
        sTTPresenterContract3.onSTTDataChanged(arrayList, this.mSpeakerNameMap, CollectionsKt.toIntArray(arrayListComponent1), CollectionsKt.toLongArray(arrayListComponent2), CollectionsKt.toLongArray(arrayListComponent3));
        notifyDataSetChanged();
        List<AiTextData> list4 = this.mAiTextDataList;
        Intrinsics.checkNotNull(list4);
        if (list4.isEmpty()) {
            STTPresenterContract sTTPresenterContract4 = this.mSTTPresenterContract;
            Intrinsics.checkNotNull(sTTPresenterContract4);
            sTTPresenterContract4.getSTTPresenter().showInfoView();
        }
    }

    @Nullable
    /* JADX INFO: renamed from: getAdapter, reason: from getter */
    public final AiSTTListViewAdapter getMAiSTTListViewAdapter() {
        return this.mAiSTTListViewAdapter;
    }

    @Nullable
    public final List<AiTextData> getAiTextDataList() {
        return this.mAiTextDataList;
    }

    @NotNull
    public final String getCurrentVoiceItemSelectedText() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        List<AiTextData> list = this.mAiTextDataList;
        Intrinsics.checkNotNull(list);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Map<Integer, Boolean> map = this.mSelectedItemMap;
            Intrinsics.checkNotNull(map);
            if (map.get(Integer.valueOf(i)) != null) {
                Boolean bool = Boolean.FALSE;
                Map<Integer, Boolean> map2 = this.mSelectedItemMap;
                Intrinsics.checkNotNull(map2);
                if (!Intrinsics.areEqual(bool, map2.get(Integer.valueOf(i)))) {
                    List<AiTextData> list2 = this.mAiTextDataList;
                    Intrinsics.checkNotNull(list2);
                    AiTextData aiTextData = list2.get(i);
                    STTPresenterContract sTTPresenterContract = this.mSTTPresenterContract;
                    Intrinsics.checkNotNull(sTTPresenterContract);
                    if (sTTPresenterContract.isShowSpeakerLabel()) {
                        spannableStringBuilder.append((CharSequence) aiTextData.getSpeakerName()).append((CharSequence) " (").append((CharSequence) AiSTTListViewAdapter.INSTANCE.getStringByDuration(aiTextData.getStartTime(), false)).append((CharSequence) ")").append((CharSequence) System.lineSeparator());
                    }
                    spannableStringBuilder.append((CharSequence) aiTextData.getText()).append((CharSequence) System.lineSeparator()).append((CharSequence) System.lineSeparator());
                }
            }
        }
        String string = spannableStringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final boolean getMIsNeedToUpdateParagraphInfo() {
        return this.mIsNeedToUpdateParagraphInfo;
    }

    public final long getMUserScrollTime() {
        return this.mUserScrollTime;
    }

    @NotNull
    public final String getSTTCurrentVoiceItemText(boolean isContainHeader) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        List<AiTextData> list = this.mAiTextDataList;
        Intrinsics.checkNotNull(list);
        for (AiTextData aiTextData : list) {
            if (isContainHeader) {
                STTPresenterContract sTTPresenterContract = this.mSTTPresenterContract;
                Intrinsics.checkNotNull(sTTPresenterContract);
                if (sTTPresenterContract.isShowSpeakerLabel()) {
                    spannableStringBuilder.append((CharSequence) aiTextData.getSpeakerName()).append((CharSequence) " (").append((CharSequence) AiSTTListViewAdapter.INSTANCE.getStringByDuration(aiTextData.getStartTime(), false)).append((CharSequence) ")").append((CharSequence) System.lineSeparator());
                }
            }
            spannableStringBuilder.append((CharSequence) aiTextData.getText()).append((CharSequence) System.lineSeparator()).append((CharSequence) System.lineSeparator());
        }
        String string = spannableStringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @Nullable
    public final Map<Integer, Boolean> getSelectedItemMap() {
        return this.mSelectedItemMap;
    }

    @Nullable
    public final ScrollLinearLayoutManager getSttLayoutManager() {
        return this.sttLayoutManager;
    }

    @Nullable
    public final BasePenRecyclerView getSttRecyclerView() {
        return this.sttRecyclerView;
    }

    public final void initPainter() {
        PaintHelper paintHelper = this.mPaintHelper;
        Intrinsics.checkNotNull(paintHelper);
        paintHelper.initSpanColor();
    }

    public final void initSTTVoiceItems(@NotNull STTVoiceItem voiceItem) {
        Intrinsics.checkNotNullParameter(voiceItem, "voiceItem");
        if (!Intrinsics.areEqual(voiceItem, this.mSTTVoiceItem)) {
            this.lastScrollPosition = -1;
        }
        ArrayList<TextData> textDataList = voiceItem.getTextDataList();
        this.mSTTVoiceItem = voiceItem;
        this.mSpeakerNameMap.clear();
        if (textDataList == null || textDataList.isEmpty()) {
            return;
        }
        Logger.m12713i(TAG, "initSTTVoiceItems");
        STTPresenterContract sTTPresenterContract = this.mSTTPresenterContract;
        Intrinsics.checkNotNull(sTTPresenterContract);
        STTPresenter sTTPresenter = sTTPresenterContract.getSTTPresenter();
        if (sTTPresenter.getMOnSavedInstanceState()) {
            if (sTTPresenter.getMCurrentTextDataList() != null) {
                setAiTextDataList(TypeIntrinsics.asMutableList(sTTPresenter.getMCurrentTextDataList()));
            }
            if (sTTPresenter.getMCurrentSpeakerNameMap() != null) {
                Map<Integer, String> mCurrentSpeakerNameMap = sTTPresenter.getMCurrentSpeakerNameMap();
                Intrinsics.checkNotNull(mCurrentSpeakerNameMap);
                this.mSpeakerNameMap = mCurrentSpeakerNameMap;
            }
            if (sTTPresenter.getMCurrentParagraphInfo() != null) {
                this.mAiParagraphInfo = sTTPresenter.getMCurrentParagraphInfo();
            }
        } else {
            STTVoiceItem sTTVoiceItem = this.mSTTVoiceItem;
            Intrinsics.checkNotNull(sTTVoiceItem);
            if (sTTVoiceItem.getSpeakerNameMap() != null) {
                STTVoiceItem sTTVoiceItem2 = this.mSTTVoiceItem;
                Intrinsics.checkNotNull(sTTVoiceItem2);
                this.mSpeakerNameMap = new HashMap(sTTVoiceItem2.getSpeakerNameMap());
                STTPresenterContract sTTPresenterContract2 = this.mSTTPresenterContract;
                Intrinsics.checkNotNull(sTTPresenterContract2);
                sTTPresenterContract2.onSpeakerNameMapChanged(this.mSpeakerNameMap);
            }
            this.mAiParagraphInfo = voiceItem.getParagraphInfo();
            initAiTextDataList(textDataList);
            STTPresenterContract sTTPresenterContract3 = this.mSTTPresenterContract;
            Intrinsics.checkNotNull(sTTPresenterContract3);
            sTTPresenterContract3.onParagraphInfoChanged(this.mAiParagraphInfo);
        }
        if (this.mIsNeedToUpdateParagraphInfo) {
            this.mIsNeedToUpdateParagraphInfo = false;
            Triple<ArrayList<Integer>, ArrayList<Long>, ArrayList<Long>> tripleConvertParagraphInfoToArrays = convertParagraphInfoToArrays(new ArrayList<>(this.mAiParagraphInfo));
            ArrayList<Integer> arrayListComponent1 = tripleConvertParagraphInfoToArrays.component1();
            ArrayList<Long> arrayListComponent2 = tripleConvertParagraphInfoToArrays.component2();
            ArrayList<Long> arrayListComponent3 = tripleConvertParagraphInfoToArrays.component3();
            STTPresenterContract sTTPresenterContract4 = this.mSTTPresenterContract;
            Intrinsics.checkNotNull(sTTPresenterContract4);
            sTTPresenterContract4.onSTTDataChanged(textDataList, this.mSpeakerNameMap, CollectionsKt.toIntArray(arrayListComponent1), CollectionsKt.toLongArray(arrayListComponent2), CollectionsKt.toLongArray(arrayListComponent3));
        }
    }

    public final boolean isDataChanged() {
        Logger.m12713i(TAG, "isDataChanged#");
        List<AiTextData> list = this.mAiTextDataList;
        Intrinsics.checkNotNull(list);
        for (AiTextData aiTextData : list) {
            String originalText = aiTextData.getOriginalText();
            String string = aiTextData.getText().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            if (!Intrinsics.areEqual(aiTextData.getSpeakerName().toString(), aiTextData.getOriginalName()) || !Intrinsics.areEqual(originalText, string)) {
                return true;
            }
        }
        return false;
    }

    public final boolean isSelectionMode() {
        AiSTTListViewAdapter aiSTTListViewAdapter = this.mAiSTTListViewAdapter;
        if (aiSTTListViewAdapter == null) {
            return false;
        }
        Intrinsics.checkNotNull(aiSTTListViewAdapter);
        return aiSTTListViewAdapter.getIsSelectionMode();
    }

    public final void notifyAdapter(@Nullable final Runnable runnable) {
        BasePenRecyclerView basePenRecyclerView = this.sttRecyclerView;
        if (basePenRecyclerView == null || this.mAiSTTListViewAdapter == null) {
            return;
        }
        Intrinsics.checkNotNull(basePenRecyclerView);
        RecyclerView.ItemAnimator itemAnimator = basePenRecyclerView.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.isRunning(new RecyclerView.ItemAnimator.ItemAnimatorFinishedListener() { // from class: com.samsung.android.support.senl.nt.stt.view.a
                @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemAnimatorFinishedListener
                public final void onAnimationsFinished() {
                    AiSTTListView.notifyAdapter$lambda$4(this.f7922a, runnable);
                }
            });
            return;
        }
        BasePenRecyclerView basePenRecyclerView2 = this.sttRecyclerView;
        Intrinsics.checkNotNull(basePenRecyclerView2);
        basePenRecyclerView2.post(runnable);
    }

    public final void notifyDataSetChanged() {
        notifyAdapter(new RunnableC9767a(this, 29));
    }

    public final void notifyItemChanged(int index) {
        notifyAdapter(new RunnableC0050f(this, index, 25));
    }

    public final void onModeChanged(@NotNull STTMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Logger.m12713i(TAG, "onModeChanged : " + mode);
        if (mode == STTMode.SELECTION) {
            setSelectionMode(true);
        } else {
            Map<Integer, Boolean> map = this.mSelectedItemMap;
            Intrinsics.checkNotNull(map);
            map.clear();
            setSelectionMode(false);
        }
        AiSTTListViewAdapter aiSTTListViewAdapter = this.mAiSTTListViewAdapter;
        if (aiSTTListViewAdapter != null) {
            Intrinsics.checkNotNull(aiSTTListViewAdapter);
            aiSTTListViewAdapter.setEditMode(mode == STTMode.EDIT);
            AiSTTListViewAdapter aiSTTListViewAdapter2 = this.mAiSTTListViewAdapter;
            Intrinsics.checkNotNull(aiSTTListViewAdapter2);
            aiSTTListViewAdapter2.notifyDataSetChanged();
        }
    }

    public final void onShowSpeakerLabelChanged() {
        Logger.m12713i(TAG, "onShowSpeakerLabelChanged");
        AiSTTListViewAdapter aiSTTListViewAdapter = this.mAiSTTListViewAdapter;
        if (aiSTTListViewAdapter != null) {
            Intrinsics.checkNotNull(aiSTTListViewAdapter);
            STTPresenterContract sTTPresenterContract = this.mSTTPresenterContract;
            Intrinsics.checkNotNull(sTTPresenterContract);
            aiSTTListViewAdapter.setShowSpeakerLabel(sTTPresenterContract.isShowSpeakerLabel());
            AiSTTListViewAdapter aiSTTListViewAdapter2 = this.mAiSTTListViewAdapter;
            Intrinsics.checkNotNull(aiSTTListViewAdapter2);
            aiSTTListViewAdapter2.notifyDataSetChanged();
        }
    }

    public final void saveSTTData(boolean isUpdated) {
        Logger.m12713i(TAG, "saveSTTData : " + isUpdated);
        AiSTTListViewAdapter aiSTTListViewAdapter = this.mAiSTTListViewAdapter;
        if (aiSTTListViewAdapter != null) {
            Intrinsics.checkNotNull(aiSTTListViewAdapter);
            if (aiSTTListViewAdapter.getIsEditMode()) {
                if (!isUpdated) {
                    resetAiTextData();
                } else if (isDataChanged()) {
                    updateAiTextData();
                }
            }
        }
    }

    public final void scrollToItem(int positionItem, int startIndex, boolean forceScroll, @NotNull ScrollItemType scrollType, @NotNull ScrollItemDirection scrollDirection) {
        Intrinsics.checkNotNullParameter(scrollType, "scrollType");
        Intrinsics.checkNotNullParameter(scrollDirection, "scrollDirection");
        if (System.currentTimeMillis() - this.mUserScrollTime > USER_SCROLL_INTERVAL || forceScroll) {
            BasePenRecyclerView basePenRecyclerView = this.sttRecyclerView;
            Intrinsics.checkNotNull(basePenRecyclerView);
            if (basePenRecyclerView.findViewHolderForAdapterPosition(positionItem) == null) {
                Logger.m12713i(TAG, "scrollToItem# scroll item not visible yet, scroll " + scrollDirection + " to " + positionItem);
                if (scrollDirection == ScrollItemDirection.f7921UP) {
                    ScrollLinearLayoutManager scrollLinearLayoutManager = this.sttLayoutManager;
                    if (scrollLinearLayoutManager != null) {
                        scrollLinearLayoutManager.scrollToPositionWithOffset(positionItem + 1, 1);
                    }
                } else {
                    ScrollLinearLayoutManager scrollLinearLayoutManager2 = this.sttLayoutManager;
                    if (scrollLinearLayoutManager2 != null) {
                        scrollLinearLayoutManager2.scrollToPosition(positionItem);
                    }
                }
            }
            BasePenRecyclerView basePenRecyclerView2 = this.sttRecyclerView;
            Intrinsics.checkNotNull(basePenRecyclerView2);
            basePenRecyclerView2.post(new RunnableC10887m(this, positionItem, scrollType, startIndex, forceScroll));
        }
    }

    public final void scrollToLastPosition() {
        int i = this.lastScrollPosition;
        if (i >= 0) {
            updateSTTReplay(i, true);
        }
    }

    public final void setAiTextDataList(@Nullable List<AiTextData> aiTextDataList) {
        AiSTTListViewAdapter aiSTTListViewAdapter = this.mAiSTTListViewAdapter;
        if (aiSTTListViewAdapter == null) {
            return;
        }
        this.mAiTextDataList = aiTextDataList;
        Intrinsics.checkNotNull(aiSTTListViewAdapter);
        Intrinsics.checkNotNull(aiTextDataList);
        aiSTTListViewAdapter.setAiTextDataItemsItem(aiTextDataList);
        AiSTTListViewAdapter aiSTTListViewAdapter2 = this.mAiSTTListViewAdapter;
        Intrinsics.checkNotNull(aiSTTListViewAdapter2);
        aiSTTListViewAdapter2.setEditMode(false);
        AiSTTListViewAdapter aiSTTListViewAdapter3 = this.mAiSTTListViewAdapter;
        Intrinsics.checkNotNull(aiSTTListViewAdapter3);
        STTPresenterContract sTTPresenterContract = this.mSTTPresenterContract;
        Intrinsics.checkNotNull(sTTPresenterContract);
        aiSTTListViewAdapter3.setShowSpeakerLabel(sTTPresenterContract.isShowSpeakerLabel());
        AiSTTListViewAdapter aiSTTListViewAdapter4 = this.mAiSTTListViewAdapter;
        Intrinsics.checkNotNull(aiSTTListViewAdapter4);
        aiSTTListViewAdapter4.notifyDataSetChanged();
        STTPresenterContract sTTPresenterContract2 = this.mSTTPresenterContract;
        if (sTTPresenterContract2 != null) {
            sTTPresenterContract2.onTextDataListChanged(this.mAiTextDataList);
        }
    }

    public final void setEditMode(boolean isEditMode) {
        AiSTTListViewAdapter aiSTTListViewAdapter = this.mAiSTTListViewAdapter;
        if (aiSTTListViewAdapter != null) {
            Intrinsics.checkNotNull(aiSTTListViewAdapter);
            aiSTTListViewAdapter.setEditMode(isEditMode);
            AiSTTListViewAdapter aiSTTListViewAdapter2 = this.mAiSTTListViewAdapter;
            Intrinsics.checkNotNull(aiSTTListViewAdapter2);
            aiSTTListViewAdapter2.notifyDataSetChanged();
        }
    }

    public final void setMIsNeedToUpdateParagraphInfo(boolean z) {
        this.mIsNeedToUpdateParagraphInfo = z;
    }

    public final void setMUserScrollTime(long j) {
        this.mUserScrollTime = j;
    }

    public final void setSTTPresenterContract(@Nullable STTPresenterContract sttPresenterContract) {
        this.mSTTPresenterContract = sttPresenterContract;
    }

    public final void setSelected(int position) {
        Map<Integer, Boolean> map = this.mSelectedItemMap;
        Intrinsics.checkNotNull(map);
        map.remove(Integer.valueOf(position));
        AiSTTListViewAdapter aiSTTListViewAdapter = this.mAiSTTListViewAdapter;
        if (aiSTTListViewAdapter != null) {
            Intrinsics.checkNotNull(aiSTTListViewAdapter);
            aiSTTListViewAdapter.toggleSelectItem(position);
        }
    }

    public final void setSelectedItemMap(@Nullable Map<Integer, Boolean> selectedItemMap) {
        this.mSelectedItemMap = selectedItemMap;
    }

    public final void setSelectionMode(boolean z) {
        AiSTTListViewAdapter aiSTTListViewAdapter = this.mAiSTTListViewAdapter;
        if (aiSTTListViewAdapter != null) {
            Intrinsics.checkNotNull(aiSTTListViewAdapter);
            aiSTTListViewAdapter.setSelectionMode(z);
            AiSTTListViewAdapter aiSTTListViewAdapter2 = this.mAiSTTListViewAdapter;
            Intrinsics.checkNotNull(aiSTTListViewAdapter2);
            aiSTTListViewAdapter2.setSelectedMap(this.mSelectedItemMap);
            AiSTTListViewAdapter aiSTTListViewAdapter3 = this.mAiSTTListViewAdapter;
            Intrinsics.checkNotNull(aiSTTListViewAdapter3);
            aiSTTListViewAdapter3.notifyDataSetChanged();
        }
    }

    public final void setSttRecyclerView(@Nullable BasePenRecyclerView basePenRecyclerView) {
        this.sttRecyclerView = basePenRecyclerView;
    }

    public final void setTranslateMode(boolean isTranslateMode) {
        AiSTTListViewAdapter aiSTTListViewAdapter = this.mAiSTTListViewAdapter;
        if (aiSTTListViewAdapter != null) {
            Intrinsics.checkNotNull(aiSTTListViewAdapter);
            aiSTTListViewAdapter.setTranslateMode(isTranslateMode);
            AiSTTListViewAdapter aiSTTListViewAdapter2 = this.mAiSTTListViewAdapter;
            Intrinsics.checkNotNull(aiSTTListViewAdapter2);
            aiSTTListViewAdapter2.notifyDataSetChanged();
        }
    }

    public final void updateListMargin() {
        AiSTTListViewAdapter aiSTTListViewAdapter = this.mAiSTTListViewAdapter;
        if (aiSTTListViewAdapter != null) {
            Intrinsics.checkNotNull(aiSTTListViewAdapter);
            aiSTTListViewAdapter.updateAISTTListMargin();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateSTTReplay(int position, boolean forceUpdate) {
        AiSTTListView aiSTTListView;
        List<AiTextData> list = this.mAiTextDataList;
        if (list != null) {
            Intrinsics.checkNotNull(list);
            if (!list.isEmpty()) {
                this.lastScrollPosition = position;
                List<AiTextData> list2 = this.mAiTextDataList;
                Intrinsics.checkNotNull(list2);
                int size = list2.size();
                for (int i = 0; i < size; i++) {
                    List<AiTextData> list3 = this.mAiTextDataList;
                    Intrinsics.checkNotNull(list3);
                    AiTextData aiTextData = list3.get(i);
                    if (aiTextData.updateReplayPosition(position) || forceUpdate) {
                        aiTextData.getText().clearSpans();
                        int startReplayPosition = aiTextData.getStartReplayPosition();
                        int endReplayPosition = aiTextData.getEndReplayPosition();
                        if (aiTextData.getStartTime() > position || position > aiTextData.getEndTime()) {
                            aiSTTListView = this;
                            AiSTTListViewAdapter aiSTTListViewAdapter = aiSTTListView.mAiSTTListViewAdapter;
                            Intrinsics.checkNotNull(aiSTTListViewAdapter);
                            aiSTTListViewAdapter.notifyItemChanged(i);
                        } else {
                            StringBuilder sbM1173s = AbstractC0622a.m1173s(position, startReplayPosition, "updateSTTReplay# foundViewToScroll at ", " | startReplayPos=", " | endReplayPos=");
                            sbM1173s.append(endReplayPosition);
                            sbM1173s.append(" | forceUpdate=");
                            sbM1173s.append(forceUpdate);
                            Logger.m12713i(TAG, sbM1173s.toString());
                            if (startReplayPosition != -1) {
                                PaintHelper paintHelper = this.mPaintHelper;
                                Intrinsics.checkNotNull(paintHelper);
                                paintHelper.setSTTReplayPaintedString(aiTextData.getText(), startReplayPosition, endReplayPosition + 1);
                                aiSTTListView = this;
                                scrollToItem$default(aiSTTListView, i, startReplayPosition, false, null, null, 28, null);
                            } else if (endReplayPosition != -1) {
                                aiSTTListView = this;
                                scrollToItem$default(aiSTTListView, i, endReplayPosition, false, null, null, 28, null);
                            }
                            AiSTTListViewAdapter aiSTTListViewAdapter2 = aiSTTListView.mAiSTTListViewAdapter;
                            Intrinsics.checkNotNull(aiSTTListViewAdapter2);
                            aiSTTListViewAdapter2.notifyItemChanged(i);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiSTTListView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mAiTextDataList = new ArrayList();
        this.mSpeakerNameMap = new HashMap();
        this.mSelectedItemMap = new TreeMap();
        this.lastScrollPosition = -1;
        this.mAiParagraphInfo = new ArrayList();
        this.mContext = context;
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiSTTListView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mAiTextDataList = new ArrayList();
        this.mSpeakerNameMap = new HashMap();
        this.mSelectedItemMap = new TreeMap();
        this.lastScrollPosition = -1;
        this.mAiParagraphInfo = new ArrayList();
        this.mContext = context;
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiSTTListView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mAiTextDataList = new ArrayList();
        this.mSpeakerNameMap = new HashMap();
        this.mSelectedItemMap = new TreeMap();
        this.lastScrollPosition = -1;
        this.mAiParagraphInfo = new ArrayList();
        this.mContext = context;
        init();
    }

    public final void updateSTTReplay() {
        List<AiTextData> list = this.mAiTextDataList;
        if (list != null) {
            Intrinsics.checkNotNull(list);
            if (list.isEmpty()) {
                return;
            }
            List<AiTextData> list2 = this.mAiTextDataList;
            Intrinsics.checkNotNull(list2);
            Iterator<AiTextData> it = list2.iterator();
            while (it.hasNext()) {
                it.next().getText().clearSpans();
            }
            AiSTTListViewAdapter aiSTTListViewAdapter = this.mAiSTTListViewAdapter;
            Intrinsics.checkNotNull(aiSTTListViewAdapter);
            aiSTTListViewAdapter.notifyDataSetChanged();
        }
    }
}
