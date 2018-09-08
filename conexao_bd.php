<?php

$servername = "localhost";
$username = "root";
$password = "Mandela21#";
$dbname = "arvore_genealogica";

$res_array = array();

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

$sql = "SELECT id, nome, mae, pai FROM arvore";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
    $res_array = array();

    $i = 0;
    while($row = $result->fetch_assoc()) {
        $res_array[$i]=Array($row["id"],utf8_encode($row["nome"]),utf8_encode($row["mae"]),utf8_encode($row["pai"]));
        //echo utf8_encode("id: " . $row["id"]. " - Name: " . $row["nome"]. " " . $row["mae"]. "<br>");
        $i=i+1;
    }
} else {
    echo "0 results";
}
$conn->close();
?>