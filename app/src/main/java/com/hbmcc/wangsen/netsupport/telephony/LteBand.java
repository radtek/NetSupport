package com.hbmcc.wangsen.netsupport.telephony;

import java.util.ArrayList;
import java.util.List;

public class LteBand {
    public static final int FDD = 0;
    public static final int TDD = 1;

    int band;
    int duplexMode;
    int dlEarfcnMin;
    int dlEarfcnMax;
    int ulEarfcnMin;
    int ulEarfcnMax;
    double dlFreqMin;
    double dlFreqMax;
    double ulFreqMin;
    double ulFreqMax;

    public LteBand(int band, int duplexMode, int dlEarfcnMin, int dlEarfcnMax, int ulEarfcnMin, int ulEarfcnMax, double dlFreqMin, double dlFreqMax, double ulFreqMin, double ulFreqMax) {
        this.band = band;
        this.duplexMode = duplexMode;
        this.dlEarfcnMin = dlEarfcnMin;
        this.dlEarfcnMax = dlEarfcnMax;
        this.ulEarfcnMin = ulEarfcnMin;
        this.ulEarfcnMax = ulEarfcnMax;
        this.dlFreqMin = dlFreqMin;
        this.dlFreqMax = dlFreqMax;
        this.ulFreqMin = ulFreqMin;
        this.ulFreqMax = ulFreqMax;
    }

    static List<LteBand> lteBandList = new ArrayList<>(38);

    private static boolean init() {
        lteBandList.add(new LteBand(1, FDD, 0, 599, 18000, 18599, 2110, 2170, 1920, 1980));
        lteBandList.add(new LteBand(2, FDD, 600, 1199, 18600, 19199, 1930, 1990, 1850, 1910));
        lteBandList.add(new LteBand(3, FDD, 1200, 1949, 19200, 19949, 1805, 1880, 1710, 1785));
        lteBandList.add(new LteBand(4, FDD, 1950, 2399, 19950, 20399, 2110, 2155, 1710, 1755));
        lteBandList.add(new LteBand(5, FDD, 2400, 2649, 20400, 20649, 869, 894, 824, 849));
        lteBandList.add(new LteBand(6, FDD, 2650, 2749, 20650, 20749, 875, 885, 830, 840));
        lteBandList.add(new LteBand(7, FDD, 2750, 3449, 20750, 21449, 2620, 2690, 2500, 2570));
        lteBandList.add(new LteBand(8, FDD, 3450, 3799, 21450, 21799, 925, 960, 880, 915));
        lteBandList.add(new LteBand(9, FDD, 3800, 4149, 21800, 22149, 1844.9, 1879.9, 1749.9, 1784.9));
        lteBandList.add(new LteBand(10, FDD, 4150, 4749, 22150, 22749, 2110, 2170, 1710, 1770));
        lteBandList.add(new LteBand(11, FDD, 4750, 4999, 22750, 22999, 1475.9, 1500.9, 1427.9, 1452.9));
        lteBandList.add(new LteBand(12, FDD, 5000, 5179, 23000, 23179, 728, 746, 698, 716));
        lteBandList.add(new LteBand(13, FDD, 5180, 5279, 23180, 23279, 746, 756, 777, 787));
        lteBandList.add(new LteBand(14, FDD, 5280, 5379, 23280, 23379, 758, 768, 788, 798));
        lteBandList.add(new LteBand(17, FDD, 5730, 5849, 23730, 23849, 734, 746, 704, 716));
        lteBandList.add(new LteBand(18, FDD, 5850, 5999, 23850, 23999, 860, 875, 815, 830));
        lteBandList.add(new LteBand(19, FDD, 6000, 6149, 24000, 24149, 875, 890, 830, 845));
        lteBandList.add(new LteBand(20, FDD, 6150, 6449, 24150, 24449, 791, 821, 832, 862));
        lteBandList.add(new LteBand(21, FDD, 6450, 6599, 24450, 24599, 1495.9, 1510.9, 1447.9, 1462.9));
        lteBandList.add(new LteBand(22, FDD, 6600, 7399, 24600, 25399, 3510, 3590, 3410, 3490));
        lteBandList.add(new LteBand(23, FDD, 7500, 7699, 25500, 25699, 2180, 2200, 2000, 2020));
        lteBandList.add(new LteBand(24, FDD, 7700, 8039, 25700, 26039, 1525, 1559, 1626.5, 1660.5));
        lteBandList.add(new LteBand(25, FDD, 8040, 8689, 26040, 26689, 1930, 1995, 1850, 1915));
        lteBandList.add(new LteBand(26, FDD, 8690, 9039, 26690, 27039, 859, 894, 814, 849));
        lteBandList.add(new LteBand(27, FDD, 9040, 9209, 27040, 27209, 852, 869, 807, 824));
        lteBandList.add(new LteBand(28, FDD, 9210, 9659, 27210, 27659, 758, 803, 703, 748));
        lteBandList.add(new LteBand(33, TDD, 36000, 36199, 36000, 36199, 1900, 1920, 1900, 1920));
        lteBandList.add(new LteBand(34, TDD, 36200, 36349, 36200, 36349, 2010, 2025, 2010, 2025));
        lteBandList.add(new LteBand(35, TDD, 36350, 36949, 36350, 36949, 1850, 1910, 1850, 1910));
        lteBandList.add(new LteBand(36, TDD, 36950, 37549, 36950, 37549, 1930, 1990, 1930, 1990));
        lteBandList.add(new LteBand(37, TDD, 37550, 37749, 37550, 37749, 1910, 1930, 1910, 1930));
        lteBandList.add(new LteBand(38, TDD, 37750, 38249, 37750, 38249, 2570, 2620, 2570, 2620));
        lteBandList.add(new LteBand(39, TDD, 38250, 38649, 38250, 38649, 1880, 1920, 1880, 1920));
        lteBandList.add(new LteBand(40, TDD, 38650, 39649, 38650, 39649, 2300, 2400, 2300, 2400));
        lteBandList.add(new LteBand(41, TDD, 39650, 41589, 39650, 41589, 2496, 2690, 2496, 2690));
        lteBandList.add(new LteBand(42, TDD, 41590, 43589, 41590, 43589, 3400, 3600, 3400, 3600));
        lteBandList.add(new LteBand(43, TDD, 43590, 45589, 43590, 45589, 3600, 3800, 3600, 3800));
        lteBandList.add(new LteBand(44, TDD, 45590, 46589, 45590, 46589, 703, 803, 703, 803));
        return true;
    }

