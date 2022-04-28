
Yardımcı Bilgiler
-------------------------------------

-Veri Tabanı için H2 memory kullanılmıştır.
'#spring.datasource.url=jdbc:h2:file:C:/Users/'YOUR USER'
ile .mv oluşturulacak hale getirebilirsiniz.Bu sayede dbVisiualizer ile tablo yapılarına bakabilirsiniz.

-Tablolar Entity sınıfları üzerinde ilişkisel olarak yaratılmıştır(OTM / MTO).Entity sınıfları için; 

    `-Rest uçlarında kullanılacak 'nullable' tanımlarına dikkat edilmelidir.
    -Rest uçları için 'Global Exception Handler' oluşturulup,mantıklı ex mesajları tanımlanmıştır.`

-Task sırasında gerekli olan verileri **resource/data-h2.sql üzerinde otomatik insert scriptleri** yazılmıştır.
Uygulama başlattıktan sonra tek yapmanız gereken **_postmanCollectionda_** bulunan requestleri denemek olacaktır.
(Entityler için basic rest uçları tanımlanmıştır.Tasklarda belirtilen tanımlamaları dilenirse bu uçlardanda yapılabilir.)

-Daha sonra loglara consoledan bakılıp istenen loglamaların yapıldığı görülür.

-Pack ve Bag için endPointlerden request atılarak istenilen sonuçların alındığı görülür yada .mv dosyası açılıp bakılabilir.

-Logback ile belirtilen loglama işlemleri yapılmaktadır.

-DockerFile ve Docker-compose.yml oluşturulmuştur.Maven komutları çalıştırıldıktan sonra target dosyasında .jar oluştuğunu görüp  
ister terminal üzerinden image oluşturup isterse docker-compose up komutuyla docker yüklü ortamınızda test edebilirsiniz.

-Unit Testler için örnek olabilecek Service ve Integration testlerinden bazıları yazılmıştır.

