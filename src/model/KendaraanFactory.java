package model;

public class KendaraanFactory {
        public static final String[] JENIS = {"MOBIL", "MOTOR", "MINIBUS", "PREMIUM"};

        public static Kendaraan buat(String jenis, String platNomor, String merk, long tarifPerHari) {
                return switch (jenis) {
                case "MOBIL" -> new Mobil(platNomor, merk, tarifPerHari);
                case "MOTOR" -> new Motor(platNomor, merk, tarifPerHari);
                case "MINIBUS" -> new MiniBus(platNomor, merk, tarifPerHari);
                case "PREMIUM" -> new MobilPremium(platNomor, merk, tarifPerHari);
                default -> null;
                };
        }
}