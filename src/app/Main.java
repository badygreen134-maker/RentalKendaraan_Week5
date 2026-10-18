package app;

import model.Kendaraan;
import controller.RentalController;

public class Main {
    public static void main(String[] args) {
        RentalController controller = new RentalController();

        controller.tambahDataAwal(new Kendaraan("KT 6850 BAB", "Vario 160", "Motor", 300000));
        controller.tambahDataAwal(new Kendaraan("KT 4938 BAB", "Vario 150", "Motor", 250000));
        controller.tambahDataAwal(new Kendaraan("KT 6850 BAB", "Vario 125", "Motor", 200000));
        controller.jalankan();
    }
}
