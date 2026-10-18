package model;

public class Penyewaan {
    private final String id;
    private final String namaPenyewa;
    private final Kendaraan Kendaraan;
    private final int lamaHari;
    private final long totalBiaya;
    private boolean aktif = true;

    public Penyewaan(String id, String namaPenyewa, Kendaraan Kendaraan, int lamaHari, long totalBiaya) {
        this.id = id;
        this.namaPenyewa = namaPenyewa;
        this.Kendaraan = Kendaraan;
        this.lamaHari = lamaHari;
        this.totalBiaya = totalBiaya;
    }

    public String getId() {
        return id;
    }

    public String getNamaPenyewa() {
        return namaPenyewa;
    }

    public Kendaraan getKendaraan() {
        return Kendaraan;
    }

    public int getLamaHari() {
        return lamaHari;
    }

    public long getTotalBiaya() {
        return totalBiaya;
    }

    public boolean isAktif() {
        return aktif;
    }

    public void selesai() {
        this.aktif = false;
    }
}
