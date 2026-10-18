package controller;

import model.Kendaraan;
import model.KendaraanRepository;
import model.Penyewaan;
import model.PenyewaanRepository;
import view.RentalView;
import view.StrukView;
import java.util.List;
import model.KendaraanFactory;

public class RentalController {
    private final KendaraanRepository kendaraanRepo = new KendaraanRepository();
    private final PenyewaanRepository penyewaanRepo = new PenyewaanRepository();
    private final RentalView view = new RentalView();
    private final StrukView strukView = new StrukView();

    public void tambahDataAwal(Kendaraan kendaraan) {
        kendaraanRepo.tambah(kendaraan);
    }

    public void jalankan() {
        while (true) {
            String pilihan = view.tampilMenu();
            switch (pilihan) {
                case "1" -> view.tampilDaftarKendaraan(kendaraanRepo.semua());
                case "2" -> tambahKendaraan();
                case "3" -> sewaKendaraan();
                case "4" -> kembalikanKendaraan();
                case "5" -> view.tampilRiwayat(penyewaanRepo.semua());
                case "0" -> {
                    view.tampilPesan("Terima kasih telah menggunakan aplikasi ini");
                    return;
                }
                default -> view.tampilPesan("Pilihan tidak valid");
            }
        }
    }

    public void tambahKendaraan() {
        String platNomor = view.bacaTeks("Plat Nomor");
        if (platNomor.isEmpty() || kendaraanRepo.cariByPlat(platNomor) != null) {
            view.tampilPesan("Plat nomor tidak valid atau sudah terdaftar");
            return;
        }
        String merk = view.bacaTeks("Merk");
        String jenis = view.bacaTeks("Jenis (" + String.join("/", KendaraanFactory.JENIS) + ")").toUpperCase();
        if (!List.of(KendaraanFactory.JENIS).contains(jenis)) {
            view.tampilPesan("Jenis tidak dikenal.");
            return;
        }

        long tarifPerHari = view.bacaAngka("Tarif per Hari");
        if (tarifPerHari <= 0) {
            view.tampilPesan("Tarif harus lebih dari 0.");
            return;
        }

        kendaraanRepo.tambah(KendaraanFactory.buat(jenis, platNomor, merk, tarifPerHari));
        view.tampilPesan("Kendaraan berhasil ditambahkan.");
    }

    public void sewaKendaraan() {
        String platNomor = view.bacaTeks("Plat Nomor Kendaraan");
        Kendaraan kendaraan = kendaraanRepo.cariByPlat(platNomor);
        if (kendaraan == null || !kendaraan.isTersedia()) {
            System.out.println("Kendaraan tidak ditemukan atau sedang disewa");
            return;
        }
        String namaPenyewa = view.bacaTeks("Nama Penyewa");
        int lamaHari = (int) view.bacaAngka("Lama Sewa (hari)");
        if (lamaHari < kendaraan.getMinimalHari()) {
            view.tampilPesan(kendaraan.getMerk() + " minimal disewa " + kendaraan.getMinimalHari() + " hari.");
        }
        
        long totalBiaya = kendaraan.hitungBiaya(lamaHari);
        Penyewaan sewa = new Penyewaan(platNomor, namaPenyewa, kendaraan, lamaHari, totalBiaya);
        penyewaanRepo.tambah(sewa);
        kendaraan.setTersedia(false);
        strukView.cetak(sewa);
    }

    public void kembalikanKendaraan() {
        String platNomor = view.bacaTeks("Plat Nomor Kendaraan");
        Penyewaan sewa = penyewaanRepo.cariAktifByPlat(platNomor);
        if (sewa == null) {
            view.tampilPesan("Penyewaan tidak ada");
            return;
        }
        sewa.selesai();
        sewa.getKendaraan().setTersedia(true);
        view.tampilPesan("Kendaraan " + sewa.getKendaraan().getMerk() + " berhasil dikembalikan");
    }
}
