<?php

$hostname='localhost';
$database='usuarios_radio';
$username='root';
$password='';

$conexion=new mysqli($hostname,$username,$password,$database)or die ("No es posible conectarse al servidor de Base de datos");

$db = mysqli_select_db( $conexion, $database ) or die ( "Upps! Parece ser que no es posible conectarse a la base de datos" );

if ($conexion->connect_errno) {
 echo "lo sentimos, tenemos problemas con la conexión";
}

?>