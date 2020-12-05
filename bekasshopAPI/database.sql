CREATE TABLE `bekasshopdb`.`users` ( `id` INT NOT NULL AUTO_INCREMENT , `emails` 
VARCHAR(100) NOT NULL , `username` VARCHAR(100) NOT NULL , `password` VARCHAR(100) 
NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;

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
(NULL, 'Spion Mobil', 'Spion Mobil yang sudah diapaki!', 'Spion_Mobil.jpg', '1000000', 'automotive')

