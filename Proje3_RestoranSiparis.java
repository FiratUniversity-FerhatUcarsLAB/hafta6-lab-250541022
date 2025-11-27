import java.util.Scanner;

public class SiparisSistemiNoLoop {

    //  1) Ana Yemek Fiyatı 
    public static double getMainDishPrice(int secim) {
        switch (secim) {
            case 1: return 85;   // Izgara Tavuk
            case 2: return 120;  // Adana Kebap
            case 3: return 110;  // Levrek
            case 4: return 65;   // Mantı
            default: return 0;
        }
    }

    // 2) Başlangıç Fiyatı 
    public static double getAppetizerPrice(int secim) {
        switch (secim) {
            case 1: return 25;   // Çorba
            case 2: return 45;   // Humus
            case 3: return 55;   // Sigara Böreği
            default: return 0;
        }
    }

    // 3) İçecek Fiyatı 
    public static double getDrinkPrice(int secim) {
        switch (secim) {
            case 1: return 15;   // Kola
            case 2: return 12;   // Ayran
            case 3: return 35;   // Taze Meyve Suyu
            case 4: return 25;   // Limonata
            default: return 0;
        }
    }

    //  4) Tatlı Fiyatı 
    public static double getDessertPrice(int secim) {
        switch (secim) {
            case 1: return 65;   // Künefe
            case 2: return 55;   // Baklava
            case 3: return 35;   // Sütlaç
            default: return 0;
        }
    }

    //  5) Combo Menü Kontrolü 
    public static boolean isComboOrder(boolean anaVar, boolean icecekVar, boolean tatliVar) {
        return anaVar && icecekVar && tatliVar;
    }

    // 6) Happy Hour 
    public static boolean isHappyHour(int saat) {
        if (saat >= 14 && saat <= 17) {
            return true;
        } else {
            return false;
        }
    }

    //  7) İndirim Hesaplama 
    public static double calculateDiscount(double tutar, boolean combo, boolean ogrenci, int saat) {

        // İç içe if İSTENİYOR → tamamen nested yazıldı
        if (combo) {
            tutar *= 0.85; // %15 combo indirimi

            if (ogrenci) {
                tutar *= 0.90; // %10 öğrenci indirimi

                if (tutar > 200) {
                    tutar *= 0.90; // %10 ekstra indirim
                }

            } else { // öğrenci değilse
                if (tutar > 200) {
                    tutar *= 0.90;
                }
            }

        } else { // combo değilse
            if (ogrenci) {
                tutar *= 0.90;

                if (tutar > 200) {
                    tutar *= 0.90;
                }
            } else {
                if (tutar > 200) {
                    tutar *= 0.90;
                }
            }
        }

        return tutar;
    }

    // 8) Bahşiş Önerisi 
    public static double calculateServiceTip(double tutar) {
        return tutar * 0.10;
    }

    // =====================================================================
    // ================================ MAIN ==============================
    // =====================================================================

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int saat;
        boolean ogrenci;

        System.out.print("Saat gir (0-23): ");
        saat = scanner.nextInt();

        System.out.print("Öğrenci misin? (1=Evet, 0=Hayır): ");
        ogrenci = scanner.nextInt() == 1;

        // ---- ürün seçimleri (döngü yok → tek seferlik giriş) ----

        System.out.print("Ana Yemek (1-4) seç veya 0: ");
        int anaSecim = scanner.nextInt();
        double ana = getMainDishPrice(anaSecim);
        boolean anaVar = (ana > 0);

        System.out.print("Başlangıç (1-3) seç veya 0: ");
        int basSecim = scanner.nextInt();
        double bas = getAppetizerPrice(basSecim);

        System.out.print("İçecek (1-4) seç veya 0: ");
        int icecekSecim = sc.nextInt();
        double icecek = getDrinkPrice(icecekSecim);

        boolean icecekVar = false;
        if (icecek > 0) {
            icecekVar = true;

            if (isHappyHour(saat)) {
                icecek *= 0.80; 
            }
        }

        System.out.print("Tatlı (1-3) seç veya 0: ");
        int tatliSecim = sc.nextInt();
        double tatli = getDessertPrice(tatliSecim);
        boolean tatliVar = (tatli > 0);

        // ---------------- TOPLAM ----------------
        double toplam = ana + bas + icecek + tatli;

        boolean combo = isComboOrder(anaVar, icecekVar, tatliVar);

        toplam = calculateDiscount(toplam, combo, ogrenci, saat);

        double bahsis = calculateServiceTip(toplam);

        // ---------------- ÖZET ----------------
        System.out.println("\n===== SİPARİŞ ÖZETİ =====");
        System.out.printf("Ana Yemek : %.2f TL%n", ana);
        System.out.printf("Başlangıç : %.2f TL%n", bas);
        System.out.printf("İçecek    : %.2f TL%n", icecek);
        System.out.printf("Tatlı     : %.2f TL%n", tatli);

        System.out.println("----------------------------");
        System.out.printf("TOPLAM : %.2f TL%n", toplam);
        System.out.printf("Bahşiş (%%10): %.2f TL%n", bahsis);

        scanner.close
      
    }
}

