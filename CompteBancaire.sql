

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données :  `CompteBancaire`
--

-- --------------------------------------------------------
#test!!!!
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
(9396563, 'dupont', 'pierre', '0789562310', 'marseille 9eme', '1234', 12673),
(4856339, 'wood', 'eve', '0689578810', 'marseille 7eme', '8536', 15639),
(9386633, 'allaoui', 'sana', '06782310', 'marseille 3eme', '2869', 15639);

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
(12673, 9861, 4000),
(15639, 13124, 124254),
(15639, 1853, 135);

-- --------------------------------------------------------

--
-- Structure de la table `employe`
--

CREATE TABLE `employe` (
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

INSERT INTO `employe` (`cni`, `nom`, `prenom`, `telephone`, `adresse`, `login`, `password`, `profil`) VALUES
(9853696, 'tan', 'noha', '075686888', 'luminy', 'noha', 'passer', 'ADMINISTRATEUR'),
(8234678, 'hajar', 'jana', '075686888', 'nice', 'bng', 'passer', 'EMPLOYE'),
(3467654, 'shyrin', 'bl', '065686878', 'nice', 'shyri', 'passer', 'EMPLOYE');


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
  KEY `FK_cni` (`cni`),
  CONSTRAINT `FK_cni` FOREIGN KEY (`cni`) REFERENCES `employe`(`cni`)

)ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
--------------------------

CREATE TABLE IF NOT EXISTS `type_compte` (
  `id_typeC` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `plafond` float unsigned NOT NULL DEFAULT '0',
  `montant_minimum` float unsigned NOT NULL DEFAULT '0',
  `taux_interet` float unsigned NOT NULL DEFAULT '0',
 
  PRIMARY KEY (`id_typeC`),
  KEY `FK_numero` (`numero`),
  CONSTRAINT `FK_numero` FOREIGN KEY (`numero`) REFERENCES `compte`(`numero`)
)ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
------------------------------------

CREATE TABLE IF NOT EXISTS `Transferer_argent` (
  `idTransfer` int(11) NOT NULL AUTO_INCREMENT,
   `id_client_emetteur`  int(11) NOT NULL AUTO_INCREMENT,
  `amount` float NOT NULL,
  `accountNo_emetteur` varchar(100) NOT NULL,
  `accountNo_recepteur` varchar(100) NOT NULL,
  PRIMARY KEY (`idTransfer`),
  KEY `FK_cni` (`cni`),
  CONSTRAINT `FK_cni` FOREIGN KEY (`cni`) REFERENCES `employe`(`cni`)
)ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
-----------------------------------------






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
ALTER TABLE `employe`
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