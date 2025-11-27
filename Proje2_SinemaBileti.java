import java.util.Scanner;

public class SinemaBiletiKlasik {

    // 1) Hafta sonu kontrolü
    public static boolean isWeekend(int gun) {
        return (gun == 6 || gun == 7);
    }

    // 2) Matine kontrolü (12:00 öncesi)
    public static boolean isMatinee(int saat) {
        return saat < 12;
    }

    // 3) Temel fiyat hesaplama
    public static double calculateBasePrice(int gun, int saat) {
        boolean haftaSonu = isWeekend(gun);
        boolean matine = isMatinee(saat);

        if (haftaSonu) {
            if (matine) return 55;
            else return 85;
        } else {
            if (matine) return 45;
            else return 65;
        }
    }

    // 4) İndirim hesaplama
    public static double calculateDiscount(int yas, int meslek, int gun) {

        // Yaşa göre indirim
        if (yas < 12) return 0.25;
        if (yas >= 65) return 0.30;

        // Meslek → 1=Öğrenci, 2=Öğretmen, 3=Diğer
        switch (meslek) {
            case 1:  // öğrenci
                if (gun >= 1 && gun <= 4) return 0.20; // Pzt–Per
                else return 0.15; // Cuma–Pazar
            case 2:  // öğretmen
                if (gun == 3) return 0.35; // Çarşamba
                break;
        }

        return 0.0;
    }

    // 5) Film türü ekstra ücreti
    public static double getFormatExtra(int filmTuru) {
        switch (filmTuru) {
            case 2: return 25;  // 3D
            case 3: return 35;  // IMAX
            case 4: return 50;  // 4DX
            default: return 0;  // 2D
        }
    }

    // 6) Final fiyat hesaplama
    public static double calculateFinalPrice(int gun, int saat, int yas, int meslek, int filmTuru) {
        double base = calculateBasePrice(gun, saat);
        double extra = getFormatExtra(filmTuru);
        double discountRate = calculateDiscount(yas, meslek, gun);

        double toplam = base + extra;
        toplam -= toplam * discountRate;

        return toplam;
    }

    // 7) Bilet bilgisi oluşturma
    public static void generateTicketInfo(int gun, int saat, int yas, int meslek, int filmTuru) {

        String gunAdi = "";
        switch (gun) {
            case 1: gunAdi = "Pazartesi"; 
            break;
            case 2: gunAdi = "Salı";
            break;
            case 3: gunAdi = "Çarşamba";
            break;
            case 4: gunAdi = "Perşembe"; 
            break;
            case 5: gunAdi = "Cuma"; 
            break;
            case 6: gunAdi = "Cumartesi"; 
            break;
            case 7: gunAdi = "Pazar";
            break;
            default: gunAdi = "Geçersiz Gün";
        }

        String meslekAdi = "";
        switch (meslek) {
            case 1: meslekAdi = "Öğrenci";
            break;
            case 2: meslekAdi = "Öğretmen";
            break;
            case 3: meslekAdi = "Diğer"; 
            break;
            default: meslekAdi = "Bilinmeyen"; 
        }

        String formatAdi = "";
        switch (filmTuru) {
            case 1: formatAdi = "2D"; 
            break;
            case 2: formatAdi = "3D";
            break;
            case 3: formatAdi = "IMAX";
            break;
            case 4: formatAdi = "4DX";
            break;
            default: formatAdi = "Bilinmeyen"; 
        }

        double fiyat = calculateFinalPrice(gun, saat, yas, meslek, filmTuru);

        System.out.println("\n----- BİLET BİLGİSİ -----");
        System.out.println("Gün: " + gunAdi);
        System.out.println("Saat: " + saat + ":00");
        System.out.println("Yaş: " + yas);
        System.out.println("Meslek: " + meslekAdi);
        System.out.println("Film Türü: " + formatAdi);
        System.out.printf("Toplam Fiyat: %.2f TL%n", fiyat);
    }

    // ================= MAIN =================
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Gün seç (1=Pzt, 2=Salı, 3=Çarş, 4=Perş, 5=Cuma, 6=Cmt, 7=Pazar): ");
        int gun = scanner.nextInt();

        System.out.print("Saat gir (0-23): ");
        int saat = scanner.nextInt();

        System.out.print("Yaş: ");
        int yas = scanner.nextInt();

        System.out.println("Meslek (1=Öğrenci, 2=Öğretmen, 3=Diğer): ");
        int meslek = scanner.nextInt();

        System.out.println("Film Türü (1=2D, 2=3D, 3=IMAX, 4=4DX): ");
        int filmTuru = scanner.nextInt();

        generateTicketInfo(gun, saat, yas, meslek, filmTuru);

        scanner.close();
    }
}
