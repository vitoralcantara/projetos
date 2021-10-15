<?php

$servername = "localhost";
$username = "root";
$password = "Mandela21#";
$dbname = "ARVORE_GENEALOGICA";

$res_array = array();

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 
?>