-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 01-Dez-2018 às 18:10
-- Versão do servidor: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sanepar`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `bairro`
--

CREATE TABLE `bairro` (
  `idBairro` int(10) UNSIGNED NOT NULL,
  `nomeBairro` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `bairro`
--

INSERT INTO `bairro` (`idBairro`, `nomeBairro`) VALUES
(1, 'belvedere'),
(2, 'centro');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cidade`
--

CREATE TABLE `cidade` (
  `idCidade` int(10) UNSIGNED NOT NULL,
  `nomeCidade` varchar(45) NOT NULL,
  `idEstado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `cidade`
--

INSERT INTO `cidade` (`idCidade`, `nomeCidade`, `idEstado`) VALUES
(1, 'Foz do Iguacu', 1),
(2, 'Santa Terezinha de Itaipu', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `nomeCliente` varchar(45) NOT NULL,
  `documentoCliente` varchar(45) NOT NULL,
  `pessoaJuridica` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`idCliente`, `nomeCliente`, `documentoCliente`, `pessoaJuridica`) VALUES
(1, 'Tiago Pereira', '09722879901', 0),
(2, 'Marmitex', '99999999999/999999', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `email`
--

CREATE TABLE `email` (
  `idEmail` int(10) UNSIGNED NOT NULL,
  `enderecoEmail` varchar(45) NOT NULL,
  `idCliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `email`
--

INSERT INTO `email` (`idEmail`, `enderecoEmail`, `idCliente`) VALUES
(1, 'tiago.foz@hotmail.com', 1),
(2, 'tiago.pereira@gmail.com', 1),
(3, 'marmitex@hotmail.com', 2),
(4, 'marmitex@gmail.com', 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco`
--

CREATE TABLE `endereco` (
  `idEndereco` int(10) UNSIGNED NOT NULL,
  `idCidade` int(10) UNSIGNED NOT NULL,
  `idRua` int(10) UNSIGNED NOT NULL,
  `idBairro` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `endereco`
--

INSERT INTO `endereco` (`idEndereco`, `idCidade`, `idRua`, `idBairro`) VALUES
(1, 1, 1, 2),
(2, 2, 2, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `enderecoespecifico`
--

CREATE TABLE `enderecoespecifico` (
  `idEnderecoEspecifico` int(11) NOT NULL,
  `cepEndereco` varchar(45) NOT NULL,
  `numeroEndereco` varchar(45) NOT NULL,
  `complemento` varchar(80) DEFAULT NULL,
  `idEndereco` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `enderecoespecifico`
--

INSERT INTO `enderecoespecifico` (`idEnderecoEspecifico`, `cepEndereco`, `numeroEndereco`, `complemento`, `idEndereco`) VALUES
(1, '85867530', '23', NULL, 1),
(2, '88888888', '300', 'ao lado da farmacia', 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `estado`
--

CREATE TABLE `estado` (
  `idEstado` int(11) NOT NULL,
  `nomeEstado` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `estado`
--

INSERT INTO `estado` (`idEstado`, `nomeEstado`) VALUES
(1, 'Parana');

-- --------------------------------------------------------

--
-- Estrutura da tabela `fatura`
--

CREATE TABLE `fatura` (
  `idFatura` int(11) NOT NULL,
  `mesFatura` int(45) NOT NULL,
  `metrosCubicos` int(11) NOT NULL,
  `custoMetroCubico` float NOT NULL,
  `esgoto` tinyint(4) NOT NULL,
  `custoEsgoto` float NOT NULL DEFAULT '0',
  `idHidrometro` int(11) NOT NULL,
  `anoFatura` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `fatura`
--

INSERT INTO `fatura` (`idFatura`, `mesFatura`, `metrosCubicos`, `custoMetroCubico`, `esgoto`, `custoEsgoto`, `idHidrometro`, `anoFatura`) VALUES
(1, 12, 13, 5.96, 1, 4.77, 1, 2018),
(2, 11, 15, 5.96, 1, 4.77, 1, 2018),
(3, 10, 12, 5.96, 1, 4.77, 1, 2018),
(4, 9, 14, 5.96, 1, 4.77, 1, 2018),
(5, 8, 17, 5.96, 1, 4.77, 1, 2018),
(6, 7, 11, 5.96, 1, 4.77, 1, 2018),
(7, 6, 14, 5.96, 1, 4.77, 1, 2018),
(8, 5, 11, 5.96, 1, 4.77, 1, 2018),
(9, 4, 13, 5.96, 1, 4.77, 1, 2018),
(10, 3, 9, 5.96, 1, 4.77, 1, 2018),
(11, 2, 12, 5.96, 1, 4.77, 1, 2018),
(12, 1, 13, 5.96, 1, 4.77, 1, 2018),
(13, 12, 11, 5.96, 0, 0, 2, 2018),
(14, 11, 19, 5.96, 0, 0, 2, 2018),
(15, 10, 13, 5.96, 0, 0, 2, 2018),
(16, 9, 12, 5.96, 0, 0, 2, 2018),
(17, 8, 10, 5.96, 0, 0, 2, 2018),
(18, 7, 14, 5.96, 0, 0, 2, 2018),
(19, 6, 16, 5.96, 0, 0, 2, 2018),
(20, 5, 15, 5.96, 0, 0, 2, 2018),
(21, 4, 13, 5.96, 0, 0, 2, 2018),
(22, 3, 9, 5.96, 0, 0, 2, 2018),
(23, 2, 11, 5.96, 0, 0, 2, 2018),
(24, 1, 13, 5.96, 0, 0, 2, 2018);

-- --------------------------------------------------------

--
-- Estrutura da tabela `hidrometro`
--

CREATE TABLE `hidrometro` (
  `idHidrometro` int(11) NOT NULL,
  `idEnderecoEspecifico` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `registroHidrometro` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `hidrometro`
--

INSERT INTO `hidrometro` (`idHidrometro`, `idEnderecoEspecifico`, `idCliente`, `registroHidrometro`) VALUES
(1, 1, 1, '44444444'),
(2, 2, 2, '56565656');

-- --------------------------------------------------------

--
-- Estrutura da tabela `rua`
--

CREATE TABLE `rua` (
  `idRua` int(10) UNSIGNED NOT NULL,
  `nomeRua` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `rua`
--

INSERT INTO `rua` (`idRua`, `nomeRua`) VALUES
(1, 'Av Brasil'),
(2, 'Vitorino');

-- --------------------------------------------------------

--
-- Estrutura da tabela `telefone`
--

CREATE TABLE `telefone` (
  `idTelefone` int(10) UNSIGNED NOT NULL,
  `numeroTelefone` varchar(15) NOT NULL,
  `idCliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `telefone`
--

INSERT INTO `telefone` (`idTelefone`, `numeroTelefone`, `idCliente`) VALUES
(1, '35776715', 1),
(2, '999940308', 1),
(3, '99999999', 2),
(4, '88888888', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bairro`
--
ALTER TABLE `bairro`
  ADD PRIMARY KEY (`idBairro`),
  ADD UNIQUE KEY `idEstado_UNIQUE` (`idBairro`);

--
-- Indexes for table `cidade`
--
ALTER TABLE `cidade`
  ADD PRIMARY KEY (`idCidade`),
  ADD UNIQUE KEY `idCidade_UNIQUE` (`idCidade`),
  ADD KEY `fk_cidade_estado_idx` (`idEstado`);

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`),
  ADD UNIQUE KEY `idCliente_UNIQUE` (`idCliente`);

--
-- Indexes for table `email`
--
ALTER TABLE `email`
  ADD PRIMARY KEY (`idEmail`),
  ADD UNIQUE KEY `idEmail_UNIQUE` (`idEmail`),
  ADD KEY `fk_email_cliente1_idx` (`idCliente`);

--
-- Indexes for table `endereco`
--
ALTER TABLE `endereco`
  ADD PRIMARY KEY (`idEndereco`),
  ADD UNIQUE KEY `idEndereco_UNIQUE` (`idEndereco`),
  ADD KEY `fk_endereco_cidade1_idx` (`idCidade`),
  ADD KEY `fk_endereco_rua1_idx` (`idRua`),
  ADD KEY `fk_endereco_bairro1_idx` (`idBairro`);

--
-- Indexes for table `enderecoespecifico`
--
ALTER TABLE `enderecoespecifico`
  ADD PRIMARY KEY (`idEnderecoEspecifico`),
  ADD UNIQUE KEY `idEnderecoEspecifico_UNIQUE` (`idEnderecoEspecifico`),
  ADD KEY `fk_enderecoEspecifico_endereco1_idx` (`idEndereco`);

--
-- Indexes for table `estado`
--
ALTER TABLE `estado`
  ADD PRIMARY KEY (`idEstado`),
  ADD UNIQUE KEY `idEstado_UNIQUE` (`idEstado`);

--
-- Indexes for table `fatura`
--
ALTER TABLE `fatura`
  ADD PRIMARY KEY (`idFatura`),
  ADD KEY `fk_fatura_hidrometro1_idx` (`idHidrometro`);

--
-- Indexes for table `hidrometro`
--
ALTER TABLE `hidrometro`
  ADD PRIMARY KEY (`idHidrometro`),
  ADD UNIQUE KEY `idHidrometro_UNIQUE` (`idHidrometro`),
  ADD KEY `fk_enderecoEspecifico_has_cliente_cliente1_idx` (`idCliente`),
  ADD KEY `fk_enderecoEspecifico_has_cliente_enderecoEspecifico1_idx` (`idEnderecoEspecifico`);

--
-- Indexes for table `rua`
--
ALTER TABLE `rua`
  ADD PRIMARY KEY (`idRua`),
  ADD UNIQUE KEY `idEstado_UNIQUE` (`idRua`);

--
-- Indexes for table `telefone`
--
ALTER TABLE `telefone`
  ADD PRIMARY KEY (`idTelefone`),
  ADD UNIQUE KEY `idEmail_UNIQUE` (`idTelefone`),
  ADD KEY `fk_telefone_cliente1_idx` (`idCliente`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bairro`
--
ALTER TABLE `bairro`
  MODIFY `idBairro` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `cidade`
--
ALTER TABLE `cidade`
  MODIFY `idCidade` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `email`
--
ALTER TABLE `email`
  MODIFY `idEmail` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `endereco`
--
ALTER TABLE `endereco`
  MODIFY `idEndereco` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `enderecoespecifico`
--
ALTER TABLE `enderecoespecifico`
  MODIFY `idEnderecoEspecifico` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `estado`
--
ALTER TABLE `estado`
  MODIFY `idEstado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `fatura`
--
ALTER TABLE `fatura`
  MODIFY `idFatura` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT for table `hidrometro`
--
ALTER TABLE `hidrometro`
  MODIFY `idHidrometro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `rua`
--
ALTER TABLE `rua`
  MODIFY `idRua` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `telefone`
--
ALTER TABLE `telefone`
  MODIFY `idTelefone` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `cidade`
--
ALTER TABLE `cidade`
  ADD CONSTRAINT `fk_cidade_estado` FOREIGN KEY (`idEstado`) REFERENCES `estado` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `email`
--
ALTER TABLE `email`
  ADD CONSTRAINT `fk_email_cliente1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `endereco`
--
ALTER TABLE `endereco`
  ADD CONSTRAINT `fk_endereco_bairro1` FOREIGN KEY (`idBairro`) REFERENCES `bairro` (`idBairro`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_endereco_cidade1` FOREIGN KEY (`idCidade`) REFERENCES `cidade` (`idCidade`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_endereco_rua1` FOREIGN KEY (`idRua`) REFERENCES `rua` (`idRua`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `enderecoespecifico`
--
ALTER TABLE `enderecoespecifico`
  ADD CONSTRAINT `fk_enderecoEspecifico_endereco1` FOREIGN KEY (`idEndereco`) REFERENCES `endereco` (`idEndereco`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `fatura`
--
ALTER TABLE `fatura`
  ADD CONSTRAINT `fk_fatura_hidrometro1` FOREIGN KEY (`idHidrometro`) REFERENCES `hidrometro` (`idHidrometro`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `hidrometro`
--
ALTER TABLE `hidrometro`
  ADD CONSTRAINT `fk_enderecoEspecifico_has_cliente_cliente1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_enderecoEspecifico_has_cliente_enderecoEspecifico1` FOREIGN KEY (`idEnderecoEspecifico`) REFERENCES `enderecoespecifico` (`idEnderecoEspecifico`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `telefone`
--
ALTER TABLE `telefone`
  ADD CONSTRAINT `fk_telefone_cliente1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
