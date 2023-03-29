package com.muzhevsky.core.shareBots;

import java.util.ArrayList;
import java.util.List;

public class Share {

    private String name;
    private double price;

    private List<TradeBot> followersList = new ArrayList<>();

    public Share(String name, double price) {
        if (name == null || name.length() == 0)
            throw new IllegalArgumentException("name is null or empty");

        if (price <= 1e-4)
            throw new IllegalArgumentException("price is less or equals to zero");

        this.name = name;
        this.price = price;
    }

    public void addFollower(TradeBot bot) {
        if (bot == null)
            throw new IllegalArgumentException("bot is null");

        if (botIsFollowing(bot))
            return;

        followersList.add(bot);
        bot.setNewShare(this);
    }

    private boolean botIsFollowing(TradeBot bot) {
        for (TradeBot item : followersList)
            if (item == bot)
                return true;

        return false;
    }

    public void removeFollower(TradeBot bot) {
        for (int i = 0; i < followersList.size(); i++)
            if (followersList.get(i) == bot) {
                followersList.remove(i);
                bot.sellAll();
                return;
            }
    }

    public String getName() {return name;}
    public double getPrice() {
        return price;
    }

    public void setPrice(double newPrice) {
        if (price < 1e-4)
            throw new IllegalArgumentException("price is less or equals to zero");

        this.price = newPrice;
        for (TradeBot bot : followersList)
            bot.action(newPrice);
    }

    @Override
    public String toString() {
        return name;
    }
}
