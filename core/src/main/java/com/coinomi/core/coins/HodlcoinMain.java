package com.coinomi.core.coins;

import com.coinomi.core.coins.families.BitFamily;

/**
 * @author FreeTrade
 */
public class HodlcoinMain extends BitFamily {
    private HodlcoinMain() {
        id = "hodlcoin.main";

        addressHeader = 40;
        p2shHeader = 5;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        spendableCoinbaseDepth = 100;
        dumpedPrivateKeyHeader = 168;

        name = "HOdlcoin";
        symbol = "HODL";
        uriScheme = "hodlcoin";
        bip44Index = 1989;
        unitExponent = 8;
       // feeValue = value(50000000L);
        feeValue = value(0);
        minNonDust = value(5460);
        softDustLimit = value(1000000); // 0.01 HODL
        softDustPolicy = SoftDustPolicy.AT_LEAST_BASE_FEE_IF_SOFT_DUST_TXO_PRESENT;
        //Note For historical reasons HOdlcoin uses 'Bitcoin Signed Message' for the header. 
        signedMessageHeader = toBytes("Bitcoin Signed Message:\n");
    }

    private static HodlcoinMain instance = new HodlcoinMain();
    public static synchronized CoinType get() {
        return instance;
    }
}
