package model;

public class Kendaraan {
    private final String platNomor;
    private final String merk;
    private final String jenis;
    private final long tarifPerHari;
    private boolean tersedia = true;

    public Kendaraan(String platNomor, String merk, String jenis, long tarifPerHari) {
        this.platNomor = platNomor;
        this.merk = merk;
        this.jenis = jenis;
        this.tarifPerHari = tarifPerHari;
    }

    public long hitungBiaya(int hari) {
        long total = tarifPerHari * hari;

        if (jenis.equals("MOBIL")){
            total += 50000; // asuransi
        } else if (jenis.equals("MOTOR")){
            if (hari >= 7) total -= total / 10; // diskon 10 ribu untuk motor jika sewa lebih dari 7 hari
        }
        return total;
    }

    public String getPlatNomor() {
        return platNomor;
    }

    public String getMerk() {
        return merk;
    }

    public String getJenis() {
        return jenis;
    }

    public long getTarifPerHari() {
        return tarifPerHari;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }
}
