-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 11, 2022 at 08:31 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 7.4.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gyf`
--

-- --------------------------------------------------------

--
-- Table structure for table `avis`
--

CREATE TABLE `avis` (
  `id_avis` int(11) NOT NULL,
  `nombre_etoile` int(11) NOT NULL,
  `description` varchar(255) NOT NULL,
  `id_user` int(11) NOT NULL,
  `cible_avis` int(11) NOT NULL,
  `type_avis` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `bateaux`
--

CREATE TABLE `bateaux` (
  `id_bateau` int(11) NOT NULL,
  `compagnie_maritime` varchar(255) NOT NULL,
  `depart` varchar(255) NOT NULL,
  `destination` varchar(255) NOT NULL,
  `date_depart` date NOT NULL,
  `date_arrive` date NOT NULL,
  `prix` int(11) NOT NULL,
  `duree` varchar(50) NOT NULL,
  `nom_bateau` varchar(255) NOT NULL,
  `image_bateau` varchar(255) NOT NULL,
  `avis_bateau` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `chambre`
--

CREATE TABLE `chambre` (
  `id_chambre` int(11) NOT NULL,
  `type_chambre` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `espace_culturels`
--

CREATE TABLE `espace_culturels` (
  `id_espace` int(11) NOT NULL,
  `nom_espace` varchar(255) NOT NULL,
  `image_espace` varchar(255) NOT NULL,
  `horaire` varchar(255) NOT NULL,
  `prix` int(11) NOT NULL,
  `paye` int(11) NOT NULL,
  `date_creation` varchar(255) NOT NULL,
  `pays` varchar(255) NOT NULL,
  `localisation` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `avis_espace` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `evenement`
--

CREATE TABLE `evenement` (
  `id_evenement` int(11) NOT NULL,
  `nom_evenement` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `type_evenement` varchar(255) NOT NULL,
  `localisation` varchar(255) NOT NULL,
  `image_evenement` varchar(255) NOT NULL,
  `date_debut` date NOT NULL,
  `date_fin` date NOT NULL,
  `pays` varchar(255) NOT NULL,
  `nombre_participants` int(11) NOT NULL,
  `prix` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `historique`
--

CREATE TABLE `historique` (
  `id_historique` int(11) NOT NULL,
  `entre_date` date NOT NULL,
  `sortie_date` date NOT NULL,
  `duree` int(11) NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `hotels`
--

CREATE TABLE `hotels` (
  `id_hotel` int(11) NOT NULL,
  `nom_hotel` varchar(255) NOT NULL,
  `localisation` varchar(255) NOT NULL,
  `prix_hotel` int(11) NOT NULL,
  `categorie` varchar(255) NOT NULL,
  `id_chambre` int(11) NOT NULL,
  `avis_hotel` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `monuments`
--

CREATE TABLE `monuments` (
  `id_monument` int(11) NOT NULL,
  `nom_monument` varchar(255) NOT NULL,
  `image_monument` varchar(255) NOT NULL,
  `payant` int(11) NOT NULL,
  `prix` int(11) NOT NULL,
  `description` varchar(255) NOT NULL,
  `date_creation` varchar(255) NOT NULL,
  `pays` varchar(255) NOT NULL,
  `localisation` varchar(255) NOT NULL,
  `avis_monument` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `offers`
--

CREATE TABLE `offers` (
  `id_offre` int(11) NOT NULL,
  `titre` varchar(255) NOT NULL,
  `depart` varchar(255) NOT NULL,
  `destination` varchar(255) NOT NULL,
  `date_depart` date NOT NULL,
  `date_arrive` date NOT NULL,
  `nombre_nuits` int(11) NOT NULL,
  `discription` varchar(255) NOT NULL,
  `prix` int(11) NOT NULL,
  `image_offre` varchar(255) NOT NULL,
  `avis_offre` int(11) NOT NULL,
  `id_vol` int(11) NOT NULL,
  `id_hotel` int(11) NOT NULL,
  `id_restaurant` int(11) NOT NULL,
  `id_monument` int(11) NOT NULL,
  `id_evenement` int(11) NOT NULL,
  `id_espace` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `payment_bateaux`
--

CREATE TABLE `payment_bateaux` (
  `id_pay_bateau` int(11) NOT NULL,
  `id_bateau` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `type_payment` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `payment_mon_cult`
--

CREATE TABLE `payment_mon_cult` (
  `id_payment` int(11) NOT NULL,
  `cible_reservation` int(11) NOT NULL,
  `type_reservation` int(11) NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `payment_offers`
--

CREATE TABLE `payment_offers` (
  `id_pay_offre` int(11) NOT NULL,
  `id_offre` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `type_payment` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `payment_vols`
--

CREATE TABLE `payment_vols` (
  `id_pay_vol` int(11) NOT NULL,
  `id_vol` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `type_payment` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `reclamation`
--

CREATE TABLE `reclamation` (
  `id_reclamation` int(11) NOT NULL,
  `description` varchar(255) NOT NULL,
  `date_creation` date NOT NULL,
  `date_traitement` date NOT NULL,
  `status` varchar(255) NOT NULL,
  `image_reclamation` varchar(255) NOT NULL,
  `cible_reclamation` int(11) NOT NULL,
  `type_reclamation` int(11) NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `reservations_resto_hotel`
--

CREATE TABLE `reservations_resto_hotel` (
  `id_reservation` int(11) NOT NULL,
  `cible_reservation` int(11) NOT NULL,
  `date_debut` date NOT NULL,
  `date_fin` date NOT NULL,
  `mode_payment` varchar(255) NOT NULL,
  `prix` int(11) NOT NULL,
  `type_reservation` int(11) NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `reservation_evenement`
--

CREATE TABLE `reservation_evenement` (
  `id_res_event` int(11) NOT NULL,
  `payment_event` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_evenement` int(11) NOT NULL,
  `date_expiration` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `restaurants`
