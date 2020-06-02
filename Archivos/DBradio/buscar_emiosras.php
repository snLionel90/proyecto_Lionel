<?php
include 'conexion.php';
$ID_emisora = $_GET['ID_emisora'];

$consulta = "select * from emisoras where ID_emisora= '$ID_emisora'";
$resultado =  $conexion -> query($consulta);

while($fila=$resultado -> fetch_array()){
	$emisoras[] = $fila;
	echo json_encode($emisoras);
}

$resultado -> close();

?>

