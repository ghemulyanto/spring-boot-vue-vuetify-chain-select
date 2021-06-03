-- region.provinces definition

CREATE TABLE `provinces` (
  `id` char(2) NOT NULL,
  `name` varchar(100) ,
  `capital_city` varchar(100) ,
  `latitude` double ,
  `longitude` double ,
  `elevation` float ,
  `timezone` tinyint(4) ,
  `path` longtext ,
  `status` tinyint(4) ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


-- region.regencies definition

CREATE TABLE `regencies` (
  `id` char(5)  NOT NULL,
  `province_id` char(2)  NOT NULL,
  `name` varchar(100) ,
  `capital_city` varchar(100) ,
  `latitude` double ,
  `longitude` double ,
  `elevation` float ,
  `timezone` tinyint(4) ,
  `path` longtext COLLATE utf8_unicode_ci ,
  `status` tinyint(4) ,
  PRIMARY KEY (`id`),
  KEY `regencies_province_id_index` (`province_id`),
  CONSTRAINT `regencies_province_id_foreign` FOREIGN KEY (`province_id`) REFERENCES `provinces` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


-- region.districts definition

CREATE TABLE `districts` (
  `id` char(8) NOT NULL,
  `regency_id` char(5) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `districts_id_index` (`regency_id`),
  CONSTRAINT `districts_regency_id_foreign` FOREIGN KEY (`regency_id`) REFERENCES `regencies` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


-- region.villages definition

CREATE TABLE `villages` (
  `id` char(13) NOT NULL,
  `district_id` char(8) NOT NULL,
  `name` varchar(100) ,
  PRIMARY KEY (`id`),
  KEY `villages_district_id_index` (`district_id`),
  CONSTRAINT `villages_district_id_foreign` FOREIGN KEY (`district_id`) REFERENCES `districts` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;