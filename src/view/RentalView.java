package view;

import java.util.List;
import java.util.Scanner;
import model.Kendaraan;
import model.Penyewaan;

public class RentalView {
    private final Scanner input = new Scanner(System.in);

    public String tampilMenu() {
        System.out.println();
        System.out.println("=== APLIKASI RENTAL KENDARAAN ===");
        System.out.println("1. Tampilkan Daftar Kendaraan");
        System.out.println("2. Tambah Kendaraan");
        System.out.println("3. Sewa Kendaraan");
        System.out.println("4. Kembalikan Kendaraan");
        System.out.println("5. Tampilkan Riwayat Pesanan");
        System.out.println("0. Keluar");
        return bacaTeks("Pilih menu");
    }

    public void tampilDaftarKendaraan(List<Kendaraan> daftar) {
        System.out.println("===================================");
        System.out.println("         DAFTAR KENDARAAN          ");
        System.out.println("===================================");
        if(daftar.isEmpty()) {
            System.out.println("Belum ada data kendaraan");
            return;
        } 
            for (Kendaraan k : daftar) {
                System.out.println(
                    k.getPlatNomor() + " | " + k.getMerk() + " | " + k.getJenis() 
                    + " | " + Format.rupiah(k.getTarifPerHari()) + " | " + k.getMinimalHari() + " | " 
                    + (k.isTersedia() ? "Tersedia" : "Disewa"));
            }
    }

    public void tampilDaftarPenyewaan(List<Penyewaan> daftar) {

    }

    public void tampilRiwayat(List<Penyewaan> daftar) {
        System.out.println("===================================");
        System.out.println("         Riwayat Penyewaan         ");
        System.out.println("===================================");
        if(daftar.isEmpty()) {
            System.out.println("Belum ada Penyewaan");
            return;
        } 
            for (Penyewaan p : daftar) {
                System.out.println(p.getId() + " | " + p.getNamaPenyewa() + " | " + p.getKendaraan().getMerk() + " | " + p.getLamaHari() + " | " + Format.rupiah(p.getTotalBiaya()) + " | " + (p.isAktif() ? "Aktif" : "Tidak Aktif"));
            }
    }

    public String bacaTeks(String label) {
        System.out.print(label + ": ");
        return input.nextLine().trim();
    }

    public long bacaAngka(String label) {
        while(true) {
            String teks = bacaTeks(label);
            try{
                return Long.parseLong(teks);
            } catch (NumberFormatException e) {
                tampilPesan("Input harus berupa angka");
            }
        }
    }
    
    public void tampilPesan(String pesan) {
        System.out.println(">> " + pesan);
    }
}
