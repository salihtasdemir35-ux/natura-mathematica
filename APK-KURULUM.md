# Natura Mathematica — APK Oluşturma ve Kurulum

Bu klasör, Natura Mathematica uygulamasını Android telefon ve tablete kurulabilen bir **APK** dosyasına dönüştüren hazır bir Android projesidir. APK'yı GitHub senin yerine derler; bilgisayarına hiçbir şey kurman gerekmez.

## 1. GitHub'da APK'yı oluştur (yaklaşık 5–8 dakika)

1. GitHub'da yeni bir depo oluştur (örnek ad: `natura-mathematica`). Herkese açık ya da gizli olabilir.
2. Bu zip dosyasını bilgisayarında aç.
3. Depoda **Add file → Upload files** seçeneğine tıkla.
4. `NaturaMathematica` klasörünün **içindeki her şeyi** sürükleyip bırak: `app` klasörü, `.github` klasörü, `build.gradle`, `settings.gradle`, `gradle.properties` ve bu dosya.
   - `.github` gizli bir klasördür. Mac'te Finder'da **Cmd + Shift + .** ile görünür hâle gelir.
   - `.github` yüklenmezse: **Add file → Create new file** seç, dosya adına `.github/workflows/build-apk.yml` yaz ve bu zip'teki aynı dosyanın içeriğini yapıştır.
5. **Commit changes** düğmesine bas.
6. **Actions** sekmesinde “APK oluştur” işi kendiliğinden başlar. Yeşil ✓ çıkınca derleme bitmiştir.
7. Depo ana sayfasının sağındaki **Releases** bölümünü aç ve en son sürümdeki **NaturaMathematica.apk** dosyasını indir.
   - APK'ya ayrıca Actions → ilgili çalışma → **Artifacts** bölümünden de ulaşabilirsin (zip olarak iner).

Uygulamada değişiklik yapıp `app/src/main/assets/index.html` dosyasını yeniden yüklediğinde yeni bir APK kendiliğinden oluşur. Sürüm numarası her seferinde artar.

## 2. Telefona ya da tablete kur

1. APK'yı telefonda ya da tablette indir. (Bilgisayara indirdiysen e-posta, Drive ya da kabloyla cihaza aktar.)
2. Dosyaya dokun. İstenirse **“Bu kaynaktan yüklemeye izin ver”** seçeneğini aç.
3. **Yükle** düğmesine bas. Uygulama ana ekranda ayçiçeği–altın spiral simgesiyle **Natura Mathematica** adıyla görünür.

Bilmen gerekenler:
- Uygulama **internet izni istemez**; tamamen çevrimdışı çalışır.
- **Türkçe / English:** Üst menüdeki 🌐 düğmesiyle dil değişir. İlk açılışta cihaz dili Türkçe değilse uygulama İngilizce başlar.
- Telefonda ve tablette dikey ve yatay ekranda çalışır. Geri tuşu uygulamada bir önceki sayfaya döner.
- Bütün sürümler aynı anahtarla imzalandığı için yeni bir APK, eskisini silmeden üzerine kurulabilir. İlerlemen korunur.
- Google Play dışından kurulan uygulamalar için Play Protect bir uyarı gösterebilir. “Yine de yükle” seçeneğiyle devam edebilirsin.
- En az Android 7.0 gerekir.

## 3. Bilgisayarda kullanım

APK dosyaları yalnızca Android'de (telefon, tablet, Chromebook) çalışır; Windows ve Mac APK açamaz. Bilgisayarda aynı uygulamayı şu iki yoldan biriyle kullan:
- `natura-mathematica.html` dosyasına çift tıkla. İnternetsiz açılır ve APK'daki uygulamayla birebir aynıdır.
- Ya da yayın bağlantısını tarayıcıda aç.

## Google Play'e yüklemek istersen

Bu projedeki imza anahtarı (`app/natura-mathematica.p12`) ve şifresi, kolay kurulum için proje içine konmuştur. Bu, kişisel kullanım ve elden dağıtım için uygundur. Google Play'de yayımlamak istersen:
- Kendi gizli anahtarını oluştur.
- Anahtarı ve şifresini GitHub **Secrets** bölümüne taşı.
- Play için APK yerine AAB (`gradle bundleRelease`) derle.

## Proje yapısı

| Dosya | Görevi |
|---|---|
| `app/src/main/assets/index.html` | Uygulamanın tamamı (107 simülasyon) |
| `app/src/main/java/.../MainActivity.java` | Uygulamayı tam ekran ve internetsiz açan Android ekranı |
| `app/src/main/AndroidManifest.xml` | Uygulama adı, simgesi, ekran yönü ayarları |
| `app/src/main/res/` | Simgeler ve renkler |
| `.github/workflows/build-apk.yml` | GitHub'da APK'yı derleyen otomatik iş |
