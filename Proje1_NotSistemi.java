import java.util.Scanner;

public class NotDegerlendirme {

    // Ortalama hesaplama metodu
    public static double calculateAverage(double vize_notu, double final_notu, double odev) {
        return vize_notu * 0.30 + final_notu * 0.40 + odev * 0.30;
    }

    // Geçme durumu metodu
    public static boolean isPassingGrade(double ort) {
        return ort >= 50;
    }

    // Harf notu metodu
    public static String getLetterGrade(double ort) {
        if (ort >= 90) return "A";
        else if (ort >= 80) return "B";
        else if (ort >= 70) return "C";
        else if (ort >= 60) return "D";
        else return "F";
    }

    // Onur listesi metodu
    public static boolean isHonorList(double ort, double vize_notu, double final_notu, double odev) {
        return ort >= 85 && vize_notu >= 70 && final_notu >= 70 && odev >= 70;
    }

    // Bütünleme hakkı metodu
    public static boolean hasRetakeRight(double ort) {
        return ort >= 40 && ort < 50;
    }


    // ------------------------ MAIN PROGRAM ------------------------
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Vize notu: ");
        double vize = input.nextDouble();

        System.out.print("Final notu: ");
        double fin = input.nextDouble();

        System.out.print("Ödev notu: ");
        double odev = input.nextDouble();

        double ortalama = calculateAverage(vize, fin, odev);

        System.out.println("\n--- SONUÇLAR ---");
        System.out.printf("Ortalama: %.2f%n", ortalama);
        System.out.println("Harf Notu: " + getLetterGrade(ortalama));

        // Geçti kaldı
        if (isPassingGrade(ortalama)) {
            System.out.println("Durum: GEÇTİ");
        } else {
            System.out.println("Durum: KALDI");
        }

        // Bütünleme
        if (hasRetakeRight(ortalama)) {
            System.out.println("Bütünleme Hakkı: VAR");
        } else {
            System.out.println("Bütünleme Hakkı: YOK");
        }

        input.close();
    }
}
