package view;

import model.Penyewaan;

public class StrukView {
    public void cetak(Penyewaan p) {
        System.out.println("========================Struk Sewa========================");
        System.out.println("No. Sewa: " + p.getId());
        System.out.println("Nama Penyewa: " + p.getNamaPenyewa());
        System.out.println("kendaraan: " + p.getKendaraan().getMerk() + " (" + p.getKendaraan().getPlatNomor() + ")");
        System.out.println("Jenis Kendaraan: " + p.getKendaraan().getJenis());
        System.out.println("Lama Sewa (hari): " + p.getLamaHari()+ " hari");
        System.out.println("Total Biaya: " + Format.rupiah(p.getTotalBiaya()));
        System.out.println("==========================================================");

    }
}
