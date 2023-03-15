package com.muzhevsky.core.shareBots;

public interface TradeBot {
    void action(double newPrice);

    void setNewShare(Share share);

    double sellAll();
}
