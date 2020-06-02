<?php

include 'conexion.php';
$nombre=$_POST['nombre'];
$apellido=$_POST['apellido'];
$edad=$_POST['edad'];
$comentario=$_POST['comentario'];

$consulta="insert into usuarios values('".$nombre."','".$apellido."','".$edad."','".$comentario."')";
mysqli_query($conexion,$consulta) or die (mysqli_error());
mysqli_close($conexion);

?>