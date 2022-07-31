-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : dim. 31 juil. 2022 à 08:19
-- Version du serveur : 10.4.20-MariaDB
-- Version de PHP : 7.3.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `kalata`
--

-- --------------------------------------------------------

--
-- Structure de la table `candidat`
--

CREATE TABLE `candidat` (
  `id_candidat` int(20) NOT NULL,
  `nom` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `prenom` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `date` date DEFAULT current_timestamp(),
  `nb_vote` int(11) DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `candidat`
--

INSERT INTO `candidat` (`id_candidat`, `nom`, `prenom`, `date`, `nb_vote`, `image`) VALUES
(49, 'BALLO ', 'Keita', '2022-07-31', 7, NULL),
(50, 'MALLE', 'Alassane', '2022-07-31', NULL, NULL),
(51, 'Diawara', 'Karim', '2022-07-31', NULL, 'cgi.png'),
(52, 'Karim', 'DIAWARA', '2022-07-31', NULL, 'kalata.png'),
(53, 'Diawara', 'Karim', '2022-07-31', NULL, 'images (8).png'),
(54, 'Diawara', 'Karim', '2022-07-31', NULL, 'images (8).png'),
(55, 'Diawara', 'Karim', '2022-07-31', NULL, 'images (8).png'),
(56, 'Diawara', 'Karim', '2022-07-31', NULL, 'rechercher-illustration-isometrique-du-candidat_7209-231.webp');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `candidat`
--
ALTER TABLE `candidat`
  ADD PRIMARY KEY (`id_candidat`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `candidat`
--
ALTER TABLE `candidat`
  MODIFY `id_candidat` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
