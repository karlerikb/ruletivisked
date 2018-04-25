class Rulett {

    public static void main(String[] args) {
        long[] euroopaRulett = {37, 36, 35, 34, 33, 32, 31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        viseteArv(euroopaRulett, "euroopa");

        long[] ameerikaRulett = {38, 37, 36, 35, 34, 33, 32, 31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        viseteArv(ameerikaRulett, "ameerika");

        // long[] taring = {6, 5, 4, 3, 2, 1};
        // viseteArv(taring);
    }

    static long suurimYhistegur(long arv1, long arv2) {
        long ajutine;
        while (arv2 > 0) {
            ajutine = arv2;
            arv2 = arv1 % arv2;
            arv1 = ajutine;
        }
        return arv1;
    }

    static long suurimYhistegur(long[] ruletinumbrid) {
        long arv1, arv2;
        arv1 = ruletinumbrid[0];
        for (int i = 1; i < ruletinumbrid.length; i++) {
            arv2 = ruletinumbrid[i];
            arv1 = suurimYhistegur(arv1, arv2);
        }
        return arv1;
    }

    static long vahimYhiskordne(long arv1, long arv2) {
        return arv1 * (arv2 / suurimYhistegur(arv1, arv2));
    }

    static long vahimYhiskordne(long[] ruletinumbrid) {
        long arv1, arv2;
        arv1 = ruletinumbrid[0];
        for (int i = 1; i < ruletinumbrid.length; i++) {
            arv2 = ruletinumbrid[i];
            arv1 = vahimYhiskordne(arv1, arv2);
        }
        return arv1;
    }

    static long murrulugeja(long[] ruletinumbrid) {
        long yhineNimetaja = vahimYhiskordne(ruletinumbrid);
        long murrulugeja = 0;
        long ruletinumber;

        for (int i = 0; i < ruletinumbrid.length; i++) {
            ruletinumber = ruletinumbrid[i];
            murrulugeja = murrulugeja + yhineNimetaja / ruletinumber * (ruletinumbrid.length);
        }
        return murrulugeja;
    }

    static void viseteArv(long[] ruletinumbrid, String ruletityyp) {
        long murrulugeja = murrulugeja(ruletinumbrid);
        long murrunimetaja = vahimYhiskordne(ruletinumbrid);
        long taandus = suurimYhistegur(murrulugeja, murrunimetaja);

        System.out.println(ruletityyp + " rulett, arv hariliku murruna taandamata: " + murrulugeja + " / " + murrunimetaja);
        System.out.println(ruletityyp + " rulett, arv hariliku murruna: " + (murrulugeja / taandus) + " / " + (murrunimetaja / taandus));
        System.out.println(ruletityyp + " rulett, arv kümnendmurruna: " + ((double)murrulugeja / (double)murrunimetaja));
        System.out.println();
    }
    
}