-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-06-2020 a las 16:25:58
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.3.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `usuarios_radio`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `datos_emisora`
--

CREATE TABLE `datos_emisora` (
  `ID_datos` int(3) NOT NULL,
  `frecuencia` float NOT NULL,
  `potencia(W)` int(6) NOT NULL,
  `audiencia` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `datos_emisora`
--

INSERT INTO `datos_emisora` (`ID_datos`, `frecuencia`, `potencia(W)`, `audiencia`) VALUES
(1, 101.7, 520, 1250000),
(6, 92, 500, 100000),
(25, 99.5, 3550, 250000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `emisoras`
--

CREATE TABLE `emisoras` (
  `ID_emisora` int(11) NOT NULL,
  `nombre_emisora` varchar(30) NOT NULL,
  `ciudad` varchar(25) NOT NULL,
  `stream` varchar(255) NOT NULL,
  `datos_id` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `emisoras`
--

INSERT INTO `emisoras` (`ID_emisora`, `nombre_emisora`, `ciudad`, `stream`, `datos_id`) VALUES
(1, 'Radio Nacional RNE', 'Madrid', 'https://rne.rtveradio.cires21.com/rne_hc.mp3', 1),
(2, 'RockFm', 'Madrid', 'http://rockfm.cope.stream.flumotion.com/cope/rockfm.mp3.m3u', 5),
(3, 'Cadena100', 'Madrid', 'http://cadena100.cope.stream.flumotion.com/cope/cadena100.mp3.m3u', 25),
(4, 'EuropaFM', 'Madrid', 'http://icecast-streaming.nice264.com/europafm', 10),
(5, 'Onda Melodia', 'Madrid', 'http://icecast-streaming.nice264.com/melodiafm', 14),
(6, 'Radio 4G', 'Madrid', 'http://195.10.10.223/radio4g/radiosigloxxi.mp3', 3),
(8, 'EITB Musika', 'Bilbao', 'http://mp3-eitb.stream.flumotion.com/eitb/eitbmusika.mp3', 6),
(9, 'MaximaFm', 'Toledo', 'http://emisoras.cadenaser.com:8085/Los40Dance.m3u', 11);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `relacion usuario-emisora`
--

CREATE TABLE `relacion usuario-emisora` (
  `nom_usuario` varchar(25) NOT NULL,
  `id_emisora` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `relacion usuario-emisora`
--

INSERT INTO `relacion usuario-emisora` (`nom_usuario`, `id_emisora`) VALUES
('hmghmgh', 4),
('hmghmgh', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `nombre` varchar(25) NOT NULL,
  `apellido` varchar(25) NOT NULL,
  `edad` int(3) NOT NULL,
  `comentario` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`nombre`, `apellido`, `edad`, `comentario`) VALUES
('', '', 0, ''),
('gh', 'h', 4, 'dgf'),
('hmghmgh', 'mghmghm', 222, 'lllllhi'),
('pepito', 'grillo', 6, 'queso'),
('ttgh', 'h', 4, 'dgf');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `datos_emisora`
--
ALTER TABLE `datos_emisora`
  ADD PRIMARY KEY (`ID_datos`);

--
-- Indices de la tabla `emisoras`
--
ALTER TABLE `emisoras`
  ADD PRIMARY KEY (`ID_emisora`),
  ADD KEY `datos_id` (`datos_id`);

--
-- Indices de la tabla `relacion usuario-emisora`
--
ALTER TABLE `relacion usuario-emisora`
  ADD KEY `nom_usuario` (`nom_usuario`,`id_emisora`),
  ADD KEY `id_emisora` (`id_emisora`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`nombre`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `emisoras`
--
ALTER TABLE `emisoras`
  MODIFY `ID_emisora` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `datos_emisora`
--
ALTER TABLE `datos_emisora`
  ADD CONSTRAINT `datos_emisora_ibfk_1` FOREIGN KEY (`ID_datos`) REFERENCES `emisoras` (`datos_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `relacion usuario-emisora`
--
ALTER TABLE `relacion usuario-emisora`
  ADD CONSTRAINT `relacion usuario-emisora_ibfk_1` FOREIGN KEY (`id_emisora`) REFERENCES `emisoras` (`ID_emisora`),
  ADD CONSTRAINT `relacion usuario-emisora_ibfk_2` FOREIGN KEY (`nom_usuario`) REFERENCES `usuarios` (`nombre`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
