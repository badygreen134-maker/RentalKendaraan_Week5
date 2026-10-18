package app;

//import model.Kendaraan;
import controller.RentalController;
import model.Mobil;
import model.Motor;
import model.MiniBus;
import model.MobilPremium;

public class Main {
    public static void main(String[] args) {
        RentalController controller = new RentalController();

        controller.tambahDataAwal(new Motor("KT 6850 BAB", "Vario 160", 300000));
        controller.tambahDataAwal(new Mobil("KT 4938 OKT", "Kijang Innova", 250000));
        controller.tambahDataAwal(new Mobil("KT 9976 XVB", "Toyota Fortuner", 400000));
        controller.tambahDataAwal(new MiniBus("KT 0923 OVJ", "Toyota Hiace", 500000));
        controller.tambahDataAwal(new MobilPremium("L 9999 VIP", "Toyota Alphard", 1500000));

        controller.jalankan();
    }
}