--

CREATE TABLE `restaurants` (
  `id_restaurant` int(11) NOT NULL,
  `nom_restaurant` varchar(255) NOT NULL,
  `localisation` varchar(255) NOT NULL,
  `horaire` varchar(255) NOT NULL,
  `numero_restaurant` varchar(255) NOT NULL,
  `cuisinies` varchar(255) NOT NULL,
  `nombre_fourchet` int(11) NOT NULL,
  `avis_restaurant` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `id_role` int(11) NOT NULL,
  `role` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id_user` int(11) NOT NULL,
  `nom_user` varchar(255) NOT NULL,
  `prenom_user` varchar(255) NOT NULL,
  `sexe` varchar(255) NOT NULL,
  `numero_tel` int(11) NOT NULL,
  `email_user` varchar(255) NOT NULL,
  `pays_user` varchar(255) NOT NULL,
  `ville_user` varchar(255) NOT NULL,
  `code_postal` int(11) NOT NULL,
  `date_naissance` date NOT NULL,
  `id_role` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `vols`
--

CREATE TABLE `vols` (
  `id_vol` int(11) NOT NULL,
  `compagnie_aerien` varchar(255) NOT NULL,
  `depart` varchar(255) NOT NULL,
  `destination` varchar(255) NOT NULL,
  `date_depart` date NOT NULL,
  `date_arrive` date NOT NULL,
  `prix` int(11) NOT NULL,
  `duree` int(11) NOT NULL,
  `type_avion` varchar(255) NOT NULL,
  `image_vol` varchar(255) NOT NULL,
  `avis_vol` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `avis`
--
ALTER TABLE `avis`
  ADD PRIMARY KEY (`id_avis`),
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `bateaux`
--
ALTER TABLE `bateaux`
  ADD PRIMARY KEY (`id_bateau`),
  ADD UNIQUE KEY `id_bateau` (`id_bateau`);

--
-- Indexes for table `chambre`
--
ALTER TABLE `chambre`
  ADD PRIMARY KEY (`id_chambre`);

--
-- Indexes for table `espace_culturels`
--
ALTER TABLE `espace_culturels`
  ADD PRIMARY KEY (`id_espace`);

--
-- Indexes for table `evenement`
--
ALTER TABLE `evenement`
  ADD PRIMARY KEY (`id_evenement`);

--
-- Indexes for table `historique`
--
ALTER TABLE `historique`
  ADD PRIMARY KEY (`id_historique`),
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `hotels`
--
ALTER TABLE `hotels`
  ADD PRIMARY KEY (`id_hotel`),
  ADD KEY `id_chambre` (`id_chambre`);

--
-- Indexes for table `monuments`
--
ALTER TABLE `monuments`
  ADD PRIMARY KEY (`id_monument`);

--
-- Indexes for table `offers`
--
ALTER TABLE `offers`
  ADD PRIMARY KEY (`id_offre`),
  ADD KEY `id_espace` (`id_espace`),
  ADD KEY `id_evenement` (`id_evenement`),
  ADD KEY `id_hotel` (`id_hotel`),
  ADD KEY `id_monument` (`id_monument`),
  ADD KEY `id_restaurant` (`id_restaurant`),
  ADD KEY `id_vol` (`id_vol`);

--
-- Indexes for table `payment_bateaux`
--
ALTER TABLE `payment_bateaux`
  ADD PRIMARY KEY (`id_pay_bateau`),
  ADD KEY `id_bateau` (`id_bateau`),
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `payment_mon_cult`
--
ALTER TABLE `payment_mon_cult`
  ADD PRIMARY KEY (`id_payment`),
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `payment_offers`
--
ALTER TABLE `payment_offers`
  ADD PRIMARY KEY (`id_pay_offre`),
  ADD KEY `id_offre` (`id_offre`),
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `payment_vols`
--
ALTER TABLE `payment_vols`
  ADD PRIMARY KEY (`id_pay_vol`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_vol` (`id_vol`);

--
-- Indexes for table `reclamation`
--
ALTER TABLE `reclamation`
  ADD PRIMARY KEY (`id_reclamation`),
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `reservations_resto_hotel`
--
ALTER TABLE `reservations_resto_hotel`
  ADD PRIMARY KEY (`id_reservation`),
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `reservation_evenement`
--
ALTER TABLE `reservation_evenement`
  ADD PRIMARY KEY (`id_res_event`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_evenement` (`id_evenement`);

--
-- Indexes for table `restaurants`
--
ALTER TABLE `restaurants`
  ADD PRIMARY KEY (`id_restaurant`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id_role`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`),
  ADD KEY `id_role` (`id_role`);

--
-- Indexes for table `vols`
--
ALTER TABLE `vols`
  ADD PRIMARY KEY (`id_vol`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `avis`
--
ALTER TABLE `avis`
  MODIFY `id_avis` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `bateaux`
--
ALTER TABLE `bateaux`
  MODIFY `id_bateau` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `chambre`
--
ALTER TABLE `chambre`
  MODIFY `id_chambre` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `espace_culturels`
--
ALTER TABLE `espace_culturels`
  MODIFY `id_espace` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `evenement`
--
ALTER TABLE `evenement`
  MODIFY `id_evenement` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `historique`
--
ALTER TABLE `historique`
  MODIFY `id_historique` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `hotels`
--
ALTER TABLE `hotels`
  MODIFY `id_hotel` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `monuments`
--
ALTER TABLE `monuments`
  MODIFY `id_monument` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `offers`
--
ALTER TABLE `offers`
  MODIFY `id_offre` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `payment_bateaux`
--
ALTER TABLE `payment_bateaux`
  MODIFY `id_pay_bateau` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `payment_mon_cult`
--
ALTER TABLE `payment_mon_cult`
  MODIFY `id_payment` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `payment_offers`
--
ALTER TABLE `payment_offers`
  MODIFY `id_pay_offre` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `payment_vols`
--
ALTER TABLE `payment_vols`
  MODIFY `id_pay_vol` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `reclamation`
--
ALTER TABLE `reclamation`
  MODIFY `id_reclamation` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `reservations_resto_hotel`
--
ALTER TABLE `reservations_resto_hotel`
  MODIFY `id_reservation` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `reservation_evenement`
--
ALTER TABLE `reservation_evenement`
  MODIFY `id_res_event` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `restaurants`
--
ALTER TABLE `restaurants`
  MODIFY `id_restaurant` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `id_role` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `vols`
--
ALTER TABLE `vols`
  MODIFY `id_vol` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `avis`
--
ALTER TABLE `avis`
  ADD CONSTRAINT `avis_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`) ON DELETE CASCADE;

--
-- Constraints for table `historique`
--
ALTER TABLE `historique`
  ADD CONSTRAINT `historique_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`) ON DELETE CASCADE;

--
-- Constraints for table `hotels`
--
ALTER TABLE `hotels`
  ADD CONSTRAINT `hotels_ibfk_1` FOREIGN KEY (`id_chambre`) REFERENCES `chambre` (`id_chambre`) ON DELETE CASCADE;

--
-- Constraints for table `offers`
--
ALTER TABLE `offers`
  ADD CONSTRAINT `offers_ibfk_1` FOREIGN KEY (`id_espace`) REFERENCES `espace_culturels` (`id_espace`) ON DELETE CASCADE,
  ADD CONSTRAINT `offers_ibfk_2` FOREIGN KEY (`id_evenement`) REFERENCES `evenement` (`id_evenement`) ON DELETE CASCADE,
  ADD CONSTRAINT `offers_ibfk_3` FOREIGN KEY (`id_hotel`) REFERENCES `hotels` (`id_hotel`) ON DELETE CASCADE,
  ADD CONSTRAINT `offers_ibfk_4` FOREIGN KEY (`id_monument`) REFERENCES `monuments` (`id_monument`) ON DELETE CASCADE,
  ADD CONSTRAINT `offers_ibfk_5` FOREIGN KEY (`id_restaurant`) REFERENCES `restaurants` (`id_restaurant`) ON DELETE CASCADE,
  ADD CONSTRAINT `offers_ibfk_6` FOREIGN KEY (`id_vol`) REFERENCES `vols` (`id_vol`) ON DELETE CASCADE;

--
-- Constraints for table `payment_bateaux`
--
ALTER TABLE `payment_bateaux`
  ADD CONSTRAINT `payment_bateaux_ibfk_1` FOREIGN KEY (`id_bateau`) REFERENCES `bateaux` (`id_bateau`) ON DELETE CASCADE,
  ADD CONSTRAINT `payment_bateaux_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`) ON DELETE CASCADE;

--
-- Constraints for table `payment_mon_cult`
--
ALTER TABLE `payment_mon_cult`
  ADD CONSTRAINT `payment_mon_cult_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`) ON DELETE CASCADE;

--
-- Constraints for table `payment_offers`
--
ALTER TABLE `payment_offers`
  ADD CONSTRAINT `payment_offers_ibfk_1` FOREIGN KEY (`id_offre`) REFERENCES `offers` (`id_offre`) ON DELETE CASCADE,
  ADD CONSTRAINT `payment_offers_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`) ON DELETE CASCADE;

--
-- Constraints for table `payment_vols`
--
ALTER TABLE `payment_vols`
  ADD CONSTRAINT `payment_vols_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`) ON DELETE CASCADE,
  ADD CONSTRAINT `payment_vols_ibfk_2` FOREIGN KEY (`id_vol`) REFERENCES `vols` (`id_vol`) ON DELETE CASCADE;

--
-- Constraints for table `reclamation`
--
ALTER TABLE `reclamation`
  ADD CONSTRAINT `reclamation_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`) ON DELETE CASCADE;

--
-- Constraints for table `reservations_resto_hotel`
--
ALTER TABLE `reservations_resto_hotel`
  ADD CONSTRAINT `reservations_resto_hotel_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`) ON DELETE CASCADE;

--
-- Constraints for table `reservation_evenement`
--
ALTER TABLE `reservation_evenement`
  ADD CONSTRAINT `reservation_evenement_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`) ON DELETE CASCADE,
  ADD CONSTRAINT `reservation_evenement_ibfk_2` FOREIGN KEY (`id_evenement`) REFERENCES `evenement` (`id_evenement`) ON DELETE CASCADE;

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`id_role`) REFERENCES `roles` (`id_role`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
