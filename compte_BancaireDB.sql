

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données :  `CompteBancaire`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `cni` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `telephone` varchar(13) DEFAULT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `codesecret` varchar(255) DEFAULT NULL,
  `compte_numero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`cni`, `nom`, `prenom`, `telephone`, `adresse`, `codesecret`, `compte_numero`) VALUES
(433563, 'egze', 'efazgz', 'egzgzr', 'eav', '1234', 12),
(4511233, 'ngom', 'bassirou', '55785', 'thies hersent', '1234', 1),
(87564543, 'mbaye', 'samba', '5342412', 'thies', '4567', 13);

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE `compte` (
  `numero` int(11) NOT NULL,
  `solde` double DEFAULT NULL,
  `decouvert` double DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `compte`
--

INSERT INTO `compte` (`numero`, `solde`, `decouvert`) VALUES
(1, 9861, 4000),
(12, 13124, 124254),
(13, 1853, 135),
(14, 100, 199),
(15, 20000, 200);

-- --------------------------------------------------------

--
-- Structure de la table `employe`
--

CREATE TABLE `Employe` (
  `cni` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `telephone` varchar(13) DEFAULT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `login` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `profil` enum('EMPLOYE','ADMINISTRATEUR') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `employe`
--

INSERT INTO `Employe` (`cni`, `nom`, `prenom`, `telephone`, `adresse`, `login`, `password`, `profil`) VALUES
(0, 'tan', 'noha', '775686888', 'luminy', 'bng', 'passer', 'ADMINISTRATEUR'),
(1234676542, 'hajar', 'jana', '775686888', 'nice', 'bngbng', 'passer', 'EMPLOYE');


-- --------------------------------------------------------

--
-- Structure de la table `historique`
--

CREATE TABLE `historique` (
  `id` int(11) NOT NULL,
  `solde_initial` double DEFAULT NULL,
  `solde_final` double DEFAULT NULL,
  `date` date DEFAULT NULL,
  `numero_compte` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `historique`
--

INSERT INTO `historique` (`id`, `solde_initial`, `solde_final`, `date`, `numero_compte`) VALUES
(1, 1000, 800, '2023-01-02', 1),
(2, 1000, 750, '2023-01-02', 1),
(3, 750, 5750, '2023-01-02', 1),
(4, 5750, 10750, '2023-01-02', 1),
(5, 10750, 7250, '2023-01-02', 1),
(6, 7250, 6750, '2023-01-09', 1),
(7, 6750, 8750, '2023-01-09', 1),
(8, 8750, 8627, '2023-01-12', 1),
(9, 8627, 9861, '2023-01-12', 1),
(10, 353, 2353, '2023-01-18', 13),
(11, 2353, 1353, '2023-01-18', 13),
(12, 1353, 1853, '2023-01-18', 13);

-----------------------------------------
DROP TABLE IF EXISTS `TransactionTable`;
CREATE TABLE IF NOT EXISTS `TransactionTable` (
  `id_transaction` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `transactionName` varchar(100) NOT NULL,
  `debit` float unsigned DEFAULT '0',
  `credit` float unsigned DEFAULT '0',
  `dateOfTransaction` date NOT NULL,
  `accountNo` varchar(100) NOT NULL,
  PRIMARY KEY (`id_transaction`),
  KEY `FK_id_employe` (`id_employe`),
  CONSTRAINT `FK_id_employe` FOREIGN KEY (`id_employe`) REFERENCES `employe`(`id_employe`)

);
--
-- Index pour les tables exportées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`cni`),
  ADD KEY `fk_client_compte_idx` (`compte_numero`);

--
-- Index pour la table `compte`
--
ALTER TABLE `compte`
  ADD PRIMARY KEY (`numero`);

--
-- Index pour la table `employe`
--
ALTER TABLE `Employe`
  ADD PRIMARY KEY (`cni`);

--
-- Index pour la table `historique`
--
ALTER TABLE `historique`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_historique_compte1_idx` (`numero_compte`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `compte`
--
ALTER TABLE `compte`
  MODIFY `numero` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT pour la table `historique`
--
ALTER TABLE `historique`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `fk_client_compte` FOREIGN KEY (`compte_numero`) REFERENCES `compte` (`numero`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `historique`
--
ALTER TABLE `historique`
  ADD CONSTRAINT `fk_historique_compte1` FOREIGN KEY (`numero_compte`) REFERENCES `compte` (`numero`) ON DELETE NO ACTION ON UPDATE NO ACTION;