public class Motor extends Kendaraan implements DapatDinyalakan {

    private final int jumlahRoda = 2;
    private String jenis;

    public Motor(String platNomor, String merk, String jenis) {
        super(platNomor, merk);
        this.jenis = jenis;
    }

    public Motor(String platNomor, String merk, int bbm, String jenis) {
        super(platNomor, merk, bbm);
        this.jenis = jenis;
    }

    public int getJumlahRoda() {
        return jumlahRoda;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Roda      : " + jumlahRoda);
        System.out.println("Jenis     : " + jenis);
    }

    @Override
    public void jalan(int jarak) {
        if (isMesinHidup()) {
            if (hitungSisaJarak() >= jarak) {
                setKilometer(getKilometer() + jarak);
                setBbm(getBbm() - jarak / KM_PER_LITER);
                System.out.println("Motor berjalan " + jarak + " km");
            } else {
                System.out.println("Motor tidak bisa jalan " + jarak + " km, BBM tidak cukup");
            }
        } else {
            System.out.println("Motor belum bisa jalan, mesin masih mati");
        }
    }

    @Override
    public void nyalakan() {
        if (getBbm() > 0) {
            setMesinHidup(true);
            System.out.println("Mesin motor menyala");
        } else {
            System.out.println("Mesin motor gagal menyala, BBM habis");
        }
    }

    @Override
    public void matikan() {
        setMesinHidup(false);
        System.out.println("Mesin motor dimatikan");
    }
}
