package com.samsung.scsp.common;

import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.error.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import p074R1.C0230b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class JournalFactory {
    private static final boolean DEBUG_JOURNAL = false;
    private static final Logger logger = Logger.get("JournalFactory");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class JournalBase implements Journal {
        private final List<JournalItem> journalItems;

        public /* synthetic */ JournalBase(int i) {
            this();
        }

        private static /* synthetic */ void lambda$apply$0(JournalItem journalItem) {
            Logger logger = JournalFactory.logger;
            Objects.requireNonNull(journalItem);
            logger.m12931d(new C0230b(journalItem, 3));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$apply$1(Consumer consumer) {
            synchronized (this.journalItems) {
                consumer.accept(new ArrayList(this.journalItems));
                this.journalItems.clear();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$apply$2(Consumer consumer) {
            FaultBarrier.run(new C11626e(this, consumer, 0));
        }

        @Override // com.samsung.scsp.common.Journal
        public void apply(final Consumer<List<JournalItem>> consumer) {
            new Thread(new Runnable() { // from class: com.samsung.scsp.common.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.f8139a.lambda$apply$2(consumer);
                }
            }).start();
        }

        @Override // com.samsung.scsp.common.Journal
        public void begin(String str, String str2) {
            this.journalItems.add(JournalItem.begin(str, str2));
        }

        @Override // com.samsung.scsp.common.Journal
        public void end(String str, String str2) {
            this.journalItems.add(JournalItem.end(str, str2));
        }

        @Override // com.samsung.scsp.common.Journal
        public void error(String str, String str2, int i) {
            this.journalItems.add(JournalItem.error(str, str2, i));
        }

        private JournalBase() {
            this.journalItems = new ArrayList();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LazyHolder {
        private static final Map<String, Journal> MAP = new HashMap();

        private LazyHolder() {
        }
    }

    public static Journal get(String str) {
        Journal journal = (Journal) LazyHolder.MAP.get(str);
        if (journal != null) {
            return journal;
        }
        JournalBase journalBase = new JournalBase(0);
        LazyHolder.MAP.put(str, journalBase);
        return journalBase;
    }
}
