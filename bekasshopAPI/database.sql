CREATE TABLE `bekasshopdb`.`users` ( `id` INT NOT NULL AUTO_INCREMENT , `emails` 
VARCHAR(100) NOT NULL , `username` VARCHAR(100) NOT NULL , `password` VARCHAR(100) 
NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;                      

CREATE TABLE bekasshopdb.products ( id INT NOT NULL AUTO_INCREMENT , name 
VARCHAR(30) NOT NULL , description VARCHAR(255) NOT NULL , image VARCHAR(50)
NOT NULL , 'price' INT(11) NOT NULL , 'category' VARCHAR(100) NOT NULL , PRIMARY KEY (id)) ENGINE = InnoDB;

INSERT INTO users (id, emails, username, password) VALUES
(NULL, 'dadu@gmail.com', 'Dadu', 'tonyhawk123'), 
(NULL, 'rudy@gmail.com', 'rudy111', 'rudy123')

INSERT INTO `products` (`id`, `name`, `description`, `image`, `price`, `category`) VALUES 
(NULL, 'Yoyo', 'Yoyo Bekas pakai oleh juara 1', 'Yoyo_Bekas.jpg', '100000', 'toys'),
(NULL, 'Kuda Jumping', 'kuda jumping yang sudah diapaki!', 'Kuda_Jumping.jpg', '100000', 'toys'),
(NULL, 'Magnetic Drawing Board', 'Magnetic Drawing Board yang sudah diapaki!', 'Magnetic_Drawing_Board.jpg', '30000', 'toys'),
(NULL, 'Plastisin Kecil', 'Plastisin Kecil yang sudah diapaki!', 'Plastisin_Kecil.jpg', '120000', 'toys'),
(NULL, 'Boneka', 'boneka buatan andi', 'Boneka.jpg', '20000', 'toys'),
(NULL, 'Groovy Swivel Chair', 'Groovy Swivel Chair yang sudah diapaki!', 'Groovy_Swivel_Chair.jpg', '500000', 'furniture'),
(NULL, 'Adah Upholstered Loveseat', 'Adah Upholstered Loveseat yang sudah diapaki!', 'Adah_Upholstered_Loveseat.jpg', '1200000', 'furniture'),
(NULL, 'Wood & Cane Console Table', 'Wood & Cane Console Table yang sudah diapaki!', 'Wood_Cane_Console_Table.jpg', '400000', 'furniture'),
(NULL, 'Sling Dining Chair', 'Sling Dining Chair yang sudah diapaki!', 'Sling_Dining_Chair.jpg', '450000', 'furniture'),
(NULL, 'Mobil AVV Second', 'Mobil AVV yang sudah diapaki!', 'Mobil_AVV_Bekas.jpg', '50000000', 'automotive'),
(NULL, 'Ban Bekas', 'Ban yang sudah dipake bertahun - tahun!', 'Ban_Bekas.jpg', '50000', 'automotive'),
(NULL, 'Spion Tiger Motor', 'Spion Tiger Motor yang sudah diapaki!', 'Spion_Tiger_Motor.jpg', '30000', 'automotive'),
(NULL, 'Spion Mobil', 'Spion Mobil yang sudah diapaki!', 'Spion_Mobil.jpg', '1000000', 'automotive'),
(NULL, 'TV LG Second', 'TV LG Second Kondisi 9/10, bagian belakang sedikit berdebu', 'TV_LG.jpg', '2500000', 'electronic'),
(NULL, 'Printer Epson L3100', 'Printer Second Epson L3100 kondisi baru, pakai 5 bulan kantor', 'epson.jpg', '3500000', 'electronic'),
(NULL, 'Laptop Asus ROG Strix 3', 'Laptop ROG Strix 3 kondisi bagus tombol enter sedikit rusak', 'Asus_ROG.jpg', '12000000', 'electronic'),
(NULL, 'Headseat Steelseries II', 'Headseat Steelseries II kondisi baik baru dipakai 2 bulan', 'steelseries.jpg', '2000000', 'electronic'),
(NULL, 'Mouse Logitech G502 Hero', 'Mouse Logitech G502 baru pakai 2 minggu, diganti karena tidak cocok', 'g502.jpg', '600000', 'electronic'),
(NULL, 'Mouse Logitech G102 Light', 'Mouse Logitech G102 garasi 1 tahun 5 febuari', 'g102.jpg', '200000', 'electronic'),
(NULL, 'Laptop Asus zenbook', 'Laptop Asus dijual karena dibutuhkan laptop yang lebih baik', 'zenbook.jpg', '9000000', 'electronic'),
(NULL, 'Komputer Rakit RTX 2080', 'Dijual cepat komputer RTX 2080', 'komputer.jpg', '21000000', 'electronic'),
(NULL, 'Kursi Gaming Omega', 'Kursi Gaming Omega kondisi 10/10 box ready', 'kursi_omega.jpg', '5000000', 'furniture'),
(NULL, 'Sofa KINGKOIL', 'Sofa Kingkoil dijual karena ingin pindah rumah', 'sofaking.jpg', '12000000', 'furniture'),
(NULL, 'Meja makan informa', 'Meja makan informa ukuran untuk 6 orang kondisi 8/10', 'meja_makan.jpg', '6000000', 'furniture'),
(NULL, 'Kursi makan 4 Set', 'Kursi makan dijual 4 pcs harga 4pcs', 'kursi4pcs.jpg', '2400000', 'furniture')                        

