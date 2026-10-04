package com.microsoft.identity.common.java.controllers;

import com.microsoft.identity.common.java.commands.BaseCommand;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CommandResultCache {
    private static final int DEFAULT_ITEM_COUNT = 250;
    private final Object cacheLock;
    private final Map<BaseCommand, CommandResultCacheItem> mCache;

    public CommandResultCache() {
        this(250);
    }

    public void clear() {
        synchronized (this.cacheLock) {
            this.mCache.clear();
        }
    }

    public CommandResult get(BaseCommand baseCommand) {
        synchronized (this.cacheLock) {
            try {
                CommandResultCacheItem commandResultCacheItem = this.mCache.get(baseCommand);
                if (commandResultCacheItem == null) {
                    return null;
                }
                if (commandResultCacheItem.isExpired()) {
                    this.mCache.remove(baseCommand);
                    return null;
                }
                return commandResultCacheItem.getValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int getSize() {
        int size;
        synchronized (this.cacheLock) {
            size = this.mCache.size();
        }
        return size;
    }

    public void put(BaseCommand baseCommand, CommandResult commandResult) {
        synchronized (this.cacheLock) {
            this.mCache.put(baseCommand, new CommandResultCacheItem(commandResult));
        }
    }

    public CommandResultCache(final int i) {
        this.cacheLock = new Object();
        this.mCache = new LinkedHashMap<BaseCommand, CommandResultCacheItem>(i + 1, 0.75f, true) { // from class: com.microsoft.identity.common.java.controllers.CommandResultCache.1
            @Override // java.util.LinkedHashMap
            public boolean removeEldestEntry(Map.Entry<BaseCommand, CommandResultCacheItem> entry) {
                return size() > i;
            }
        };
    }
}