    private static LteBand getEarfcnBelong(int earfcn) {
        if(lteBandList.isEmpty()){
            init();
        }
        for (LteBand lteBand : lteBandList) {
            if (lteBand.dlEarfcnMin < earfcn && lteBand.dlEarfcnMax > earfcn) {
                return lteBand;
            }
        }
        return new LteBand(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    public static int getBand(int earfcn) {
        return getEarfcnBelong(earfcn).band;
    }

    public static double getDlCenterFreq(int earfcn) {
        LteBand lteBand = getEarfcnBelong(earfcn);
        return (earfcn - lteBand.dlEarfcnMin) / 10 + lteBand.dlFreqMin;
    }

    public static double getUlCenterFreq(int earfcn) {
        LteBand lteBand = getEarfcnBelong(earfcn);
        return (earfcn - lteBand.dlEarfcnMin) / 10 + lteBand.ulFreqMin;
    }

    public static int getDuplexMode(int earfcn) {
        return getEarfcnBelong(earfcn).duplexMode;
    }

    public static int getDlEarfcnMin(int earfcn) {
        return getEarfcnBelong(earfcn).dlEarfcnMin;
    }

    public static int getDlEarfcnMax(int earfcn) {
        return getEarfcnBelong(earfcn).dlEarfcnMax;
    }

    public static int getUlEarfcnMin(int earfcn) {
        return getEarfcnBelong(earfcn).ulEarfcnMin;
    }

    public static int getUlEarfcnMax(int earfcn) {
        return getEarfcnBelong(earfcn).ulEarfcnMax;
    }

    public static double getDlFreqMin(int earfcn) {
        return getEarfcnBelong(earfcn).dlFreqMin;
    }

    public static double getDlFreqMax(int earfcn) {
        return getEarfcnBelong(earfcn).dlFreqMax;
    }

    public static double getUlFreqMin(int earfcn) {
        return getEarfcnBelong(earfcn).ulFreqMin;
    }

    public static double getUlFreqMax(int earfcn) {
        return getEarfcnBelong(earfcn).ulFreqMax;
    }


}
