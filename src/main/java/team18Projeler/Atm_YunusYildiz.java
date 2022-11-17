package team18Projeler;

import java.util.Scanner;
/*      ATM
       Kullaniciya giriş için kart numarasi ve şifresini isteyin, eger herhangi birini yanlis girerse tekrar isteyin.
       Kart numarasi aralarda boşluk ile girerse de eger doğruysa kabul edin.
       Kart numarasi ve sifre dogrulanirsa kullanicinin yapabileceği işlemleri ekrana yazdirin,
       Bakiye sorgula, para yatirma, para çekme, para gönderme, sifre değiştirme ve cikis.
       Para çekme ve para gonderme işleminde mevcut bakiyeden buyuk para çekilemez,
       Para gönderme işleminde istenen iban TR ile baslamali ve toplam 26 karakterli olmali, eger değilse menü ekranina geri donsun.
       Sifre değiştirme işleminde mevcut şifreyi teyit ettikten sonra, sifre değişiklik işlemini yapmali,       */
public class Atm_YunusYildiz {

    static String kartNo1 = "1111222233334444";//Burası kullanıcının DataBase'de kayıtlı olan kart numarası
    static String kartNo2 = "1111 2222 3333 4444";//Burası kullanıcının DataBase'de kayıtlı olan kart numarası boşluklu hali
    static String sifre = "ab1cd2";//Burası kullanıcının DataBase'de kayıtlı olan şifresi

    static String inputKartNo;//Kullanıcının giriş yaparken girdiği kart numarasını içine koyacağımız variable
    static String inputSifre;//Kullanıcının giriş yaparken girdiği şifreyi içine koyacağımız variable

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        do {
            System.out.println("Lütfen kart numaranızı giriniz...");
            inputKartNo =input.nextLine();
            System.out.println("Lütfen şifrenizi giriniz");
            inputSifre = input.nextLine();
            boolean kartNoYanlisMi = !inputKartNo.equals(kartNo1) && !inputKartNo.equals(kartNo2);
            boolean sifreYanlisMi = !inputSifre.equals(sifre);
            if (kartNoYanlisMi || sifreYanlisMi) {
                System.out.println("Eksik veya hatalı giriş yaptınız bilgileri tekrardan giriniz...");
            } else {
                System.out.println("Giriş başarılı ana menüye yönlendiriliyorsunuz...");
                break;
            }
        } while (true);


        int mevcutBakiye = 5000;
        int islem;
        do {
            System.out.println("Lütfen Yapmak istediğiniz işlemi seçiniz\nBakiye sorgulama için '1'e, Para Yatırma için '2'ye, Para çekme için '3'e, Para Gönderme için '4'e, Şifre değiştirme için '5'e, Çıkış için 0'a basınız");
            islem = input.nextInt();
            switch (islem) {
                case 1:
                    System.out.println("Bakiyeniz " + mevcutBakiye + " tl dir.");
                    islem = 0;
                    break;
                case 2:
                    System.out.println("Yatıracağınız miktarı giriniz...");
                    int yatirilanMiktar = input.nextInt();
                    int guncellenmisBakiye = mevcutBakiye + yatirilanMiktar;
                    System.out.println("Yatırma işleminiz başarıylar gerçekleşmiştir, Eski bakiyeniz: "+mevcutBakiye+"₺ Güncel bakiyeniz: "+guncellenmisBakiye+"₺");
                    islem = 0;
                    break;
                case 3:
                    System.out.println("Çekmek istediğiniz miktari giriniz...");
                    int cekilecekMiktar = input.nextInt();
                    if (cekilecekMiktar > mevcutBakiye) {
                        System.out.println("Mevcut bakiyeden buyuk para çekilemez!");
                    } else {
                        System.out.println("İşleminiz birkaç saniye içerisinde gerçekleştirilcek lütfen bekleyiniz😀😀😀");
                        for (int i = 0; i < 10000; i++) {}//burada loop süresince müşteriyi beklettik 😂😁
                        System.out.println("Paranızı alabilirsiniz Çekilen miktar: "+cekilecekMiktar+"₺ Güncel bakiye: "+(mevcutBakiye-cekilecekMiktar)+"₺");
                    }
                    islem = 0;
                    break;
                case 4:
                    System.out.println("Göndermek istediğiniz IBAN numarasını giriniz");
                    String iban = input.next();
                    if (!iban.startsWith("TR") || iban.length() != 26) {
                        System.out.println("IBAN numarası yanlış veya eksik girilmiştir Ana Menüye yönlendiriliyorsunuz");
                        break;
                    }

                    System.out.println("Göndermek istediğiniz miktari giriniz");
                    int gonderilecekMiktar = input.nextInt();

                    if (gonderilecekMiktar > mevcutBakiye) {
                        System.out.println("Mevcut bakiyeden buyuk para gönderilemez! Program sonlandırılıyor...");
                        islem = 0;
                        break;
                    } else {
                        System.out.println("Para gönderme işleminiz başarıyla gerçekleştirilmiştir.");
                        islem = 0;
                        break;
                    }
                case 5:
                    System.out.println("Eski şifrenizi giriniz");
                    String eskiSifreGirisi = input.next();
                    if (eskiSifreGirisi.equals(sifre)) {
                        System.out.println("Yeni şifrenizi giriniz");
                        sifre = input.next();
                        System.out.println("Şifreniz değiştirilmiştir");
                        islem = 0;
                        break;
                    } else {
                        System.out.println("Hatalı şifre girdiniz Ana Menüye yönlendiriliyorsunuz");
                        break;
                    }
                case 0:
                    break;
                default:
                    System.out.println("Böyle bir işlem numarası tanımlanmamıştır");
                    islem=0;
                    break;
            }
            if (islem == 0){
                System.out.println("Bizi tercih ettiğiniz için teşekkür ederiz. Hoşçakalın✋🖐😃");
                break;
            }
        } while (true);

    }
}