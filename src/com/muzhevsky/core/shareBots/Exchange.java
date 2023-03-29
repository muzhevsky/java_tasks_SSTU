package com.muzhevsky.core.shareBots;

import java.util.HashMap;
import java.util.Map;

public class Exchange {
    private Map<String, Share> shares = new HashMap<>();

    public void addShare(Share share){
        shares.put(share.getName(), share);
    }

    public Share getShare(String name){
        return shares.get(name);
    }
}
