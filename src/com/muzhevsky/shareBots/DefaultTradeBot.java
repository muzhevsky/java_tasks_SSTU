package com.muzhevsky.shareBots;

public class DefaultTradeBot implements TradeBot {
    private String name;

    private double prevPrice;
    private int shareCount;
    private final int amountToBuy = 5;

    private CheckRule sellRule;
    private CheckRule buyRule;

    private Share share;
    private Account account;

    public DefaultTradeBot(String name, CheckRule buyRule, CheckRule sellRule, Account account) {
        if (name == null || name.length() < 1)
            throw new IllegalArgumentException("name is null or empty");
        if (buyRule == null)
            throw new IllegalArgumentException("buy rule is null");
        if (sellRule == null)
            throw new IllegalArgumentException("sell rule is null");
        if (account == null)
            throw new IllegalArgumentException("account is null");

        this.name = name;
        this.buyRule = buyRule;
        this.sellRule = sellRule;
        this.account = account;
    }

    public void setNewShare(Share share) {
        if (share == null)
            throw new IllegalArgumentException("share is null");

        double income = prevPrice * shareCount;
        account.addMoney(income);

        if (this.share != null)
            this.share.removeFollower(this);
        share.addFollower(this);

        prevPrice = share.getPrice();
        this.share = share;
    }

    public void action(double newPrice) {

        if (sellRule.check(prevPrice, newPrice)) {
            System.out.println("sell");
            prevPrice = newPrice;

            account.addMoney(shareCount * prevPrice);
            shareCount = 0;

        }

        else if (buyRule.check(prevPrice, newPrice)) {
            System.out.println("buy");
            prevPrice = prevPrice * shareCount;
            shareCount += amountToBuy;
            prevPrice = (prevPrice + newPrice * amountToBuy) / shareCount;

            account.spendMoney(amountToBuy * newPrice);
        }

    }

    @Override
    public double sellAll() {
        double fullPrice = shareCount * prevPrice;
        account.addMoney(fullPrice);
        return fullPrice;
    }

    @Override
    public String toString() {
        return name;
    }
}